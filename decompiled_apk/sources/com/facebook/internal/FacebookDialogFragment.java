package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookWebFallbackDialog;
import com.facebook.internal.WebDialog;
import java.util.Arrays;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes8.dex */
public final class FacebookDialogFragment extends DialogFragment {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    public static final String TAG = "FacebookDialogFragment";

    @OXOo.oOoXoXO
    private Dialog innerDialog;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initDialog$lambda-0, reason: not valid java name */
    public static final void m196initDialog$lambda0(FacebookDialogFragment this$0, Bundle bundle, FacebookException facebookException) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onCompleteWebDialog(bundle, facebookException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initDialog$lambda-1, reason: not valid java name */
    public static final void m197initDialog$lambda1(FacebookDialogFragment this$0, Bundle bundle, FacebookException facebookException) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onCompleteWebFallbackDialog(bundle);
    }

    private final void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        int i;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        Intent intent = activity.getIntent();
        IIX0o.oO(intent, "fragmentActivity.intent");
        Intent createProtocolResultIntent = NativeProtocol.createProtocolResultIntent(intent, bundle, facebookException);
        if (facebookException == null) {
            i = -1;
        } else {
            i = 0;
        }
        activity.setResult(i, createProtocolResultIntent);
        activity.finish();
    }

    private final void onCompleteWebFallbackDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }

    @OXOo.oOoXoXO
    public final Dialog getInnerDialog() {
        return this.innerDialog;
    }

    @VisibleForTesting
    public final void initDialog$facebook_common_release() {
        FragmentActivity activity;
        boolean z;
        WebDialog newInstance;
        String string;
        if (this.innerDialog != null || (activity = getActivity()) == null) {
            return;
        }
        Intent intent = activity.getIntent();
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        IIX0o.oO(intent, "intent");
        Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(intent);
        if (methodArgumentsFromIntent == null) {
            z = false;
        } else {
            z = methodArgumentsFromIntent.getBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, false);
        }
        String str = null;
        Bundle bundle = null;
        if (!z) {
            if (methodArgumentsFromIntent == null) {
                string = null;
            } else {
                string = methodArgumentsFromIntent.getString("action");
            }
            if (methodArgumentsFromIntent != null) {
                bundle = methodArgumentsFromIntent.getBundle(NativeProtocol.WEB_DIALOG_PARAMS);
            }
            Utility utility = Utility.INSTANCE;
            if (Utility.isNullOrEmpty(string)) {
                Utility.logd(TAG, "Cannot start a WebDialog with an empty/missing 'actionName'");
                activity.finish();
                return;
            } else if (string != null) {
                newInstance = new WebDialog.Builder(activity, string, bundle).setOnCompleteListener(new WebDialog.OnCompleteListener() { // from class: com.facebook.internal.II0xO0
                    @Override // com.facebook.internal.WebDialog.OnCompleteListener
                    public final void onComplete(Bundle bundle2, FacebookException facebookException) {
                        FacebookDialogFragment.m196initDialog$lambda0(FacebookDialogFragment.this, bundle2, facebookException);
                    }
                }).build();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        } else {
            if (methodArgumentsFromIntent != null) {
                str = methodArgumentsFromIntent.getString("url");
            }
            Utility utility2 = Utility.INSTANCE;
            if (Utility.isNullOrEmpty(str)) {
                Utility.logd(TAG, "Cannot start a fallback WebDialog with an empty/missing 'url'");
                activity.finish();
                return;
            }
            oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String format = String.format("fb%s://bridge/", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            IIX0o.oO(format, "java.lang.String.format(format, *args)");
            FacebookWebFallbackDialog.Companion companion = FacebookWebFallbackDialog.Companion;
            if (str != null) {
                newInstance = companion.newInstance(activity, str, format);
                newInstance.setOnCompleteListener(new WebDialog.OnCompleteListener() { // from class: com.facebook.internal.I0Io
                    @Override // com.facebook.internal.WebDialog.OnCompleteListener
                    public final void onComplete(Bundle bundle2, FacebookException facebookException) {
                        FacebookDialogFragment.m197initDialog$lambda1(FacebookDialogFragment.this, bundle2, facebookException);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }
        this.innerDialog = newInstance;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@OXOo.OOXIXo Configuration newConfig) {
        IIX0o.x0xO0oo(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if ((this.innerDialog instanceof WebDialog) && isResumed()) {
            Dialog dialog = this.innerDialog;
            if (dialog != null) {
                ((WebDialog) dialog).resize();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@OXOo.oOoXoXO Bundle bundle) {
        super.onCreate(bundle);
        initDialog$facebook_common_release();
    }

    @Override // androidx.fragment.app.DialogFragment
    @OXOo.OOXIXo
    public Dialog onCreateDialog(@OXOo.oOoXoXO Bundle bundle) {
        Dialog dialog = this.innerDialog;
        if (dialog == null) {
            onCompleteWebDialog(null, null);
            setShowsDialog(false);
            Dialog onCreateDialog = super.onCreateDialog(bundle);
            IIX0o.oO(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
            return onCreateDialog;
        }
        if (dialog != null) {
            return dialog;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = this.innerDialog;
        if (dialog instanceof WebDialog) {
            if (dialog != null) {
                ((WebDialog) dialog).resize();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
        }
    }

    public final void setInnerDialog(@OXOo.oOoXoXO Dialog dialog) {
        this.innerDialog = dialog;
    }
}
