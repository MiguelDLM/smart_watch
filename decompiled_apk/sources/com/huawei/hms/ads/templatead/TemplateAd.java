package com.huawei.hms.ads.templatead;

import android.view.View;
import com.huawei.hms.ads.annotation.AllApi;
import java.util.Map;

@AllApi
/* loaded from: classes10.dex */
public interface TemplateAd {
    void destroy();

    String getContentId();

    Map<String, String> getExt();

    View getTemplateAdView();

    String getUniqueId();

    boolean isExpire();

    void render();
}
