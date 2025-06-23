package com.jd.ad.sdk.jad_al;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_al.jad_an;
import com.jd.ad.sdk.jad_hs.jad_na;
import com.jd.ad.sdk.jad_kv.jad_ly;
import java.util.Map;

/* loaded from: classes10.dex */
public abstract class jad_an<T extends jad_an<T>> implements Cloneable {
    public int jad_an;

    @Nullable
    public Drawable jad_er;
    public int jad_fs;
    public int jad_hu;

    @Nullable
    public Drawable jad_jt;
    public boolean jad_mz;

    @Nullable
    public Drawable jad_ob;
    public int jad_pc;
    public boolean jad_tg;

    @Nullable
    public Resources.Theme jad_uh;
    public boolean jad_vi;
    public boolean jad_wj;
    public boolean jad_xk;
    public boolean jad_zm;
    public float jad_bo = 1.0f;

    @NonNull
    public jad_ly jad_cp = jad_ly.jad_cp;

    @NonNull
    public com.jd.ad.sdk.jad_ep.jad_jt jad_dq = com.jd.ad.sdk.jad_ep.jad_jt.NORMAL;
    public boolean jad_iv = true;
    public int jad_jw = -1;
    public int jad_kx = -1;

    @NonNull
    public com.jd.ad.sdk.jad_hs.jad_hu jad_ly = com.jd.ad.sdk.jad_fo.jad_an.jad_bo;
    public boolean jad_na = true;

    @NonNull
    public com.jd.ad.sdk.jad_hs.jad_jw jad_qd = new com.jd.ad.sdk.jad_hs.jad_jw();

    @NonNull
    public Map<Class<?>, jad_na<?>> jad_re = new com.jd.ad.sdk.jad_gp.jad_bo();

    @NonNull
    public Class<?> jad_sf = Object.class;
    public boolean jad_yl = true;

