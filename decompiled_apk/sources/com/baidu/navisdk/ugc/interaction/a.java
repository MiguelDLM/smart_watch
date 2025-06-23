package com.baidu.navisdk.ugc.interaction;

import android.text.TextUtils;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.util.common.g;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f8200a;
    public String b;
    public int c;
    public int d;
    public String e;
    public boolean f = false;
    public int g;

    public void a() {
        this.f8200a = null;
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = false;
        this.g = 0;
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.f8200a);
    }

    public String toString() {
        return "InteractionData{eventId='" + this.f8200a + "', eventType=" + this.c + ", userIden=" + this.d + ", des='" + this.e + "', isReportServer=" + this.f + ", page=" + this.g + ", unencryptedEventId: " + this.b + '}';
    }

    public boolean a(String str) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e("UgcModule_Interaction", "start parseData content: " + str);
        }
        a();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("eventid", null);
            this.b = optString;
            this.f8200a = JNITrajectoryControl.sInstance.eventIdEncode(Long.valueOf(optString).longValue());
            this.c = jSONObject.optInt("etype", 0);
            this.d = jSONObject.optInt("identity", 0);
            this.e = jSONObject.optString("des", null);
            this.g = jSONObject.optInt("navistate", 0);
            if (!gVar.d()) {
                return true;
            }
            gVar.e("UgcModule_Interaction", "parseData done, " + toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            g gVar2 = g.UGC;
            if (gVar2.c()) {
                gVar2.c("UgcModule_Interaction", "InteractionData parseData exception " + e.toString());
            }
            return false;
        }
    }
}
