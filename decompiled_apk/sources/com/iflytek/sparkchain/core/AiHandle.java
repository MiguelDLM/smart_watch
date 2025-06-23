package com.iflytek.sparkchain.core;

/* loaded from: classes10.dex */
public class AiHandle {
    private int code;
    private int i;
    private int id;

    public AiHandle(int i, int i2, int i3) {
        this.code = i;
        this.id = i2;
        this.i = i3;
    }

    public int getCode() {
        return this.code;
    }

    public int getI() {
        return this.i;
    }

    public int getId() {
        return this.id;
    }

    public boolean isFail() {
        return !isSuccess();
    }

    public boolean isSuccess() {
        return this.code == 0;
    }
}
