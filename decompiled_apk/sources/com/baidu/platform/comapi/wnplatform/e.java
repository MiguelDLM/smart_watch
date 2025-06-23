package com.baidu.platform.comapi.wnplatform;

import android.os.Handler;
import android.os.Message;
import com.baidu.ar.baidumap.DownloadListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class e implements DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f9903a;

    public e(c cVar) {
        this.f9903a = cVar;
    }

    @Override // com.baidu.ar.baidumap.DownloadListener
    public void onDownloadComplete(boolean z) {
        Handler handler;
        Handler handler2;
        handler = this.f9903a.g;
        if (handler != null) {
            Message message = new Message();
            message.what = 1;
            message.obj = new Boolean(z);
            handler2 = this.f9903a.g;
            handler2.sendMessage(message);
        }
    }

    @Override // com.baidu.ar.baidumap.DownloadListener
    public void onDownloadError(int i, String str) {
        Handler handler;
        Handler handler2;
        handler = this.f9903a.g;
        if (handler != null) {
            Message message = new Message();
            message.what = 2;
            message.obj = str;
            handler2 = this.f9903a.g;
            handler2.sendMessage(message);
        }
    }

    @Override // com.baidu.ar.baidumap.DownloadListener
    public void onDownloadProcess(int i) {
    }

    @Override // com.baidu.ar.baidumap.DownloadListener
    public void onDownloadStart(boolean z) {
        Handler handler;
        Handler handler2;
        handler = this.f9903a.g;
        if (handler != null) {
            Message message = new Message();
            message.what = 0;
            handler2 = this.f9903a.g;
            handler2.sendMessage(message);
        }
    }
}
