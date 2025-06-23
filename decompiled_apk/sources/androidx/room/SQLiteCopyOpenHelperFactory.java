package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    @OXOo.oOoXoXO
    private final String mCopyFromAssetPath;

    @OXOo.oOoXoXO
    private final File mCopyFromFile;

    @OXOo.oOoXoXO
    private final Callable<InputStream> mCopyFromInputStream;

    @OXOo.OOXIXo
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    public SQLiteCopyOpenHelperFactory(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO File file, @OXOo.oOoXoXO Callable<InputStream> callable, @OXOo.OOXIXo SupportSQLiteOpenHelper.Factory mDelegate) {
        IIX0o.x0xO0oo(mDelegate, "mDelegate");
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mCopyFromInputStream = callable;
        this.mDelegate = mDelegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @OXOo.OOXIXo
    public SupportSQLiteOpenHelper create(@OXOo.OOXIXo SupportSQLiteOpenHelper.Configuration configuration) {
        IIX0o.x0xO0oo(configuration, "configuration");
        return new SQLiteCopyOpenHelper(configuration.context, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, configuration.callback.version, this.mDelegate.create(configuration));
    }
}
