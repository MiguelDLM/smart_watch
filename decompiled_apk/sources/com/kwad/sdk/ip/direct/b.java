package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.utils.bo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes11.dex */
public final class b {
    private static Handler aJC = new Handler(Looper.getMainLooper());
    static int aJM = 80;
    static int port = 80;

    /* loaded from: classes11.dex */
    public static class a extends Thread {
        LinkedList aJO = new LinkedList();
        volatile boolean aJP = false;
        Selector aJN = Selector.open();

        public a() {
            setName("Connector");
        }

        private void Jy() {
            synchronized (this.aJO) {
                while (this.aJO.size() > 0) {
                    try {
                        C0868b c0868b = (C0868b) this.aJO.removeFirst();
                        try {
                            c0868b.aJT.register(this.aJN, 8, c0868b);
                        } catch (Throwable th) {
                            c0868b.aJT.close();
                            c0868b.aJU = th;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        private void Jz() {
            Iterator<SelectionKey> it = this.aJN.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0868b c0868b = (C0868b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0868b.aJY = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bo.c(socketChannel);
                    c0868b.aJU = th;
                }
            }
        }

        public final void a(C0868b c0868b) {
            final SocketChannel socketChannel;
            try {
                socketChannel = SocketChannel.open();
            } catch (Throwable th) {
                th = th;
                socketChannel = null;
            }
            try {
                socketChannel.configureBlocking(false);
                boolean connect = socketChannel.connect(c0868b.aJS);
                c0868b.aJT = socketChannel;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                c0868b.aJX = elapsedRealtime;
                if (connect) {
                    c0868b.aJY = elapsedRealtime;
                    bo.c(socketChannel);
                } else {
                    synchronized (this.aJO) {
                        this.aJO.add(c0868b);
                    }
                    Selector selector = this.aJN;
                    if (selector != null) {
                        try {
                            selector.wakeup();
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    bo.c(socketChannel);
                    c0868b.aJU = th;
                    try {
                        b.aJC.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                bo.c(socketChannel);
                            }
                        }, c0868b.aJW);
                    } catch (Throwable unused2) {
                    }
                } finally {
                    try {
                        b.aJC.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                bo.c(socketChannel);
                            }
                        }, c0868b.aJW);
                    } catch (Throwable unused3) {
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.aJN.select() > 0) {
                        Jz();
                    }
                    Jy();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.aJP) {
                    Selector selector = this.aJN;
                    if (selector != null) {
                        try {
                            selector.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    return;
                }
                continue;
            }
        }

        public final void shutdown() {
            this.aJP = true;
            Selector selector = this.aJN;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.kwad.sdk.ip.direct.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0868b {
        InetSocketAddress aJS;
        SocketChannel aJT;
        Throwable aJU;
        private float aJV;
        long aJW;
        long aJX;
        long aJY = 0;
        boolean aJZ = false;
        private boolean success;

        public C0868b(String str) {
            try {
                this.aJS = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.aJU = th;
            }
        }

        public final void JA() {
            String str;
            if (this.aJY != 0) {
                str = Long.toString(this.aJY - this.aJX) + "ms";
                this.aJV = (float) (this.aJY - this.aJX);
                this.success = true;
            } else {
                Throwable th = this.aJU;
                if (th != null) {
                    str = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    str = "Timed out";
                }
            }
            com.kwad.sdk.core.e.c.d("IpDirect_Ping", this.aJS + " : " + str);
            this.aJZ = true;
        }
    }

    public static c f(String str, long j) {
        a aVar;
        long j2 = j / 5;
        com.kwad.sdk.core.e.c.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < cVar.JB(); i++) {
                C0868b c0868b = new C0868b(str);
                c0868b.aJW = j + j2;
                linkedList.add(c0868b);
                try {
                    aVar.a(c0868b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j + j2);
                try {
                    aVar.shutdown();
                    aVar.join();
                    Iterator it = linkedList.iterator();
                    boolean z = true;
                    float f = 0.0f;
                    while (it.hasNext()) {
                        C0868b c0868b2 = (C0868b) it.next();
                        c0868b2.JA();
                        z &= c0868b2.success;
                        cVar.bC(z);
                        f += c0868b2.aJV;
                    }
                    com.kwad.sdk.core.e.c.d("IpDirect_Ping", "sum:" + f + "*size:" + linkedList.size());
                    cVar.k(f / ((float) linkedList.size()));
                    return cVar;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }
}
