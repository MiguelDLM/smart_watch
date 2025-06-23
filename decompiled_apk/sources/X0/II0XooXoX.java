package X0;

import X0.Oxx0xo;
import java.lang.Comparable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public class II0XooXoX<T extends Comparable<? super T>> implements Oxx0xo<T> {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final T f3171Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final T f3172XO;

    public II0XooXoX(@OXOo.OOXIXo T start, @OXOo.OOXIXo T endExclusive) {
        IIX0o.x0xO0oo(start, "start");
        IIX0o.x0xO0oo(endExclusive, "endExclusive");
        this.f3172XO = start;
        this.f3171Oo = endExclusive;
    }

    @Override // X0.Oxx0xo
    @OXOo.OOXIXo
    public T II0xO0() {
        return this.f3171Oo;
    }

    @Override // X0.Oxx0xo
    public boolean contains(@OXOo.OOXIXo T t) {
        return Oxx0xo.oIX0oI.oIX0oI(this, t);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof II0XooXoX) {
            if (!isEmpty() || !((II0XooXoX) obj).isEmpty()) {
                II0XooXoX iI0XooXoX = (II0XooXoX) obj;
                if (!IIX0o.Oxx0IOOO(getStart(), iI0XooXoX.getStart()) || !IIX0o.Oxx0IOOO(II0xO0(), iI0XooXoX.II0xO0())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // X0.Oxx0xo
    @OXOo.OOXIXo
    public T getStart() {
        return this.f3172XO;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + II0xO0().hashCode();
    }

    @Override // X0.Oxx0xo
    public boolean isEmpty() {
        return Oxx0xo.oIX0oI.II0xO0(this);
    }

    @OXOo.OOXIXo
    public String toString() {
        return getStart() + "..<" + II0xO0();
    }
}
