package OIII0O;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import org.apache.log4j.spi.LoggingEvent;

/* loaded from: classes6.dex */
public class Oxx0IOOO extends org.apache.log4j.II0xO0 {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f1576IXxxXO = 1;

    /* renamed from: Oo, reason: collision with root package name */
    public static final int f1577Oo = 30000;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final int f1578x0xO0oo = 4560;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public String f1579II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public ObjectOutputStream f1580OOXIXo;

    /* renamed from: oO, reason: collision with root package name */
    public int f1581oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f1582oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public boolean f1583ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public oIX0oI f1584x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f1585xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public InetAddress f1586xxIXOIIO;

    /* loaded from: classes6.dex */
    public class oIX0oI extends Thread {

        /* renamed from: XO, reason: collision with root package name */
        public boolean f1588XO = false;

        public oIX0oI() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.f1588XO) {
                try {
                    Thread.sleep(Oxx0IOOO.this.f1582oOoXoXO);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Attempting connection to ");
                    stringBuffer.append(Oxx0IOOO.this.f1586xxIXOIIO.getHostName());
                    org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer.toString());
                    Oxx0IOOO oxx0IOOO = Oxx0IOOO.this;
                    Socket socket = new Socket(oxx0IOOO.f1586xxIXOIIO, oxx0IOOO.f1585xoIox);
                    synchronized (this) {
                        Oxx0IOOO.this.f1580OOXIXo = new ObjectOutputStream(socket.getOutputStream());
                        Oxx0IOOO.this.f1584x0XOIxOo = null;
                        org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Connection established. Exiting connector thread.");
                    }
                    return;
                } catch (InterruptedException unused) {
                    org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Connector interrupted. Leaving loop.");
                    return;
                } catch (ConnectException unused2) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Remote host ");
                    stringBuffer2.append(Oxx0IOOO.this.f1586xxIXOIIO.getHostName());
                    stringBuffer2.append(" refused connection.");
                    org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer2.toString());
                } catch (IOException e) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Could not connect to ");
                    stringBuffer3.append(Oxx0IOOO.this.f1586xxIXOIIO.getHostName());
                    stringBuffer3.append(". Exception is ");
                    stringBuffer3.append(e);
                    org.apache.log4j.helpers.xxIXOIIO.oIX0oI(stringBuffer3.toString());
                }
            }
        }
    }

    public Oxx0IOOO() {
        this.f1585xoIox = 4560;
        this.f1582oOoXoXO = 30000;
        this.f1583ooOOo0oXI = false;
        this.f1581oO = 0;
    }

    public static InetAddress XxX0x0xxx(String str) {
        try {
            return InetAddress.getByName(str);
        } catch (Exception e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find address of [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            org.apache.log4j.helpers.xxIXOIIO.oxoX(stringBuffer.toString(), e);
            return null;
        }
    }

    public int IIX0o() {
        return this.f1585xoIox;
    }

    @Override // org.apache.log4j.II0xO0
    public void IIXOooo(LoggingEvent loggingEvent) {
        if (loggingEvent == null) {
            return;
        }
        if (this.f1586xxIXOIIO == null) {
            org.apache.log4j.spi.X0o0xo x0o0xo = this.f33162oxoX;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No remote host is set for SocketAppender named \"");
            stringBuffer.append(this.f33157II0xO0);
            stringBuffer.append("\".");
            x0o0xo.error(stringBuffer.toString());
            return;
        }
        if (this.f1580OOXIXo != null) {
            try {
                if (this.f1583ooOOo0oXI) {
                    loggingEvent.getLocationInformation();
                }
                this.f1580OOXIXo.writeObject(loggingEvent);
                this.f1580OOXIXo.flush();
                int i = this.f1581oO + 1;
                this.f1581oO = i;
                if (i >= 1) {
                    this.f1581oO = 0;
                    this.f1580OOXIXo.reset();
                }
            } catch (IOException e) {
                this.f1580OOXIXo = null;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Detected problem with connection: ");
                stringBuffer2.append(e);
                org.apache.log4j.helpers.xxIXOIIO.Oxx0IOOO(stringBuffer2.toString());
                if (this.f1582oOoXoXO > 0) {
                    xxX();
                }
            }
        }
    }

    public void IoOoX(int i) {
        this.f1582oOoXoXO = i;
    }

    public void XI0IXoo() {
        ObjectOutputStream objectOutputStream = this.f1580OOXIXo;
        if (objectOutputStream != null) {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                org.apache.log4j.helpers.xxIXOIIO.oxoX("Could not close oos.", e);
            }
            this.f1580OOXIXo = null;
        }
        oIX0oI oix0oi = this.f1584x0XOIxOo;
        if (oix0oi != null) {
            oix0oi.f1588XO = true;
            this.f1584x0XOIxOo = null;
        }
    }

    public void XIxXXX0x0(InetAddress inetAddress, int i) {
        if (this.f1586xxIXOIIO == null) {
            return;
        }
        try {
            XI0IXoo();
            this.f1580OOXIXo = new ObjectOutputStream(new Socket(inetAddress, i).getOutputStream());
        } catch (IOException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not connect to remote log4j server at [");
            stringBuffer.append(inetAddress.getHostName());
            stringBuffer.append("].");
            String stringBuffer2 = stringBuffer.toString();
            if (this.f1582oOoXoXO > 0) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append(stringBuffer2);
                stringBuffer3.append(" We will try again later.");
                stringBuffer2 = stringBuffer3.toString();
                xxX();
            }
            org.apache.log4j.helpers.xxIXOIIO.oxoX(stringBuffer2, e);
        }
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public synchronized void close() {
        if (this.f33158Oxx0IOOO) {
            return;
        }
        this.f33158Oxx0IOOO = true;
        XI0IXoo();
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.spi.OOXIXo
    public void oI0IIXIo() {
        XIxXXX0x0(this.f1586xxIXOIIO, this.f1585xoIox);
    }

    public void oOXoIIIo(String str) {
        this.f1586xxIXOIIO = XxX0x0xxx(str);
        this.f1579II0XooXoX = str;
    }

    public void oo(int i) {
        this.f1585xoIox = i;
    }

    public void oo0xXOI0I(boolean z) {
        this.f1583ooOOo0oXI = z;
    }

    @Override // org.apache.log4j.II0xO0, org.apache.log4j.oIX0oI
    public boolean ooOOo0oXI() {
        return false;
    }

    public int ooXIXxIX() {
        return this.f1582oOoXoXO;
    }

    public String xI() {
        return this.f1579II0XooXoX;
    }

    public boolean xXxxox0I() {
        return this.f1583ooOOo0oXI;
    }

    public void xxX() {
        if (this.f1584x0XOIxOo == null) {
            org.apache.log4j.helpers.xxIXOIIO.oIX0oI("Starting a new connector thread.");
            oIX0oI oix0oi = new oIX0oI();
            this.f1584x0XOIxOo = oix0oi;
            oix0oi.setDaemon(true);
            this.f1584x0XOIxOo.setPriority(1);
            this.f1584x0XOIxOo.start();
        }
    }

    public Oxx0IOOO(InetAddress inetAddress, int i) {
        this.f1585xoIox = 4560;
        this.f1582oOoXoXO = 30000;
        this.f1583ooOOo0oXI = false;
        this.f1581oO = 0;
        this.f1586xxIXOIIO = inetAddress;
        this.f1579II0XooXoX = inetAddress.getHostName();
        this.f1585xoIox = i;
        XIxXXX0x0(inetAddress, i);
    }

    public Oxx0IOOO(String str, int i) {
        this.f1582oOoXoXO = 30000;
        this.f1583ooOOo0oXI = false;
        this.f1581oO = 0;
        this.f1585xoIox = i;
        InetAddress XxX0x0xxx2 = XxX0x0xxx(str);
        this.f1586xxIXOIIO = XxX0x0xxx2;
        this.f1579II0XooXoX = str;
        XIxXXX0x0(XxX0x0xxx2, i);
    }
}
