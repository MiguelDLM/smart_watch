package Ox0XO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class IIXOooo implements Oxx0xo {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static /* synthetic */ Class f2850II0XooXoX;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final oxO.oxoX f2851Oxx0IOOO;

    /* renamed from: XO, reason: collision with root package name */
    public static final String f2852XO;

    /* renamed from: I0Io, reason: collision with root package name */
    public String f2853I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public SocketFactory f2854II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public int f2855X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Socket f2856oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public int f2857oxoX;

    static {
        Class<IIXOooo> cls = f2850II0XooXoX;
        if (cls == null) {
            cls = IIXOooo.class;
            f2850II0XooXoX = cls;
        }
        String name = cls.getName();
        f2852XO = name;
        f2851Oxx0IOOO = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public IIXOooo(SocketFactory socketFactory, String str, int i, String str2) {
        f2851Oxx0IOOO.xoIox(str2);
        this.f2854II0xO0 = socketFactory;
        this.f2853I0Io = str;
        this.f2857oxoX = i;
    }

    public void II0xO0(int i) {
        this.f2855X0o0xo = i;
    }

    @Override // Ox0XO.Oxx0xo
    public InputStream getInputStream() throws IOException {
        return this.f2856oIX0oI.getInputStream();
    }

    @Override // Ox0XO.Oxx0xo
    public String getServerURI() {
        StringBuffer stringBuffer = new StringBuffer("tcp://");
        stringBuffer.append(this.f2853I0Io);
        stringBuffer.append(":");
        stringBuffer.append(this.f2857oxoX);
        return stringBuffer.toString();
    }

    @Override // Ox0XO.Oxx0xo
    public OutputStream oIX0oI() throws IOException {
        return this.f2856oIX0oI.getOutputStream();
    }

    @Override // Ox0XO.Oxx0xo
    public void start() throws IOException, MqttException {
        try {
            f2851Oxx0IOOO.OOXIXo(f2852XO, "start", "252", new Object[]{this.f2853I0Io, new Integer(this.f2857oxoX), new Long(this.f2855X0o0xo * 1000)});
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f2853I0Io, this.f2857oxoX);
            Socket createSocket = this.f2854II0xO0.createSocket();
            this.f2856oIX0oI = createSocket;
            createSocket.connect(inetSocketAddress, this.f2855X0o0xo * 1000);
        } catch (ConnectException e) {
            f2851Oxx0IOOO.II0xO0(f2852XO, "start", "250", null, e);
            throw new MqttException(32103, e);
        }
    }

    @Override // Ox0XO.Oxx0xo
    public void stop() throws IOException {
        Socket socket = this.f2856oIX0oI;
        if (socket != null) {
            socket.close();
        }
    }
}
