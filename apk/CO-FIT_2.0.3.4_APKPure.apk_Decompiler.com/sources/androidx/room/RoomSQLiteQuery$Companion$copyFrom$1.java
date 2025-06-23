package androidx.room;

import OXOo.OOXIXo;
import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.jvm.internal.IIX0o;

public final class RoomSQLiteQuery$Companion$copyFrom$1 implements SupportSQLiteProgram {
    private final /* synthetic */ RoomSQLiteQuery $$delegate_0;

    public RoomSQLiteQuery$Companion$copyFrom$1(RoomSQLiteQuery roomSQLiteQuery) {
        this.$$delegate_0 = roomSQLiteQuery;
    }

    public void bindBlob(int i, @OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "value");
        this.$$delegate_0.bindBlob(i, bArr);
    }

    public void bindDouble(int i, double d) {
        this.$$delegate_0.bindDouble(i, d);
    }

    public void bindLong(int i, long j) {
        this.$$delegate_0.bindLong(i, j);
    }

    public void bindNull(int i) {
        this.$$delegate_0.bindNull(i);
    }

    public void bindString(int i, @OOXIXo String str) {
        IIX0o.x0xO0oo(str, "value");
        this.$$delegate_0.bindString(i, str);
    }

    public void clearBindings() {
        this.$$delegate_0.clearBindings();
    }

    public void close() {
        this.$$delegate_0.close();
    }
}
