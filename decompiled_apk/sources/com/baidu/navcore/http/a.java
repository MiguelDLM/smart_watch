package com.baidu.navcore.http;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private int f6453a;
    private byte[] b;

    public a(int i) {
        if (i >= 0) {
            this.b = new byte[i];
            return;
        }
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    private void a(int i) {
        byte[] bArr = new byte[Math.max(this.b.length << 1, i)];
        System.arraycopy(this.b, 0, bArr, 0, this.f6453a);
        this.b = bArr;
    }

    public void a(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr == null) {
            return;
        }
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.f6453a + i2;
        if (i4 > this.b.length) {
            a(i4);
        }
        System.arraycopy(bArr, i, this.b, this.f6453a, i2);
        this.f6453a = i4;
    }

    public byte[] a() {
        int i = this.f6453a;
        byte[] bArr = new byte[i];
        if (i > 0) {
            System.arraycopy(this.b, 0, bArr, 0, i);
        }
        return bArr;
    }
}
