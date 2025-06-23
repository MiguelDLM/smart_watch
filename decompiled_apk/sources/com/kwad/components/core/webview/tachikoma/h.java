package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes11.dex */
public final class h {
    private final Map<String, HashMap<Integer, String>> Zp = new ConcurrentHashMap();
    private Map<String, Integer> Zq = new ConcurrentSkipListMap();
    private int Zr = 0;

    /* loaded from: classes11.dex */
    public static class a {
        private static final h Zs = new h();
    }

    private static int aR(String str) {
        return ((str.length() * 2) + 44) / 1024;
    }

    private void q(String str, String str2) {
        int aR = aR(str2);
        this.Zr += aR;
        this.Zq.put(str, Integer.valueOf(aR));
    }

    public static h tf() {
        return a.Zs;
    }

    public final void b(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str2) && com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aui) != 0) {
            if (this.Zp.containsKey(str)) {
                if (this.Zp.get(str).containsKey(Integer.valueOf(i))) {
                    return;
                } else {
                    this.Zp.remove(str);
                }
            }
            aR(aR(str2));
            HashMap<Integer, String> hashMap = new HashMap<>();
            hashMap.put(Integer.valueOf(i), str2);
            this.Zp.put(str, hashMap);
            q(str, str2);
        }
    }

    public final String n(String str, int i) {
        if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aui) != 0 && this.Zp.containsKey(str)) {
            HashMap<Integer, String> hashMap = this.Zp.get(str);
            if (hashMap.containsKey(Integer.valueOf(i))) {
                return hashMap.get(Integer.valueOf(i));
            }
        }
        return "";
    }

    private void aR(int i) {
        if (this.Zr + i > com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aui)) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, Integer>> it = this.Zq.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                arrayList.add(next.getKey());
                this.Zr -= next.getValue().intValue();
                it.remove();
                if (this.Zr <= com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aui) - i) {
                    break;
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.Zp.remove((String) it2.next());
            }
        }
    }
}
