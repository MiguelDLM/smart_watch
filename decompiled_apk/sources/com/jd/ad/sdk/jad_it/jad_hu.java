package com.jd.ad.sdk.jad_it;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import androidx.annotation.NonNull;

/* loaded from: classes10.dex */
public class jad_hu extends jad_bo<AssetFileDescriptor> {
    public jad_hu(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.jd.ad.sdk.jad_it.jad_dq
    @NonNull
    public Class<AssetFileDescriptor> jad_an() {
        return AssetFileDescriptor.class;
    }

    @Override // com.jd.ad.sdk.jad_it.jad_bo
    public void jad_an(AssetFileDescriptor assetFileDescriptor) {
        assetFileDescriptor.close();
    }

    @Override // com.jd.ad.sdk.jad_it.jad_bo
    public AssetFileDescriptor jad_an(AssetManager assetManager, String str) {
        return assetManager.openFd(str);
    }
}
