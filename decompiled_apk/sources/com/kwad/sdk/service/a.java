package com.kwad.sdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.proxy.app.DownloadService;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes11.dex */
public class a extends com.kwad.sdk.l.a {
    private com.kwad.sdk.c aOT;
    private Service aOV;
    private final Map<String, Integer> aOU = new ConcurrentHashMap();
    private final HandlerC0873a aOW = new HandlerC0873a(this);

    /* renamed from: com.kwad.sdk.service.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0873a extends Handler {
        final WeakReference<a> aOX;

        public HandlerC0873a(a aVar) {
            this.aOX = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar = this.aOX.get();
            if (aVar != null && message.what == 1) {
                if (aVar.aOT != null && aVar.aOT.yw()) {
                    aVar.aOV.stopSelf();
                } else {
                    sendEmptyMessageDelayed(1, 30000L);
                }
            }
        }
    }

    private void g(Intent intent) {
        Integer num;
        if (intent == null) {
            return;
        }
        try {
            int i = 0;
            int intExtra = intent.getIntExtra("download_service_type_tag", 0);
            String stringExtra = intent.getStringExtra("download_service_id_tag");
            DownloadTask.DownloadRequest downloadRequest = (DownloadTask.DownloadRequest) intent.getSerializableExtra("download_service_args_tag");
            if (TextUtils.isEmpty(stringExtra)) {
                num = null;
            } else {
                num = this.aOU.get(stringExtra);
            }
            if (num != null) {
                i = num.intValue();
            }
            if (intExtra != 1) {
                if (intExtra != 2) {
                    if (intExtra != 3) {
                        if (intExtra == 4) {
                            if (i != 0) {
                                this.aOT.cancel(i);
                                return;
                            }
                            String stringExtra2 = intent.getStringExtra("download_service_path");
                            if (stringExtra2 != null) {
                                com.kwad.sdk.c.bW(stringExtra2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.aOT.resume(i);
                    return;
                }
                this.aOT.pause(i);
                return;
            }
            this.aOU.put(stringExtra, Integer.valueOf(this.aOT.a(downloadRequest, (com.kwad.sdk.a) null)));
        } catch (Exception unused) {
        }
    }

    @InvokeBy(invokerClass = b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        b.a(DownloadService.class, a.class);
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        if (service == null) {
            return;
        }
        this.aOV = service;
        this.aOT = com.kwad.sdk.c.yq();
        this.aOW.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // com.kwad.sdk.l.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        g(intent);
        return super.onStartCommand(service, intent, i, i2);
    }
}
