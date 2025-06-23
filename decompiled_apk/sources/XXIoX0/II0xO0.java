package XXIoX0;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.XI0oooXX;
import kotlinx.coroutines.internal.oI0IIXIo;

/* loaded from: classes6.dex */
public final class II0xO0 extends Oxx0IOOO {

    /* renamed from: IIXOooo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final II0xO0 f4039IIXOooo = new II0xO0();

    public II0xO0() {
        super(ooOOo0oXI.f4061I0Io, ooOOo0oXI.f4068oxoX, ooOOo0oXI.f4065X0o0xo, ooOOo0oXI.f4067oIX0oI);
    }

    public final void XxX0x0xxx() {
        super.close();
    }

    @Override // XXIoX0.Oxx0IOOO, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    @XI0oooXX
    public CoroutineDispatcher limitedParallelism(int i) {
        oI0IIXIo.oIX0oI(i);
        if (i >= ooOOo0oXI.f4061I0Io) {
            return this;
        }
        return super.limitedParallelism(i);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    public String toString() {
        return "Dispatchers.Default";
    }
}
