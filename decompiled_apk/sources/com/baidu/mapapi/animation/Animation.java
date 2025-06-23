package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapsdkplatform.comapi.a.c;

/* loaded from: classes7.dex */
public abstract class Animation {
    public c bdAnimation;

    /* loaded from: classes7.dex */
    public interface AnimationListener {
        void onAnimationCancel();

        void onAnimationEnd();

        void onAnimationRepeat();

        void onAnimationStart();
    }

    /* loaded from: classes7.dex */
    public enum RepeatMode {
        RESTART,
        REVERSE
    }

    public abstract void cancel();

    public abstract void setAnimationListener(AnimationListener animationListener);

    public abstract void setDuration(long j);

    public abstract void setInterpolator(Interpolator interpolator);
}
