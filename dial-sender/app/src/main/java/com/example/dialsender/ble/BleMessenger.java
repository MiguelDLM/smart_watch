package com.example.dialsender.ble;

import java.io.ByteArrayOutputStream;

public class BleMessenger {

    /**
     * Build an outbound BLE Message frame in byte format according to the protocol
     * rules.
     */
    public static byte[] buildFrame(BleKey key, BleKeyFlag flag, byte[] payload, boolean isReply) {
        int command = key.getCommand();
        int keyVal = key.getKey();
        int flagVal = flag.getValue();

        int header = 0x01; // Version = 1
        if (isReply) {
            header |= 0x10;
        }

        if (payload == null) {
            payload = new byte[0];
        }

        int length = payload.length + 3; // +3 for cmd, key, keyFlag

        // CRC is computed over command, key, flag, and payload
        ByteArrayOutputStream crcData = new ByteArrayOutputStream();
        crcData.write(command);
        crcData.write(keyVal);
        crcData.write(flagVal);
        try {
            crcData.write(payload);
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] crcInput = crcData.toByteArray();
        int crc = Crc16.compute(crcInput, 0, crcInput.length);

        ByteArrayOutputStream frame = new ByteArrayOutputStream();
        frame.write(0xAB); // MAGIC
        frame.write(header);

        // LENGTH is big endian uint16
        frame.write((length >>> 8) & 0xFF);
        frame.write(length & 0xFF);

        // CRC is big endian uint16
        frame.write((crc >>> 8) & 0xFF);
        frame.write(crc & 0xFF);

        frame.write(command);
        frame.write(keyVal);
        frame.write(flagVal);

        try {
            frame.write(payload);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return frame.toByteArray();
    }
}
