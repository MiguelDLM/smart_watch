package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bo;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public abstract class l<R extends f, T extends BaseResultData> extends a<R> {
    private static final String TAG = "Networking";

    @Nullable
    private g<R, T> mListener = null;
    private final com.kwad.sdk.core.network.b.b mMonitorRecorder = com.kwad.sdk.core.network.b.c.ET();

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.dg(1);
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.a.f fVar;
        if (cVar != null && !cVar.Ew() && (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null && ah.isNetworkConnected(fVar.getContext())) {
            com.kwad.sdk.ip.direct.a.Jt();
        }
    }

    private String getHostTypeByUrl(@NonNull String str) {
        if (str.contains("/rest/zt/emoticon/package/list")) {
            return "zt";
        }
        return "api";
    }

    private void notifyOnErrorListener(@NonNull R r, c cVar, String str) {
        String url = r.getUrl();
        DomainException domainException = new DomainException(cVar.awC, cVar.awD);
        com.kwad.sdk.core.network.idc.a.EE().a(url, getHostTypeByUrl(url), domainException);
        notifyOnErrorListener((l<R, T>) r, cVar.code, str);
    }

    private void notifyOnStartRequest(@NonNull R r) {
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onStartRequest(r);
    }

    private void notifyOnSuccess(@NonNull R r, T t) {
        if (com.kwad.sdk.core.network.idc.a.EE().EG()) {
            String hostTypeByUrl = getHostTypeByUrl(r.getUrl());
            if ("api".equals(hostTypeByUrl)) {
                com.kwad.sdk.core.network.idc.a.EE().eb(hostTypeByUrl);
            }
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onSuccess(r, t);
        this.mMonitorRecorder.ES();
    }

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mMonitorRecorder.EM();
        this.mListener = gVar;
    }

    private void parseCommonData(String str, String str2) {
        try {
            q.EA().U(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    private void setMonitorRequestId(@NonNull f fVar) {
        Map<String, String> header = fVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (!TextUtils.isEmpty(str)) {
                this.mMonitorRecorder.el(str);
            }
        }
    }

    public void afterParseData(T t) {
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    public boolean enableCrashReport() {
        return true;
    }

    public boolean enableMonitorReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    public void fetchImpl() {
        R r;
        Throwable th;
        c cVar = null;
        try {
            this.mMonitorRecorder.EQ();
            r = createRequest();
            try {
                notifyOnStartRequest(r);
                this.mMonitorRecorder.eh(r.getUrl()).ei(r.getUrl());
                setMonitorRequestId(r);
                if (!ah.isNetworkConnected(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                    e eVar = e.awI;
                    notifyOnErrorListener((l<R, T>) r, eVar.errorCode, eVar.msg);
                    this.mMonitorRecorder.df(e.awI.errorCode).ej(e.awI.msg);
                } else {
                    try {
                        String url = r.getUrl();
                        AdHttpProxy yy = com.kwad.sdk.g.yy();
                        if (yy instanceof com.kwad.sdk.core.network.c.b) {
                            this.mMonitorRecorder.ek("ok_http").EP();
                        } else {
                            this.mMonitorRecorder.ek("http").EP();
                        }
                        if (isPostByJson()) {
                            cVar = yy.doPost(url, r.getHeader(), r.getBody());
                        } else {
                            cVar = yy.doPost(url, r.getHeader(), r.getBodyMap());
                        }
                        com.kwad.sdk.core.e.c.i(TAG, "url: " + url + ", response: " + cVar);
                    } catch (Exception e) {
                        notifyOnErrorListener((l<R, T>) r, e.awP.errorCode, bo.t(e));
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                        this.mMonitorRecorder.ej("requestError:" + e.getMessage());
                    }
                    this.mMonitorRecorder.EN().EO().di(com.kwad.sdk.ip.direct.a.getType());
                    try {
                        onResponse(r, cVar);
                    } catch (Exception e2) {
                        notifyOnErrorListener((l<R, T>) r, e.awP.errorCode, bo.t(e2));
                        this.mMonitorRecorder.ej("onResponseError:" + e2.getMessage());
                        com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                    }
                }
                try {
                    if (enableMonitorReport()) {
                        this.mMonitorRecorder.report();
                    }
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    try {
                        this.mMonitorRecorder.ej("requestError:" + th.getMessage());
                    } catch (Exception unused2) {
                        notifyOnErrorListener((l<R, T>) r, e.awP.errorCode, bo.t(th));
                        com.kwad.sdk.core.e.c.printStackTrace(th);
                        try {
                            if (enableMonitorReport()) {
                                this.mMonitorRecorder.report();
                            }
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        if (enableMonitorReport()) {
                            this.mMonitorRecorder.report();
                        }
                    } catch (Exception unused4) {
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            r = null;
            th = th4;
        }
    }

    public boolean isPostByJson() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r, c cVar) {
        String str;
        if (cVar == null) {
            e eVar = e.awI;
            notifyOnErrorListener((l<R, T>) r, eVar.errorCode, eVar.msg);
            this.mMonitorRecorder.ej("responseBase is null");
            com.kwad.sdk.core.e.c.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.df(cVar.code);
        checkIpDirect(cVar);
        if (!TextUtils.isEmpty(cVar.awE) && cVar.Ew()) {
            try {
                parseCommonData(r.getUrl(), cVar.awE);
                T parseData = parseData(cVar.awE);
                afterParseData(parseData);
                if (cVar.awE != null) {
                    this.mMonitorRecorder.ar(r7.length()).ER().dh(parseData.result);
                }
                if (!parseData.isResultOk()) {
                    this.mMonitorRecorder.ej("serverCodeError:" + parseData.result + ":" + parseData.errorMsg);
                    if (parseData.notifyFailOnResultError()) {
                        notifyOnErrorListener((l<R, T>) r, parseData.result, parseData.errorMsg);
                        return;
                    }
                }
                if (parseData.isDataEmpty()) {
                    int i = e.awK.errorCode;
                    if (!TextUtils.isEmpty(parseData.testErrorMsg)) {
                        str = parseData.testErrorMsg;
                    } else {
                        str = e.awK.msg;
                    }
                    notifyOnErrorListener((l<R, T>) r, i, str);
                    return;
                }
                checkAndSetHasData(parseData);
                notifyOnSuccess(r, parseData);
                return;
            } catch (Exception e) {
                e eVar2 = e.awJ;
                notifyOnErrorListener((l<R, T>) r, eVar2.errorCode, eVar2.msg);
                com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                this.mMonitorRecorder.ej("parseDataError:" + e.getMessage());
                return;
            }
        }
        notifyOnErrorListener((l<R, T>) r, cVar, "网络错误");
        this.mMonitorRecorder.ej("httpCodeError:" + cVar.code + ":" + cVar.awE);
        StringBuilder sb = new StringBuilder("request responseBase httpCodeError:");
        sb.append(cVar.code);
        com.kwad.sdk.core.e.c.w(TAG, sb.toString());
    }

    @NonNull
    public abstract T parseData(String str);

    public void request(@NonNull g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            notifyOnErrorListener((l<R, T>) null, e.awP.errorCode, bo.t(th));
            reportSdkCaughtException(th);
        }
    }

    private void notifyOnErrorListener(@NonNull R r, int i, String str) {
        try {
            h.Ex().b(r, i);
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onError(r, i, str);
        this.mMonitorRecorder.ES();
    }
}
