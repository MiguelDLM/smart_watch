package com.jd.ad.sdk.jad_it;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.InputStream;

/* loaded from: classes10.dex */
public class jad_na extends jad_bo<InputStream> {
    public jad_na(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq
    @NonNull
    public Class<InputStream> jad_an() {
        return InputStream.class;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_bo
    public void jad_an(InputStream inputStream) {
        inputStream.close();
    }

    @Override // com.jd.ad.sdk.jad_it.jad_bo
    public InputStream jad_an(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
