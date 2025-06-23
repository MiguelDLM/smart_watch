package androidx.collection;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;

public final class LongLongPair {
    private final long first;
    private final long second;

    public LongLongPair(long j, long j2) {
        this.first = j;
        this.second = j2;
    }

    public final long component1() {
        return getFirst();
    }

    public final long component2() {
        return getSecond();
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (!(obj instanceof LongLongPair)) {
            return false;
        }
        LongLongPair longLongPair = (LongLongPair) obj;
        if (longLongPair.first == this.first && longLongPair.second == this.second) {
            return true;
        }
        return false;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getSecond() {
        return this.second;
    }

    public int hashCode() {
        return oIX0oI.oIX0oI(this.first) ^ oIX0oI.oIX0oI(this.second);
    }

    @OOXIXo
    public String toString() {
        return HexStringBuilder.COMMENT_BEGIN_CHAR + this.first + ", " + this.second + HexStringBuilder.COMMENT_END_CHAR;
    }
}
