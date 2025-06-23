package com.sma.smartv3.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.co_fit.R;

@kotlin.jvm.internal.XX({"SMAP\nLanguageSettingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageSettingActivity.kt\ncom/sma/smartv3/ui/me/LanguageSettingActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,36:1\n87#2,7:37\n94#2,3:45\n70#2,7:48\n97#2:55\n87#2,7:56\n94#2,3:64\n70#2,7:67\n97#2:74\n1#3:44\n1#3:63\n*S KotlinDebug\n*F\n+ 1 LanguageSettingActivity.kt\ncom/sma/smartv3/ui/me/LanguageSettingActivity\n*L\n29#1:37,7\n29#1:45,3\n29#1:48,7\n29#1:55\n33#1:56,7\n33#1:64,3\n33#1:67,7\n33#1:74\n29#1:44\n33#1:63\n*E\n"})
/* loaded from: classes11.dex */
public final class LanguageSettingActivity extends BaseActivity {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.watch_language_set);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_language_set;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void repair(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", R.string.language_pack_repair);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) LanguageListActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public final void select(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", R.string.language_pack_select);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) LanguageListActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
