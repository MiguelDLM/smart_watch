package androidx.lifecycle;

import OXOo.OOXIXo;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.IIX0o;

public final class SingleGeneratedAdapterObserver implements LifecycleEventObserver {
    @OOXIXo
    private final GeneratedAdapter generatedAdapter;

    public SingleGeneratedAdapterObserver(@OOXIXo GeneratedAdapter generatedAdapter2) {
        IIX0o.x0xO0oo(generatedAdapter2, "generatedAdapter");
        this.generatedAdapter = generatedAdapter2;
    }

    public void onStateChanged(@OOXIXo LifecycleOwner lifecycleOwner, @OOXIXo Lifecycle.Event event) {
        IIX0o.x0xO0oo(lifecycleOwner, "source");
        IIX0o.x0xO0oo(event, NotificationCompat.CATEGORY_EVENT);
        this.generatedAdapter.callMethods(lifecycleOwner, event, false, (MethodCallsLogger) null);
        this.generatedAdapter.callMethods(lifecycleOwner, event, true, (MethodCallsLogger) null);
    }
}
