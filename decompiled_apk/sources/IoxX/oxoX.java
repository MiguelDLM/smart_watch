package IoxX;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class oxoX extends ByteArrayOutputStream {

    /* renamed from: XO, reason: collision with root package name */
    public final /* synthetic */ X0o0xo f902XO;

    public oxoX(X0o0xo x0o0xo) {
        this.f902XO = x0o0xo;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ByteBuffer wrap;
        OutputStream X0o0xo2;
        OutputStream X0o0xo3;
        synchronized (this) {
            wrap = ByteBuffer.wrap(toByteArray());
            reset();
        }
        byte[] oxoX2 = new II0xO0((byte) 2, true, wrap.array()).oxoX();
        X0o0xo2 = this.f902XO.X0o0xo();
        X0o0xo2.write(oxoX2);
        X0o0xo3 = this.f902XO.X0o0xo();
        X0o0xo3.flush();
    }
}
