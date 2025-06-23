package kotlinx.coroutines.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.oXIO0o0XI;

/* loaded from: classes6.dex */
public class OxI<E> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final AtomicReferenceFieldUpdater f30260oIX0oI = AtomicReferenceFieldUpdater.newUpdater(OxI.class, Object.class, "_cur");

    @OXOo.oOoXoXO
    @XO0OX.o00
    private volatile Object _cur;

    public OxI(boolean z) {
        this._cur = new O0xOxO(8, z);
    }

    public final int I0Io() {
        return ((O0xOxO) f30260oIX0oI.get(this)).XO();
    }

    @OXOo.oOoXoXO
    public final E II0XooXoX() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30260oIX0oI;
        while (true) {
            O0xOxO o0xOxO = (O0xOxO) atomicReferenceFieldUpdater.get(this);
            E e = (E) o0xOxO.x0XOIxOo();
            if (e != O0xOxO.f30246oI0IIXIo) {
                return e;
            }
            androidx.concurrent.futures.oIX0oI.oIX0oI(f30260oIX0oI, this, o0xOxO, o0xOxO.ooOOo0oXI());
        }
    }

    public final void II0xO0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30260oIX0oI;
        while (true) {
            O0xOxO o0xOxO = (O0xOxO) atomicReferenceFieldUpdater.get(this);
            if (o0xOxO.oxoX()) {
                return;
            } else {
                androidx.concurrent.futures.oIX0oI.oIX0oI(f30260oIX0oI, this, o0xOxO, o0xOxO.ooOOo0oXI());
            }
        }
    }

    @OXOo.OOXIXo
    public final <R> List<R> Oxx0IOOO(@OXOo.OOXIXo Oox.oOoXoXO<? super E, ? extends R> oooxoxo) {
        return ((O0xOxO) f30260oIX0oI.get(this)).OOXIXo(oooxoxo);
    }

    public final boolean X0o0xo() {
        return ((O0xOxO) f30260oIX0oI.get(this)).II0XooXoX();
    }

    public final void XO(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Oox.oOoXoXO<Object, oXIO0o0XI> oooxoxo, Object obj) {
        while (true) {
            oooxoxo.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    public final boolean oIX0oI(@OXOo.OOXIXo E e) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30260oIX0oI;
        while (true) {
            O0xOxO o0xOxO = (O0xOxO) atomicReferenceFieldUpdater.get(this);
            int oIX0oI2 = o0xOxO.oIX0oI(e);
            if (oIX0oI2 == 0) {
                return true;
            }
            if (oIX0oI2 != 1) {
                if (oIX0oI2 == 2) {
                    return false;
                }
            } else {
                androidx.concurrent.futures.oIX0oI.oIX0oI(f30260oIX0oI, this, o0xOxO, o0xOxO.ooOOo0oXI());
            }
        }
    }

    public final boolean oxoX() {
        return ((O0xOxO) f30260oIX0oI.get(this)).Oxx0IOOO();
    }
}
