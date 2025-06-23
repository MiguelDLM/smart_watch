package com.kwad.components.core.webview.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.offline.api.tk.model.BundleServiceConfig;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.r;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class g {
    private final Map<String, a> Ze = new ConcurrentHashMap();

    /* loaded from: classes11.dex */
    public static class a {
        public i Zj;
        public boolean Zk;
        public List<b> Zl = new ArrayList();

        public a(i iVar) {
            this.Zj = iVar;
        }

        public final void a(b bVar) {
            if (bVar != null) {
                this.Zl.add(bVar);
            }
        }

        public final void aQ(final String str) {
            bo.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    Iterator<b> it = a.this.Zl.iterator();
                    while (it.hasNext()) {
                        it.next().onFailed(str);
                    }
                    a.this.Zl.clear();
                }
            });
        }

        public final void td() {
            bo.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.g.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    Iterator<b> it = a.this.Zl.iterator();
                    while (it.hasNext()) {
                        it.next().onSuccess();
                    }
                    a.this.Zl.clear();
                }
            });
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onFailed(String str);

        void onSuccess();
    }

    /* loaded from: classes11.dex */
    public static class c {
        private static final g Zo = new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(Context context) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "begin load all services");
        SdkConfigData CK = com.kwad.sdk.core.config.d.CK();
        if (context == null || (optJSONObject = CK.toJson().optJSONObject("appConfig")) == null || (optJSONArray = optJSONObject.optJSONArray("tkServiceConfigs")) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            BundleServiceConfig bundleServiceConfig = new BundleServiceConfig();
            bundleServiceConfig.parseJson(optJSONArray.optJSONObject(i));
            if (bundleServiceConfig.loadType == 1) {
                b(context, bundleServiceConfig.bundleName, null);
            }
        }
    }

    private static boolean isLocalDebugEnable() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    public static g tc() {
        return c.Zo;
    }

    public final void b(Context context, String str, b bVar) {
        JSONArray optJSONArray;
        if (isLocalDebugEnable()) {
            unloadBundle(str);
        }
        com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle:" + str);
        if (TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle fail: invalid bundle name");
            if (bVar != null) {
                bVar.onFailed("invalid bundle name");
                return;
            }
            return;
        }
        SdkConfigData CK = com.kwad.sdk.core.config.d.CK();
        if (CK == null) {
            com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle fail: config data empty");
            if (bVar != null) {
                bVar.onFailed("config data empty");
                return;
            }
            return;
        }
        if (context == null) {
            com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle fail: no context");
            if (bVar != null) {
                bVar.onFailed("no context");
                return;
            }
            return;
        }
        JSONObject optJSONObject = CK.toJson().optJSONObject("styleTemplatesConfig");
        StyleTemplate styleTemplate = null;
        if (optJSONObject == null) {
            optJSONArray = null;
        } else {
            optJSONArray = optJSONObject.optJSONArray("styleTemplates");
        }
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                if (i >= optJSONArray.length()) {
                    break;
                }
                StyleTemplate styleTemplate2 = new StyleTemplate();
                styleTemplate2.parseJson(optJSONArray.optJSONObject(i));
                String str2 = styleTemplate2.templateId;
                if (str2 != null && str2.equals(str)) {
                    styleTemplate = styleTemplate2;
                    break;
                }
                i++;
            }
        }
        if (isLocalDebugEnable() && styleTemplate == null) {
            styleTemplate = new StyleTemplate();
            styleTemplate.templateId = str;
        }
        if (styleTemplate == null) {
            com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle fail: no bundle");
            if (bVar != null) {
                bVar.onFailed("no bundle");
                return;
            }
            return;
        }
        a(context, styleTemplate, bVar);
    }

    public final void init() {
        try {
            com.kwad.components.core.n.a.d.b bVar = (com.kwad.components.core.n.a.d.b) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.d.b.class);
            if (bVar != null) {
                bVar.a(new com.kwad.components.core.n.a.d.a() { // from class: com.kwad.components.core.webview.tachikoma.g.1
                    @Override // com.kwad.components.core.n.a.d.a
                    public final void a(int i, int i2, long j, long j2) {
                        g.this.at(KsAdSDK.getContext());
                    }
                });
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void unloadBundle(String str) {
        if (this.Ze.get(str) != null) {
            com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "unload bundle" + str);
            a aVar = this.Ze.get(str);
            if (aVar != null) {
                aVar.Zj.jq();
            }
            this.Ze.remove(str);
        }
    }

    public final void a(Context context, String str, b bVar) {
        if (TextUtils.isEmpty(str)) {
            bVar.onFailed("invalid bundle string");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            StyleTemplate styleTemplate = new StyleTemplate();
            styleTemplate.parseJson(jSONObject);
            if (TextUtils.isEmpty(styleTemplate.templateId) || TextUtils.isEmpty(styleTemplate.templateUrl)) {
                bVar.onFailed("invalid bundle:" + str);
            }
            a(context, styleTemplate, bVar);
        } catch (Throwable th) {
            bVar.onFailed(th.getMessage());
        }
    }

    private void a(Context context, final StyleTemplate styleTemplate, b bVar) {
        final String str = styleTemplate.templateId;
        if (str == null) {
            if (bVar != null) {
                bVar.onFailed("no bundle");
                return;
            }
            return;
        }
        a aVar = this.Ze.get(str);
        if (aVar != null) {
            if (aVar.Zk) {
                com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle finish: already load");
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            aVar.a(bVar);
            return;
        }
        i iVar = new i(context, false);
        iVar.a("isService", Boolean.TRUE);
        final a aVar2 = new a(iVar);
        aVar2.a(bVar);
        iVar.a(styleTemplate);
        iVar.a((Activity) null, (AdResultData) null, new j() { // from class: com.kwad.components.core.webview.tachikoma.g.2
            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(a.C0809a c0809a) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void b(ac.a aVar3) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void bF() {
                com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle success: done");
                a aVar3 = aVar2;
                aVar3.Zk = true;
                aVar3.td();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void bG() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final FrameLayout getTKContainer() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTKReaderScene() {
                return "tk_bundle_service";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTkTemplateId() {
                return styleTemplate.templateId;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final com.kwad.sdk.widget.e getTouchCoordsView() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(aw awVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(o oVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(p pVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(m mVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(t tVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(WebCloseStatus webCloseStatus) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(r rVar, com.kwad.sdk.core.webview.b bVar2) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar3) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(TKRenderFailReason tKRenderFailReason) {
                com.kwad.sdk.core.e.c.d("KSAdTKBundleService", "load bundle fail: execute fail");
                aVar2.aQ("execute fail");
                g.this.unloadBundle(str);
            }
        });
        this.Ze.put(str, aVar2);
    }
}
