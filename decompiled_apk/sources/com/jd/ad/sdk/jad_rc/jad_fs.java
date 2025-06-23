package com.jd.ad.sdk.jad_rc;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_rc.jad_ob;
import java.nio.ByteBuffer;

/* loaded from: classes10.dex */
public class jad_fs implements com.jd.ad.sdk.jad_hs.jad_ly<ByteBuffer, Bitmap> {
    public final jad_jw jad_an;

    public jad_fs(jad_jw jad_jwVar) {
        this.jad_an = jad_jwVar;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_an(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        jad_jw jad_jwVar2 = this.jad_an;
        return jad_jwVar2.jad_an(new jad_ob.jad_an(byteBuffer, jad_jwVar2.jad_dq, jad_jwVar2.jad_cp), i, i2, jad_jwVar, jad_jw.jad_kx);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public boolean jad_an(@NonNull ByteBuffer byteBuffer, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        this.jad_an.getClass();
        return true;
    }
}
