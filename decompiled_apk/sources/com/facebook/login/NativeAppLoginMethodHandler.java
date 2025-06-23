package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.CustomTabLoginMethodHandler;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

@VisibleForTesting(otherwise = 3)
/* loaded from: classes8.dex */
public abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {

    @OXOo.OOXIXo
    private final AccessTokenSource tokenSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAppLoginMethodHandler(@OXOo.OOXIXo LoginClient loginClient) {
        super(loginClient);
        IIX0o.x0xO0oo(loginClient, "loginClient");
        this.tokenSource = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    }

    private final void completeLogin(LoginClient.Result result) {
        if (result != null) {
            getLoginClient().completeAndValidate(result);
        } else {
            getLoginClient().tryNextHandler();
        }
    }

    private final boolean isCallable(Intent intent) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        IIX0o.oO(FacebookSdk.getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536), "FacebookSdk.getApplicationContext()\n            .packageManager\n            .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
        return !r3.isEmpty();
    }

    private final void processSuccessResponse(final LoginClient.Request request, final Bundle bundle) {
        if (bundle.containsKey("code")) {
            Utility utility = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(bundle.getString("code"))) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.login.IXxxXO
                    @Override // java.lang.Runnable
                    public final void run() {
                        NativeAppLoginMethodHandler.m253processSuccessResponse$lambda0(NativeAppLoginMethodHandler.this, request, bundle);
                    }
                });
                return;
            }
        }
        handleResultOk(request, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processSuccessResponse$lambda-0, reason: not valid java name */
    public static final void m253processSuccessResponse$lambda0(NativeAppLoginMethodHandler this$0, LoginClient.Request request, Bundle extras) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(request, "$request");
        IIX0o.x0xO0oo(extras, "$extras");
        try {
            this$0.handleResultOk(request, this$0.processCodeExchange(request, extras));
        } catch (FacebookServiceException e) {
            FacebookRequestError requestError = e.getRequestError();
            this$0.handleResultError(request, requestError.getErrorType(), requestError.getErrorMessage(), String.valueOf(requestError.getErrorCode()));
        } catch (FacebookException e2) {
            this$0.handleResultError(request, null, e2.getMessage(), null);
        }
    }

    @OXOo.oOoXoXO
    public String getError(@OXOo.oOoXoXO Bundle bundle) {
        String string;
        if (bundle == null) {
            string = null;
        } else {
            string = bundle.getString("error");
        }
        if (string == null) {
            if (bundle == null) {
                return null;
            }
            return bundle.getString("error_type");
        }
        return string;
    }

    @OXOo.oOoXoXO
    public String getErrorMessage(@OXOo.oOoXoXO Bundle bundle) {
        String string;
        if (bundle == null) {
            string = null;
        } else {
            string = bundle.getString("error_message");
        }
        if (string == null) {
            if (bundle == null) {
                return null;
            }
            return bundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
        }
        return string;
    }

    @OXOo.OOXIXo
    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    public void handleResultCancel(@OXOo.oOoXoXO LoginClient.Request request, @OXOo.OOXIXo Intent data) {
        Object obj;
        IIX0o.x0xO0oo(data, "data");
        Bundle extras = data.getExtras();
        String error = getError(extras);
        String str = null;
        if (extras != null && (obj = extras.get("error_code")) != null) {
            str = obj.toString();
        }
        ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
        if (IIX0o.Oxx0IOOO(ServerProtocol.getErrorConnectionFailure(), str)) {
            completeLogin(LoginClient.Result.Companion.createErrorResult(request, error, getErrorMessage(extras), str));
        } else {
            completeLogin(LoginClient.Result.Companion.createCancelResult(request, error));
        }
    }

    public void handleResultError(@OXOo.oOoXoXO LoginClient.Request request, @OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3) {
        if (str != null && IIX0o.Oxx0IOOO(str, "logged_out")) {
            CustomTabLoginMethodHandler.Companion companion = CustomTabLoginMethodHandler.Companion;
            CustomTabLoginMethodHandler.calledThroughLoggedOutAppSwitch = true;
            completeLogin(null);
            return;
        }
        ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
        if (CollectionsKt___CollectionsKt.X00xOoXI(ServerProtocol.getErrorsProxyAuthDisabled(), str)) {
            completeLogin(null);
        } else if (CollectionsKt___CollectionsKt.X00xOoXI(ServerProtocol.getErrorsUserCanceled(), str)) {
            completeLogin(LoginClient.Result.Companion.createCancelResult(request, null));
        } else {
            completeLogin(LoginClient.Result.Companion.createErrorResult(request, str, str2, str3));
        }
    }

    public void handleResultOk(@OXOo.OOXIXo LoginClient.Request request, @OXOo.OOXIXo Bundle extras) {
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(extras, "extras");
        try {
            LoginMethodHandler.Companion companion = LoginMethodHandler.Companion;
            completeLogin(LoginClient.Result.Companion.createCompositeTokenResult(request, companion.createAccessTokenFromWebBundle(request.getPermissions(), extras, getTokenSource(), request.getApplicationId()), companion.createAuthenticationTokenFromWebBundle(extras, request.getNonce())));
        } catch (FacebookException e) {
            completeLogin(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, request, null, e.getMessage(), null, 8, null));
        }
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        String obj;
        LoginClient.Request pendingRequest = getLoginClient().getPendingRequest();
        if (intent == null) {
            completeLogin(LoginClient.Result.Companion.createCancelResult(pendingRequest, "Operation canceled"));
        } else if (i2 == 0) {
            handleResultCancel(pendingRequest, intent);
        } else if (i2 != -1) {
            completeLogin(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, pendingRequest, "Unexpected resultCode from authorization.", null, null, 8, null));
        } else {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                completeLogin(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, pendingRequest, "Unexpected null from returned authorization data.", null, null, 8, null));
                return true;
            }
            String error = getError(extras);
            Object obj2 = extras.get("error_code");
            if (obj2 == null) {
                obj = null;
            } else {
                obj = obj2.toString();
            }
            String errorMessage = getErrorMessage(extras);
            String string = extras.getString("e2e");
            Utility utility = Utility.INSTANCE;
            if (!Utility.isNullOrEmpty(string)) {
                logWebLoginCompleted(string);
            }
            if (error == null && obj == null && errorMessage == null && pendingRequest != null) {
                processSuccessResponse(pendingRequest, extras);
            } else {
                handleResultError(pendingRequest, error, errorMessage, obj);
            }
        }
        return true;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public abstract int tryAuthorize(@OXOo.OOXIXo LoginClient.Request request);

    public boolean tryIntent(@OXOo.oOoXoXO Intent intent, int i) {
        LoginFragment loginFragment;
        ActivityResultLauncher<Intent> launcher;
        if (intent == null || !isCallable(intent)) {
            return false;
        }
        Fragment fragment = getLoginClient().getFragment();
        oXIO0o0XI oxio0o0xi = null;
        if (fragment instanceof LoginFragment) {
            loginFragment = (LoginFragment) fragment;
        } else {
            loginFragment = null;
        }
        if (loginFragment != null && (launcher = loginFragment.getLauncher()) != null) {
            launcher.launch(intent);
            oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        }
        if (oxio0o0xi == null) {
            return false;
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAppLoginMethodHandler(@OXOo.OOXIXo Parcel source) {
        super(source);
        IIX0o.x0xO0oo(source, "source");
        this.tokenSource = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    }
}
