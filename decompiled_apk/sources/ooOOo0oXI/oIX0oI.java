package ooOOo0oXI;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
import x0XOIxOo.oIX0oI;

/* loaded from: classes.dex */
public abstract class oIX0oI implements oIX0oI.II0xO0, OOXIXo, X0o0xo {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final float[] f32376II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, Integer> f32378OOXIXo;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final com.airbnb.lottie.xoIox f32380X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.oIX0oI f32381XO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public final List<x0XOIxOo.oIX0oI<?, Float>> f32383oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    @Nullable
    public final x0XOIxOo.oIX0oI<?, Float> f32384ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> f32386x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public final x0XOIxOo.oIX0oI<?, Float> f32387xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public final Paint f32388xxIXOIIO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final PathMeasure f32382oIX0oI = new PathMeasure();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final Path f32377II0xO0 = new Path();

    /* renamed from: I0Io, reason: collision with root package name */
    public final Path f32375I0Io = new Path();

    /* renamed from: oxoX, reason: collision with root package name */
    public final RectF f32385oxoX = new RectF();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final List<II0xO0> f32379Oxx0IOOO = new ArrayList();

    /* loaded from: classes.dex */
    public static final class II0xO0 {

        /* renamed from: II0xO0, reason: collision with root package name */
        @Nullable
        public final OxxIIOOXO f32389II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final List<x0XOIxOo> f32390oIX0oI;

        public II0xO0(@Nullable OxxIIOOXO oxxIIOOXO) {
            this.f32390oIX0oI = new ArrayList();
            this.f32389II0xO0 = oxxIIOOXO;
        }
    }

