package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.ad.base.tanxc_if;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.bridge.Callback;
import com.alimm.tanx.core.bridge.JsBridgeUtil;
import com.alimm.tanx.core.bridge.JsHandler;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.AbstractMap;

public class TableScreenWebViewUtil extends tanxc_if {
    protected long tanxc_do = 0;
    /* access modifiers changed from: private */
    public tanxc_if tanxc_for;
    protected final long tanxc_if = 500;
    /* access modifiers changed from: private */
    public TableScreenInterface tanxc_int;

    public interface TableScreenInterface extends JsBridgeUtil.BaseWebInterface {
    }

    public boolean tanxc_do() {
        return true;
    }

    public void tanxc_do(LinearLayout linearLayout, BidInfo bidInfo, TanxAdSlot tanxAdSlot, tanxc_if tanxc_if2, TableScreenInterface tableScreenInterface) {
        LogUtils.d("TableScreenWebViewUtil", "init");
        super.tanxc_do(linearLayout, true, bidInfo, tanxAdSlot, tableScreenInterface, new JsBridgeUtil.AdInterface() {
            public void adClose() {
                LogUtils.d("TableScreenWebViewUtil", "RewardVideo.notifyClose");
            }

            public void adSkip(boolean z) {
                LogUtils.d("TableScreenWebViewUtil", "RewardVideo.notifyAdSkip:" + z);
            }
        });
        this.tanxc_for = tanxc_if2;
        this.tanxc_int = tableScreenInterface;
    }

    public void tanxc_do(WebView webView) {
        super.tanxc_do(webView);
        super.tanxc_do(true);
        this.tanxc_new.register("WebAd.notifyAdExpose", new JsHandler() {
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyAdExpose");
                    abstractMap.get("area");
                    if (!(TableScreenWebViewUtil.this.tanxc_for == null || TableScreenWebViewUtil.this.tanxc_for.tanxc_do == null)) {
                        TableScreenWebViewUtil.this.tanxc_for.tanxc_do.onResourceLoadSuccess();
                    }
                    callback.call(true, (AbstractMap) null);
                } catch (Exception e) {
                    LogUtils.e("TableScreenWebViewUtil", e);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyAdClick", new JsHandler() {
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyAdClick");
                    long currentTimeMillis = System.currentTimeMillis();
                    TableScreenWebViewUtil tableScreenWebViewUtil = TableScreenWebViewUtil.this;
                    if (currentTimeMillis - tableScreenWebViewUtil.tanxc_do >= 500) {
                        tableScreenWebViewUtil.tanxc_do = System.currentTimeMillis();
                        abstractMap.get("area");
                        String str = (String) abstractMap.get("clickThroughUrl");
                        String str2 = (String) abstractMap.get("deepLinkUrl");
                        if (!(TableScreenWebViewUtil.this.tanxc_for == null || TableScreenWebViewUtil.this.tanxc_for.tanxc_do == null)) {
                            TableScreenWebViewUtil.this.tanxc_for.tanxc_do.click(str, str2);
                            if (TableScreenWebViewUtil.this.tanxc_for.tanxc_for() != null) {
                                TableScreenWebViewUtil.this.tanxc_for.tanxc_for().onAdClicked((TanxAdView) null, TableScreenWebViewUtil.this.tanxc_for.tanxc_do);
                            }
                        }
                        callback.call(true, (AbstractMap) null);
                        return;
                    }
                    LogUtils.d("TableScreenWebViewUtil", "mClickedOnce = true");
                } catch (Exception e) {
                    LogUtils.e("TableScreenWebViewUtil", e);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyError", new JsHandler() {
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                int i;
                LogUtils.d("TableScreenWebViewUtil", "WebAd.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                String str = (String) abstractMap.get("msg");
                TableScreenInterface tanxc_if = TableScreenWebViewUtil.this.tanxc_int;
                if (num == null) {
                    i = -1;
                } else {
                    i = num.intValue();
                }
                tanxc_if.webError(i, str);
                callback.call(true, (AbstractMap) null);
            }
        });
    }
}
