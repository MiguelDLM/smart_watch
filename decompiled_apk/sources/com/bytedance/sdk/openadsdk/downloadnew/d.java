package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.a.e;
import com.bytedance.sdk.openadsdk.api.a.f;
import com.bytedance.sdk.openadsdk.api.a.g;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.d;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o0.xXxxox0I;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class d implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f10764a;
    private final Context b;
    private AdDownloadModel.Builder c;
    private AdDownloadModel d;
    private AdDownloadController.Builder e;
    private AdDownloadController f;
    private AdDownloadEventConfig.Builder g;
    private AdDownloadEventConfig h;

    private d(Context context) {
        this.b = context;
    }

    private static boolean a(IDownloadButtonClickListener iDownloadButtonClickListener) {
        return iDownloadButtonClickListener != null;
    }

    private int av() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getDownloadMode();
    }

    private void b(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        AdDownloadModel.Builder a2 = a(((Long) map.get("id")).longValue(), (String) map.get(TTDownloadField.TT_APP_ICON), ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue(), (String) map.get(TTDownloadField.TT_LOG_EXTRA), (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON), (JSONObject) map.get(TTDownloadField.TT_DOWNLOAD_SETTINGS), (String) map.get("filePath"), (String) map.get(TTDownloadField.TT_DOWNLOAD_URL), (String) map.get("appName"), (String) map.get("packageName"), ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue(), (String) map.get(TTDownloadField.TT_OPEN_URL), (String) map.get(TTDownloadField.TT_WEB_TITLE), (String) map.get(TTDownloadField.TT_WEB_URL));
        this.c = a2;
        this.d = a2.build();
    }

    private DownloadStatusChangeListener c(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        if (obj instanceof EventListener) {
            return new e((EventListener) obj);
        }
        return null;
    }

    private DownloadModel d(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    private DownloadEventConfig e(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    private DownloadController f(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private Activity g(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private ExitInstallListener h(Object obj) {
        if (obj instanceof ExitInstallListener) {
            return (ExitInstallListener) obj;
        }
        return null;
    }

    private OnItemClickListener i(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new g((EventListener) obj);
        }
        return null;
    }

    private IDownloadButtonClickListener j(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new f((EventListener) obj);
        }
        return null;
    }

    public int A() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return 0;
        }
        return adDownloadEventConfig.getDownloadScene();
    }

    public boolean B() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return true;
        }
        return adDownloadEventConfig.isEnableClickEvent();
    }

    public boolean C() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return false;
        }
        return adDownloadEventConfig.isEnableV3Event();
    }

    public JSONObject D() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraJson();
    }

    public JSONObject E() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getParamsJson();
    }

    public long F() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getId();
    }

    public String G() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getMd5();
    }

    public long H() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExpectFileLength();
    }

    public long I() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExtraValue();
    }

    public String J() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getDownloadUrl();
    }

    public List<String> K() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getBackupUrls();
    }

    public String L() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getNotificationJumpUrl();
    }

    public String M() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getName();
    }

    public String N() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getMimeType();
    }

    public Map<String, String> O() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getHeaders();
    }

    public boolean P() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowToast();
    }

    public boolean Q() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowNotification();
    }

    public boolean R() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isNeedWifi();
    }

    public boolean S() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public boolean T() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public String U() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getFilePath();
    }

    public String V() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getFileName();
    }

    public void W() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceWifi();
    }

    public JSONObject X() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDownloadSettings();
    }

    public void Y() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideToast();
    }

    public void Z() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideNotification();
    }

    public boolean aa() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.needIndependentProcess();
    }

    public int ab() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getVersionCode();
    }

    public String ac() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getVersionName();
    }

    public boolean ad() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAd();
    }

    public String ae() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getLogExtra();
    }

    public String af() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getPackageName();
    }

    public String ag() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getAppIcon();
    }

    public DeepLink ah() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDeepLink();
    }

    public List<String> ai() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getClickTrackUrl();
    }

    public JSONObject aj() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getExtra();
    }

    public int ak() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getModelType();
    }

    public com.ss.android.download.api.model.d al() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getQuickAppModel();
    }

    public boolean am() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.autoInstallWithoutNotification();
    }

    public boolean an() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return com.ss.android.download.api.c.b.a(com.ss.android.socialbase.downloader.g.a.a(X()), N());
        }
        return adDownloadModel.shouldDownloadWithPatchApply();
    }

    public int ao() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return 2;
        }
        return adDownloadModel.getExecutorGroup();
    }

    public int ap() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return 1;
        }
        return adDownloadModel.getFunnelType();
    }

    public String aq() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getStartToast();
    }

    public String ar() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return "";
        }
        return adDownloadModel.getStartToast();
    }

    public boolean as() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAutoInstall();
    }

    public boolean at() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.distinctDir();
    }

    public boolean au() {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.enablePause();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Map<String, Object> hashMap;
        if (i == 20) {
            a((Bundle) valueSet.objectValue(0, Bundle.class));
            return null;
        }
        if (valueSet != null && valueSet.objectValue(0, Map.class) != null) {
            hashMap = (Map) valueSet.objectValue(0, Map.class);
        } else {
            hashMap = new HashMap<>();
        }
        return (T) a(cls, i, hashMap);
    }

    public boolean k() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableShowComplianceDialog();
    }

    public boolean l() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAutoDownloadOnCardShow();
    }

    public boolean m() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableNewActivity();
    }

    public boolean n() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAH();
    }

    public boolean o() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAM();
    }

    public boolean p() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableOppoAutoDownload();
    }

    public String q() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return "";
        }
        return adDownloadEventConfig.getRefer();
    }

    public String r() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return "";
        }
        return adDownloadEventConfig.getClickButtonTag();
    }

    public String s() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return "";
        }
        return adDownloadEventConfig.getClickItemTag();
    }

    public String t() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return "";
        }
        return adDownloadEventConfig.getClickLabel();
    }

    public String u() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return "";
        }
        return adDownloadEventConfig.getClickStartLabel();
    }

    public String v() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return "";
        }
        return adDownloadEventConfig.getClickPauseLabel();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return xXxxox0I.oIX0oI().II0XooXoX(0, c.f10755a).Oxx0IOOO(1, Boolean.valueOf(c.b)).X0o0xo(10000, 3).OOXIXo();
    }

    public String w() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return "";
        }
        return adDownloadEventConfig.getClickPauseLabel();
    }

    public String x() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return "";
        }
        return adDownloadEventConfig.getClickInstallLabel();
    }

    public String y() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return "";
        }
        return adDownloadEventConfig.getStorageDenyLabel();
    }

    public Object z() {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraEventObject();
    }

    public static d a(Context context) {
        if (f10764a == null) {
            synchronized (d.class) {
                try {
                    if (f10764a == null) {
                        f10764a = new d(context);
                    }
                } finally {
                }
            }
        }
        return f10764a;
    }

    private void d(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG);
        String str2 = (String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG);
        String str3 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_START);
        String str4 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_CONTINUE);
        String str5 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_PAUSE);
        String str6 = (String) map.get(TTDownloadField.TT_LABEL_STORAGE_DENY);
        String str7 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_INSTALL);
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        AdDownloadEventConfig.Builder isEnableV3Event = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickStartLabel(str3).setClickContinueLabel(str4).setClickPauseLabel(str5).setStorageDenyLabel(str6).setClickInstallLabel(str7).setIsEnableClickEvent(booleanValue).setIsEnableV3Event(booleanValue2);
        this.g = isEnableV3Event;
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.h = this.g.build();
    }

    private void e(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = (String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG);
        String str2 = (String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG);
        String str3 = (String) map.get(TTDownloadField.TT_CLICK_LABEL);
        int intValue = ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_SCENE)).intValue();
        String str4 = (String) map.get(TTDownloadField.TT_REFER);
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        JSONObject jSONObject2 = (JSONObject) map.get(TTDownloadField.TT_PARAMS_JSON);
        String str5 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_START);
        String str6 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_CONTINUE);
        String str7 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_PAUSE);
        String str8 = (String) map.get(TTDownloadField.TT_LABEL_STORAGE_DENY);
        String str9 = (String) map.get(TTDownloadField.TT_LABEL_CLICK_INSTALL);
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        JSONObject jSONObject3 = (JSONObject) map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        AdDownloadEventConfig.Builder paramsJson = new AdDownloadEventConfig.Builder().setClickButtonTag(str).setClickItemTag(str2).setClickLabel(str3).setClickStartLabel(str5).setClickContinueLabel(str6).setClickPauseLabel(str7).setStorageDenyLabel(str8).setClickInstallLabel(str9).setIsEnableClickEvent(booleanValue).setDownloadScene(intValue).setIsEnableV3Event(booleanValue2).setRefer(str4).setExtraJson(jSONObject).setParamsJson(jSONObject2);
        this.g = paramsJson;
        if (jSONObject3 != null) {
            paramsJson.setExtraEventObject(jSONObject3);
        }
        this.h = this.g.build();
    }

    private void f(int i) {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setDownloadMode(i);
    }

    public boolean g() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.shouldUseNewWebView();
    }

    public int h() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getInterceptFlag();
    }

    public AdDownloadModel k(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAppIcon(str);
    }

    public AdDownloadModel l(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setDownloadUrl(str);
    }

    public AdDownloadModel m(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNotificationJumpUrl(str);
    }

    public AdDownloadModel n(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setMimeType(str);
    }

    public AdDownloadModel o(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFilePath(str);
    }

    public AdDownloadModel p(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFileName(str);
    }

    public AdDownloadModel q(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionName(str);
    }

    private void c(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int intValue = ((Integer) map.get(TTDownloadField.TT_LINK_MODE)).intValue();
        int intValue2 = ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue();
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_BACK_DIALOG)).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ADD_TO_DOWNLOAD_MANAGE)).booleanValue();
        Object obj = map.get(TTDownloadField.TT_EXTRA_OPERATION);
        boolean booleanValue3 = ((Boolean) map.get(TTDownloadField.TT_SHOULD_USE_NEW_WEB_VIEW)).booleanValue();
        int intValue3 = ((Integer) map.get(TTDownloadField.TT_INTERCEPT_FLAG)).intValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        Object obj2 = map.get(TTDownloadField.TT_EXTRA_OBJECT);
        boolean booleanValue4 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue();
        boolean booleanValue7 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AH)).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AM)).booleanValue();
        AdDownloadController.Builder enableOppoAutoDownload = new AdDownloadController.Builder().setLinkMode(intValue).setDownloadMode(intValue2).setIsEnableBackDialog(booleanValue).setIsAddToDownloadManage(booleanValue2).setExtraOperation(obj).setShouldUseNewWebView(booleanValue3).setInterceptFlag(intValue3).setExtraJson(jSONObject).setExtraObject(obj2).setEnableShowComplianceDialog(booleanValue4).setIsAutoDownloadOnCardShow(booleanValue5).setEnableNewActivity(booleanValue6).setEnableAH(booleanValue7).setEnableAM(booleanValue8).setEnableOppoAutoDownload(((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue());
        this.e = enableOppoAutoDownload;
        this.f = enableOppoAutoDownload.build();
    }

    public int f() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return 1;
        }
        return adDownloadController.getDowloadChunkCount();
    }

    public void g(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setStartToast(str);
    }

    public void h(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setSdkMonitorScene(str);
    }

    public JSONObject i() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraJson();
    }

    public Object j() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraObject();
    }

    private void f(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long longValue = ((Long) map.get(TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue();
        String str = (String) map.get("md5");
        long longValue2 = ((Long) map.get(TTDownloadField.TT_EXTRA_VALUE)).longValue();
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_AD)).booleanValue();
        int intValue = ((Integer) map.get(TTDownloadField.TT_MODEL_TYPE)).intValue();
        List<String> list = (List) map.get(TTDownloadField.TT_CLICK_TRACK_URL);
        List<String> list2 = (List) map.get(TTDownloadField.TT_BACK_UP_URLS);
        String str2 = (String) map.get(TTDownloadField.TT_NOTIFICATION_JUMP_URL);
        String str3 = (String) map.get(TTDownloadField.TT_MIME_TYPE);
        Map<String, String> map2 = (Map) map.get(TTDownloadField.TT_HEADERS);
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue();
        boolean booleanValue3 = ((Boolean) map.get(TTDownloadField.TT_NEED_WIFI)).booleanValue();
        String str4 = (String) map.get(TTDownloadField.TT_FILE_NAME);
        int intValue2 = ((Integer) map.get("versionCode")).intValue();
        String str5 = (String) map.get(TTDownloadField.TT_VERSION_NAME);
        String str6 = (String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL);
        com.ss.android.download.api.model.d a2 = new d.a().a(str6).b((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).a();
        int intValue3 = ((Integer) map.get(TTDownloadField.TT_EXECUTOR_GROUP)).intValue();
        String str7 = (String) map.get(TTDownloadField.TT_START_TOAST);
        String str8 = (String) map.get(TTDownloadField.TT_SDK_MONITOR_SCENE);
        boolean booleanValue4 = ((Boolean) map.get(TTDownloadField.TT_AUTO_INSTALL)).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get(TTDownloadField.TT_DISTINCT_DIR)).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_PAUSE)).booleanValue();
        long longValue3 = ((Long) map.get("id")).longValue();
        String str9 = (String) map.get(TTDownloadField.TT_APP_ICON);
        boolean booleanValue7 = ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue();
        String str10 = (String) map.get(TTDownloadField.TT_LOG_EXTRA);
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        JSONObject jSONObject2 = (JSONObject) map.get(TTDownloadField.TT_DOWNLOAD_SETTINGS);
        String str11 = (String) map.get("filePath");
        String str12 = (String) map.get(TTDownloadField.TT_DOWNLOAD_URL);
        String str13 = (String) map.get("appName");
        String str14 = (String) map.get("packageName");
        boolean booleanValue9 = ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue();
        String str15 = (String) map.get(TTDownloadField.TT_OPEN_URL);
        String str16 = (String) map.get(TTDownloadField.TT_WEB_TITLE);
        String str17 = (String) map.get(TTDownloadField.TT_WEB_URL);
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(longValue).setMd5(str).setId(longValue3).setExtraValue(longValue2).setIsAd(booleanValue).setModelType(intValue).setLogExtra(str10).setAppIcon(str9).setBackupUrls(list2).setNotificationJumpUrl(str2).setClickTrackUrl(list).setMimeType(str3).setHeaders(map2).setIsShowToast(booleanValue2).setIsShowNotification(booleanValue7).setNeedWifi(booleanValue3).setFileName(str4).setVersionCode(intValue2).setVersionName(str5).setQuickAppModel(a2).setAutoInstallWithoutNotification(booleanValue8).setExecutorGroup(intValue3).setStartToast(str7).setSdkMonitorScene(str8).setAutoInstall(booleanValue4).setDistinctDir(booleanValue5).setEnablePause(booleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.2
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str18, String str19) {
                return null;
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str11)) {
            fileUriProvider.setFilePath(str11);
        }
        if (!TextUtils.isEmpty(str12)) {
            fileUriProvider.setDownloadUrl(str12);
        }
        if (!TextUtils.isEmpty(str13)) {
            fileUriProvider.setAppName(str13);
        }
        if (!TextUtils.isEmpty(str14)) {
            fileUriProvider.setPackageName(str14);
        }
        fileUriProvider.setNeedIndependentProcess(booleanValue9);
        fileUriProvider.setDeepLink(a(longValue3, str15, str16, str17));
        this.d = this.c.build();
    }

    private void j(boolean z) {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return;
        }
        try {
            adDownloadController.setEnableOppoAutoDownload(z);
        } catch (Throwable unused) {
        }
    }

    public AdDownloadModel g(boolean z) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsShowNotification(z);
    }

    public AdDownloadModel h(boolean z) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNeedIndependentProcess(z);
    }

    public AdDownloadModel i(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setLogExtra(str);
    }

    public <T> T a(Class<T> cls, int i, Map<String, Object> map) {
        DownloadModel d;
        DownloadModel d2;
        DownloadEventConfig e;
        DownloadController f;
        DownloadModel d3;
        DownloadEventConfig e2;
        DownloadController f2;
        DownloadEventConfig e3;
        DownloadController f3;
        DownloadEventConfig e4;
        DownloadController f4;
        switch (i) {
            case 0:
                return (T) Boolean.valueOf(c.a(g(map.get(TTDownloadField.TT_ACTIVITY)), h(map.get(TTDownloadField.TT_EXIT_INSTALL_LISTENER))));
            case 1:
                return (T) c.a().f();
            case 2:
                try {
                    return (T) Boolean.valueOf(c.a((String) map.get(TTDownloadField.TT_TAG_INTERCEPT), (String) map.get(TTDownloadField.TT_LABEL), new JSONObject((String) map.get(TTDownloadField.TT_META)), new HashMap()));
                } catch (JSONException unused) {
                    return (T) Boolean.FALSE;
                }
            case 3:
                c.a(((Integer) map.get(TTDownloadField.TT_HID)).intValue());
                return null;
            case 4:
                AdDownloadModel adDownloadModel = this.d;
                c.a().a(adDownloadModel == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel.getDownloadUrl(), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue());
                return null;
            case 5:
                int intValue = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                AdDownloadModel adDownloadModel2 = this.d;
                if (adDownloadModel2 == null) {
                    d = d(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    d = d(adDownloadModel2);
                }
                c.a().a(this.b, intValue, c(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER)), d);
                return null;
            case 6:
                AdDownloadModel adDownloadModel3 = this.d;
                return (T) Boolean.valueOf(c.a(this.b, adDownloadModel3 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel3.getDownloadUrl()));
            case 7:
                c.b();
                return null;
            case 8:
                AdDownloadModel adDownloadModel4 = this.d;
                c.a().a(adDownloadModel4 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel4.getDownloadUrl(), ((Boolean) map.get(TTDownloadField.TT_FORCE)).booleanValue());
                return null;
            case 9:
                c.a(((Integer) map.get("id")).intValue(), (ITTDownloadAdapter.OnEventLogHandler) map.get(TTDownloadField.TT_ONEVENT_LOG_HANDLER));
                return null;
            case 10:
                c.a((String) map.get(TTDownloadField.TT_DOWNLOAD_PATH));
                return null;
            case 11:
            case 20:
            case 21:
            case 22:
            case 43:
            case 77:
            case 126:
            case 138:
            default:
                return null;
            case 12:
                Uri uri = (Uri) map.get("uri");
                AdDownloadModel adDownloadModel5 = this.d;
                if (adDownloadModel5 == null) {
                    d2 = d(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    d2 = d(adDownloadModel5);
                }
                AdDownloadEventConfig adDownloadEventConfig = this.h;
                if (adDownloadEventConfig == null) {
                    e = e(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    e = e(adDownloadEventConfig);
                }
                AdDownloadController adDownloadController = this.f;
                if (adDownloadController == null) {
                    f = f(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    f = f(adDownloadController);
                }
                IDownloadButtonClickListener j = j(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (a(j)) {
                    return (T) Boolean.valueOf(c.a(this.b, uri, d2, e, f, j));
                }
                return (T) Boolean.valueOf(c.a(this.b, uri, d2, e, f));
            case 13:
                int intValue2 = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_DISABLE_DIALOG)).booleanValue();
                String str = (String) map.get(TTDownloadField.TT_USERAGENT);
                AdDownloadModel adDownloadModel6 = this.d;
                if (adDownloadModel6 == null) {
                    d3 = d(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    d3 = d(adDownloadModel6);
                }
                DownloadModel downloadModel = d3;
                AdDownloadEventConfig adDownloadEventConfig2 = this.h;
                if (adDownloadEventConfig2 == null) {
                    e2 = e(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    e2 = e(adDownloadEventConfig2);
                }
                DownloadEventConfig downloadEventConfig = e2;
                AdDownloadController adDownloadController2 = this.f;
                if (adDownloadController2 == null) {
                    f2 = f(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    f2 = f(adDownloadController2);
                }
                DownloadController downloadController = f2;
                DownloadStatusChangeListener c = c(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER));
                IDownloadButtonClickListener j2 = j(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (a(j2)) {
                    c.a().e().a(this.b, str, booleanValue, downloadModel, downloadEventConfig, downloadController, c, intValue2, j2);
                    return null;
                }
                c.a().e().a(this.b, str, booleanValue, downloadModel, downloadEventConfig, downloadController, c, intValue2);
                return null;
            case 14:
                AdDownloadModel adDownloadModel7 = this.d;
                long longValue = adDownloadModel7 == null ? ((Long) map.get("id")).longValue() : adDownloadModel7.getId();
                AdDownloadModel adDownloadModel8 = this.d;
                return (T) Boolean.valueOf(c.a().e().a(this.b, longValue, adDownloadModel8 == null ? (String) map.get(TTDownloadField.TT_LOG_EXTRA) : adDownloadModel8.getLogExtra(), (DownloadStatusChangeListener) null, ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue()));
            case 15:
                return (T) Boolean.valueOf(c.a((Uri) map.get("uri")));
            case 16:
                AdDownloadModel adDownloadModel9 = this.d;
                String downloadUrl = adDownloadModel9 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel9.getDownloadUrl();
                AdDownloadModel adDownloadModel10 = this.d;
                long longValue2 = adDownloadModel10 == null ? ((Long) map.get("id")).longValue() : adDownloadModel10.getId();
                int intValue3 = ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                AdDownloadEventConfig adDownloadEventConfig3 = this.h;
                if (adDownloadEventConfig3 == null) {
                    e3 = e(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    e3 = e(adDownloadEventConfig3);
                }
                DownloadEventConfig downloadEventConfig2 = e3;
                AdDownloadController adDownloadController3 = this.f;
                if (adDownloadController3 == null) {
                    f3 = f(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    f3 = f(adDownloadController3);
                }
                c.a().a(downloadUrl, longValue2, intValue3, downloadEventConfig2, f3);
                return null;
            case 17:
                AdDownloadModel adDownloadModel11 = this.d;
                String downloadUrl2 = adDownloadModel11 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel11.getDownloadUrl();
                long longValue3 = ((Long) map.get("id")).longValue();
                int intValue4 = ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                AdDownloadEventConfig adDownloadEventConfig4 = this.h;
                if (adDownloadEventConfig4 == null) {
                    e4 = e(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    e4 = e(adDownloadEventConfig4);
                }
                DownloadEventConfig downloadEventConfig3 = e4;
                AdDownloadController adDownloadController4 = this.f;
                if (adDownloadController4 == null) {
                    f4 = f(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    f4 = f(adDownloadController4);
                }
                c.a().a(downloadUrl2, longValue3, intValue4, downloadEventConfig3, f4, i(map.get(TTDownloadField.TT_ITEM_CLICK_LISTENER)), j(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER)));
                return null;
            case 18:
                AdDownloadModel adDownloadModel12 = this.d;
                return (T) Boolean.valueOf(c.a().e().a(adDownloadModel12 == null ? ((Long) map.get("id")).longValue() : adDownloadModel12.getId(), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue()));
            case 19:
                AdDownloadModel adDownloadModel13 = this.d;
                return (T) Boolean.valueOf(c.a().e().a(adDownloadModel13 == null ? ((Long) map.get("id")).longValue() : adDownloadModel13.getId()));
            case 23:
                if (((Boolean) map.get(TTDownloadField.TT_MATE_IS_EMPTY)).booleanValue()) {
                    AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                    this.c = builder;
                    this.d = builder.build();
                    return null;
                }
                b(map);
                return null;
            case 24:
                a((String) map.get(TTDownloadField.TT_APP_ICON), (String) map.get("appName"), (String) map.get("packageName"));
                return null;
            case 25:
                a(((Integer) map.get(TTDownloadField.TT_AUTO_OPEN)).intValue(), ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue(), ((Boolean) map.get(TTDownloadField.TT_IS_HAVE_DOWNLOAD_SDK_CONFIG)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AH)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AM)).booleanValue());
                return null;
            case 26:
                f(((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue());
                return null;
            case 27:
                return (T) Integer.valueOf(av());
            case 28:
                j(((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue());
                return null;
            case 29:
                d(map);
                return null;
            case 30:
                b(((Integer) map.get(TTDownloadField.TT_DOWNLOAD_SCENE)).intValue());
                return null;
            case 31:
                e(((Boolean) map.get(TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue());
                return null;
            case 32:
                c(map);
                return null;
            case 33:
                return (T) Integer.valueOf(a());
            case 34:
                return (T) Boolean.valueOf(b());
            case 35:
                return (T) Boolean.valueOf(c());
            case 36:
                return (T) d();
            case 37:
                return (T) Boolean.valueOf(e());
            case 38:
                return (T) Integer.valueOf(f());
            case 39:
                return (T) Boolean.valueOf(g());
            case 40:
                return (T) Integer.valueOf(h());
            case 41:
                return (T) i();
            case 42:
                return (T) j();
            case 44:
                a(((Integer) map.get(TTDownloadField.TT_LINK_MODE)).intValue());
                return null;
            case 45:
                return (T) Boolean.valueOf(k());
            case 46:
                a(((Boolean) map.get(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue());
                return null;
            case 47:
                return (T) Boolean.valueOf(l());
            case 48:
                return (T) Boolean.valueOf(m());
            case 49:
                b(((Boolean) map.get(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue());
                return null;
            case 50:
                c(((Boolean) map.get(TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue());
                return null;
            case 51:
                return (T) Boolean.valueOf(n());
            case 52:
                return (T) Boolean.valueOf(o());
            case 53:
                a(map.get(TTDownloadField.TT_EXTRA_OBJECT));
                return null;
            case 54:
                a((JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON));
                return null;
            case 55:
                return (T) Boolean.valueOf(p());
            case 56:
                e(map);
                return null;
            case 57:
                return (T) String.valueOf(q());
            case 58:
                return (T) String.valueOf(r());
            case 59:
                return (T) String.valueOf(s());
            case 60:
                return (T) String.valueOf(t());
            case 61:
                return (T) String.valueOf(u());
            case 62:
                return (T) String.valueOf(v());
            case 63:
                return (T) String.valueOf(w());
            case 64:
                return (T) String.valueOf(x());
            case 65:
                return (T) String.valueOf(y());
            case 66:
                return (T) z();
            case 67:
                return (T) Integer.valueOf(A());
            case 68:
                return (T) Boolean.valueOf(B());
            case 69:
                return (T) Boolean.valueOf(C());
            case 70:
                return (T) D();
            case 71:
                return (T) E();
            case 72:
                b(map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT));
                return null;
            case 73:
                a((String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG));
                return null;
            case 74:
                b((JSONObject) map.get(TTDownloadField.TT_EVENT_CONFIG_EXTRA_JSON));
                return null;
            case 75:
                c((JSONObject) map.get(TTDownloadField.TT_PARAMS_JSON));
                return null;
            case 76:
                b((String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG));
                return null;
            case 78:
                c((String) map.get(TTDownloadField.TT_REFER));
                return null;
            case 79:
                d((String) map.get(TTDownloadField.TT_QUICK_APP_EVENT_TAG));
                return null;
            case 80:
                f(map);
                return null;
            case 81:
                return (T) Long.valueOf(F());
            case 82:
                return (T) String.valueOf(G());
            case 83:
                return (T) Long.valueOf(H());
            case 84:
                return (T) Long.valueOf(I());
            case 85:
                return (T) String.valueOf(J());
            case 86:
                return (T) K();
            case 87:
                return (T) String.valueOf(L());
            case 88:
                return (T) String.valueOf(M());
            case 89:
                return (T) String.valueOf(N());
            case 90:
                return (T) O();
            case 91:
                return (T) Boolean.valueOf(P());
            case 92:
                return (T) Boolean.valueOf(Q());
            case 93:
                return (T) Boolean.valueOf(R());
            case 94:
                return (T) Boolean.valueOf(S());
            case 95:
                return (T) Boolean.valueOf(T());
            case 96:
                return (T) String.valueOf(U());
            case 97:
                return (T) String.valueOf(V());
            case 98:
                W();
                return null;
            case 99:
                return (T) X();
            case 100:
                Y();
                return null;
            case 101:
                Z();
                return null;
            case 102:
                return (T) Boolean.valueOf(aa());
            case 103:
                return (T) Integer.valueOf(ab());
            case 104:
                return (T) String.valueOf(ac());
            case 105:
                return (T) Boolean.valueOf(ad());
            case 106:
                return (T) String.valueOf(ae());
            case 107:
                return (T) String.valueOf(af());
            case 108:
                return (T) String.valueOf(ag());
            case 109:
                return (T) ah();
            case 110:
                return (T) ai();
            case 111:
                return (T) aj();
            case 112:
                return (T) Integer.valueOf(ak());
            case 113:
                return (T) al();
            case 114:
                return (T) Boolean.valueOf(am());
            case 115:
                return (T) Boolean.valueOf(an());
            case 116:
                return (T) Integer.valueOf(ao());
            case 117:
                return (T) Integer.valueOf(ap());
            case 118:
                return (T) String.valueOf(aq());
            case 119:
                return (T) String.valueOf(ar());
            case 120:
                return (T) Boolean.valueOf(as());
            case 121:
                return (T) Boolean.valueOf(at());
            case 122:
                return (T) Boolean.valueOf(au());
            case 123:
                e((String) map.get("md5"));
                return null;
            case 124:
                a(((Long) map.get(TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue());
                return null;
            case 125:
                d(((Boolean) map.get(TTDownloadField.TT_NEED_WIFI)).booleanValue());
                return null;
            case 127:
                b(((Long) map.get(TTDownloadField.TT_EXTRA_VALUE)).longValue());
                return null;
            case 128:
                f((String) map.get("appName"));
                return null;
            case 129:
                d((JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON));
                return null;
            case 130:
                g((String) map.get(TTDownloadField.TT_START_TOAST));
                return null;
            case 131:
                h((String) map.get(TTDownloadField.TT_SDK_MONITOR_SCENE));
                return null;
            case 132:
                c(((Long) map.get("id")).longValue());
                return null;
            case 133:
                f(((Boolean) map.get(TTDownloadField.TT_IS_AD)).booleanValue());
                return null;
            case 134:
                c(((Integer) map.get(TTDownloadField.TT_MODEL_TYPE)).intValue());
                return null;
            case 135:
                i((String) map.get(TTDownloadField.TT_LOG_EXTRA));
                return null;
            case 136:
                j((String) map.get("packageName"));
                return null;
            case 137:
                k((String) map.get(TTDownloadField.TT_APP_ICON));
                return null;
            case 139:
                a((List<String>) map.get(TTDownloadField.TT_CLICK_TRACK_URL));
                return null;
            case 140:
                l((String) map.get(TTDownloadField.TT_DOWNLOAD_URL));
                return null;
            case 141:
                b((List<String>) map.get(TTDownloadField.TT_BACK_UP_URLS));
                return null;
            case 142:
                m((String) map.get(TTDownloadField.TT_NOTIFICATION_JUMP_URL));
                return null;
            case 143:
                n((String) map.get(TTDownloadField.TT_MIME_TYPE));
                return null;
            case 144:
                a((Map<String, String>) map.get(TTDownloadField.TT_HEADERS));
                return null;
            case 145:
                g(((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue());
                return null;
            case 146:
                o((String) map.get("filePath"));
                return null;
            case 147:
                p((String) map.get(TTDownloadField.TT_FILE_NAME));
                return null;
            case 148:
                h(((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue());
                return null;
            case 149:
                d(((Integer) map.get("versionCode")).intValue());
                return null;
            case 150:
                q((String) map.get(TTDownloadField.TT_VERSION_NAME));
                return null;
            case 151:
                a(new d.a().a((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL)).b((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).a());
                return null;
            case 152:
                i(((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue());
                return null;
            case 153:
                e(((Integer) map.get(TTDownloadField.TT_FUNNEL_TYPE)).intValue());
                return null;
        }
    }

    public AdDownloadModel i(boolean z) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAutoInstallWithoutNotification(z);
    }

    public AdDownloadModel j(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setPackageName(str);
    }

    public boolean b() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableBackDialog();
    }

    public void b(boolean z) {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setIsAutoDownloadOnCardShow(z);
    }

    public void b(Object obj) {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraEventObject(obj);
    }

    public void b(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraJson(jSONObject);
    }

    public Object d() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraClickOperation();
    }

    public void b(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickItemTag(str);
    }

    public void d(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setQuickAppEventTag(str);
    }

    public void b(int i) {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setDownloadScene(i);
    }

    public void d(boolean z) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setNeedWifi(z);
    }

    public void b(long j) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtraValue(j);
    }

    public void d(JSONObject jSONObject) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtra(jSONObject);
    }

    public AdDownloadModel b(List<String> list) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setBackupUrls(list);
    }

    public AdDownloadModel d(int i) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionCode(i);
    }

    public boolean e() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableMultipleDownload();
    }

    public boolean c() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAddToDownloadManage();
    }

    public void e(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setMd5(str);
    }

    public void c(boolean z) {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableNewActivity(z);
    }

    public void e(boolean z) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setIsShowToast(z);
    }

    public void c(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setParamsJson(jSONObject);
    }

    public AdDownloadModel e(int i) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFunnelType(i);
    }

    public void c(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setRefer(str);
    }

    public AdDownloadModel c(long j) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setId(j);
    }

    public AdDownloadModel c(int i) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setModelType(i);
    }

    public void f(String str) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setAppName(str);
    }

    public AdDownloadModel f(boolean z) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsAd(z);
    }

    public void a(Bundle bundle) {
        c.a(this.b);
    }

    private AdDownloadModel.Builder a(long j, String str, boolean z, boolean z2, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z3, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j).setAppIcon(str).setIsShowNotification(z).setAutoInstallWithoutNotification(z2).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.1
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str10, String str11) {
                return null;
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fileUriProvider.setFilePath(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            fileUriProvider.setDownloadUrl(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            fileUriProvider.setAppName(str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            fileUriProvider.setPackageName(str6);
        }
        fileUriProvider.setNeedIndependentProcess(z3);
        fileUriProvider.setDeepLink(a(j, str7, str8, str9));
        return fileUriProvider;
    }

    private DeepLink a(long j, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private void a(String str, String str2, String str3) {
        AdDownloadModel.Builder builder = this.c;
        if (builder == null) {
            return;
        }
        this.d = builder.setAppIcon(str).setAppName(str2).setPackageName(str3).build();
    }

    private void a(int i, int i2, boolean z, boolean z2, boolean z3) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i).setDownloadMode(i2).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.e = isAddToDownloadManage;
        if (z) {
            isAddToDownloadManage.setEnableAH(z2);
            this.e.setEnableAM(z3);
        }
        this.f = this.e.build();
    }

    public int a() {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getLinkMode();
    }

    public void a(int i) {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setLinkMode(i);
    }

    public void a(boolean z) {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableShowComplianceDialog(z);
    }

    public void a(Object obj) {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraObject(obj);
    }

    public void a(JSONObject jSONObject) {
        AdDownloadController adDownloadController = this.f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraJson(jSONObject);
    }

    public void a(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.h;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickButtonTag(str);
    }

    public void a(long j) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExpectFileLength(j);
    }

    public AdDownloadModel a(List<String> list) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setClickTrackUrl(list);
    }

    public AdDownloadModel a(Map<String, String> map) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setHeaders(map);
    }

    public AdDownloadModel a(com.ss.android.download.api.model.d dVar) {
        AdDownloadModel adDownloadModel = this.d;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setQuickAppModel(dVar);
    }
}
