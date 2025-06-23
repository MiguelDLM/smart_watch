package androidx.sqlite.db.framework;

import OXOo.OOXIXo;
import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.jvm.internal.IIX0o;

public class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    @OOXIXo
    private final SQLiteProgram delegate;

    public FrameworkSQLiteProgram(@OOXIXo SQLiteProgram sQLiteProgram) {
        IIX0o.x0xO0oo(sQLiteProgram, "delegate");
        this.delegate = sQLiteProgram;
    }

    public void bindBlob(int i, @OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "value");
        this.delegate.bindBlob(i, bArr);
    }

    public void bindDouble(int i, double d) {
        this.delegate.bindDouble(i, d);
    }

    public void bindLong(int i, long j) {
        this.delegate.bindLong(i, j);
    }

    public void bindNull(int i) {
        this.delegate.bindNull(i);
    }

    public void bindString(int i, @OOXIXo String str) {
        IIX0o.x0xO0oo(str, "value");
        this.delegate.bindString(i, str);
    }

    public void clearBindings() {
        this.delegate.clearBindings();
    }

    public void close() {
        this.delegate.close();
    }
}
