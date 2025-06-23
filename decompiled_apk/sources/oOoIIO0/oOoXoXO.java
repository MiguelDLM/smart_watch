package oOoIIO0;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.kuaishou.weapon.p0.g;
import oOoIIO0.I0Io;

/* loaded from: classes11.dex */
public final class oOoXoXO implements II0xO0, Oxx0IOOO {

    /* renamed from: XO, reason: collision with root package name */
    public final xXoOI00O.I0Io f32065XO;

    @RequiresPermission(g.f18396a)
    public oOoXoXO(Context context, String str, ooOOo0oXI ooooo0oxi) {
        xXoOI00O.I0Io i0Io = new xXoOI00O.I0Io(context, str, 1);
        this.f32065XO = i0Io;
        i0Io.Oo(ooooo0oxi);
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0XooXoX(int i, String str, String str2) {
        xXoOI00O.I0Io i0Io = this.f32065XO;
        if (i0Io == null) {
            return;
        }
        i0Io.II0XooXoX(i, str, str2);
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0xO0(int i) {
        xXoOI00O.I0Io i0Io = this.f32065XO;
        if (i0Io == null) {
            return;
        }
        i0Io.II0xO0(i);
    }

    public void IXxxXO(String str) {
        this.f32065XO.x0xO0oo(str);
    }

    public int OOXIXo() {
        xXoOI00O.I0Io i0Io = this.f32065XO;
        if (i0Io == null) {
            return 0;
        }
        return i0Io.X0IIOO();
    }

    public void Oo(boolean z) {
        this.f32065XO.OxI(z);
    }

    public void Oxx0xo(String str) {
        this.f32065XO.XI0IXoo(str);
    }

    @Override // oOoIIO0.II0xO0
    public void cancel() {
        xXoOI00O.I0Io i0Io = this.f32065XO;
        if (i0Io != null) {
            i0Io.Xx000oIo();
            this.f32065XO.f34710oo0xXOI0I.oxoX();
            this.f32065XO.cancel(true);
        }
    }

    @Override // oOoIIO0.II0xO0
    public void destroy() {
        cancel();
    }

    public void oI0IIXIo(String str) {
        this.f32065XO.xXxxox0I(str);
    }

    public boolean oO() {
        if (x0XOIxOo() && this.f32065XO.oo0xXOI0I()) {
            return true;
        }
        return false;
    }

    public String oOoXoXO() {
        return this.f32065XO.oo();
    }

    public String ooOOo0oXI() {
        xXoOI00O.I0Io i0Io = this.f32065XO;
        if (i0Io == null) {
            return null;
        }
        return i0Io.XxX0x0xxx();
    }

    public String oxoX() {
        return this.f32065XO.xoXoI();
    }

    public boolean x0XOIxOo() {
        return this.f32065XO.xI();
    }

    @RequiresPermission(g.f18396a)
    public void x0xO0oo() {
        this.f32065XO.oI0IIXIo(new I0Io.II0xO0().X0o0xo().XO());
    }

    @Override // oOoIIO0.II0xO0
    public void I0Io() {
    }

    @Override // oOoIIO0.II0xO0
    public void Oxx0IOOO() {
    }

    @Override // oOoIIO0.II0xO0
    public void X0o0xo() {
    }

    @Override // oOoIIO0.II0xO0
    public void XO() {
    }

    @Override // oOoIIO0.II0xO0
    public void oIX0oI() {
    }

    @Override // oOoIIO0.II0xO0
    public void xoIox() {
    }

    @Override // oOoIIO0.II0xO0
    public void xxIXOIIO() {
    }
}
