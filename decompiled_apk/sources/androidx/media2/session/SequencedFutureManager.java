package androidx.media2.session;

import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.AbstractResolvableFuture;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class SequencedFutureManager implements Closeable {
    private static final boolean DEBUG = false;
    private static final String TAG = "SequencedFutureManager";

    @GuardedBy("mLock")
    private int mNextSequenceNumber;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private ArrayMap<Integer, SequencedFuture<?>> mSeqToFutureMap = new ArrayMap<>();

    /* loaded from: classes.dex */
    public static final class SequencedFuture<T> extends AbstractResolvableFuture<T> {
        private final T mResultWhenClosed;
        private final int mSequenceNumber;

        private SequencedFuture(int i, @NonNull T t) {
            this.mSequenceNumber = i;
            this.mResultWhenClosed = t;
        }

        public static <T> SequencedFuture<T> create(int i, @NonNull T t) {
            return new SequencedFuture<>(i, t);
        }

        @NonNull
        public T getResultWhenClosed() {
            return this.mResultWhenClosed;
        }

        public int getSequenceNumber() {
            return this.mSequenceNumber;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture
        public boolean set(@Nullable T t) {
            return super.set(t);
        }

        public void setWithTheValueOfResultWhenClosed() {
            set(this.mResultWhenClosed);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mSeqToFutureMap.values());
            this.mSeqToFutureMap.clear();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SequencedFuture) it.next()).setWithTheValueOfResultWhenClosed();
        }
    }

    public <T> SequencedFuture<T> createSequencedFuture(T t) {
        SequencedFuture<T> create;
        synchronized (this.mLock) {
            int obtainNextSequenceNumber = obtainNextSequenceNumber();
            create = SequencedFuture.create(obtainNextSequenceNumber, t);
            this.mSeqToFutureMap.put(Integer.valueOf(obtainNextSequenceNumber), create);
        }
        return create;
    }

    public int obtainNextSequenceNumber() {
        int i;
        synchronized (this.mLock) {
            i = this.mNextSequenceNumber;
            this.mNextSequenceNumber = i + 1;
        }
        return i;
    }

    public <T> void setFutureResult(int i, T t) {
        synchronized (this.mLock) {
            try {
                SequencedFuture<?> remove = this.mSeqToFutureMap.remove(Integer.valueOf(i));
                if (remove != null) {
                    if (t != null && remove.getResultWhenClosed().getClass() != t.getClass()) {
                        Log.w(TAG, "Type mismatch, expected " + remove.getResultWhenClosed().getClass() + ", but was " + t.getClass());
                    }
                    remove.set(t);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
