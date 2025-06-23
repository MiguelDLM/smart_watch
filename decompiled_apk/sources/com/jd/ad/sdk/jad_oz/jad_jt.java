package com.jd.ad.sdk.jad_oz;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.URL;
import java.security.MessageDigest;

/* loaded from: classes10.dex */
public class jad_jt implements com.jd.ad.sdk.jad_hs.jad_hu {
    public final jad_hu jad_bo;

    @Nullable
    public final URL jad_cp;

    @Nullable
    public final String jad_dq;

    @Nullable
    public String jad_er;

    @Nullable
    public URL jad_fs;
    public int jad_hu;

    @Nullable
    public volatile byte[] jad_jt;

    public jad_jt(String str, jad_hu jad_huVar) {
        this.jad_cp = null;
        this.jad_dq = com.jd.ad.sdk.jad_gp.jad_kx.jad_an(str);
        this.jad_bo = (jad_hu) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_huVar);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public boolean equals(Object obj) {
        if (!(obj instanceof jad_jt)) {
            return false;
        }
        jad_jt jad_jtVar = (jad_jt) obj;
        return jad_an().equals(jad_jtVar.jad_an()) && this.jad_bo.equals(jad_jtVar.jad_bo);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public int hashCode() {
        if (this.jad_hu == 0) {
            int hashCode = jad_an().hashCode();
            this.jad_hu = hashCode;
            this.jad_hu = this.jad_bo.hashCode() + (hashCode * 31);
        }
        return this.jad_hu;
    }

    public String jad_an() {
        String str = this.jad_dq;
        return str != null ? str : ((URL) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(this.jad_cp)).toString();
    }

    public URL jad_bo() {
        if (this.jad_fs == null) {
            if (TextUtils.isEmpty(this.jad_er)) {
                String str = this.jad_dq;
                if (TextUtils.isEmpty(str)) {
                    str = ((URL) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(this.jad_cp)).toString();
                }
                this.jad_er = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.jad_fs = new URL(this.jad_er);
        }
        return this.jad_fs;
    }

    public String toString() {
        return jad_an();
    }

    public jad_jt(URL url, jad_hu jad_huVar) {
        this.jad_cp = (URL) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(url);
        this.jad_dq = null;
        this.jad_bo = (jad_hu) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_huVar);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_hu
    public void jad_an(@NonNull MessageDigest messageDigest) {
        if (this.jad_jt == null) {
            this.jad_jt = jad_an().getBytes(com.jd.ad.sdk.jad_hs.jad_hu.jad_an);
        }
        messageDigest.update(this.jad_jt);
    }
}
