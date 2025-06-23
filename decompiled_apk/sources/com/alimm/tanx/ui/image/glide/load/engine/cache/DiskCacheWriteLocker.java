package com.alimm.tanx.ui.image.glide.load.engine.cache;

import com.alimm.tanx.ui.image.glide.load.Key;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
final class DiskCacheWriteLocker {
    private final Map<Key, WriteLock> locks = new HashMap();
    private final WriteLockPool writeLockPool = new WriteLockPool();

    /* loaded from: classes.dex */
    public static class WriteLock {
        int interestedThreads;
        final Lock lock;

        private WriteLock() {
            this.lock = new ReentrantLock();
        }
    }

    /* loaded from: classes.dex */
    public static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue<WriteLock> pool;

        private WriteLockPool() {
            this.pool = new ArrayDeque();
        }

        public WriteLock obtain() {
            WriteLock poll;
            synchronized (this.pool) {
                poll = this.pool.poll();
            }
            if (poll == null) {
                return new WriteLock();
            }
            return poll;
        }

        public void offer(WriteLock writeLock) {
            synchronized (this.pool) {
                try {
                    if (this.pool.size() < 10) {
                        this.pool.offer(writeLock);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void acquire(Key key) {
        WriteLock writeLock;
        synchronized (this) {
            try {
                writeLock = this.locks.get(key);
                if (writeLock == null) {
                    writeLock = this.writeLockPool.obtain();
                    this.locks.put(key, writeLock);
                }
                writeLock.interestedThreads++;
            } catch (Throwable th) {
                throw th;
            }
        }
        writeLock.lock.lock();
    }

    public void release(Key key) {
        WriteLock writeLock;
        int i;
        int i2;
        synchronized (this) {
            try {
                writeLock = this.locks.get(key);
                if (writeLock != null && (i2 = writeLock.interestedThreads) > 0) {
                    int i3 = i2 - 1;
                    writeLock.interestedThreads = i3;
                    if (i3 == 0) {
                        WriteLock remove = this.locks.remove(key);
                        if (remove.equals(writeLock)) {
                            this.writeLockPool.offer(remove);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Removed the wrong lock, expected to remove: ");
                            sb.append(writeLock);
                            sb.append(", but actually removed: ");
                            sb.append(remove);
                            sb.append(", key: ");
                            sb.append(key);
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot release a lock that is not held, key: ");
                sb2.append(key);
                sb2.append(", interestedThreads: ");
                if (writeLock == null) {
                    i = 0;
                } else {
                    i = writeLock.interestedThreads;
                }
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
            } finally {
            }
        }
        writeLock.lock.unlock();
    }
}
