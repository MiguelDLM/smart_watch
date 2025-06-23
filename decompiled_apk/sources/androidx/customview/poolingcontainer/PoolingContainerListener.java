package androidx.customview.poolingcontainer;

import androidx.annotation.UiThread;

/* loaded from: classes.dex */
public interface PoolingContainerListener {
    @UiThread
    void onRelease();
}
