package com.kwad.sdk.crash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.g;
import com.kwad.sdk.crash.handler.AnrHandler;
import com.kwad.sdk.crash.handler.NativeCrashHandler;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes11.dex */
public final class b {
    private static volatile boolean aGq = false;
    private static volatile boolean aGr = false;
    private static Handler Xl = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean ISLOADED = new AtomicBoolean(false);
    private static final String[] aGs = {"c++_shared", "kscutils", "exception-handler"};
    private static boolean aGt = false;
    private static boolean aGu = false;

    public static boolean HO() {
        if (ISLOADED.get()) {
            return true;
        }
        try {
            for (String str : aGs) {
                System.loadLibrary(str);
            }
            ISLOADED.set(true);
            return true;
        } catch (Throwable unused) {
            ISLOADED.set(false);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void HP() {
        AnrHandler.getInstance().init(com.kwad.sdk.crash.a.a.Ir(), new f() { // from class: com.kwad.sdk.crash.b.5
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                e.If().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.6
            @Override // com.kwad.sdk.crash.report.e
            public final File Ia() {
                return new File(com.kwad.sdk.crash.a.a.Ip(), "anr_log/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                com.kwad.sdk.core.e.c.d("AdExceptionCollector", "ANR upload");
                a(exceptionMessage, 3, countDownLatch);
            }
        });
    }

    private static synchronized void HQ() {
        synchronized (b.class) {
            if (!aGq) {
                aGq = true;
                com.kwad.sdk.core.threads.a.Gi().postDelayed(new Runnable() { // from class: com.kwad.sdk.crash.b.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            b.HR();
                        } catch (Throwable unused) {
                        }
                    }
                }, TimeUnit.SECONDS.toMillis(d.aGW));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void HR() {
        HS();
        if (aGt) {
            HT();
        }
        if (aGu) {
            HU();
        }
    }

    private static void HS() {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "reportJavaException");
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(com.kwad.sdk.crash.handler.c.Iv().getUploader());
        fVar.C(com.kwad.sdk.crash.a.a.Iq());
    }

    private static void HT() {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "reportAnrException");
        com.kwad.sdk.crash.report.b bVar = new com.kwad.sdk.crash.report.b();
        bVar.a(AnrHandler.getInstance().getUploader());
        bVar.C(com.kwad.sdk.crash.a.a.Ir());
    }

    private static void HU() {
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "reportNativeException");
        com.kwad.sdk.crash.report.g gVar = new com.kwad.sdk.crash.report.g();
        gVar.a(NativeCrashHandler.getInstance().getUploader());
        gVar.C(com.kwad.sdk.crash.a.a.Is());
    }

    public static void a(@NonNull c cVar) {
        if (cVar.context == null || aGr) {
            return;
        }
        aGr = true;
        aGt = cVar.aGt;
        aGu = cVar.aGu;
        try {
            com.kwad.sdk.crash.utils.e.init(cVar.context);
            com.kwad.sdk.crash.a.a.init(cVar.context, cVar.aGH);
            e.If().a(cVar);
            bH(cVar.context);
            if (!bG(cVar.context) && (aGt || aGu)) {
                g.a(cVar, new g.a() { // from class: com.kwad.sdk.crash.b.1
                    @Override // com.kwad.sdk.crash.g.a
                    public final void HY() {
                        b.Xl.post(new Runnable() { // from class: com.kwad.sdk.crash.b.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.kwad.sdk.core.e.c.w("AdExceptionCollector", "ExceptionSoLoadHelper.init onLoad");
                                if (b.aGt) {
                                    b.HP();
                                }
                                if (b.aGu) {
                                    b.c(false, "/sdcard/");
                                }
                            }
                        });
                    }

                    @Override // com.kwad.sdk.crash.g.a
                    public final void HZ() {
                        com.kwad.sdk.core.e.c.w("AdExceptionCollector", "ExceptionSoLoadHelper.init fail");
                    }
                });
            }
            HQ();
        } catch (Throwable unused) {
        }
    }

    private static boolean bG(Context context) {
        if (context == null || y.cn(context) >= 3) {
            return true;
        }
        return false;
    }

    private static void bH(Context context) {
        com.kwad.sdk.crash.handler.c.Iv().init(com.kwad.sdk.crash.a.a.Iq(), new f() { // from class: com.kwad.sdk.crash.b.3
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                e.If().b(i, exceptionMessage);
            }
        }, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.4
            @Override // com.kwad.sdk.crash.report.e
            public final File Ia() {
                return new File(com.kwad.sdk.crash.a.a.Ip(), "java_crash/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                a(exceptionMessage, 1, countDownLatch);
            }
        });
        Thread.setDefaultUncaughtExceptionHandler(new com.kwad.sdk.crash.handler.d(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(boolean z, String str) {
        if (!com.kwad.sdk.crash.a.a.A(com.kwad.sdk.crash.a.a.Is())) {
            return;
        }
        NativeCrashHandler.getInstance().init(com.kwad.sdk.crash.a.a.Is(), z, str, new com.kwad.sdk.crash.report.c() { // from class: com.kwad.sdk.crash.b.7
            @Override // com.kwad.sdk.crash.report.e
            public final File Ia() {
                return new File(com.kwad.sdk.crash.a.a.Ip(), "native_crash_log/upload");
            }

            @Override // com.kwad.sdk.crash.report.e
            public final void a(ExceptionMessage exceptionMessage, @Nullable CountDownLatch countDownLatch) {
                try {
                    com.kwad.sdk.core.e.c.d("AdExceptionCollector", "Native upload");
                    if (exceptionMessage == null) {
                        com.kwad.sdk.core.e.c.w("AdExceptionCollector", "Native upload but msg is null");
                        return;
                    }
                    if (com.kwad.sdk.crash.b.a.fB(exceptionMessage.mThreadName) || com.kwad.sdk.crash.b.a.fC(exceptionMessage.mCrashDetail)) {
                        a(exceptionMessage, 4, countDownLatch);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void n(@NonNull final Throwable th) {
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.sdk.crash.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (com.kwad.sdk.crash.b.a.o(th)) {
                        com.kwad.sdk.crash.handler.a.p(th);
                    }
                } catch (Throwable th2) {
                    com.kwad.sdk.core.e.c.printStackTrace(th2);
                }
            }
        });
    }
}
