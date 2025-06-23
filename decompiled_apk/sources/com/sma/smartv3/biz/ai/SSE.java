package com.sma.smartv3.biz.ai;

/* loaded from: classes12.dex */
public class SSE {
    private static final String DONE_DATA = "[DONE]";
    private final String data;

    public SSE(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public boolean isDone() {
        return DONE_DATA.equalsIgnoreCase(this.data);
    }

    public byte[] toBytes() {
        return String.format("data: %s\n\n", this.data).getBytes();
    }
}
