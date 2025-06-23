package androidx.sqlite.db.framework;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.IIX0o;

public final class FrameworkSQLiteOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    @OOXIXo
    public SupportSQLiteOpenHelper create(@OOXIXo SupportSQLiteOpenHelper.Configuration configuration) {
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        return new FrameworkSQLiteOpenHelper(configuration.context, configuration.name, configuration.callback, configuration.useNoBackupDirectory, configuration.allowDataLossOnRecovery);
    }
}
