package Ix00oIoI;

import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import com.octopus.ad.internal.animation.TransitionDirection;

/* loaded from: classes11.dex */
public class I0Io implements XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public Animation f941II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Animation f942oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static final float[] f937I0Io = {0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: oxoX, reason: collision with root package name */
    public static final float[] f940oxoX = {0.0f, 0.0f, -1.0f, 0.0f};

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final float[] f938X0o0xo = {-1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: XO, reason: collision with root package name */
    public static final float[] f939XO = {1.0f, 0.0f, 0.0f, 0.0f};

    /* loaded from: classes11.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f943oIX0oI;

        static {
            int[] iArr = new int[TransitionDirection.values().length];
            f943oIX0oI = iArr;
            try {
                iArr[TransitionDirection.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f943oIX0oI[TransitionDirection.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f943oIX0oI[TransitionDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f943oIX0oI[TransitionDirection.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public I0Io(long j, TransitionDirection transitionDirection) {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        oxoX(I0Io(transitionDirection), linearInterpolator, j);
        X0o0xo(I0Io(transitionDirection), linearInterpolator, j);
    }

    public final float[] I0Io(TransitionDirection transitionDirection) {
        int i = oIX0oI.f943oIX0oI[transitionDirection.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return f937I0Io;
                    }
                    return f939XO;
                }
                return f938X0o0xo;
            }
            return f940oxoX;
        }
        return f937I0Io;
    }

    @Override // Ix00oIoI.XO
    public Animation II0xO0() {
        return this.f941II0xO0;
    }

    public final void X0o0xo(float[] fArr, Interpolator interpolator, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -1.0f, 2, 0.0f, 2, 0.0f);
        this.f941II0xO0 = translateAnimation;
        translateAnimation.setFillAfter(true);
        this.f941II0xO0.setDuration(j);
        this.f941II0xO0.setInterpolator(interpolator);
    }

    @Override // Ix00oIoI.XO
    public Animation oIX0oI() {
        return this.f942oIX0oI;
    }

    public final void oxoX(float[] fArr, Interpolator interpolator, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, fArr[0], 2, fArr[1], 2, fArr[2], 2, fArr[3]);
        this.f942oIX0oI = translateAnimation;
        translateAnimation.setInterpolator(interpolator);
        this.f942oIX0oI.setFillAfter(true);
        this.f942oIX0oI.setDuration(j);
    }
}
