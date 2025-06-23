package com.kwad.sdk.crash.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes11.dex */
public abstract class c implements e {
    private ArrayList<a> aIt = new ArrayList<>();

    /* loaded from: classes11.dex */
    public static class a {
        private ExceptionMessage aIu;
        private int aIv;

        public a(ExceptionMessage exceptionMessage, int i) {
            this.aIu = exceptionMessage;
            this.aIv = i;
        }
    }

    private void IJ() {
        if (!this.aIt.isEmpty()) {
            try {
                Iterator<a> it = this.aIt.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    b(next.aIu, next.aIv, null);
                    it.remove();
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            }
        }
    }

    private void b(ExceptionMessage exceptionMessage, int i, @Nullable CountDownLatch countDownLatch) {
        if (exceptionMessage != null && c(exceptionMessage)) {
            if (i == 3) {
                com.kwad.sdk.crash.report.a.b(exceptionMessage);
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
            com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
        }
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e If = com.kwad.sdk.crash.e.If();
            if (If.Ik() != null && If.Ij() != 2) {
                List<com.kwad.sdk.crash.a> list = If.Ik().aGM;
                double d = If.Ik().aGp;
                String appId = If.getAppId();
                String sdkVersion = If.getSdkVersion();
                for (com.kwad.sdk.crash.a aVar : list) {
                    if (aVar != null) {
                        if (!com.kwad.sdk.crash.utils.c.b(aVar.aGm) && !aVar.aGm.contains(appId)) {
                        }
                        if (com.kwad.sdk.crash.utils.c.b(aVar.aGn) || aVar.aGn.contains(sdkVersion)) {
                            if (com.kwad.sdk.crash.utils.c.b(aVar.aGo) || a(exceptionMessage.mCrashDetail, aVar.aGo)) {
                                d = aVar.aGp;
                            }
                        }
                    }
                }
                if (Math.random() < d) {
                    return true;
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.w("BaseExceptionUploader", Log.getStackTraceString(e));
            return true;
        }
    }

    public final void a(ExceptionMessage exceptionMessage, int i, @Nullable CountDownLatch countDownLatch) {
        try {
            IJ();
            b(exceptionMessage, i, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            this.aIt.add(new a(exceptionMessage, i));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private static boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
