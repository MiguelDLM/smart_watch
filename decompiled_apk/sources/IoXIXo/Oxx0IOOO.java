package IoXIXo;

import java.io.File;
import java.io.IOException;

/* loaded from: classes11.dex */
public class Oxx0IOOO extends X0o0xo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final long f814II0xO0;

    public Oxx0IOOO(long j) {
        if (j > 0) {
            this.f814II0xO0 = j;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // IoXIXo.X0o0xo
    public boolean I0Io(File file, long j, int i) {
        if (j <= this.f814II0xO0) {
            return true;
        }
        return false;
    }

    @Override // IoXIXo.X0o0xo, IoXIXo.oIX0oI
    public /* bridge */ /* synthetic */ void a(File file) throws IOException {
        super.a(file);
    }
}
