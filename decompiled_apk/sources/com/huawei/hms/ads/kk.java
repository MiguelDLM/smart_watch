package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: classes10.dex */
public interface kk extends fw, gf {
    Integer Code(AdContentData adContentData);

    void Code(int i);

    void Code(int i, int i2, String str, boolean z, Integer num);

    void Code(int i, boolean z);

    void Code(View view);

    void Code(km kmVar, Integer num);

    void Code(ky kyVar);

    void Code(AdContentData adContentData, int i);

    void I(int i);

    km V(int i);

    void V();

    AdSlotParam getAdSlotParam();

    int getAdType();

    int getAudioFocusType();

    Context getContext();
}
