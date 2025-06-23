package com.goodix.ble.gr.libdfu.dfu.cmd.sdu;

import com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx;
import com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx;
import com.goodix.ble.libcomx.util.HexBuilder;
import com.goodix.ble.libcomx.util.HexReader;

/* loaded from: classes9.dex */
public class XNvds implements IFrameSdu4Tx, IFrameSdu4Rx {
    public static final int OP_CONFIG = 3;
    public static final int OP_DELETE = 2;
    public static final int OP_READ = 1;
    public static final int OP_WRITE = 0;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 2;
    private static final int k = 4;
    private static final int l = 2;
    private static final int m = 1024;

    /* renamed from: a, reason: collision with root package name */
    private int f16080a;
    private int b;
    private int c;
    private int d;
    private byte[] e;
    private int f;
    private int g;

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Rx
    public void deserialize(HexReader hexReader) {
        this.f16080a = hexReader.get(1);
        int i2 = hexReader.get(1);
        this.b = i2;
        if (i2 != 3) {
            this.c = hexReader.get(2);
            if (this.b == 1) {
                int i3 = hexReader.get(2);
                byte[] bArr = new byte[i3];
                this.e = bArr;
                hexReader.get(bArr, 0, i3);
            }
        }
    }

    public byte[] getData() {
        return this.e;
    }

    public int getOpration() {
        return this.b;
    }

    public int getResponse() {
        return this.f16080a;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public int getSduSize() {
        int i2 = this.b;
        if (i2 != 0) {
            if (i2 == 1) {
                return 5;
            }
            if (i2 == 2) {
                return 3;
            }
            if (i2 != 3) {
                return 0;
            }
            return 7;
        }
        byte[] bArr = this.e;
        if (bArr == null) {
            return 5;
        }
        return bArr.length + 5;
    }

    public int getTagId() {
        return this.c;
    }

    public void requestConfig(int i2, int i3) {
        this.b = 3;
        this.f = i2;
        this.g = i3;
    }

    public void requestDelete(int i2) {
        this.b = 2;
        this.c = i2;
    }

    public void requestRead(int i2, int i3) {
        this.b = 1;
        this.c = i2;
        this.d = i3;
    }

    public void requestWrite(int i2, byte[] bArr) {
        this.b = 0;
        this.c = i2;
        this.e = bArr;
    }

    @Override // com.goodix.ble.libcomx.transceiver.IFrameSdu4Tx
    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.b, 1);
        if (this.b == 3) {
            hexBuilder.put(this.f, 4);
            hexBuilder.put(this.g, 2);
            return;
        }
        hexBuilder.put(this.c, 2);
        int i2 = this.b;
        if (i2 == 1) {
            hexBuilder.put(this.d, 2);
            return;
        }
        if (i2 == 0) {
            byte[] bArr = this.e;
            if (bArr != null) {
                hexBuilder.put(bArr.length, 2);
                hexBuilder.put(this.e);
            } else {
                hexBuilder.put(0, 2);
            }
        }
    }

    public void requestRead(int i2) {
        requestRead(i2, 1024);
    }
}
