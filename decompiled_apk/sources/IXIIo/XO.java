package IXIIo;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class XO extends InputStream {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final String f693IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final oxO.oxoX f694Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static /* synthetic */ Class f695oI0IIXIo;

    /* renamed from: Oo, reason: collision with root package name */
    public DataInputStream f696Oo;

    /* renamed from: XO, reason: collision with root package name */
    public Ox0XO.oxoX f697XO;

    static {
        Class<XO> cls = f695oI0IIXIo;
        if (cls == null) {
            cls = XO.class;
            f695oI0IIXIo = cls;
        }
        String name = cls.getName();
        f693IXxxXO = name;
        f694Oxx0xo = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public XO(Ox0XO.oxoX oxox, InputStream inputStream) {
        this.f697XO = oxox;
        this.f696Oo = new DataInputStream(inputStream);
    }

    public IIXOooo II0xO0() throws IOException, MqttException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte readByte = this.f696Oo.readByte();
        this.f697XO.O0xOxO(1);
        byte b = (byte) ((readByte >>> 4) & 15);
        if (b >= 1 && b <= 14) {
            long II0xO02 = IIXOooo.xoXoI(this.f696Oo).II0xO0();
            byteArrayOutputStream.write(readByte);
            byteArrayOutputStream.write(IIXOooo.OOXIXo(II0xO02));
            int size = (int) (byteArrayOutputStream.size() + II0xO02);
            byte[] bArr = new byte[size];
            oIX0oI(bArr, byteArrayOutputStream.size(), size - byteArrayOutputStream.size());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            System.arraycopy(byteArray, 0, bArr, 0, byteArray.length);
            IIXOooo xxIXOIIO2 = IIXOooo.xxIXOIIO(bArr);
            f694Oxx0xo.OOXIXo(f693IXxxXO, "readMqttWireMessage", "501", new Object[]{xxIXOIIO2});
            return xxIXOIIO2;
        }
        throw Ox0XO.oOoXoXO.oIX0oI(32108);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f696Oo.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f696Oo.close();
    }

    public final void oIX0oI(byte[] bArr, int i, int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = 0;
            while (i3 < i2) {
                int read = this.f696Oo.read(bArr, i + i3, i2 - i3);
                this.f697XO.O0xOxO(read);
                if (read >= 0) {
                    i3 += read;
                } else {
                    throw new EOFException();
                }
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f696Oo.read();
    }
}
