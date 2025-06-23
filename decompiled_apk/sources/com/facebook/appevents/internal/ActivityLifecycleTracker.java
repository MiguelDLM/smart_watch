package com.facebook.appevents.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public final class ActivityLifecycleTracker {

    @OOXIXo
    private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";

    @OOXIXo
    public static final ActivityLifecycleTracker INSTANCE = new ActivityLifecycleTracker();
    private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000;

    @OOXIXo
    private static final String TAG;
    private static int activityReferences;

    @oOoXoXO
    private static String appId;

    @oOoXoXO
    private static WeakReference<Activity> currActivity;
    private static long currentActivityAppearTime;

    @oOoXoXO
    private static volatile ScheduledFuture<?> currentFuture;

    @OOXIXo
    private static final Object currentFutureLock;

    @oOoXoXO
    private static volatile SessionInfo currentSession;

    @OOXIXo
    private static final AtomicInteger foregroundActivityCount;
    private static final ScheduledExecutorService singleThreadExecutor;

    @OOXIXo
    private static final AtomicBoolean tracking;

    static {
        String canonicalName = ActivityLifecycleTracker.class.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = "com.facebook.appevents.internal.ActivityLifecycleTracker";
        }
        TAG = canonicalName;
        singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
        currentFutureLock = new Object();
        foregroundActivityCount = new AtomicInteger(0);
        tracking = new AtomicBoolean(false);
    }

    private ActivityLifecycleTracker() {
    }

    private final void cancelCurrentTask() {
        ScheduledFuture<?> scheduledFuture;
        synchronized (currentFutureLock) {
            try {
                if (currentFuture != null && (scheduledFuture = currentFuture) != null) {
                    scheduledFuture.cancel(false);
                }
                currentFuture = null;
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = currActivity;
        if (weakReference == null || weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @x0XOIxOo
    @oOoXoXO
    public static final UUID getCurrentSessionGuid() {
        SessionInfo sessionInfo;
        if (currentSession == null || (sessionInfo = currentSession) == null) {
            return null;
        }
        return sessionInfo.getSessionId();
    }

    private final int getSessionTimeoutInSeconds() {
        FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null) {
            Constants constants = Constants.INSTANCE;
            return Constants.getDefaultAppEventsSessionTimeoutInSeconds();
        }
        return appSettingsWithoutQuery.getSessionTimeoutInSeconds();
    }

    @x0XOIxOo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isInBackground() {
        if (activityReferences == 0) {
            return true;
        }
        return false;
    }

    @x0XOIxOo
    public static final boolean isTracking() {
        return tracking.get();
    }

    @x0XOIxOo
    public static final void onActivityCreated(@oOoXoXO Activity activity) {
        singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.internal.oxoX
            @Override // java.lang.Runnable
            public final void run() {
                ActivityLifecycleTracker.m162onActivityCreated$lambda1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityCreated$lambda-1, reason: not valid java name */
    public static final void m162onActivityCreated$lambda1() {
        if (currentSession == null) {
            currentSession = SessionInfo.Companion.getStoredSessionInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityDestroyed(Activity activity) {
        CodelessManager codelessManager = CodelessManager.INSTANCE;
        CodelessManager.onActivityDestroyed(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onActivityPaused(Activity activity) {
        AtomicInteger atomicInteger = foregroundActivityCount;
        if (atomicInteger.decrementAndGet() < 0) {
            atomicInteger.set(0);
            Log.w(TAG, INCORRECT_IMPL_WARNING);
        }
        cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        Utility utility = Utility.INSTANCE;
        final String activityName = Utility.getActivityName(activity);
        CodelessManager codelessManager = CodelessManager.INSTANCE;
        CodelessManager.onActivityPaused(activity);
        singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.internal.II0xO0
            @Override // java.lang.Runnable
            public final void run() {
                ActivityLifecycleTracker.m163onActivityPaused$lambda6(currentTimeMillis, activityName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityPaused$lambda-6, reason: not valid java name */
    public static final void m163onActivityPaused$lambda6(final long j, final String activityName) {
        IIX0o.x0xO0oo(activityName, "$activityName");
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j), null, null, 4, null);
        }
        SessionInfo sessionInfo = currentSession;
        if (sessionInfo != null) {
            sessionInfo.setSessionLastEventTime(Long.valueOf(j));
        }
        if (foregroundActivityCount.get() <= 0) {
            Runnable runnable = new Runnable() { // from class: com.facebook.appevents.internal.I0Io
                @Override // java.lang.Runnable
                public final void run() {
                    ActivityLifecycleTracker.m164onActivityPaused$lambda6$lambda4(j, activityName);
                }
            };
            synchronized (currentFutureLock) {
                currentFuture = singleThreadExecutor.schedule(runnable, INSTANCE.getSessionTimeoutInSeconds(), TimeUnit.SECONDS);
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            }
        }
        long j2 = currentActivityAppearTime;
        long j3 = 0;
        if (j2 > 0) {
            j3 = (j - j2) / 1000;
        }
        AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
        AutomaticAnalyticsLogger.logActivityTimeSpentEvent(activityName, j3);
        SessionInfo sessionInfo2 = currentSession;
        if (sessionInfo2 != null) {
            sessionInfo2.writeSessionToDisk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityPaused$lambda-6$lambda-4, reason: not valid java name */
    public static final void m164onActivityPaused$lambda6$lambda4(long j, String activityName) {
        IIX0o.x0xO0oo(activityName, "$activityName");
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j), null, null, 4, null);
        }
        if (foregroundActivityCount.get() <= 0) {
            SessionLogger sessionLogger = SessionLogger.INSTANCE;
            SessionLogger.logDeactivateApp(activityName, currentSession, appId);
            SessionInfo.Companion.clearSavedSessionFromDisk();
            currentSession = null;
        }
        synchronized (currentFutureLock) {
            currentFuture = null;
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    @x0XOIxOo
    public static final void onActivityResumed(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        currActivity = new WeakReference<>(activity);
        foregroundActivityCount.incrementAndGet();
        INSTANCE.cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        currentActivityAppearTime = currentTimeMillis;
        Utility utility = Utility.INSTANCE;
        final String activityName = Utility.getActivityName(activity);
        CodelessManager codelessManager = CodelessManager.INSTANCE;
        CodelessManager.onActivityResumed(activity);
        MetadataIndexer metadataIndexer = MetadataIndexer.INSTANCE;
        MetadataIndexer.onActivityResumed(activity);
        SuggestedEventsManager suggestedEventsManager = SuggestedEventsManager.INSTANCE;
        SuggestedEventsManager.trackActivity(activity);
        InAppPurchaseManager inAppPurchaseManager = InAppPurchaseManager.INSTANCE;
        InAppPurchaseManager.startTracking();
        final Context applicationContext = activity.getApplicationContext();
        singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.internal.oIX0oI
            @Override // java.lang.Runnable
            public final void run() {
                ActivityLifecycleTracker.m165onActivityResumed$lambda2(currentTimeMillis, activityName, applicationContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityResumed$lambda-2, reason: not valid java name */
    public static final void m165onActivityResumed$lambda2(long j, String activityName, Context appContext) {
        Long sessionLastEventTime;
        SessionInfo sessionInfo;
        IIX0o.x0xO0oo(activityName, "$activityName");
        SessionInfo sessionInfo2 = currentSession;
        if (sessionInfo2 == null) {
            sessionLastEventTime = null;
        } else {
            sessionLastEventTime = sessionInfo2.getSessionLastEventTime();
        }
        if (currentSession == null) {
            currentSession = new SessionInfo(Long.valueOf(j), null, null, 4, null);
            SessionLogger sessionLogger = SessionLogger.INSTANCE;
            String str = appId;
            IIX0o.oO(appContext, "appContext");
            SessionLogger.logActivateApp(activityName, null, str, appContext);
        } else if (sessionLastEventTime != null) {
            long longValue = j - sessionLastEventTime.longValue();
            if (longValue > INSTANCE.getSessionTimeoutInSeconds() * 1000) {
                SessionLogger sessionLogger2 = SessionLogger.INSTANCE;
                SessionLogger.logDeactivateApp(activityName, currentSession, appId);
                String str2 = appId;
                IIX0o.oO(appContext, "appContext");
                SessionLogger.logActivateApp(activityName, null, str2, appContext);
                currentSession = new SessionInfo(Long.valueOf(j), null, null, 4, null);
            } else if (longValue > 1000 && (sessionInfo = currentSession) != null) {
                sessionInfo.incrementInterruptionCount();
            }
        }
        SessionInfo sessionInfo3 = currentSession;
        if (sessionInfo3 != null) {
            sessionInfo3.setSessionLastEventTime(Long.valueOf(j));
        }
        SessionInfo sessionInfo4 = currentSession;
        if (sessionInfo4 != null) {
            sessionInfo4.writeSessionToDisk();
        }
    }

    @x0XOIxOo
    public static final void startTracking(@OOXIXo Application application, @oOoXoXO String str) {
        IIX0o.x0xO0oo(application, "application");
        if (!tracking.compareAndSet(false, true)) {
            return;
        }
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.CodelessEvents, new FeatureManager.Callback() { // from class: com.facebook.appevents.internal.X0o0xo
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z) {
                ActivityLifecycleTracker.m166startTracking$lambda0(z);
            }
        });
        appId = str;
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker$startTracking$2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@OOXIXo Activity activity, @oOoXoXO Bundle bundle) {
                String str2;
                IIX0o.x0xO0oo(activity, "activity");
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                str2 = ActivityLifecycleTracker.TAG;
                companion.log(loggingBehavior, str2, "onActivityCreated");
                AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                AppEventUtility.assertIsMainThread();
                ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                ActivityLifecycleTracker.onActivityCreated(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@OOXIXo Activity activity) {
                String str2;
                IIX0o.x0xO0oo(activity, "activity");
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                str2 = ActivityLifecycleTracker.TAG;
                companion.log(loggingBehavior, str2, "onActivityDestroyed");
                ActivityLifecycleTracker.INSTANCE.onActivityDestroyed(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@OOXIXo Activity activity) {
                String str2;
                IIX0o.x0xO0oo(activity, "activity");
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                str2 = ActivityLifecycleTracker.TAG;
                companion.log(loggingBehavior, str2, "onActivityPaused");
                AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                AppEventUtility.assertIsMainThread();
                ActivityLifecycleTracker.INSTANCE.onActivityPaused(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@OOXIXo Activity activity) {
                String str2;
                IIX0o.x0xO0oo(activity, "activity");
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                str2 = ActivityLifecycleTracker.TAG;
                companion.log(loggingBehavior, str2, "onActivityResumed");
                AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                AppEventUtility.assertIsMainThread();
                ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                ActivityLifecycleTracker.onActivityResumed(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@OOXIXo Activity activity, @OOXIXo Bundle outState) {
                String str2;
                IIX0o.x0xO0oo(activity, "activity");
                IIX0o.x0xO0oo(outState, "outState");
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                str2 = ActivityLifecycleTracker.TAG;
                companion.log(loggingBehavior, str2, "onActivitySaveInstanceState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@OOXIXo Activity activity) {
                int i;
                String str2;
                IIX0o.x0xO0oo(activity, "activity");
                ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                i = ActivityLifecycleTracker.activityReferences;
                ActivityLifecycleTracker.activityReferences = i + 1;
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                str2 = ActivityLifecycleTracker.TAG;
                companion.log(loggingBehavior, str2, "onActivityStarted");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@OOXIXo Activity activity) {
                String str2;
                int i;
                IIX0o.x0xO0oo(activity, "activity");
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
                str2 = ActivityLifecycleTracker.TAG;
                companion.log(loggingBehavior, str2, "onActivityStopped");
                AppEventsLogger.Companion.onContextStop();
                ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                i = ActivityLifecycleTracker.activityReferences;
                ActivityLifecycleTracker.activityReferences = i - 1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startTracking$lambda-0, reason: not valid java name */
    public static final void m166startTracking$lambda0(boolean z) {
        if (z) {
            CodelessManager codelessManager = CodelessManager.INSTANCE;
            CodelessManager.enable();
        } else {
            CodelessManager codelessManager2 = CodelessManager.INSTANCE;
            CodelessManager.disable();
        }
    }
}
