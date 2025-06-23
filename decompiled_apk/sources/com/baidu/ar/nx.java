package com.baidu.ar;

import com.google.firebase.crashlytics.buildtools.api.net.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import javax.net.SocketFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;

/* loaded from: classes7.dex */
public abstract class nx extends nr implements ns, Runnable {
    private ny Ic;
    protected URI Im;
    private nu In;

    /* renamed from: Io, reason: collision with root package name */
    private Socket f5573Io;
    private SocketFactory Ip;
    private OutputStream Iq;
    private Proxy Ir;
    private Thread Is;
    private Thread It;
    private CountDownLatch Iu;
    private CountDownLatch Iv;
    private int Iw;
    private nw Ix;
    private Map<String, String> rU;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        private final nx Iz;

        public a(nx nxVar) {
            this.Iz = nxVar;
        }

        private void dm() {
            try {
                if (nx.this.f5573Io != null) {
                    nx.this.f5573Io.close();
                }
            } catch (IOException e) {
                nx.this.a((ns) this.Iz, (Exception) e);
            }
        }

        private void ji() {
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = nx.this.In.HU.take();
                    nx.this.Iq.write(take.array(), 0, take.limit());
                    nx.this.Iq.flush();
                } catch (InterruptedException unused) {
                    for (ByteBuffer byteBuffer : nx.this.In.HU) {
                        nx.this.Iq.write(byteBuffer.array(), 0, byteBuffer.limit());
                        nx.this.Iq.flush();
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebSocketWriteThread-" + Thread.currentThread().getId());
            try {
                try {
                    ji();
                } catch (IOException e) {
                    nx.this.b(e);
                }
            } finally {
                dm();
                nx.this.Is = null;
            }
        }
    }

    public nx(URI uri) {
        this(uri, new nz());
    }

    private int getPort() {
        int port = this.Im.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.Im.getScheme();
        if ("wss".equals(scheme)) {
            return 443;
        }
        if ("ws".equals(scheme)) {
            return 80;
        }
        throw new IllegalArgumentException("unknown scheme: " + scheme);
    }

