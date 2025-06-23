package IOOXOOOOo;

import IOOXOOOOo.I0Io;
import android.content.Context;
import android.graphics.Point;
import android.os.SystemClock;
import me.devilsen.czxing.view.AutoFitSurfaceView;

/* loaded from: classes6.dex */
public abstract class II0xO0 implements I0Io.oIX0oI, AutoFitSurfaceView.oIX0oI {

    /* renamed from: OxI, reason: collision with root package name */
    public static final long f540OxI = 1000;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public boolean f541IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final I0Io f542IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final AutoFitSurfaceView f543Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public long f544Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f545OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public final Context f546XO;

    /* renamed from: o00, reason: collision with root package name */
    public oIX0oI f547o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Point f548oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public boolean f549xoXoI;

    /* loaded from: classes6.dex */
    public interface oIX0oI {
        void oIX0oI(byte[] bArr, int i, int i2);
    }

    public II0xO0(Context context, AutoFitSurfaceView autoFitSurfaceView) {
        this.f546XO = context;
        this.f543Oo = autoFitSurfaceView;
        autoFitSurfaceView.setOnTouchListener(this);
        I0Io i0Io = new I0Io(context);
        this.f542IXxxXO = i0Io;
        i0Io.Oxx0IOOO(this);
    }

    @Override // IOOXOOOOo.I0Io.oIX0oI
    public void I0Io() {
        int width;
        int height;
        AutoFitSurfaceView autoFitSurfaceView = this.f543Oo;
        if (autoFitSurfaceView != null && autoFitSurfaceView.getWidth() != 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.f544Oxx0xo < 1000) {
                return;
            }
            this.f544Oxx0xo = uptimeMillis;
            Point point = this.f548oI0IIXIo;
            if (point != null) {
                width = point.x;
                height = point.y;
            } else {
                width = this.f543Oo.getWidth() / 2;
                height = this.f543Oo.getHeight() / 2;
            }
            Oxx0IOOO(width, height);
        }
    }

    public abstract float II0XooXoX();

    public abstract void IXxxXO();

    public boolean OOXIXo() {
        return this.f541IIXOooo;
    }

    public abstract void Oo();

    public abstract void Oxx0IOOO(float f, float f2);

    public void Oxx0xo(oIX0oI oix0oi) {
        this.f547o00 = oix0oi;
    }

    public abstract float OxxIIOOXO(float f);

    public abstract void X0o0xo(byte[] bArr);

    public abstract void XO();

    public void oI0IIXIo(Point point) {
        this.f548oI0IIXIo = point;
    }

    @Override // me.devilsen.czxing.view.AutoFitSurfaceView.oIX0oI
    public void oIX0oI(float f, float f2) {
        Oxx0IOOO(f, f2);
    }

    public abstract void oO();

    public boolean oOoXoXO() {
        return this.f549xoXoI;
    }

    public abstract boolean ooOOo0oXI();

    public abstract void x0XOIxOo();

    public abstract void x0xO0oo();

    public boolean xoIox() {
        return this.f545OxxIIOOXO;
    }

    public abstract float xxIXOIIO();
}
