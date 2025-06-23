package androidx.work.impl.utils;

import OXOo.OOXIXo;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Preference;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;

public final class IdGeneratorKt {
    public static final int INITIAL_ID = 0;
    @OOXIXo
    public static final String NEXT_ALARM_MANAGER_ID_KEY = "next_alarm_manager_id";
    @OOXIXo
    public static final String NEXT_JOB_SCHEDULER_ID_KEY = "next_job_scheduler_id";
    @OOXIXo
    public static final String PREFERENCE_FILE_KEY = "androidx.work.util.id";

    public static final void migrateLegacyIdGenerator(@OOXIXo Context context, @OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(context, bn.f.o);
        IIX0o.x0xO0oo(supportSQLiteDatabase, "sqLiteDatabase");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE_KEY, 0);
        if (sharedPreferences.contains(NEXT_JOB_SCHEDULER_ID_KEY) || sharedPreferences.contains(NEXT_JOB_SCHEDULER_ID_KEY)) {
            int i = sharedPreferences.getInt(NEXT_JOB_SCHEDULER_ID_KEY, 0);
            int i2 = sharedPreferences.getInt(NEXT_ALARM_MANAGER_ID_KEY, 0);
            supportSQLiteDatabase.beginTransaction();
            try {
                supportSQLiteDatabase.execSQL(PreferenceUtils.INSERT_PREFERENCE, new Object[]{NEXT_JOB_SCHEDULER_ID_KEY, Integer.valueOf(i)});
                supportSQLiteDatabase.execSQL(PreferenceUtils.INSERT_PREFERENCE, new Object[]{NEXT_ALARM_MANAGER_ID_KEY, Integer.valueOf(i2)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final int nextId(WorkDatabase workDatabase, String str) {
        int i;
        Long longValue = workDatabase.preferenceDao().getLongValue(str);
        int i2 = 0;
        if (longValue != null) {
            i = (int) longValue.longValue();
        } else {
            i = 0;
        }
        if (i != Integer.MAX_VALUE) {
            i2 = i + 1;
        }
        updatePreference(workDatabase, str, i2);
        return i;
    }

    /* access modifiers changed from: private */
    public static final void updatePreference(WorkDatabase workDatabase, String str, int i) {
        workDatabase.preferenceDao().insertPreference(new Preference(str, Long.valueOf((long) i)));
    }
}
