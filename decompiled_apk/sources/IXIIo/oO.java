package IXIIo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.apache.log4j.spi.LocationInfo;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class oO extends II0XooXoX {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public byte[] f702IIXOooo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public String f703OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public OoOoXO0.Oxx0xo f704oI0IIXIo;

    public oO(String str, OoOoXO0.Oxx0xo oxx0xo) {
        super((byte) 3);
        this.f702IIXOooo = null;
        this.f703OxxIIOOXO = str;
        this.f704oI0IIXIo = oxx0xo;
    }

    public static byte[] O0xOxO(OoOoXO0.Oxx0xo oxx0xo) {
        return oxx0xo.getPayload();
    }

    @Override // IXIIo.IIXOooo
    public byte[] IXxxXO() throws MqttException {
        if (this.f702IIXOooo == null) {
            this.f702IIXOooo = O0xOxO(this.f704oI0IIXIo);
        }
        return this.f702IIXOooo;
    }

    @Override // IXIIo.IIXOooo
    public byte Oo() {
        byte qos = (byte) (this.f704oI0IIXIo.getQos() << 1);
        if (this.f704oI0IIXIo.isRetained()) {
            qos = (byte) (qos | 1);
        }
        if (this.f704oI0IIXIo.isDuplicate() || this.f678I0Io) {
            return (byte) (qos | 8);
        }
        return qos;
    }

    @Override // IXIIo.IIXOooo
    public void OxI(int i) {
        super.OxI(i);
        OoOoXO0.Oxx0xo oxx0xo = this.f704oI0IIXIo;
        if (oxx0xo instanceof x0xO0oo) {
            ((x0xO0oo) oxx0xo).II0xO0(i);
        }
    }

    @Override // IXIIo.IIXOooo
    public boolean OxxIIOOXO() {
        return true;
    }

    public OoOoXO0.Oxx0xo X0IIOO() {
        return this.f704oI0IIXIo;
    }

    public String XI0IXoo() {
        return this.f703OxxIIOOXO;
    }

    @Override // IXIIo.IIXOooo
    public byte[] oI0IIXIo() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            ooOOo0oXI(dataOutputStream, this.f703OxxIIOOXO);
            if (this.f704oI0IIXIo.getQos() > 0) {
                dataOutputStream.writeShort(this.f679II0xO0);
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new MqttException(e);
        }
    }

    @Override // IXIIo.II0XooXoX, OoOoXO0.oI0IIXIo
    public int oIX0oI() {
        try {
            return IXxxXO().length;
        } catch (MqttException unused) {
            return 0;
        }
    }

    @Override // IXIIo.IIXOooo
    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] payload = this.f704oI0IIXIo.getPayload();
        int min = Math.min(payload.length, 20);
        for (int i = 0; i < min; i++) {
            String hexString = Integer.toHexString(payload[i]);
            if (hexString.length() == 1) {
                StringBuffer stringBuffer2 = new StringBuffer("0");
                stringBuffer2.append(hexString);
                hexString = stringBuffer2.toString();
            }
            stringBuffer.append(hexString);
        }
        try {
            str = new String(payload, 0, min, "UTF-8");
        } catch (Exception unused) {
            str = LocationInfo.NA;
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(super.toString());
        stringBuffer3.append(" qos:");
        stringBuffer3.append(this.f704oI0IIXIo.getQos());
        if (this.f704oI0IIXIo.getQos() > 0) {
            stringBuffer3.append(" msgId:");
            stringBuffer3.append(this.f679II0xO0);
        }
        stringBuffer3.append(" retained:");
        stringBuffer3.append(this.f704oI0IIXIo.isRetained());
        stringBuffer3.append(" dup:");
        stringBuffer3.append(this.f678I0Io);
        stringBuffer3.append(" topic:\"");
        stringBuffer3.append(this.f703OxxIIOOXO);
        stringBuffer3.append("\"");
        stringBuffer3.append(" payload:[hex:");
        stringBuffer3.append(stringBuffer);
        stringBuffer3.append(" utf8:\"");
        stringBuffer3.append(str);
        stringBuffer3.append("\"");
        stringBuffer3.append(" length:");
        stringBuffer3.append(payload.length);
        stringBuffer3.append("]");
        return stringBuffer3.toString();
    }

    public oO(byte b, byte[] bArr) throws MqttException, IOException {
        super((byte) 3);
        this.f702IIXOooo = null;
        x0xO0oo x0xo0oo = new x0xO0oo();
        this.f704oI0IIXIo = x0xo0oo;
        x0xo0oo.setQos(3 & (b >> 1));
        if ((b & 1) == 1) {
            this.f704oI0IIXIo.setRetained(true);
        }
        if ((b & 8) == 8) {
            ((x0xO0oo) this.f704oI0IIXIo).setDuplicate(true);
        }
        oIX0oI oix0oi = new oIX0oI(new ByteArrayInputStream(bArr));
        DataInputStream dataInputStream = new DataInputStream(oix0oi);
        this.f703OxxIIOOXO = xoIox(dataInputStream);
        if (this.f704oI0IIXIo.getQos() > 0) {
            this.f679II0xO0 = dataInputStream.readUnsignedShort();
        }
        byte[] bArr2 = new byte[bArr.length - oix0oi.oIX0oI()];
        dataInputStream.readFully(bArr2);
        dataInputStream.close();
        this.f704oI0IIXIo.setPayload(bArr2);
    }
}
