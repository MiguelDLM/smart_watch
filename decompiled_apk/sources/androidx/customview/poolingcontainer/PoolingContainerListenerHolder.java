package androidx.customview.poolingcontainer;

import OXOo.OOXIXo;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class PoolingContainerListenerHolder {

    @OOXIXo
    private final ArrayList<PoolingContainerListener> listeners = new ArrayList<>();

    public final void addListener(@OOXIXo PoolingContainerListener listener) {
        IIX0o.x0xO0oo(listener, "listener");
        this.listeners.add(listener);
    }

    public final void onRelease() {
        for (int oo0xXOI0I2 = CollectionsKt__CollectionsKt.oo0xXOI0I(this.listeners); -1 < oo0xXOI0I2; oo0xXOI0I2--) {
            this.listeners.get(oo0xXOI0I2).onRelease();
        }
    }

    public final void removeListener(@OOXIXo PoolingContainerListener listener) {
        IIX0o.x0xO0oo(listener, "listener");
        this.listeners.remove(listener);
    }
}
