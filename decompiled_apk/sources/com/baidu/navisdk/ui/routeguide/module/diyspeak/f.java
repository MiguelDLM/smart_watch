package com.baidu.navisdk.ui.routeguide.module.diyspeak;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.setting.SettingParams;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.util.common.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class f {
    public int g;

    /* renamed from: a, reason: collision with root package name */
    public a[] f9003a = null;
    public long b = 0;
    public long c = 0;
    public long d = 0;
    public long e = 0;
    public long f = 0;
    public int h = -1;
    private boolean i = false;
    private SharedPreferences j = null;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f9004a = null;
        public c[] b = null;
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f9005a = false;
        public int b = -1;
        public int c = 1;
        public String d = null;
        public String e = null;
    }

    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f9006a = -1;
        public String b = null;
        public String c = null;
        public boolean d = false;
        public d[] e = null;
    }

    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f9007a = null;
        public b[] b = null;
    }

    private c c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        c cVar = new c();
        cVar.f9006a = jSONObject.optInt("type");
        cVar.b = jSONObject.optString("title");
        cVar.c = jSONObject.optString("preview");
        cVar.d = jSONObject.optInt("isblock", 0) == 1;
        JSONArray optJSONArray = jSONObject.optJSONArray("settings");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            cVar.e = new d[length];
            for (int i = 0; i < length; i++) {
                cVar.e[i] = d(optJSONArray.optJSONObject(i));
            }
        }
        return cVar;
    }

    private d d(JSONObject jSONObject) {
        d dVar = new d();
        dVar.f9007a = jSONObject.optString("desc");
        JSONArray optJSONArray = jSONObject.optJSONArray("checkboxs");
        int length = optJSONArray.length();
        dVar.b = new b[length];
        for (int i = 0; i < length; i++) {
            dVar.b[i] = b(optJSONArray.optJSONObject(i));
        }
        return dVar;
    }

    public void a(boolean z) {
    }

    public void b() {
        if (this.i) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeak", "parseLocalConfig isParsing");
                return;
            }
            return;
        }
        try {
            a(c(), true);
        } catch (Throwable th) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeak", "parseLocalConfig err:" + th.getMessage());
            }
        }
    }

    public void a(JSONArray jSONArray) throws JSONException {
        a(jSONArray, false);
    }

    private void a(JSONArray jSONArray, boolean z) throws JSONException {
        this.i = true;
        this.b = 0L;
        int length = jSONArray.length();
        a[] aVarArr = new a[length];
        for (int i = 0; i < length; i++) {
            aVarArr[i] = a(jSONArray.getJSONObject(i));
        }
        this.f9003a = aVarArr;
        this.i = false;
        if (e.f.c() == 6) {
            a();
        }
        if (z) {
            return;
        }
        try {
            b(jSONArray);
        } catch (Throwable th) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeak", "saveConfigToLocal err:" + th.getMessage());
            }
        }
    }

    private b b(JSONObject jSONObject) {
        b bVar = new b();
        bVar.e = jSONObject.optString("name");
        bVar.b = jSONObject.optInt("cmd");
        bVar.f9005a = jSONObject.optInt("isblock", 0) == 1;
        bVar.c = jSONObject.optInt("len", 1);
        bVar.d = jSONObject.optString("value");
        this.b |= 1 << bVar.b;
        for (int i = 1; i < bVar.c; i++) {
            this.b |= 1 << (bVar.b + i);
        }
        return bVar;
    }

    private JSONArray c() {
        if (this.j == null) {
            this.j = com.baidu.navisdk.framework.a.c().a().getSharedPreferences("navi_diy_config", 0);
        }
        String string = this.j.getString("diy_speak_config", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONArray(string);
        } catch (Exception unused) {
            return null;
        }
    }

    private void b(JSONArray jSONArray) {
        if (this.j == null) {
            this.j = com.baidu.navisdk.framework.a.c().a().getSharedPreferences("navi_diy_config", 0);
        }
        this.j.edit().putString("diy_speak_config", jSONArray.toString()).commit();
    }

    public void a() {
        if (BNSettingManager.containsKey(SettingParams.Key.NAVI_DIY_CUSTOM_MODE_VALUE)) {
            long diyCustomModeValue = BNSettingManager.getDiyCustomModeValue();
            long voiceModeValue = JNIGuidanceControl.getInstance().getVoiceModeValue(0);
            long j = this.b;
            long j2 = 0;
            if (j != 0) {
                j2 = (diyCustomModeValue & j) | (voiceModeValue & (~j));
                BNSettingManager.setDiyCustomModeValue(j2);
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeak", "fixLocalValue :" + diyCustomModeValue + "," + j2);
            }
        }
    }

    private a a(JSONObject jSONObject) throws JSONException {
        a aVar = new a();
        aVar.f9004a = jSONObject.getString("title");
        JSONArray optJSONArray = jSONObject.optJSONArray("subcontent");
        int length = optJSONArray.length();
        aVar.b = new c[length];
        for (int i = 0; i < length; i++) {
            aVar.b[i] = c(optJSONArray.getJSONObject(i));
        }
        return aVar;
    }
}
