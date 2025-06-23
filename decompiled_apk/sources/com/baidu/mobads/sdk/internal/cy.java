package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class cy implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cv f6299a;

    public cy(cv cvVar) {
        this.f6299a = cvVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        int i;
        int i2;
        int i3;
        int i4;
        String str;
        if (iOAdEvent != null) {
            try {
                if (iOAdEvent.getData() != null) {
                    Object obj = iOAdEvent.getData().get("intervalpages");
                    Object obj2 = iOAdEvent.getData().get("bannerseconds");
                    Object obj3 = iOAdEvent.getData().get("novelrouter");
                    Object obj4 = iOAdEvent.getData().get("entry");
                    Object obj5 = iOAdEvent.getData().get(URLPackage.KEY_CHANNEL_ID);
                    Object obj6 = iOAdEvent.getData().get("contentId");
                    if (obj3 != null) {
                        if (obj != null) {
                            i = ((Integer) obj).intValue();
                        } else {
                            i = 6;
                        }
                        if (obj2 != null) {
                            i2 = ((Integer) obj2).intValue();
                        } else {
                            i2 = 10;
                        }
                        if (obj4 != null) {
                            i3 = ((Integer) obj4).intValue();
                        } else {
                            i3 = 0;
                        }
                        if (obj5 != null) {
                            i4 = ((Integer) obj5).intValue();
                        } else {
                            i4 = 1022;
                        }
                        if (obj6 != null) {
                            str = (String) obj6;
                        } else {
                            str = null;
                        }
                        String str2 = str;
                        JSONObject jSONObject = new JSONObject();
                        if (ao.f()) {
                            jSONObject.put("status", "0");
                        } else {
                            jSONObject.put("status", "1");
                        }
                        this.f6299a.a(jSONObject);
                        this.f6299a.a(i, i2, (String) obj3, i3, i4, str2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
