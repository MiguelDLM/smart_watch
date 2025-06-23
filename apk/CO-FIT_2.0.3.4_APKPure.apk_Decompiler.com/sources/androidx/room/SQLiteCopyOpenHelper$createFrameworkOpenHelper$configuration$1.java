package androidx.room;

import OXOo.OOXIXo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.facebook.appevents.UserDataStore;
import kotlin.jvm.internal.IIX0o;

public final class SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1 extends SupportSQLiteOpenHelper.Callback {
    final /* synthetic */ int $version;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1(int i, int i2) {
        super(i2);
        this.$version = i;
    }

    public void onCreate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
    }

    public void onOpen(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        int i = this.$version;
        if (i < 1) {
            supportSQLiteDatabase.setVersion(i);
        }
    }

    public void onUpgrade(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
    }
}
