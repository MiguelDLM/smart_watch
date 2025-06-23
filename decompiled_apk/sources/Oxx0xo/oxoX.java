package Oxx0xo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.oO;
import com.airbnb.lottie.xoIox;
import x0XOIxOo.x0xO0oo;

/* loaded from: classes.dex */
public class oxoX extends com.airbnb.lottie.model.layer.oIX0oI {

    /* renamed from: IIX0o, reason: collision with root package name */
    public final Path f3065IIX0o;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public final Paint f3066XxX0x0xxx;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public final Layer f3067ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> f3068xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public final float[] f3069xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public final RectF f3070xxX;

    public oxoX(xoIox xoiox, Layer layer) {
        super(xoiox, layer);
        this.f3070xxX = new RectF();
        oOoXoXO.oIX0oI oix0oi = new oOoXoXO.oIX0oI();
        this.f3066XxX0x0xxx = oix0oi;
        this.f3069xXxxox0I = new float[8];
        this.f3065IIX0o = new Path();
        this.f3067ooXIXxIX = layer;
        oix0oi.setAlpha(0);
        oix0oi.setStyle(Paint.Style.FILL);
        oix0oi.setColor(layer.ooOOo0oXI());
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI, x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        super.XO(t, xoiox);
        if (t == oO.f4976XxX0x0xxx) {
            if (xoiox == null) {
                this.f3068xI = null;
            } else {
                this.f3068xI = new x0xO0oo(xoiox);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI
    public void oI0IIXIo(Canvas canvas, Matrix matrix, int i) {
        int intValue;
        int alpha = Color.alpha(this.f3067ooXIXxIX.ooOOo0oXI());
        if (alpha == 0) {
            return;
        }
        if (this.f4926IIXOooo.II0XooXoX() == null) {
            intValue = 100;
        } else {
            intValue = this.f4926IIXOooo.II0XooXoX().II0XooXoX().intValue();
        }
        int i2 = (int) ((i / 255.0f) * (((alpha / 255.0f) * intValue) / 100.0f) * 255.0f);
        this.f3066XxX0x0xxx.setAlpha(i2);
        x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> oix0oi = this.f3068xI;
        if (oix0oi != null) {
            this.f3066XxX0x0xxx.setColorFilter(oix0oi.II0XooXoX());
        }
        if (i2 > 0) {
            float[] fArr = this.f3069xXxxox0I;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.f3067ooXIXxIX.oO();
            float[] fArr2 = this.f3069xXxxox0I;
            fArr2[3] = 0.0f;
            fArr2[4] = this.f3067ooXIXxIX.oO();
            this.f3069xXxxox0I[5] = this.f3067ooXIXxIX.x0XOIxOo();
            float[] fArr3 = this.f3069xXxxox0I;
            fArr3[6] = 0.0f;
            fArr3[7] = this.f3067ooXIXxIX.x0XOIxOo();
            matrix.mapPoints(this.f3069xXxxox0I);
            this.f3065IIX0o.reset();
            Path path = this.f3065IIX0o;
            float[] fArr4 = this.f3069xXxxox0I;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.f3065IIX0o;
            float[] fArr5 = this.f3069xXxxox0I;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.f3065IIX0o;
            float[] fArr6 = this.f3069xXxxox0I;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.f3065IIX0o;
            float[] fArr7 = this.f3069xXxxox0I;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.f3065IIX0o;
            float[] fArr8 = this.f3069xXxxox0I;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.f3065IIX0o.close();
            canvas.drawPath(this.f3065IIX0o, this.f3066XxX0x0xxx);
        }
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI, ooOOo0oXI.X0o0xo
    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        super.oIX0oI(rectF, matrix, z);
        this.f3070xxX.set(0.0f, 0.0f, this.f3067ooXIXxIX.oO(), this.f3067ooXIXxIX.x0XOIxOo());
        this.f4941ooOOo0oXI.mapRect(this.f3070xxX);
        rectF.set(this.f3070xxX);
    }
}
