package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class LoginLogger {

    @OXOo.OOXIXo
    public static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";

    @OXOo.OOXIXo
    public static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";

    @OXOo.OOXIXo
    public static final String EVENT_EXTRAS_FAILURE = "failure";

    @OXOo.OOXIXo
    public static final String EVENT_EXTRAS_IS_REAUTHORIZE = "isReauthorize";

    @OXOo.OOXIXo
    public static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";

    @OXOo.OOXIXo
    public static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";

    @OXOo.OOXIXo
    public static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";

    @OXOo.OOXIXo
    public static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";

    @OXOo.OOXIXo
    public static final String EVENT_EXTRAS_PERMISSIONS = "permissions";

    @OXOo.OOXIXo
    public static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";

    @OXOo.OOXIXo
    public static final String EVENT_EXTRAS_TARGET_APP = "target_app";

    @OXOo.OOXIXo
    public static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_FOA_LOGIN_COMPLETE = "foa_mobile_login_complete";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_COMPLETE = "foa_mobile_login_method_complete";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_NOT_TRIED = "foa_mobile_login_method_not_tried";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_START = "foa_mobile_login_method_start";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_FOA_LOGIN_START = "foa_mobile_login_start";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_LOGIN_HEARTBEAT = "fb_mobile_login_heartbeat";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_LOGIN_METHOD_NOT_TRIED = "fb_mobile_login_method_not_tried";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_LOGIN_STATUS_COMPLETE = "fb_mobile_login_status_complete";

    @OXOo.OOXIXo
    public static final String EVENT_NAME_LOGIN_STATUS_START = "fb_mobile_login_status_start";

    @OXOo.OOXIXo
    public static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";

    @OXOo.OOXIXo
    public static final String EVENT_PARAM_CHALLENGE = "7_challenge";

    @OXOo.OOXIXo
    public static final String EVENT_PARAM_ERROR_CODE = "4_error_code";

    @OXOo.OOXIXo
    public static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";

    @OXOo.OOXIXo
    public static final String EVENT_PARAM_EXTRAS = "6_extras";

    @OXOo.OOXIXo
    public static final String EVENT_PARAM_FOA_METHOD_RESULT_SKIPPED = "foa_skipped";

    @OXOo.OOXIXo
    public static final String EVENT_PARAM_LOGIN_RESULT = "2_result";

    @OXOo.OOXIXo
    public static final String EVENT_PARAM_METHOD = "3_method";

    @OXOo.OOXIXo
    public static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";

    @OXOo.OOXIXo
    public static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";

    @OXOo.OOXIXo
    public static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";

    @OXOo.OOXIXo
    private final String applicationId;

    @OXOo.oOoXoXO
    private String facebookVersion;

    @OXOo.OOXIXo
    private final InternalAppEventsLogger logger;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle newAuthorizationLoggingBundle(String str) {
            Bundle bundle = new Bundle();
            bundle.putLong(LoginLogger.EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
            bundle.putString(LoginLogger.EVENT_PARAM_AUTH_LOGGER_ID, str);
            bundle.putString(LoginLogger.EVENT_PARAM_METHOD, "");
            bundle.putString(LoginLogger.EVENT_PARAM_LOGIN_RESULT, "");
            bundle.putString(LoginLogger.EVENT_PARAM_ERROR_MESSAGE, "");
            bundle.putString(LoginLogger.EVENT_PARAM_ERROR_CODE, "");
            bundle.putString(LoginLogger.EVENT_PARAM_EXTRAS, "");
            return bundle;
        }

        private Companion() {
        }
    }

    public LoginLogger(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String applicationId) {
        PackageInfo packageInfo;
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(applicationId, "applicationId");
        this.applicationId = applicationId;
        this.logger = new InternalAppEventsLogger(context, applicationId);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) != null) {
                this.facebookVersion = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static /* synthetic */ void logAuthorizationMethodComplete$default(LoginLogger loginLogger, String str, String str2, String str3, String str4, String str5, Map map, String str6, int i, Object obj) {
        String str7;
        if (CrashShieldHandler.isObjectCrashing(LoginLogger.class)) {
            return;
        }
        if ((i & 64) != 0) {
            str7 = EVENT_NAME_LOGIN_METHOD_COMPLETE;
        } else {
            str7 = str6;
        }
        try {
            loginLogger.logAuthorizationMethodComplete(str, str2, str3, str4, str5, map, str7);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, LoginLogger.class);
        }
    }

    public static /* synthetic */ void logAuthorizationMethodNotTried$default(LoginLogger loginLogger, String str, String str2, String str3, int i, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(LoginLogger.class)) {
            return;
        }
        if ((i & 4) != 0) {
            str3 = EVENT_NAME_LOGIN_METHOD_NOT_TRIED;
        }
        try {
            loginLogger.logAuthorizationMethodNotTried(str, str2, str3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, LoginLogger.class);
        }
    }

    public static /* synthetic */ void logAuthorizationMethodStart$default(LoginLogger loginLogger, String str, String str2, String str3, int i, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(LoginLogger.class)) {
            return;
        }
        if ((i & 4) != 0) {
            str3 = EVENT_NAME_LOGIN_METHOD_START;
        }
        try {
            loginLogger.logAuthorizationMethodStart(str, str2, str3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, LoginLogger.class);
        }
    }

    public static /* synthetic */ void logCompleteLogin$default(LoginLogger loginLogger, String str, Map map, LoginClient.Result.Code code, Map map2, Exception exc, String str2, int i, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(LoginLogger.class)) {
            return;
        }
        if ((i & 32) != 0) {
            str2 = EVENT_NAME_LOGIN_COMPLETE;
        }
        try {
            loginLogger.logCompleteLogin(str, map, code, map2, exc, str2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, LoginLogger.class);
        }
    }

    private final void logHeartbeatEvent(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                final Bundle newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                worker.schedule(new Runnable() { // from class: com.facebook.login.oOoXoXO
                    @Override // java.lang.Runnable
                    public final void run() {
                        LoginLogger.m248logHeartbeatEvent$lambda0(LoginLogger.this, newAuthorizationLoggingBundle);
                    }
                }, 5L, TimeUnit.SECONDS);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: logHeartbeatEvent$lambda-0, reason: not valid java name */
    public static final void m248logHeartbeatEvent$lambda0(LoginLogger this$0, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(LoginLogger.class)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(bundle, "$bundle");
            this$0.logger.logEventImplicitly(EVENT_NAME_LOGIN_HEARTBEAT, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, LoginLogger.class);
        }
    }

    public static /* synthetic */ void logStartLogin$default(LoginLogger loginLogger, LoginClient.Request request, String str, int i, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(LoginLogger.class)) {
            return;
        }
        if ((i & 2) != 0) {
            str = EVENT_NAME_LOGIN_START;
        }
        try {
            loginLogger.logStartLogin(request, str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, LoginLogger.class);
        }
    }

    public static /* synthetic */ void logUnexpectedError$default(LoginLogger loginLogger, String str, String str2, String str3, int i, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(LoginLogger.class)) {
            return;
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        try {
            loginLogger.logUnexpectedError(str, str2, str3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, LoginLogger.class);
        }
    }

    @OXOo.OOXIXo
    public final String getApplicationId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.applicationId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @XO0OX.xoIox
    public final void logAuthorizationMethodComplete(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO Map<String, String> map) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logAuthorizationMethodComplete$default(this, str, str2, str3, str4, str5, map, null, 64, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.xoIox
    public final void logAuthorizationMethodNotTried(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logAuthorizationMethodNotTried$default(this, str, str2, null, 4, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.xoIox
    public final void logAuthorizationMethodStart(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logAuthorizationMethodStart$default(this, str, str2, null, 4, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.xoIox
    public final void logCompleteLogin(@OXOo.oOoXoXO String str, @OXOo.OOXIXo Map<String, String> loggingExtras, @OXOo.oOoXoXO LoginClient.Result.Code code, @OXOo.oOoXoXO Map<String, String> map, @OXOo.oOoXoXO Exception exc) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(loggingExtras, "loggingExtras");
            logCompleteLogin$default(this, str, loggingExtras, code, map, exc, null, 32, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logLoginStatusError(@OXOo.oOoXoXO String str, @OXOo.OOXIXo Exception exception) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(exception, "exception");
            Bundle newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exception.toString());
            this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void logLoginStatusFailure(@OXOo.oOoXoXO String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, EVENT_EXTRAS_FAILURE);
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logLoginStatusStart(@OXOo.oOoXoXO String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_START, Companion.newAuthorizationLoggingBundle(str));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void logLoginStatusSuccess(@OXOo.oOoXoXO String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Bundle newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.SUCCESS.getLoggingValue());
                this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, newAuthorizationLoggingBundle);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @XO0OX.xoIox
    public final void logStartLogin(@OXOo.OOXIXo LoginClient.Request pendingLoginRequest) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(pendingLoginRequest, "pendingLoginRequest");
            logStartLogin$default(this, pendingLoginRequest, null, 2, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.xoIox
    public final void logUnexpectedError(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logUnexpectedError$default(this, str, str2, null, 4, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.xoIox
    public final void logAuthorizationMethodComplete(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO String str5, @OXOo.oOoXoXO Map<String, String> map, @OXOo.oOoXoXO String str6) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
            if (str3 != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, str3);
            }
            if (str4 != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str4);
            }
            if (str5 != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_CODE, str5);
            }
            if (map != null && !map.isEmpty()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey() != null) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, new JSONObject(linkedHashMap).toString());
            }
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
            this.logger.logEventImplicitly(str6, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.xoIox
    public final void logAuthorizationMethodNotTried(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
            this.logger.logEventImplicitly(str3, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.xoIox
    public final void logAuthorizationMethodStart(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
            this.logger.logEventImplicitly(str3, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.xoIox
    public final void logCompleteLogin(@OXOo.oOoXoXO String str, @OXOo.OOXIXo Map<String, String> loggingExtras, @OXOo.oOoXoXO LoginClient.Result.Code code, @OXOo.oOoXoXO Map<String, String> map, @OXOo.oOoXoXO Exception exc, @OXOo.oOoXoXO String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(loggingExtras, "loggingExtras");
            Bundle newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
            if (code != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, code.getLoggingValue());
            }
            if ((exc == null ? null : exc.getMessage()) != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.getMessage());
            }
            JSONObject jSONObject = loggingExtras.isEmpty() ? null : new JSONObject(loggingExtras);
            if (map != null) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                try {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (key != null) {
                            jSONObject.put(key, value);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (jSONObject != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject.toString());
            }
            this.logger.logEventImplicitly(str2, newAuthorizationLoggingBundle);
            if (code == LoginClient.Result.Code.SUCCESS) {
                logHeartbeatEvent(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.xoIox
    public final void logStartLogin(@OXOo.OOXIXo LoginClient.Request pendingLoginRequest, @OXOo.oOoXoXO String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(pendingLoginRequest, "pendingLoginRequest");
            Bundle newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(pendingLoginRequest.getAuthId());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("login_behavior", pendingLoginRequest.getLoginBehavior().toString());
                jSONObject.put(EVENT_EXTRAS_REQUEST_CODE, LoginClient.Companion.getLoginRequestCode());
                jSONObject.put("permissions", TextUtils.join(",", pendingLoginRequest.getPermissions()));
                jSONObject.put("default_audience", pendingLoginRequest.getDefaultAudience().toString());
                jSONObject.put(EVENT_EXTRAS_IS_REAUTHORIZE, pendingLoginRequest.isRerequest());
                String str2 = this.facebookVersion;
                if (str2 != null) {
                    jSONObject.put(EVENT_EXTRAS_FACEBOOK_VERSION, str2);
                }
                if (pendingLoginRequest.getLoginTargetApp() != null) {
                    jSONObject.put(EVENT_EXTRAS_TARGET_APP, pendingLoginRequest.getLoginTargetApp().toString());
                }
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject.toString());
            } catch (JSONException unused) {
            }
            this.logger.logEventImplicitly(str, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @XO0OX.xoIox
    public final void logUnexpectedError(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle("");
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str2);
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str3);
            this.logger.logEventImplicitly(str, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
