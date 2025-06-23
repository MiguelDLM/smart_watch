package oIX0o;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import org.apache.log4j.x0xO0oo;

/* loaded from: classes6.dex */
public class xoIox {

    /* renamed from: I0Io, reason: collision with root package name */
    public static int f31639I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static String f31640II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static x0xO0oo f31641oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public static /* synthetic */ Class f31642oxoX;

    static {
        Class cls = f31642oxoX;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.varia.Roller");
            f31642oxoX = cls;
        }
        f31641oIX0oI = x0xO0oo.xo0x(cls);
    }

    public static void I0Io(String[] strArr) {
        org.apache.log4j.oxoX.oIX0oI();
        if (strArr.length == 2) {
            II0xO0(strArr[0], strArr[1]);
        } else {
            X0o0xo("Wrong number of arguments.");
        }
        oxoX();
    }

    public static void II0xO0(String str, String str2) {
        f31640II0xO0 = str;
        try {
            f31639I0Io = Integer.parseInt(str2);
        } catch (NumberFormatException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Second argument ");
            stringBuffer.append(str2);
            stringBuffer.append(" is not a valid integer.");
            X0o0xo(stringBuffer.toString());
        }
    }

    public static void X0o0xo(String str) {
        PrintStream printStream = System.err;
        printStream.println(str);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Usage: java ");
        Class cls = f31642oxoX;
        if (cls == null) {
            cls = oIX0oI("org.apache.log4j.varia.Roller");
            f31642oxoX = cls;
        }
        stringBuffer.append(cls.getName());
        stringBuffer.append("host_name port_number");
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

    public static void oxoX() {
        try {
            Socket socket = new Socket(f31640II0xO0, f31639I0Io);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF(II0xO0.f31620Oxx0xo);
            String readUTF = dataInputStream.readUTF();
            if ("OK".equals(readUTF)) {
                f31641oIX0oI.oo0xXOI0I("Roll over signal acknowledged by remote appender.");
            } else {
                x0xO0oo x0xo0oo = f31641oIX0oI;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unexpected return code ");
                stringBuffer.append(readUTF);
                stringBuffer.append(" from remote entity.");
                x0xo0oo.XoX(stringBuffer.toString());
                System.exit(2);
            }
        } catch (IOException e) {
            x0xO0oo x0xo0oo2 = f31641oIX0oI;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not send roll signal on host ");
            stringBuffer2.append(f31640II0xO0);
            stringBuffer2.append(" port ");
            stringBuffer2.append(f31639I0Io);
            stringBuffer2.append(" .");
            x0xo0oo2.x0XOIxOo(stringBuffer2.toString(), e);
            System.exit(2);
        }
        System.exit(0);
    }
}
