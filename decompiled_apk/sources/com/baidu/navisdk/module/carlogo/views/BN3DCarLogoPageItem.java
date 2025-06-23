package com.baidu.navisdk.module.carlogo.views;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.imageloader.config.ImageConfig;
import com.baidu.navisdk.imageloader.config.ImageDiskCacheStrategy;
import com.baidu.navisdk.imageloader.target.ImageLoaderCustomTarget;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.ui.widget.BNRoundProgress;
import com.baidu.navisdk.util.common.LogUtil;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.util.Locale;

/* loaded from: classes7.dex */
public final class BN3DCarLogoPageItem extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f7082a;
    private BNRoundProgress b;
    private String c;

    /* loaded from: classes7.dex */
    public class a extends ImageLoaderCustomTarget<Drawable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7083a;

        public a(boolean z) {
            this.f7083a = z;
        }

        @Override // com.baidu.navisdk.imageloader.target.ImageLoaderCustomTarget
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onImageLoaderResourceReady(Drawable drawable) {
            if (BN3DCarLogoPageItem.this.f7082a == null) {
                return;
            }
            String str = (String) BN3DCarLogoPageItem.this.f7082a.getTag(R.id.view_tag_first);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoPageItem", "onResourceReady url: " + str + ", mGifUrl:" + BN3DCarLogoPageItem.this.c);
            }
            if (!BN3DCarLogoPageItem.this.c.equals(str)) {
                return;
            }
            if (drawable instanceof GifDrawable) {
                if (this.f7083a) {
                    BN3DCarLogoPageItem.this.f7082a.setImageDrawable(drawable);
                    GifDrawable gifDrawable = (GifDrawable) drawable;
                    gifDrawable.setLoopCount(1);
                    gifDrawable.start();
                    return;
                }
                BN3DCarLogoPageItem.this.f7082a.setImageBitmap(((GifDrawable) drawable).getFirstFrame());
                return;
            }
            BN3DCarLogoPageItem.this.f7082a.setImageDrawable(drawable);
        }
    }

    public BN3DCarLogoPageItem(@NonNull Context context) {
        super(context);
    }

    public void c() {
        Object obj;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPageItem", "startPlayGif: ");
        }
        ImageView imageView = this.f7082a;
        if (imageView != null) {
            obj = imageView.getDrawable();
        } else {
            obj = null;
        }
        if (obj instanceof Animatable) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoPageItem", "startPlayGif: drawable is glidedrawable");
            }
            Animatable animatable = (Animatable) obj;
            if (!animatable.isRunning()) {
                animatable.start();
                return;
            }
            return;
        }
        a(this.c, false, true);
    }

    public void d() {
        Drawable drawable;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPageItem", "stopPlayGif: ");
        }
        ImageView imageView = this.f7082a;
        if (imageView != null) {
            drawable = imageView.getDrawable();
        } else {
            drawable = null;
        }
        if (drawable instanceof GifDrawable) {
            GifDrawable gifDrawable = (GifDrawable) drawable;
            if (gifDrawable.isRunning()) {
                gifDrawable.stop();
                ImageView imageView2 = this.f7082a;
                if (imageView2 != null) {
                    imageView2.setImageBitmap(gifDrawable.getFirstFrame());
                }
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f7082a = (ImageView) findViewById(R.id.three_d_car_logo_item_img);
        this.b = (BNRoundProgress) findViewById(R.id.three_d_car_logo_item_progress);
    }

    public BN3DCarLogoPageItem(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(String str, boolean z, boolean z2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPageItem", "setGif: " + str + ",isNeedPlaceHolder: " + z + ", isAutoPlay:" + z2);
        }
        this.c = str;
        if (this.f7082a != null) {
            if (TextUtils.isEmpty(str)) {
                j.b(this.f7082a);
                return;
            }
            this.f7082a.setTag(R.id.view_tag_first, str);
            ImageConfig.ConfigBuilder diskCacheStrategy = ImageLoader.with(getContext()).load(str).diskCacheStrategy(ImageDiskCacheStrategy.SOURCE);
            if (z) {
                this.f7082a.setImageResource(R.drawable.nsdk_icon_default_pic);
            }
            diskCacheStrategy.setMemoryCache(false).into(new a(z2));
        }
    }

    public void b() {
        BNRoundProgress bNRoundProgress = this.b;
        if (bNRoundProgress != null) {
            bNRoundProgress.onDestroy();
            this.b = null;
        }
        ImageView imageView = this.f7082a;
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof GifDrawable) {
                ((GifDrawable) drawable).recycle();
            }
            j.a(this.f7082a);
            this.f7082a = null;
        }
    }

    public BN3DCarLogoPageItem(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(String str, boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPageItem", "init gifName: " + str);
        }
        a(str, true, z);
    }

    public void a(String str) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPageItem", "changeGif: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, false, false);
    }

    public void a(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPageItem", "updateProgress: " + i);
        }
        BNRoundProgress bNRoundProgress = this.b;
        if (bNRoundProgress != null) {
            bNRoundProgress.setProgressAndText(i, String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i)));
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
            }
        }
    }

    public void a() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPageItem", "hideProgress: ");
        }
        BNRoundProgress bNRoundProgress = this.b;
        if (bNRoundProgress != null) {
            bNRoundProgress.setVisibility(8);
        }
    }
}
