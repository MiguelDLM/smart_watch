package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.IIX0o;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class UserSettingsManager {

    @OXOo.OOXIXo
    private static final String ADVERTISERID_COLLECTION_FALSE_WARNING = "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.";

    @OXOo.OOXIXo
    private static final String ADVERTISERID_COLLECTION_NOT_SET_WARNING = "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.";

    @OXOo.OOXIXo
    private static final String ADVERTISER_ID_KEY = "advertiser_id";

    @OXOo.OOXIXo
    private static final String APPLICATION_FIELDS = "fields";

    @OXOo.OOXIXo
    private static final String AUTOLOG_APPEVENT_NOT_SET_WARNING = "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.";

    @OXOo.OOXIXo
    private static final String AUTO_APP_LINK_WARNING = "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest";

    @OXOo.OOXIXo
    private static final String EVENTS_CODELESS_SETUP_ENABLED = "auto_event_setup_enabled";

    @OXOo.OOXIXo
    public static final UserSettingsManager INSTANCE = new UserSettingsManager();

    @OXOo.OOXIXo
    private static final String LAST_TIMESTAMP = "last_timestamp";

    @OXOo.OOXIXo
    private static final String TAG;
    private static final long TIMEOUT_7D = 604800000;

    @OXOo.OOXIXo
    private static final String USER_SETTINGS = "com.facebook.sdk.USER_SETTINGS";

    @OXOo.OOXIXo
    private static final String USER_SETTINGS_BITMASK = "com.facebook.sdk.USER_SETTINGS_BITMASK";

    @OXOo.OOXIXo
    private static final String VALUE = "value";

    @OXOo.OOXIXo
    private static final UserSetting advertiserIDCollectionEnabled;

    @OXOo.OOXIXo
    private static final UserSetting autoInitEnabled;

    @OXOo.OOXIXo
    private static final UserSetting autoLogAppEventsEnabled;

    @OXOo.OOXIXo
    private static final UserSetting codelessSetupEnabled;

    @OXOo.OOXIXo
    private static final AtomicBoolean isFetchingCodelessStatus;

    @OXOo.OOXIXo
    private static final AtomicBoolean isInitialized;

    @OXOo.OOXIXo
    private static final UserSetting monitorEnabled;
    private static SharedPreferences userSettingPref;

    /* loaded from: classes8.dex */
    public static final class UserSetting {
        private boolean defaultVal;

        @OXOo.OOXIXo
        private String key;
        private long lastTS;

        @OXOo.oOoXoXO
        private Boolean value;

        public UserSetting(boolean z, @OXOo.OOXIXo String key) {
            IIX0o.x0xO0oo(key, "key");
            this.defaultVal = z;
            this.key = key;
        }

        public final boolean getDefaultVal() {
            return this.defaultVal;
        }

        @OXOo.OOXIXo
        public final String getKey() {
            return this.key;
        }

        public final long getLastTS() {
            return this.lastTS;
        }

        @OXOo.oOoXoXO
        public final Boolean getValue() {
            return this.value;
        }

        public final void setDefaultVal(boolean z) {
            this.defaultVal = z;
        }

        public final void setKey(@OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.key = str;
        }

        public final void setLastTS(long j) {
            this.lastTS = j;
        }

        public final void setValue(@OXOo.oOoXoXO Boolean bool) {
            this.value = bool;
        }

        /* renamed from: getValue, reason: collision with other method in class */
        public final boolean m125getValue() {
            Boolean bool = this.value;
            return bool == null ? this.defaultVal : bool.booleanValue();
        }
    }

    static {
        String name = UserSettingsManager.class.getName();
        IIX0o.oO(name, "UserSettingsManager::class.java.name");
        TAG = name;
        isInitialized = new AtomicBoolean(false);
        isFetchingCodelessStatus = new AtomicBoolean(false);
        autoInitEnabled = new UserSetting(true, FacebookSdk.AUTO_INIT_ENABLED_PROPERTY);
        autoLogAppEventsEnabled = new UserSetting(true, FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY);
        advertiserIDCollectionEnabled = new UserSetting(true, FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY);
        codelessSetupEnabled = new UserSetting(false, EVENTS_CODELESS_SETUP_ENABLED);
        monitorEnabled = new UserSetting(true, FacebookSdk.MONITOR_ENABLED_PROPERTY);
    }

    private UserSettingsManager() {
    }

    @XO0OX.x0XOIxOo
    public static final boolean getAdvertiserIDCollectionEnabled() {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return advertiserIDCollectionEnabled.m125getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
            return false;
        }
    }

    @XO0OX.x0XOIxOo
    public static final boolean getAutoInitEnabled() {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return autoInitEnabled.m125getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
            return false;
        }
    }

    @XO0OX.x0XOIxOo
    public static final boolean getAutoLogAppEventsEnabled() {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return autoLogAppEventsEnabled.m125getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
            return false;
        }
    }

    @XO0OX.x0XOIxOo
    public static final boolean getCodelessSetupEnabled() {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return codelessSetupEnabled.m125getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
            return false;
        }
    }

    @XO0OX.x0XOIxOo
    public static final boolean getMonitorEnabled() {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return false;
        }
        try {
            INSTANCE.initializeIfNotInitialized();
            return monitorEnabled.m125getValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
            return false;
        }
    }

    private final void initializeCodelessSetupEnabledAsync() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            UserSetting userSetting = codelessSetupEnabled;
            readSettingFromCache(userSetting);
            final long currentTimeMillis = System.currentTimeMillis();
            if (userSetting.getValue() != null && currentTimeMillis - userSetting.getLastTS() < 604800000) {
                return;
            }
            userSetting.setValue(null);
            userSetting.setLastTS(0L);
            if (!isFetchingCodelessStatus.compareAndSet(false, true)) {
                return;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.xoXoI
                @Override // java.lang.Runnable
                public final void run() {
                    UserSettingsManager.m124initializeCodelessSetupEnabledAsync$lambda0(currentTimeMillis);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initializeCodelessSetupEnabledAsync$lambda-0, reason: not valid java name */
    public static final void m124initializeCodelessSetupEnabledAsync$lambda0(long j) {
        String str;
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return;
        }
        try {
            if (advertiserIDCollectionEnabled.m125getValue()) {
                FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if (queryAppSettings != null && queryAppSettings.getCodelessEventsEnabled()) {
                    AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                    if (attributionIdentifiers != null && attributionIdentifiers.getAndroidAdvertiserId() != null) {
                        str = attributionIdentifiers.getAndroidAdvertiserId();
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString(ADVERTISER_ID_KEY, str);
                        bundle.putString("fields", EVENTS_CODELESS_SETUP_ENABLED);
                        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, "app", null);
                        newGraphPathRequest.setParameters(bundle);
                        JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
                        if (jSONObject != null) {
                            UserSetting userSetting = codelessSetupEnabled;
                            userSetting.setValue(Boolean.valueOf(jSONObject.optBoolean(EVENTS_CODELESS_SETUP_ENABLED, false)));
                            userSetting.setLastTS(j);
                            INSTANCE.writeSettingToCache(userSetting);
                        }
                    }
                }
            }
            isFetchingCodelessStatus.set(false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
        }
    }

    private final void initializeIfNotInitialized() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!FacebookSdk.isInitialized() || !isInitialized.compareAndSet(false, true)) {
                return;
            }
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(USER_SETTINGS, 0);
            IIX0o.oO(sharedPreferences, "FacebookSdk.getApplicationContext()\n            .getSharedPreferences(USER_SETTINGS, Context.MODE_PRIVATE)");
            userSettingPref = sharedPreferences;
            initializeUserSetting(autoLogAppEventsEnabled, advertiserIDCollectionEnabled, autoInitEnabled);
            initializeCodelessSetupEnabledAsync();
            logWarnings();
            logIfSDKSettingsChanged();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void initializeUserSetting(UserSetting... userSettingArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            int length = userSettingArr.length;
            int i = 0;
            while (i < length) {
                UserSetting userSetting = userSettingArr[i];
                i++;
                if (userSetting == codelessSetupEnabled) {
                    initializeCodelessSetupEnabledAsync();
                } else if (userSetting.getValue() == null) {
                    readSettingFromCache(userSetting);
                    if (userSetting.getValue() == null) {
                        loadSettingFromManifest(userSetting);
                    }
                } else {
                    writeSettingToCache(userSetting);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void loadSettingFromManifest(UserSetting userSetting) {
        Bundle bundle;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            validateInitialized();
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo == null) {
                    bundle = null;
                } else {
                    bundle = applicationInfo.metaData;
                }
                if (bundle != null && applicationInfo.metaData.containsKey(userSetting.getKey())) {
                    userSetting.setValue(Boolean.valueOf(applicationInfo.metaData.getBoolean(userSetting.getKey(), userSetting.getDefaultVal())));
                }
            } catch (PackageManager.NameNotFoundException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void logIfAutoAppLinkEnabled() {
        Bundle bundle;
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationInfo == null) {
                bundle = null;
            } else {
                bundle = applicationInfo.metaData;
            }
            if (bundle != null && applicationInfo.metaData.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                Bundle bundle2 = new Bundle();
                Utility utility = Utility.INSTANCE;
                if (!Utility.isAutoAppLinkSetup()) {
                    bundle2.putString("SchemeWarning", AUTO_APP_LINK_WARNING);
                    Log.w(TAG, AUTO_APP_LINK_WARNING);
                }
                internalAppEventsLogger.logEvent("fb_auto_applink", bundle2);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
        }
    }

    private final void logIfSDKSettingsChanged() {
        int i;
        int i2;
        ApplicationInfo applicationInfo;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (!isInitialized.get()) {
                return;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (!FacebookSdk.isInitialized()) {
                return;
            }
            Context applicationContext = FacebookSdk.getApplicationContext();
            boolean m125getValue = autoInitEnabled.m125getValue();
            int i3 = 0;
            int i4 = (m125getValue ? 1 : 0) | ((autoLogAppEventsEnabled.m125getValue() ? 1 : 0) << 1) | ((advertiserIDCollectionEnabled.m125getValue() ? 1 : 0) << 2) | ((monitorEnabled.m125getValue() ? 1 : 0) << 3);
            SharedPreferences sharedPreferences = userSettingPref;
            Bundle bundle = null;
            if (sharedPreferences != null) {
                int i5 = sharedPreferences.getInt(USER_SETTINGS_BITMASK, 0);
                if (i5 != i4) {
                    SharedPreferences sharedPreferences2 = userSettingPref;
                    if (sharedPreferences2 != null) {
                        sharedPreferences2.edit().putInt(USER_SETTINGS_BITMASK, i4).apply();
                        try {
                            applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                            if (applicationInfo != null) {
                                bundle = applicationInfo.metaData;
                            }
                        } catch (PackageManager.NameNotFoundException unused) {
                            i = 0;
                        }
                        if (bundle != null) {
                            String[] strArr = {FacebookSdk.AUTO_INIT_ENABLED_PROPERTY, FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY, FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY, FacebookSdk.MONITOR_ENABLED_PROPERTY};
                            boolean[] zArr = {true, true, true, true};
                            i = 0;
                            i2 = 0;
                            while (true) {
                                int i6 = i3 + 1;
                                try {
                                    i |= (applicationInfo.metaData.containsKey(strArr[i3]) ? 1 : 0) << i3;
                                    i2 |= (applicationInfo.metaData.getBoolean(strArr[i3], zArr[i3]) ? 1 : 0) << i3;
                                    if (i6 > 3) {
                                        break;
                                    } else {
                                        i3 = i6;
                                    }
                                } catch (PackageManager.NameNotFoundException unused2) {
                                    i3 = i2;
                                    i2 = i3;
                                    i3 = i;
                                    InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(applicationContext);
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putInt("usage", i3);
                                    bundle2.putInt("initial", i2);
                                    bundle2.putInt("previous", i5);
                                    bundle2.putInt("current", i4);
                                    internalAppEventsLogger.logChangedSettingsEvent(bundle2);
                                    return;
                                }
                            }
                            i3 = i;
                            InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
                            Bundle bundle22 = new Bundle();
                            bundle22.putInt("usage", i3);
                            bundle22.putInt("initial", i2);
                            bundle22.putInt("previous", i5);
                            bundle22.putInt("current", i4);
                            internalAppEventsLogger2.logChangedSettingsEvent(bundle22);
                            return;
                        }
                        i2 = 0;
                        InternalAppEventsLogger internalAppEventsLogger22 = new InternalAppEventsLogger(applicationContext);
                        Bundle bundle222 = new Bundle();
                        bundle222.putInt("usage", i3);
                        bundle222.putInt("initial", i2);
                        bundle222.putInt("previous", i5);
                        bundle222.putInt("current", i4);
                        internalAppEventsLogger22.logChangedSettingsEvent(bundle222);
                        return;
                    }
                    IIX0o.XOxIOxOx("userSettingPref");
                    throw null;
                }
                return;
            }
            IIX0o.XOxIOxOx("userSettingPref");
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void logWarnings() {
        Bundle bundle;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationInfo == null) {
                bundle = null;
            } else {
                bundle = applicationInfo.metaData;
            }
            if (bundle != null) {
                if (!applicationInfo.metaData.containsKey(FacebookSdk.AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY)) {
                    Log.w(TAG, AUTOLOG_APPEVENT_NOT_SET_WARNING);
                }
                if (!applicationInfo.metaData.containsKey(FacebookSdk.ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY)) {
                    Log.w(TAG, ADVERTISERID_COLLECTION_NOT_SET_WARNING);
                }
                if (!getAdvertiserIDCollectionEnabled()) {
                    Log.w(TAG, ADVERTISERID_COLLECTION_FALSE_WARNING);
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void readSettingFromCache(UserSetting userSetting) {
        String str = "";
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            validateInitialized();
            try {
                SharedPreferences sharedPreferences = userSettingPref;
                if (sharedPreferences != null) {
                    String string = sharedPreferences.getString(userSetting.getKey(), "");
                    if (string != null) {
                        str = string;
                    }
                    if (str.length() > 0) {
                        JSONObject jSONObject = new JSONObject(str);
                        userSetting.setValue(Boolean.valueOf(jSONObject.getBoolean("value")));
                        userSetting.setLastTS(jSONObject.getLong(LAST_TIMESTAMP));
                        return;
                    }
                    return;
                }
                IIX0o.XOxIOxOx("userSettingPref");
                throw null;
            } catch (JSONException e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setAdvertiserIDCollectionEnabled(boolean z) {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return;
        }
        try {
            UserSetting userSetting = advertiserIDCollectionEnabled;
            userSetting.setValue(Boolean.valueOf(z));
            userSetting.setLastTS(System.currentTimeMillis());
            if (isInitialized.get()) {
                INSTANCE.writeSettingToCache(userSetting);
            } else {
                INSTANCE.initializeIfNotInitialized();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setAutoInitEnabled(boolean z) {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return;
        }
        try {
            UserSetting userSetting = autoInitEnabled;
            userSetting.setValue(Boolean.valueOf(z));
            userSetting.setLastTS(System.currentTimeMillis());
            if (isInitialized.get()) {
                INSTANCE.writeSettingToCache(userSetting);
            } else {
                INSTANCE.initializeIfNotInitialized();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setAutoLogAppEventsEnabled(boolean z) {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return;
        }
        try {
            UserSetting userSetting = autoLogAppEventsEnabled;
            userSetting.setValue(Boolean.valueOf(z));
            userSetting.setLastTS(System.currentTimeMillis());
            if (isInitialized.get()) {
                INSTANCE.writeSettingToCache(userSetting);
            } else {
                INSTANCE.initializeIfNotInitialized();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setMonitorEnabled(boolean z) {
        if (CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            return;
        }
        try {
            UserSetting userSetting = monitorEnabled;
            userSetting.setValue(Boolean.valueOf(z));
            userSetting.setLastTS(System.currentTimeMillis());
            if (isInitialized.get()) {
                INSTANCE.writeSettingToCache(userSetting);
            } else {
                INSTANCE.initializeIfNotInitialized();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, UserSettingsManager.class);
        }
    }

    private final void validateInitialized() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (isInitialized.get()) {
            } else {
                throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void writeSettingToCache(UserSetting userSetting) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            validateInitialized();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("value", userSetting.getValue());
                jSONObject.put(LAST_TIMESTAMP, userSetting.getLastTS());
                SharedPreferences sharedPreferences = userSettingPref;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString(userSetting.getKey(), jSONObject.toString()).apply();
                    logIfSDKSettingsChanged();
                } else {
                    IIX0o.XOxIOxOx("userSettingPref");
                    throw null;
                }
            } catch (Exception e) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
