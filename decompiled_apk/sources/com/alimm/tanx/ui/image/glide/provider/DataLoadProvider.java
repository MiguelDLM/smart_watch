package com.alimm.tanx.ui.image.glide.provider;

import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import java.io.File;

/* loaded from: classes.dex */
public interface DataLoadProvider<T, Z> {
    ResourceDecoder<File, Z> getCacheDecoder();

    ResourceEncoder<Z> getEncoder();

    ResourceDecoder<T, Z> getSourceDecoder();

    Encoder<T> getSourceEncoder();
}
