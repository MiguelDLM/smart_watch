package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginManager;
import com.szabh.smable3.entity.BleNotification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;

/* loaded from: classes8.dex */
public class LoginManager {

    @OXOo.OOXIXo
    public static final Companion Companion;

    @OXOo.OOXIXo
    private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";

    @OXOo.OOXIXo
    private static final String MANAGE_PERMISSION_PREFIX = "manage";

    @OXOo.OOXIXo
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS;

    @OXOo.OOXIXo
    private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";

    @OXOo.OOXIXo
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";

    @OXOo.OOXIXo
    private static final String TAG;
    private static volatile LoginManager instance;
    private boolean isFamilyLogin;

    @OXOo.oOoXoXO
    private String messengerPageId;
    private boolean resetMessengerState;

    @OXOo.OOXIXo
    private final SharedPreferences sharedPreferences;
    private boolean shouldSkipAccountDeduplication;

    @OXOo.OOXIXo
    private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;

    @OXOo.OOXIXo
    private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;

    @OXOo.OOXIXo
    private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;

    @OXOo.OOXIXo
    private LoginTargetApp loginTargetApp = LoginTargetApp.FACEBOOK;

    /* loaded from: classes8.dex */
    public static final class ActivityStartActivityDelegate implements StartActivityDelegate {

        @OXOo.OOXIXo
        private final Activity activityContext;

        public ActivityStartActivityDelegate(@OXOo.OOXIXo Activity activity) {
            IIX0o.x0xO0oo(activity, "activity");
            this.activityContext = activity;
        }

        @Override // com.facebook.login.StartActivityDelegate
        @OXOo.OOXIXo
        public Activity getActivityContext() {
            return this.activityContext;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(@OXOo.OOXIXo Intent intent, int i) {
            IIX0o.x0xO0oo(intent, "intent");
            getActivityContext().startActivityForResult(intent, i);
        }
    }

    /* loaded from: classes8.dex */
    public static final class AndroidxActivityResultRegistryOwnerStartActivityDelegate implements StartActivityDelegate {

        @OXOo.OOXIXo
        private final ActivityResultRegistryOwner activityResultRegistryOwner;

        @OXOo.OOXIXo
        private final CallbackManager callbackManager;

