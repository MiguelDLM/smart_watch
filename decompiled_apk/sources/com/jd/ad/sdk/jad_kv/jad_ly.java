package com.jd.ad.sdk.jad_kv;

/* loaded from: classes10.dex */
public abstract class jad_ly {
    public static final jad_ly jad_an = new jad_an();
    public static final jad_ly jad_bo = new jad_bo();
    public static final jad_ly jad_cp = new jad_cp();

    /* loaded from: classes10.dex */
    public class jad_an extends jad_ly {
        @Override // com.jd.ad.sdk.jad_kv.jad_ly
        public boolean jad_an() {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_ly
        public boolean jad_bo() {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_ly
        public boolean jad_an(com.jd.ad.sdk.jad_hs.jad_an jad_anVar) {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_ly
        public boolean jad_an(boolean z, com.jd.ad.sdk.jad_hs.jad_an jad_anVar, com.jd.ad.sdk.jad_hs.jad_cp jad_cpVar) {
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public class jad_bo extends jad_ly {
        @Override // com.jd.ad.sdk.jad_kv.jad_ly
        public boolean jad_an() {
            return true;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_ly
        public boolean jad_bo() {
            return false;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_ly
        public boolean jad_an(com.jd.ad.sdk.jad_hs.jad_an jad_anVar) {
            return (jad_anVar == com.jd.ad.sdk.jad_hs.jad_an.DATA_DISK_CACHE || jad_anVar == com.jd.ad.sdk.jad_hs.jad_an.MEMORY_CACHE) ? false : true;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_ly
        public boolean jad_an(boolean z, com.jd.ad.sdk.jad_hs.jad_an jad_anVar, com.jd.ad.sdk.jad_hs.jad_cp jad_cpVar) {
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public class jad_cp extends jad_ly {
        @Override // com.jd.ad.sdk.jad_kv.jad_ly
        public boolean jad_an() {
            return true;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_ly
        public boolean jad_bo() {
            return true;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_ly
        public boolean jad_an(com.jd.ad.sdk.jad_hs.jad_an jad_anVar) {
            return jad_anVar == com.jd.ad.sdk.jad_hs.jad_an.REMOTE;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_ly
        public boolean jad_an(boolean z, com.jd.ad.sdk.jad_hs.jad_an jad_anVar, com.jd.ad.sdk.jad_hs.jad_cp jad_cpVar) {
            return ((z && jad_anVar == com.jd.ad.sdk.jad_hs.jad_an.DATA_DISK_CACHE) || jad_anVar == com.jd.ad.sdk.jad_hs.jad_an.LOCAL) && jad_cpVar == com.jd.ad.sdk.jad_hs.jad_cp.TRANSFORMED;
        }
    }

    public abstract boolean jad_an();

    public abstract boolean jad_an(com.jd.ad.sdk.jad_hs.jad_an jad_anVar);

    public abstract boolean jad_an(boolean z, com.jd.ad.sdk.jad_hs.jad_an jad_anVar, com.jd.ad.sdk.jad_hs.jad_cp jad_cpVar);

    public abstract boolean jad_bo();
}
