package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public class ForwardingTimeout extends Timeout {

    @OXOo.OOXIXo
    private Timeout delegate;

    public ForwardingTimeout(@OXOo.OOXIXo Timeout delegate) {
        IIX0o.x0xO0oo(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okio.Timeout
    @OXOo.OOXIXo
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // okio.Timeout
    @OXOo.OOXIXo
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    @OXOo.OOXIXo
    @XO0OX.xxIXOIIO(name = "delegate")
    public final Timeout delegate() {
        return this.delegate;
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    /* renamed from: setDelegate, reason: collision with other method in class */
    public final /* synthetic */ void m452setDelegate(Timeout timeout) {
        IIX0o.x0xO0oo(timeout, "<set-?>");
        this.delegate = timeout;
    }

    @Override // okio.Timeout
    public void throwIfReached() throws IOException {
        this.delegate.throwIfReached();
    }

    @Override // okio.Timeout
    @OXOo.OOXIXo
    public Timeout timeout(long j, @OXOo.OOXIXo TimeUnit unit) {
        IIX0o.x0xO0oo(unit, "unit");
        return this.delegate.timeout(j, unit);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override // okio.Timeout
    @OXOo.OOXIXo
    public Timeout deadlineNanoTime(long j) {
        return this.delegate.deadlineNanoTime(j);
    }

    @OXOo.OOXIXo
    public final ForwardingTimeout setDelegate(@OXOo.OOXIXo Timeout delegate) {
        IIX0o.x0xO0oo(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }
}
