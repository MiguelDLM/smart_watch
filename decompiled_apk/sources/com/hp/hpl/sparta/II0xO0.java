package com.hp.hpl.sparta;

/* loaded from: classes10.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int[] f17136oIX0oI;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f17135II0xO0 = 0;

    /* renamed from: I0Io, reason: collision with root package name */
    public int f17134I0Io = 0;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f17137oxoX = true;

    public II0xO0(int i) {
        this.f17136oIX0oI = new int[i];
    }

    public final void I0Io(int i) {
        if (this.f17137oxoX) {
            int[] iArr = this.f17136oIX0oI;
            int i2 = this.f17135II0xO0;
            iArr[i2] = i;
            this.f17135II0xO0 = (i2 + 1) % iArr.length;
            this.f17134I0Io++;
        }
    }

    public void II0xO0(int i) {
        I0Io(i + 65536);
    }

    public void X0o0xo() {
        this.f17137oxoX = false;
    }

    public void XO() {
        this.f17137oxoX = true;
    }

    public void oIX0oI(char c) {
        I0Io(c);
    }

    public void oxoX(String str) {
        for (char c : str.toCharArray()) {
            oIX0oI(c);
        }
    }

    public String toString() {
        int i;
        StringBuffer stringBuffer = new StringBuffer((this.f17136oIX0oI.length * 11) / 10);
        int i2 = this.f17134I0Io;
        int[] iArr = this.f17136oIX0oI;
        if (i2 < iArr.length) {
            i = iArr.length - i2;
        } else {
            i = 0;
        }
        while (true) {
            int[] iArr2 = this.f17136oIX0oI;
            if (i < iArr2.length) {
                int i3 = iArr2[(this.f17135II0xO0 + i) % iArr2.length];
                if (i3 < 65536) {
                    stringBuffer.append((char) i3);
                } else {
                    stringBuffer.append(Integer.toString(i3 - 65536));
                }
                i++;
            } else {
                return stringBuffer.toString();
            }
        }
    }
}
