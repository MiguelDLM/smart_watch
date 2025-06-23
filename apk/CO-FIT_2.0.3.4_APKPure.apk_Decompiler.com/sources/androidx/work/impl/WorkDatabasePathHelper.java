package androidx.work.impl;

import OXOo.OOXIXo;
import X0.IIXOooo;
import XO0OX.x0XOIxOo;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import com.huawei.openalliance.ad.constant.bn;
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
public final class WorkDatabasePathHelper {
    @OOXIXo
    public static final WorkDatabasePathHelper INSTANCE = new WorkDatabasePathHelper();

    private WorkDatabasePathHelper() {
    }

    @RequiresApi(23)
    private final File getNoBackupPath(Context context) {
        return new File(Api21Impl.INSTANCE.getNoBackupFilesDir(context), WorkDatabasePathHelperKt.WORK_DATABASE_NAME);
    }

    @x0XOIxOo
    public static final void migrateDatabase(@OOXIXo Context context) {
        String str;
        IIX0o.x0xO0oo(context, bn.f.o);
        WorkDatabasePathHelper workDatabasePathHelper = INSTANCE;
        File defaultDatabasePath = workDatabasePathHelper.getDefaultDatabasePath(context);
        if (Build.VERSION.SDK_INT >= 23 && defaultDatabasePath.exists()) {
            Logger.get().debug(WorkDatabasePathHelperKt.TAG, "Migrating WorkDatabase to the no-backup directory");
            for (Map.Entry next : workDatabasePathHelper.migrationPaths(context).entrySet()) {
                File file = (File) next.getKey();
                File file2 = (File) next.getValue();
                if (file.exists()) {
                    if (file2.exists()) {
                        Logger.get().warning(WorkDatabasePathHelperKt.TAG, "Over-writing contents of " + file2);
                    }
                    if (file.renameTo(file2)) {
                        str = "Migrated " + file + "to " + file2;
                    } else {
                        str = "Renaming " + file + " to " + file2 + " failed";
                    }
                    Logger.get().debug(WorkDatabasePathHelperKt.TAG, str);
                }
            }
        }
    }

    @OOXIXo
    public final File getDatabasePath(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, bn.f.o);
        if (Build.VERSION.SDK_INT < 23) {
            return getDefaultDatabasePath(context);
        }
        return getNoBackupPath(context);
    }

    @OOXIXo
    public final File getDefaultDatabasePath(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, bn.f.o);
        File databasePath = context.getDatabasePath(WorkDatabasePathHelperKt.WORK_DATABASE_NAME);
        IIX0o.oO(databasePath, "context.getDatabasePath(WORK_DATABASE_NAME)");
        return databasePath;
    }

    @OOXIXo
    public final Map<File, File> migrationPaths(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, bn.f.o);
        if (Build.VERSION.SDK_INT < 23) {
            return o0.O0xOxO();
        }
        File defaultDatabasePath = getDefaultDatabasePath(context);
        File databasePath = getDatabasePath(context);
        String[] access$getDATABASE_EXTRA_FILES$p = WorkDatabasePathHelperKt.DATABASE_EXTRA_FILES;
        LinkedHashMap linkedHashMap = new LinkedHashMap(IIXOooo.OxxIIOOXO(OI0.xoIox(access$getDATABASE_EXTRA_FILES$p.length), 16));
        for (String str : access$getDATABASE_EXTRA_FILES$p) {
            Pair oIX0oI2 = Xo0.oIX0oI(new File(defaultDatabasePath.getPath() + str), new File(databasePath.getPath() + str));
            linkedHashMap.put(oIX0oI2.getFirst(), oIX0oI2.getSecond());
        }
        return o0.x0xO(linkedHashMap, Xo0.oIX0oI(defaultDatabasePath, databasePath));
    }
}
