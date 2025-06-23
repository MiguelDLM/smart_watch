package com.alimm.tanx.core.view.player.cache.videocache;

import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

class ProxyCache {
    private static final Logger LOG = LoggerFactory.getLogger("ProxyCache");
    private static final int MAX_READ_SOURCE_ATTEMPTS = 1;
    private final Cache cache;
    private volatile int percentsAvailable = -1;
    private final AtomicInteger readSourceErrorsCount;
    private final Source source;
    private volatile Thread sourceReaderThread;
    private final Object stopLock = new Object();
    private volatile boolean stopped;
    private final Object wc = new Object();

    public class SourceReaderRunnable implements Runnable {
        private SourceReaderRunnable() {
        }

        public void run() {
            ProxyCache.this.readSource();
        }
    }

    public ProxyCache(Source source2, Cache cache2) {
        this.source = (Source) Preconditions.checkNotNull(source2);
        this.cache = (Cache) Preconditions.checkNotNull(cache2);
        this.readSourceErrorsCount = new AtomicInteger();
    }

    private void checkReadSourceErrorsCount() throws ProxyCacheException {
        int i = this.readSourceErrorsCount.get();
        if (i >= 1) {
            this.readSourceErrorsCount.set(0);
            throw new ProxyCacheException("Error reading source " + i + " times");
        }
    }

    private void closeSource() {
        try {
            this.source.close();
        } catch (ProxyCacheException e) {
            onError(new ProxyCacheException("Error closing source " + this.source, e));
        }
    }

    private boolean isStopped() {
        if (Thread.currentThread().isInterrupted() || this.stopped) {
            return true;
        }
        return false;
    }

    private void notifyNewCacheDataAvailable(long j, long j2) {
        onCacheAvailable(j, j2);
        synchronized (this.wc) {
            this.wc.notifyAll();
        }
    }

