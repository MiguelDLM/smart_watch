package com.alimm.tanx.core.ad.ad.template.rendering.feed;

import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd;
import com.alimm.tanx.core.ad.base.tanxc_if;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.bridge.Callback;
import com.alimm.tanx.core.bridge.JsBridgeUtil;
import com.alimm.tanx.core.bridge.JsHandler;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.AbstractMap;

public class FeedWebViewUtil extends tanxc_if {
    protected ITanxAd tanxc_do;
    protected long tanxc_for = 0;
    protected TanxAdView tanxc_if;
    protected final long tanxc_int = 500;
    /* access modifiers changed from: private */
    public FeedWebInterface tanxc_try;

    public interface FeedWebInterface extends JsBridgeUtil.BaseWebInterface {
    }

    public boolean tanxc_do() {
        return false;
    }

    public void tanxc_do(LinearLayout linearLayout, boolean z, ITanxAd iTanxAd, TanxAdView tanxAdView, FeedWebInterface feedWebInterface) {
        LogUtils.d("FeedWebViewUtil", "init");
        if (iTanxAd != null) {
            this.tanxc_if = tanxAdView;
            this.tanxc_do = iTanxAd;
            super.tanxc_do(linearLayout, z, iTanxAd.getBidInfo(), iTanxAd.getAdSlot(), feedWebInterface, new JsBridgeUtil.AdInterface() {
                public void adClose() {
                    LogUtils.d("FeedWebViewUtil", "RewardVideo.notifyClose");
                }

                public void adSkip(boolean z) {
                    LogUtils.d("FeedWebViewUtil", "RewardVideo.notifyAdSkip:" + z);
                }
            });
            this.tanxc_try = feedWebInterface;
        }
    }

    public void tanxc_do(WebView webView) {
        super.tanxc_do(webView);
        super.tanxc_do(false);
        this.tanxc_new.register("WebAd.notifyAdExpose", new JsHandler() {
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("FeedWebViewUtil", "WebAd.notifyAdExpose");
                    abstractMap.get("area");
                    ITanxAd iTanxAd = FeedWebViewUtil.this.tanxc_do;
                    if (iTanxAd != null) {
                        iTanxAd.onResourceLoadSuccess();
                    }
                    callback.call(true, (AbstractMap) null);
                } catch (Exception e) {
                    LogUtils.e("FeedWebViewUtil", e);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyAdClick", new JsHandler() {
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
                        callback.call(true, (AbstractMap) null);
                        return;
                    }
                    LogUtils.d("FeedWebViewUtil", "mClickedOnce = true");
                } catch (Exception e) {
                    LogUtils.e("FeedWebViewUtil", e);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyError", new JsHandler() {
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                int i;
                LogUtils.d("FeedWebViewUtil", "WebAd.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                String str = (String) abstractMap.get("msg");
                FeedWebInterface tanxc_do2 = FeedWebViewUtil.this.tanxc_try;
                if (num == null) {
                    i = -1;
                } else {
                    i = num.intValue();
                }
                tanxc_do2.webError(i, str);
                callback.call(true, (AbstractMap) null);
            }
        });
    }
}
