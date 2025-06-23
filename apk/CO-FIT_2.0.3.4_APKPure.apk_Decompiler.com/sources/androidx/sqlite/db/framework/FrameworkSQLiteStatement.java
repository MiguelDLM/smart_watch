package androidx.sqlite.db.framework;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.jvm.internal.IIX0o;

public final class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {
    @OOXIXo
    private final SQLiteStatement delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteStatement(@OOXIXo SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        IIX0o.x0xO0oo(sQLiteStatement, "delegate");
        this.delegate = sQLiteStatement;
    }

    public void execute() {
        this.delegate.execute();
    }

    public long executeInsert() {
        return this.delegate.executeInsert();
    }

    public int executeUpdateDelete() {
        return this.delegate.executeUpdateDelete();
    }

    public long simpleQueryForLong() {
        return this.delegate.simpleQueryForLong();
    }

    @oOoXoXO
    public String simpleQueryForString() {
        return this.delegate.simpleQueryForString();
    }
}
