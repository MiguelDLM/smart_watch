package androidx.work;

import OXOo.OOXIXo;
import androidx.lifecycle.LiveData;
import androidx.work.Operation;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.IIX0o;

final class OperationImpl implements Operation {
    @OOXIXo
    private final ListenableFuture<Operation.State.SUCCESS> future;
    @OOXIXo
    private final LiveData<Operation.State> state;

    public OperationImpl(@OOXIXo LiveData<Operation.State> liveData, @OOXIXo ListenableFuture<Operation.State.SUCCESS> listenableFuture) {
        IIX0o.x0xO0oo(liveData, "state");
        IIX0o.x0xO0oo(listenableFuture, "future");
        this.state = liveData;
        this.future = listenableFuture;
    }

    @OOXIXo
    public ListenableFuture<Operation.State.SUCCESS> getResult() {
        return this.future;
    }

    @OOXIXo
    public LiveData<Operation.State> getState() {
        return this.state;
    }
}
