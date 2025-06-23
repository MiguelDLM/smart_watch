package XX0xXo;

import XIXIX.Oxx0IOOO;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import java.lang.ref.WeakReference;

/* loaded from: classes9.dex */
public class X0o0xo implements oxoX {

    /* renamed from: Oo, reason: collision with root package name */
    public Drawable f4000Oo;

    /* renamed from: XO, reason: collision with root package name */
    public Context f4003XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public WeakReference<Chart> f4004oI0IIXIo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public Oxx0IOOO f3999IXxxXO = new Oxx0IOOO();

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Oxx0IOOO f4001Oxx0xo = new Oxx0IOOO();

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public XIXIX.I0Io f4002OxxIIOOXO = new XIXIX.I0Io();

    /* renamed from: IIXOooo, reason: collision with root package name */
    public Rect f3998IIXOooo = new Rect();

    public X0o0xo(Context context, int i) {
        this.f4003XO = context;
        this.f4000Oo = context.getResources().getDrawable(i, null);
    }

    public void II0XooXoX(Oxx0IOOO oxx0IOOO) {
        this.f3999IXxxXO = oxx0IOOO;
        if (oxx0IOOO == null) {
            this.f3999IXxxXO = new Oxx0IOOO();
        }
    }

    @Override // XX0xXo.oxoX
    public Oxx0IOOO II0xO0(float f, float f2) {
        Drawable drawable;
        Drawable drawable2;
        Oxx0IOOO offset = getOffset();
        Oxx0IOOO oxx0IOOO = this.f4001Oxx0xo;
        oxx0IOOO.f3771IXxxXO = offset.f3771IXxxXO;
        oxx0IOOO.f3772Oxx0xo = offset.f3772Oxx0xo;
        Chart oxoX2 = oxoX();
        XIXIX.I0Io i0Io = this.f4002OxxIIOOXO;
        float f3 = i0Io.f3743IXxxXO;
        float f4 = i0Io.f3744Oxx0xo;
        if (f3 == 0.0f && (drawable2 = this.f4000Oo) != null) {
            f3 = drawable2.getIntrinsicWidth();
        }
        if (f4 == 0.0f && (drawable = this.f4000Oo) != null) {
            f4 = drawable.getIntrinsicHeight();
        }
        Oxx0IOOO oxx0IOOO2 = this.f4001Oxx0xo;
        float f5 = oxx0IOOO2.f3771IXxxXO;
        if (f + f5 < 0.0f) {
            oxx0IOOO2.f3771IXxxXO = -f;
        } else if (oxoX2 != null && f + f3 + f5 > oxoX2.getWidth()) {
            this.f4001Oxx0xo.f3771IXxxXO = (oxoX2.getWidth() - f) - f3;
        }
        Oxx0IOOO oxx0IOOO3 = this.f4001Oxx0xo;
        float f6 = oxx0IOOO3.f3772Oxx0xo;
        if (f2 + f6 < 0.0f) {
            oxx0IOOO3.f3772Oxx0xo = -f2;
        } else if (oxoX2 != null && f2 + f4 + f6 > oxoX2.getHeight()) {
            this.f4001Oxx0xo.f3772Oxx0xo = (oxoX2.getHeight() - f2) - f4;
        }
        return this.f4001Oxx0xo;
    }

    public void Oxx0IOOO(float f, float f2) {
        Oxx0IOOO oxx0IOOO = this.f3999IXxxXO;
        oxx0IOOO.f3771IXxxXO = f;
        oxx0IOOO.f3772Oxx0xo = f2;
    }

    public XIXIX.I0Io X0o0xo() {
        return this.f4002OxxIIOOXO;
    }

    public void XO(Chart chart) {
        this.f4004oI0IIXIo = new WeakReference<>(chart);
    }

    @Override // XX0xXo.oxoX
    public Oxx0IOOO getOffset() {
        return this.f3999IXxxXO;
    }

    @Override // XX0xXo.oxoX
    public void oIX0oI(Canvas canvas, float f, float f2) {
        if (this.f4000Oo == null) {
            return;
        }
        Oxx0IOOO II0xO02 = II0xO0(f, f2);
        XIXIX.I0Io i0Io = this.f4002OxxIIOOXO;
        float f3 = i0Io.f3743IXxxXO;
        float f4 = i0Io.f3744Oxx0xo;
        if (f3 == 0.0f) {
            f3 = this.f4000Oo.getIntrinsicWidth();
        }
        if (f4 == 0.0f) {
            f4 = this.f4000Oo.getIntrinsicHeight();
        }
        this.f4000Oo.copyBounds(this.f3998IIXOooo);
        Drawable drawable = this.f4000Oo;
        Rect rect = this.f3998IIXOooo;
        int i = rect.left;
        int i2 = rect.top;
        drawable.setBounds(i, i2, ((int) f3) + i, ((int) f4) + i2);
        int save = canvas.save();
        canvas.translate(f + II0xO02.f3771IXxxXO, f2 + II0xO02.f3772Oxx0xo);
        this.f4000Oo.draw(canvas);
        canvas.restoreToCount(save);
        this.f4000Oo.setBounds(this.f3998IIXOooo);
    }

    public Chart oxoX() {
        WeakReference<Chart> weakReference = this.f4004oI0IIXIo;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void xxIXOIIO(XIXIX.I0Io i0Io) {
        this.f4002OxxIIOOXO = i0Io;
        if (i0Io == null) {
            this.f4002OxxIIOOXO = new XIXIX.I0Io();
        }
    }

    @Override // XX0xXo.oxoX
    public void I0Io(Entry entry, XI0oooXX.oxoX oxox) {
    }
}
