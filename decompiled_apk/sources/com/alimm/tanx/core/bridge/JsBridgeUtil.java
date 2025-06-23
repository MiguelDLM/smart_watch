package com.alimm.tanx.core.bridge;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ut.bean.UtItemH5Bean;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.utils.NotConfused;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.qq.e.comm.constants.Constants;
import java.util.AbstractMap;
import java.util.HashMap;

/* loaded from: classes.dex */
public class JsBridgeUtil implements NotConfused {
    public static final String TAG = "JsBridgeUtil";
    private AdInterface adInterface;
    private BaseWebInterface baseWebInterface;
    private JsBridgeBean jsBridgeBean;

    /* loaded from: classes.dex */
    public interface AdInterface {
        void adClose();

        void adSkip(boolean z);
    }

    /* loaded from: classes.dex */
    public interface BaseWebInterface {
        void adClose();

        void adSkip(boolean z);

        void h5NotifyDrawSuccess();

        void webDrawStatus(boolean z);

        void webError(int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void track(AbstractMap<String, Object> abstractMap, Callback callback) {
        String str;
        try {
            LogUtils.d(TAG, "RewardVideo.track");
            JSONObject jSONObject = (JSONObject) abstractMap.get(NotificationCompat.CATEGORY_EVENT);
            if (jSONObject != null) {
                str = jSONObject.toJSONString();
            } else {
                str = "";
            }
            UtItemH5Bean utItemH5Bean = (UtItemH5Bean) JSON.parseObject(str, UtItemH5Bean.class);
            Boolean bool = (Boolean) abstractMap.get("needTemplateId");
            Boolean bool2 = (Boolean) abstractMap.get("needCreativeId");
            Boolean bool3 = (Boolean) abstractMap.get("needOpenType");
            Boolean bool4 = (Boolean) abstractMap.get("needClickUrl");
            if (utItemH5Bean != null) {
                JsBridgeBean jsBridgeBean = this.jsBridgeBean;
                if (jsBridgeBean != null) {
                    utItemH5Bean.pid = jsBridgeBean.getPid();
                    utItemH5Bean.reqId = this.jsBridgeBean.getReqId();
                }
                if (TextUtils.isEmpty(utItemH5Bean.page)) {
                    utItemH5Bean.page = utItemH5Bean.arg1;
                }
                if (this.jsBridgeBean != null) {
                    if (utItemH5Bean.args == null) {
                        utItemH5Bean.args = new HashMap();
                    }
                    if (bool == null || bool.booleanValue()) {
                        utItemH5Bean.args.put(ExposeManager.UtArgsNames.templateId, this.jsBridgeBean.getTemplateId());
                    }
                    if (bool2 == null || bool2.booleanValue()) {
                        utItemH5Bean.args.put(ExposeManager.UtArgsNames.creativeId, this.jsBridgeBean.getCreativeId());
                    }
                    if (bool3 != null && bool3.booleanValue()) {
                        utItemH5Bean.args.put("openType", Integer.valueOf(this.jsBridgeBean.getOpenType()));
                    }
                    if (bool4 != null && bool4.booleanValue()) {
                        utItemH5Bean.args.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, this.jsBridgeBean.getDeepLinkUrl());
                    }
                }
                TanxBaseUt.h5Ut(utItemH5Bean);
            } else {
                LogUtils.e(TAG, "Core.track  接收到H5埋点对象为空");
            }
            callback.call(true, null);
        } catch (Exception e) {
            LogUtils.e(TAG, e);
        }
    }

