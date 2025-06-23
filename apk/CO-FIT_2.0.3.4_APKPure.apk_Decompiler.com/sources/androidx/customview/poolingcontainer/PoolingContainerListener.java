package androidx.customview.poolingcontainer;

import androidx.annotation.UiThread;

public interface PoolingContainerListener {
    @UiThread
    void onRelease();
}
