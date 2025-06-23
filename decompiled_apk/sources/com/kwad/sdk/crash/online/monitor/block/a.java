package com.kwad.sdk.crash.online.monitor.block;

import android.os.Looper;
import android.util.Printer;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class a {
    private static volatile boolean aHH;
    private static String aHI;
    private static List<String> aHJ;
    private static List<String> aHK;
    private static volatile boolean aHL;
    private static volatile boolean aHM;

    public static boolean IA() {
        if (aHM) {
            return aHL;
        }
        try {
            String str = new String(com.kwad.sdk.core.a.c.Ee().decode("Y29tLnRlbmNlbnQubWF0cml4Lk1hdHJpeA=="));
            com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "hasMatrix after:" + str);
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            aHL = false;
            aHM = true;
            return aHL;
        }
    }

    public static boolean Iz() {
        if (aHH) {
            return false;
        }
        try {
            if (((Printer) s.getField(Looper.getMainLooper(), "mLogging")) == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e);
            aHH = true;
            return false;
        }
    }

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aHJ = aVar.aIf;
        aHK = aVar.aIg;
    }

    public static boolean bA(boolean z) {
        List<String> list = aHJ;
        if (list != null && !list.isEmpty()) {
            return a(aHJ, true);
        }
        return g("Y29tLnRlbmNlbnQubWF0cml4LnRyYWNlLmNvcmUuTG9vcGVyTW9uaXRvcg==", true);
    }

    public static boolean bB(boolean z) {
        List<String> list = aHK;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return a(aHK, false);
    }

    private static boolean g(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return a(arrayList, z);
    }

    private static boolean a(List<String> list, boolean z) {
        if (aHH) {
            return false;
        }
        try {
            Printer printer = (Printer) s.getField(Looper.getMainLooper(), "mLogging");
            if (printer == null) {
                com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "printer not hook");
            } else {
                aHI = printer.getClass().getName();
                com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "originPrinter name:" + printer.getClass().getName());
                if (z) {
                    f.fK(aHI);
                }
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String str = new String(com.kwad.sdk.core.a.c.Ee().decode(it.next()));
                    com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "printer after:" + str);
                    if (printer.getClass().getName().contains(str)) {
                        com.kwad.sdk.core.e.c.d("perfMonitor.MonitorDetector", "printer monitor");
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("perfMonitor.MonitorDetector", "hasBlockMonitor ", e);
            aHH = true;
        }
        return false;
    }
}
