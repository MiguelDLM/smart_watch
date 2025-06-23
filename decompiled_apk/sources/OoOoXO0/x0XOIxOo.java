package OoOoXO0;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

/* loaded from: classes6.dex */
public class x0XOIxOo implements X0o0xo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public long f2637II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public OOXIXo f2638oIX0oI;

    public x0XOIxOo(String str, String str2) throws MqttException {
        this(str, str2, new IXI.oxoX());
    }

    public static String Oxx0IOOO() {
        return OOXIXo.x0xO0oo();
    }

    @Override // OoOoXO0.X0o0xo
    public void I0Io(String str, Oxx0IOOO oxx0IOOO) throws MqttException {
        subscribe(new String[]{str}, new int[]{1}, new Oxx0IOOO[]{oxx0IOOO});
    }

    public String II0XooXoX() {
        return this.f2638oIX0oI.Oxx0xo();
    }

    @Override // OoOoXO0.X0o0xo
    public void II0xO0(String str) throws MqttException {
        subscribe(new String[]{str}, new int[]{1});
    }

    public void OOXIXo() throws MqttException {
        this.f2638oIX0oI.o00();
    }

    @Override // OoOoXO0.X0o0xo
    public II0XooXoX X0o0xo(x0xO0oo x0xo0oo) throws MqttSecurityException, MqttException {
        II0XooXoX connect = this.f2638oIX0oI.connect(x0xo0oo, null, null);
        connect.waitForCompletion(xoIox());
        return connect;
    }

    @Override // OoOoXO0.X0o0xo
    public void XO(String[] strArr) throws MqttException {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = 1;
        }
        subscribe(strArr, iArr);
    }

    @Override // OoOoXO0.X0o0xo
    public void close() throws MqttException {
        this.f2638oIX0oI.close();
    }

    @Override // OoOoXO0.X0o0xo
    public void connect() throws MqttSecurityException, MqttException {
        connect(new x0xO0oo());
    }

    @Override // OoOoXO0.X0o0xo
    public void disconnect() throws MqttException {
        this.f2638oIX0oI.disconnect().waitForCompletion();
    }

    @Override // OoOoXO0.X0o0xo
    public void disconnectForcibly() throws MqttException {
        this.f2638oIX0oI.disconnectForcibly();
    }

    @Override // OoOoXO0.X0o0xo
    public String getClientId() {
        return this.f2638oIX0oI.getClientId();
    }

    @Override // OoOoXO0.X0o0xo
    public XO[] getPendingDeliveryTokens() {
        return this.f2638oIX0oI.getPendingDeliveryTokens();
    }

    @Override // OoOoXO0.X0o0xo
    public String getServerURI() {
        return this.f2638oIX0oI.getServerURI();
    }

    @Override // OoOoXO0.X0o0xo
    public boolean isConnected() {
        return this.f2638oIX0oI.isConnected();
    }

    @Override // OoOoXO0.X0o0xo
    public void messageArrivedComplete(int i, int i2) throws MqttException {
        this.f2638oIX0oI.messageArrivedComplete(i, i2);
    }

    @Override // OoOoXO0.X0o0xo
    public xoXoI oIX0oI(String str) {
        return this.f2638oIX0oI.xoXoI(str);
    }

    public void oOoXoXO(long j) throws IllegalArgumentException {
        if (j >= -1) {
            this.f2637II0xO0 = j;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // OoOoXO0.X0o0xo
    public void oxoX(String[] strArr, Oxx0IOOO[] oxx0IOOOArr) throws MqttException {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = 1;
        }
        subscribe(strArr, iArr, oxx0IOOOArr);
    }

    @Override // OoOoXO0.X0o0xo
    public void publish(String str, byte[] bArr, int i, boolean z) throws MqttException, MqttPersistenceException {
        Oxx0xo oxx0xo = new Oxx0xo(bArr);
        oxx0xo.setQos(i);
        oxx0xo.setRetained(z);
        publish(str, oxx0xo);
    }

    @Override // OoOoXO0.X0o0xo
    public void setCallback(oOoXoXO oooxoxo) {
        this.f2638oIX0oI.setCallback(oooxoxo);
    }

    @Override // OoOoXO0.X0o0xo
    public void setManualAcks(boolean z) {
        this.f2638oIX0oI.setManualAcks(z);
    }

    @Override // OoOoXO0.X0o0xo
    public void subscribe(String str, int i) throws MqttException {
        subscribe(new String[]{str}, new int[]{i});
    }

    @Override // OoOoXO0.X0o0xo
    public void unsubscribe(String str) throws MqttException {
        unsubscribe(new String[]{str});
    }

    public long xoIox() {
        return this.f2637II0xO0;
    }

    public XOx.oIX0oI xxIXOIIO() {
        return this.f2638oIX0oI.oI0IIXIo();
    }

    public x0XOIxOo(String str, String str2, oO oOVar) throws MqttException {
        this.f2638oIX0oI = null;
        this.f2637II0xO0 = -1L;
        this.f2638oIX0oI = new OOXIXo(str, str2, oOVar);
    }

    @Override // OoOoXO0.X0o0xo
    public void connect(x0xO0oo x0xo0oo) throws MqttSecurityException, MqttException {
        this.f2638oIX0oI.connect(x0xo0oo, null, null).waitForCompletion(xoIox());
    }

    @Override // OoOoXO0.X0o0xo
    public void disconnect(long j) throws MqttException {
        this.f2638oIX0oI.disconnect(j, null, null).waitForCompletion();
    }

    @Override // OoOoXO0.X0o0xo
    public void disconnectForcibly(long j) throws MqttException {
        this.f2638oIX0oI.disconnectForcibly(j);
    }

    @Override // OoOoXO0.X0o0xo
    public void subscribe(String[] strArr, int[] iArr) throws MqttException {
        II0XooXoX subscribe = this.f2638oIX0oI.subscribe(strArr, iArr, (Object) null, (I0Io) null);
        subscribe.waitForCompletion(xoIox());
        int[] grantedQos = subscribe.getGrantedQos();
        for (int i = 0; i < grantedQos.length; i++) {
            iArr[i] = grantedQos[i];
        }
        if (grantedQos.length == 1 && iArr[0] == 128) {
            throw new MqttException(128);
        }
    }

    @Override // OoOoXO0.X0o0xo
    public void unsubscribe(String[] strArr) throws MqttException {
        this.f2638oIX0oI.unsubscribe(strArr, (Object) null, (I0Io) null).waitForCompletion(xoIox());
    }

    @Override // OoOoXO0.X0o0xo
    public void disconnectForcibly(long j, long j2) throws MqttException {
        this.f2638oIX0oI.disconnectForcibly(j, j2);
    }

    @Override // OoOoXO0.X0o0xo
    public void publish(String str, Oxx0xo oxx0xo) throws MqttException, MqttPersistenceException {
        this.f2638oIX0oI.publish(str, oxx0xo, (Object) null, (I0Io) null).waitForCompletion(xoIox());
    }

    @Override // OoOoXO0.X0o0xo
    public void subscribe(String str, int i, Oxx0IOOO oxx0IOOO) throws MqttException {
        subscribe(new String[]{str}, new int[]{i}, new Oxx0IOOO[]{oxx0IOOO});
    }

    @Override // OoOoXO0.X0o0xo
    public void subscribe(String[] strArr, int[] iArr, Oxx0IOOO[] oxx0IOOOArr) throws MqttException {
        subscribe(strArr, iArr);
        for (int i = 0; i < strArr.length; i++) {
            this.f2638oIX0oI.f2617IXxxXO.I0oOoX(strArr[i], oxx0IOOOArr[i]);
        }
    }
}
