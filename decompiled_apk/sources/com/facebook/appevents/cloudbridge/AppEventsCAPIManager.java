package com.facebook.appevents.cloudbridge;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.oO;
import kotlin.text.OxI;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class AppEventsCAPIManager {

    @OOXIXo
    private static final String SETTINGS_PATH = "/cloudbridge_settings";
    private static boolean isEnabled;

    @OOXIXo
    public static final AppEventsCAPIManager INSTANCE = new AppEventsCAPIManager();

    @oOoXoXO
    private static final String TAG = AppEventsCAPIManager.class.getCanonicalName();

    private AppEventsCAPIManager() {
    }

    @x0XOIxOo
    public static final void enable() {
        try {
            GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.appevents.cloudbridge.oIX0oI
                @Override // com.facebook.GraphRequest.Callback
                public final void onCompleted(GraphResponse graphResponse) {
                    AppEventsCAPIManager.m147enable$lambda0(graphResponse);
                }
            };
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            GraphRequest graphRequest = new GraphRequest(null, IIX0o.XIxXXX0x0(FacebookSdk.getApplicationId(), SETTINGS_PATH), null, HttpMethod.GET, callback, null, 32, null);
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            if (str != null) {
                companion.log(loggingBehavior, str, " \n\nCreating Graph Request: \n=============\n%s\n\n ", graphRequest);
                graphRequest.executeAsync();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (JSONException e) {
            Logger.Companion companion2 = Logger.Companion;
            LoggingBehavior loggingBehavior2 = LoggingBehavior.APP_EVENTS;
            String str2 = TAG;
            if (str2 != null) {
                companion2.log(loggingBehavior2, str2, " \n\nGraph Request Exception: \n=============\n%s\n\n ", oO.xxIXOIIO(e));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: enable$lambda-0, reason: not valid java name */
    public static final void m147enable$lambda0(GraphResponse response) {
        IIX0o.x0xO0oo(response, "response");
        INSTANCE.getCAPIGSettingsFromGraphResponse$facebook_core_release(response);
    }

    @x0XOIxOo
    @oOoXoXO
    public static final Map<String, Object> getSavedCloudBridgeCredentials$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(AppEventsCAPIManager.class)) {
            return null;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.CLOUDBRIDGE_SAVED_CREDENTIALS, 0);
            if (sharedPreferences == null) {
                return null;
            }
            SettingsAPIFields settingsAPIFields = SettingsAPIFields.DATASETID;
            String string = sharedPreferences.getString(settingsAPIFields.getRawValue(), null);
            SettingsAPIFields settingsAPIFields2 = SettingsAPIFields.URL;
            String string2 = sharedPreferences.getString(settingsAPIFields2.getRawValue(), null);
            SettingsAPIFields settingsAPIFields3 = SettingsAPIFields.ACCESSKEY;
            String string3 = sharedPreferences.getString(settingsAPIFields3.getRawValue(), null);
            if (string != null && !OxI.X0O0I0(string) && string2 != null && !OxI.X0O0I0(string2) && string3 != null && !OxI.X0O0I0(string3)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(settingsAPIFields2.getRawValue(), string2);
                linkedHashMap.put(settingsAPIFields.getRawValue(), string);
                linkedHashMap.put(settingsAPIFields3.getRawValue(), string3);
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, String.valueOf(TAG), " \n\nLoading Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", string, string2, string3);
                return linkedHashMap;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventsCAPIManager.class);
            return null;
        }
    }

    public final void getCAPIGSettingsFromGraphResponse$facebook_core_release(@OOXIXo GraphResponse response) {
        Object obj;
        boolean z = false;
        IIX0o.x0xO0oo(response, "response");
        if (response.getError() != null) {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            if (str != null) {
                companion.log(loggingBehavior, str, " \n\nGraph Response Error: \n================\nResponse Error: %s\nResponse Error Exception: %s\n\n ", response.getError().toString(), String.valueOf(response.getError().getException()));
                Map<String, Object> savedCloudBridgeCredentials$facebook_core_release = getSavedCloudBridgeCredentials$facebook_core_release();
                if (savedCloudBridgeCredentials$facebook_core_release != null) {
                    URL url = new URL(String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.URL.getRawValue())));
                    AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                    AppEventsConversionsAPITransformerWebRequests.configure(String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.DATASETID.getRawValue())), url.getProtocol() + "://" + ((Object) url.getHost()), String.valueOf(savedCloudBridgeCredentials$facebook_core_release.get(SettingsAPIFields.ACCESSKEY.getRawValue())));
                    isEnabled = true;
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Logger.Companion companion2 = Logger.Companion;
        LoggingBehavior loggingBehavior2 = LoggingBehavior.APP_EVENTS;
        String str2 = TAG;
        if (str2 != null) {
            companion2.log(loggingBehavior2, str2, " \n\nGraph Response Received: \n================\n%s\n\n ", response);
            JSONObject jSONObject = response.getJSONObject();
            try {
                Utility utility = Utility.INSTANCE;
                if (jSONObject == null) {
                    obj = null;
                } else {
                    obj = jSONObject.get("data");
                }
                if (obj != null) {
                    Map<String, ? extends Object> convertJSONObjectToHashMap = Utility.convertJSONObjectToHashMap(new JSONObject((String) CollectionsKt___CollectionsKt.O0OOX0IIx(Utility.convertJSONArrayToList((JSONArray) obj))));
                    String str3 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.URL.getRawValue());
                    String str4 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.DATASETID.getRawValue());
                    String str5 = (String) convertJSONObjectToHashMap.get(SettingsAPIFields.ACCESSKEY.getRawValue());
                    if (str3 != null && str4 != null && str5 != null) {
                        try {
                            AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests2 = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                            AppEventsConversionsAPITransformerWebRequests.configure(str4, str3, str5);
                            setSavedCloudBridgeCredentials$facebook_core_release(convertJSONObjectToHashMap);
                            SettingsAPIFields settingsAPIFields = SettingsAPIFields.ENABLED;
                            if (convertJSONObjectToHashMap.get(settingsAPIFields.getRawValue()) != null) {
                                Object obj2 = convertJSONObjectToHashMap.get(settingsAPIFields.getRawValue());
                                if (obj2 != null) {
                                    z = ((Boolean) obj2).booleanValue();
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                            }
                            isEnabled = z;
                            return;
                        } catch (MalformedURLException e) {
                            Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "CloudBridge Settings API response doesn't have valid url\n %s ", oO.xxIXOIIO(e));
                            return;
                        }
                    }
                    companion2.log(loggingBehavior2, str2, "CloudBridge Settings API response doesn't have valid data");
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
            } catch (NullPointerException e2) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "CloudBridge Settings API response is not a valid json: \n%s ", oO.xxIXOIIO(e2));
                return;
            } catch (JSONException e3) {
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, TAG, "CloudBridge Settings API response is not a valid json: \n%s ", oO.xxIXOIIO(e3));
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public final boolean isEnabled$facebook_core_release() {
        return isEnabled;
    }

    public final void setEnabled$facebook_core_release(boolean z) {
        isEnabled = z;
    }

    public final void setSavedCloudBridgeCredentials$facebook_core_release(@oOoXoXO Map<String, ? extends Object> map) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.CLOUDBRIDGE_SAVED_CREDENTIALS, 0);
        if (sharedPreferences == null) {
            return;
        }
        if (map == null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.clear();
            edit.apply();
            return;
        }
        SettingsAPIFields settingsAPIFields = SettingsAPIFields.DATASETID;
        Object obj = map.get(settingsAPIFields.getRawValue());
        SettingsAPIFields settingsAPIFields2 = SettingsAPIFields.URL;
        Object obj2 = map.get(settingsAPIFields2.getRawValue());
        SettingsAPIFields settingsAPIFields3 = SettingsAPIFields.ACCESSKEY;
        Object obj3 = map.get(settingsAPIFields3.getRawValue());
        if (obj != null && obj2 != null && obj3 != null) {
            SharedPreferences.Editor edit2 = sharedPreferences.edit();
            edit2.putString(settingsAPIFields.getRawValue(), obj.toString());
            edit2.putString(settingsAPIFields2.getRawValue(), obj2.toString());
            edit2.putString(settingsAPIFields3.getRawValue(), obj3.toString());
            edit2.apply();
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, String.valueOf(TAG), " \n\nSaving Cloudbridge settings from saved Prefs: \n================\n DATASETID: %s\n URL: %s \n ACCESSKEY: %s \n\n ", obj, obj2, obj3);
        }
    }
}
