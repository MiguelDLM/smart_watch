package com.baidu.ar;

import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class ep {
    private ExecutorService rH;
    private int rI;
    private int rJ;
    private int rK;
    private long rL;

    public ep(int i, int i2, int i3, long j) {
        this.rI = i;
        this.rJ = i2;
        this.rK = i3;
        this.rL = j;
    }

    private ExecutorService dK() {
        if (this.rH == null) {
            this.rH = new ThreadPoolExecutor(this.rI, this.rJ, this.rL, TimeUnit.SECONDS, new LinkedBlockingQueue(this.rK), Executors.defaultThreadFactory(), new RejectedExecutionHandler() { // from class: com.baidu.ar.ep.1
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    kf.b("HttpRequestExecutor", "请求队列已满，请求被丢弃");
                }
            });
        }
        return this.rH;
    }

    public ew a(er erVar, fa faVar, IProgressCallback iProgressCallback) {
        en enVar = new en(erVar, faVar);
        enVar.setProgressCallback(iProgressCallback);
        dK().submit(enVar);
        return enVar;
    }

    public void shutdown() {
        ExecutorService executorService = this.rH;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public ew a(er erVar, IProgressCallback iProgressCallback) {
        en enVar = new en(erVar);
        enVar.setProgressCallback(iProgressCallback);
        enVar.dJ();
        return enVar;
    }

    public ew a(HttpException httpException, fa faVar) {
        el elVar = new el(httpException, faVar);
        dK().submit(elVar);
        return elVar;
    }
}
