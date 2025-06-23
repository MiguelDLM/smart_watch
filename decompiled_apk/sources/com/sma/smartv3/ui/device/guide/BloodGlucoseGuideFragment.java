package com.sma.smartv3.ui.device.guide;

import OXOo.oOoXoXO;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bestmafen.androidbase.base.BaseFragment;
import com.github.appintro.SlideSelectionListener;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class BloodGlucoseGuideFragment extends BaseFragment implements SlideSelectionListener {
    private TextView tvNo;
    private TextView tvYes;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BloodGlucoseGuideFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24364IO0XoXxO, true);
        TextView textView = this$0.tvYes;
        TextView textView2 = null;
        if (textView == null) {
            IIX0o.XOxIOxOx("tvYes");
            textView = null;
        }
        textView.setBackgroundTintList(this$0.getResources().getColorStateList(R.color.colorAccent));
        TextView textView3 = this$0.tvNo;
        if (textView3 == null) {
            IIX0o.XOxIOxOx("tvNo");
        } else {
            textView2 = textView3;
        }
        textView2.setBackgroundTintList(this$0.getResources().getColorStateList(R.color.light));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(BloodGlucoseGuideFragment this$0, View view) {
        IIX0o.x0xO0oo(this$0, "this$0");
        Xo0.f24349oIX0oI.XO().put(XoI0Ixx0.f24364IO0XoXxO, false);
        TextView textView = this$0.tvYes;
        TextView textView2 = null;
        if (textView == null) {
            IIX0o.XOxIOxOx("tvYes");
            textView = null;
        }
        textView.setBackgroundTintList(this$0.getResources().getColorStateList(R.color.light));
        TextView textView3 = this$0.tvNo;
        if (textView3 == null) {
            IIX0o.XOxIOxOx("tvNo");
        } else {
            textView2 = textView3;
        }
        textView2.setBackgroundTintList(this$0.getResources().getColorStateList(R.color.colorAccent));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        View findViewById = getMView().findViewById(R.id.tv_yes);
        IIX0o.oO(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.tvYes = textView;
        TextView textView2 = null;
        if (textView == null) {
            IIX0o.XOxIOxOx("tvYes");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.guide.II0xO0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BloodGlucoseGuideFragment.initView$lambda$0(BloodGlucoseGuideFragment.this, view);
            }
        });
        View findViewById2 = getMView().findViewById(R.id.tv_no);
        IIX0o.oO(findViewById2, "findViewById(...)");
        TextView textView3 = (TextView) findViewById2;
        this.tvNo = textView3;
        if (textView3 == null) {
            IIX0o.XOxIOxOx("tvNo");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.device.guide.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BloodGlucoseGuideFragment.initView$lambda$1(BloodGlucoseGuideFragment.this, view);
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_app_guide_blood_glucose;
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideDeselected() {
    }

    @Override // com.github.appintro.SlideSelectionListener
    public void onSlideSelected() {
        boolean z = Xo0.f24349oIX0oI.XO().getBoolean(XoI0Ixx0.f24364IO0XoXxO, false);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI("BloodGlucoseGuideFragment onSlideSelected isFamilyHistory = " + z);
        TextView textView = null;
        if (z) {
            TextView textView2 = this.tvYes;
            if (textView2 == null) {
                IIX0o.XOxIOxOx("tvYes");
                textView2 = null;
            }
            textView2.setBackgroundTintList(getResources().getColorStateList(R.color.colorAccent));
            TextView textView3 = this.tvNo;
            if (textView3 == null) {
                IIX0o.XOxIOxOx("tvNo");
            } else {
                textView = textView3;
            }
            textView.setBackgroundTintList(getResources().getColorStateList(R.color.light));
            return;
        }
        TextView textView4 = this.tvYes;
        if (textView4 == null) {
            IIX0o.XOxIOxOx("tvYes");
            textView4 = null;
        }
        textView4.setBackgroundTintList(getResources().getColorStateList(R.color.light));
        TextView textView5 = this.tvNo;
        if (textView5 == null) {
            IIX0o.XOxIOxOx("tvNo");
        } else {
            textView = textView5;
        }
        textView.setBackgroundTintList(getResources().getColorStateList(R.color.colorAccent));
    }
}
