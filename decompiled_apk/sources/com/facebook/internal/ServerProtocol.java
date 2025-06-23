package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.Arrays;
import java.util.Collection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class ServerProtocol {

    @OXOo.OOXIXo
    private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";

    @OXOo.OOXIXo
    public static final String DIALOG_CANCEL_URI = "fbconnect://cancel";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_APP_ID = "app_id";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_AUTHENTICATION_TOKEN = "id_token";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_CBT = "cbt";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH = "cct_over_app_switch";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_CLIENT_ID = "client_id";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_CODE_CHALLENGE = "code_challenge";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_CODE_CHALLENGE_METHOD = "code_challenge_method";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_CODE_REDIRECT_URI = "code_redirect_uri";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_CUSTOM_TABS_PREFETCHING = "cct_prefetching";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_DISPLAY = "display";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_DISPLAY_TOUCH = "touch";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_E2E = "e2e";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_FAIL_ON_LOGGED_OUT = "fail_on_logged_out";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_FX_APP = "fx_app";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_IES = "ies";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_LOGIN_BEHAVIOR = "login_behavior";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_MESSENGER_PAGE_ID = "messenger_page_id";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_NONCE = "nonce";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_RESET_MESSENGER_STATE = "reset_messenger_state";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_SCOPE = "scope";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_SDK_VERSION = "sdk";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_SKIP_DEDUPE = "skip_dedupe";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_SSO_DEVICE = "sso";

    @OXOo.OOXIXo
    public static final String DIALOG_PARAM_STATE = "state";

    @OXOo.OOXIXo
    public static final String DIALOG_PATH = "dialog/";

    @OXOo.OOXIXo
    public static final String DIALOG_REDIRECT_CHROME_OS_URI = "fbconnect://chrome_os_success";

    @OXOo.OOXIXo
    public static final String DIALOG_REDIRECT_URI = "fbconnect://success";

    @OXOo.OOXIXo
    public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";

    @OXOo.OOXIXo
    public static final String DIALOG_RESPONSE_TYPE_CODE = "code,signed_request,graph_domain";

    @OXOo.OOXIXo
    public static final String DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST = "id_token,token,signed_request,graph_domain";

    @OXOo.OOXIXo
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES = "token,signed_request,graph_domain,granted_scopes";

    @OXOo.OOXIXo
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST = "token,signed_request,graph_domain";

    @OXOo.OOXIXo
    public static final String DIALOG_RETURN_SCOPES_TRUE = "true";

    @OXOo.OOXIXo
    public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";

    @OXOo.OOXIXo
    public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";

    @OXOo.OOXIXo
    public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";

    @OXOo.OOXIXo
    public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";

    @OXOo.OOXIXo
    public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";

    @OXOo.OOXIXo
    public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";

    @OXOo.OOXIXo
    public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";

    @OXOo.OOXIXo
    private static final String GRAPH_URL_FORMAT = "https://graph.%s";

    @OXOo.OOXIXo
    private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";

    @OXOo.OOXIXo
    public static final String INSTAGRAM_OAUTH_PATH = "oauth/authorize";

    @OXOo.OOXIXo
    public static final ServerProtocol INSTANCE = new ServerProtocol();

    @OXOo.OOXIXo
    private static final String TAG;

    static {
        String name = ServerProtocol.class.getName();
        IIX0o.oO(name, "ServerProtocol::class.java.name");
        TAG = name;
    }

    private ServerProtocol() {
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getDefaultAPIVersion() {
        return "v14.0";
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getDialogAuthority() {
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String format = String.format(DIALOG_AUTHORITY_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getFacebookDomain()}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getErrorConnectionFailure() {
        return "CONNECTION_FAILURE";
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Collection<String> getErrorsProxyAuthDisabled() {
        return CollectionsKt__CollectionsKt.X00IoxXI("service_disabled", "AndroidAuthKillSwitchException");
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final Collection<String> getErrorsUserCanceled() {
        return CollectionsKt__CollectionsKt.X00IoxXI("access_denied", "OAuthAccessDeniedException");
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getFacebookGraphUrlBase() {
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String format = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getFacebookDomain()}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getGraphUrlBase() {
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String format = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getGraphDomain()}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getGraphUrlBaseForSubdomain(@OXOo.OOXIXo String subdomain) {
        IIX0o.x0xO0oo(subdomain, "subdomain");
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format(GRAPH_URL_FORMAT, Arrays.copyOf(new Object[]{subdomain}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getGraphVideoUrlBase() {
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String format = String.format(GRAPH_VIDEO_URL_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getGraphDomain()}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static final String getInstagramDialogAuthority() {
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String format = String.format(DIALOG_AUTHORITY_FORMAT, Arrays.copyOf(new Object[]{FacebookSdk.getInstagramDomain()}, 1));
        IIX0o.oO(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    public static final Bundle getQueryParamsForPlatformActivityIntentWebFallback(@OXOo.OOXIXo String callId, int i, @OXOo.oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(callId, "callId");
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationSignature = FacebookSdk.getApplicationSignature(FacebookSdk.getApplicationContext());
        Utility utility = Utility.INSTANCE;
        if (Utility.isNullOrEmpty(applicationSignature)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(FALLBACK_DIALOG_PARAM_KEY_HASH, applicationSignature);
        bundle2.putString("app_id", FacebookSdk.getApplicationId());
        bundle2.putInt("version", i);
        bundle2.putString(DIALOG_PARAM_DISPLAY, "touch");
        Bundle bundle3 = new Bundle();
        bundle3.putString("action_id", callId);
        try {
            BundleJSONConverter bundleJSONConverter = BundleJSONConverter.INSTANCE;
            JSONObject convertToJSON = BundleJSONConverter.convertToJSON(bundle3);
            if (bundle == null) {
                bundle = new Bundle();
            }
            JSONObject convertToJSON2 = BundleJSONConverter.convertToJSON(bundle);
            if (convertToJSON != null && convertToJSON2 != null) {
                bundle2.putString(FALLBACK_DIALOG_PARAM_BRIDGE_ARGS, convertToJSON.toString());
                bundle2.putString(FALLBACK_DIALOG_PARAM_METHOD_ARGS, convertToJSON2.toString());
                return bundle2;
            }
            return null;
        } catch (IllegalArgumentException e) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, IIX0o.XIxXXX0x0("Error creating Url -- ", e));
            return null;
        } catch (JSONException e2) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, 6, TAG, IIX0o.XIxXXX0x0("Error creating Url -- ", e2));
            return null;
        }
    }
}
