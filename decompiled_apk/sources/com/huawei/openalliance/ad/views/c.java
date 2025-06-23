package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.huawei.hms.ads.fb;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.utils.w;
import com.huawei.openalliance.ad.views.a;

/* loaded from: classes10.dex */
public class c extends a {
    public c(Context context) {
        super(context);
        this.V.Code(context.getResources().getDrawable(R.drawable.hiad_app_down_btn_normal_hm));
        a.C0672a c0672a = this.V;
        Resources resources = context.getResources();
        int i = R.color.hiad_down_btn_white;
        c0672a.Code(resources.getColor(i));
        LayerDrawable layerDrawable = (LayerDrawable) Code(context, R.drawable.hiad_app_down_btn_processing_hm);
        Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.progress);
        if (findDrawableByLayerId instanceof ClipDrawable) {
            h hVar = new h(findDrawableByLayerId, 17, 1);
            layerDrawable.mutate();
            layerDrawable.setDrawableByLayerId(android.R.id.progress, hVar);
            this.I.Code(layerDrawable);
        } else {
            fb.I("ExtandAppDownloadButtonStyleHm", "not clipDrawable");
            this.I.Code(Code(context, R.drawable.hiad_app_down_btn_processing));
        }
        this.I.Code(context.getResources().getColor(R.color.hiad_emui_black));
        LayerDrawable layerDrawable2 = (LayerDrawable) Code(context, R.drawable.hiad_app_down_btn_installing_hm);
        if (layerDrawable2.findDrawableByLayerId(android.R.id.progress) instanceof ClipDrawable) {
            f fVar = new f(w.V(context, 18.0f));
            layerDrawable2.mutate();
            layerDrawable2.setDrawableByLayerId(android.R.id.progress, fVar);
            this.Z.Code(layerDrawable2);
            fVar.Code();
        } else {
            fb.I("ExtandAppDownloadButtonStyleHm", "not clipDrawable");
            this.Z.Code(Code(context, R.drawable.hiad_app_down_btn_installing));
        }
        this.Z.Code(context.getResources().getColor(i));
    }
}
