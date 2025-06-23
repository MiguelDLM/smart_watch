package androidx.room;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2 extends Lambda implements oOoXoXO<SupportSQLiteDatabase, Object> {
    final /* synthetic */ long $numBytes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2(long j) {
        super(1);
        this.$numBytes = j;
    }

    @OXOo.oOoXoXO
    public final Object invoke(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        supportSQLiteDatabase.setPageSize(this.$numBytes);
        return null;
    }
}
