package xxx00;

import IIxOXoOo0.XO;
import OOXIxO0.Oxx0IOOO;
import OXOo.oOoXoXO;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.blankj.utilcode.util.SizeUtils;
import com.github.mikephil.charting.data.Entry;
import kotlin.jvm.internal.IIX0o;
import o0xxxXXxX.ooOOo0oXI;
import xX0IIXIx0.xoIox;

/* loaded from: classes12.dex */
public final class I0Io extends xoIox {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f35553OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final float f35554oI0IIXIo;

    public I0Io(@oOoXoXO Oxx0IOOO oxx0IOOO, @oOoXoXO Ioxxx.oIX0oI oix0oi, @oOoXoXO XIXIX.oOoXoXO oooxoxo) {
        super(oxx0IOOO, oix0oi, oooxoxo);
        this.f35554oI0IIXIo = 10.0f;
        this.f35553OxxIIOOXO = -1;
    }

    public final void XIxXXX0x0(Canvas canvas, float f) {
        this.f34533oxoX.setColor(this.f35553OxxIIOOXO);
        this.f34533oxoX.setStyle(Paint.Style.STROKE);
        this.f34533oxoX.setStrokeWidth(SizeUtils.dp2px(1.0f));
        this.f34533oxoX.setPathEffect(new DashPathEffect(new float[]{1.0f, 0.0f}, 0.0f));
        this.f34533oxoX.setAntiAlias(true);
        IIX0o.ooOOo0oXI(canvas);
        float xoIox2 = this.f34563oIX0oI.xoIox();
        float f2 = this.f35554oI0IIXIo;
        float f3 = 2;
        canvas.drawCircle(f, xoIox2 + f2, f2 - f3, this.f34533oxoX);
        this.f34533oxoX.setColor(this.f35553OxxIIOOXO);
        this.f34533oxoX.setStrokeWidth(SizeUtils.dp2px(1.0f));
        this.f34533oxoX.setPathEffect(new DashPathEffect(new float[]{1.0f, 2.0f}, 0.0f));
        canvas.drawLine(f, this.f34563oIX0oI.xoIox() + (this.f35554oI0IIXIo * f3), f, this.f34563oIX0oI.XO(), this.f34533oxoX);
    }

    @Override // xX0IIXIx0.xoIox, xX0IIXIx0.Oxx0IOOO
    public void oxoX(@oOoXoXO Canvas canvas, @oOoXoXO XI0oooXX.oxoX[] oxoxArr) {
        ooOOo0oXI lineData = this.f34603xxIXOIIO.getLineData();
        IIX0o.ooOOo0oXI(oxoxArr);
        for (XI0oooXX.oxoX oxox : oxoxArr) {
            XO xo2 = (XO) lineData.OOXIXo(oxox.oxoX());
            if (xo2 != null && xo2.XX0()) {
                Entry Ox0O2 = xo2.Ox0O(oxox.II0XooXoX(), oxox.xoIox());
                if (oOoXoXO(Ox0O2, xo2)) {
                    XIXIX.XO XO2 = this.f34603xxIXOIIO.oxoX(xo2.OX00O0xII()).XO(Ox0O2.xxIXOIIO(), Ox0O2.I0Io() * this.f34530II0xO0.xxIXOIIO());
                    oxox.x0XOIxOo((float) XO2.f3774IXxxXO, (float) XO2.f3775Oxx0xo);
                    XIxXXX0x0(canvas, (float) XO2.f3774IXxxXO);
                }
            }
        }
    }

    public final void xxX(int i) {
        this.f35553OxxIIOOXO = i;
    }
}
