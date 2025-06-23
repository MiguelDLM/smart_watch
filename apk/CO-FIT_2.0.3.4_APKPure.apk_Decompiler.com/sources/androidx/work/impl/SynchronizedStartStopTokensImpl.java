package androidx.work.impl;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.List;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nStartStopToken.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StartStopToken.kt\nandroidx/work/impl/SynchronizedStartStopTokensImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,104:1\n1#2:105\n*E\n"})
final class SynchronizedStartStopTokensImpl implements StartStopTokens {
    @OOXIXo
    private final StartStopTokens delegate;
    @OOXIXo
    private final Object lock = new Object();

    public SynchronizedStartStopTokensImpl(@OOXIXo StartStopTokens startStopTokens) {
        IIX0o.x0xO0oo(startStopTokens, "delegate");
        this.delegate = startStopTokens;
    }

    public boolean contains(@OOXIXo WorkGenerationalId workGenerationalId) {
        boolean contains;
        IIX0o.x0xO0oo(workGenerationalId, "id");
        synchronized (this.lock) {
            contains = this.delegate.contains(workGenerationalId);
        }
        return contains;
    }

    public /* synthetic */ StartStopToken remove(WorkSpec workSpec) {
        return XO.oIX0oI(this, workSpec);
    }

    public /* synthetic */ StartStopToken tokenFor(WorkSpec workSpec) {
        return XO.II0xO0(this, workSpec);
    }

    @oOoXoXO
    public StartStopToken remove(@OOXIXo WorkGenerationalId workGenerationalId) {
        StartStopToken remove;
        IIX0o.x0xO0oo(workGenerationalId, "id");
        synchronized (this.lock) {
            remove = this.delegate.remove(workGenerationalId);
        }
        return remove;
    }

    @OOXIXo
    public StartStopToken tokenFor(@OOXIXo WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        IIX0o.x0xO0oo(workGenerationalId, "id");
        synchronized (this.lock) {
            startStopToken = this.delegate.tokenFor(workGenerationalId);
        }
        return startStopToken;
    }

    @OOXIXo
    public List<StartStopToken> remove(@OOXIXo String str) {
        List<StartStopToken> remove;
        IIX0o.x0xO0oo(str, "workSpecId");
        synchronized (this.lock) {
            remove = this.delegate.remove(str);
        }
        return remove;
    }
}
