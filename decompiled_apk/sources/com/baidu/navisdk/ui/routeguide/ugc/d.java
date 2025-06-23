package com.baidu.navisdk.ui.routeguide.ugc;

import android.content.Context;
import com.baidu.navisdk.util.common.g;
import com.google.android.gms.fitness.FitnessStatusCodes;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes8.dex */
public class d {
    private static volatile d d;

    /* renamed from: a, reason: collision with root package name */
    private String f9149a = "UgcVerifyFreqController";
    private e b;
    private HashMap<Integer, String> c;

    private d(Context context) {
        this.b = new e(context, "ugc_verify_freq");
        HashMap<Integer, String> hashMap = new HashMap<>();
        this.c = hashMap;
        hashMap.put(110, "road_build");
        this.c.put(Integer.valueOf(FitnessStatusCodes.INCONSISTENT_PACKAGE_NAME), "may_be_stopped");
        this.c.put(5012, "abnormal_gate");
    }

    public String a(int i) {
        return this.c.get(Integer.valueOf(i));
    }

    public boolean b(String str) {
        g gVar = g.UGC;
        if (gVar.d()) {
            gVar.e(this.f9149a, "type freq match start");
        }
        long a2 = this.b.a(str, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a2 >= 86400000) {
            if (gVar.d()) {
                gVar.e(this.f9149a, "type freq match true, new record time = " + currentTimeMillis);
                return true;
            }
            return true;
        }
        return false;
    }

    public static d a(Context context) {
        if (d == null) {
            d = new d(context);
        }
        return d;
    }

    public void a(String str) {
        e eVar = this.b;
        if (eVar != null) {
            eVar.b(str, System.currentTimeMillis());
        }
    }

    public Map<String, ?> a() {
        return this.b.a();
    }
}
