package com.facebook.internal.instrument.anrreport;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.ActivityManager;
import android.os.Looper;
import android.os.Process;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.anrreport.ANRDetector;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class ANRDetector {
    private static final int DETECTION_INTERVAL_IN_MS = 500;

    @OOXIXo
    public static final ANRDetector INSTANCE = new ANRDetector();
    private static final int myUid = Process.myUid();
    private static final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    @oOoXoXO
    private static String previousStackTrace = "";

    @OOXIXo
    private static final Runnable anrDetectorRunnable = new Runnable() { // from class: I0X0x0oIo.oIX0oI
        @Override // java.lang.Runnable
        public final void run() {
            ANRDetector.m228anrDetectorRunnable$lambda0();
        }
    };

    private ANRDetector() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: anrDetectorRunnable$lambda-0, reason: not valid java name */
    public static final void m228anrDetectorRunnable$lambda0() {
        if (CrashShieldHandler.isObjectCrashing(ANRDetector.class)) {
            return;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Object systemService = FacebookSdk.getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            if (systemService != null) {
                checkProcessError((ActivityManager) systemService);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ANRDetector.class);
        }
    }

    @x0XOIxOo
    @VisibleForTesting
    public static final void checkProcessError(@oOoXoXO ActivityManager activityManager) {
        if (!CrashShieldHandler.isObjectCrashing(ANRDetector.class) && activityManager != null) {
            try {
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2 && processErrorStateInfo.uid == myUid) {
                            Thread thread = Looper.getMainLooper().getThread();
                            IIX0o.oO(thread, "getMainLooper().thread");
                            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
                            String stackTrace = InstrumentUtility.getStackTrace(thread);
                            if (!IIX0o.Oxx0IOOO(stackTrace, previousStackTrace) && InstrumentUtility.isSDKRelatedThread(thread)) {
                                previousStackTrace = stackTrace;
                                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                                InstrumentData.Builder.build(processErrorStateInfo.shortMsg, stackTrace).save();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ANRDetector.class);
            }
        }
    }

    @x0XOIxOo
    @VisibleForTesting
    public static final void start() {
        if (CrashShieldHandler.isObjectCrashing(ANRDetector.class)) {
            return;
        }
        try {
            scheduledExecutorService.scheduleAtFixedRate(anrDetectorRunnable, 0L, 500, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ANRDetector.class);
        }
    }
}
