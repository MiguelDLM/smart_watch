package Ix00oIoI;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import com.octopus.ad.internal.animation.TransitionDirection;

/* loaded from: classes11.dex */
public class oxoX implements XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public Animation f962II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Animation f963oIX0oI;

    /* renamed from: I0Io, reason: collision with root package name */
    public static final float[] f954I0Io = {0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: oxoX, reason: collision with root package name */
    public static final float[] f959oxoX = {0.0f, 0.0f, -1.0f, 0.0f};

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final float[] f957X0o0xo = {-1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: XO, reason: collision with root package name */
    public static final float[] f958XO = {1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final float[] f956Oxx0IOOO = {0.0f, 0.0f, 0.0f, -1.0f};

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final float[] f955II0XooXoX = {0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final float[] f961xxIXOIIO = {0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: xoIox, reason: collision with root package name */
    public static final float[] f960xoIox = {0.0f, -1.0f, 0.0f, 0.0f};

    /* loaded from: classes11.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f964oIX0oI;

        static {
            int[] iArr = new int[TransitionDirection.values().length];
            f964oIX0oI = iArr;
            try {
                iArr[TransitionDirection.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f964oIX0oI[TransitionDirection.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f964oIX0oI[TransitionDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f964oIX0oI[TransitionDirection.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public oxoX(long j, TransitionDirection transitionDirection) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        this.f963oIX0oI = I0Io(oxoX(transitionDirection), accelerateInterpolator, j);
        this.f962II0xO0 = I0Io(X0o0xo(transitionDirection), accelerateInterpolator, j);
    }

    public final Animation I0Io(float[] fArr, Interpolator interpolator, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, fArr[0], 2, fArr[1], 2, fArr[2], 2, fArr[3]);
        translateAnimation.setInterpolator(interpolator);
        translateAnimation.setDuration(j);
        return translateAnimation;
    }

    @Override // Ix00oIoI.XO
    public Animation II0xO0() {
        return this.f962II0xO0;
    }

    public final float[] X0o0xo(TransitionDirection transitionDirection) {
        int i = oIX0oI.f964oIX0oI[transitionDirection.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return f956Oxx0IOOO;
                    }
                    return f960xoIox;
                }
                return f961xxIXOIIO;
            }
            return f955II0XooXoX;
        }
        return f956Oxx0IOOO;
    }

    @Override // Ix00oIoI.XO
    public Animation oIX0oI() {
        return this.f963oIX0oI;
    }

    public final float[] oxoX(TransitionDirection transitionDirection) {
        int i = oIX0oI.f964oIX0oI[transitionDirection.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return f954I0Io;
                    }
                    return f958XO;
                }
                return f957X0o0xo;
            }
            return f959oxoX;
        }
        return f954I0Io;
    }
}
