package IoxX;

import Ox0XO.OxxIIOOXO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class II0XooXoX extends OxxIIOOXO {

    /* renamed from: OxI, reason: collision with root package name */
    public static /* synthetic */ Class f862OxI;

    /* renamed from: o00, reason: collision with root package name */
    public static final oxO.oxoX f863o00;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final String f864xoXoI;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public ByteArrayOutputStream f865IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public String f866IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public XO f867Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public String f868Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public ByteBuffer f869OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f870oI0IIXIo;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public PipedInputStream f871x0xO0oo;

    static {
        Class<II0XooXoX> cls = f862OxI;
        if (cls == null) {
            cls = II0XooXoX.class;
            f862OxI = cls;
        }
        String name = cls.getName();
        f864xoXoI = name;
        f863o00 = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public II0XooXoX(SSLSocketFactory sSLSocketFactory, String str, String str2, int i, String str3) {
        super(sSLSocketFactory, str2, i, str3);
        this.f865IIXOooo = new Oxx0IOOO(this);
        this.f866IXxxXO = str;
        this.f868Oxx0xo = str2;
        this.f870oI0IIXIo = i;
        this.f871x0xO0oo = new PipedInputStream();
        f863o00.xoIox(str3);
    }

    public final OutputStream II0XooXoX() throws IOException {
        return super.oIX0oI();
    }

    public final InputStream Oxx0IOOO() throws IOException {
        return super.getInputStream();
    }

    @Override // Ox0XO.IIXOooo, Ox0XO.Oxx0xo
    public InputStream getInputStream() throws IOException {
        return this.f871x0xO0oo;
    }

    @Override // Ox0XO.OxxIIOOXO, Ox0XO.IIXOooo, Ox0XO.Oxx0xo
    public String getServerURI() {
        StringBuffer stringBuffer = new StringBuffer("wss://");
        stringBuffer.append(this.f868Oxx0xo);
        stringBuffer.append(":");
        stringBuffer.append(this.f870oI0IIXIo);
        return stringBuffer.toString();
    }

    @Override // Ox0XO.IIXOooo, Ox0XO.Oxx0xo
    public OutputStream oIX0oI() throws IOException {
        return this.f865IIXOooo;
    }

    @Override // Ox0XO.OxxIIOOXO, Ox0XO.IIXOooo, Ox0XO.Oxx0xo
    public void start() throws IOException, MqttException {
        super.start();
        new I0Io(super.getInputStream(), super.oIX0oI(), this.f866IXxxXO, this.f868Oxx0xo, this.f870oI0IIXIo).oIX0oI();
        XO xo2 = new XO(Oxx0IOOO(), this.f871x0xO0oo);
        this.f867Oo = xo2;
        xo2.oxoX("WssSocketReceiver");
    }

    @Override // Ox0XO.IIXOooo, Ox0XO.Oxx0xo
    public void stop() throws IOException {
        II0XooXoX().write(new II0xO0((byte) 8, true, com.tencent.connect.common.II0xO0.f26842oIX0oI.getBytes()).oxoX());
        II0XooXoX().flush();
        XO xo2 = this.f867Oo;
        if (xo2 != null) {
            xo2.X0o0xo();
        }
        super.stop();
    }
}
