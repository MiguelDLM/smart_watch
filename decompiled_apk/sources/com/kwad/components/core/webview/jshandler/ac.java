package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class ac implements com.kwad.sdk.core.webview.c.a {
    protected final com.kwad.sdk.core.webview.b WQ;
    protected b Xv;

    /* loaded from: classes11.dex */
    public static class a implements com.kwad.sdk.core.b {
        public int height;
        public int width;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.width);
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void c(a aVar);
    }

    public ac(com.kwad.sdk.core.webview.b bVar) {
        this.WQ = bVar;
    }

    public final void a(b bVar) {
        this.Xv = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getContainerLimit";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a();
        b bVar = this.Xv;
        if (bVar != null) {
            bVar.c(aVar);
        } else {
            aVar.width = this.WQ.Ph.getWidth();
            aVar.height = this.WQ.Ph.getHeight();
        }
        cVar.a(aVar);
    }
}
