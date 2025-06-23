package com.baidu.tts;

import android.database.sqlite.SQLiteDatabase;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes8.dex */
public class d2 {

    /* renamed from: a, reason: collision with root package name */
    public String f10070a;
    public String b;
    public String c;
    public String d;
    public long e = 0;
    public a2 f = a2.a();
    public CopyOnWriteArraySet<DownloadHandler> g = new CopyOnWriteArraySet<>();

    public d2(String str) {
        this.f10070a = str;
    }

    public void a(DownloadHandler downloadHandler) {
        boolean isSetEmpty = DataTool.isSetEmpty(this.g);
        LoggerProxy.d("ModelFlyweight", "unregisterListener 1isEmpty=" + isSetEmpty);
        if (isSetEmpty) {
            return;
        }
        this.g.remove(downloadHandler);
        boolean isSetEmpty2 = DataTool.isSetEmpty(this.g);
        LoggerProxy.d("ModelFlyweight", "unregisterListener 2isEmpty=" + isSetEmpty2);
        if (isSetEmpty2) {
            c();
            return;
        }
        Iterator<DownloadHandler> it = this.g.iterator();
        while (it.hasNext()) {
            LoggerProxy.d("ModelFlyweight", "unregisterListener item=" + it.next());
        }
    }

    public void b() {
        long j = 0;
        if (this.e == 0) {
            e2 a2 = e2.a();
            String b = a2.b(this.b).b();
            String b2 = a2.b(this.c).b();
            long parseLong = Long.parseLong(b);
            long parseLong2 = Long.parseLong(b2);
            if (!StringTool.isEmpty(this.d)) {
                j = Long.parseLong(a2.b(this.d).b());
            }
            this.e = parseLong + parseLong2 + j;
        }
    }

    public final void c() {
        this.f.a(this.b, this.f10070a);
        this.f.a(this.c, this.f10070a);
        if (!StringTool.isEmpty(this.d)) {
            this.f.a(this.d, this.f10070a);
        }
    }

    public Set<String> a() {
        HashSet hashSet = new HashSet();
        e2 a2 = e2.a();
        c2 b = a2.b(this.b);
        c2 b2 = a2.b(this.c);
        String a3 = b.a();
        String a4 = b2.a();
        hashSet.add(a3);
        hashSet.add(a4);
        if (!StringTool.isEmpty(this.d)) {
            hashSet.add(a2.b(this.d).a());
        }
        return hashSet;
    }

    public boolean a(e1 e1Var) {
        Map<String, String> a2 = e1Var.a(this.f10070a);
        if (!e1Var.a("speechModel", "speech_ext_data_id")) {
            e1Var.a("speechModel", "speech_ext_data_id", TypedValues.Custom.S_INT);
        }
        if (!e1Var.a("speechModel", "tac_subgan_speaker_attr")) {
            e1Var.a("speechModel", "tac_subgan_speaker_attr", "varchar(256)");
        }
        if (a2 == null || a2.isEmpty()) {
            return false;
        }
        q2 q2Var = q2.TEXT_DATA_ID;
        this.b = DataTool.getMapValue(a2, "text_data_id");
        q2 q2Var2 = q2.SPEECH_DATA_ID;
        this.c = DataTool.getMapValue(a2, "speech_data_id");
        q2 q2Var3 = q2.SPEECH_EXT_DATA_ID;
        this.d = DataTool.getMapValue(a2, "speech_ext_data_id");
        boolean isEmpty = StringTool.isEmpty(this.b);
        boolean isEmpty2 = StringTool.isEmpty(this.c);
        if (!isEmpty && !isEmpty2) {
            return true;
        }
        String str = this.f10070a;
        e1Var.d.lock();
        try {
            SQLiteDatabase writableDatabase = e1Var.b.getWritableDatabase();
            try {
                writableDatabase.delete("speechModel", "id=?", new String[]{str});
                writableDatabase.close();
            } catch (Exception unused) {
                writableDatabase.close();
            } catch (Throwable th) {
                writableDatabase.close();
                throw th;
            }
            e1Var.d.unlock();
            return false;
        } catch (Throwable th2) {
            e1Var.d.unlock();
            throw th2;
        }
    }

    public void a(ModelBags modelBags, e1 e1Var) {
        e1Var.d.lock();
        try {
            new k1(e1Var.b.getWritableDatabase(), new h1(modelBags)).a();
            e1Var.d.unlock();
            a(e1Var);
        } catch (Throwable th) {
            e1Var.d.unlock();
            throw th;
        }
    }
}
