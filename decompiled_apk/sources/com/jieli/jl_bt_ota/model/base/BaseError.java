package com.jieli.jl_bt_ota.model.base;

/* loaded from: classes10.dex */
public class BaseError {
    private final int code;
    private final String message;
    private int opCode;
    private final int subCode;

    public BaseError(int i, String str) {
        this(i, i, str);
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public int getOpCode() {
        return this.opCode;
    }

    public int getSubCode() {
        return this.subCode;
    }

    public BaseError setOpCode(int i) {
        this.opCode = i;
        return this;
    }

    public String toString() {
        return "BaseError{code=" + this.code + ", subCode=" + this.subCode + ", opCode=" + this.opCode + ", message='" + this.message + "'}";
    }

    public BaseError(int i, int i2, String str) {
        this.code = i;
        this.subCode = i2;
        this.message = str;
    }
}
