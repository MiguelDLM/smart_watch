package com.baidu.navisdk.module.ar.record;

import android.media.MediaCodec;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private ByteBuffer f6994a;
    private MediaCodec.BufferInfo b;

    public c(boolean z, byte[] bArr, MediaCodec.BufferInfo bufferInfo) {
        this.f6994a = ByteBuffer.wrap(bArr);
        this.b = bufferInfo;
    }

    public MediaCodec.BufferInfo a() {
        return this.b;
    }

    public ByteBuffer b() {
        return this.f6994a;
    }
}
