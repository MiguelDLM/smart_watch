package com.jd.ad.sdk.jad_js;

import android.content.Context;
import com.jd.ad.sdk.lottie.LottieAnimationView;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes10.dex */
public class jad_fs implements Callable<jad_sf<jad_jt>> {
    public final /* synthetic */ String jad_an;
    public final /* synthetic */ LottieAnimationView jad_bo;

    public jad_fs(LottieAnimationView lottieAnimationView, String str) {
        this.jad_bo = lottieAnimationView;
        this.jad_an = str;
    }

    @Override // java.util.concurrent.Callable
    public jad_sf<jad_jt> call() {
        LottieAnimationView lottieAnimationView = this.jad_bo;
        if (lottieAnimationView.jad_na) {
            Context context = lottieAnimationView.getContext();
            String str = this.jad_an;
            Map<String, jad_uh<jad_jt>> map = jad_hu.jad_an;
            return jad_hu.jad_an(context, str, "asset_" + str);
        }
        return jad_hu.jad_an(lottieAnimationView.getContext(), this.jad_an, (String) null);
    }
}
