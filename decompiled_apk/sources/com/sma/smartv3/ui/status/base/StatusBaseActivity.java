package com.sma.smartv3.ui.status.base;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity;
import com.google.android.material.tabs.TabLayout;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.view.text.PFMedium;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import oIxOXo.oxoX;

/* loaded from: classes12.dex */
public abstract class StatusBaseActivity extends BaseFragmentPagerActivity {
    public BaseStatusFragment dayFragment;
    public BaseStatusFragment monthFragment;
    public BaseStatusFragment weeFragment;

    @OOXIXo
    private final X0IIOO table$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.status.base.StatusBaseActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) StatusBaseActivity.this.findViewById(R.id.table);
        }
    });

    @OOXIXo
    private final X0IIOO abhTitleCenter$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<PFMedium>() { // from class: com.sma.smartv3.ui.status.base.StatusBaseActivity$abhTitleCenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final PFMedium invoke() {
            return (PFMedium) StatusBaseActivity.this.findViewById(R.id.abh_title_center);
        }
    });

    @OOXIXo
    private final X0IIOO abhTitleRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.base.StatusBaseActivity$abhTitleRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) StatusBaseActivity.this.findViewById(R.id.abh_title_right);
        }
    });

    @OOXIXo
    private final X0IIOO abhTitleOtherRight$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.status.base.StatusBaseActivity$abhTitleOtherRight$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            return (ImageView) StatusBaseActivity.this.findViewById(R.id.abh_title_other_right);
        }
    });

    public final PFMedium getAbhTitleCenter() {
        return (PFMedium) this.abhTitleCenter$delegate.getValue();
    }

    public final ImageView getAbhTitleOtherRight() {
        return (ImageView) this.abhTitleOtherRight$delegate.getValue();
    }

    public final ImageView getAbhTitleRight() {
        return (ImageView) this.abhTitleRight$delegate.getValue();
    }

    @OOXIXo
    public final BaseStatusFragment getDayFragment() {
        BaseStatusFragment baseStatusFragment = this.dayFragment;
        if (baseStatusFragment != null) {
            return baseStatusFragment;
        }
        IIX0o.XOxIOxOx("dayFragment");
        return null;
    }

    @OOXIXo
    public final BaseStatusFragment getMonthFragment() {
        BaseStatusFragment baseStatusFragment = this.monthFragment;
        if (baseStatusFragment != null) {
            return baseStatusFragment;
        }
        IIX0o.XOxIOxOx("monthFragment");
        return null;
    }

    public final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    @OOXIXo
    public final BaseStatusFragment getWeeFragment() {
        BaseStatusFragment baseStatusFragment = this.weeFragment;
        if (baseStatusFragment != null) {
            return baseStatusFragment;
        }
        IIX0o.XOxIOxOx("weeFragment");
        return null;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
        initFragment();
    }

    public abstract void initFragment();

    @OOXIXo
    public List<Fragment> initFragments() {
        getAbhTitleOtherRight().setVisibility(0);
        getAbhTitleOtherRight().setImageResource(R.drawable.icon_calendar_normal);
        return CollectionsKt__CollectionsKt.X00IoxXI(getDayFragment(), getWeeFragment(), getMonthFragment());
    }

    @Override // com.bestmafen.androidbase.viewpager.BaseFragmentPagerActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getTable().setBackgroundColor(oxoX.I0Io(getMContext(), R.color.view_page_tablayout_bg));
        getMFragmentPagerAdapter().setTitles(new String[]{getString(R.string.day), getString(R.string.week), getString(R.string.month)});
        getAbhTitleCenter().setText(setTitle());
        getAbhTitleRight().setVisibility(0);
        getAbhTitleRight().setImageResource(R.drawable.ic_share);
        getTable().setupWithViewPager(getMViewPager());
    }

    public int layoutId() {
        return R.layout.activity_status_info;
    }

    public final void onTitleLeftClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    public void onTitleRightClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (this.dayFragment != null && getDayFragment().getUserVisibleHint()) {
            getDayFragment().share();
            return;
        }
        if (this.weeFragment != null && getWeeFragment().getUserVisibleHint()) {
            getWeeFragment().share();
        } else if (this.monthFragment != null && getMonthFragment().getUserVisibleHint()) {
            getMonthFragment().share();
        }
    }

    public void onTitleRightOtherClick(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        if (getDayFragment().getUserVisibleHint()) {
            getDayFragment().showCalendarPopop();
        } else if (getWeeFragment().getUserVisibleHint()) {
            getWeeFragment().showCalendarPopop();
        } else if (getMonthFragment().getUserVisibleHint()) {
            getMonthFragment().showCalendarPopop();
        }
    }

    public final void setDayFragment(@OOXIXo BaseStatusFragment baseStatusFragment) {
        IIX0o.x0xO0oo(baseStatusFragment, "<set-?>");
        this.dayFragment = baseStatusFragment;
    }

    public final void setMonthFragment(@OOXIXo BaseStatusFragment baseStatusFragment) {
        IIX0o.x0xO0oo(baseStatusFragment, "<set-?>");
        this.monthFragment = baseStatusFragment;
    }

    @OOXIXo
    public abstract String setTitle();

    public final void setWeeFragment(@OOXIXo BaseStatusFragment baseStatusFragment) {
        IIX0o.x0xO0oo(baseStatusFragment, "<set-?>");
        this.weeFragment = baseStatusFragment;
    }
}
