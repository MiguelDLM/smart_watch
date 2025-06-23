package com.sma.smartv3.ui.sport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.me.PermissionSettingsActivity;

@kotlin.jvm.internal.XX({"SMAP\nSportSettingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportSettingActivity.kt\ncom/sma/smartv3/ui/sport/SportSettingActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,42:1\n69#2,3:43\n72#2,5:47\n1#3:46\n*S KotlinDebug\n*F\n+ 1 SportSettingActivity.kt\ncom/sma/smartv3/ui/sport/SportSettingActivity\n*L\n40#1:43,3\n40#1:47,5\n40#1:46\n*E\n"})
/* loaded from: classes12.dex */
public final class SportSettingActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO screenAlwaysOnCB$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<AppCompatCheckBox>() { // from class: com.sma.smartv3.ui.sport.SportSettingActivity$screenAlwaysOnCB$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final AppCompatCheckBox invoke() {
            return (AppCompatCheckBox) SportSettingActivity.this.findViewById(R.id.screenAlwaysOnCB);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(CompoundButton compoundButton, boolean z) {
        com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().put(com.sma.smartv3.util.XoI0Ixx0.f24388OO, z);
        com.sma.smartv3.util.x0xO0oo.II0xO0(com.sma.smartv3.util.XoI0Ixx0.f24388OO, null, 2, null);
    }

    public final AppCompatCheckBox getScreenAlwaysOnCB() {
        return (AppCompatCheckBox) this.screenAlwaysOnCB$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.settings);
        getScreenAlwaysOnCB().setChecked(com.sma.smartv3.util.Xo0.f24349oIX0oI.XO().getBoolean(com.sma.smartv3.util.XoI0Ixx0.f24388OO));
        getScreenAlwaysOnCB().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sma.smartv3.ui.sport.x0xO
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SportSettingActivity.initView$lambda$0(compoundButton, z);
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_sport_setting;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void sportPermissionSetClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) PermissionSettingsActivity.class));
    }
}
