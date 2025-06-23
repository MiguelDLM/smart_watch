package com.sma.smartv3.ui.me;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.LogUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.androidthirdpartylogin.google.GoogleFit;
import com.sma.smartv3.co_fit.R;

/* loaded from: classes11.dex */
public final class GoogleFitAuthActivity extends BaseActivity {
    private boolean isGoogleFitSyncBoolean;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO rootView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.GoogleFitAuthActivity$rootView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return GoogleFitAuthActivity.this.findViewById(R.id.root_view);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnRevoke$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.me.GoogleFitAuthActivity$btnRevoke$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            return GoogleFitAuthActivity.this.findViewById(R.id.btn_revoke);
        }
    });

    private final View getBtnRevoke() {
        return (View) this.btnRevoke$delegate.getValue();
    }

    private final View getRootView() {
        return (View) this.rootView$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final Intent getFitIntent(@OXOo.OOXIXo Context context) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(context, "context");
        PackageManager packageManager = context.getPackageManager();
        kotlin.jvm.internal.IIX0o.oO(packageManager, "getPackageManager(...)");
        try {
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage("com.google.android.apps.fitness");
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(launchIntentForPackage);
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(launchIntentForPackage);
            return launchIntentForPackage;
        } catch (Exception unused) {
            return new Intent();
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.authorize);
        View btnRevoke = getBtnRevoke();
        if (com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24459ooOOo0oXI)) {
            i = 0;
        } else {
            i = 8;
        }
        btnRevoke.setVisibility(i);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_google_fit_auth;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(TokenParser.SP);
        sb.append(i2);
        sb.append(TokenParser.SP);
        sb.append(intent);
        LogUtils.d(sb.toString());
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24459ooOOo0oXI, GoogleFit.f19698oIX0oI.OOXIXo(this, i, i2));
        this.isGoogleFitSyncBoolean = true;
        initView();
    }

    public final void onRevoke(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        GoogleFit.f19698oIX0oI.Oxx0xo(this);
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24459ooOOo0oXI, false);
        initView();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void toGoogleFit(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        if (xo0.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24459ooOOo0oXI)) {
            try {
                startActivity(getFitIntent(this));
                return;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }
        GoogleFit.f19698oIX0oI.xxIXOIIO(this);
        if (this.isGoogleFitSyncBoolean) {
            xo0.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24459ooOOo0oXI, true);
            initView();
        }
    }
}
