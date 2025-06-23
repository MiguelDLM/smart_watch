package com.huawei.hms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.huawei.hms.ads.data.SearchInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes10.dex */
public interface q {
    Location B();

    void B(Integer num);

    void B(String str);

    RequestOptions C();

    void C(Integer num);

    void C(String str);

    String Code();

    void Code(int i);

    void Code(Location location);

    void Code(App app);

    void Code(SearchInfo searchInfo);

    void Code(Integer num);

    void Code(String str);

    void Code(String str, BiddingParam biddingParam);

    void Code(List<Integer> list);

    void Code(Map<String, Bundle> map);

    void Code(boolean z);

    boolean Code(Context context);

    String D();

    void D(String str);

    String F();

    void F(Integer num);

    void F(String str);

    int I();

    void I(Integer num);

    void I(String str);

    void I(boolean z);

    List<Integer> L();

    void L(String str);

    void S(Integer num);

    void S(String str);

    boolean S();

    String V();

    void V(Integer num);

    void V(String str);

    void V(Map<String, BiddingParam> map);

    void V(boolean z);

    Set<String> Z();

    void Z(Integer num);

    void Z(String str);

    String a();

    void a(String str);

    BiddingParam b(String str);

    boolean b();
}
