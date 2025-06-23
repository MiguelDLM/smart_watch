package com.jd.ad.sdk.jad_f_an;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_f_fs implements View.OnAttachStateChangeListener {
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_an jad_f_an;

    public jad_f_fs(com.jd.ad.sdk.feed.jad_f_an jad_f_anVar) {
        this.jad_f_an = jad_f_anVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        com.jd.ad.sdk.feed.jad_f_an jad_f_anVar = this.jad_f_an;
        if (jad_f_anVar.jad_f_iv != null) {
            if (jad_f_anVar.jad_f_dq()) {
                List<String> list = jad_f_anVar.jad_f_cp;
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        JADMediator.getInstance().getFoundationService().loadImage(jad_f_anVar.jad_f_bo(), list.get(i), new jad_f_jt(jad_f_anVar, jad_f_anVar.jad_f_an("jad_feed_image" + i)));
                    }
                    return;
                }
                return;
            }
            String jad_f_cp = jad_f_anVar.jad_f_cp();
            if (!TextUtils.isEmpty(jad_f_cp)) {
                JADMediator.getInstance().getFoundationService().loadImage(jad_f_anVar.jad_f_bo(), jad_f_cp, new jad_f_hu(jad_f_anVar, jad_f_anVar.jad_f_an("jad_feed_image")));
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        com.jd.ad.sdk.feed.jad_f_an jad_f_anVar = this.jad_f_an;
        if (jad_f_anVar.jad_f_iv != null) {
            if (jad_f_anVar.jad_f_dq()) {
                List<String> list = jad_f_anVar.jad_f_cp;
                if (list != null && !list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        ImageView jad_f_an = jad_f_anVar.jad_f_an("jad_feed_image" + i);
                        if (jad_f_an != null) {
                            jad_f_an.setImageBitmap(null);
                        }
                    }
                    return;
                }
                return;
            }
            ImageView jad_f_an2 = jad_f_anVar.jad_f_an("jad_feed_image");
            if (jad_f_an2 != null) {
                jad_f_an2.setImageBitmap(null);
            }
        }
    }
}
