package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.bridge.Callback;
import com.alimm.tanx.core.bridge.JsBridgeUtil;
import com.alimm.tanx.core.bridge.JsHandler;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.ut.impl.TanxRewardUt;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.AbstractMap;
import java.util.HashMap;

/* loaded from: classes.dex */
public class RewardWebViewUtil extends com.alimm.tanx.core.ad.base.tanxc_if {
    private tanxc_new tanxc_do;
    private RewardInterface tanxc_if;
    private String tanxc_for = "";
    private String tanxc_int = "";
    private long tanxc_try = -1;

    /* loaded from: classes.dex */
    public interface RewardInterface extends JsBridgeUtil.BaseWebInterface {
        long getCurrentTime();

        String getPlayState();

        long getTotalTime();

        void onScroll(int i, int i2);

        void setPlayer(Boolean bool, Boolean bool2);

        void webNotifyCountDown(int i, int i2);
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public boolean tanxc_do() {
        return true;
    }

    public void tanxc_if(int i) {
        if (this.tanxc_try <= 0) {
            return;
        }
        LogUtils.d("utLog", "utPlayEndClickTime");
        TanxRewardUt.utPlayEndClickTime(this.tanxc_do, System.currentTimeMillis() - this.tanxc_try, i);
        this.tanxc_try = -1L;
    }

    public void tanxc_do(LinearLayout linearLayout, BidInfo bidInfo, TanxAdSlot tanxAdSlot, tanxc_new tanxc_newVar, RewardInterface rewardInterface) {
        LogUtils.d("RewardWebViewUtil", "init");
        super.tanxc_do(linearLayout, true, bidInfo, tanxAdSlot, rewardInterface, new JsBridgeUtil.AdInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.1
            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
            public void adClose() {
                LogUtils.d("RewardWebViewUtil", "RewardVideo.notifyClose");
                RewardWebViewUtil.this.tanxc_if(1);
            }

            @Override // com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface
            public void adSkip(boolean z) {
                LogUtils.d("RewardWebViewUtil", "RewardVideo.notifyAdSkip:" + z);
                RewardWebViewUtil.this.tanxc_if(1);
            }
        });
        this.tanxc_do = tanxc_newVar;
        this.tanxc_if = rewardInterface;
    }

