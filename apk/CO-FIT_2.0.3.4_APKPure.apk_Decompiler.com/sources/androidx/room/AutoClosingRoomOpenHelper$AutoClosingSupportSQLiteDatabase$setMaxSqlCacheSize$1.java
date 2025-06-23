package androidx.room;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaxSqlCacheSize$1 extends Lambda implements oOoXoXO<SupportSQLiteDatabase, Object> {
    final /* synthetic */ int $cacheSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaxSqlCacheSize$1(int i) {
        super(1);
        this.$cacheSize = i;
    }

    @OXOo.oOoXoXO
    public final Object invoke(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        supportSQLiteDatabase.setMaxSqlCacheSize(this.$cacheSize);
        return null;
    }
}
