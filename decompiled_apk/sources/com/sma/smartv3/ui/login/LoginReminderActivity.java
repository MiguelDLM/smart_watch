package com.sma.smartv3.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.util.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nLoginReminderActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoginReminderActivity.kt\ncom/sma/smartv3/ui/login/LoginReminderActivity\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,44:1\n19#2:45\n15#2:46\n11#2,2:47\n*S KotlinDebug\n*F\n+ 1 LoginReminderActivity.kt\ncom/sma/smartv3/ui/login/LoginReminderActivity\n*L\n31#1:45\n31#1:46\n32#1:47,2\n*E\n"})
/* loaded from: classes12.dex */
public final class LoginReminderActivity extends BaseActivity {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.login_reminder);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_login_reminder;
    }

    public final void noLogin(@OXOo.OOXIXo View View) {
        IIX0o.x0xO0oo(View, "View");
        finish();
    }

    public final void onBottomClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Xo0 xo0 = Xo0.f24349oIX0oI;
        SPUtils XO2 = xo0.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        xo0.oxoX().put(AppUser.class.getName(), new Gson().toJson((AppUser) appUser));
        ProjectManager.f19822oIX0oI.OooO0XOx(getMContext());
        finish();
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
