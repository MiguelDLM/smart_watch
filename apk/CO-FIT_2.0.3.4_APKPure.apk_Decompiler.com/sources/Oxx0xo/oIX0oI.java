package Oxx0xo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.oO;
import com.airbnb.lottie.xoIox;
import x0XOIxOo.x0xO0oo;

public class oIX0oI extends com.airbnb.lottie.model.layer.oIX0oI {
    @Nullable

    /* renamed from: IIX0o  reason: collision with root package name */
    public x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> f164IIX0o;

    /* renamed from: XxX0x0xxx  reason: collision with root package name */
    public final Rect f165XxX0x0xxx = new Rect();

    /* renamed from: xXxxox0I  reason: collision with root package name */
    public final Rect f166xXxxox0I = new Rect();

    /* renamed from: xxX  reason: collision with root package name */
    public final Paint f167xxX = new oOoXoXO.oIX0oI(3);

    public oIX0oI(xoIox xoiox, Layer layer) {
        super(xoiox, layer);
    }

    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        super.XO(t, xoiox);
        if (t != oO.f982XxX0x0xxx) {
            return;
        }
        if (xoiox == null) {
            this.f164IIX0o = null;
        } else {
            this.f164IIX0o = new x0xO0oo(xoiox);
        }
    }

    public void oI0IIXIo(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap oo2 = oo();
        if (oo2 != null && !oo2.isRecycled()) {
            float X0o0xo2 = IIXOooo.xoIox.X0o0xo();
            this.f167xxX.setAlpha(i);
            x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> oix0oi = this.f164IIX0o;
            if (oix0oi != null) {
                this.f167xxX.setColorFilter(oix0oi.II0XooXoX());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f165XxX0x0xxx.set(0, 0, oo2.getWidth(), oo2.getHeight());
            this.f166xXxxox0I.set(0, 0, (int) (((float) oo2.getWidth()) * X0o0xo2), (int) (((float) oo2.getHeight()) * X0o0xo2));
            canvas.drawBitmap(oo2, this.f165XxX0x0xxx, this.f166xXxxox0I, this.f167xxX);
            canvas.restore();
        }
    }

    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        super.oIX0oI(rectF, matrix, z);
        Bitmap oo2 = oo();
        if (oo2 != null) {
            rectF.set(0.0f, 0.0f, ((float) oo2.getWidth()) * IIXOooo.xoIox.X0o0xo(), ((float) oo2.getHeight()) * IIXOooo.xoIox.X0o0xo());
            this.f947ooOOo0oXI.mapRect(rectF);
        }
    }

    @Nullable
    public final Bitmap oo() {
        return this.f949x0XOIxOo.o00(this.f945oO.OOXIXo());
    }
}
