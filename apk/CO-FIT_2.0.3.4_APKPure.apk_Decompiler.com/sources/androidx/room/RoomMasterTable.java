package androidx.room;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class RoomMasterTable {
    @OOXIXo
    private static final String COLUMN_ID = "id";
    @OOXIXo
    private static final String COLUMN_IDENTITY_HASH = "identity_hash";
    @OOXIXo
    public static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)";
    @OOXIXo
    public static final String DEFAULT_ID = "42";
    @OOXIXo
    public static final RoomMasterTable INSTANCE = new RoomMasterTable();
    @OOXIXo
    public static final String NAME = "room_master_table";
    @OOXIXo
    public static final String READ_QUERY = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1";
    @OOXIXo
    public static final String TABLE_NAME = "room_master_table";

    private RoomMasterTable() {
    }

    @x0XOIxOo
    @OOXIXo
    public static final String createInsertQuery(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')";
    }
}
