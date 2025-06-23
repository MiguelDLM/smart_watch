package com.kwad.components.offline.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.c.a.i;
import com.kwad.sdk.components.r;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class b implements com.kwad.components.core.n.a.d.c {
    private final ITkOfflineCompo adE;

    public b(@NonNull ITkOfflineCompo iTkOfflineCompo) {
        this.adE = iTkOfflineCompo;
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final r a(Context context, String str, int i, int i2, boolean z) {
        IOfflineCompoTachikomaContext context2 = this.adE.getContext(context, str, i, i2, z);
        if (context2 == null) {
            return null;
        }
        return new i(context2);
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i) {
        return this.adE.checkStyleTemplateById(context, str, str2, str3, i);
    }

    @Override // com.kwad.sdk.components.a
    public final Class<b> getComponentsType() {
        return b.class;
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final String getJsBaseDir(Context context, String str) {
        return this.adE.getJsBaseDir(context, str);
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final ITkOfflineCompo.TKState getState() {
        return this.adE.getState();
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener) {
        this.adE.loadTkFileByTemplateId(context, str, str2, str3, i, tKDownloadListener);
    }

    public final void onConfigRefresh(Context context, @NonNull JSONObject jSONObject) {
        this.adE.onConfigRefresh(context, jSONObject);
    }

    @Override // com.kwad.components.core.n.a.d.c
    public final void onDestroy() {
        this.adE.onDestroy();
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return this.adE.priority();
    }
}
