package com.alimm.tanx.ui.image.glide.load.resource.transcode;

import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.resource.bytes.BytesResource;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable;

/* loaded from: classes.dex */
public class GifDrawableBytesTranscoder implements ResourceTranscoder<GifDrawable, byte[]> {
    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public String getId() {
        return "GifDrawableBytesTranscoder.com.alimm.tanx.ui.image.glide.load.resource.transcode";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public Resource<byte[]> transcode(Resource<GifDrawable> resource) {
        return new BytesResource(resource.get().getData());
    }
}
