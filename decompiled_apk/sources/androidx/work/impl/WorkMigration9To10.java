package androidx.work.impl;

import android.content.Context;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.utils.IdGeneratorKt;
import androidx.work.impl.utils.PreferenceUtils;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class WorkMigration9To10 extends Migration {

    @OXOo.OOXIXo
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkMigration9To10(@OXOo.OOXIXo Context context) {
        super(9, 10);
        IIX0o.x0xO0oo(context, "context");
        this.context = context;
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@OXOo.OOXIXo SupportSQLiteDatabase db) {
        IIX0o.x0xO0oo(db, "db");
        db.execSQL(PreferenceUtils.CREATE_PREFERENCE);
        PreferenceUtils.migrateLegacyPreferences(this.context, db);
        IdGeneratorKt.migrateLegacyIdGenerator(this.context, db);
    }
}
