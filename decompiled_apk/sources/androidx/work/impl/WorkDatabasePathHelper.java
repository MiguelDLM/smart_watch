package androidx.work.impl;

import X0.IIXOooo;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Xo0;
import kotlin.collections.OI0;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWorkDatabasePathHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WorkDatabasePathHelper.kt\nandroidx/work/impl/WorkDatabasePathHelper\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,122:1\n215#2,2:123\n8676#3,2:125\n9358#3,4:127\n*S KotlinDebug\n*F\n+ 1 WorkDatabasePathHelper.kt\nandroidx/work/impl/WorkDatabasePathHelper\n*L\n46#1:123,2\n75#1:125,2\n75#1:127,4\n*E\n"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class WorkDatabasePathHelper {

    @OXOo.OOXIXo
    public static final WorkDatabasePathHelper INSTANCE = new WorkDatabasePathHelper();

    private WorkDatabasePathHelper() {
    }

    @RequiresApi(23)
    private final File getNoBackupPath(Context context) {
        return new File(Api21Impl.INSTANCE.getNoBackupFilesDir(context), WorkDatabasePathHelperKt.WORK_DATABASE_NAME);
    }

    @XO0OX.x0XOIxOo
    public static final void migrateDatabase(@OXOo.OOXIXo Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        IIX0o.x0xO0oo(context, "context");
        WorkDatabasePathHelper workDatabasePathHelper = INSTANCE;
        File defaultDatabasePath = workDatabasePathHelper.getDefaultDatabasePath(context);
        if (Build.VERSION.SDK_INT >= 23 && defaultDatabasePath.exists()) {
            Logger logger = Logger.get();
            str = WorkDatabasePathHelperKt.TAG;
            logger.debug(str, "Migrating WorkDatabase to the no-backup directory");
            for (Map.Entry<File, File> entry : workDatabasePathHelper.migrationPaths(context).entrySet()) {
                File key = entry.getKey();
                File value = entry.getValue();
                if (key.exists()) {
                    if (value.exists()) {
                        Logger logger2 = Logger.get();
                        str4 = WorkDatabasePathHelperKt.TAG;
                        logger2.warning(str4, "Over-writing contents of " + value);
                    }
                    if (key.renameTo(value)) {
                        str2 = "Migrated " + key + "to " + value;
                    } else {
                        str2 = "Renaming " + key + " to " + value + " failed";
                    }
                    Logger logger3 = Logger.get();
                    str3 = WorkDatabasePathHelperKt.TAG;
                    logger3.debug(str3, str2);
                }
            }
        }
    }

    @OXOo.OOXIXo
    public final File getDatabasePath(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        if (Build.VERSION.SDK_INT < 23) {
            return getDefaultDatabasePath(context);
        }
        return getNoBackupPath(context);
    }

    @OXOo.OOXIXo
    public final File getDefaultDatabasePath(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        File databasePath = context.getDatabasePath(WorkDatabasePathHelperKt.WORK_DATABASE_NAME);
        IIX0o.oO(databasePath, "context.getDatabasePath(WORK_DATABASE_NAME)");
        return databasePath;
    }

    @OXOo.OOXIXo
    public final Map<File, File> migrationPaths(@OXOo.OOXIXo Context context) {
        String[] strArr;
        IIX0o.x0xO0oo(context, "context");
        if (Build.VERSION.SDK_INT >= 23) {
            File defaultDatabasePath = getDefaultDatabasePath(context);
            File databasePath = getDatabasePath(context);
            strArr = WorkDatabasePathHelperKt.DATABASE_EXTRA_FILES;
            LinkedHashMap linkedHashMap = new LinkedHashMap(IIXOooo.OxxIIOOXO(OI0.xoIox(strArr.length), 16));
            for (String str : strArr) {
                Pair oIX0oI2 = Xo0.oIX0oI(new File(defaultDatabasePath.getPath() + str), new File(databasePath.getPath() + str));
                linkedHashMap.put(oIX0oI2.getFirst(), oIX0oI2.getSecond());
            }
            return o0.x0xO(linkedHashMap, Xo0.oIX0oI(defaultDatabasePath, databasePath));
        }
        return o0.O0xOxO();
    }
}
