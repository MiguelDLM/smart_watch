package androidx.work.impl;

import OXOo.OOXIXo;
import android.content.Context;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.utils.IdGeneratorKt;
import androidx.work.impl.utils.PreferenceUtils;
import com.facebook.appevents.UserDataStore;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;

public final class WorkMigration9To10 extends Migration {
    @OOXIXo
    private final Context context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WorkMigration9To10(@OOXIXo Context context2) {
        super(9, 10);
        IIX0o.x0xO0oo(context2, bn.f.o);
        this.context = context2;
    }

    public void migrate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        supportSQLiteDatabase.execSQL(PreferenceUtils.CREATE_PREFERENCE);
        PreferenceUtils.migrateLegacyPreferences(this.context, supportSQLiteDatabase);
        IdGeneratorKt.migrateLegacyIdGenerator(this.context, supportSQLiteDatabase);
    }
}
