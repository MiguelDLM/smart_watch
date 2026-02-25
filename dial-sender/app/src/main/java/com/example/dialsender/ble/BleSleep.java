package com.example.dialsender.ble;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BleSleep {
    public long timestamp;
    public int mode;
    public int softMotion;
    public int strongMotion;

    public static final int MODE_DEEP = 1;
    public static final int MODE_LIGHT = 2;
    public static final int MODE_AWAKE = 3;
    public static final int MODE_PIECEMEAL = 8;
    public static final int MODE_REM = 9;
    public static final int MODE_START = 17;
    public static final int MODE_END = 34;

    public void decode(byte[] data) {
        if (data.length < 7)
            return;
        ByteBuffer buffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);

        long bleTime = buffer.getInt() & 0xFFFFFFFFL;
        this.timestamp = bleTime + 946684800L;

        this.mode = buffer.get() & 0xFF;
        this.softMotion = buffer.get() & 0xFF;
        this.strongMotion = buffer.get() & 0xFF;
    }
}
