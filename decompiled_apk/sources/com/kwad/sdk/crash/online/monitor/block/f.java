package com.kwad.sdk.crash.online.monitor.block;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.kwad.sdk.crash.online.monitor.block.report.BlockReportAction;
import com.kwad.sdk.crash.report.h;
import com.kwad.sdk.crash.report.request.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class f {
    public static /* synthetic */ int An() {
        return ID();
    }

    private static boolean Fk() {
        int ID = ID();
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return false;
        }
        long size = com.kwad.sdk.crash.online.monitor.block.report.a.bJ(context).size();
        com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "size:" + size + " limit:" + ID);
        if (size < ID) {
            return false;
        }
        return true;
    }

    private static int ID() {
        com.kwad.sdk.crash.online.monitor.a.a IB = e.IB();
        if (IB != null) {
            return IB.aIk;
        }
        return 20;
    }

    public static /* synthetic */ boolean IE() {
        return Fk();
    }

    public static void a(String str, long j, long j2, String str2, String str3, boolean z) {
        try {
            h(b(str, j, j2, str2, str3), false);
        } catch (Throwable unused) {
        }
    }

    @Nullable
    private static String b(String str, long j, long j2, String str2, String str3) {
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w("perfMonitor.Reporter", Log.getStackTraceString(e));
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = fJ(b.fH(str));
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (j2 == 0) {
            j2 = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        }
        return c(str, j, j2, str2, str3).toJson().toString();
    }

    private static BlockEvent c(String str, long j, long j2, String str2, String str3) {
        BlockEvent blockEvent = new BlockEvent();
        blockEvent.blockDuration = j2;
        blockEvent.currentActivity = str2;
        blockEvent.processName = str3;
        BlockEvent.a aVar = new BlockEvent.a();
        aVar.aHP = str;
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        aVar.aHN = j;
        aVar.repeatCount = (int) (j2 / blockEvent.blockLoopInterval);
        blockEvent.stackTraceSample.add(aVar);
        return blockEvent;
    }

    private static String fJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            boolean startsWith = str.startsWith(" \n");
            com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "oldVersion:" + startsWith);
            if (startsWith) {
                if (str.contains("at ")) {
                    str = str.substring(str.indexOf("at "));
                }
                str = str.replaceAll(":", "\\.") + "\n";
            }
            String replaceAll = str.replaceAll("at ", "").replaceAll(" ", "");
            if (replaceAll.contains("\n")) {
                replaceAll = replaceAll.replaceAll("\n", "\n\tat ");
            }
            return "\n\tat " + (replaceAll + "_").replaceAll("\n\tat _", "\n");
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w("perfMonitor.Reporter", Log.getStackTraceString(e));
            return str;
        }
    }

    public static void fK(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "reportPrinterName:" + str);
        if (e.IC()) {
            d dVar = new d();
            dVar.aHV = str;
            dVar.aHX = a.IA();
            com.kwad.sdk.commercial.b.o(dVar);
        }
    }

    public static void fL(String str) {
        try {
            d dVar = new d();
            dVar.errorMsg = str;
            dVar.aHX = a.IA();
            com.kwad.sdk.commercial.b.o(dVar);
        } catch (Exception unused) {
        }
        com.kwad.sdk.core.e.c.w("perfMonitor.Reporter", str);
    }

    private static void h(final String str, final boolean z) {
        g.execute(new az() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!z && f.An() != 1) {
                    BlockReportAction blockReportAction = new BlockReportAction(str);
                    com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "write to db :" + blockReportAction.toJson().toString());
                    final Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
                    if (context == null) {
                        return;
                    }
                    com.kwad.sdk.crash.online.monitor.block.report.a.bJ(context).j(blockReportAction);
                    if (f.IE()) {
                        final List<com.kwad.sdk.core.report.e> Fs = com.kwad.sdk.crash.online.monitor.block.report.a.bJ(context).Fs();
                        ArrayList arrayList = new ArrayList();
                        Iterator<com.kwad.sdk.core.report.e> it = Fs.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((BlockReportAction) it.next()).msg);
                        }
                        h.a("perf-block", arrayList, new b.a() { // from class: com.kwad.sdk.crash.online.monitor.block.f.1.1
                            @Override // com.kwad.sdk.crash.report.request.b.a
                            public final void onError(int i, String str2) {
                                com.kwad.sdk.core.e.c.w("perfMonitor.Reporter", "errorCode:" + i + " errorMsg:" + str2);
                            }

                            @Override // com.kwad.sdk.crash.report.request.b.a
                            public final void onSuccess() {
                                com.kwad.sdk.crash.online.monitor.block.report.a.bJ(context).x(Fs);
                            }
                        });
                        return;
                    }
                    return;
                }
                com.kwad.sdk.core.e.c.d("perfMonitor.Reporter", "report now :" + str);
                h.ah("perf-block", str);
            }
        });
    }
}
