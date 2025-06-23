package IXIIo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class oxoX extends IIXOooo {

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final String f705XI0IXoo = "Con";

    /* renamed from: IIXOooo, reason: collision with root package name */
    public OoOoXO0.Oxx0xo f706IIXOooo;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public String f707O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public int f708OxI;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public boolean f709OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public int f710X0IIOO;

    /* renamed from: o00, reason: collision with root package name */
    public char[] f711o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public String f712oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public String f713xoXoI;

    public oxoX(byte b, byte[] bArr) throws IOException, MqttException {
        super((byte) 1);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        xoIox(dataInputStream);
        dataInputStream.readByte();
        dataInputStream.readByte();
        this.f708OxI = dataInputStream.readUnsignedShort();
        this.f712oI0IIXIo = xoIox(dataInputStream);
        dataInputStream.close();
    }

    @Override // IXIIo.IIXOooo
    public byte[] IXxxXO() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            ooOOo0oXI(dataOutputStream, this.f712oI0IIXIo);
            if (this.f706IIXOooo != null) {
                ooOOo0oXI(dataOutputStream, this.f707O0xOxO);
                dataOutputStream.writeShort(this.f706IIXOooo.getPayload().length);
                dataOutputStream.write(this.f706IIXOooo.getPayload());
            }
            String str = this.f713xoXoI;
            if (str != null) {
                ooOOo0oXI(dataOutputStream, str);
                char[] cArr = this.f711o00;
                if (cArr != null) {
                    ooOOo0oXI(dataOutputStream, new String(cArr));
                }
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new MqttException(e);
        }
    }

    public boolean O0xOxO() {
        return this.f709OxxIIOOXO;
    }

    @Override // IXIIo.IIXOooo
    public byte Oo() {
        return (byte) 0;
    }

    @Override // IXIIo.IIXOooo
    public boolean OxxIIOOXO() {
        return false;
    }

    @Override // IXIIo.IIXOooo
    public byte[] oI0IIXIo() throws MqttException {
        byte b;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int i = this.f710X0IIOO;
            if (i == 3) {
                ooOOo0oXI(dataOutputStream, "MQIsdp");
            } else if (i == 4) {
                ooOOo0oXI(dataOutputStream, "MQTT");
            }
            dataOutputStream.write(this.f710X0IIOO);
            if (this.f709OxxIIOOXO) {
                b = (byte) 2;
            } else {
                b = 0;
            }
            OoOoXO0.Oxx0xo oxx0xo = this.f706IIXOooo;
            if (oxx0xo != null) {
                b = (byte) (((byte) (b | 4)) | (oxx0xo.getQos() << 3));
                if (this.f706IIXOooo.isRetained()) {
                    b = (byte) (b | 32);
                }
            }
            if (this.f713xoXoI != null) {
                b = (byte) (b | 128);
                if (this.f711o00 != null) {
                    b = (byte) (b | 64);
                }
            }
            dataOutputStream.write(b);
            dataOutputStream.writeShort(this.f708OxI);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new MqttException(e);
        }
    }

    @Override // IXIIo.IIXOooo
    public String oO() {
        return "Con";
    }

    @Override // IXIIo.IIXOooo
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(String.valueOf(super.toString()));
        stringBuffer.append(" clientId ");
        stringBuffer.append(this.f712oI0IIXIo);
        stringBuffer.append(" keepAliveInterval ");
        stringBuffer.append(this.f708OxI);
        return stringBuffer.toString();
    }

    public oxoX(String str, int i, boolean z, int i2, String str2, char[] cArr, OoOoXO0.Oxx0xo oxx0xo, String str3) {
        super((byte) 1);
        this.f712oI0IIXIo = str;
        this.f709OxxIIOOXO = z;
        this.f708OxI = i2;
        this.f713xoXoI = str2;
        this.f711o00 = cArr;
        this.f706IIXOooo = oxx0xo;
        this.f707O0xOxO = str3;
        this.f710X0IIOO = i;
    }
}
