package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog;
import com.facebook.login.LoginClient;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes8.dex */
public class WebViewLoginMethodHandler extends WebLoginMethodHandler {

    @OXOo.OOXIXo
    private static final String OAUTH_DIALOG = "oauth";

    @OXOo.oOoXoXO
    private String e2e;

    @OXOo.oOoXoXO
    private WebDialog loginDialog;

    @OXOo.OOXIXo
    private final String nameForLogging;

    @OXOo.OOXIXo
    private final AccessTokenSource tokenSource;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new Parcelable.Creator<WebViewLoginMethodHandler>() { // from class: com.facebook.login.WebViewLoginMethodHandler$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public WebViewLoginMethodHandler createFromParcel(@OXOo.OOXIXo Parcel source) {
            IIX0o.x0xO0oo(source, "source");
            return new WebViewLoginMethodHandler(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public WebViewLoginMethodHandler[] newArray(int i) {
            return new WebViewLoginMethodHandler[i];
        }
    };

    /* loaded from: classes8.dex */
    public final class AuthDialogBuilder extends WebDialog.Builder {
        public String authType;
        public String e2e;
        private boolean isFamilyLogin;

        @OXOo.OOXIXo
        private LoginBehavior loginBehavior;

        @OXOo.OOXIXo
        private String redirect_uri;
        private boolean shouldSkipDedupe;

        @OXOo.OOXIXo
        private LoginTargetApp targetApp;
        final /* synthetic */ WebViewLoginMethodHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthDialogBuilder(@OXOo.OOXIXo WebViewLoginMethodHandler this$0, @OXOo.OOXIXo Context context, @OXOo.OOXIXo String applicationId, Bundle parameters) {
            super(context, applicationId, "oauth", parameters);
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(applicationId, "applicationId");
            IIX0o.x0xO0oo(parameters, "parameters");
            this.this$0 = this$0;
            this.redirect_uri = ServerProtocol.DIALOG_REDIRECT_URI;
            this.loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
            this.targetApp = LoginTargetApp.FACEBOOK;
        }

        @Override // com.facebook.internal.WebDialog.Builder
        @OXOo.OOXIXo
        public WebDialog build() {
            String str;
            Bundle parameters = getParameters();
            if (parameters != null) {
                parameters.putString("redirect_uri", this.redirect_uri);
                parameters.putString("client_id", getApplicationId());
                parameters.putString("e2e", getE2e());
                if (this.targetApp == LoginTargetApp.INSTAGRAM) {
                    str = ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES;
                } else {
                    str = ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST;
                }
                parameters.putString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, str);
                parameters.putString(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, "true");
                parameters.putString(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, getAuthType());
                parameters.putString("login_behavior", this.loginBehavior.name());
                if (this.isFamilyLogin) {
                    parameters.putString(ServerProtocol.DIALOG_PARAM_FX_APP, this.targetApp.toString());
                }
                if (this.shouldSkipDedupe) {
                    parameters.putString(ServerProtocol.DIALOG_PARAM_SKIP_DEDUPE, "true");
                }
                WebDialog.Companion companion = WebDialog.Companion;
                Context context = getContext();
                if (context != null) {
                    return companion.newInstance(context, "oauth", parameters, getTheme(), this.targetApp, getListener());
                }
                throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Bundle");
        }

        @OXOo.OOXIXo
        public final String getAuthType() {
            String str = this.authType;
            if (str != null) {
                return str;
            }
            IIX0o.XOxIOxOx("authType");
            throw null;
        }

        @OXOo.OOXIXo
        public final String getE2e() {
            String str = this.e2e;
            if (str != null) {
                return str;
            }
            IIX0o.XOxIOxOx("e2e");
            throw null;
        }

        /* renamed from: setAuthType, reason: collision with other method in class */
        public final void m254setAuthType(@OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.authType = str;
        }

        @OXOo.OOXIXo
        public final AuthDialogBuilder setE2E(@OXOo.OOXIXo String e2e) {
            IIX0o.x0xO0oo(e2e, "e2e");
            setE2e(e2e);
            return this;
        }

        public final void setE2e(@OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.e2e = str;
        }

        @OXOo.OOXIXo
        public final AuthDialogBuilder setFamilyLogin(boolean z) {
            this.isFamilyLogin = z;
            return this;
        }

        @OXOo.OOXIXo
        public final AuthDialogBuilder setIsChromeOS(boolean z) {
            String str;
            if (z) {
                str = ServerProtocol.DIALOG_REDIRECT_CHROME_OS_URI;
            } else {
                str = ServerProtocol.DIALOG_REDIRECT_URI;
            }
            this.redirect_uri = str;
            return this;
        }

        @OXOo.OOXIXo
        public final AuthDialogBuilder setIsRerequest(boolean z) {
            return this;
        }

        @OXOo.OOXIXo
        public final AuthDialogBuilder setLoginBehavior(@OXOo.OOXIXo LoginBehavior loginBehavior) {
            IIX0o.x0xO0oo(loginBehavior, "loginBehavior");
            this.loginBehavior = loginBehavior;
            return this;
        }

        @OXOo.OOXIXo
        public final AuthDialogBuilder setLoginTargetApp(@OXOo.OOXIXo LoginTargetApp targetApp) {
            IIX0o.x0xO0oo(targetApp, "targetApp");
            this.targetApp = targetApp;
            return this;
        }

        @OXOo.OOXIXo
        public final AuthDialogBuilder setShouldSkipDedupe(boolean z) {
            this.shouldSkipDedupe = z;
            return this;
        }

        @OXOo.OOXIXo
        public final AuthDialogBuilder setAuthType(@OXOo.OOXIXo String authType) {
            IIX0o.x0xO0oo(authType, "authType");
            m254setAuthType(authType);
            return this;
        }
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(@OXOo.OOXIXo LoginClient loginClient) {
        super(loginClient);
        IIX0o.x0xO0oo(loginClient, "loginClient");
        this.nameForLogging = "web_view";
        this.tokenSource = AccessTokenSource.WEB_VIEW;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void cancel() {
        WebDialog webDialog = this.loginDialog;
        if (webDialog != null) {
            if (webDialog != null) {
                webDialog.cancel();
            }
            this.loginDialog = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @OXOo.oOoXoXO
    public final String getE2e() {
        return this.e2e;
    }

    @OXOo.oOoXoXO
    public final WebDialog getLoginDialog() {
        return this.loginDialog;
    }

    @Override // com.facebook.login.LoginMethodHandler
    @OXOo.OOXIXo
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    @OXOo.OOXIXo
    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean needsInternetPermission() {
        return true;
    }

    public final void onWebDialogComplete(@OXOo.OOXIXo LoginClient.Request request, @OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO FacebookException facebookException) {
        IIX0o.x0xO0oo(request, "request");
        super.onComplete(request, bundle, facebookException);
    }

    public final void setE2e(@OXOo.oOoXoXO String str) {
        this.e2e = str;
    }

    public final void setLoginDialog(@OXOo.oOoXoXO WebDialog webDialog) {
        this.loginDialog = webDialog;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int tryAuthorize(@OXOo.OOXIXo final LoginClient.Request request) {
        IIX0o.x0xO0oo(request, "request");
        Bundle parameters = getParameters(request);
        WebDialog.OnCompleteListener onCompleteListener = new WebDialog.OnCompleteListener() { // from class: com.facebook.login.WebViewLoginMethodHandler$tryAuthorize$listener$1
            @Override // com.facebook.internal.WebDialog.OnCompleteListener
            public void onComplete(@OXOo.oOoXoXO Bundle bundle, @OXOo.oOoXoXO FacebookException facebookException) {
                WebViewLoginMethodHandler.this.onWebDialogComplete(request, bundle, facebookException);
            }
        };
        String e2e = LoginClient.Companion.getE2E();
        this.e2e = e2e;
        addLoggingExtra("e2e", e2e);
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity == null) {
            return 0;
        }
        Utility utility = Utility.INSTANCE;
        boolean isChromeOS = Utility.isChromeOS(activity);
        AuthDialogBuilder authDialogBuilder = new AuthDialogBuilder(this, activity, request.getApplicationId(), parameters);
        String str = this.e2e;
        if (str != null) {
            this.loginDialog = authDialogBuilder.setE2E(str).setIsChromeOS(isChromeOS).setAuthType(request.getAuthType()).setLoginBehavior(request.getLoginBehavior()).setLoginTargetApp(request.getLoginTargetApp()).setFamilyLogin(request.isFamilyLogin()).setShouldSkipDedupe(request.shouldSkipAccountDeduplication()).setOnCompleteListener(onCompleteListener).build();
            FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
            facebookDialogFragment.setRetainInstance(true);
            facebookDialogFragment.setInnerDialog(this.loginDialog);
            facebookDialogFragment.show(activity.getSupportFragmentManager(), FacebookDialogFragment.TAG);
            return 1;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(@OXOo.OOXIXo Parcel dest, int i) {
        IIX0o.x0xO0oo(dest, "dest");
        super.writeToParcel(dest, i);
        dest.writeString(this.e2e);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(@OXOo.OOXIXo Parcel source) {
        super(source);
        IIX0o.x0xO0oo(source, "source");
        this.nameForLogging = "web_view";
        this.tokenSource = AccessTokenSource.WEB_VIEW;
        this.e2e = source.readString();
    }
}
