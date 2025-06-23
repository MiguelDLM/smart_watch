package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting(otherwise = 3)
/* loaded from: classes8.dex */
public abstract class LoginMethodHandler implements Parcelable {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    public static final String NO_SIGNED_REQUEST_ERROR_MESSAGE = "Authorization response does not contain the signed_request";

    @OXOo.OOXIXo
    public static final String NO_USER_ID_ERROR_MESSAGE = "Failed to retrieve user_id from signed_request";

    @OXOo.OOXIXo
    public static final String USER_CANCELED_LOG_IN_ERROR_MESSAGE = "User canceled log in.";
    public LoginClient loginClient;

    @OXOo.oOoXoXO
    private Map<String, String> methodLoggingExtras;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final AccessToken createAccessTokenFromNativeLogin(@OXOo.OOXIXo Bundle bundle, @OXOo.oOoXoXO AccessTokenSource accessTokenSource, @OXOo.OOXIXo String applicationId) {
            String string;
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(applicationId, "applicationId");
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0L));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string2 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0L));
            if (string2 == null || string2.length() == 0 || (string = bundle.getString(NativeProtocol.EXTRA_USER_ID)) == null || string.length() == 0) {
                return null;
            }
            return new AccessToken(string2, applicationId, string, stringArrayList, null, null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString("graph_domain"));
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final AccessToken createAccessTokenFromWebBundle(@OXOo.oOoXoXO Collection<String> collection, @OXOo.OOXIXo Bundle bundle, @OXOo.oOoXoXO AccessTokenSource accessTokenSource, @OXOo.OOXIXo String applicationId) throws FacebookException {
            Collection<String> collection2;
            ArrayList arrayList;
            ArrayList arrayList2;
            IIX0o.x0xO0oo(bundle, "bundle");
            IIX0o.x0xO0oo(applicationId, "applicationId");
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, "expires_in", new Date());
            String string = bundle.getString("access_token");
            if (string == null) {
                return null;
            }
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0L));
            String string2 = bundle.getString("granted_scopes");
            if (string2 != null && string2.length() > 0) {
                Object[] array = StringsKt__StringsKt.XXoO0oX(string2, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    collection2 = CollectionsKt__CollectionsKt.Oxx0xo(Arrays.copyOf(strArr, strArr.length));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                collection2 = collection;
            }
            String string3 = bundle.getString("denied_scopes");
            if (string3 != null && string3.length() > 0) {
                Object[] array2 = StringsKt__StringsKt.XXoO0oX(string3, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
                if (array2 != null) {
                    String[] strArr2 = (String[]) array2;
                    arrayList = CollectionsKt__CollectionsKt.Oxx0xo(Arrays.copyOf(strArr2, strArr2.length));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                arrayList = null;
            }
            String string4 = bundle.getString("expired_scopes");
            if (string4 != null && string4.length() > 0) {
                Object[] array3 = StringsKt__StringsKt.XXoO0oX(string4, new String[]{","}, false, 0, 6, null).toArray(new String[0]);
                if (array3 != null) {
                    String[] strArr3 = (String[]) array3;
                    arrayList2 = CollectionsKt__CollectionsKt.Oxx0xo(Arrays.copyOf(strArr3, strArr3.length));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            } else {
                arrayList2 = null;
            }
            if (Utility.isNullOrEmpty(string)) {
                return null;
            }
            return new AccessToken(string, applicationId, getUserIDFromSignedRequest(bundle.getString("signed_request")), collection2, arrayList, arrayList2, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2, bundle.getString("graph_domain"));
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final AuthenticationToken createAuthenticationTokenFromNativeLogin(@OXOo.OOXIXo Bundle bundle, @OXOo.oOoXoXO String str) throws FacebookException {
            IIX0o.x0xO0oo(bundle, "bundle");
            String string = bundle.getString(NativeProtocol.EXTRA_AUTHENTICATION_TOKEN);
            if (string != null && string.length() != 0 && str != null && str.length() != 0) {
                try {
                    return new AuthenticationToken(string, str);
                } catch (Exception e) {
                    throw new FacebookException(e.getMessage());
                }
            }
            return null;
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        public final AuthenticationToken createAuthenticationTokenFromWebBundle(@OXOo.OOXIXo Bundle bundle, @OXOo.oOoXoXO String str) throws FacebookException {
            IIX0o.x0xO0oo(bundle, "bundle");
            String string = bundle.getString("id_token");
            if (string != null && string.length() != 0 && str != null && str.length() != 0) {
                try {
                    return new AuthenticationToken(string, str);
                } catch (Exception e) {
                    throw new FacebookException(e.getMessage(), e);
                }
            }
            return null;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public final String getUserIDFromSignedRequest(@OXOo.oOoXoXO String str) throws FacebookException {
            Object[] array;
            if (str != null && str.length() != 0) {
                try {
                    array = StringsKt__StringsKt.XXoO0oX(str, new String[]{FileUtils.FILE_EXTENSION_SEPARATOR}, false, 0, 6, null).toArray(new String[0]);
                } catch (UnsupportedEncodingException | JSONException unused) {
                }
                if (array != null) {
                    String[] strArr = (String[]) array;
                    if (strArr.length == 2) {
                        byte[] data = Base64.decode(strArr[1], 0);
                        IIX0o.oO(data, "data");
                        String string = new JSONObject(new String(data, kotlin.text.oxoX.f29581II0xO0)).getString("user_id");
                        IIX0o.oO(string, "jsonObject.getString(\"user_id\")");
                        return string;
                    }
                    throw new FacebookException(LoginMethodHandler.NO_USER_ID_ERROR_MESSAGE);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            throw new FacebookException(LoginMethodHandler.NO_SIGNED_REQUEST_ERROR_MESSAGE);
        }

        private Companion() {
        }
    }

    public LoginMethodHandler(@OXOo.OOXIXo LoginClient loginClient) {
        IIX0o.x0xO0oo(loginClient, "loginClient");
        setLoginClient(loginClient);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final AccessToken createAccessTokenFromNativeLogin(@OXOo.OOXIXo Bundle bundle, @OXOo.oOoXoXO AccessTokenSource accessTokenSource, @OXOo.OOXIXo String str) {
        return Companion.createAccessTokenFromNativeLogin(bundle, accessTokenSource, str);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final AccessToken createAccessTokenFromWebBundle(@OXOo.oOoXoXO Collection<String> collection, @OXOo.OOXIXo Bundle bundle, @OXOo.oOoXoXO AccessTokenSource accessTokenSource, @OXOo.OOXIXo String str) throws FacebookException {
        return Companion.createAccessTokenFromWebBundle(collection, bundle, accessTokenSource, str);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final AuthenticationToken createAuthenticationTokenFromNativeLogin(@OXOo.OOXIXo Bundle bundle, @OXOo.oOoXoXO String str) throws FacebookException {
        return Companion.createAuthenticationTokenFromNativeLogin(bundle, str);
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final AuthenticationToken createAuthenticationTokenFromWebBundle(@OXOo.OOXIXo Bundle bundle, @OXOo.oOoXoXO String str) throws FacebookException {
        return Companion.createAuthenticationTokenFromWebBundle(bundle, str);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getUserIDFromSignedRequest(@OXOo.oOoXoXO String str) throws FacebookException {
        return Companion.getUserIDFromSignedRequest(str);
    }

    public void addLoggingExtra(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO Object obj) {
        String obj2;
        if (this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        Map<String, String> map = this.methodLoggingExtras;
        if (map != null) {
            if (obj == null) {
                obj2 = null;
            } else {
                obj2 = obj.toString();
            }
            map.put(str, obj2);
        }
    }

    public void cancel() {
    }

    @OXOo.OOXIXo
    public String getClientState(@OXOo.OOXIXo String authId) {
        IIX0o.x0xO0oo(authId, "authId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LoginLogger.EVENT_PARAM_AUTH_LOGGER_ID, authId);
            jSONObject.put(LoginLogger.EVENT_PARAM_METHOD, getNameForLogging());
            putChallengeParam(jSONObject);
        } catch (JSONException e) {
            Log.w("LoginMethodHandler", IIX0o.XIxXXX0x0("Error creating client state json: ", e.getMessage()));
        }
        String jSONObject2 = jSONObject.toString();
        IIX0o.oO(jSONObject2, "param.toString()");
        return jSONObject2;
    }

    @OXOo.OOXIXo
    public final LoginClient getLoginClient() {
        LoginClient loginClient = this.loginClient;
        if (loginClient != null) {
            return loginClient;
        }
        IIX0o.XOxIOxOx("loginClient");
        throw null;
    }

    @OXOo.oOoXoXO
    public final Map<String, String> getMethodLoggingExtras() {
        return this.methodLoggingExtras;
    }

    @OXOo.OOXIXo
    public abstract String getNameForLogging();

    @OXOo.OOXIXo
    public String getRedirectUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append("fb");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        sb.append(FacebookSdk.getApplicationId());
        sb.append("://authorize/");
        return sb.toString();
    }

    public void logWebLoginCompleted(@OXOo.oOoXoXO String str) {
        String applicationId;
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        if (pendingRequest == null) {
            applicationId = null;
        } else {
            applicationId = pendingRequest.getApplicationId();
        }
        if (applicationId == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            applicationId = FacebookSdk.getApplicationId();
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(getLoginClient().getActivity(), applicationId);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_WEB_LOGIN_E2E, str);
        bundle.putLong(AnalyticsEvents.PARAMETER_WEB_LOGIN_SWITCHBACK_TIME, System.currentTimeMillis());
        bundle.putString("app_id", applicationId);
        internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_WEB_LOGIN_COMPLETE, null, bundle);
    }

    public boolean needsInternetPermission() {
        return false;
    }

    public boolean onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        return false;
    }

    @OXOo.OOXIXo
    public Bundle processCodeExchange(@OXOo.OOXIXo LoginClient.Request request, @OXOo.OOXIXo Bundle values) throws FacebookException {
        GraphRequest createCodeExchangeRequest;
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(values, "values");
        String string = values.getString("code");
        Utility utility = Utility.INSTANCE;
        if (!Utility.isNullOrEmpty(string)) {
            String str = null;
            if (string == null) {
                createCodeExchangeRequest = null;
            } else {
                PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
                String redirectUrl = getRedirectUrl();
                String codeVerifier = request.getCodeVerifier();
                if (codeVerifier == null) {
                    codeVerifier = "";
                }
                createCodeExchangeRequest = PKCEUtil.createCodeExchangeRequest(string, redirectUrl, codeVerifier);
            }
            if (createCodeExchangeRequest != null) {
                GraphResponse executeAndWait = createCodeExchangeRequest.executeAndWait();
                FacebookRequestError error = executeAndWait.getError();
                if (error == null) {
                    try {
                        JSONObject jSONObject = executeAndWait.getJSONObject();
                        if (jSONObject != null) {
                            str = jSONObject.getString("access_token");
                        }
                        if (jSONObject != null && !Utility.isNullOrEmpty(str)) {
                            values.putString("access_token", str);
                            if (jSONObject.has("id_token")) {
                                values.putString("id_token", jSONObject.getString("id_token"));
                            }
                            return values;
                        }
                        throw new FacebookException("No access token found from result");
                    } catch (JSONException e) {
                        throw new FacebookException(IIX0o.XIxXXX0x0("Fail to process code exchange response: ", e.getMessage()));
                    }
                }
                throw new FacebookServiceException(error, error.getErrorMessage());
            }
            throw new FacebookException("Failed to create code exchange request");
        }
        throw new FacebookException("No code param found from the request");
    }

    public void putChallengeParam(@OXOo.OOXIXo JSONObject param) throws JSONException {
        IIX0o.x0xO0oo(param, "param");
    }

    public final void setLoginClient(@OXOo.OOXIXo LoginClient loginClient) {
        IIX0o.x0xO0oo(loginClient, "<set-?>");
        this.loginClient = loginClient;
    }

    public final void setMethodLoggingExtras(@OXOo.oOoXoXO Map<String, String> map) {
        this.methodLoggingExtras = map;
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return false;
    }

    public abstract int tryAuthorize(@OXOo.OOXIXo LoginClient.Request request);

    @Override // android.os.Parcelable
    public void writeToParcel(@OXOo.OOXIXo Parcel dest, int i) {
        IIX0o.x0xO0oo(dest, "dest");
        Utility utility = Utility.INSTANCE;
        Utility.writeStringMapToParcel(dest, this.methodLoggingExtras);
    }

    public LoginMethodHandler(@OXOo.OOXIXo Parcel source) {
        IIX0o.x0xO0oo(source, "source");
        Utility utility = Utility.INSTANCE;
        Map<String, String> readStringMapFromParcel = Utility.readStringMapFromParcel(source);
        this.methodLoggingExtras = readStringMapFromParcel == null ? null : o0.O0X(readStringMapFromParcel);
    }
}
