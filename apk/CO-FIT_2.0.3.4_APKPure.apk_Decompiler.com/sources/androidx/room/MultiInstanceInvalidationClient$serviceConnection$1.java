package androidx.room;

import OXOo.OOXIXo;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.room.IMultiInstanceInvalidationService;
import kotlin.jvm.internal.IIX0o;

public final class MultiInstanceInvalidationClient$serviceConnection$1 implements ServiceConnection {
    final /* synthetic */ MultiInstanceInvalidationClient this$0;

    public MultiInstanceInvalidationClient$serviceConnection$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public void onServiceConnected(@OOXIXo ComponentName componentName, @OOXIXo IBinder iBinder) {
        IIX0o.x0xO0oo(componentName, "name");
        IIX0o.x0xO0oo(iBinder, NotificationCompat.CATEGORY_SERVICE);
        this.this$0.setService(IMultiInstanceInvalidationService.Stub.asInterface(iBinder));
        this.this$0.getExecutor().execute(this.this$0.getSetUpRunnable());
    }

    public void onServiceDisconnected(@OOXIXo ComponentName componentName) {
        IIX0o.x0xO0oo(componentName, "name");
        this.this$0.getExecutor().execute(this.this$0.getRemoveObserverRunnable());
        this.this$0.setService((IMultiInstanceInvalidationService) null);
    }
}
