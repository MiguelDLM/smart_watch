package androidx.room;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.facebook.appevents.UserDataStore;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Lambda;

public final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1 extends Lambda implements oOoXoXO<SupportSQLiteDatabase, T> {
    final /* synthetic */ oOoXoXO<SupportSQLiteStatement, T> $block;
    final /* synthetic */ AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement, oOoXoXO<? super SupportSQLiteStatement, ? extends T> oooxoxo) {
        super(1);
        this.this$0 = autoClosingSupportSqliteStatement;
        this.$block = oooxoxo;
    }

    public final T invoke(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        SupportSQLiteStatement compileStatement = supportSQLiteDatabase.compileStatement(this.this$0.sql);
        this.this$0.doBinds(compileStatement);
        return this.$block.invoke(compileStatement);
    }
}
