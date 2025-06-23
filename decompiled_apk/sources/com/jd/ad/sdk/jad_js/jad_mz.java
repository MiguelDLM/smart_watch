package com.jd.ad.sdk.jad_js;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ud.jad_cp;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes10.dex */
public class jad_mz extends Drawable implements Drawable.Callback, Animatable {
    public final Matrix jad_an = new Matrix();
    public com.jd.ad.sdk.jad_js.jad_jt jad_bo;
    public final com.jd.ad.sdk.jad_ve.jad_er jad_cp;
    public float jad_dq;
    public boolean jad_er;
    public boolean jad_fs;
    public final ArrayList<jad_ob> jad_hu;

    @Nullable
    public com.jd.ad.sdk.jad_nw.jad_bo jad_iv;
    public boolean jad_jt;

    @Nullable
    public String jad_jw;

    @Nullable
    public com.jd.ad.sdk.jad_js.jad_bo jad_kx;

    @Nullable
    public com.jd.ad.sdk.jad_nw.jad_an jad_ly;

    @Nullable
    public com.jd.ad.sdk.jad_js.jad_an jad_mz;
    public boolean jad_na;

    @Nullable
    public com.jd.ad.sdk.jad_ra.jad_bo jad_ob;
    public int jad_pc;
    public boolean jad_qd;
    public boolean jad_re;
    public boolean jad_sf;
    public boolean jad_tg;
    public boolean jad_uh;

    /* loaded from: classes10.dex */
    public class jad_an implements jad_ob {
        public final /* synthetic */ String jad_an;

