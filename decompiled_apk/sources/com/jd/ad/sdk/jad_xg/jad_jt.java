package com.jd.ad.sdk.jad_xg;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;
import com.jd.ad.sdk.jad_kv.jad_ly;
import com.jd.ad.sdk.jad_kv.jad_sf;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADFoundationService;

/* loaded from: classes10.dex */
public class jad_jt implements JADFoundationService {
    @Override // com.jd.ad.sdk.mdt.service.JADFoundationService
    @Nullable
    public Application getApplication() {
        return com.jd.ad.sdk.jad_do.jad_bo.jad_an();
    }

    @Override // com.jd.ad.sdk.mdt.service.JADFoundationService
    public boolean isNetAvailable() {
        Application jad_an2 = com.jd.ad.sdk.jad_do.jad_bo.jad_an();
        if (jad_an2 != null && com.jd.ad.sdk.jad_ob.jad_jt.jad_an(jad_an2) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADFoundationService
    public void loadImage(@Nullable Context context, @Nullable String str, @Nullable OnImageLoadListener onImageLoadListener) {
        if (com.jd.ad.sdk.jad_do.jad_cp.jad_an(context) && !TextUtils.isEmpty(str) && onImageLoadListener != null) {
            com.jd.ad.sdk.jad_ep.jad_cp.jad_bo(context).jad_an(str).jad_an(jad_ly.jad_cp).jad_bo(new jad_bo(this)).jad_an((com.jd.ad.sdk.jad_ep.jad_iv) new jad_an(this, onImageLoadListener));
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADFoundationService
    public void preloadImage(@Nullable Context context, @Nullable String str, @Nullable OnImageLoadListener onImageLoadListener) {
        if (!com.jd.ad.sdk.jad_do.jad_cp.jad_an(context) || TextUtils.isEmpty(str)) {
            return;
        }
        com.jd.ad.sdk.jad_ep.jad_cp.jad_bo(context).jad_an(str).jad_an(jad_ly.jad_bo).jad_bo(new jad_cp(this, onImageLoadListener)).jad_dq();
    }

    /* loaded from: classes10.dex */
    public class jad_bo implements com.jd.ad.sdk.jad_al.jad_jt<Drawable> {
        public jad_bo(jad_jt jad_jtVar) {
        }

        @Override // com.jd.ad.sdk.jad_al.jad_jt
        public boolean jad_an(Drawable drawable, Object obj, com.jd.ad.sdk.jad_bm.jad_er<Drawable> jad_erVar, com.jd.ad.sdk.jad_hs.jad_an jad_anVar, boolean z) {
            Logger.d("preload 加载图片 成功");
            return false;
        }

        @Override // com.jd.ad.sdk.jad_al.jad_jt
        public boolean jad_an(@Nullable jad_sf jad_sfVar, Object obj, com.jd.ad.sdk.jad_bm.jad_er<Drawable> jad_erVar, boolean z) {
            Logger.d("preload 加载图片 失败");
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public class jad_cp implements com.jd.ad.sdk.jad_al.jad_jt<Drawable> {
        public final /* synthetic */ OnImageLoadListener jad_an;

        public jad_cp(jad_jt jad_jtVar, OnImageLoadListener onImageLoadListener) {
            this.jad_an = onImageLoadListener;
        }

        @Override // com.jd.ad.sdk.jad_al.jad_jt
        public boolean jad_an(Drawable drawable, Object obj, com.jd.ad.sdk.jad_bm.jad_er<Drawable> jad_erVar, com.jd.ad.sdk.jad_hs.jad_an jad_anVar, boolean z) {
            this.jad_an.onLoadSuccess(null);
            return false;
        }

        @Override // com.jd.ad.sdk.jad_al.jad_jt
        public boolean jad_an(@Nullable jad_sf jad_sfVar, Object obj, com.jd.ad.sdk.jad_bm.jad_er<Drawable> jad_erVar, boolean z) {
            this.jad_an.onLoadFailed(-1, "load error", null);
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public class jad_an extends com.jd.ad.sdk.jad_bm.jad_an<Drawable> {
        public final /* synthetic */ OnImageLoadListener jad_dq;

        public jad_an(jad_jt jad_jtVar, OnImageLoadListener onImageLoadListener) {
            this.jad_dq = onImageLoadListener;
        }

        @Override // com.jd.ad.sdk.jad_bm.jad_er
        public void jad_an(@NonNull Object obj, @Nullable com.jd.ad.sdk.jad_en.jad_bo jad_boVar) {
            Drawable drawable = (Drawable) obj;
            Logger.d("preload 加载图片 onResourceReady");
            OnImageLoadListener onImageLoadListener = this.jad_dq;
            if (onImageLoadListener != null) {
                onImageLoadListener.onLoadSuccess(drawable);
            }
        }

        @Override // com.jd.ad.sdk.jad_bm.jad_an, com.jd.ad.sdk.jad_bm.jad_er
        public void jad_cp(@Nullable Drawable drawable) {
            Logger.d("preload 加载图片 onLoadFailed");
            OnImageLoadListener onImageLoadListener = this.jad_dq;
            if (onImageLoadListener != null) {
                onImageLoadListener.onLoadFailed(-1, "load error", drawable);
            }
        }

        @Override // com.jd.ad.sdk.jad_bm.jad_er
        public void jad_an(@Nullable Drawable drawable) {
            Logger.d("preload 加载图片 onLoadCleared");
        }
    }
}
