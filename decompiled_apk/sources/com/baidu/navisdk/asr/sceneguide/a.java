package com.baidu.navisdk.asr.sceneguide;

import com.baidu.navisdk.util.common.g;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f6562a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;

    public static a a(String str, String str2, String str3, String str4) {
        a aVar = new a();
        try {
            aVar.b = str3;
            aVar.c = str4;
            aVar.f6562a = str2;
            JSONObject jSONObject = new JSONObject(str);
            aVar.d = jSONObject.optString("tts", "");
            aVar.e = jSONObject.optString("text", "");
            aVar.f = jSONObject.optString("data_id", "");
            JSONObject optJSONObject = jSONObject.optJSONObject("next_order");
            if (optJSONObject != null) {
                aVar.o = optJSONObject.optString("order");
                aVar.m = optJSONObject.optString("approach_data");
                aVar.n = optJSONObject.optString("approach_data_id");
                aVar.i = optJSONObject.optString("confirm_tts");
                aVar.j = optJSONObject.optString("confirm_data_id");
                aVar.k = optJSONObject.optString("cancel_tts");
                aVar.l = optJSONObject.optString("cancel_data_id");
                aVar.g = optJSONObject.optString("fail_tts");
                aVar.h = optJSONObject.optString("fail_data_id");
                aVar.p = optJSONObject.optInt("value");
            }
            return aVar;
        } catch (JSONException e) {
            g gVar = g.ASR;
            if (gVar.d()) {
                gVar.e("behavRulesBNAsrSceneAction", "parse() error , jsonStr = " + str + " e = " + e);
            }
            e.printStackTrace();
            return aVar;
        }
    }

    public com.baidu.navisdk.asr.model.a b() {
        com.baidu.navisdk.asr.model.a aVar = new com.baidu.navisdk.asr.model.a();
        aVar.D = this.o;
        aVar.z0 = this.b;
        aVar.t0 = this.p;
        String str = this.m;
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    a(aVar, split[0], split[1]);
                }
            }
        }
        return aVar;
    }

    public String toString() {
        return "BNAsrSceneXDActinoData{mOrder='" + this.f6562a + "', mSceneId='" + this.b + "', mRecInfo='" + this.c + "', mTTS='" + this.d + "', mText='" + this.e + "', mDataId='" + this.f + "', mSecondFailTTS='" + this.g + "', mSecondFailDataId='" + this.h + "', mSecondConfirmTTS='" + this.i + "', mSecondConfirmDataId='" + this.j + "', mSecondCancelTTS='" + this.k + "', mSecondCanelDataId='" + this.l + "', mSecondParamsData='" + this.m + "', mSecondParamsDataId='" + this.n + "', mSecondOrder='" + this.o + "', mSecondValue=" + this.p + '}';
    }

    public boolean a(com.baidu.navisdk.behavrules.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        try {
            this.d = aVar.a(this.d, this.f);
            this.i = aVar.a(this.i, this.j);
            this.k = aVar.a(this.k, this.l);
            this.m = aVar.a(this.m, this.n);
            return true;
        } catch (com.baidu.navisdk.behavrules.data.b e) {
            g gVar = g.ASR;
            if (gVar.d()) {
                gVar.e("behavRulesBNAsrSceneAction", "parseData(), e = " + e);
            }
            e.printStackTrace();
            return false;
        }
    }

    public com.baidu.navisdk.asr.model.a a() {
        com.baidu.navisdk.asr.model.b bVar = new com.baidu.navisdk.asr.model.b();
        bVar.c(this.d);
        bVar.a(this.f6562a);
        bVar.b(this.e);
        bVar.d = this.c;
        com.baidu.navisdk.asr.model.a aVar = new com.baidu.navisdk.asr.model.a(bVar);
        aVar.z0 = this.b;
        aVar.D = this.f6562a;
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007a A[Catch: NumberFormatException -> 0x0030, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x0030, blocks: (B:5:0x000a, B:22:0x005b, B:24:0x005e, B:26:0x006c, B:28:0x007a, B:30:0x0026, B:33:0x0032, B:36:0x003d, B:39:0x0047), top: B:4:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.baidu.navisdk.asr.model.a r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            if (r6 == 0) goto Lab
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto La
            goto Lab
        La:
            int r0 = r7.hashCode()     // Catch: java.lang.NumberFormatException -> L30
            r1 = 106911(0x1a19f, float:1.49814E-40)
            r2 = 1
            r3 = 2
            r4 = 3
            if (r0 == r1) goto L47
            r1 = 107301(0x1a325, float:1.50361E-40)
            if (r0 == r1) goto L3d
            r1 = 115792(0x1c450, float:1.62259E-40)
            if (r0 == r1) goto L32
            r1 = 3373707(0x337a8b, float:4.72757E-39)
            if (r0 == r1) goto L26
            goto L51
        L26:
            java.lang.String r0 = "name"
            boolean r0 = r7.equals(r0)     // Catch: java.lang.NumberFormatException -> L30
            if (r0 == 0) goto L51
            r0 = 0
            goto L52
        L30:
            goto L7d
        L32:
            java.lang.String r0 = "uid"
            boolean r0 = r7.equals(r0)     // Catch: java.lang.NumberFormatException -> L30
            if (r0 == 0) goto L51
            r0 = 3
            goto L52
        L3d:
            java.lang.String r0 = "lng"
            boolean r0 = r7.equals(r0)     // Catch: java.lang.NumberFormatException -> L30
            if (r0 == 0) goto L51
            r0 = 2
            goto L52
        L47:
            java.lang.String r0 = "lat"
            boolean r0 = r7.equals(r0)     // Catch: java.lang.NumberFormatException -> L30
            if (r0 == 0) goto L51
            r0 = 1
            goto L52
        L51:
            r0 = -1
        L52:
            if (r0 == 0) goto L7a
            if (r0 == r2) goto L6c
            if (r0 == r3) goto L5e
            if (r0 == r4) goto L5b
            goto Lab
        L5b:
            r6.f0 = r8     // Catch: java.lang.NumberFormatException -> L30
            goto Lab
        L5e:
            com.baidu.nplatform.comapi.basestruct.GeoPoint r0 = r6.A0     // Catch: java.lang.NumberFormatException -> L30
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.NumberFormatException -> L30
            int r1 = r1.intValue()     // Catch: java.lang.NumberFormatException -> L30
            r0.setLongitudeE6(r1)     // Catch: java.lang.NumberFormatException -> L30
            goto Lab
        L6c:
            com.baidu.nplatform.comapi.basestruct.GeoPoint r0 = r6.A0     // Catch: java.lang.NumberFormatException -> L30
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.NumberFormatException -> L30
            int r1 = r1.intValue()     // Catch: java.lang.NumberFormatException -> L30
            r0.setLatitudeE6(r1)     // Catch: java.lang.NumberFormatException -> L30
            goto Lab
        L7a:
            r6.B0 = r8     // Catch: java.lang.NumberFormatException -> L30
            goto Lab
        L7d:
            com.baidu.navisdk.util.common.g r0 = com.baidu.navisdk.util.common.g.ASR
            boolean r1 = r0.d()
            if (r1 == 0) goto Lab
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "parseDataItem() error, result = "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = " key = "
            r1.append(r6)
            r1.append(r7)
            java.lang.String r6 = " value = "
            r1.append(r6)
            r1.append(r8)
            java.lang.String r6 = r1.toString()
            java.lang.String r7 = "behavRulesBNAsrSceneAction"
            r0.e(r7, r6)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.asr.sceneguide.a.a(com.baidu.navisdk.asr.model.a, java.lang.String, java.lang.String):void");
    }
}
