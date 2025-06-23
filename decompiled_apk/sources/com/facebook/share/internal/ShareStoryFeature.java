package com.facebook.share.internal;

import OXOo.OOXIXo;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.NativeProtocol;
import java.util.Arrays;

/* loaded from: classes8.dex */
public enum ShareStoryFeature implements DialogFeature {
    SHARE_STORY_ASSET(NativeProtocol.PROTOCOL_VERSION_20170417);

    private final int minVersion;

    ShareStoryFeature(int i) {
        this.minVersion = i;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static ShareStoryFeature[] valuesCustom() {
        ShareStoryFeature[] valuesCustom = values();
        return (ShareStoryFeature[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    @Override // com.facebook.internal.DialogFeature
    @OOXIXo
    public String getAction() {
        return NativeProtocol.ACTION_SHARE_STORY;
    }

    @Override // com.facebook.internal.DialogFeature
    public int getMinVersion() {
        return this.minVersion;
    }
}
