package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;

/* loaded from: classes9.dex */
public abstract class oIX0oI extends oO {

    /* renamed from: I0Io, reason: collision with root package name */
    public XIXIX.xxIXOIIO f34557I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public XX0xXo.oIX0oI f34558II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public Paint f34559Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public Paint f34560X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public Paint f34561XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public Paint f34562oxoX;

    public oIX0oI(XIXIX.oOoXoXO oooxoxo, XIXIX.xxIXOIIO xxixoiio, XX0xXo.oIX0oI oix0oi) {
        super(oooxoxo);
        this.f34557I0Io = xxixoiio;
        this.f34558II0xO0 = oix0oi;
        if (this.f34563oIX0oI != null) {
            this.f34560X0o0xo = new Paint(1);
            Paint paint = new Paint();
            this.f34562oxoX = paint;
            paint.setColor(-7829368);
            this.f34562oxoX.setStrokeWidth(1.0f);
            Paint paint2 = this.f34562oxoX;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            this.f34562oxoX.setAlpha(90);
            Paint paint3 = new Paint();
            this.f34561XO = paint3;
            paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.f34561XO.setStrokeWidth(1.0f);
            this.f34561XO.setStyle(style);
            Paint paint4 = new Paint(1);
            this.f34559Oxx0IOOO = paint4;
            paint4.setStyle(style);
        }
    }

    public Paint I0Io() {
        return this.f34560X0o0xo;
    }

    public abstract void II0XooXoX(Canvas canvas);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    public void II0xO0(float f, float f2) {
        double ceil;
        double oo0xXOI0I2;
        float f3 = f;
        int XIxXXX0x02 = this.f34558II0xO0.XIxXXX0x0();
        double abs = Math.abs(f2 - f3);
        if (XIxXXX0x02 != 0 && abs > XIXIX.OOXIXo.f3760XO && !Double.isInfinite(abs)) {
            double IoOoX2 = XIXIX.OOXIXo.IoOoX(abs / XIxXXX0x02);
            if (this.f34558II0xO0.XOxIOxOx() && IoOoX2 < this.f34558II0xO0.OxI()) {
                IoOoX2 = this.f34558II0xO0.OxI();
            }
            double IoOoX3 = XIXIX.OOXIXo.IoOoX(Math.pow(10.0d, (int) Math.log10(IoOoX2)));
            if (((int) (IoOoX2 / IoOoX3)) > 5) {
                IoOoX2 = Math.floor(IoOoX3 * 10.0d);
            }
            int IoOoX4 = this.f34558II0xO0.IoOoX();
            if (this.f34558II0xO0.x0o()) {
                IoOoX2 = ((float) abs) / (XIxXXX0x02 - 1);
                XX0xXo.oIX0oI oix0oi = this.f34558II0xO0;
                oix0oi.f4026x0XOIxOo = XIxXXX0x02;
                if (oix0oi.f4023oOoXoXO.length < XIxXXX0x02) {
                    oix0oi.f4023oOoXoXO = new float[XIxXXX0x02];
                }
                for (int i = 0; i < XIxXXX0x02; i++) {
                    this.f34558II0xO0.f4023oOoXoXO[i] = f3;
                    f3 = (float) (f3 + IoOoX2);
                }
            } else {
                if (IoOoX2 == XIXIX.OOXIXo.f3760XO) {
                    ceil = XIXIX.OOXIXo.f3760XO;
                } else {
                    ceil = Math.ceil(f3 / IoOoX2) * IoOoX2;
                }
                if (this.f34558II0xO0.IoOoX()) {
                    ceil -= IoOoX2;
                }
                if (IoOoX2 == XIXIX.OOXIXo.f3760XO) {
                    oo0xXOI0I2 = XIXIX.OOXIXo.f3760XO;
                } else {
                    oo0xXOI0I2 = XIXIX.OOXIXo.oo0xXOI0I(Math.floor(f2 / IoOoX2) * IoOoX2);
                }
                if (IoOoX2 != XIXIX.OOXIXo.f3760XO) {
                    double d = ceil;
                    IoOoX4 = IoOoX4;
                    while (d <= oo0xXOI0I2) {
                        d += IoOoX2;
                        IoOoX4++;
                    }
                }
                XX0xXo.oIX0oI oix0oi2 = this.f34558II0xO0;
                oix0oi2.f4026x0XOIxOo = IoOoX4;
                if (oix0oi2.f4023oOoXoXO.length < IoOoX4) {
                    oix0oi2.f4023oOoXoXO = new float[IoOoX4];
                }
                for (int i2 = 0; i2 < IoOoX4; i2++) {
                    if (ceil == XIXIX.OOXIXo.f3760XO) {
                        ceil = 0.0d;
                    }
                    this.f34558II0xO0.f4023oOoXoXO[i2] = (float) ceil;
                    ceil += IoOoX2;
                }
                XIxXXX0x02 = IoOoX4;
            }
            if (IoOoX2 < 1.0d) {
                this.f34558II0xO0.f4022oO = (int) Math.ceil(-Math.log10(IoOoX2));
            } else {
                this.f34558II0xO0.f4022oO = 0;
            }
            if (this.f34558II0xO0.IoOoX()) {
                XX0xXo.oIX0oI oix0oi3 = this.f34558II0xO0;
                if (oix0oi3.f4024ooOOo0oXI.length < XIxXXX0x02) {
                    oix0oi3.f4024ooOOo0oXI = new float[XIxXXX0x02];
                }
                float f4 = ((float) IoOoX2) / 2.0f;
                for (int i3 = 0; i3 < XIxXXX0x02; i3++) {
                    XX0xXo.oIX0oI oix0oi4 = this.f34558II0xO0;
                    oix0oi4.f4024ooOOo0oXI[i3] = oix0oi4.f4023oOoXoXO[i3] + f4;
                }
                return;
            }
            return;
        }
        XX0xXo.oIX0oI oix0oi5 = this.f34558II0xO0;
        oix0oi5.f4023oOoXoXO = new float[0];
        oix0oi5.f4024ooOOo0oXI = new float[0];
        oix0oi5.f4026x0XOIxOo = 0;
    }

    public abstract void Oxx0IOOO(Canvas canvas);

    public Paint X0o0xo() {
        return this.f34562oxoX;
    }

    public XIXIX.xxIXOIIO XO() {
        return this.f34557I0Io;
    }

    public void oIX0oI(float f, float f2, boolean z) {
        float f3;
        double d;
        XIXIX.oOoXoXO oooxoxo = this.f34563oIX0oI;
        if (oooxoxo != null && oooxoxo.OOXIXo() > 10.0f && !this.f34563oIX0oI.xXxxox0I()) {
            XIXIX.XO xoIox2 = this.f34557I0Io.xoIox(this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.xoIox());
            XIXIX.XO xoIox3 = this.f34557I0Io.xoIox(this.f34563oIX0oI.II0XooXoX(), this.f34563oIX0oI.XO());
            if (!z) {
                f3 = (float) xoIox3.f3775Oxx0xo;
                d = xoIox2.f3775Oxx0xo;
            } else {
                f3 = (float) xoIox2.f3775Oxx0xo;
                d = xoIox3.f3775Oxx0xo;
            }
            float f4 = (float) d;
            XIXIX.XO.I0Io(xoIox2);
            XIXIX.XO.I0Io(xoIox3);
            f = f3;
            f2 = f4;
        }
        II0xO0(f, f2);
    }

    public Paint oxoX() {
        return this.f34561XO;
    }

    public abstract void xoIox(Canvas canvas);

    public abstract void xxIXOIIO(Canvas canvas);
}
