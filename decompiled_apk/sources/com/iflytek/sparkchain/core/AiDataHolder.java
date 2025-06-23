package com.iflytek.sparkchain.core;

import android.util.Log;
import com.iflytek.sparkchain.core.a;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;

/* loaded from: classes10.dex */
public abstract class AiDataHolder<T, O extends a> {
    protected ByteBuffer buffer;
    protected int handle;
    private final String key;
    protected O object;
    protected b from = b.MEM;
    private AiStatus status = AiStatus.BEGIN;
    private boolean updated = false;
    protected boolean isData = false;

    public AiDataHolder(O o, String str) {
        this.key = str;
        this.object = o;
        o.ref(this);
        this.handle = AiBuilder.getAtomicHandle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private T response() {
        return this;
    }

    private void sync(int i) {
        if (this.isData) {
            sync(this.handle, "status", Integer.valueOf(this.status.getValue()));
        }
        paramSync(this.handle);
        if (this.buffer != null) {
            int value = type().getValue();
            Log.i("DataHolder", "type=" + value);
            AiHelper.getInst().newDirectBuffer((long) i, this.key, this.buffer, this.from.getValue(), value, this.status.getValue(), this.buffer.capacity());
        }
    }

    public T begin() {
        this.status = (AiStatus) update(this.status, AiStatus.BEGIN);
        return response();
    }

    public T cont() {
        this.status = (AiStatus) update(this.status, AiStatus.CONTINUE);
        return response();
    }

    public T data(String str) {
        return data(str.getBytes());
    }

    public T end() {
        this.status = (AiStatus) update(this.status, AiStatus.END);
        return response();
    }

    public T file(String str) {
        this.from = b.FILE;
        return data(str);
    }

    public void finalize() throws Throwable {
        try {
            super.finalize();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        AiHelper.getInst().delBuilder(this.handle);
    }

    public T once() {
        this.status = (AiStatus) update(this.status, AiStatus.ONCE);
        return response();
    }

    public abstract void paramSync(int i);

    public T status(AiStatus aiStatus) {
        this.status = (AiStatus) update(this.status, aiStatus);
        return response();
    }

    public void syncCtrl(int i) {
        sync(i);
        AiHelper.getInst().newBuilder(i, this.key, this.handle);
    }

    public void syncDesc(int i) {
        sync(i);
        AiHelper.getInst().newDesc(i, this.key, this.handle);
    }

    public abstract c type();

    public <P> P update(P p, P p2) {
        if (p != p2) {
            this.updated = true;
        }
        return p2;
    }

    public O valid() {
        if (this.isData && this.buffer == null) {
            throw new InvalidParameterException();
        }
        return this.object;
    }

    public T data(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = this.buffer;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.buffer = byteBuffer;
        this.isData = true;
        return response();
    }

    public T file(ByteBuffer byteBuffer) {
        this.from = b.FILE;
        return data(byteBuffer);
    }

    public void sync(int i, String str, Boolean bool) {
        AiHelper.getInst().newBoolean(i, str, bool.booleanValue());
    }

    public T data(byte[] bArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        return data(allocateDirect);
    }

    public T file(byte[] bArr) {
        this.from = b.FILE;
        return data(bArr);
    }

    public void sync(int i, String str, Double d) {
        AiHelper.getInst().newDouble(i, str, d.doubleValue());
    }

    public void sync(int i, String str, Integer num) {
        AiHelper.getInst().newInteger(i, str, num.intValue());
    }

    public void sync(int i, String str, byte[] bArr) {
        AiHelper.getInst().newBuffer(i, str, bArr, b.MEM.getValue(), c.OTHER.getValue(), AiStatus.ONCE.getValue());
    }
}
