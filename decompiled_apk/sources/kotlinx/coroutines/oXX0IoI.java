package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;

/* loaded from: classes6.dex */
public final class oXX0IoI implements Oox.oOoXoXO<Throwable, kotlin.oXIO0o0XI> {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicIntegerFieldUpdater f30346Oxx0xo = AtomicIntegerFieldUpdater.newUpdater(oXX0IoI.class, "_state");

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public I0oOIX f30347IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final Thread f30348Oo = Thread.currentThread();

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final oXIO0o0XI f30349XO;

    @XO0OX.o00
    private volatile int _state;

    public oXX0IoI(@OXOo.OOXIXo oXIO0o0XI oxio0o0xi) {
        this.f30349XO = oxio0o0xi;
    }

    private final void oxoX(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Oox.oOoXoXO<? super Integer, kotlin.oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    public void I0Io(@OXOo.oOoXoXO Throwable th) {
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = f30346Oxx0xo;
        do {
            i = atomicIntegerFieldUpdater2.get(this);
            if (i != 0) {
                if (i != 1 && i != 2 && i != 3) {
                    II0xO0(i);
                    throw new KotlinNothingValueException();
                }
                return;
            }
            atomicIntegerFieldUpdater = f30346Oxx0xo;
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 2));
        this.f30348Oo.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
    }

    public final Void II0xO0(int i) {
        throw new IllegalStateException(("Illegal state " + i).toString());
    }

    public final void X0o0xo() {
        int i;
        this.f30347IXxxXO = this.f30349XO.O0xOxO(true, true, this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30346Oxx0xo;
        do {
            i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 2 && i != 3) {
                    II0xO0(i);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!f30346Oxx0xo.compareAndSet(this, i, 0));
    }

    @Override // Oox.oOoXoXO
    public /* bridge */ /* synthetic */ kotlin.oXIO0o0XI invoke(Throwable th) {
        I0Io(th);
        return kotlin.oXIO0o0XI.f29392oIX0oI;
    }

    public final void oIX0oI() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f30346Oxx0xo;
        while (true) {
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i != 2) {
                    if (i == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        II0xO0(i);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f30346Oxx0xo.compareAndSet(this, i, 1)) {
                I0oOIX i0oOIX = this.f30347IXxxXO;
                if (i0oOIX != null) {
                    i0oOIX.dispose();
                    return;
                }
                return;
            }
        }
    }
}
