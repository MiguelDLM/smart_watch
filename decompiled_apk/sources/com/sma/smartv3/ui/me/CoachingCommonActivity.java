package com.sma.smartv3.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.sma.smartv3.co_fit.R;

@kotlin.jvm.internal.XX({"SMAP\nCoachingCommonActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoachingCommonActivity.kt\ncom/sma/smartv3/ui/me/CoachingCommonActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n87#2,7:50\n94#2,3:58\n70#2,7:61\n97#2:68\n1#3:57\n*S KotlinDebug\n*F\n+ 1 CoachingCommonActivity.kt\ncom/sma/smartv3/ui/me/CoachingCommonActivity\n*L\n44#1:50,7\n44#1:58,3\n44#1:61,7\n44#1:68\n44#1:57\n*E\n"})
/* loaded from: classes11.dex */
public final class CoachingCommonActivity extends BaseActivity {
    private final void toActivity(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", str);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) CoachingCommonSetActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.exercise_course);
    }

    public final void l1Coaching(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        toActivity("L1");
    }

    public final void l2EasyCoaching(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        toActivity(IXxxXO.f23349II0xO0);
    }

    public final void l2MafCoaching(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        toActivity(IXxxXO.f23348I0Io);
    }

    public final void l3Coaching(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        toActivity(IXxxXO.f23351oxoX);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activiy_coaching_common_list;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
