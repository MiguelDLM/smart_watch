package Ix00oIoI;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import com.octopus.ad.internal.animation.TransitionDirection;

/* loaded from: classes11.dex */
public class X0o0xo implements XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public Animation f950II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Animation f951oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static final float[] f946I0Io = {0.0f, 0.0f, 0.0f, -1.0f};

    /* renamed from: oxoX, reason: collision with root package name */
    public static final float[] f949oxoX = {0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final float[] f947X0o0xo = {0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: XO, reason: collision with root package name */
    public static final float[] f948XO = {0.0f, -1.0f, 0.0f, 0.0f};

    /* loaded from: classes11.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f952oIX0oI;

        static {
            int[] iArr = new int[TransitionDirection.values().length];
            f952oIX0oI = iArr;
            try {
                iArr[TransitionDirection.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f952oIX0oI[TransitionDirection.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f952oIX0oI[TransitionDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f952oIX0oI[TransitionDirection.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public X0o0xo(long j, TransitionDirection transitionDirection) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        oxoX(accelerateInterpolator, j);
        X0o0xo(I0Io(transitionDirection), accelerateInterpolator, j);
    }

    private float[] I0Io(TransitionDirection transitionDirection) {
        int i = oIX0oI.f952oIX0oI[transitionDirection.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return f946I0Io;
                    }
                    return f948XO;
                }
                return f947X0o0xo;
            }
            return f949oxoX;
        }
        return f946I0Io;
    }

    private void X0o0xo(float[] fArr, Interpolator interpolator, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, fArr[0], 2, fArr[1], 2, fArr[2], 2, fArr[3]);
        translateAnimation.setInterpolator(interpolator);
        translateAnimation.setDuration(j);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(j);
        alphaAnimation.setInterpolator(interpolator);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        this.f950II0xO0 = animationSet;
    }

    private void oxoX(Interpolator interpolator, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.f951oIX0oI = alphaAnimation;
        alphaAnimation.setDuration(j);
        this.f951oIX0oI.setInterpolator(interpolator);
    }

    @Override // Ix00oIoI.XO
    public Animation II0xO0() {
        return this.f950II0xO0;
    }

    @Override // Ix00oIoI.XO
    public Animation oIX0oI() {
        return this.f951oIX0oI;
    }
}
