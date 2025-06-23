package Ox0XO;

import java.io.IOException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class OxxIIOOXO extends IIXOooo {

    /* renamed from: oO, reason: collision with root package name */
    public static /* synthetic */ Class f2881oO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final String f2882ooOOo0oXI;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final oxO.oxoX f2883x0XOIxOo;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String f2884OOXIXo;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public int f2885oOoXoXO;

    /* renamed from: xoIox, reason: collision with root package name */
    public int f2886xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public String[] f2887xxIXOIIO;

    static {
        Class<OxxIIOOXO> cls = f2881oO;
        if (cls == null) {
            cls = OxxIIOOXO.class;
            f2881oO = cls;
        }
        String name = cls.getName();
        f2882ooOOo0oXI = name;
        f2883x0XOIxOo = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public OxxIIOOXO(SSLSocketFactory sSLSocketFactory, String str, int i, String str2) {
        super(sSLSocketFactory, str, i, str2);
        this.f2884OOXIXo = str;
        this.f2885oOoXoXO = i;
        f2883x0XOIxOo.xoIox(str2);
    }

    public String[] I0Io() {
        return this.f2887xxIXOIIO;
    }

    public void X0o0xo(int i) {
        super.II0xO0(i);
        this.f2886xoIox = i;
    }

    @Override // Ox0XO.IIXOooo, Ox0XO.Oxx0xo
    public String getServerURI() {
        StringBuffer stringBuffer = new StringBuffer("ssl://");
        stringBuffer.append(this.f2884OOXIXo);
        stringBuffer.append(":");
        stringBuffer.append(this.f2885oOoXoXO);
        return stringBuffer.toString();
    }

    public void oxoX(String[] strArr) {
        this.f2887xxIXOIIO = strArr;
        if (this.f2856oIX0oI != null && strArr != null) {
            if (f2883x0XOIxOo.X0IIOO(5)) {
                String str = "";
                for (int i = 0; i < strArr.length; i++) {
                    if (i > 0) {
                        StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
                        stringBuffer.append(",");
                        str = stringBuffer.toString();
                    }
                    StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(str));
                    stringBuffer2.append(strArr[i]);
                    str = stringBuffer2.toString();
                }
                f2883x0XOIxOo.OOXIXo(f2882ooOOo0oXI, "setEnabledCiphers", "260", new Object[]{str});
            }
            ((SSLSocket) this.f2856oIX0oI).setEnabledCipherSuites(strArr);
        }
    }

    @Override // Ox0XO.IIXOooo, Ox0XO.Oxx0xo
    public void start() throws IOException, MqttException {
        super.start();
        oxoX(this.f2887xxIXOIIO);
        int soTimeout = this.f2856oIX0oI.getSoTimeout();
        if (soTimeout == 0) {
            this.f2856oIX0oI.setSoTimeout(this.f2886xoIox * 1000);
        }
        ((SSLSocket) this.f2856oIX0oI).startHandshake();
        this.f2856oIX0oI.setSoTimeout(soTimeout);
    }
}
