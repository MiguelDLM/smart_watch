package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.szabh.smable3.BleKey;
import kotlin.collections.ooOOo0oXI;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes13.dex */
public final class BleStream {

    @OOXIXo
    private final BleKey mBleKey;

    @OOXIXo
    private final byte[] mData;
    private final int mType;

    public BleStream(@OOXIXo BleKey mBleKey, int i, @OOXIXo byte[] mData) {
        IIX0o.x0xO0oo(mBleKey, "mBleKey");
        IIX0o.x0xO0oo(mData, "mData");
        this.mBleKey = mBleKey;
        this.mType = i;
        this.mData = mData;
    }

    @OOXIXo
    public final BleKey getMBleKey() {
        return this.mBleKey;
    }

    @oOoXoXO
    public final BleStreamPacket getPacket(int i, long j) {
        if (i >= this.mData.length) {
            return null;
        }
        long j2 = i;
        long j3 = j + j2;
        if (j3 > r0.length) {
            int i2 = this.mType;
            byte[] bArr = this.mData;
            return new BleStreamPacket(i2, bArr.length, j2, ooOOo0oXI.xxOXOOoIX(bArr, i, bArr.length));
        }
        return new BleStreamPacket(this.mType, r0.length, j2, ooOOo0oXI.xxOXOOoIX(this.mData, i, (int) j3));
    }
}
