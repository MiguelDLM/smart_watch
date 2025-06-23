package com.huawei.openalliance.ad.download;

import android.content.Context;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.download.DownloadTask;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class b<T extends DownloadTask> {
    private static final String Z = "DownloadManager";
    protected Context Code;
    protected c<T> I;
    protected DownloadListener<T> V;

    public b(Context context) {
        this.Code = context.getApplicationContext();
    }

    public T Code(String str) {
        return this.I.Code(str);
    }

    public boolean I(T t) {
        if (t == null) {
            return false;
        }
        boolean V = this.I.V(t);
        fb.V(Z, "removeTask, succ:" + V);
        if (!V) {
            return true;
        }
        Z(t);
        return true;
    }

    public void V() {
        fb.V(Z, "cancelAllDownload");
        Iterator<T> it = this.I.Code().iterator();
        while (it.hasNext()) {
            Z(it.next());
        }
        this.I.V();
    }

    public void Z(T t) {
        if (t == null) {
            return;
        }
        if (fb.Code()) {
            fb.Code(Z, "onDownloadDeleted, taskId:%s", t.F());
        }
        DownloadListener<T> downloadListener = this.V;
        if (downloadListener != null) {
            downloadListener.onDownloadDeleted(t);
        }
    }

    public void Code() {
        if (this.I == null) {
            this.I = new c<>();
        }
    }

    public void V(T t) {
        if (t == null) {
            return;
        }
        fb.V(Z, "deleteTask, succ:%s, taskId:%s", Boolean.valueOf(this.I.V(t)), t.F());
    }

    public void Code(DownloadListener<T> downloadListener) {
        this.V = downloadListener;
    }

    public void Code(T t) {
        this.I.Code((c<T>) t);
        if (fb.Code()) {
            fb.Code(Z, "addTask, task:%s, priority:%s", t.F(), Integer.valueOf(t.C()));
        }
    }
}
