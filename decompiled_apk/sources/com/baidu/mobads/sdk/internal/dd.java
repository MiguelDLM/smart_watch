package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CPUDramaListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;

/* loaded from: classes7.dex */
class dd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IOAdEvent f6304a;
    final /* synthetic */ dc b;

    public dd(dc dcVar, IOAdEvent iOAdEvent) {
        this.b = dcVar;
        this.f6304a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        CPUDramaListener cPUDramaListener;
        String str;
        CPUDramaListener cPUDramaListener2;
        CPUDramaListener cPUDramaListener3;
        IOAdEvent iOAdEvent = this.f6304a;
        if (iOAdEvent != null && !TextUtils.isEmpty(iOAdEvent.getType())) {
            String type = this.f6304a.getType();
            cPUDramaListener = this.b.f6303a.s;
            if (cPUDramaListener == null) {
                return;
            }
            if ("onContentLoaded".equals(type)) {
                cPUDramaListener3 = this.b.f6303a.s;
                cPUDramaListener3.onContentLoaded();
                return;
            }
            if ("onContentFailed".equals(type)) {
                HashMap hashMap = (HashMap) this.f6304a.getData();
                int i = 0;
                if (hashMap != null) {
                    str = (String) hashMap.get("error_message");
                    Object obj = hashMap.get("error_code");
                    if (obj == null) {
                        obj = 0;
                    }
                    i = ((Integer) obj).intValue();
                } else {
                    str = "";
                }
                cPUDramaListener2 = this.b.f6303a.s;
                cPUDramaListener2.onContentFailed(i, str);
                return;
            }
            if (x.as.equals(type)) {
                this.b.f6303a.l(this.f6304a);
            } else if (x.at.equals(type)) {
                this.b.f6303a.m(this.f6304a);
            }
        }
    }
}
