package com.kwad.components.ad.splashscreen.monitor;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.Serializable;
import java.util.List;

@KsJson
/* loaded from: classes11.dex */
public class SplashMonitorInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int CHECK_BACKUP_FAILED = 4;
    public static final int CHECK_BACKUP_SUCCESS = 3;
    public static final int CHECK_CACHE = 2;
    public static final int CHECK_INVALID_VIDEO = 5;
    public static final int CHECK_LIVE_NO_CACHE = 8;
    public static final int CHECK_TIME_OUT = 7;
    public static final int ERROR_DOWNLOAD = 4;
    public static final int ERROR_NET = 1;
    public static final String ERROR_NET_MSG = "networkError";
    public static final int ERROR_PRELOAD_ID_INVALID = 3;
    public static final String ERROR_PRELOAD_ID_INVALID_MSG = "preloadIdError";
    public static final int ERROR_URL_INVALID = 2;
    public static final String ERROR_URL_INVALID_MSG = "urlError";
    public static final int IMAGE_LOAD_NO_TIMEOUT = 3002;
    public static final int IMAGE_LOAD_START = 3001;
    public static final int IMAGE_LOAD_TIMEOUT = 3003;
    public static final long LOAD_PROCESS_TYPE_NEW = 1;
    public static final long LOAD_PROCESS_TYPE_OLD = 2;
    public static final int LOAD_STATUS_CHECK_FAILED = 5;
    public static final int LOAD_STATUS_CHECK_SUCCESS = 3;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAILED = 4;
    public static final int LOAD_STATUS_LOAD_DATA_PRE = 11;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_TYPE_CACHE = 2;
    public static final int LOAD_TYPE_ONLINE = 1;
    public static final int MATERIAL_IMAGE = 2;
    public static final int MATERIAL_VIDEO = 1;
    public static final int PRE_LOAD_FAIL = 3;
    public static final int PRE_LOAD_START = 1;
    public static final int PRE_LOAD_SUCCESS = 2;
    public static final int SHOW_AD_CALL = 4;
    public static final int SHOW_CALL = 6;
    public static final int SHOW_CALL_ERROR = 7;
    public static final int SHOW_END_RECORD = 8;
    public static final int SHOW_FAIL = 3;
    public static final int SHOW_START = 1;
    public static final int SHOW_SUCCESS = 2;
    public static final int SHOW_TK_OFFLINE_READY = 5;
    public static final int SINGLE_CACHE_FAIL = 2;
    public static final int SINGLE_CACHE_SUCCESS = 1;
    public static final int SPLASH_FROM_FRAGMENT = 2;
    public static final int SPLASH_FROM_VIEW = 1;
    public static final String TEMPLATE_ID_EMPTY = "template_id_empty";
    public static final String TEMPLATE_RENER_TYPE_ERROR = "template_render_type_error";
    public static final int TK_ENTER = 101;
    public static final int TK_ENV_NOT_READY = 103;
    public static final int TK_LOAD_FAILED = 105;
    public static final int TK_LOAD_START = 102;
    public static final int TK_LOAD_SUCCESS = 104;
    public static final int TK_RENDER_TIMEOUT = 106;
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_UPDATE = 2;
    private static final long serialVersionUID = 3528420046810658543L;
    public int actionType;
    public long beforeLoadDataTime;
    public long cacheValidTime;
    public int callbackType;
    public long checkDataTime;
    public int checkStatus;
    public long costTime;
    public int count;
    public long creativeId;
    public List<String> creativeIds;
    public List<Integer> elementTypes;
    public List<String> ids;
    public String interactiveStyle;
    public String interactivityDefaultStyle;
    public boolean isRotateComposeTimeout;
    public boolean isWebTimeout;
    public long loadAndCheckDataTime;
    public long loadDataTime;
    public long loadProcessType;
    public int materialType;
    public long nativeLoadTime;
    public long offlineLoadTime;
    public int offlineSource;
    public long posId;
    public String preloadId;
    public List<String> preloadIds;
    public long showEndTime;
    public long size;
    public long soLoadTime;
    public int soSource;
    public int status;
    public String templateId;
    public int templateVersionCode;
    public long tkDefaultTimeout;
    public long tkFileLoadTime;
    public long tkInitTime;
    public long tkRenderTime;
    public long tkRenderType;
    public long tkTotalTime;
    public int totalCount;
    public int type;
    public String url;
    public int viewSource;
    public long webLoadTime;

    public SplashMonitorInfo setActionType(int i) {
        this.actionType = i;
        return this;
    }

    public SplashMonitorInfo setBeforeLoadDataTime(long j) {
        this.beforeLoadDataTime = j;
        return this;
    }

    public SplashMonitorInfo setCacheValidTime(long j) {
        this.cacheValidTime = j;
        return this;
    }

    public SplashMonitorInfo setCallbackType(int i) {
        this.callbackType = i;
        return this;
    }

    public SplashMonitorInfo setCheckDataTime(long j) {
        this.checkDataTime = j;
        return this;
    }

    public SplashMonitorInfo setCheckStatus(int i) {
        this.checkStatus = i;
        return this;
    }

    public SplashMonitorInfo setCostTime(long j) {
        this.costTime = j;
        return this;
    }

    public SplashMonitorInfo setCount(int i) {
        this.count = i;
        return this;
    }

    public SplashMonitorInfo setCreativeId(long j) {
        this.creativeId = j;
        return this;
    }

    public SplashMonitorInfo setCreativeIds(List<String> list) {
        this.creativeIds = list;
        return this;
    }

    public SplashMonitorInfo setElementTypes(List<Integer> list) {
        this.elementTypes = list;
        return this;
    }

    public SplashMonitorInfo setIds(List<String> list) {
        this.ids = list;
        return this;
    }

    public SplashMonitorInfo setInteractiveStyle(int i) {
        this.interactiveStyle = String.valueOf(i);
        return this;
    }

    public SplashMonitorInfo setInteractivityDefaultStyle(int i) {
        this.interactivityDefaultStyle = String.valueOf(i);
        return this;
    }

    public SplashMonitorInfo setLoadAndCheckDataTime(long j) {
        this.loadAndCheckDataTime = j;
        return this;
    }

    public SplashMonitorInfo setLoadDataTime(long j) {
        this.loadDataTime = j;
        return this;
    }

    public SplashMonitorInfo setLoadProcessType(long j) {
        this.loadProcessType = j;
        return this;
    }

    public SplashMonitorInfo setMaterialType(int i) {
        this.materialType = i;
        return this;
    }

    public SplashMonitorInfo setNativeLoadTime(long j) {
        this.nativeLoadTime = j;
        return this;
    }

    public SplashMonitorInfo setOfflineLoadTime(long j) {
        this.offlineLoadTime = j;
        return this;
    }

    public SplashMonitorInfo setOfflineSource(int i) {
        this.offlineSource = i;
        return this;
    }

    public SplashMonitorInfo setPreloadId(String str) {
        this.preloadId = str;
        return this;
    }

    public SplashMonitorInfo setPreloadIds(List<String> list) {
        this.preloadIds = list;
        return this;
    }

    public SplashMonitorInfo setRotateComposeTimeout(boolean z) {
        this.isRotateComposeTimeout = z;
        return this;
    }

    public SplashMonitorInfo setShowEndTime(long j) {
        this.showEndTime = j;
        return this;
    }

    public SplashMonitorInfo setSize(long j) {
        this.size = j;
        return this;
    }

    public SplashMonitorInfo setSoLoadTime(long j) {
        this.soLoadTime = j;
        return this;
    }

    public SplashMonitorInfo setSoSource(int i) {
        this.soSource = i;
        return this;
    }

    public SplashMonitorInfo setStatus(int i) {
        this.status = i;
        return this;
    }

    public SplashMonitorInfo setTemplateId(String str) {
        this.templateId = str;
        return this;
    }

    public SplashMonitorInfo setTemplateVersionCode(int i) {
        this.templateVersionCode = i;
        return this;
    }

    public SplashMonitorInfo setTkDefaultTimeout(long j) {
        this.tkDefaultTimeout = j;
        return this;
    }

    public SplashMonitorInfo setTkFileLoadTime(long j) {
        this.tkFileLoadTime = j;
        return this;
    }

    public SplashMonitorInfo setTkInitTime(long j) {
        this.tkInitTime = j;
        return this;
    }

    public SplashMonitorInfo setTkRenderTime(long j) {
        this.tkRenderTime = j;
        return this;
    }

    public SplashMonitorInfo setTkRenderType(long j) {
        this.tkRenderType = j;
        return this;
    }

    public SplashMonitorInfo setTkTotalTime(long j) {
        this.tkTotalTime = j;
        return this;
    }

    public SplashMonitorInfo setTotalCount(int i) {
        this.totalCount = i;
        return this;
    }

    public SplashMonitorInfo setType(int i) {
        this.type = i;
        return this;
    }

    public SplashMonitorInfo setUrl(String str) {
        this.url = str;
        return this;
    }

    public SplashMonitorInfo setViewSource(int i) {
        this.viewSource = i;
        return this;
    }

    public SplashMonitorInfo setWebLoadTime(long j) {
        this.webLoadTime = j;
        return this;
    }

    public SplashMonitorInfo setWebTimeout(boolean z) {
        this.isWebTimeout = z;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public SplashMonitorInfo setAdTemplate(AdTemplate adTemplate) {
        return (SplashMonitorInfo) super.setAdTemplate(adTemplate);
    }

    @Override // com.kwad.sdk.commercial.c.a
    public SplashMonitorInfo setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public SplashMonitorInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
