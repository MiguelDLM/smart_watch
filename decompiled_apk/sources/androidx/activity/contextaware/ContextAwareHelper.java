package androidx.activity.contextaware;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nContextAwareHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAwareHelper.kt\nandroidx/activity/contextaware/ContextAwareHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,87:1\n1#2:88\n*E\n"})
/* loaded from: classes.dex */
public final class ContextAwareHelper {

    @oOoXoXO
    private volatile Context context;

    @OOXIXo
    private final Set<OnContextAvailableListener> listeners = new CopyOnWriteArraySet();

    public final void addOnContextAvailableListener(@OOXIXo OnContextAvailableListener listener) {
        IIX0o.x0xO0oo(listener, "listener");
        Context context = this.context;
        if (context != null) {
            listener.onContextAvailable(context);
        }
        this.listeners.add(listener);
    }

    public final void clearAvailableContext() {
        this.context = null;
    }

    public final void dispatchOnContextAvailable(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        this.context = context;
        Iterator<OnContextAvailableListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onContextAvailable(context);
        }
    }

    @oOoXoXO
    public final Context peekAvailableContext() {
        return this.context;
    }

    public final void removeOnContextAvailableListener(@OOXIXo OnContextAvailableListener listener) {
        IIX0o.x0xO0oo(listener, "listener");
        this.listeners.remove(listener);
    }
}
