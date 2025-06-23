package OIII0O;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public class xxIXOIIO implements Runnable {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static x0xO0oo f1625Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static /* synthetic */ Class f1626oI0IIXIo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public ObjectInputStream f1627IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public org.apache.log4j.spi.xxIXOIIO f1628Oo;

    /* renamed from: XO, reason: collision with root package name */
    public Socket f1629XO;

    static {
        Class cls = f1626oI0IIXIo;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.net.SocketNode");
            f1626oI0IIXIo = cls;
        }
        f1625Oxx0xo = x0xO0oo.xo0x(cls);
    }

    public xxIXOIIO(Socket socket, org.apache.log4j.spi.xxIXOIIO xxixoiio) {
        this.f1629XO = socket;
        this.f1628Oo = xxixoiio;
        try {
            this.f1627IXxxXO = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (Exception e) {
            x0xO0oo x0xo0oo = f1625Oxx0xo;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not open ObjectInputStream to ");
            stringBuffer.append(socket);
            x0xo0oo.x0XOIxOo(stringBuffer.toString(), e);
        }
    }

    public static /* synthetic */ Class oIX0oI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                LoggingEvent loggingEvent = (LoggingEvent) this.f1627IXxxXO.readObject();
                x0xO0oo xxIXOIIO2 = this.f1628Oo.xxIXOIIO(loggingEvent.getLoggerName());
                if (loggingEvent.getLevel().isGreaterOrEqual(xxIXOIIO2.o00())) {
                    xxIXOIIO2.I0Io(loggingEvent);
                }
            } catch (EOFException unused) {
                f1625Oxx0xo.oo0xXOI0I("Caught java.io.EOFException closing conneciton.");
                try {
                    this.f1627IXxxXO.close();
                    return;
                } catch (Exception e) {
                    f1625Oxx0xo.oo("Could not close connection.", e);
                    return;
                }
            } catch (SocketException unused2) {
                f1625Oxx0xo.oo0xXOI0I("Caught java.net.SocketException closing conneciton.");
                this.f1627IXxxXO.close();
                return;
            } catch (IOException e2) {
                x0xO0oo x0xo0oo = f1625Oxx0xo;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Caught java.io.IOException: ");
                stringBuffer.append(e2);
                x0xo0oo.oo0xXOI0I(stringBuffer.toString());
                f1625Oxx0xo.oo0xXOI0I("Closing connection.");
                this.f1627IXxxXO.close();
                return;
            } catch (Exception e3) {
                f1625Oxx0xo.x0XOIxOo("Unexpected exception. Closing conneciton.", e3);
                this.f1627IXxxXO.close();
                return;
            }
        }
    }
}
