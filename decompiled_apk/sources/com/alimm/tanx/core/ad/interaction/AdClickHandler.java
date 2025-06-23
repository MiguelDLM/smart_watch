package com.alimm.tanx.core.ad.interaction;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.core.ad.browser.TanxBrowserActivity;
import com.alimm.tanx.core.ad.interaction.tanxc_do;
import com.alimm.tanx.core.ad.interaction.tanxc_for;
import com.alimm.tanx.core.bridge.JsBridgeBean;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxTestLog;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;

/* loaded from: classes.dex */
public class AdClickHandler implements NotConfused {
    private static final String TAG = "AdClickHandler";

    private void openWebActivity(Context context, String str, AdClickInfo adClickInfo) {
        if (adClickInfo == null) {
            LogUtils.e(TAG, "openWebActivity 时adClickInfo 为空");
        } else {
            TanxBrowserActivity.tanxc_do(context, str, new JsBridgeBean(adClickInfo.getPid(), adClickInfo.getReqId(), adClickInfo.getRawJsonStr(), adClickInfo.getEventTrack(), adClickInfo.getTemplateId(), adClickInfo.getCreativeId(), adClickInfo.getOpenType(), adClickInfo.getDeepLinkUrl(), adClickInfo.getClickThroughUrl()));
        }
    }

    public boolean handleClickAndUt(Context context, AdClickInfo adClickInfo, boolean z) {
        return handleClickAndUt(context, adClickInfo, false, z);
    }

    public boolean handleClickAndUt(Context context, AdClickInfo adClickInfo, boolean z, boolean z2) {
        tanxc_for tanxc_forVar;
        String webClickThroughUrl;
        String str;
        LogUtils.d("DeepLinkManager", "handleClickAndUt..");
        String pid = adClickInfo.getPid();
        String reqId = adClickInfo.getReqId();
        String deepLinkUrl = (TextUtils.isEmpty(adClickInfo.getWebClickThroughUrl()) && TextUtils.isEmpty(adClickInfo.getWebDeepLinkUrl())) ? adClickInfo.getDeepLinkUrl() : adClickInfo.getWebDeepLinkUrl();
        LogUtils.d("DeepLinkManager", "deepLinkUrl: " + deepLinkUrl);
        tanxc_forVar = tanxc_for.tanxc_do.tanxc_do;
        boolean tanxc_do = tanxc_forVar.tanxc_do(context, deepLinkUrl, reqId, pid);
        LogUtils.d("DeepLinkManager", "handle: " + tanxc_do);
        if (TextUtils.isEmpty(adClickInfo.getWebClickThroughUrl()) && TextUtils.isEmpty(adClickInfo.getWebDeepLinkUrl())) {
            webClickThroughUrl = adClickInfo.getClickThroughUrl();
        } else {
            webClickThroughUrl = adClickInfo.getWebClickThroughUrl();
        }
        if (tanxc_do || z) {
            str = deepLinkUrl;
        } else {
            LogUtils.d("DeepLinkManager", "ClickThroughUrl: " + webClickThroughUrl);
            if (!TextUtils.isEmpty(webClickThroughUrl)) {
                openWebActivity(context, webClickThroughUrl, adClickInfo);
                tanxc_do.C0103tanxc_do.tanxc_do.tanxc_do(webClickThroughUrl, "h5");
            }
            str = webClickThroughUrl;
        }
        if (z2) {
            TanxBaseUt.utNavigate(adClickInfo, tanxc_do ? SDKConstants.PARAM_DEEP_LINK : "throughUrl", str, deepLinkUrl, webClickThroughUrl);
        }
        TanxBaseUt.utClick(adClickInfo, tanxc_do, str, deepLinkUrl, webClickThroughUrl);
        LogUtils.d("TanxSDK-DoClick", "TanxSDK落地页唤端跳转 reqId：" + adClickInfo.getReqId());
        TanxTestLog.sendLog("点击url", str);
        return tanxc_do;
    }
}
