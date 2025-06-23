package com.jd.ad.sdk.jad_nw;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_ox.jad_iv;
import com.jd.ad.sdk.jad_ve.jad_dq;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class jad_an {
    public final AssetManager jad_dq;

    @Nullable
    public com.jd.ad.sdk.jad_js.jad_an jad_er;
    public final jad_iv<String> jad_an = new jad_iv<>();
    public final Map<jad_iv<String>, Typeface> jad_bo = new HashMap();
    public final Map<String, Typeface> jad_cp = new HashMap();
    public String jad_fs = ".ttf";

    public jad_an(Drawable.Callback callback, @Nullable com.jd.ad.sdk.jad_js.jad_an jad_anVar) {
        AssetManager assets;
        this.jad_er = jad_anVar;
        if (callback instanceof View) {
            assets = ((View) callback).getContext().getAssets();
        } else {
            jad_dq.jad_an("LottieDrawable must be inside of a view for images to work.");
            assets = null;
        }
        this.jad_dq = assets;
    }
}
