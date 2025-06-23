package com.jd.ad.sdk.jad_vg;

import android.util.Log;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_hs.jad_mz;
import com.jd.ad.sdk.jad_kv.jad_xk;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.IOException;

/* loaded from: classes10.dex */
public class jad_dq implements jad_mz<jad_cp> {
    @Override // com.jd.ad.sdk.jad_hs.jad_mz
    @NonNull
    public com.jd.ad.sdk.jad_hs.jad_cp jad_an(@NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return com.jd.ad.sdk.jad_hs.jad_cp.SOURCE;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_dq
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull Object obj, @NonNull File file, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar) {
        return jad_an((jad_xk) obj, file);
    }

    public boolean jad_an(@NonNull jad_xk jad_xkVar, @NonNull File file) {
        try {
            com.jd.ad.sdk.jad_gp.jad_an.jad_an(((jad_cp) jad_xkVar.get()).jad_an.jad_an.jad_an.jad_er().asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Logger.w("GifEncoder", "Failed to encode GIF drawable data", e);
            return false;
        }
    }
}
