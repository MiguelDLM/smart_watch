package okhttp3;

import OI0IXox.oxoX;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import okhttp3.internal.cache.DiskLruCache;
import okio.Okio;

@XX({"SMAP\nCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cache.kt\nokhttp3/Cache$urls$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,788:1\n1#2:789\n*E\n"})
/* loaded from: classes6.dex */
public final class Cache$urls$1 implements Iterator<String>, oxoX {
    private boolean canRemove;

    @OOXIXo
    private final Iterator<DiskLruCache.Snapshot> delegate;

    @oOoXoXO
    private String nextUrl;

    public Cache$urls$1(Cache cache) {
        this.delegate = cache.getCache$okhttp().snapshots();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextUrl != null) {
            return true;
        }
        this.canRemove = false;
        while (this.delegate.hasNext()) {
            try {
                DiskLruCache.Snapshot next = this.delegate.next();
                try {
                    continue;
                    this.nextUrl = Okio.buffer(next.getSource(0)).readUtf8LineStrict();
                    II0xO0.oIX0oI(next, null);
                    return true;
                } finally {
                    try {
                        continue;
                        break;
                    } catch (Throwable th) {
                    }
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.canRemove) {
            this.delegate.remove();
            return;
        }
        throw new IllegalStateException("remove() before next()");
    }

    @Override // java.util.Iterator
    @OOXIXo
    public String next() {
        if (hasNext()) {
            String str = this.nextUrl;
            IIX0o.ooOOo0oXI(str);
            this.nextUrl = null;
            this.canRemove = true;
            return str;
        }
        throw new NoSuchElementException();
    }
}
