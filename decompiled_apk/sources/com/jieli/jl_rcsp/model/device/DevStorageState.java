package com.jieli.jl_rcsp.model.device;

import com.jieli.jl_rcsp.util.CHexConver;

/* loaded from: classes10.dex */
public class DevStorageState {
    private int handle;
    private int index;
    private boolean isOnline;

    public int getHandle() {
        return this.handle;
    }

    public int getIndex() {
        return this.index;
    }

    public boolean isOnline() {
        return this.isOnline;
    }

    public int parseData(byte[] bArr) {
        boolean z = false;
        if (bArr == null || bArr.length < 2) {
            return 0;
        }
        if (CHexConver.byteToInt(bArr[0]) == 1) {
            z = true;
        }
        setOnline(z);
        this.index = CHexConver.byteToInt(bArr[1]);
        if (!this.isOnline || bArr.length < 6) {
            return 2;
        }
        setHandle(CHexConver.bytesToInt(bArr, 2, 4));
        return 6;
    }

    public DevStorageState setHandle(int i) {
        this.handle = i;
        return this;
    }

    public DevStorageState setIndex(int i) {
        this.index = i;
        return this;
    }

    public DevStorageState setOnline(boolean z) {
        this.isOnline = z;
        return this;
    }

    public String toString() {
        return "DevStorageState{isOnline=" + this.isOnline + ", index=" + this.index + ", handle=" + this.handle + '}';
    }
}
