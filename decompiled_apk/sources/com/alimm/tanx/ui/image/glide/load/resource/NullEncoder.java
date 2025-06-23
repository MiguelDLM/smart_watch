package com.alimm.tanx.ui.image.glide.load.resource;

import com.alimm.tanx.ui.image.glide.load.Encoder;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class NullEncoder<T> implements Encoder<T> {
    private static final NullEncoder<?> NULL_ENCODER = new NullEncoder<>();

    public static <T> Encoder<T> get() {
        return NULL_ENCODER;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(T t, OutputStream outputStream) {
        return false;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public String getId() {
        return "";
    }
}
