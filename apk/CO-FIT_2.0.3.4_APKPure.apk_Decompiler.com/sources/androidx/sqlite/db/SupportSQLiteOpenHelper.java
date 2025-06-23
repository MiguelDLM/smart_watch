package androidx.sqlite.db;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import com.facebook.appevents.UserDataStore;
import com.huawei.openalliance.ad.constant.bn;
import java.io.Closeable;
import java.io.File;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;

public interface SupportSQLiteOpenHelper extends Closeable {

    @XX({"SMAP\nSupportSQLiteOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SupportSQLiteOpenHelper.kt\nandroidx/sqlite/db/SupportSQLiteOpenHelper$Callback\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,426:1\n1#2:427\n1855#3,2:428\n107#4:430\n79#4,22:431\n*S KotlinDebug\n*F\n+ 1 SupportSQLiteOpenHelper.kt\nandroidx/sqlite/db/SupportSQLiteOpenHelper$Callback\n*L\n243#1:428,2\n251#1:430\n251#1:431,22\n*E\n"})
    public static abstract class Callback {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @OOXIXo
        private static final String TAG = "SupportSQLite";
        @XO
        public final int version;

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

        public void onConfigure(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
            if (r1 != null) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
            r4 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
            if (r4.hasNext() != false) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
            r1 = ((android.util.Pair) r4.next()).second;
            kotlin.jvm.internal.IIX0o.oO(r1, "p.second");
            deleteDatabaseFile((java.lang.String) r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
            r4 = r4.getPath();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
            if (r4 != null) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
            deleteDatabaseFile(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0066, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003a */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0087  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0038 A[ExcHandler: all (r2v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
          PHI: (r1v12 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r1v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v5 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v5 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:6:0x0033, B:9:0x003a, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:6:0x0033] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCorruption(@OXOo.OOXIXo androidx.sqlite.db.SupportSQLiteDatabase r4) {
            /*
                r3 = this;
                java.lang.String r0 = "p.second"
                java.lang.String r1 = "db"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r4, r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Corruption reported by sqlite on database: "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r2 = ".path"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "SupportSQLite"
                android.util.Log.e(r2, r1)
                boolean r1 = r4.isOpen()
                if (r1 != 0) goto L_0x0032
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x0031
                r3.deleteDatabaseFile(r4)
            L_0x0031:
                return
            L_0x0032:
                r1 = 0
                java.util.List r1 = r4.getAttachedDbs()     // Catch:{ SQLiteException -> 0x003a, all -> 0x0038 }
                goto L_0x003a
            L_0x0038:
                r2 = move-exception
                goto L_0x003e
            L_0x003a:
                r4.close()     // Catch:{ IOException -> 0x0067, all -> 0x0038 }
                goto L_0x0068
            L_0x003e:
                if (r1 == 0) goto L_0x005d
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r4 = r1.iterator()
            L_0x0046:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x0066
                java.lang.Object r1 = r4.next()
                android.util.Pair r1 = (android.util.Pair) r1
                java.lang.Object r1 = r1.second
                kotlin.jvm.internal.IIX0o.oO(r1, r0)
                java.lang.String r1 = (java.lang.String) r1
                r3.deleteDatabaseFile(r1)
                goto L_0x0046
            L_0x005d:
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x0066
                r3.deleteDatabaseFile(r4)
            L_0x0066:
                throw r2
            L_0x0067:
            L_0x0068:
                if (r1 == 0) goto L_0x0087
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r4 = r1.iterator()
            L_0x0070:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x0090
                java.lang.Object r1 = r4.next()
                android.util.Pair r1 = (android.util.Pair) r1
                java.lang.Object r1 = r1.second
                kotlin.jvm.internal.IIX0o.oO(r1, r0)
                java.lang.String r1 = (java.lang.String) r1
                r3.deleteDatabaseFile(r1)
                goto L_0x0070
            L_0x0087:
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x0090
                r3.deleteDatabaseFile(r4)
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.SupportSQLiteOpenHelper.Callback.onCorruption(androidx.sqlite.db.SupportSQLiteDatabase):void");
        }

        public abstract void onCreate(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase);

        public void onDowngrade(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
        }

        public void onOpen(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        }

        public abstract void onUpgrade(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);
    }

    public interface Factory {
        @OOXIXo
        SupportSQLiteOpenHelper create(@OOXIXo Configuration configuration);
    }

    void close();

    @oOoXoXO
    String getDatabaseName();

    @OOXIXo
    SupportSQLiteDatabase getReadableDatabase();

    @OOXIXo
    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z);

    public static final class Configuration {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @XO
        public final boolean allowDataLossOnRecovery;
        @XO
        @OOXIXo
        public final Callback callback;
        @XO
        @OOXIXo
        public final Context context;
        @XO
        @oOoXoXO
        public final String name;
        @XO
        public final boolean useNoBackupDirectory;

        public static class Builder {
            private boolean allowDataLossOnRecovery;
            @oOoXoXO
            private Callback callback;
            @OOXIXo
            private final Context context;
            @oOoXoXO
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(@OOXIXo Context context2) {
                IIX0o.x0xO0oo(context2, bn.f.o);
                this.context = context2;
            }

            @OOXIXo
            public Builder allowDataLossOnRecovery(boolean z) {
                this.allowDataLossOnRecovery = z;
                return this;
            }

            @OOXIXo
            public Configuration build() {
                String str;
                Callback callback2 = this.callback;
                if (callback2 == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (!this.useNoBackupDirectory || ((str = this.name) != null && str.length() != 0)) {
                    return new Configuration(this.context, this.name, callback2, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
                } else {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
            }

            @OOXIXo
            public Builder callback(@OOXIXo Callback callback2) {
                IIX0o.x0xO0oo(callback2, bn.f.L);
                this.callback = callback2;
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

        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            @x0XOIxOo
            @OOXIXo
            public final Builder builder(@OOXIXo Context context) {
                IIX0o.x0xO0oo(context, bn.f.o);
                return new Builder(context);
            }

            private Companion() {
            }
        }

        public Configuration(@OOXIXo Context context2, @oOoXoXO String str, @OOXIXo Callback callback2, boolean z, boolean z2) {
            IIX0o.x0xO0oo(context2, bn.f.o);
            IIX0o.x0xO0oo(callback2, bn.f.L);
            this.context = context2;
            this.name = str;
            this.callback = callback2;
            this.useNoBackupDirectory = z;
            this.allowDataLossOnRecovery = z2;
        }

        @x0XOIxOo
        @OOXIXo
        public static final Builder builder(@OOXIXo Context context2) {
            return Companion.builder(context2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Configuration(Context context2, String str, Callback callback2, boolean z, boolean z2, int i, IIXOooo iIXOooo) {
            this(context2, str, callback2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
        }
    }
}
