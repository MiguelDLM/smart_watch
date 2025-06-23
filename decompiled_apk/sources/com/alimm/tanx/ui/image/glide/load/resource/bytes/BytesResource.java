package com.alimm.tanx.ui.image.glide.load.resource.bytes;

import com.alimm.tanx.ui.image.glide.load.engine.Resource;

/* loaded from: classes.dex */
public class BytesResource implements Resource<byte[]> {
    private final byte[] bytes;

    public BytesResource(byte[] bArr) {
        if (bArr != null) {
            this.bytes = bArr;
            return;
        }
        throw new NullPointerException("Bytes must not be null");
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return this.bytes.length;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public byte[] get() {
        return this.bytes;
    }
}
