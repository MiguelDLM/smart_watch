package xX0IIXIx0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes9.dex */
public abstract class OOXIXo extends oOoXoXO {
    public OOXIXo(Ioxxx.oIX0oI oix0oi, XIXIX.oOoXoXO oooxoxo) {
        super(oix0oi, oooxoxo);
    }

    public void Oo(Canvas canvas, Path path, Drawable drawable) {
        if (oO()) {
            int save = canvas.save();
            canvas.clipPath(path);
            drawable.setBounds((int) this.f34563oIX0oI.II0XooXoX(), (int) this.f34563oIX0oI.xoIox(), (int) this.f34563oIX0oI.xxIXOIIO(), (int) this.f34563oIX0oI.XO());
            drawable.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this code was run on API level " + XIXIX.OOXIXo.XIxXXX0x0() + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    public final boolean oO() {
        if (XIXIX.OOXIXo.XIxXXX0x0() >= 18) {
            return true;
        }
        return false;
    }

    public void x0xO0oo(Canvas canvas, Path path, int i, int i2) {
        int i3 = (i & 16777215) | (i2 << 24);
        if (oO()) {
            int save = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(i3);
            canvas.restoreToCount(save);
            return;
        }
        Paint.Style style = this.f34529I0Io.getStyle();
        int color = this.f34529I0Io.getColor();
        this.f34529I0Io.setStyle(Paint.Style.FILL);
        this.f34529I0Io.setColor(i3);
        canvas.drawPath(path, this.f34529I0Io);
        this.f34529I0Io.setColor(color);
        this.f34529I0Io.setStyle(style);
    }
}
