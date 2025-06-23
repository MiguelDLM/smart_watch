package com.jd.ad.sdk.jad_ra;

import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_py.jad_jw;
import com.jd.ad.sdk.jad_py.jad_kx;
import com.jd.ad.sdk.jad_py.jad_ly;
import java.util.List;
import java.util.Locale;

/* loaded from: classes10.dex */
public class jad_er {
    public final List<com.jd.ad.sdk.jad_qz.jad_cp> jad_an;
    public final com.jd.ad.sdk.jad_js.jad_jt jad_bo;
    public final String jad_cp;
    public final long jad_dq;
    public final int jad_er;
    public final long jad_fs;
    public final List<com.jd.ad.sdk.jad_qz.jad_jt> jad_hu;
    public final jad_ly jad_iv;

    @Nullable
    public final String jad_jt;
    public final int jad_jw;
    public final int jad_kx;
    public final int jad_ly;
    public final float jad_mz;
    public final float jad_na;
    public final int jad_ob;
    public final int jad_pc;

    @Nullable
    public final jad_jw jad_qd;

    @Nullable
    public final jad_kx jad_re;

    @Nullable
    public final com.jd.ad.sdk.jad_py.jad_bo jad_sf;
    public final List<com.jd.ad.sdk.jad_wf.jad_an<Float>> jad_tg;
    public final int jad_uh;
    public final boolean jad_vi;

    @Nullable
    public final com.jd.ad.sdk.jad_qz.jad_an jad_wj;

    @Nullable
    public final com.jd.ad.sdk.jad_tc.jad_jw jad_xk;

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/List<Lcom/jd/ad/sdk/jad_qz/jad_cp;>;Lcom/jd/ad/sdk/jad_js/jad_jt;Ljava/lang/String;JLjava/lang/Object;JLjava/lang/String;Ljava/util/List<Lcom/jd/ad/sdk/jad_qz/jad_jt;>;Lcom/jd/ad/sdk/jad_py/jad_ly;IIIFFIILcom/jd/ad/sdk/jad_py/jad_jw;Lcom/jd/ad/sdk/jad_py/jad_kx;Ljava/util/List<Lcom/jd/ad/sdk/jad_wf/jad_an<Ljava/lang/Float;>;>;Ljava/lang/Object;Lcom/jd/ad/sdk/jad_py/jad_bo;ZLcom/jd/ad/sdk/jad_qz/jad_an;Lcom/jd/ad/sdk/jad_tc/jad_jw;)V */
    public jad_er(List list, com.jd.ad.sdk.jad_js.jad_jt jad_jtVar, String str, long j, int i, long j2, @Nullable String str2, List list2, jad_ly jad_lyVar, int i2, int i3, int i4, float f, float f2, int i5, int i6, @Nullable jad_jw jad_jwVar, @Nullable jad_kx jad_kxVar, List list3, int i7, @Nullable com.jd.ad.sdk.jad_py.jad_bo jad_boVar, boolean z, @Nullable com.jd.ad.sdk.jad_qz.jad_an jad_anVar, @Nullable com.jd.ad.sdk.jad_tc.jad_jw jad_jwVar2) {
        this.jad_an = list;
        this.jad_bo = jad_jtVar;
        this.jad_cp = str;
        this.jad_dq = j;
        this.jad_er = i;
        this.jad_fs = j2;
        this.jad_jt = str2;
        this.jad_hu = list2;
        this.jad_iv = jad_lyVar;
        this.jad_jw = i2;
        this.jad_kx = i3;
        this.jad_ly = i4;
        this.jad_mz = f;
        this.jad_na = f2;
        this.jad_ob = i5;
        this.jad_pc = i6;
        this.jad_qd = jad_jwVar;
        this.jad_re = jad_kxVar;
        this.jad_tg = list3;
        this.jad_uh = i7;
        this.jad_sf = jad_boVar;
        this.jad_vi = z;
        this.jad_wj = jad_anVar;
        this.jad_xk = jad_jwVar2;
    }

    public com.jd.ad.sdk.jad_js.jad_jt jad_an() {
        return this.jad_bo;
    }

    public long jad_bo() {
        return this.jad_dq;
    }

    public List<com.jd.ad.sdk.jad_qz.jad_jt> jad_cp() {
        return this.jad_hu;
    }

    public int jad_dq() {
        return this.jad_uh;
    }

    public String jad_er() {
        return this.jad_cp;
    }

    public long jad_fs() {
        return this.jad_fs;
    }

    public int jad_hu() {
        return this.jad_ly;
    }

    @Nullable
    public jad_jw jad_iv() {
        return this.jad_qd;
    }

    public List<com.jd.ad.sdk.jad_qz.jad_cp> jad_jt() {
        return this.jad_an;
    }

    @Nullable
    public jad_kx jad_jw() {
        return this.jad_re;
    }

    @Nullable
    public com.jd.ad.sdk.jad_py.jad_bo jad_kx() {
        return this.jad_sf;
    }

    public jad_ly jad_ly() {
        return this.jad_iv;
    }

    public String toString() {
        return jad_an("");
    }

    public String jad_an(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(this.jad_cp);
        sb.append("\n");
        jad_er jad_an = this.jad_bo.jad_an(this.jad_fs);
        if (jad_an != null) {
            sb.append("\t\tParents: ");
            sb.append(jad_an.jad_cp);
            com.jd.ad.sdk.jad_js.jad_jt jad_jtVar = this.jad_bo;
            while (true) {
                jad_an = jad_jtVar.jad_an(jad_an.jad_fs);
                if (jad_an == null) {
                    break;
                }
                sb.append("->");
                sb.append(jad_an.jad_cp);
                jad_jtVar = this.jad_bo;
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!this.jad_hu.isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(this.jad_hu.size());
            sb.append("\n");
        }
        if (this.jad_jw != 0 && this.jad_kx != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(this.jad_jw), Integer.valueOf(this.jad_kx), Integer.valueOf(this.jad_ly)));
        }
        if (!this.jad_an.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.jd.ad.sdk.jad_qz.jad_cp jad_cpVar : this.jad_an) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(jad_cpVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
