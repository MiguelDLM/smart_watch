package androidx.room;

import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class RoomMasterTable {

    @OXOo.OOXIXo
    private static final String COLUMN_ID = "id";

    @OXOo.OOXIXo
    private static final String COLUMN_IDENTITY_HASH = "identity_hash";

    @OXOo.OOXIXo
    public static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)";

    @OXOo.OOXIXo
    public static final String DEFAULT_ID = "42";

    @OXOo.OOXIXo
    public static final RoomMasterTable INSTANCE = new RoomMasterTable();

    @OXOo.OOXIXo
    public static final String NAME = "room_master_table";

    @OXOo.OOXIXo
    public static final String READ_QUERY = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1";

    @OXOo.OOXIXo
    public static final String TABLE_NAME = "room_master_table";

    private RoomMasterTable() {
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String createInsertQuery(@OXOo.OOXIXo String hash) {
        IIX0o.x0xO0oo(hash, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + hash + "')";
    }
}
