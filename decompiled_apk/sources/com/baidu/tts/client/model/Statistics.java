package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.f5;
import com.baidu.tts.h5;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* loaded from: classes8.dex */
public class Statistics {
    public static boolean isStatistics = true;

    /* renamed from: a, reason: collision with root package name */
    public f5 f10066a;

    public Statistics(Context context) {
        this.f10066a = new f5(context);
    }

    public static void setEnable(boolean z) {
        isStatistics = z;
    }

    public int start() {
        int i;
        f5 f5Var = this.f10066a;
        h5 h5Var = f5Var.f10089a;
        h5Var.getClass();
        FutureTask<Integer> futureTask = new FutureTask<>(new h5.a());
        h5Var.c = futureTask;
        h5Var.f.submit(futureTask);
        FutureTask<Integer> futureTask2 = h5Var.c;
        f5Var.b = futureTask2;
        try {
            i = futureTask2.get().intValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
            i = -1;
            LoggerProxy.d("StatisticsClient", "Statistics uploade result=" + i);
            return 0;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            i = -1;
            LoggerProxy.d("StatisticsClient", "Statistics uploade result=" + i);
            return 0;
        }
        LoggerProxy.d("StatisticsClient", "Statistics uploade result=" + i);
        return 0;
    }

    public int stop() {
        f5 f5Var = this.f10066a;
        if (f5Var.b != null) {
            f5Var.f10089a.c.cancel(true);
            return 0;
        }
        return 0;
    }
}
