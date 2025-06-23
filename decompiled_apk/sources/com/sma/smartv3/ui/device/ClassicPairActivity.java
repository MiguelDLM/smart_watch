package com.sma.smartv3.ui.device;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.device.guide.ClassicPairGuide2Fragment;
import com.szabh.smable3.component.BleConnector;

@kotlin.jvm.internal.XX({"SMAP\nClassicPairActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassicPairActivity.kt\ncom/sma/smartv3/ui/device/ClassicPairActivity\n+ 2 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n*L\n1#1,36:1\n74#2,4:37\n*S KotlinDebug\n*F\n+ 1 ClassicPairActivity.kt\ncom/sma/smartv3/ui/device/ClassicPairActivity\n*L\n24#1:37,4\n*E\n"})
/* loaded from: classes12.dex */
public final class ClassicPairActivity extends BaseActivity {
    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        BaseFragment.oIX0oI oix0oi = BaseFragment.Companion;
        BaseFragment baseFragment = (BaseFragment) ClassicPairGuide2Fragment.class.newInstance();
        baseFragment.setArguments(null);
        beginTransaction.add(R.id.content, (ClassicPairGuide2Fragment) baseFragment).commit();
        if (BleConnector.INSTANCE.isBoundClassic()) {
            ToastUtils.showLong("3.0 " + getString(R.string.bind_success), new Object[0]);
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_classic_pair;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
