package com.facebook.appevents;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes8.dex */
public final class AppEventQueue {
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;

    @OXOo.OOXIXo
    public static final AppEventQueue INSTANCE = new AppEventQueue();
    private static final int NO_CONNECTIVITY_ERROR_CODE = -1;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER;

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.OOXIXo
    private static volatile AppEventCollection appEventCollection;

    @OXOo.OOXIXo
    private static final Runnable flushRunnable;

    @OXOo.oOoXoXO
    private static ScheduledFuture<?> scheduledFuture;
    private static final ScheduledExecutorService singleThreadExecutor;

    static {
        String name = AppEventQueue.class.getName();
        IIX0o.oO(name, "AppEventQueue::class.java.name");
        TAG = name;
        NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
        appEventCollection = new AppEventCollection();
        singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
        flushRunnable = new Runnable() { // from class: com.facebook.appevents.X0o0xo
            @Override // java.lang.Runnable
            public final void run() {
                AppEventQueue.m131flushRunnable$lambda0();
            }
        };
    }

    private AppEventQueue() {
    }

    @XO0OX.x0XOIxOo
    public static final void add(@OXOo.OOXIXo final AccessTokenAppIdPair accessTokenAppId, @OXOo.OOXIXo final AppEvent appEvent) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(accessTokenAppId, "accessTokenAppId");
            IIX0o.x0xO0oo(appEvent, "appEvent");
            singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.XO
                @Override // java.lang.Runnable
                public final void run() {
                    AppEventQueue.m128add$lambda3(AccessTokenAppIdPair.this, appEvent);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: add$lambda-3, reason: not valid java name */
    public static final void m128add$lambda3(AccessTokenAppIdPair accessTokenAppId, AppEvent appEvent) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(accessTokenAppId, "$accessTokenAppId");
            IIX0o.x0xO0oo(appEvent, "$appEvent");
            appEventCollection.addEvent(accessTokenAppId, appEvent);
            if (AppEventsLogger.Companion.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY && appEventCollection.getEventCount() > NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER) {
                flushAndWait(FlushReason.EVENT_THRESHOLD);
            } else if (scheduledFuture == null) {
                scheduledFuture = singleThreadExecutor.schedule(flushRunnable, 15L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final GraphRequest buildRequestForSession(@OXOo.OOXIXo final AccessTokenAppIdPair accessTokenAppId, @OXOo.OOXIXo final SessionEventsState appEvents, boolean z, @OXOo.OOXIXo final FlushStatistics flushState) {
        boolean z2 = false;
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(accessTokenAppId, "accessTokenAppId");
            IIX0o.x0xO0oo(appEvents, "appEvents");
            IIX0o.x0xO0oo(flushState, "flushState");
            String applicationId = accessTokenAppId.getApplicationId();
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
            GraphRequest.Companion companion = GraphRequest.Companion;
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format("%s/activities", Arrays.copyOf(new Object[]{applicationId}, 1));
            IIX0o.oO(format, "java.lang.String.format(format, *args)");
            final GraphRequest newPostRequest = companion.newPostRequest(null, format, null, null);
            newPostRequest.setForceApplicationRequest(true);
            Bundle parameters = newPostRequest.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            parameters.putString("access_token", accessTokenAppId.getAccessTokenString());
            String pushNotificationsRegistrationId = InternalAppEventsLogger.Companion.getPushNotificationsRegistrationId();
            if (pushNotificationsRegistrationId != null) {
                parameters.putString("device_token", pushNotificationsRegistrationId);
            }
            String installReferrer = AppEventsLoggerImpl.Companion.getInstallReferrer();
            if (installReferrer != null) {
                parameters.putString(ReferrerDetails.f5172II0xO0, installReferrer);
            }
            newPostRequest.setParameters(parameters);
            if (queryAppSettings != null) {
                z2 = queryAppSettings.supportsImplicitLogging();
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            int populateRequest = appEvents.populateRequest(newPostRequest, FacebookSdk.getApplicationContext(), z2, z);
            if (populateRequest == 0) {
                return null;
            }
            flushState.setNumEvents(flushState.getNumEvents() + populateRequest);
            newPostRequest.setCallback(new GraphRequest.Callback() { // from class: com.facebook.appevents.II0XooXoX
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    AppEventQueue.m129buildRequestForSession$lambda4(AccessTokenAppIdPair.this, newPostRequest, appEvents, flushState, graphResponse);
                }
            });
            return newPostRequest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildRequestForSession$lambda-4, reason: not valid java name */
    public static final void m129buildRequestForSession$lambda4(AccessTokenAppIdPair accessTokenAppId, GraphRequest postRequest, SessionEventsState appEvents, FlushStatistics flushState, GraphResponse response) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(accessTokenAppId, "$accessTokenAppId");
            IIX0o.x0xO0oo(postRequest, "$postRequest");
            IIX0o.x0xO0oo(appEvents, "$appEvents");
            IIX0o.x0xO0oo(flushState, "$flushState");
            IIX0o.x0xO0oo(response, "response");
            handleResponse(accessTokenAppId, postRequest, response, appEvents, flushState);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final List<GraphRequest> buildRequests(@OXOo.OOXIXo AppEventCollection appEventCollection2, @OXOo.OOXIXo FlushStatistics flushResults) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(appEventCollection2, "appEventCollection");
            IIX0o.x0xO0oo(flushResults, "flushResults");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            boolean limitEventAndDataUsage = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
            ArrayList arrayList = new ArrayList();
            for (AccessTokenAppIdPair accessTokenAppIdPair : appEventCollection2.keySet()) {
                SessionEventsState sessionEventsState = appEventCollection2.get(accessTokenAppIdPair);
                if (sessionEventsState != null) {
                    GraphRequest buildRequestForSession = buildRequestForSession(accessTokenAppIdPair, sessionEventsState, limitEventAndDataUsage, flushResults);
                    if (buildRequestForSession != null) {
                        arrayList.add(buildRequestForSession);
                        if (AppEventsCAPIManager.INSTANCE.isEnabled$facebook_core_release()) {
                            AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                            AppEventsConversionsAPITransformerWebRequests.transformGraphRequestAndSendToCAPIGEndPoint(buildRequestForSession);
                        }
                    }
                } else {
                    throw new IllegalStateException("Required value was null.");
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    public static final void flush(@OXOo.OOXIXo final FlushReason reason) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(reason, "reason");
            singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.I0Io
                @Override // java.lang.Runnable
                public final void run() {
                    AppEventQueue.m130flush$lambda2(FlushReason.this);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: flush$lambda-2, reason: not valid java name */
    public static final void m130flush$lambda2(FlushReason reason) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(reason, "$reason");
            flushAndWait(reason);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void flushAndWait(@OXOo.OOXIXo FlushReason reason) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(reason, "reason");
            AppEventDiskStore appEventDiskStore = AppEventDiskStore.INSTANCE;
            appEventCollection.addPersistedEvents(AppEventDiskStore.readAndClearStore());
            try {
                FlushStatistics sendEventsToServer = sendEventsToServer(reason, appEventCollection);
                if (sendEventsToServer != null) {
                    Intent intent = new Intent(AppEventsLogger.ACTION_APP_EVENTS_FLUSHED);
                    intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED, sendEventsToServer.getNumEvents());
                    intent.putExtra(AppEventsLogger.APP_EVENTS_EXTRA_FLUSH_RESULT, sendEventsToServer.getResult());
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast(intent);
                }
            } catch (Exception e) {
                Log.w(TAG, "Caught unexpected exception while flushing app events: ", e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: flushRunnable$lambda-0, reason: not valid java name */
    public static final void m131flushRunnable$lambda0() {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            scheduledFuture = null;
            if (AppEventsLogger.Companion.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                flushAndWait(FlushReason.TIMER);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Set<AccessTokenAppIdPair> getKeySet() {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            return appEventCollection.keySet();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    public static final void handleResponse(@OXOo.OOXIXo final AccessTokenAppIdPair accessTokenAppId, @OXOo.OOXIXo GraphRequest request, @OXOo.OOXIXo GraphResponse response, @OXOo.OOXIXo final SessionEventsState appEvents, @OXOo.OOXIXo FlushStatistics flushState) {
        String str;
        boolean z = true;
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(accessTokenAppId, "accessTokenAppId");
            IIX0o.x0xO0oo(request, "request");
            IIX0o.x0xO0oo(response, "response");
            IIX0o.x0xO0oo(appEvents, "appEvents");
            IIX0o.x0xO0oo(flushState, "flushState");
            FacebookRequestError error = response.getError();
            String str2 = "Success";
            FlushResult flushResult = FlushResult.SUCCESS;
            if (error != null) {
                if (error.getErrorCode() == -1) {
                    str2 = "Failed: No Connectivity";
                    flushResult = FlushResult.NO_CONNECTIVITY;
                } else {
                    oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                    str2 = String.format("Failed:\n  Response: %s\n  Error %s", Arrays.copyOf(new Object[]{response.toString(), error.toString()}, 2));
                    IIX0o.oO(str2, "java.lang.String.format(format, *args)");
                    flushResult = FlushResult.SERVER_ERROR;
                }
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
                try {
                    str = new JSONArray((String) request.getTag()).toString(2);
                    IIX0o.oO(str, "{\n            val jsonArray = JSONArray(eventsJsonString)\n            jsonArray.toString(2)\n          }");
                } catch (JSONException unused) {
                    str = "<Can't encode events for debug logging>";
                }
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", String.valueOf(request.getGraphObject()), str2, str);
            }
            if (error == null) {
                z = false;
            }
            appEvents.clearInFlightAndStats(z);
            FlushResult flushResult2 = FlushResult.NO_CONNECTIVITY;
            if (flushResult == flushResult2) {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.Oxx0IOOO
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppEventQueue.m132handleResponse$lambda5(AccessTokenAppIdPair.this, appEvents);
                    }
                });
            }
            if (flushResult != FlushResult.SUCCESS && flushState.getResult() != flushResult2) {
                flushState.setResult(flushResult);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleResponse$lambda-5, reason: not valid java name */
    public static final void m132handleResponse$lambda5(AccessTokenAppIdPair accessTokenAppId, SessionEventsState appEvents) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(accessTokenAppId, "$accessTokenAppId");
            IIX0o.x0xO0oo(appEvents, "$appEvents");
            AppEventStore appEventStore = AppEventStore.INSTANCE;
            AppEventStore.persistEvents(accessTokenAppId, appEvents);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void persistToDisk() {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            singleThreadExecutor.execute(new Runnable() { // from class: com.facebook.appevents.oxoX
                @Override // java.lang.Runnable
                public final void run() {
                    AppEventQueue.m133persistToDisk$lambda1();
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: persistToDisk$lambda-1, reason: not valid java name */
    public static final void m133persistToDisk$lambda1() {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return;
        }
        try {
            AppEventStore appEventStore = AppEventStore.INSTANCE;
            AppEventStore.persistEvents(appEventCollection);
            appEventCollection = new AppEventCollection();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    @VisibleForTesting(otherwise = 2)
    public static final FlushStatistics sendEventsToServer(@OXOo.OOXIXo FlushReason reason, @OXOo.OOXIXo AppEventCollection appEventCollection2) {
        if (CrashShieldHandler.isObjectCrashing(AppEventQueue.class)) {
            return null;
        }
        try {
            IIX0o.x0xO0oo(reason, "reason");
            IIX0o.x0xO0oo(appEventCollection2, "appEventCollection");
            FlushStatistics flushStatistics = new FlushStatistics();
            List<GraphRequest> buildRequests = buildRequests(appEventCollection2, flushStatistics);
            if (buildRequests.isEmpty()) {
                return null;
            }
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", Integer.valueOf(flushStatistics.getNumEvents()), reason.toString());
            Iterator<GraphRequest> it = buildRequests.iterator();
            while (it.hasNext()) {
                it.next().executeAndWait();
            }
            return flushStatistics;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventQueue.class);
            return null;
        }
    }
}
