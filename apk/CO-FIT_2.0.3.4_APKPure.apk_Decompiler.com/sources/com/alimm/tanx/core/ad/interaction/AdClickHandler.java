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
        String str;
        String str2;
        String str3;
        LogUtils.d("DeepLinkManager", "handleClickAndUt..");
        String pid = adClickInfo.getPid();
        String reqId = adClickInfo.getReqId();
        if (!TextUtils.isEmpty(adClickInfo.getWebClickThroughUrl()) || !TextUtils.isEmpty(adClickInfo.getWebDeepLinkUrl())) {
            str = adClickInfo.getWebDeepLinkUrl();
        } else {
            str = adClickInfo.getDeepLinkUrl();
        }
        LogUtils.d("DeepLinkManager", "deepLinkUrl: " + str);
        boolean tanxc_do = tanxc_for.tanxc_do.tanxc_do.tanxc_do(context, str, reqId, pid);
        LogUtils.d("DeepLinkManager", "handle: " + tanxc_do);
        if (!TextUtils.isEmpty(adClickInfo.getWebClickThroughUrl()) || !TextUtils.isEmpty(adClickInfo.getWebDeepLinkUrl())) {
            str2 = adClickInfo.getWebClickThroughUrl();
        } else {
            str2 = adClickInfo.getClickThroughUrl();
        }
        if (tanxc_do || z) {
            str3 = str;
        } else {
            LogUtils.d("DeepLinkManager", "ClickThroughUrl: " + str2);
            if (!TextUtils.isEmpty(str2)) {
                openWebActivity(context, str2, adClickInfo);
                tanxc_do.C0020tanxc_do.tanxc_do.tanxc_do(str2, "h5");
            }
            str3 = str2;
        }
        if (z2) {
            TanxBaseUt.utNavigate(adClickInfo, tanxc_do ? SDKConstants.PARAM_DEEP_LINK : "throughUrl", str3, str, str2);
        }
        TanxBaseUt.utClick(adClickInfo, tanxc_do, str3, str, str2);
        LogUtils.d("TanxSDK-DoClick", "TanxSDK落地页唤端跳转 reqId：" + adClickInfo.getReqId());
        TanxTestLog.sendLog("点击url", str3);
        return tanxc_do;
    }
}
