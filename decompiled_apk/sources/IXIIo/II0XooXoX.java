package IXIIo;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

/* loaded from: classes6.dex */
public abstract class II0XooXoX extends IIXOooo implements OoOoXO0.oI0IIXIo {
    public II0XooXoX(byte b) {
        super(b);
    }

    @Override // OoOoXO0.oI0IIXIo
    public int I0Io() throws MqttPersistenceException {
        return II0xO0().length;
    }

    @Override // OoOoXO0.oI0IIXIo
    public byte[] II0xO0() throws MqttPersistenceException {
        try {
            return x0XOIxOo();
        } catch (MqttException e) {
            throw new MqttPersistenceException(e.getCause());
        }
    }

    @Override // OoOoXO0.oI0IIXIo
    public int X0o0xo() throws MqttPersistenceException {
        return 0;
    }

    @Override // OoOoXO0.oI0IIXIo
    public byte[] XO() throws MqttPersistenceException {
        try {
            return IXxxXO();
        } catch (MqttException e) {
            throw new MqttPersistenceException(e.getCause());
        }
    }

    @Override // OoOoXO0.oI0IIXIo
    public int oIX0oI() throws MqttPersistenceException {
        return 0;
    }

    @Override // OoOoXO0.oI0IIXIo
    public int oxoX() throws MqttPersistenceException {
        return 0;
    }
}
