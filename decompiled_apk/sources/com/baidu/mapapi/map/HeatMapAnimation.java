package com.baidu.mapapi.map;

/* loaded from: classes7.dex */
public class HeatMapAnimation {

    /* renamed from: a, reason: collision with root package name */
    private int f5813a;
    private AnimationType b;
    private boolean c;

    /* loaded from: classes7.dex */
    public enum AnimationType {
        Linear,
        InQuad,
        OutQuad,
        InOutQuad,
        OutInQuad,
        InCubic,
        OutCubic,
        InOutCubic,
        OutInCubic,
        InQuart,
        OutQuart,
        InOutQuart,
        OutInQuart,
        InQuint,
        OutQuint,
        InOutQuint,
        OutInQuint,
        InSine,
        OutSine,
        InOutSine,
        OutInSine,
        InExpo,
        OutExpo,
        InOutExpo,
        OutInExpo,
        InCirc,
        OutCirc,
        InOutCirc,
        OutInCirc,
        InElastic,
        OutElastic,
        InOutElastic,
        OutInElastic,
        InBack,
        OutBack,
        InOutBack,
        OutInBack,
        InBounce,
        OutBounce,
        InOutBounce,
        OutInBounce,
        InCurve,
        OutCurve,
        SineCurve,
        CosineCurve
    }

    public HeatMapAnimation(boolean z, int i, AnimationType animationType) {
        this.f5813a = 100;
        this.b = AnimationType.Linear;
        if (i >= 0) {
            this.f5813a = i;
        }
        this.b = animationType;
        this.c = z;
    }

    public int getAnimationType() {
        return this.b.ordinal();
    }

    public int getDuration() {
        return this.f5813a;
    }

    public boolean getIsAnimation() {
        return this.c;
    }

    public void setAnimation(boolean z) {
        this.c = z;
    }

    public void setAnimationType(AnimationType animationType) {
        this.b = animationType;
    }

    public void setDuration(int i) {
        this.f5813a = i;
    }
}