    @Override // com.alimm.tanx.core.ad.base.tanxc_if
    public void tanxc_do(WebView webView) {
        super.tanxc_do(webView);
        super.tanxc_do(true);
        this.tanxc_new.register("WebAd.getPlayerInfo", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.2
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                String str;
                LogUtils.d("RewardWebViewUtil", "WebAd.getPlayerInfo  - currentTime:" + RewardWebViewUtil.this.tanxc_if.getCurrentTime() + "  totalTime:" + RewardWebViewUtil.this.tanxc_if.getTotalTime() + "  playState:" + RewardWebViewUtil.this.tanxc_if.getPlayState());
                HashMap hashMap = new HashMap();
                hashMap.put("currentTime", Long.valueOf(RewardWebViewUtil.this.tanxc_if.getCurrentTime()));
                hashMap.put("totalTime", Long.valueOf(RewardWebViewUtil.this.tanxc_if.getTotalTime()));
                if (RewardWebViewUtil.this.tanxc_do.tanxc_do.mute) {
                    str = "muted";
                } else {
                    str = "vocal";
                }
                hashMap.put("audioState", str);
                hashMap.put("playState", RewardWebViewUtil.this.tanxc_if.getPlayState());
                LogUtils.d("RewardWebViewUtil", JSON.toJSONString(hashMap));
                callback.call(true, hashMap);
            }
        });
        this.tanxc_new.register("WebAd.notifyAdExpose", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.3
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("RewardWebViewUtil", "WebAd.notifyAdExpose");
                    abstractMap.get("area");
                    if (RewardWebViewUtil.this.tanxc_do != null && RewardWebViewUtil.this.tanxc_do.tanxc_if != null) {
                        RewardWebViewUtil.this.tanxc_do.tanxc_if.onResourceLoadSuccess();
                    }
                    callback.call(true, null);
                } catch (Exception e) {
                    LogUtils.e("RewardWebViewUtil", e);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyAdClick", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.4
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("RewardWebViewUtil", "WebAd.notifyAdClick");
                    RewardWebViewUtil.this.tanxc_if(0);
                    LogUtils.d("RewardWebViewUtil", "WebAd.notifyAdClick");
                    abstractMap.get("area");
                    String str = (String) abstractMap.get("clickThroughUrl");
                    String str2 = (String) abstractMap.get("deepLinkUrl");
                    if (RewardWebViewUtil.this.tanxc_do != null && RewardWebViewUtil.this.tanxc_do.tanxc_if != null) {
                        RewardWebViewUtil.this.tanxc_do.tanxc_if.click(str, str2);
                        if (RewardWebViewUtil.this.tanxc_do.tanxc_for() != null) {
                            RewardWebViewUtil.this.tanxc_do.tanxc_for().onAdClicked(null, RewardWebViewUtil.this.tanxc_do.tanxc_if);
                        }
                    }
                    callback.call(true, null);
                } catch (Exception e) {
                    LogUtils.e("RewardWebViewUtil", e);
                }
            }
        });
        this.tanxc_new.register("WebAd.setPlayer", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.5
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d("RewardWebViewUtil", "WebAd.setPlayer");
                    RewardWebViewUtil.this.tanxc_if.setPlayer((Boolean) abstractMap.get("muted"), (Boolean) abstractMap.get("pausing"));
                    callback.call(true, null);
                } catch (Exception e) {
                    LogUtils.e("RewardWebViewUtil", e);
                }
            }
        });
        this.tanxc_new.register("WebAd.notifyCountDown", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.6
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d("RewardWebViewUtil", "WebAd.notifyCountDown");
                Integer num = (Integer) abstractMap.get("totalTime");
                Integer num2 = (Integer) abstractMap.get("currentTime");
                if (num == null) {
                    num = 0;
                }
                if (num2 == null) {
                    num2 = 0;
                }
                RewardWebViewUtil.this.tanxc_if.webNotifyCountDown(num.intValue(), num2.intValue());
                callback.call(true, null);
            }
        });
        this.tanxc_new.register("WebAd.notifyError", new JsHandler() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.7
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                int intValue;
                LogUtils.d("RewardWebViewUtil", "WebAd.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                String str = (String) abstractMap.get("msg");
                RewardInterface rewardInterface = RewardWebViewUtil.this.tanxc_if;
                if (num == null) {
                    intValue = -1;
                } else {
                    intValue = num.intValue();
                }
                rewardInterface.webError(intValue, str);
                callback.call(true, null);
            }
        });
    }

    public void tanxc_do(String str) {
        LogUtils.d("RewardWebViewUtil", "playStateChange - nowPlayStateStr：" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (this.tanxc_int.equals(str)) {
            return;
        }
        hashMap.put("new", str);
        hashMap.put("old", this.tanxc_int);
        this.tanxc_new.postEvent("WebAd.playStateChange", hashMap);
        this.tanxc_int = str;
        if (str == null || !str.equals("end")) {
            return;
        }
        this.tanxc_try = System.currentTimeMillis();
    }

    public void tanxc_do(int i) {
        String str;
        LogUtils.d("RewardWebViewUtil", "audioStateChange - volume：" + i);
        HashMap hashMap = new HashMap();
        if (i <= 0) {
            str = "muted";
        } else {
            str = "vocal";
        }
        if (this.tanxc_for.equals(str)) {
            return;
        }
        hashMap.put("new", str);
        hashMap.put("old", this.tanxc_for);
        this.tanxc_new.postEvent("WebAd.audioStateChange", hashMap);
        this.tanxc_for = str;
    }
}
