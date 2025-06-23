package com.alimm.tanx.core.orange;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.ConfigRequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.orange.bean.ExposureConfigBean;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.TanxConfigTableV2;
import com.alimm.tanx.core.request.ConfigRequest;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.AssetsUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.SharedPreferencesHelper;
import com.baidu.mobads.sdk.internal.a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class OrangeManager implements NotConfused {
    public static final String FEED_VIDEO_MAX_SIZE = "feedVideoMaxSize";
    private static final String TAG = "OrangeManager";
    private static volatile OrangeManager instance;
    private volatile OrangeBean orangeBean;
    private OrangeInitListener orangeInitListener;

    /* access modifiers changed from: private */
    public void callBack2InitSucc() {
        OrangeInitListener orangeInitListener2 = this.orangeInitListener;
        if (orangeInitListener2 != null) {
            orangeInitListener2.initFinish(this.orangeBean);
        }
    }

    private void checkAndCreateDefaultOrange() {
        try {
            if (this.orangeBean == null) {
                String fromAssets = getFromAssets("orange.json");
                if (!TextUtils.isEmpty(fromAssets)) {
                    this.orangeBean = (OrangeBean) JSON.parseObject(fromAssets, OrangeBean.class);
                    LogUtils.d(TAG, "本地初始orange配置->" + fromAssets);
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e), "");
        }
    }

    /* access modifiers changed from: private */
    public void checkNewConfigRequest(OrangeBean orangeBean2) {
        HashMap<String, String> hashMap;
        if (orangeBean2 == null || (hashMap = orangeBean2.commonSwitch) == null || hashMap.get("useNewConfig") == null) {
            callBack2InitSucc();
        } else if ("true".equalsIgnoreCase(orangeBean2.commonSwitch.get("useNewConfig"))) {
            newConfigRequest();
        }
    }

    /* access modifiers changed from: private */
    public void checkOrangeVersion2Write(OrangeBean orangeBean2, String str) {
        if (this.orangeBean == null || this.orangeBean.version < orangeBean2.version) {
            writeOrange(str);
            this.orangeBean = orangeBean2;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int defaultFeedInteractionParam(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 1
            r4.hashCode()
            r1 = -1
            int r2 = r4.hashCode()
            switch(r2) {
                case -1059030137: goto L_0x0024;
                case 103203022: goto L_0x0019;
                case 1348276389: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            r4 = -1
            goto L_0x002e
        L_0x000e:
            java.lang.String r2 = "allSlideDistance"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x0017
            goto L_0x000c
        L_0x0017:
            r4 = 2
            goto L_0x002e
        L_0x0019:
            java.lang.String r2 = "slideDirection"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x0022
            goto L_0x000c
        L_0x0022:
            r4 = 1
            goto L_0x002e
        L_0x0024:
            java.lang.String r2 = "directionSlideDistance"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x002d
            goto L_0x000c
        L_0x002d:
            r4 = 0
        L_0x002e:
            switch(r4) {
                case 0: goto L_0x0036;
                case 1: goto L_0x0035;
                case 2: goto L_0x0032;
                default: goto L_0x0031;
            }
        L_0x0031:
            return r1
        L_0x0032:
            r4 = 120(0x78, float:1.68E-43)
            return r4
        L_0x0035:
            return r0
        L_0x0036:
            r4 = 55
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.orange.OrangeManager.defaultFeedInteractionParam(java.lang.String):int");
    }

    private boolean diamondConfigParse(String str) {
        HashMap<String, Boolean> hashMap;
        try {
            OrangeBean orangeBean2 = (OrangeBean) JSON.parseObject(str, OrangeBean.class);
            if (!(orangeBean2 == null || (hashMap = orangeBean2.adSwitch) == null)) {
                if (hashMap.size() > 0) {
                    this.orangeBean = orangeBean2;
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private void diamondRequest() {
        new tanxc_do().tanxc_do(new NetWorkCallBack<OrangeBean>() {
            public void error(int i, String str, String str2) {
                LogUtils.e(OrangeManager.TAG, "orange配置拉取失败-> code:" + i + " reqId:" + str + "  error->" + str2);
                OrangeManager.this.callBack2InitSucc();
                StringBuilder sb = new StringBuilder();
                sb.append("orange配置拉取失败-> code:");
                sb.append(i);
                sb.append("  error->");
                sb.append(str2);
                TanxBaseUt.utError(i, OrangeManager.TAG, sb.toString(), "");
            }

            /* renamed from: tanxc_do */
            public void succ(OrangeBean orangeBean) {
                if (orangeBean != null) {
                    OrangeManager.this.checkOrangeVersion2Write(orangeBean, JSON.toJSONString(orangeBean));
                    OrangeManager.this.checkNewConfigRequest(orangeBean);
                }
                LogUtils.d(OrangeManager.TAG, "Orange diamond服务器版本为->" + orangeBean.version);
            }
        });
    }

    public static OrangeManager getInstance() {
        if (instance == null) {
            synchronized (OrangeManager.class) {
                try {
                    if (instance == null) {
                        instance = new OrangeManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private boolean newConfigParse(String str) {
        try {
            this.orangeBean = (OrangeBean) JSON.parseObject(((TanxConfigTableV2) JSON.parseObject(str, TanxConfigTableV2.class)).content, OrangeBean.class);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void newConfigRequest() {
        new ConfigRequest().request(new ConfigRequestBean(), (NetWorkCallBack<TanxConfigTableV2>) new NetWorkCallBack<TanxConfigTableV2>() {
            public void error(int i, String str, String str2) {
                LogUtils.e(OrangeManager.TAG, "newConfigRequest error code:" + i, ",reqId:" + str + ",error:" + str2);
                OrangeManager.this.callBack2InitSucc();
            }

            /* renamed from: tanxc_do */
            public void succ(TanxConfigTableV2 tanxConfigTableV2) {
                try {
                    if (!TextUtils.isEmpty(tanxConfigTableV2.content)) {
                        OrangeBean orangeBean = (OrangeBean) JSON.parseObject(tanxConfigTableV2.content, OrangeBean.class);
                        if (orangeBean != null) {
                            LogUtils.d(OrangeManager.TAG, "Orange 新配置接口服务器版本为->" + orangeBean.version);
                            OrangeManager.this.checkOrangeVersion2Write(orangeBean, JSON.toJSONString(tanxConfigTableV2));
                        } else {
                            LogUtils.e(OrangeManager.TAG, "orangeBean为空");
                        }
                    } else {
                        LogUtils.e(OrangeManager.TAG, "tanxConfigTableV2.content为空");
                        TanxCommonUt.sendNewConfigFail("", -1, UtErrorCode.DATA_PARSE_ERROR.getIntCode(), "tanxConfigTableV2.content为空", "");
                    }
                } catch (Exception e) {
                    UtErrorCode utErrorCode = UtErrorCode.JSON_PARSE_ERROR;
                    int intCode = utErrorCode.getIntCode();
                    TanxCommonUt.sendNewConfigFail("", -1, intCode, "OrangeManager,catch:" + utErrorCode.getMsg(), "");
                    LogUtils.e(OrangeManager.TAG, e);
                }
                OrangeManager.this.callBack2InitSucc();
            }
        });
    }

    private void readLocalOrange() {
        try {
            SharedPreferencesHelper instance2 = SharedPreferencesHelper.getInstance();
            SharedPreferencesHelper.getInstance();
            String string = instance2.getString(SharedPreferencesHelper.KEY_ORANGE);
            if (!TextUtils.isEmpty(string)) {
                if (!diamondConfigParse(string)) {
                    newConfigParse(string);
                }
                LogUtils.d(TAG, "Orange本地版本为->" + this.orangeBean.version);
                LogUtils.d(TAG, "本地orange配置->" + JSON.toJSONString(this.orangeBean));
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e), "");
        }
        checkAndCreateDefaultOrange();
    }

    private void writeOrange(String str) {
        try {
            LogUtils.d(TAG, "覆盖本地orange配置->" + str);
            SharedPreferencesHelper instance2 = SharedPreferencesHelper.getInstance();
            SharedPreferencesHelper.getInstance();
            instance2.putString(SharedPreferencesHelper.KEY_ORANGE, str);
        } catch (Exception e) {
            LogUtils.e(TAG, e);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, LogUtils.getStackTraceMessage(e), "");
        }
    }

    public boolean getAdSwitch(String str) {
        if (this.orangeBean == null || this.orangeBean.adSwitch == null || this.orangeBean.adSwitch.get(str) == null || str == null) {
            return true;
        }
        return this.orangeBean.adSwitch.get(str).booleanValue();
    }

    public boolean getAllAppImageSwitch() {
        if (this.orangeBean == null || this.orangeBean.imageSwitch == null || this.orangeBean.imageSwitch.get("AllApp") == null) {
            return false;
        }
        return this.orangeBean.imageSwitch.get("AllApp").booleanValue();
    }

    public boolean getCommonSwitch(String str) {
        if (this.orangeBean == null || this.orangeBean.commonSwitch == null || this.orangeBean.commonSwitch.get(str) == null) {
            return false;
        }
        return "true".equalsIgnoreCase(this.orangeBean.commonSwitch.get(str));
    }

    public ExposureConfigBean getExposureConfigBean(int i) {
        try {
            if (!(this.orangeBean == null || this.orangeBean.exposureConfig == null || this.orangeBean.exposureConfig.size() <= 0 || TanxCoreSdk.getConfig() == null)) {
                if (!TextUtils.isEmpty(TanxCoreSdk.getConfig().getAppKey())) {
                    ExposureConfigBean exposureConfigBean = null;
                    for (int i2 = 0; i2 < this.orangeBean.exposureConfig.size(); i2++) {
                        if (this.orangeBean.exposureConfig.get(i2).key.equals(TanxCoreSdk.getConfig().getAppKey()) && this.orangeBean.exposureConfig.get(i2).adType == i) {
                            return this.orangeBean.exposureConfig.get(i2);
                        }
                        if (this.orangeBean.exposureConfig.get(i2).key.equals("default") && this.orangeBean.exposureConfig.get(i2).adType == i && exposureConfigBean == null) {
                            exposureConfigBean = this.orangeBean.exposureConfig.get(i2);
                        }
                    }
                    return exposureConfigBean;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public String getFeedInteractionGifUrlParam(String str) {
        if (this.orangeBean == null || this.orangeBean.feedInteractionParam == null) {
            return "https://img.alicdn.com/imgextra/i3/O1CN01yaPRML1GyyqsOZP7R_!!6000000000692-1-tps-1200-432.gif";
        }
        String str2 = this.orangeBean.feedInteractionParam.get(str);
        if (TextUtils.isEmpty(str2)) {
            return "https://img.alicdn.com/imgextra/i3/O1CN01yaPRML1GyyqsOZP7R_!!6000000000692-1-tps-1200-432.gif";
        }
        return str2;
    }

    public int getFeedInteractionParam2Integer(String str) {
        try {
            if (this.orangeBean != null) {
                if (this.orangeBean.feedInteractionParam != null) {
                    String str2 = this.orangeBean.feedInteractionParam.get(str);
                    if (TextUtils.isEmpty(str2)) {
                        return defaultFeedInteractionParam(str);
                    }
                    return Integer.parseInt(str2);
                }
            }
            return defaultFeedInteractionParam(str);
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getFromAssets(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AssetsUtil.getApplicationAssets(TanxCoreSdk.getApplication()).open(str)));
            String str2 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return str2;
                }
                str2 = str2 + readLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean getImageSwitch(String str) {
        if (this.orangeBean == null || this.orangeBean.imageSwitch == null || this.orangeBean.imageSwitch.get(str) == null) {
            return false;
        }
        return this.orangeBean.imageSwitch.get(str).booleanValue();
    }

    public HashMap<String, Boolean> getInstallSwitch() {
        if (this.orangeBean == null || this.orangeBean.installStatusSwitch == null) {
            return new HashMap<>();
        }
        return this.orangeBean.installStatusSwitch;
    }

    public OrangeBean getOrangeBean() {
        return this.orangeBean;
    }

    public long getThreshold(String str) {
        if (this.orangeBean == null || this.orangeBean.threshold == null || this.orangeBean.threshold.get(str) == null) {
            return -1;
        }
        return this.orangeBean.threshold.get(str).longValue();
    }

    public int getUtUploadMaxCount() {
        if (this.orangeBean == null || this.orangeBean.ut == null) {
            return -1;
        }
        return this.orangeBean.ut.uploadMaxCount;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0084 A[Catch:{ Exception -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alimm.tanx.core.orange.bean.WebConfigBean getWebConfigBean() {
        /*
            r4 = this;
            com.alimm.tanx.core.orange.bean.OrangeBean r0 = r4.orangeBean     // Catch:{ Exception -> 0x008a }
            if (r0 == 0) goto L_0x007d
            com.alimm.tanx.core.orange.bean.OrangeBean r0 = r4.orangeBean     // Catch:{ Exception -> 0x008a }
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r0 = r0.webConfigBeanList     // Catch:{ Exception -> 0x008a }
            if (r0 == 0) goto L_0x007d
            com.alimm.tanx.core.orange.bean.OrangeBean r0 = r4.orangeBean     // Catch:{ Exception -> 0x008a }
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r0 = r0.webConfigBeanList     // Catch:{ Exception -> 0x008a }
            int r0 = r0.size()     // Catch:{ Exception -> 0x008a }
            if (r0 <= 0) goto L_0x007d
            com.alimm.tanx.core.config.TanxConfig r0 = com.alimm.tanx.core.TanxCoreSdk.getConfig()     // Catch:{ Exception -> 0x008a }
            if (r0 == 0) goto L_0x007d
            com.alimm.tanx.core.config.TanxConfig r0 = com.alimm.tanx.core.TanxCoreSdk.getConfig()     // Catch:{ Exception -> 0x008a }
            java.lang.String r0 = r0.getAppKey()     // Catch:{ Exception -> 0x008a }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x008a }
            if (r0 == 0) goto L_0x0029
            goto L_0x007d
        L_0x0029:
            r0 = 0
            r1 = 0
        L_0x002b:
            com.alimm.tanx.core.orange.bean.OrangeBean r2 = r4.orangeBean     // Catch:{ Exception -> 0x008a }
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r2 = r2.webConfigBeanList     // Catch:{ Exception -> 0x008a }
            int r2 = r2.size()     // Catch:{ Exception -> 0x008a }
            if (r1 >= r2) goto L_0x0082
            com.alimm.tanx.core.orange.bean.OrangeBean r2 = r4.orangeBean     // Catch:{ Exception -> 0x008a }
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r2 = r2.webConfigBeanList     // Catch:{ Exception -> 0x008a }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x008a }
            com.alimm.tanx.core.orange.bean.WebConfigBean r2 = (com.alimm.tanx.core.orange.bean.WebConfigBean) r2     // Catch:{ Exception -> 0x008a }
            java.lang.String r2 = r2.key     // Catch:{ Exception -> 0x008a }
            com.alimm.tanx.core.config.TanxConfig r3 = com.alimm.tanx.core.TanxCoreSdk.getConfig()     // Catch:{ Exception -> 0x008a }
            java.lang.String r3 = r3.getAppKey()     // Catch:{ Exception -> 0x008a }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x008a }
            if (r2 == 0) goto L_0x005a
            com.alimm.tanx.core.orange.bean.OrangeBean r0 = r4.orangeBean     // Catch:{ Exception -> 0x008a }
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r0 = r0.webConfigBeanList     // Catch:{ Exception -> 0x008a }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x008a }
            com.alimm.tanx.core.orange.bean.WebConfigBean r0 = (com.alimm.tanx.core.orange.bean.WebConfigBean) r0     // Catch:{ Exception -> 0x008a }
            return r0
        L_0x005a:
            com.alimm.tanx.core.orange.bean.OrangeBean r2 = r4.orangeBean     // Catch:{ Exception -> 0x008a }
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r2 = r2.webConfigBeanList     // Catch:{ Exception -> 0x008a }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ Exception -> 0x008a }
            com.alimm.tanx.core.orange.bean.WebConfigBean r2 = (com.alimm.tanx.core.orange.bean.WebConfigBean) r2     // Catch:{ Exception -> 0x008a }
            java.lang.String r2 = r2.key     // Catch:{ Exception -> 0x008a }
            java.lang.String r3 = "default"
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x008a }
            if (r2 == 0) goto L_0x007a
            if (r0 != 0) goto L_0x007a
            com.alimm.tanx.core.orange.bean.OrangeBean r0 = r4.orangeBean     // Catch:{ Exception -> 0x008a }
            java.util.List<com.alimm.tanx.core.orange.bean.WebConfigBean> r0 = r0.webConfigBeanList     // Catch:{ Exception -> 0x008a }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ Exception -> 0x008a }
            com.alimm.tanx.core.orange.bean.WebConfigBean r0 = (com.alimm.tanx.core.orange.bean.WebConfigBean) r0     // Catch:{ Exception -> 0x008a }
        L_0x007a:
            int r1 = r1 + 1
            goto L_0x002b
        L_0x007d:
            com.alimm.tanx.core.orange.bean.WebConfigBean r0 = new com.alimm.tanx.core.orange.bean.WebConfigBean     // Catch:{ Exception -> 0x008a }
            r0.<init>()     // Catch:{ Exception -> 0x008a }
        L_0x0082:
            if (r0 != 0) goto L_0x0089
            com.alimm.tanx.core.orange.bean.WebConfigBean r0 = new com.alimm.tanx.core.orange.bean.WebConfigBean     // Catch:{ Exception -> 0x008a }
            r0.<init>()     // Catch:{ Exception -> 0x008a }
        L_0x0089:
            return r0
        L_0x008a:
            com.alimm.tanx.core.orange.bean.WebConfigBean r0 = new com.alimm.tanx.core.orange.bean.WebConfigBean
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.orange.OrangeManager.getWebConfigBean():com.alimm.tanx.core.orange.bean.WebConfigBean");
    }

    public boolean getWebSuffixWhiteSwitch(String str) {
        if (this.orangeBean == null || this.orangeBean.webSuffixWhiteList == null) {
            String[] strArr = {"com", "cn", "htm", a.f, "php", "tf"};
            for (int i = 0; i < 6; i++) {
                if (strArr[i].equals(str)) {
                    return true;
                }
            }
            return false;
        } else if (this.orangeBean.webSuffixWhiteList.get(str) == null) {
            return false;
        } else {
            return this.orangeBean.webSuffixWhiteList.get(str).booleanValue();
        }
    }

    public void init() {
        init((OrangeInitListener) null);
    }

    public void init(OrangeInitListener orangeInitListener2) {
        this.orangeInitListener = orangeInitListener2;
        readLocalOrange();
        diamondRequest();
    }
}
