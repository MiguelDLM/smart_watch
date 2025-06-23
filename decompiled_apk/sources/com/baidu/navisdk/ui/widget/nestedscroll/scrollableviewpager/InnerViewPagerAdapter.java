package com.baidu.navisdk.ui.widget.nestedscroll.scrollableviewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes8.dex */
public class InnerViewPagerAdapter extends PagerAdapter {
    private final ViewPageCallback mCallback;
    private final Context mContext;
    private View mCurPager;
    private final IServiceManager mServiceManager;
    private final ArrayList<Object> mDataList = new ArrayList<>();
    private final HashMap<Object, View> mCacheViews = new HashMap<>();

    public InnerViewPagerAdapter(@NonNull Context context, @NonNull IServiceManager iServiceManager) {
        this.mContext = context;
        this.mServiceManager = iServiceManager;
        this.mCallback = (ViewPageCallback) iServiceManager.getService(ViewPageCallback.class);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Object obj2;
        ArrayList arrayList = new ArrayList(this.mDataList);
        int size = arrayList.size();
        if (i >= 0 && i <= size - 1) {
            obj2 = arrayList.get(i);
        } else {
            obj2 = null;
        }
        if (obj instanceof IPageView) {
            ((IPageView) obj).postUnBindView(obj2, this.mServiceManager);
        }
        if (obj instanceof View) {
            View view = (View) obj;
            viewGroup.removeView(view);
            if (obj2 != null) {
                this.mCacheViews.put(obj2, view);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mDataList.size();
    }

    public View getCurPager() {
        return this.mCurPager;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return -2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        Object obj = this.mDataList.get(i);
        View view = this.mCacheViews.get(obj);
        View view2 = view;
        if (view == null) {
            View createPage = this.mCallback.createPage(obj);
            boolean z = createPage instanceof IPageView;
            view2 = createPage;
            if (z) {
                ((IPageView) createPage).pageInit(obj, this.mServiceManager);
                view2 = createPage;
            }
        }
        viewGroup.addView(view2, new ViewPager.LayoutParams());
        if (view2 instanceof IPageView) {
            ((IPageView) view2).postBindView(obj, this.mServiceManager);
        }
        return view2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void setDataList(List<?> list) {
        this.mDataList.clear();
        this.mCacheViews.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        this.mCurPager = (View) obj;
    }
}
