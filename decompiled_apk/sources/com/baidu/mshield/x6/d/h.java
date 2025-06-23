package com.baidu.mshield.x6.d;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public Context f6436a;

    public h(Context context, int i) {
        this.f6436a = context;
    }

    public JSONObject a() {
        try {
            return b();
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d8 A[Catch: all -> 0x0228, TRY_LEAVE, TryCatch #1 {all -> 0x0228, blocks: (B:3:0x0008, B:5:0x0022, B:7:0x002b, B:9:0x0034, B:11:0x0045, B:13:0x0056, B:15:0x0079, B:19:0x0088, B:21:0x008d, B:23:0x0096, B:42:0x00fd, B:44:0x0113, B:58:0x01a8, B:61:0x01af, B:63:0x01d8, B:65:0x0200, B:67:0x020e, B:69:0x0214, B:70:0x0218, B:72:0x021e, B:74:0x022b, B:75:0x023f, B:77:0x0267, B:79:0x0270, B:80:0x0277, B:82:0x0281, B:84:0x028d, B:86:0x02ac, B:88:0x02b2, B:89:0x02b6, B:91:0x02bc, B:93:0x02c6, B:94:0x02da, B:95:0x02df, B:99:0x0194, B:105:0x01a2, B:119:0x00fa, B:102:0x0199, B:26:0x00b6, B:32:0x00dd, B:36:0x00e7, B:38:0x00ec, B:41:0x00f5), top: B:2:0x0008, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0281 A[Catch: all -> 0x0228, TryCatch #1 {all -> 0x0228, blocks: (B:3:0x0008, B:5:0x0022, B:7:0x002b, B:9:0x0034, B:11:0x0045, B:13:0x0056, B:15:0x0079, B:19:0x0088, B:21:0x008d, B:23:0x0096, B:42:0x00fd, B:44:0x0113, B:58:0x01a8, B:61:0x01af, B:63:0x01d8, B:65:0x0200, B:67:0x020e, B:69:0x0214, B:70:0x0218, B:72:0x021e, B:74:0x022b, B:75:0x023f, B:77:0x0267, B:79:0x0270, B:80:0x0277, B:82:0x0281, B:84:0x028d, B:86:0x02ac, B:88:0x02b2, B:89:0x02b6, B:91:0x02bc, B:93:0x02c6, B:94:0x02da, B:95:0x02df, B:99:0x0194, B:105:0x01a2, B:119:0x00fa, B:102:0x0199, B:26:0x00b6, B:32:0x00dd, B:36:0x00e7, B:38:0x00ec, B:41:0x00f5), top: B:2:0x0008, inners: #0, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject b() {
        /*
            Method dump skipped, instructions count: 772
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x6.d.h.b():org.json.JSONObject");
    }

    public final void a(Throwable th) {
        com.baidu.mshield.x6.e.f.a(th);
    }

    public static String a(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return null;
            }
            String stringExtra = registerReceiver.getStringExtra("technology");
            return TextUtils.isEmpty(stringExtra) ? "unknown" : stringExtra;
        } catch (Exception e) {
            com.baidu.mshield.x6.e.f.a(e);
            return null;
        }
    }
}
