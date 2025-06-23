package com.kwad.components.offline.c.a;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.IOfflineTKView;
import com.kwad.sdk.components.j;
import com.kwad.sdk.components.m;
import com.kwad.sdk.components.p;
import com.kwad.sdk.components.q;
import com.kwad.sdk.components.r;
import com.kwad.sdk.utils.aq;
import java.util.Map;

/* loaded from: classes11.dex */
public final class i implements r {
    private final IOfflineCompoTachikomaContext aei;

    public i(@NonNull IOfflineCompoTachikomaContext iOfflineCompoTachikomaContext) {
        aq.checkNotNull(iOfflineCompoTachikomaContext);
        this.aei = iOfflineCompoTachikomaContext;
    }

    @Override // com.kwad.sdk.components.r
    public final void a(String str, String str2, q qVar) {
        this.aei.execute(str, str2, new h(qVar));
    }

    @Override // com.kwad.sdk.components.r
    public final void b(com.kwad.sdk.core.webview.c.g gVar) {
        if (gVar == null) {
            return;
        }
        this.aei.registerTKBridge(new f(gVar));
    }

    @Override // com.kwad.sdk.components.r
    public final m bb(String str) {
        final IOfflineTKView tKView = this.aei.getTKView(str, new Object[0]);
        return new m() { // from class: com.kwad.components.offline.c.a.i.1
            @Override // com.kwad.sdk.components.m
            public final void bindActivity(Activity activity) {
                tKView.bindActivity(activity);
            }

            @Override // com.kwad.sdk.components.m
            public final View getView() {
                return tKView.getView();
            }

            @Override // com.kwad.sdk.components.m
            public final boolean onBackPressed() {
                return tKView.onBackPressed();
            }

            @Override // com.kwad.sdk.components.m
            public final void render() {
                tKView.render();
            }
        };
    }

    @Override // com.kwad.sdk.components.r
    public final void c(com.kwad.sdk.core.webview.c.a aVar) {
        if (aVar == null) {
            return;
        }
        this.aei.registerJsBridge(new b(aVar));
    }

    @Override // com.kwad.sdk.components.r
    public final Object execute(String str) {
        return this.aei.execute(str);
    }

    @Override // com.kwad.sdk.components.r
    public final int getUniqId() {
        return this.aei.getUniqId();
    }

    @Override // com.kwad.sdk.components.r
    public final View getView() {
        return this.aei.getView();
    }

    @Override // com.kwad.sdk.components.r
    public final void onDestroy() {
        this.aei.onDestroy();
    }

    @Override // com.kwad.sdk.components.r
    public final void setCustomEnv(Map<String, Object> map) {
        this.aei.setCustomEnv(map);
    }

    @Override // com.kwad.sdk.components.r
    public final void a(p pVar) {
        if (pVar != null) {
            this.aei.registerHostActionHandler(new c(pVar));
        }
    }

    @Override // com.kwad.sdk.components.r
    public final void a(j jVar) {
        if (jVar != null) {
            this.aei.registerApkLoadCreator(new e(jVar));
        }
    }
}
