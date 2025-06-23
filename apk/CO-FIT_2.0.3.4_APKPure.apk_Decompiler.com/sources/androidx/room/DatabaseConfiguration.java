package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.huawei.openalliance.ad.constant.bn;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.XX;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

public class DatabaseConfiguration {
    @XO
    public final boolean allowDestructiveMigrationOnDowngrade;
    @XO
    public final boolean allowMainThreadQueries;
    @XO
    @OOXIXo
    public final List<AutoMigrationSpec> autoMigrationSpecs;
    @XO
    @oOoXoXO
    public final List<RoomDatabase.Callback> callbacks;
    @XO
    @OOXIXo
    public final Context context;
    @XO
    @oOoXoXO
    public final String copyFromAssetPath;
    @XO
    @oOoXoXO
    public final File copyFromFile;
    @XO
    @oOoXoXO
    public final Callable<InputStream> copyFromInputStream;
    @XO
    @OOXIXo
    public final RoomDatabase.JournalMode journalMode;
    @XO
    @OOXIXo
    public final RoomDatabase.MigrationContainer migrationContainer;
    @oOoXoXO
    private final Set<Integer> migrationNotRequiredFrom;
    @XO
    public final boolean multiInstanceInvalidation;
    @XO
    @oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final Intent multiInstanceInvalidationServiceIntent;
    @XO
    @oOoXoXO
    public final String name;
    @XO
    @oOoXoXO
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    @XO
    @OOXIXo
    public final Executor queryExecutor;
    @XO
    public final boolean requireMigration;
    @XO
    @OOXIXo
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    @XO
    @OOXIXo
    public final Executor transactionExecutor;
    @XO
    @OOXIXo
    public final List<Object> typeConverters;

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@OOXIXo Context context2, @oOoXoXO String str, @OOXIXo SupportSQLiteOpenHelper.Factory factory, @OOXIXo RoomDatabase.MigrationContainer migrationContainer2, @oOoXoXO List<? extends RoomDatabase.Callback> list, boolean z, @OOXIXo RoomDatabase.JournalMode journalMode2, @OOXIXo Executor executor, @OOXIXo Executor executor2, @oOoXoXO Intent intent, boolean z2, boolean z3, @oOoXoXO Set<Integer> set, @oOoXoXO String str2, @oOoXoXO File file, @oOoXoXO Callable<InputStream> callable, @oOoXoXO RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2, @OOXIXo List<? extends Object> list2, @OOXIXo List<? extends AutoMigrationSpec> list3) {
        RoomDatabase.JournalMode journalMode3 = journalMode2;
        Executor executor3 = executor;
        Executor executor4 = executor2;
        Intent intent2 = intent;
        List<? extends Object> list4 = list2;
        List<? extends AutoMigrationSpec> list5 = list3;
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(factory, "sqliteOpenHelperFactory");
        IIX0o.x0xO0oo(migrationContainer2, "migrationContainer");
        IIX0o.x0xO0oo(journalMode3, "journalMode");
        IIX0o.x0xO0oo(executor3, "queryExecutor");
        IIX0o.x0xO0oo(executor4, "transactionExecutor");
        IIX0o.x0xO0oo(list4, "typeConverters");
        IIX0o.x0xO0oo(list5, "autoMigrationSpecs");
        this.context = context2;
        this.name = str;
        this.sqliteOpenHelperFactory = factory;
        this.migrationContainer = migrationContainer2;
        this.callbacks = list;
        this.allowMainThreadQueries = z;
        this.journalMode = journalMode3;
        this.queryExecutor = executor3;
        this.transactionExecutor = executor4;
        this.multiInstanceInvalidationServiceIntent = intent2;
        this.requireMigration = z2;
        this.allowDestructiveMigrationOnDowngrade = z3;
        this.migrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
        this.typeConverters = list4;
        this.autoMigrationSpecs = list5;
        this.multiInstanceInvalidation = intent2 != null;
    }

    public boolean isMigrationRequired(int i, int i2) {
        if ((i > i2 && this.allowDestructiveMigrationOnDowngrade) || !this.requireMigration) {
            return false;
        }
        Set<Integer> set = this.migrationNotRequiredFrom;
        if (set == null || !set.contains(Integer.valueOf(i))) {
            return true;
        }
        return false;
    }

    @kotlin.OOXIXo(message = "Use [isMigrationRequired(int, int)] which takes\n      [allowDestructiveMigrationOnDowngrade] into account.", replaceWith = @XX(expression = "isMigrationRequired(version, version + 1)", imports = {}))
    public boolean isMigrationRequiredFrom(int i) {
        return isMigrationRequired(i, i + 1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@OOXIXo Context context2, @oOoXoXO String str, @OOXIXo SupportSQLiteOpenHelper.Factory factory, @OOXIXo RoomDatabase.MigrationContainer migrationContainer2, @oOoXoXO List<? extends RoomDatabase.Callback> list, boolean z, @OOXIXo RoomDatabase.JournalMode journalMode2, @OOXIXo Executor executor, boolean z2, @oOoXoXO Set<Integer> set) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor, (Intent) null, z2, false, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<? extends Object>) CollectionsKt__CollectionsKt.ooXIXxIX(), (List<? extends AutoMigrationSpec>) CollectionsKt__CollectionsKt.ooXIXxIX());
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(factory, "sqliteOpenHelperFactory");
        IIX0o.x0xO0oo(migrationContainer2, "migrationContainer");
        IIX0o.x0xO0oo(journalMode2, "journalMode");
        IIX0o.x0xO0oo(executor, "queryExecutor");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @kotlin.XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(@OXOo.OOXIXo android.content.Context r21, @OXOo.oOoXoXO java.lang.String r22, @OXOo.OOXIXo androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, @OXOo.OOXIXo androidx.room.RoomDatabase.MigrationContainer r24, @OXOo.oOoXoXO java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, @OXOo.OOXIXo androidx.room.RoomDatabase.JournalMode r27, @OXOo.OOXIXo java.util.concurrent.Executor r28, @OXOo.OOXIXo java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, @OXOo.oOoXoXO java.util.Set<java.lang.Integer> r33) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r0)
            if (r30 == 0) goto L_0x0035
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0033:
            r10 = r0
            goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x0033
        L_0x0037:
            java.util.List r18 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            java.util.List r19 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            r16 = 0
            r17 = 0
            r14 = 0
            r15 = 0
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @kotlin.XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(@OXOo.OOXIXo android.content.Context r21, @OXOo.oOoXoXO java.lang.String r22, @OXOo.OOXIXo androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, @OXOo.OOXIXo androidx.room.RoomDatabase.MigrationContainer r24, @OXOo.oOoXoXO java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, @OXOo.OOXIXo androidx.room.RoomDatabase.JournalMode r27, @OXOo.OOXIXo java.util.concurrent.Executor r28, @OXOo.OOXIXo java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, @OXOo.oOoXoXO java.util.Set<java.lang.Integer> r33, @OXOo.oOoXoXO java.lang.String r34, @OXOo.oOoXoXO java.io.File r35) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r0)
            if (r30 == 0) goto L_0x0035
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0033:
            r10 = r0
            goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x0033
        L_0x0037:
            java.util.List r18 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            java.util.List r19 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            r16 = 0
            r17 = 0
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @kotlin.XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(@OXOo.OOXIXo android.content.Context r21, @OXOo.oOoXoXO java.lang.String r22, @OXOo.OOXIXo androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, @OXOo.OOXIXo androidx.room.RoomDatabase.MigrationContainer r24, @OXOo.oOoXoXO java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, @OXOo.OOXIXo androidx.room.RoomDatabase.JournalMode r27, @OXOo.OOXIXo java.util.concurrent.Executor r28, @OXOo.OOXIXo java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, @OXOo.oOoXoXO java.util.Set<java.lang.Integer> r33, @OXOo.oOoXoXO java.lang.String r34, @OXOo.oOoXoXO java.io.File r35, @OXOo.oOoXoXO java.util.concurrent.Callable<java.io.InputStream> r36) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r0)
            if (r30 == 0) goto L_0x0035
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0033:
            r10 = r0
            goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x0033
        L_0x0037:
            java.util.List r18 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            java.util.List r19 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            r17 = 0
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @kotlin.XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(@OXOo.OOXIXo android.content.Context r21, @OXOo.oOoXoXO java.lang.String r22, @OXOo.OOXIXo androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, @OXOo.OOXIXo androidx.room.RoomDatabase.MigrationContainer r24, @OXOo.oOoXoXO java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, @OXOo.OOXIXo androidx.room.RoomDatabase.JournalMode r27, @OXOo.OOXIXo java.util.concurrent.Executor r28, @OXOo.OOXIXo java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, @OXOo.oOoXoXO java.util.Set<java.lang.Integer> r33, @OXOo.oOoXoXO java.lang.String r34, @OXOo.oOoXoXO java.io.File r35, @OXOo.oOoXoXO java.util.concurrent.Callable<java.io.InputStream> r36, @OXOo.oOoXoXO androidx.room.RoomDatabase.PrepackagedDatabaseCallback r37) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r0)
            if (r30 == 0) goto L_0x0035
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0033:
            r10 = r0
            goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x0033
        L_0x0037:
            java.util.List r18 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            java.util.List r19 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r17 = r37
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @kotlin.XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(@OXOo.OOXIXo android.content.Context r21, @OXOo.oOoXoXO java.lang.String r22, @OXOo.OOXIXo androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, @OXOo.OOXIXo androidx.room.RoomDatabase.MigrationContainer r24, @OXOo.oOoXoXO java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, @OXOo.OOXIXo androidx.room.RoomDatabase.JournalMode r27, @OXOo.OOXIXo java.util.concurrent.Executor r28, @OXOo.OOXIXo java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, @OXOo.oOoXoXO java.util.Set<java.lang.Integer> r33, @OXOo.oOoXoXO java.lang.String r34, @OXOo.oOoXoXO java.io.File r35, @OXOo.oOoXoXO java.util.concurrent.Callable<java.io.InputStream> r36, @OXOo.oOoXoXO androidx.room.RoomDatabase.PrepackagedDatabaseCallback r37, @OXOo.OOXIXo java.util.List<? extends java.lang.Object> r38) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r0)
            java.lang.String r0 = "typeConverters"
            r15 = r38
            kotlin.jvm.internal.IIX0o.x0xO0oo(r15, r0)
            if (r30 == 0) goto L_0x003c
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x003a:
            r10 = r0
            goto L_0x003e
        L_0x003c:
            r0 = 0
            goto L_0x003a
        L_0x003e:
            java.util.List r19 = kotlin.collections.CollectionsKt__CollectionsKt.ooXIXxIX()
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback, java.util.List):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @kotlin.XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(@OXOo.OOXIXo android.content.Context r21, @OXOo.oOoXoXO java.lang.String r22, @OXOo.OOXIXo androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, @OXOo.OOXIXo androidx.room.RoomDatabase.MigrationContainer r24, @OXOo.oOoXoXO java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, @OXOo.OOXIXo androidx.room.RoomDatabase.JournalMode r27, @OXOo.OOXIXo java.util.concurrent.Executor r28, @OXOo.OOXIXo java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, @OXOo.oOoXoXO java.util.Set<java.lang.Integer> r33, @OXOo.oOoXoXO java.lang.String r34, @OXOo.oOoXoXO java.io.File r35, @OXOo.oOoXoXO java.util.concurrent.Callable<java.io.InputStream> r36, @OXOo.oOoXoXO androidx.room.RoomDatabase.PrepackagedDatabaseCallback r37, @OXOo.OOXIXo java.util.List<? extends java.lang.Object> r38, @OXOo.OOXIXo java.util.List<? extends androidx.room.migration.AutoMigrationSpec> r39) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.IIX0o.x0xO0oo(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r0)
            java.lang.String r0 = "typeConverters"
            r15 = r38
            kotlin.jvm.internal.IIX0o.x0xO0oo(r15, r0)
            java.lang.String r0 = "autoMigrationSpecs"
            r14 = r39
            kotlin.jvm.internal.IIX0o.x0xO0oo(r14, r0)
            if (r30 == 0) goto L_0x0043
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0041:
            r10 = r0
            goto L_0x0045
        L_0x0043:
            r0 = 0
            goto L_0x0041
        L_0x0045:
            r17 = 0
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r18 = r38
            r19 = r39
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback, java.util.List, java.util.List):void");
    }
}
