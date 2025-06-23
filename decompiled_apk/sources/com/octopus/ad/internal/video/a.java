package com.octopus.ad.internal.video;

import android.graphics.Matrix;

/* loaded from: classes11.dex */
public class a {

    /* renamed from: II0xO0, reason: collision with root package name */
    public II0xO0 f18743II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public II0xO0 f18744oIX0oI;

    /* loaded from: classes11.dex */
    public static class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f18745II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f18746oIX0oI;

        public II0xO0(int i, int i2) {
            this.f18746oIX0oI = i;
            this.f18745II0xO0 = i2;
        }

        public int II0xO0() {
            return this.f18745II0xO0;
        }

        public int oIX0oI() {
            return this.f18746oIX0oI;
        }
    }

    /* renamed from: com.octopus.ad.internal.video.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public enum EnumC0891a {
        LEFT_TOP,
        LEFT_CENTER,
        LEFT_BOTTOM,
        CENTER_TOP,
        CENTER,
        CENTER_BOTTOM,
        RIGHT_TOP,
        RIGHT_CENTER,
        RIGHT_BOTTOM
    }

    /* loaded from: classes11.dex */
    public enum b {
        NONE,
        FIT_XY,
        FIT_START,
        FIT_CENTER,
        FIT_END,
        LEFT_TOP,
        LEFT_CENTER,
        LEFT_BOTTOM,
        CENTER_TOP,
        CENTER,
        CENTER_BOTTOM,
        RIGHT_TOP,
        RIGHT_CENTER,
        RIGHT_BOTTOM,
        LEFT_TOP_CROP,
        LEFT_CENTER_CROP,
        LEFT_BOTTOM_CROP,
        CENTER_TOP_CROP,
        CENTER_CROP,
        CENTER_BOTTOM_CROP,
        RIGHT_TOP_CROP,
        RIGHT_CENTER_CROP,
        RIGHT_BOTTOM_CROP,
        START_INSIDE,
        CENTER_INSIDE,
        END_INSIDE
    }

    /* loaded from: classes11.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        public static final /* synthetic */ int[] f18749II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f18750oIX0oI;

        static {
            int[] iArr = new int[EnumC0891a.values().length];
            f18749II0xO0 = iArr;
            try {
                iArr[EnumC0891a.LEFT_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18749II0xO0[EnumC0891a.LEFT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18749II0xO0[EnumC0891a.LEFT_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18749II0xO0[EnumC0891a.CENTER_TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18749II0xO0[EnumC0891a.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f18749II0xO0[EnumC0891a.CENTER_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f18749II0xO0[EnumC0891a.RIGHT_TOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f18749II0xO0[EnumC0891a.RIGHT_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f18749II0xO0[EnumC0891a.RIGHT_BOTTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[b.values().length];
            f18750oIX0oI = iArr2;
            try {
                iArr2[b.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f18750oIX0oI[b.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f18750oIX0oI[b.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f18750oIX0oI[b.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f18750oIX0oI[b.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f18750oIX0oI[b.LEFT_TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f18750oIX0oI[b.LEFT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f18750oIX0oI[b.LEFT_BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f18750oIX0oI[b.CENTER_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f18750oIX0oI[b.CENTER.ordinal()] = 10;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f18750oIX0oI[b.CENTER_BOTTOM.ordinal()] = 11;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f18750oIX0oI[b.RIGHT_TOP.ordinal()] = 12;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f18750oIX0oI[b.RIGHT_CENTER.ordinal()] = 13;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f18750oIX0oI[b.RIGHT_BOTTOM.ordinal()] = 14;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f18750oIX0oI[b.LEFT_TOP_CROP.ordinal()] = 15;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f18750oIX0oI[b.LEFT_CENTER_CROP.ordinal()] = 16;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f18750oIX0oI[b.LEFT_BOTTOM_CROP.ordinal()] = 17;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f18750oIX0oI[b.CENTER_TOP_CROP.ordinal()] = 18;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f18750oIX0oI[b.CENTER_CROP.ordinal()] = 19;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f18750oIX0oI[b.CENTER_BOTTOM_CROP.ordinal()] = 20;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f18750oIX0oI[b.RIGHT_TOP_CROP.ordinal()] = 21;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f18750oIX0oI[b.RIGHT_CENTER_CROP.ordinal()] = 22;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f18750oIX0oI[b.RIGHT_BOTTOM_CROP.ordinal()] = 23;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f18750oIX0oI[b.START_INSIDE.ordinal()] = 24;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f18750oIX0oI[b.CENTER_INSIDE.ordinal()] = 25;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f18750oIX0oI[b.END_INSIDE.ordinal()] = 26;
            } catch (NoSuchFieldError unused35) {
            }
        }
    }

    public a(II0xO0 iI0xO0, II0xO0 iI0xO02) {
        this.f18744oIX0oI = iI0xO0;
        this.f18743II0xO0 = iI0xO02;
    }

    public final Matrix I0Io(float f, float f2, EnumC0891a enumC0891a) {
        switch (oIX0oI.f18749II0xO0[enumC0891a.ordinal()]) {
            case 1:
                return II0xO0(f, f2, 0.0f, 0.0f);
            case 2:
                return II0xO0(f, f2, 0.0f, this.f18744oIX0oI.II0xO0() / 2.0f);
            case 3:
                return II0xO0(f, f2, 0.0f, this.f18744oIX0oI.II0xO0());
            case 4:
                return II0xO0(f, f2, this.f18744oIX0oI.oIX0oI() / 2.0f, 0.0f);
            case 5:
                return II0xO0(f, f2, this.f18744oIX0oI.oIX0oI() / 2.0f, this.f18744oIX0oI.II0xO0() / 2.0f);
            case 6:
                return II0xO0(f, f2, this.f18744oIX0oI.oIX0oI() / 2.0f, this.f18744oIX0oI.II0xO0());
            case 7:
                return II0xO0(f, f2, this.f18744oIX0oI.oIX0oI(), 0.0f);
            case 8:
                return II0xO0(f, f2, this.f18744oIX0oI.oIX0oI(), this.f18744oIX0oI.II0xO0() / 2.0f);
            case 9:
                return II0xO0(f, f2, this.f18744oIX0oI.oIX0oI(), this.f18744oIX0oI.II0xO0());
            default:
                throw new IllegalArgumentException("Illegal PivotPoint");
        }
    }

    public final Matrix II0XooXoX() {
        return oxoX(EnumC0891a.LEFT_TOP);
    }

    public final Matrix II0xO0(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2, f3, f4);
        return matrix;
    }

    public final Matrix OOXIXo() {
        return oxoX(EnumC0891a.RIGHT_BOTTOM);
    }

    public final Matrix Oxx0IOOO(EnumC0891a enumC0891a) {
        return I0Io(this.f18743II0xO0.oIX0oI() / this.f18744oIX0oI.oIX0oI(), this.f18743II0xO0.II0xO0() / this.f18744oIX0oI.II0xO0(), enumC0891a);
    }

    public Matrix X0o0xo(b bVar) {
        switch (oIX0oI.f18750oIX0oI[bVar.ordinal()]) {
            case 1:
                return oIX0oI();
            case 2:
                return XO();
            case 3:
                return xoIox();
            case 4:
                return II0XooXoX();
            case 5:
                return OOXIXo();
            case 6:
                return Oxx0IOOO(EnumC0891a.LEFT_TOP);
            case 7:
                return Oxx0IOOO(EnumC0891a.LEFT_CENTER);
            case 8:
                return Oxx0IOOO(EnumC0891a.LEFT_BOTTOM);
            case 9:
                return Oxx0IOOO(EnumC0891a.CENTER_TOP);
            case 10:
                return Oxx0IOOO(EnumC0891a.CENTER);
            case 11:
                return Oxx0IOOO(EnumC0891a.CENTER_BOTTOM);
            case 12:
                return Oxx0IOOO(EnumC0891a.RIGHT_TOP);
            case 13:
                return Oxx0IOOO(EnumC0891a.RIGHT_CENTER);
            case 14:
                return Oxx0IOOO(EnumC0891a.RIGHT_BOTTOM);
            case 15:
                return xxIXOIIO(EnumC0891a.LEFT_TOP);
            case 16:
                return xxIXOIIO(EnumC0891a.LEFT_CENTER);
            case 17:
                return xxIXOIIO(EnumC0891a.LEFT_BOTTOM);
            case 18:
                return xxIXOIIO(EnumC0891a.CENTER_TOP);
            case 19:
                return xxIXOIIO(EnumC0891a.CENTER);
            case 20:
                return xxIXOIIO(EnumC0891a.CENTER_BOTTOM);
            case 21:
                return xxIXOIIO(EnumC0891a.RIGHT_TOP);
            case 22:
                return xxIXOIIO(EnumC0891a.RIGHT_CENTER);
            case 23:
                return xxIXOIIO(EnumC0891a.RIGHT_BOTTOM);
            case 24:
                return oOoXoXO();
            case 25:
                return ooOOo0oXI();
            case 26:
                return x0XOIxOo();
            default:
                return null;
        }
    }

    public final Matrix XO() {
        return I0Io(1.0f, 1.0f, EnumC0891a.LEFT_TOP);
    }

    public final Matrix oIX0oI() {
        return I0Io(this.f18743II0xO0.oIX0oI() / this.f18744oIX0oI.oIX0oI(), this.f18743II0xO0.II0xO0() / this.f18744oIX0oI.II0xO0(), EnumC0891a.LEFT_TOP);
    }

    public final Matrix oOoXoXO() {
        if (this.f18743II0xO0.II0xO0() <= this.f18744oIX0oI.oIX0oI() && this.f18743II0xO0.II0xO0() <= this.f18744oIX0oI.II0xO0()) {
            return Oxx0IOOO(EnumC0891a.LEFT_TOP);
        }
        return II0XooXoX();
    }

    public final Matrix ooOOo0oXI() {
        if (this.f18743II0xO0.II0xO0() <= this.f18744oIX0oI.oIX0oI() && this.f18743II0xO0.II0xO0() <= this.f18744oIX0oI.II0xO0()) {
            return Oxx0IOOO(EnumC0891a.CENTER);
        }
        return xoIox();
    }

    public final Matrix oxoX(EnumC0891a enumC0891a) {
        float oIX0oI2 = this.f18744oIX0oI.oIX0oI() / this.f18743II0xO0.oIX0oI();
        float II0xO02 = this.f18744oIX0oI.II0xO0() / this.f18743II0xO0.II0xO0();
        float min = Math.min(oIX0oI2, II0xO02);
        return I0Io(min / oIX0oI2, min / II0xO02, enumC0891a);
    }

    public final Matrix x0XOIxOo() {
        if (this.f18743II0xO0.II0xO0() <= this.f18744oIX0oI.oIX0oI() && this.f18743II0xO0.II0xO0() <= this.f18744oIX0oI.II0xO0()) {
            return Oxx0IOOO(EnumC0891a.RIGHT_BOTTOM);
        }
        return OOXIXo();
    }

    public final Matrix xoIox() {
        return oxoX(EnumC0891a.CENTER);
    }

    public final Matrix xxIXOIIO(EnumC0891a enumC0891a) {
        float oIX0oI2 = this.f18744oIX0oI.oIX0oI() / this.f18743II0xO0.oIX0oI();
        float II0xO02 = this.f18744oIX0oI.II0xO0() / this.f18743II0xO0.II0xO0();
        float max = Math.max(oIX0oI2, II0xO02);
        return I0Io(max / oIX0oI2, max / II0xO02, enumC0891a);
    }
}
