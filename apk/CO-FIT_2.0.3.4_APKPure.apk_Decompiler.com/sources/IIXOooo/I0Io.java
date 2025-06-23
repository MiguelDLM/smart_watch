package IIXOooo;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class I0Io extends ValueAnimator {

    /* renamed from: Oo  reason: collision with root package name */
    public final Set<Animator.AnimatorListener> f14Oo = new CopyOnWriteArraySet();

    /* renamed from: XO  reason: collision with root package name */
    public final Set<ValueAnimator.AnimatorUpdateListener> f15XO = new CopyOnWriteArraySet();

    public void I0Io() {
        for (Animator.AnimatorListener onAnimationRepeat : this.f14Oo) {
            onAnimationRepeat.onAnimationRepeat(this);
        }
    }

    public void II0xO0(boolean z) {
        for (Animator.AnimatorListener next : this.f14Oo) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationEnd(this, z);
            } else {
                next.onAnimationEnd(this);
            }
        }
    }

    public void X0o0xo() {
        for (ValueAnimator.AnimatorUpdateListener onAnimationUpdate : this.f15XO) {
            onAnimationUpdate.onAnimationUpdate(this);
        }
    }

    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f14Oo.add(animatorListener);
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f15XO.add(animatorUpdateListener);
    }

    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public void oIX0oI() {
        for (Animator.AnimatorListener onAnimationCancel : this.f14Oo) {
            onAnimationCancel.onAnimationCancel(this);
        }
    }

    public void oxoX(boolean z) {
        for (Animator.AnimatorListener next : this.f14Oo) {
            if (Build.VERSION.SDK_INT >= 26) {
                next.onAnimationStart(this, z);
            } else {
                next.onAnimationStart(this);
            }
        }
    }

    public void removeAllListeners() {
        this.f14Oo.clear();
    }

    public void removeAllUpdateListeners() {
        this.f15XO.clear();
    }

    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f14Oo.remove(animatorListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f15XO.remove(animatorUpdateListener);
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
