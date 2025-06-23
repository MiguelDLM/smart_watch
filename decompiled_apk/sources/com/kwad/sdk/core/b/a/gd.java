package com.kwad.sdk.core.b.a;

import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class gd implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.b.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt(JNISearchConst.JNI_SHOP_OPEN_TIME_COLOR);
        bVar.contentEncoding = jSONObject.optString("Content-Encoding");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.contentEncoding)) {
            bVar.contentEncoding = "";
        }
        bVar.aFI = jSONObject.optString("Cache-Control");
        if (obj.toString().equals(bVar.aFI)) {
            bVar.aFI = "";
        }
        bVar.aFG = jSONObject.optString("Content-Type");
        if (obj.toString().equals(bVar.aFG)) {
            bVar.aFG = "";
        }
        com.kwad.sdk.core.webview.b.a.a aVar = new com.kwad.sdk.core.webview.b.a.a();
        bVar.aFJ = aVar;
        aVar.parseJson(jSONObject.optJSONObject(TTDownloadField.TT_HEADERS));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(com.kwad.sdk.core.webview.b.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = bVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, JNISearchConst.JNI_SHOP_OPEN_TIME_COLOR, i);
        }
        String str = bVar.contentEncoding;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Content-Encoding", bVar.contentEncoding);
        }
        String str2 = bVar.aFI;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Cache-Control", bVar.aFI);
        }
        String str3 = bVar.aFG;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "Content-Type", bVar.aFG);
        }
        com.kwad.sdk.utils.t.a(jSONObject, TTDownloadField.TT_HEADERS, bVar.aFJ);
        return jSONObject;
    }
}
