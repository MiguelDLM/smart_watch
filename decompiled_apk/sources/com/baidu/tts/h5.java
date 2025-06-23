package com.baidu.tts;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.database.FsFileInfoTable;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.tools.CommonUtility;
import com.baidu.tts.tools.GetCUID;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class h5 {

    /* renamed from: a, reason: collision with root package name */
    public Context f10103a;
    public m3 b;
    public FutureTask<Integer> c;
    public int d = 0;
    public int e = 0;
    public ExecutorService f = Executors.newSingleThreadExecutor();

    /* loaded from: classes8.dex */
    public class a implements Callable<Integer> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            String str;
            a4 a4Var = new a4();
            y2 y2Var = y2.STATISTICS_MODELLOAD_SERVER;
            String str2 = y2Var.f10202a;
            String b = y2Var.b();
            String a2 = y2Var.a();
            HashMap hashMap = new HashMap();
            hashMap.put("Host", a2);
            a4Var.f = hashMap;
            HashMap hashMap2 = new HashMap();
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = (ArrayList) ((HashMap) h5.this.b.c()).get("listId");
            if (arrayList.size() != 0) {
                h5.this.d = ((Integer) arrayList.get(0)).intValue();
                h5.this.e = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
            }
            JSONArray jSONArray = new JSONArray((Collection) ((HashMap) h5.this.b.c()).get("list"));
            try {
                jSONObject.put("deviceInfo", FsFileInfoTable.a(h5.this.f10103a));
                Context context = h5.this.f10103a;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("Cuid", GetCUID.getCUID(context));
                    jSONObject2.put("AppPackageName", context.getPackageName());
                    jSONObject2.put("SDKVersion", "3.2.7.163009b");
                    jSONObject2.put("soInfo", EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONObject.put("appinfo", jSONObject2.toString());
                jSONObject.put("methodinfo", jSONArray);
                LoggerProxy.d("UploadStatistics", "StatisticsData= " + jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            hashMap2.put("d", jSONObject.toString());
            try {
                str = CommonUtility.urlEncoded(hashMap2);
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                str = null;
            }
            i5 i5Var = new i5();
            a4Var.a(b, str, "POST", i5Var);
            int i = i5Var.b;
            h5.this.f.submit(new g5(this, i));
            if (i == 0) {
                c4.a().a(str2, b);
            }
            return Integer.valueOf(i);
        }
    }

    public h5(Context context) {
        this.f10103a = context;
        this.b = new m3(context);
    }
}
