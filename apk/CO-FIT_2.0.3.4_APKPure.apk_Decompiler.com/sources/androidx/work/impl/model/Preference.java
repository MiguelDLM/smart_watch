package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Entity
public final class Preference {
    @ColumnInfo(name = "key")
    @OOXIXo
    @PrimaryKey
    private final String key;
    @ColumnInfo(name = "long_value")
    @oOoXoXO
    private final Long value;

    public Preference(@OOXIXo String str, @oOoXoXO Long l) {
        IIX0o.x0xO0oo(str, "key");
        this.key = str;
        this.value = l;
    }

    public static /* synthetic */ Preference copy$default(Preference preference, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = preference.key;
        }
        if ((i & 2) != 0) {
            l = preference.value;
        }
        return preference.copy(str, l);
    }

    @OOXIXo
    public final String component1() {
        return this.key;
    }

    @oOoXoXO
    public final Long component2() {
        return this.value;
    }

    @OOXIXo
    public final Preference copy(@OOXIXo String str, @oOoXoXO Long l) {
        IIX0o.x0xO0oo(str, "key");
        return new Preference(str, l);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Preference)) {
            return false;
        }
        Preference preference = (Preference) obj;
        return IIX0o.Oxx0IOOO(this.key, preference.key) && IIX0o.Oxx0IOOO(this.value, preference.value);
    }

    @OOXIXo
    public final String getKey() {
        return this.key;
    }

    @oOoXoXO
    public final Long getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = this.key.hashCode() * 31;
        Long l = this.value;
        return hashCode + (l == null ? 0 : l.hashCode());
    }

    @OOXIXo
    public String toString() {
        return "Preference(key=" + this.key + ", value=" + this.value + HexStringBuilder.COMMENT_END_CHAR;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Preference(@OOXIXo String str, boolean z) {
        this(str, Long.valueOf(z ? 1 : 0));
        IIX0o.x0xO0oo(str, "key");
    }
}