    public void initJsBridge(TanxJsBridge tanxJsBridge, JsBridgeBean jsBridgeBean, BaseWebInterface baseWebInterface, AdInterface adInterface) {
        if (tanxJsBridge == null) {
            LogUtils.d(TAG, "jsBridge注册失败，tanxJsBridge为空");
            return;
        }
        this.jsBridgeBean = jsBridgeBean;
        this.baseWebInterface = baseWebInterface;
        this.adInterface = adInterface;
        tanxJsBridge.register("Core.getSdkInfo", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.3
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d(JsBridgeUtil.TAG, "Core.getSDKInfo");
                HashMap hashMap = new HashMap();
                hashMap.put("version", SdkConstant.getSdkVersion());
                callback.call(true, hashMap);
            }
        });
        tanxJsBridge.register("WebAd.notifyWebDidMount", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.4
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d(JsBridgeUtil.TAG, "WebAd.notifyWebDidMount");
                if (JsBridgeUtil.this.baseWebInterface != null) {
                    LogUtils.d(JsBridgeUtil.TAG, "baseWebInterface!=null");
                    JsBridgeUtil.this.baseWebInterface.h5NotifyDrawSuccess();
                }
            }
        });
        tanxJsBridge.register("WebAd.track", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.5
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                JsBridgeUtil.this.track(abstractMap, callback);
            }
        });
        tanxJsBridge.register("WebAd.getAd", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.6
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                JSONObject jSONObject;
                HashMap hashMap = new HashMap();
                JSONObject jSONObject2 = null;
                try {
                    LogUtils.d(JsBridgeUtil.TAG, "RewardVideo.getAd");
                    if (JsBridgeUtil.this.jsBridgeBean != null && !TextUtils.isEmpty(JsBridgeUtil.this.jsBridgeBean.getRawJsonStr())) {
                        jSONObject = JSON.parseObject(JsBridgeUtil.this.jsBridgeBean.getRawJsonStr());
                    } else {
                        jSONObject = null;
                    }
                    e = null;
                    jSONObject2 = jSONObject;
                } catch (Exception e) {
                    e = e;
                    LogUtils.e(JsBridgeUtil.TAG, e);
                }
                if (jSONObject2 != null) {
                    hashMap.put(MapBundleKey.MapObjKey.OBJ_AD, jSONObject2);
                } else {
                    hashMap.put("code", -1);
                    String stackTraceMessage = LogUtils.getStackTraceMessage(e);
                    if (JsBridgeUtil.this.jsBridgeBean != null) {
                        stackTraceMessage = stackTraceMessage + "  \n jsBridgeBean:" + JsBridgeUtil.this.jsBridgeBean.getRawJsonStr();
                    }
                    hashMap.put("msg", stackTraceMessage);
                }
                callback.call(true, hashMap);
            }
        });
        tanxJsBridge.register("Core.getNetType", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.7
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d(JsBridgeUtil.TAG, "Core.getNetType");
                HashMap hashMap = new HashMap();
                hashMap.put("netType", NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getMsg());
                LogUtils.d(JsBridgeUtil.TAG, JSON.toJSONString(hashMap));
                callback.call(true, hashMap);
            }
        });
        tanxJsBridge.register("WebAd.notifyClose", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.8
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d(JsBridgeUtil.TAG, "RewardVideo.notifyClose");
                if (JsBridgeUtil.this.adInterface != null) {
                    JsBridgeUtil.this.adInterface.adClose();
                }
                JsBridgeUtil.this.baseWebInterface.adClose();
                callback.call(true, null);
            }
        });
        tanxJsBridge.register("WebAd.notifyAdSkip", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.9
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                LogUtils.d(JsBridgeUtil.TAG, "RewardVideo.notifyAdSkip");
                Boolean bool = (Boolean) abstractMap.get("needClose");
                if (bool == null) {
                    bool = Boolean.TRUE;
                }
                if (JsBridgeUtil.this.adInterface != null) {
                    JsBridgeUtil.this.adInterface.adSkip(bool.booleanValue());
                }
                JsBridgeUtil.this.baseWebInterface.adSkip(bool.booleanValue());
                callback.call(true, null);
            }
        });
        tanxJsBridge.register("WebAd.notifyError", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.10
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                int intValue;
                LogUtils.d(JsBridgeUtil.TAG, "Reward.notifyError");
                Integer num = (Integer) abstractMap.get("cmd");
                String str = (String) abstractMap.get("msg");
                BaseWebInterface baseWebInterface2 = JsBridgeUtil.this.baseWebInterface;
                if (num == null) {
                    intValue = -1;
                } else {
                    intValue = num.intValue();
                }
                baseWebInterface2.webError(intValue, str);
                callback.call(true, null);
            }
        });
        tanxJsBridge.register("WebAd.submitFeedback", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.2
            @Override // com.alimm.tanx.core.bridge.JsHandler
            public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                try {
                    LogUtils.d(JsBridgeUtil.TAG, "RewardVideo.submitFeedback");
                    String str = (String) abstractMap.get("interactType");
                    String str2 = (String) abstractMap.get("interactDesc");
                    if (JsBridgeUtil.this.jsBridgeBean != null) {
                        InteractionUpload.getInstance().uploadInteraction(JsBridgeUtil.this.jsBridgeBean.getEventTrack(), str, str2);
                    }
                    callback.call(true, null);
                } catch (Exception e) {
                    LogUtils.e(JsBridgeUtil.TAG, e);
                }
            }
        });
    }

    public void setShowWebBar(TanxJsBridge tanxJsBridge, final boolean z) {
        if (tanxJsBridge == null) {
            LogUtils.d(TAG, "setShowWebBar过程jsBridge注册失败，tanxJsBridge为空");
        } else {
            tanxJsBridge.register("WebAd.isShowWebBar", new JsHandler() { // from class: com.alimm.tanx.core.bridge.JsBridgeUtil.1
                @Override // com.alimm.tanx.core.bridge.JsHandler
                public void handler(AbstractMap<String, Object> abstractMap, Callback callback) {
                    LogUtils.d(JsBridgeUtil.TAG, "WebAd.isShowWebBar");
                    HashMap hashMap = new HashMap();
                    hashMap.put("showWebBarSwitch", Boolean.valueOf(z));
                    callback.call(true, hashMap);
                }
            });
        }
    }
}
