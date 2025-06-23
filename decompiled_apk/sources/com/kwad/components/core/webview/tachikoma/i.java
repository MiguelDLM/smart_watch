package com.kwad.components.core.webview.tachikoma;

import XIXIX.OOXIXo;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.ui.widget.BNWebViewClient;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.l;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.av;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.a.s;
import com.kwad.components.core.webview.tachikoma.a.t;
import com.kwad.components.core.webview.tachikoma.a.v;
import com.kwad.components.core.webview.tachikoma.a.x;
import com.kwad.components.core.webview.tachikoma.b.n;
import com.kwad.components.core.webview.tachikoma.b.y;
import com.kwad.components.core.webview.tachikoma.c.e;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.m;
import com.kwad.sdk.components.o;
import com.kwad.sdk.components.p;
import com.kwad.sdk.components.r;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.v;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class i implements com.kwad.components.core.e.e.f, o, com.kwad.sdk.core.view.b, com.kwad.sdk.core.webview.d.a.a {
    private static Map<Integer, WeakReference<com.kwad.components.core.webview.tachikoma.c.e>> ZN = new HashMap();
    private long Fe;
    private StyleTemplate Th;
    private com.kwad.sdk.core.download.d Wm;
    private av ZA;
    private com.kwad.sdk.core.view.d ZB;
    private TextView ZC;
    private boolean ZD;
    private boolean ZE;
    private boolean ZF;
    private boolean ZG;
    private boolean ZH;
    private int ZI;
    private long ZJ;
    private long ZK;
    private long ZL;
    private Map<String, Object> ZM;
    private int ZO;
    private int ZP;
    private boolean ZQ;
    private String ZR;
    private String ZS;
    protected com.kwad.sdk.core.webview.e ZU;
    private a ZV;
    private p ZW;
    private com.kwad.sdk.components.j ZX;
    private final Runnable ZY;
    private final Runnable ZZ;
    private com.kwad.components.core.webview.tachikoma.c.e Zt;
    protected j Zu;
    private com.kwad.sdk.core.webview.c.g Zv;
    private com.kwad.components.core.n.a.d.c Zw;
    private Future<?> Zx;
    private r Zy;
    private com.kwad.components.core.webview.tachikoma.a.p Zz;
    private aw cQ;
    private final l gO;

    @Nullable
    private Activity mActivity;
    private AdResultData mAdResultData;
    protected final Context mContext;
    private final y wq;
    protected long xt;

    /* loaded from: classes11.dex */
    public interface a {
        void onFailed();

        void onSuccess();
    }

    public i(Context context) {
        this(context, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.sdk.components.i aC(final AdTemplate adTemplate) {
        final com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(adTemplate);
        cVar.oA();
        return new com.kwad.sdk.components.i() { // from class: com.kwad.components.core.webview.tachikoma.i.24
            @Override // com.kwad.sdk.components.i
            public final void a(final com.kwad.sdk.components.h hVar) {
                cVar.b(new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.tachikoma.i.24.1
                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        hVar.onDownloadFailed();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        hVar.onDownloadFinished();
                    }

                    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadStarted() {
                        hVar.onDownloadStarted();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        hVar.onIdle();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        hVar.onInstalled();
                    }

                    @Override // com.kwad.sdk.core.download.a.a
                    public final void onPaused(int i) {
                        hVar.onPaused(i);
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i) {
                        hVar.onProgressUpdate(i);
                    }
                });
            }

            @Override // com.kwad.sdk.components.i
            public final void cancelDownload() {
                com.kwad.sdk.core.download.a.dH(com.kwad.sdk.core.response.b.e.dV(adTemplate));
            }

            @Override // com.kwad.sdk.components.i
            public final void installApp() {
                cVar.oF();
            }

            @Override // com.kwad.sdk.components.i
            public final void openApp() {
                cVar.oD();
            }

            @Override // com.kwad.sdk.components.i
            public final void pauseDownload() {
                cVar.oH();
            }

            @Override // com.kwad.sdk.components.i
            public final void resumeDownload() {
                cVar.oI();
            }

            @Override // com.kwad.sdk.components.i
            public final void setCustomReportParam(String str) {
                try {
                    cVar.d(new JSONObject(str));
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }

            @Override // com.kwad.sdk.components.i
            public final void startDownload() {
                cVar.oG();
            }

            @Override // com.kwad.sdk.components.i
            public final void stopDownload() {
                cVar.oH();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(String str) {
        b(TKRenderFailReason.TK_FILE_LOAD_ERROR);
        aU(str);
    }

    private static StyleTemplate aT(String str) {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return null;
    }

    private void aU(String str) {
        f(this.Zu.getTkTemplateId(), str);
        StyleTemplate tl = tl();
        if (tl == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.ZI).setRenderState(4).setErrorReason(str).setTemplateId(this.Zu.getTkTemplateId()).setVersionCode(String.valueOf(tl.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(String str) {
        com.kwad.sdk.core.e.c.d("TKLoadController", "logTkRenderFail : " + str + ", templateId = " + this.Zu.getTkTemplateId());
        g(this.Zu.getTkTemplateId(), str);
        if (this.ZF && !this.ZG) {
            this.ZG = true;
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.ZI).setRenderState(2).setErrorReason(str).setTemplateId(this.Zu.getTkTemplateId()).setVersionCode(String.valueOf(this.Th.templateVersionCode)).toJson());
        }
    }

    private static boolean isLocalDebugEnable() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    private void ti() {
        this.ZF = false;
        this.ZG = false;
        this.ZD = false;
        this.ZE = false;
        this.ZH = false;
        this.Fe = 0L;
        this.ZK = 0L;
        this.ZL = 0L;
        this.ZJ = 0L;
    }

    private void tj() {
        if (isLocalDebugEnable()) {
            this.ZO = 2000;
            this.ZP = 3000;
        }
        bo.runOnUiThreadDelay(this.ZY, this.ZO);
        int i = this.ZP;
        if (i > 0) {
            bo.runOnUiThreadDelay(this.ZZ, i);
        }
        this.Zx = GlobalThreadPools.Gr().submit(new az() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                i.this.Fe = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.e.c.d("TKLoadController", "开始读取模板 id: " + i.this.Zu.getTkTemplateId());
                i.this.a(new TKDownloadListener() { // from class: com.kwad.components.core.webview.tachikoma.i.1.1
                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onFailed(String str) {
                        i.this.aS(str);
                    }

                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                        i.this.b(styleTemplate);
                    }
                });
            }
        });
    }

    private static boolean tk() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    private StyleTemplate tl() {
        AdMatrixInfo.MatrixTemplate k;
        String tkTemplateId = this.Zu.getTkTemplateId();
        StyleTemplate styleTemplate = this.Th;
        if (styleTemplate != null) {
            tkTemplateId = styleTemplate.templateId;
        }
        StyleTemplate aT = aT(tkTemplateId);
        if (aT != null) {
            return aT;
        }
        if (isLocalDebugEnable()) {
            StyleTemplate styleTemplate2 = new StyleTemplate();
            styleTemplate2.templateId = tkTemplateId;
            styleTemplate2.templateVersion = "1.0.4";
            styleTemplate2.templateVersionCode = 104;
            if (tk()) {
                styleTemplate2.templateUrl = BNWebViewClient.URL_HTTP_PREFIX + OfflineHostProvider.getApi().env().localIpAddress() + ":9292/" + tkTemplateId + ".104.coverage.zip";
            } else {
                styleTemplate2.templateUrl = BNWebViewClient.URL_HTTP_PREFIX + OfflineHostProvider.getApi().env().localIpAddress() + ":9292/" + tkTemplateId + ".104.zip";
            }
            return styleTemplate2;
        }
        StyleTemplate styleTemplate3 = this.Th;
        if (styleTemplate3 != null) {
            return styleTemplate3;
        }
        AdTemplate tn = tn();
        if (tn == null || (k = com.kwad.sdk.core.response.b.b.k(tn, this.Zu.getTkTemplateId())) == null) {
            return null;
        }
        com.kwad.components.core.n.a.d.c cVar = this.Zw;
        if (cVar == null) {
            StyleTemplate styleTemplate4 = new StyleTemplate();
            styleTemplate4.templateId = k.templateId;
            styleTemplate4.templateMd5 = k.templateMd5;
            styleTemplate4.templateUrl = k.templateUrl;
            styleTemplate4.templateVersionCode = (int) k.templateVersionCode;
            styleTemplate4.tkSouce = 0;
            return styleTemplate4;
        }
        return cVar.checkStyleTemplateById(this.mContext, k.templateId, k.templateMd5, k.templateUrl, (int) k.templateVersionCode);
    }

    private void tm() {
        this.ZU.a(!aj.ML() ? 1 : 0, this.Zu.getTouchCoordsView(), this.Zu.getTKContainer(), this.Zu.getTkTemplateId());
    }

    private void to() {
        StyleTemplate tl = tl();
        if (tl == null) {
            return;
        }
        this.ZI = tl.tkSouce;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.ZI).setRenderState(-1).setTemplateId(this.Zu.getTkTemplateId()).setVersionCode(String.valueOf(tl.templateVersionCode)).toJson());
    }

    private void tp() {
        this.ZF = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.ZI).setRenderState(0).setTemplateId(this.Zu.getTkTemplateId()).setVersionCode(String.valueOf(this.Th.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq() {
        com.kwad.sdk.core.e.c.d("TKLoadController", "logTkRenderSuccess, templateId = " + this.Zu.getTkTemplateId());
        if (this.ZF && !this.ZG) {
            this.ZG = true;
            long j = 0;
            if (this.ZJ > 0) {
                j = SystemClock.elapsedRealtime() - this.ZJ;
            }
            com.kwad.sdk.core.e.c.d("TKLoadController", "render time, templateId = " + this.Zu.getTkTemplateId() + " init:" + this.ZL + " load:" + (this.ZK - this.Fe) + " render:" + j);
            TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.ZI).setRenderState(1).setRenderTime(j).setTemplateId(this.Zu.getTkTemplateId()).setLoadTime(this.ZK - this.Fe).setInitTime(this.ZL).setVersionCode(String.valueOf(this.Th.templateVersionCode)).toJson());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tr() {
        com.kwad.sdk.core.e.c.d("TKLoadController", "logTkRenderFail : timeout, templateId = " + this.Zu.getTkTemplateId());
        StyleTemplate tl = tl();
        if (tl == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.ZI).setRenderState(3).setErrorReason("timeout").setTemplateId(this.Zu.getTkTemplateId()).setVersionCode(String.valueOf(tl.templateVersionCode)).toJson());
    }

    private Map<String, Object> ts() {
        if (this.ZM == null) {
            HashMap hashMap = new HashMap();
            this.ZM = hashMap;
            hashMap.put("TKVersion", "6.0.7");
            this.ZM.put("SDKVersion", BuildConfig.VERSION_NAME);
            this.ZM.put("sdkType", 1);
        }
        return this.ZM;
    }

    private void tt() {
        String str;
        if (this.Zw != null && this.Zy != null) {
            File file = new File(new File(this.Zw.getJsBaseDir(this.mContext, this.Zu.getTkTemplateId())), "kcov.json");
            if (!file.exists()) {
                return;
            }
            try {
                String V = q.V(file);
                if (TextUtils.isEmpty(V)) {
                    return;
                }
                com.kwad.sdk.core.e.c.d("TKLoadController", "kcov.json:" + V);
                JSONObject jSONObject = new JSONObject(V);
                final String string = jSONObject.getString("gitHeadCommit");
                final String string2 = jSONObject.getString("coverageApi");
                final String string3 = jSONObject.getString("coverageTaskId");
                final String string4 = jSONObject.getString("currentBranch");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    if (("尝试获取覆盖率统计... " + this.Th) != null) {
                        str = this.Th.templateId;
                    } else {
                        str = "";
                    }
                    com.kwad.sdk.core.e.c.d("TKLoadController", str);
                    Object execute = this.Zy.execute("JSON.stringify(this.__coverage__)");
                    if (!(execute instanceof String)) {
                        return;
                    }
                    final String str2 = (String) execute;
                    com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.19
                        @Override // java.lang.Runnable
                        public final void run() {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("coverage_task_id", Integer.valueOf(string3));
                                jSONObject2.put("user", "");
                                jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
                                jSONObject2.put("branch_name", string4);
                                jSONObject2.put("version", BuildConfig.VERSION_NAME);
                                jSONObject2.put("tk_version", String.valueOf(i.this.Th.templateVersionCode));
                                jSONObject2.put("tk_template_ids", i.this.Th.templateId);
                            } catch (JSONException e) {
                                com.kwad.sdk.core.e.c.printStackTrace(e);
                            }
                            com.kwad.sdk.core.network.c doPost = com.kwad.sdk.g.yy().doPost(string2 + "/analysis/add/pkg/info", (Map<String, String>) null, jSONObject2);
                            if (doPost.Ew()) {
                                com.kwad.sdk.core.e.c.d("TKLoadController", "上传TK覆盖率pkg完成:" + doPost.awE);
                            } else {
                                com.kwad.sdk.core.e.c.d("TKLoadController", "上传覆盖率pkg失败");
                            }
                            com.kwad.sdk.core.network.c doPost2 = com.kwad.sdk.g.yy().doPost(string2 + "/attachment/ec", (Map<String, String>) null, new AdHttpBodyBuilder() { // from class: com.kwad.components.core.webview.tachikoma.i.19.1
                                @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                                public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                                    adHttpFormDataBuilder.addFormDataPart("task_id", string3);
                                    adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                                    adHttpFormDataBuilder.addFormDataPart("os_build_serial", "unknown");
                                    adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                                    adHttpFormDataBuilder.addFormDataPart(HttpConstants.APP_VERSION, BuildConfig.VERSION_NAME);
                                    adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                                    adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                                    adHttpFormDataBuilder.addFormDataPart("uid", "");
                                    adHttpFormDataBuilder.addFormDataPart("did", com.kwad.sdk.utils.aw.getDeviceId());
                                    adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                                    adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                                    try {
                                        adHttpFormDataBuilder.addFormDataPart("file", UUID.randomUUID().toString() + ".json", "application/octet-stream", str2.getBytes("UTF-8"));
                                    } catch (UnsupportedEncodingException e2) {
                                        com.kwad.sdk.core.e.c.printStackTrace(e2);
                                    }
                                }
                            });
                            if (doPost2.Ew()) {
                                com.kwad.sdk.core.e.c.d("TKLoadController", "上传TK覆盖率完成:" + doPost2.awE);
                                return;
                            }
                            com.kwad.sdk.core.e.c.d("TKLoadController", "上传TK覆盖率失败");
                        }
                    });
                    return;
                }
                com.kwad.sdk.core.e.c.d("TKLoadController", "kcov.json数据不合法，缺少关键字段gitHeadCommit | coverageApi | coverageTaskId | currentBranch");
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
    }

    public void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, r rVar, ViewGroup viewGroup) {
    }

    @Override // com.kwad.sdk.components.o
    public final void callJS(String str) {
        r rVar = this.Zy;
        if (rVar != null) {
            rVar.a(str, null, null);
        }
    }

    @Override // com.kwad.components.core.e.e.f
    public void dismiss() {
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sZ();
        }
    }

    public void f(String str, String str2) {
    }

    public void g(String str, String str2) {
    }

    public final String getTkTemplateId() {
        j jVar = this.Zu;
        if (jVar == null) {
            return null;
        }
        return jVar.getTkTemplateId();
    }

    public void jq() {
        com.kwad.sdk.core.view.d dVar = this.ZB;
        if (dVar != null) {
            dVar.getWindowFocusChangeHelper().b(this);
            this.ZB = null;
        }
        Future<?> future = this.Zx;
        if (future != null) {
            future.cancel(true);
        }
        bo.c(this.ZY);
        bo.c(this.ZZ);
        com.kwad.components.core.e.e.g.oQ().b(this);
        if (this.Wm != null) {
            com.kwad.sdk.core.download.b.DO().a(this.Wm);
        }
        com.kwad.components.core.webview.tachikoma.c.e eVar = this.Zt;
        if (eVar != null) {
            eVar.dismiss();
        }
        if (com.kwad.components.core.a.md.booleanValue()) {
            tt();
        }
        com.kwad.components.core.n.a.d.c cVar = this.Zw;
        if (cVar != null) {
            cVar.onDestroy();
        }
        final r rVar = this.Zy;
        if (rVar != null) {
            this.Zy = null;
            bo.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.18
                @Override // java.lang.Runnable
                public final void run() {
                    r rVar2 = rVar;
                    if (rVar2 != null) {
                        rVar2.onDestroy();
                    }
                }
            });
        }
    }

    public boolean nJ() {
        return false;
    }

    @Override // com.kwad.components.core.e.e.f
    public void show() {
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.ta();
        }
    }

    public final com.kwad.sdk.core.webview.b th() {
        return this.ZU;
    }

    public final AdTemplate tn() {
        return this.ZU.getAdTemplate();
    }

    public i(Context context, boolean z) {
        this.ZD = false;
        this.ZE = false;
        this.ZF = false;
        this.ZG = false;
        this.ZH = false;
        this.ZI = 0;
        this.xt = -1L;
        this.ZO = 1000;
        this.ZP = 0;
        this.ZQ = true;
        this.ZU = new com.kwad.sdk.core.webview.e();
        this.ZV = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.ZW = new p() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.sdk.components.p
            public final void a(com.kwad.sdk.components.k kVar) {
                StyleTemplate styleTemplate;
                Activity activity = i.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.c.b.En();
                    activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activity != null && !activity.isFinishing()) {
                    final String viewKey = kVar.getViewKey();
                    if (viewKey == null) {
                        styleTemplate = new StyleTemplate();
                        try {
                            styleTemplate.parseJson(styleTemplate, new JSONObject(kVar.getStyleTemplate()));
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTrace(th);
                            kVar.callbackPageStatus(false, "template parse failed");
                            return;
                        }
                    } else {
                        styleTemplate = null;
                    }
                    e.b bVar = new e.b();
                    bVar.d(i.this.mAdResultData);
                    bVar.c(kVar);
                    if (styleTemplate != null) {
                        bVar.a(styleTemplate);
                    }
                    if (viewKey != null) {
                        bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.1
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final m a(Object... objArr) {
                                if (i.this.Zy != null) {
                                    return i.this.Zy.bb(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    com.kwad.components.core.webview.tachikoma.c.e b = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                    b.show(activity.getFragmentManager(), "");
                    i.ZN.put(Integer.valueOf(kVar.getDialogId()), new WeakReference(b));
                    return;
                }
                kVar.callbackPageStatus(false, "no host activity");
            }

            @Override // com.kwad.sdk.components.p
            public final void b(com.kwad.sdk.components.k kVar) {
                WeakReference weakReference = (WeakReference) i.ZN.get(Integer.valueOf(kVar.getDialogId()));
                if (weakReference != null && weakReference.get() != null) {
                    ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
            
                if (r0 != com.kwad.sdk.core.c.b.getCurrentActivity()) goto L6;
             */
            @Override // com.kwad.sdk.components.p
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void a(com.kwad.sdk.components.l r8) {
                /*
                    r7 = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.b(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.c.b.En()
                    android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.c.b.En()
                    android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.String r3 = r8.getTemplateString()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r4 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    if (r3 == 0) goto L62
                    java.lang.String r3 = r8.getViewKey()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r3 = r8.getClassName()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lb9
                    java.lang.String r3 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.b.a(r4, r3)
                    com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r3 = r3.mContext
                    r2.setClass(r3, r4)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.r.a.a> r3 = com.kwad.components.core.r.a.a.class
                    com.kwad.sdk.service.b.a(r4, r3)
                    int r3 = com.kwad.components.core.r.a.a.rt()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.r.a.a.a(r3, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.c(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.ne()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.c(r6)
                    int r5 = r5.i(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = "tk_style_template"
                    java.lang.String r6 = r8.getTemplateString()
                    r2.putExtra(r5, r6)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$22$2 r6 = new com.kwad.components.core.webview.tachikoma.i$22$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.r.a.a.a(r3, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r3)
                    com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r3 = r3.mContext
                    r2.setClass(r3, r4)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lce
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                Lce:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Ld7
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Ld7
                    return
                Ld7:
                    r0 = move-exception
                    com.kwad.sdk.core.e.c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass22.a(com.kwad.sdk.components.l):void");
            }
        };
        this.ZX = new com.kwad.sdk.components.j() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.sdk.components.j
            public final com.kwad.sdk.components.i aS(int i) {
                return i.this.aC(com.kwad.sdk.core.response.b.c.n(com.kwad.components.core.n.a.d.a.a.at(i)));
            }

            @Override // com.kwad.sdk.components.j
            public final com.kwad.sdk.components.i aW(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aC(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.ZY = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "已经超时" + i.this.Zu.getTkTemplateId());
                i.this.tr();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.ZZ = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.gO = new l() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            private void g(double d) {
                i.this.wq.abj = false;
                i.this.wq.abf = false;
                i.this.wq.nF = (int) ((d / 1000.0d) + 0.5d);
                iV();
            }

            private void iV() {
                if (i.this.Zz != null && i.this.wq != null) {
                    i.this.Zz.a(i.this.wq);
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                i.this.wq.abf = true;
                i.this.wq.abj = false;
                i.this.wq.nF = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.dS(i.this.tn()));
                iV();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                i.this.wq.abj = true;
                i.this.wq.abf = false;
                iV();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j, long j2) {
                g(j2);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                g(OOXIXo.f3760XO);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                g(OOXIXo.f3760XO);
            }
        };
        this.mContext = context;
        this.xt = -1L;
        this.ZO = 1000;
        this.ZQ = z;
        this.wq = new y();
    }

    public static /* synthetic */ boolean c(i iVar, boolean z) {
        iVar.ZH = true;
        return true;
    }

    @Override // com.kwad.sdk.core.view.b
    public final void i(View view, boolean z) {
        av avVar;
        FrameLayout tKContainer = this.Zu.getTKContainer();
        if (tKContainer == null || !tKContainer.equals(view) || (avVar = this.ZA) == null) {
            return;
        }
        avVar.aU(z);
    }

    public static /* synthetic */ boolean b(i iVar, boolean z) {
        iVar.ZE = true;
        return true;
    }

    private void c(StyleTemplate styleTemplate) {
        if (com.kwad.components.core.a.md.booleanValue() && this.Zu.getTKContainer() != null) {
            if (this.ZC == null) {
                TextView textView = new TextView(this.mContext);
                this.ZC = textView;
                textView.setTextSize(12.0f);
                this.ZC.setTextColor(SupportMenu.CATEGORY_MASK);
                this.Zu.getTKContainer().addView(this.ZC);
            }
            this.ZC.setText(styleTemplate.templateId + " " + styleTemplate.templateVersionCode);
            this.ZC.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Throwable th) {
        com.kwad.sdk.core.e.c.d("TKLoadController", "logTkRenderFail : " + th + ", templateId = " + this.Zu.getTkTemplateId());
        String tkTemplateId = this.Zu.getTkTemplateId();
        StringBuilder sb = new StringBuilder("error:");
        sb.append(th.toString());
        g(tkTemplateId, sb.toString());
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.ZI).setRenderState(3).setErrorReason(th.toString()).setTemplateId(this.Zu.getTkTemplateId()).setVersionCode(String.valueOf(this.Th.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final StyleTemplate styleTemplate) {
        com.kwad.sdk.utils.i.b("", "renderType_tk", styleTemplate.templateId, styleTemplate.templateUrl);
        com.kwad.sdk.core.e.c.d("TKLoadController", "读取完毕，总耗时" + (SystemClock.elapsedRealtime() - this.Fe) + ", 读取成功" + styleTemplate.templateId);
        if (this.ZD) {
            return;
        }
        com.kwad.sdk.core.e.c.d("TKLoadController", "没有超时");
        bo.c(this.ZY);
        bo.runOnUiThread(new az() { // from class: com.kwad.components.core.webview.tachikoma.i.12
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                i iVar = i.this;
                iVar.a(styleTemplate, iVar.ZV);
            }
        });
        ViewParent tKContainer = this.Zu.getTKContainer();
        if (tKContainer instanceof com.kwad.sdk.core.view.d) {
            com.kwad.sdk.core.view.d dVar = (com.kwad.sdk.core.view.d) tKContainer;
            this.ZB = dVar;
            dVar.getWindowFocusChangeHelper().a(this);
        }
    }

    public ak c(com.kwad.sdk.core.webview.b bVar) {
        return new ak(bVar);
    }

    public static /* synthetic */ boolean a(i iVar, boolean z) {
        iVar.ZD = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final TKRenderFailReason tKRenderFailReason) {
        bo.postOnUiThread(new az() { // from class: com.kwad.components.core.webview.tachikoma.i.2
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (i.this.ZH) {
                    return;
                }
                i.c(i.this, true);
                i.this.Zu.a(tKRenderFailReason);
                com.kwad.components.core.e.e.g.oQ().b(i.this);
                com.kwad.components.core.webview.tachikoma.d.b.tG().s(i.this.ZR, i.this.ZS);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(aj.a aVar) {
        FrameLayout tKContainer = this.Zu.getTKContainer();
        if (tKContainer != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tKContainer.getLayoutParams();
            layoutParams.height = com.kwad.sdk.c.a.a.a(this.mContext, aVar.height);
            layoutParams.leftMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.leftMargin);
            layoutParams.rightMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.rightMargin);
            layoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.bottomMargin);
            layoutParams.width = -1;
            tKContainer.setLayoutParams(layoutParams);
        }
    }

    public final void a(StyleTemplate styleTemplate) {
        this.Th = styleTemplate;
    }

    public void a(@Nullable Activity activity, AdResultData adResultData, j jVar) {
        this.mActivity = activity;
        this.mAdResultData = adResultData;
        this.ZU.d(adResultData);
        this.Zu = jVar;
        this.ZR = jVar.getTkTemplateId();
        this.ZS = this.Zu.getTKReaderScene();
        ti();
        FrameLayout tKContainer = this.Zu.getTKContainer();
        if (tKContainer != null) {
            tKContainer.removeAllViews();
        }
        if (!com.kwad.sdk.core.config.d.CE()) {
            b(TKRenderFailReason.SWITCH_CLOSE);
            return;
        }
        this.Zw = (com.kwad.components.core.n.a.d.c) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.d.c.class);
        to();
        com.kwad.sdk.core.e.c.d("TKLoadController", "bind mTKPlugin: " + this.Zw);
        if (TextUtils.isEmpty(this.ZR)) {
            com.kwad.sdk.commercial.e.a.e(tn(), this.ZS);
        }
        if (this.Zw != null) {
            tj();
            return;
        }
        b(TKRenderFailReason.PLUGIN_NOT_READY);
        f(this.ZR, TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED);
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.ZI).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.ZR).toJson());
    }

    public i(long j, Context context) {
        this.ZD = false;
        this.ZE = false;
        this.ZF = false;
        this.ZG = false;
        this.ZH = false;
        this.ZI = 0;
        this.xt = -1L;
        this.ZO = 1000;
        this.ZP = 0;
        this.ZQ = true;
        this.ZU = new com.kwad.sdk.core.webview.e();
        this.ZV = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.ZW = new p() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.sdk.components.p
            public final void a(com.kwad.sdk.components.k kVar) {
                StyleTemplate styleTemplate;
                Activity activity = i.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.c.b.En();
                    activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activity != null && !activity.isFinishing()) {
                    final String viewKey = kVar.getViewKey();
                    if (viewKey == null) {
                        styleTemplate = new StyleTemplate();
                        try {
                            styleTemplate.parseJson(styleTemplate, new JSONObject(kVar.getStyleTemplate()));
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTrace(th);
                            kVar.callbackPageStatus(false, "template parse failed");
                            return;
                        }
                    } else {
                        styleTemplate = null;
                    }
                    e.b bVar = new e.b();
                    bVar.d(i.this.mAdResultData);
                    bVar.c(kVar);
                    if (styleTemplate != null) {
                        bVar.a(styleTemplate);
                    }
                    if (viewKey != null) {
                        bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.1
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final m a(Object... objArr) {
                                if (i.this.Zy != null) {
                                    return i.this.Zy.bb(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    com.kwad.components.core.webview.tachikoma.c.e b = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                    b.show(activity.getFragmentManager(), "");
                    i.ZN.put(Integer.valueOf(kVar.getDialogId()), new WeakReference(b));
                    return;
                }
                kVar.callbackPageStatus(false, "no host activity");
            }

            @Override // com.kwad.sdk.components.p
            public final void b(com.kwad.sdk.components.k kVar) {
                WeakReference weakReference = (WeakReference) i.ZN.get(Integer.valueOf(kVar.getDialogId()));
                if (weakReference != null && weakReference.get() != null) {
                    ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
                }
            }

            @Override // com.kwad.sdk.components.p
            public final void a(com.kwad.sdk.components.l lVar) {
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                    	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                    */
                /*
                    this = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.b(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.c.b.En()
                    android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.c.b.En()
                    android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.String r3 = r8.getTemplateString()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r4 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    if (r3 == 0) goto L62
                    java.lang.String r3 = r8.getViewKey()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r3 = r8.getClassName()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lb9
                    java.lang.String r3 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.b.a(r4, r3)
                    com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r3 = r3.mContext
                    r2.setClass(r3, r4)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.r.a.a> r3 = com.kwad.components.core.r.a.a.class
                    com.kwad.sdk.service.b.a(r4, r3)
                    int r3 = com.kwad.components.core.r.a.a.rt()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.r.a.a.a(r3, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.c(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.ne()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.c(r6)
                    int r5 = r5.i(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = "tk_style_template"
                    java.lang.String r6 = r8.getTemplateString()
                    r2.putExtra(r5, r6)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$22$2 r6 = new com.kwad.components.core.webview.tachikoma.i$22$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.r.a.a.a(r3, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r3)
                    com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r3 = r3.mContext
                    r2.setClass(r3, r4)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lce
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                Lce:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Ld7
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Ld7
                    return
                Ld7:
                    r0 = move-exception
                    com.kwad.sdk.core.e.c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass22.a(com.kwad.sdk.components.l):void");
            }
        };
        this.ZX = new com.kwad.sdk.components.j() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.sdk.components.j
            public final com.kwad.sdk.components.i aS(int i) {
                return i.this.aC(com.kwad.sdk.core.response.b.c.n(com.kwad.components.core.n.a.d.a.a.at(i)));
            }

            @Override // com.kwad.sdk.components.j
            public final com.kwad.sdk.components.i aW(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aC(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.ZY = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "已经超时" + i.this.Zu.getTkTemplateId());
                i.this.tr();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.ZZ = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.gO = new l() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            private void g(double d) {
                i.this.wq.abj = false;
                i.this.wq.abf = false;
                i.this.wq.nF = (int) ((d / 1000.0d) + 0.5d);
                iV();
            }

            private void iV() {
                if (i.this.Zz != null && i.this.wq != null) {
                    i.this.Zz.a(i.this.wq);
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                i.this.wq.abf = true;
                i.this.wq.abj = false;
                i.this.wq.nF = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.dS(i.this.tn()));
                iV();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i, int i2) {
                i.this.wq.abj = true;
                i.this.wq.abf = false;
                iV();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j2, long j22) {
                g(j22);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                g(OOXIXo.f3760XO);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                g(OOXIXo.f3760XO);
            }
        };
        this.mContext = context;
        this.xt = j;
        this.wq = new y();
    }

    public final void a(com.kwad.sdk.core.webview.c.g gVar) {
        this.Zv = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TKDownloadListener tKDownloadListener) {
        StyleTemplate tl = tl();
        if (tl == null) {
            tKDownloadListener.onFailed("no template");
            return;
        }
        if (!isLocalDebugEnable()) {
            String n = h.tf().n(tl.templateId, tl.templateVersionCode);
            if (!TextUtils.isEmpty(n) && !isLocalDebugEnable()) {
                tl.jsStr = n;
                tl.tkSouce = 4;
                com.kwad.sdk.core.e.c.d("TKLoadController", "使用TK模板缓存");
                tKDownloadListener.onSuccess(tl);
                return;
            }
        }
        this.Zw.loadTkFileByTemplateId(this.mContext, tl.templateId, tl.templateMd5, tl.templateUrl, tl.templateVersionCode, tKDownloadListener);
    }

    public i(Context context, int i, int i2) {
        this.ZD = false;
        this.ZE = false;
        this.ZF = false;
        this.ZG = false;
        this.ZH = false;
        this.ZI = 0;
        this.xt = -1L;
        this.ZO = 1000;
        this.ZP = 0;
        this.ZQ = true;
        this.ZU = new com.kwad.sdk.core.webview.e();
        this.ZV = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.b(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.ZW = new p() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.sdk.components.p
            public final void a(com.kwad.sdk.components.k kVar) {
                StyleTemplate styleTemplate;
                Activity activity = i.this.mActivity;
                if (activity == null) {
                    com.kwad.sdk.core.c.b.En();
                    activity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activity != null && !activity.isFinishing()) {
                    final String viewKey = kVar.getViewKey();
                    if (viewKey == null) {
                        styleTemplate = new StyleTemplate();
                        try {
                            styleTemplate.parseJson(styleTemplate, new JSONObject(kVar.getStyleTemplate()));
                        } catch (Throwable th) {
                            com.kwad.sdk.core.e.c.printStackTrace(th);
                            kVar.callbackPageStatus(false, "template parse failed");
                            return;
                        }
                    } else {
                        styleTemplate = null;
                    }
                    e.b bVar = new e.b();
                    bVar.d(i.this.mAdResultData);
                    bVar.c(kVar);
                    if (styleTemplate != null) {
                        bVar.a(styleTemplate);
                    }
                    if (viewKey != null) {
                        bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.1
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final m a(Object... objArr) {
                                if (i.this.Zy != null) {
                                    return i.this.Zy.bb(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    com.kwad.components.core.webview.tachikoma.c.e b = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                    b.show(activity.getFragmentManager(), "");
                    i.ZN.put(Integer.valueOf(kVar.getDialogId()), new WeakReference(b));
                    return;
                }
                kVar.callbackPageStatus(false, "no host activity");
            }

            @Override // com.kwad.sdk.components.p
            public final void b(com.kwad.sdk.components.k kVar) {
                WeakReference weakReference = (WeakReference) i.ZN.get(Integer.valueOf(kVar.getDialogId()));
                if (weakReference != null && weakReference.get() != null) {
                    ((com.kwad.components.core.webview.tachikoma.c.e) weakReference.get()).dismiss();
                }
            }

            /*  JADX ERROR: Method code generation error
                java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                */
            @Override // com.kwad.sdk.components.p
            public final void a(com.kwad.sdk.components.l r8) {
                /*
                    r7 = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.i.b(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.c.b.En()
                    android.app.Activity r1 = com.kwad.sdk.core.c.b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.c.b.En()
                    android.app.Activity r0 = com.kwad.sdk.core.c.b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.String r3 = r8.getTemplateString()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r4 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    if (r3 == 0) goto L62
                    java.lang.String r3 = r8.getViewKey()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r3 = r8.getClassName()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lb9
                    java.lang.String r3 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.b.a(r4, r3)
                    com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r3 = r3.mContext
                    r2.setClass(r3, r4)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.r.a.a> r3 = com.kwad.components.core.r.a.a.class
                    com.kwad.sdk.service.b.a(r4, r3)
                    int r3 = com.kwad.components.core.r.a.a.rt()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.r.a.a.a(r3, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.i.c(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.c.f.ne()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.i.c(r6)
                    int r5 = r5.i(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = "tk_style_template"
                    java.lang.String r6 = r8.getTemplateString()
                    r2.putExtra(r5, r6)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$22$2 r6 = new com.kwad.components.core.webview.tachikoma.i$22$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.r.a.a.a(r3, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r3)
                    com.kwad.components.core.webview.tachikoma.i r3 = com.kwad.components.core.webview.tachikoma.i.this
                    android.content.Context r3 = r3.mContext
                    r2.setClass(r3, r4)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lce
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                Lce:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Ld7
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Ld7
                    return
                Ld7:
                    r0 = move-exception
                    com.kwad.sdk.core.e.c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.i.AnonymousClass22.a(com.kwad.sdk.components.l):void");
            }
        };
        this.ZX = new com.kwad.sdk.components.j() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.sdk.components.j
            public final com.kwad.sdk.components.i aS(int i3) {
                return i.this.aC(com.kwad.sdk.core.response.b.c.n(com.kwad.components.core.n.a.d.a.a.at(i3)));
            }

            @Override // com.kwad.sdk.components.j
            public final com.kwad.sdk.components.i aW(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.aC(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.ZY = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.e.c.d("TKLoadController", "已经超时" + i.this.Zu.getTkTemplateId());
                i.this.tr();
                i.a(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.ZZ = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.gO = new l() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            private void g(double d) {
                i.this.wq.abj = false;
                i.this.wq.abf = false;
                i.this.wq.nF = (int) ((d / 1000.0d) + 0.5d);
                iV();
            }

            private void iV() {
                if (i.this.Zz != null && i.this.wq != null) {
                    i.this.Zz.a(i.this.wq);
                }
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                i.this.wq.abf = true;
                i.this.wq.abj = false;
                i.this.wq.nF = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.dS(i.this.tn()));
                iV();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayError(int i3, int i22) {
                i.this.wq.abj = true;
                i.this.wq.abf = false;
                iV();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayProgress(long j2, long j22) {
                g(j22);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                g(OOXIXo.f3760XO);
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPreparing() {
                g(OOXIXo.f3760XO);
            }
        };
        this.mContext = context;
        this.ZO = i;
        this.wq = new y();
        this.ZP = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StyleTemplate styleTemplate, final a aVar) {
        this.Th = styleTemplate;
        com.kwad.sdk.core.e.c.w("TKLoadController", "addTKView mTKPlugin.getState(): " + this.Zw.getState());
        if (this.Zw.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            aU(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(styleTemplate.jsStr)) {
            aV(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        try {
            tp();
            this.ZK = SystemClock.elapsedRealtime();
            r a2 = this.Zw.a(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce, this.ZQ);
            com.kwad.components.core.n.a.d.a.a.a(a2.getUniqId(), this.mAdResultData);
            a2.a(this.ZW);
            a2.a(this.ZX);
            AdResultData adResultData = this.mAdResultData;
            if (adResultData != null && com.kwad.sdk.core.response.b.c.n(adResultData).mAdScene != null) {
                ts().put("adStyle", Integer.valueOf(com.kwad.sdk.core.response.b.c.n(this.mAdResultData).mAdScene.getAdStyle()));
                ts().put("adScene", com.kwad.sdk.core.response.b.c.n(this.mAdResultData).mAdScene.toJson().toString());
            }
            if (this.Th != null) {
                ts().put("styleTemplate", this.Th.toJson().toString());
            }
            ts().put("adCacheId", Integer.valueOf(a2.getUniqId()));
            ts().put(com.huawei.openalliance.ad.uriaction.i.Code, ServiceProvider.getAppId());
            ts().put("isDebug", com.kwad.components.core.a.md);
            a2.setCustomEnv(ts());
            this.Zy = a2;
            com.kwad.sdk.core.c.b.En();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null) {
                ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView();
                ts().put("isImmersiveMode", Boolean.valueOf(com.kwad.sdk.c.a.a.C(viewGroup) && com.kwad.sdk.c.a.a.aV(currentActivity) == viewGroup.getHeight()));
            }
            a2.setCustomEnv(ts());
            com.kwad.sdk.core.webview.c.g gVar = this.Zv;
            if (gVar != null) {
                a2.b(gVar);
            }
            this.ZL = SystemClock.elapsedRealtime() - this.ZK;
            this.ZJ = SystemClock.elapsedRealtime();
            tm();
            a(a2);
            File file = new File(this.Zw.getJsBaseDir(this.mContext, this.Zu.getTkTemplateId()));
            a2.a(styleTemplate.jsStr, file.getAbsolutePath() + "/", new com.kwad.sdk.components.q() { // from class: com.kwad.components.core.webview.tachikoma.i.21
                @Override // com.kwad.sdk.components.q
                public final void onFailed(Throwable th) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onFailed();
                    }
                    i.this.f(th);
                }

                @Override // com.kwad.sdk.components.q
                public final void onSuccess() {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.onSuccess();
                    }
                }
            });
            FrameLayout tKContainer = this.Zu.getTKContainer();
            if (tKContainer == null || !this.ZQ) {
                return;
            }
            View view = a2.getView();
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            tKContainer.addView(view);
            c(styleTemplate);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
            f(th);
            if (aVar != null) {
                aVar.onFailed();
            }
        }
    }

    private void a(r rVar) {
        com.kwad.components.core.e.d.c cVar = tn() != null ? new com.kwad.components.core.e.d.c(tn()) : null;
        this.Zu.a(rVar, this.ZU);
        a(rVar, new com.kwad.components.core.webview.jshandler.o());
        a(rVar, new com.kwad.components.core.webview.jshandler.p());
        s sVar = new s();
        sVar.a(new s.a() { // from class: com.kwad.components.core.webview.tachikoma.i.3
            @Override // com.kwad.components.core.webview.tachikoma.a.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.b.s sVar2) {
                if (!TextUtils.isEmpty(sVar2.message)) {
                    v.d(i.this.mContext, sVar2.message, 0L);
                }
            }
        });
        a(rVar, sVar);
        a(rVar, c(this.ZU));
        a(rVar, new com.kwad.components.core.webview.jshandler.l(this.ZU));
        a(rVar, new com.kwad.components.core.webview.jshandler.m(this.ZU));
        a(rVar, new com.kwad.sdk.core.webview.d.a());
        a(rVar, new com.kwad.components.core.webview.tachikoma.a.f());
        a(rVar, new x());
        if (nJ()) {
            com.kwad.components.core.webview.jshandler.x xVar = new com.kwad.components.core.webview.jshandler.x(this.ZU, cVar, this);
            if (!this.ZR.equals(com.kwad.sdk.core.response.b.b.cR(this.ZU.getAdTemplate()))) {
                com.kwad.components.core.e.e.g.oQ().a(this);
            }
            a(rVar, xVar);
        } else {
            a(rVar, new aa(this.ZU, cVar, this, (byte) 0));
        }
        a(rVar, new z(this.ZU));
        a(rVar, new com.kwad.components.core.webview.tachikoma.a.k());
        a(rVar, new ad(this.ZU));
        a(rVar, new ag(this.ZU));
        a(rVar, new ap(this.mContext, tn()));
        ac acVar = new ac(this.ZU);
        acVar.a(new ac.b() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.components.core.webview.jshandler.ac.b
            public final void c(ac.a aVar) {
                i.this.Zu.b(aVar);
            }
        });
        a(rVar, acVar);
        a(rVar, new com.kwad.components.core.webview.jshandler.aj(this.ZU, new aj.b() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.components.core.webview.jshandler.aj.b
            public final void a(aj.a aVar) {
                i.this.b(aVar);
            }
        }));
        a(rVar, new aq(new aq.b() { // from class: com.kwad.components.core.webview.tachikoma.i.6
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar) {
                long j;
                if (aVar.status != 1) {
                    i.this.b(TKRenderFailReason.RENDER_ERROR);
                    i.this.aV(aVar.errorMsg);
                    return;
                }
                if (i.this.ZE) {
                    i.this.b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
                    return;
                }
                bo.c(i.this.ZZ);
                i.this.tq();
                if (i.this.Zu != null) {
                    bo.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.6.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.this.Zu.bF();
                        }
                    });
                    com.kwad.components.core.webview.tachikoma.d.b tG = com.kwad.components.core.webview.tachikoma.d.b.tG();
                    String tkTemplateId = i.this.Zu.getTkTemplateId();
                    long j2 = i.this.ZK - i.this.Fe;
                    long j3 = i.this.ZL;
                    if (i.this.ZJ > 0) {
                        j = SystemClock.elapsedRealtime() - i.this.ZJ;
                    } else {
                        j = 0;
                    }
                    tG.c(tkTemplateId, j2, j3, j);
                }
            }
        }));
        aw awVar = new aw();
        this.cQ = awVar;
        a(rVar, awVar);
        this.Zu.a(this.cQ);
        av avVar = new av();
        this.ZA = avVar;
        a(rVar, avVar);
        a(rVar, new com.kwad.components.core.webview.jshandler.az(this.ZU, cVar));
        com.kwad.components.core.webview.tachikoma.a.p pVar = new com.kwad.components.core.webview.tachikoma.a.p();
        this.Zz = pVar;
        a(rVar, pVar);
        this.Zu.a(this.Zz);
        a(rVar, new com.kwad.components.core.webview.jshandler.a(new a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // com.kwad.components.core.webview.jshandler.a.b
            public final void c(a.C0809a c0809a) {
                i.this.Zu.a(c0809a);
            }
        }));
        if (tn() != null && com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dS(tn()))) {
            final com.kwad.components.core.webview.tachikoma.a.l lVar = new com.kwad.components.core.webview.tachikoma.a.l();
            a(rVar, lVar);
            this.Wm = new com.kwad.sdk.core.download.d(tn()) { // from class: com.kwad.components.core.webview.tachikoma.i.8
                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.b.b bVar = new com.kwad.components.core.webview.tachikoma.b.b();
                    bVar.aaR = 1;
                    lVar.a(bVar);
                }
            };
            com.kwad.sdk.core.download.b.DO().a(this.Wm, tn());
        }
        t tVar = new t();
        tVar.a(new t.a() { // from class: com.kwad.components.core.webview.tachikoma.i.9
            @Override // com.kwad.components.core.webview.tachikoma.a.t.a
            public final void b(com.kwad.components.core.webview.tachikoma.b.t tVar2) {
                i.this.Zu.a(tVar2);
            }
        });
        a(rVar, tVar);
        com.kwad.components.core.webview.tachikoma.a.v vVar = new com.kwad.components.core.webview.tachikoma.a.v();
        vVar.a(new v.a() { // from class: com.kwad.components.core.webview.tachikoma.i.10
            @Override // com.kwad.components.core.webview.tachikoma.a.v.a
            public final void b(com.kwad.components.core.webview.tachikoma.b.m mVar) {
                i.this.Zu.a(mVar);
            }
        });
        a(rVar, vVar);
        com.kwad.components.core.webview.tachikoma.a.o oVar = new com.kwad.components.core.webview.tachikoma.a.o();
        a(rVar, oVar);
        this.Zu.a(oVar);
        a(rVar, new com.kwad.components.core.webview.tachikoma.a.r() { // from class: com.kwad.components.core.webview.tachikoma.i.11
            @Override // com.kwad.components.core.webview.tachikoma.a.r
            public final void a(com.kwad.components.core.webview.tachikoma.b.r rVar2) {
                super.a(rVar2);
                if (i.this.mActivity == null) {
                    i iVar = i.this;
                    com.kwad.sdk.core.c.b.En();
                    iVar.mActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (i.this.mActivity != null && !i.this.mActivity.isFinishing()) {
                    if (i.this.Zt != null) {
                        i.this.Zt.dismiss();
                    }
                    e.b bVar = new e.b();
                    bVar.d(i.this.mAdResultData);
                    bVar.aX(rVar2.templateId);
                    i.this.Zt = com.kwad.components.core.webview.tachikoma.c.e.b(bVar);
                    i.this.Zt.show(i.this.mActivity.getFragmentManager(), "");
                }
            }
        });
        a(rVar, new com.kwad.components.core.webview.tachikoma.a.c() { // from class: com.kwad.components.core.webview.tachikoma.i.13
            @Override // com.kwad.components.core.webview.tachikoma.a.c
            public final void iY() {
                super.iY();
                if (i.this.Zt != null) {
                    i.this.Zt.dismiss();
                }
                j jVar = i.this.Zu;
                if (jVar != null) {
                    jVar.bG();
                }
            }
        });
        a(rVar, new com.kwad.components.core.webview.jshandler.y(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.14
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                i.this.Zu.a(webCloseStatus);
            }
        }));
        a(rVar, new com.kwad.components.core.webview.tachikoma.a.d() { // from class: com.kwad.components.core.webview.tachikoma.i.15
            @Override // com.kwad.components.core.webview.tachikoma.a.d
            public final void a(com.kwad.components.core.webview.tachikoma.b.g gVar) {
                AdTemplate adTemplate;
                int i = gVar.Wy;
                if (i >= 0) {
                    adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.at(i), gVar.JK);
                } else {
                    adTemplate = null;
                }
                if (adTemplate == null) {
                    adTemplate = i.this.tn();
                }
                com.kwad.components.core.o.a.qI().a(gVar.actionType, adTemplate, gVar.Lh);
            }
        });
        a(rVar, new com.kwad.components.core.webview.tachikoma.a.j() { // from class: com.kwad.components.core.webview.tachikoma.i.16
            @Override // com.kwad.components.core.webview.tachikoma.a.j
            public final void a(n nVar) {
                super.a(nVar);
                AdWebViewActivityProxy.launch(i.this.mContext, new AdWebViewActivityProxy.a.C0799a().at(nVar.title).au(nVar.url).aE(!nVar.abb).m(i.this.mAdResultData).pK());
            }
        });
        a(rVar, new com.kwad.components.core.webview.tachikoma.a.a(tn()));
        a(rVar, new com.kwad.components.core.webview.tachikoma.a(tn()));
        a(this.ZU, cVar, rVar, this.Zu.getTKContainer());
    }

    private static void a(r rVar, com.kwad.sdk.core.webview.c.a aVar) {
        rVar.c(aVar);
    }

    public final void a(String str, Object obj) {
        ts().put(str, obj);
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        j jVar = this.Zu;
        if (jVar != null) {
            jVar.a(aVar);
        }
    }
}
