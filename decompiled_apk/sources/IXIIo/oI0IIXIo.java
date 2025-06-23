package IXIIo;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class oI0IIXIo extends II0xO0 {
    public oI0IIXIo(byte b, byte[] bArr) throws IOException {
        super((byte) 11);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f679II0xO0 = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }

    @Override // IXIIo.IIXOooo
    public byte[] oI0IIXIo() throws MqttException {
        return new byte[0];
    }
}
