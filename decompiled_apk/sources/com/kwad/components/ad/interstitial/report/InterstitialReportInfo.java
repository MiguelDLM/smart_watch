package com.kwad.components.ad.interstitial.report;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

@KsJson
/* loaded from: classes11.dex */
public class InterstitialReportInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int DOWNLOAD_FAILED = 2;
    public static final int DOWNLOAD_STATUS_ERROR = 2;
    public static final int DOWNLOAD_STATUS_START = 1;
    public static final int DOWNLOAD_SUCCESS = 1;
    public static final int DOWNLOAD_TYPE_ALL = 2;
    public static final int DOWNLOAD_TYPE_ONLINE = 1;
    public static final int DOWNLOAD_TYPE_PART = 3;
    public static final int LOAD_STATUS_AD_SHOWN = 4;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAILED = 5;
    public static final int LOAD_STATUS_LOAD_FINISH = 3;
    public static final int LOAD_STATUS_RENDER_FAILED = 12;
    public static final int LOAD_STATUS_RENDER_START = 10;
    public static final int LOAD_STATUS_RENDER_SUCCESS = 7;
    public static final int LOAD_STATUS_SERVER_SHOW = 11;
    public static final int LOAD_STATUS_SHOW_AD_CALL = 6;
    public static final int LOAD_STATUS_SHOW_FAILED = 9;
    public static final int LOAD_STATUS_SHOW_SUCCESS = 8;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_TYPE_CACHE = 2;
    public static final int LOAD_TYPE_ONLINE = 1;
    public static final int TYPE_H5 = 2;
    public static final int TYPE_NATIVE = 1;
    public static final int TYPE_TK = 3;
    public static final int VIDEO_STATUS_1 = 1;
    public static final int VIDEO_STATUS_2 = 2;
    public static final int VIDEO_STATUS_3 = 3;
    private static final long serialVersionUID = 6882024284587637114L;
    public String abParams;
    public long actionType;
    public long callbackType;
    public long clickSceneType;
    public long creativeId;
    public long downloadDuration;
    public long downloadSize;
    public int downloadType;
    public int expectedRenderType;
    public long itemClickType;
    public long loadDataTime;
    public int materialType;
    public long playStartedDuration;
    public long renderDuration;
    public int renderType;
    public int status;
    public int type;
    public long videoDuration;
    public String videoUrl;
    public double visiblePercent;

    public InterstitialReportInfo() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "interstitialAdLoadProcessChange", com.kwad.sdk.core.config.d.Ck());
        t.putValue(jSONObject, "videoCacheOptType", com.kwad.sdk.core.config.d.Do());
        t.putValue(jSONObject, "okHttpSupport", isOkHttpSupported());
        t.putValue(jSONObject, "insertConfigShowPercent", com.kwad.sdk.core.config.d.Cp());
        this.abParams = jSONObject.toString();
    }

    public boolean isOkHttpSupported() {
        try {
            Class.forName("okhttp3.OkHttpClient");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public InterstitialReportInfo setAbParams(String str) {
        this.abParams = str;
        return this;
    }

    public InterstitialReportInfo setActionType(long j) {
        this.actionType = j;
        return this;
    }

    public InterstitialReportInfo setCallbackType(long j) {
        this.callbackType = j;
        return this;
    }

    public InterstitialReportInfo setClickSceneType(long j) {
        this.clickSceneType = j;
        return this;
    }

    public InterstitialReportInfo setCreativeId(long j) {
        this.creativeId = j;
        return this;
    }

    public InterstitialReportInfo setDownloadDuration(long j) {
        this.downloadDuration = j;
        return this;
    }

    public InterstitialReportInfo setDownloadSize(long j) {
        this.downloadSize = j;
        return this;
    }

    public InterstitialReportInfo setDownloadType(int i) {
        this.downloadType = i;
        return this;
    }

    public InterstitialReportInfo setExpectedRenderType() {
        this.expectedRenderType = 3;
        return this;
    }

    public InterstitialReportInfo setItemClickType(long j) {
        this.itemClickType = j;
        return this;
    }

    public InterstitialReportInfo setLoadDataTime(long j) {
        this.loadDataTime = j;
        return this;
    }

    public InterstitialReportInfo setMaterialType(int i) {
        this.materialType = i;
        return this;
    }

    public InterstitialReportInfo setPlayStartedDuration(long j) {
        this.playStartedDuration = j;
        return this;
    }

    public InterstitialReportInfo setRenderDuration(long j) {
        this.renderDuration = j;
        return this;
    }

    public InterstitialReportInfo setRenderType(int i) {
        this.renderType = i;
        return this;
    }

    public InterstitialReportInfo setStatus(int i) {
        this.status = i;
        return this;
    }

    public InterstitialReportInfo setType(int i) {
        this.type = i;
        return this;
    }

    public InterstitialReportInfo setVideoDuration(long j) {
        this.videoDuration = j;
        return this;
    }

    public InterstitialReportInfo setVideoUrl(String str) {
        this.videoUrl = str;
        return this;
    }

    public InterstitialReportInfo setVisiblePercent(double d) {
        this.visiblePercent = d;
        return this;
    }

    public InterstitialReportInfo(AdTemplate adTemplate) {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "interstitialAdLoadProcessChange", com.kwad.sdk.core.config.d.Ck());
        t.putValue(jSONObject, "videoCacheOptType", com.kwad.sdk.core.config.d.Do());
        t.putValue(jSONObject, "okHttpSupport", isOkHttpSupported());
        t.putValue(jSONObject, "downloadStatus", adTemplate.getDownloadStatus());
        t.putValue(jSONObject, "insertConfigShowPercent", com.kwad.sdk.core.config.d.Cp());
        this.abParams = jSONObject.toString();
    }
}
