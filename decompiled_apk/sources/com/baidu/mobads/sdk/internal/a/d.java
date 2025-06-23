package com.baidu.mobads.sdk.internal.a;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f6212a;
    final /* synthetic */ c b;

    public d(c cVar, a aVar) {
        this.b = cVar;
        this.f6212a = aVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        Object[] objArr;
        if (iOAdEvent != null && c.h.equals(iOAdEvent.getType()) && (data = iOAdEvent.getData()) != null && !data.isEmpty()) {
            Object obj = data.get("e_t");
            Object obj2 = data.get("e_n");
            Object obj3 = data.get("e_a");
            if ((obj instanceof String) && (obj2 instanceof String)) {
                if (obj3 instanceof Object[]) {
                    objArr = (Object[]) obj3;
                } else {
                    objArr = null;
                }
                data.put("e_r", this.f6212a.handleEvent((String) obj, (String) obj2, objArr));
            }
        }
    }
}
