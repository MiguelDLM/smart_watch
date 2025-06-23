package IXIIo;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class IXxxXO extends II0xO0 {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int[] f681oI0IIXIo;

    public IXxxXO(byte b, byte[] bArr) throws IOException {
        super((byte) 9);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f679II0xO0 = dataInputStream.readUnsignedShort();
        this.f681oI0IIXIo = new int[bArr.length - 2];
        int i = 0;
        for (int read = dataInputStream.read(); read != -1; read = dataInputStream.read()) {
            this.f681oI0IIXIo[i] = read;
            i++;
        }
        dataInputStream.close();
    }

    public int[] O0xOxO() {
        return this.f681oI0IIXIo;
    }

    @Override // IXIIo.IIXOooo
    public byte[] oI0IIXIo() throws MqttException {
        return new byte[0];
    }

    @Override // IXIIo.II0xO0, IXIIo.IIXOooo
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" granted Qos");
        for (int i = 0; i < this.f681oI0IIXIo.length; i++) {
            stringBuffer.append(" ");
            stringBuffer.append(this.f681oI0IIXIo[i]);
        }
        return stringBuffer.toString();
    }
}
