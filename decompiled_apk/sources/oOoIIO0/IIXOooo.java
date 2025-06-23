package oOoIIO0;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import com.kuaishou.weapon.p0.g;

/* loaded from: classes11.dex */
public final class IIXOooo implements II0xO0, Oxx0IOOO {

    /* renamed from: XO, reason: collision with root package name */
    public final xXoOI00O.I0Io f32026XO;

    @RequiresPermission(g.f18396a)
    public IIXOooo(Context context, String str, ooOOo0oXI ooooo0oxi) {
        xXoOI00O.I0Io i0Io = new xXoOI00O.I0Io(context, str, 1);
        this.f32026XO = i0Io;
        i0Io.Oo(ooooo0oxi);
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0XooXoX(int i, String str, String str2) {
        xXoOI00O.I0Io i0Io = this.f32026XO;
        if (i0Io == null) {
            return;
        }
        i0Io.II0XooXoX(i, str, str2);
    }

    @Override // oOoIIO0.Oxx0IOOO
    public void II0xO0(int i) {
        xXoOI00O.I0Io i0Io = this.f32026XO;
        if (i0Io == null) {
            return;
        }
        i0Io.II0xO0(i);
    }

    public int OOXIXo() {
        xXoOI00O.I0Io i0Io = this.f32026XO;
        if (i0Io == null) {
            return 0;
        }
        return i0Io.X0IIOO();
    }

    @Override // oOoIIO0.II0xO0
    public void cancel() {
        xXoOI00O.I0Io i0Io = this.f32026XO;
        if (i0Io != null) {
            i0Io.Xx000oIo();
            this.f32026XO.f34710oo0xXOI0I.oxoX();
            this.f32026XO.cancel(true);
        }
    }

    @Override // oOoIIO0.II0xO0
    public void destroy() {
        cancel();
    }

    public void oO(String str) {
        this.f32026XO.x0xO0oo(str);
    }

    public String oOoXoXO() {
        xXoOI00O.I0Io i0Io = this.f32026XO;
        if (i0Io == null) {
            return null;
        }
        return i0Io.XxX0x0xxx();
    }

    @RequiresPermission(g.f18396a)
    public void ooOOo0oXI() {
        this.f32026XO.oI0IIXIo(null);
    }

    public String oxoX() {
        return this.f32026XO.xoXoI();
    }

    public void x0XOIxOo(boolean z) {
        this.f32026XO.OxI(z);
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
