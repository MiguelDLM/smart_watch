package androidx.room;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.IIX0o;

public final class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    @oOoXoXO
    private final String mCopyFromAssetPath;
    @oOoXoXO
    private final File mCopyFromFile;
    @oOoXoXO
    private final Callable<InputStream> mCopyFromInputStream;
    @OOXIXo
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    public SQLiteCopyOpenHelperFactory(@oOoXoXO String str, @oOoXoXO File file, @oOoXoXO Callable<InputStream> callable, @OOXIXo SupportSQLiteOpenHelper.Factory factory) {
        IIX0o.x0xO0oo(factory, "mDelegate");
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mCopyFromInputStream = callable;
        this.mDelegate = factory;
    }

    @OOXIXo
    public SupportSQLiteOpenHelper create(@OOXIXo SupportSQLiteOpenHelper.Configuration configuration) {
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        return new SQLiteCopyOpenHelper(configuration.context, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, configuration.callback.version, this.mDelegate.create(configuration));
    }
}
