package okio;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.IOException;
import kotlin.DeprecationLevel;
import kotlin.XX;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public abstract class ForwardingSource implements Source {

    @OXOo.OOXIXo
    private final Source delegate;

    public ForwardingSource(@OXOo.OOXIXo Source delegate) {
        IIX0o.x0xO0oo(delegate, "delegate");
        this.delegate = delegate;
    }

    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @XX(expression = "delegate", imports = {}))
    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "-deprecated_delegate")
    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final Source m451deprecated_delegate() {
        return this.delegate;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "delegate")
    public final Source delegate() {
        return this.delegate;
    }

    @Override // okio.Source
    public long read(@OXOo.OOXIXo Buffer sink, long j) throws IOException {
        IIX0o.x0xO0oo(sink, "sink");
        return this.delegate.read(sink, j);
    }

    @Override // okio.Source
    @OXOo.OOXIXo
    public Timeout timeout() {
        return this.delegate.timeout();
    }

    @OXOo.OOXIXo
    public String toString() {
        return getClass().getSimpleName() + HexStringBuilder.COMMENT_BEGIN_CHAR + this.delegate + HexStringBuilder.COMMENT_END_CHAR;
    }
}
