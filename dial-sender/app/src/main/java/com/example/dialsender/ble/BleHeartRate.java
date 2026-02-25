package com.example.dialsender.ble;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BleHeartRate {
    public long timestamp;
    public int bpm;
    public int type;

    public void decode(byte[] data) {
        if (data.length < 6)
            return;
        ByteBuffer buffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);

        long bleTime = buffer.getInt() & 0xFFFFFFFFL;
        // 946684800 is 2000-01-01T00:00:00Z Unix Epoch Base
        this.timestamp = bleTime + 946684800L;

        this.bpm = buffer.get() & 0xFF;
        this.type = buffer.get() & 0xFF;
    }
}
