package IXIIo;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class ooOOo0oXI extends II0xO0 {
    public ooOOo0oXI(byte b, byte[] bArr) throws IOException {
        super((byte) 5);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f679II0xO0 = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    @Override // IXIIo.IIXOooo
    public byte[] oI0IIXIo() throws MqttException {
        return oOoXoXO();
    }

    public ooOOo0oXI(oO oOVar) {
        super((byte) 5);
        this.f679II0xO0 = oOVar.x0xO0oo();
    }
}
