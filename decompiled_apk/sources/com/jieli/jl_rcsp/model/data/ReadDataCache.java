package com.jieli.jl_rcsp.model.data;

import com.jieli.jl_rcsp.interfaces.data.OnDataEventCallback;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes10.dex */
public class ReadDataCache extends ReadParams {
    private OnDataEventCallback mCallback;
    private final ByteArrayOutputStream mOutputStream;
    private int offset;
    private int seq;

    public ReadDataCache(ReadParams readParams) {
        super(readParams.getDataType(), readParams.getVersion(), readParams.getSendLimit(), readParams.getReceiveLimit(), readParams.getDataLen(), readParams.getCrc());
        this.mOutputStream = new ByteArrayOutputStream();
        this.seq = -1;
    }

    public OnDataEventCallback getCallback() {
        return this.mCallback;
    }

    public int getOffset() {
        return this.offset;
    }

    public byte[] getOutputData() {
        return this.mOutputStream.toByteArray();
    }

    public int getSeq() {
        return this.seq;
    }

    public boolean putData(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                this.mOutputStream.write(bArr);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public void release() {
        this.mOutputStream.reset();
        this.offset = 0;
        this.seq = -1;
    }

    public void setCallback(OnDataEventCallback onDataEventCallback) {
        this.mCallback = onDataEventCallback;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public void setSeq(int i) {
        this.seq = i;
    }

    @Override // com.jieli.jl_rcsp.model.data.ReadParams, com.jieli.jl_rcsp.model.data.DataParams
    public String toString() {
        return "ReadDataCache{mOutputStream=" + this.mOutputStream + ", mCallback=" + this.mCallback + ", offset=" + this.offset + ", seq=" + this.seq + '}';
    }
}
