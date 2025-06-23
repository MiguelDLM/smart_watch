package OIII0O;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class II0XooXoX extends org.apache.log4j.II0xO0 {

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f1525oOoXoXO = 4560;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public int f1526II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public boolean f1527OOXIXo;

    /* renamed from: xoIox, reason: collision with root package name */
    public oIX0oI f1528xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public Vector f1529xxIXOIIO;

    /* loaded from: classes6.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public boolean f1530IXxxXO = true;

        /* renamed from: Oo, reason: collision with root package name */
        public Vector f1531Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public Thread f1532Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public int f1533XO;

        public oIX0oI(int i, Vector vector) {
            this.f1533XO = i;
            this.f1531Oo = vector;
            Thread thread = new Thread(this);
            this.f1532Oxx0xo = thread;
            thread.setDaemon(true);
            this.f1532Oxx0xo.start();
        }

        public synchronized void oIX0oI() {
            if (this.f1530IXxxXO) {
                org.apache.log4j.helpers.xxIXOIIO.oIX0oI("server monitor thread shutting down");
                this.f1530IXxxXO = false;
                try {
                    this.f1532Oxx0xo.join();
                } catch (InterruptedException unused) {
                }
                this.f1532Oxx0xo = null;
                org.apache.log4j.helpers.xxIXOIIO.oIX0oI("server monitor thread shut down");
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0012 A[SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r6 = this;
                java.lang.String r0 = "exception setting timeout, shutting down server socket."
                r1 = 0
                java.net.ServerSocket r2 = new java.net.ServerSocket     // Catch: java.lang.Exception -> L82
                int r3 = r6.f1533XO     // Catch: java.lang.Exception -> L82
                r2.<init>(r3)     // Catch: java.lang.Exception -> L82
                r3 = 1000(0x3e8, float:1.401E-42)
                r2.setSoTimeout(r3)     // Catch: java.lang.Exception -> L82
                r2.setSoTimeout(r3)     // Catch: java.lang.Throwable -> L1f java.net.SocketException -> L76
            L12:
                boolean r0 = r6.f1530IXxxXO     // Catch: java.lang.Throwable -> L1f
                if (r0 != 0) goto L1a
                r2.close()     // Catch: java.io.IOException -> L19
            L19:
                return
            L1a:
                java.net.Socket r0 = r2.accept()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L21 java.net.SocketException -> L28 java.io.InterruptedIOException -> L30
                goto L31
            L1f:
                r0 = move-exception
                goto L7e
            L21:
                r0 = move-exception
                java.lang.String r3 = "exception accepting socket."
                org.apache.log4j.helpers.xxIXOIIO.oxoX(r3, r0)     // Catch: java.lang.Throwable -> L1f
                goto L30
            L28:
                r0 = move-exception
                java.lang.String r3 = "exception accepting socket, shutting down server socket."
                org.apache.log4j.helpers.xxIXOIIO.oxoX(r3, r0)     // Catch: java.lang.Throwable -> L1f
                r6.f1530IXxxXO = r1     // Catch: java.lang.Throwable -> L1f
            L30:
                r0 = 0
            L31:
                if (r0 == 0) goto L12
                java.net.InetAddress r3 = r0.getInetAddress()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                r4.<init>()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                java.lang.String r5 = "accepting connection from "
                r4.append(r5)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                java.lang.String r5 = r3.getHostName()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                r4.append(r5)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                java.lang.String r5 = " ("
                r4.append(r5)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                java.lang.String r3 = r3.getHostAddress()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                r4.append(r3)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                java.lang.String r3 = ")"
                r4.append(r3)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                org.apache.log4j.helpers.xxIXOIIO.oIX0oI(r3)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                java.io.OutputStream r0 = r0.getOutputStream()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                r3.<init>(r0)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                java.util.Vector r0 = r6.f1531Oo     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                r0.addElement(r3)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L6f
                goto L12
            L6f:
                r0 = move-exception
                java.lang.String r3 = "exception creating output stream on socket."
                org.apache.log4j.helpers.xxIXOIIO.oxoX(r3, r0)     // Catch: java.lang.Throwable -> L1f
                goto L12
            L76:
                r1 = move-exception
                org.apache.log4j.helpers.xxIXOIIO.oxoX(r0, r1)     // Catch: java.lang.Throwable -> L1f
                r2.close()     // Catch: java.io.IOException -> L7d
            L7d:
                return
            L7e:
                r2.close()     // Catch: java.io.IOException -> L81
            L81:
                throw r0
            L82:
                r2 = move-exception
                org.apache.log4j.helpers.xxIXOIIO.oxoX(r0, r2)
                r6.f1530IXxxXO = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: OIII0O.II0XooXoX.oIX0oI.run():void");
        }
    }

    public II0XooXoX() {
        this.f1526II0XooXoX = 4560;
        this.f1529xxIXOIIO = new Vector();
        this.f1528xoIox = null;
        this.f1527OOXIXo = false;
    }

    @Override // org.apache.log4j.II0xO0
    public void IIXOooo(LoggingEvent loggingEvent) {
        ObjectOutputStream objectOutputStream;
        if (loggingEvent != null && this.f1529xxIXOIIO.size() != 0) {
            if (this.f1527OOXIXo) {
                loggingEvent.getLocationInformation();
            }
            int i = 0;
            while (i < this.f1529xxIXOIIO.size()) {
                try {
                    objectOutputStream = (ObjectOutputStream) this.f1529xxIXOIIO.elementAt(i);
                } catch (ArrayIndexOutOfBoundsException unused) {
                    objectOutputStream = null;
                }
                if (objectOutputStream == null) {
                    return;
                }
                try {
                    objectOutputStream.writeObject(loggingEvent);
                    objectOutputStream.flush();
                    objectOutputStream.reset();
                } catch (IOException unused2) {
                    this.f1529xxIXOIIO.removeElementAt(i);
                    org.apache.log4j.helpers.xxIXOIIO.oIX0oI("dropped connection");
                    i--;
                }
                i++;
            }
        }
    }

    public void X0IIOO() {
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI("stopping ServerSocket");
        this.f1528xoIox.oIX0oI();
        this.f1528xoIox = null;
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI("closing client connections");
        while (this.f1529xxIXOIIO.size() != 0) {
            ObjectOutputStream objectOutputStream = (ObjectOutputStream) this.f1529xxIXOIIO.elementAt(0);
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    org.apache.log4j.helpers.xxIXOIIO.oxoX("could not close oos.", e);
                }
                this.f1529xxIXOIIO.removeElementAt(0);
            }
        }
    }

    public boolean XI0IXoo() {
        return this.f1527OOXIXo;
    }

    public int XIxXXX0x0() {
        return this.f1526II0XooXoX;
    }

    public void XxX0x0xxx(int i) {
        this.f1526II0XooXoX = i;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public synchronized void close() {
        if (this.f33158Oxx0IOOO) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("closing SocketHubAppender ");
        stringBuffer.append(getName());
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
        this.f33158Oxx0IOOO = true;
        X0IIOO();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("SocketHubAppender ");
        stringBuffer2.append(getName());
        stringBuffer2.append(" closed");
        org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
        xXxxox0I();
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public boolean ooOOo0oXI() {
        return false;
    }

    public final void xXxxox0I() {
        this.f1528xoIox = new oIX0oI(this.f1526II0XooXoX, this.f1529xxIXOIIO);
    }

    public void xxX(boolean z) {
        this.f1527OOXIXo = z;
    }

    public II0XooXoX(int i) {
        this.f1526II0XooXoX = 4560;
        this.f1529xxIXOIIO = new Vector();
        this.f1528xoIox = null;
        this.f1527OOXIXo = false;
        this.f1526II0XooXoX = i;
        xXxxox0I();
    }
}
