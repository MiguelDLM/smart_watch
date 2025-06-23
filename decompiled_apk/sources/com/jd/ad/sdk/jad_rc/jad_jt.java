package com.jd.ad.sdk.jad_rc;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

@RequiresApi(api = 28)
/* loaded from: classes10.dex */
public final class jad_jt implements com.jd.ad.sdk.jad_hs.jad_ly<ByteBuffer, Bitmap> {
    public final jad_dq jad_an = new jad_dq();

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull ByteBuffer byteBuffer, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_an(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        ImageDecoder.Source createSource;
        createSource = ImageDecoder.createSource(byteBuffer);
        return this.jad_an.jad_an2(createSource, i, i2, jad_jwVar);
    }
}
