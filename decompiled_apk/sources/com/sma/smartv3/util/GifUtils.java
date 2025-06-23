package com.sma.smartv3.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.sma.smartv3.util.GifUtils;

/* loaded from: classes12.dex */
public final class GifUtils {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final GifUtils f24207oIX0oI = new GifUtils();

    /* loaded from: classes12.dex */
    public interface oIX0oI {
        void oIX0oI();
    }

    public final void oIX0oI(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Object model, final int i, @OXOo.OOXIXo ImageView imageView, @OXOo.OOXIXo final oIX0oI listener) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        kotlin.jvm.internal.IIX0o.x0xO0oo(model, "model");
        kotlin.jvm.internal.IIX0o.x0xO0oo(imageView, "imageView");
        kotlin.jvm.internal.IIX0o.x0xO0oo(listener, "listener");
        Glide.with(context).asGif().load(model).diskCacheStrategy(DiskCacheStrategy.DATA).listener(new RequestListener<GifDrawable>() { // from class: com.sma.smartv3.util.GifUtils$play$1
            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(@OXOo.OOXIXo GifDrawable resource, @OXOo.OOXIXo Object model2, @OXOo.oOoXoXO Target<GifDrawable> target, @OXOo.OOXIXo DataSource dataSource, boolean z) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(resource, "resource");
                kotlin.jvm.internal.IIX0o.x0xO0oo(model2, "model");
                kotlin.jvm.internal.IIX0o.x0xO0oo(dataSource, "dataSource");
                int i2 = i;
                if (i2 > 0) {
                    try {
                        resource.setLoopCount(i2);
                        final GifUtils.oIX0oI oix0oi = listener;
                        resource.registerAnimationCallback(new Animatable2Compat.AnimationCallback() { // from class: com.sma.smartv3.util.GifUtils$play$1$onResourceReady$1
                            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
                            public void onAnimationEnd(@OXOo.oOoXoXO Drawable drawable) {
                                GifUtils.oIX0oI.this.oIX0oI();
                            }
                        });
                        return false;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(@OXOo.oOoXoXO GlideException glideException, @OXOo.oOoXoXO Object obj, @OXOo.OOXIXo Target<GifDrawable> target, boolean z) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(target, "target");
                return false;
            }
        }).into(imageView);
    }
}