        public AndroidxActivityResultRegistryOwnerStartActivityDelegate(@OXOo.OOXIXo ActivityResultRegistryOwner activityResultRegistryOwner, @OXOo.OOXIXo CallbackManager callbackManager) {
            IIX0o.x0xO0oo(activityResultRegistryOwner, "activityResultRegistryOwner");
            IIX0o.x0xO0oo(callbackManager, "callbackManager");
            this.activityResultRegistryOwner = activityResultRegistryOwner;
            this.callbackManager = callbackManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: startActivityForResult$lambda-0, reason: not valid java name */
        public static final void m252startActivityForResult$lambda0(AndroidxActivityResultRegistryOwnerStartActivityDelegate this$0, LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder launcherHolder, Pair pair) {
            IIX0o.x0xO0oo(this$0, "this$0");
            IIX0o.x0xO0oo(launcherHolder, "$launcherHolder");
            CallbackManager callbackManager = this$0.callbackManager;
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            Object obj = pair.first;
            IIX0o.oO(obj, "result.first");
            callbackManager.onActivityResult(requestCode, ((Number) obj).intValue(), (Intent) pair.second);
            ActivityResultLauncher<Intent> launcher = launcherHolder.getLauncher();
            if (launcher != null) {
                launcher.unregister();
            }
            launcherHolder.setLauncher(null);
        }

        @Override // com.facebook.login.StartActivityDelegate
        @OXOo.oOoXoXO
        public Activity getActivityContext() {
            Object obj = this.activityResultRegistryOwner;
            if (obj instanceof Activity) {
                return (Activity) obj;
            }
            return null;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(@OXOo.OOXIXo Intent intent, int i) {
            IIX0o.x0xO0oo(intent, "intent");
            final LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder = new LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder();
            loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.setLauncher(this.activityResultRegistryOwner.getActivityResultRegistry().register("facebook-login", new ActivityResultContract<Intent, Pair<Integer, Intent>>() { // from class: com.facebook.login.LoginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$1
                @Override // androidx.activity.result.contract.ActivityResultContract
                @OXOo.OOXIXo
                public Intent createIntent(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent input) {
                    IIX0o.x0xO0oo(context, "context");
                    IIX0o.x0xO0oo(input, "input");
                    return input;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // androidx.activity.result.contract.ActivityResultContract
                @OXOo.OOXIXo
                public Pair<Integer, Intent> parseResult(int i2, @OXOo.oOoXoXO Intent intent2) {
                    Pair<Integer, Intent> create = Pair.create(Integer.valueOf(i2), intent2);
                    IIX0o.oO(create, "create(resultCode, intent)");
                    return create;
                }
            }, new ActivityResultCallback() { // from class: com.facebook.login.x0xO0oo
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.m252startActivityForResult$lambda0(LoginManager.AndroidxActivityResultRegistryOwnerStartActivityDelegate.this, loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder, (Pair) obj);
                }
            }));
            ActivityResultLauncher<Intent> launcher = loginManager$AndroidxActivityResultRegistryOwnerStartActivityDelegate$startActivityForResult$LauncherHolder.getLauncher();
            if (launcher != null) {
                launcher.launch(intent);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<String> getOtherPublishPermissions() {
            return Xo0.OxxIIOOXO("ads_management", "create_event", "rsvp_event");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void handleLoginStatusError(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
            FacebookException facebookException = new FacebookException(str + ": " + ((Object) str2));
            loginLogger.logLoginStatusError(str3, facebookException);
            loginStatusCallback.onError(facebookException);
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        @VisibleForTesting(otherwise = 2)
        public final LoginResult computeLoginResult(@OXOo.OOXIXo LoginClient.Request request, @OXOo.OOXIXo AccessToken newToken, @OXOo.oOoXoXO AuthenticationToken authenticationToken) {
            IIX0o.x0xO0oo(request, "request");
            IIX0o.x0xO0oo(newToken, "newToken");
            Set<String> permissions = request.getPermissions();
            Set OoOoxX0xo = CollectionsKt___CollectionsKt.OoOoxX0xo(CollectionsKt___CollectionsKt.IOOoXo0Ix(newToken.getPermissions()));
            if (request.isRerequest()) {
                OoOoxX0xo.retainAll(permissions);
            }
            Set OoOoxX0xo2 = CollectionsKt___CollectionsKt.OoOoxX0xo(CollectionsKt___CollectionsKt.IOOoXo0Ix(permissions));
            OoOoxX0xo2.removeAll(OoOoxX0xo);
            return new LoginResult(newToken, authenticationToken, OoOoxX0xo, OoOoxX0xo2);
        }

        @XO0OX.x0XOIxOo
        @OXOo.oOoXoXO
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final Map<String, String> getExtraDataFromIntent(@OXOo.oOoXoXO Intent intent) {
            if (intent == null) {
                return null;
            }
            intent.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result == null) {
                return null;
            }
            return result.extraData;
        }

        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        public LoginManager getInstance() {
            if (LoginManager.instance == null) {
                synchronized (this) {
                    Companion companion = LoginManager.Companion;
                    LoginManager.instance = new LoginManager();
                    oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                }
            }
            LoginManager loginManager = LoginManager.instance;
            if (loginManager != null) {
                return loginManager;
            }
            IIX0o.XOxIOxOx("instance");
            throw null;
        }

        @XO0OX.x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean isPublishPermission(@OXOo.oOoXoXO String str) {
            if (str == null) {
                return false;
            }
            if (!OxI.IOOoXo0Ix(str, LoginManager.PUBLISH_PERMISSION_PREFIX, false, 2, null) && !OxI.IOOoXo0Ix(str, LoginManager.MANAGE_PERMISSION_PREFIX, false, 2, null) && !LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(str)) {
                return false;
            }
            return true;
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public final class FacebookLoginActivityResultContract extends ActivityResultContract<Collection<? extends String>, CallbackManager.ActivityResultParameters> {

        @OXOo.oOoXoXO
        private CallbackManager callbackManager;

        @OXOo.oOoXoXO
        private String loggerID;

        public FacebookLoginActivityResultContract(@OXOo.oOoXoXO LoginManager this$0, @OXOo.oOoXoXO CallbackManager callbackManager, String str) {
            IIX0o.x0xO0oo(this$0, "this$0");
            LoginManager.this = this$0;
            this.callbackManager = callbackManager;
            this.loggerID = str;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context context, Collection<? extends String> collection) {
            return createIntent2(context, (Collection<String>) collection);
        }

        @OXOo.oOoXoXO
        public final CallbackManager getCallbackManager() {
            return this.callbackManager;
        }

        @OXOo.oOoXoXO
        public final String getLoggerID() {
            return this.loggerID;
        }

        public final void setCallbackManager(@OXOo.oOoXoXO CallbackManager callbackManager) {
            this.callbackManager = callbackManager;
        }

        public final void setLoggerID(@OXOo.oOoXoXO String str) {
            this.loggerID = str;
        }

        @OXOo.OOXIXo
        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Collection<String> permissions) {
            IIX0o.x0xO0oo(context, "context");
            IIX0o.x0xO0oo(permissions, "permissions");
            LoginClient.Request createLoginRequestWithConfig = LoginManager.this.createLoginRequestWithConfig(new LoginConfiguration(permissions, null, 2, null));
            String str = this.loggerID;
            if (str != null) {
                createLoginRequestWithConfig.setAuthId(str);
            }
            LoginManager.this.logStartLogin(context, createLoginRequestWithConfig);
            Intent facebookActivityIntent = LoginManager.this.getFacebookActivityIntent(createLoginRequestWithConfig);
            if (LoginManager.this.resolveIntent(facebookActivityIntent)) {
                return facebookActivityIntent;
            }
            FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            LoginManager.this.logCompleteLogin(context, LoginClient.Result.Code.ERROR, null, facebookException, false, createLoginRequestWithConfig);
            throw facebookException;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @OXOo.OOXIXo
        public CallbackManager.ActivityResultParameters parseResult(int i, @OXOo.oOoXoXO Intent intent) {
            LoginManager.onActivityResult$default(LoginManager.this, i, intent, null, 4, null);
            int requestCode = CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
            CallbackManager callbackManager = this.callbackManager;
            if (callbackManager != null) {
                callbackManager.onActivityResult(requestCode, i, intent);
            }
            return new CallbackManager.ActivityResultParameters(requestCode, i, intent);
        }

        public /* synthetic */ FacebookLoginActivityResultContract(CallbackManager callbackManager, String str, int i, IIXOooo iIXOooo) {
            this(LoginManager.this, (i & 1) != 0 ? null : callbackManager, (i & 2) != 0 ? null : str);
        }
    }

    /* loaded from: classes8.dex */
    public static final class FragmentStartActivityDelegate implements StartActivityDelegate {

        @OXOo.oOoXoXO
        private final Activity activityContext;

        @OXOo.OOXIXo
        private final FragmentWrapper fragment;

        public FragmentStartActivityDelegate(@OXOo.OOXIXo FragmentWrapper fragment) {
            IIX0o.x0xO0oo(fragment, "fragment");
            this.fragment = fragment;
            this.activityContext = fragment.getActivity();
        }

        @Override // com.facebook.login.StartActivityDelegate
        @OXOo.oOoXoXO
        public Activity getActivityContext() {
            return this.activityContext;
        }

        @Override // com.facebook.login.StartActivityDelegate
        public void startActivityForResult(@OXOo.OOXIXo Intent intent, int i) {
            IIX0o.x0xO0oo(intent, "intent");
            this.fragment.startActivityForResult(intent, i);
        }
    }

    /* loaded from: classes8.dex */
    public static final class LoginLoggerHolder {

        @OXOo.OOXIXo
        public static final LoginLoggerHolder INSTANCE = new LoginLoggerHolder();

        @OXOo.oOoXoXO
        private static LoginLogger logger;

        private LoginLoggerHolder() {
        }

        @OXOo.oOoXoXO
        public final synchronized LoginLogger getLogger(@OXOo.oOoXoXO Context context) {
            if (context == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                context = FacebookSdk.getApplicationContext();
            }
            if (context == null) {
                return null;
            }
            if (logger == null) {
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                logger = new LoginLogger(context, FacebookSdk.getApplicationId());
            }
            return logger;
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        OTHER_PUBLISH_PERMISSIONS = companion.getOtherPublishPermissions();
        String cls = LoginManager.class.toString();
        IIX0o.oO(cls, "LoginManager::class.java.toString()");
        TAG = cls;
    }

    public LoginManager() {
        Validate validate = Validate.INSTANCE;
        Validate.sdkInitialized();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, 0);
        IIX0o.oO(sharedPreferences, "getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences;
        if (FacebookSdk.hasCustomTabsPrefetching) {
            CustomTabUtils customTabUtils = CustomTabUtils.INSTANCE;
            if (CustomTabUtils.getChromePackage() != null) {
                CustomTabsClient.bindCustomTabsService(FacebookSdk.getApplicationContext(), BleNotification.GOOGLE_CHROME, new CustomTabPrefetchHelper());
                CustomTabsClient.connectAndInitialize(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationContext().getPackageName());
            }
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    @VisibleForTesting(otherwise = 2)
    public static final LoginResult computeLoginResult(@OXOo.OOXIXo LoginClient.Request request, @OXOo.OOXIXo AccessToken accessToken, @OXOo.oOoXoXO AuthenticationToken authenticationToken) {
        return Companion.computeLoginResult(request, accessToken, authenticationToken);
    }

    public static /* synthetic */ FacebookLoginActivityResultContract createLogInActivityResultContract$default(LoginManager loginManager, CallbackManager callbackManager, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                callbackManager = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return loginManager.createLogInActivityResultContract(callbackManager, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogInActivityResultContract");
    }

    private final LoginClient.Request createLoginRequestFromResponse(GraphResponse graphResponse) {
        Set<String> permissions;
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        List list = null;
        if (accessToken != null && (permissions = accessToken.getPermissions()) != null) {
            list = CollectionsKt___CollectionsKt.IOOoXo0Ix(permissions);
        }
        return createLoginRequest(list);
    }

    private final void finishLogin(AccessToken accessToken, AuthenticationToken authenticationToken, LoginClient.Request request, FacebookException facebookException, boolean z, FacebookCallback<LoginResult> facebookCallback) {
        LoginResult loginResult;
        if (accessToken != null) {
            AccessToken.Companion.setCurrentAccessToken(accessToken);
            Profile.Companion.fetchProfileForCurrentAccessToken();
        }
        if (authenticationToken != null) {
            AuthenticationToken.Companion.setCurrentAuthenticationToken(authenticationToken);
        }
        if (facebookCallback != null) {
            if (accessToken != null && request != null) {
                loginResult = Companion.computeLoginResult(request, accessToken, authenticationToken);
            } else {
                loginResult = null;
            }
            if (!z && (loginResult == null || !loginResult.getRecentlyGrantedPermissions().isEmpty())) {
                if (facebookException != null) {
                    facebookCallback.onError(facebookException);
                    return;
                } else {
                    if (accessToken != null && loginResult != null) {
                        setExpressLoginStatus(true);
                        facebookCallback.onSuccess(loginResult);
                        return;
                    }
                    return;
                }
            }
            facebookCallback.onCancel();
        }
    }

    @XO0OX.x0XOIxOo
    @OXOo.oOoXoXO
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final Map<String, String> getExtraDataFromIntent(@OXOo.oOoXoXO Intent intent) {
        return Companion.getExtraDataFromIntent(intent);
    }

    @XO0OX.x0XOIxOo
    @OXOo.OOXIXo
    public static LoginManager getInstance() {
        return Companion.getInstance();
    }

    private final boolean isExpressLoginAllowed() {
        return this.sharedPreferences.getBoolean(EXPRESS_LOGIN_ALLOWED, true);
    }

    @XO0OX.x0XOIxOo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean isPublishPermission(@OXOo.oOoXoXO String str) {
        return Companion.isPublishPermission(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logCompleteLogin(Context context, LoginClient.Result.Code code, Map<String, String> map, Exception exc, boolean z, LoginClient.Request request) {
        String str;
        String str2;
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger == null) {
            return;
        }
        if (request == null) {
            LoginLogger.logUnexpectedError$default(logger, LoginLogger.EVENT_NAME_LOGIN_COMPLETE, "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", null, 4, null);
            return;
        }
        HashMap hashMap = new HashMap();
        if (z) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put(LoginLogger.EVENT_EXTRAS_TRY_LOGIN_ACTIVITY, str);
        String authId = request.getAuthId();
        if (request.isFamilyLogin()) {
            str2 = LoginLogger.EVENT_NAME_FOA_LOGIN_COMPLETE;
        } else {
            str2 = LoginLogger.EVENT_NAME_LOGIN_COMPLETE;
        }
        logger.logCompleteLogin(authId, hashMap, code, map, exc, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logStartLogin(Context context, LoginClient.Request request) {
        String str;
        LoginLogger logger = LoginLoggerHolder.INSTANCE.getLogger(context);
        if (logger != null && request != null) {
            if (request.isFamilyLogin()) {
                str = LoginLogger.EVENT_NAME_FOA_LOGIN_START;
            } else {
                str = LoginLogger.EVENT_NAME_LOGIN_START;
            }
            logger.logStartLogin(request, str);
        }
    }

    private final void loginWithConfiguration(FragmentWrapper fragmentWrapper, LoginConfiguration loginConfiguration) {
        logIn(fragmentWrapper, loginConfiguration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean onActivityResult$default(LoginManager loginManager, int i, Intent intent, FacebookCallback facebookCallback, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                facebookCallback = null;
            }
            return loginManager.onActivityResult(i, intent, facebookCallback);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActivityResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerCallback$lambda-0, reason: not valid java name */
    public static final boolean m249registerCallback$lambda0(LoginManager this$0, FacebookCallback facebookCallback, int i, Intent intent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        return this$0.onActivityResult(i, intent, facebookCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean resolveIntent(Intent intent) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) == null) {
            return false;
        }
        return true;
    }

    private final void retrieveLoginStatusImpl(Context context, final LoginStatusCallback loginStatusCallback, long j) {
        Context context2;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        final String applicationId = FacebookSdk.getApplicationId();
        final String uuid = UUID.randomUUID().toString();
        IIX0o.oO(uuid, "randomUUID().toString()");
        if (context == null) {
            context2 = FacebookSdk.getApplicationContext();
        } else {
            context2 = context;
        }
        final LoginLogger loginLogger = new LoginLogger(context2, applicationId);
        if (!isExpressLoginAllowed()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
            return;
        }
        LoginStatusClient newInstance$facebook_common_release = LoginStatusClient.Companion.newInstance$facebook_common_release(context, applicationId, uuid, FacebookSdk.getGraphApiVersion(), j, null);
        newInstance$facebook_common_release.setCompletedListener(new PlatformServiceClient.CompletedListener() { // from class: com.facebook.login.x0XOIxOo
            @Override // com.facebook.internal.PlatformServiceClient.CompletedListener
            public final void completed(Bundle bundle) {
                LoginManager.m250retrieveLoginStatusImpl$lambda2(uuid, loginLogger, loginStatusCallback, applicationId, bundle);
            }
        });
        loginLogger.logLoginStatusStart(uuid);
        if (!newInstance$facebook_common_release.start()) {
            loginLogger.logLoginStatusFailure(uuid);
            loginStatusCallback.onFailure();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: retrieveLoginStatusImpl$lambda-2, reason: not valid java name */
    public static final void m250retrieveLoginStatusImpl$lambda2(String loggerRef, LoginLogger logger, LoginStatusCallback responseCallback, String applicationId, Bundle bundle) {
        String str;
        IIX0o.x0xO0oo(loggerRef, "$loggerRef");
        IIX0o.x0xO0oo(logger, "$logger");
        IIX0o.x0xO0oo(responseCallback, "$responseCallback");
        IIX0o.x0xO0oo(applicationId, "$applicationId");
        if (bundle != null) {
            String string = bundle.getString(NativeProtocol.STATUS_ERROR_TYPE);
            String string2 = bundle.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
            if (string != null) {
                Companion.handleLoginStatusError(string, string2, loggerRef, logger, responseCallback);
                return;
            }
            String string3 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
            Utility utility = Utility.INSTANCE;
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0L));
            ArrayList<String> stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
            String string4 = bundle.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
            String string5 = bundle.getString("graph_domain");
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0L));
            if (string4 != null && string4.length() != 0) {
                str = LoginMethodHandler.Companion.getUserIDFromSignedRequest(string4);
            } else {
                str = null;
            }
            String str2 = str;
            if (string3 != null && string3.length() != 0 && stringArrayList != null && !stringArrayList.isEmpty() && str2 != null && str2.length() != 0) {
                AccessToken accessToken = new AccessToken(string3, applicationId, str2, stringArrayList, null, null, null, bundleLongAsDate, null, bundleLongAsDate2, string5);
                AccessToken.Companion.setCurrentAccessToken(accessToken);
                Profile.Companion.fetchProfileForCurrentAccessToken();
                logger.logLoginStatusSuccess(loggerRef);
                responseCallback.onCompleted(accessToken);
                return;
            }
            logger.logLoginStatusFailure(loggerRef);
            responseCallback.onFailure();
            return;
        }
        logger.logLoginStatusFailure(loggerRef);
        responseCallback.onFailure();
    }

    private final void setExpressLoginStatus(boolean z) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(EXPRESS_LOGIN_ALLOWED, z);
        edit.apply();
    }

    private final void startLogin(StartActivityDelegate startActivityDelegate, LoginClient.Request request) throws FacebookException {
        logStartLogin(startActivityDelegate.getActivityContext(), request);
        CallbackManagerImpl.Companion.registerStaticCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.login.oO
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public final boolean onActivityResult(int i, Intent intent) {
                boolean m251startLogin$lambda1;
                m251startLogin$lambda1 = LoginManager.m251startLogin$lambda1(LoginManager.this, i, intent);
                return m251startLogin$lambda1;
            }
        });
        if (tryFacebookActivity(startActivityDelegate, request)) {
            return;
        }
        FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        logCompleteLogin(startActivityDelegate.getActivityContext(), LoginClient.Result.Code.ERROR, null, facebookException, false, request);
        throw facebookException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startLogin$lambda-1, reason: not valid java name */
    public static final boolean m251startLogin$lambda1(LoginManager this$0, int i, Intent intent) {
        IIX0o.x0xO0oo(this$0, "this$0");
        return onActivityResult$default(this$0, i, intent, null, 4, null);
    }

    private final boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, LoginClient.Request request) {
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (!resolveIntent(facebookActivityIntent)) {
            return false;
        }
        try {
            startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.Companion.getLoginRequestCode());
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    private final void validatePublishPermissions(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            if (!Companion.isPublishPermission(str)) {
                throw new FacebookException("Cannot pass a read permission (" + str + ") to a request for publish authorization");
            }
        }
    }

    private final void validateReadPermissions(Collection<String> collection) {
        if (collection == null) {
            return;
        }
        for (String str : collection) {
            if (Companion.isPublishPermission(str)) {
                throw new FacebookException("Cannot pass a publish or manage permission (" + str + ") to a request for read authorization");
            }
        }
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public final FacebookLoginActivityResultContract createLogInActivityResultContract() {
        return createLogInActivityResultContract$default(this, null, null, 3, null);
    }

    @OXOo.OOXIXo
    public LoginClient.Request createLoginRequest(@OXOo.oOoXoXO Collection<String> collection) {
        Set XxI0;
        LoginBehavior loginBehavior = this.loginBehavior;
        if (collection == null) {
            XxI0 = null;
        } else {
            XxI0 = CollectionsKt___CollectionsKt.XxI0(collection);
        }
        Set set = XxI0;
        DefaultAudience defaultAudience = this.defaultAudience;
        String str = this.authType;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        IIX0o.oO(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior, set, defaultAudience, str, applicationId, uuid, this.loginTargetApp, null, null, null, null, ScreenUtil.DEFAULT_HEIGHT, null);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    @OXOo.OOXIXo
    public LoginClient.Request createLoginRequestWithConfig(@OXOo.OOXIXo LoginConfiguration loginConfig) {
        String codeVerifier;
        IIX0o.x0xO0oo(loginConfig, "loginConfig");
        CodeChallengeMethod codeChallengeMethod = CodeChallengeMethod.S256;
        try {
            PKCEUtil pKCEUtil = PKCEUtil.INSTANCE;
            codeVerifier = PKCEUtil.generateCodeChallenge(loginConfig.getCodeVerifier(), codeChallengeMethod);
        } catch (FacebookException unused) {
            codeChallengeMethod = CodeChallengeMethod.PLAIN;
            codeVerifier = loginConfig.getCodeVerifier();
        }
        CodeChallengeMethod codeChallengeMethod2 = codeChallengeMethod;
        String str = codeVerifier;
        LoginBehavior loginBehavior = this.loginBehavior;
        Set XxI0 = CollectionsKt___CollectionsKt.XxI0(loginConfig.getPermissions());
        DefaultAudience defaultAudience = this.defaultAudience;
        String str2 = this.authType;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        IIX0o.oO(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior, XxI0, defaultAudience, str2, applicationId, uuid, this.loginTargetApp, loginConfig.getNonce(), loginConfig.getCodeVerifier(), str, codeChallengeMethod2);
        request.setRerequest(AccessToken.Companion.isCurrentAccessTokenActive());
        request.setMessengerPageId(this.messengerPageId);
        request.setResetMessengerState(this.resetMessengerState);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    @OXOo.OOXIXo
    public LoginClient.Request createReauthorizeRequest() {
        LoginBehavior loginBehavior = LoginBehavior.DIALOG_ONLY;
        HashSet hashSet = new HashSet();
        DefaultAudience defaultAudience = this.defaultAudience;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        IIX0o.oO(uuid, "randomUUID().toString()");
        LoginClient.Request request = new LoginClient.Request(loginBehavior, hashSet, defaultAudience, "reauthorize", applicationId, uuid, this.loginTargetApp, null, null, null, null, ScreenUtil.DEFAULT_HEIGHT, null);
        request.setFamilyLogin(this.isFamilyLogin);
        request.setShouldSkipAccountDeduplication(this.shouldSkipAccountDeduplication);
        return request;
    }

    @OXOo.OOXIXo
    public final String getAuthType() {
        return this.authType;
    }

    @OXOo.OOXIXo
    public final DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    @OXOo.OOXIXo
    public Intent getFacebookActivityIntent(@OXOo.OOXIXo LoginClient.Request request) {
        IIX0o.x0xO0oo(request, "request");
        Intent intent = new Intent();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtra(LoginFragment.REQUEST_KEY, bundle);
        return intent;
    }

    @OXOo.OOXIXo
    public final LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    @OXOo.OOXIXo
    public final LoginTargetApp getLoginTargetApp() {
        return this.loginTargetApp;
    }

    public final boolean getShouldSkipAccountDeduplication() {
        return this.shouldSkipAccountDeduplication;
    }

    public final boolean isFamilyLogin() {
        return this.isFamilyLogin;
    }

    public final void logIn(@OXOo.OOXIXo Fragment fragment, @OXOo.oOoXoXO Collection<String> collection) {
        IIX0o.x0xO0oo(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void logInWithConfiguration(@OXOo.OOXIXo Fragment fragment, @OXOo.OOXIXo LoginConfiguration loginConfig) {
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(loginConfig, "loginConfig");
        loginWithConfiguration(new FragmentWrapper(fragment), loginConfig);
    }

    @kotlin.OOXIXo(message = "")
    public final void logInWithPublishPermissions(@OXOo.OOXIXo Fragment fragment, @OXOo.OOXIXo Collection<String> permissions) {
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(permissions, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), permissions);
    }

    @kotlin.OOXIXo(message = "")
    public final void logInWithReadPermissions(@OXOo.OOXIXo Fragment fragment, @OXOo.OOXIXo Collection<String> permissions) {
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(permissions, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), permissions);
    }

    public void logOut() {
        AccessToken.Companion.setCurrentAccessToken(null);
        AuthenticationToken.Companion.setCurrentAuthenticationToken(null);
        Profile.Companion.setCurrentProfile(null);
        setExpressLoginStatus(false);
    }

    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 3)
    public final boolean onActivityResult(int i, @OXOo.oOoXoXO Intent intent) {
        return onActivityResult$default(this, i, intent, null, 4, null);
    }

    public final void reauthorizeDataAccess(@OXOo.OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "activity");
        startLogin(new ActivityStartActivityDelegate(activity), createReauthorizeRequest());
    }

    public final void registerCallback(@OXOo.oOoXoXO CallbackManager callbackManager, @OXOo.oOoXoXO final FacebookCallback<LoginResult> facebookCallback) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.login.ooOOo0oXI
                @Override // com.facebook.internal.CallbackManagerImpl.Callback
                public final boolean onActivityResult(int i, Intent intent) {
                    boolean m249registerCallback$lambda0;
                    m249registerCallback$lambda0 = LoginManager.m249registerCallback$lambda0(LoginManager.this, facebookCallback, i, intent);
                    return m249registerCallback$lambda0;
                }
            });
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    public final void resolveError(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo GraphResponse response) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(response, "response");
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(response));
    }

    public final void retrieveLoginStatus(@OXOo.OOXIXo Context context, @OXOo.OOXIXo LoginStatusCallback responseCallback) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(responseCallback, "responseCallback");
        retrieveLoginStatus(context, 5000L, responseCallback);
    }

    @OXOo.OOXIXo
    public final LoginManager setAuthType(@OXOo.OOXIXo String authType) {
        IIX0o.x0xO0oo(authType, "authType");
        this.authType = authType;
        return this;
    }

    @OXOo.OOXIXo
    public final LoginManager setDefaultAudience(@OXOo.OOXIXo DefaultAudience defaultAudience) {
        IIX0o.x0xO0oo(defaultAudience, "defaultAudience");
        this.defaultAudience = defaultAudience;
        return this;
    }

    @OXOo.OOXIXo
    public final LoginManager setFamilyLogin(boolean z) {
        this.isFamilyLogin = z;
        return this;
    }

    @OXOo.OOXIXo
    public final LoginManager setLoginBehavior(@OXOo.OOXIXo LoginBehavior loginBehavior) {
        IIX0o.x0xO0oo(loginBehavior, "loginBehavior");
        this.loginBehavior = loginBehavior;
        return this;
    }

    @OXOo.OOXIXo
    public final LoginManager setLoginTargetApp(@OXOo.OOXIXo LoginTargetApp targetApp) {
        IIX0o.x0xO0oo(targetApp, "targetApp");
        this.loginTargetApp = targetApp;
        return this;
    }

    @OXOo.OOXIXo
    public final LoginManager setMessengerPageId(@OXOo.oOoXoXO String str) {
        this.messengerPageId = str;
        return this;
    }

    @OXOo.OOXIXo
    public final LoginManager setResetMessengerState(boolean z) {
        this.resetMessengerState = z;
        return this;
    }

    @OXOo.OOXIXo
    public final LoginManager setShouldSkipAccountDeduplication(boolean z) {
        this.shouldSkipAccountDeduplication = z;
        return this;
    }

    public final void unregisterCallback(@OXOo.oOoXoXO CallbackManager callbackManager) {
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).unregisterCallback(CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
            return;
        }
        throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public final FacebookLoginActivityResultContract createLogInActivityResultContract(@OXOo.oOoXoXO CallbackManager callbackManager) {
        return createLogInActivityResultContract$default(this, callbackManager, null, 2, null);
    }

    public final void logIn(@OXOo.OOXIXo Fragment fragment, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logInWithPublishPermissions(@OXOo.OOXIXo Fragment fragment, @OXOo.OOXIXo CallbackManager callbackManager, @OXOo.OOXIXo Collection<String> permissions) {
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(callbackManager, "callbackManager");
        IIX0o.x0xO0oo(permissions, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithPublishPermissions(activity, callbackManager, permissions);
            return;
        }
        throw new FacebookException(IIX0o.XIxXXX0x0("Cannot obtain activity context on the fragment ", fragment));
    }

    public final void logInWithReadPermissions(@OXOo.OOXIXo Fragment fragment, @OXOo.OOXIXo CallbackManager callbackManager, @OXOo.OOXIXo Collection<String> permissions) {
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(callbackManager, "callbackManager");
        IIX0o.x0xO0oo(permissions, "permissions");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            logInWithReadPermissions(activity, callbackManager, permissions);
            return;
        }
        throw new FacebookException(IIX0o.XIxXXX0x0("Cannot obtain activity context on the fragment ", fragment));
    }

    public final void loginWithConfiguration(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo LoginConfiguration loginConfig) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(loginConfig, "loginConfig");
        logIn(activity, loginConfig);
    }

    @XO0OX.xoIox
    @VisibleForTesting(otherwise = 3)
    public boolean onActivityResult(int i, @OXOo.oOoXoXO Intent intent, @OXOo.oOoXoXO FacebookCallback<LoginResult> facebookCallback) {
        LoginClient.Result.Code code;
        AccessToken accessToken;
        AuthenticationToken authenticationToken;
        LoginClient.Request request;
        Map<String, String> map;
        boolean z;
        AuthenticationToken authenticationToken2;
        LoginClient.Result.Code code2 = LoginClient.Result.Code.ERROR;
        FacebookException facebookException = null;
        boolean z2 = false;
        if (intent != null) {
            intent.setExtrasClassLoader(LoginClient.Result.class.getClassLoader());
            LoginClient.Result result = (LoginClient.Result) intent.getParcelableExtra(LoginFragment.RESULT_KEY);
            if (result != null) {
                request = result.request;
                LoginClient.Result.Code code3 = result.code;
                if (i != -1) {
                    if (i != 0) {
                        accessToken = null;
                        authenticationToken2 = null;
                    } else {
                        accessToken = null;
                        authenticationToken2 = null;
                        z2 = true;
                    }
                } else if (code3 == LoginClient.Result.Code.SUCCESS) {
                    accessToken = result.token;
                    authenticationToken2 = result.authenticationToken;
                } else {
                    authenticationToken2 = null;
                    facebookException = new FacebookAuthorizationException(result.errorMessage);
                    accessToken = null;
                }
                map = result.loggingExtras;
                z = z2;
                authenticationToken = authenticationToken2;
                code = code3;
            }
            code = code2;
            accessToken = null;
            authenticationToken = null;
            request = null;
            map = null;
            z = false;
        } else {
            if (i == 0) {
                code = LoginClient.Result.Code.CANCEL;
                accessToken = null;
                authenticationToken = null;
                request = null;
                map = null;
                z = true;
            }
            code = code2;
            accessToken = null;
            authenticationToken = null;
            request = null;
            map = null;
            z = false;
        }
        if (facebookException == null && accessToken == null && !z) {
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        }
        FacebookException facebookException2 = facebookException;
        LoginClient.Request request2 = request;
        logCompleteLogin(null, code, map, facebookException2, true, request2);
        finishLogin(accessToken, authenticationToken, request2, facebookException2, z, facebookCallback);
        return true;
    }

    @kotlin.OOXIXo(message = "")
    public final void resolveError(@OXOo.OOXIXo Fragment fragment, @OXOo.OOXIXo GraphResponse response) {
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(response, "response");
        resolveError(new FragmentWrapper(fragment), response);
    }

    public final void retrieveLoginStatus(@OXOo.OOXIXo Context context, long j, @OXOo.OOXIXo LoginStatusCallback responseCallback) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(responseCallback, "responseCallback");
        retrieveLoginStatusImpl(context, responseCallback, j);
    }

    @OXOo.OOXIXo
    @XO0OX.xoIox
    public final FacebookLoginActivityResultContract createLogInActivityResultContract(@OXOo.oOoXoXO CallbackManager callbackManager, @OXOo.oOoXoXO String str) {
        return new FacebookLoginActivityResultContract(this, callbackManager, str);
    }

    public final void logIn(@OXOo.OOXIXo android.app.Fragment fragment, @OXOo.oOoXoXO Collection<String> collection) {
        IIX0o.x0xO0oo(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection);
    }

    public final void reauthorizeDataAccess(@OXOo.OOXIXo Fragment fragment) {
        IIX0o.x0xO0oo(fragment, "fragment");
        reauthorizeDataAccess(new FragmentWrapper(fragment));
    }

    public final void resolveError(@OXOo.OOXIXo Fragment fragment, @OXOo.OOXIXo CallbackManager callbackManager, @OXOo.OOXIXo GraphResponse response) {
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(callbackManager, "callbackManager");
        IIX0o.x0xO0oo(response, "response");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            resolveError(activity, callbackManager, response);
            return;
        }
        throw new FacebookException(IIX0o.XIxXXX0x0("Cannot obtain activity context on the fragment ", fragment));
    }

    private final void reauthorizeDataAccess(FragmentWrapper fragmentWrapper) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createReauthorizeRequest());
    }

