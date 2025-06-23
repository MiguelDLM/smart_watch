package androidx.room;

import OXOo.OOXIXo;
import android.os.RemoteCallbackList;
import com.huawei.openalliance.ad.constant.bn;
import kotlin.jvm.internal.IIX0o;

public final class MultiInstanceInvalidationService$callbackList$1 extends RemoteCallbackList<IMultiInstanceInvalidationCallback> {
    final /* synthetic */ MultiInstanceInvalidationService this$0;

    public MultiInstanceInvalidationService$callbackList$1(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.this$0 = multiInstanceInvalidationService;
    }

    public void onCallbackDied(@OOXIXo IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, @OOXIXo Object obj) {
        IIX0o.x0xO0oo(iMultiInstanceInvalidationCallback, bn.f.L);
        IIX0o.x0xO0oo(obj, "cookie");
        this.this$0.getClientNames$room_runtime_release().remove((Integer) obj);
    }
}
