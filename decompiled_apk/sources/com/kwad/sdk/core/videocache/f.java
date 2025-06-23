package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.garmin.fit.O0Xx;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.aq;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* loaded from: classes11.dex */
public final class f {
    private final Object aDh;
    private final ExecutorService aDi;
    private final Map<String, g> aDj;
    private final ServerSocket aDk;
    private final Thread aDl;
    private final com.kwad.sdk.core.videocache.c aDm;
    private final int port;

    /* loaded from: classes11.dex */
    public static final class a {
        private File aCT;
        private com.kwad.sdk.core.videocache.d.c aCW;
        private int aCY;
        private Context context;
        private int aCZ = 0;
        private com.kwad.sdk.core.videocache.a.a aCV = new com.kwad.sdk.core.videocache.a.g(O0Xx.f12382xxX);
        private com.kwad.sdk.core.videocache.a.c aCU = new com.kwad.sdk.core.videocache.a.f();
        private com.kwad.sdk.core.videocache.b.b aCX = new com.kwad.sdk.core.videocache.b.a();

        public a(Context context) {
            this.context = context;
            this.aCT = o.bx(context);
        }

        private com.kwad.sdk.core.videocache.c Hc() {
            return new com.kwad.sdk.core.videocache.c(this.aCT, this.aCU, this.aCV, this.aCW, this.aCX, this.aCY, this.aCZ);
        }

        public final f Hb() {
            this.aCW = com.kwad.sdk.core.videocache.d.d.k(this.context, this.aCZ);
            return new f(Hc(), (byte) 0);
        }

        public final a az(long j) {
            this.aCV = new com.kwad.sdk.core.videocache.a.g(O0Xx.f12382xxX);
            return this;
        }

        public final a ds(int i) {
            this.aCY = i;
            return this;
        }

        public final a dt(int i) {
            this.aCZ = i;
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public final class b implements Runnable {
        private final Socket aDn;

        public b(Socket socket) {
            this.aDn = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.aDn);
        }
    }

    /* loaded from: classes11.dex */
    public final class c implements Runnable {
        private final CountDownLatch aDp;

        public c(CountDownLatch countDownLatch) {
            this.aDp = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.aDp.countDown();
                f.this.GZ();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
    }

    public /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b2) {
        this(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.aDk.accept();
                com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "Accept new socket " + accept);
                this.aDi.submit(new b(accept));
            } catch (IOException e) {
                onError(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    private int Ha() {
        int i;
        synchronized (this.aDh) {
            try {
                Iterator<g> it = this.aDj.values().iterator();
                i = 0;
                while (it.hasNext()) {
                    i += it.next().Ha();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private File U(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.aDm;
        return new File(cVar.aCT, cVar.aCU.generate(str));
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private void c(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException unused) {
            com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    private static void d(Socket socket) {
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException unused) {
            com.kwad.sdk.core.e.c.w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private void e(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket", e));
        }
    }

    private String eO(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.port), l.encode(str));
    }

    private File eP(String str) {
        return new File(this.aDm.aCT, this.aDm.aCU.generate(str) + ".download");
    }

    private g eQ(String str) {
        g gVar;
        synchronized (this.aDh) {
            try {
                gVar = this.aDj.get(str);
                if (gVar == null) {
                    gVar = new g(str, this.aDm);
                    this.aDj.put(str, gVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    private String f(String str, boolean z) {
        if (U(str).exists()) {
            File U = U(str);
            r(U);
            return Uri.fromFile(U).toString();
        }
        return eO(str);
    }

    private static void onError(Throwable th) {
        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
    }

    private void r(File file) {
        try {
            this.aDm.aCV.s(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.e.c.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    public final String eK(String str) {
        if (str == null) {
            return "";
        }
        return f(str, true);
    }

    public final boolean eL(String str) {
        aq.av(str, "Url can't be null!");
        return U(str).exists();
    }

    public final boolean eM(String str) {
        aq.av(str, "Url can't be null!");
        if (!eP(str).exists() && !U(str).exists()) {
            return false;
        }
        return true;
    }

    public final boolean eN(String str) {
        g gVar = this.aDj.get(str);
        if (gVar != null) {
            gVar.shutdown();
            this.aDj.remove(str);
            return true;
        }
        return false;
    }

    private f(com.kwad.sdk.core.videocache.c cVar) {
        this.aDh = new Object();
        this.aDi = GlobalThreadPools.Gs();
        this.aDj = new ConcurrentHashMap();
        this.aDm = (com.kwad.sdk.core.videocache.c) aq.checkNotNull(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.aDk = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            i.install("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.aDl = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this.aDi.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public final boolean a(String str, long j, a.C0856a c0856a, AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (eL(str)) {
            return true;
        }
        return com.kwad.sdk.core.network.a.a.a(eO(str), null, c0856a, j, adHttpResponseListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.kwad.sdk.core.videocache.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public void a(Socket socket) {
        ?? r6;
        ?? r0 = "Opened connections: ";
        try {
            try {
                d b2 = d.b(socket.getInputStream());
                com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "Request to cache proxy:" + b2);
                eQ(l.decode(b2.uri)).a(b2, socket);
                b(socket);
                r6 = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e) {
                e = e;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                r6 = new StringBuilder("Opened connections: ");
            } catch (SocketException e2) {
                com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e2.printStackTrace();
                b(socket);
                r6 = new StringBuilder("Opened connections: ");
            } catch (IOException e3) {
                e = e3;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                r6 = new StringBuilder("Opened connections: ");
            }
            r0 = Ha();
            r6.append(r0);
            socket = r6.toString();
            com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", socket);
        } catch (Throwable th) {
            b(socket);
            com.kwad.sdk.core.e.c.d("HttpProxyCacheServer", ((String) r0) + Ha());
            throw th;
        }
    }
}
