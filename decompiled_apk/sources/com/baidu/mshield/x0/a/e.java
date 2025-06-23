package com.baidu.mshield.x0.a;

import OoOoXO0.xoXoI;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.f;
import com.baidu.mshield.x0.EngineImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class e extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f6398a;
    public final /* synthetic */ Context b;

    public e(JSONObject jSONObject, Context context) {
        this.f6398a = jSONObject;
        this.b = context;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        int i;
        String str;
        String str2;
        JSONObject jSONObject;
        String str3;
        int i2;
        String str4;
        JSONObject jSONObject2;
        String str5;
        JSONObject jSONObject3;
        String str6;
        String str7 = "4";
        String str8 = "1";
        try {
            int optInt = this.f6398a.optInt("1", 0);
            String optString = this.f6398a.optString("4", "");
            if (this.f6398a.has("7")) {
                i = this.f6398a.optJSONObject("7").optInt("1", 1);
            } else {
                i = 0;
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            StringBuilder sb = new StringBuilder();
            sb.append("detect app encryptStr====");
            str = d.b;
            sb.append(str);
            com.baidu.mshield.b.c.a.b(sb.toString());
            str2 = d.b;
            String b = com.baidu.xclient.gdid.a.b(str2);
            com.baidu.mshield.b.c.a.b("detect app decryptStr====" + b);
            if (!TextUtils.isEmpty(b)) {
                jSONObject = new JSONObject(b);
            } else {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject4 = new JSONObject();
            String str9 = "8";
            String str10 = "0";
            if (jSONObject.length() > 0) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Iterator<String> it = keys;
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    JSONObject jSONObject5 = jSONObject;
                    String optString2 = optJSONObject.optString("p");
                    String str11 = optString;
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(f.f6163a);
                    JSONObject jSONObject6 = new JSONObject();
                    String str12 = valueOf;
                    PackageInfo a2 = c.a(this.b, optString2);
                    if (a2 != null) {
                        str4 = next;
                        if (optInt == 1) {
                            i2 = optInt;
                            jSONObject6.put(str10, com.baidu.mshield.b.f.e.a(new File(a2.applicationInfo.sourceDir)));
                        } else {
                            i2 = optInt;
                        }
                        jSONObject6.put(str8, str8);
                        if (c.b(this.b, optString2)) {
                            jSONObject6.put(str7, str8);
                        } else {
                            jSONObject6.put(str7, str10);
                        }
                        ArrayList arrayList = new ArrayList();
                        JSONObject jSONObject7 = new JSONObject();
                        str3 = str7;
                        if (optJSONObject2 != null) {
                            Iterator<String> keys2 = optJSONObject2.keys();
                            while (keys2.hasNext()) {
                                JSONObject jSONObject8 = jSONObject4;
                                StringBuffer stringBuffer = new StringBuffer();
                                int i3 = i;
                                String next2 = keys2.next();
                                String str13 = str10;
                                String optString3 = optJSONObject2.optString(next2);
                                if (TextUtils.isEmpty(optString3)) {
                                    jSONObject4 = jSONObject8;
                                    str10 = str13;
                                    i = i3;
                                } else {
                                    String str14 = str8;
                                    if (new File(optString3).exists()) {
                                        String[] a3 = com.baidu.mshield.b.a.b.a(optString3);
                                        str6 = str9;
                                        stringBuffer.append(a3[0]);
                                        stringBuffer.append(xoXoI.f2670oxoX);
                                        jSONObject3 = optJSONObject2;
                                        stringBuffer.append(a3[1]);
                                        stringBuffer.append(xoXoI.f2670oxoX);
                                        stringBuffer.append(a3[2]);
                                        stringBuffer.append(xoXoI.f2670oxoX);
                                        stringBuffer.append(a3[3]);
                                    } else {
                                        jSONObject3 = optJSONObject2;
                                        str6 = str9;
                                    }
                                    arrayList.add(optString3);
                                    jSONObject7.put(next2, stringBuffer.toString());
                                    jSONObject4 = jSONObject8;
                                    str10 = str13;
                                    i = i3;
                                    str8 = str14;
                                    str9 = str6;
                                    optJSONObject2 = jSONObject3;
                                }
                            }
                        }
                        String str15 = str8;
                        String str16 = str10;
                        JSONObject jSONObject9 = optJSONObject2;
                        int i4 = i;
                        jSONObject2 = jSONObject4;
                        String str17 = str9;
                        jSONObject6.put("3", String.valueOf(c.a(this.b, optString2, arrayList)));
                        jSONObject6.put("5", jSONObject7.toString());
                        jSONObject6.put("6", a2.firstInstallTime);
                        jSONObject6.put("7", a2.lastUpdateTime);
                        if (jSONObject9 != null && jSONObject9.length() > 0) {
                            str8 = str15;
                            str5 = str17;
                            jSONObject6.put(str5, str8);
                            str10 = str16;
                        } else {
                            str8 = str15;
                            str5 = str17;
                            str10 = str16;
                            jSONObject6.put(str5, str10);
                        }
                        jSONObject6.put("9", a2.versionName);
                        i = i4;
                        if (i == 1) {
                            String[] c = c.c(this.b, optString2);
                            for (int i5 = 0; i5 < c.length; i5++) {
                                String str18 = c[i5];
                                StringBuffer stringBuffer2 = new StringBuffer();
                                if (!TextUtils.isEmpty(str18)) {
                                    String[] a4 = com.baidu.mshield.b.a.b.a(str18);
                                    stringBuffer2.append(a4[0]);
                                    stringBuffer2.append(xoXoI.f2670oxoX);
                                    stringBuffer2.append(a4[1]);
                                    stringBuffer2.append(xoXoI.f2670oxoX);
                                    stringBuffer2.append(a4[2]);
                                    stringBuffer2.append(xoXoI.f2670oxoX);
                                    stringBuffer2.append(a4[3]);
                                }
                                jSONObject6.put(String.valueOf(i5 + 10), stringBuffer2.toString());
                            }
                        }
                    } else {
                        str3 = str7;
                        i2 = optInt;
                        str4 = next;
                        jSONObject2 = jSONObject4;
                        str5 = str9;
                        jSONObject6.put(str8, str10);
                    }
                    JSONObject jSONObject10 = jSONObject2;
                    jSONObject10.put(str4, jSONObject6);
                    jSONObject4 = jSONObject10;
                    str9 = str5;
                    keys = it;
                    jSONObject = jSONObject5;
                    optString = str11;
                    valueOf = str12;
                    optInt = i2;
                    str7 = str3;
                }
            }
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject11 = new JSONObject();
            jSONObject11.put("3", jSONObject4);
            jSONObject11.put(str10, valueOf);
            jSONObject11.put("5", optString);
            jSONObject11.put(str9, EngineImpl.getInstance(this.b).getPropertyByType("mod"));
            jSONArray.put(jSONObject11);
            com.baidu.mshield.b.c.a.b("handleNativeCollect: upArray=" + jSONArray);
            com.baidu.mshield.x0.b.d.b(this.b, jSONArray, "1001159");
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }
}
