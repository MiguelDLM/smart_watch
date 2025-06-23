package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.facebook.appevents.UserDataStore;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@XX({"SMAP\nRoomOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomOpenHelper.kt\nandroidx/room/RoomOpenHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 CursorUtil.kt\nandroidx/room/util/CursorUtil\n*L\n1#1,245:1\n1855#2,2:246\n145#3,7:248\n*S KotlinDebug\n*F\n+ 1 RoomOpenHelper.kt\nandroidx/room/RoomOpenHelper\n*L\n90#1:246,2\n137#1:248,7\n*E\n"})
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @oOoXoXO
    private DatabaseConfiguration configuration;
    @OOXIXo
    private final Delegate delegate;
    @OOXIXo
    private final String identityHash;
    @OOXIXo
    private final String legacyHash;

    @XX({"SMAP\nRoomOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomOpenHelper.kt\nandroidx/room/RoomOpenHelper$Companion\n+ 2 CursorUtil.kt\nandroidx/room/util/CursorUtil\n*L\n1#1,245:1\n145#2,7:246\n145#2,7:253\n*S KotlinDebug\n*F\n+ 1 RoomOpenHelper.kt\nandroidx/room/RoomOpenHelper$Companion\n*L\n231#1:246,7\n239#1:253,7\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
            kotlin.io.II0xO0.oIX0oI(r4, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean hasEmptySchema$room_runtime_release(@OXOo.OOXIXo androidx.sqlite.db.SupportSQLiteDatabase r4) {
            /*
                r3 = this;
                java.lang.String r0 = "db"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
                java.lang.String r0 = "SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"
                android.database.Cursor r4 = r4.query((java.lang.String) r0)
                java.io.Closeable r4 = (java.io.Closeable) r4
                r0 = r4
                android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x001f }
                boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x001f }
                r2 = 0
                if (r1 == 0) goto L_0x0021
                int r0 = r0.getInt(r2)     // Catch:{ all -> 0x001f }
                if (r0 != 0) goto L_0x0021
                r2 = 1
                goto L_0x0021
            L_0x001f:
                r0 = move-exception
                goto L_0x0026
            L_0x0021:
                r0 = 0
                kotlin.io.II0xO0.oIX0oI(r4, r0)
                return r2
            L_0x0026:
                throw r0     // Catch:{ all -> 0x0027 }
            L_0x0027:
                r1 = move-exception
                kotlin.io.II0xO0.oIX0oI(r4, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.Companion.hasEmptySchema$room_runtime_release(androidx.sqlite.db.SupportSQLiteDatabase):boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
            kotlin.io.II0xO0.oIX0oI(r4, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean hasRoomMasterTable$room_runtime_release(@OXOo.OOXIXo androidx.sqlite.db.SupportSQLiteDatabase r4) {
            /*
                r3 = this;
                java.lang.String r0 = "db"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r0)
                java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
                android.database.Cursor r4 = r4.query((java.lang.String) r0)
                java.io.Closeable r4 = (java.io.Closeable) r4
                r0 = r4
                android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x001f }
                boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x001f }
                r2 = 0
                if (r1 == 0) goto L_0x0021
                int r0 = r0.getInt(r2)     // Catch:{ all -> 0x001f }
                if (r0 == 0) goto L_0x0021
                r2 = 1
                goto L_0x0021
            L_0x001f:
                r0 = move-exception
                goto L_0x0026
            L_0x0021:
                r0 = 0
                kotlin.io.II0xO0.oIX0oI(r4, r0)
                return r2
            L_0x0026:
                throw r0     // Catch:{ all -> 0x0027 }
            L_0x0027:
                r1 = move-exception
                kotlin.io.II0xO0.oIX0oI(r4, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.Companion.hasRoomMasterTable$room_runtime_release(androidx.sqlite.db.SupportSQLiteDatabase):boolean");
        }

        private Companion() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class Delegate {
        @XO
        public final int version;

        public Delegate(int i) {
            this.version = i;
        }

        public abstract void createAllTables(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);

        public void onPostMigrate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        }

        public void onPreMigrate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        }

        @OOXIXo
        public ValidationResult onValidateSchema(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            validateMigration(supportSQLiteDatabase);
            return new ValidationResult(true, (String) null);
        }

        @kotlin.OOXIXo(message = "Use [onValidateSchema(SupportSQLiteDatabase)]")
        public void validateMigration(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ValidationResult {
        @XO
        @oOoXoXO
        public final String expectedFoundMsg;
        @XO
        public final boolean isValid;

        public ValidationResult(boolean z, @oOoXoXO String str) {
            this.isValid = z;
            this.expectedFoundMsg = str;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(@OOXIXo DatabaseConfiguration databaseConfiguration, @OOXIXo Delegate delegate2, @OOXIXo String str, @OOXIXo String str2) {
        super(delegate2.version);
        IIX0o.x0xO0oo(databaseConfiguration, O0IoXXOx.XO.f15419Oxx0IOOO);
        IIX0o.x0xO0oo(delegate2, "delegate");
        IIX0o.x0xO0oo(str, "identityHash");
        IIX0o.x0xO0oo(str2, "legacyHash");
        this.configuration = databaseConfiguration;
        this.delegate = delegate2;
        this.identityHash = str;
        this.legacyHash = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        kotlin.io.II0xO0.oIX0oI(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0062, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void checkIdentity(androidx.sqlite.db.SupportSQLiteDatabase r4) {
        /*
            r3 = this;
            androidx.room.RoomOpenHelper$Companion r0 = Companion
            boolean r0 = r0.hasRoomMasterTable$room_runtime_release(r4)
            if (r0 == 0) goto L_0x0063
            androidx.sqlite.db.SimpleSQLiteQuery r0 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.String r1 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r0.<init>(r1)
            android.database.Cursor r4 = r4.query((androidx.sqlite.db.SupportSQLiteQuery) r0)
            java.io.Closeable r4 = (java.io.Closeable) r4
            r0 = r4
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x0025 }
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x0025 }
            r2 = 0
            if (r1 == 0) goto L_0x0027
            r1 = 0
            java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x0025 }
            goto L_0x0028
        L_0x0025:
            r0 = move-exception
            goto L_0x005d
        L_0x0027:
            r0 = r2
        L_0x0028:
            kotlin.io.II0xO0.oIX0oI(r4, r2)
            java.lang.String r4 = r3.identityHash
            boolean r4 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r4, r0)
            if (r4 != 0) goto L_0x0075
            java.lang.String r4 = r3.legacyHash
            boolean r4 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r4, r0)
            if (r4 == 0) goto L_0x003c
            goto L_0x0075
        L_0x003c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            r1.append(r2)
            java.lang.String r2 = r3.identityHash
            r1.append(r2)
            java.lang.String r2 = ", found: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r4.<init>(r0)
            throw r4
        L_0x005d:
            throw r0     // Catch:{ all -> 0x005e }
        L_0x005e:
            r1 = move-exception
            kotlin.io.II0xO0.oIX0oI(r4, r0)
            throw r1
        L_0x0063:
            androidx.room.RoomOpenHelper$Delegate r0 = r3.delegate
            androidx.room.RoomOpenHelper$ValidationResult r0 = r0.onValidateSchema(r4)
            boolean r1 = r0.isValid
            if (r1 == 0) goto L_0x0076
            androidx.room.RoomOpenHelper$Delegate r0 = r3.delegate
            r0.onPostMigrate(r4)
            r3.updateIdentity(r4)
        L_0x0075:
            return
        L_0x0076:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r1.append(r2)
            java.lang.String r0 = r0.expectedFoundMsg
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.checkIdentity(androidx.sqlite.db.SupportSQLiteDatabase):void");
    }

    private final void createMasterTableIfNotExists(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private final void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        createMasterTableIfNotExists(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    public void onConfigure(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        super.onConfigure(supportSQLiteDatabase);
    }

    public void onCreate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        boolean hasEmptySchema$room_runtime_release = Companion.hasEmptySchema$room_runtime_release(supportSQLiteDatabase);
        this.delegate.createAllTables(supportSQLiteDatabase);
        if (!hasEmptySchema$room_runtime_release) {
            ValidationResult onValidateSchema = this.delegate.onValidateSchema(supportSQLiteDatabase);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
            }
        }
        updateIdentity(supportSQLiteDatabase);
        this.delegate.onCreate(supportSQLiteDatabase);
    }

    public void onDowngrade(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        onUpgrade(supportSQLiteDatabase, i, i2);
    }

    public void onOpen(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        super.onOpen(supportSQLiteDatabase);
        checkIdentity(supportSQLiteDatabase);
        this.delegate.onOpen(supportSQLiteDatabase);
        this.configuration = null;
    }

    public void onUpgrade(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        List<Migration> findMigrationPath;
        IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        DatabaseConfiguration databaseConfiguration = this.configuration;
        if (databaseConfiguration == null || (findMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(i, i2)) == null) {
            DatabaseConfiguration databaseConfiguration2 = this.configuration;
            if (databaseConfiguration2 == null || databaseConfiguration2.isMigrationRequired(i, i2)) {
                throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            this.delegate.dropAllTables(supportSQLiteDatabase);
            this.delegate.createAllTables(supportSQLiteDatabase);
            return;
        }
        this.delegate.onPreMigrate(supportSQLiteDatabase);
        for (Migration migrate : findMigrationPath) {
            migrate.migrate(supportSQLiteDatabase);
        }
        ValidationResult onValidateSchema = this.delegate.onValidateSchema(supportSQLiteDatabase);
        if (onValidateSchema.isValid) {
            this.delegate.onPostMigrate(supportSQLiteDatabase);
            updateIdentity(supportSQLiteDatabase);
            return;
        }
        throw new IllegalStateException("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(@OOXIXo DatabaseConfiguration databaseConfiguration, @OOXIXo Delegate delegate2, @OOXIXo String str) {
        this(databaseConfiguration, delegate2, "", str);
        IIX0o.x0xO0oo(databaseConfiguration, O0IoXXOx.XO.f15419Oxx0IOOO);
        IIX0o.x0xO0oo(delegate2, "delegate");
        IIX0o.x0xO0oo(str, "legacyHash");
    }
}
