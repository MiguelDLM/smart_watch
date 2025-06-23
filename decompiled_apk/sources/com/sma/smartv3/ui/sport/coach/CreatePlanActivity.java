package com.sma.smartv3.ui.sport.coach;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.angcyo.dsladapter.LibExKt;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.device.guide.BaseAppGuideActivity;
import com.sma.smartv3.ui.me.WebViewActivity;
import com.sma.smartv3.ui.sport.coach.AICoachManage;
import com.sma.smartv3.ui.sport.coach.guide.PersonalActivityConfirmFragment;
import com.sma.smartv3.ui.sport.coach.guide.PersonalActivityFragment;
import com.sma.smartv3.ui.sport.coach.guide.PersonalInformationFragment;
import com.sma.smartv3.ui.sport.coach.guide.PlanChooseDaysFragment;
import com.sma.smartv3.ui.sport.coach.guide.PlanGoalFragment;
import com.sma.smartv3.ui.sport.coach.guide.PlanStartTimeFragment;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.PFMedium;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nCreatePlanActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreatePlanActivity.kt\ncom/sma/smartv3/ui/sport/coach/CreatePlanActivity\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,196:1\n87#2,7:197\n94#2,3:205\n70#2,7:208\n97#2:215\n140#2,5:216\n145#2,5:222\n1#3:204\n1#3:221\n86#4,2:227\n*S KotlinDebug\n*F\n+ 1 CreatePlanActivity.kt\ncom/sma/smartv3/ui/sport/coach/CreatePlanActivity\n*L\n81#1:197,7\n81#1:205,3\n81#1:208,7\n81#1:215\n106#1:216,5\n106#1:222,5\n81#1:204\n106#1:221\n117#1:227,2\n*E\n"})
/* loaded from: classes12.dex */
public final class CreatePlanActivity extends BaseAppGuideActivity {
    private final int CREATE_PLAN_DONE = 254;
    private final int layoutId = R.layout.activity_coach_create_plan;

