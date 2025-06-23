package com.alimm.tanx.core.ad.ad.splash;

import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.TanxSplashAdView;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new;
import com.alimm.tanx.core.ad.base.tanxc_if;
import com.alimm.tanx.core.bridge.Callback;
import com.alimm.tanx.core.bridge.JsBridgeUtil;
import com.alimm.tanx.core.bridge.JsHandler;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.AbstractMap;

public class SplashWebViewUtil extends tanxc_if {
    protected ITanxSplashExpressAd tanxc_do;
    protected long tanxc_for = 0;
    protected TanxSplashAdView tanxc_if;
    protected final long tanxc_int = 500;
    /* access modifiers changed from: private */
    public SplashWebInterface tanxc_try;

    public interface SplashWebInterface extends JsBridgeUtil.BaseWebInterface {
    }

    public boolean tanxc_do() {
        return true;
    }

    public void tanxc_do(LinearLayout linearLayout, ITanxSplashExpressAd iTanxSplashExpressAd, TanxSplashAdView tanxSplashAdView, SplashWebInterface splashWebInterface) {
        LogUtils.d("SplashWebViewUtil", "init");
        if (iTanxSplashExpressAd != null) {
            this.tanxc_if = tanxSplashAdView;
            this.tanxc_do = iTanxSplashExpressAd;
            super.tanxc_do(linearLayout, true, iTanxSplashExpressAd.getBidInfo(), iTanxSplashExpressAd.getAdSlot(), splashWebInterface, new JsBridgeUtil.AdInterface() {
                public void adClose() {
                    LogUtils.d("SplashWebViewUtil", "RewardVideo.notifyClose");
                }

                public void adSkip(boolean z) {
                    LogUtils.d("SplashWebViewUtil", "RewardVideo.notifyAdSkip:" + z);
                }
            });
            this.tanxc_try = splashWebInterface;
        }
    }

    public void tanxc_do(WebView webView) {
        super.tanxc_do(webView);
        super.tanxc_do(false);
        this.tanxc_new.register("WebAd.notifyAdExpose", new JsHandler() {
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("SplashWebViewUtil", "WebAd.notifyAdExpose");
                    abstractMap.get("area");
                    ITanxSplashExpressAd iTanxSplashExpressAd = SplashWebViewUtil.this.tanxc_do;
                    if (iTanxSplashExpressAd != null) {
                        iTanxSplashExpressAd.onResourceLoadSuccess();
                    }
                    callback.call(true, (AbstractMap) null);
                } catch (Exception e) {
                    LogUtils.e("SplashWebViewUtil", e);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyAdClick", new JsHandler() {
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("SplashWebViewUtil", "WebAd.notifyAdClick");
                    long currentTimeMillis = System.currentTimeMillis();
                    SplashWebViewUtil splashWebViewUtil = SplashWebViewUtil.this;
                    if (currentTimeMillis - splashWebViewUtil.tanxc_for >= 500) {
                        splashWebViewUtil.tanxc_for = System.currentTimeMillis();
                        abstractMap.get("area");
                        String str = (String) abstractMap.get("clickThroughUrl");
                        String str2 = (String) abstractMap.get("deepLinkUrl");
                        ITanxSplashExpressAd iTanxSplashExpressAd = SplashWebViewUtil.this.tanxc_do;
                        if (iTanxSplashExpressAd != null && (iTanxSplashExpressAd instanceof tanxc_new)) {
                            ((tanxc_new) iTanxSplashExpressAd).tanxc_do(str, str2, false);
                            if (SplashWebViewUtil.this.tanxc_do.getOnSplashAdListener() != null) {
                                SplashWebViewUtil.this.tanxc_do.getOnSplashAdListener().onAdClicked();
                            }
                        }
                        callback.call(true, (AbstractMap) null);
                        return;
                    }
                    LogUtils.d("SplashWebViewUtil", "mClickedOnce = true");
                } catch (Exception e) {
                    LogUtils.e("SplashWebViewUtil", e);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyError", new JsHandler() {
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                int i;
                LogUtils.d("SplashWebViewUtil", "WebAd.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                String str = (String) abstractMap.get("msg");
                SplashWebInterface tanxc_do2 = SplashWebViewUtil.this.tanxc_try;
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
