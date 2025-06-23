package com.octopus.ad.internal.animation;

/* loaded from: classes11.dex */
public enum TransitionDirection {
    UP,
    DOWN,
    RIGHT,
    LEFT;

    public static TransitionDirection getDirectionForInt(int i) {
        for (TransitionDirection transitionDirection : values()) {
            if (transitionDirection.ordinal() == i) {
                return transitionDirection;
            }
        }
        return UP;
    }
}
