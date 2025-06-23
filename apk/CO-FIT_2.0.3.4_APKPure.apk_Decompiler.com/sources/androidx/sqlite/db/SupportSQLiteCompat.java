package androidx.sqlite.db;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.huawei.openalliance.ad.constant.bn;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SupportSQLiteCompat {

    @RequiresApi(16)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api16Impl {
        @OOXIXo
        public static final Api16Impl INSTANCE = new Api16Impl();

        private Api16Impl() {
        }

        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void cancel(@OOXIXo CancellationSignal cancellationSignal) {
            IIX0o.x0xO0oo(cancellationSignal, "cancellationSignal");
            cancellationSignal.cancel();
        }

        @x0XOIxOo
        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final CancellationSignal createCancellationSignal() {
            return new CancellationSignal();
        }

        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final boolean deleteDatabase(@OOXIXo File file) {
            IIX0o.x0xO0oo(file, "file");
            return SQLiteDatabase.deleteDatabase(file);
        }

        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void disableWriteAheadLogging(@OOXIXo SQLiteDatabase sQLiteDatabase) {
            IIX0o.x0xO0oo(sQLiteDatabase, "sQLiteDatabase");
            sQLiteDatabase.disableWriteAheadLogging();
        }

        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final boolean isWriteAheadLoggingEnabled(@OOXIXo SQLiteDatabase sQLiteDatabase) {
            IIX0o.x0xO0oo(sQLiteDatabase, "sQLiteDatabase");
            return sQLiteDatabase.isWriteAheadLoggingEnabled();
        }

        @x0XOIxOo
        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final Cursor rawQueryWithFactory(@OOXIXo SQLiteDatabase sQLiteDatabase, @OOXIXo String str, @OOXIXo String[] strArr, @oOoXoXO String str2, @OOXIXo CancellationSignal cancellationSignal, @OOXIXo SQLiteDatabase.CursorFactory cursorFactory) {
            IIX0o.x0xO0oo(sQLiteDatabase, "sQLiteDatabase");
            IIX0o.x0xO0oo(str, "sql");
            IIX0o.x0xO0oo(strArr, "selectionArgs");
            IIX0o.x0xO0oo(cancellationSignal, "cancellationSignal");
            IIX0o.x0xO0oo(cursorFactory, "cursorFactory");
            Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
            IIX0o.oO(rawQueryWithFactory, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
            return rawQueryWithFactory;
        }

        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setForeignKeyConstraintsEnabled(@OOXIXo SQLiteDatabase sQLiteDatabase, boolean z) {
            IIX0o.x0xO0oo(sQLiteDatabase, "sQLiteDatabase");
            sQLiteDatabase.setForeignKeyConstraintsEnabled(z);
        }

        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setWriteAheadLoggingEnabled(@OOXIXo SQLiteOpenHelper sQLiteOpenHelper, boolean z) {
            IIX0o.x0xO0oo(sQLiteOpenHelper, "sQLiteOpenHelper");
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z);
        }
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api19Impl {
        @OOXIXo
        public static final Api19Impl INSTANCE = new Api19Impl();

        private Api19Impl() {
        }

        @x0XOIxOo
        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final Uri getNotificationUri(@OOXIXo Cursor cursor) {
            IIX0o.x0xO0oo(cursor, "cursor");
            Uri notificationUri = cursor.getNotificationUri();
            IIX0o.oO(notificationUri, "cursor.notificationUri");
            return notificationUri;
        }

        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final boolean isLowRamDevice(@OOXIXo ActivityManager activityManager) {
            IIX0o.x0xO0oo(activityManager, "activityManager");
            return activityManager.isLowRamDevice();
        }
    }

    @RequiresApi(21)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api21Impl {
        @OOXIXo
        public static final Api21Impl INSTANCE = new Api21Impl();

        private Api21Impl() {
        }

        @x0XOIxOo
        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final File getNoBackupFilesDir(@OOXIXo Context context) {
            IIX0o.x0xO0oo(context, bn.f.o);
            File noBackupFilesDir = context.getNoBackupFilesDir();
            IIX0o.oO(noBackupFilesDir, "context.noBackupFilesDir");
            return noBackupFilesDir;
        }
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api23Impl {
        @OOXIXo
        public static final Api23Impl INSTANCE = new Api23Impl();

        private Api23Impl() {
        }

        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setExtras(@OOXIXo Cursor cursor, @OOXIXo Bundle bundle) {
            IIX0o.x0xO0oo(cursor, "cursor");
            IIX0o.x0xO0oo(bundle, "extras");
            cursor.setExtras(bundle);
        }
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api29Impl {
        @OOXIXo
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @OOXIXo
        public static final List<Uri> getNotificationUris(@OOXIXo Cursor cursor) {
            IIX0o.x0xO0oo(cursor, "cursor");
            List<Uri> notificationUris = cursor.getNotificationUris();
            IIX0o.ooOOo0oXI(notificationUris);
            return notificationUris;
        }

        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setNotificationUris(@OOXIXo Cursor cursor, @OOXIXo ContentResolver contentResolver, @OOXIXo List<? extends Uri> list) {
            IIX0o.x0xO0oo(cursor, "cursor");
            IIX0o.x0xO0oo(contentResolver, "cr");
            IIX0o.x0xO0oo(list, "uris");
            cursor.setNotificationUris(contentResolver, list);
        }
    }

    private SupportSQLiteCompat() {
    }
}
