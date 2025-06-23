package androidx.sqlite.db;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;

/* loaded from: classes.dex */
public interface SupportSQLiteOpenHelper extends Closeable {

    @XX({"SMAP\nSupportSQLiteOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SupportSQLiteOpenHelper.kt\nandroidx/sqlite/db/SupportSQLiteOpenHelper$Callback\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,426:1\n1#2:427\n1855#3,2:428\n107#4:430\n79#4,22:431\n*S KotlinDebug\n*F\n+ 1 SupportSQLiteOpenHelper.kt\nandroidx/sqlite/db/SupportSQLiteOpenHelper$Callback\n*L\n243#1:428,2\n251#1:430\n251#1:431,22\n*E\n"})
    /* loaded from: classes.dex */
    public static abstract class Callback {

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @OOXIXo
        private static final String TAG = "SupportSQLite";

        @XO
        public final int version;

        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        public Callback(int i) {
            this.version = i;
        }

        private final void deleteDatabaseFile(String str) {
            int i;
            boolean z;
            if (!OxI.oX0I0O(str, ":memory:", true)) {
                int length = str.length() - 1;
                int i2 = 0;
                boolean z2 = false;
                while (i2 <= length) {
                    if (!z2) {
                        i = i2;
                    } else {
                        i = length;
                    }
                    if (IIX0o.oI0IIXIo(str.charAt(i), 32) <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z2) {
                        if (!z) {
                            z2 = true;
                        } else {
                            i2++;
                        }
                    } else if (!z) {
                        break;
                    } else {
                        length--;
                    }
                }
                if (str.subSequence(i2, length + 1).toString().length() != 0) {
                    Log.w(TAG, "deleting the database file: " + str);
                    try {
                        SupportSQLiteCompat.Api16Impl.deleteDatabase(new File(str));
                    } catch (Exception e) {
                        Log.w(TAG, "delete failed: ", e);
                    }
                }
            }
        }

        public void onConfigure(@OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
        }

        public void onCorruption(@OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
            Log.e(TAG, "Corruption reported by sqlite on database: " + db + ".path");
            if (!db.isOpen()) {
                String path = db.getPath();
                if (path != null) {
                    deleteDatabaseFile(path);
                    return;
                }
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = db.getAttachedDbs();
                } catch (SQLiteException unused) {
                }
                try {
                    db.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        Object obj = ((Pair) it.next()).second;
                        IIX0o.oO(obj, "p.second");
                        deleteDatabaseFile((String) obj);
                    }
                } else {
                    String path2 = db.getPath();
                    if (path2 != null) {
                        deleteDatabaseFile(path2);
                    }
                }
            }
        }

        public abstract void onCreate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);

        public void onDowngrade(@OOXIXo SupportSQLiteDatabase db, int i, int i2) {
            IIX0o.x0xO0oo(db, "db");
            throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
        }

        public void onOpen(@OOXIXo SupportSQLiteDatabase db) {
            IIX0o.x0xO0oo(db, "db");
        }

        public abstract void onUpgrade(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface Factory {
        @OOXIXo
        SupportSQLiteOpenHelper create(@OOXIXo Configuration configuration);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @oOoXoXO
    String getDatabaseName();

    @OOXIXo
    SupportSQLiteDatabase getReadableDatabase();

    @OOXIXo
    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z);

    /* loaded from: classes.dex */
    public static final class Configuration {

        @OOXIXo
        public static final Companion Companion = new Companion(null);

        @XO
        public final boolean allowDataLossOnRecovery;

        @OOXIXo
        @XO
        public final Callback callback;

        @OOXIXo
        @XO
        public final Context context;

        @XO
        @oOoXoXO
        public final String name;

        @XO
        public final boolean useNoBackupDirectory;

        /* loaded from: classes.dex */
        public static class Builder {
            private boolean allowDataLossOnRecovery;

            @oOoXoXO
            private Callback callback;

            @OOXIXo
            private final Context context;

            @oOoXoXO
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(@OOXIXo Context context) {
                IIX0o.x0xO0oo(context, "context");
                this.context = context;
            }

            @OOXIXo
            public Builder allowDataLossOnRecovery(boolean z) {
                this.allowDataLossOnRecovery = z;
                return this;
            }

            @OOXIXo
            public Configuration build() {
                String str;
                Callback callback = this.callback;
                if (callback != null) {
                    if (this.useNoBackupDirectory && ((str = this.name) == null || str.length() == 0)) {
                        throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                    }
                    return new Configuration(this.context, this.name, callback, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
                }
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }

            @OOXIXo
            public Builder callback(@OOXIXo Callback callback) {
                IIX0o.x0xO0oo(callback, "callback");
                this.callback = callback;
                return this;
            }

            @OOXIXo
            public Builder name(@oOoXoXO String str) {
                this.name = str;
                return this;
            }

            @OOXIXo
            public Builder noBackupDirectory(boolean z) {
                this.useNoBackupDirectory = z;
                return this;
            }
        }

        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @x0XOIxOo
            @OOXIXo
            public final Builder builder(@OOXIXo Context context) {
                IIX0o.x0xO0oo(context, "context");
                return new Builder(context);
            }

            private Companion() {
            }
        }

        public Configuration(@OOXIXo Context context, @oOoXoXO String str, @OOXIXo Callback callback, boolean z, boolean z2) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(callback, "callback");
            this.context = context;
            this.name = str;
            this.callback = callback;
            this.useNoBackupDirectory = z;
            this.allowDataLossOnRecovery = z2;
        }

        @x0XOIxOo
        @OOXIXo
        public static final Builder builder(@OOXIXo Context context) {
            return Companion.builder(context);
        }

        public /* synthetic */ Configuration(Context context, String str, Callback callback, boolean z, boolean z2, int i, IIXOooo iIXOooo) {
            this(context, str, callback, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
        }
    }
}
