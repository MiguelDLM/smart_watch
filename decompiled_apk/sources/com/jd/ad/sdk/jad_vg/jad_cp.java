package com.jd.ad.sdk.jad_vg;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.jd.ad.sdk.jad_gp.jad_kx;
import com.jd.ad.sdk.jad_vg.jad_jt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_cp extends Drawable implements jad_jt.jad_bo, Animatable, Animatable2Compat {
    public final jad_an jad_an;
    public boolean jad_bo;
    public boolean jad_cp;
    public boolean jad_dq;
    public int jad_fs;
    public boolean jad_hu;
    public Paint jad_iv;
    public Rect jad_jw;
    public List<Animatable2Compat.AnimationCallback> jad_kx;
    public boolean jad_er = true;
    public int jad_jt = -1;

    /* loaded from: classes10.dex */
    public static final class jad_an extends Drawable.ConstantState {

        @VisibleForTesting
        public final jad_jt jad_an;

        public jad_an(jad_jt jad_jtVar) {
            this.jad_an = jad_jtVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new jad_cp(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new jad_cp(this);
        }
    }

    public jad_cp(jad_an jad_anVar) {
        this.jad_an = (jad_an) jad_kx.jad_an(jad_anVar);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.jad_kx;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap;
        if (this.jad_dq) {
            return;
        }
        if (this.jad_hu) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.jad_jw == null) {
                this.jad_jw = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.jad_jw);
            this.jad_hu = false;
        }
        jad_jt jad_jtVar = this.jad_an.jad_an;
        jad_jt.jad_an jad_anVar = jad_jtVar.jad_iv;
        if (jad_anVar != null) {
            bitmap = jad_anVar.jad_jt;
        } else {
            bitmap = jad_jtVar.jad_ly;
        }
        if (this.jad_jw == null) {
            this.jad_jw = new Rect();
        }
        canvas.drawBitmap(bitmap, (Rect) null, this.jad_jw, jad_cp());
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.jad_an;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.jad_an.jad_an.jad_qd;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.jad_an.jad_an.jad_pc;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_vg.jad_jt.jad_bo
    public void jad_an() {
        int i;
        Object callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        jad_jt.jad_an jad_anVar = this.jad_an.jad_an.jad_iv;
        if (jad_anVar != null) {
            i = jad_anVar.jad_er;
        } else {
            i = -1;
        }
        if (i == r0.jad_an.jad_bo() - 1) {
            this.jad_fs++;
        }
        int i2 = this.jad_jt;
        if (i2 != -1 && this.jad_fs >= i2) {
            List<Animatable2Compat.AnimationCallback> list = this.jad_kx;
            if (list != null) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.jad_kx.get(i3).onAnimationEnd(this);
                }
            }
            stop();
        }
    }

    public Bitmap jad_bo() {
        return this.jad_an.jad_an.jad_ly;
    }

    public final Paint jad_cp() {
        if (this.jad_iv == null) {
            this.jad_iv = new Paint(2);
        }
        return this.jad_iv;
    }

    public final void jad_dq() {
        jad_kx.jad_an(!this.jad_dq, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.jad_an.jad_an.jad_an.jad_bo() != 1) {
            if (!this.jad_bo) {
                this.jad_bo = true;
                jad_jt jad_jtVar = this.jad_an.jad_an;
                if (!jad_jtVar.jad_jw) {
                    if (!jad_jtVar.jad_cp.contains(this)) {
                        boolean isEmpty = jad_jtVar.jad_cp.isEmpty();
                        jad_jtVar.jad_cp.add(this);
                        if (isEmpty && !jad_jtVar.jad_fs) {
                            jad_jtVar.jad_fs = true;
                            jad_jtVar.jad_jw = false;
                            jad_jtVar.jad_an();
                        }
                    } else {
                        throw new IllegalStateException("Cannot subscribe twice in a row");
                    }
                } else {
                    throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
                }
            } else {
                return;
            }
        }
        invalidateSelf();
    }

    public final void jad_er() {
        this.jad_bo = false;
        jad_jt jad_jtVar = this.jad_an.jad_an;
        jad_jtVar.jad_cp.remove(this);
        if (jad_jtVar.jad_cp.isEmpty()) {
            jad_jtVar.jad_fs = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.jad_hu = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.jad_kx == null) {
            this.jad_kx = new ArrayList();
        }
        this.jad_kx.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        jad_cp().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        jad_cp().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        jad_kx.jad_an(!this.jad_dq, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.jad_er = z;
        if (!z) {
            jad_er();
        } else if (this.jad_cp) {
            jad_dq();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.jad_cp = true;
        this.jad_fs = 0;
        if (this.jad_er) {
            jad_dq();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.jad_cp = false;
        jad_er();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.jad_kx;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }
}
