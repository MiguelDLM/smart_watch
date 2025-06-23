package X0;

import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public class oIX0oI implements Iterable<Character>, OI0IXox.oIX0oI {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final C0048oIX0oI f3201Oxx0xo = new C0048oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final int f3202IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final char f3203Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final char f3204XO;

    /* renamed from: X0.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0048oIX0oI {
        public /* synthetic */ C0048oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final oIX0oI oIX0oI(char c, char c2, int i) {
            return new oIX0oI(c, c2, i);
        }

        public C0048oIX0oI() {
        }
    }

    public oIX0oI(char c, char c2, int i) {
        if (i != 0) {
            if (i != Integer.MIN_VALUE) {
                this.f3204XO = c;
                this.f3203Oo = (char) xx0o0O.x0XOIxOo.I0Io(c, c2, i);
                this.f3202IXxxXO = i;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    @Override // java.lang.Iterable
    @OXOo.OOXIXo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public kotlin.collections.IXxxXO iterator() {
        return new II0xO0(this.f3204XO, this.f3203Oo, this.f3202IXxxXO);
    }

    public final char X0o0xo() {
        return this.f3203Oo;
    }

    public final int XO() {
        return this.f3202IXxxXO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof oIX0oI) {
            if (!isEmpty() || !((oIX0oI) obj).isEmpty()) {
                oIX0oI oix0oi = (oIX0oI) obj;
                if (this.f3204XO != oix0oi.f3204XO || this.f3203Oo != oix0oi.f3203Oo || this.f3202IXxxXO != oix0oi.f3202IXxxXO) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3204XO * 31) + this.f3203Oo) * 31) + this.f3202IXxxXO;
    }

    public boolean isEmpty() {
        if (this.f3202IXxxXO > 0) {
            if (IIX0o.oI0IIXIo(this.f3204XO, this.f3203Oo) <= 0) {
                return false;
            }
        } else if (IIX0o.oI0IIXIo(this.f3204XO, this.f3203Oo) >= 0) {
            return false;
        }
        return true;
    }

    public final char oxoX() {
        return this.f3204XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f3202IXxxXO > 0) {
            sb = new StringBuilder();
            sb.append(this.f3204XO);
            sb.append("..");
            sb.append(this.f3203Oo);
            sb.append(" step ");
            i = this.f3202IXxxXO;
        } else {
            sb = new StringBuilder();
            sb.append(this.f3204XO);
            sb.append(" downTo ");
            sb.append(this.f3203Oo);
            sb.append(" step ");
            i = -this.f3202IXxxXO;
        }
        sb.append(i);
        return sb.toString();
    }
}
