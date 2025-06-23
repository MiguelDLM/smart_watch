package OX00o0X;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class ooOOo0oXI extends Thread {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final org.apache.log4j.x0xO0oo f1962IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static /* synthetic */ Class f1963Oxx0xo;

    /* renamed from: Oo, reason: collision with root package name */
    public ServerSocket f1964Oo;

    /* renamed from: XO, reason: collision with root package name */
    public IXxxXO f1965XO;

    /* loaded from: classes6.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final Socket f1967XO;

        public oIX0oI(Socket socket) {
            this.f1967XO = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            ooOOo0oXI.f1962IXxxXO.xxIXOIIO("Starting to get data");
            try {
                while (true) {
                    ooOOo0oXI.this.f1965XO.Oxx0IOOO(new xoIox((LoggingEvent) new ObjectInputStream(this.f1967XO.getInputStream()).readObject()));
                }
            } catch (EOFException unused) {
                ooOOo0oXI.f1962IXxxXO.oo0xXOI0I("Reached EOF, closing connection");
                try {
                    this.f1967XO.close();
                } catch (IOException e) {
                    ooOOo0oXI.f1962IXxxXO.oxXx0IX("Error closing connection", e);
                }
            } catch (IOException e2) {
                ooOOo0oXI.f1962IXxxXO.oxXx0IX("Got IOException, closing connection", e2);
                this.f1967XO.close();
            } catch (ClassNotFoundException e3) {
                ooOOo0oXI.f1962IXxxXO.oxXx0IX("Got ClassNotFoundException, closing connection", e3);
                this.f1967XO.close();
            } catch (SocketException unused2) {
                ooOOo0oXI.f1962IXxxXO.oo0xXOI0I("Caught SocketException, closing connection");
                this.f1967XO.close();
            }
        }
    }

    static {
        Class cls = f1963Oxx0xo;
        if (cls == null) {
            cls = I0Io("org.apache.log4j.chainsaw.LoggingReceiver");
            f1963Oxx0xo = cls;
        }
        f1962IXxxXO = org.apache.log4j.x0xO0oo.xo0x(cls);
    }

    public ooOOo0oXI(IXxxXO iXxxXO, int i) throws IOException {
        setDaemon(true);
        this.f1965XO = iXxxXO;
        this.f1964Oo = new ServerSocket(i);
    }

    public static /* synthetic */ Class I0Io(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        f1962IXxxXO.oo0xXOI0I("Thread started");
        while (true) {
            try {
                org.apache.log4j.x0xO0oo x0xo0oo = f1962IXxxXO;
                x0xo0oo.xxIXOIIO("Waiting for a connection");
                Socket accept = this.f1964Oo.accept();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Got a connection from ");
                stringBuffer.append(accept.getInetAddress().getHostName());
                x0xo0oo.xxIXOIIO(stringBuffer.toString());
                Thread thread = new Thread(new oIX0oI(accept));
                thread.setDaemon(true);
                thread.start();
            } catch (IOException e) {
                f1962IXxxXO.x0XOIxOo("Error in accepting connections, stopping.", e);
                return;
            }
        }
    }
}
