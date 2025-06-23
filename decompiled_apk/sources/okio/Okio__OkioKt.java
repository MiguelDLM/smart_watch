package okio;

import java.io.Closeable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.xxX;
import kotlin.oO;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final /* synthetic */ class Okio__OkioKt {
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "blackhole")
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    @OXOo.OOXIXo
    public static final BufferedSource buffer(@OXOo.OOXIXo Source source) {
        IIX0o.x0xO0oo(source, "<this>");
        return new RealBufferedSource(source);
    }

    public static final <T extends Closeable, R> R use(T t, @OXOo.OOXIXo Oox.oOoXoXO<? super T, ? extends R> block) {
        R r;
        IIX0o.x0xO0oo(block, "block");
        Throwable th = null;
        try {
            r = block.invoke(t);
            xxX.oxoX(1);
            if (t != null) {
                try {
                    t.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            xxX.I0Io(1);
        } catch (Throwable th3) {
            xxX.oxoX(1);
            if (t != null) {
                try {
                    t.close();
                } catch (Throwable th4) {
                    oO.oIX0oI(th3, th4);
                }
            }
            xxX.I0Io(1);
            th = th3;
            r = null;
        }
        if (th == null) {
            IIX0o.ooOOo0oXI(r);
            return r;
        }
        throw th;
    }

    @OXOo.OOXIXo
    public static final BufferedSink buffer(@OXOo.OOXIXo Sink sink) {
        IIX0o.x0xO0oo(sink, "<this>");
        return new RealBufferedSink(sink);
    }
}
