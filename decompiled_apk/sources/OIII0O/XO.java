package OIII0O;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.IIXOooo;
import org.apache.log4j.oO;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public class XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public static /* synthetic */ Class f1604I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static int f1605II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static x0xO0oo f1606oIX0oI;

    static {
        Class cls = f1604I0Io;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.net.SimpleSocketServer");
            f1604I0Io = cls;
        }
        f1606oIX0oI = x0xO0oo.xo0x(cls);
    }

    public static void I0Io(String[] strArr) {
        if (strArr.length == 2) {
            II0xO0(strArr[0], strArr[1]);
        } else {
            oxoX("Wrong number of arguments.");
        }
        try {
            x0xO0oo x0xo0oo = f1606oIX0oI;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Listening on port ");
            stringBuffer.append(f1605II0xO0);
            x0xo0oo.oo0xXOI0I(stringBuffer.toString());
            ServerSocket serverSocket = new ServerSocket(f1605II0xO0);
            while (true) {
                f1606oIX0oI.oo0xXOI0I("Waiting to accept a new client.");
                Socket accept = serverSocket.accept();
                x0xO0oo x0xo0oo2 = f1606oIX0oI;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Connected to client at ");
                stringBuffer2.append(accept.getInetAddress());
                x0xo0oo2.oo0xXOI0I(stringBuffer2.toString());
                f1606oIX0oI.oo0xXOI0I("Starting new socket node.");
                new Thread(new xxIXOIIO(accept, oO.XO())).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void II0xO0(String str, String str2) {
        try {
            f1605II0xO0 = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not interpret port number [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            oxoX(stringBuffer.toString());
        }
        if (str2.endsWith(".xml")) {
            new O0IoXXOx.XO();
            O0IoXXOx.XO.I0Io(str2);
        } else {
            new IIXOooo();
            IIXOooo.I0Io(str2);
        }
    }

    public static /* synthetic */ Class oIX0oI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static void oxoX(String str) {
        PrintStream printStream = System.err;
        printStream.println(str);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Usage: java ");
        Class cls = f1604I0Io;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.net.SimpleSocketServer");
            f1604I0Io = cls;
        }
        stringBuffer.append(cls.getName());
        stringBuffer.append(" port configFile");
        printStream.println(stringBuffer.toString());
        System.exit(1);
    }
}