    public final void logIn(@OXOo.OOXIXo android.app.Fragment fragment, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(fragment, "fragment");
        logIn(new FragmentWrapper(fragment), collection, str);
    }

    public final void logIn(@OXOo.OOXIXo FragmentWrapper fragment, @OXOo.oOoXoXO Collection<String> collection) {
        IIX0o.x0xO0oo(fragment, "fragment");
        logIn(fragment, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithPublishPermissions(@OXOo.OOXIXo android.app.Fragment fragment, @OXOo.OOXIXo Collection<String> permissions) {
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(permissions, "permissions");
        logInWithPublishPermissions(new FragmentWrapper(fragment), permissions);
    }

    public final void logInWithReadPermissions(@OXOo.OOXIXo android.app.Fragment fragment, @OXOo.OOXIXo Collection<String> permissions) {
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(permissions, "permissions");
        logInWithReadPermissions(new FragmentWrapper(fragment), permissions);
    }

    private final void logInWithPublishPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validatePublishPermissions(collection);
        loginWithConfiguration(fragmentWrapper, new LoginConfiguration(collection, null, 2, null));
    }

    private final void logInWithReadPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        validateReadPermissions(collection);
        logIn(fragmentWrapper, new LoginConfiguration(collection, null, 2, null));
    }

