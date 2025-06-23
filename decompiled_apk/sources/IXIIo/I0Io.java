package IXIIo;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class I0Io extends II0xO0 {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final String f659IIXOooo = "Con";

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f660OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public int f661oI0IIXIo;

    public I0Io(byte b, byte[] bArr) throws IOException {
        super((byte) 2);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f660OxxIIOOXO = (dataInputStream.readUnsignedByte() & 1) == 1;
        this.f661oI0IIXIo = dataInputStream.readUnsignedByte();
        dataInputStream.close();
    }

    public int O0xOxO() {
        return this.f661oI0IIXIo;
    }

    @Override // IXIIo.IIXOooo
    public boolean OxxIIOOXO() {
        return false;
    }

    public boolean X0IIOO() {
        return this.f660OxxIIOOXO;
    }

    @Override // IXIIo.IIXOooo
    public byte[] oI0IIXIo() throws MqttException {
        return new byte[0];
    }

    @Override // IXIIo.IIXOooo
    public String oO() {
        return "Con";
    }

    @Override // IXIIo.II0xO0, IXIIo.IIXOooo
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(super.toString()));
        stringBuffer.append(" session present:");
        stringBuffer.append(this.f660OxxIIOOXO);
        stringBuffer.append(" return code: ");
        stringBuffer.append(this.f661oI0IIXIo);
        return stringBuffer.toString();
    }
}
