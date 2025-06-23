package com.jd.ad.sdk.jad_ve;

import XIXIX.OOXIXo;
import android.animation.Animator;
import android.graphics.PointF;
import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class jad_er extends jad_an implements Choreographer.FrameCallback {

    @Nullable
    public com.jd.ad.sdk.jad_js.jad_jt jad_jw;
    public float jad_cp = 1.0f;
    public boolean jad_dq = false;
    public long jad_er = 0;
    public float jad_fs = 0.0f;
    public int jad_jt = 0;
    public float jad_hu = -2.1474836E9f;
    public float jad_iv = 2.1474836E9f;

    @VisibleForTesting
    public boolean jad_kx = false;

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        Iterator<Animator.AnimatorListener> it = this.jad_bo.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
        jad_hu();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        boolean z;
        float jad_er;
        float jad_dq;
        jad_jt();
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar != null && this.jad_kx) {
            long j2 = this.jad_er;
            long j3 = 0;
            if (j2 != 0) {
                j3 = j - j2;
            }
            float abs = ((float) j3) / ((1.0E9f / jad_jtVar.jad_mz) / Math.abs(this.jad_cp));
            float f = this.jad_fs;
            if (jad_fs()) {
                abs = -abs;
            }
            float f2 = f + abs;
            this.jad_fs = f2;
            float jad_er2 = jad_er();
            float jad_dq2 = jad_dq();
            PointF pointF = jad_jt.jad_an;
            if (f2 >= jad_er2 && f2 <= jad_dq2) {
                z = true;
            } else {
                z = false;
            }
            this.jad_fs = Math.max(jad_er(), Math.min(jad_dq(), this.jad_fs));
            this.jad_er = j;
            jad_an();
            if (!z) {
                if (getRepeatCount() != -1 && this.jad_jt >= getRepeatCount()) {
                    if (this.jad_cp < 0.0f) {
                        jad_dq = jad_er();
                    } else {
                        jad_dq = jad_dq();
                    }
                    this.jad_fs = jad_dq;
                    jad_hu();
                    jad_an(jad_fs());
                } else {
                    Iterator<Animator.AnimatorListener> it = this.jad_bo.iterator();
                    while (it.hasNext()) {
                        it.next().onAnimationRepeat(this);
                    }
                    this.jad_jt++;
                    if (getRepeatMode() == 2) {
                        this.jad_dq = !this.jad_dq;
                        this.jad_cp = -this.jad_cp;
                    } else {
                        if (jad_fs()) {
                            jad_er = jad_dq();
                        } else {
                            jad_er = jad_er();
                        }
                        this.jad_fs = jad_er;
                    }
                    this.jad_er = j;
                }
            }
            if (this.jad_jw != null) {
                float f3 = this.jad_fs;
                if (f3 < this.jad_hu || f3 > this.jad_iv) {
                    throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.jad_hu), Float.valueOf(this.jad_iv), Float.valueOf(this.jad_fs)));
                }
            }
            com.jd.ad.sdk.jad_js.jad_dq.jad_an("LottieValueAnimator#doFrame");
        }
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = OOXIXo.f3760XO, to = 1.0d)
    public float getAnimatedFraction() {
        float f;
        float jad_er;
        if (this.jad_jw == null) {
            return 0.0f;
        }
        if (jad_fs()) {
            f = jad_dq();
            jad_er = this.jad_fs;
        } else {
            f = this.jad_fs;
            jad_er = jad_er();
        }
        return (f - jad_er) / (jad_dq() - jad_er());
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(jad_cp());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.jad_jw == null) {
            return 0L;
        }
        return r0.jad_an();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.jad_kx;
    }

    public void jad_an(float f) {
        if (this.jad_fs == f) {
            return;
        }
        float jad_er = jad_er();
        float jad_dq = jad_dq();
        PointF pointF = jad_jt.jad_an;
        this.jad_fs = Math.max(jad_er, Math.min(jad_dq, f));
        this.jad_er = 0L;
        jad_an();
    }

    @MainThread
    public void jad_bo() {
        jad_hu();
        jad_an(jad_fs());
    }

    @FloatRange(from = OOXIXo.f3760XO, to = 1.0d)
    public float jad_cp() {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        float f = this.jad_fs;
        float f2 = jad_jtVar.jad_kx;
        return (f - f2) / (jad_jtVar.jad_ly - f2);
    }

    public float jad_dq() {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        float f = this.jad_iv;
        if (f == 2.1474836E9f) {
            return jad_jtVar.jad_ly;
        }
        return f;
    }

    public float jad_er() {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        float f = this.jad_hu;
        if (f == -2.1474836E9f) {
            return jad_jtVar.jad_kx;
        }
        return f;
    }

    public final boolean jad_fs() {
        if (this.jad_cp < 0.0f) {
            return true;
        }
        return false;
    }

    @MainThread
    public void jad_hu() {
        Choreographer.getInstance().removeFrameCallback(this);
        this.jad_kx = false;
    }

    public void jad_jt() {
        if (this.jad_kx) {
            Choreographer.getInstance().removeFrameCallback(this);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.jad_dq) {
            this.jad_dq = false;
            this.jad_cp = -this.jad_cp;
        }
    }

    public void jad_an(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_jw;
        float f3 = jad_jtVar == null ? -3.4028235E38f : jad_jtVar.jad_kx;
        float f4 = jad_jtVar == null ? Float.MAX_VALUE : jad_jtVar.jad_ly;
        PointF pointF = jad_jt.jad_an;
        float max = Math.max(f3, Math.min(f4, f));
        float max2 = Math.max(f3, Math.min(f4, f2));
        if (max == this.jad_hu && max2 == this.jad_iv) {
            return;
        }
        this.jad_hu = max;
        this.jad_iv = max2;
        jad_an((int) Math.max(max, Math.min(max2, this.jad_fs)));
    }
}
