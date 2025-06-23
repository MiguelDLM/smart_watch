package x0xO0oo;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public final PointF f34090I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final PointF f34091II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final PointF f34092oIX0oI;

    public oIX0oI() {
        this.f34092oIX0oI = new PointF();
        this.f34091II0xO0 = new PointF();
        this.f34090I0Io = new PointF();
    }

    public PointF I0Io() {
        return this.f34090I0Io;
    }

    public PointF II0xO0() {
        return this.f34091II0xO0;
    }

    public void X0o0xo(float f, float f2) {
        this.f34091II0xO0.set(f, f2);
    }

    public void XO(float f, float f2) {
        this.f34090I0Io.set(f, f2);
    }

    public PointF oIX0oI() {
        return this.f34092oIX0oI;
    }

    public void oxoX(float f, float f2) {
        this.f34092oIX0oI.set(f, f2);
    }

    public oIX0oI(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f34092oIX0oI = pointF;
        this.f34091II0xO0 = pointF2;
        this.f34090I0Io = pointF3;
    }
}
