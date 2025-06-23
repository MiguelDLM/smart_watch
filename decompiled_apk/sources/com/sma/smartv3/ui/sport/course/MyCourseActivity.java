package com.sma.smartv3.ui.sport.course;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.viewpager.BaseFragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.sma.smartv3.co_fit.R;
import java.util.List;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class MyCourseActivity extends BaseActivity implements com.bestmafen.androidbase.viewpager.oIX0oI {
    protected BaseFragmentPagerAdapter mFragmentPagerAdapter;
    protected ViewPager mViewPager;

    @OXOo.OOXIXo
    private final X0IIOO table$delegate = XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TabLayout>() { // from class: com.sma.smartv3.ui.sport.course.MyCourseActivity$table$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TabLayout invoke() {
            return (TabLayout) MyCourseActivity.this.findViewById(R.id.table);
        }
    });

    @OXOo.OOXIXo
    public final BaseFragmentPagerAdapter getMFragmentPagerAdapter() {
        BaseFragmentPagerAdapter baseFragmentPagerAdapter = this.mFragmentPagerAdapter;
        if (baseFragmentPagerAdapter != null) {
            return baseFragmentPagerAdapter;
        }
        IIX0o.XOxIOxOx("mFragmentPagerAdapter");
        return null;
    }

    @OXOo.OOXIXo
    public final ViewPager getMViewPager() {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            return viewPager;
        }
        IIX0o.XOxIOxOx("mViewPager");
        return null;
    }

    public final TabLayout getTable() {
        return (TabLayout) this.table$delegate.getValue();
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public List<Fragment> initFragments() {
        return CollectionsKt__CollectionsKt.X00IoxXI(new MyExerciseCourseFragment(), new MyCollectCourseFragment());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        TextView textView = (TextView) findViewById(R.id.abh_title_center);
        if (textView != null) {
            textView.setText("功能开发中..");
        }
        View findViewById = findViewById(R.id.view_pager);
        IIX0o.oO(findViewById, "findViewById(...)");
        setMViewPager((ViewPager) findViewById);
        BaseFragmentPagerAdapter baseFragmentPagerAdapter = new BaseFragmentPagerAdapter(this);
        getMViewPager().setAdapter(baseFragmentPagerAdapter);
        getMViewPager().setOffscreenPageLimit(baseFragmentPagerAdapter.getCount());
        setMFragmentPagerAdapter(baseFragmentPagerAdapter);
        getTable().setBackgroundColor(oIxOXo.oxoX.I0Io(getMContext(), R.color.view_page_tablayout_bg));
        getMFragmentPagerAdapter().setTitles(new String[]{"已锻炼", "已收藏"});
        getTable().setupWithViewPager(getMViewPager());
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_course_my;
    }

    public final void onTitleLeftClick(@OXOo.OOXIXo View view) {
        IIX0o.x0xO0oo(view, "view");
        finish();
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OXOo.OOXIXo
    public FragmentManager provideFragmentManager() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        IIX0o.oO(supportFragmentManager, "getSupportFragmentManager(...)");
        return supportFragmentManager;
    }

    public final void setMFragmentPagerAdapter(@OXOo.OOXIXo BaseFragmentPagerAdapter baseFragmentPagerAdapter) {
        IIX0o.x0xO0oo(baseFragmentPagerAdapter, "<set-?>");
        this.mFragmentPagerAdapter = baseFragmentPagerAdapter;
    }

    public final void setMViewPager(@OXOo.OOXIXo ViewPager viewPager) {
        IIX0o.x0xO0oo(viewPager, "<set-?>");
        this.mViewPager = viewPager;
    }
}
