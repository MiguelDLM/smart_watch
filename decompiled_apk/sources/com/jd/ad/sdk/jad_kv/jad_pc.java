package com.jd.ad.sdk.jad_kv;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes10.dex */
public class jad_pc implements com.jd.ad.sdk.jad_hs.jad_hu {
    public final Object jad_bo;
    public final int jad_cp;
    public final int jad_dq;
    public final Class<?> jad_er;
    public final Class<?> jad_fs;
    public final Map<Class<?>, com.jd.ad.sdk.jad_hs.jad_na<?>> jad_hu;
    public final com.jd.ad.sdk.jad_hs.jad_jw jad_iv;
    public final com.jd.ad.sdk.jad_hs.jad_hu jad_jt;
    public int jad_jw;

    public jad_pc(Object obj, com.jd.ad.sdk.jad_hs.jad_hu jad_huVar, int i, int i2, Map<Class<?>, com.jd.ad.sdk.jad_hs.jad_na<?>> map, Class<?> cls, Class<?> cls2, com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        this.jad_bo = com.jd.ad.sdk.jad_gp.jad_kx.jad_an(obj);
        this.jad_jt = (com.jd.ad.sdk.jad_hs.jad_hu) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_huVar, "Signature must not be null");
        this.jad_cp = i;
        this.jad_dq = i2;
        this.jad_hu = (Map) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(map);
        this.jad_er = (Class) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(cls, "Resource class must not be null");
        this.jad_fs = (Class) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(cls2, "Transcode class must not be null");
        this.jad_iv = (com.jd.ad.sdk.jad_hs.jad_jw) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public boolean equals(Object obj) {
        if (!(obj instanceof jad_pc)) {
            return false;
        }
        jad_pc jad_pcVar = (jad_pc) obj;
        return this.jad_bo.equals(jad_pcVar.jad_bo) && this.jad_jt.equals(jad_pcVar.jad_jt) && this.jad_dq == jad_pcVar.jad_dq && this.jad_cp == jad_pcVar.jad_cp && this.jad_hu.equals(jad_pcVar.jad_hu) && this.jad_er.equals(jad_pcVar.jad_er) && this.jad_fs.equals(jad_pcVar.jad_fs) && this.jad_iv.equals(jad_pcVar.jad_iv);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public int hashCode() {
        if (this.jad_jw == 0) {
            int hashCode = this.jad_bo.hashCode();
            this.jad_jw = hashCode;
            int hashCode2 = ((((this.jad_jt.hashCode() + (hashCode * 31)) * 31) + this.jad_cp) * 31) + this.jad_dq;
            this.jad_jw = hashCode2;
            int hashCode3 = this.jad_hu.hashCode() + (hashCode2 * 31);
            this.jad_jw = hashCode3;
            int hashCode4 = this.jad_er.hashCode() + (hashCode3 * 31);
            this.jad_jw = hashCode4;
            int hashCode5 = this.jad_fs.hashCode() + (hashCode4 * 31);
            this.jad_jw = hashCode5;
            this.jad_jw = this.jad_iv.jad_bo.hashCode() + (hashCode5 * 31);
        }
        return this.jad_jw;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public void jad_an(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("EngineKey{model=");
        jad_an.append(this.jad_bo);
        jad_an.append(", width=");
        jad_an.append(this.jad_cp);
        jad_an.append(", height=");
        jad_an.append(this.jad_dq);
        jad_an.append(", resourceClass=");
        jad_an.append(this.jad_er);
        jad_an.append(", transcodeClass=");
        jad_an.append(this.jad_fs);
        jad_an.append(", signature=");
        jad_an.append(this.jad_jt);
        jad_an.append(", hashCode=");
        jad_an.append(this.jad_jw);
        jad_an.append(", transformations=");
        jad_an.append(this.jad_hu);
        jad_an.append(", options=");
        jad_an.append(this.jad_iv);
        jad_an.append('}');
        return jad_an.toString();
    }
}
