package com.huawei.hms.ads;

import android.net.Uri;
import com.huawei.hms.ads.annotation.GlobalApi;

@GlobalApi
/* loaded from: classes10.dex */
public abstract class Video {
    @GlobalApi
    public abstract float getAspectRatio();

    @GlobalApi
    public abstract int getDuration();

    @GlobalApi
    public abstract Uri getUri();
}