        public jad_an(String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_bo(this.jad_an);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_bo implements jad_ob {
        public final /* synthetic */ int jad_an;
        public final /* synthetic */ int jad_bo;

        public jad_bo(int i, int i2) {
            this.jad_an = i;
            this.jad_bo = i2;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_an(this.jad_an, this.jad_bo);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_cp implements jad_ob {
        public final /* synthetic */ int jad_an;

        public jad_cp(int i) {
            this.jad_an = i;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_an(this.jad_an);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_dq implements jad_ob {
        public final /* synthetic */ float jad_an;

        public jad_dq(float f) {
            this.jad_an = f;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_cp(this.jad_an);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_er implements jad_ob {
        public final /* synthetic */ com.jd.ad.sdk.jad_ox.jad_er jad_an;
        public final /* synthetic */ Object jad_bo;
        public final /* synthetic */ com.jd.ad.sdk.jad_wf.jad_cp jad_cp;

        public jad_er(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, Object obj, com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar) {
            this.jad_an = jad_erVar;
            this.jad_bo = obj;
            this.jad_cp = jad_cpVar;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_an(this.jad_an, this.jad_bo, this.jad_cp);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_fs implements ValueAnimator.AnimatorUpdateListener {
        public jad_fs() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            jad_mz jad_mzVar = jad_mz.this;
            com.jd.ad.sdk.jad_ra.jad_bo jad_boVar = jad_mzVar.jad_ob;
            if (jad_boVar != null) {
                jad_boVar.jad_cp(jad_mzVar.jad_cp.jad_cp());
            }
        }
    }

    /* loaded from: classes10.dex */
    public class jad_hu implements jad_ob {
        public jad_hu() {
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_jt();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_iv implements jad_ob {
        public final /* synthetic */ int jad_an;

        public jad_iv(int i) {
            this.jad_an = i;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_cp(this.jad_an);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_jt implements jad_ob {
        public jad_jt() {
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_fs();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_jw implements jad_ob {
        public final /* synthetic */ float jad_an;

        public jad_jw(float f) {
            this.jad_an = f;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_bo(this.jad_an);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_kx implements jad_ob {
        public final /* synthetic */ int jad_an;

        public jad_kx(int i) {
            this.jad_an = i;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_bo(this.jad_an);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_ly implements jad_ob {
        public final /* synthetic */ float jad_an;

        public jad_ly(float f) {
            this.jad_an = f;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_an(this.jad_an);
        }
    }

    /* renamed from: com.jd.ad.sdk.jad_js.jad_mz$jad_mz, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0688jad_mz implements jad_ob {
        public final /* synthetic */ String jad_an;

        public C0688jad_mz(String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_cp(this.jad_an);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_na implements jad_ob {
        public final /* synthetic */ String jad_an;

        public jad_na(String str) {
            this.jad_an = str;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_mz.jad_ob
        public void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar) {
            jad_mz.this.jad_an(this.jad_an);
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_ob {
        void jad_an(com.jd.ad.sdk.jad_js.jad_jt jad_jtVar);
    }

    public jad_mz() {
        com.jd.ad.sdk.jad_ve.jad_er jad_erVar = new com.jd.ad.sdk.jad_ve.jad_er();
        this.jad_cp = jad_erVar;
        this.jad_dq = 1.0f;
        this.jad_er = true;
        this.jad_fs = false;
        this.jad_jt = false;
        this.jad_hu = new ArrayList<>();
        jad_fs jad_fsVar = new jad_fs();
        this.jad_pc = 255;
        this.jad_tg = true;
        this.jad_uh = false;
        jad_erVar.addUpdateListener(jad_fsVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.jad_uh = false;
        if (this.jad_jt) {
            try {
                jad_an(canvas);
            } catch (Throwable unused) {
                com.jd.ad.sdk.jad_ve.jad_dq.jad_an.getClass();
            }
        } else {
            jad_an(canvas);
        }
        com.jd.ad.sdk.jad_js.jad_dq.jad_an("Drawable#draw");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.jad_pc;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.jad_bo == null) {
            return -1;
        }
        return (int) (this.jad_dq * r0.jad_jw.height());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.jad_bo == null) {
            return -1;
        }
        return (int) (this.jad_dq * r0.jad_jw.width());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.jad_uh) {
            return;
        }
        this.jad_uh = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return jad_er();
    }

    public void jad_an(int i) {
        if (this.jad_bo == null) {
            this.jad_hu.add(new jad_cp(i));
        } else {
            this.jad_cp.jad_an(i);
        }
    }

    public void jad_bo(String str) {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new jad_an(str));
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_hu jad_bo2 = jad_jtVar.jad_bo(str);
        if (jad_bo2 != null) {
            int i = (int) jad_bo2.jad_bo;
            jad_an(i, ((int) jad_bo2.jad_cp) + i);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
    }

    public void jad_cp(String str) {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new C0688jad_mz(str));
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_hu jad_bo2 = jad_jtVar.jad_bo(str);
        if (jad_bo2 != null) {
            jad_cp((int) jad_bo2.jad_bo);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    public com.jd.ad.sdk.jad_js.jad_jt jad_dq() {
        return this.jad_bo;
    }

    public boolean jad_er() {
        com.jd.ad.sdk.jad_ve.jad_er jad_erVar = this.jad_cp;
        if (jad_erVar == null) {
            return false;
        }
        return jad_erVar.jad_kx;
    }

    @MainThread
    public void jad_fs() {
        float jad_er2;
        float jad_dq2;
        if (this.jad_ob == null) {
            this.jad_hu.add(new jad_jt());
            return;
        }
        if (jad_an() || this.jad_cp.getRepeatCount() == 0) {
            com.jd.ad.sdk.jad_ve.jad_er jad_erVar = this.jad_cp;
            jad_erVar.jad_kx = true;
            boolean jad_fs2 = jad_erVar.jad_fs();
            for (Animator.AnimatorListener animatorListener : jad_erVar.jad_bo) {
                if (Build.VERSION.SDK_INT >= 26) {
                    animatorListener.onAnimationStart(jad_erVar, jad_fs2);
                } else {
                    animatorListener.onAnimationStart(jad_erVar);
                }
            }
            if (jad_erVar.jad_fs()) {
                jad_er2 = jad_erVar.jad_dq();
            } else {
                jad_er2 = jad_erVar.jad_er();
            }
            jad_erVar.jad_an((int) jad_er2);
            jad_erVar.jad_er = 0L;
            jad_erVar.jad_jt = 0;
            jad_erVar.jad_jt();
        }
        if (!jad_an()) {
            com.jd.ad.sdk.jad_ve.jad_er jad_erVar2 = this.jad_cp;
            if (jad_erVar2.jad_cp < 0.0f) {
                jad_dq2 = jad_erVar2.jad_er();
            } else {
                jad_dq2 = jad_erVar2.jad_dq();
            }
            jad_an((int) jad_dq2);
            this.jad_cp.jad_bo();
        }
    }

    @MainThread
    public void jad_jt() {
        float jad_dq2;
        if (this.jad_ob == null) {
            this.jad_hu.add(new jad_hu());
            return;
        }
        if (jad_an() || this.jad_cp.getRepeatCount() == 0) {
            com.jd.ad.sdk.jad_ve.jad_er jad_erVar = this.jad_cp;
            jad_erVar.jad_kx = true;
            jad_erVar.jad_jt();
            jad_erVar.jad_er = 0L;
            if (jad_erVar.jad_fs() && jad_erVar.jad_fs == jad_erVar.jad_er()) {
                jad_erVar.jad_fs = jad_erVar.jad_dq();
            } else if (!jad_erVar.jad_fs() && jad_erVar.jad_fs == jad_erVar.jad_dq()) {
                jad_erVar.jad_fs = jad_erVar.jad_er();
            }
        }
        if (!jad_an()) {
            com.jd.ad.sdk.jad_ve.jad_er jad_erVar2 = this.jad_cp;
            if (jad_erVar2.jad_cp < 0.0f) {
                jad_dq2 = jad_erVar2.jad_er();
            } else {
                jad_dq2 = jad_erVar2.jad_dq();
            }
            jad_an((int) jad_dq2);
            this.jad_cp.jad_bo();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.jad_pc = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        com.jd.ad.sdk.jad_ve.jad_dq.jad_an("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || ((View) callback).isInEditMode()) {
            return;
        }
        jad_fs();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        this.jad_hu.clear();
        this.jad_cp.jad_bo();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void jad_an(int i, int i2) {
        if (this.jad_bo == null) {
            this.jad_hu.add(new jad_bo(i, i2));
        } else {
            this.jad_cp.jad_an(i, i2 + 0.99f);
        }
    }

    public final void jad_bo() {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        jad_cp.jad_an jad_anVar = com.jd.ad.sdk.jad_tc.jad_vi.jad_an;
        Rect rect = jad_jtVar.jad_jw;
        com.jd.ad.sdk.jad_ra.jad_er jad_erVar = new com.jd.ad.sdk.jad_ra.jad_er(Collections.emptyList(), jad_jtVar, "__container", -1L, 1, -1L, null, Collections.emptyList(), new com.jd.ad.sdk.jad_py.jad_ly(null, null, null, null, null, null, null, null, null), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, Collections.emptyList(), 1, null, false, null, null);
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar2 = this.jad_bo;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar = new com.jd.ad.sdk.jad_ra.jad_bo(this, jad_erVar, jad_jtVar2.jad_iv, jad_jtVar2);
        this.jad_ob = jad_boVar;
        if (this.jad_re) {
            jad_boVar.jad_an(true);
        }
    }

    public void jad_cp() {
        com.jd.ad.sdk.jad_ve.jad_er jad_erVar = this.jad_cp;
        if (jad_erVar.jad_kx) {
            jad_erVar.cancel();
        }
        this.jad_bo = null;
        this.jad_ob = null;
        this.jad_iv = null;
        com.jd.ad.sdk.jad_ve.jad_er jad_erVar2 = this.jad_cp;
        jad_erVar2.jad_jw = null;
        jad_erVar2.jad_hu = -2.1474836E9f;
        jad_erVar2.jad_iv = 2.1474836E9f;
        invalidateSelf();
    }

    public void jad_an(String str) {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new jad_na(str));
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_hu jad_bo2 = jad_jtVar.jad_bo(str);
        if (jad_bo2 != null) {
            jad_bo((int) (jad_bo2.jad_bo + jad_bo2.jad_cp));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    public final boolean jad_an() {
        return this.jad_er || this.jad_fs;
    }

    public <T> void jad_an(com.jd.ad.sdk.jad_ox.jad_er jad_erVar, T t, @Nullable com.jd.ad.sdk.jad_wf.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar = this.jad_ob;
        if (jad_boVar == null) {
            this.jad_hu.add(new jad_er(jad_erVar, t, jad_cpVar));
            return;
        }
        boolean z = true;
        if (jad_erVar == com.jd.ad.sdk.jad_ox.jad_er.jad_cp) {
            jad_boVar.jad_an((com.jd.ad.sdk.jad_ra.jad_bo) t, (com.jd.ad.sdk.jad_wf.jad_cp<com.jd.ad.sdk.jad_ra.jad_bo>) jad_cpVar);
        } else {
            com.jd.ad.sdk.jad_ox.jad_fs jad_fsVar = jad_erVar.jad_bo;
            if (jad_fsVar != null) {
                jad_fsVar.jad_an(t, jad_cpVar);
            } else {
                ArrayList arrayList = new ArrayList();
                this.jad_ob.jad_an(jad_erVar, 0, arrayList, new com.jd.ad.sdk.jad_ox.jad_er(new String[0]));
                for (int i = 0; i < arrayList.size(); i++) {
                    ((com.jd.ad.sdk.jad_ox.jad_er) arrayList.get(i)).jad_bo.jad_an(t, jad_cpVar);
                }
                z = true ^ arrayList.isEmpty();
            }
        }
        if (z) {
            invalidateSelf();
            if (t == jad_re.jad_gr) {
                jad_cp(this.jad_cp.jad_cp());
            }
        }
    }

    public void jad_cp(int i) {
        if (this.jad_bo == null) {
            this.jad_hu.add(new jad_iv(i));
        } else {
            this.jad_cp.jad_an(i, (int) r0.jad_iv);
        }
    }

    public void jad_cp(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new jad_dq(f));
        } else {
            this.jad_cp.jad_an(com.jd.ad.sdk.jad_ve.jad_jt.jad_an(jad_jtVar.jad_kx, jad_jtVar.jad_ly, f));
            com.jd.ad.sdk.jad_js.jad_dq.jad_an("Drawable#setProgress");
        }
    }

    public void jad_bo(int i) {
        if (this.jad_bo == null) {
            this.jad_hu.add(new jad_kx(i));
            return;
        }
        com.jd.ad.sdk.jad_ve.jad_er jad_erVar = this.jad_cp;
        jad_erVar.jad_an(jad_erVar.jad_hu, i + 0.99f);
    }

    public void jad_bo(float f) {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new jad_jw(f));
        } else {
            jad_cp((int) com.jd.ad.sdk.jad_ve.jad_jt.jad_an(jad_jtVar.jad_kx, jad_jtVar.jad_ly, f));
        }
    }

    public final void jad_an(@NonNull Canvas canvas) {
        float f;
        float f2;
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        int i = -1;
        if (jad_jtVar != null && !getBounds().isEmpty()) {
            Rect bounds = getBounds();
            float width = bounds.width() / bounds.height();
            Rect rect = jad_jtVar.jad_jw;
            if (width != rect.width() / rect.height()) {
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar = this.jad_ob;
                com.jd.ad.sdk.jad_js.jad_jt jad_jtVar2 = this.jad_bo;
                if (jad_boVar == null || jad_jtVar2 == null) {
                    return;
                }
                Rect bounds2 = getBounds();
                float width2 = bounds2.width() / jad_jtVar2.jad_jw.width();
                float height = bounds2.height() / jad_jtVar2.jad_jw.height();
                if (this.jad_tg) {
                    float min = Math.min(width2, height);
                    if (min < 1.0f) {
                        f2 = 1.0f / min;
                        width2 /= f2;
                        height /= f2;
                    } else {
                        f2 = 1.0f;
                    }
                    if (f2 > 1.0f) {
                        i = canvas.save();
                        float width3 = bounds2.width() / 2.0f;
                        float height2 = bounds2.height() / 2.0f;
                        float f3 = width3 * min;
                        float f4 = min * height2;
                        canvas.translate(width3 - f3, height2 - f4);
                        canvas.scale(f2, f2, f3, f4);
                    }
                }
                this.jad_an.reset();
                this.jad_an.preScale(width2, height);
                jad_boVar.jad_an(canvas, this.jad_an, this.jad_pc);
                if (i > 0) {
                    canvas.restoreToCount(i);
                    return;
                }
                return;
            }
        }
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2 = this.jad_ob;
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar3 = this.jad_bo;
        if (jad_boVar2 == null || jad_jtVar3 == null) {
            return;
        }
        float f5 = this.jad_dq;
        float min2 = Math.min(canvas.getWidth() / jad_jtVar3.jad_jw.width(), canvas.getHeight() / jad_jtVar3.jad_jw.height());
        if (f5 > min2) {
            f = this.jad_dq / min2;
        } else {
            min2 = f5;
            f = 1.0f;
        }
        if (f > 1.0f) {
            i = canvas.save();
            float width4 = jad_jtVar3.jad_jw.width() / 2.0f;
            float height3 = jad_jtVar3.jad_jw.height() / 2.0f;
            float f6 = width4 * min2;
            float f7 = height3 * min2;
            float f8 = this.jad_dq;
            canvas.translate((width4 * f8) - f6, (f8 * height3) - f7);
            canvas.scale(f, f, f6, f7);
        }
        this.jad_an.reset();
        this.jad_an.preScale(min2, min2);
        jad_boVar2.jad_an(canvas, this.jad_an, this.jad_pc);
        if (i > 0) {
            canvas.restoreToCount(i);
        }
    }

    public void jad_an(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
        if (jad_jtVar == null) {
            this.jad_hu.add(new jad_ly(f));
        } else {
            jad_bo((int) com.jd.ad.sdk.jad_ve.jad_jt.jad_an(jad_jtVar.jad_kx, jad_jtVar.jad_ly, f));
        }
    }
}
