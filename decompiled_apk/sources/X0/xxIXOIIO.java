package X0;

import X0.Oxx0IOOO;
import java.lang.Comparable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public class xxIXOIIO<T extends Comparable<? super T>> implements Oxx0IOOO<T> {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public final T f3229Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final T f3230XO;

    public xxIXOIIO(@OXOo.OOXIXo T start, @OXOo.OOXIXo T endInclusive) {
        IIX0o.x0xO0oo(start, "start");
        IIX0o.x0xO0oo(endInclusive, "endInclusive");
        this.f3230XO = start;
        this.f3229Oo = endInclusive;
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    public boolean contains(@OXOo.OOXIXo T t) {
        return Oxx0IOOO.oIX0oI.oIX0oI(this, t);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof xxIXOIIO) {
            if (!isEmpty() || !((xxIXOIIO) obj).isEmpty()) {
                xxIXOIIO xxixoiio = (xxIXOIIO) obj;
                if (!IIX0o.Oxx0IOOO(getStart(), xxixoiio.getStart()) || !IIX0o.Oxx0IOOO(getEndInclusive(), xxixoiio.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // X0.Oxx0IOOO
    @OXOo.OOXIXo
    public T getEndInclusive() {
        return this.f3229Oo;
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    @OXOo.OOXIXo
    public T getStart() {
        return this.f3230XO;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    public boolean isEmpty() {
        return Oxx0IOOO.oIX0oI.II0xO0(this);
    }

    @OXOo.OOXIXo
    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
