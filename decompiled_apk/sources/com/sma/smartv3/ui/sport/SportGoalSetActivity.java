package com.sma.smartv3.ui.sport;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bestmafen.androidbase.base.BaseFragment;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity;
import com.google.android.material.tabs.TabLayout;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.PFMedium;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

@kotlin.jvm.internal.XX({"SMAP\nSportGoalSetActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportGoalSetActivity.kt\ncom/sma/smartv3/ui/sport/SportGoalSetActivity\n+ 2 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,55:1\n80#2,9:56\n89#2,3:66\n75#2,3:69\n80#2,9:72\n89#2,3:82\n75#2,3:85\n80#2,9:88\n89#2,3:98\n75#2,3:101\n1#3:65\n1#3:81\n1#3:97\n*S KotlinDebug\n*F\n+ 1 SportGoalSetActivity.kt\ncom/sma/smartv3/ui/sport/SportGoalSetActivity\n*L\n26#1:56,9\n26#1:66,3\n26#1:69,3\n27#1:72,9\n27#1:82,3\n27#1:85,3\n28#1:88,9\n28#1:98,3\n28#1:101,3\n26#1:65\n27#1:81\n28#1:97\n*E\n"})
/* loaded from: classes12.dex */
public final class SportGoalSetActivity extends BaseFragmentPagerActivity {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO table$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.sport.SportGoalSetActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) SportGoalSetActivity.this.findViewById(R.id.table);
        }
    });

    private final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        BaseFragment.oIX0oI oix0oi = BaseFragment.Companion;
        int mArg1 = getMArg1();
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", mArg1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        BaseFragment baseFragment = (BaseFragment) SportGoalDistanceFragment.class.newInstance();
        baseFragment.setArguments(bundle);
        int mArg12 = getMArg1();
        Bundle bundle2 = new Bundle();
        bundle2.putString("mArg0", null);
        bundle2.putInt("mArg1", mArg12);
        bundle2.putParcelable("mArg2", null);
        bundle2.putSerializable("mArg3", null);
        BaseFragment baseFragment2 = (BaseFragment) SportGoalTimeFragment.class.newInstance();
        baseFragment2.setArguments(bundle2);
        int mArg13 = getMArg1();
        Bundle bundle3 = new Bundle();
        bundle3.putString("mArg0", null);
        bundle3.putInt("mArg1", mArg13);
        bundle3.putParcelable("mArg2", null);
        bundle3.putSerializable("mArg3", null);
        BaseFragment baseFragment3 = (BaseFragment) SportGoalCaloriesFragment.class.newInstance();
        baseFragment3.setArguments(bundle3);
        return CollectionsKt__CollectionsKt.X00IoxXI((SportGoalDistanceFragment) baseFragment, (SportGoalTimeFragment) baseFragment2, (SportGoalCaloriesFragment) baseFragment3);
    }

    @Override // com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        ((PFMedium) findViewById(R.id.abh_title_center)).setText(R.string.set_goals);
        getMFragmentPagerAdapter().setTitles(new String[]{getString(R.string.distance), getString(R.string.time), getString(R.string.calories)});
        getTable().setBackgroundColor(oIxOXo.oxoX.I0Io(this, R.color.view_page_tablayout_bg));
        getTable().setupWithViewPager(getMViewPager());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_sport_goal_set;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        finish();
    }
}
