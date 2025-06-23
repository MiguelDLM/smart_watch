package com.jieli.jl_rcsp.model.data;

import com.jieli.jl_rcsp.interfaces.data.OnDataEventCallback;

/* loaded from: classes10.dex */
public class SendDataCache extends SendParams {
    private final OnDataEventCallback callback;
    private int offset;
    private int seq;

    public SendDataCache(SendParams sendParams, OnDataEventCallback onDataEventCallback) {
        super(sendParams.getDataType(), sendParams.getVersion(), sendParams.getSendLimit(), sendParams.getReceiveLimit(), sendParams.getData());
        this.seq = -1;
        this.callback = onDataEventCallback;
        this.offset = 0;
    }

    public OnDataEventCallback getCallback() {
        return this.callback;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getSeq() {
        return this.seq;
    }

    public void release() {
        this.seq = -1;
        this.offset = 0;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public void setSeq(int i) {
        this.seq = i;
    }

    @Override // com.jieli.jl_rcsp.model.data.SendParams, com.jieli.jl_rcsp.model.data.DataParams
    public String toString() {
        return "SendDataCache{callback=" + this.callback + ", seq=" + this.seq + ", offset=" + this.offset + '}';
    }
}
