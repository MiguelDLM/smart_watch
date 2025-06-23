package androidx.room;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nRoomOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomOpenHelper.kt\nandroidx/room/RoomOpenHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 CursorUtil.kt\nandroidx/room/util/CursorUtil\n*L\n1#1,245:1\n1855#2,2:246\n145#3,7:248\n*S KotlinDebug\n*F\n+ 1 RoomOpenHelper.kt\nandroidx/room/RoomOpenHelper\n*L\n90#1:246,2\n137#1:248,7\n*E\n"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.oOoXoXO
    private DatabaseConfiguration configuration;

    @OXOo.OOXIXo
    private final Delegate delegate;

    @OXOo.OOXIXo
    private final String identityHash;

    @OXOo.OOXIXo
    private final String legacyHash;

    @XX({"SMAP\nRoomOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomOpenHelper.kt\nandroidx/room/RoomOpenHelper$Companion\n+ 2 CursorUtil.kt\nandroidx/room/util/CursorUtil\n*L\n1#1,245:1\n145#2,7:246\n145#2,7:253\n*S KotlinDebug\n*F\n+ 1 RoomOpenHelper.kt\nandroidx/room/RoomOpenHelper$Companion\n*L\n231#1:246,7\n239#1:253,7\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public final boolean hasEmptySchema$room_runtime_release(@OXOo.OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
            Cursor query = db.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                Cursor cursor = query;
                boolean z = false;
                if (cursor.moveToFirst()) {
                    if (cursor.getInt(0) == 0) {
                        z = true;
                    }
                }
                kotlin.io.II0xO0.oIX0oI(query, null);
                return z;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.II0xO0.oIX0oI(query, th);
                    throw th2;
                }
            }
        }

        public final boolean hasRoomMasterTable$room_runtime_release(@OXOo.OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
            Cursor query = db.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                Cursor cursor = query;
                boolean z = false;
                if (cursor.moveToFirst()) {
                    if (cursor.getInt(0) != 0) {
                        z = true;
                    }
                }
                kotlin.io.II0xO0.oIX0oI(query, null);
                return z;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.II0xO0.oIX0oI(query, th);
                    throw th2;
                }
            }
        }

        private Companion() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static abstract class Delegate {

        @XO0OX.XO
        public final int version;

        public Delegate(int i) {
            this.version = i;
        }

        public abstract void createAllTables(@OXOo.OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(@OXOo.OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(@OXOo.OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(@OXOo.OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);

        public void onPostMigrate(@OXOo.OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
        }

        public void onPreMigrate(@OXOo.OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
        }

        @OXOo.OOXIXo
        public ValidationResult onValidateSchema(@OXOo.OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
            validateMigration(db);
            return new ValidationResult(true, null);
        }

        @kotlin.OOXIXo(message = "Use [onValidateSchema(SupportSQLiteDatabase)]")
        public void validateMigration(@OXOo.OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public static class ValidationResult {

        @XO0OX.XO
        @OXOo.oOoXoXO
        public final String expectedFoundMsg;

        @XO0OX.XO
        public final boolean isValid;

        public ValidationResult(boolean z, @OXOo.oOoXoXO String str) {
            this.isValid = z;
            this.expectedFoundMsg = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(@OXOo.OOXIXo DatabaseConfiguration configuration, @OXOo.OOXIXo Delegate delegate, @OXOo.OOXIXo String identityHash, @OXOo.OOXIXo String legacyHash) {
        super(delegate.version);
        IIX0o.x0xO0oo(configuration, "configuration");
        IIX0o.x0xO0oo(delegate, "delegate");
        IIX0o.x0xO0oo(identityHash, "identityHash");
        IIX0o.x0xO0oo(legacyHash, "legacyHash");
        this.configuration = configuration;
        this.delegate = delegate;
        this.identityHash = identityHash;
        this.legacyHash = legacyHash;
    }

    private final void checkIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        String str;
        if (Companion.hasRoomMasterTable$room_runtime_release(supportSQLiteDatabase)) {
            Cursor query = supportSQLiteDatabase.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
            try {
                Cursor cursor = query;
                if (cursor.moveToFirst()) {
                    str = cursor.getString(0);
                } else {
                    str = null;
                }
                kotlin.io.II0xO0.oIX0oI(query, null);
                if (!IIX0o.Oxx0IOOO(this.identityHash, str) && !IIX0o.Oxx0IOOO(this.legacyHash, str)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.identityHash + ", found: " + str);
                }
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    kotlin.io.II0xO0.oIX0oI(query, th);
                    throw th2;
                }
            }
        }
        ValidationResult onValidateSchema = this.delegate.onValidateSchema(supportSQLiteDatabase);
        if (onValidateSchema.isValid) {
            this.delegate.onPostMigrate(supportSQLiteDatabase);
            updateIdentity(supportSQLiteDatabase);
        } else {
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
        }
    }

    private final void createMasterTableIfNotExists(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private final void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        createMasterTableIfNotExists(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(@OXOo.OOXIXo SupportSQLiteDatabase db) {
        IIX0o.x0xO0oo(db, "db");
        super.onConfigure(db);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(@OXOo.OOXIXo SupportSQLiteDatabase db) {
        IIX0o.x0xO0oo(db, "db");
        boolean hasEmptySchema$room_runtime_release = Companion.hasEmptySchema$room_runtime_release(db);
        this.delegate.createAllTables(db);
        if (!hasEmptySchema$room_runtime_release) {
            ValidationResult onValidateSchema = this.delegate.onValidateSchema(db);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
            }
        }
        updateIdentity(db);
        this.delegate.onCreate(db);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(@OXOo.OOXIXo SupportSQLiteDatabase db, int i, int i2) {
        IIX0o.x0xO0oo(db, "db");
        onUpgrade(db, i, i2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(@OXOo.OOXIXo SupportSQLiteDatabase db) {
        IIX0o.x0xO0oo(db, "db");
        super.onOpen(db);
        checkIdentity(db);
        this.delegate.onOpen(db);
        this.configuration = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(@OXOo.OOXIXo SupportSQLiteDatabase db, int i, int i2) {
        List<Migration> findMigrationPath;
        IIX0o.x0xO0oo(db, "db");
        DatabaseConfiguration databaseConfiguration = this.configuration;
        if (databaseConfiguration != null && (findMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(i, i2)) != null) {
            this.delegate.onPreMigrate(db);
            Iterator<T> it = findMigrationPath.iterator();
            while (it.hasNext()) {
                ((Migration) it.next()).migrate(db);
            }
            ValidationResult onValidateSchema = this.delegate.onValidateSchema(db);
            if (onValidateSchema.isValid) {
                this.delegate.onPostMigrate(db);
                updateIdentity(db);
                return;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg);
            }
        }
        DatabaseConfiguration databaseConfiguration2 = this.configuration;
        if (databaseConfiguration2 != null && !databaseConfiguration2.isMigrationRequired(i, i2)) {
            this.delegate.dropAllTables(db);
            this.delegate.createAllTables(db);
            return;
        }
        throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(@OXOo.OOXIXo DatabaseConfiguration configuration, @OXOo.OOXIXo Delegate delegate, @OXOo.OOXIXo String legacyHash) {
        this(configuration, delegate, "", legacyHash);
        IIX0o.x0xO0oo(configuration, "configuration");
        IIX0o.x0xO0oo(delegate, "delegate");
        IIX0o.x0xO0oo(legacyHash, "legacyHash");
    }
}
