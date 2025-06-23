package com.sma.smartv3.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nPurchaseTipsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PurchaseTipsActivity.kt\ncom/sma/smartv3/ui/main/PurchaseTipsActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,44:1\n69#2,3:45\n72#2,5:49\n1#3:48\n*S KotlinDebug\n*F\n+ 1 PurchaseTipsActivity.kt\ncom/sma/smartv3/ui/main/PurchaseTipsActivity\n*L\n38#1:45,3\n38#1:49,5\n38#1:48\n*E\n"})
/* loaded from: classes12.dex */
public final class PurchaseTipsActivity extends BaseActivity {
    private final void toMain() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        x0xO0oo.II0xO0(x0xO0oo.f24563I0X0x0oIo, null, 2, null);
        finish();
    }

    public final void confirmClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        toMain();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_purchase_tip;
    }

    public final void noRemindClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Xo0.f24349oIX0oI.oIX0oI().put(XoI0Ixx0.f24472x0XOIxOo, false);
        toMain();
    }
}