    public final void resolveError(@OXOo.OOXIXo android.app.Fragment fragment, @OXOo.OOXIXo GraphResponse response) {
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(response, "response");
        resolveError(new FragmentWrapper(fragment), response);
    }

    private final void resolveError(FragmentWrapper fragmentWrapper, GraphResponse graphResponse) {
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestFromResponse(graphResponse));
    }

    public final void logIn(@OXOo.OOXIXo FragmentWrapper fragment, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(fragment, "fragment");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, null, 2, null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new FragmentStartActivityDelegate(fragment), createLoginRequestWithConfig);
    }

    public final void resolveError(@OXOo.OOXIXo ActivityResultRegistryOwner activityResultRegistryOwner, @OXOo.OOXIXo CallbackManager callbackManager, @OXOo.OOXIXo GraphResponse response) {
        IIX0o.x0xO0oo(activityResultRegistryOwner, "activityResultRegistryOwner");
        IIX0o.x0xO0oo(callbackManager, "callbackManager");
        IIX0o.x0xO0oo(response, "response");
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestFromResponse(response));
    }

    public final void logInWithPublishPermissions(@OXOo.OOXIXo Activity activity, @OXOo.oOoXoXO Collection<String> collection) {
        IIX0o.x0xO0oo(activity, "activity");
        validatePublishPermissions(collection);
        loginWithConfiguration(activity, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithReadPermissions(@OXOo.OOXIXo Activity activity, @OXOo.oOoXoXO Collection<String> collection) {
        IIX0o.x0xO0oo(activity, "activity");
        validateReadPermissions(collection);
        logIn(activity, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logIn(@OXOo.OOXIXo Activity activity, @OXOo.oOoXoXO Collection<String> collection) {
        IIX0o.x0xO0oo(activity, "activity");
        logIn(activity, new LoginConfiguration(collection, null, 2, null));
    }

    public final void logInWithPublishPermissions(@OXOo.OOXIXo ActivityResultRegistryOwner activityResultRegistryOwner, @OXOo.OOXIXo CallbackManager callbackManager, @OXOo.OOXIXo Collection<String> permissions) {
        IIX0o.x0xO0oo(activityResultRegistryOwner, "activityResultRegistryOwner");
        IIX0o.x0xO0oo(callbackManager, "callbackManager");
        IIX0o.x0xO0oo(permissions, "permissions");
        validatePublishPermissions(permissions);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logInWithReadPermissions(@OXOo.OOXIXo ActivityResultRegistryOwner activityResultRegistryOwner, @OXOo.OOXIXo CallbackManager callbackManager, @OXOo.OOXIXo Collection<String> permissions) {
        IIX0o.x0xO0oo(activityResultRegistryOwner, "activityResultRegistryOwner");
        IIX0o.x0xO0oo(callbackManager, "callbackManager");
        IIX0o.x0xO0oo(permissions, "permissions");
        validateReadPermissions(permissions);
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }

    public final void logIn(@OXOo.OOXIXo FragmentWrapper fragment, @OXOo.OOXIXo LoginConfiguration loginConfig) {
        IIX0o.x0xO0oo(fragment, "fragment");
        IIX0o.x0xO0oo(loginConfig, "loginConfig");
        startLogin(new FragmentStartActivityDelegate(fragment), createLoginRequestWithConfig(loginConfig));
    }

    public final void logIn(@OXOo.OOXIXo Activity activity, @OXOo.OOXIXo LoginConfiguration loginConfig) {
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(loginConfig, "loginConfig");
        if (activity instanceof ActivityResultRegistryOwner) {
            Log.w(TAG, "You're calling logging in Facebook with an activity supports androidx activity result APIs. Please follow our document to upgrade to new APIs to avoid overriding onActivityResult().");
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig(loginConfig));
    }

    public final void logIn(@OXOo.OOXIXo Activity activity, @OXOo.oOoXoXO Collection<String> collection, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(activity, "activity");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(collection, null, 2, null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestWithConfig);
    }

    private final void logIn(ActivityResultRegistryOwner activityResultRegistryOwner, CallbackManager callbackManager, LoginConfiguration loginConfiguration) {
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestWithConfig(loginConfiguration));
    }

    public final void logIn(@OXOo.OOXIXo ActivityResultRegistryOwner activityResultRegistryOwner, @OXOo.OOXIXo CallbackManager callbackManager, @OXOo.OOXIXo Collection<String> permissions, @OXOo.oOoXoXO String str) {
        IIX0o.x0xO0oo(activityResultRegistryOwner, "activityResultRegistryOwner");
        IIX0o.x0xO0oo(callbackManager, "callbackManager");
        IIX0o.x0xO0oo(permissions, "permissions");
        LoginClient.Request createLoginRequestWithConfig = createLoginRequestWithConfig(new LoginConfiguration(permissions, null, 2, null));
        if (str != null) {
            createLoginRequestWithConfig.setAuthId(str);
        }
        startLogin(new AndroidxActivityResultRegistryOwnerStartActivityDelegate(activityResultRegistryOwner, callbackManager), createLoginRequestWithConfig);
    }

    public final void logIn(@OXOo.OOXIXo ActivityResultRegistryOwner activityResultRegistryOwner, @OXOo.OOXIXo CallbackManager callbackManager, @OXOo.OOXIXo Collection<String> permissions) {
        IIX0o.x0xO0oo(activityResultRegistryOwner, "activityResultRegistryOwner");
        IIX0o.x0xO0oo(callbackManager, "callbackManager");
        IIX0o.x0xO0oo(permissions, "permissions");
        logIn(activityResultRegistryOwner, callbackManager, new LoginConfiguration(permissions, null, 2, null));
    }
}
