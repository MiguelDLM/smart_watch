package OoOoXO0;

import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class IIXOooo implements II0XooXoX {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Ox0XO.xoXoI f2606oIX0oI;

    public IIXOooo() {
        this.f2606oIX0oI = null;
    }

    @Override // OoOoXO0.II0XooXoX
    public I0Io getActionCallback() {
        return this.f2606oIX0oI.II0xO0();
    }

    @Override // OoOoXO0.II0XooXoX
    public oxoX getClient() {
        return this.f2606oIX0oI.I0Io();
    }

    @Override // OoOoXO0.II0XooXoX
    public MqttException getException() {
        return this.f2606oIX0oI.oxoX();
    }

    @Override // OoOoXO0.II0XooXoX
    public int[] getGrantedQos() {
        return this.f2606oIX0oI.X0o0xo();
    }

    @Override // OoOoXO0.II0XooXoX
    public int getMessageId() {
        return this.f2606oIX0oI.II0XooXoX();
    }

    @Override // OoOoXO0.II0XooXoX
    public IXIIo.IIXOooo getResponse() {
        return this.f2606oIX0oI.xxIXOIIO();
    }

    @Override // OoOoXO0.II0XooXoX
    public boolean getSessionPresent() {
        return this.f2606oIX0oI.xoIox();
    }

    @Override // OoOoXO0.II0XooXoX
    public String[] getTopics() {
        return this.f2606oIX0oI.OOXIXo();
    }

    @Override // OoOoXO0.II0XooXoX
    public Object getUserContext() {
        return this.f2606oIX0oI.oOoXoXO();
    }

    @Override // OoOoXO0.II0XooXoX
    public boolean isComplete() {
        return this.f2606oIX0oI.x0XOIxOo();
    }

    @Override // OoOoXO0.II0XooXoX
    public void setActionCallback(I0Io i0Io) {
        this.f2606oIX0oI.IIXOooo(i0Io);
    }

    @Override // OoOoXO0.II0XooXoX
    public void setUserContext(Object obj) {
        this.f2606oIX0oI.xxX(obj);
    }

    @Override // OoOoXO0.II0XooXoX
    public void waitForCompletion() throws MqttException {
        this.f2606oIX0oI.xXxxox0I(-1L);
    }

    @Override // OoOoXO0.II0XooXoX
    public void waitForCompletion(long j) throws MqttException {
        this.f2606oIX0oI.xXxxox0I(j);
    }

    public IIXOooo(String str) {
        this.f2606oIX0oI = null;
        this.f2606oIX0oI = new Ox0XO.xoXoI(str);
    }
}
