package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class ViewModel {
    @Nullable
    private final Map<String, Object> mBagOfTags;
    private volatile boolean mCleared;
    @Nullable
    private final Set<Closeable> mCloseables;

    public ViewModel() {
        this.mBagOfTags = new HashMap();
        this.mCloseables = new LinkedHashSet();
        this.mCleared = false;
    }

    private static void closeWithRuntimeException(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addCloseable(@NonNull Closeable closeable) {
        Set<Closeable> set = this.mCloseables;
        if (set != null) {
            synchronized (set) {
                this.mCloseables.add(closeable);
            }
        }
    }

    @MainThread
    public final void clear() {
        this.mCleared = true;
        Map<String, Object> map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                try {
                    for (Object closeWithRuntimeException : this.mBagOfTags.values()) {
                        closeWithRuntimeException(closeWithRuntimeException);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        Set<Closeable> set = this.mCloseables;
        if (set != null) {
            synchronized (set) {
                try {
                    for (Closeable closeWithRuntimeException2 : this.mCloseables) {
                        closeWithRuntimeException(closeWithRuntimeException2);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        onCleared();
    }

    public <T> T getTag(String str) {
        T t;
        Map<String, Object> map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = this.mBagOfTags.get(str);
        }
        return t;
    }

    public void onCleared() {
    }

    public <T> T setTagIfAbsent(String str, T t) {
        T t2;
        synchronized (this.mBagOfTags) {
            try {
                t2 = this.mBagOfTags.get(str);
                if (t2 == null) {
                    this.mBagOfTags.put(str, t);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (t2 != null) {
            t = t2;
        }
        if (this.mCleared) {
            closeWithRuntimeException(t);
        }
        return t;
    }

    public ViewModel(@NonNull Closeable... closeableArr) {
        this.mBagOfTags = new HashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.mCloseables = linkedHashSet;
        this.mCleared = false;
        linkedHashSet.addAll(Arrays.asList(closeableArr));
    }
}
