package xxIO;

import IIxOXoOo0.oIX0oI;
import com.github.mikephil.charting.data.BarEntry;

/* loaded from: classes9.dex */
public class X0o0xo extends oxoX {
    public X0o0xo(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xxIO.oxoX, xxIO.I0Io
    /* renamed from: II0XooXoX */
    public void oIX0oI(oIX0oI oix0oi) {
        float f;
        float f2;
        float abs;
        float abs2;
        float f3;
        float f4;
        float X0xxXX02 = oix0oi.X0xxXX0() * this.f35292I0Io;
        float f5 = this.f35299OOXIXo / 2.0f;
        for (int i = 0; i < X0xxXX02; i++) {
            BarEntry barEntry = (BarEntry) oix0oi.OOXIXo(i);
            if (barEntry != null) {
                float xxIXOIIO2 = barEntry.xxIXOIIO();
                float I0Io2 = barEntry.I0Io();
                float[] oI0IIXIo2 = barEntry.oI0IIXIo();
                if (this.f35302xxIXOIIO && oI0IIXIo2 != null) {
                    float f6 = -barEntry.x0xO0oo();
                    int i2 = 0;
                    float f7 = 0.0f;
                    while (i2 < oI0IIXIo2.length) {
                        float f8 = oI0IIXIo2[i2];
                        if (f8 >= 0.0f) {
                            abs = f8 + f7;
                            abs2 = f6;
                            f6 = f7;
                            f7 = abs;
                        } else {
                            abs = Math.abs(f8) + f6;
                            abs2 = Math.abs(f8) + f6;
                        }
                        float f9 = xxIXOIIO2 - f5;
                        float f10 = xxIXOIIO2 + f5;
                        if (this.f35301xoIox) {
                            if (f6 >= abs) {
                                f4 = f6;
                            } else {
                                f4 = abs;
                            }
                            if (f6 > abs) {
                                f6 = abs;
                            }
                        } else {
                            if (f6 >= abs) {
                                f3 = f6;
                            } else {
                                f3 = abs;
                            }
                            if (f6 > abs) {
                                f6 = abs;
                            }
                            float f11 = f6;
                            f6 = f3;
                            f4 = f11;
                        }
                        float f12 = this.f35297oxoX;
                        Oxx0IOOO(f4 * f12, f10, f6 * f12, f9);
                        i2++;
                        f6 = abs2;
                    }
                } else {
                    float f13 = xxIXOIIO2 - f5;
                    float f14 = xxIXOIIO2 + f5;
                    if (this.f35301xoIox) {
                        if (I0Io2 >= 0.0f) {
                            f2 = I0Io2;
                        } else {
                            f2 = 0.0f;
                        }
                        if (I0Io2 > 0.0f) {
                            I0Io2 = 0.0f;
                        }
                    } else {
                        if (I0Io2 >= 0.0f) {
                            f = I0Io2;
                        } else {
                            f = 0.0f;
                        }
                        if (I0Io2 > 0.0f) {
                            I0Io2 = 0.0f;
                        }
                        float f15 = I0Io2;
                        I0Io2 = f;
                        f2 = f15;
                    }
                    if (I0Io2 > 0.0f) {
                        I0Io2 *= this.f35297oxoX;
                    } else {
                        f2 *= this.f35297oxoX;
                    }
                    Oxx0IOOO(f2, f14, I0Io2, f13);
                }
            }
        }
        oxoX();
    }
}
