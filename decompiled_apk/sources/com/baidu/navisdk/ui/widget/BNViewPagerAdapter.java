package com.baidu.navisdk.ui.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.BNViewPagerAdapter.ViewHolder;
import com.baidu.navisdk.widget.photoview.PhotoView;
import java.util.LinkedList;

/* loaded from: classes8.dex */
public abstract class BNViewPagerAdapter<T extends ViewHolder> extends PagerAdapter {
    protected LinkedList<View> mCaches = new LinkedList<>();

    /* loaded from: classes8.dex */
    public static class ViewHolder {
        public View mItemView;
        public PhotoView mPhotoView;

        public ViewHolder(View view) {
            this.mItemView = view;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.mCaches.size() > 0) {
            this.mCaches.clear();
        }
        View view = (View) obj;
        viewGroup.removeView(view);
        this.mCaches.addLast(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View removeFirst;
        ViewHolder viewHolder;
        if (this.mCaches.size() == 0) {
            viewHolder = onCreateViewHolder();
            removeFirst = viewHolder.mItemView;
            removeFirst.setTag(R.id.nsdk_base_view_parger_convertView_tag, viewHolder);
        } else {
            removeFirst = this.mCaches.removeFirst();
            viewHolder = (ViewHolder) removeFirst.getTag(R.id.nsdk_base_view_parger_convertView_tag);
        }
        onBindView(viewHolder, i);
        viewGroup.addView(removeFirst);
        return removeFirst;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public abstract void onBindView(T t, int i);

    public abstract T onCreateViewHolder();
}
