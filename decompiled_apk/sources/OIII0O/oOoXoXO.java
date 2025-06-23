package OIII0O;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.x0XOIxOo;

/* loaded from: classes6.dex */
public class oOoXoXO extends org.apache.log4j.II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public oIX0oI f1607II0XooXoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f1608xxIXOIIO = 23;

    /* loaded from: classes6.dex */
    public class oIX0oI extends Thread {

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public ServerSocket f1611Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public boolean f1613XO = false;

        /* renamed from: Oo, reason: collision with root package name */
        public Vector f1610Oo = new Vector();

        /* renamed from: IXxxXO, reason: collision with root package name */
        public Vector f1609IXxxXO = new Vector();

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public int f1614oI0IIXIo = 20;

        public oIX0oI(int i) throws IOException {
            this.f1611Oxx0xo = new ServerSocket(i);
        }

        public void finalize() {
            Enumeration elements = this.f1609IXxxXO.elements();
            while (elements.hasMoreElements()) {
                try {
                    ((Socket) elements.nextElement()).close();
                } catch (Exception unused) {
                }
            }
            try {
                this.f1611Oxx0xo.close();
            } catch (Exception unused2) {
            }
            this.f1613XO = true;
        }

        public void oIX0oI(String str) {
            Enumeration elements = this.f1609IXxxXO.elements();
            Enumeration elements2 = this.f1610Oo.elements();
            while (elements2.hasMoreElements()) {
                Socket socket = (Socket) elements.nextElement();
                PrintWriter printWriter = (PrintWriter) elements2.nextElement();
                printWriter.print(str);
                if (printWriter.checkError()) {
                    this.f1609IXxxXO.remove(socket);
                    this.f1610Oo.remove(printWriter);
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.f1613XO) {
                try {
                    Socket accept = this.f1611Oxx0xo.accept();
                    PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
                    if (this.f1609IXxxXO.size() < this.f1614oI0IIXIo) {
                        this.f1609IXxxXO.addElement(accept);
                        this.f1610Oo.addElement(printWriter);
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("TelnetAppender v1.0 (");
                        stringBuffer.append(this.f1609IXxxXO.size());
                        stringBuffer.append(" active connections)\r\n\r\n");
                        printWriter.print(stringBuffer.toString());
                        printWriter.flush();
                    } else {
                        printWriter.print("Too many connections.\r\n");
                        printWriter.flush();
                        accept.close();
                    }
                } catch (Exception e) {
                    org.apache.log4j.helpers.xxIXOIIO.oxoX("Encountered error while in SocketHandler loop.", e);
                }
            }
        }
    }

    @Override // org.apache.log4j.II0xO0
    public void IIXOooo(LoggingEvent loggingEvent) {
        String[] throwableStrRep;
        this.f1607II0XooXoX.oIX0oI(this.f33161oIX0oI.oIX0oI(loggingEvent));
        if (this.f33161oIX0oI.Oxx0IOOO() && (throwableStrRep = loggingEvent.getThrowableStrRep()) != null) {
            for (String str : throwableStrRep) {
                this.f1607II0XooXoX.oIX0oI(str);
                this.f1607II0XooXoX.oIX0oI(x0XOIxOo.f33503oIX0oI);
            }
        }
    }

    public int X0IIOO() {
        return this.f1608xxIXOIIO;
    }

    public void XI0IXoo(int i) {
        this.f1608xxIXOIIO = i;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public void close() {
        this.f1607II0XooXoX.finalize();
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
        try {
            oIX0oI oix0oi = new oIX0oI(this.f1608xxIXOIIO);
            this.f1607II0XooXoX = oix0oi;
            oix0oi.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public boolean ooOOo0oXI() {
        return true;
    }
}
