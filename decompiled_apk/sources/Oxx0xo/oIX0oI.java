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

/* loaded from: classes.dex */
public class oIX0oI extends com.airbnb.lottie.model.layer.oIX0oI {

    /* renamed from: IIX0o, reason: collision with root package name */
    @Nullable
    public x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> f3061IIX0o;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public final Rect f3062XxX0x0xxx;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public final Rect f3063xXxxox0I;

    /* renamed from: xxX, reason: collision with root package name */
    public final Paint f3064xxX;

    public oIX0oI(xoIox xoiox, Layer layer) {
        super(xoiox, layer);
        this.f3064xxX = new oOoXoXO.oIX0oI(3);
        this.f3062XxX0x0xxx = new Rect();
        this.f3063xXxxox0I = new Rect();
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI, x0xO0oo.X0o0xo
    public <T> void XO(T t, @Nullable xoXoI.xoIox<T> xoiox) {
        super.XO(t, xoiox);
        if (t == oO.f4976XxX0x0xxx) {
            if (xoiox == null) {
                this.f3061IIX0o = null;
            } else {
                this.f3061IIX0o = new x0xO0oo(xoiox);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI
    public void oI0IIXIo(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap oo2 = oo();
        if (oo2 != null && !oo2.isRecycled()) {
            float X0o0xo2 = IIXOooo.xoIox.X0o0xo();
            this.f3064xxX.setAlpha(i);
            x0XOIxOo.oIX0oI<ColorFilter, ColorFilter> oix0oi = this.f3061IIX0o;
            if (oix0oi != null) {
                this.f3064xxX.setColorFilter(oix0oi.II0XooXoX());
            }
            canvas.save();
            canvas.concat(matrix);
            this.f3062XxX0x0xxx.set(0, 0, oo2.getWidth(), oo2.getHeight());
            this.f3063xXxxox0I.set(0, 0, (int) (oo2.getWidth() * X0o0xo2), (int) (oo2.getHeight() * X0o0xo2));
            canvas.drawBitmap(oo2, this.f3062XxX0x0xxx, this.f3063xXxxox0I, this.f3064xxX);
            canvas.restore();
        }
    }

    @Override // com.airbnb.lottie.model.layer.oIX0oI, ooOOo0oXI.X0o0xo
    public void oIX0oI(RectF rectF, Matrix matrix, boolean z) {
        super.oIX0oI(rectF, matrix, z);
        if (oo() != null) {
            rectF.set(0.0f, 0.0f, r3.getWidth() * IIXOooo.xoIox.X0o0xo(), r3.getHeight() * IIXOooo.xoIox.X0o0xo());
            this.f4941ooOOo0oXI.mapRect(rectF);
        }
    }

    @Nullable
    public final Bitmap oo() {
        return this.f4943x0XOIxOo.o00(this.f4939oO.OOXIXo());
    }
}
