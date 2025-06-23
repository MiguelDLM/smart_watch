package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.CustomTab;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginTargetApp;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class CustomTabMainActivity extends Activity {

    @OXOo.oOoXoXO
    private BroadcastReceiver redirectReceiver;
    private boolean shouldCloseCustomTab = true;

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final String EXTRA_ACTION = IIX0o.XIxXXX0x0(CustomTabMainActivity.class.getSimpleName(), ".extra_action");

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final String EXTRA_PARAMS = IIX0o.XIxXXX0x0(CustomTabMainActivity.class.getSimpleName(), ".extra_params");

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final String EXTRA_CHROME_PACKAGE = IIX0o.XIxXXX0x0(CustomTabMainActivity.class.getSimpleName(), ".extra_chromePackage");

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final String EXTRA_URL = IIX0o.XIxXXX0x0(CustomTabMainActivity.class.getSimpleName(), ".extra_url");

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final String EXTRA_TARGET_APP = IIX0o.XIxXXX0x0(CustomTabMainActivity.class.getSimpleName(), ".extra_targetApp");

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final String REFRESH_ACTION = IIX0o.XIxXXX0x0(CustomTabMainActivity.class.getSimpleName(), ".action_refresh");

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final String NO_ACTIVITY_EXCEPTION = IIX0o.XIxXXX0x0(CustomTabMainActivity.class.getSimpleName(), ".no_activity_exception");

    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle parseResponseUri(String str) {
            Uri parse = Uri.parse(str);
            Utility utility = Utility.INSTANCE;
            Bundle parseUrlQueryString = Utility.parseUrlQueryString(parse.getQuery());
            parseUrlQueryString.putAll(Utility.parseUrlQueryString(parse.getFragment()));
            return parseUrlQueryString;
        }

        private Companion() {
        }
    }

    /* loaded from: classes8.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTargetApp.valuesCustom().length];
            iArr[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void sendResult(int i, Intent intent) {
        Bundle bundle;
        BroadcastReceiver broadcastReceiver = this.redirectReceiver;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra(EXTRA_URL);
            if (stringExtra != null) {
                bundle = Companion.parseResponseUri(stringExtra);
            } else {
                bundle = new Bundle();
            }
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            Intent intent2 = getIntent();
            IIX0o.oO(intent2, "intent");
            Intent createProtocolResultIntent = NativeProtocol.createProtocolResultIntent(intent2, bundle, null);
            if (createProtocolResultIntent != null) {
                intent = createProtocolResultIntent;
            }
            setResult(i, intent);
        } else {
            NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
            Intent intent3 = getIntent();
            IIX0o.oO(intent3, "intent");
            setResult(i, NativeProtocol.createProtocolResultIntent(intent3, null, null));
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@OXOo.oOoXoXO Bundle bundle) {
        String stringExtra;
        CustomTab customTab;
        super.onCreate(bundle);
        String str = CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION;
        if (IIX0o.Oxx0IOOO(str, getIntent().getAction())) {
            setResult(0);
            finish();
            return;
        }
        if (bundle != null || (stringExtra = getIntent().getStringExtra(EXTRA_ACTION)) == null) {
            return;
        }
        Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
        String stringExtra2 = getIntent().getStringExtra(EXTRA_CHROME_PACKAGE);
        if (WhenMappings.$EnumSwitchMapping$0[LoginTargetApp.Companion.fromString(getIntent().getStringExtra(EXTRA_TARGET_APP)).ordinal()] == 1) {
            customTab = new InstagramCustomTab(stringExtra, bundleExtra);
        } else {
            customTab = new CustomTab(stringExtra, bundleExtra);
        }
        boolean openCustomTab = customTab.openCustomTab(this, stringExtra2);
        this.shouldCloseCustomTab = false;
        if (!openCustomTab) {
            setResult(0, getIntent().putExtra(NO_ACTIVITY_EXCEPTION, true));
            finish();
        } else {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.facebook.CustomTabMainActivity$onCreate$redirectReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@OXOo.OOXIXo Context context, @OXOo.OOXIXo Intent intent) {
                    IIX0o.x0xO0oo(context, "context");
                    IIX0o.x0xO0oo(intent, "intent");
                    Intent intent2 = new Intent(CustomTabMainActivity.this, (Class<?>) CustomTabMainActivity.class);
                    intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
                    String str2 = CustomTabMainActivity.EXTRA_URL;
                    intent2.putExtra(str2, intent.getStringExtra(str2));
                    intent2.addFlags(603979776);
                    CustomTabMainActivity.this.startActivity(intent2);
                }
            };
            this.redirectReceiver = broadcastReceiver;
            LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, new IntentFilter(str));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(@OXOo.OOXIXo Intent intent) {
        IIX0o.x0xO0oo(intent, "intent");
        super.onNewIntent(intent);
        if (IIX0o.Oxx0IOOO(REFRESH_ACTION, intent.getAction())) {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
        } else if (IIX0o.Oxx0IOOO(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION, intent.getAction())) {
            sendResult(-1, intent);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, null);
        }
        this.shouldCloseCustomTab = true;
    }
}
