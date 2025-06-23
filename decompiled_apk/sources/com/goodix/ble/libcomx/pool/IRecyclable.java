package com.goodix.ble.libcomx.pool;

/* loaded from: classes9.dex */
public interface IRecyclable {
    int getRefCnt();

    void release();

    void retain();

    void reuse(Pool pool);
}
