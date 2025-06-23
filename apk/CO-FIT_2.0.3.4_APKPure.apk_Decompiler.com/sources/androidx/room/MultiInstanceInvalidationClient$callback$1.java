package androidx.room;

import OXOo.OOXIXo;
import androidx.room.IMultiInstanceInvalidationCallback;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;

public final class MultiInstanceInvalidationClient$callback$1 extends IMultiInstanceInvalidationCallback.Stub {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    public MultiInstanceInvalidationClient$callback$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    /* access modifiers changed from: private */
    public static final void onInvalidation$lambda$0(MultiInstanceInvalidationClient multiInstanceInvalidationClient, String[] strArr) {
        IIX0o.x0xO0oo(multiInstanceInvalidationClient, "this$0");
        IIX0o.x0xO0oo(strArr, "$tables");
        multiInstanceInvalidationClient.getInvalidationTracker().notifyObserversByTableNames((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public void onInvalidation(@OOXIXo String[] strArr) {
        IIX0o.x0xO0oo(strArr, "tables");
        this.this$0.getExecutor().execute(new XO(this.this$0, strArr));
    }
}
