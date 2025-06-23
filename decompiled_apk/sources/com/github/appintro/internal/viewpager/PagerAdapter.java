package com.github.appintro.internal.viewpager;

import OXOo.OOXIXo;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes9.dex */
public final class PagerAdapter extends FragmentPagerAdapter {

    @OOXIXo
    private final List<Fragment> fragments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerAdapter(@OOXIXo FragmentManager fragmentManager, @OOXIXo List<Fragment> fragments) {
        super(fragmentManager, 1);
        IIX0o.x0xO0oo(fragmentManager, "fragmentManager");
        IIX0o.x0xO0oo(fragments, "fragments");
        this.fragments = fragments;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.fragments.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @OOXIXo
    public Fragment getItem(int i) {
        return this.fragments.get(i);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    @OOXIXo
    public Object instantiateItem(@OOXIXo ViewGroup container, int i) {
        IIX0o.x0xO0oo(container, "container");
        Object instantiateItem = super.instantiateItem(container, i);
        IIX0o.oO(instantiateItem, "super.instantiateItem(container, position)");
        this.fragments.set(i, (Fragment) instantiateItem);
        return instantiateItem;
    }
}
