package androidx.sqlite.db.framework;

import OXOo.OOXIXo;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @OOXIXo
    public SupportSQLiteOpenHelper create(@OOXIXo SupportSQLiteOpenHelper.Configuration configuration) {
        IIX0o.x0xO0oo(configuration, "configuration");
        return new FrameworkSQLiteOpenHelper(configuration.context, configuration.name, configuration.callback, configuration.useNoBackupDirectory, configuration.allowDataLossOnRecovery);
    }
}
