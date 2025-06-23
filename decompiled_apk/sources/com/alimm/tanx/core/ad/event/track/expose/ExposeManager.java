package com.alimm.tanx.core.ad.event.track.expose;

import android.content.Context;
import android.os.Looper;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.listener.bean.IBidInfo;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.OrangeUtBean;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxExposerUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import xIOXX.oxoX;
import xIx.I0Io;
import xIx.II0xO0;
import xIx.oxoX;

/* loaded from: classes.dex */
public class ExposeManager {
    private final IExposer tanxc_do;
    private final List<String> tanxc_if;

    /* loaded from: classes.dex */
    public interface UtArgsNames {
        public static final String creativeId = "creative_id";
        public static final String interactType = "interact_type";
        public static final String nameSpace = "tanx";
        public static final String pid = "pid";
        public static final String reqId = "req_id";
        public static final String sessionId = "session_id";
        public static final String templateId = "template_id";
    }

    /* loaded from: classes.dex */
    public static class tanxc_do {
        static volatile ExposeManager tanxc_do = new ExposeManager(0);
    }

    public /* synthetic */ ExposeManager(byte b) {
        this();
    }

    private static boolean tanxc_if() {
        OrangeUtBean orangeUtBean;
        Boolean bool;
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null || (orangeUtBean = orangeBean.ut) == null || (bool = orangeUtBean.utTanxExposerSwitch) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private ExposeManager() {
        this.tanxc_do = new com.alimm.tanx.core.ad.event.track.expose.tanxc_do();
        this.tanxc_if = new ArrayList();
    }

    public static ExposeManager tanxc_do() {
        return tanxc_do.tanxc_do;
    }

    public void tanxc_do(Context context) {
        I0Io.I0Io().oIX0oI(context, new II0xO0.oIX0oI(new xIOXX.oIX0oI() { // from class: com.alimm.tanx.core.ad.event.track.expose.oIX0oI
            @Override // xIOXX.oIX0oI
            public final void oIX0oI(oxoX oxox, xIOXX.I0Io i0Io) {
                ExposeManager.this.tanxc_do(oxox, i0Io);
            }
        }, new x0oxIIIX.oIX0oI() { // from class: com.alimm.tanx.core.ad.event.track.expose.II0xO0
            @Override // x0oxIIIX.oIX0oI
            public final void oIX0oI(String str, int i, Object obj, Object obj2, Object obj3, Map map) {
                ExposeManager.tanxc_do(str, i, obj, obj2, obj3, map);
            }
        }).X0o0xo(2001).ooOOo0oXI(true).Oxx0IOOO(true).XO(XOxoX.I0Io.Oxx0IOOO(context), XOxoX.I0Io.II0xO0(context)).xoIox(TanxCoreSdk.getConfig().isDebugMode()).II0XooXoX());
        I0Io.I0Io().oxoX(new oXO0oOx0.oIX0oI() { // from class: com.alimm.tanx.core.ad.event.track.expose.ExposeManager.2
            @Override // oXO0oOx0.oIX0oI
            public Looper tanxc_do() {
                return Looper.getMainLooper();
            }

            @Override // oXO0oOx0.oIX0oI
            public void tanxc_if(int i, String str, String str2, AdMonitorType adMonitorType, xIx.oxoX oxox) {
                if (oxox != null) {
                    LogUtils.d("ExposeManager", "onExposeTempFail:url=" + str2 + ";exposeParams=" + oxox.toString() + ";msg=" + str + ";code=" + i);
                    TanxExposerUt.sendMonitorFail(adMonitorType, str2, i, str, oxox.oIX0oI());
                }
            }

            @Override // oXO0oOx0.oIX0oI
            public void tanxc_do(String str, AdMonitorType adMonitorType, xIx.oxoX oxox) {
                if (oxox != null) {
                    LogUtils.d("ExposeManager", "onExposeSuccess:url=" + str + ";exposeParams=" + oxox.toString());
                    TanxExposerUt.sendMonitorSuc(adMonitorType, str, oxox.oIX0oI());
                }
            }

            @Override // oXO0oOx0.oIX0oI
            public void tanxc_do(int i, String str, String str2, AdMonitorType adMonitorType, xIx.oxoX oxox) {
                if (oxox != null) {
                    LogUtils.d("ExposeManager", "onExposeTempFail:url=" + str2 + ";exposeParams=" + oxox.toString() + ";msg=" + str + ";code=" + i);
                    TanxExposerUt.sendMonitorFail(adMonitorType, str2, i, str, oxox.oIX0oI());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void tanxc_do(oxoX oxox, final xIOXX.I0Io i0Io) {
        if (oxox == null) {
            LogUtils.d("ExposeManager", "requestOptions is null");
            return;
        }
        RequestBean build = new RequestBean().setUrl(oxox.oIX0oI()).build();
        build.setOverrideError(true);
        build.setTryAgainCount(oxox.II0xO0());
        NetWorkManager.getInstance().sendHttpGet(build, Object.class, false, false, new NetWorkCallBack() { // from class: com.alimm.tanx.core.ad.event.track.expose.ExposeManager.1
            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i, String str, String str2) {
                LogUtils.d("ExposeManager", str2);
                xIOXX.I0Io i0Io2 = i0Io;
                if (i0Io2 != null) {
                    i0Io2.oIX0oI(i, str2);
                }
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void succ(Object obj) {
                LogUtils.d("ExposeManager", JSON.toJSONString(obj));
                xIOXX.I0Io i0Io2 = i0Io;
                if (i0Io2 != null) {
                    i0Io2.tanxc_do();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void tanxc_do(String str, int i, Object obj, Object obj2, Object obj3, Map map) {
        LogUtils.d("ExposeManager", "userTracker:page=" + str + ";eventId=" + i + ";arg1=" + obj + ";args" + XOxoX.I0Io.X0o0xo(map));
        if (tanxc_if()) {
            TanxBaseUt.track(str, null, null, i, 0, (String) obj, (String) obj2, (String) obj3, map, null);
        } else {
            LogUtils.d("ExposeManager", "埋点开关关闭，终止上报");
        }
    }

    public void tanxc_do(BidInfo bidInfo, String str, String str2, List<String> list) {
        try {
            LogUtils.d("ExposeManager", "exposeVideo3S ing reqId:" + str + " pid :" + str);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pid", str2);
            jSONObject.put(UtArgsNames.reqId, str);
            jSONObject.put("session_id", bidInfo.getSessionId());
            jSONObject.put(UtArgsNames.templateId, bidInfo.getTemplateId());
            jSONObject.put(UtArgsNames.creativeId, bidInfo.getCreativeId());
            jSONObject.put(UtArgsNames.interactType, bidInfo.getInteractType2Int());
            I0Io.I0Io().XO(list, new oxoX.oIX0oI().II0xO0(UtArgsNames.nameSpace).Oxx0IOOO(str2).I0Io(jSONObject).oxoX());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void tanxc_do(BidInfo bidInfo, String str, String str2, AdMonitorType adMonitorType, List<tanxc_if> list, ExposeCallback exposeCallback) {
        if (OrangeManager.getInstance().getCommonSwitch("useNewExposerSwitch")) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pid", str2);
                jSONObject.put(UtArgsNames.reqId, str);
                jSONObject.put("session_id", bidInfo.getSessionId());
                jSONObject.put(UtArgsNames.templateId, bidInfo.getTemplateId());
                jSONObject.put(UtArgsNames.creativeId, bidInfo.getCreativeId());
                jSONObject.put(UtArgsNames.interactType, bidInfo.getInteractType2Int());
                xIx.oxoX oxoX2 = new oxoX.oIX0oI().II0xO0(UtArgsNames.nameSpace).Oxx0IOOO(str2).I0Io(jSONObject).oxoX();
                if (adMonitorType == AdMonitorType.EXPOSE) {
                    I0Io.I0Io().II0xO0(bidInfo.getImpTrackUrl(), oxoX2);
                } else if (adMonitorType == AdMonitorType.CLICK) {
                    I0Io.I0Io().Oxx0IOOO(bidInfo.getClickTrackUrl(), oxoX2);
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        tanxc_do(bidInfo, list, exposeCallback);
    }

    public void tanxc_do(IBidInfo iBidInfo, List<tanxc_if> list, final ExposeCallback exposeCallback) {
        if (iBidInfo != null && list != null) {
            for (int i = 0; i < list.size(); i++) {
                final tanxc_if tanxc_ifVar = list.get(i);
                if (tanxc_ifVar != null) {
                    String tanxc_do2 = tanxc_ifVar.tanxc_do();
                    if (tanxc_ifVar.tanxc_int()) {
                        if (!tanxc_ifVar.tanxc_for() && !tanxc_ifVar.tanxc_try() && !this.tanxc_if.contains(tanxc_do2)) {
                            this.tanxc_if.add(tanxc_do2);
                        }
                    }
                    this.tanxc_do.onExpose(tanxc_ifVar.tanxc_if(), tanxc_do2, new ExposeCallback() { // from class: com.alimm.tanx.core.ad.event.track.expose.ExposeManager.3
                        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
                        public void onFail(int i2, String str, String str2) {
                            ExposeManager.this.tanxc_if.remove(str2);
                            tanxc_ifVar.tanxc_new();
                            ExposeCallback exposeCallback2 = exposeCallback;
                            if (exposeCallback2 != null) {
                                exposeCallback2.onFail(i2, str, str2);
                            }
                        }

                        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
                        public void onSucceed(int i2, String str) {
                            tanxc_ifVar.tanxc_do(true);
                            ExposeManager.this.tanxc_if.remove(str);
                            ExposeCallback exposeCallback2 = exposeCallback;
                            if (exposeCallback2 != null) {
                                exposeCallback2.onSucceed(i2, str);
                            }
                        }

                        @Override // com.alimm.tanx.core.ad.event.track.expose.ExposeCallback
                        public void send(String str) {
                            ExposeCallback exposeCallback2 = exposeCallback;
                            if (exposeCallback2 != null) {
                                exposeCallback2.send(str);
                            }
                        }
                    });
                }
            }
            return;
        }
        String str = "";
        String str2 = iBidInfo == null ? " bidInfo == null" : "";
        if (list == null) {
            str2 = str2 + " monitorInfoList == null";
        } else if (list.size() <= 0) {
            str2 = str2 + " monitorInfoList size <= 0";
        } else {
            str = list.toString();
        }
        if (exposeCallback != null) {
            exposeCallback.onFail(UtErrorCode.IMP_URL_ERROR.getIntCode(), str2, str);
        }
    }
}
