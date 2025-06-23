package com.jd.ad.sdk.jad_rc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* loaded from: classes10.dex */
public final class jad_wj implements com.jd.ad.sdk.jad_hs.jad_ly<Bitmap, Bitmap> {

    /* loaded from: classes10.dex */
    public static final class jad_an implements com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> {
        public final Bitmap jad_an;

        public jad_an(@NonNull Bitmap bitmap) {
            this.jad_an = bitmap;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_xk
        @NonNull
        public Bitmap get() {
            return this.jad_an;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_xk
        public int jad_bo() {
            return com.jd.ad.sdk.jad_gp.jad_ly.jad_an(this.jad_an);
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_xk
        @NonNull
        public Class<Bitmap> jad_cp() {
            return Bitmap.class;
        }

        @Override // com.jd.ad.sdk.jad_kv.jad_xk
        public void jad_dq() {
        }
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull Bitmap bitmap, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_an(@NonNull Bitmap bitmap, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return new jad_an(bitmap);
    }
}
