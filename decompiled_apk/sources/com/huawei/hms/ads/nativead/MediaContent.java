package com.huawei.hms.ads.nativead;

import android.graphics.drawable.Drawable;
import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: classes10.dex */
public interface MediaContent {
    float getAspectRatio();

    Drawable getImage();

    void setImage(Drawable drawable);
}
