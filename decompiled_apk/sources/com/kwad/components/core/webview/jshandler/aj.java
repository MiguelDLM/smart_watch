package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class aj implements com.kwad.sdk.core.webview.c.a {
    private final WebView OA;
    private boolean XZ;
    private Handler Xl;

    @Nullable
    private com.kwad.sdk.core.webview.c.c Xm;

    @Nullable
    private b cS;

    /* loaded from: classes11.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public int bottomMargin;
        public int height;
        public int leftMargin;
        public int rightMargin;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.height = jSONObject.optInt("height");
            this.leftMargin = jSONObject.optInt("leftMargin");
            this.rightMargin = jSONObject.optInt("rightMargin");
            this.bottomMargin = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftMargin", this.leftMargin);
            com.kwad.sdk.utils.t.putValue(jSONObject, "rightMargin", this.rightMargin);
            com.kwad.sdk.utils.t.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    public aj(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2) {
        this(bVar, bVar2, true);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Xm = null;
        this.cS = null;
        this.Xl.removeCallbacksAndMessages(null);
    }

    private aj(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2, boolean z) {
        this.XZ = true;
        this.Xl = new Handler(Looper.getMainLooper());
        this.OA = bVar.OA;
        this.cS = bVar2;
        this.XZ = true;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Xm = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.Xl.post(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.aj.1
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    if (aj.this.OA != null && aj.this.XZ) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) aj.this.OA.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.height;
                        marginLayoutParams.leftMargin = aVar2.leftMargin;
                        marginLayoutParams.rightMargin = aVar2.rightMargin;
                        marginLayoutParams.bottomMargin = aVar2.bottomMargin;
                        aj.this.OA.setLayoutParams(marginLayoutParams);
                    }
                    if (aj.this.cS != null) {
                        aj.this.cS.a(aVar);
                    }
                }
            });
            this.Xl.post(new com.kwad.sdk.utils.az() { // from class: com.kwad.components.core.webview.jshandler.aj.2
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    if (aj.this.Xm != null) {
                        aj.this.Xm.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }
}
