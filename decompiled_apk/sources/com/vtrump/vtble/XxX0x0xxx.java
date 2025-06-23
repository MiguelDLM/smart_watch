package com.vtrump.vtble;

/* loaded from: classes13.dex */
public class XxX0x0xxx {

    /* renamed from: I0Io, reason: collision with root package name */
    public short f27460I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public byte[] f27461II0xO0 = new byte[16];

    /* renamed from: X0o0xo, reason: collision with root package name */
    public byte f27462X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public short f27463oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public short f27464oxoX;

    public XxX0x0xxx(XIxXXX0x0 xIxXXX0x0) {
        byte[] II0xO02 = xIxXXX0x0.II0xO0();
        this.f27463oIX0oI = (short) (II0xO02[1] >> (II0xO02[2] + 8));
        System.arraycopy(II0xO02, 3, this.f27461II0xO0, 0, 16);
        this.f27460I0Io = (short) (II0xO02[20] >> (II0xO02[21] + 8));
        this.f27464oxoX = (short) (II0xO02[22] >> (II0xO02[23] + 8));
        this.f27462X0o0xo = II0xO02[24];
    }

    public static XxX0x0xxx oIX0oI(XIxXXX0x0 xIxXXX0x0) {
        if (xIxXXX0x0.II0xO0().length != 25) {
            return null;
        }
        return new XxX0x0xxx(xIxXXX0x0);
    }

    public String toString() {
        return "[Service uuid]" + xxX.Oxx0xo(this.f27461II0xO0) + "[Major id]" + ((int) this.f27460I0Io) + "[Minor id]" + ((int) this.f27464oxoX) + "[power]" + ((int) this.f27462X0o0xo);
    }
}
