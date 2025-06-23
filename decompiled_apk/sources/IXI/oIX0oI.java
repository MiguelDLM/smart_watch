package IXI;

import OoOoXO0.oI0IIXIo;
import OoOoXO0.oO;
import java.util.Enumeration;
import java.util.Hashtable;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

/* loaded from: classes6.dex */
public class oIX0oI implements oO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Hashtable f651oIX0oI;

    @Override // OoOoXO0.oO
    public boolean I0Io(String str) throws MqttPersistenceException {
        return this.f651oIX0oI.containsKey(str);
    }

    @Override // OoOoXO0.oO
    public void II0xO0(String str, oI0IIXIo oi0iixio) throws MqttPersistenceException {
        this.f651oIX0oI.put(str, oi0iixio);
    }

    @Override // OoOoXO0.oO
    public void clear() throws MqttPersistenceException {
        this.f651oIX0oI.clear();
    }

    @Override // OoOoXO0.oO
    public void close() throws MqttPersistenceException {
        this.f651oIX0oI.clear();
    }

    @Override // OoOoXO0.oO
    public oI0IIXIo get(String str) throws MqttPersistenceException {
        return (oI0IIXIo) this.f651oIX0oI.get(str);
    }

    @Override // OoOoXO0.oO
    public Enumeration keys() throws MqttPersistenceException {
        return this.f651oIX0oI.keys();
    }

    @Override // OoOoXO0.oO
    public void oIX0oI(String str, String str2) throws MqttPersistenceException {
        this.f651oIX0oI = new Hashtable();
    }

    @Override // OoOoXO0.oO
    public void remove(String str) throws MqttPersistenceException {
        this.f651oIX0oI.remove(str);
    }
}
