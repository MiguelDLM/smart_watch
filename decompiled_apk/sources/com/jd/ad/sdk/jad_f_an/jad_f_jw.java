package com.jd.ad.sdk.jad_f_an;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes10.dex */
public class jad_f_jw implements OnImageLoadListener {
    public final /* synthetic */ ImageView jad_f_an;
    public final /* synthetic */ AtomicInteger jad_f_bo;
    public final /* synthetic */ int jad_f_cp;
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_an jad_f_dq;

    public jad_f_jw(com.jd.ad.sdk.feed.jad_f_an jad_f_anVar, ImageView imageView, AtomicInteger atomicInteger, int i) {
        this.jad_f_dq = jad_f_anVar;
        this.jad_f_an = imageView;
        this.jad_f_bo = atomicInteger;
        this.jad_f_cp = i;
    }

    @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
    public void onLoadFailed(int i, String str, @Nullable Drawable drawable) {
        int i2 = this.jad_f_bo.get();
        int i3 = this.jad_f_cp;
        if (i2 < i3) {
            this.jad_f_bo.set(i3);
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String str2 = this.jad_f_dq.jad_f_er;
            JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
            eventService.reportRenderFailedEvent(str2, jADError.getCode(), this.jad_f_dq.jad_f_bo(jADError.getMessage(new String[0])), this.jad_f_dq.jad_f_fs);
            this.jad_f_dq.jad_f_an(jADError.getCode(), jADError.getMessage(new String[0]));
        }
    }

    @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
    public void onLoadSuccess(@NonNull Drawable drawable) {
        ImageView imageView = this.jad_f_an;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        if (this.jad_f_bo.incrementAndGet() == this.jad_f_cp) {
            com.jd.ad.sdk.feed.jad_f_an jad_f_anVar = this.jad_f_dq;
            jad_f_anVar.jad_f_an(jad_f_anVar.jad_f_iv);
        }
    }
}
