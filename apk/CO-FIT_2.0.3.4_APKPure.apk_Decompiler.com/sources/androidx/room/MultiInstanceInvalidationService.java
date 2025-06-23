package androidx.room;

import OXOo.OOXIXo;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import androidx.room.IMultiInstanceInvalidationService;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.IIX0o;

@ExperimentalRoomApi
public final class MultiInstanceInvalidationService extends Service {
    @OOXIXo
    private final IMultiInstanceInvalidationService.Stub binder = new MultiInstanceInvalidationService$binder$1(this);
    @OOXIXo
    private final RemoteCallbackList<IMultiInstanceInvalidationCallback> callbackList = new MultiInstanceInvalidationService$callbackList$1(this);
    @OOXIXo
    private final Map<Integer, String> clientNames = new LinkedHashMap();
    private int maxClientId;

    @OOXIXo
    public final RemoteCallbackList<IMultiInstanceInvalidationCallback> getCallbackList$room_runtime_release() {
        return this.callbackList;
    }

    @OOXIXo
    public final Map<Integer, String> getClientNames$room_runtime_release() {
        return this.clientNames;
    }

    public final int getMaxClientId$room_runtime_release() {
        return this.maxClientId;
    }

    @OOXIXo
    public IBinder onBind(@OOXIXo Intent intent) {
        IIX0o.x0xO0oo(intent, SDKConstants.PARAM_INTENT);
        return this.binder;
    }

    public final void setMaxClientId$room_runtime_release(int i) {
        this.maxClientId = i;
    }
}
