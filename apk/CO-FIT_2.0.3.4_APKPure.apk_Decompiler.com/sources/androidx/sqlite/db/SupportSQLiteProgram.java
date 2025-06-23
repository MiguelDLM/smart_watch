package androidx.sqlite.db;

import OXOo.OOXIXo;
import java.io.Closeable;

public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i, @OOXIXo byte[] bArr);

    void bindDouble(int i, double d);

    void bindLong(int i, long j);

    void bindNull(int i);

    void bindString(int i, @OOXIXo String str);

    void clearBindings();
}
