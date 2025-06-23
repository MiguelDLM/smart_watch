package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class b {
    private static List<String> aHR = null;
    private static List<String> aHS = null;
    private static int aHT = 5;

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aHR = new ArrayList();
        List<String> list = aVar.aIe;
        if (list != null && !list.isEmpty()) {
            aHR.addAll(aVar.aIe);
        } else {
            aHR.add("com.kwad");
            aHR.add("com.kwai");
            aHR.add("com.ksad");
            aHR.add("tkruntime");
            aHR.add("tachikoma");
            aHR.add("kuaishou");
        }
        aHT = aVar.aIj;
        aHS = new ArrayList();
        List<String> list2 = aVar.aId;
        if (list2 != null && !list2.isEmpty()) {
            aHS.addAll(aVar.aId);
            return;
        }
        aHS.add("android.");
        aHS.add("androidx.");
        aHS.add("org.");
        aHS.add("java.");
    }

    private static boolean fF(String str) {
        List<String> list = aHS;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean fG(String str) {
        List<String> list = aHR;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String fH(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\n");
        com.kwad.sdk.core.e.c.d("perfMonitor.Filter", "stacks after split:" + split.length);
        boolean z = false;
        int i = 0;
        for (String str2 : split) {
            if (z || !fF(str2)) {
                if (i >= aHT) {
                    return "";
                }
                if (fG(str2)) {
                    return str;
                }
                i++;
                z = true;
            }
        }
        return "";
    }
}