    @OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.sport.coach.CreatePlanActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) CreatePlanActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.coach.CreatePlanActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) CreatePlanActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OOXIXo
    private final X0IIOO nextButton$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.sport.coach.CreatePlanActivity$nextButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) CreatePlanActivity.this.findViewById(R.id.next);
        }
    });

    @OOXIXo
    private final X0IIOO nextButtonClick$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.sport.coach.CreatePlanActivity$nextButtonClick$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) CreatePlanActivity.this.findViewById(R.id.next_custom_click);
        }
    });

    @OOXIXo
    private final X0IIOO doneButton$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.sport.coach.CreatePlanActivity$doneButton$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) CreatePlanActivity.this.findViewById(R.id.done);
        }
    });

    @OOXIXo
    private final X0IIOO mPagerView$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ViewPager>() { // from class: com.sma.smartv3.ui.sport.coach.CreatePlanActivity$mPagerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ViewPager invoke() {
            return (ViewPager) CreatePlanActivity.this.findViewById(R.id.view_pager);
        }
    });

    private final void initConfiguration() {
        setSkipButtonEnabled(false);
        setIndicatorEnabled(false);
        setWizardMode(true);
        showStatusBar(true);
        setSwipe(false);
        getAbhTitleCenter().setText(getString(R.string.personal_information));
        getNextButton().setText(getString(R.string.coach_create_plan_btn_next_step));
    }

    public final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    public final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    public final Button getDoneButton() {
        return (Button) this.doneButton$delegate.getValue();
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseAppGuideActivity, com.github.appintro.AppIntro, com.github.appintro.AppIntroBase
    public int getLayoutId() {
        return this.layoutId;
    }

    public final ViewPager getMPagerView() {
        return (ViewPager) this.mPagerView$delegate.getValue();
    }

    public final Button getNextButton() {
        return (Button) this.nextButton$delegate.getValue();
    }

    public final Button getNextButtonClick() {
        return (Button) this.nextButtonClick$delegate.getValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @kotlin.OOXIXo(message = "Deprecated in Java")
    public void onActivityResult(int i, int i2, @oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == this.CREATE_PLAN_DONE) {
            if (i2 == -1) {
                LogUtils.i("onActivityResult");
                SPUtils XO2 = Xo0.f24349oIX0oI.XO();
                AICoachManage.oIX0oI oix0oi = AICoachManage.f23905XO;
                XO2.put(XoI0Ixx0.f24387OIx00oxx + '_' + AICoachManage.VitalityData.class.getName(), new Gson().toJson(oix0oi.oIX0oI().oI0IIXIo()));
                x0xO0oo.II0xO0(x0xO0oo.f24647x0OIX00oO, null, 2, null);
                oix0oi.oIX0oI().IIXOooo();
                finish();
            }
            if (i2 == 9000) {
                getMPagerView().setCurrentItem(0);
            }
        }
    }

    @Override // com.sma.smartv3.ui.device.guide.BaseAppGuideActivity, com.github.appintro.AppIntroBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@oOoXoXO Bundle bundle) {
        super.onCreate(bundle);
        XO0.II0xO0.oxoX().x0XOIxOo(this);
        initConfiguration();
        if (getIntent().getIntExtra("type", 0) == 0) {
            addSlide(new PersonalInformationFragment());
            addSlide(new PersonalActivityFragment());
            addSlide(new PersonalActivityConfirmFragment());
        }
        addSlide(new PlanChooseDaysFragment());
        addSlide(new PlanStartTimeFragment());
        addSlide(new PlanGoalFragment());
        getNextButtonClick().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.coach.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ToastUtils.showLong(R.string.abh_choose_day_tip);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        XO0.II0xO0.oxoX().IIXOooo(this);
    }

    @Override // com.github.appintro.AppIntroBase
    public void onDonePressed(@oOoXoXO Fragment fragment) {
        super.onDonePressed(fragment);
        startActivityForResult(new Intent(this, (Class<?>) PlanConfirmActivity.class), this.CREATE_PLAN_DONE);
    }

    @XO0.XO(tag = x0xO0oo.f24590OIOoIIOIx)
    public final void onPlanChooseDayChanged(int i) {
        LogUtils.v("onBloodGlucoseChanged");
        if (i >= 3) {
            getNextButtonClick().setVisibility(8);
            getNextButton().setVisibility(0);
        } else {
            getNextButtonClick().setVisibility(0);
            getNextButton().setVisibility(8);
        }
    }

    @Override // com.github.appintro.AppIntroBase
    public void onSlideChanged(@oOoXoXO Fragment fragment, @oOoXoXO Fragment fragment2) {
        super.onSlideChanged(fragment, fragment2);
        LibExKt.oxxXoxO(getAbhTitleRight(), true);
        if (fragment2 instanceof PersonalInformationFragment) {
            getAbhTitleCenter().setText(getString(R.string.personal_information));
            getNextButton().setText(getString(R.string.coach_create_plan_btn_next_step));
            return;
        }
        if (fragment2 instanceof PersonalActivityFragment) {
            getAbhTitleCenter().setText(getString(R.string.coach_create_plan_aa_title));
            getNextButton().setText(getString(R.string.btn_start));
            LibExKt.x0OIX00oO(getAbhTitleRight(), true);
            getAbhTitleRight().setImageResource(R.drawable.plan_coach_ic_waring);
            return;
        }
        if (fragment2 instanceof PersonalActivityConfirmFragment) {
            getAbhTitleCenter().setText(getString(R.string.coach_create_plan_aa_title));
            getNextButton().setText(getString(R.string.next));
            return;
        }
        if (fragment2 instanceof PlanChooseDaysFragment) {
            getNextButtonClick().setText(getString(R.string.next));
            getNextButton().setText(getString(R.string.next));
            if (((PlanChooseDaysFragment) fragment2).getChoicesSize() >= 3) {
                getNextButtonClick().setVisibility(8);
                getNextButton().setVisibility(0);
            } else {
                getNextButtonClick().setVisibility(0);
                getNextButton().setVisibility(8);
            }
            getAbhTitleCenter().setText(getString(R.string.coach_create_plan_cd_title));
            return;
        }
        if (fragment2 instanceof PlanStartTimeFragment) {
            getAbhTitleCenter().setText(getString(R.string.coach_create_plan_st_title));
            getNextButton().setText(getString(R.string.next));
        } else if (fragment2 instanceof PlanGoalFragment) {
            getAbhTitleCenter().setText(getString(R.string.coach_create_plan_pg_title));
            getNextButton().setText(getString(R.string.got_it));
        }
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        onBackPressed();
    }

    public final void onTitleRightClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", "https://api.iot-solution.net/web/help/ai_coach_activity_assessment.html");
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this, (Class<?>) WebViewActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
