package androidx.room;

import OXOo.OOXIXo;
import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

public final class QueryInterceptorProgram implements SupportSQLiteProgram {
    @OOXIXo
    private final List<Object> bindArgsCache = new ArrayList();

    private final void saveArgsToCache(int i, Object obj) {
        int size;
        int i2 = i - 1;
        if (i2 >= this.bindArgsCache.size() && (size = this.bindArgsCache.size()) <= i2) {
            while (true) {
                this.bindArgsCache.add((Object) null);
                if (size == i2) {
                    break;
                }
                size++;
            }
        }
        this.bindArgsCache.set(i2, obj);
    }

    public void bindBlob(int i, @OOXIXo byte[] bArr) {
        IIX0o.x0xO0oo(bArr, "value");
        saveArgsToCache(i, bArr);
    }

    public void bindDouble(int i, double d) {
        saveArgsToCache(i, Double.valueOf(d));
    }

    public void bindLong(int i, long j) {
        saveArgsToCache(i, Long.valueOf(j));
    }

    public void bindNull(int i) {
        saveArgsToCache(i, (Object) null);
    }

    public void bindString(int i, @OOXIXo String str) {
        IIX0o.x0xO0oo(str, "value");
        saveArgsToCache(i, str);
    }

    public void clearBindings() {
        this.bindArgsCache.clear();
    }

    public void close() {
    }

    @OOXIXo
    public final List<Object> getBindArgsCache$room_runtime_release() {
        return this.bindArgsCache;
    }
}
