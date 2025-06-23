package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.login.LoginClient;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public class LoginFragment extends Fragment {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    public static final String EXTRA_REQUEST = "request";

    @OXOo.OOXIXo
    private static final String NULL_CALLING_PKG_ERROR_MSG = "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.";

    @OXOo.OOXIXo
    public static final String REQUEST_KEY = "com.facebook.LoginFragment:Request";

    @OXOo.OOXIXo
    public static final String RESULT_KEY = "com.facebook.LoginFragment:Result";

    @OXOo.OOXIXo
    private static final String SAVED_LOGIN_CLIENT = "loginClient";

    @OXOo.OOXIXo
    private static final String TAG = "LoginFragment";

    @OXOo.oOoXoXO
    private String callingPackage;
    private ActivityResultLauncher<Intent> launcher;
    private LoginClient loginClient;
    private View progressBar;

    @OXOo.oOoXoXO
    private LoginClient.Request request;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    private final Oox.oOoXoXO<ActivityResult, oXIO0o0XI> getLoginMethodHandlerCallback(final FragmentActivity fragmentActivity) {
        return new Oox.oOoXoXO<ActivityResult, oXIO0o0XI>() { // from class: com.facebook.login.LoginFragment$getLoginMethodHandlerCallback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(ActivityResult activityResult) {
                invoke2(activityResult);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@OXOo.OOXIXo ActivityResult result) {
                IIX0o.x0xO0oo(result, "result");
                if (result.getResultCode() == -1) {
                    LoginFragment.this.getLoginClient().onActivityResult(LoginClient.Companion.getLoginRequestCode(), result.getResultCode(), result.getData());
                } else {
                    fragmentActivity.finish();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideSpinner() {
        View view = this.progressBar;
        if (view != null) {
            view.setVisibility(8);
            onSpinnerHidden();
        } else {
            IIX0o.XOxIOxOx("progressBar");
            throw null;
        }
    }

    private final void initializeCallingPackage(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity == null) {
            return;
        }
        this.callingPackage = callingActivity.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0, reason: not valid java name */
    public static final void m246onCreate$lambda0(LoginFragment this$0, LoginClient.Result outcome) {
        IIX0o.x0xO0oo(this$0, "this$0");
        IIX0o.x0xO0oo(outcome, "outcome");
        this$0.onLoginClientCompleted(outcome);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1, reason: not valid java name */
    public static final void m247onCreate$lambda1(Oox.oOoXoXO tmp0, ActivityResult activityResult) {
        IIX0o.x0xO0oo(tmp0, "$tmp0");
        tmp0.invoke(activityResult);
    }

    private final void onLoginClientCompleted(LoginClient.Result result) {
        int i;
        this.request = null;
        if (result.code == LoginClient.Result.Code.CANCEL) {
            i = 0;
        } else {
            i = -1;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESULT_KEY, result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        FragmentActivity activity = getActivity();
        if (isAdded() && activity != null) {
            activity.setResult(i, intent);
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSpinner() {
        View view = this.progressBar;
        if (view != null) {
            view.setVisibility(0);
            onSpinnerShown();
        } else {
            IIX0o.XOxIOxOx("progressBar");
            throw null;
        }
    }

    @OXOo.OOXIXo
    public LoginClient createLoginClient() {
        return new LoginClient(this);
    }

    @OXOo.OOXIXo
    public final ActivityResultLauncher<Intent> getLauncher() {
        ActivityResultLauncher<Intent> activityResultLauncher = this.launcher;
        if (activityResultLauncher != null) {
            return activityResultLauncher;
        }
        IIX0o.XOxIOxOx("launcher");
        throw null;
    }

    @LayoutRes
    public int getLayoutResId() {
        return com.facebook.common.R.layout.com_facebook_login_fragment;
    }

    @OXOo.OOXIXo
    public final LoginClient getLoginClient() {
        LoginClient loginClient = this.loginClient;
        if (loginClient != null) {
            return loginClient;
        }
        IIX0o.XOxIOxOx(SAVED_LOGIN_CLIENT);
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        getLoginClient().onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@OXOo.oOoXoXO Bundle bundle) {
        LoginClient loginClient;
        Bundle bundleExtra;
        super.onCreate(bundle);
        if (bundle == null) {
            loginClient = null;
        } else {
            loginClient = (LoginClient) bundle.getParcelable(SAVED_LOGIN_CLIENT);
        }
        if (loginClient != null) {
            loginClient.setFragment(this);
        } else {
            loginClient = createLoginClient();
        }
        this.loginClient = loginClient;
        getLoginClient().setOnCompletedListener(new LoginClient.OnCompletedListener() { // from class: com.facebook.login.xoIox
            @Override // com.facebook.login.LoginClient.OnCompletedListener
            public final void onCompleted(LoginClient.Result result) {
                LoginFragment.m246onCreate$lambda0(LoginFragment.this, result);
            }
        });
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        initializeCallingPackage(activity);
        Intent intent = activity.getIntent();
        if (intent != null && (bundleExtra = intent.getBundleExtra(REQUEST_KEY)) != null) {
            this.request = (LoginClient.Request) bundleExtra.getParcelable("request");
        }
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        final Oox.oOoXoXO<ActivityResult, oXIO0o0XI> loginMethodHandlerCallback = getLoginMethodHandlerCallback(activity);
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(startActivityForResult, new ActivityResultCallback() { // from class: com.facebook.login.OOXIXo
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                LoginFragment.m247onCreate$lambda1(Oox.oOoXoXO.this, (ActivityResult) obj);
            }
        });
        IIX0o.oO(registerForActivityResult, "registerForActivityResult(\n            ActivityResultContracts.StartActivityForResult(),\n            getLoginMethodHandlerCallback(activity))");
        this.launcher = registerForActivityResult;
    }

    @Override // androidx.fragment.app.Fragment
    @OXOo.oOoXoXO
    public View onCreateView(@OXOo.OOXIXo LayoutInflater inflater, @OXOo.oOoXoXO ViewGroup viewGroup, @OXOo.oOoXoXO Bundle bundle) {
        IIX0o.x0xO0oo(inflater, "inflater");
        View inflate = inflater.inflate(getLayoutResId(), viewGroup, false);
        View findViewById = inflate.findViewById(com.facebook.common.R.id.com_facebook_login_fragment_progress_bar);
        IIX0o.oO(findViewById, "view.findViewById<View>(R.id.com_facebook_login_fragment_progress_bar)");
        this.progressBar = findViewById;
        getLoginClient().setBackgroundProcessingListener(new LoginClient.BackgroundProcessingListener() { // from class: com.facebook.login.LoginFragment$onCreateView$1
            @Override // com.facebook.login.LoginClient.BackgroundProcessingListener
            public void onBackgroundProcessingStarted() {
                LoginFragment.this.showSpinner();
            }

            @Override // com.facebook.login.LoginClient.BackgroundProcessingListener
            public void onBackgroundProcessingStopped() {
                LoginFragment.this.hideSpinner();
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        getLoginClient().cancelCurrentHandler();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        View findViewById;
        super.onPause();
        View view = getView();
        if (view == null) {
            findViewById = null;
        } else {
            findViewById = view.findViewById(com.facebook.common.R.id.com_facebook_login_fragment_progress_bar);
        }
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.callingPackage == null) {
            Log.e(TAG, NULL_CALLING_PKG_ERROR_MSG);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        getLoginClient().startOrContinueAuth(this.request);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@OXOo.OOXIXo Bundle outState) {
        IIX0o.x0xO0oo(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVED_LOGIN_CLIENT, getLoginClient());
    }

    public void onSpinnerHidden() {
    }

    public void onSpinnerShown() {
    }
}
