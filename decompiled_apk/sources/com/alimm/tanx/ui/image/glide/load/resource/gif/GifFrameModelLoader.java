package com.alimm.tanx.ui.image.glide.load.resource.gif;

import com.alimm.tanx.ui.image.glide.Priority;
import com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class GifFrameModelLoader implements ModelLoader<GifDecoder, GifDecoder> {

    /* loaded from: classes.dex */
    public static class GifFrameDataFetcher implements DataFetcher<GifDecoder> {
        private final GifDecoder decoder;

        public GifFrameDataFetcher(GifDecoder gifDecoder) {
            this.decoder = gifDecoder;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public String getId() {
            return String.valueOf(this.decoder.getCurrentFrameIndex());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
        public GifDecoder loadData(Priority priority) {
            return this.decoder;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<GifDecoder> getResourceFetcher(GifDecoder gifDecoder, int i, int i2) {
        return new GifFrameDataFetcher(gifDecoder);
    }
}
