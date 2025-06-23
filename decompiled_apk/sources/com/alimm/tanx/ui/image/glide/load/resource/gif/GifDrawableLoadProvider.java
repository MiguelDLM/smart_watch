package com.alimm.tanx.ui.image.glide.load.resource.gif;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.model.StreamEncoder;
import com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder;
import com.alimm.tanx.ui.image.glide.provider.DataLoadProvider;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class GifDrawableLoadProvider implements DataLoadProvider<InputStream, GifDrawable> {
    private final FileToStreamDecoder<GifDrawable> cacheDecoder;
    private final GifResourceDecoder decoder;
    private final GifResourceEncoder encoder;
    private final StreamEncoder sourceEncoder;

    public GifDrawableLoadProvider(Context context, BitmapPool bitmapPool) {
        GifResourceDecoder gifResourceDecoder = new GifResourceDecoder(context, bitmapPool);
        this.decoder = gifResourceDecoder;
        this.cacheDecoder = new FileToStreamDecoder<>(gifResourceDecoder);
        this.encoder = new GifResourceEncoder(bitmapPool);
        this.sourceEncoder = new StreamEncoder();
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceDecoder<File, GifDrawable> getCacheDecoder() {
        return this.cacheDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceEncoder<GifDrawable> getEncoder() {
        return this.encoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public ResourceDecoder<InputStream, GifDrawable> getSourceDecoder() {
        return this.decoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public Encoder<InputStream> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
