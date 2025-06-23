package com.jd.ad.sdk.jad_rc;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.resource.bitmap.oIX0oI;
import com.jd.ad.sdk.logger.Logger;

@RequiresApi(api = 28)
/* loaded from: classes10.dex */
public final class jad_dq implements com.jd.ad.sdk.jad_hs.jad_ly<ImageDecoder.Source, Bitmap> {
    public final com.jd.ad.sdk.jad_lw.jad_er jad_an = new com.jd.ad.sdk.jad_lw.jad_fs();

    /* renamed from: jad_an, reason: avoid collision after fix types in other method */
    public com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_an2(@NonNull ImageDecoder.Source source, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        Bitmap decodeBitmap;
        decodeBitmap = ImageDecoder.decodeBitmap(source, new com.jd.ad.sdk.jad_qb.jad_an(i, i2, jad_jwVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Decoded [");
            jad_an.append(decodeBitmap.getWidth());
            jad_an.append("x");
            jad_an.append(decodeBitmap.getHeight());
            jad_an.append("] for [");
            jad_an.append(i);
            jad_an.append("x");
            jad_an.append(i2);
            jad_an.append("]");
            Logger.v("BitmapImageDecoder", jad_an.toString());
        }
        return new jad_er(decodeBitmap, this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public /* bridge */ /* synthetic */ com.jd.ad.sdk.jad_kv.jad_xk<Bitmap> jad_an(@NonNull ImageDecoder.Source source, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return jad_an2(oIX0oI.oIX0oI(source), i, i2, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull ImageDecoder.Source source, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        oIX0oI.oIX0oI(source);
        return true;
    }
}
