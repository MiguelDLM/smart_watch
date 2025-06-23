package XX0xXo;

import XIXIX.OOXIXo;
import android.graphics.Typeface;
import androidx.core.view.ViewCompat;

/* loaded from: classes9.dex */
public abstract class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public boolean f3996oIX0oI = true;

    /* renamed from: II0xO0, reason: collision with root package name */
    public float f3993II0xO0 = 5.0f;

    /* renamed from: I0Io, reason: collision with root package name */
    public float f3992I0Io = 5.0f;

    /* renamed from: oxoX, reason: collision with root package name */
    public Typeface f3997oxoX = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public float f3994X0o0xo = OOXIXo.X0o0xo(10.0f);

    /* renamed from: XO, reason: collision with root package name */
    public int f3995XO = ViewCompat.MEASURED_STATE_MASK;

    public Typeface I0Io() {
        return this.f3997oxoX;
    }

    public void II0XooXoX(int i) {
        this.f3995XO = i;
    }

    public float II0xO0() {
        return this.f3994X0o0xo;
    }

    public void OOXIXo(float f) {
        this.f3993II0xO0 = OOXIXo.X0o0xo(f);
    }

    public void Oxx0IOOO(boolean z) {
        this.f3996oIX0oI = z;
    }

    public float X0o0xo() {
        return this.f3992I0Io;
    }

    public boolean XO() {
        return this.f3996oIX0oI;
    }

    public int oIX0oI() {
        return this.f3995XO;
    }

    public void oOoXoXO(float f) {
        this.f3992I0Io = OOXIXo.X0o0xo(f);
    }

    public float oxoX() {
        return this.f3993II0xO0;
    }

    public void xoIox(Typeface typeface) {
        this.f3997oxoX = typeface;
    }

    public void xxIXOIIO(float f) {
        if (f > 24.0f) {
            f = 24.0f;
        }
        if (f < 6.0f) {
            f = 6.0f;
        }
        this.f3994X0o0xo = OOXIXo.X0o0xo(f);
    }
}
