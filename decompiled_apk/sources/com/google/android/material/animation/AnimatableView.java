package com.google.android.material.animation;

import androidx.annotation.NonNull;

/* loaded from: classes9.dex */
public interface AnimatableView {

    /* loaded from: classes9.dex */
    public interface Listener {
        void onAnimationEnd();
    }

    void startAnimation(@NonNull Listener listener);

    void stopAnimation();
}
