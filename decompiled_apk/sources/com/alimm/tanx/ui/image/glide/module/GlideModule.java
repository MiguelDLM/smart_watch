package com.alimm.tanx.ui.image.glide.module;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.GlideBuilder;

/* loaded from: classes.dex */
public interface GlideModule {
    void applyOptions(Context context, GlideBuilder glideBuilder);

    void registerComponents(Context context, Glide glide);
}
