package androidx.work;

import androidx.lifecycle.LiveData;
import androidx.work.Operation;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
final class OperationImpl implements Operation {

    @OXOo.OOXIXo
    private final ListenableFuture<Operation.State.SUCCESS> future;

    @OXOo.OOXIXo
    private final LiveData<Operation.State> state;

    public OperationImpl(@OXOo.OOXIXo LiveData<Operation.State> state, @OXOo.OOXIXo ListenableFuture<Operation.State.SUCCESS> future) {
        IIX0o.x0xO0oo(state, "state");
        IIX0o.x0xO0oo(future, "future");
        this.state = state;
        this.future = future;
    }

    @Override // androidx.work.Operation
    @OXOo.OOXIXo
    public ListenableFuture<Operation.State.SUCCESS> getResult() {
        return this.future;
    }

    @Override // androidx.work.Operation
    @OXOo.OOXIXo
    public LiveData<Operation.State> getState() {
        return this.state;
    }
}
