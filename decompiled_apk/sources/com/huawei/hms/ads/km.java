package com.huawei.hms.ads;

import android.view.View;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: classes10.dex */
public interface km extends fw, gf, kw {
    void B();

    boolean C();

    void Code(int i);

    void Code(int i, int i2);

    void Code(View view, Integer num);

    void Code(gv gvVar);

    void D();

    void F();

    void I(int i);

    void V();

    void Z();

    fn getAdMediator();

    void setAdContent(AdContentData adContentData);

    void setAdMediator(fn fnVar);

    void setAudioFocusType(int i);

    void setDisplayDuration(int i);
}
