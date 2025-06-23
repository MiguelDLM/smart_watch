package com.baidu.tts;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.BasicHandler;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.MD5;
import com.huawei.hms.ads.jsb.constant.Constant;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class m3 {

    /* renamed from: a, reason: collision with root package name */
    public Context f10136a;
    public e1 b;
    public j1 c;
    public w3 d;
    public p1 e;

    public m3(Context context) {
        this.f10136a = context;
        a();
    }

    public final void a() {
        this.b = new e1(this);
        this.c = new j1(this);
        this.d = new w3(this);
        p1 p1Var = new p1();
        this.e = p1Var;
        p1Var.c = this;
        o1 o1Var = p1Var.f10148a;
        o1Var.f10143a = this;
        o1Var.b.b = this.b;
        o1Var.c.i = this;
        o1Var.start();
    }

    public boolean b(String str) {
        Map<String, String> a2 = this.b.a(str);
        if (DataTool.isMapEmpty(a2)) {
            LoggerProxy.d("GetServerModelsWork", "DbManager can not find modelId " + str);
            return false;
        }
        q2 q2Var = q2.TEXT_DATA_ID;
        String str2 = a2.get("text_data_id");
        q2 q2Var2 = q2.SPEECH_DATA_ID;
        String str3 = a2.get("speech_data_id");
        boolean a3 = a(str2);
        boolean a4 = a(str3);
        if (a3 && a4) {
            return true;
        }
        String str4 = new String();
        if (!a3) {
            str4 = str4 + "text resource ";
        }
        if (!a4) {
            str4 = str4 + "speech resource ";
        }
        LoggerProxy.d("GetServerModelsWork", str4 + "is not matched.");
        return false;
    }

    public Map<String, ArrayList> c() {
        j1 j1Var = this.c;
        j1Var.getClass();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        j1Var.e.lock();
        SQLiteDatabase readableDatabase = j1Var.b.getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("select * from StatisticsInfo limit 0,100", null);
        while (rawQuery.moveToNext()) {
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    int i = rawQuery.getInt(rawQuery.getColumnIndex("id"));
                    jSONObject.put(Constant.MAP_KEY_UUID, rawQuery.getString(rawQuery.getColumnIndex(Constant.MAP_KEY_UUID)));
                    jSONObject.put("startInfo", rawQuery.getString(rawQuery.getColumnIndex("startInfo")));
                    jSONObject.put("endInfo", rawQuery.getString(rawQuery.getColumnIndex("endInfo")));
                    arrayList2.add(Integer.valueOf(i));
                    arrayList.add(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } finally {
                rawQuery.close();
                readableDatabase.close();
                j1Var.e.unlock();
            }
        }
        hashMap.put("listId", arrayList2);
        hashMap.put("list", arrayList);
        return hashMap;
    }

    public Context b() {
        return this.f10136a;
    }

    public BasicHandler<ModelBags> a(Conditions conditions, boolean z) {
        w3 w3Var = this.d;
        BasicHandler<ModelBags> basicHandler = new BasicHandler<>(new FutureTask(new r3(w3Var.f10185a.b, conditions, w3Var.f10185a, z)));
        basicHandler.start();
        return basicHandler;
    }

    public BasicHandler<ModelFileBags> a(Set<String> set) {
        this.d.getClass();
        BasicHandler<ModelFileBags> basicHandler = new BasicHandler<>(new FutureTask(new u3(set)));
        basicHandler.start();
        return basicHandler;
    }

    public String a(String str, String str2) {
        e1 e1Var = this.b;
        e1Var.getClass();
        Map<String, String> b = e1Var.b("select b.absPath from speechModel a left join modelFile b on a." + str + "=b.id where a.id=?", new String[]{str2});
        if (b == null) {
            return null;
        }
        q2 q2Var = q2.ABS_PATH;
        return b.get("absPath");
    }

    public boolean a(String str) {
        e1 e1Var = this.b;
        e1Var.getClass();
        Map<String, String> b = e1Var.b("select * from modelFile where id=?", new String[]{str});
        if (DataTool.isMapEmpty(b)) {
            LoggerProxy.d("GetServerModelsWork", "DbManager can not find fileID " + str);
            return false;
        }
        q2 q2Var = q2.ABS_PATH;
        String str2 = b.get("absPath");
        q2 q2Var2 = q2.LENGTH;
        String str3 = b.get("length");
        q2 q2Var3 = q2.MD5;
        String str4 = b.get("md5");
        File file = new File(str2);
        if (file.exists()) {
            long length = file.length();
            long parseLong = Long.parseLong(str3);
            if (length != parseLong) {
                LoggerProxy.d("GetServerModelsWork", "bad model length expected " + parseLong + ", really " + length);
                return false;
            }
            String bigFileMd5 = MD5.getInstance().getBigFileMd5(file);
            if (bigFileMd5.equalsIgnoreCase(str4)) {
                return true;
            }
            LoggerProxy.d("GetServerModelsWork", "bad model md5 expected " + str4 + ", really " + bigFileMd5);
            return false;
        }
        LoggerProxy.d("GetServerModelsWork", "file not exists " + file.getAbsolutePath());
        return false;
    }
}
