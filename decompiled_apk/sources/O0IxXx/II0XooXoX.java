package O0IxXx;

import android.content.Context;
import android.net.Uri;
import com.garmin.fit.O0Xx;
import com.octopus.ad.internal.b.p;
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
import java.util.concurrent.Executors;

/* loaded from: classes11.dex */
public class II0XooXoX {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Map<String, xxIXOIIO> f1204I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public final oOoXoXO f1205II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final ExecutorService f1206II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final O0IxXx.I0Io f1207Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final int f1208X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final Thread f1209XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final Object f1210oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final ServerSocket f1211oxoX;

    /* loaded from: classes11.dex */
    public final class I0Io implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final Socket f1213XO;

        public I0Io(Socket socket) {
            this.f1213XO = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            II0XooXoX.this.xxIXOIIO(this.f1213XO);
        }
    }

    /* loaded from: classes11.dex */
    public static final class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        public IoXIXo.oIX0oI f1214I0Io = new IoXIXo.Oxx0IOOO(O0Xx.f12382xxX);

        /* renamed from: II0xO0, reason: collision with root package name */
        public IoXIXo.I0Io f1215II0xO0 = new IoXIXo.XO();

        /* renamed from: X0o0xo, reason: collision with root package name */
        public XO f1216X0o0xo = new O0IxXx.oxoX();

        /* renamed from: oIX0oI, reason: collision with root package name */
        public File f1217oIX0oI;

        /* renamed from: oxoX, reason: collision with root package name */
        public xxOXOOoIX.I0Io f1218oxoX;

        public II0xO0(Context context) {
            this.f1218oxoX = xxOXOOoIX.oxoX.II0xO0(context);
            this.f1217oIX0oI = Oxx0xo.oIX0oI(context);
        }

        public final O0IxXx.I0Io I0Io() {
            return new O0IxXx.I0Io(this.f1217oIX0oI, this.f1215II0xO0, this.f1214I0Io, this.f1218oxoX, this.f1216X0o0xo);
        }

        public II0XooXoX II0xO0() {
            return new II0XooXoX(I0Io());
        }

        public II0xO0 oIX0oI(long j) {
            this.f1214I0Io = new IoXIXo.Oxx0IOOO(j);
            return this;
        }
    }

    /* loaded from: classes11.dex */
    public final class oxoX implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final CountDownLatch f1220XO;

        public oxoX(CountDownLatch countDownLatch) {
            this.f1220XO = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1220XO.countDown();
            II0XooXoX.this.OOXIXo();
        }
    }

    public void I0Io(O0IxXx.II0xO0 iI0xO0) {
        ooOOo0oXI.oIX0oI(iI0xO0);
        synchronized (this.f1210oIX0oI) {
            try {
                Iterator<xxIXOIIO> it = this.f1204I0Io.values().iterator();
                while (it.hasNext()) {
                    it.next().X0o0xo(iI0xO0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void II0XooXoX(Throwable th) {
        com.octopus.ad.internal.utilities.oIX0oI.X0o0xo(com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO, "HttpProxyCacheServer error", th);
    }

    public String II0xO0(String str, boolean z) {
        if (z && ooOOo0oXI(str)) {
            File Oo2 = Oo(str);
            Oxx0IOOO(Oo2);
            return Uri.fromFile(Oo2).toString();
        }
        if (xoIox()) {
            return oO(str);
        }
        return str;
    }

    public final void IXxxXO(Socket socket) {
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException e) {
            com.octopus.ad.internal.utilities.oIX0oI.oo(com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO, "Failed to close socket on proxy side: {}. It seems client have already closed connection.", e);
        }
    }

    public final void OOXIXo() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.f1211oxoX.accept();
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO, "Accept new socket " + accept);
                this.f1206II0xO0.submit(new I0Io(accept));
            } catch (IOException e) {
                II0XooXoX(new p("Error during waiting connection", e));
                return;
            }
        }
    }

    public final File Oo(String str) {
        O0IxXx.I0Io i0Io = this.f1207Oxx0IOOO;
        return new File(i0Io.f1202oIX0oI, i0Io.f1200II0xO0.a(str));
    }

    public final void Oxx0IOOO(File file) {
        try {
            this.f1207Oxx0IOOO.f1199I0Io.a(file);
        } catch (IOException e) {
            com.octopus.ad.internal.utilities.oIX0oI.X0o0xo(com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO, "Error touching file " + file, e);
        }
    }

    public final xxIXOIIO Oxx0xo(String str) throws p {
        xxIXOIIO xxixoiio;
        synchronized (this.f1210oIX0oI) {
            try {
                xxixoiio = this.f1204I0Io.get(str);
                if (xxixoiio == null) {
                    xxixoiio = new xxIXOIIO(str, this.f1207Oxx0IOOO);
                    this.f1204I0Io.put(str, xxixoiio);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xxixoiio;
    }

    public final void oI0IIXIo(Socket socket) {
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            II0XooXoX(new p("Error closing socket", e));
        }
    }

    public String oIX0oI(String str) {
        return II0xO0(str, true);
    }

    public final String oO(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.f1208X0o0xo), oO.X0o0xo(str));
    }

    public final void oOoXoXO(Socket socket) {
        x0xO0oo(socket);
        IXxxXO(socket);
        oI0IIXIo(socket);
    }

    public boolean ooOOo0oXI(String str) {
        ooOOo0oXI.II0xO0(str, "Url can't be null!");
        return Oo(str).exists();
    }

    public void oxoX(O0IxXx.II0xO0 iI0xO0, String str) {
        ooOOo0oXI.X0o0xo(iI0xO0, str);
        synchronized (this.f1210oIX0oI) {
            try {
                Oxx0xo(str).II0xO0(iI0xO0);
            } catch (p e) {
                com.octopus.ad.internal.utilities.oIX0oI.oo(com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO, "Error registering cache listener", e);
            }
        }
    }

    public final int x0XOIxOo() {
        int i;
        synchronized (this.f1210oIX0oI) {
            try {
                Iterator<xxIXOIIO> it = this.f1204I0Io.values().iterator();
                i = 0;
                while (it.hasNext()) {
                    i += it.next().oIX0oI();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    public final void x0xO0oo(Socket socket) {
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
        } catch (SocketException unused) {
            com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO, "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            II0XooXoX(new p("Error closing socket input stream", e));
        }
    }

    public final boolean xoIox() {
        return this.f1205II0XooXoX.I0Io(3, 70);
    }

    public final void xxIXOIIO(Socket socket) {
        String str;
        StringBuilder sb;
        try {
            try {
                X0o0xo II0xO02 = X0o0xo.II0xO0(socket.getInputStream());
                com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO, "Request to cache proxy:" + II0xO02);
                String XO2 = oO.XO(II0xO02.f1235oIX0oI);
                if (this.f1205II0XooXoX.X0o0xo(XO2)) {
                    this.f1205II0XooXoX.II0xO0(socket);
                } else {
                    Oxx0xo(XO2).I0Io(II0xO02, socket);
                }
                oOoXoXO(socket);
                str = com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO;
                sb = new StringBuilder();
            } catch (p e) {
                e = e;
                II0XooXoX(new p("Error processing request", e));
                oOoXoXO(socket);
                str = com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO;
                sb = new StringBuilder();
            } catch (SocketException unused) {
                com.octopus.ad.internal.utilities.oIX0oI.oxoX(com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO, "Closing socket… Socket is closed by client.");
                oOoXoXO(socket);
                str = com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO;
                sb = new StringBuilder();
            } catch (IOException e2) {
                e = e2;
                II0XooXoX(new p("Error processing request", e));
                oOoXoXO(socket);
                str = com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO;
                sb = new StringBuilder();
            }
            sb.append("Opened connections: ");
            sb.append(x0XOIxOo());
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(str, sb.toString());
        } catch (Throwable th) {
            oOoXoXO(socket);
            com.octopus.ad.internal.utilities.oIX0oI.II0xO0(com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO, "Opened connections: " + x0XOIxOo());
            throw th;
        }
    }

    public II0XooXoX(O0IxXx.I0Io i0Io) {
        this.f1210oIX0oI = new Object();
        this.f1206II0xO0 = Executors.newFixedThreadPool(8);
        this.f1204I0Io = new ConcurrentHashMap();
        this.f1207Oxx0IOOO = (O0IxXx.I0Io) ooOOo0oXI.oIX0oI(i0Io);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f1211oxoX = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f1208X0o0xo = localPort;
            OOXIXo.oIX0oI("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new oxoX(countDownLatch));
            this.f1209XO = thread;
            thread.start();
            countDownLatch.await();
            this.f1205II0XooXoX = new oOoXoXO("127.0.0.1", localPort);
            com.octopus.ad.internal.utilities.oIX0oI.IIXOooo(com.octopus.ad.internal.utilities.oIX0oI.f18687IXxxXO, "Proxy cache server started. Is it alive? " + xoIox());
        } catch (IOException | InterruptedException e) {
            this.f1206II0xO0.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }
}
