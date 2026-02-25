package com.example.dialsender.ble;

public enum BleKeyFlag {
    UPDATE(0x00),
    READ(0x10),
    READ_CONTINUE(0x11),
    CREATE(0x20),
    DELETE(0x30),
    RESET(0x40),
    NONE(0xFF);

    private final int value;

    BleKeyFlag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BleKeyFlag fromValue(int value) {
        for (BleKeyFlag flag : values()) {
            if (flag.value == value)
                return flag;
        }
        return NONE;
    }
}
