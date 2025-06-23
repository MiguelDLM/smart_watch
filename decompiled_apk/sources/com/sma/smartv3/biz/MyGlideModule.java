package com.sma.smartv3.biz;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.module.GlideModule;
import com.sma.smartv3.initializer.IXxxXO;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class MyGlideModule implements GlideModule {
    @Override // com.bumptech.glide.module.GlideModule, com.bumptech.glide.module.AppliesOptions
    public void applyOptions(@OXOo.OOXIXo Context context, @OXOo.OOXIXo GlideBuilder builder) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(builder, "builder");
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, IXxxXO.oo(X00IoxXI.oIX0oI.f3233oIX0oI).getName(), 262144000));
    }

    @Override // com.bumptech.glide.module.GlideModule, com.bumptech.glide.module.RegistersComponents
    public void registerComponents(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Glide glide, @OXOo.OOXIXo Registry registry) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(glide, "glide");
        IIX0o.x0xO0oo(registry, "registry");
    }
}
