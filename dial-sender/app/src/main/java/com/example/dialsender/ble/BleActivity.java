package com.example.dialsender.ble;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class BleActivity {
    public long timestamp;
    public int mode;
    public int state;
    public int step;
    public int calorie;
    public int distance;

    public void decode(byte[] data) {
        if (data.length < 16)
            return;
        ByteBuffer buffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);

        long bleTime = buffer.getInt() & 0xFFFFFFFFL;
        this.timestamp = bleTime + 946684800L;

        byte modeState = buffer.get();
        this.mode = (modeState & 0xFF) >>> 3;
        this.state = modeState & 0x07;

        // Step is 24-bit (3 bytes) little-endian. We pad it to 4 bytes.
        byte[] stepBytes = new byte[4];
        buffer.get(stepBytes, 0, 3);
        stepBytes[3] = 0; // Pad top byte
        this.step = ByteBuffer.wrap(stepBytes).order(ByteOrder.LITTLE_ENDIAN).getInt();

        this.calorie = buffer.getInt();
        this.distance = buffer.getInt();
    }
}
