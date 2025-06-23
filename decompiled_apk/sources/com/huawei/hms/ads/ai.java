package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ai {
    private static final String Code = "JsbCmdManager";
    private static final byte[] I = new byte[0];
    private static ai V;
    private final List<String> B;
    private final Map<String, Class<? extends ad>> C;
    private final Map<String, ad> Z = new HashMap();

    /* loaded from: classes10.dex */
    public static class a<T> implements Runnable {
        private ad B;
        private final Context Code;
        private final String I;
        private final String V;
        private final RemoteCallResultCallback<String> Z;

        public a(Context context, ad adVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
            this.Code = context;
            this.V = str;
            this.I = str2;
            this.Z = remoteCallResultCallback;
            this.B = adVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ai.V(this.Code, this.B, this.V, this.I, this.Z);
        }
    }

    private ai() {
        ArrayList arrayList = new ArrayList();
        this.B = arrayList;
        HashMap hashMap = new HashMap();
        this.C = hashMap;
        hashMap.put(aj.V, com.huawei.openalliance.ad.utils.ar.Code(com.huawei.openalliance.ad.constant.x.bA));
        hashMap.put(aj.F, com.huawei.openalliance.ad.utils.ar.Code(com.huawei.openalliance.ad.constant.x.bA));
        hashMap.put(aj.J, com.huawei.openalliance.ad.utils.ar.Code(com.huawei.openalliance.ad.constant.x.bA));
        hashMap.put(aj.I, com.huawei.openalliance.ad.utils.ar.Code("com.huawei.openalliance.ad.jsb.JsbRewardProxy"));
        hashMap.put(aj.Z, com.huawei.openalliance.ad.utils.ar.Code("com.huawei.openalliance.ad.jsb.JsbInterstitialProxy"));
        hashMap.put(aj.B, com.huawei.openalliance.ad.utils.ar.Code(com.huawei.openalliance.ad.constant.x.bF));
        hashMap.put(aj.C, ae.class);
        hashMap.put(aj.c, bb.class);
        hashMap.put(aj.d, bc.class);
        hashMap.put(aj.S, bg.class);
        hashMap.put(aj.L, be.class);
        hashMap.put(aj.D, bf.class);
        hashMap.put(aj.f17253a, ba.class);
        hashMap.put(aj.b, at.class);
        hashMap.put(aj.e, az.class);
        hashMap.put(aj.i, ay.class);
        hashMap.put(aj.g, av.class);
        hashMap.put(aj.h, aw.class);
        hashMap.put(aj.j, com.huawei.openalliance.ad.utils.ar.Code("com.huawei.openalliance.ad.jsb.JsbRewardProxy"));
        hashMap.put(aj.k, com.huawei.openalliance.ad.utils.ar.Code("com.huawei.openalliance.ad.jsb.JsbInterstitialProxy"));
        hashMap.put(aj.m, bs.class);
        hashMap.put(aj.H, bq.class);
        hashMap.put(aj.l, br.class);
        hashMap.put(aj.o, bk.class);
        hashMap.put(aj.n, bj.class);
        hashMap.put(aj.p, bp.class);
        hashMap.put(aj.q, bo.class);
        hashMap.put(aj.r, bm.class);
        hashMap.put(aj.s, bn.class);
        hashMap.put(aj.t, bl.class);
        hashMap.put(aj.Code, an.class);
        hashMap.put(aj.u, am.class);
        hashMap.put(aj.y, bd.class);
        hashMap.put(aj.z, bh.class);
        hashMap.put(aj.f, au.class);
        if (com.huawei.openalliance.ad.utils.ar.Code(com.huawei.openalliance.ad.constant.x.bG) != null) {
            hashMap.put(aj.v, ap.class);
            hashMap.put(aj.w, ar.class);
            hashMap.put(aj.x, aq.class);
        }
        hashMap.put(aj.A, ao.class);
        hashMap.put(aj.E, ak.class);
        hashMap.put(aj.G, al.class);
        arrayList.add(aj.C);
        arrayList.add(aj.j);
        arrayList.add(aj.k);
        arrayList.add(aj.F);
        arrayList.add(aj.J);
    }

    public static String V(String str) {
        return new JSONObject(str).optString(com.huawei.openalliance.ad.constant.aw.Y);
    }

    public ad Code(String str) {
        StringBuilder sb;
        String str2;
        String sb2;
        if (!TextUtils.isEmpty(str)) {
            ad adVar = this.Z.get(str);
            if (adVar == null) {
                fb.Code(Code, "create command %s", str);
                Class<? extends ad> cls = this.C.get(str);
                if (cls == null) {
                    sb = new StringBuilder();
                    str2 = "no class found for cmd: ";
                } else {
                    try {
                        adVar = cls.newInstance();
                    } catch (InstantiationException unused) {
                        fb.I(Code, "get cmd %s Instantiation Exception", str);
                    } catch (Throwable th) {
                        fb.I(Code, "get cmd %s: %s", str, th.getClass().getSimpleName());
                    }
                    if (adVar == null) {
                        sb = new StringBuilder();
                        str2 = "no instance created for cmd: ";
                    } else {
                        this.Z.put(str, adVar);
                    }
                }
                sb.append(str2);
                sb.append(str);
                sb2 = sb.toString();
            }
            return adVar;
        }
        sb2 = "get cmd, method is empty";
        fb.I(Code, sb2);
        return null;
    }

    public static ai Code() {
        ai aiVar;
        synchronized (I) {
            try {
                if (V == null) {
                    V = new ai();
                }
                aiVar = V;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aiVar;
    }

    public void V() {
        this.Z.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, ad adVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (adVar == null) {
            String str3 = "api for " + str + " is not found";
            fb.V(Code, "call " + str3);
            ag.Code(remoteCallResultCallback, str, -1, str3, true);
            return;
        }
        fb.V(Code, "call method: " + str);
        if (fb.Code()) {
            fb.Code(Code, "param: %s", com.huawei.openalliance.ad.utils.bh.Code(str2));
        }
        try {
            adVar.execute(context, str2, remoteCallResultCallback);
        } catch (Throwable th) {
            fb.I(Code, "call method %s, ex: %s", str, th.getClass().getSimpleName());
            ag.Code(remoteCallResultCallback, str, -1, th.getClass().getSimpleName() + ":" + th.getMessage(), true);
            fb.Code(3, th);
        }
    }

    public boolean Code(String str, Context context) {
        return (context instanceof Activity) && this.B.contains(str);
    }
}
