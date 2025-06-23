package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class FetchedAppSettingsManager {

    @OXOo.OOXIXo
    private static final String APPLICATION_FIELDS = "fields";

    @OXOo.OOXIXo
    private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";

    @OXOo.OOXIXo
    private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";

    @OXOo.OOXIXo
    private static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";

    @OXOo.OOXIXo
    private static final String APP_SETTING_APP_EVENTS_AAM_RULE = "aam_rules";

    @OXOo.OOXIXo
    private static final String APP_SETTING_APP_EVENTS_EVENT_BINDINGS = "auto_event_mapping_android";

    @OXOo.OOXIXo
    private static final String APP_SETTING_APP_EVENTS_FEATURE_BITMASK = "app_events_feature_bitmask";

    @OXOo.OOXIXo
    private static final String APP_SETTING_APP_EVENTS_SESSION_TIMEOUT = "app_events_session_timeout";

    @OXOo.OOXIXo
    private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";

    @OXOo.OOXIXo
    private static final List<String> APP_SETTING_FIELDS;

    @OXOo.OOXIXo
    private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";

    @OXOo.OOXIXo
    private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";

    @OXOo.OOXIXo
    private static final String APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD = "restrictive_data_filter_params";

    @OXOo.OOXIXo
    private static final String APP_SETTING_SMART_LOGIN_OPTIONS = "seamless_login";

    @OXOo.OOXIXo
    private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    private static final int AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 8;
    private static final int CODELESS_EVENTS_ENABLED_BITMASK_FIELD = 32;
    private static final int IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 16;

    @OXOo.OOXIXo
    public static final FetchedAppSettingsManager INSTANCE = new FetchedAppSettingsManager();
    private static final int MONITOR_ENABLED_BITMASK_FIELD = 16384;

    @OXOo.OOXIXo
    private static final String SDK_UPDATE_MESSAGE = "sdk_update_message";

    @OXOo.OOXIXo
    private static final String SMART_LOGIN_BOOKMARK_ICON_URL = "smart_login_bookmark_icon_url";

    @OXOo.OOXIXo
    private static final String SMART_LOGIN_MENU_ICON_URL = "smart_login_menu_icon_url";

    @OXOo.OOXIXo
    private static final String SUGGESTED_EVENTS_SETTING = "suggested_events_setting";

    @OXOo.OOXIXo
    private static final String TAG;
    private static final int TRACK_UNINSTALL_ENABLED_BITMASK_FIELD = 256;

    @OXOo.OOXIXo
    private static final Map<String, FetchedAppSettings> fetchedAppSettings;

    @OXOo.OOXIXo
    private static final ConcurrentLinkedQueue<FetchedAppSettingsCallback> fetchedAppSettingsCallbacks;
    private static boolean isUnityInit;

    @OXOo.OOXIXo
    private static final AtomicReference<FetchAppSettingState> loadingState;
    private static boolean printedSDKUpdatedMessage;

    @OXOo.oOoXoXO
    private static JSONArray unityEventBindings;

    /* loaded from: classes8.dex */
    public enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static FetchAppSettingState[] valuesCustom() {
            FetchAppSettingState[] valuesCustom = values();
            return (FetchAppSettingState[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* loaded from: classes8.dex */
    public interface FetchedAppSettingsCallback {
        void onError();

        void onSuccess(@OXOo.oOoXoXO FetchedAppSettings fetchedAppSettings);
    }

    static {
        String simpleName = FetchedAppSettingsManager.class.getSimpleName();
        IIX0o.oO(simpleName, "FetchedAppSettingsManager::class.java.simpleName");
        TAG = simpleName;
        APP_SETTING_FIELDS = CollectionsKt__CollectionsKt.X00IoxXI(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, APP_SETTING_NUX_CONTENT, APP_SETTING_NUX_ENABLED, APP_SETTING_DIALOG_CONFIGS, APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES, APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, APP_SETTING_APP_EVENTS_FEATURE_BITMASK, APP_SETTING_APP_EVENTS_EVENT_BINDINGS, APP_SETTING_SMART_LOGIN_OPTIONS, SMART_LOGIN_BOOKMARK_ICON_URL, SMART_LOGIN_MENU_ICON_URL, APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD, APP_SETTING_APP_EVENTS_AAM_RULE, SUGGESTED_EVENTS_SETTING);
        fetchedAppSettings = new ConcurrentHashMap();
        loadingState = new AtomicReference<>(FetchAppSettingState.NOT_LOADED);
        fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue<>();
    }

    private FetchedAppSettingsManager() {
    }

    @XO0OX.x0XOIxOo
    public static final void getAppSettingsAsync(@OXOo.OOXIXo FetchedAppSettingsCallback callback) {
        IIX0o.x0xO0oo(callback, "callback");
        fetchedAppSettingsCallbacks.add(callback);
        loadAppSettingsAsync();
    }

    private final JSONObject getAppSettingsQueryResponse(String str) {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(APP_SETTING_FIELDS);
        bundle.putString("fields", TextUtils.join(",", arrayList));
        GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, "app", null);
        newGraphPathRequest.setForceApplicationRequest(true);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jsonObject = newGraphPathRequest.executeAndWait().getJsonObject();
        if (jsonObject == null) {
            return new JSONObject();
        }
        return jsonObject;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final FetchedAppSettings getAppSettingsWithoutQuery(@OXOo.oOoXoXO String str) {
        if (str != null) {
            return fetchedAppSettings.get(str);
        }
        return null;
    }

    @XO0OX.x0XOIxOo
    public static final void loadAppSettingsAsync() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        final Context applicationContext = FacebookSdk.getApplicationContext();
        final String applicationId = FacebookSdk.getApplicationId();
        Utility utility = Utility.INSTANCE;
        if (Utility.isNullOrEmpty(applicationId)) {
            loadingState.set(FetchAppSettingState.ERROR);
            INSTANCE.pollCallbacks();
            return;
        }
        if (fetchedAppSettings.containsKey(applicationId)) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            INSTANCE.pollCallbacks();
            return;
        }
        AtomicReference<FetchAppSettingState> atomicReference = loadingState;
        FetchAppSettingState fetchAppSettingState = FetchAppSettingState.NOT_LOADED;
        FetchAppSettingState fetchAppSettingState2 = FetchAppSettingState.LOADING;
        if (!androidx.lifecycle.Oxx0IOOO.oIX0oI(atomicReference, fetchAppSettingState, fetchAppSettingState2) && !androidx.lifecycle.Oxx0IOOO.oIX0oI(atomicReference, FetchAppSettingState.ERROR, fetchAppSettingState2)) {
            INSTANCE.pollCallbacks();
            return;
        }
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        final String format = String.format(APP_SETTINGS_PREFS_KEY_FORMAT, Arrays.copyOf(new Object[]{applicationId}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.Oxx0IOOO
            @Override // java.lang.Runnable
            public final void run() {
                FetchedAppSettingsManager.m201loadAppSettingsAsync$lambda0(applicationContext, format, applicationId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadAppSettingsAsync$lambda-0, reason: not valid java name */
    public static final void m201loadAppSettingsAsync$lambda0(Context context, String settingsKey, String applicationId) {
        FetchAppSettingState fetchAppSettingState;
        JSONObject jSONObject;
        IIX0o.x0xO0oo(context, "$context");
        IIX0o.x0xO0oo(settingsKey, "$settingsKey");
        IIX0o.x0xO0oo(applicationId, "$applicationId");
        SharedPreferences sharedPreferences = context.getSharedPreferences(APP_SETTINGS_PREFS_STORE, 0);
        FetchedAppSettings fetchedAppSettings2 = null;
        String string = sharedPreferences.getString(settingsKey, null);
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(string)) {
            if (string != null) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    Utility utility2 = Utility.INSTANCE;
                    Utility.logd(Utility.LOG_TAG, e);
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    fetchedAppSettings2 = INSTANCE.parseAppSettingsFromJSON$facebook_core_release(applicationId, jSONObject);
                }
            } else {
                throw new IllegalStateException("Required value was null.");
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager = INSTANCE;
        JSONObject appSettingsQueryResponse = fetchedAppSettingsManager.getAppSettingsQueryResponse(applicationId);
        if (appSettingsQueryResponse != null) {
            fetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(applicationId, appSettingsQueryResponse);
            sharedPreferences.edit().putString(settingsKey, appSettingsQueryResponse.toString()).apply();
        }
        if (fetchedAppSettings2 != null) {
            String sdkUpdateMessage = fetchedAppSettings2.getSdkUpdateMessage();
            if (!printedSDKUpdatedMessage && sdkUpdateMessage != null && sdkUpdateMessage.length() > 0) {
                printedSDKUpdatedMessage = true;
                Log.w(TAG, sdkUpdateMessage);
            }
        }
        FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
        FetchedAppGateKeepersManager.queryAppGateKeepers(applicationId, true);
        AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
        AutomaticAnalyticsLogger.logActivateAppEvent();
        AtomicReference<FetchAppSettingState> atomicReference = loadingState;
        if (fetchedAppSettings.containsKey(applicationId)) {
            fetchAppSettingState = FetchAppSettingState.SUCCESS;
        } else {
            fetchAppSettingState = FetchAppSettingState.ERROR;
        }
        atomicReference.set(fetchAppSettingState);
        fetchedAppSettingsManager.pollCallbacks();
    }

    private final Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations(JSONObject jSONObject) {
        JSONArray optJSONArray;
        int length;
        HashMap hashMap = new HashMap();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null && (length = optJSONArray.length()) > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                FetchedAppSettings.DialogFeatureConfig.Companion companion = FetchedAppSettings.DialogFeatureConfig.Companion;
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                IIX0o.oO(optJSONObject, "dialogConfigData.optJSONObject(i)");
                FetchedAppSettings.DialogFeatureConfig parseDialogConfig = companion.parseDialogConfig(optJSONObject);
                if (parseDialogConfig != null) {
                    String dialogName = parseDialogConfig.getDialogName();
                    Map map = (Map) hashMap.get(dialogName);
                    if (map == null) {
                        map = new HashMap();
                        hashMap.put(dialogName, map);
                    }
                    map.put(parseDialogConfig.getFeatureName(), parseDialogConfig);
                }
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return hashMap;
    }

    private final synchronized void pollCallbacks() {
        FetchAppSettingState fetchAppSettingState = loadingState.get();
        if (FetchAppSettingState.NOT_LOADED != fetchAppSettingState && FetchAppSettingState.LOADING != fetchAppSettingState) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            final FetchedAppSettings fetchedAppSettings2 = fetchedAppSettings.get(FacebookSdk.getApplicationId());
            Handler handler = new Handler(Looper.getMainLooper());
            if (FetchAppSettingState.ERROR == fetchAppSettingState) {
                while (true) {
                    ConcurrentLinkedQueue<FetchedAppSettingsCallback> concurrentLinkedQueue = fetchedAppSettingsCallbacks;
                    if (!concurrentLinkedQueue.isEmpty()) {
                        final FetchedAppSettingsCallback poll = concurrentLinkedQueue.poll();
                        handler.post(new Runnable() { // from class: com.facebook.internal.II0XooXoX
                            @Override // java.lang.Runnable
                            public final void run() {
                                FetchedAppSettingsManager.FetchedAppSettingsCallback.this.onError();
                            }
                        });
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    ConcurrentLinkedQueue<FetchedAppSettingsCallback> concurrentLinkedQueue2 = fetchedAppSettingsCallbacks;
                    if (!concurrentLinkedQueue2.isEmpty()) {
                        final FetchedAppSettingsCallback poll2 = concurrentLinkedQueue2.poll();
                        handler.post(new Runnable() { // from class: com.facebook.internal.xxIXOIIO
                            @Override // java.lang.Runnable
                            public final void run() {
                                FetchedAppSettingsManager.FetchedAppSettingsCallback.this.onSuccess(fetchedAppSettings2);
                            }
                        });
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final FetchedAppSettings queryAppSettings(@OXOo.OOXIXo String applicationId, boolean z) {
        IIX0o.x0xO0oo(applicationId, "applicationId");
        if (!z) {
            Map<String, FetchedAppSettings> map = fetchedAppSettings;
            if (map.containsKey(applicationId)) {
                return map.get(applicationId);
            }
        }
        FetchedAppSettingsManager fetchedAppSettingsManager = INSTANCE;
        JSONObject appSettingsQueryResponse = fetchedAppSettingsManager.getAppSettingsQueryResponse(applicationId);
        if (appSettingsQueryResponse == null) {
            return null;
        }
        FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release = fetchedAppSettingsManager.parseAppSettingsFromJSON$facebook_core_release(applicationId, appSettingsQueryResponse);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (IIX0o.Oxx0IOOO(applicationId, FacebookSdk.getApplicationId())) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            fetchedAppSettingsManager.pollCallbacks();
        }
        return parseAppSettingsFromJSON$facebook_core_release;
    }

    @XO0OX.x0XOIxOo
    public static final void setIsUnityInit(boolean z) {
        isUnityInit = z;
        if (unityEventBindings != null && z) {
            UnityReflection unityReflection = UnityReflection.INSTANCE;
            UnityReflection.sendEventMapping(String.valueOf(unityEventBindings));
        }
    }

    @OXOo.OOXIXo
    public final FetchedAppSettings parseAppSettingsFromJSON$facebook_core_release(@OXOo.OOXIXo String applicationId, @OXOo.OOXIXo JSONObject settingsJSON) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String jSONArray;
        IIX0o.x0xO0oo(applicationId, "applicationId");
        IIX0o.x0xO0oo(settingsJSON, "settingsJSON");
        JSONArray optJSONArray = settingsJSON.optJSONArray(APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES);
        FacebookRequestErrorClassification.Companion companion = FacebookRequestErrorClassification.Companion;
        FacebookRequestErrorClassification createFromJSON = companion.createFromJSON(optJSONArray);
        if (createFromJSON == null) {
            createFromJSON = companion.getDefaultErrorClassification();
        }
        FacebookRequestErrorClassification facebookRequestErrorClassification = createFromJSON;
        int optInt = settingsJSON.optInt(APP_SETTING_APP_EVENTS_FEATURE_BITMASK, 0);
        if ((optInt & 8) != 0) {
            z = true;
        } else {
            z = false;
        }
        if ((optInt & 16) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((optInt & 32) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((optInt & 256) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((optInt & 16384) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        JSONArray optJSONArray2 = settingsJSON.optJSONArray(APP_SETTING_APP_EVENTS_EVENT_BINDINGS);
        unityEventBindings = optJSONArray2;
        if (optJSONArray2 != null) {
            InternalSettings internalSettings = InternalSettings.INSTANCE;
            if (InternalSettings.isUnityApp()) {
                UnityReflection unityReflection = UnityReflection.INSTANCE;
                if (optJSONArray2 == null) {
                    jSONArray = null;
                } else {
                    jSONArray = optJSONArray2.toString();
                }
                UnityReflection.sendEventMapping(jSONArray);
            }
        }
        boolean optBoolean = settingsJSON.optBoolean(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, false);
        String optString = settingsJSON.optString(APP_SETTING_NUX_CONTENT, "");
        IIX0o.oO(optString, "settingsJSON.optString(APP_SETTING_NUX_CONTENT, \"\")");
        boolean optBoolean2 = settingsJSON.optBoolean(APP_SETTING_NUX_ENABLED, false);
        Constants constants = Constants.INSTANCE;
        int optInt2 = settingsJSON.optInt(APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, Constants.getDefaultAppEventsSessionTimeoutInSeconds());
        EnumSet<SmartLoginOption> parseOptions = SmartLoginOption.Companion.parseOptions(settingsJSON.optLong(APP_SETTING_SMART_LOGIN_OPTIONS));
        Map<String, Map<String, FetchedAppSettings.DialogFeatureConfig>> parseDialogConfigurations = parseDialogConfigurations(settingsJSON.optJSONObject(APP_SETTING_DIALOG_CONFIGS));
        String optString2 = settingsJSON.optString(SMART_LOGIN_BOOKMARK_ICON_URL);
        IIX0o.oO(optString2, "settingsJSON.optString(SMART_LOGIN_BOOKMARK_ICON_URL)");
        String optString3 = settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL);
        IIX0o.oO(optString3, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String optString4 = settingsJSON.optString(SDK_UPDATE_MESSAGE);
        IIX0o.oO(optString4, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        FetchedAppSettings fetchedAppSettings2 = new FetchedAppSettings(optBoolean, optString, optBoolean2, optInt2, parseOptions, parseDialogConfigurations, z, facebookRequestErrorClassification, optString2, optString3, z2, z3, optJSONArray2, optString4, z4, z5, settingsJSON.optString(APP_SETTING_APP_EVENTS_AAM_RULE), settingsJSON.optString(SUGGESTED_EVENTS_SETTING), settingsJSON.optString(APP_SETTING_RESTRICTIVE_EVENT_FILTER_FIELD));
        fetchedAppSettings.put(applicationId, fetchedAppSettings2);
        return fetchedAppSettings2;
    }
}
