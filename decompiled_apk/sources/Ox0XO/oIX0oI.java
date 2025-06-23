package Ox0XO;

import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class oIX0oI implements x0XOIxOo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ II0xO0 f2918oIX0oI;

    public oIX0oI(II0xO0 iI0xO0) {
        this.f2918oIX0oI = iI0xO0;
    }

    @Override // Ox0XO.x0XOIxOo
    public void oIX0oI(OoOoXO0.oIX0oI oix0oi) throws MqttException {
        if (this.f2918oIX0oI.IoOoX()) {
            while (this.f2918oIX0oI.f2828Oxx0IOOO.OOXIXo() >= this.f2918oIX0oI.f2828Oxx0IOOO.oO() - 1) {
                Thread.yield();
            }
            II0xO0.f2818OxxIIOOXO.OOXIXo(II0xO0.f2821oI0IIXIo, "notifyReconnect", "510", new Object[]{oix0oi.oIX0oI().oO()});
            this.f2918oIX0oI.oo0xXOI0I(oix0oi.oIX0oI(), oix0oi.II0xO0());
            this.f2918oIX0oI.f2828Oxx0IOOO.x0o(oix0oi.oIX0oI());
            return;
        }
        II0xO0.f2818OxxIIOOXO.xxIXOIIO(II0xO0.f2821oI0IIXIo, "notifyReconnect", "208");
        throw oOoXoXO.oIX0oI(32104);
    }
}
