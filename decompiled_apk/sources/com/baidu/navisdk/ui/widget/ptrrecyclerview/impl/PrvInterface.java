package com.baidu.navisdk.ui.widget.ptrrecyclerview.impl;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView;

/* loaded from: classes8.dex */
public interface PrvInterface {
    void addHeaderView(View view);

    void addOnScrollListener(PullToRefreshRecyclerView.OnScrollListener onScrollListener);

    RecyclerView.LayoutManager getLayoutManager();

    BaseLoadMoreView getLoadMoreFooter();

    RecyclerView getRecyclerView();

    boolean isSwipeEnable();

    void onFinishLoading(boolean z, boolean z2);

    void release();

    void removeHeader();

    void scrollToPosition(int i);

    void setAdapter(RecyclerView.Adapter adapter);

    void setEmptyView(View view);

    void setFooter(View view);

    void setLayoutManager(RecyclerView.LayoutManager layoutManager);

    void setLoadMoreCount(int i);

    void setLoadMoreFooter(BaseLoadMoreView baseLoadMoreView);

    void setOnLoadMoreComplete();

    void setOnRefreshComplete();

    void setPagingableListener(PullToRefreshRecyclerView.PagingableListener pagingableListener);

    void setSwipeEnable(boolean z);

    void smoothScrollToPosition(int i);
}
