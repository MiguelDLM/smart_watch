package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.XX;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public class DatabaseConfiguration {

    @XO0OX.XO
    public final boolean allowDestructiveMigrationOnDowngrade;

    @XO0OX.XO
    public final boolean allowMainThreadQueries;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final List<AutoMigrationSpec> autoMigrationSpecs;

    @XO0OX.XO
    @OXOo.oOoXoXO
    public final List<RoomDatabase.Callback> callbacks;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final Context context;

    @XO0OX.XO
    @OXOo.oOoXoXO
    public final String copyFromAssetPath;

    @XO0OX.XO
    @OXOo.oOoXoXO
    public final File copyFromFile;

    @XO0OX.XO
    @OXOo.oOoXoXO
    public final Callable<InputStream> copyFromInputStream;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final RoomDatabase.JournalMode journalMode;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final RoomDatabase.MigrationContainer migrationContainer;

    @OXOo.oOoXoXO
    private final Set<Integer> migrationNotRequiredFrom;

    @XO0OX.XO
    public final boolean multiInstanceInvalidation;

    @XO0OX.XO
    @OXOo.oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final Intent multiInstanceInvalidationServiceIntent;

    @XO0OX.XO
    @OXOo.oOoXoXO
    public final String name;

    @XO0OX.XO
    @OXOo.oOoXoXO
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final Executor queryExecutor;

    @XO0OX.XO
    public final boolean requireMigration;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final Executor transactionExecutor;

    @OXOo.OOXIXo
    @XO0OX.XO
    public final List<Object> typeConverters;

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.OOXIXo SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @OXOo.OOXIXo RoomDatabase.MigrationContainer migrationContainer, @OXOo.oOoXoXO List<? extends RoomDatabase.Callback> list, boolean z, @OXOo.OOXIXo RoomDatabase.JournalMode journalMode, @OXOo.OOXIXo Executor queryExecutor, @OXOo.OOXIXo Executor transactionExecutor, @OXOo.oOoXoXO Intent intent, boolean z2, boolean z3, @OXOo.oOoXoXO Set<Integer> set, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO File file, @OXOo.oOoXoXO Callable<InputStream> callable, @OXOo.oOoXoXO RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @OXOo.OOXIXo List<? extends Object> typeConverters, @OXOo.OOXIXo List<? extends AutoMigrationSpec> autoMigrationSpecs) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        IIX0o.x0xO0oo(migrationContainer, "migrationContainer");
        IIX0o.x0xO0oo(journalMode, "journalMode");
        IIX0o.x0xO0oo(queryExecutor, "queryExecutor");
        IIX0o.x0xO0oo(transactionExecutor, "transactionExecutor");
        IIX0o.x0xO0oo(typeConverters, "typeConverters");
        IIX0o.x0xO0oo(autoMigrationSpecs, "autoMigrationSpecs");
        this.context = context;
        this.name = str;
        this.sqliteOpenHelperFactory = sqliteOpenHelperFactory;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = z;
        this.journalMode = journalMode;
        this.queryExecutor = queryExecutor;
        this.transactionExecutor = transactionExecutor;
        this.multiInstanceInvalidationServiceIntent = intent;
        this.requireMigration = z2;
        this.allowDestructiveMigrationOnDowngrade = z3;
        this.migrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.typeConverters = typeConverters;
        this.autoMigrationSpecs = autoMigrationSpecs;
        this.multiInstanceInvalidation = intent != null;
    }

    public boolean isMigrationRequired(int i, int i2) {
        if ((i > i2 && this.allowDestructiveMigrationOnDowngrade) || !this.requireMigration) {
            return false;
        }
        Set<Integer> set = this.migrationNotRequiredFrom;
        if (set != null && set.contains(Integer.valueOf(i))) {
            return false;
        }
        return true;
    }

    @kotlin.OOXIXo(message = "Use [isMigrationRequired(int, int)] which takes\n      [allowDestructiveMigrationOnDowngrade] into account.", replaceWith = @XX(expression = "isMigrationRequired(version, version + 1)", imports = {}))
    public boolean isMigrationRequiredFrom(int i) {
        return isMigrationRequired(i, i + 1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.OOXIXo SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @OXOo.OOXIXo RoomDatabase.MigrationContainer migrationContainer, @OXOo.oOoXoXO List<? extends RoomDatabase.Callback> list, boolean z, @OXOo.OOXIXo RoomDatabase.JournalMode journalMode, @OXOo.OOXIXo Executor queryExecutor, boolean z2, @OXOo.oOoXoXO Set<Integer> set) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z, journalMode, queryExecutor, queryExecutor, (Intent) null, z2, false, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<? extends Object>) CollectionsKt__CollectionsKt.ooXIXxIX(), (List<? extends AutoMigrationSpec>) CollectionsKt__CollectionsKt.ooXIXxIX());
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        IIX0o.x0xO0oo(migrationContainer, "migrationContainer");
        IIX0o.x0xO0oo(journalMode, "journalMode");
        IIX0o.x0xO0oo(queryExecutor, "queryExecutor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.OOXIXo SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @OXOo.OOXIXo RoomDatabase.MigrationContainer migrationContainer, @OXOo.oOoXoXO List<? extends RoomDatabase.Callback> list, boolean z, @OXOo.OOXIXo RoomDatabase.JournalMode journalMode, @OXOo.OOXIXo Executor queryExecutor, @OXOo.OOXIXo Executor transactionExecutor, boolean z2, boolean z3, boolean z4, @OXOo.oOoXoXO Set<Integer> set) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z, journalMode, queryExecutor, transactionExecutor, z2 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z3, z4, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<? extends Object>) CollectionsKt__CollectionsKt.ooXIXxIX(), (List<? extends AutoMigrationSpec>) CollectionsKt__CollectionsKt.ooXIXxIX());
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        IIX0o.x0xO0oo(migrationContainer, "migrationContainer");
        IIX0o.x0xO0oo(journalMode, "journalMode");
        IIX0o.x0xO0oo(queryExecutor, "queryExecutor");
        IIX0o.x0xO0oo(transactionExecutor, "transactionExecutor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.OOXIXo SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @OXOo.OOXIXo RoomDatabase.MigrationContainer migrationContainer, @OXOo.oOoXoXO List<? extends RoomDatabase.Callback> list, boolean z, @OXOo.OOXIXo RoomDatabase.JournalMode journalMode, @OXOo.OOXIXo Executor queryExecutor, @OXOo.OOXIXo Executor transactionExecutor, boolean z2, boolean z3, boolean z4, @OXOo.oOoXoXO Set<Integer> set, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO File file) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z, journalMode, queryExecutor, transactionExecutor, z2 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z3, z4, set, str2, file, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<? extends Object>) CollectionsKt__CollectionsKt.ooXIXxIX(), (List<? extends AutoMigrationSpec>) CollectionsKt__CollectionsKt.ooXIXxIX());
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        IIX0o.x0xO0oo(migrationContainer, "migrationContainer");
        IIX0o.x0xO0oo(journalMode, "journalMode");
        IIX0o.x0xO0oo(queryExecutor, "queryExecutor");
        IIX0o.x0xO0oo(transactionExecutor, "transactionExecutor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.OOXIXo SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @OXOo.OOXIXo RoomDatabase.MigrationContainer migrationContainer, @OXOo.oOoXoXO List<? extends RoomDatabase.Callback> list, boolean z, @OXOo.OOXIXo RoomDatabase.JournalMode journalMode, @OXOo.OOXIXo Executor queryExecutor, @OXOo.OOXIXo Executor transactionExecutor, boolean z2, boolean z3, boolean z4, @OXOo.oOoXoXO Set<Integer> set, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO File file, @OXOo.oOoXoXO Callable<InputStream> callable) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z, journalMode, queryExecutor, transactionExecutor, z2 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z3, z4, set, str2, file, callable, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<? extends Object>) CollectionsKt__CollectionsKt.ooXIXxIX(), (List<? extends AutoMigrationSpec>) CollectionsKt__CollectionsKt.ooXIXxIX());
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        IIX0o.x0xO0oo(migrationContainer, "migrationContainer");
        IIX0o.x0xO0oo(journalMode, "journalMode");
        IIX0o.x0xO0oo(queryExecutor, "queryExecutor");
        IIX0o.x0xO0oo(transactionExecutor, "transactionExecutor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.OOXIXo SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @OXOo.OOXIXo RoomDatabase.MigrationContainer migrationContainer, @OXOo.oOoXoXO List<? extends RoomDatabase.Callback> list, boolean z, @OXOo.OOXIXo RoomDatabase.JournalMode journalMode, @OXOo.OOXIXo Executor queryExecutor, @OXOo.OOXIXo Executor transactionExecutor, boolean z2, boolean z3, boolean z4, @OXOo.oOoXoXO Set<Integer> set, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO File file, @OXOo.oOoXoXO Callable<InputStream> callable, @OXOo.oOoXoXO RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z, journalMode, queryExecutor, transactionExecutor, z2 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z3, z4, set, str2, file, callable, prepackagedDatabaseCallback, (List<? extends Object>) CollectionsKt__CollectionsKt.ooXIXxIX(), (List<? extends AutoMigrationSpec>) CollectionsKt__CollectionsKt.ooXIXxIX());
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        IIX0o.x0xO0oo(migrationContainer, "migrationContainer");
        IIX0o.x0xO0oo(journalMode, "journalMode");
        IIX0o.x0xO0oo(queryExecutor, "queryExecutor");
        IIX0o.x0xO0oo(transactionExecutor, "transactionExecutor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.OOXIXo SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @OXOo.OOXIXo RoomDatabase.MigrationContainer migrationContainer, @OXOo.oOoXoXO List<? extends RoomDatabase.Callback> list, boolean z, @OXOo.OOXIXo RoomDatabase.JournalMode journalMode, @OXOo.OOXIXo Executor queryExecutor, @OXOo.OOXIXo Executor transactionExecutor, boolean z2, boolean z3, boolean z4, @OXOo.oOoXoXO Set<Integer> set, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO File file, @OXOo.oOoXoXO Callable<InputStream> callable, @OXOo.oOoXoXO RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @OXOo.OOXIXo List<? extends Object> typeConverters) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z, journalMode, queryExecutor, transactionExecutor, z2 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z3, z4, set, str2, file, callable, prepackagedDatabaseCallback, typeConverters, (List<? extends AutoMigrationSpec>) CollectionsKt__CollectionsKt.ooXIXxIX());
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        IIX0o.x0xO0oo(migrationContainer, "migrationContainer");
        IIX0o.x0xO0oo(journalMode, "journalMode");
        IIX0o.x0xO0oo(queryExecutor, "queryExecutor");
        IIX0o.x0xO0oo(transactionExecutor, "transactionExecutor");
        IIX0o.x0xO0oo(typeConverters, "typeConverters");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.OOXIXo(message = "This constructor is deprecated.", replaceWith = @XX(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO String str, @OXOo.OOXIXo SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @OXOo.OOXIXo RoomDatabase.MigrationContainer migrationContainer, @OXOo.oOoXoXO List<? extends RoomDatabase.Callback> list, boolean z, @OXOo.OOXIXo RoomDatabase.JournalMode journalMode, @OXOo.OOXIXo Executor queryExecutor, @OXOo.OOXIXo Executor transactionExecutor, boolean z2, boolean z3, boolean z4, @OXOo.oOoXoXO Set<Integer> set, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO File file, @OXOo.oOoXoXO Callable<InputStream> callable, @OXOo.oOoXoXO RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @OXOo.OOXIXo List<? extends Object> typeConverters, @OXOo.OOXIXo List<? extends AutoMigrationSpec> autoMigrationSpecs) {
        this(context, str, sqliteOpenHelperFactory, migrationContainer, list, z, journalMode, queryExecutor, transactionExecutor, z2 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z3, z4, set, str2, file, callable, (RoomDatabase.PrepackagedDatabaseCallback) null, typeConverters, autoMigrationSpecs);
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        IIX0o.x0xO0oo(migrationContainer, "migrationContainer");
        IIX0o.x0xO0oo(journalMode, "journalMode");
        IIX0o.x0xO0oo(queryExecutor, "queryExecutor");
        IIX0o.x0xO0oo(transactionExecutor, "transactionExecutor");
        IIX0o.x0xO0oo(typeConverters, "typeConverters");
        IIX0o.x0xO0oo(autoMigrationSpecs, "autoMigrationSpecs");
    }
}
