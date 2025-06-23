package com.jd.ad.sdk.jad_i_an;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;
import com.jd.ad.sdk.interstitial.jad_i_an;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;

/* loaded from: classes10.dex */
public class jad_i_dq implements OnImageLoadListener {
    public final /* synthetic */ com.jd.ad.sdk.interstitial.jad_i_an jad_i_an;

    public jad_i_dq(com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar) {
        this.jad_i_an = jad_i_anVar;
    }

    @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
    public void onLoadFailed(int i, String str, @Nullable Drawable drawable) {
        JADEventService eventService = JADMediator.getInstance().getEventService();
        String str2 = this.jad_i_an.jad_i_er;
        JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
        eventService.reportRenderFailedEvent(str2, jADError.getCode(), this.jad_i_an.jad_i_an(jADError.getMessage(new String[0])), this.jad_i_an.jad_i_fs);
        this.jad_i_an.jad_i_an(jADError.getCode(), jADError.getMessage(new String[0]));
    }

    @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
    public void onLoadSuccess(@NonNull Drawable drawable) {
        ImageView imageView = this.jad_i_an.jad_i_mz;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar = this.jad_i_an;
        View view = jad_i_anVar.jad_i_jt;
        jad_i_an.jad_i_cp jad_i_cpVar = jad_i_anVar.jad_i_hu;
        if (jad_i_cpVar != null) {
            jad_i_cpVar.onAdRenderSuccess(view);
        }
    }
}
