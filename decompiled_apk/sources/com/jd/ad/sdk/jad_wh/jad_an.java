package com.jd.ad.sdk.jad_wh;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_hs.jad_jw;
import com.jd.ad.sdk.jad_kv.jad_xk;
import java.io.ByteArrayOutputStream;

/* loaded from: classes10.dex */
public class jad_an implements jad_er<Bitmap, byte[]> {
    public final Bitmap.CompressFormat jad_an;

    public jad_an() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.jd.ad.sdk.jad_wh.jad_er
    @Nullable
    public jad_xk<byte[]> jad_an(@NonNull jad_xk<Bitmap> jad_xkVar, @NonNull jad_jw jad_jwVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        jad_xkVar.get().compress(this.jad_an, 100, byteArrayOutputStream);
        jad_xkVar.jad_dq();
        return new com.jd.ad.sdk.jad_sd.jad_bo(byteArrayOutputStream.toByteArray());
    }

    public jad_an(@NonNull Bitmap.CompressFormat compressFormat, int i) {
        this.jad_an = compressFormat;
    }
}
