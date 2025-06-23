package com.baidu.navisdk.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: com.baidu.navisdk.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C0512a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9401a;

        static {
            int[] iArr = new int[b.values().length];
            f9401a = iArr;
            try {
                iArr[b.ANIM_LEFT_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9401a[b.ANIM_RIGHT_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9401a[b.ANIM_LEFT_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9401a[b.ANIM_RIGHT_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9401a[b.ANIM_DOWN_IN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9401a[b.ANIM_DOWN_OUT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9401a[b.ANIM_TOP_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9401a[b.ANIM_TOP_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public enum b {
        ANIM_LEFT_IN,
        ANIM_RIGHT_IN,
        ANIM_LEFT_OUT,
        ANIM_RIGHT_OUT,
        ANIM_DOWN_IN,
        ANIM_DOWN_OUT,
        ANIM_TOP_IN,
        ANIM_TOP_OUT
    }

    public static Animation a(b bVar, long j, long j2) {
        Animation a2 = a(bVar);
        if (a2 != null && j >= 0) {
            a2.setStartOffset(j);
        }
        if (a2 != null && j2 >= 0) {
            a2.setDuration(j2);
        }
        return a2;
    }

    public static Animation a(b bVar) {
        switch (C0512a.f9401a[bVar.ordinal()]) {
            case 1:
                return JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_left_in);
            case 2:
                return JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_right_in);
            case 3:
                return JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_left_out);
            case 4:
                return JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_right_out);
            case 5:
                return JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_down_in);
            case 6:
                return JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_down_out);
            case 7:
                return JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_top_in);
            case 8:
                return JarUtils.loadAnimation(com.baidu.navisdk.framework.a.c().a(), R.anim.nsdk_anim_top_out);
            default:
                return null;
        }
    }

    public static void a(View view, float f, int i) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, f, 1.0f);
        animatorSet.setDuration(i);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public static ObjectAnimator a(View view, int i, Animator.AnimatorListener animatorListener) {
        if (view == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(i);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.play(ofFloat);
        ofFloat.addListener(animatorListener);
        animatorSet.start();
        return ofFloat;
    }
}
