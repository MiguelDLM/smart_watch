package androidx.room;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.IIX0o;

public final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    @OOXIXo
    private final AutoCloser autoCloser;
    @OOXIXo
    private final SupportSQLiteOpenHelper.Factory delegate;

    public AutoClosingRoomOpenHelperFactory(@OOXIXo SupportSQLiteOpenHelper.Factory factory, @OOXIXo AutoCloser autoCloser2) {
        IIX0o.x0xO0oo(factory, "delegate");
        IIX0o.x0xO0oo(autoCloser2, "autoCloser");
        this.delegate = factory;
        this.autoCloser = autoCloser2;
    }

    @OOXIXo
    public AutoClosingRoomOpenHelper create(@OOXIXo SupportSQLiteOpenHelper.Configuration configuration) {
        IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
        return new AutoClosingRoomOpenHelper(this.delegate.create(configuration), this.autoCloser);
    }
}
