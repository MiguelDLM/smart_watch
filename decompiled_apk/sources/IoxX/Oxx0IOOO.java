package IoxX;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class Oxx0IOOO extends ByteArrayOutputStream {

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ II0XooXoX f877XO;

    public Oxx0IOOO(II0XooXoX iI0XooXoX) {
        this.f877XO = iI0XooXoX;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ByteBuffer wrap;
        OutputStream II0XooXoX2;
        OutputStream II0XooXoX3;
        synchronized (this) {
            wrap = ByteBuffer.wrap(toByteArray());
            reset();
        }
        byte[] oxoX2 = new II0xO0((byte) 2, true, wrap.array()).oxoX();
        II0XooXoX2 = this.f877XO.II0XooXoX();
        II0XooXoX2.write(oxoX2);
        II0XooXoX3 = this.f877XO.II0XooXoX();
        II0XooXoX3.flush();
    }
}
