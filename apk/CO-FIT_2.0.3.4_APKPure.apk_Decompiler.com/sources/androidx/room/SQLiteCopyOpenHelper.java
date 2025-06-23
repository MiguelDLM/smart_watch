package androidx.room;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import X0.IIXOooo;
import android.content.Context;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.util.ProcessLock;
import com.huawei.openalliance.ad.constant.bn;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

public final class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    @OOXIXo
    private final Context context;
    @oOoXoXO
    private final String copyFromAssetPath;
    @oOoXoXO
    private final File copyFromFile;
    @oOoXoXO
    private final Callable<InputStream> copyFromInputStream;
    private DatabaseConfiguration databaseConfiguration;
    private final int databaseVersion;
    @OOXIXo
    private final SupportSQLiteOpenHelper delegate;
    private boolean verified;

    public SQLiteCopyOpenHelper(@OOXIXo Context context2, @oOoXoXO String str, @oOoXoXO File file, @oOoXoXO Callable<InputStream> callable, int i, @OOXIXo SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        IIX0o.x0xO0oo(context2, bn.f.o);
        IIX0o.x0xO0oo(supportSQLiteOpenHelper, "delegate");
        this.context = context2;
        this.copyFromAssetPath = str;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.databaseVersion = i;
        this.delegate = supportSQLiteOpenHelper;
    }

    private final void copyDatabaseFile(File file, boolean z) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.copyFromAssetPath != null) {
            readableByteChannel = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
            IIX0o.oO(readableByteChannel, "newChannel(context.assets.open(copyFromAssetPath))");
        } else if (this.copyFromFile != null) {
            readableByteChannel = new FileInputStream(this.copyFromFile).getChannel();
            IIX0o.oO(readableByteChannel, "FileInputStream(copyFromFile).channel");
        } else {
            Callable<InputStream> callable = this.copyFromInputStream;
            if (callable != null) {
                try {
                    readableByteChannel = Channels.newChannel(callable.call());
                    IIX0o.oO(readableByteChannel, "newChannel(inputStream)");
                } catch (Exception e) {
                    throw new IOException("inputStreamCallable exception on call", e);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.context.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        IIX0o.oO(channel, "output");
        FileUtil.copy(readableByteChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            IIX0o.oO(createTempFile, "intermediateFile");
            dispatchOnOpenPrepackagedDatabase(createTempFile, z);
            if (!createTempFile.renameTo(file)) {
                throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
            }
            return;
        }
        throw new IOException("Failed to create directories for " + file.getAbsolutePath());
    }

    private final SupportSQLiteOpenHelper createFrameworkOpenHelper(File file) {
        try {
            int readVersion = DBUtil.readVersion(file);
            return new FrameworkSQLiteOpenHelperFactory().create(SupportSQLiteOpenHelper.Configuration.Companion.builder(this.context).name(file.getAbsolutePath()).callback(new SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1(readVersion, IIXOooo.OxxIIOOXO(readVersion, 1))).build());
        } catch (IOException e) {
            throw new RuntimeException("Malformed database file, unable to read version.", e);
        }
    }

    private final void dispatchOnOpenPrepackagedDatabase(File file, boolean z) {
        SupportSQLiteDatabase supportSQLiteDatabase;
        DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
        if (databaseConfiguration2 == null) {
            IIX0o.XOxIOxOx("databaseConfiguration");
            databaseConfiguration2 = null;
        }
        if (databaseConfiguration2.prepackagedDatabaseCallback != null) {
            SupportSQLiteOpenHelper createFrameworkOpenHelper = createFrameworkOpenHelper(file);
            if (z) {
                try {
                    supportSQLiteDatabase = createFrameworkOpenHelper.getWritableDatabase();
                } catch (Throwable th) {
                    II0xO0.oIX0oI(createFrameworkOpenHelper, th);
                    throw th;
                }
            } else {
                supportSQLiteDatabase = createFrameworkOpenHelper.getReadableDatabase();
            }
            DatabaseConfiguration databaseConfiguration3 = this.databaseConfiguration;
            if (databaseConfiguration3 == null) {
                IIX0o.XOxIOxOx("databaseConfiguration");
                databaseConfiguration3 = null;
            }
            RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback = databaseConfiguration3.prepackagedDatabaseCallback;
            IIX0o.ooOOo0oXI(prepackagedDatabaseCallback);
            prepackagedDatabaseCallback.onOpenPrepackagedDatabase(supportSQLiteDatabase);
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
            II0xO0.oIX0oI(createFrameworkOpenHelper, (Throwable) null);
        }
    }

    private final void verifyDatabaseFile(boolean z) {
        String databaseName = getDatabaseName();
        if (databaseName != null) {
            File databasePath = this.context.getDatabasePath(databaseName);
            DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
            DatabaseConfiguration databaseConfiguration3 = null;
            if (databaseConfiguration2 == null) {
                IIX0o.XOxIOxOx("databaseConfiguration");
                databaseConfiguration2 = null;
            }
            ProcessLock processLock = new ProcessLock(databaseName, this.context.getFilesDir(), databaseConfiguration2.multiInstanceInvalidation);
            try {
                ProcessLock.lock$default(processLock, false, 1, (Object) null);
                if (!databasePath.exists()) {
                    IIX0o.oO(databasePath, "databaseFile");
                    copyDatabaseFile(databasePath, z);
                    processLock.unlock();
                    return;
                }
                try {
                    IIX0o.oO(databasePath, "databaseFile");
                    int readVersion = DBUtil.readVersion(databasePath);
                    if (readVersion == this.databaseVersion) {
                        processLock.unlock();
                        return;
                    }
                    DatabaseConfiguration databaseConfiguration4 = this.databaseConfiguration;
                    if (databaseConfiguration4 == null) {
                        IIX0o.XOxIOxOx("databaseConfiguration");
                    } else {
                        databaseConfiguration3 = databaseConfiguration4;
                    }
                    if (databaseConfiguration3.isMigrationRequired(readVersion, this.databaseVersion)) {
                        processLock.unlock();
                        return;
                    }
                    if (this.context.deleteDatabase(databaseName)) {
                        try {
                            copyDatabaseFile(databasePath, z);
                        } catch (IOException e) {
                            Log.w(Room.LOG_TAG, "Unable to copy database file.", e);
                        }
                    } else {
                        Log.w(Room.LOG_TAG, "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                    }
                    processLock.unlock();
                } catch (IOException e2) {
                    Log.w(Room.LOG_TAG, "Unable to read database version.", e2);
                    processLock.unlock();
                }
            } catch (IOException e3) {
                throw new RuntimeException("Unable to copy database file.", e3);
            } catch (Throwable th) {
                processLock.unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("Required value was null.");
        }
    }

    public synchronized void close() {
        getDelegate().close();
        this.verified = false;
    }

    @oOoXoXO
    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    @OOXIXo
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @OOXIXo
    public SupportSQLiteDatabase getReadableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(false);
            this.verified = true;
        }
        return getDelegate().getReadableDatabase();
    }

    @OOXIXo
    public SupportSQLiteDatabase getWritableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(true);
            this.verified = true;
        }
        return getDelegate().getWritableDatabase();
    }

    public final void setDatabaseConfiguration(@OOXIXo DatabaseConfiguration databaseConfiguration2) {
        IIX0o.x0xO0oo(databaseConfiguration2, "databaseConfiguration");
        this.databaseConfiguration = databaseConfiguration2;
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        getDelegate().setWriteAheadLoggingEnabled(z);
    }
}
