package com.baidu.navisdk.ui.routeguide.control;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.nplatform.comapi.MapItem;
import java.util.HashMap;
import o0oIxXOx.oO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class h implements com.baidu.navisdk.module.pronavi.abs.b {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, b> f8543a = new HashMap<>();
    private final Handler b = new com.baidu.navisdk.util.worker.loop.a("rg_barrage");
    private final Runnable c = new a();

    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: com.baidu.navisdk.ui.routeguide.control.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0439a extends com.baidu.navisdk.util.http.center.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8545a;

            public C0439a(String str) {
                this.f8545a = str;
            }

            @Override // com.baidu.navisdk.util.http.center.f
            public void a(int i, String str, Throwable th) {
            }

            @Override // com.baidu.navisdk.util.http.center.f
            public void a(int i, String str) {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.IMLog;
                if (gVar.d()) {
                    gVar.e("chat list, status:" + i + " response:" + str);
                }
                if (i != 200) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getInt("errno") != 0) {
                        return;
                    }
                    JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("chatlist");
                    if (jSONArray.length() == 0) {
                        return;
                    }
                    b bVar = new b(null);
                    bVar.f8546a = new String[jSONArray.length()];
                    bVar.b = new String[jSONArray.length()];
                    bVar.c = new long[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String optString = jSONObject2.optString("portrait");
                        String string = jSONObject2.getString("message");
                        long optLong = jSONObject2.optLong("timestamp");
                        bVar.f8546a[i2] = optString;
                        bVar.b[i2] = string;
                        bVar.c[i2] = optLong;
                    }
                    if (h.this.a(this.f8545a, bVar)) {
                        BNMapController.getInstance().setBarrageInfo(this.f8545a, bVar.f8546a, bVar.b);
                        h.this.f8543a.put(this.f8545a, bVar);
                    } else {
                        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.IMLog;
                        if (gVar2.d()) {
                            gVar2.e("has now new message");
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = com.baidu.navisdk.module.cloudconfig.f.c().J.d * 1000;
            h.this.b.removeCallbacks(h.this.c);
            h.this.b.postDelayed(h.this.c, i);
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().getRouteInfoInUniform(42, bundle);
            String string = bundle.getString("eventId");
            long j = bundle.getLong("roomId");
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.IMLog;
            if (gVar.d()) {
                gVar.e("show barrage, event:" + string + " room:" + j);
            }
            if (!TextUtils.isEmpty(string) && j != 0) {
                com.baidu.navisdk.util.http.center.b.a().b(com.baidu.navisdk.util.http.b.d().b("chatList"), h.this.a(string, j), new C0439a(string), new com.baidu.navisdk.util.http.center.e());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String[] f8546a;
        String[] b;
        long[] c;

        private b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    @Override // com.baidu.navisdk.module.pronavi.abs.b
    public void release() {
        this.f8543a.clear();
        this.b.removeCallbacks(this.c);
    }

    public void a(int i) {
        if (i == 1) {
            this.b.removeCallbacks(this.c);
        } else {
            this.b.removeCallbacks(this.c);
            this.c.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, b bVar) {
        b bVar2 = this.f8543a.get(str);
        if (bVar2 == null) {
            return true;
        }
        return a(bVar) > a(bVar2);
    }

    private long a(b bVar) {
        long[] jArr = bVar.c;
        long j = 0;
        if (jArr == null) {
            return 0L;
        }
        for (long j2 : jArr) {
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> a(String str, long j) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("event_id", str);
        hashMap.put("room_id", j + "");
        hashMap.put(MapItem.KEY_ITEM_SID, "1");
        hashMap.put(oO.f31192XO, "0");
        com.baidu.navisdk.util.http.a.a(hashMap);
        hashMap.put(HttpConstants.SIGN, com.baidu.navisdk.util.common.v.b("ugc" + com.baidu.navisdk.util.http.center.c.a(hashMap) + "a7b5688d605948697e5dcbe9a37ec223").toLowerCase());
        return hashMap;
    }
}
