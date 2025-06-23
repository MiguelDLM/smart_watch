package androidx.customview.poolingcontainer;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import kotlin.jvm.internal.IIX0o;

@xxIXOIIO(name = "PoolingContainer")
public final class PoolingContainer {
    private static final int IsPoolingContainerTag = R.id.is_pooling_container_tag;
    private static final int PoolingContainerListenerHolderTag = R.id.pooling_container_listener_holder_tag;

    @SuppressLint({"ExecutorRegistration"})
    public static final void addPoolingContainerListener(@OOXIXo View view, @OOXIXo PoolingContainerListener poolingContainerListener) {
        IIX0o.x0xO0oo(view, "<this>");
        IIX0o.x0xO0oo(poolingContainerListener, "listener");
        getPoolingContainerListenerHolder(view).addListener(poolingContainerListener);
    }

    public static final void callPoolingContainerOnRelease(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<this>");
        for (View poolingContainerListenerHolder : ViewKt.getAllViews(view)) {
            getPoolingContainerListenerHolder(poolingContainerListenerHolder).onRelease();
        }
    }

    public static final void callPoolingContainerOnReleaseForChildren(@OOXIXo ViewGroup viewGroup) {
        IIX0o.x0xO0oo(viewGroup, "<this>");
        for (View poolingContainerListenerHolder : ViewGroupKt.getChildren(viewGroup)) {
            getPoolingContainerListenerHolder(poolingContainerListenerHolder).onRelease();
        }
    }

    private static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View view) {
        int i = PoolingContainerListenerHolderTag;
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(i);
        if (poolingContainerListenerHolder != null) {
            return poolingContainerListenerHolder;
        }
        PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
        view.setTag(i, poolingContainerListenerHolder2);
        return poolingContainerListenerHolder2;
    }

    public static final boolean isPoolingContainer(@OOXIXo View view) {
        Boolean bool;
        IIX0o.x0xO0oo(view, "<this>");
        Object tag = view.getTag(IsPoolingContainerTag);
        if (tag instanceof Boolean) {
            bool = (Boolean) tag;
        } else {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean isWithinPoolingContainer(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<this>");
        for (ViewParent next : ViewKt.getAncestors(view)) {
            if ((next instanceof View) && isPoolingContainer((View) next)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void removePoolingContainerListener(@OOXIXo View view, @OOXIXo PoolingContainerListener poolingContainerListener) {
        IIX0o.x0xO0oo(view, "<this>");
        IIX0o.x0xO0oo(poolingContainerListener, "listener");
        getPoolingContainerListenerHolder(view).removeListener(poolingContainerListener);
    }

    public static final void setPoolingContainer(@OOXIXo View view, boolean z) {
        IIX0o.x0xO0oo(view, "<this>");
        view.setTag(IsPoolingContainerTag, Boolean.valueOf(z));
    }
}
