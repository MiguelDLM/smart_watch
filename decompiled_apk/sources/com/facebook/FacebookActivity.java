package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.logging.dumpsys.EndToEndDumper;
import com.facebook.login.LoginFragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public class FacebookActivity extends FragmentActivity {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    private static final String FRAGMENT_TAG = "SingleFragment";

    @OXOo.OOXIXo
    public static final String PASS_THROUGH_CANCEL_ACTION = "PassThrough";

    @OXOo.OOXIXo
    private static final String TAG;

    @OXOo.oOoXoXO
    private Fragment currentFragment;

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String name = FacebookActivity.class.getName();
        IIX0o.oO(name, "FacebookActivity::class.java.name");
        TAG = name;
    }

    private final void handlePassThroughError() {
        Intent requestIntent = getIntent();
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        IIX0o.oO(requestIntent, "requestIntent");
        FacebookException exceptionFromErrorData = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getMethodArgumentsFromIntent(requestIntent));
        Intent intent = getIntent();
        IIX0o.oO(intent, "intent");
        setResult(0, NativeProtocol.createProtocolResultIntent(intent, null, exceptionFromErrorData));
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void dump(@OXOo.OOXIXo String prefix, @OXOo.oOoXoXO FileDescriptor fileDescriptor, @OXOo.OOXIXo PrintWriter writer, @OXOo.oOoXoXO String[] strArr) {
        Boolean valueOf;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            IIX0o.x0xO0oo(prefix, "prefix");
            IIX0o.x0xO0oo(writer, "writer");
            EndToEndDumper companion = EndToEndDumper.Companion.getInstance();
            if (companion == null) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(companion.maybeDump(prefix, writer, strArr));
            }
            if (IIX0o.Oxx0IOOO(valueOf, Boolean.TRUE)) {
                return;
            }
            super.dump(prefix, fileDescriptor, writer, strArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @OXOo.oOoXoXO
    public final Fragment getCurrentFragment() {
        return this.currentFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.facebook.internal.FacebookDialogFragment, androidx.fragment.app.Fragment, androidx.fragment.app.DialogFragment] */
    @OXOo.OOXIXo
    public Fragment getFragment() {
        LoginFragment loginFragment;
        Intent intent = getIntent();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        IIX0o.oO(supportFragmentManager, "supportFragmentManager");
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (findFragmentByTag == null) {
            if (IIX0o.Oxx0IOOO(FacebookDialogFragment.TAG, intent.getAction())) {
                ?? facebookDialogFragment = new FacebookDialogFragment();
                facebookDialogFragment.setRetainInstance(true);
                facebookDialogFragment.show(supportFragmentManager, FRAGMENT_TAG);
                loginFragment = facebookDialogFragment;
            } else {
                LoginFragment loginFragment2 = new LoginFragment();
                loginFragment2.setRetainInstance(true);
                supportFragmentManager.beginTransaction().add(com.facebook.common.R.id.com_facebook_fragment_container, loginFragment2, FRAGMENT_TAG).commit();
                loginFragment = loginFragment2;
            }
            return loginFragment;
        }
        return findFragmentByTag;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@OXOo.OOXIXo Configuration newConfig) {
        IIX0o.x0xO0oo(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Fragment fragment = this.currentFragment;
        if (fragment != null) {
            fragment.onConfigurationChanged(newConfig);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@OXOo.oOoXoXO Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!FacebookSdk.isInitialized()) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, "Facebook SDK not initialized. Make sure you call sdkInitialize inside your Application's onCreate method.");
            Context applicationContext = getApplicationContext();
            IIX0o.oO(applicationContext, "applicationContext");
            FacebookSdk.sdkInitialize(applicationContext);
        }
        setContentView(com.facebook.common.R.layout.com_facebook_activity_layout);
        if (IIX0o.Oxx0IOOO(PASS_THROUGH_CANCEL_ACTION, intent.getAction())) {
            handlePassThroughError();
        } else {
            this.currentFragment = getFragment();
        }
    }
}
