package com.jd.ad.sdk.lottie;

import XIXIX.OOXIXo;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PathMeasure;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.jd.ad.sdk.jad_js.jad_fs;
import com.jd.ad.sdk.jad_js.jad_iv;
import com.jd.ad.sdk.jad_js.jad_jt;
import com.jd.ad.sdk.jad_js.jad_jw;
import com.jd.ad.sdk.jad_js.jad_kx;
import com.jd.ad.sdk.jad_js.jad_ly;
import com.jd.ad.sdk.jad_js.jad_mz;
import com.jd.ad.sdk.jad_js.jad_ob;
import com.jd.ad.sdk.jad_js.jad_qd;
import com.jd.ad.sdk.jad_js.jad_re;
import com.jd.ad.sdk.jad_js.jad_uh;
import com.jd.ad.sdk.jad_js.jad_vi;
import com.jd.ad.sdk.jad_js.jad_wj;
import com.jd.ad.sdk.jad_js.jad_xk;
import com.jd.ad.sdk.jad_js.jad_yl;
import com.jd.ad.sdk.jad_ve.jad_hu;
import com.jd.ad.sdk.multi.R;
import java.io.ByteArrayInputStream;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLException;

/* loaded from: classes10.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static final jad_ob<Throwable> jad_tg = new jad_an();
    public final jad_ob<jad_jt> jad_an;
    public final jad_ob<Throwable> jad_bo;

    @Nullable
    public jad_ob<Throwable> jad_cp;

    @DrawableRes
    public int jad_dq;
    public final jad_mz jad_er;
    public boolean jad_fs;

    @RawRes
    public int jad_hu;
    public boolean jad_iv;
    public String jad_jt;
    public boolean jad_jw;
    public boolean jad_kx;
    public boolean jad_ly;
    public boolean jad_mz;
    public boolean jad_na;
    public jad_wj jad_ob;
    public final Set<jad_qd> jad_pc;
    public int jad_qd;

    @Nullable
    public jad_uh<jad_jt> jad_re;

    @Nullable
    public jad_jt jad_sf;

    /* loaded from: classes10.dex */
    public class jad_an implements jad_ob<Throwable> {
        @Override // com.jd.ad.sdk.jad_js.jad_ob
        public void jad_an(Throwable th) {
            Throwable th2 = th;
            ThreadLocal<PathMeasure> threadLocal = jad_hu.jad_an;
            if (!(th2 instanceof SocketException) && !(th2 instanceof ClosedChannelException) && !(th2 instanceof InterruptedIOException) && !(th2 instanceof ProtocolException) && !(th2 instanceof SSLException) && !(th2 instanceof UnknownHostException) && !(th2 instanceof UnknownServiceException)) {
                throw new IllegalStateException("Unable to parse composition", th2);
            }
            com.jd.ad.sdk.jad_ve.jad_dq.jad_an("Unable to load composition.", th2);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_bo implements jad_ob<jad_jt> {
        public jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_js.jad_ob
        public void jad_an(jad_jt jad_jtVar) {
            LottieAnimationView.this.setComposition(jad_jtVar);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_cp implements jad_ob<Throwable> {
        public jad_cp() {
        }

        @Override // com.jd.ad.sdk.jad_js.jad_ob
        public void jad_an(Throwable th) {
            Throwable th2 = th;
            LottieAnimationView lottieAnimationView = LottieAnimationView.this;
            int i = lottieAnimationView.jad_dq;
            if (i != 0) {
                lottieAnimationView.setImageResource(i);
            }
            jad_ob<Throwable> jad_obVar = LottieAnimationView.this.jad_cp;
            if (jad_obVar == null) {
                jad_obVar = LottieAnimationView.jad_tg;
            }
            jad_obVar.jad_an(th2);
        }
    }

    /* loaded from: classes10.dex */
    public static /* synthetic */ class jad_dq {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[jad_wj.values().length];
            jad_an = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jad_an[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_er extends View.BaseSavedState {
        public static final Parcelable.Creator<jad_er> CREATOR = new jad_an();
        public String jad_an;
        public int jad_bo;
        public float jad_cp;
        public boolean jad_dq;
        public String jad_er;
        public int jad_fs;
        public int jad_jt;

        /* loaded from: classes10.dex */
        public class jad_an implements Parcelable.Creator<jad_er> {
            @Override // android.os.Parcelable.Creator
            public jad_er createFromParcel(Parcel parcel) {
                return new jad_er(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public jad_er[] newArray(int i) {
                return new jad_er[i];
            }
        }

        public jad_er(Parcel parcel) {
            super(parcel);
            this.jad_an = parcel.readString();
            this.jad_cp = parcel.readFloat();
            this.jad_dq = parcel.readInt() == 1;
            this.jad_er = parcel.readString();
            this.jad_fs = parcel.readInt();
            this.jad_jt = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.jad_an);
            parcel.writeFloat(this.jad_cp);
            parcel.writeInt(this.jad_dq ? 1 : 0);
            parcel.writeString(this.jad_er);
            parcel.writeInt(this.jad_fs);
            parcel.writeInt(this.jad_jt);
        }

        public jad_er(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.jad_an = new jad_bo();
        this.jad_bo = new jad_cp();
        this.jad_dq = 0;
        this.jad_er = new jad_mz();
        this.jad_iv = false;
        this.jad_jw = false;
        this.jad_kx = false;
        this.jad_ly = false;
        this.jad_mz = false;
        this.jad_na = true;
        this.jad_ob = jad_wj.AUTOMATIC;
        this.jad_pc = new HashSet();
        this.jad_qd = 0;
        jad_an(null, R.attr.lottieAnimationViewStyle);
    }

    private void setCompositionTask(jad_uh<jad_jt> jad_uhVar) {
        this.jad_sf = null;
        this.jad_er.jad_cp();
        jad_an();
        this.jad_re = jad_uhVar.jad_bo(this.jad_an).jad_an(this.jad_bo);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        this.jad_qd++;
        super.buildDrawingCache(z);
        if (this.jad_qd == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(jad_wj.HARDWARE);
        }
        this.jad_qd--;
        com.jd.ad.sdk.jad_js.jad_dq.jad_an("buildDrawingCache");
    }

    @Nullable
    public jad_jt getComposition() {
        return this.jad_sf;
    }

    public long getDuration() {
        if (this.jad_sf != null) {
            return r0.jad_an();
        }
        return 0L;
    }

    public int getFrame() {
        return (int) this.jad_er.jad_cp.jad_fs;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.jad_er.jad_jw;
    }

    public float getMaxFrame() {
        return this.jad_er.jad_cp.jad_dq();
    }

    public float getMinFrame() {
        return this.jad_er.jad_cp.jad_er();
    }

    @Nullable
    public jad_vi getPerformanceTracker() {
        jad_jt jad_jtVar = this.jad_er.jad_bo;
        if (jad_jtVar != null) {
            return jad_jtVar.jad_an;
        }
        return null;
    }

    @FloatRange(from = OOXIXo.f3760XO, to = 1.0d)
    public float getProgress() {
        return this.jad_er.jad_cp.jad_cp();
    }

    public int getRepeatCount() {
        return this.jad_er.jad_cp.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.jad_er.jad_cp.getRepeatMode();
    }

    public float getScale() {
        return this.jad_er.jad_dq;
    }

    public float getSpeed() {
        return this.jad_er.jad_cp.jad_cp;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        jad_mz jad_mzVar = this.jad_er;
        if (drawable2 == jad_mzVar) {
            super.invalidateDrawable(jad_mzVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public final void jad_an() {
        jad_uh<jad_jt> jad_uhVar = this.jad_re;
        if (jad_uhVar != null) {
            jad_ob<jad_jt> jad_obVar = this.jad_an;
            synchronized (jad_uhVar) {
                jad_uhVar.jad_an.remove(jad_obVar);
            }
            jad_uh<jad_jt> jad_uhVar2 = this.jad_re;
            jad_ob<Throwable> jad_obVar2 = this.jad_bo;
            synchronized (jad_uhVar2) {
                jad_uhVar2.jad_bo.remove(jad_obVar2);
            }
        }
    }

    public final void jad_bo() {
        jad_jt jad_jtVar;
        int i;
        int i2 = jad_dq.jad_an[this.jad_ob.ordinal()];
        int i3 = 2;
        if (i2 != 1 && (i2 == 2 || i2 != 3 || (((jad_jtVar = this.jad_sf) != null && jad_jtVar.jad_na && Build.VERSION.SDK_INT < 28) || ((jad_jtVar != null && jad_jtVar.jad_ob > 4) || (i = Build.VERSION.SDK_INT) == 24 || i == 25)))) {
            i3 = 1;
        }
        if (i3 != getLayerType()) {
            setLayerType(i3, null);
        }
    }

    @MainThread
    public void jad_cp() {
        this.jad_mz = false;
        this.jad_kx = false;
        this.jad_jw = false;
        this.jad_iv = false;
        jad_mz jad_mzVar = this.jad_er;
        jad_mzVar.jad_hu.clear();
        jad_mzVar.jad_cp.jad_hu();
        jad_bo();
    }

    @MainThread
    public void jad_dq() {
        if (!isShown()) {
            this.jad_iv = true;
        } else {
            this.jad_er.jad_fs();
            jad_bo();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && (this.jad_mz || this.jad_kx)) {
            jad_dq();
            this.jad_mz = false;
            this.jad_kx = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (this.jad_er.jad_er()) {
            this.jad_kx = false;
            this.jad_jw = false;
            this.jad_iv = false;
            jad_mz jad_mzVar = this.jad_er;
            jad_mzVar.jad_hu.clear();
            jad_mzVar.jad_cp.cancel();
            jad_bo();
            this.jad_kx = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof jad_er)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        jad_er jad_erVar = (jad_er) parcelable;
        super.onRestoreInstanceState(jad_erVar.getSuperState());
        String str = jad_erVar.jad_an;
        this.jad_jt = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.jad_jt);
        }
        int i = jad_erVar.jad_bo;
        this.jad_hu = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(jad_erVar.jad_cp);
        if (jad_erVar.jad_dq) {
            jad_dq();
        }
        this.jad_er.jad_jw = jad_erVar.jad_er;
        setRepeatMode(jad_erVar.jad_fs);
        setRepeatCount(jad_erVar.jad_jt);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z;
        jad_er jad_erVar = new jad_er(super.onSaveInstanceState());
        jad_erVar.jad_an = this.jad_jt;
        jad_erVar.jad_bo = this.jad_hu;
        jad_erVar.jad_cp = this.jad_er.jad_cp.jad_cp();
        if (!this.jad_er.jad_er() && (ViewCompat.isAttachedToWindow(this) || !this.jad_kx)) {
            z = false;
        } else {
            z = true;
        }
        jad_erVar.jad_dq = z;
        jad_mz jad_mzVar = this.jad_er;
        jad_erVar.jad_er = jad_mzVar.jad_jw;
        jad_erVar.jad_fs = jad_mzVar.jad_cp.getRepeatMode();
        jad_erVar.jad_jt = this.jad_er.jad_cp.getRepeatCount();
        return jad_erVar;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        if (!this.jad_fs) {
            return;
        }
        if (isShown()) {
            if (this.jad_jw) {
                if (isShown()) {
                    this.jad_er.jad_jt();
                    jad_bo();
                } else {
                    this.jad_iv = false;
                    this.jad_jw = true;
                }
            } else if (this.jad_iv) {
                jad_dq();
            }
            this.jad_jw = false;
            this.jad_iv = false;
            return;
        }
        if (this.jad_er.jad_er()) {
            jad_cp();
            this.jad_jw = true;
        }
    }

    public void setAnimation(@RawRes int i) {
        jad_uh<jad_jt> jad_an2;
        this.jad_hu = i;
        this.jad_jt = null;
        if (isInEditMode()) {
            jad_an2 = new jad_uh<>(new com.jd.ad.sdk.jad_js.jad_er(this, i), true);
        } else if (this.jad_na) {
            Context context = getContext();
            String jad_an3 = com.jd.ad.sdk.jad_js.jad_hu.jad_an(context, i);
            jad_an2 = com.jd.ad.sdk.jad_js.jad_hu.jad_an(jad_an3, new jad_kx(new WeakReference(context), context.getApplicationContext(), i, jad_an3));
        } else {
            Context context2 = getContext();
            Map<String, jad_uh<jad_jt>> map = com.jd.ad.sdk.jad_js.jad_hu.jad_an;
            jad_an2 = com.jd.ad.sdk.jad_js.jad_hu.jad_an((String) null, new jad_kx(new WeakReference(context2), context2.getApplicationContext(), i, null));
        }
        setCompositionTask(jad_an2);
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        Map<String, jad_uh<jad_jt>> map = com.jd.ad.sdk.jad_js.jad_hu.jad_an;
        setCompositionTask(com.jd.ad.sdk.jad_js.jad_hu.jad_an((String) null, new jad_ly(byteArrayInputStream, null)));
    }

    public void setAnimationFromUrl(String str) {
        jad_uh<jad_jt> jad_an2;
        if (this.jad_na) {
            Context context = getContext();
            Map<String, jad_uh<jad_jt>> map = com.jd.ad.sdk.jad_js.jad_hu.jad_an;
            String str2 = "url_" + str;
            jad_an2 = com.jd.ad.sdk.jad_js.jad_hu.jad_an(str2, new jad_iv(context, str, str2));
        } else {
            Context context2 = getContext();
            Map<String, jad_uh<jad_jt>> map2 = com.jd.ad.sdk.jad_js.jad_hu.jad_an;
            jad_an2 = com.jd.ad.sdk.jad_js.jad_hu.jad_an((String) null, new jad_iv(context2, str, null));
        }
        setCompositionTask(jad_an2);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.jad_er.jad_sf = z;
    }

    public void setCacheComposition(boolean z) {
        this.jad_na = z;
    }

    public void setComposition(@NonNull jad_jt jad_jtVar) {
        boolean z;
        this.jad_er.setCallback(this);
        this.jad_sf = jad_jtVar;
        boolean z2 = true;
        this.jad_ly = true;
        jad_mz jad_mzVar = this.jad_er;
        if (jad_mzVar.jad_bo == jad_jtVar) {
            z2 = false;
        } else {
            jad_mzVar.jad_uh = false;
            jad_mzVar.jad_cp();
            jad_mzVar.jad_bo = jad_jtVar;
            jad_mzVar.jad_bo();
            com.jd.ad.sdk.jad_ve.jad_er jad_erVar = jad_mzVar.jad_cp;
            if (jad_erVar.jad_jw == null) {
                z = true;
            } else {
                z = false;
            }
            jad_erVar.jad_jw = jad_jtVar;
            if (z) {
                jad_erVar.jad_an((int) Math.max(jad_erVar.jad_hu, jad_jtVar.jad_kx), (int) Math.min(jad_erVar.jad_iv, jad_jtVar.jad_ly));
            } else {
                jad_erVar.jad_an((int) jad_jtVar.jad_kx, (int) jad_jtVar.jad_ly);
            }
            float f = jad_erVar.jad_fs;
            jad_erVar.jad_fs = 0.0f;
            jad_erVar.jad_an((int) f);
            jad_erVar.jad_an();
            jad_mzVar.jad_cp(jad_mzVar.jad_cp.getAnimatedFraction());
            jad_mzVar.jad_dq = jad_mzVar.jad_dq;
            Iterator it = new ArrayList(jad_mzVar.jad_hu).iterator();
            while (it.hasNext()) {
                jad_mz.jad_ob jad_obVar = (jad_mz.jad_ob) it.next();
                if (jad_obVar != null) {
                    jad_obVar.jad_an(jad_jtVar);
                }
                it.remove();
            }
            jad_mzVar.jad_hu.clear();
            jad_jtVar.jad_an.jad_an = jad_mzVar.jad_qd;
            Drawable.Callback callback = jad_mzVar.getCallback();
            if (callback instanceof ImageView) {
                ImageView imageView = (ImageView) callback;
                imageView.setImageDrawable(null);
                imageView.setImageDrawable(jad_mzVar);
            }
        }
        this.jad_ly = false;
        jad_bo();
        Drawable drawable = getDrawable();
        jad_mz jad_mzVar2 = this.jad_er;
        if (drawable == jad_mzVar2 && !z2) {
            return;
        }
        if (!z2) {
            boolean jad_er2 = jad_mzVar2.jad_er();
            setImageDrawable(null);
            setImageDrawable(this.jad_er);
            if (jad_er2) {
                this.jad_er.jad_jt();
            }
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator<jad_qd> it2 = this.jad_pc.iterator();
        while (it2.hasNext()) {
            it2.next().jad_an(jad_jtVar);
        }
    }

    public void setFailureListener(@Nullable jad_ob<Throwable> jad_obVar) {
        this.jad_cp = jad_obVar;
    }

    public void setFallbackResource(@DrawableRes int i) {
        this.jad_dq = i;
    }

    public void setFontAssetDelegate(com.jd.ad.sdk.jad_js.jad_an jad_anVar) {
        jad_mz jad_mzVar = this.jad_er;
        jad_mzVar.jad_mz = jad_anVar;
        com.jd.ad.sdk.jad_nw.jad_an jad_anVar2 = jad_mzVar.jad_ly;
        if (jad_anVar2 != null) {
            jad_anVar2.jad_er = jad_anVar;
        }
    }

    public void setFrame(int i) {
        this.jad_er.jad_an(i);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.jad_er.jad_fs = z;
    }

    public void setImageAssetDelegate(com.jd.ad.sdk.jad_js.jad_bo jad_boVar) {
        jad_mz jad_mzVar = this.jad_er;
        jad_mzVar.jad_kx = jad_boVar;
        com.jd.ad.sdk.jad_nw.jad_bo jad_boVar2 = jad_mzVar.jad_iv;
        if (jad_boVar2 != null) {
            jad_boVar2.jad_cp = jad_boVar;
        }
    }

    public void setImageAssetsFolder(String str) {
        this.jad_er.jad_jw = str;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        jad_an();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        jad_an();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        jad_an();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.jad_er.jad_bo(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.jad_er.jad_an(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.jad_er.jad_bo(str);
    }

    public void setMinFrame(int i) {
        this.jad_er.jad_cp(i);
    }

    public void setMinProgress(float f) {
        this.jad_er.jad_bo(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        jad_mz jad_mzVar = this.jad_er;
        if (jad_mzVar.jad_re != z) {
            jad_mzVar.jad_re = z;
            com.jd.ad.sdk.jad_ra.jad_bo jad_boVar = jad_mzVar.jad_ob;
            if (jad_boVar != null) {
                jad_boVar.jad_an(z);
            }
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        jad_mz jad_mzVar = this.jad_er;
        jad_mzVar.jad_qd = z;
        jad_jt jad_jtVar = jad_mzVar.jad_bo;
        if (jad_jtVar != null) {
            jad_jtVar.jad_an.jad_an = z;
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.jad_er.jad_cp(f);
    }

    public void setRenderMode(jad_wj jad_wjVar) {
        this.jad_ob = jad_wjVar;
        jad_bo();
    }

    public void setRepeatCount(int i) {
        this.jad_er.jad_cp.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.jad_er.jad_cp.setRepeatMode(i);
    }

    public void setSafeMode(boolean z) {
        this.jad_er.jad_jt = z;
    }

    public void setScale(float f) {
        this.jad_er.jad_dq = f;
        Drawable drawable = getDrawable();
        jad_mz jad_mzVar = this.jad_er;
        if (drawable == jad_mzVar) {
            boolean jad_er2 = jad_mzVar.jad_er();
            setImageDrawable(null);
            setImageDrawable(this.jad_er);
            if (jad_er2) {
                this.jad_er.jad_jt();
            }
        }
    }

    public void setSpeed(float f) {
        this.jad_er.jad_cp.jad_cp = f;
    }

    public void setTextDelegate(jad_yl jad_ylVar) {
        this.jad_er.getClass();
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        jad_mz jad_mzVar;
        if (!this.jad_ly && drawable == (jad_mzVar = this.jad_er) && jad_mzVar.jad_er()) {
            jad_cp();
        } else if (!this.jad_ly && (drawable instanceof jad_mz)) {
            jad_mz jad_mzVar2 = (jad_mz) drawable;
            if (jad_mzVar2.jad_er()) {
                jad_mzVar2.jad_hu.clear();
                jad_mzVar2.jad_cp.jad_hu();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jad_an = new jad_bo();
        this.jad_bo = new jad_cp();
        this.jad_dq = 0;
        this.jad_er = new jad_mz();
        this.jad_iv = false;
        this.jad_jw = false;
        this.jad_kx = false;
        this.jad_ly = false;
        this.jad_mz = false;
        this.jad_na = true;
        this.jad_ob = jad_wj.AUTOMATIC;
        this.jad_pc = new HashSet();
        this.jad_qd = 0;
        jad_an(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public void setMaxFrame(String str) {
        this.jad_er.jad_an(str);
    }

    public void setMinFrame(String str) {
        this.jad_er.jad_cp(str);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jad_an = new jad_bo();
        this.jad_bo = new jad_cp();
        this.jad_dq = 0;
        this.jad_er = new jad_mz();
        this.jad_iv = false;
        this.jad_jw = false;
        this.jad_kx = false;
        this.jad_ly = false;
        this.jad_mz = false;
        this.jad_na = true;
        this.jad_ob = jad_wj.AUTOMATIC;
        this.jad_pc = new HashSet();
        this.jad_qd = 0;
        jad_an(attributeSet, i);
    }

    public final void jad_an(@Nullable AttributeSet attributeSet, @AttrRes int i) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i, 0);
        this.jad_na = obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        int i2 = R.styleable.LottieAnimationView_lottie_rawRes;
        boolean hasValue = obtainStyledAttributes.hasValue(i2);
        int i3 = R.styleable.LottieAnimationView_lottie_fileName;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i3);
        int i4 = R.styleable.LottieAnimationView_lottie_url;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i4);
        if (hasValue && hasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (hasValue) {
            int resourceId = obtainStyledAttributes.getResourceId(i2, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (hasValue2) {
            String string2 = obtainStyledAttributes.getString(i3);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (hasValue3 && (string = obtainStyledAttributes.getString(i4)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.jad_kx = true;
            this.jad_mz = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.jad_er.jad_cp.setRepeatCount(-1);
        }
        int i5 = R.styleable.LottieAnimationView_lottie_repeatMode;
        if (obtainStyledAttributes.hasValue(i5)) {
            setRepeatMode(obtainStyledAttributes.getInt(i5, 1));
        }
        int i6 = R.styleable.LottieAnimationView_lottie_repeatCount;
        if (obtainStyledAttributes.hasValue(i6)) {
            setRepeatCount(obtainStyledAttributes.getInt(i6, -1));
        }
        int i7 = R.styleable.LottieAnimationView_lottie_speed;
        if (obtainStyledAttributes.hasValue(i7)) {
            setSpeed(obtainStyledAttributes.getFloat(i7, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        jad_mz jad_mzVar = this.jad_er;
        if (jad_mzVar.jad_na != z) {
            jad_mzVar.jad_na = z;
            if (jad_mzVar.jad_bo != null) {
                jad_mzVar.jad_bo();
            }
        }
        int i8 = R.styleable.LottieAnimationView_lottie_colorFilter;
        if (obtainStyledAttributes.hasValue(i8)) {
            jad_xk jad_xkVar = new jad_xk(AppCompatResources.getColorStateList(getContext(), obtainStyledAttributes.getResourceId(i8, -1)).getDefaultColor());
            this.jad_er.jad_an(new com.jd.ad.sdk.jad_ox.jad_er("**"), jad_re.jad_mx, new com.jd.ad.sdk.jad_wf.jad_cp(jad_xkVar));
        }
        int i9 = R.styleable.LottieAnimationView_lottie_scale;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.jad_er.jad_dq = obtainStyledAttributes.getFloat(i9, 1.0f);
        }
        int i10 = R.styleable.LottieAnimationView_lottie_renderMode;
        if (obtainStyledAttributes.hasValue(i10)) {
            int i11 = obtainStyledAttributes.getInt(i10, 0);
            if (i11 >= jad_wj.values().length) {
                i11 = 0;
            }
            setRenderMode(jad_wj.values()[i11]);
        }
        setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        obtainStyledAttributes.recycle();
        jad_bo();
        this.jad_fs = true;
    }

    public void setAnimation(String str) {
        jad_uh<jad_jt> jad_an2;
        this.jad_jt = str;
        this.jad_hu = 0;
        if (isInEditMode()) {
            jad_an2 = new jad_uh<>(new jad_fs(this, str), true);
        } else if (this.jad_na) {
            Context context = getContext();
            Map<String, jad_uh<jad_jt>> map = com.jd.ad.sdk.jad_js.jad_hu.jad_an;
            String str2 = "asset_" + str;
            jad_an2 = com.jd.ad.sdk.jad_js.jad_hu.jad_an(str2, new jad_jw(context.getApplicationContext(), str, str2));
        } else {
            Context context2 = getContext();
            Map<String, jad_uh<jad_jt>> map2 = com.jd.ad.sdk.jad_js.jad_hu.jad_an;
            jad_an2 = com.jd.ad.sdk.jad_js.jad_hu.jad_an((String) null, new jad_jw(context2.getApplicationContext(), str, null));
        }
        setCompositionTask(jad_an2);
    }
}
