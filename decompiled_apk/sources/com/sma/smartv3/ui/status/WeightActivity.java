package com.sma.smartv3.ui.status;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity;
import com.google.android.material.tabs.TabLayout;
import com.sma.smartv3.app.ProjectManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.fragment.WeightHistoryFragment;
import com.sma.smartv3.ui.status.fragment.WeightMeasureFragment;
import com.sma.smartv3.ui.status.fragment.WeightRecordsFragment;
import com.sma.smartv3.view.NoScollViewPager;
import com.sma.smartv3.view.text.PFMedium;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class WeightActivity extends BaseFragmentPagerActivity {
    public WeightHistoryFragment weightHistoryFragment;
    public WeightMeasureFragment weightMeasureFragment;
    public WeightRecordsFragment weightRecordsFragment;

    @OXOo.OOXIXo
    private final X0IIOO table$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.status.WeightActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) WeightActivity.this.findViewById(R.id.table);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.WeightActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) WeightActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OXOo.OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.WeightActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) WeightActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    public final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    public final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    public final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final WeightHistoryFragment getWeightHistoryFragment() {
        WeightHistoryFragment weightHistoryFragment = this.weightHistoryFragment;
        if (weightHistoryFragment != null) {
            return weightHistoryFragment;
        }
        IIX0o.XOxIOxOx("weightHistoryFragment");
        return null;
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

    @OXOo.OOXIXo
    public final WeightRecordsFragment getWeightRecordsFragment() {
        WeightRecordsFragment weightRecordsFragment = this.weightRecordsFragment;
        if (weightRecordsFragment != null) {
            return weightRecordsFragment;
        }
        IIX0o.XOxIOxOx("weightRecordsFragment");
        return null;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
        initFragment();
    }

    public final void initFragment() {
        setWeightRecordsFragment(new WeightRecordsFragment());
        setWeightMeasureFragment(new WeightMeasureFragment());
        setWeightHistoryFragment(new WeightHistoryFragment());
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        return CollectionsKt__CollectionsKt.X00IoxXI(getWeightRecordsFragment(), getWeightMeasureFragment(), getWeightHistoryFragment());
    }

    @Override // com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        int i;
        super.initView();
        TabLayout table = getTable();
        if (ProjectManager.f19822oIX0oI.IOoo()) {
            i = 0;
        } else {
            i = 8;
        }
        table.setVisibility(i);
        findViewById(R.id.line).setVisibility(getTable().getVisibility());
        getTable().setBackgroundColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.view_page_tablayout_bg));
        getAbhTitleCenter().setText(setTitle());
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ic_share);
        getTable().setupWithViewPager(getMViewPager());
        TabLayout table2 = getTable();
        table2.setSelectedTabIndicatorHeight(0);
        TabLayout.Tab tabAt = table2.getTabAt(0);
        if (tabAt != null) {
            tabAt.setIcon(R.drawable.selector_weight_tab_record);
        }
        TabLayout.Tab tabAt2 = table2.getTabAt(1);
        if (tabAt2 != null) {
            tabAt2.setIcon(R.drawable.selector_weight_tab_measure);
        }
        TabLayout.Tab tabAt3 = table2.getTabAt(2);
        if (tabAt3 != null) {
            tabAt3.setIcon(R.drawable.selector_weight_tab_history);
        }
        ViewPager mViewPager = getMViewPager();
        IIX0o.x0XOIxOo(mViewPager, "null cannot be cast to non-null type com.sma.smartv3.view.NoScollViewPager");
        ((NoScollViewPager) mViewPager).setCanScoll(false);
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_status_weight;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public void onTitleRightClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (getWeightRecordsFragment().getUserVisibleHint()) {
            getWeightRecordsFragment().share();
        } else if (getWeightMeasureFragment().getUserVisibleHint()) {
            getWeightMeasureFragment().share();
        } else if (getWeightHistoryFragment().getUserVisibleHint()) {
            getWeightHistoryFragment().share();
        }
    }

    @OXOo.OOXIXo
    public final String setTitle() {
        String string = getString(R.string.weight);
        IIX0o.oO(string, "getString(...)");
        return string;
    }

    public final void setWeightHistoryFragment(@OXOo.OOXIXo WeightHistoryFragment weightHistoryFragment) {
        IIX0o.x0xO0oo(weightHistoryFragment, "<set-?>");
        this.weightHistoryFragment = weightHistoryFragment;
    }

    public final void setWeightMeasureFragment(@OXOo.OOXIXo WeightMeasureFragment weightMeasureFragment) {
        IIX0o.x0xO0oo(weightMeasureFragment, "<set-?>");
        this.weightMeasureFragment = weightMeasureFragment;
    }

    public final void setWeightRecordsFragment(@OXOo.OOXIXo WeightRecordsFragment weightRecordsFragment) {
        IIX0o.x0xO0oo(weightRecordsFragment, "<set-?>");
        this.weightRecordsFragment = weightRecordsFragment;
    }
}
