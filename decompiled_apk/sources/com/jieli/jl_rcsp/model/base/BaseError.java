package com.jieli.jl_rcsp.model.base;

import com.jieli.jl_rcsp.constant.RcspErrorCode;

/* loaded from: classes10.dex */
public class BaseError {
    private int code;
    private String message;
    private int opCode;
    private int subCode;

    public BaseError() {
        this(0, 0, "");
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

    public BaseError setCode(int i) {
        this.code = i;
        return this;
    }

    public BaseError setMessage(String str) {
        this.message = str;
        return this;
    }

    public BaseError setOpCode(int i) {
        this.opCode = i;
        return this;
    }

    public BaseError setSubCode(int i) {
        this.subCode = i;
        return this;
    }

    public String toString() {
        return "BaseError{code=" + this.code + ", subCode=" + this.subCode + ", opCode=" + this.opCode + ", message='" + this.message + "'}";
    }

    public BaseError(int i) {
        this(i, RcspErrorCode.getErrorDesc(i));
    }

    public BaseError(int i, String str) {
        this(0, i, str);
    }

    public BaseError(int i, int i2, String str) {
        this.code = i;
        this.subCode = i2;
        this.message = str;
    }
}
