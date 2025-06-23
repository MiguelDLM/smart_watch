package com.kwad.components.offline.api.tk.model.report;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class TKDownloadMsg extends BaseOfflineCompoJsonParse<TKDownloadMsg> implements Serializable {
    public static final int ENV_SUCCESS = 3;
    public static final int FAIL = 2;
    private static final int INVALID_DOWNLOAD_STATE = -1;
    public static final int START = 0;
    public static final int SUCCESS = 1;
    private static final long serialVersionUID = -8872909341685100922L;
    public long availableTime;
    public int downloadState = -1;
    public long downloadTime;
    public String errorDetail;
    public String errorReason;
    public int loadingTimes;
    public long offlineLoadTime;
    public int offlineSource;
    public int preload;
    public int retryCount;
    public long soLoadTime;
    public int soSource;
    public String templateId;
    public int threadPoolCoreSize;
    public String versionCode;

    public TKDownloadMsg setDownloadState(int i) {
        this.downloadState = i;
        return this;
    }

    public TKDownloadMsg setDownloadTime(long j) {
        this.downloadTime = j;
        return this;
    }

    public TKDownloadMsg setErrorDetail(String str) {
        this.errorDetail = str;
        return this;
    }

    public TKDownloadMsg setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public TKDownloadMsg setInitSdkTimeConsuming(long j) {
        this.availableTime = j;
        return this;
    }

    public TKDownloadMsg setLoadingTimes(int i) {
        this.loadingTimes = i;
        return this;
    }

    public TKDownloadMsg setOfflineLoadTime(long j) {
        this.offlineLoadTime = j;
        return this;
    }

    public TKDownloadMsg setOfflineSource(int i) {
        this.offlineSource = i;
        return this;
    }

    public TKDownloadMsg setPreload(int i) {
        this.preload = i;
        return this;
    }

    public TKDownloadMsg setRetryCount(int i) {
        this.retryCount = i;
        return this;
    }

    public TKDownloadMsg setSoLoadTime(long j) {
        this.soLoadTime = j;
        return this;
    }

    public TKDownloadMsg setSoSource(int i) {
        this.soSource = i;
        return this;
    }

    public TKDownloadMsg setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public TKDownloadMsg setThreadPoolCoreSize(int i) {
        this.threadPoolCoreSize = i;
        return this;
    }

    public TKDownloadMsg setVersionCode(String str) {
        this.versionCode = str;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKDownloadMsg.downloadState = jSONObject.optInt("download_state");
        tKDownloadMsg.downloadTime = jSONObject.optLong("download_time");
        tKDownloadMsg.preload = jSONObject.optInt("preload");
        tKDownloadMsg.errorReason = jSONObject.optString("error_reason");
        Object opt = jSONObject.opt("error_reason");
        Object obj = JSONObject.NULL;
        if (opt == obj) {
            tKDownloadMsg.errorReason = "";
        }
        tKDownloadMsg.templateId = jSONObject.optString(ExposeManager.UtArgsNames.templateId);
        if (jSONObject.opt(ExposeManager.UtArgsNames.templateId) == obj) {
            tKDownloadMsg.templateId = "";
        }
        tKDownloadMsg.versionCode = jSONObject.optString("version_code");
        if (jSONObject.opt("version_code") == obj) {
            tKDownloadMsg.versionCode = "";
        }
        tKDownloadMsg.retryCount = jSONObject.optInt("retry_count");
        tKDownloadMsg.loadingTimes = jSONObject.optInt("loading_times");
        tKDownloadMsg.offlineSource = jSONObject.optInt("offline_source");
        tKDownloadMsg.soSource = jSONObject.optInt("so_source");
        tKDownloadMsg.offlineLoadTime = jSONObject.optLong("offline_load_time");
        tKDownloadMsg.soLoadTime = jSONObject.optLong("so_load_time");
        tKDownloadMsg.errorDetail = jSONObject.optString("error_detail");
        if (jSONObject.opt("error_detail") == obj) {
            tKDownloadMsg.errorDetail = "";
        }
        tKDownloadMsg.threadPoolCoreSize = jSONObject.optInt("thread_pool_core_size");
        tKDownloadMsg.availableTime = jSONObject.optLong("available_time");
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKDownloadMsg tKDownloadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JsonHelper.putValue(jSONObject, "download_state", tKDownloadMsg.downloadState);
        JsonHelper.putValue(jSONObject, "thread_pool_core_size", tKDownloadMsg.threadPoolCoreSize);
        JsonHelper.putValue(jSONObject, "available_time", tKDownloadMsg.availableTime);
        long j = tKDownloadMsg.downloadTime;
        if (j != 0) {
            JsonHelper.putValue(jSONObject, "download_time", j);
        }
        int i = tKDownloadMsg.preload;
        if (i != 0) {
            JsonHelper.putValue(jSONObject, "preload", i);
        }
        String str = tKDownloadMsg.errorReason;
        if (str != null && !str.equals("")) {
            JsonHelper.putValue(jSONObject, "error_reason", tKDownloadMsg.errorReason);
        }
        String str2 = tKDownloadMsg.templateId;
        if (str2 != null && !str2.equals("")) {
            JsonHelper.putValue(jSONObject, ExposeManager.UtArgsNames.templateId, tKDownloadMsg.templateId);
        }
        String str3 = tKDownloadMsg.versionCode;
        if (str3 != null && !str3.equals("")) {
            JsonHelper.putValue(jSONObject, "version_code", tKDownloadMsg.versionCode);
        }
        int i2 = tKDownloadMsg.retryCount;
        if (i2 != 0) {
            JsonHelper.putValue(jSONObject, "retry_count", i2);
        }
        int i3 = tKDownloadMsg.loadingTimes;
        if (i3 != 0) {
            JsonHelper.putValue(jSONObject, "loading_times", i3);
        }
        int i4 = tKDownloadMsg.offlineSource;
        if (i4 != 0) {
            JsonHelper.putValue(jSONObject, "offline_source", i4);
        }
        int i5 = tKDownloadMsg.soSource;
        if (i5 != 0) {
            JsonHelper.putValue(jSONObject, "so_source", i5);
        }
        long j2 = tKDownloadMsg.offlineLoadTime;
        if (j2 != 0) {
            JsonHelper.putValue(jSONObject, "offline_load_time", j2);
        }
        long j3 = tKDownloadMsg.soLoadTime;
        if (j3 != 0) {
            JsonHelper.putValue(jSONObject, "so_load_time", j3);
        }
        String str4 = tKDownloadMsg.errorDetail;
        if (str4 != null && !str4.equals("")) {
            JsonHelper.putValue(jSONObject, "error_detail", tKDownloadMsg.errorDetail);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(TKDownloadMsg tKDownloadMsg) {
        return toJson(tKDownloadMsg, (JSONObject) null);
    }
}
