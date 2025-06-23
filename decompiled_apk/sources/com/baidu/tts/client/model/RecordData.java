package com.baidu.tts.client.model;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.j1;
import com.baidu.tts.m3;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.openalliance.ad.constant.bn;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class RecordData {

    /* renamed from: a, reason: collision with root package name */
    public m3 f10064a;
    public ExecutorService b = Executors.newSingleThreadExecutor();

    /* loaded from: classes8.dex */
    public class InsertData implements Callable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public JSONObject f10065a;
        public String b;
        public String c;

        public InsertData(JSONObject jSONObject, String str, String str2) {
            this.f10065a = jSONObject;
            this.b = str;
            this.c = str2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            j1 j1Var;
            SQLiteDatabase writableDatabase;
            JSONObject jSONObject = this.f10065a;
            if (jSONObject == null && this.c == null) {
                m3 m3Var = RecordData.this.f10064a;
                String str = this.b;
                j1Var = m3Var.c;
                j1Var.d.lock();
                writableDatabase = j1Var.b.getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Constant.MAP_KEY_UUID, str);
                    writableDatabase.insert("StatisticsInfo", null, contentValues);
                } finally {
                }
            } else if (jSONObject != null) {
                m3 m3Var2 = RecordData.this.f10064a;
                String str2 = this.b;
                String str3 = this.c;
                String jSONObject2 = jSONObject.toString();
                j1Var = m3Var2.c;
                j1Var.d.lock();
                writableDatabase = j1Var.b.getWritableDatabase();
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put(str3, jSONObject2);
                    if (writableDatabase.update("StatisticsInfo", contentValues2, "uuid=?", new String[]{str2}) == 0) {
                        writableDatabase.insert("StatisticsInfo", null, contentValues2);
                    }
                    writableDatabase.close();
                    j1Var.d.unlock();
                } finally {
                }
            }
            return 0;
        }
    }

    public RecordData(m3 m3Var) {
        this.f10064a = m3Var;
    }

    public void setEndInfo(String str, String str2, int i, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("modeId", str2);
            jSONObject.put("result", i);
            jSONObject.put("endTime", str3);
            LoggerProxy.d("RecordData", "EndInfo json= " + jSONObject.toString());
            this.b.submit(new InsertData(jSONObject, str, "endInfo"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setStartInfo(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bn.f.g, str3);
            jSONObject.put("modeId", str2);
            LoggerProxy.d("RecordData", " StartInfo json= " + jSONObject.toString());
            this.b.submit(new InsertData(null, str, null));
            this.b.submit(new InsertData(jSONObject, str, "startInfo"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
