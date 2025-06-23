package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    @OXOo.OOXIXo
    private final AutoCloser autoCloser;

    @OXOo.OOXIXo
    private final SupportSQLiteOpenHelper.Factory delegate;

    public AutoClosingRoomOpenHelperFactory(@OXOo.OOXIXo SupportSQLiteOpenHelper.Factory delegate, @OXOo.OOXIXo AutoCloser autoCloser) {
        IIX0o.x0xO0oo(delegate, "delegate");
        IIX0o.x0xO0oo(autoCloser, "autoCloser");
        this.delegate = delegate;
        this.autoCloser = autoCloser;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    @OXOo.OOXIXo
    public AutoClosingRoomOpenHelper create(@OXOo.OOXIXo SupportSQLiteOpenHelper.Configuration configuration) {
        IIX0o.x0xO0oo(configuration, "configuration");
        return new AutoClosingRoomOpenHelper(this.delegate.create(configuration), this.autoCloser);
    }
}