    public boolean equals(Object obj) {
        if (!(obj instanceof jad_an)) {
            return false;
        }
        jad_an jad_anVar = (jad_an) obj;
        return Float.compare(jad_anVar.jad_bo, this.jad_bo) == 0 && this.jad_fs == jad_anVar.jad_fs && com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_er, jad_anVar.jad_er) && this.jad_hu == jad_anVar.jad_hu && com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_jt, jad_anVar.jad_jt) && this.jad_pc == jad_anVar.jad_pc && com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_ob, jad_anVar.jad_ob) && this.jad_iv == jad_anVar.jad_iv && this.jad_jw == jad_anVar.jad_jw && this.jad_kx == jad_anVar.jad_kx && this.jad_mz == jad_anVar.jad_mz && this.jad_na == jad_anVar.jad_na && this.jad_wj == jad_anVar.jad_wj && this.jad_xk == jad_anVar.jad_xk && this.jad_cp.equals(jad_anVar.jad_cp) && this.jad_dq == jad_anVar.jad_dq && this.jad_qd.equals(jad_anVar.jad_qd) && this.jad_re.equals(jad_anVar.jad_re) && this.jad_sf.equals(jad_anVar.jad_sf) && com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_ly, jad_anVar.jad_ly) && com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_uh, jad_anVar.jad_uh);
    }

    public int hashCode() {
        float f = this.jad_bo;
        char[] cArr = com.jd.ad.sdk.jad_gp.jad_ly.jad_an;
        return com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_uh, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_ly, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_sf, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_re, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_qd, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_dq, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_cp, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_xk ? 1 : 0, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_wj ? 1 : 0, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_na ? 1 : 0, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_mz ? 1 : 0, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_kx, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_jw, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_iv ? 1 : 0, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_ob, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_pc, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_jt, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_hu, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_er, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_fs, com.jd.ad.sdk.jad_gp.jad_ly.jad_an(Float.floatToIntBits(f), 17)))))))))))))))))))));
    }

    @Override // 
    @CheckResult
    /* renamed from: jad_an, reason: merged with bridge method [inline-methods] */
    public T clone() {
        try {
            T t = (T) super.clone();
            com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar = new com.jd.ad.sdk.jad_hs.jad_jw();
            t.jad_qd = jad_jwVar;
            jad_jwVar.jad_an(this.jad_qd);
            com.jd.ad.sdk.jad_gp.jad_bo jad_boVar = new com.jd.ad.sdk.jad_gp.jad_bo();
            t.jad_re = jad_boVar;
            jad_boVar.putAll(this.jad_re);
            t.jad_tg = false;
            t.jad_vi = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    public final T jad_bo() {
        if (this.jad_tg) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    @NonNull
    @CheckResult
    public T jad_an(@NonNull jad_an<?> jad_anVar) {
        if (this.jad_vi) {
            return (T) clone().jad_an(jad_anVar);
        }
        if (jad_an(jad_anVar.jad_an, 2)) {
            this.jad_bo = jad_anVar.jad_bo;
        }
        if (jad_an(jad_anVar.jad_an, 262144)) {
            this.jad_wj = jad_anVar.jad_wj;
        }
        if (jad_an(jad_anVar.jad_an, 1048576)) {
            this.jad_zm = jad_anVar.jad_zm;
        }
        if (jad_an(jad_anVar.jad_an, 4)) {
            this.jad_cp = jad_anVar.jad_cp;
        }
        if (jad_an(jad_anVar.jad_an, 8)) {
            this.jad_dq = jad_anVar.jad_dq;
        }
        if (jad_an(jad_anVar.jad_an, 16)) {
            this.jad_er = jad_anVar.jad_er;
            this.jad_fs = 0;
            this.jad_an &= -33;
        }
        if (jad_an(jad_anVar.jad_an, 32)) {
            this.jad_fs = jad_anVar.jad_fs;
            this.jad_er = null;
            this.jad_an &= -17;
        }
        if (jad_an(jad_anVar.jad_an, 64)) {
            this.jad_jt = jad_anVar.jad_jt;
            this.jad_hu = 0;
            this.jad_an &= -129;
        }
        if (jad_an(jad_anVar.jad_an, 128)) {
            this.jad_hu = jad_anVar.jad_hu;
            this.jad_jt = null;
            this.jad_an &= -65;
        }
        if (jad_an(jad_anVar.jad_an, 256)) {
            this.jad_iv = jad_anVar.jad_iv;
        }
        if (jad_an(jad_anVar.jad_an, 512)) {
            this.jad_kx = jad_anVar.jad_kx;
            this.jad_jw = jad_anVar.jad_jw;
        }
        if (jad_an(jad_anVar.jad_an, 1024)) {
            this.jad_ly = jad_anVar.jad_ly;
        }
        if (jad_an(jad_anVar.jad_an, 4096)) {
            this.jad_sf = jad_anVar.jad_sf;
        }
        if (jad_an(jad_anVar.jad_an, 8192)) {
            this.jad_ob = jad_anVar.jad_ob;
            this.jad_pc = 0;
            this.jad_an &= -16385;
        }
        if (jad_an(jad_anVar.jad_an, 16384)) {
            this.jad_pc = jad_anVar.jad_pc;
            this.jad_ob = null;
            this.jad_an &= -8193;
        }
        if (jad_an(jad_anVar.jad_an, 32768)) {
            this.jad_uh = jad_anVar.jad_uh;
        }
        if (jad_an(jad_anVar.jad_an, 65536)) {
            this.jad_na = jad_anVar.jad_na;
        }
        if (jad_an(jad_anVar.jad_an, 131072)) {
            this.jad_mz = jad_anVar.jad_mz;
        }
        if (jad_an(jad_anVar.jad_an, 2048)) {
            this.jad_re.putAll(jad_anVar.jad_re);
            this.jad_yl = jad_anVar.jad_yl;
        }
        if (jad_an(jad_anVar.jad_an, 524288)) {
            this.jad_xk = jad_anVar.jad_xk;
        }
        if (!this.jad_na) {
            this.jad_re.clear();
            int i = this.jad_an;
            this.jad_mz = false;
            this.jad_an = i & (-133121);
            this.jad_yl = true;
        }
        this.jad_an |= jad_anVar.jad_an;
        this.jad_qd.jad_an(jad_anVar.jad_qd);
        return jad_bo();
    }

    @NonNull
    @CheckResult
    public T jad_bo(int i, int i2) {
        if (this.jad_vi) {
            return (T) clone().jad_bo(i, i2);
        }
        this.jad_kx = i;
        this.jad_jw = i2;
        this.jad_an |= 512;
        return jad_bo();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public T jad_an(@NonNull jad_na<Bitmap> jad_naVar, boolean z) {
        if (this.jad_vi) {
            return (T) clone().jad_an(jad_naVar, z);
        }
        com.jd.ad.sdk.jad_rc.jad_ly jad_lyVar = new com.jd.ad.sdk.jad_rc.jad_ly(jad_naVar, z);
        jad_an(Bitmap.class, jad_naVar, z);
        jad_an(Drawable.class, jad_lyVar, z);
        jad_an(BitmapDrawable.class, jad_lyVar, z);
        jad_an(com.jd.ad.sdk.jad_vg.jad_cp.class, new com.jd.ad.sdk.jad_vg.jad_fs(jad_naVar), z);
        return jad_bo();
    }

    @NonNull
    @CheckResult
    public T jad_bo(boolean z) {
        if (this.jad_vi) {
            return (T) clone().jad_bo(z);
        }
        this.jad_zm = z;
        this.jad_an |= 1048576;
        return jad_bo();
    }

    @NonNull
    @CheckResult
    public T jad_an(boolean z) {
        if (this.jad_vi) {
            return (T) clone().jad_an(true);
        }
        this.jad_iv = !z;
        this.jad_an |= 256;
        return jad_bo();
    }

    public static boolean jad_an(int i, int i2) {
        return (i & i2) != 0;
    }

    @NonNull
    @CheckResult
    public T jad_an(@NonNull Class<?> cls) {
        if (this.jad_vi) {
            return (T) clone().jad_an(cls);
        }
        if (cls != null) {
            this.jad_sf = cls;
            this.jad_an |= 4096;
            return jad_bo();
        }
        throw new NullPointerException("Argument must not be null");
    }

    @NonNull
    @CheckResult
    public T jad_an(@NonNull jad_ly jad_lyVar) {
        if (this.jad_vi) {
            return (T) clone().jad_an(jad_lyVar);
        }
        if (jad_lyVar != null) {
            this.jad_cp = jad_lyVar;
            this.jad_an |= 4;
            return jad_bo();
        }
        throw new NullPointerException("Argument must not be null");
    }

    @NonNull
    @CheckResult
    public T jad_an(@NonNull com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar) {
        if (this.jad_vi) {
            return (T) clone().jad_an(jad_jtVar);
        }
        if (jad_jtVar != null) {
            this.jad_dq = jad_jtVar;
            this.jad_an |= 8;
            return jad_bo();
        }
        throw new NullPointerException("Argument must not be null");
    }

    @NonNull
    @CheckResult
    public T jad_an(@NonNull com.jd.ad.sdk.jad_hs.jad_hu jad_huVar) {
        if (this.jad_vi) {
            return (T) clone().jad_an(jad_huVar);
        }
        if (jad_huVar != null) {
            this.jad_ly = jad_huVar;
            this.jad_an |= 1024;
            return jad_bo();
        }
        throw new NullPointerException("Argument must not be null");
    }

    @NonNull
    public <Y> T jad_an(@NonNull Class<Y> cls, @NonNull jad_na<Y> jad_naVar, boolean z) {
        if (this.jad_vi) {
            return (T) clone().jad_an(cls, jad_naVar, z);
        }
        if (cls == null) {
            throw new NullPointerException("Argument must not be null");
        }
        if (jad_naVar != null) {
            this.jad_re.put(cls, jad_naVar);
            int i = this.jad_an;
            this.jad_na = true;
            this.jad_an = 67584 | i;
            this.jad_yl = false;
            if (z) {
                this.jad_an = i | 198656;
                this.jad_mz = true;
            }
            return jad_bo();
        }
        throw new NullPointerException("Argument must not be null");
    }
}
