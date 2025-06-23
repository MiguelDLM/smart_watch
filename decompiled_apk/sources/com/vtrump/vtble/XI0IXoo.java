package com.vtrump.vtble;

import android.util.Log;

/* loaded from: classes13.dex */
public class XI0IXoo {

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final String f27426X0o0xo = "vtble." + XI0IXoo.class.getSimpleName();

    /* renamed from: I0Io, reason: collision with root package name */
    public byte[] f27427I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public byte f27428II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public short f27429oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public XIxXXX0x0 f27430oxoX;

    public XI0IXoo(XIxXXX0x0 xIxXXX0x0) {
        StringBuilder sb;
        String str;
        byte b;
        byte b2;
        byte b3;
        byte b4;
        this.f27430oxoX = xIxXXX0x0;
        byte[] II0xO02 = xIxXXX0x0.II0xO0();
        if (II0xO02 == null || II0xO02.length < 5) {
            return;
        }
        byte b5 = II0xO02[0];
        if (b5 == -40 || b5 == -35) {
            if (II0xO02.length == 9 || II0xO02.length == 8) {
                this.f27428II0xO0 = (byte) -40;
                this.f27427I0Io = r1;
                byte[] bArr = {3, 3, 6, 15};
                return;
            }
            sb = new StringBuilder();
            str = "VTManufactureData like d8||dd, data: ";
        } else if (((b5 & 255) >> 4) == 13 || ((b5 & 255) >> 4) == 14) {
            if (II0xO02.length == 11) {
                this.f27428II0xO0 = (byte) -40;
                this.f27427I0Io = r1;
                byte[] bArr2 = {3, 3, 30, 15};
                Log.d(f27426X0o0xo, "VTManufactureData: found dr");
                return;
            }
            sb = new StringBuilder();
            str = "VTManufactureData like DX||EX, data: ";
        } else if (b5 == 2 && ((b4 = II0xO02[1]) == -40 || b4 == -35 || b4 == -34 || b4 == -33 || b4 == 15)) {
            if (II0xO02.length == 14) {
                this.f27428II0xO0 = (byte) 64;
                byte[] bArr3 = new byte[II0xO02.length];
                this.f27427I0Io = bArr3;
                System.arraycopy(II0xO02, 0, bArr3, 0, II0xO02.length);
                return;
            }
            sb = new StringBuilder();
            str = "VTManufactureData like d8||dd||de||df, data: ";
        } else if (b5 == -1 && II0xO02[1] == -2) {
            if (II0xO02.length == 18 || II0xO02.length == 19) {
                this.f27428II0xO0 = (byte) 48;
                byte[] bArr4 = new byte[II0xO02.length];
                this.f27427I0Io = bArr4;
                bArr4[0] = 3;
                bArr4[1] = 3;
                System.arraycopy(II0xO02, 2, bArr4, 2, II0xO02.length - 2);
                return;
            }
            sb = new StringBuilder();
            str = "VTManufactureData like ff&&fe, data: ";
        } else if (b5 == -54 && II0xO02[1] == 32 && II0xO02[2] == 11 && II0xO02[3] == 65) {
            if (II0xO02.length == 21) {
                this.f27428II0xO0 = (byte) 48;
                byte[] bArr5 = new byte[II0xO02.length - 4];
                this.f27427I0Io = bArr5;
                bArr5[0] = 3;
                bArr5[1] = 3;
                bArr5[2] = 13;
                bArr5[3] = 50;
                System.arraycopy(II0xO02, 8, bArr5, 4, II0xO02.length - 8);
                return;
            }
            sb = new StringBuilder();
            str = "VTManufactureData like ca&&20&&0b&&41, data: ";
        } else {
            if (b5 == -1 && II0xO02[1] == -16) {
                if (II0xO02.length != 16 && II0xO02.length != 26 && II0xO02.length != 20) {
                    sb = new StringBuilder();
                    sb.append("VTManufactureData like ff&&f0, data: ");
                    sb.append(xxX.IIXOooo(II0xO02));
                    sb.append(",length: ");
                    sb.append(II0xO02.length);
                    Log.e("vtble", sb.toString());
                }
                this.f27428II0xO0 = (byte) -2;
                byte[] bArr6 = new byte[4];
                this.f27427I0Io = bArr6;
                if (II0xO02[6] == 86 && II0xO02[7] == 84) {
                    bArr6[0] = 1;
                    bArr6[1] = 3;
                    bArr6[2] = II0xO02[8];
                    bArr6[3] = II0xO02[9];
                    return;
                }
                bArr6[0] = 1;
                bArr6[1] = 3;
                bArr6[2] = 15;
                bArr6[3] = 53;
                return;
            }
            if (b5 == -54 && II0xO02[1] == 16 && II0xO02[2] == 15 && II0xO02[3] == 1) {
                if (II0xO02.length == 19 || II0xO02.length == 25) {
                    this.f27428II0xO0 = (byte) -2;
                    this.f27427I0Io = r1;
                    byte[] bArr7 = {1, 3, 17, 53};
                    return;
                }
                sb = new StringBuilder();
                str = "VTManufactureData like ca&&10&&0f&&01, data: ";
            } else if (b5 != -1 || (b2 = II0xO02[1]) != -1) {
                if (b5 == -88 && II0xO02[1] == 1 && II0xO02[2] == -75 && II0xO02[4] == 34 && II0xO02[5] == 26) {
                    if ((II0xO02[6] == 0) & (II0xO02[7] == 0)) {
                        Oxx0xo.II0xO0("vtble", "VTManufactureData tm, data: " + xxX.IIXOooo(II0xO02) + ",length: " + II0xO02.length);
                        if (II0xO02.length == 14) {
                            this.f27428II0xO0 = (byte) -2;
                            this.f27427I0Io = r1;
                            byte[] bArr8 = {1, 3, 28, 66};
                            return;
                        }
                        sb = new StringBuilder();
                        str = "VTManufactureData like a8-01-b5, data: ";
                    }
                }
                if (b5 == -88 && II0xO02[1] == 1 && II0xO02[2] == -107) {
                    Oxx0xo.II0xO0("vtble", "VTManufactureData AAAAA adv tm, data: " + xxX.IIXOooo(II0xO02) + ",length: " + II0xO02.length);
                    if (II0xO02.length == 26) {
                        this.f27428II0xO0 = (byte) 48;
                        this.f27427I0Io = r1;
                        byte[] bArr9 = {3, 3, 36, 15};
                        return;
                    }
                    sb = new StringBuilder();
                    str = "VTManufactureData like a8-01-95, data: ";
                } else {
                    if (b5 != -64) {
                        if (II0xO02.length == 12 && b5 == -2 && (b = II0xO02[1]) == -16) {
                            byte b6 = II0xO02[2];
                            if ((b6 == 36 || b6 == 37 || b6 == 38 || b6 == 39 || b6 == 40 || b6 == 41) && b5 + b + b6 + II0xO02[3] + II0xO02[4] == (II0xO02[5] & 255)) {
                                this.f27428II0xO0 = (byte) -2;
                                byte[] bArr10 = new byte[4];
                                this.f27427I0Io = bArr10;
                                bArr10[0] = 1;
                                bArr10[1] = 3;
                                if (b6 == 36) {
                                    bArr10[2] = 40;
                                } else if (b6 == 37) {
                                    bArr10[2] = 41;
                                } else if (b6 == 38) {
                                    bArr10[2] = 42;
                                }
                                bArr10[3] = IIIxO.oIX0oI.f236II0XooXoX;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (II0xO02.length == 15) {
                        this.f27428II0xO0 = (byte) 48;
                        byte[] bArr11 = new byte[4];
                        this.f27427I0Io = bArr11;
                        bArr11[0] = 3;
                        bArr11[1] = 3;
                        if ((II0xO02[6] == 10) && (II0xO02[7] == 1)) {
                            bArr11[2] = 32;
                            bArr11[3] = 71;
                            return;
                        } else {
                            bArr11[2] = 22;
                            bArr11[3] = 53;
                            return;
                        }
                    }
                    sb = new StringBuilder();
                    str = "VTManufactureData like c0, data: ";
                }
            } else {
                if (II0xO02.length == 23 || II0xO02.length == 21 || II0xO02.length == 7 || II0xO02.length == 13) {
                    this.f27429oIX0oI = (short) ((b5 >> 8) | b2);
                    this.f27428II0xO0 = II0xO02[2];
                    byte[] bArr12 = new byte[II0xO02.length - 3];
                    this.f27427I0Io = bArr12;
                    System.arraycopy(II0xO02, 3, bArr12, 0, II0xO02.length - 3);
                    return;
                }
                if (II0xO02.length == 11 && (b3 = II0xO02[2]) == -1) {
                    this.f27429oIX0oI = (short) ((b5 >> 8) | b2);
                    this.f27428II0xO0 = b3;
                    byte[] bArr13 = new byte[II0xO02.length - 3];
                    this.f27427I0Io = bArr13;
                    System.arraycopy(II0xO02, 3, bArr13, 0, II0xO02.length - 3);
                    return;
                }
                sb = new StringBuilder();
                str = "VTManufactureData like ff&&ff, data: ";
            }
        }
        sb.append(str);
        sb.append(xxX.IIXOooo(II0xO02));
        Log.e("vtble", sb.toString());
    }

    public static XI0IXoo oIX0oI(XIxXXX0x0 xIxXXX0x0) {
        if (xIxXXX0x0.X0o0xo() != -1) {
            return null;
        }
        return new XI0IXoo(xIxXXX0x0);
    }

    public XxX0x0xxx I0Io() {
        return XxX0x0xxx.oIX0oI(this.f27430oxoX);
    }

    public byte[] II0xO0() {
        return this.f27427I0Io;
    }

    public byte X0o0xo() {
        return this.f27428II0xO0;
    }

    public X0IIOO oxoX() {
        return X0IIOO.oIX0oI(this);
    }

    public String toString() {
        byte b = this.f27428II0xO0;
        if (b == -2) {
            return oxoX() == null ? "" : oxoX().toString();
        }
        if (b == -1) {
            return "[paired key]" + xxX.Oxx0xo(this.f27427I0Io);
        }
        if (b == 0) {
            return "[unknown manufacture data]" + xxX.Oxx0xo(this.f27427I0Io);
        }
        if (b == 2) {
            if (I0Io() == null) {
                return "[iBeacon] null";
            }
            return "[iBeacon]" + I0Io().toString();
        }
        if (b != 32) {
            return "[unknown manufacture data]" + xxX.IIXOooo(this.f27430oxoX.II0xO0());
        }
        return "[short link]" + xxX.Oxx0xo(this.f27427I0Io);
    }
}
