package com.sma.smartv3.ui.device.dial;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bestmafen.androidbase.base.BaseFragment;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.initializer.BleInitializer;

/* loaded from: classes12.dex */
public final class DialCustomizeFragment extends BaseFragment {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnBottom$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.device.dial.DialCustomizeFragment$btnBottom$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = DialCustomizeFragment.this.getMView();
            return mView.findViewById(R.id.btn_bottom);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tv_dial_customize_desc$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.device.dial.DialCustomizeFragment$tv_dial_customize_desc$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = DialCustomizeFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_dial_customize_desc);
        }
    });

    private final View getBtnBottom() {
        return (View) this.btnBottom$delegate.getValue();
    }

    private final TextView getTv_dial_customize_desc() {
        return (TextView) this.tv_dial_customize_desc$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(DialCustomizeFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (BleInitializer.f20700XO.xX0IIXIx0()) {
            ToastUtils.showLong(R.string.syncing);
            return;
        }
        ProductManager productManager = ProductManager.f20544oIX0oI;
        FragmentActivity requireActivity = this$0.requireActivity();
        kotlin.jvm.internal.IIX0o.oO(requireActivity, "requireActivity(...)");
        ProductManager.O0OoXI(productManager, requireActivity, null, 2, null);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void initView() {
        String language = Utils.getApp().getResources().getConfiguration().locale.getLanguage();
        if (ProjectManager.f19822oIX0oI.IO0XoXxO() && kotlin.jvm.internal.IIX0o.Oxx0IOOO(language, "ko")) {
            getTv_dial_customize_desc().setTextSize(28.0f);
            Drawable drawable = ContextCompat.getDrawable(getMActivity(), R.drawable.kfit_right_icon);
            if (drawable != null) {
                drawable.setBounds(0, 0, 0, 0);
            }
            getTv_dial_customize_desc().setCompoundDrawables(null, null, drawable, null);
        }
        getBtnBottom().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.dial.OooI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialCustomizeFragment.initView$lambda$0(DialCustomizeFragment.this, view);
            }
        });
        getBtnBottom().setFocusableInTouchMode(true);
        getBtnBottom().requestFocus();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_dial_customize;
    }
}