    public oIX0oI(com.airbnb.lottie.xoIox xoiox, com.airbnb.lottie.model.layer.oIX0oI oix0oi, Paint.Cap cap, Paint.Join join, float f, Oo.Oxx0IOOO oxx0IOOO, Oo.X0o0xo x0o0xo, List<Oo.X0o0xo> list, Oo.X0o0xo x0o0xo2) {
        oOoXoXO.oIX0oI oix0oi2 = new oOoXoXO.oIX0oI(1);
        this.f32388xxIXOIIO = oix0oi2;
        this.f32380X0o0xo = xoiox;
        this.f32381XO = oix0oi;
        oix0oi2.setStyle(Paint.Style.STROKE);
        oix0oi2.setStrokeCap(cap);
        oix0oi2.setStrokeJoin(join);
        oix0oi2.setStrokeMiter(f);
        this.f32378OOXIXo = oxx0IOOO.oIX0oI();
        this.f32387xoIox = x0o0xo.oIX0oI();
        if (x0o0xo2 == null) {
            this.f32384ooOOo0oXI = null;
        } else {
            this.f32384ooOOo0oXI = x0o0xo2.oIX0oI();
        }
        this.f32383oOoXoXO = new ArrayList(list.size());
        this.f32376II0XooXoX = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.f32383oOoXoXO.add(list.get(i).oIX0oI());
        }
        oix0oi.xxIXOIIO(this.f32378OOXIXo);
        oix0oi.xxIXOIIO(this.f32387xoIox);
        for (int i2 = 0; i2 < this.f32383oOoXoXO.size(); i2++) {
            oix0oi.xxIXOIIO(this.f32383oOoXoXO.get(i2));
        }
        x0XOIxOo.oIX0oI<?, Float> oix0oi3 = this.f32384ooOOo0oXI;
        if (oix0oi3 != null) {
            oix0oi.xxIXOIIO(oix0oi3);
        }
        this.f32378OOXIXo.oIX0oI(this);
        this.f32387xoIox.oIX0oI(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f32383oOoXoXO.get(i3).oIX0oI(this);
        }
        x0XOIxOo.oIX0oI<?, Float> oix0oi4 = this.f32384ooOOo0oXI;
        if (oix0oi4 != null) {
            oix0oi4.oIX0oI(this);
        }
    }

    public void I0Io(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.X0o0xo.oIX0oI("StrokeContent#draw");
        if (IIXOooo.xoIox.II0XooXoX(matrix)) {
            com.airbnb.lottie.X0o0xo.II0xO0("StrokeContent#draw");
            return;
        }
        this.f32388xxIXOIIO.setAlpha(IIXOooo.xxIXOIIO.oxoX((int) ((((i / 255.0f) * ((x0XOIxOo.X0o0xo) this.f32378OOXIXo).x0xO0oo()) / 100.0f) * 255.0f), 0, 255));
        this.f32388xxIXOIIO.setStrokeWidth(((x0XOIxOo.I0Io) this.f32387xoIox).x0xO0oo() * IIXOooo.xoIox.Oxx0IOOO(matrix));
        if (this.f32388xxIXOIIO.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.X0o0xo.II0xO0("StrokeContent#draw");
            return;
        }
        II0xO0(matrix);
        x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> oix0oi = this.f32386x0XOIxOo;
        if (oix0oi != null) {
            this.f32388xxIXOIIO.setColorFilter(oix0oi.II0XooXoX());
        }
        for (int i2 = 0; i2 < this.f32379Oxx0IOOO.size(); i2++) {
            II0xO0 iI0xO0 = this.f32379Oxx0IOOO.get(i2);
            if (iI0xO0.f32389II0xO0 != null) {
                II0XooXoX(canvas, iI0xO0, matrix);
            } else {
                com.airbnb.lottie.X0o0xo.oIX0oI("StrokeContent#buildPath");
                this.f32377II0xO0.reset();
                for (int size = iI0xO0.f32390oIX0oI.size() - 1; size >= 0; size--) {
                    this.f32377II0xO0.addPath(((x0XOIxOo) iI0xO0.f32390oIX0oI.get(size)).getPath(), matrix);
                }
                com.airbnb.lottie.X0o0xo.II0xO0("StrokeContent#buildPath");
                com.airbnb.lottie.X0o0xo.oIX0oI("StrokeContent#drawPath");
                canvas.drawPath(this.f32377II0xO0, this.f32388xxIXOIIO);
                com.airbnb.lottie.X0o0xo.II0xO0("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.X0o0xo.II0xO0("StrokeContent#draw");
    }

    public final void II0XooXoX(Canvas canvas, II0xO0 iI0xO0, Matrix matrix) {
        float f;
        float f2;
        com.airbnb.lottie.X0o0xo.oIX0oI("StrokeContent#applyTrimPath");
        if (iI0xO0.f32389II0xO0 == null) {
            com.airbnb.lottie.X0o0xo.II0xO0("StrokeContent#applyTrimPath");
            return;
        }
        this.f32377II0xO0.reset();
        for (int size = iI0xO0.f32390oIX0oI.size() - 1; size >= 0; size--) {
            this.f32377II0xO0.addPath(((x0XOIxOo) iI0xO0.f32390oIX0oI.get(size)).getPath(), matrix);
        }
        this.f32382oIX0oI.setPath(this.f32377II0xO0, false);
        float length = this.f32382oIX0oI.getLength();
        while (this.f32382oIX0oI.nextContour()) {
            length += this.f32382oIX0oI.getLength();
        }
        float floatValue = (iI0xO0.f32389II0xO0.Oxx0IOOO().II0XooXoX().floatValue() * length) / 360.0f;
        float floatValue2 = ((iI0xO0.f32389II0xO0.II0XooXoX().II0XooXoX().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((iI0xO0.f32389II0xO0.XO().II0XooXoX().floatValue() * length) / 100.0f) + floatValue;
        float f3 = 0.0f;
        for (int size2 = iI0xO0.f32390oIX0oI.size() - 1; size2 >= 0; size2--) {
            this.f32375I0Io.set(((x0XOIxOo) iI0xO0.f32390oIX0oI.get(size2)).getPath());
            this.f32375I0Io.transform(matrix);
            this.f32382oIX0oI.setPath(this.f32375I0Io, false);
            float length2 = this.f32382oIX0oI.getLength();
            float f4 = 1.0f;
            if (floatValue3 > length) {
                float f5 = floatValue3 - length;
                if (f5 < f3 + length2 && f3 < f5) {
                    if (floatValue2 > length) {
                        f2 = (floatValue2 - length) / length2;
                    } else {
                        f2 = 0.0f;
                    }
                    IIXOooo.xoIox.oIX0oI(this.f32375I0Io, f2, Math.min(f5 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f32375I0Io, this.f32388xxIXOIIO);
                    f3 += length2;
                }
            }
            float f6 = f3 + length2;
            if (f6 >= floatValue2 && f3 <= floatValue3) {
                if (f6 <= floatValue3 && floatValue2 < f3) {
                    canvas.drawPath(this.f32375I0Io, this.f32388xxIXOIIO);
                } else {
                    if (floatValue2 < f3) {
                        f = 0.0f;
                    } else {
                        f = (floatValue2 - f3) / length2;
                    }
                    if (floatValue3 <= f6) {
                        f4 = (floatValue3 - f3) / length2;
                    }
                    IIXOooo.xoIox.oIX0oI(this.f32375I0Io, f, f4, 0.0f);
                    canvas.drawPath(this.f32375I0Io, this.f32388xxIXOIIO);
                }
            }
            f3 += length2;
        }
        com.airbnb.lottie.X0o0xo.II0xO0("StrokeContent#applyTrimPath");
    }

    public final void II0xO0(Matrix matrix) {
        float floatValue;
        com.airbnb.lottie.X0o0xo.oIX0oI("StrokeContent#applyDashPattern");
        if (this.f32383oOoXoXO.isEmpty()) {
            com.airbnb.lottie.X0o0xo.II0xO0("StrokeContent#applyDashPattern");
            return;
        }
        float Oxx0IOOO2 = IIXOooo.xoIox.Oxx0IOOO(matrix);
        for (int i = 0; i < this.f32383oOoXoXO.size(); i++) {
            this.f32376II0XooXoX[i] = this.f32383oOoXoXO.get(i).II0XooXoX().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.f32376II0XooXoX;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f32376II0XooXoX;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.f32376II0XooXoX;
            fArr3[i] = fArr3[i] * Oxx0IOOO2;
        }
        x0XOIxOo.oIX0oI<?, Float> oix0oi = this.f32384ooOOo0oXI;
        if (oix0oi == null) {
            floatValue = 0.0f;
        } else {
            floatValue = Oxx0IOOO2 * oix0oi.II0XooXoX().floatValue();
        }
        this.f32388xxIXOIIO.setPathEffect(new DashPathEffect(this.f32376II0XooXoX, floatValue));
        com.airbnb.lottie.X0o0xo.II0xO0("StrokeContent#applyDashPattern");
    }

    @Override // x0xO0oo.X0o0xo
    public void Oxx0IOOO(x0xO0oo.oxoX oxox, int i, List<x0xO0oo.oxoX> list, x0xO0oo.oxoX oxox2) {
        IIXOooo.xxIXOIIO.ooOOo0oXI(oxox, i, list, oxox2, this);
    }

    @Override // ooOOo0oXI.I0Io
    public void X0o0xo(List<I0Io> list, List<I0Io> list2) {
        OxxIIOOXO oxxIIOOXO = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            I0Io i0Io = list.get(size);
            if (i0Io instanceof OxxIIOOXO) {
                OxxIIOOXO oxxIIOOXO2 = (OxxIIOOXO) i0Io;
                if (oxxIIOOXO2.xxIXOIIO() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    oxxIIOOXO = oxxIIOOXO2;
                }
            }
        }
        if (oxxIIOOXO != null) {
            oxxIIOOXO.II0xO0(this);
        }
        II0xO0 iI0xO0 = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            I0Io i0Io2 = list2.get(size2);
            if (i0Io2 instanceof OxxIIOOXO) {
                OxxIIOOXO oxxIIOOXO3 = (OxxIIOOXO) i0Io2;
                if (oxxIIOOXO3.xxIXOIIO() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (iI0xO0 != null) {
                        this.f32379Oxx0IOOO.add(iI0xO0);
                    }
                    iI0xO0 = new II0xO0(oxxIIOOXO3);
                    oxxIIOOXO3.II0xO0(this);
                }
            }
            if (i0Io2 instanceof x0XOIxOo) {
                if (iI0xO0 == null) {
                    iI0xO0 = new II0xO0(oxxIIOOXO);
                }
                iI0xO0.f32390oIX0oI.add((x0XOIxOo) i0Io2);
            }
        }
        if (iI0xO0 != null) {
            this.f32379Oxx0IOOO.add(iI0xO0);
        }
    }

    @CallSuper
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        if (t == com.airbnb.lottie.oO.f4983oxoX) {
            this.f32378OOXIXo.x0XOIxOo(xoiox);
            return;
        }
        if (t == com.airbnb.lottie.oO.f4966Oo) {
            this.f32387xoIox.x0XOIxOo(xoiox);
            return;
        }
        if (t == com.airbnb.lottie.oO.f4976XxX0x0xxx) {
            x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> oix0oi = this.f32386x0XOIxOo;
            if (oix0oi != null) {
                this.f32381XO.XIxXXX0x0(oix0oi);
            }
            if (xoiox == null) {
                this.f32386x0XOIxOo = null;
                return;
            }
            x0XOIxOo.x0xO0oo x0xo0oo = new x0XOIxOo.x0xO0oo(xoiox);
            this.f32386x0XOIxOo = x0xo0oo;
            x0xo0oo.oIX0oI(this);
            this.f32381XO.xxIXOIIO(this.f32386x0XOIxOo);
        }
    }

    @Override // ooOOo0oXI.X0o0xo
    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        com.airbnb.lottie.X0o0xo.oIX0oI("StrokeContent#getBounds");
        this.f32377II0xO0.reset();
        for (int i = 0; i < this.f32379Oxx0IOOO.size(); i++) {
            II0xO0 iI0xO0 = this.f32379Oxx0IOOO.get(i);
            for (int i2 = 0; i2 < iI0xO0.f32390oIX0oI.size(); i2++) {
                this.f32377II0xO0.addPath(((x0XOIxOo) iI0xO0.f32390oIX0oI.get(i2)).getPath(), matrix);
            }
        }
        this.f32377II0xO0.computeBounds(this.f32385oxoX, false);
        float x0xO0oo2 = ((x0XOIxOo.I0Io) this.f32387xoIox).x0xO0oo();
        RectF rectF2 = this.f32385oxoX;
        float f = x0xO0oo2 / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.f32385oxoX);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.X0o0xo.II0xO0("StrokeContent#getBounds");
    }

    @Override // x0XOIxOo.oIX0oI.II0xO0
    public void oxoX() {
        this.f32380X0o0xo.invalidateSelf();
    }
}
