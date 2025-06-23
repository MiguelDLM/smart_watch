package com.bytedance.sdk.openadsdk.api.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.List;
import java.util.Map;
import o0.xXxxox0I;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class c implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private DownloadModel f10664a;

    public c(DownloadModel downloadModel) {
        this.f10664a = downloadModel;
    }

    public String A() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getPackageName();
        }
        return null;
    }

    public String B() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getAppIcon();
        }
        return null;
    }

    public DeepLink C() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getDeepLink();
        }
        return null;
    }

    public List<String> D() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getClickTrackUrl();
        }
        return null;
    }

    public JSONObject E() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getExtra();
        }
        return null;
    }

    public int F() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getModelType();
        }
        return 0;
    }

    public com.ss.android.download.api.model.d G() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getQuickAppModel();
        }
        return null;
    }

    public boolean H() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.autoInstallWithoutNotification();
        }
        return false;
    }

    public IDownloadFileUriProvider I() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getDownloadFileUriProvider();
        }
        return null;
    }

    public boolean J() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.shouldDownloadWithPatchApply();
        }
        return false;
    }

    public int K() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getExecutorGroup();
        }
        return 0;
    }

    public int L() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getFunnelType();
        }
        return 0;
    }

    public String M() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getStartToast();
        }
        return null;
    }

    public String N() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getSdkMonitorScene();
        }
        return null;
    }

    public boolean O() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.isAutoInstall();
        }
        return false;
    }

    public boolean P() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.distinctDir();
        }
        return false;
    }

    public boolean Q() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.enablePause();
        }
        return false;
    }

    public String a() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getDownloadUrl();
        }
        return null;
    }

    public List<String> b() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getBackupUrls();
        }
        return null;
    }

    public String c() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getNotificationJumpUrl();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_WIFI /* 223417 */:
                r();
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_TOAST /* 223419 */:
                t();
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_NOTIFICATION /* 223420 */:
                u();
                return null;
            case 223430:
                if (valueSet != null) {
                    return (T) a((String) valueSet.objectValue(223431, String.class));
                }
                return null;
            default:
                return null;
        }
    }

    public long d() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getId();
        }
        return 0L;
    }

    public String e() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getMd5();
        }
        return null;
    }

    public long f() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getExpectFileLength();
        }
        return 0L;
    }

    public long g() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getExtraValue();
        }
        return 0L;
    }

    public String h() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getName();
        }
        return null;
    }

    public String i() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getMimeType();
        }
        return null;
    }

    public Map<String, String> j() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getHeaders();
        }
        return null;
    }

    public boolean k() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.isShowToast();
        }
        return false;
    }

    public boolean l() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.isShowNotification();
        }
        return false;
    }

    public boolean m() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.isNeedWifi();
        }
        return false;
    }

    public boolean n() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.isInExternalPublicDir();
        }
        return false;
    }

    public boolean o() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.isVisibleInDownloadsUi();
        }
        return false;
    }

    public String p() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getFilePath();
        }
        return null;
    }

    public String q() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getFileName();
        }
        return null;
    }

    public void r() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            downloadModel.forceWifi();
        }
    }

    public JSONObject s() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getDownloadSettings();
        }
        return null;
    }

    public void t() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            downloadModel.forceHideToast();
        }
    }

    public void u() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            downloadModel.forceHideNotification();
        }
    }

    public boolean v() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.needIndependentProcess();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return xXxxox0I.oIX0oI().II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DOWNLOAD_URL, a()).Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_BACKUP_URLS, b()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_NOTIFICATION_JUMP_URL, c()).XO(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_ID, d()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_MD5, e()).XO(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXPECT_FILE_LENGTH, f()).XO(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXTRA_VALUE, g()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_NAME, h()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_MIME_TYPE, i()).Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_HEADERS, j()).xxIXOIIO(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_SHOW_TOAST, k()).xxIXOIIO(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_SHOW_NOTIFICATION, l()).xxIXOIIO(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_NEED_WIFI, m()).xxIXOIIO(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_IN_EXTERNAL_PUBLIC_DIR, n()).xxIXOIIO(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_VISIBLE_IN_DOWNLOADS_UI, o()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FILE_PATH, p()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FILE_NAME, q()).Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DOWNLOAD_SETTINGS, s()).xxIXOIIO(ValueSetConstants.VALUE_DOWNLOAD_MODE_NEED_INDEPENDENT_PROCESS, v()).X0o0xo(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_VERSION_CODE, w()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_VERSION_NAME, x()).xxIXOIIO(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_AD, y()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_LOG_EXTRA, z()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_PACKAGE_NAME, A()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_APP_ICON, B()).Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DEEP_LINK, C()).Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_CLICK_TRACK_URL, D()).Oxx0IOOO(223430, E()).X0o0xo(223431, F()).Oxx0IOOO(223432, G()).xxIXOIIO(223433, H()).Oxx0IOOO(223434, I()).xxIXOIIO(223435, J()).X0o0xo(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXECUTOR_GROUP, K()).X0o0xo(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FUNNEL_TYPE, L()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_START_TOAST, M()).II0XooXoX(223432, N()).xxIXOIIO(223433, O()).xxIXOIIO(223434, P()).xxIXOIIO(223435, Q()).OOXIXo();
    }

    public int w() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getVersionCode();
        }
        return 0;
    }

    public String x() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getVersionName();
        }
        return null;
    }

    public boolean y() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.isAd();
        }
        return false;
    }

    public String z() {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.getLogExtra();
        }
        return null;
    }

    public DownloadModel a(String str) {
        DownloadModel downloadModel = this.f10664a;
        if (downloadModel != null) {
            return downloadModel.setFilePath(str);
        }
        return null;
    }
}
