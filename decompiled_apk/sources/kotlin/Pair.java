package kotlin;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;

/* loaded from: classes6.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A a2, B b) {
        this.first = a2;
        this.second = b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair copy$default(Pair pair, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = pair.first;
        }
        if ((i & 2) != 0) {
            obj2 = pair.second;
        }
        return pair.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    @OXOo.OOXIXo
    public final Pair<A, B> copy(A a2, B b) {
        return new Pair<>(a2, b);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.first, pair.first) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.second, pair.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a2 = this.first;
        int hashCode = (a2 == null ? 0 : a2.hashCode()) * 31;
        B b = this.second;
        return hashCode + (b != null ? b.hashCode() : 0);
    }

    @OXOo.OOXIXo
    public String toString() {
        return HexStringBuilder.COMMENT_BEGIN_CHAR + this.first + ", " + this.second + HexStringBuilder.COMMENT_END_CHAR;
    }
}
