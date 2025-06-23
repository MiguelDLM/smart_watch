package com.baidu.ar;

import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes7.dex */
public class ee {
    private static final int qS;
    private static final int qT;
    private static final int qU;
    private static final BlockingQueue<Runnable> qV;
    private static final BlockingQueue<Runnable> qW;
    private static final BlockingQueue<Runnable> qX;
    private static ThreadPoolExecutor qY;
    private static ThreadPoolExecutor qZ;
    private static ThreadPoolExecutor ra;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        qS = availableProcessors;
        int i = availableProcessors + 1;
        qT = i;
        int i2 = (availableProcessors * 2) + 1;
        qU = i2;
        Log.d("ThreadPoolFactory", "CPU_COUNT = " + availableProcessors + ", CORE_POOL_SIZE = " + i + ", MAXIMUM_POOL_SIZE = " + i2 + ", KEEP_ALIVE = 15");
        qV = new LinkedBlockingQueue(128);
        qW = new LinkedBlockingQueue(128);
        qX = new LinkedBlockingQueue(128);
        qY = null;
        qZ = null;
        ra = null;
    }

    private static void a(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }

    public static void shutdown() {
        try {
            a(ra);
            a(qY);
            a(qZ);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
