package Ix00oIoI;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;

/* loaded from: classes11.dex */
public class II0xO0 implements XO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public Animation f944II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public Animation f945oIX0oI;

    public II0xO0(long j) {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        I0Io(accelerateInterpolator, j);
        oxoX(accelerateInterpolator, j);
    }

    public final void I0Io(Interpolator interpolator, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.f945oIX0oI = alphaAnimation;
        alphaAnimation.setDuration(j);
        this.f945oIX0oI.setInterpolator(interpolator);
    }

    @Override // Ix00oIoI.XO
    public Animation II0xO0() {
        return this.f944II0xO0;
    }

    @Override // Ix00oIoI.XO
    public Animation oIX0oI() {
        return this.f945oIX0oI;
    }

    public final void oxoX(Interpolator interpolator, long j) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.f944II0xO0 = alphaAnimation;
        alphaAnimation.setDuration(j);
        this.f944II0xO0.setInterpolator(interpolator);
    }
}
