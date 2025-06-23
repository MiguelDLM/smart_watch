package com.jd.ad.sdk.jad_lw;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes10.dex */
public class jad_cp implements jad_ly {
    public final jad_bo jad_an = new jad_bo();
    public final jad_hu<jad_an, Bitmap> jad_bo = new jad_hu<>();

    @VisibleForTesting
    /* loaded from: classes10.dex */
    public static class jad_an implements jad_mz {
        public final jad_bo jad_an;
        public int jad_bo;
        public int jad_cp;
        public Bitmap.Config jad_dq;

        public jad_an(jad_bo jad_boVar) {
            this.jad_an = jad_boVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof jad_an)) {
                return false;
            }
            jad_an jad_anVar = (jad_an) obj;
            return this.jad_bo == jad_anVar.jad_bo && this.jad_cp == jad_anVar.jad_cp && this.jad_dq == jad_anVar.jad_dq;
        }

        public int hashCode() {
            int i = ((this.jad_bo * 31) + this.jad_cp) * 31;
            Bitmap.Config config = this.jad_dq;
            return i + (config != null ? config.hashCode() : 0);
        }

        @Override // com.jd.ad.sdk.jad_lw.jad_mz
        public void jad_an() {
            jad_bo jad_boVar = this.jad_an;
            if (jad_boVar.jad_an.size() < 20) {
                jad_boVar.jad_an.offer(this);
            }
        }

        public String toString() {
            return jad_cp.jad_cp(this.jad_bo, this.jad_cp, this.jad_dq);
        }
    }

    @VisibleForTesting
    /* loaded from: classes10.dex */
    public static class jad_bo extends jad_dq<jad_an> {
        @Override // com.jd.ad.sdk.jad_lw.jad_dq
        public jad_an jad_an() {
            return new jad_an(this);
        }
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_ly
    public Bitmap jad_an() {
        return this.jad_bo.jad_an();
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_ly
    public String jad_bo(int i, int i2, Bitmap.Config config) {
        return jad_cp(i, i2, config);
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_ly
    public int jad_cp(Bitmap bitmap) {
        return com.jd.ad.sdk.jad_gp.jad_ly.jad_an(bitmap);
    }

    public String toString() {
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("AttributeStrategy:\n  ");
        jad_an2.append(this.jad_bo);
        return jad_an2.toString();
    }

    public static String jad_cp(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_ly
    public Bitmap jad_an(int i, int i2, Bitmap.Config config) {
        jad_an jad_bo2 = this.jad_an.jad_bo();
        jad_bo2.jad_bo = i;
        jad_bo2.jad_cp = i2;
        jad_bo2.jad_dq = config;
        return this.jad_bo.jad_an(jad_bo2);
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_ly
    public String jad_bo(Bitmap bitmap) {
        return jad_cp(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.jd.ad.sdk.jad_lw.jad_ly
    public void jad_an(Bitmap bitmap) {
        jad_bo jad_boVar = this.jad_an;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        jad_an jad_bo2 = jad_boVar.jad_bo();
        jad_bo2.jad_bo = width;
        jad_bo2.jad_cp = height;
        jad_bo2.jad_dq = config;
        this.jad_bo.jad_an(jad_bo2, bitmap);
    }
}
