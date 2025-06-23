package com.baidu.navisdk.ui.widget.nestedscroll.scrollableviewpager;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.viewpager.widget.ViewPager;
import com.baidu.navisdk.model.datastruct.p;
import com.baidu.navisdk.ui.widget.nestedscroll.OuterScrollView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class ScrollableViewPagerFrame implements IServiceManager {

    @NonNull
    private final Context mContext;
    private InnerViewPagerAdapter mPageAdapter;
    private ViewPager.OnPageChangeListener mPageChangeListener;
    private ScrollContentView mScrollContentView;

    @NonNull
    private final OuterScrollView mScrollView;
    private InnerViewPager mViewPager;
    private OnViewPagerListener mViewPagerListener;
    private final ArrayList<Object> mDataList = new ArrayList<>();
    private final Map<Class<?>, Object> mServices = new ArrayMap();

    /* loaded from: classes8.dex */
    public static abstract class OnViewPagerListener {
        public View createPage(Object obj, IServiceManager iServiceManager) {
            return null;
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i, Object obj) {
        }
    }

    public ScrollableViewPagerFrame(@NonNull Context context, @NonNull OuterScrollView outerScrollView) {
        this.mContext = context;
        this.mScrollView = outerScrollView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        this.mScrollContentView = new ScrollContentView(this.mContext);
        this.mScrollView.getContentLayout().addView(this.mScrollContentView);
        this.mPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.navisdk.ui.widget.nestedscroll.scrollableviewpager.ScrollableViewPagerFrame.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (ScrollableViewPagerFrame.this.mViewPagerListener != null) {
                    ScrollableViewPagerFrame.this.mViewPagerListener.onPageScrollStateChanged(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (ScrollableViewPagerFrame.this.mViewPagerListener != null) {
                    ScrollableViewPagerFrame.this.mViewPagerListener.onPageScrolled(i, f, i2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                Object obj;
                if (ScrollableViewPagerFrame.this.mViewPagerListener != null) {
                    if (i >= 0 && i < ScrollableViewPagerFrame.this.mDataList.size()) {
                        obj = ScrollableViewPagerFrame.this.mDataList.get(i);
                    } else {
                        obj = null;
                    }
                    ScrollableViewPagerFrame.this.mViewPagerListener.onPageSelected(i, obj);
                }
            }
        };
    }

    public void addContentView(View view, FrameLayout.LayoutParams layoutParams) {
        this.mScrollContentView.addContent(view, layoutParams);
    }

    public void addHeadView(View view, FrameLayout.LayoutParams layoutParams) {
        this.mScrollContentView.addHead(view, layoutParams);
    }

    public void addTailView(View view, FrameLayout.LayoutParams layoutParams) {
        this.mScrollContentView.addTail(view, layoutParams);
    }

    public void changeToPage(int i, boolean z) {
        InnerViewPager innerViewPager = this.mViewPager;
        if (innerViewPager != null) {
            innerViewPager.setCurrentItem(i, z);
        }
    }

    public void create() {
        register(ViewPageCallback.class, new ViewPageCallback() { // from class: com.baidu.navisdk.ui.widget.nestedscroll.scrollableviewpager.ScrollableViewPagerFrame.2
            @Override // com.baidu.navisdk.ui.widget.nestedscroll.scrollableviewpager.ViewPageCallback
            public View createPage(Object obj) {
                if (ScrollableViewPagerFrame.this.mViewPagerListener != null) {
                    return ScrollableViewPagerFrame.this.mViewPagerListener.createPage(obj, ScrollableViewPagerFrame.this);
                }
                return null;
            }
        });
        InnerViewPager innerViewPager = (InnerViewPager) this.mScrollContentView.findViewWithTag(InnerViewPager.TAG);
        this.mViewPager = innerViewPager;
        if (innerViewPager != null) {
            InnerViewPagerAdapter innerViewPagerAdapter = new InnerViewPagerAdapter(this.mContext, this);
            this.mPageAdapter = innerViewPagerAdapter;
            this.mViewPager.setAdapter(innerViewPagerAdapter);
            this.mViewPager.addOnPageChangeListener(this.mPageChangeListener);
        }
        this.mScrollView.setOverScrollMode(2);
    }

    public void destroy() {
        this.mServices.clear();
        InnerViewPager innerViewPager = this.mViewPager;
        if (innerViewPager != null) {
            innerViewPager.removeOnPageChangeListener(this.mPageChangeListener);
        }
    }

    public View getCurShowPage() {
        InnerViewPagerAdapter innerViewPagerAdapter = this.mPageAdapter;
        if (innerViewPagerAdapter != null) {
            return innerViewPagerAdapter.getCurPager();
        }
        return null;
    }

    @Override // com.baidu.navisdk.ui.widget.nestedscroll.scrollableviewpager.IServiceManager
    public <T> T getService(@NonNull Class<T> cls) {
        Object obj = this.mServices.get(cls);
        if (obj == null) {
            return null;
        }
        return cls.cast(obj);
    }

    public float getSpecialStatusPercent() {
        return this.mScrollView.getSpecialStatusPercent();
    }

    @Override // com.baidu.navisdk.ui.widget.nestedscroll.scrollableviewpager.IServiceManager
    public <T> void register(@NonNull Class<T> cls, @NonNull T t) {
        T cast = cls.cast(t);
        if (cast != null) {
            this.mServices.put(cls, cast);
        }
    }

    public void removeBlankViewClickListener() {
        this.mScrollView.removeBlankViewClickListener();
    }

    public void setBlankViewClickListener(View.OnClickListener onClickListener) {
        this.mScrollView.setBlankViewClickListener(onClickListener);
    }

    public void setBottomStatusContentHeight(int i) {
        this.mScrollView.setBottomStatusContentHeight(i);
    }

    public void setScrollAvailable(boolean z) {
        this.mScrollView.setScrollAvailable(z);
        InnerViewPager innerViewPager = this.mViewPager;
        if (innerViewPager != null) {
            innerViewPager.setScrollAvailable(z);
        }
    }

    public void setScrollChangeListener(OuterScrollView.OnScrollChangeListener onScrollChangeListener) {
        this.mScrollView.setScrollChangeListener(onScrollChangeListener);
    }

    public void setScrollViewBackground(int i) {
        this.mScrollView.setBackgroundColor(i);
    }

    public void setScrollViewTouchListener(OuterScrollView.OnScrollViewTouchListener onScrollViewTouchListener) {
        this.mScrollView.setScrollViewTouchListener(onScrollViewTouchListener);
    }

    public void setSpecialStatusContentHeight(int i) {
        this.mScrollView.setSpecialStatusContentHeight(i);
    }

    public void setSupport3Status(boolean z) {
        this.mScrollView.setSupport3Status(z);
    }

    public void setTopStatusContentHeight(int i) {
        ScrollContentView scrollContentView = this.mScrollContentView;
        if (scrollContentView != null) {
            scrollContentView.setHeight(i);
        }
        this.mScrollView.setTopStatusContentHeight(i);
    }

    public void setViewPagerListener(OnViewPagerListener onViewPagerListener) {
        this.mViewPagerListener = onViewPagerListener;
    }

    public void updateStatus(p pVar, boolean z) {
        this.mScrollView.updateStatus(pVar, z);
    }

    public void updateViewPager(List<?> list) {
        InnerViewPagerAdapter innerViewPagerAdapter = this.mPageAdapter;
        if (innerViewPagerAdapter != null) {
            innerViewPagerAdapter.setDataList(list);
        }
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        private boolean isSupport3Status;
        private int mBottomStatusContentHeight;
        private View mContentView;
        private FrameLayout.LayoutParams mContentViewLp;
        private final Context mContext;
        private View mHeadView;
        private FrameLayout.LayoutParams mHeadViewLp;
        private OuterScrollView.OnScrollChangeListener mScrollChangeListener;
        private final OuterScrollView mScrollView;
        private OuterScrollView.OnScrollViewTouchListener mScrollViewTouchListener;
        private int mSpecialStatusContentHeight;
        private View mTailView;
        private FrameLayout.LayoutParams mTailViewLp;
        private int mTopStatusContentHeight;
        private OnViewPagerListener mViewPagerListener;
        private boolean scrollAvailable;

        public Builder(Context context, OuterScrollView outerScrollView) {
            this.mContext = context;
            this.mScrollView = outerScrollView;
        }

        public Builder addContentView(View view, FrameLayout.LayoutParams layoutParams) {
            this.mContentView = view;
            this.mContentViewLp = layoutParams;
            return this;
        }

        public Builder addHeadView(View view, FrameLayout.LayoutParams layoutParams) {
            this.mHeadView = view;
            this.mHeadViewLp = layoutParams;
            return this;
        }

        public Builder addTailView(View view, FrameLayout.LayoutParams layoutParams) {
            this.mTailView = view;
            this.mTailViewLp = layoutParams;
            return this;
        }

        public ScrollableViewPagerFrame build() {
            ScrollableViewPagerFrame scrollableViewPagerFrame = new ScrollableViewPagerFrame(this.mContext, this.mScrollView);
            scrollableViewPagerFrame.init();
            return scrollableViewPagerFrame;
        }

        public ScrollableViewPagerFrame create() {
            ScrollableViewPagerFrame build = build();
            build.setScrollAvailable(this.scrollAvailable);
            build.setSupport3Status(this.isSupport3Status);
            build.setBottomStatusContentHeight(this.mBottomStatusContentHeight);
            build.setSpecialStatusContentHeight(this.mSpecialStatusContentHeight);
            build.setTopStatusContentHeight(this.mTopStatusContentHeight);
            build.setScrollChangeListener(this.mScrollChangeListener);
            build.setScrollViewTouchListener(this.mScrollViewTouchListener);
            build.setViewPagerListener(this.mViewPagerListener);
            build.addHeadView(this.mHeadView, this.mHeadViewLp);
            build.addContentView(this.mContentView, this.mContentViewLp);
            build.addTailView(this.mTailView, this.mTailViewLp);
            build.create();
            return build;
        }

        public Builder setBottomStatusContentHeight(int i) {
            this.mBottomStatusContentHeight = i;
            return this;
        }

        public Builder setScrollAvailable(boolean z) {
            this.scrollAvailable = z;
            return this;
        }

        public Builder setScrollChangeListener(OuterScrollView.OnScrollChangeListener onScrollChangeListener) {
            this.mScrollChangeListener = onScrollChangeListener;
            return this;
        }

        public Builder setScrollViewTouchListener(OuterScrollView.OnScrollViewTouchListener onScrollViewTouchListener) {
            this.mScrollViewTouchListener = onScrollViewTouchListener;
            return this;
        }

        public Builder setSpecialStatusContentHeight(int i) {
            this.mSpecialStatusContentHeight = i;
            return this;
        }

        public Builder setSupport3Status(boolean z) {
            this.isSupport3Status = z;
            return this;
        }

        public Builder setTopStatusContentHeight(int i) {
            this.mTopStatusContentHeight = i;
            return this;
        }

        public Builder setViewPagerListener(OnViewPagerListener onViewPagerListener) {
            this.mViewPagerListener = onViewPagerListener;
            return this;
        }

        public Builder addContentView(View view) {
            this.mContentView = view;
            return this;
        }

        public Builder addHeadView(View view) {
            this.mHeadView = view;
            return this;
        }

        public Builder addTailView(View view) {
            this.mTailView = view;
            return this;
        }
    }
}
