package IXIIo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class OxxIIOOXO extends IIXOooo {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int f690OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public String[] f691oI0IIXIo;

    public OxxIIOOXO(String[] strArr) {
        super((byte) 10);
        this.f691oI0IIXIo = strArr;
    }

    @Override // IXIIo.IIXOooo
    public boolean IIXOooo() {
        return true;
    }

    @Override // IXIIo.IIXOooo
    public byte[] IXxxXO() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int i = 0;
            while (true) {
                String[] strArr = this.f691oI0IIXIo;
                if (i >= strArr.length) {
                    dataOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                ooOOo0oXI(dataOutputStream, strArr[i]);
                i++;
            }
        } catch (IOException e) {
            throw new MqttException(e);
        }
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
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(this.f679II0xO0);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new MqttException(e);
        }
    }

    @Override // IXIIo.IIXOooo
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        stringBuffer.append(" names:[");
        for (int i = 0; i < this.f690OxxIIOOXO; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            StringBuffer stringBuffer2 = new StringBuffer("\"");
            stringBuffer2.append(this.f691oI0IIXIo[i]);
            stringBuffer2.append("\"");
            stringBuffer.append(stringBuffer2.toString());
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public OxxIIOOXO(byte b, byte[] bArr) throws IOException {
        super((byte) 10);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f679II0xO0 = dataInputStream.readUnsignedShort();
        boolean z = false;
        this.f690OxxIIOOXO = 0;
        this.f691oI0IIXIo = new String[10];
        while (!z) {
            try {
                this.f691oI0IIXIo[this.f690OxxIIOOXO] = xoIox(dataInputStream);
            } catch (Exception unused) {
                z = true;
            }
        }
        dataInputStream.close();
    }
}
