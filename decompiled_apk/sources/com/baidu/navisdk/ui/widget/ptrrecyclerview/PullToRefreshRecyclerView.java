package com.baidu.navisdk.ui.widget.ptrrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.widget.TwoStateScrollView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.DefaultLoadMoreView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.header.Header;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.util.PullToRefreshRecyclerViewUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class PullToRefreshRecyclerView extends TwoStateScrollView implements PrvInterface {
    private static final int FINGER_SIZE = 5;
    private static final int INNER_VIEW_TOUCH_SIZE = 20;
    private static final String TAG = "PullToRefreshRecyclerView";
    private int downY;
    private boolean hasMoreItems;
    private boolean interceptHasActionDown;
    private int interceptLastY;
    private boolean isLoading;
    private AdapterObserver mAdapterObserver;
    private int mCurScroll;
    private View mEmptyView;
    private View mHeader;
    private InterOnScrollListener mInterOnScrollListener;
    private boolean mIsSwipeEnable;
    private int mLoadMoreCount;
    private BaseLoadMoreView mLoadMoreFooter;
    private OnScrollListener mOnScrollLinstener;
    private PagingableListener mPagingableListener;
    private PullToRefreshRecyclerViewUtil mPtrrvUtil;
    private RecyclerView mRecyclerView;
    private Header mRootHeader;
    private RelativeLayout mRootRelativeLayout;

    /* loaded from: classes8.dex */
    public class AdapterObserver extends RecyclerView.AdapterDataObserver {
        private AdapterObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.Adapter adapter;
            super.onChanged();
            if (PullToRefreshRecyclerView.this.mRecyclerView != null && (adapter = PullToRefreshRecyclerView.this.mRecyclerView.getAdapter()) != null && PullToRefreshRecyclerView.this.mEmptyView != null) {
                if (adapter.getItemCount() == 0) {
                    if (PullToRefreshRecyclerView.this.mIsSwipeEnable) {
                        PullToRefreshRecyclerView.this.setEnabled(false);
                    }
                    if (PullToRefreshRecyclerView.this.mEmptyView.getParent() != PullToRefreshRecyclerView.this.mRootRelativeLayout) {
                        PullToRefreshRecyclerView.this.mRootRelativeLayout.addView(PullToRefreshRecyclerView.this.mEmptyView);
                    }
                    PullToRefreshRecyclerView.this.mEmptyView.setVisibility(0);
                    PullToRefreshRecyclerView.this.mRecyclerView.setVisibility(8);
                    return;
                }
                if (PullToRefreshRecyclerView.this.mIsSwipeEnable) {
                    PullToRefreshRecyclerView.this.setEnabled(true);
                }
                PullToRefreshRecyclerView.this.mEmptyView.setVisibility(8);
                PullToRefreshRecyclerView.this.mRecyclerView.setVisibility(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class InterOnScrollListener extends RecyclerView.OnScrollListener {
        private InterOnScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (PullToRefreshRecyclerView.this.mOnScrollLinstener != null) {
                PullToRefreshRecyclerView.this.mOnScrollLinstener.onScrollStateChanged(recyclerView, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (PullToRefreshRecyclerView.this.getLayoutManager() == null) {
                return;
            }
            PullToRefreshRecyclerView.this.mCurScroll += i2;
            if (PullToRefreshRecyclerView.this.mHeader != null) {
                PullToRefreshRecyclerView.this.mHeader.setTranslationY(-PullToRefreshRecyclerView.this.mCurScroll);
            }
            int childCount = PullToRefreshRecyclerView.this.getLayoutManager().getChildCount();
            int itemCount = PullToRefreshRecyclerView.this.getLayoutManager().getItemCount();
            int findFirstVisibleItemPosition = PullToRefreshRecyclerView.this.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = PullToRefreshRecyclerView.this.findLastVisibleItemPosition();
            if (PullToRefreshRecyclerView.this.mIsSwipeEnable) {
                if (PullToRefreshRecyclerView.this.findFirstCompletelyVisibleItemPosition() != 0) {
                    PullToRefreshRecyclerView.this.setEnabled(false);
                } else {
                    PullToRefreshRecyclerView.this.setEnabled(true);
                }
            }
            if (itemCount < PullToRefreshRecyclerView.this.mLoadMoreCount) {
                PullToRefreshRecyclerView.this.setHasMoreItems(false);
                PullToRefreshRecyclerView.this.isLoading = false;
            } else if (!PullToRefreshRecyclerView.this.isLoading && PullToRefreshRecyclerView.this.hasMoreItems && findLastVisibleItemPosition + 1 == itemCount && PullToRefreshRecyclerView.this.mPagingableListener != null) {
                PullToRefreshRecyclerView.this.isLoading = true;
                PullToRefreshRecyclerView.this.mPagingableListener.onLoadMoreItems();
            }
            if (PullToRefreshRecyclerView.this.mOnScrollLinstener != null) {
                PullToRefreshRecyclerView.this.mOnScrollLinstener.onScrolled(recyclerView, i, i2);
                PullToRefreshRecyclerView.this.mOnScrollLinstener.onScroll(recyclerView, findFirstVisibleItemPosition, childCount, itemCount);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface OnScrollListener {
        void onScroll(RecyclerView recyclerView, int i, int i2, int i3);

        void onScrollStateChanged(RecyclerView recyclerView, int i);

        void onScrolled(RecyclerView recyclerView, int i, int i2);
    }

    /* loaded from: classes8.dex */
    public interface PagingableListener {
        void onLoadMoreItems();
    }

    public PullToRefreshRecyclerView(Context context) {
        this(context, null);
    }

    private void initView(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) JarUtils.inflate(context, R.layout.ptrrv_root_view, null);
        this.mRootRelativeLayout = relativeLayout;
        addView(relativeLayout);
        RecyclerView recyclerView = (RecyclerView) this.mRootRelativeLayout.findViewById(R.id.recycler_view);
        this.mRecyclerView = recyclerView;
        recyclerView.setHasFixedSize(true);
        if (!this.mIsSwipeEnable) {
            setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHasMoreItems(boolean z) {
        this.hasMoreItems = z;
        if (this.mLoadMoreFooter == null) {
            this.mLoadMoreFooter = new DefaultLoadMoreView(getContext(), getRecyclerView());
        }
        if (this.mRecyclerView.isComputingLayout()) {
            this.mRecyclerView.stopScroll();
        }
        try {
            if (!this.hasMoreItems) {
                this.mRecyclerView.removeItemDecoration(this.mLoadMoreFooter);
            } else {
                this.mRecyclerView.removeItemDecoration(this.mLoadMoreFooter);
                this.mRecyclerView.addItemDecoration(this.mLoadMoreFooter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setLinster() {
        InterOnScrollListener interOnScrollListener = new InterOnScrollListener();
        this.mInterOnScrollListener = interOnScrollListener;
        this.mRecyclerView.setOnScrollListener(interOnScrollListener);
    }

    private void setup(Context context) {
        this.mScroller = new Scroller(context);
        setupExtra();
        initView(context);
        setLinster();
    }

    private void setupExtra() {
        this.isLoading = false;
        this.hasMoreItems = false;
        this.mPtrrvUtil = new PullToRefreshRecyclerViewUtil();
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void addHeaderView(View view) {
        View view2 = this.mHeader;
        if (view2 != null) {
            this.mRootRelativeLayout.removeView(view2);
        }
        this.mHeader = view;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PullToRefreshRecyclerView.this.mHeader.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (PullToRefreshRecyclerView.this.getRecyclerView() != null && PullToRefreshRecyclerView.this.mHeader != null) {
                    if (PullToRefreshRecyclerView.this.mRootHeader == null) {
                        PullToRefreshRecyclerView.this.mRootHeader = new Header();
                    }
                    PullToRefreshRecyclerView.this.mRootHeader.setHeight(PullToRefreshRecyclerView.this.mHeader.getMeasuredHeight());
                    PullToRefreshRecyclerView.this.getRecyclerView().removeItemDecoration(PullToRefreshRecyclerView.this.mRootHeader);
                    PullToRefreshRecyclerView.this.getRecyclerView().addItemDecoration(PullToRefreshRecyclerView.this.mRootHeader);
                    PullToRefreshRecyclerView.this.getRecyclerView().getAdapter().notifyDataSetChanged();
                }
            }
        });
        this.mRootRelativeLayout.addView(this.mHeader);
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void addOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollLinstener = onScrollListener;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        return this.mPtrrvUtil.findFirstCompletelyVisibleItemPosition(getLayoutManager());
    }

    public int findFirstVisibleItemPosition() {
        return this.mPtrrvUtil.findFirstVisibleItemPosition(getLayoutManager());
    }

    public int findLastVisibleItemPosition() {
        return this.mPtrrvUtil.findLastVisibleItemPosition(getLayoutManager());
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public RecyclerView.LayoutManager getLayoutManager() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getLayoutManager();
        }
        return null;
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public BaseLoadMoreView getLoadMoreFooter() {
        return this.mLoadMoreFooter;
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public boolean isSwipeEnable() {
        return this.mIsSwipeEnable;
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void onFinishLoading(boolean z, boolean z2) {
        BaseLoadMoreView baseLoadMoreView;
        if (getLayoutManager() == null) {
            return;
        }
        if (!z && (baseLoadMoreView = this.mLoadMoreFooter) != null) {
            this.mCurScroll -= baseLoadMoreView.getLoadMorePadding();
        }
        if (getLayoutManager().getItemCount() < this.mLoadMoreCount) {
            z = false;
        }
        setHasMoreItems(z);
        this.isLoading = false;
        if (z2) {
            this.mRecyclerView.scrollToPosition(findFirstVisibleItemPosition() - 1);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.needScroll) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        String str = TAG;
        LogUtil.e(str, "onInterceptTouchEvent : isScrolling --> " + this.isScrolling + ", action: " + action);
        if (this.isScrolling && action != 0) {
            return false;
        }
        int y = (int) motionEvent.getY();
        obtainVelocity(motionEvent);
        boolean z2 = true;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    LogUtil.e(str, "onInterceptTouchEvent (ACTION_MOVE): interceptHasActionDown --> " + this.interceptHasActionDown);
                    if (!this.interceptHasActionDown) {
                        return false;
                    }
                    this.interceptHasActionDown = false;
                    if (!this.mScroller.isFinished()) {
                        this.mScroller.abortAnimation();
                    }
                    int i = y - this.interceptLastY;
                    int i2 = y - this.downY;
                    LogUtil.e(str, "onInterceptTouchEvent (ACTION_MOVE): --> status: " + this.status + ", dy: " + i);
                    if (this.status == TwoStateScrollView.DragState.TOP) {
                        if (i > 5) {
                            LogUtil.e(str, "onInterceptTouchEvent (ACTION_MOVE)(TOP): --> case 1: - scroll down");
                            scrollBy(0, -i);
                            this.interceptLastY = y;
                            this.mLastY = y;
                            return true;
                        }
                        if (i < -5) {
                            LogUtil.e(str, "onInterceptTouchEvent (ACTION_MOVE)(TOP): --> case 2: - scroll up");
                            this.interceptLastY = y;
                            this.mLastY = y;
                        } else {
                            if (i > 0) {
                                return true;
                            }
                            LogUtil.e(str, "onInterceptTouchEvent (ACTION_MOVE)(TOP): --> case 3: - touch equivalent");
                            this.interceptLastY = y;
                            this.mLastY = y;
                            this.interceptHasActionDown = true;
                            return false;
                        }
                    } else {
                        if (i2 < -20) {
                            LogUtil.e(str, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 7: - outer view event");
                            z = true;
                        } else {
                            LogUtil.e(str, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 8: - inner view event");
                            this.interceptHasActionDown = true;
                            z = false;
                        }
                        if (i < 0) {
                            LogUtil.e(str, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 4: - scroll up");
                            scrollBy(0, -i);
                        } else {
                            if (i > 5) {
                                LogUtil.e(str, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 5: - scroll down");
                                this.mLastY = y;
                                this.interceptLastY = y;
                                LogUtil.e(str, "onInterceptTouchEvent: containerEvent --> " + z2 + ", dyToDown: " + i2);
                                return z2;
                            }
                            LogUtil.e(str, "onInterceptTouchEvent (ACTION_MOVE)(BOTTOM): --> case 6: - touch equivalent");
                            this.interceptHasActionDown = true;
                        }
                        z2 = z;
                        this.mLastY = y;
                        this.interceptLastY = y;
                        LogUtil.e(str, "onInterceptTouchEvent: containerEvent --> " + z2 + ", dyToDown: " + i2);
                        return z2;
                    }
                }
            } else {
                LogUtil.e(str, "onInterceptTouchEvent (ACTION_UP): interceptHasActionDown --> " + this.interceptHasActionDown);
                this.interceptHasActionDown = false;
                this.interceptLastY = y;
            }
        } else {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                this.isScrolling = false;
            }
            this.mScrollStart = getScrollY();
            LogUtil.e(str, "onInterceptTouchEvent (ACTION_DOWN): mScrollStart --> " + this.mScrollStart);
            if (getLayoutManager() != null && getLayoutManager().getChildAt(0) != null) {
                int top = getLayoutManager().getChildAt(0).getTop();
                LogUtil.e(str, "onInterceptTouchEvent: firstItemTop --> " + top);
                if (top == -1) {
                    getLayoutManager().getChildAt(0).setTop(0);
                }
            }
            int findFirstCompletelyVisibleItemPosition = findFirstCompletelyVisibleItemPosition();
            LogUtil.e(str, "onInterceptTouchEvent (ACTION_DOWN): firstCompletelyVisibleItem --> " + findFirstCompletelyVisibleItemPosition);
            int i3 = this.mScrollStart;
            int i4 = this.foldableHeight;
            if (i3 < (-i4) / 2) {
                this.status = TwoStateScrollView.DragState.BOTTOM;
            } else {
                this.status = TwoStateScrollView.DragState.TOP;
            }
            TwoStateScrollView.DragState dragState = this.status;
            if (dragState == TwoStateScrollView.DragState.TOP && i3 == 0 && findFirstCompletelyVisibleItemPosition <= 0) {
                this.interceptHasActionDown = true;
            } else if (dragState == TwoStateScrollView.DragState.BOTTOM && i3 == (-i4)) {
                this.interceptHasActionDown = true;
            }
            this.interceptLastY = y;
            this.downY = y;
            LogUtil.e(str, "onInterceptTouchEvent (ACTION_DOWN): status --> " + this.status);
            if (this.status == TwoStateScrollView.DragState.BOTTOM) {
                if (!this.isScrolling && y < this.blankSpaceHeight) {
                    this.interceptHasActionDown = false;
                    LogUtil.e(str, "onInterceptTouchEvent (ACTION_DOWN): --> blank space clicked: " + y);
                    if (!this.isNotInterruptBlankTouchEvent) {
                        return false;
                    }
                    return super.onTouchEvent(motionEvent);
                }
            } else if (!this.isScrolling && y < (getMeasuredHeight() - this.persistantHeight) - this.foldableHeight) {
                this.interceptHasActionDown = false;
                LogUtil.e(str, "onInterceptTouchEvent (ACTION_DOWN): --> beyond view range: " + y);
                return false;
            }
            this.hasActionDown = true;
            this.mLastY = y;
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void release() {
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void removeHeader() {
        if (this.mRootHeader != null) {
            getRecyclerView().removeItemDecoration(this.mRootHeader);
            this.mRootHeader = null;
        }
        View view = this.mHeader;
        if (view != null) {
            this.mRootRelativeLayout.removeView(view);
            this.mHeader = null;
        }
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void scrollToPosition(int i) {
        this.mRecyclerView.scrollToPosition(i);
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void setAdapter(RecyclerView.Adapter adapter) {
        this.mRecyclerView.setAdapter(adapter);
        if (this.mAdapterObserver == null) {
            this.mAdapterObserver = new AdapterObserver();
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mAdapterObserver);
            this.mAdapterObserver.onChanged();
        }
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void setEmptyView(View view) {
        View view2 = this.mEmptyView;
        if (view2 != null) {
            this.mRootRelativeLayout.removeView(view2);
        }
        this.mEmptyView = view;
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void setFooter(View view) {
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(layoutManager);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void setLoadMoreCount(int i) {
        this.mLoadMoreCount = i;
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void setLoadMoreFooter(BaseLoadMoreView baseLoadMoreView) {
        this.mLoadMoreFooter = baseLoadMoreView;
    }

    public void setLoadmoreString(String str) {
        BaseLoadMoreView baseLoadMoreView = this.mLoadMoreFooter;
        if (baseLoadMoreView != null) {
            baseLoadMoreView.setLoadmoreString(str);
        }
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void setOnLoadMoreComplete() {
        setHasMoreItems(false);
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void setOnRefreshComplete() {
        setRefreshing(false);
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void setPagingableListener(PagingableListener pagingableListener) {
        this.mPagingableListener = pagingableListener;
    }

    public void setRefreshing(boolean z) {
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void setSwipeEnable(boolean z) {
        this.mIsSwipeEnable = z;
        setEnabled(z);
    }

    @Override // com.baidu.navisdk.ui.widget.ptrrecyclerview.impl.PrvInterface
    public void smoothScrollToPosition(int i) {
        this.mRecyclerView.smoothScrollToPosition(i);
    }

    public PullToRefreshRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLoadMoreCount = 10;
        this.mIsSwipeEnable = false;
        this.isLoading = false;
        this.hasMoreItems = false;
        this.interceptHasActionDown = false;
        this.interceptLastY = -1;
        this.downY = -1;
        setup(context);
    }
}
