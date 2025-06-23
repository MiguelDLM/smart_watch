package okio;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.IOException;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public abstract class ForwardingSink implements Sink {

    @OXOo.OOXIXo
    private final Sink delegate;

    public ForwardingSink(@OXOo.OOXIXo Sink delegate) {
        IIX0o.x0xO0oo(delegate, "delegate");
        this.delegate = delegate;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "delegate", imports = {}))
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "-deprecated_delegate")
    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final Sink m450deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "delegate")
    public final Sink delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // okio.Sink
    @OXOo.OOXIXo
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @OXOo.OOXIXo
    public String toString() {
        return getClass().getSimpleName() + HexStringBuilder.COMMENT_BEGIN_CHAR + this.delegate + HexStringBuilder.COMMENT_END_CHAR;
    }

    @Override // okio.Sink
    public void write(@OXOo.OOXIXo Buffer source, long j) throws IOException {
        IIX0o.x0xO0oo(source, "source");
        this.delegate.write(source, j);
    }
}
