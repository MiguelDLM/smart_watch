package IXIIo;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class OOXIXo extends II0xO0 {
    public OOXIXo(byte b, byte[] bArr) throws IOException {
        super((byte) 4);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f679II0xO0 = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    @Override // IXIIo.IIXOooo
    public byte[] oI0IIXIo() throws MqttException {
        return oOoXoXO();
    }

    public OOXIXo(oO oOVar) {
        super((byte) 4);
        this.f679II0xO0 = oOVar.x0xO0oo();
    }

    public OOXIXo(int i) {
        super((byte) 4);
        this.f679II0xO0 = i;
    }
}
