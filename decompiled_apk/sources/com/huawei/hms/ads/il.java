package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.widget.ImageView;
import com.huawei.hms.ads.kf;
import java.util.List;

/* loaded from: classes10.dex */
public interface il<V extends kf> {
    void Code(Context context, ImageView imageView, Drawable drawable);

    void Code(Location location);

    void Code(RequestOptions requestOptions);

    void Code(com.huawei.openalliance.ad.inter.data.l lVar);

    void Code(com.huawei.openalliance.ad.inter.data.r rVar);

    void Code(Integer num);

    void Code(String str, int i, List<String> list, int i2);

    void Code(String str, com.huawei.openalliance.ad.inter.data.g gVar, long j);

    boolean Code(com.huawei.openalliance.ad.inter.data.b bVar, float f);

    void I(Integer num);

    boolean S();

    void V(Integer num);

    void V(String str);
}
