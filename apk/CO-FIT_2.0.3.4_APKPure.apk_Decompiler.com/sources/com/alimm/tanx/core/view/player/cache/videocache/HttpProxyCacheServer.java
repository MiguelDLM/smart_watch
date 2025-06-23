package com.alimm.tanx.core.view.player.cache.videocache;

import android.content.Context;
import android.net.Uri;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.view.player.cache.videocache.file.DiskUsage;
import com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator;
import com.alimm.tanx.core.view.player.cache.videocache.file.Md5FileNameGenerator;
import com.alimm.tanx.core.view.player.cache.videocache.file.TotalCountLruDiskUsage;
import com.alimm.tanx.core.view.player.cache.videocache.file.TotalSizeLruDiskUsage;
import com.alimm.tanx.core.view.player.cache.videocache.headers.EmptyHeadersInjector;
import com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector;
import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorageFactory;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpProxyCacheServer {
    private static final Logger LOG = LoggerFactory.getLogger("HttpProxyCacheServer");
    private static final String PROXY_HOST = "127.0.0.1";
    private final Object clientsLock;
    private final Map<String, HttpProxyCacheServerClients> clientsMap;
    private final Config config;
    private final Pinger pinger;
    private final int port;
    private final ServerSocket serverSocket;
    private final ExecutorService socketProcessor;
    private final Thread waitConnectionThread;

    public static final class Builder {
        private static final long DEFAULT_MAX_SIZE = 536870912;
        private File cacheRoot;
        private DiskUsage diskUsage = new TotalSizeLruDiskUsage(536870912);
        private FileNameGenerator fileNameGenerator = new Md5FileNameGenerator();
        private HeaderInjector headerInjector = new EmptyHeadersInjector();
        private final SourceInfoStorage sourceInfoStorage;

        public Builder(Context context) {
            this.sourceInfoStorage = SourceInfoStorageFactory.newSourceInfoStorage(context);
            this.cacheRoot = StorageUtils.getIndividualCacheDirectory(context);
        }

        /* access modifiers changed from: private */
        public Config buildConfig() {
            return new Config(this.cacheRoot, this.fileNameGenerator, this.diskUsage, this.sourceInfoStorage, this.headerInjector);
        }

        public HttpProxyCacheServer build() {
            return new HttpProxyCacheServer(buildConfig());
        }

        public Builder cacheDirectory(File file) {
            this.cacheRoot = (File) Preconditions.checkNotNull(file);
            return this;
        }

        public Builder diskUsage(DiskUsage diskUsage2) {
            this.diskUsage = (DiskUsage) Preconditions.checkNotNull(diskUsage2);
            return this;
        }

        public Builder fileNameGenerator(FileNameGenerator fileNameGenerator2) {
            this.fileNameGenerator = (FileNameGenerator) Preconditions.checkNotNull(fileNameGenerator2);
            return this;
        }

        public Builder headerInjector(HeaderInjector headerInjector2) {
            this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(headerInjector2);
            return this;
        }

        public Builder maxCacheFilesCount(int i) {
            this.diskUsage = new TotalCountLruDiskUsage(i);
            return this;
        }

        public Builder maxCacheSize(long j) {
            this.diskUsage = new TotalSizeLruDiskUsage(j);
            return this;
        }
    }

    public final class SocketProcessorRunnable implements Runnable {
        private final Socket socket;

        public SocketProcessorRunnable(Socket socket2) {
            this.socket = socket2;
        }

        public void run() {
            HttpProxyCacheServer.this.processSocket(this.socket);
        }
    }

    public final class WaitRequestsRunnable implements Runnable {
        private final CountDownLatch startSignal;

        public WaitRequestsRunnable(CountDownLatch countDownLatch) {
            this.startSignal = countDownLatch;
        }

        public void run() {
            this.startSignal.countDown();
            HttpProxyCacheServer.this.waitForRequest();
        }
    }

    private String appendToProxyUrl(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", new Object[]{PROXY_HOST, Integer.valueOf(this.port), ProxyCacheUtils.encode(str)});
    }

    private void closeSocket(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket", e));
        }
    }

    private void closeSocketInput(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException unused) {
            LOG.debug("Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    private void closeSocketOutput(Socket socket) {
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException e) {
            LOG.warn("Failed to close socket on proxy side: {}. It seems client have already closed connection.", e.getMessage());
        }
    }

    private HttpProxyCacheServerClients getClients(String str) throws ProxyCacheException {
        HttpProxyCacheServerClients httpProxyCacheServerClients;
        synchronized (this.clientsLock) {
            try {
                httpProxyCacheServerClients = this.clientsMap.get(str);
                if (httpProxyCacheServerClients == null) {
                    httpProxyCacheServerClients = new HttpProxyCacheServerClients(str, this.config);
                    this.clientsMap.put(str, httpProxyCacheServerClients);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return httpProxyCacheServerClients;
    }

    private int getClientsCount() {
        int i;
        synchronized (this.clientsLock) {
            try {
                i = 0;
                for (HttpProxyCacheServerClients clientsCount : this.clientsMap.values()) {
                    i += clientsCount.getClientsCount();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private boolean isAlive() {
        return this.pinger.ping(3, 70);
    }

    private void onError(Throwable th) {
        LOG.error("HttpProxyCacheServer error", th);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00d0, code lost:
        releaseSocket(r7);
        r7 = LOG;
        r7.debug("Opened connections: " + getClientsCount());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00ef, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0051, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x00a7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processSocket(java.net.Socket r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Opened connections: "
            java.io.InputStream r1 = r7.getInputStream()     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            com.alimm.tanx.core.view.player.cache.videocache.GetRequest r1 = com.alimm.tanx.core.view.player.cache.videocache.GetRequest.read(r1)     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r2 = LOG     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            r3.<init>()     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            java.lang.String r4 = "Request to cache proxy:"
            r3.append(r4)     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            r3.append(r1)     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            java.lang.String r3 = r3.toString()     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            r2.debug(r3)     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            java.lang.String r3 = r1.uri     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            java.lang.String r3 = com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.decode(r3)     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            r4.<init>()     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            java.lang.String r5 = "此时的url为："
            r4.append(r5)     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            r4.append(r3)     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            java.lang.String r4 = r4.toString()     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            r2.info(r4)     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            com.alimm.tanx.core.view.player.cache.videocache.Pinger r4 = r6.pinger     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            boolean r4 = r4.isPingRequest(r3)     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            if (r4 == 0) goto L_0x0058
            com.alimm.tanx.core.view.player.cache.videocache.Pinger r1 = r6.pinger     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            r1.responseToPing(r7)     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            goto L_0x005f
        L_0x0051:
            r1 = move-exception
            goto L_0x00d0
        L_0x0054:
            r1 = move-exception
            goto L_0x007d
        L_0x0056:
            r1 = move-exception
            goto L_0x007d
        L_0x0058:
            com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServerClients r3 = r6.getClients(r3)     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
            r3.processRequest(r1, r7)     // Catch:{ SocketException -> 0x00a7, ProxyCacheException -> 0x0056, IOException -> 0x0054 }
        L_0x005f:
            r6.releaseSocket(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            int r0 = r6.getClientsCount()
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.String[] r7 = new java.lang.String[]{r7}
            r2.debug(r7)
            goto L_0x00cf
        L_0x007d:
            com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException r2 = new com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException     // Catch:{ all -> 0x0051 }
            java.lang.String r3 = "Error processing request"
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0051 }
            r6.onError(r2)     // Catch:{ all -> 0x0051 }
            r6.releaseSocket(r7)
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r7 = LOG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            int r0 = r6.getClientsCount()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String[] r0 = new java.lang.String[]{r0}
            r7.debug(r0)
            goto L_0x00cf
        L_0x00a7:
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r1 = LOG     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "Closing socket… Socket is closed by client."
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ all -> 0x0051 }
            r1.debug(r2)     // Catch:{ all -> 0x0051 }
            r6.releaseSocket(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            int r0 = r6.getClientsCount()
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.String[] r7 = new java.lang.String[]{r7}
            r1.debug(r7)
        L_0x00cf:
            return
        L_0x00d0:
            r6.releaseSocket(r7)
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r7 = LOG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            int r0 = r6.getClientsCount()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String[] r0 = new java.lang.String[]{r0}
            r7.debug(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer.processSocket(java.net.Socket):void");
    }

    private void releaseSocket(Socket socket) {
        closeSocketInput(socket);
        closeSocketOutput(socket);
        closeSocket(socket);
    }

    private void shutdownClients() {
        synchronized (this.clientsLock) {
            try {
                for (HttpProxyCacheServerClients shutdown : this.clientsMap.values()) {
                    shutdown.shutdown();
                }
                this.clientsMap.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void touchFileSafely(File file) {
        try {
            this.config.diskUsage.touch(file);
        } catch (IOException e) {
            Logger logger = LOG;
            logger.error("Error touching file " + file, e);
        }
    }

    /* access modifiers changed from: private */
    public void waitForRequest() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.serverSocket.accept();
                Logger logger = LOG;
                logger.info("Accept new socket " + accept);
                this.socketProcessor.submit(new SocketProcessorRunnable(accept));
            } catch (IOException e) {
                onError(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    public File getCacheFile(String str) {
        Config config2 = this.config;
        return new File(config2.cacheRoot, config2.fileNameGenerator.generate(str));
    }

    public File getCacheRoot() {
        return this.config.cacheRoot;
    }

    public String getProxyUrl(String str) {
        return getProxyUrl(str, true);
    }

    public File getTempCacheFile(String str) {
        File file = this.config.cacheRoot;
        return new File(file, this.config.fileNameGenerator.generate(str) + ".download");
    }

    public boolean isCached(String str) {
        Preconditions.checkNotNull(str, "Url can't be null!");
        return getCacheFile(str).exists();
    }

    public void registerCacheListener(CacheListener cacheListener, String str) {
        Preconditions.checkAllNotNull(cacheListener, str);
        synchronized (this.clientsLock) {
            try {
                getClients(str).registerCacheListener(cacheListener);
            } catch (ProxyCacheException e) {
                LOG.warn("Error registering cache listener", e);
            }
        }
    }

    public void shutdown() {
        LOG.info("Shutdown proxy server");
        shutdownClients();
        this.config.sourceInfoStorage.release();
        this.waitConnectionThread.interrupt();
        try {
            if (!this.serverSocket.isClosed()) {
                this.serverSocket.close();
            }
        } catch (IOException e) {
            onError(new ProxyCacheException("Error shutting down proxy server", e));
        }
    }

    public void unregisterCacheListener(CacheListener cacheListener, String str) {
        Preconditions.checkAllNotNull(cacheListener, str);
        synchronized (this.clientsLock) {
            try {
                getClients(str).unregisterCacheListener(cacheListener);
            } catch (ProxyCacheException e) {
                LOG.warn("Error registering cache listener", e);
            }
        }
    }

    public HttpProxyCacheServer(Context context) {
        this(new Builder(context).buildConfig());
    }

    public String getProxyUrl(String str, boolean z) {
        if (!z || !isCached(str)) {
            return isAlive() ? appendToProxyUrl(str) : str;
        }
        File cacheFile = getCacheFile(str);
        touchFileSafely(cacheFile);
        return Uri.fromFile(cacheFile).toString();
    }

    private HttpProxyCacheServer(Config config2) {
        this.clientsLock = new Object();
        this.socketProcessor = Executors.newFixedThreadPool(8);
        this.clientsMap = new ConcurrentHashMap();
        this.config = (Config) Preconditions.checkNotNull(config2);
        try {
            ServerSocket serverSocket2 = new ServerSocket(0, 8, InetAddress.getByName(PROXY_HOST));
            this.serverSocket = serverSocket2;
            int localPort = serverSocket2.getLocalPort();
            this.port = localPort;
            IgnoreHostProxySelector.install(PROXY_HOST, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new WaitRequestsRunnable(countDownLatch));
            this.waitConnectionThread = thread;
            thread.start();
            countDownLatch.await();
            this.pinger = new Pinger(PROXY_HOST, localPort);
            LogUtils.d("Proxy cache server started. Is it alive? " + isAlive(), new String[0]);
        } catch (IOException | InterruptedException e) {
            this.socketProcessor.shutdown();
            LogUtils.e("Error starting local proxy server", e);
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public void unregisterCacheListener(CacheListener cacheListener) {
        Preconditions.checkNotNull(cacheListener);
        synchronized (this.clientsLock) {
            try {
                for (HttpProxyCacheServerClients unregisterCacheListener : this.clientsMap.values()) {
                    unregisterCacheListener.unregisterCacheListener(cacheListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
