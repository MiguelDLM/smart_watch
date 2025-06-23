package com.jd.ad.sdk.jad_nw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.jd.ad.sdk.jad_js.jad_na;
import com.jd.ad.sdk.jad_ve.jad_dq;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public class jad_bo {
    public static final Object jad_er = new Object();
    public final Context jad_an;
    public final String jad_bo;

    @Nullable
    public com.jd.ad.sdk.jad_js.jad_bo jad_cp;
    public final Map<String, jad_na> jad_dq;

    public jad_bo(Drawable.Callback callback, String str, com.jd.ad.sdk.jad_js.jad_bo jad_boVar, Map<String, jad_na> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            str = str + IOUtils.DIR_SEPARATOR_UNIX;
        }
        this.jad_bo = str;
        if (callback instanceof View) {
            this.jad_an = ((View) callback).getContext();
            this.jad_dq = map;
            jad_an(jad_boVar);
        } else {
            jad_dq.jad_an("LottieDrawable must be inside of a view for images to work.");
            this.jad_dq = new HashMap();
            this.jad_an = null;
        }
    }

    public void jad_an(@Nullable com.jd.ad.sdk.jad_js.jad_bo jad_boVar) {
        this.jad_cp = jad_boVar;
    }

    public final Bitmap jad_an(String str, @Nullable Bitmap bitmap) {
        synchronized (jad_er) {
            this.jad_dq.get(str).jad_er = bitmap;
        }
        return bitmap;
    }
}
