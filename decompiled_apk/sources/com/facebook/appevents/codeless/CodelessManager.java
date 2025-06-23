package com.facebook.appevents.codeless;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public final class CodelessManager {

    @oOoXoXO
    private static String deviceSessionID;
    private static volatile boolean isCheckingSession;

    @oOoXoXO
    private static SensorManager sensorManager;

    @oOoXoXO
    private static ViewIndexer viewIndexer;

    @OOXIXo
    public static final CodelessManager INSTANCE = new CodelessManager();

    @OOXIXo
    private static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();

    @OOXIXo
    private static final AtomicBoolean isCodelessEnabled = new AtomicBoolean(true);

    @OOXIXo
    private static final AtomicBoolean isAppIndexingEnabled = new AtomicBoolean(false);

    private CodelessManager() {
    }

    private final void checkCodelessSession(final String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (isCheckingSession) {
                return;
            }
            isCheckingSession = true;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.appevents.codeless.I0Io
                @Override // java.lang.Runnable
                public final void run() {
                    CodelessManager.m151checkCodelessSession$lambda1(str);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkCodelessSession$lambda-1, reason: not valid java name */
    public static final void m151checkCodelessSession$lambda1(String str) {
        String androidAdvertiserId;
        boolean z = true;
        String str2 = "0";
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
            JSONArray jSONArray = new JSONArray();
            String str3 = Build.MODEL;
            if (str3 == null) {
                str3 = "";
            }
            jSONArray.put(str3);
            if (attributionIdentifiers == null) {
                androidAdvertiserId = null;
            } else {
                androidAdvertiserId = attributionIdentifiers.getAndroidAdvertiserId();
            }
            if (androidAdvertiserId != null) {
                jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
            } else {
                jSONArray.put("");
            }
            jSONArray.put("0");
            AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
            if (AppEventUtility.isEmulator()) {
                str2 = "1";
            }
            jSONArray.put(str2);
            Utility utility = Utility.INSTANCE;
            Locale currentLocale = Utility.getCurrentLocale();
            jSONArray.put(currentLocale.getLanguage() + '_' + ((Object) currentLocale.getCountry()));
            String jSONArray2 = jSONArray.toString();
            IIX0o.oO(jSONArray2, "extInfoArray.toString()");
            bundle.putString(Constants.DEVICE_SESSION_ID, getCurrentDeviceSessionID$facebook_core_release());
            bundle.putString(Constants.EXTINFO, jSONArray2);
            GraphRequest.Companion companion = GraphRequest.Companion;
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            String format = String.format(Locale.US, "%s/app_indexing_session", Arrays.copyOf(new Object[]{str}, 1));
            IIX0o.oO(format, "java.lang.String.format(locale, format, *args)");
            JSONObject jSONObject = companion.newPostRequestWithBundle(null, format, bundle, null).executeAndWait().getJSONObject();
            AtomicBoolean atomicBoolean = isAppIndexingEnabled;
            if (jSONObject == null || !jSONObject.optBoolean(Constants.APP_INDEXING_ENABLED, false)) {
                z = false;
            }
            atomicBoolean.set(z);
            if (!atomicBoolean.get()) {
                deviceSessionID = null;
            } else {
                ViewIndexer viewIndexer2 = viewIndexer;
                if (viewIndexer2 != null) {
                    viewIndexer2.schedule();
                }
            }
            isCheckingSession = false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @x0XOIxOo
    public static final void disable() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            isCodelessEnabled.set(false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @x0XOIxOo
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            isCodelessEnabled.set(true);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final String getCurrentDeviceSessionID$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return null;
        }
        try {
            if (deviceSessionID == null) {
                deviceSessionID = UUID.randomUUID().toString();
            }
            String str = deviceSessionID;
            if (str != null) {
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
            return null;
        }
    }

    @x0XOIxOo
    public static final boolean getIsAppIndexingEnabled$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return false;
        }
        try {
            return isAppIndexingEnabled.get();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
            return false;
        }
    }

    private final boolean isDebugOnEmulator() {
        CrashShieldHandler.isObjectCrashing(this);
        return false;
    }

    @x0XOIxOo
    public static final void onActivityDestroyed(@OOXIXo Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(activity, "activity");
            CodelessMatcher.Companion.getInstance().destroy(activity);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @x0XOIxOo
    public static final void onActivityPaused(@OOXIXo Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(activity, "activity");
            if (!isCodelessEnabled.get()) {
                return;
            }
            CodelessMatcher.Companion.getInstance().remove(activity);
            ViewIndexer viewIndexer2 = viewIndexer;
            if (viewIndexer2 != null) {
                viewIndexer2.unschedule();
            }
            SensorManager sensorManager2 = sensorManager;
            if (sensorManager2 != null) {
                sensorManager2.unregisterListener(viewIndexingTrigger);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @x0XOIxOo
    public static final void onActivityResumed(@OOXIXo Activity activity) {
        Boolean valueOf;
        CodelessManager codelessManager;
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(activity, "activity");
            if (!isCodelessEnabled.get()) {
                return;
            }
            CodelessMatcher.Companion.getInstance().add(activity);
            Context applicationContext = activity.getApplicationContext();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            final String applicationId = FacebookSdk.getApplicationId();
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            final FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
            if (appSettingsWithoutQuery == null) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(appSettingsWithoutQuery.getCodelessEventsEnabled());
            }
            if (!IIX0o.Oxx0IOOO(valueOf, Boolean.TRUE)) {
                if (INSTANCE.isDebugOnEmulator()) {
                }
                codelessManager = INSTANCE;
                if (!codelessManager.isDebugOnEmulator() && !isAppIndexingEnabled.get()) {
                    codelessManager.checkCodelessSession(applicationId);
                    return;
                }
            }
            SensorManager sensorManager2 = (SensorManager) applicationContext.getSystemService("sensor");
            if (sensorManager2 == null) {
                return;
            }
            sensorManager = sensorManager2;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(1);
            ViewIndexer viewIndexer2 = new ViewIndexer(activity);
            viewIndexer = viewIndexer2;
            ViewIndexingTrigger viewIndexingTrigger2 = viewIndexingTrigger;
            viewIndexingTrigger2.setOnShakeListener(new ViewIndexingTrigger.OnShakeListener() { // from class: com.facebook.appevents.codeless.II0xO0
                @Override // com.facebook.appevents.codeless.ViewIndexingTrigger.OnShakeListener
                public final void onShake() {
                    CodelessManager.m152onActivityResumed$lambda0(FetchedAppSettings.this, applicationId);
                }
            });
            sensorManager2.registerListener(viewIndexingTrigger2, defaultSensor, 2);
            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                viewIndexer2.schedule();
            }
            codelessManager = INSTANCE;
            if (!codelessManager.isDebugOnEmulator()) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onActivityResumed$lambda-0, reason: not valid java name */
    public static final void m152onActivityResumed$lambda0(FetchedAppSettings fetchedAppSettings, String appId) {
        boolean z;
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(appId, "$appId");
            if (fetchedAppSettings != null && fetchedAppSettings.getCodelessEventsEnabled()) {
                z = true;
            } else {
                z = false;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            boolean codelessSetupEnabled = FacebookSdk.getCodelessSetupEnabled();
            if (z && codelessSetupEnabled) {
                INSTANCE.checkCodelessSession(appId);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }

    @x0XOIxOo
    public static final void updateAppIndexing$facebook_core_release(boolean z) {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        try {
            isAppIndexingEnabled.set(z);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessManager.class);
        }
    }
}
