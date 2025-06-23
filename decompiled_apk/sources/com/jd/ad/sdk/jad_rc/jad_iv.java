package com.jd.ad.sdk.jad_rc;

/* loaded from: classes10.dex */
public abstract class jad_iv {
    public static final jad_iv jad_an = new jad_bo();
    public static final jad_iv jad_bo;
    public static final jad_iv jad_cp;
    public static final com.jd.ad.sdk.jad_hs.jad_iv<jad_iv> jad_dq;
    public static final boolean jad_er;

    /* loaded from: classes10.dex */
    public static class jad_an extends jad_iv {
        @Override // com.jd.ad.sdk.jad_rc.jad_iv
        public int jad_an(int i, int i2, int i3, int i4) {
            return 2;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_iv
        public float jad_bo(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_bo extends jad_iv {
        @Override // com.jd.ad.sdk.jad_rc.jad_iv
        public int jad_an(int i, int i2, int i3, int i4) {
            return jad_iv.jad_er ? 2 : 1;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_iv
        public float jad_bo(int i, int i2, int i3, int i4) {
            if (jad_iv.jad_er) {
                return Math.min(i3 / i, i4 / i2);
            }
            if (Math.max(i2 / i4, i / i3) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_cp extends jad_iv {
        @Override // com.jd.ad.sdk.jad_rc.jad_iv
        public int jad_an(int i, int i2, int i3, int i4) {
            return 2;
        }

        @Override // com.jd.ad.sdk.jad_rc.jad_iv
        public float jad_bo(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    static {
        jad_an jad_anVar = new jad_an();
        jad_bo = new jad_cp();
        jad_cp = jad_anVar;
        jad_dq = com.jd.ad.sdk.jad_hs.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", jad_anVar);
        jad_er = true;
    }

    public abstract int jad_an(int i, int i2, int i3, int i4);

    public abstract float jad_bo(int i, int i2, int i3, int i4);
}
