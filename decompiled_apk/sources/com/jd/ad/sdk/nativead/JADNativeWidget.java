package com.jd.ad.sdk.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.jad_n_an.jad_n_fs;
import com.jd.ad.sdk.jad_n_an.jad_n_jt;
import com.jd.ad.sdk.multi.R;

/* loaded from: classes10.dex */
public class JADNativeWidget {
    private JADNativeWidget() {
    }

    @NonNull
    public static Bitmap getJDLogo(@NonNull Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.jad_logo);
    }

    @NonNull
    public static Bitmap getLogo(@NonNull Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.jad_logo_normal);
    }

    public static View getShakeAnimationView(Context context) {
        return new jad_n_fs(context).getView();
    }

    public static View getSwipeAnimationView(Context context) {
        return new jad_n_jt(context).getView();
    }

    @NonNull
    public static Bitmap getTextLogo(@NonNull Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.jad_logo_no_ic);
    }

    public static View getShakeAnimationView(Context context, String str) {
        return new jad_n_fs(context, str).getView();
    }
}
