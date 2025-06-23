package com.bestmafen.androidbase.viewpager;

import OXOo.OOXIXo;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bestmafen.androidbase.R;
import com.bestmafen.androidbase.base.BaseActivity;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public abstract class BaseFragmentPagerActivity extends BaseActivity implements oIX0oI {
    protected BaseFragmentPagerAdapter mFragmentPagerAdapter;
    protected ViewPager mViewPager;

    @OOXIXo
    public final BaseFragmentPagerAdapter getMFragmentPagerAdapter() {
        BaseFragmentPagerAdapter baseFragmentPagerAdapter = this.mFragmentPagerAdapter;
        if (baseFragmentPagerAdapter != null) {
            return baseFragmentPagerAdapter;
        }
        IIX0o.XOxIOxOx("mFragmentPagerAdapter");
        return null;
    }

    @OOXIXo
    public final ViewPager getMViewPager() {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            return viewPager;
        }
        IIX0o.XOxIOxOx("mViewPager");
        return null;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @CallSuper
    public void initView() {
        View findViewById = findViewById(R.id.view_pager);
        IIX0o.oO(findViewById, "findViewById(...)");
        setMViewPager((ViewPager) findViewById);
        BaseFragmentPagerAdapter baseFragmentPagerAdapter = new BaseFragmentPagerAdapter(this);
        getMViewPager().setAdapter(baseFragmentPagerAdapter);
        getMViewPager().setOffscreenPageLimit(baseFragmentPagerAdapter.getCount());
        setMFragmentPagerAdapter(baseFragmentPagerAdapter);
    }

    @Override // com.bestmafen.androidbase.viewpager.oIX0oI
    @OOXIXo
    public FragmentManager provideFragmentManager() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        IIX0o.oO(supportFragmentManager, "getSupportFragmentManager(...)");
        return supportFragmentManager;
    }

    public final void setMFragmentPagerAdapter(@OOXIXo BaseFragmentPagerAdapter baseFragmentPagerAdapter) {
        IIX0o.x0xO0oo(baseFragmentPagerAdapter, "<set-?>");
        this.mFragmentPagerAdapter = baseFragmentPagerAdapter;
    }

    public final void setMViewPager(@OOXIXo ViewPager viewPager) {
        IIX0o.x0xO0oo(viewPager, "<set-?>");
        this.mViewPager = viewPager;
    }
}
