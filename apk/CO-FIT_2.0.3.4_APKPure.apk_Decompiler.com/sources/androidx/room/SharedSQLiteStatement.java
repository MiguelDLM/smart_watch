package androidx.room;

import OXOo.OOXIXo;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class SharedSQLiteStatement {
    @OOXIXo
    private final RoomDatabase database;
    @OOXIXo
    private final AtomicBoolean lock = new AtomicBoolean(false);
    @OOXIXo
    private final X0IIOO stmt$delegate = XIxXXX0x0.oIX0oI(new SharedSQLiteStatement$stmt$2(this));

    public SharedSQLiteStatement(@OOXIXo RoomDatabase roomDatabase) {
        IIX0o.x0xO0oo(roomDatabase, "database");
        this.database = roomDatabase;
    }

    /* access modifiers changed from: private */
    public final SupportSQLiteStatement createNewStatement() {
        return this.database.compileStatement(createQuery());
    }

    private final SupportSQLiteStatement getStmt() {
        return (SupportSQLiteStatement) this.stmt$delegate.getValue();
    }

    @OOXIXo
    public SupportSQLiteStatement acquire() {
        assertNotMainThread();
        return getStmt(this.lock.compareAndSet(false, true));
    }

    public void assertNotMainThread() {
        this.database.assertNotMainThread();
    }

    @OOXIXo
    public abstract String createQuery();

    public void release(@OOXIXo SupportSQLiteStatement supportSQLiteStatement) {
        IIX0o.x0xO0oo(supportSQLiteStatement, "statement");
        if (supportSQLiteStatement == getStmt()) {
            this.lock.set(false);
        }
    }

    private final SupportSQLiteStatement getStmt(boolean z) {
        if (z) {
            return getStmt();
        }
        return createNewStatement();
    }
}
