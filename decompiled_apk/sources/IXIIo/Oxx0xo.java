package IXIIo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class Oxx0xo extends IIXOooo {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public int f687IIXOooo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public int[] f688OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public String[] f689oI0IIXIo;

    public Oxx0xo(byte b, byte[] bArr) throws IOException {
        super((byte) 8);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        this.f679II0xO0 = dataInputStream.readUnsignedShort();
        boolean z = false;
        this.f687IIXOooo = 0;
        this.f689oI0IIXIo = new String[10];
        this.f688OxxIIOOXO = new int[10];
        while (!z) {
            try {
                this.f689oI0IIXIo[this.f687IIXOooo] = xoIox(dataInputStream);
                int[] iArr = this.f688OxxIIOOXO;
                int i = this.f687IIXOooo;
                this.f687IIXOooo = i + 1;
                iArr[i] = dataInputStream.readByte();
            } catch (Exception unused) {
                z = true;
            }
        }
        dataInputStream.close();
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
                String[] strArr = this.f689oI0IIXIo;
                if (i >= strArr.length) {
                    dataOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                ooOOo0oXI(dataOutputStream, strArr[i]);
                dataOutputStream.writeByte(this.f688OxxIIOOXO[i]);
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
        for (int i = 0; i < this.f687IIXOooo; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append("\"");
            stringBuffer.append(this.f689oI0IIXIo[i]);
            stringBuffer.append("\"");
        }
        stringBuffer.append("] qos:[");
        for (int i2 = 0; i2 < this.f687IIXOooo; i2++) {
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.f688OxxIIOOXO[i2]);
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public Oxx0xo(String[] strArr, int[] iArr) {
        super((byte) 8);
        this.f689oI0IIXIo = strArr;
        this.f688OxxIIOOXO = iArr;
        if (strArr.length == iArr.length) {
            for (int i : iArr) {
                OoOoXO0.Oxx0xo.validateQos(i);
            }
            return;
        }
        throw new IllegalArgumentException();
    }
}
