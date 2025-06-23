package com.github.mikephil.charting.components;

import XIXIX.I0Io;
import XIXIX.OOXIXo;
import XIXIX.oOoXoXO;
import XX0xXo.II0xO0;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class Legend extends II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public com.github.mikephil.charting.components.oIX0oI[] f15937II0XooXoX;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public float f15938IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public DashPathEffect f15939IXxxXO;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public float f15940O0xOxO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public LegendVerticalAlignment f15941OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public float f15942Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public float f15943OxI;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public com.github.mikephil.charting.components.oIX0oI[] f15944Oxx0IOOO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public float f15945Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public float f15946OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public float f15947X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public boolean f15948XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public List<I0Io> f15949XIxXXX0x0;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public List<I0Io> f15950XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public float f15951o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f15952oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public LegendForm f15953oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public LegendOrientation f15954oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f15955ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public LegendDirection f15956x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public float f15957x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public LegendHorizontalAlignment f15958xoIox;

    /* renamed from: xoXoI, reason: collision with root package name */
    public float f15959xoXoI;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public boolean f15960xxIXOIIO;

    /* renamed from: xxX, reason: collision with root package name */
    public List<Boolean> f15961xxX;

    /* loaded from: classes9.dex */
    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    /* loaded from: classes9.dex */
    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    /* loaded from: classes9.dex */
    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    /* loaded from: classes9.dex */
    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    /* loaded from: classes9.dex */
    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f15962oIX0oI;

        static {
            int[] iArr = new int[LegendOrientation.values().length];
            f15962oIX0oI = iArr;
            try {
                iArr[LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15962oIX0oI[LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Legend() {
        this.f15944Oxx0IOOO = new com.github.mikephil.charting.components.oIX0oI[0];
        this.f15960xxIXOIIO = false;
        this.f15958xoIox = LegendHorizontalAlignment.LEFT;
        this.f15941OOXIXo = LegendVerticalAlignment.BOTTOM;
        this.f15954oOoXoXO = LegendOrientation.HORIZONTAL;
        this.f15955ooOOo0oXI = false;
        this.f15956x0XOIxOo = LegendDirection.LEFT_TO_RIGHT;
        this.f15953oO = LegendForm.SQUARE;
        this.f15957x0xO0oo = 8.0f;
        this.f15942Oo = 3.0f;
        this.f15939IXxxXO = null;
        this.f15945Oxx0xo = 6.0f;
        this.f15952oI0IIXIo = 0.0f;
        this.f15946OxxIIOOXO = 5.0f;
        this.f15938IIXOooo = 3.0f;
        this.f15959xoXoI = 0.95f;
        this.f15951o00 = 0.0f;
        this.f15943OxI = 0.0f;
        this.f15940O0xOxO = 0.0f;
        this.f15947X0IIOO = 0.0f;
        this.f15948XI0IXoo = false;
        this.f15949XIxXXX0x0 = new ArrayList(16);
        this.f15961xxX = new ArrayList(16);
        this.f15950XxX0x0xxx = new ArrayList(16);
        this.f3994X0o0xo = OOXIXo.X0o0xo(10.0f);
        this.f3993II0xO0 = OOXIXo.X0o0xo(5.0f);
        this.f3992I0Io = OOXIXo.X0o0xo(3.0f);
    }

    public void I0X0x0oIo(float f) {
        this.f15945Oxx0xo = f;
    }

    public void I0oOoX(float f) {
        this.f15946OxxIIOOXO = f;
    }

    public float IIX0o() {
        return this.f15952oI0IIXIo;
    }

    public float IIXOooo() {
        return this.f15942Oo;
    }

    public void IO(List<com.github.mikephil.charting.components.oIX0oI> list) {
        this.f15944Oxx0IOOO = (com.github.mikephil.charting.components.oIX0oI[]) list.toArray(new com.github.mikephil.charting.components.oIX0oI[list.size()]);
    }

    public com.github.mikephil.charting.components.oIX0oI[] IXxxXO() {
        return this.f15944Oxx0IOOO;
    }

    public void Io(DashPathEffect dashPathEffect) {
        this.f15939IXxxXO = dashPathEffect;
    }

    public void IoOoX(List<com.github.mikephil.charting.components.oIX0oI> list) {
        this.f15944Oxx0IOOO = (com.github.mikephil.charting.components.oIX0oI[]) list.toArray(new com.github.mikephil.charting.components.oIX0oI[list.size()]);
        this.f15960xxIXOIIO = true;
    }

    public float O0xOxO() {
        return this.f15959xoXoI;
    }

    public void OI0(LegendForm legendForm) {
        this.f15953oO = legendForm;
    }

    public LegendDirection Oo() {
        return this.f15956x0XOIxOo;
    }

    public LegendHorizontalAlignment OxI() {
        return this.f15958xoIox;
    }

    public com.github.mikephil.charting.components.oIX0oI[] Oxx0xo() {
        return this.f15937II0XooXoX;
    }

    public DashPathEffect OxxIIOOXO() {
        return this.f15939IXxxXO;
    }

    public void X00IoxXI(boolean z) {
        this.f15955ooOOo0oXI = z;
    }

    public float X0IIOO(Paint paint) {
        float f = 0.0f;
        for (com.github.mikephil.charting.components.oIX0oI oix0oi : this.f15944Oxx0IOOO) {
            String str = oix0oi.f15998oIX0oI;
            if (str != null) {
                float oIX0oI2 = OOXIXo.oIX0oI(paint, str);
                if (oIX0oI2 > f) {
                    f = oIX0oI2;
                }
            }
        }
        return f;
    }

    public float XI0IXoo(Paint paint) {
        float f;
        float X0o0xo2 = OOXIXo.X0o0xo(this.f15946OxxIIOOXO);
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (com.github.mikephil.charting.components.oIX0oI oix0oi : this.f15944Oxx0IOOO) {
            if (Float.isNaN(oix0oi.f15994I0Io)) {
                f = this.f15957x0xO0oo;
            } else {
                f = oix0oi.f15994I0Io;
            }
            float X0o0xo3 = OOXIXo.X0o0xo(f);
            if (X0o0xo3 > f3) {
                f3 = X0o0xo3;
            }
            String str = oix0oi.f15998oIX0oI;
            if (str != null) {
                float oxoX2 = OOXIXo.oxoX(paint, str);
                if (oxoX2 > f2) {
                    f2 = oxoX2;
                }
            }
        }
        return f2 + f3 + X0o0xo2;
    }

    public LegendOrientation XIxXXX0x0() {
        return this.f15954oOoXoXO;
    }

    public void XOxIOxOx(com.github.mikephil.charting.components.oIX0oI[] oix0oiArr) {
        if (oix0oiArr == null) {
            oix0oiArr = new com.github.mikephil.charting.components.oIX0oI[0];
        }
        this.f15937II0XooXoX = oix0oiArr;
    }

    public void XX(float f) {
        this.f15957x0xO0oo = f;
    }

    public void XX0(boolean z) {
        this.f15948XI0IXoo = z;
    }

    public void XoX(float f) {
        this.f15959xoXoI = f;
    }

    public void Xx000oIo(LegendDirection legendDirection) {
        this.f15956x0XOIxOo = legendDirection;
    }

    public LegendVerticalAlignment XxX0x0xxx() {
        return this.f15941OOXIXo;
    }

    public void o0(float f) {
        this.f15942Oo = f;
    }

    public float o00() {
        return this.f15946OxxIIOOXO;
    }

    public LegendForm oI0IIXIo() {
        return this.f15953oO;
    }

    public List<I0Io> oO() {
        return this.f15949XIxXXX0x0;
    }

    public void oOXoIIIo(com.github.mikephil.charting.components.oIX0oI[] oix0oiArr) {
        this.f15944Oxx0IOOO = oix0oiArr;
        this.f15960xxIXOIIO = true;
    }

    public void oX(float f) {
        this.f15952oI0IIXIo = f;
    }

    public void oo() {
        this.f15960xxIXOIIO = false;
    }

    public boolean oo0xXOI0I() {
        return this.f15948XI0IXoo;
    }

    public void ooOOo0oXI(Paint paint, oOoXoXO oooxoxo) {
        boolean z;
        float X0o0xo2;
        boolean z2;
        float X0o0xo3;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i;
        float f7;
        float X0o0xo4 = OOXIXo.X0o0xo(this.f15957x0xO0oo);
        float X0o0xo5 = OOXIXo.X0o0xo(this.f15938IIXOooo);
        float X0o0xo6 = OOXIXo.X0o0xo(this.f15946OxxIIOOXO);
        float X0o0xo7 = OOXIXo.X0o0xo(this.f15945Oxx0xo);
        float X0o0xo8 = OOXIXo.X0o0xo(this.f15952oI0IIXIo);
        boolean z3 = this.f15948XI0IXoo;
        com.github.mikephil.charting.components.oIX0oI[] oix0oiArr = this.f15944Oxx0IOOO;
        int length = oix0oiArr.length;
        this.f15947X0IIOO = XI0IXoo(paint);
        this.f15940O0xOxO = X0IIOO(paint);
        int i2 = oIX0oI.f15962oIX0oI[this.f15954oOoXoXO.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                float oI0IIXIo2 = OOXIXo.oI0IIXIo(paint);
                float IIXOooo2 = OOXIXo.IIXOooo(paint) + X0o0xo8;
                float OOXIXo2 = oooxoxo.OOXIXo() * this.f15959xoXoI;
                this.f15961xxX.clear();
                this.f15949XIxXXX0x0.clear();
                this.f15950XxX0x0xxx.clear();
                int i3 = 0;
                float f8 = 0.0f;
                int i4 = -1;
                float f9 = 0.0f;
                float f10 = 0.0f;
                while (i3 < length) {
                    com.github.mikephil.charting.components.oIX0oI oix0oi = oix0oiArr[i3];
                    float f11 = X0o0xo4;
                    float f12 = X0o0xo7;
                    if (oix0oi.f15995II0xO0 != LegendForm.NONE) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (Float.isNaN(oix0oi.f15994I0Io)) {
                        X0o0xo3 = f11;
                    } else {
                        X0o0xo3 = OOXIXo.X0o0xo(oix0oi.f15994I0Io);
                    }
                    String str = oix0oi.f15998oIX0oI;
                    com.github.mikephil.charting.components.oIX0oI[] oix0oiArr2 = oix0oiArr;
                    float f13 = IIXOooo2;
                    this.f15961xxX.add(Boolean.FALSE);
                    if (i4 == -1) {
                        f = 0.0f;
                    } else {
                        f = f9 + X0o0xo5;
                    }
                    if (str != null) {
                        f2 = X0o0xo5;
                        this.f15949XIxXXX0x0.add(OOXIXo.II0xO0(paint, str));
                        if (z2) {
                            f7 = X0o0xo6 + X0o0xo3;
                        } else {
                            f7 = 0.0f;
                        }
                        f4 = f + f7 + this.f15949XIxXXX0x0.get(i3).f3743IXxxXO;
                    } else {
                        f2 = X0o0xo5;
                        float f14 = X0o0xo3;
                        this.f15949XIxXXX0x0.add(I0Io.II0xO0(0.0f, 0.0f));
                        if (z2) {
                            f3 = f14;
                        } else {
                            f3 = 0.0f;
                        }
                        f4 = f + f3;
                        if (i4 == -1) {
                            i4 = i3;
                        }
                    }
                    if (str != null || i3 == length - 1) {
                        float f15 = f10;
                        if (f15 == 0.0f) {
                            f5 = 0.0f;
                        } else {
                            f5 = f12;
                        }
                        if (z3 && f15 != 0.0f && OOXIXo2 - f15 < f5 + f4) {
                            this.f15950XxX0x0xxx.add(I0Io.II0xO0(f15, oI0IIXIo2));
                            f8 = Math.max(f8, f15);
                            List<Boolean> list = this.f15961xxX;
                            if (i4 > -1) {
                                i = i4;
                            } else {
                                i = i3;
                            }
                            list.set(i, Boolean.TRUE);
                            f6 = f4;
                        } else {
                            f6 = f15 + f5 + f4;
                        }
                        if (i3 == length - 1) {
                            this.f15950XxX0x0xxx.add(I0Io.II0xO0(f6, oI0IIXIo2));
                            f8 = Math.max(f8, f6);
                        }
                        f10 = f6;
                    }
                    if (str != null) {
                        i4 = -1;
                    }
                    i3++;
                    X0o0xo5 = f2;
                    X0o0xo4 = f11;
                    X0o0xo7 = f12;
                    IIXOooo2 = f13;
                    f9 = f4;
                    oix0oiArr = oix0oiArr2;
                }
                float f16 = IIXOooo2;
                this.f15951o00 = f8;
                this.f15943OxI = (oI0IIXIo2 * this.f15950XxX0x0xxx.size()) + (f16 * (this.f15950XxX0x0xxx.size() == 0 ? 0 : this.f15950XxX0x0xxx.size() - 1));
            }
        } else {
            float oI0IIXIo3 = OOXIXo.oI0IIXIo(paint);
            float f17 = 0.0f;
            float f18 = 0.0f;
            float f19 = 0.0f;
            boolean z4 = false;
            for (int i5 = 0; i5 < length; i5++) {
                com.github.mikephil.charting.components.oIX0oI oix0oi2 = oix0oiArr[i5];
                if (oix0oi2.f15995II0xO0 != LegendForm.NONE) {
                    z = true;
                } else {
                    z = false;
                }
                if (Float.isNaN(oix0oi2.f15994I0Io)) {
                    X0o0xo2 = X0o0xo4;
                } else {
                    X0o0xo2 = OOXIXo.X0o0xo(oix0oi2.f15994I0Io);
                }
                String str2 = oix0oi2.f15998oIX0oI;
                if (!z4) {
                    f19 = 0.0f;
                }
                if (z) {
                    if (z4) {
                        f19 += X0o0xo5;
                    }
                    f19 += X0o0xo2;
                }
                if (str2 != null) {
                    if (z && !z4) {
                        f19 += X0o0xo6;
                    } else if (z4) {
                        f17 = Math.max(f17, f19);
                        f18 += oI0IIXIo3 + X0o0xo8;
                        f19 = 0.0f;
                        z4 = false;
                    }
                    f19 += OOXIXo.oxoX(paint, str2);
                    if (i5 < length - 1) {
                        f18 += oI0IIXIo3 + X0o0xo8;
                    }
                } else {
                    f19 += X0o0xo2;
                    if (i5 < length - 1) {
                        f19 += X0o0xo5;
                    }
                    z4 = true;
                }
                f17 = Math.max(f17, f19);
            }
            this.f15951o00 = f17;
            this.f15943OxI = f18;
        }
        this.f15943OxI += this.f3992I0Io;
        this.f15951o00 += this.f3993II0xO0;
    }

    public boolean ooXIXxIX() {
        return this.f15955ooOOo0oXI;
    }

    public void oxXx0IX(LegendOrientation legendOrientation) {
        this.f15954oOoXoXO = legendOrientation;
    }

    public void oxxXoxO(LegendHorizontalAlignment legendHorizontalAlignment) {
        this.f15958xoIox = legendHorizontalAlignment;
    }

    public List<Boolean> x0XOIxOo() {
        return this.f15961xxX;
    }

    public void x0o(int[] iArr, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < Math.min(iArr.length, strArr.length); i++) {
            com.github.mikephil.charting.components.oIX0oI oix0oi = new com.github.mikephil.charting.components.oIX0oI();
            int i2 = iArr[i];
            oix0oi.f15997XO = i2;
            oix0oi.f15998oIX0oI = strArr[i];
            if (i2 != 1122868 && i2 != 0) {
                if (i2 == 1122867) {
                    oix0oi.f15995II0xO0 = LegendForm.EMPTY;
                }
            } else {
                oix0oi.f15995II0xO0 = LegendForm.NONE;
            }
            arrayList.add(oix0oi);
        }
        this.f15937II0XooXoX = (com.github.mikephil.charting.components.oIX0oI[]) arrayList.toArray(new com.github.mikephil.charting.components.oIX0oI[arrayList.size()]);
    }

    public List<I0Io> x0xO0oo() {
        return this.f15950XxX0x0xxx;
    }

    public boolean xI() {
        return this.f15960xxIXOIIO;
    }

    public void xII(List<com.github.mikephil.charting.components.oIX0oI> list) {
        this.f15937II0XooXoX = (com.github.mikephil.charting.components.oIX0oI[]) list.toArray(new com.github.mikephil.charting.components.oIX0oI[list.size()]);
    }

    public void xXOx(LegendVerticalAlignment legendVerticalAlignment) {
        this.f15941OOXIXo = legendVerticalAlignment;
    }

    public float xXxxox0I() {
        return this.f15945Oxx0xo;
    }

    public void xo0x(float f) {
        this.f15938IIXOooo = f;
    }

    public float xoXoI() {
        return this.f15957x0xO0oo;
    }

    public float xxX() {
        return this.f15938IIXOooo;
    }

    public Legend(com.github.mikephil.charting.components.oIX0oI[] oix0oiArr) {
        this();
        if (oix0oiArr != null) {
            this.f15944Oxx0IOOO = oix0oiArr;
            return;
        }
        throw new IllegalArgumentException("entries array is NULL");
    }
}
