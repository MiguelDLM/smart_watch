package com.baidu.tts;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class c2 {

    /* renamed from: a, reason: collision with root package name */
    public String f10046a;
    public Map<String, String> b = new HashMap();

    public c2(String str) {
        this.f10046a = str;
    }

    public boolean a(e1 e1Var) {
        Map<String, String> b = e1Var.b("select * from modelFile where id=?", new String[]{this.f10046a});
        this.b = b;
        if (DataTool.isMapEmpty(b)) {
            return false;
        }
        Map<String, String> map = this.b;
        q2 q2Var = q2.ABS_PATH;
        String str = map.get("absPath");
        if (StringTool.isEmpty(str)) {
            String str2 = this.f10046a;
            e1Var.d.lock();
            try {
                SQLiteDatabase writableDatabase = e1Var.b.getWritableDatabase();
                try {
                    try {
                        writableDatabase.delete("modelFile", "id=?", new String[]{str2});
                        writableDatabase.close();
                    } catch (Exception unused) {
                    }
                    e1Var.d.unlock();
                    return false;
                } finally {
                    writableDatabase.close();
                }
            } catch (Throwable th) {
                e1Var.d.unlock();
                throw th;
            }
        }
        e2.a().a(str).f = this.f10046a;
        return true;
    }

    public String b() {
        Map<String, String> map = this.b;
        q2 q2Var = q2.LENGTH;
        return DataTool.getMapValue(map, "length");
    }

    public String a() {
        Map<String, String> map = this.b;
        q2 q2Var = q2.ABS_PATH;
        return DataTool.getMapValue(map, "absPath");
    }

    public void a(ModelFileBags modelFileBags, e1 e1Var) {
        e1Var.d.lock();
        try {
            new k1(e1Var.b.getWritableDatabase(), new g1(modelFileBags)).a();
            e1Var.d.unlock();
            a(e1Var);
        } catch (Throwable th) {
            e1Var.d.unlock();
            throw th;
        }
    }
}
