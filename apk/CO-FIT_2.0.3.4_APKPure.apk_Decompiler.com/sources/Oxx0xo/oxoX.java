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
import com.airbnb.lottie.model.layer.oIX0oI;
import com.airbnb.lottie.oO;
import com.airbnb.lottie.xoIox;
import x0XOIxOo.x0xO0oo;

public class oxoX extends oIX0oI {

    /* renamed from: IIX0o  reason: collision with root package name */
    public final Path f168IIX0o;

    /* renamed from: XxX0x0xxx  reason: collision with root package name */
    public final Paint f169XxX0x0xxx;

    /* renamed from: ooXIXxIX  reason: collision with root package name */
    public final Layer f170ooXIXxIX;
    @Nullable

    /* renamed from: xI  reason: collision with root package name */
    public x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> f171xI;

    /* renamed from: xXxxox0I  reason: collision with root package name */
    public final float[] f172xXxxox0I;

    /* renamed from: xxX  reason: collision with root package name */
    public final RectF f173xxX = new RectF();

    public oxoX(xoIox xoiox, Layer layer) {
        super(xoiox, layer);
        oOoXoXO.oIX0oI oix0oi = new oOoXoXO.oIX0oI();
        this.f169XxX0x0xxx = oix0oi;
        this.f172xXxxox0I = new float[8];
        this.f168IIX0o = new Path();
        this.f170ooXIXxIX = layer;
        oix0oi.setAlpha(0);
        oix0oi.setStyle(Paint.Style.FILL);
        oix0oi.setColor(layer.ooOOo0oXI());
    }

    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        super.XO(t, xoiox);
        if (t != oO.f982XxX0x0xxx) {
            return;
        }
        if (xoiox == null) {
            this.f171xI = null;
        } else {
            this.f171xI = new x0xO0oo(xoiox);
        }
    }

    public void oI0IIXIo(Canvas canvas, Matrix matrix, int i) {
        int i2;
        int alpha = Color.alpha(this.f170ooXIXxIX.ooOOo0oXI());
        if (alpha != 0) {
            if (this.f932IIXOooo.II0XooXoX() == null) {
                i2 = 100;
            } else {
                i2 = this.f932IIXOooo.II0XooXoX().II0XooXoX().intValue();
            }
            int i3 = (int) ((((float) i) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) i2)) / 100.0f) * 255.0f);
            this.f169XxX0x0xxx.setAlpha(i3);
            x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> oix0oi = this.f171xI;
            if (oix0oi != null) {
                this.f169XxX0x0xxx.setColorFilter(oix0oi.II0XooXoX());
            }
            if (i3 > 0) {
                float[] fArr = this.f172xXxxox0I;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.f170ooXIXxIX.oO();
                float[] fArr2 = this.f172xXxxox0I;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.f170ooXIXxIX.oO();
                this.f172xXxxox0I[5] = (float) this.f170ooXIXxIX.x0XOIxOo();
                float[] fArr3 = this.f172xXxxox0I;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.f170ooXIXxIX.x0XOIxOo();
                matrix.mapPoints(this.f172xXxxox0I);
                this.f168IIX0o.reset();
                Path path = this.f168IIX0o;
                float[] fArr4 = this.f172xXxxox0I;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.f168IIX0o;
                float[] fArr5 = this.f172xXxxox0I;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.f168IIX0o;
                float[] fArr6 = this.f172xXxxox0I;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.f168IIX0o;
                float[] fArr7 = this.f172xXxxox0I;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.f168IIX0o;
                float[] fArr8 = this.f172xXxxox0I;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.f168IIX0o.close();
                canvas.drawPath(this.f168IIX0o, this.f169XxX0x0xxx);
            }
        }
    }

    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        super.oIX0oI(rectF, matrix, z);
        this.f173xxX.set(0.0f, 0.0f, (float) this.f170ooXIXxIX.oO(), (float) this.f170ooXIXxIX.x0XOIxOo());
        this.f947ooOOo0oXI.mapRect(this.f173xxX);
        rectF.set(this.f173xxX);
    }
}
