package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.digest.MessageDigestAlgorithms;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class FacebookSdk {

    @OXOo.OOXIXo
    public static final String ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY = "com.facebook.sdk.AdvertiserIDCollectionEnabled";

    @OXOo.OOXIXo
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";

    @OXOo.OOXIXo
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";

    @OXOo.OOXIXo
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";

    @OXOo.OOXIXo
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";

    @OXOo.OOXIXo
    public static final String AUTO_INIT_ENABLED_PROPERTY = "com.facebook.sdk.AutoInitEnabled";

    @OXOo.OOXIXo
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";

    @OXOo.OOXIXo
    public static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";

    @OXOo.OOXIXo
    public static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";

    @OXOo.OOXIXo
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";

    @OXOo.OOXIXo
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";

    @OXOo.OOXIXo
    public static final String CLOUDBRIDGE_SAVED_CREDENTIALS = "com.facebook.sdk.CloudBridgeSavedCredentials";

    @OXOo.OOXIXo
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";

    @OXOo.OOXIXo
    public static final String DATA_PROCESSING_OPTIONS_PREFERENCES = "com.facebook.sdk.DataProcessingOptions";

    @OXOo.OOXIXo
    public static final String DATA_PROCESSION_OPTIONS = "data_processing_options";

    @OXOo.OOXIXo
    public static final String DATA_PROCESSION_OPTIONS_COUNTRY = "data_processing_options_country";

    @OXOo.OOXIXo
    public static final String DATA_PROCESSION_OPTIONS_STATE = "data_processing_options_state";

    @OXOo.OOXIXo
    public static final String FACEBOOK_COM = "facebook.com";

    @OXOo.OOXIXo
    public static final String FB_GG = "fb.gg";

    @OXOo.OOXIXo
    public static final String GAMING = "gaming";

    @OXOo.OOXIXo
    public static final String INSTAGRAM = "instagram";

    @OXOo.OOXIXo
    public static final String INSTAGRAM_COM = "instagram.com";
    private static final int MAX_REQUEST_CODE_RANGE = 100;

    @OXOo.OOXIXo
    public static final String MONITOR_ENABLED_PROPERTY = "com.facebook.sdk.MonitorEnabled";

    @OXOo.OOXIXo
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";

    @OXOo.OOXIXo
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";

    @OXOo.oOoXoXO
    private static volatile String appClientToken;
    private static Context applicationContext;

    @OXOo.oOoXoXO
    private static volatile String applicationId;

    @OXOo.oOoXoXO
    private static volatile String applicationName;

    @XO0OX.XO
    public static boolean bypassAppSwitch;
    private static LockOnGetVariable<File> cacheDir;

    @OXOo.oOoXoXO
    private static volatile Boolean codelessDebugLogEnabled;

    @OXOo.oOoXoXO
    private static Executor executor;

    @OXOo.OOXIXo
    private static volatile String facebookDomain;

    @OXOo.OOXIXo
    private static String graphApiVersion;

    @OXOo.OOXIXo
    private static GraphRequestCreator graphRequestCreator;

    @XO0OX.XO
    public static boolean hasCustomTabsPrefetching;

    @XO0OX.XO
    public static boolean ignoreAppSwitchToLoggedOut;

    @OXOo.OOXIXo
    private static volatile String instagramDomain;
    private static volatile boolean isDebugEnabledField;
    private static boolean isFullyInitialized;
    private static boolean isLegacyTokenUpgradeSupported;

    @OXOo.OOXIXo
    private static final AtomicBoolean sdkInitialized;

    @OXOo.OOXIXo
    public static final FacebookSdk INSTANCE = new FacebookSdk();

    @OXOo.oOoXoXO
    private static final String TAG = FacebookSdk.class.getCanonicalName();

    @OXOo.OOXIXo
    private static final HashSet<LoggingBehavior> loggingBehaviors = Xo0.ooOOo0oXI(LoggingBehavior.DEVELOPER_ERRORS);

    @OXOo.OOXIXo
    private static AtomicLong onProgressThreshold = new AtomicLong(65536);
    private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
    private static int callbackRequestCodeOffset = DEFAULT_CALLBACK_REQUEST_CODE_OFFSET;

    @OXOo.OOXIXo
    private static final ReentrantLock LOCK = new ReentrantLock();

    @VisibleForTesting
    /* loaded from: classes8.dex */
    public interface GraphRequestCreator {
        @OXOo.OOXIXo
        GraphRequest createPostRequest(@OXOo.oOoXoXO AccessToken accessToken, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO JSONObject jSONObject, @OXOo.oOoXoXO GraphRequest.Callback callback);
    }

    /* loaded from: classes8.dex */
    public interface InitializeCallback {
        void onInitialized();
    }

    static {
        ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
        graphApiVersion = ServerProtocol.getDefaultAPIVersion();
        sdkInitialized = new AtomicBoolean(false);
        instagramDomain = INSTAGRAM_COM;
        facebookDomain = FACEBOOK_COM;
        graphRequestCreator = new GraphRequestCreator() { // from class: com.facebook.Oxx0IOOO
            @Override // com.facebook.FacebookSdk.GraphRequestCreator
            public final GraphRequest createPostRequest(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
                GraphRequest m109graphRequestCreator$lambda0;
                m109graphRequestCreator$lambda0 = FacebookSdk.m109graphRequestCreator$lambda0(accessToken, str, jSONObject, callback);
                return m109graphRequestCreator$lambda0;
            }
        };
    }

    private FacebookSdk() {
    }

    @XO0OX.x0XOIxOo
    public static final void addLoggingBehavior(@OXOo.OOXIXo LoggingBehavior behavior) {
        IIX0o.x0xO0oo(behavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.add(behavior);
            INSTANCE.updateGraphDebugBehavior();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    @XO0OX.x0XOIxOo
    public static final void clearLoggingBehaviors() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.clear();
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
    }

    @XO0OX.x0XOIxOo
    public static final void fullyInitialize() {
        isFullyInitialized = true;
    }

    @XO0OX.x0XOIxOo
    public static final boolean getAdvertiserIDCollectionEnabled() {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        return UserSettingsManager.getAdvertiserIDCollectionEnabled();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Context getApplicationContext() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        IIX0o.XOxIOxOx("applicationContext");
        throw null;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getApplicationId() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        String str = applicationId;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String getApplicationName() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        return applicationName;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final String getApplicationSignature(@OXOo.oOoXoXO Context context) {
        PackageManager packageManager;
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return null;
        }
        try {
            Validate validate = Validate.INSTANCE;
            Validate.sdkInitialized();
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null && signatureArr.length != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
                    messageDigest.update(packageInfo.signatures[0].toByteArray());
                    return Base64.encodeToString(messageDigest.digest(), 9);
                }
            } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
            return null;
        }
    }

    @XO0OX.x0XOIxOo
    public static final boolean getAutoInitEnabled() {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        return UserSettingsManager.getAutoInitEnabled();
    }

    @XO0OX.x0XOIxOo
    public static final boolean getAutoLogAppEventsEnabled() {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        return UserSettingsManager.getAutoLogAppEventsEnabled();
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final File getCacheDir() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        LockOnGetVariable<File> lockOnGetVariable = cacheDir;
        if (lockOnGetVariable != null) {
            return lockOnGetVariable.getValue();
        }
        IIX0o.XOxIOxOx("cacheDir");
        throw null;
    }

    @XO0OX.x0XOIxOo
    public static final int getCallbackRequestCodeOffset() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getClientToken() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        String str = appClientToken;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
    }

    @XO0OX.x0XOIxOo
    public static final boolean getCodelessDebugLogEnabled() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        Boolean bool = codelessDebugLogEnabled;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @XO0OX.x0XOIxOo
    public static final boolean getCodelessSetupEnabled() {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        return UserSettingsManager.getCodelessSetupEnabled();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Executor getExecutor() {
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
            reentrantLock.unlock();
            Executor executor2 = executor;
            if (executor2 != null) {
                return executor2;
            }
            throw new IllegalStateException("Required value was null.");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getFacebookDomain() {
        return facebookDomain;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getGraphApiVersion() {
        Utility utility = Utility.INSTANCE;
        String str = TAG;
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("getGraphApiVersion: %s", Arrays.copyOf(new Object[]{graphApiVersion}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        Utility.logd(str, format);
        return graphApiVersion;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getGraphDomain() {
        String str;
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken != null) {
            str = currentAccessToken.getGraphDomain();
        } else {
            str = null;
        }
        Utility utility = Utility.INSTANCE;
        return Utility.getGraphDomainFromTokenDomain(str);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getInstagramDomain() {
        return instagramDomain;
    }

    @XO0OX.x0XOIxOo
    public static final boolean getLimitEventAndDataUsage(@OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        return context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(hashSet));
            IIX0o.oO(unmodifiableSet, "unmodifiableSet(HashSet(loggingBehaviors))");
        }
        return unmodifiableSet;
    }

    @XO0OX.x0XOIxOo
    public static final boolean getMonitorEnabled() {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        return UserSettingsManager.getMonitorEnabled();
    }

    @XO0OX.x0XOIxOo
    public static final long getOnProgressThreshold() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: graphRequestCreator$lambda-0, reason: not valid java name */
    public static final GraphRequest m109graphRequestCreator$lambda0(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
        return GraphRequest.Companion.newPostRequest(accessToken, str, jSONObject, callback);
    }

    @XO0OX.x0XOIxOo
    public static final boolean isDebugEnabled() {
        return isDebugEnabledField;
    }

    @XO0OX.x0XOIxOo
    public static final boolean isFacebookRequestCode(int i) {
        int i2 = callbackRequestCodeOffset;
        if (i >= i2 && i < i2 + 100) {
            return true;
        }
        return false;
    }

    @XO0OX.x0XOIxOo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final synchronized boolean isFullyInitialized() {
        boolean z;
        synchronized (FacebookSdk.class) {
            z = isFullyInitialized;
        }
        return z;
    }

    @XO0OX.x0XOIxOo
    public static final boolean isInitialized() {
        return sdkInitialized.get();
    }

    @XO0OX.x0XOIxOo
    public static final boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    @XO0OX.x0XOIxOo
    public static final boolean isLoggingBehaviorEnabled(@OXOo.OOXIXo LoggingBehavior behavior) {
        boolean z;
        IIX0o.x0xO0oo(behavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            if (isDebugEnabled()) {
                if (hashSet.contains(behavior)) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    @XO0OX.x0XOIxOo
    public static final void loadDefaultsFromMetadata$facebook_core_release(@OXOo.oOoXoXO Context context) {
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return;
            }
            if (applicationId == null) {
                Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                if (obj instanceof String) {
                    String str = (String) obj;
                    Locale ROOT = Locale.ROOT;
                    IIX0o.oO(ROOT, "ROOT");
                    String lowerCase = str.toLowerCase(ROOT);
                    IIX0o.oO(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (OxI.IOOoXo0Ix(lowerCase, "fb", false, 2, null)) {
                        String substring = str.substring(2);
                        IIX0o.oO(substring, "(this as java.lang.String).substring(startIndex)");
                        applicationId = substring;
                    } else {
                        applicationId = str;
                    }
                } else if (obj instanceof Number) {
                    throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                }
            }
            if (applicationName == null) {
                applicationName = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
            }
            if (appClientToken == null) {
                appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
            }
            if (callbackRequestCodeOffset == DEFAULT_CALLBACK_REQUEST_CODE_OFFSET) {
                callbackRequestCodeOffset = applicationInfo.metaData.getInt(CALLBACK_OFFSET_PROPERTY, DEFAULT_CALLBACK_REQUEST_CODE_OFFSET);
            }
            if (codelessDebugLogEnabled == null) {
                codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean(CODELESS_DEBUG_LOG_ENABLED_PROPERTY, false));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private final void publishInstallAndWaitForResponse(Context context, String str) {
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
                String XIxXXX0x02 = IIX0o.XIxXXX0x0(str, "ping");
                long j = sharedPreferences.getLong(XIxXXX0x02, 0L);
                try {
                    AppEventsLoggerUtility appEventsLoggerUtility = AppEventsLoggerUtility.INSTANCE;
                    JSONObject jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.Companion.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context);
                    oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                    String format = String.format(PUBLISH_ACTIVITY_PATH, Arrays.copyOf(new Object[]{str}, 1));
                    IIX0o.oO(format, "java.lang.String.format(format, *args)");
                    GraphRequest createPostRequest = graphRequestCreator.createPostRequest(null, format, jSONObjectForGraphAPICall, null);
                    if (j == 0 && createPostRequest.executeAndWait().getError() == null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putLong(XIxXXX0x02, System.currentTimeMillis());
                        edit.apply();
                    }
                } catch (JSONException e) {
                    throw new FacebookException("An error occurred while publishing install.", e);
                }
            } catch (Exception e2) {
                Utility utility = Utility.INSTANCE;
                Utility.logd("Facebook-publish", e2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.x0XOIxOo
    @VisibleForTesting(otherwise = 3)
    public static final void publishInstallAsync(@OXOo.OOXIXo Context context, @OXOo.OOXIXo final String applicationId2) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(applicationId2, "applicationId");
            final Context applicationContext2 = context.getApplicationContext();
            getExecutor().execute(new Runnable() { // from class: com.facebook.oO
                @Override // java.lang.Runnable
                public final void run() {
                    FacebookSdk.m110publishInstallAsync$lambda15(applicationContext2, applicationId2);
                }
            });
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.OnDeviceEventProcessing)) {
                OnDeviceProcessingManager onDeviceProcessingManager = OnDeviceProcessingManager.INSTANCE;
                if (OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                    OnDeviceProcessingManager.sendInstallEventAsync(applicationId2, ATTRIBUTION_PREFERENCES);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: publishInstallAsync$lambda-15, reason: not valid java name */
    public static final void m110publishInstallAsync$lambda15(Context applicationContext2, String applicationId2) {
        IIX0o.x0xO0oo(applicationId2, "$applicationId");
        FacebookSdk facebookSdk = INSTANCE;
        IIX0o.oO(applicationContext2, "applicationContext");
        facebookSdk.publishInstallAndWaitForResponse(applicationContext2, applicationId2);
    }

    @XO0OX.x0XOIxOo
    public static final void removeLoggingBehavior(@OXOo.OOXIXo LoggingBehavior behavior) {
        IIX0o.x0xO0oo(behavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.remove(behavior);
        }
    }

    @XO0OX.x0XOIxOo
    @kotlin.OOXIXo(message = "")
    public static final synchronized void sdkInitialize(@OXOo.OOXIXo Context applicationContext2, int i) {
        synchronized (FacebookSdk.class) {
            IIX0o.x0xO0oo(applicationContext2, "applicationContext");
            sdkInitialize(applicationContext2, i, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-3, reason: not valid java name */
    public static final File m111sdkInitialize$lambda3() {
        Context context = applicationContext;
        if (context != null) {
            return context.getCacheDir();
        }
        IIX0o.XOxIOxOx("applicationContext");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-4, reason: not valid java name */
    public static final void m112sdkInitialize$lambda4(boolean z) {
        if (z) {
            InstrumentManager instrumentManager = InstrumentManager.INSTANCE;
            InstrumentManager.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-5, reason: not valid java name */
    public static final void m113sdkInitialize$lambda5(boolean z) {
        if (z) {
            AppEventsManager appEventsManager = AppEventsManager.INSTANCE;
            AppEventsManager.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-6, reason: not valid java name */
    public static final void m114sdkInitialize$lambda6(boolean z) {
        if (z) {
            hasCustomTabsPrefetching = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-7, reason: not valid java name */
    public static final void m115sdkInitialize$lambda7(boolean z) {
        if (z) {
            ignoreAppSwitchToLoggedOut = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-8, reason: not valid java name */
    public static final void m116sdkInitialize$lambda8(boolean z) {
        if (z) {
            bypassAppSwitch = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-9, reason: not valid java name */
    public static final Void m117sdkInitialize$lambda9(InitializeCallback initializeCallback) {
        AccessTokenManager.Companion.getInstance().loadCurrentAccessToken();
        ProfileManager.Companion.getInstance().loadCurrentProfile();
        if (AccessToken.Companion.isCurrentAccessTokenActive()) {
            Profile.Companion companion = Profile.Companion;
            if (companion.getCurrentProfile() == null) {
                companion.fetchProfileForCurrentAccessToken();
            }
        }
        if (initializeCallback != null) {
            initializeCallback.onInitialized();
        }
        AppEventsLogger.Companion companion2 = AppEventsLogger.Companion;
        companion2.initializeLib(getApplicationContext(), applicationId);
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        UserSettingsManager.logIfAutoAppLinkEnabled();
        Context applicationContext2 = getApplicationContext().getApplicationContext();
        IIX0o.oO(applicationContext2, "getApplicationContext().applicationContext");
        companion2.newLogger(applicationContext2).flush();
        return null;
    }

    @XO0OX.x0XOIxOo
    public static final void setAdvertiserIDCollectionEnabled(boolean z) {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        UserSettingsManager.setAdvertiserIDCollectionEnabled(z);
    }

    @XO0OX.x0XOIxOo
    public static final void setApplicationId(@OXOo.OOXIXo String applicationId2) {
        IIX0o.x0xO0oo(applicationId2, "applicationId");
        Validate validate = Validate.INSTANCE;
        Validate.notEmpty(applicationId2, "applicationId");
        applicationId = applicationId2;
    }

    @XO0OX.x0XOIxOo
    public static final void setApplicationName(@OXOo.oOoXoXO String str) {
        applicationName = str;
    }

    @XO0OX.x0XOIxOo
    public static final void setAutoInitEnabled(boolean z) {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        UserSettingsManager.setAutoInitEnabled(z);
        if (z) {
            fullyInitialize();
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setAutoLogAppEventsEnabled(boolean z) {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        UserSettingsManager.setAutoLogAppEventsEnabled(z);
        if (z) {
            Application application = (Application) getApplicationContext();
            ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
            ActivityLifecycleTracker.startTracking(application, getApplicationId());
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setCacheDir(@OXOo.OOXIXo File cacheDir2) {
        IIX0o.x0xO0oo(cacheDir2, "cacheDir");
        cacheDir = new LockOnGetVariable<>(cacheDir2);
    }

    @XO0OX.x0XOIxOo
    public static final void setClientToken(@OXOo.oOoXoXO String str) {
        appClientToken = str;
    }

    @XO0OX.x0XOIxOo
    public static final void setCodelessDebugLogEnabled(boolean z) {
        codelessDebugLogEnabled = Boolean.valueOf(z);
    }

    @XO0OX.x0XOIxOo
    public static final void setDataProcessingOptions(@OXOo.oOoXoXO String[] strArr) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        try {
            setDataProcessingOptions(strArr, 0, 0);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setExecutor(@OXOo.OOXIXo Executor executor2) {
        IIX0o.x0xO0oo(executor2, "executor");
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            executor = executor2;
            oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        } finally {
            reentrantLock.unlock();
        }
    }

    @XO0OX.x0XOIxOo
    public static final void setFacebookDomain(@OXOo.OOXIXo String facebookDomain2) {
        IIX0o.x0xO0oo(facebookDomain2, "facebookDomain");
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = facebookDomain2;
    }

    @XO0OX.x0XOIxOo
    public static final void setGraphApiVersion(@OXOo.OOXIXo String graphApiVersion2) {
        IIX0o.x0xO0oo(graphApiVersion2, "graphApiVersion");
        Log.w(TAG, "WARNING: Calling setGraphApiVersion from non-DEBUG code.");
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(graphApiVersion2) && !IIX0o.Oxx0IOOO(graphApiVersion, graphApiVersion2)) {
            graphApiVersion = graphApiVersion2;
        }
    }

    @XO0OX.x0XOIxOo
    @VisibleForTesting
    public static final void setGraphRequestCreator$facebook_core_release(@OXOo.OOXIXo GraphRequestCreator graphRequestCreator2) {
        IIX0o.x0xO0oo(graphRequestCreator2, "graphRequestCreator");
        graphRequestCreator = graphRequestCreator2;
    }

    @XO0OX.x0XOIxOo
    public static final void setIsDebugEnabled(boolean z) {
        isDebugEnabledField = z;
    }

    @XO0OX.x0XOIxOo
    public static final void setLegacyTokenUpgradeSupported(boolean z) {
        isLegacyTokenUpgradeSupported = z;
    }

    @XO0OX.x0XOIxOo
    public static final void setLimitEventAndDataUsage(@OXOo.OOXIXo Context context, boolean z) {
        IIX0o.x0xO0oo(context, "context");
        context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z).apply();
    }

    @XO0OX.x0XOIxOo
    public static final void setMonitorEnabled(boolean z) {
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        UserSettingsManager.setMonitorEnabled(z);
    }

    @XO0OX.x0XOIxOo
    public static final void setOnProgressThreshold(long j) {
        onProgressThreshold.set(j);
    }

    private final void updateGraphDebugBehavior() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        if (hashSet.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
            if (!hashSet.contains(loggingBehavior)) {
                hashSet.add(loggingBehavior);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        com.facebook.FacebookSdk.callbackRequestCodeOffset = r3;
        sdkInitialize(r2, r4);
     */
    @XO0OX.x0XOIxOo
    @kotlin.OOXIXo(message = "")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final synchronized void sdkInitialize(@OXOo.OOXIXo android.content.Context r2, int r3, @OXOo.oOoXoXO com.facebook.FacebookSdk.InitializeCallback r4) {
        /*
            java.lang.Class<com.facebook.FacebookSdk> r0 = com.facebook.FacebookSdk.class
            monitor-enter(r0)
            java.lang.String r1 = "applicationContext"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r1)     // Catch: java.lang.Throwable -> L1d
            java.util.concurrent.atomic.AtomicBoolean r1 = com.facebook.FacebookSdk.sdkInitialized     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.get()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1f
            int r1 = com.facebook.FacebookSdk.callbackRequestCodeOffset     // Catch: java.lang.Throwable -> L1d
            if (r3 != r1) goto L15
            goto L1f
        L15:
            com.facebook.FacebookException r2 = new com.facebook.FacebookException     // Catch: java.lang.Throwable -> L1d
            java.lang.String r3 = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1d
            throw r2     // Catch: java.lang.Throwable -> L1d
        L1d:
            r2 = move-exception
            goto L30
        L1f:
            if (r3 < 0) goto L28
            com.facebook.FacebookSdk.callbackRequestCodeOffset = r3     // Catch: java.lang.Throwable -> L1d
            sdkInitialize(r2, r4)     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r0)
            return
        L28:
            com.facebook.FacebookException r2 = new com.facebook.FacebookException     // Catch: java.lang.Throwable -> L1d
            java.lang.String r3 = "The callback request code offset can't be negative."
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L1d
            throw r2     // Catch: java.lang.Throwable -> L1d
        L30:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.sdkInitialize(android.content.Context, int, com.facebook.FacebookSdk$InitializeCallback):void");
    }

    @XO0OX.x0XOIxOo
    public static final void setDataProcessingOptions(@OXOo.oOoXoXO String[] strArr, int i, int i2) {
        if (CrashShieldHandler.isObjectCrashing(FacebookSdk.class)) {
            return;
        }
        if (strArr == null) {
            try {
                strArr = new String[0];
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, FacebookSdk.class);
                return;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DATA_PROCESSION_OPTIONS, new JSONArray((Collection) ArraysKt___ArraysKt.IoXOX(strArr)));
            jSONObject.put(DATA_PROCESSION_OPTIONS_COUNTRY, i);
            jSONObject.put(DATA_PROCESSION_OPTIONS_STATE, i2);
            Context context = applicationContext;
            if (context != null) {
                context.getSharedPreferences(DATA_PROCESSING_OPTIONS_PREFERENCES, 0).edit().putString(DATA_PROCESSION_OPTIONS, jSONObject.toString()).apply();
            } else {
                IIX0o.XOxIOxOx("applicationContext");
                throw null;
            }
        } catch (JSONException unused) {
        }
    }

    @XO0OX.x0XOIxOo
    @kotlin.OOXIXo(message = "")
    public static final synchronized void sdkInitialize(@OXOo.OOXIXo Context applicationContext2) {
        synchronized (FacebookSdk.class) {
            IIX0o.x0xO0oo(applicationContext2, "applicationContext");
            sdkInitialize(applicationContext2, (InitializeCallback) null);
        }
    }

    @XO0OX.x0XOIxOo
    @kotlin.OOXIXo(message = "")
    public static final synchronized void sdkInitialize(@OXOo.OOXIXo Context applicationContext2, @OXOo.oOoXoXO final InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            IIX0o.x0xO0oo(applicationContext2, "applicationContext");
            AtomicBoolean atomicBoolean = sdkInitialized;
            if (atomicBoolean.get()) {
                if (initializeCallback != null) {
                    initializeCallback.onInitialized();
                }
                return;
            }
            Validate validate = Validate.INSTANCE;
            Validate.hasFacebookActivity(applicationContext2, false);
            Validate.hasInternetPermissions(applicationContext2, false);
            Context applicationContext3 = applicationContext2.getApplicationContext();
            IIX0o.oO(applicationContext3, "applicationContext.applicationContext");
            applicationContext = applicationContext3;
            AppEventsLogger.Companion.getAnonymousAppDeviceGUID(applicationContext2);
            Context context = applicationContext;
            if (context != null) {
                loadDefaultsFromMetadata$facebook_core_release(context);
                String str = applicationId;
                if (str != null && str.length() != 0) {
                    String str2 = appClientToken;
                    if (str2 != null && str2.length() != 0) {
                        atomicBoolean.set(true);
                        if (getAutoInitEnabled()) {
                            fullyInitialize();
                        }
                        Context context2 = applicationContext;
                        if (context2 != null) {
                            if (context2 instanceof Application) {
                                UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
                                if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                                    ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                                    Context context3 = applicationContext;
                                    if (context3 == null) {
                                        IIX0o.XOxIOxOx("applicationContext");
                                        throw null;
                                    }
                                    ActivityLifecycleTracker.startTracking((Application) context3, applicationId);
                                }
                            }
                            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
                            FetchedAppSettingsManager.loadAppSettingsAsync();
                            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
                            NativeProtocol.updateAllAvailableProtocolVersionsAsync();
                            BoltsMeasurementEventListener.Companion companion = BoltsMeasurementEventListener.Companion;
                            Context context4 = applicationContext;
                            if (context4 != null) {
                                companion.getInstance(context4);
                                cacheDir = new LockOnGetVariable<>(new Callable() { // from class: com.facebook.II0XooXoX
                                    @Override // java.util.concurrent.Callable
                                    public final Object call() {
                                        File m111sdkInitialize$lambda3;
                                        m111sdkInitialize$lambda3 = FacebookSdk.m111sdkInitialize$lambda3();
                                        return m111sdkInitialize$lambda3;
                                    }
                                });
                                FeatureManager featureManager = FeatureManager.INSTANCE;
                                FeatureManager.checkFeature(FeatureManager.Feature.Instrument, new FeatureManager.Callback() { // from class: com.facebook.xxIXOIIO
                                    @Override // com.facebook.internal.FeatureManager.Callback
                                    public final void onCompleted(boolean z) {
                                        FacebookSdk.m112sdkInitialize$lambda4(z);
                                    }
                                });
                                FeatureManager.checkFeature(FeatureManager.Feature.AppEvents, new FeatureManager.Callback() { // from class: com.facebook.xoIox
                                    @Override // com.facebook.internal.FeatureManager.Callback
                                    public final void onCompleted(boolean z) {
                                        FacebookSdk.m113sdkInitialize$lambda5(z);
                                    }
                                });
                                FeatureManager.checkFeature(FeatureManager.Feature.ChromeCustomTabsPrefetching, new FeatureManager.Callback() { // from class: com.facebook.OOXIXo
                                    @Override // com.facebook.internal.FeatureManager.Callback
                                    public final void onCompleted(boolean z) {
                                        FacebookSdk.m114sdkInitialize$lambda6(z);
                                    }
                                });
                                FeatureManager.checkFeature(FeatureManager.Feature.IgnoreAppSwitchToLoggedOut, new FeatureManager.Callback() { // from class: com.facebook.oOoXoXO
                                    @Override // com.facebook.internal.FeatureManager.Callback
                                    public final void onCompleted(boolean z) {
                                        FacebookSdk.m115sdkInitialize$lambda7(z);
                                    }
                                });
                                FeatureManager.checkFeature(FeatureManager.Feature.BypassAppSwitch, new FeatureManager.Callback() { // from class: com.facebook.ooOOo0oXI
                                    @Override // com.facebook.internal.FeatureManager.Callback
                                    public final void onCompleted(boolean z) {
                                        FacebookSdk.m116sdkInitialize$lambda8(z);
                                    }
                                });
                                getExecutor().execute(new FutureTask(new Callable() { // from class: com.facebook.x0XOIxOo
                                    @Override // java.util.concurrent.Callable
                                    public final Object call() {
                                        Void m117sdkInitialize$lambda9;
                                        m117sdkInitialize$lambda9 = FacebookSdk.m117sdkInitialize$lambda9(FacebookSdk.InitializeCallback.this);
                                        return m117sdkInitialize$lambda9;
                                    }
                                }));
                                return;
                            }
                            IIX0o.XOxIOxOx("applicationContext");
                            throw null;
                        }
                        IIX0o.XOxIOxOx("applicationContext");
                        throw null;
                    }
                    throw new FacebookException("A valid Facebook app client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk.");
                }
                throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
            }
            IIX0o.XOxIOxOx("applicationContext");
            throw null;
        }
    }
}
