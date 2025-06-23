package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.huawei.openalliance.ad.constant.bn;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class r implements ICommonModuleObj {

    /* renamed from: a, reason: collision with root package name */
    private static volatile r f6336a;
    private CustomNotification b = new CustomNotification();

    private r() {
    }

    public static r a() {
        if (f6336a == null) {
            synchronized (r.class) {
                try {
                    if (f6336a == null) {
                        f6336a = new r();
                    }
                } finally {
                }
            }
        }
        return f6336a;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        if (ICommonModuleObj.KEY_NOTIFICATION.equals(str) && jSONObject != null) {
            Context context = (Context) jSONObject.opt(bn.f.o);
            int optInt = jSONObject.optInt("version", 0);
            String optString = jSONObject.optString(URLPackage.KEY_CHANNEL_ID);
            String optString2 = jSONObject.optString("ticker");
            Bitmap bitmap = (Bitmap) jSONObject.opt(com.huawei.openalliance.ad.constant.x.cD);
            String optString3 = jSONObject.optString("title");
            String optString4 = jSONObject.optString("content");
            String optString5 = jSONObject.optString("status");
            boolean optBoolean = jSONObject.optBoolean("autoCancel");
            int optInt2 = jSONObject.optInt("progress");
            boolean optBoolean2 = jSONObject.optBoolean("indeterminate", false);
            int optInt3 = jSONObject.optInt("smallIcon");
            String optString6 = jSONObject.optString("action");
            PendingIntent pendingIntent = (PendingIntent) jSONObject.opt("pendingIntent");
            String optString7 = jSONObject.optString("action2");
            PendingIntent pendingIntent2 = (PendingIntent) jSONObject.opt("pendingIntent2");
            if (optInt == 1) {
                return this.b.getNewNotification(context, optString2, optBoolean, bitmap, optString3, optString4, optInt2, optBoolean2, optString6, pendingIntent, optString7, pendingIntent2);
            }
            return this.b.getCustomNotification(context, optString, optString2, bitmap, optString3, optString4, optString5, optBoolean, optInt2, optInt3, optString6, pendingIntent);
        }
        return null;
    }
}
