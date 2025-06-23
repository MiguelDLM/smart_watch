package com.baidu.tts;

import android.content.Context;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.d0;
import com.baidu.tts.emstatistics.TtsStatsUpload;
import com.baidu.tts.emstatistics.TtsStatsUploadBag;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.jni.TtsLogLoad;
import com.baidu.tts.tools.StringTool;
import com.baidu.tts.tools.Utility;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class i2 {
    public static i2 h = null;
    public static j2 i = null;
    public static boolean j = false;
    public static String k;
    public static volatile long l;

    /* renamed from: a, reason: collision with root package name */
    public Context f10107a;
    public int b = 0;
    public int c = 0;
    public long d = 0;
    public long e = 0;
    public int f = 0;
    public int g = 0;

    /* loaded from: classes8.dex */
    public class a implements Callable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f10108a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ d c;
        public final /* synthetic */ String d;

        public a(byte[] bArr, boolean z, d dVar, String str) {
            this.f10108a = bArr;
            this.b = z;
            this.c = dVar;
            this.d = str;
        }

        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            TtsStatsUpload.getInstance().dataCollectStat(this.f10108a, new h2(this), this.d);
            return 0;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p2 f10109a;
        public final /* synthetic */ TtsError b;
        public final /* synthetic */ TtsError c;
        public final /* synthetic */ r4 d;
        public final /* synthetic */ y4 e;

        public b(p2 p2Var, TtsError ttsError, TtsError ttsError2, r4 r4Var, y4 y4Var) {
            this.f10109a = p2Var;
            this.b = ttsError;
            this.c = ttsError2;
            this.d = r4Var;
            this.e = y4Var;
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
    }

    /* loaded from: classes8.dex */
    public interface d {
    }

    public final void a(TtsStatsUploadBag ttsStatsUploadBag, y4 y4Var) {
        String jSONObject;
        String jSONObject2;
        if (y4Var != null) {
            ttsStatsUploadBag.setSn(y4Var.i);
            synchronized (y4Var) {
                jSONObject = y4Var.f.toString();
            }
            if (jSONObject == null) {
                return;
            }
            try {
                ttsStatsUploadBag.setTimestamp(new JSONObject(jSONObject).getLong(TtsStatsUploadBag.KEY_SYN_STIME));
                synchronized (y4Var) {
                    jSONObject2 = y4Var.f.toString();
                }
                ttsStatsUploadBag.setExtension(jSONObject2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void b(p2 p2Var, TtsError ttsError, TtsError ttsError2, r4 r4Var, y4 y4Var) {
        String str;
        try {
            this.b++;
            TtsStatsUploadBag a2 = a(p2Var, r4Var, ttsError, ttsError2);
            a(a2, y4Var);
            if (l == 0) {
                l = a2.getTimestamp();
            }
            a2.setTimeInterval(a2.getTimestamp() - l);
            l = a2.getTimestamp();
            JSONObject jSONObject = new JSONObject(a2.getAttributes());
            d0.b bVar = r4Var.b;
            if (bVar == null) {
                str = "";
            } else {
                str = bVar.p;
            }
            a(str, 4);
            LoggerProxy.d("TtsStatsInterceptor", "Writes data to the file:" + jSONObject.toString());
            TtsLogLoad.writeLocalFile(jSONObject.toString(), jSONObject.toString().getBytes("UTF-8").length, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: Exception -> 0x0010, TryCatch #0 {Exception -> 0x0010, blocks: (B:4:0x0004, B:6:0x0008, B:7:0x0013, B:10:0x0024, B:11:0x0043, B:13:0x0049, B:15:0x004f, B:16:0x005c, B:18:0x0060, B:20:0x0066, B:21:0x0073, B:23:0x0091, B:27:0x006f, B:28:0x0058, B:29:0x0029), top: B:3:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.baidu.tts.aop.tts.TtsError r9, java.lang.String r10) {
        /*
            r8 = this;
            boolean r0 = com.baidu.tts.i2.j
            if (r0 == 0) goto Lbf
            com.baidu.tts.j2 r0 = com.baidu.tts.i2.i     // Catch: java.lang.Exception -> L10
            if (r0 != 0) goto L13
            com.baidu.tts.j2 r0 = new com.baidu.tts.j2     // Catch: java.lang.Exception -> L10
            r0.<init>()     // Catch: java.lang.Exception -> L10
            com.baidu.tts.i2.i = r0     // Catch: java.lang.Exception -> L10
            goto L13
        L10:
            r9 = move-exception
            goto Lbc
        L13:
            int r0 = r8.c     // Catch: java.lang.Exception -> L10
            int r0 = r0 + 1
            r8.c = r0     // Catch: java.lang.Exception -> L10
            com.baidu.tts.j2 r1 = com.baidu.tts.i2.i     // Catch: java.lang.Exception -> L10
            r1.b = r0     // Catch: java.lang.Exception -> L10
            r1.e = r10     // Catch: java.lang.Exception -> L10
            r10 = 0
            java.lang.String r0 = ""
            if (r9 != 0) goto L29
            r1.c = r0     // Catch: java.lang.Exception -> L10
            r1.d = r10     // Catch: java.lang.Exception -> L10
            goto L43
        L29:
            java.lang.String r2 = r9.getSN()     // Catch: java.lang.Exception -> L10
            r1.e = r2     // Catch: java.lang.Exception -> L10
            com.baidu.tts.j2 r1 = com.baidu.tts.i2.i     // Catch: java.lang.Exception -> L10
            com.baidu.tts.x2 r2 = r9.getErrorEnum()     // Catch: java.lang.Exception -> L10
            java.lang.String r2 = r2.c     // Catch: java.lang.Exception -> L10
            r1.c = r2     // Catch: java.lang.Exception -> L10
            com.baidu.tts.j2 r1 = com.baidu.tts.i2.i     // Catch: java.lang.Exception -> L10
            com.baidu.tts.x2 r9 = r9.getErrorEnum()     // Catch: java.lang.Exception -> L10
            int r9 = r9.b     // Catch: java.lang.Exception -> L10
            r1.d = r9     // Catch: java.lang.Exception -> L10
        L43:
            int r9 = r8.f     // Catch: java.lang.Exception -> L10
            r1 = 0
            if (r9 == 0) goto L58
            long r3 = r8.d     // Catch: java.lang.Exception -> L10
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 <= 0) goto L58
            com.baidu.tts.j2 r5 = com.baidu.tts.i2.i     // Catch: java.lang.Exception -> L10
            int r9 = r9 / 500
            long r6 = (long) r9     // Catch: java.lang.Exception -> L10
            long r3 = r3 / r6
            r5.f = r3     // Catch: java.lang.Exception -> L10
            goto L5c
        L58:
            com.baidu.tts.j2 r9 = com.baidu.tts.i2.i     // Catch: java.lang.Exception -> L10
            r9.f = r1     // Catch: java.lang.Exception -> L10
        L5c:
            int r9 = r8.g     // Catch: java.lang.Exception -> L10
            if (r9 == 0) goto L6f
            long r3 = r8.e     // Catch: java.lang.Exception -> L10
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 <= 0) goto L6f
            com.baidu.tts.j2 r5 = com.baidu.tts.i2.i     // Catch: java.lang.Exception -> L10
            int r9 = r9 / 500
            long r6 = (long) r9     // Catch: java.lang.Exception -> L10
            long r3 = r3 / r6
            r5.g = r3     // Catch: java.lang.Exception -> L10
            goto L73
        L6f:
            com.baidu.tts.j2 r9 = com.baidu.tts.i2.i     // Catch: java.lang.Exception -> L10
            r9.g = r1     // Catch: java.lang.Exception -> L10
        L73:
            r8.d = r1     // Catch: java.lang.Exception -> L10
            r8.e = r1     // Catch: java.lang.Exception -> L10
            com.baidu.tts.j2 r9 = com.baidu.tts.i2.i     // Catch: java.lang.Exception -> L10
            r9.f10115a = r10     // Catch: java.lang.Exception -> L10
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch: java.lang.Exception -> L10
            com.baidu.tts.j2 r10 = com.baidu.tts.i2.i     // Catch: java.lang.Exception -> L10
            java.util.Map r10 = r10.a()     // Catch: java.lang.Exception -> L10
            r9.<init>(r10)     // Catch: java.lang.Exception -> L10
            r10 = 5
            r8.a(r0, r10)     // Catch: java.lang.Exception -> L10
            com.baidu.tts.j2 r0 = com.baidu.tts.i2.i     // Catch: java.lang.Exception -> L10
            r1 = 0
            r0.h = r1     // Catch: java.lang.Exception -> L10
            java.lang.String r0 = "TtsStatsInterceptor"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L10
            r1.<init>()     // Catch: java.lang.Exception -> L10
            java.lang.String r2 = "Writes data to the file 2:"
            r1.append(r2)     // Catch: java.lang.Exception -> L10
            java.lang.String r2 = r9.toString()     // Catch: java.lang.Exception -> L10
            r1.append(r2)     // Catch: java.lang.Exception -> L10
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L10
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r0, r1)     // Catch: java.lang.Exception -> L10
            java.lang.String r0 = r9.toString()     // Catch: java.lang.Exception -> L10
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> L10
            java.lang.String r1 = "UTF-8"
            byte[] r9 = r9.getBytes(r1)     // Catch: java.lang.Exception -> L10
            int r9 = r9.length     // Catch: java.lang.Exception -> L10
            com.baidu.tts.jni.TtsLogLoad.writeLocalFile(r0, r9, r10)     // Catch: java.lang.Exception -> L10
            goto Lbf
        Lbc:
            r9.printStackTrace()
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.i2.a(com.baidu.tts.aop.tts.TtsError, java.lang.String):void");
    }

    public static synchronized i2 a() {
        i2 i2Var;
        synchronized (i2.class) {
            try {
                if (h == null) {
                    h = new i2();
                }
                i2Var = h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2Var;
    }

    public boolean a(String str, boolean z, d dVar) {
        if (StringTool.isEmpty(str)) {
            return false;
        }
        k = str;
        this.f10107a = e3.e().c();
        TtsStatsUpload.getInstance().setContext(this.f10107a);
        new Thread(new FutureTask(new a(new byte[]{0, 5, 0, 0, 0}, z, dVar, str))).start();
        return true;
    }

    public void a(int i2, int i3, long j2, long j3) {
        if (i == null) {
            i = new j2();
        }
        j2 j2Var = i;
        if (j2Var != null) {
            if (j2Var.h == null) {
                j2Var.h = new JSONArray();
            }
            j2 j2Var2 = i;
            j2Var2.getClass();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("idx", i2);
                jSONObject.put("type", i3);
                jSONObject.put("te", j3);
                jSONObject.put(MapBundleKey.MapObjKey.OBJ_SL_TIME, j2);
                JSONArray jSONArray = j2Var2.h;
                if (jSONArray != null) {
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(p2 p2Var, TtsError ttsError, TtsError ttsError2, r4 r4Var, y4 y4Var) {
        String c2 = r4Var.c();
        k = c2;
        if (j) {
            b(p2Var, ttsError, ttsError2, r4Var, y4Var);
        } else {
            if (StringTool.isEmpty(c2)) {
                return;
            }
            a().a(c2, true, new b(p2Var, ttsError, ttsError2, r4Var, y4Var));
        }
    }

    public final TtsStatsUploadBag a(p2 p2Var, r4 r4Var, TtsError ttsError, TtsError ttsError2) {
        String str;
        TtsStatsUploadBag ttsStatsUploadBag = new TtsStatsUploadBag();
        ttsStatsUploadBag.setTimestamp(System.currentTimeMillis());
        ttsStatsUploadBag.setPhoneModel(Utility.getSystemModel());
        ttsStatsUploadBag.setIndex(this.b);
        ttsStatsUploadBag.setSubErrorCode(0);
        ttsStatsUploadBag.setTtsMode(p2Var.f10149a);
        int i2 = r4Var.d;
        if (i2 == 10) {
            str = "wifi";
        } else if (i2 == 11) {
            str = "ether";
        } else if (i2 == 2) {
            str = "2G";
        } else if (i2 == 3) {
            str = "3G";
        } else if (i2 != 4) {
            str = i2 != 5 ? "unknown" : "5G";
        } else {
            str = "4G";
        }
        ttsStatsUploadBag.setNetType(str);
        String c2 = r4Var.c();
        if (!StringTool.isEmpty(c2)) {
            ttsStatsUploadBag.setPid(Integer.parseInt(c2));
        }
        e0 e0Var = r4Var.f10162a;
        ttsStatsUploadBag.setSpeaker(e0Var == null ? "" : e0Var.j);
        d0.b bVar = r4Var.b;
        String str2 = bVar != null ? bVar.l : "";
        if (!StringTool.isEmpty(str2)) {
            ttsStatsUploadBag.setSpeechInfo(EmbeddedSynthesizerEngine.bdTTSGetDatParam(str2));
        }
        if (ttsError != null) {
            ttsStatsUploadBag.setErrorCode(ttsError.getDetailCode());
            ttsStatsUploadBag.setErrorDes(ttsError.getDetailMessage());
        }
        if (ttsError2 != null) {
            ttsStatsUploadBag.setTtsresult(ttsError2.getDetailCode());
        }
        return ttsStatsUploadBag;
    }

    public void a(String str, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            String bdTTSGetEngineParam = EmbeddedSynthesizerEngine.bdTTSGetEngineParam();
            String optString = new JSONObject(bdTTSGetEngineParam).optString("version", "");
            if (bdTTSGetEngineParam != null) {
                jSONObject.put("etts_version", optString);
            }
            jSONObject.put("appid", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TtsLogLoad.setLogHeadSring(jSONObject.toString(), i2);
    }
}
