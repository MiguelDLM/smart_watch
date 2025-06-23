package com.jd.ad.sdk.jad_uf;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_hs.jad_jw;
import com.jd.ad.sdk.jad_hs.jad_ly;
import com.jd.ad.sdk.jad_kv.jad_xk;
import java.io.File;

/* loaded from: classes10.dex */
public class jad_an implements jad_ly<File, File> {
    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@NonNull File file, @NonNull jad_jw jad_jwVar) {
        return true;
    }

    @Override // com.jd.ad.sdk.jad_hs.jad_ly
    public jad_xk<File> jad_an(@NonNull File file, int i, int i2, @NonNull jad_jw jad_jwVar) {
        return new jad_bo(file);
    }
}
