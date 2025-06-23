package IoxX;

import Ox0XO.IIXOooo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import javax.net.SocketFactory;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class X0o0xo extends IIXOooo {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static /* synthetic */ Class f878IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public static final oxO.oxoX f879Oo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final String f880x0xO0oo;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public int f881OOXIXo;

    /* renamed from: oO, reason: collision with root package name */
    public ByteArrayOutputStream f882oO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public PipedInputStream f883oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public XO f884ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public ByteBuffer f885x0XOIxOo;

    /* renamed from: xoIox, reason: collision with root package name */
    public String f886xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String f887xxIXOIIO;

    static {
        Class<X0o0xo> cls = f878IXxxXO;
        if (cls == null) {
            cls = X0o0xo.class;
            f878IXxxXO = cls;
        }
        String name = cls.getName();
        f880x0xO0oo = name;
        f879Oo = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public X0o0xo(SocketFactory socketFactory, String str, String str2, int i, String str3) {
        super(socketFactory, str2, i, str3);
        this.f882oO = new oxoX(this);
        this.f887xxIXOIIO = str;
        this.f886xoIox = str2;
        this.f881OOXIXo = i;
        this.f883oOoXoXO = new PipedInputStream();
        f879Oo.xoIox(str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OutputStream X0o0xo() throws IOException {
        return super.oIX0oI();
    }

    private InputStream oxoX() throws IOException {
        return super.getInputStream();
    }

    @Override // Ox0XO.IIXOooo, Ox0XO.Oxx0xo
    public InputStream getInputStream() throws IOException {
        return this.f883oOoXoXO;
    }

    @Override // Ox0XO.IIXOooo, Ox0XO.Oxx0xo
    public String getServerURI() {
        StringBuffer stringBuffer = new StringBuffer("ws://");
        stringBuffer.append(this.f886xoIox);
        stringBuffer.append(":");
        stringBuffer.append(this.f881OOXIXo);
        return stringBuffer.toString();
    }

    @Override // Ox0XO.IIXOooo, Ox0XO.Oxx0xo
    public OutputStream oIX0oI() throws IOException {
        return this.f882oO;
    }

    @Override // Ox0XO.IIXOooo, Ox0XO.Oxx0xo
    public void start() throws IOException, MqttException {
        super.start();
        new I0Io(oxoX(), X0o0xo(), this.f887xxIXOIIO, this.f886xoIox, this.f881OOXIXo).oIX0oI();
        XO xo2 = new XO(oxoX(), this.f883oOoXoXO);
        this.f884ooOOo0oXI = xo2;
        xo2.oxoX("webSocketReceiver");
    }

    @Override // Ox0XO.IIXOooo, Ox0XO.Oxx0xo
    public void stop() throws IOException {
        X0o0xo().write(new II0xO0((byte) 8, true, com.tencent.connect.common.II0xO0.f26842oIX0oI.getBytes()).oxoX());
        X0o0xo().flush();
        XO xo2 = this.f884ooOOo0oXI;
        if (xo2 != null) {
            xo2.X0o0xo();
        }
        super.stop();
    }
}
