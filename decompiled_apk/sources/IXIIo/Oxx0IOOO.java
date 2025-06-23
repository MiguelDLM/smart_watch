package IXIIo;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.paho.client.mqttv3.MqttException;

/* loaded from: classes6.dex */
public class Oxx0IOOO extends OutputStream {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final String f682IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final oxO.oxoX f683Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static /* synthetic */ Class f684oI0IIXIo;

    /* renamed from: Oo, reason: collision with root package name */
    public BufferedOutputStream f685Oo;

    /* renamed from: XO, reason: collision with root package name */
    public Ox0XO.oxoX f686XO;

    static {
        Class<Oxx0IOOO> cls = f684oI0IIXIo;
        if (cls == null) {
            cls = Oxx0IOOO.class;
            f684oI0IIXIo = cls;
        }
        String name = cls.getName();
        f682IXxxXO = name;
        f683Oxx0xo = oxO.X0o0xo.oIX0oI(oxO.X0o0xo.f33551oIX0oI, name);
    }

    public Oxx0IOOO(Ox0XO.oxoX oxox, OutputStream outputStream) {
        this.f686XO = oxox;
        this.f685Oo = new BufferedOutputStream(outputStream);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f685Oo.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f685Oo.flush();
    }

    public void oIX0oI(IIXOooo iIXOooo) throws IOException, MqttException {
        byte[] x0XOIxOo2 = iIXOooo.x0XOIxOo();
        byte[] IXxxXO2 = iIXOooo.IXxxXO();
        this.f685Oo.write(x0XOIxOo2, 0, x0XOIxOo2.length);
        this.f686XO.xxX(x0XOIxOo2.length);
        int i = 0;
        while (i < IXxxXO2.length) {
            int min = Math.min(1024, IXxxXO2.length - i);
            this.f685Oo.write(IXxxXO2, i, min);
            i += 1024;
            this.f686XO.xxX(min);
        }
        f683Oxx0xo.OOXIXo(f682IXxxXO, "write", "500", new Object[]{iIXOooo});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f685Oo.write(bArr);
        this.f686XO.xxX(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f685Oo.write(bArr, i, i2);
        this.f686XO.xxX(i2);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f685Oo.write(i);
    }
}
