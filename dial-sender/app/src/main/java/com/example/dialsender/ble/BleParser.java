package com.example.dialsender.ble;

import java.io.ByteArrayOutputStream;

public class BleParser {

    public interface BleParserListener {
        void onFrameParsed(BleKey key, BleKeyFlag flag, boolean isReply, byte[] payload);

        void onPacketError(String error);
    }

    private final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private BleParserListener listener;

    public void setListener(BleParserListener listener) {
        this.listener = listener;
    }

    public synchronized void onNotification(byte[] data) {
        buffer.write(data, 0, data.length);
        processBuffer();
    }

    private void processBuffer() {
        while (true) {
            byte[] bytes = buffer.toByteArray();
            if (bytes.length < 9) {
                // Wait for more data
                return;
            }

            // Check Magic Byte: 0xAB (signed -85)
            if (bytes[0] != (byte) 0xAB) {
                if (listener != null)
                    listener.onPacketError("Invalid Magic byte. Flushing buffer.");
                buffer.reset(); // Corrupt stream, flush everything
                return;
            }

            // Length occupies bytes[2] and bytes[3] (Big Endian uint16)
            int length = ((bytes[2] & 0xFF) << 8) | (bytes[3] & 0xFF);
            int frameSize = length + 6; // +6 for magic(1)+header(1)+length(2)+crc(2)

            if (bytes.length < frameSize) {
                // Wait for more data to fulfill the frame
                return;
            }

            // We have a full frame. Extract it.
            byte[] frame = new byte[frameSize];
            System.arraycopy(bytes, 0, frame, 0, frameSize);

            // Rebuild the buffer with leftovers
            buffer.reset();
            buffer.write(bytes, frameSize, bytes.length - frameSize);

            // Validate the CRC
            int expectedCrc = ((frame[4] & 0xFF) << 8) | (frame[5] & 0xFF);
            // CRC computed over everything from offset 6 onward
            int actualCrc = Crc16.compute(frame, 6, frameSize - 6);

            if (expectedCrc != actualCrc) {
                if (listener != null)
                    listener.onPacketError("CRC Mismatch: Expected " + expectedCrc + " got " + actualCrc
                            + ". Ignoring mismatch to match legacy behavior.");
                // WARNING: The original MainActivity DID NOT check incoming CRCs.
                // Some smartwatch firmwares send invalid CRCs on ACKs. We MUST process it
                // anyway!
                // continue; // <-- Removed this to prevent dropping valid ACKs
            }

            // Parse valid frame
            int header = frame[1] & 0xFF;
            boolean isReply = (header & 0x10) != 0;
            boolean isNack = (header & 0x20) != 0;

            if (isNack && listener != null) {
                listener.onPacketError("Received NACK frame");
            }

            int command = frame[6] & 0xFF;
            int keyIndex = frame[7] & 0xFF;
            BleKey bleKey = BleKey.fromRaw(command, keyIndex);

            int flagVal = frame[8] & 0xFF;
            BleKeyFlag bleKeyFlag = BleKeyFlag.fromValue(flagVal);

            int payloadSize = frameSize - 9;
            byte[] payload = new byte[payloadSize];
            if (payloadSize > 0) {
                System.arraycopy(frame, 9, payload, 0, payloadSize);
            }

            if (listener != null && bleKey != BleKey.NONE) {
                listener.onFrameParsed(bleKey, bleKeyFlag, isReply, payload);
            }
        }
    }
}
