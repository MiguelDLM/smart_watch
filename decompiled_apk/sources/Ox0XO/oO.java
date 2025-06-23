package Ox0XO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.eclipse.paho.android.service.MqttServiceConstants;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class oO implements Oxx0xo {

    /* renamed from: oxoX, reason: collision with root package name */
    public static /* synthetic */ Class f2919oxoX;

    /* renamed from: I0Io, reason: collision with root package name */
    public Object f2920I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public String f2921II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Class f2922oIX0oI;

    public oO(String str) {
        this.f2921II0xO0 = str;
    }

    @Override // Ox0XO.Oxx0xo
    public InputStream getInputStream() throws IOException {
        try {
            return (InputStream) this.f2922oIX0oI.getMethod("getClientInputStream", null).invoke(this.f2920I0Io, null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // Ox0XO.Oxx0xo
    public String getServerURI() {
        StringBuffer stringBuffer = new StringBuffer("local://");
        stringBuffer.append(this.f2921II0xO0);
        return stringBuffer.toString();
    }

    @Override // Ox0XO.Oxx0xo
    public OutputStream oIX0oI() throws IOException {
        try {
            return (OutputStream) this.f2922oIX0oI.getMethod("getClientOutputStream", null).invoke(this.f2920I0Io, null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 5 */
    @Override // Ox0XO.Oxx0xo
    public void start() throws IOException, MqttException {
        if (oOoXoXO.I0Io("com.ibm.mqttdirect.modules.local.bindings.localListener")) {
            try {
                Class<?> cls = Class.forName("com.ibm.mqttdirect.modules.local.bindings.localListener");
                this.f2922oIX0oI = cls;
                Class<String> cls2 = f2919oxoX;
                if (cls2 == null) {
                    cls2 = String.class;
                    f2919oxoX = cls2;
                }
                this.f2920I0Io = cls.getMethod(MqttServiceConstants.CONNECT_ACTION, cls2).invoke(null, this.f2921II0xO0);
            } catch (Exception unused) {
            }
            if (this.f2920I0Io != null) {
                return;
            } else {
                throw oOoXoXO.oIX0oI(32103);
            }
        }
        throw oOoXoXO.oIX0oI(32103);
    }

    @Override // Ox0XO.Oxx0xo
    public void stop() throws IOException {
        if (this.f2920I0Io != null) {
            try {
                this.f2922oIX0oI.getMethod("close", null).invoke(this.f2920I0Io, null);
            } catch (Exception unused) {
            }
        }
    }
}
