package com.jd.ad.sdk.jad_qz;

import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_re implements jad_cp {
    public final String jad_an;

    @Nullable
    public final com.jd.ad.sdk.jad_py.jad_bo jad_bo;
    public final List<com.jd.ad.sdk.jad_py.jad_bo> jad_cp;
    public final com.jd.ad.sdk.jad_py.jad_an jad_dq;
    public final com.jd.ad.sdk.jad_py.jad_dq jad_er;
    public final com.jd.ad.sdk.jad_py.jad_bo jad_fs;
    public final int jad_hu;
    public final float jad_iv;
    public final int jad_jt;
    public final boolean jad_jw;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;
        public static final /* synthetic */ int[] jad_bo;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3).length];
            jad_bo = iArr;
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_bo[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jad_bo[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3).length];
            jad_an = iArr2;
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                jad_an[1] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                jad_an[2] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;Lcom/jd/ad/sdk/jad_py/jad_bo;Ljava/util/List<Lcom/jd/ad/sdk/jad_py/jad_bo;>;Lcom/jd/ad/sdk/jad_py/jad_an;Lcom/jd/ad/sdk/jad_py/jad_dq;Lcom/jd/ad/sdk/jad_py/jad_bo;Ljava/lang/Object;Ljava/lang/Object;FZ)V */
    public jad_re(String str, @Nullable com.jd.ad.sdk.jad_py.jad_bo jad_boVar, List list, com.jd.ad.sdk.jad_py.jad_an jad_anVar, com.jd.ad.sdk.jad_py.jad_dq jad_dqVar, com.jd.ad.sdk.jad_py.jad_bo jad_boVar2, int i, int i2, float f, boolean z) {
        this.jad_an = str;
        this.jad_bo = jad_boVar;
        this.jad_cp = list;
        this.jad_dq = jad_anVar;
        this.jad_er = jad_dqVar;
        this.jad_fs = jad_boVar2;
        this.jad_jt = i;
        this.jad_hu = i2;
        this.jad_iv = f;
        this.jad_jw = z;
    }

    public int jad_an() {
        return this.jad_jt;
    }

    public com.jd.ad.sdk.jad_py.jad_an jad_bo() {
        return this.jad_dq;
    }

    public com.jd.ad.sdk.jad_py.jad_bo jad_cp() {
        return this.jad_bo;
    }

    public int jad_dq() {
        return this.jad_hu;
    }

    public List<com.jd.ad.sdk.jad_py.jad_bo> jad_er() {
        return this.jad_cp;
    }

    public float jad_fs() {
        return this.jad_iv;
    }

    public com.jd.ad.sdk.jad_py.jad_dq jad_hu() {
        return this.jad_er;
    }

    public com.jd.ad.sdk.jad_py.jad_bo jad_iv() {
        return this.jad_fs;
    }

    public String jad_jt() {
        return this.jad_an;
    }

    public boolean jad_jw() {
        return this.jad_jw;
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_cp
    public com.jd.ad.sdk.jad_lu.jad_cp jad_an(com.jd.ad.sdk.jad_js.jad_mz jad_mzVar, com.jd.ad.sdk.jad_ra.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_lu.jad_re(jad_mzVar, jad_anVar, this);
    }
}
