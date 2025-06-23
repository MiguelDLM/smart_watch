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
public final class b extends TimerTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f6396a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ com.baidu.mshield.x0.j.a c;

    public b(JSONObject jSONObject, Context context, com.baidu.mshield.x0.j.a aVar) {
        this.f6396a = jSONObject;
        this.b = context;
        this.c = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        int i;
        JSONObject jSONObject;
        String str;
        int i2;
        String str2;
        String str3;
        String str4;
        String[] strArr;
        String str5;
        JSONObject jSONObject2;
        String str6 = "4";
        String str7 = "7";
        String str8 = "1";
        try {
            int optInt = this.f6396a.optInt("1", 0);
            String optString = this.f6396a.optString("4", "");
            String optString2 = this.f6396a.optString("5", "");
            String optString3 = this.f6396a.optString("6", "");
            if (this.f6396a.has("7")) {
                i = this.f6396a.optJSONObject("7").optInt("1", 1);
            } else {
                i = 0;
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            com.baidu.mshield.b.c.a.b("detect app encryptStr====" + a.f6395a);
            String b = com.baidu.xclient.gdid.a.b(a.f6395a);
            com.baidu.mshield.b.c.a.b("detect app decryptStr====" + b);
            if (!TextUtils.isEmpty(b)) {
                jSONObject = new JSONObject(b);
            } else {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject3 = new JSONObject();
            String str9 = "8";
            String str10 = "0";
            if (jSONObject.length() > 0) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    Iterator<String> it = keys;
                    String next = keys.next();
                    String str11 = optString;
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    JSONObject jSONObject4 = jSONObject;
                    String optString4 = optJSONObject.optString("p");
                    String str12 = valueOf;
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(f.f6163a);
                    JSONObject jSONObject5 = new JSONObject();
                    JSONObject jSONObject6 = jSONObject3;
                    PackageInfo a2 = c.a(this.b, optString4);
                    if (a2 != null) {
                        str4 = next;
                        if (optInt == 1) {
                            i2 = optInt;
                            jSONObject5.put(str10, com.baidu.mshield.b.f.e.a(new File(a2.applicationInfo.sourceDir)));
                        } else {
                            i2 = optInt;
                        }
                        jSONObject5.put(str8, str8);
                        if (c.b(this.b, optString4)) {
                            jSONObject5.put(str6, str8);
                        } else {
                            jSONObject5.put(str6, str10);
                        }
                        ArrayList arrayList = new ArrayList();
                        JSONObject jSONObject7 = new JSONObject();
                        str = str6;
                        if (optJSONObject2 != null) {
                            Iterator<String> keys2 = optJSONObject2.keys();
                            while (keys2.hasNext()) {
                                int i3 = i;
                                StringBuffer stringBuffer = new StringBuffer();
                                String str13 = str10;
                                String next2 = keys2.next();
                                String str14 = str8;
                                String optString5 = optJSONObject2.optString(next2);
                                if (TextUtils.isEmpty(optString5)) {
                                    i = i3;
                                    str8 = str14;
                                    str10 = str13;
                                } else {
                                    String str15 = str9;
                                    if (new File(optString5).exists()) {
                                        String[] a3 = com.baidu.mshield.b.a.b.a(optString5);
                                        jSONObject2 = optJSONObject2;
                                        stringBuffer.append(a3[0]);
                                        stringBuffer.append(xoXoI.f2670oxoX);
                                        str5 = str7;
                                        stringBuffer.append(a3[1]);
                                        stringBuffer.append(xoXoI.f2670oxoX);
                                        stringBuffer.append(a3[2]);
                                        stringBuffer.append(xoXoI.f2670oxoX);
                                        stringBuffer.append(a3[3]);
                                    } else {
                                        str5 = str7;
                                        jSONObject2 = optJSONObject2;
                                    }
                                    arrayList.add(optString5);
                                    jSONObject7.put(next2, stringBuffer.toString());
                                    i = i3;
                                    str8 = str14;
                                    str10 = str13;
                                    str9 = str15;
                                    optJSONObject2 = jSONObject2;
                                    str7 = str5;
                                }
                            }
                        }
                        String str16 = str8;
                        JSONObject jSONObject8 = optJSONObject2;
                        String str17 = str10;
                        String str18 = str9;
                        int i4 = i;
                        jSONObject5.put("3", String.valueOf(c.a(this.b, optString4, arrayList)));
                        jSONObject5.put("5", jSONObject7.toString());
                        jSONObject5.put("6", a2.firstInstallTime);
                        str7 = str7;
                        jSONObject5.put(str7, a2.lastUpdateTime);
                        if (jSONObject8 != null && jSONObject8.length() > 0) {
                            str8 = str16;
                            str3 = str18;
                            jSONObject5.put(str3, str8);
                            str2 = str17;
                        } else {
                            str8 = str16;
                            str3 = str18;
                            str2 = str17;
                            jSONObject5.put(str3, str2);
                        }
                        jSONObject5.put("9", a2.versionName);
                        i = i4;
                        if (i == 1) {
                            String[] c = c.c(this.b, optString4);
                            int i5 = 0;
                            while (i5 < c.length) {
                                String str19 = c[i5];
                                StringBuffer stringBuffer2 = new StringBuffer();
                                if (!TextUtils.isEmpty(str19)) {
                                    String[] a4 = com.baidu.mshield.b.a.b.a(str19);
                                    strArr = c;
                                    stringBuffer2.append(a4[0]);
                                    stringBuffer2.append(xoXoI.f2670oxoX);
                                    stringBuffer2.append(a4[1]);
                                    stringBuffer2.append(xoXoI.f2670oxoX);
                                    stringBuffer2.append(a4[2]);
                                    stringBuffer2.append(xoXoI.f2670oxoX);
                                    stringBuffer2.append(a4[3]);
                                } else {
                                    strArr = c;
                                }
                                jSONObject5.put(String.valueOf(i5 + 10), stringBuffer2.toString());
                                i5++;
                                c = strArr;
                            }
                        }
                    } else {
                        str = str6;
                        i2 = optInt;
                        str2 = str10;
                        str3 = str9;
                        str4 = next;
                        jSONObject5.put(str8, str2);
                    }
                    jSONObject6.put(str4, jSONObject5);
                    jSONObject3 = jSONObject6;
                    str9 = str3;
                    str10 = str2;
                    optString = str11;
                    keys = it;
                    jSONObject = jSONObject4;
                    valueOf = str12;
                    optInt = i2;
                    str6 = str;
                }
            }
            String str20 = optString;
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("3", jSONObject3);
            jSONObject9.put(str10, valueOf);
            jSONObject9.put("5", str20);
            jSONObject9.put("6", optString2);
            jSONObject9.put(str7, optString3);
            jSONObject9.put(str9, EngineImpl.getInstance(this.b).getPropertyByType("mod"));
            jSONArray.put(jSONObject9);
            com.baidu.mshield.b.c.a.b("handleNativeCollect: upArray=" + jSONArray);
            com.baidu.mshield.x0.b.d.b(this.b, jSONArray, "1001159");
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(str20);
            stringBuffer3.append("_");
            stringBuffer3.append(optString2);
            stringBuffer3.append("_");
            stringBuffer3.append(optString3);
            this.c.f(stringBuffer3.toString());
            a.f6395a = "";
        } catch (Throwable th) {
            com.baidu.mshield.x0.b.d.a(th);
        }
    }
}
