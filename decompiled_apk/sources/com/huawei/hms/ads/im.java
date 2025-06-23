package com.huawei.hms.ads;

import com.huawei.hms.ads.ki;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes10.dex */
public interface im<V extends ki> {
    void Code();

    void Code(long j);

    void Code(long j, int i);

    void Code(VideoInfo videoInfo);

    void Code(com.huawei.openalliance.ad.inter.data.l lVar);

    void Code(PPSNativeView.e eVar);

    void Code(Long l, Integer num, Integer num2, boolean z, String str);

    void Code(String str);

    void Code(List<ImageInfo> list);

    boolean Code(MaterialClickInfo materialClickInfo, Integer num, String str, boolean z);

    boolean Code(MaterialClickInfo materialClickInfo, Integer num, String str, boolean z, HashMap<String, String> hashMap);

    void I(String str);

    void V();

    void V(String str);

    void V(List<String> list);
}
