package com.alimm.tanx.ui.image.glide.integration.okhttp3;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.GlideBuilder;
import com.alimm.tanx.ui.image.glide.integration.okhttp3.OkHttpUrlLoader;
import com.alimm.tanx.ui.image.glide.load.model.GlideUrl;
import com.alimm.tanx.ui.image.glide.module.GlideModule;
import java.io.InputStream;

/* loaded from: classes.dex */
public class OkHttpGlideModule implements GlideModule {
    @Override // com.alimm.tanx.ui.image.glide.module.GlideModule
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
    }

    @Override // com.alimm.tanx.ui.image.glide.module.GlideModule
    public void registerComponents(Context context, Glide glide) {
        glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory());
    }
}
