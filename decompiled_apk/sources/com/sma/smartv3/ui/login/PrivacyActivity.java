package com.sma.smartv3.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CheckBox;
import androidx.core.content.ContextCompat;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.SpanUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.PFMedium;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nPrivacyActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PrivacyActivity.kt\ncom/sma/smartv3/ui/login/PrivacyActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n254#2:107\n69#3,3:108\n72#3,5:112\n1#4:111\n*S KotlinDebug\n*F\n+ 1 PrivacyActivity.kt\ncom/sma/smartv3/ui/login/PrivacyActivity\n*L\n81#1:107\n90#1:108,3\n90#1:112,5\n90#1:111\n*E\n"})
/* loaded from: classes12.dex */
public final class PrivacyActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final X0IIOO privacyContentTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.login.PrivacyActivity$privacyContentTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) PrivacyActivity.this.findViewById(R.id.privacyContentTv);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO privacyAppTv$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.login.PrivacyActivity$privacyAppTv$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) PrivacyActivity.this.findViewById(R.id.privacyAppTv);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO privacyAppCheck$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CheckBox>() { // from class: com.sma.smartv3.ui.login.PrivacyActivity$privacyAppCheck$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CheckBox invoke() {
            return (CheckBox) PrivacyActivity.this.findViewById(R.id.privacyAppCheck);
        }
    });

    /* loaded from: classes12.dex */
    public static final class oIX0oI extends ClickableSpan {
        public oIX0oI() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@OXOo.OOXIXo View widget) {
            IIX0o.x0xO0oo(widget, "widget");
            ProjectManager.f19822oIX0oI.OIxx0I0(PrivacyActivity.this.getMContext());
        }
    }

    private final CheckBox getPrivacyAppCheck() {
        return (CheckBox) this.privacyAppCheck$delegate.getValue();
    }

    private final PFMedium getPrivacyAppTv() {
        return (PFMedium) this.privacyAppTv$delegate.getValue();
    }

    private final PFMedium getPrivacyContentTv() {
        return (PFMedium) this.privacyContentTv$delegate.getValue();
    }

    public final void agreePrivacyClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        CheckBox privacyAppCheck = getPrivacyAppCheck();
        IIX0o.oO(privacyAppCheck, "<get-privacyAppCheck>(...)");
        if (privacyAppCheck.getVisibility() == 0 && !getPrivacyAppCheck().isChecked()) {
            ToastUtils.showLong(getString(R.string.privacy_tick_tip) + '[' + ((Object) getPrivacyAppTv().getText()) + ']', new Object[0]);
            return;
        }
        Xo0 xo0 = Xo0.f24349oIX0oI;
        xo0.oIX0oI().put(XoI0Ixx0.f24489xoIox, true);
        x0xO0oo.II0xO0(XoI0Ixx0.f24489xoIox, null, 2, null);
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.OXXoIoXI()) {
            startActivity(new Intent(this, (Class<?>) ServerSelectActivity.class));
        } else {
            xo0.XO().put(XoI0Ixx0.f24363IO, false);
            projectManager.x0oxIIIX(this);
        }
        finish();
    }

    public final void denyPrivacyClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        AppUtils.exitApp();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.BaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        ProjectManager projectManager = ProjectManager.f19822oIX0oI;
        if (projectManager.OXXoIoXI()) {
            i = R.string.privacy_content;
            i2 = R.string.privacy_agreement_reminder;
        } else {
            i = R.string.privacy_content_no_login;
            i2 = R.string.privacy_agreement_reminder_no_login;
        }
        getPrivacyContentTv().setText(getString(i, getString(R.string.app_name)));
        getPrivacyContentTv().setMovementMethod(new ScrollingMovementMethod());
        SpanUtils.with(getPrivacyAppTv()).append(getString(i2)).append(getString(R.string.privacy_agreement)).setForegroundColor(ContextCompat.getColor(getMContext(), R.color.colorAccent)).setClickSpan(new oIX0oI()).create();
        View findViewById = findViewById(R.id.bt_deny);
        if (projectManager.x00IOx()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        CheckBox privacyAppCheck = getPrivacyAppCheck();
        if (!projectManager.x00IOx()) {
            i4 = 8;
        }
        privacyAppCheck.setVisibility(i4);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_privacy;
    }

    @XO0.XO(tag = x0xO0oo.f24563I0X0x0oIo)
    public final void onEmailLoginDone(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        if (!isFinishing()) {
            finish();
        }
    }
}
