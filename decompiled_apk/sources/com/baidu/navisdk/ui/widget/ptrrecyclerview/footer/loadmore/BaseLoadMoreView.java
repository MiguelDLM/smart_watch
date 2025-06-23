package com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.util.PullToRefreshRecyclerViewUtil;

/* loaded from: classes8.dex */
public class BaseLoadMoreView extends RecyclerView.ItemDecoration {
    protected static final int MSG_INVILIDATE = 1;
    protected String mLoadMoreString;
    protected OnDrawListener mOnDrawListener;
    protected RecyclerView mRecyclerView;
    protected long mUpdateTime = 150;
    protected int mLoadMorePadding = 100;
    protected Handler mInvalidateHanlder = new Handler() { // from class: com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            RecyclerView recyclerView = BaseLoadMoreView.this.mRecyclerView;
            if (recyclerView != null && recyclerView.getAdapter() != null) {
                int itemCount = BaseLoadMoreView.this.mRecyclerView.getAdapter().getItemCount() - 1;
                BaseLoadMoreView baseLoadMoreView = BaseLoadMoreView.this;
                if (baseLoadMoreView.mPtrrvUtil.findLastVisibleItemPosition(baseLoadMoreView.mRecyclerView.getLayoutManager()) == itemCount) {
                    BaseLoadMoreView.this.mRecyclerView.invalidate();
                }
            }
        }
    };
    protected PullToRefreshRecyclerViewUtil mPtrrvUtil = new PullToRefreshRecyclerViewUtil();

    /* loaded from: classes8.dex */
    public interface OnDrawListener {
        boolean onDrawLoadMore(Canvas canvas, RecyclerView recyclerView);
    }

    public BaseLoadMoreView(Context context, RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
        if (i == recyclerView.getAdapter().getItemCount() - 1) {
            rect.set(0, 0, 0, getLoadMorePadding());
        }
    }

    public int getLoadMorePadding() {
        return this.mLoadMorePadding;
    }

    public String getLoadmoreString() {
        return this.mLoadMoreString;
    }

    public void onDrawLoadMore(Canvas canvas, RecyclerView recyclerView) {
        OnDrawListener onDrawListener = this.mOnDrawListener;
        if (onDrawListener != null) {
            onDrawListener.onDrawLoadMore(canvas, recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        this.mInvalidateHanlder.removeMessages(1);
        onDrawLoadMore(canvas, recyclerView);
        this.mInvalidateHanlder.sendEmptyMessageDelayed(1, this.mUpdateTime);
    }

    public void release() {
        this.mRecyclerView = null;
    }

    public void setLoadMorePadding(int i) {
        this.mLoadMorePadding = i;
    }

    public void setLoadmoreString(String str) {
        this.mLoadMoreString = str;
    }

    public void setOnDrawListener(OnDrawListener onDrawListener) {
        this.mOnDrawListener = onDrawListener;
    }
}
