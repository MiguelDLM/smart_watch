package IXIIo;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class x0XOIxOo extends II0XooXoX {
    public x0XOIxOo(ooOOo0oXI ooooo0oxi) {
        super((byte) 6);
        OxI(ooooo0oxi.x0xO0oo());
    }

    @Override // IXIIo.IIXOooo
    public byte Oo() {
        int i;
        if (this.f678I0Io) {
            i = 8;
        } else {
            i = 0;
        }
        return (byte) (i | 2);
    }

    @Override // IXIIo.IIXOooo
    public byte[] oI0IIXIo() throws MqttException {
        return oOoXoXO();
    }

    @Override // IXIIo.IIXOooo
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(super.toString()));
        stringBuffer.append(" msgId ");
        stringBuffer.append(this.f679II0xO0);
        return stringBuffer.toString();
    }

    public x0XOIxOo(byte b, byte[] bArr) throws IOException {
        super((byte) 6);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f679II0xO0 = dataInputStream.readUnsignedShort();
        dataInputStream.close();
    }
}
