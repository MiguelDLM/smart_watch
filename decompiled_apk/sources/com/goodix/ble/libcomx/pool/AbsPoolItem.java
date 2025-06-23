package com.goodix.ble.libcomx.pool;

/* loaded from: classes9.dex */
public class AbsPoolItem implements IRecyclable {
    Pool host;
    int refCnt = 0;

    @Override // com.goodix.ble.libcomx.pool.IRecyclable
    public int getRefCnt() {
        return this.refCnt;
    }

    @Override // com.goodix.ble.libcomx.pool.IRecyclable
    public synchronized void release() {
        int i = this.refCnt - 1;
        this.refCnt = i;
        if (i < 1) {
            this.host.recycle(this);
        }
    }

    @Override // com.goodix.ble.libcomx.pool.IRecyclable
    public synchronized void retain() {
        this.refCnt++;
    }

    @Override // com.goodix.ble.libcomx.pool.IRecyclable
    public void reuse(Pool pool) {
        this.host = pool;
        this.refCnt = 0;
    }
}
