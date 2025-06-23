package com.sma.smartv3.ui.status.bg;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.base.BaseFragment;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.fragment.BloodGlucose2MonthFragment;
import java.io.Serializable;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import oIxOXo.oxoX;

@XX({"SMAP\nBloodGlucoseTrendActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BloodGlucoseTrendActivity.kt\ncom/sma/smartv3/ui/status/bg/BloodGlucoseTrendActivity\n+ 2 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n*L\n1#1,45:1\n80#2,9:46\n89#2,3:56\n75#2,3:59\n1#3:55\n1#3:65\n69#4,3:62\n72#4,5:66\n*S KotlinDebug\n*F\n+ 1 BloodGlucoseTrendActivity.kt\ncom/sma/smartv3/ui/status/bg/BloodGlucoseTrendActivity\n*L\n34#1:46,9\n34#1:56,3\n34#1:59,3\n34#1:55\n43#1:65\n43#1:62,3\n43#1:66,5\n*E\n"})
/* loaded from: classes12.dex */
public final class BloodGlucoseTrendActivity extends BaseActivity {

    @OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.bg.BloodGlucoseTrendActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) BloodGlucoseTrendActivity.this.findViewById(R.id.abh_title_right);
        }
    });
    private BloodGlucose2MonthFragment bloodGlucose2MonthFragment;

    private final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        ((TextView) findViewById(R.id.abh_title_center)).setText(R.string.blood_glucose_trend);
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ic_blood_glucose_record);
        getAbhTitleRight().setImageTintList(oxoX.X0o0xo(this, R.color.text_color));
        BaseFragment.oIX0oI oix0oi = BaseFragment.Companion;
        int mArg1 = getMArg1();
        Serializable mArg3 = getMArg3();
        Bundle bundle = new Bundle();
        BloodGlucose2MonthFragment bloodGlucose2MonthFragment = null;
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", mArg1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", mArg3);
        BaseFragment baseFragment = (BaseFragment) BloodGlucose2MonthFragment.class.newInstance();
        baseFragment.setArguments(bundle);
        this.bloodGlucose2MonthFragment = (BloodGlucose2MonthFragment) baseFragment;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        BloodGlucose2MonthFragment bloodGlucose2MonthFragment2 = this.bloodGlucose2MonthFragment;
        if (bloodGlucose2MonthFragment2 == null) {
            IIX0o.XOxIOxOx("bloodGlucose2MonthFragment");
        } else {
            bloodGlucose2MonthFragment = bloodGlucose2MonthFragment2;
        }
        beginTransaction.add(R.id.content, bloodGlucose2MonthFragment).commit();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_blood_glucose_trend;
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public final void onTitleRightClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        startActivity(new Intent(this, (Class<?>) BloodGlucoseRecordActivity.class));
    }

    @OOXIXo
    public final String setTitle() {
        String string = getString(R.string.blood_glucose);
        IIX0o.oO(string, "getString(...)");
        return string;
    }
}
