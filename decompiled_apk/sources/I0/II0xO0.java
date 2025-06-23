package I0;

import XIXIX.oOoXoXO;
import XIXIX.xxIXOIIO;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;

@SuppressLint({"NewApi"})
/* loaded from: classes9.dex */
public abstract class II0xO0 extends X0o0xo implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public float f20O0xOxO;

    /* renamed from: OxI, reason: collision with root package name */
    public float f21OxI;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public float f22X0IIOO;

    /* renamed from: o00, reason: collision with root package name */
    public ObjectAnimator f23o00;

    public II0xO0(oOoXoXO oooxoxo, float f, float f2, xxIXOIIO xxixoiio, View view, float f3, float f4, long j) {
        super(oooxoxo, f, f2, xxixoiio, view);
        this.f20O0xOxO = f3;
        this.f22X0IIOO = f4;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, TypedValues.CycleType.S_WAVE_PHASE, 0.0f, 1.0f);
        this.f23o00 = ofFloat;
        ofFloat.setDuration(j);
        this.f23o00.addUpdateListener(this);
        this.f23o00.addListener(this);
    }

    public void II0XooXoX() {
        this.f23o00.removeAllListeners();
        this.f23o00.removeAllUpdateListeners();
        this.f23o00.reverse();
        this.f23o00.addUpdateListener(this);
        this.f23o00.addListener(this);
    }

    public abstract void Oxx0IOOO();

    public float X0o0xo() {
        return this.f20O0xOxO;
    }

    public float XO() {
        return this.f22X0IIOO;
    }

    public void onAnimationCancel(Animator animator) {
        try {
            Oxx0IOOO();
        } catch (IllegalArgumentException unused) {
        }
    }

    public void onAnimationEnd(Animator animator) {
        try {
            Oxx0IOOO();
        } catch (IllegalArgumentException unused) {
        }
    }

    public float oxoX() {
        return this.f21OxI;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"NewApi"})
    public void run() {
        this.f23o00.start();
    }

    public void xxIXOIIO(float f) {
        this.f21OxI = f;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
    }
}
