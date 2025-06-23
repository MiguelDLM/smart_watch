package com.alimm.tanx.core.ad.ad.template.rendering.feed;

import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.bridge.Callback;
import com.alimm.tanx.core.bridge.JsBridgeUtil;
import com.alimm.tanx.core.bridge.JsHandler;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.AbstractMap;

/* loaded from: classes.dex */
public class FeedWebViewUtil extends com.alimm.tanx.core.ad.base.tanxc_if {
    protected ITanxAd tanxc_do;
    protected TanxAdView tanxc_if;
    private FeedWebInterface tanxc_try;
    protected long tanxc_for = 0;
    protected final long tanxc_int = 500;

    /* loaded from: classes.dex */
    public interface FeedWebInterface extends JsBridgeUtil.BaseWebInterface {
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public boolean tanxc_do() {
        return false;
    }

    public void tanxc_do(LinearLayout linearLayout, boolean z, ITanxAd iTanxAd, TanxAdView tanxAdView, FeedWebInterface feedWebInterface) {
        LogUtils.d("FeedWebViewUtil", "init");
        if (iTanxAd == null) {
            return;
        }
        this.tanxc_if = tanxAdView;
        this.tanxc_do = iTanxAd;
        super.tanxc_do(linearLayout, z, iTanxAd.getBidInfo(), iTanxAd.getAdSlot(), feedWebInterface, new JsBridgeUtil.AdInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.1
            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
            public void adClose() {
                LogUtils.d("FeedWebViewUtil", "RewardVideo.notifyClose");
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
            public void adSkip(boolean z2) {
                LogUtils.d("FeedWebViewUtil", "RewardVideo.notifyAdSkip:" + z2);
            }
        });
        this.tanxc_try = feedWebInterface;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public void tanxc_do(WebView webView) {
        super.tanxc_do(webView);
        super.tanxc_do(false);
        this.tanxc_new.register("WebAd.notifyAdExpose", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.2
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("FeedWebViewUtil", "WebAd.notifyAdExpose");
                    abstractMap.get("area");
                    ITanxAd iTanxAd = FeedWebViewUtil.this.tanxc_do;
                    if (iTanxAd != null) {
                        iTanxAd.onResourceLoadSuccess();
                    }
                    callback.call(true, null);
                } catch (Exception e) {
                    LogUtils.e("FeedWebViewUtil", e);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyAdClick", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.3
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("FeedWebViewUtil", "WebAd.notifyAdClick");
                    long currentTimeMillis = System.currentTimeMillis();
                    FeedWebViewUtil feedWebViewUtil = FeedWebViewUtil.this;
                    if (currentTimeMillis - feedWebViewUtil.tanxc_for >= 500) {
                        feedWebViewUtil.tanxc_for = System.currentTimeMillis();
                        abstractMap.get("area");
                        abstractMap.get("clickThroughUrl");
                        abstractMap.get("deepLinkUrl");
                        FeedWebViewUtil feedWebViewUtil2 = FeedWebViewUtil.this;
                        ITanxAd iTanxAd = feedWebViewUtil2.tanxc_do;
                        if (iTanxAd != null && (iTanxAd instanceof ITanxFeedAd)) {
                            ((ITanxFeedAd) iTanxAd).click(feedWebViewUtil2.tanxc_if);
                        }
                        callback.call(true, null);
                        return;
                    }
                    LogUtils.d("FeedWebViewUtil", "mClickedOnce = true");
                } catch (Exception e) {
                    LogUtils.e("FeedWebViewUtil", e);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyError", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.feed.FeedWebViewUtil.4
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                int intValue;
                LogUtils.d("FeedWebViewUtil", "WebAd.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                String str = (String) abstractMap.get("msg");
                FeedWebInterface feedWebInterface = FeedWebViewUtil.this.tanxc_try;
                if (num == null) {
                    intValue = -1;
                } else {
                    intValue = num.intValue();
                }
                feedWebInterface.webError(intValue, str);
                callback.call(true, null);
            }
        });
    }
}
