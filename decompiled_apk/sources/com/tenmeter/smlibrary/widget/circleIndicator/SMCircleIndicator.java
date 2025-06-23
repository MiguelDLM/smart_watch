package com.tenmeter.smlibrary.widget.circleIndicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tenmeter.smlibrary.widget.circleIndicator.BaseCircleIndicator;

/* loaded from: classes13.dex */
public class SMCircleIndicator extends BaseCircleIndicator {
    private final DataSetObserver mInternalDataSetObserver;
    private final ViewPager.OnPageChangeListener mInternalPageChangeListener;
    private ViewPager mViewpager;

    public SMCircleIndicator(Context context) {
        super(context);
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.tenmeter.smlibrary.widget.circleIndicator.SMCircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (SMCircleIndicator.this.mViewpager.getAdapter() != null && SMCircleIndicator.this.mViewpager.getAdapter().getCount() > 0) {
                    SMCircleIndicator.this.animatePageSelected(i);
                }
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: com.tenmeter.smlibrary.widget.circleIndicator.SMCircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int i;
                super.onChanged();
                if (SMCircleIndicator.this.mViewpager == null) {
                    return;
                }
                PagerAdapter adapter = SMCircleIndicator.this.mViewpager.getAdapter();
                if (adapter != null) {
                    i = adapter.getCount();
                } else {
                    i = 0;
                }
                if (i == SMCircleIndicator.this.getChildCount()) {
                    return;
                }
                SMCircleIndicator sMCircleIndicator = SMCircleIndicator.this;
                if (sMCircleIndicator.mLastPosition < i) {
                    sMCircleIndicator.mLastPosition = sMCircleIndicator.mViewpager.getCurrentItem();
                } else {
                    sMCircleIndicator.mLastPosition = -1;
                }
                SMCircleIndicator.this.createIndicators();
            }
        };
    }

    @Override // com.tenmeter.smlibrary.widget.circleIndicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void animatePageSelected(int i) {
        super.animatePageSelected(i);
    }

    @Override // com.tenmeter.smlibrary.widget.circleIndicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void changeIndicatorResource(int i) {
        super.changeIndicatorResource(i);
    }

    @Override // com.tenmeter.smlibrary.widget.circleIndicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void createIndicators(int i, int i2) {
        super.createIndicators(i, i2);
    }

    public DataSetObserver getDataSetObserver() {
        return this.mInternalDataSetObserver;
    }

    @Override // com.tenmeter.smlibrary.widget.circleIndicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void initialize(Config config) {
        super.initialize(config);
    }

    @Override // com.tenmeter.smlibrary.widget.circleIndicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void setIndicatorCreatedListener(BaseCircleIndicator.IndicatorCreatedListener indicatorCreatedListener) {
        super.setIndicatorCreatedListener(indicatorCreatedListener);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        ViewPager viewPager = this.mViewpager;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(onPageChangeListener);
            this.mViewpager.addOnPageChangeListener(onPageChangeListener);
            return;
        }
        throw new NullPointerException("can not find Viewpager , setViewPager first");
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewpager = viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.mLastPosition = -1;
            createIndicators();
            this.mViewpager.removeOnPageChangeListener(this.mInternalPageChangeListener);
            this.mViewpager.addOnPageChangeListener(this.mInternalPageChangeListener);
            this.mInternalPageChangeListener.onPageSelected(this.mViewpager.getCurrentItem());
        }
    }

    @Override // com.tenmeter.smlibrary.widget.circleIndicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(int i) {
        super.tintIndicator(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createIndicators() {
        PagerAdapter adapter = this.mViewpager.getAdapter();
        createIndicators(adapter == null ? 0 : adapter.getCount(), this.mViewpager.getCurrentItem());
    }

    @Override // com.tenmeter.smlibrary.widget.circleIndicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void changeIndicatorResource(int i, int i2) {
        super.changeIndicatorResource(i, i2);
    }

    @Override // com.tenmeter.smlibrary.widget.circleIndicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(int i, int i2) {
        super.tintIndicator(i, i2);
    }

    public SMCircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.tenmeter.smlibrary.widget.circleIndicator.SMCircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (SMCircleIndicator.this.mViewpager.getAdapter() != null && SMCircleIndicator.this.mViewpager.getAdapter().getCount() > 0) {
                    SMCircleIndicator.this.animatePageSelected(i);
                }
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: com.tenmeter.smlibrary.widget.circleIndicator.SMCircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int i;
                super.onChanged();
                if (SMCircleIndicator.this.mViewpager == null) {
                    return;
                }
                PagerAdapter adapter = SMCircleIndicator.this.mViewpager.getAdapter();
                if (adapter != null) {
                    i = adapter.getCount();
                } else {
                    i = 0;
                }
                if (i == SMCircleIndicator.this.getChildCount()) {
                    return;
                }
                SMCircleIndicator sMCircleIndicator = SMCircleIndicator.this;
                if (sMCircleIndicator.mLastPosition < i) {
                    sMCircleIndicator.mLastPosition = sMCircleIndicator.mViewpager.getCurrentItem();
                } else {
                    sMCircleIndicator.mLastPosition = -1;
                }
                SMCircleIndicator.this.createIndicators();
            }
        };
    }

    public SMCircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.tenmeter.smlibrary.widget.circleIndicator.SMCircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (SMCircleIndicator.this.mViewpager.getAdapter() != null && SMCircleIndicator.this.mViewpager.getAdapter().getCount() > 0) {
                    SMCircleIndicator.this.animatePageSelected(i2);
                }
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: com.tenmeter.smlibrary.widget.circleIndicator.SMCircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int i2;
                super.onChanged();
                if (SMCircleIndicator.this.mViewpager == null) {
                    return;
                }
                PagerAdapter adapter = SMCircleIndicator.this.mViewpager.getAdapter();
                if (adapter != null) {
                    i2 = adapter.getCount();
                } else {
                    i2 = 0;
                }
                if (i2 == SMCircleIndicator.this.getChildCount()) {
                    return;
                }
                SMCircleIndicator sMCircleIndicator = SMCircleIndicator.this;
                if (sMCircleIndicator.mLastPosition < i2) {
                    sMCircleIndicator.mLastPosition = sMCircleIndicator.mViewpager.getCurrentItem();
                } else {
                    sMCircleIndicator.mLastPosition = -1;
                }
                SMCircleIndicator.this.createIndicators();
            }
        };
    }

    @TargetApi(21)
    public SMCircleIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.tenmeter.smlibrary.widget.circleIndicator.SMCircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i22, float f, int i222) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i22) {
                if (SMCircleIndicator.this.mViewpager.getAdapter() != null && SMCircleIndicator.this.mViewpager.getAdapter().getCount() > 0) {
                    SMCircleIndicator.this.animatePageSelected(i22);
                }
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: com.tenmeter.smlibrary.widget.circleIndicator.SMCircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                int i22;
                super.onChanged();
                if (SMCircleIndicator.this.mViewpager == null) {
                    return;
                }
                PagerAdapter adapter = SMCircleIndicator.this.mViewpager.getAdapter();
                if (adapter != null) {
                    i22 = adapter.getCount();
                } else {
                    i22 = 0;
                }
                if (i22 == SMCircleIndicator.this.getChildCount()) {
                    return;
                }
                SMCircleIndicator sMCircleIndicator = SMCircleIndicator.this;
                if (sMCircleIndicator.mLastPosition < i22) {
                    sMCircleIndicator.mLastPosition = sMCircleIndicator.mViewpager.getCurrentItem();
                } else {
                    sMCircleIndicator.mLastPosition = -1;
                }
                SMCircleIndicator.this.createIndicators();
            }
        };
    }
}
