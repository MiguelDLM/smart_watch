package ooOOo0oXI;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
import x0XOIxOo.oIX0oI;

/* loaded from: classes.dex */
public class II0XooXoX implements X0o0xo, oIX0oI.II0xO0, OOXIXo {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f32307Oxx0xo = 32;

    /* renamed from: I0Io, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.oIX0oI f32308I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final RectF f32309II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final boolean f32310II0xO0;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final int f32311IXxxXO;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<IXxxXO.I0Io, IXxxXO.I0Io> f32312OOXIXo;

    /* renamed from: Oo, reason: collision with root package name */
    public final com.airbnb.lottie.xoIox f32313Oo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final Paint f32314Oxx0IOOO;

    /* renamed from: XO, reason: collision with root package name */
    public final Path f32316XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @NonNull
    public final String f32317oIX0oI;

    /* renamed from: oO, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> f32318oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<Integer, Integer> f32319oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<PointF, PointF> f32320ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<PointF, PointF> f32322x0XOIxOo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.x0xO0oo f32323x0xO0oo;

    /* renamed from: xoIox, reason: collision with root package name */
    public final GradientType f32324xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final List<x0XOIxOo> f32325xxIXOIIO;

    /* renamed from: oxoX, reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f32321oxoX = new LongSparseArray<>();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f32315X0o0xo = new LongSparseArray<>();

    public II0XooXoX(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, IXxxXO.oxoX oxox) {
        Path path = new Path();
        this.f32316XO = path;
        this.f32314Oxx0IOOO = new oOoXoXO.oIX0oI(1);
        this.f32309II0XooXoX = new RectF();
        this.f32325xxIXOIIO = new ArrayList();
        this.f32308I0Io = oix0oi;
        this.f32317oIX0oI = oxox.II0XooXoX();
        this.f32310II0xO0 = oxox.OOXIXo();
        this.f32313Oo = xoiox;
        this.f32324xoIox = oxox.X0o0xo();
        path.setFillType(oxox.I0Io());
        this.f32311IXxxXO = (int) (xoiox.oI0IIXIo().oxoX() / 32.0f);
        x0XOIxOo.oIX0oI<IXxxXO.I0Io, IXxxXO.I0Io> oIX0oI2 = oxox.oxoX().oIX0oI();
        this.f32312OOXIXo = oIX0oI2;
        oIX0oI2.oIX0oI(this);
        oix0oi.xxIXOIIO(oIX0oI2);
        x0XOIxOo.oIX0oI<Integer, Integer> oIX0oI3 = oxox.xxIXOIIO().oIX0oI();
        this.f32319oOoXoXO = oIX0oI3;
        oIX0oI3.oIX0oI(this);
        oix0oi.xxIXOIIO(oIX0oI3);
        x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI4 = oxox.xoIox().oIX0oI();
        this.f32320ooOOo0oXI = oIX0oI4;
        oIX0oI4.oIX0oI(this);
        oix0oi.xxIXOIIO(oIX0oI4);
        x0XOIxOo.oIX0oI<PointF, PointF> oIX0oI5 = oxox.II0xO0().oIX0oI();
        this.f32322x0XOIxOo = oIX0oI5;
        oIX0oI5.oIX0oI(this);
        oix0oi.xxIXOIIO(oIX0oI5);
    }

    private int II0XooXoX() {
        int i;
        int round = Math.round(this.f32320ooOOo0oXI.XO() * this.f32311IXxxXO);
        int round2 = Math.round(this.f32322x0XOIxOo.XO() * this.f32311IXxxXO);
        int round3 = Math.round(this.f32312OOXIXo.XO() * this.f32311IXxxXO);
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

    private int[] II0xO0(int[] iArr) {
        x0XOIxOo.x0xO0oo x0xo0oo = this.f32323x0xO0oo;
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

    private RadialGradient xoIox() {
        float f;
        long II0XooXoX2 = II0XooXoX();
        RadialGradient radialGradient = this.f32315X0o0xo.get(II0XooXoX2);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF II0XooXoX3 = this.f32320ooOOo0oXI.II0XooXoX();
        PointF II0XooXoX4 = this.f32322x0XOIxOo.II0XooXoX();
        IXxxXO.I0Io II0XooXoX5 = this.f32312OOXIXo.II0XooXoX();
        int[] II0xO02 = II0xO0(II0XooXoX5.oIX0oI());
        float[] II0xO03 = II0XooXoX5.II0xO0();
        float f2 = II0XooXoX3.x;
        float f3 = II0XooXoX3.y;
        float hypot = (float) Math.hypot(II0XooXoX4.x - f2, II0XooXoX4.y - f3);
        if (hypot <= 0.0f) {
            f = 0.001f;
        } else {
            f = hypot;
        }
        RadialGradient radialGradient2 = new RadialGradient(f2, f3, f, II0xO02, II0xO03, Shader.TileMode.CLAMP);
        this.f32315X0o0xo.put(II0XooXoX2, radialGradient2);
        return radialGradient2;
    }

    private LinearGradient xxIXOIIO() {
        long II0XooXoX2 = II0XooXoX();
        LinearGradient linearGradient = this.f32321oxoX.get(II0XooXoX2);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF II0XooXoX3 = this.f32320ooOOo0oXI.II0XooXoX();
        PointF II0XooXoX4 = this.f32322x0XOIxOo.II0XooXoX();
        IXxxXO.I0Io II0XooXoX5 = this.f32312OOXIXo.II0XooXoX();
        LinearGradient linearGradient2 = new LinearGradient(II0XooXoX3.x, II0XooXoX3.y, II0XooXoX4.x, II0XooXoX4.y, II0xO0(II0XooXoX5.oIX0oI()), II0XooXoX5.II0xO0(), Shader.TileMode.CLAMP);
        this.f32321oxoX.put(II0XooXoX2, linearGradient2);
        return linearGradient2;
    }

    @Override // ooOOo0oXI.X0o0xo
    public void I0Io(Canvas canvas, Matrix matrix, int i) {
        Shader xoIox2;
        if (this.f32310II0xO0) {
            return;
        }
        com.airbnb.lottie.X0o0xo.oIX0oI("GradientFillContent#draw");
        this.f32316XO.reset();
        for (int i2 = 0; i2 < this.f32325xxIXOIIO.size(); i2++) {
            this.f32316XO.addPath(this.f32325xxIXOIIO.get(i2).getPath(), matrix);
        }
        this.f32316XO.computeBounds(this.f32309II0XooXoX, false);
        if (this.f32324xoIox == GradientType.LINEAR) {
            xoIox2 = xxIXOIIO();
        } else {
            xoIox2 = xoIox();
        }
        xoIox2.setLocalMatrix(matrix);
        this.f32314Oxx0IOOO.setShader(xoIox2);
        x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> oix0oi = this.f32318oO;
        if (oix0oi != null) {
            this.f32314Oxx0IOOO.setColorFilter(oix0oi.II0XooXoX());
        }
        this.f32314Oxx0IOOO.setAlpha(IIXOooo.xxIXOIIO.oxoX((int) ((((i / 255.0f) * this.f32319oOoXoXO.II0XooXoX().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f32316XO, this.f32314Oxx0IOOO);
        com.airbnb.lottie.X0o0xo.II0xO0("GradientFillContent#draw");
    }

    @Override // x0xO0oo.X0o0xo
    public void Oxx0IOOO(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
        IIXOooo.xxIXOIIO.ooOOo0oXI(oxox, i, list, oxox2, this);
    }

    @Override // ooOOo0oXI.I0Io
    public void X0o0xo(List<I0Io> list, List<I0Io> list2) {
        for (int i = 0; i < list2.size(); i++) {
            I0Io i0Io = list2.get(i);
            if (i0Io instanceof x0XOIxOo) {
                this.f32325xxIXOIIO.add((x0XOIxOo) i0Io);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        if (t == com.airbnb.lottie.oO.f4983oxoX) {
            this.f32319oOoXoXO.x0XOIxOo(xoiox);
            return;
        }
        if (t == com.airbnb.lottie.oO.f4976XxX0x0xxx) {
            x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> oix0oi = this.f32318oO;
            if (oix0oi != null) {
                this.f32308I0Io.XIxXXX0x0(oix0oi);
            }
            if (xoiox == null) {
                this.f32318oO = null;
                return;
            }
            x0XOIxOo.x0xO0oo x0xo0oo = new x0XOIxOo.x0xO0oo(xoiox);
            this.f32318oO = x0xo0oo;
            x0xo0oo.oIX0oI(this);
            this.f32308I0Io.xxIXOIIO(this.f32318oO);
            return;
        }
        if (t == com.airbnb.lottie.oO.f4986xXxxox0I) {
            x0XOIxOo.x0xO0oo x0xo0oo2 = this.f32323x0xO0oo;
            if (x0xo0oo2 != null) {
                this.f32308I0Io.XIxXXX0x0(x0xo0oo2);
            }
            if (xoiox == null) {
                this.f32323x0xO0oo = null;
                return;
            }
            this.f32321oxoX.clear();
            this.f32315X0o0xo.clear();
            x0XOIxOo.x0xO0oo x0xo0oo3 = new x0XOIxOo.x0xO0oo(xoiox);
            this.f32323x0xO0oo = x0xo0oo3;
            x0xo0oo3.oIX0oI(this);
            this.f32308I0Io.xxIXOIIO(this.f32323x0xO0oo);
        }
    }

    @Override // ooOOo0oXI.I0Io
    public String getName() {
        return this.f32317oIX0oI;
    }

    @Override // ooOOo0oXI.X0o0xo
    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        this.f32316XO.reset();
        for (int i = 0; i < this.f32325xxIXOIIO.size(); i++) {
            this.f32316XO.addPath(this.f32325xxIXOIIO.get(i).getPath(), matrix);
        }
        this.f32316XO.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // x0XOIxOo.oIX0oI.II0xO0
    public void oxoX() {
        this.f32313Oo.invalidateSelf();
    }
}
