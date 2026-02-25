package com.example.dialsender.ble;

public enum BleCommand {
    UPDATE(0x01),
    SET(0x02),
    CONNECT(0x03),
    PUSH(0x04),
    DATA(0x05),
    CONTROL(0x06),
    IO(0x07),
    NONE(0xFF);

    private final int value;

    BleCommand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BleCommand fromValue(int value) {
        for (BleCommand cmd : values()) {
            if (cmd.value == value)
                return cmd;
        }
        return NONE;
    }
}
