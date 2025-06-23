package ooOOo0oXI;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;

/* loaded from: classes.dex */
public class xxIXOIIO extends oIX0oI {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f32436O0xOxO = 32;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<IXxxXO.I0Io, IXxxXO.I0Io> f32437IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f32438IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f32439Oo;

    /* renamed from: OxI, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.x0xO0oo f32440OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final RectF f32441Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public final int f32442OxxIIOOXO;

    /* renamed from: o00, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<PointF, PointF> f32443o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final GradientType f32444oI0IIXIo;

    /* renamed from: oO, reason: collision with root package name */
    public final String f32445oO;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public final boolean f32446x0xO0oo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<PointF, PointF> f32447xoXoI;

    public xxIXOIIO(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, com.airbnb.lottie.model.content.oIX0oI oix0oi2) {
        super(xoiox, oix0oi, oix0oi2.II0xO0().toPaintCap(), oix0oi2.Oxx0IOOO().toPaintJoin(), oix0oi2.xxIXOIIO(), oix0oi2.OOXIXo(), oix0oi2.ooOOo0oXI(), oix0oi2.II0XooXoX(), oix0oi2.I0Io());
        this.f32439Oo = new LongSparseArray<>();
        this.f32438IXxxXO = new LongSparseArray<>();
        this.f32441Oxx0xo = new RectF();
        this.f32445oO = oix0oi2.xoIox();
        this.f32444oI0IIXIo = oix0oi2.XO();
        this.f32446x0xO0oo = oix0oi2.x0XOIxOo();
        this.f32442OxxIIOOXO = (int) (xoiox.oI0IIXIo().oxoX() / 32.0f);
        x0XOIxOo.oIX0oI<IXxxXO.I0Io, IXxxXO.I0Io> oIX0oI2 = oix0oi2.X0o0xo().oIX0oI();
        this.f32437IIXOooo = oIX0oI2;
        oIX0oI2.oIX0oI(this);
        oix0oi.xxIXOIIO(oIX0oI2);
        x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI3 = oix0oi2.oOoXoXO().oIX0oI();
        this.f32447xoXoI = oIX0oI3;
        oIX0oI3.oIX0oI(this);
        oix0oi.xxIXOIIO(oIX0oI3);
        x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI4 = oix0oi2.oxoX().oIX0oI();
        this.f32443o00 = oIX0oI4;
        oIX0oI4.oIX0oI(this);
        oix0oi.xxIXOIIO(oIX0oI4);
    }

    @Override // ooOOo0oXI.oIX0oI, ooOOo0oXI.X0o0xo
    public void I0Io(Canvas canvas, Matrix matrix, int i) {
        Shader oOoXoXO2;
        if (this.f32446x0xO0oo) {
            return;
        }
        oIX0oI(this.f32441Oxx0xo, matrix, false);
        if (this.f32444oI0IIXIo == GradientType.LINEAR) {
            oOoXoXO2 = OOXIXo();
        } else {
            oOoXoXO2 = oOoXoXO();
        }
        oOoXoXO2.setLocalMatrix(matrix);
        this.f32388xxIXOIIO.setShader(oOoXoXO2);
        super.I0Io(canvas, matrix, i);
    }

    public final LinearGradient OOXIXo() {
        long xoIox2 = xoIox();
        LinearGradient linearGradient = this.f32439Oo.get(xoIox2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF II0XooXoX2 = this.f32447xoXoI.II0XooXoX();
        PointF II0XooXoX3 = this.f32443o00.II0XooXoX();
        IXxxXO.I0Io II0XooXoX4 = this.f32437IIXOooo.II0XooXoX();
        LinearGradient linearGradient2 = new LinearGradient(II0XooXoX2.x, II0XooXoX2.y, II0XooXoX3.x, II0XooXoX3.y, xxIXOIIO(II0XooXoX4.oIX0oI()), II0XooXoX4.II0xO0(), Shader.TileMode.CLAMP);
        this.f32439Oo.put(xoIox2, linearGradient2);
        return linearGradient2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ooOOo0oXI.oIX0oI, x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        super.XO(t, xoiox);
        if (t == com.airbnb.lottie.oO.f4986xXxxox0I) {
            x0XOIxOo.x0xO0oo x0xo0oo = this.f32440OxI;
            if (x0xo0oo != null) {
                this.f32381XO.XIxXXX0x0(x0xo0oo);
            }
            if (xoiox == null) {
                this.f32440OxI = null;
                return;
            }
            x0XOIxOo.x0xO0oo x0xo0oo2 = new x0XOIxOo.x0xO0oo(xoiox);
            this.f32440OxI = x0xo0oo2;
            x0xo0oo2.oIX0oI(this);
            this.f32381XO.xxIXOIIO(this.f32440OxI);
        }
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f32445oO;
    }

    public final RadialGradient oOoXoXO() {
        long xoIox2 = xoIox();
        RadialGradient radialGradient = this.f32438IXxxXO.get(xoIox2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF II0XooXoX2 = this.f32447xoXoI.II0XooXoX();
        PointF II0XooXoX3 = this.f32443o00.II0XooXoX();
        IXxxXO.I0Io II0XooXoX4 = this.f32437IIXOooo.II0XooXoX();
        int[] xxIXOIIO2 = xxIXOIIO(II0XooXoX4.oIX0oI());
        float[] II0xO02 = II0XooXoX4.II0xO0();
        RadialGradient radialGradient2 = new RadialGradient(II0XooXoX2.x, II0XooXoX2.y, (float) Math.hypot(II0XooXoX3.x - r7, II0XooXoX3.y - r8), xxIXOIIO2, II0xO02, Shader.TileMode.CLAMP);
        this.f32438IXxxXO.put(xoIox2, radialGradient2);
        return radialGradient2;
    }

    public final int xoIox() {
        int i;
        int round = Math.round(this.f32447xoXoI.XO() * this.f32442OxxIIOOXO);
        int round2 = Math.round(this.f32443o00.XO() * this.f32442OxxIIOOXO);
        int round3 = Math.round(this.f32437IIXOooo.XO() * this.f32442OxxIIOOXO);
        if (round != 0) {
            i = 527 * round;
        } else {
            i = 17;
        }
        if (round2 != 0) {
            i = i * 31 * round2;
        }
        if (round3 != 0) {
            return i * 31 * round3;
        }
        return i;
    }

    public final int[] xxIXOIIO(int[] iArr) {
        x0XOIxOo.x0xO0oo x0xo0oo = this.f32440OxI;
        if (x0xo0oo != null) {
            Integer[] numArr = (Integer[]) x0xo0oo.II0XooXoX();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }
}
