package com.baidu.tts;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.h5;

/* loaded from: classes8.dex */
public class g5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10098a;
    public final /* synthetic */ h5.a b;

    public g5(h5.a aVar, int i) {
        this.b = aVar;
        this.f10098a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f10098a == 0) {
            h5 h5Var = h5.this;
            m3 m3Var = h5Var.b;
            int i = h5Var.d;
            int i2 = h5Var.e;
            j1 j1Var = m3Var.c;
            j1Var.d.lock();
            SQLiteDatabase readableDatabase = j1Var.b.getReadableDatabase();
            try {
                int delete = readableDatabase.delete("StatisticsInfo", "id between ? and ?", new String[]{Integer.toString(i), Integer.toString(i2)});
                LoggerProxy.d("StatisticsDbManager", "delete database=" + delete + "=" + i + "=" + i2);
                readableDatabase.close();
                j1Var.d.unlock();
                LoggerProxy.d("UploadStatistics", "delete database code==" + delete);
            } catch (Throwable th) {
                readableDatabase.close();
                j1Var.d.unlock();
                throw th;
            }
        }
    }
}
