package com.bytedance.sdk.openadsdk.api.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadEventConfig;
import o0.xXxxox0I;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class b implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private DownloadEventConfig f10663a;

    public b(DownloadEventConfig downloadEventConfig) {
        this.f10663a = downloadEventConfig;
    }

    public String a() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getRefer();
        }
        return null;
    }

    public String b() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickButtonTag();
        }
        return null;
    }

    public String c() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickItemTag();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i != 223515) {
            if (i == 223517 && valueSet != null) {
                a((String) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_REFER_PARAMETER, String.class));
                return null;
            }
            return null;
        }
        if (valueSet != null) {
            a(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_DOWNLOAD_SCENE_PARAMETER, Integer.class)).intValue());
            return null;
        }
        return null;
    }

    public String d() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickLabel();
        }
        return null;
    }

    public String e() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickStartLabel();
        }
        return null;
    }

    public String f() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickPauseLabel();
        }
        return null;
    }

    public String g() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickContinueLabel();
        }
        return null;
    }

    public String h() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickInstallLabel();
        }
        return null;
    }

    public String i() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getStorageDenyLabel();
        }
        return null;
    }

    public Object j() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraEventObject();
        }
        return null;
    }

    public int k() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getDownloadScene();
        }
        return 0;
    }

    public boolean l() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableClickEvent();
        }
        return false;
    }

    public boolean m() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableV3Event();
        }
        return false;
    }

    public JSONObject n() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraJson();
        }
        return null;
    }

    public JSONObject o() {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getParamsJson();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return xXxxox0I.oIX0oI().II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_REFER, a()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_BUTTON_TAG, b()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_ITEM_TAG, c()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_LABEL, d()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_START_LABEL, e()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_PAUSE_LABEL, f()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_CONTINUE_LABEL, g()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_INSTALL_LABEL, h()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_STORAGE_DENY_LABEL, i()).Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_EXTRA_EVENT_OBJECT, j()).X0o0xo(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_DOWNLOAD_SCENE, k()).xxIXOIIO(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_IS_ENABLE_CLICK_EVENT, l()).xxIXOIIO(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_IS_ENABLE_V3_EVENT, m()).Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_EXTRA_JSON, n()).Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_PARAMS_JSON, o()).OOXIXo();
    }

    public void a(int i) {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            downloadEventConfig.setDownloadScene(i);
        }
    }

    public void a(String str) {
        DownloadEventConfig downloadEventConfig = this.f10663a;
        if (downloadEventConfig != null) {
            downloadEventConfig.setRefer(str);
        }
    }
}
