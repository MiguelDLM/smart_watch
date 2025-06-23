package com.facebook.appevents.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.work.PeriodicWorkRequest;
import com.baidu.mobads.sdk.internal.bn;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.security.CertificateUtil;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes8.dex */
public final class SessionLogger {

    @OOXIXo
    private static final String PACKAGE_CHECKSUM = "PCKGCHKSUM";

    @OOXIXo
    public static final SessionLogger INSTANCE = new SessionLogger();

    @oOoXoXO
    private static final String TAG = SessionLogger.class.getCanonicalName();

    @OOXIXo
    private static final long[] INACTIVE_SECONDS_QUANTA = {300000, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, 1800000, 3600000, 21600000, 43200000, 86400000, bn.e, 259200000, bn.d, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    private SessionLogger() {
    }

    private final String computePackageChecksum(Context context) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String XIxXXX0x02 = IIX0o.XIxXXX0x0("PCKGCHKSUM;", packageManager.getPackageInfo(context.getPackageName(), 0).versionName);
            SharedPreferences sharedPreferences = context.getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0);
            String string = sharedPreferences.getString(XIxXXX0x02, null);
            if (string != null && string.length() == 32) {
                return string;
            }
            HashUtils hashUtils = HashUtils.INSTANCE;
            String computeChecksumWithPackageManager = HashUtils.computeChecksumWithPackageManager(context, null);
            if (computeChecksumWithPackageManager == null) {
                computeChecksumWithPackageManager = HashUtils.computeChecksum(packageManager.getApplicationInfo(context.getPackageName(), 0).sourceDir);
            }
            sharedPreferences.edit().putString(XIxXXX0x02, computeChecksumWithPackageManager).apply();
            return computeChecksumWithPackageManager;
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @x0XOIxOo
    public static final int getQuantaIndex(long j) {
        if (CrashShieldHandler.isObjectCrashing(SessionLogger.class)) {
            return 0;
        }
        int i = 0;
        while (true) {
            try {
                long[] jArr = INACTIVE_SECONDS_QUANTA;
                if (i >= jArr.length || jArr[i] >= j) {
                    break;
                }
                i++;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, SessionLogger.class);
                return 0;
            }
        }
        return i;
    }

    @x0XOIxOo
    public static final void logActivateApp(@OOXIXo String activityName, @oOoXoXO SourceApplicationInfo sourceApplicationInfo, @oOoXoXO String str, @OOXIXo Context context) {
        String sourceApplicationInfo2;
        if (CrashShieldHandler.isObjectCrashing(SessionLogger.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(activityName, "activityName");
            IIX0o.x0xO0oo(context, "context");
            String str2 = "Unclassified";
            if (sourceApplicationInfo != null && (sourceApplicationInfo2 = sourceApplicationInfo.toString()) != null) {
                str2 = sourceApplicationInfo2;
            }
            Bundle bundle = new Bundle();
            bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, str2);
            bundle.putString(AppEventsConstants.EVENT_PARAM_PACKAGE_FP, INSTANCE.computePackageChecksum(context));
            CertificateUtil certificateUtil = CertificateUtil.INSTANCE;
            bundle.putString(AppEventsConstants.EVENT_PARAM_APP_CERT_HASH, CertificateUtil.getCertificateHash(context));
            InternalAppEventsLogger.Companion companion = InternalAppEventsLogger.Companion;
            InternalAppEventsLogger createInstance = companion.createInstance(activityName, str, null);
            createInstance.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, bundle);
            if (companion.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                createInstance.flush();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SessionLogger.class);
        }
    }

    private final void logClockSkewEvent() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            IIX0o.ooOOo0oXI(str);
            companion.log(loggingBehavior, str, "Clock skew detected");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @x0XOIxOo
    public static final void logDeactivateApp(@OOXIXo String activityName, @oOoXoXO SessionInfo sessionInfo, @oOoXoXO String str) {
        long longValue;
        String sourceApplicationInfo;
        long longValue2;
        if (CrashShieldHandler.isObjectCrashing(SessionLogger.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(activityName, "activityName");
            if (sessionInfo == null) {
                return;
            }
            Long diskRestoreTime = sessionInfo.getDiskRestoreTime();
            long j = 0;
            if (diskRestoreTime == null) {
                Long sessionLastEventTime = sessionInfo.getSessionLastEventTime();
                if (sessionLastEventTime == null) {
                    longValue2 = 0;
                } else {
                    longValue2 = sessionLastEventTime.longValue();
                }
                longValue = 0 - longValue2;
            } else {
                longValue = diskRestoreTime.longValue();
            }
            if (longValue < 0) {
                INSTANCE.logClockSkewEvent();
                longValue = 0;
            }
            long sessionLength = sessionInfo.getSessionLength();
            if (sessionLength < 0) {
                INSTANCE.logClockSkewEvent();
                sessionLength = 0;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, sessionInfo.getInterruptionCount());
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format(Locale.ROOT, "session_quanta_%d", Arrays.copyOf(new Object[]{Integer.valueOf(getQuantaIndex(longValue))}, 1));
            IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
            bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, format);
            SourceApplicationInfo sourceApplicationInfo2 = sessionInfo.getSourceApplicationInfo();
            String str2 = "Unclassified";
            if (sourceApplicationInfo2 != null && (sourceApplicationInfo = sourceApplicationInfo2.toString()) != null) {
                str2 = sourceApplicationInfo;
            }
            bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, str2);
            Long sessionLastEventTime2 = sessionInfo.getSessionLastEventTime();
            if (sessionLastEventTime2 != null) {
                j = sessionLastEventTime2.longValue();
            }
            bundle.putLong(Constants.LOG_TIME_APP_EVENT_KEY, j / 1000);
            InternalAppEventsLogger.Companion.createInstance(activityName, str, null).logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, sessionLength / 1000, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SessionLogger.class);
        }
    }
}
