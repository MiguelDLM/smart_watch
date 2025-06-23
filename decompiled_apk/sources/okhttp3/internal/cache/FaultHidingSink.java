package okhttp3.internal.cache;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import java.io.IOException;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

/* loaded from: classes6.dex */
public class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;

    @OOXIXo
    private final oOoXoXO<IOException, oXIO0o0XI> onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FaultHidingSink(@OOXIXo Sink delegate, @OOXIXo oOoXoXO<? super IOException, oXIO0o0XI> onException) {
        super(delegate);
        IIX0o.x0xO0oo(delegate, "delegate");
        IIX0o.x0xO0oo(onException, "onException");
        this.onException = onException;
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }

    @OOXIXo
    public final oOoXoXO<IOException, oXIO0o0XI> getOnException() {
        return this.onException;
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(@OOXIXo Buffer source, long j) {
        IIX0o.x0xO0oo(source, "source");
        if (this.hasErrors) {
            source.skip(j);
            return;
        }
        try {
            super.write(source, j);
        } catch (IOException e) {
            this.hasErrors = true;
            this.onException.invoke(e);
        }
    }
}