    private void jh() {
        String rawPath = this.Im.getRawPath();
        String rawQuery = this.Im.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        if (rawQuery != null) {
            rawPath = rawPath + '?' + rawQuery;
        }
        int port = getPort();
        StringBuilder sb = new StringBuilder();
        sb.append(this.Im.getHost());
        sb.append((port == 80 || port == 443) ? "" : ":" + port);
        String sb2 = sb.toString();
        pd pdVar = new pd();
        pdVar.cH(rawPath);
        pdVar.put("Host", sb2);
        Map<String, String> map = this.rU;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                pdVar.put(entry.getKey(), entry.getValue());
            }
        }
        this.In.a((pb) pdVar);
    }

    private void reset() {
        Thread currentThread = Thread.currentThread();
        if (currentThread == this.Is || currentThread == this.It) {
            throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to insure a successful cleanup.");
        }
        try {
            jg();
            Thread thread = this.Is;
            if (thread != null) {
                thread.interrupt();
                this.Is = null;
            }
            Thread thread2 = this.It;
            if (thread2 != null) {
                thread2.interrupt();
                this.It = null;
            }
            this.Ic.reset();
            Socket socket = this.f5573Io;
            if (socket != null) {
                socket.close();
                this.f5573Io = null;
            }
            this.Iu = new CountDownLatch(1);
            this.Iv = new CountDownLatch(1);
            this.In = new nu(this, this.Ic);
        } catch (Exception e) {
            b(e);
            this.In.f(1006, e.getMessage());
        }
    }

    public abstract void a(int i, String str, boolean z);

    public abstract void a(ph phVar);

    public abstract void al(String str);

    public abstract void b(Exception exc);

    public void cB(String str) {
        this.In.cB(str);
    }

    public void close() {
        if (this.Is != null) {
            this.In.ae(1000);
        }
    }

    public void connect() {
        if (this.It != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        Thread thread = new Thread(this);
        this.It = thread;
        thread.setName("WebSocketConnectReadThread-" + this.It.getId());
        this.It.start();
    }

    public void e(int i, String str, boolean z) {
    }

    public void g(int i, String str) {
    }

    @Override // com.baidu.ar.nr
    public Collection<ns> iV() {
        return Collections.singletonList(this.In);
    }

    public boolean isClosed() {
        return this.In.isClosed();
    }

    public boolean isOpen() {
        return this.In.isOpen();
    }

    public boolean jb() {
        return this.In.jb();
    }

    public void jg() {
        close();
        this.Iv.await();
    }

    public void reconnect() {
        reset();
        connect();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0093 A[Catch: InternalError -> 0x000e, Exception -> 0x0011, TryCatch #4 {Exception -> 0x0011, InternalError -> 0x000e, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x002a, B:9:0x0044, B:12:0x005f, B:14:0x006e, B:15:0x008d, B:17:0x0093, B:18:0x009f, B:42:0x0014, B:44:0x0018, B:45:0x0023, B:47:0x00fe, B:48:0x0103), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0044 A[Catch: InternalError -> 0x000e, Exception -> 0x0011, TryCatch #4 {Exception -> 0x0011, InternalError -> 0x000e, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x002a, B:9:0x0044, B:12:0x005f, B:14:0x006e, B:15:0x008d, B:17:0x0093, B:18:0x009f, B:42:0x0014, B:44:0x0018, B:45:0x0023, B:47:0x00fe, B:48:0x0103), top: B:2:0x0001 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.nx.run():void");
    }

    public void t(byte[] bArr) {
        this.In.t(bArr);
    }

    public nx(URI uri, ny nyVar) {
        this(uri, nyVar, null, 0);
    }

    @Override // com.baidu.ar.nv
    public final void b(ns nsVar) {
    }

    public nx(URI uri, ny nyVar, Map<String, String> map, int i) {
        this.Im = null;
        this.In = null;
        this.f5573Io = null;
        this.Ip = null;
        this.Ir = Proxy.NO_PROXY;
        this.Iu = new CountDownLatch(1);
        this.Iv = new CountDownLatch(1);
        this.Iw = 0;
        this.Ix = null;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (nyVar == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        this.Im = uri;
        this.Ic = nyVar;
        this.Ix = new nw() { // from class: com.baidu.ar.nx.1
            @Override // com.baidu.ar.nw
            public InetAddress a(URI uri2) {
                return InetAddress.getByName(uri2.getHost());
            }
        };
        if (map != null) {
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            this.rU = treeMap;
            treeMap.putAll(map);
        }
        this.Iw = i;
        setTcpNoDelay(false);
        aj(false);
        this.In = new nu(this, nyVar);
    }

    @Override // com.baidu.ar.nv
    public void a(ns nsVar, int i, String str) {
        g(i, str);
    }

    @Override // com.baidu.ar.nv
    public void b(ns nsVar, int i, String str, boolean z) {
        e(i, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(IOException iOException) {
        if (iOException instanceof SSLException) {
            b((Exception) iOException);
        }
        this.In.iZ();
    }

    @Override // com.baidu.ar.nv
    public final void a(ns nsVar, int i, String str, boolean z) {
        iS();
        Thread thread = this.Is;
        if (thread != null) {
            thread.interrupt();
        }
        a(i, str, z);
        this.Iu.countDown();
        this.Iv.countDown();
    }

    @Override // com.baidu.ar.nv
    public final void a(ns nsVar, pf pfVar) {
        iT();
        a((ph) pfVar);
        this.Iu.countDown();
    }

    @Override // com.baidu.ar.nv
    public final void a(ns nsVar, Exception exc) {
        b(exc);
    }

    @Override // com.baidu.ar.nv
    public final void a(ns nsVar, String str) {
        al(str);
    }

    @Override // com.baidu.ar.nv
    public final void a(ns nsVar, ByteBuffer byteBuffer) {
        a(byteBuffer);
    }

    @Override // com.baidu.ar.ns
    public void a(ov ovVar) {
        this.In.a(ovVar);
    }

    public void a(ByteBuffer byteBuffer) {
    }

    public void a(SSLParameters sSLParameters) {
        sSLParameters.setEndpointIdentificationAlgorithm(Constants.Http.HTTPS);
    }
}
