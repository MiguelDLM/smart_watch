package com.bestmafen.androidbase.viewpager;

import OXOo.OOXIXo;
import android.app.Activity;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.List;

/* loaded from: classes8.dex */
public class BaseStatePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
    private CharSequence[] mTitles;

    public BaseStatePagerAdapter(oIX0oI oix0oi) {
        super(oix0oi.provideFragmentManager());
        this.mFragments = oix0oi.initFragments();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mFragments.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @OOXIXo
    public Fragment getItem(int i) {
        return this.mFragments.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public CharSequence getPageTitle(int i) {
        CharSequence[] charSequenceArr = this.mTitles;
        if (charSequenceArr != null && charSequenceArr.length > i) {
            return charSequenceArr[i];
        }
        return super.getPageTitle(i);
    }

    public BaseStatePagerAdapter(oIX0oI oix0oi, CharSequence[] charSequenceArr) {
        super(oix0oi.provideFragmentManager());
        this.mFragments = oix0oi.initFragments();
        this.mTitles = charSequenceArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseStatePagerAdapter(oIX0oI oix0oi, int i) {
        super(oix0oi.provideFragmentManager());
        if (oix0oi instanceof Activity) {
            this.mTitles = ((Activity) oix0oi).getResources().getStringArray(i);
        } else if (oix0oi instanceof Fragment) {
            this.mTitles = ((Fragment) oix0oi).getResources().getStringArray(i);
        } else {
            throw new IllegalArgumentException("provider must be an instance of Activity or Fragment");
        }
        this.mFragments = oix0oi.initFragments();
    }
}
