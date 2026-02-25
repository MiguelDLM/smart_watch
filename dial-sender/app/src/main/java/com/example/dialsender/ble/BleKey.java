package com.example.dialsender.ble;

public enum BleKey {
    // 0x01 UPDATE
    OTA(0x0101),

    // 0x02 SET
    TIME(0x0201),
    TIME_ZONE(0x0202),
    POWER(0x0203),
    FIRMWARE_VERSION(0x0204),
    BLE_ADDRESS(0x0205),
    USER_PROFILE(0x0206),
    STEP_GOAL(0x0207),
    BACK_LIGHT(0x0208),
    SEDENTARINESS(0x0209),
    IDENTITY(0x0215), // CREATE flag sent on first connect

    // 0x03 CONNECT
    CMD_IDENTITY(0x0301),
    SESSION(0x0302), // Sent with CREATE & mId to persist connection session

    // 0x04 PUSH
    NOTIFICATION(0x0401),
    MUSIC_CONTROL(0x0402),
    WEATHER_REALTIME(0x0404),

    // 0x05 DATA
    ACTIVITY_REALTIME(0x0501),
    ACTIVITY(0x0502), // 16 bytes: Steps, Cals, Dist
    HEART_RATE(0x0503), // 6 bytes
    SLEEP(0x0505), // 7 bytes
    DATA_ALL(0x05FF), // Request bulk data

    // 0x06 CONTROL
    CAMERA(0x0601),

    // 0x07 IO
    WATCH_FACE(0x0701), // Transfer logic uses STREAM packets of 480 byte max here

    NONE(0xFFFF);

    private final int mKey; // Example 0x0503

    BleKey(int mKey) {
        this.mKey = mKey;
    }

    public int getMKey() {
        return mKey;
    }

    public int getCommand() {
        return mKey >>> 8; // e.g. 5
    }

    public int getKey() {
        return mKey & 0xFF; // e.g. 3
    }

    public static BleKey fromRaw(int command, int key) {
        int target = (command << 8) | key;
        for (BleKey b : values()) {
            if (b.mKey == target)
                return b;
        }
        return NONE;
    }
}