    private void onSourceRead() {
        this.percentsAvailable = 100;
        onCachePercentsAvailableChanged(this.percentsAvailable);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        r2 = r2 + ((long) r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void readSource() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r4 = LOG     // Catch:{ all -> 0x0059 }
            java.lang.String r5 = "开始读取网络数据"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ all -> 0x0059 }
            r4.info(r5)     // Catch:{ all -> 0x0059 }
            com.alimm.tanx.core.view.player.cache.videocache.Cache r4 = r8.cache     // Catch:{ all -> 0x0059 }
            long r2 = r4.available()     // Catch:{ all -> 0x0059 }
            com.alimm.tanx.core.view.player.cache.videocache.Source r4 = r8.source     // Catch:{ all -> 0x0059 }
            r4.open(r2)     // Catch:{ all -> 0x0059 }
            com.alimm.tanx.core.view.player.cache.videocache.Source r4 = r8.source     // Catch:{ all -> 0x0059 }
            long r0 = r4.length()     // Catch:{ all -> 0x0059 }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0059 }
        L_0x0025:
            com.alimm.tanx.core.view.player.cache.videocache.Source r5 = r8.source     // Catch:{ all -> 0x0059 }
            int r5 = r5.read(r4)     // Catch:{ all -> 0x0059 }
            r6 = -1
            if (r5 == r6) goto L_0x005d
            java.lang.Object r6 = r8.stopLock     // Catch:{ all -> 0x0059 }
            monitor-enter(r6)     // Catch:{ all -> 0x0059 }
            boolean r7 = r8.isStopped()     // Catch:{ all -> 0x004b }
            if (r7 == 0) goto L_0x004d
            monitor-exit(r6)     // Catch:{ all -> 0x004b }
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r4 = LOG
            java.lang.String r5 = "读取网络数据结束"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r4.info(r5)
            r8.closeSource()
            r8.notifyNewCacheDataAvailable(r2, r0)
            return
        L_0x004b:
            r4 = move-exception
            goto L_0x005b
        L_0x004d:
            com.alimm.tanx.core.view.player.cache.videocache.Cache r7 = r8.cache     // Catch:{ all -> 0x004b }
            r7.append(r4, r5)     // Catch:{ all -> 0x004b }
            monitor-exit(r6)     // Catch:{ all -> 0x004b }
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.notifyNewCacheDataAvailable(r2, r0)     // Catch:{ all -> 0x0059 }
            goto L_0x0025
        L_0x0059:
            r4 = move-exception
            goto L_0x0076
        L_0x005b:
            monitor-exit(r6)     // Catch:{ all -> 0x004b }
            throw r4     // Catch:{ all -> 0x0059 }
        L_0x005d:
            r8.tryComplete()     // Catch:{ all -> 0x0059 }
            r8.onSourceRead()     // Catch:{ all -> 0x0059 }
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r4 = LOG
            java.lang.String r5 = "读取网络数据结束"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            r4.info(r5)
        L_0x006f:
            r8.closeSource()
            r8.notifyNewCacheDataAvailable(r2, r0)
            goto L_0x0095
        L_0x0076:
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r5 = LOG     // Catch:{ all -> 0x0096 }
            java.lang.String r6 = "读取网络数据异常"
            java.lang.String[] r6 = new java.lang.String[]{r6}     // Catch:{ all -> 0x0096 }
            r5.info(r6)     // Catch:{ all -> 0x0096 }
            java.util.concurrent.atomic.AtomicInteger r6 = r8.readSourceErrorsCount     // Catch:{ all -> 0x0096 }
            r6.incrementAndGet()     // Catch:{ all -> 0x0096 }
            r8.onError(r4)     // Catch:{ all -> 0x0096 }
            java.lang.String r4 = "读取网络数据结束"
            java.lang.String[] r4 = new java.lang.String[]{r4}
            r5.info(r4)
            goto L_0x006f
        L_0x0095:
            return
        L_0x0096:
            r4 = move-exception
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r5 = LOG
            java.lang.String r6 = "读取网络数据结束"
            java.lang.String[] r6 = new java.lang.String[]{r6}
            r5.info(r6)
            r8.closeSource()
            r8.notifyNewCacheDataAvailable(r2, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.view.player.cache.videocache.ProxyCache.readSource():void");
    }

    private synchronized void readSourceAsync() throws ProxyCacheException {
        boolean z;
        try {
            LOG.info("一步读取网络数据");
            if (this.sourceReaderThread == null || this.sourceReaderThread.getState() == Thread.State.TERMINATED) {
                z = false;
            } else {
                z = true;
            }
            if (!this.stopped && !this.cache.isCompleted() && !z) {
                SourceReaderRunnable sourceReaderRunnable = new SourceReaderRunnable();
                this.sourceReaderThread = new Thread(sourceReaderRunnable, "Source reader for " + this.source);
                this.sourceReaderThread.start();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private void tryComplete() throws ProxyCacheException {
        synchronized (this.stopLock) {
            try {
                if (!isStopped() && this.cache.available() == this.source.length()) {
                    this.cache.complete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void waitForSourceData() throws ProxyCacheException {
        synchronized (this.wc) {
            try {
                this.wc.wait(1000);
            } catch (InterruptedException e) {
                throw new ProxyCacheException("Waiting source data is interrupted!", e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onCacheAvailable(long j, long j2) {
        int i;
        boolean z;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 == 0) {
            i = 100;
        } else {
            i = (int) ((((float) j) / ((float) j2)) * 100.0f);
        }
        if (i != this.percentsAvailable) {
            z = true;
        } else {
            z = false;
        }
        if (i2 >= 0 && z) {
            onCachePercentsAvailableChanged(i);
        }
        this.percentsAvailable = i;
    }

    public void onCachePercentsAvailableChanged(int i) {
    }

    public final void onError(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            LOG.debug("ProxyCache is interrupted");
        } else {
            LOG.error("ProxyCache error", th);
        }
    }

    public int read(byte[] bArr, long j, int i) throws ProxyCacheException {
        ProxyCacheUtils.assertBuffer(bArr, j, i);
        while (!this.cache.isCompleted() && this.cache.available() < ((long) i) + j && !this.stopped) {
            readSourceAsync();
            waitForSourceData();
            checkReadSourceErrorsCount();
        }
        LOG.info("开始从缓存中读取数据");
        int read = this.cache.read(bArr, j, i);
        if (this.cache.isCompleted() && this.percentsAvailable != 100) {
            this.percentsAvailable = 100;
            onCachePercentsAvailableChanged(100);
        }
        return read;
    }

    public void shutdown() {
        synchronized (this.stopLock) {
            try {
                Logger logger = LOG;
                logger.info("Shutdown proxy for " + this.source);
                this.stopped = true;
                if (this.sourceReaderThread != null) {
                    this.sourceReaderThread.interrupt();
                }
                this.cache.close();
            } catch (ProxyCacheException e) {
                onError(e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
