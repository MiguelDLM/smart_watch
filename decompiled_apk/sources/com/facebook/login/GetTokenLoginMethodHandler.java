package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class GetTokenLoginMethodHandler extends LoginMethodHandler {

    @OXOo.oOoXoXO
    private GetTokenClient getTokenClient;

    @OXOo.OOXIXo
    private final String nameForLogging;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new Parcelable.Creator<GetTokenLoginMethodHandler>() { // from class: com.facebook.login.GetTokenLoginMethodHandler$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public GetTokenLoginMethodHandler createFromParcel(@OXOo.OOXIXo Parcel source) {
            IIX0o.x0xO0oo(source, "source");
            return new GetTokenLoginMethodHandler(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @OXOo.OOXIXo
        public GetTokenLoginMethodHandler[] newArray(int i) {
            return new GetTokenLoginMethodHandler[i];
        }
    };

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(@OXOo.OOXIXo LoginClient loginClient) {
        super(loginClient);
        IIX0o.x0xO0oo(loginClient, "loginClient");
        this.nameForLogging = "get_token";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: tryAuthorize$lambda-1, reason: not valid java name */
    public static final void m245tryAuthorize$lambda1(GetTokenLoginMethodHandler this$0, LoginClient.Request request, Bundle bundle) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(request, "$request");
        this$0.getTokenCompleted(request, bundle);
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void cancel() {
        GetTokenClient getTokenClient = this.getTokenClient;
        if (getTokenClient != null) {
            getTokenClient.cancel();
            getTokenClient.setCompletedListener(null);
            this.getTokenClient = null;
        }
    }

    public final void complete(@OXOo.OOXIXo final LoginClient.Request request, @OXOo.OOXIXo final Bundle result) {
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(result, "result");
        String string = result.getString(NativeProtocol.EXTRA_USER_ID);
        if (string != null && string.length() != 0) {
            onComplete(request, result);
            return;
        }
        getLoginClient().notifyBackgroundProcessingStart();
        String string2 = result.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
        if (string2 != null) {
            Utility utility = Utility.INSTANCE;
            Utility.getGraphMeRequestWithCacheAsync(string2, new Utility.GraphMeRequestWithCacheCallback() { // from class: com.facebook.login.GetTokenLoginMethodHandler$complete$1
                @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
                public void onFailure(@OXOo.oOoXoXO FacebookException facebookException) {
                    String message;
                    LoginClient loginClient = this.getLoginClient();
                    LoginClient.Result.Companion companion = LoginClient.Result.Companion;
                    LoginClient.Request pendingRequest = this.getLoginClient().getPendingRequest();
                    if (facebookException == null) {
                        message = null;
                    } else {
                        message = facebookException.getMessage();
                    }
                    loginClient.complete(LoginClient.Result.Companion.createErrorResult$default(companion, pendingRequest, "Caught exception", message, null, 8, null));
                }

                @Override // com.facebook.internal.Utility.GraphMeRequestWithCacheCallback
                public void onSuccess(@OXOo.oOoXoXO JSONObject jSONObject) {
                    String string3;
                    try {
                        Bundle bundle = result;
                        if (jSONObject == null) {
                            string3 = null;
                        } else {
                            string3 = jSONObject.getString("id");
                        }
                        bundle.putString(NativeProtocol.EXTRA_USER_ID, string3);
                        this.onComplete(request, result);
                    } catch (JSONException e) {
                        this.getLoginClient().complete(LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, this.getLoginClient().getPendingRequest(), "Caught exception", e.getMessage(), null, 8, null));
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    @OXOo.OOXIXo
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public final void getTokenCompleted(@OXOo.OOXIXo LoginClient.Request request, @OXOo.oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(request, "request");
        GetTokenClient getTokenClient = this.getTokenClient;
        if (getTokenClient != null) {
            getTokenClient.setCompletedListener(null);
        }
        this.getTokenClient = null;
        getLoginClient().notifyBackgroundProcessingStop();
        if (bundle != null) {
            List stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            if (stringArrayList == null) {
                stringArrayList = CollectionsKt__CollectionsKt.ooXIXxIX();
            }
            Set<String> permissions = request.getPermissions();
            if (permissions == null) {
                permissions = Xo0.OOXIXo();
            }
            String string = bundle.getString(NativeProtocol.EXTRA_AUTHENTICATION_TOKEN);
            if (permissions.contains("openid") && (string == null || string.length() == 0)) {
                getLoginClient().tryNextHandler();
                return;
            }
            if (stringArrayList.containsAll(permissions)) {
                complete(request, bundle);
                return;
            }
            HashSet hashSet = new HashSet();
            for (String str : permissions) {
                if (!stringArrayList.contains(str)) {
                    hashSet.add(str);
                }
            }
            if (!hashSet.isEmpty()) {
                addLoggingExtra(LoginLogger.EVENT_EXTRAS_NEW_PERMISSIONS, TextUtils.join(",", hashSet));
            }
            request.setPermissions(hashSet);
        }
        getLoginClient().tryNextHandler();
    }

    public final void onComplete(@OXOo.OOXIXo LoginClient.Request request, @OXOo.OOXIXo Bundle result) {
        LoginClient.Result createErrorResult$default;
        IIX0o.x0xO0oo(request, "request");
        IIX0o.x0xO0oo(result, "result");
        try {
            LoginMethodHandler.Companion companion = LoginMethodHandler.Companion;
            createErrorResult$default = LoginClient.Result.Companion.createCompositeTokenResult(request, companion.createAccessTokenFromNativeLogin(result, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, request.getApplicationId()), companion.createAuthenticationTokenFromNativeLogin(result, request.getNonce()));
        } catch (FacebookException e) {
            createErrorResult$default = LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.Companion, getLoginClient().getPendingRequest(), null, e.getMessage(), null, 8, null);
        }
        getLoginClient().completeAndValidate(createErrorResult$default);
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int tryAuthorize(@OXOo.OOXIXo final LoginClient.Request request) {
        IIX0o.x0xO0oo(request, "request");
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            activity = FacebookSdk.getApplicationContext();
        }
        GetTokenClient getTokenClient = new GetTokenClient(activity, request);
        this.getTokenClient = getTokenClient;
        if (IIX0o.Oxx0IOOO(Boolean.valueOf(getTokenClient.start()), Boolean.FALSE)) {
            return 0;
        }
        getLoginClient().notifyBackgroundProcessingStart();
        PlatformServiceClient.CompletedListener completedListener = new PlatformServiceClient.CompletedListener() { // from class: com.facebook.login.xxIXOIIO
            @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
            public final void completed(Bundle bundle) {
                GetTokenLoginMethodHandler.m245tryAuthorize$lambda1(GetTokenLoginMethodHandler.this, request, bundle);
            }
        };
        GetTokenClient getTokenClient2 = this.getTokenClient;
        if (getTokenClient2 != null) {
            getTokenClient2.setCompletedListener(completedListener);
            return 1;
        }
        return 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(@OXOo.OOXIXo Parcel source) {
        super(source);
        IIX0o.x0xO0oo(source, "source");
        this.nameForLogging = "get_token";
    }
}
