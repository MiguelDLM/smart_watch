package IXIIo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public abstract class IIXOooo {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final byte f662II0XooXoX = 5;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final String f663IXxxXO = "UTF-8";

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final byte f664OOXIXo = 8;

    /* renamed from: Oo, reason: collision with root package name */
    public static final byte f665Oo = 14;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final byte f666Oxx0IOOO = 4;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final String[] f667Oxx0xo = {"reserved", "CONNECT", "CONNACK", "PUBLISH", "PUBACK", "PUBREC", "PUBREL", "PUBCOMP", "SUBSCRIBE", "SUBACK", "UNSUBSCRIBE", "UNSUBACK", "PINGREQ", "PINGRESP", "DISCONNECT"};

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final byte f668X0o0xo = 2;

    /* renamed from: XO, reason: collision with root package name */
    public static final byte f669XO = 3;

    /* renamed from: oO, reason: collision with root package name */
    public static final byte f670oO = 12;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final byte f671oOoXoXO = 9;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public static final byte f672ooOOo0oXI = 10;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final byte f673oxoX = 1;

    /* renamed from: x0XOIxOo, reason: collision with root package name */
    public static final byte f674x0XOIxOo = 11;

    /* renamed from: x0xO0oo, reason: collision with root package name */
    public static final byte f675x0xO0oo = 13;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final byte f676xoIox = 7;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final byte f677xxIXOIIO = 6;

    /* renamed from: I0Io, reason: collision with root package name */
    public boolean f678I0Io = false;

    /* renamed from: II0xO0, reason: collision with root package name */
    public int f679II0xO0 = 0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public byte f680oIX0oI;

    public IIXOooo(byte b) {
        this.f680oIX0oI = b;
    }

    public static IIXOooo II0XooXoX(InputStream inputStream) throws MqttException {
        try {
            DataInputStream dataInputStream = new DataInputStream(new oIX0oI(inputStream));
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            byte b = (byte) (readUnsignedByte >> 4);
            byte b2 = (byte) (readUnsignedByte & 15);
            long oIX0oI2 = (r0.oIX0oI() + xoXoI(dataInputStream).II0xO0()) - r0.oIX0oI();
            byte[] bArr = new byte[0];
            if (oIX0oI2 > 0) {
                int i = (int) oIX0oI2;
                byte[] bArr2 = new byte[i];
                dataInputStream.readFully(bArr2, 0, i);
                bArr = bArr2;
            }
            if (b == 1) {
                return new oxoX(b2, bArr);
            }
            if (b == 3) {
                return new oO(b2, bArr);
            }
            if (b == 4) {
                return new OOXIXo(b2, bArr);
            }
            if (b == 7) {
                return new oOoXoXO(b2, bArr);
            }
            if (b == 2) {
                return new I0Io(b2, bArr);
            }
            if (b == 12) {
                return new xxIXOIIO(b2, bArr);
            }
            if (b == 13) {
                return new xoIox(b2, bArr);
            }
            if (b == 8) {
                return new Oxx0xo(b2, bArr);
            }
            if (b == 9) {
                return new IXxxXO(b2, bArr);
            }
            if (b == 10) {
                return new OxxIIOOXO(b2, bArr);
            }
            if (b == 11) {
                return new oI0IIXIo(b2, bArr);
            }
            if (b == 6) {
                return new x0XOIxOo(b2, bArr);
            }
            if (b == 5) {
                return new ooOOo0oXI(b2, bArr);
            }
            if (b == 14) {
                return new X0o0xo(b2, bArr);
            }
            throw Ox0XO.oOoXoXO.oIX0oI(6);
        } catch (IOException e) {
            throw new MqttException(e);
        }
    }

    public static byte[] OOXIXo(long j) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        do {
            byte b = (byte) (j % 128);
            j /= 128;
            if (j > 0) {
                b = (byte) (b | 128);
            }
            byteArrayOutputStream.write(b);
            i++;
            if (j <= 0) {
                break;
            }
        } while (i < 4);
        return byteArrayOutputStream.toByteArray();
    }

    public static IIXOooo Oxx0IOOO(OoOoXO0.oI0IIXIo oi0iixio) throws MqttException {
        byte[] XO2 = oi0iixio.XO();
        if (XO2 == null) {
            XO2 = new byte[0];
        }
        return II0XooXoX(new xoXoI(oi0iixio.II0xO0(), oi0iixio.oxoX(), oi0iixio.I0Io(), XO2, oi0iixio.X0o0xo(), oi0iixio.oIX0oI()));
    }

    public static o00 xoXoI(DataInputStream dataInputStream) throws IOException {
        long j = 0;
        int i = 0;
        int i2 = 1;
        do {
            i++;
            j += (r5 & Byte.MAX_VALUE) * i2;
            i2 *= 128;
        } while ((dataInputStream.readByte() & 128) != 0);
        return new o00(j, i);
    }

    public static IIXOooo xxIXOIIO(byte[] bArr) throws MqttException {
        return II0XooXoX(new ByteArrayInputStream(bArr));
    }

    public boolean IIXOooo() {
        return false;
    }

    public byte[] IXxxXO() throws MqttException {
        return new byte[0];
    }

    public abstract byte Oo();

    public void OxI(int i) {
        this.f679II0xO0 = i;
    }

    public byte Oxx0xo() {
        return this.f680oIX0oI;
    }

    public boolean OxxIIOOXO() {
        return true;
    }

    public void o00(boolean z) {
        this.f678I0Io = z;
    }

    public abstract byte[] oI0IIXIo() throws MqttException;

    public String oO() {
        return new Integer(x0xO0oo()).toString();
    }

    public byte[] oOoXoXO() throws MqttException {
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

    public void ooOOo0oXI(DataOutputStream dataOutputStream, String str) throws MqttException {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            byte length = (byte) ((bytes.length >>> 8) & 255);
            byte length2 = (byte) (bytes.length & 255);
            dataOutputStream.write(length);
            dataOutputStream.write(length2);
            dataOutputStream.write(bytes);
        } catch (UnsupportedEncodingException e) {
            throw new MqttException(e);
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    public String toString() {
        return f667Oxx0xo[this.f680oIX0oI];
    }

    public byte[] x0XOIxOo() throws MqttException {
        try {
            int Oxx0xo2 = ((Oxx0xo() & 15) << 4) ^ (Oo() & 15);
            byte[] oI0IIXIo2 = oI0IIXIo();
            int length = oI0IIXIo2.length + IXxxXO().length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(Oxx0xo2);
            dataOutputStream.write(OOXIXo(length));
            dataOutputStream.write(oI0IIXIo2);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new MqttException(e);
        }
    }

    public int x0xO0oo() {
        return this.f679II0xO0;
    }

    public String xoIox(DataInputStream dataInputStream) throws MqttException {
        try {
            byte[] bArr = new byte[dataInputStream.readUnsignedShort()];
            dataInputStream.readFully(bArr);
            return new String(bArr, "UTF-8");
        } catch (IOException e) {
            throw new MqttException(e);
        }
    }
}
