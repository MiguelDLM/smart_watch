package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

/* JADX INFO: Access modifiers changed from: package-private */
@XX({"SMAP\nStartStopToken.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StartStopToken.kt\nandroidx/work/impl/SynchronizedStartStopTokensImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,104:1\n1#2:105\n*E\n"})
/* loaded from: classes.dex */
public final class SynchronizedStartStopTokensImpl implements StartStopTokens {

    @OXOo.OOXIXo
    private final StartStopTokens delegate;

    @OXOo.OOXIXo
    private final Object lock;

    public SynchronizedStartStopTokensImpl(@OXOo.OOXIXo StartStopTokens delegate) {
        IIX0o.x0xO0oo(delegate, "delegate");
        this.delegate = delegate;
        this.lock = new Object();
    }

    @Override // androidx.work.impl.StartStopTokens
    public boolean contains(@OXOo.OOXIXo WorkGenerationalId id) {
        boolean contains;
        IIX0o.x0xO0oo(id, "id");
        synchronized (this.lock) {
            contains = this.delegate.contains(id);
        }
        return contains;
    }

    @Override // androidx.work.impl.StartStopTokens
    public /* synthetic */ StartStopToken remove(WorkSpec workSpec) {
        return XO.oIX0oI(this, workSpec);
    }

    @Override // androidx.work.impl.StartStopTokens
    public /* synthetic */ StartStopToken tokenFor(WorkSpec workSpec) {
        return XO.II0xO0(this, workSpec);
    }

    @Override // androidx.work.impl.StartStopTokens
    @OXOo.oOoXoXO
    public StartStopToken remove(@OXOo.OOXIXo WorkGenerationalId id) {
        StartStopToken remove;
        IIX0o.x0xO0oo(id, "id");
        synchronized (this.lock) {
            remove = this.delegate.remove(id);
        }
        return remove;
    }

    @Override // androidx.work.impl.StartStopTokens
    @OXOo.OOXIXo
    public StartStopToken tokenFor(@OXOo.OOXIXo WorkGenerationalId id) {
        StartStopToken startStopToken;
        IIX0o.x0xO0oo(id, "id");
        synchronized (this.lock) {
            startStopToken = this.delegate.tokenFor(id);
        }
        return startStopToken;
    }

    @Override // androidx.work.impl.StartStopTokens
    @OXOo.OOXIXo
    public List<StartStopToken> remove(@OXOo.OOXIXo String workSpecId) {
        List<StartStopToken> remove;
        IIX0o.x0xO0oo(workSpecId, "workSpecId");
        synchronized (this.lock) {
            remove = this.delegate.remove(workSpecId);
        }
        return remove;
    }
}
