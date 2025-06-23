package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes6.dex */
public class xxX {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f30501II0xO0 = AtomicIntegerFieldUpdater.newUpdater(xxX.class, "_handled");

    @XO0OX.o00
    private volatile int _handled;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    @XO0OX.XO
    public final Throwable f30502oIX0oI;

    public xxX(@OXOo.OOXIXo Throwable th, boolean z) {
        this.f30502oIX0oI = th;
        this._handled = z ? 1 : 0;
    }

    public final boolean II0xO0() {
        return f30501II0xO0.compareAndSet(this, 0, 1);
    }

    public final boolean oIX0oI() {
        if (f30501II0xO0.get(this) != 0) {
            return true;
        }
        return false;
    }

    @OXOo.OOXIXo
    public String toString() {
        return OI0.oIX0oI(this) + '[' + this.f30502oIX0oI + ']';
    }

    public /* synthetic */ xxX(Throwable th, boolean z, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(th, (i & 2) != 0 ? false : z);
    }
}
