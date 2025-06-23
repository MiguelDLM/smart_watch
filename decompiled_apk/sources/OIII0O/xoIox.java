package OIII0O;

import java.io.File;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import org.apache.log4j.IIXOooo;
import org.apache.log4j.Level;
import org.apache.log4j.OxxIIOOXO;
import org.apache.log4j.ooOOo0oXI;
import org.apache.log4j.spi.oO;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public class xoIox {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static int f1616II0XooXoX = 0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static xoIox f1617Oxx0IOOO = null;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static String f1618X0o0xo = ".lcf";

    /* renamed from: XO, reason: collision with root package name */
    public static x0xO0oo f1619XO = null;

    /* renamed from: oxoX, reason: collision with root package name */
    public static String f1620oxoX = "generic";

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static /* synthetic */ Class f1621xxIXOIIO;

    /* renamed from: I0Io, reason: collision with root package name */
    public File f1622I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public org.apache.log4j.spi.xxIXOIIO f1623II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Hashtable f1624oIX0oI = new Hashtable(11);

    static {
        Class cls = f1621xxIXOIIO;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.net.SocketServer");
            f1621xxIXOIIO = cls;
        }
        f1619XO = x0xO0oo.xo0x(cls);
    }

    public xoIox(File file) {
        this.f1622I0Io = file;
    }

    public static void X0o0xo(String[] strArr) {
        if (strArr.length == 3) {
            oxoX(strArr[0], strArr[1], strArr[2]);
        } else {
            XO("Wrong number of arguments.");
        }
        try {
            x0xO0oo x0xo0oo = f1619XO;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Listening on port ");
            stringBuffer.append(f1616II0XooXoX);
            x0xo0oo.oo0xXOI0I(stringBuffer.toString());
            ServerSocket serverSocket = new ServerSocket(f1616II0XooXoX);
            while (true) {
                f1619XO.oo0xXOI0I("Waiting to accept a new client.");
                Socket accept = serverSocket.accept();
                InetAddress inetAddress = accept.getInetAddress();
                x0xO0oo x0xo0oo2 = f1619XO;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Connected to client at ");
                stringBuffer2.append(inetAddress);
                x0xo0oo2.oo0xXOI0I(stringBuffer2.toString());
                org.apache.log4j.spi.xxIXOIIO xxixoiio = (org.apache.log4j.spi.xxIXOIIO) f1617Oxx0IOOO.f1624oIX0oI.get(inetAddress);
                if (xxixoiio == null) {
                    xxixoiio = f1617Oxx0IOOO.II0xO0(inetAddress);
                }
                f1619XO.oo0xXOI0I("Starting new socket node.");
                new Thread(new xxIXOIIO(accept, xxixoiio)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void XO(String str) {
        PrintStream printStream = System.err;
        printStream.println(str);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Usage: java ");
        Class cls = f1621xxIXOIIO;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.net.SocketServer");
            f1621xxIXOIIO = cls;
        }
        stringBuffer.append(cls.getName());
        stringBuffer.append(" port configFile directory");
        printStream.println(stringBuffer.toString());
        System.exit(1);
    }

    public static /* synthetic */ Class oIX0oI(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static void oxoX(String str, String str2, String str3) {
        try {
            f1616II0XooXoX = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not interpret port number [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            XO(stringBuffer.toString());
        }
        IIXOooo.I0Io(str2);
        File file = new File(str3);
        if (!file.isDirectory()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("[");
            stringBuffer2.append(str3);
            stringBuffer2.append("] is not a directory.");
            XO(stringBuffer2.toString());
        }
        f1617Oxx0IOOO = new xoIox(file);
    }

    public org.apache.log4j.spi.xxIXOIIO I0Io() {
        if (this.f1623II0xO0 == null) {
            File file = this.f1622I0Io;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(f1620oxoX);
            stringBuffer.append(f1618X0o0xo);
            File file2 = new File(file, stringBuffer.toString());
            if (file2.exists()) {
                this.f1623II0xO0 = new ooOOo0oXI(new oO((Level) OxxIIOOXO.DEBUG));
                new IIXOooo().xoIox(file2.getAbsolutePath(), this.f1623II0xO0);
            } else {
                x0xO0oo x0xo0oo = f1619XO;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not find config file [");
                stringBuffer2.append(file2);
                stringBuffer2.append("]. Will use the default hierarchy.");
                x0xo0oo.XoX(stringBuffer2.toString());
                this.f1623II0xO0 = org.apache.log4j.oO.XO();
            }
        }
        return this.f1623II0xO0;
    }

    public org.apache.log4j.spi.xxIXOIIO II0xO0(InetAddress inetAddress) {
        x0xO0oo x0xo0oo = f1619XO;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Locating configuration file for ");
        stringBuffer.append(inetAddress);
        x0xo0oo.oo0xXOI0I(stringBuffer.toString());
        String inetAddress2 = inetAddress.toString();
        int indexOf = inetAddress2.indexOf("/");
        if (indexOf == -1) {
            x0xO0oo x0xo0oo2 = f1619XO;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not parse the inetAddress [");
            stringBuffer2.append(inetAddress);
            stringBuffer2.append("]. Using default hierarchy.");
            x0xo0oo2.XoX(stringBuffer2.toString());
            return I0Io();
        }
        String substring = inetAddress2.substring(0, indexOf);
        File file = this.f1622I0Io;
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(substring);
        stringBuffer3.append(f1618X0o0xo);
        File file2 = new File(file, stringBuffer3.toString());
        if (file2.exists()) {
            ooOOo0oXI ooooo0oxi = new ooOOo0oXI(new oO((Level) OxxIIOOXO.DEBUG));
            this.f1624oIX0oI.put(inetAddress, ooooo0oxi);
            new IIXOooo().xoIox(file2.getAbsolutePath(), ooooo0oxi);
            return ooooo0oxi;
        }
        x0xO0oo x0xo0oo3 = f1619XO;
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("Could not find config file [");
        stringBuffer4.append(file2);
        stringBuffer4.append("].");
        x0xo0oo3.XoX(stringBuffer4.toString());
        return I0Io();
    }
}
