package com.sma.smartv3.ui.status;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.base.BaseFragment;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.fragment.WeightMeasureFragment;
import com.sma.smartv3.view.text.PFMedium;
import java.io.Serializable;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nWeightMeasureReportActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WeightMeasureReportActivity.kt\ncom/sma/smartv3/ui/status/WeightMeasureReportActivity\n+ 2 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n80#2,9:48\n89#2,3:58\n75#2,3:61\n1#3:57\n*S KotlinDebug\n*F\n+ 1 WeightMeasureReportActivity.kt\ncom/sma/smartv3/ui/status/WeightMeasureReportActivity\n*L\n33#1:48,9\n33#1:58,3\n33#1:61,3\n33#1:57\n*E\n"})
/* loaded from: classes12.dex */
public final class WeightMeasureReportActivity extends BaseActivity {

    @OXOo.OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.WeightMeasureReportActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) WeightMeasureReportActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.WeightMeasureReportActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) WeightMeasureReportActivity.this.findViewById(R.id.abh_title_right);
        }
    });
    public WeightMeasureFragment weightMeasureFragment;

    public final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    public final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final WeightMeasureFragment getWeightMeasureFragment() {
        WeightMeasureFragment weightMeasureFragment = this.weightMeasureFragment;
        if (weightMeasureFragment != null) {
            return weightMeasureFragment;
        }
        IIX0o.XOxIOxOx("weightMeasureFragment");
        return null;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        getAbhTitleCenter().setText(setTitle());
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ic_share);
        BaseFragment.oIX0oI oix0oi = BaseFragment.Companion;
        int mArg1 = getMArg1();
        Serializable mArg3 = getMArg3();
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", mArg1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", mArg3);
        BaseFragment baseFragment = (BaseFragment) WeightMeasureFragment.class.newInstance();
        baseFragment.setArguments(bundle);
        setWeightMeasureFragment((WeightMeasureFragment) baseFragment);
        getSupportFragmentManager().beginTransaction().add(R.id.content, getWeightMeasureFragment()).commit();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_weight_measure_report;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        getWeightMeasureFragment().share();
    }

    @OXOo.OOXIXo
    public final String setTitle() {
        String string = getString(R.string.measure_report);
        IIX0o.oO(string, "getString(...)");
        return string;
    }

    public final void setWeightMeasureFragment(@OXOo.OOXIXo WeightMeasureFragment weightMeasureFragment) {
        IIX0o.x0xO0oo(weightMeasureFragment, "<set-?>");
        this.weightMeasureFragment = weightMeasureFragment;
    }
}
