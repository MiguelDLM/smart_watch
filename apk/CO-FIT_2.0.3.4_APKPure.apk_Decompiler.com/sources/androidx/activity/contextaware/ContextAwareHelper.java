package androidx.activity.contextaware;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import com.huawei.openalliance.ad.constant.bn;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nContextAwareHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAwareHelper.kt\nandroidx/activity/contextaware/ContextAwareHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,87:1\n1#2:88\n*E\n"})
public final class ContextAwareHelper {
    @oOoXoXO
    private volatile Context context;
    @OOXIXo
    private final Set<OnContextAvailableListener> listeners = new CopyOnWriteArraySet();

    public final void addOnContextAvailableListener(@OOXIXo OnContextAvailableListener onContextAvailableListener) {
        IIX0o.x0xO0oo(onContextAvailableListener, "listener");
        Context context2 = this.context;
        if (context2 != null) {
            onContextAvailableListener.onContextAvailable(context2);
        }
        this.listeners.add(onContextAvailableListener);
    }

    public final void clearAvailableContext() {
        this.context = null;
    }

    public final void dispatchOnContextAvailable(@OOXIXo Context context2) {
        IIX0o.x0xO0oo(context2, bn.f.o);
        this.context = context2;
        for (OnContextAvailableListener onContextAvailable : this.listeners) {
            onContextAvailable.onContextAvailable(context2);
        }
    }

    @oOoXoXO
    public final Context peekAvailableContext() {
        return this.context;
    }

    public final void removeOnContextAvailableListener(@OOXIXo OnContextAvailableListener onContextAvailableListener) {
        IIX0o.x0xO0oo(onContextAvailableListener, "listener");
        this.listeners.remove(onContextAvailableListener);
    }
}
