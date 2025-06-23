package androidx.work.impl;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.utils.PreferenceUtils;
import com.facebook.appevents.UserDataStore;
import kotlin.jvm.internal.IIX0o;

public final class RescheduleMigration extends Migration {
    @OOXIXo
    private final Context mContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RescheduleMigration(@OOXIXo Context context, int i, int i2) {
        super(i, i2);
        IIX0o.x0xO0oo(context, "mContext");
        this.mContext = context;
    }

    @OOXIXo
    public final Context getMContext() {
        return this.mContext;
    }

    public void migrate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        if (this.endVersion >= 10) {
            supportSQLiteDatabase.execSQL(PreferenceUtils.INSERT_PREFERENCE, new Object[]{PreferenceUtils.KEY_RESCHEDULE_NEEDED, 1});
            return;
        }
        this.mContext.getSharedPreferences(PreferenceUtils.PREFERENCES_FILE_NAME, 0).edit().putBoolean(PreferenceUtils.KEY_RESCHEDULE_NEEDED, true).apply();
    }
}
