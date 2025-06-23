package com.bestmafen.androidbase.recycler;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.angcyo.dsladapter.DslAdapter;
import com.angcyo.dsladapter.DslAdapterStatusItem;
import com.angcyo.dsladapter.DslItemDecoration;
import com.angcyo.dsladapter.DslViewHolder;
import com.angcyo.dsladapter.HoverItemDecoration;
import com.bestmafen.androidbase.base.BaseActivity;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes8.dex */
public abstract class BaseDSLRecyclerActivity extends BaseActivity {

    @OOXIXo
    private DslAdapterStatusItem adapterStatus;

    @OOXIXo
    private DslAdapter dslAdapter;
    public DslViewHolder dslViewHolder;
    public RecyclerView recyclerView;
    public SwipeRefreshLayout refreshLayout;

    @OOXIXo
    private HoverItemDecoration hoverItemDecoration = new HoverItemDecoration();

    @OOXIXo
    private DslItemDecoration baseDslItemDecoration = new DslItemDecoration(null, null, null, null, 15, null);

    public BaseDSLRecyclerActivity() {
        DslAdapter dslAdapter = new DslAdapter(null, 1, null);
        dslAdapter.setDslAdapterStatusItem(adapterStatusItem());
        this.dslAdapter = dslAdapter;
        this.adapterStatus = new DslAdapterStatusItem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBaseLayout$lambda$3$lambda$2(BaseDSLRecyclerActivity this$0) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onRefresh();
    }

    @OOXIXo
    public DslAdapterStatusItem adapterStatusItem() {
        return new DslAdapterStatusItem();
    }

    @OOXIXo
    public final DslAdapterStatusItem getAdapterStatus() {
        return this.adapterStatus;
    }

    @OOXIXo
    public final DslItemDecoration getBaseDslItemDecoration() {
        return this.baseDslItemDecoration;
    }

    @OOXIXo
    public final DslAdapter getDslAdapter() {
        return this.dslAdapter;
    }

    @OOXIXo
    public final DslViewHolder getDslViewHolder() {
        DslViewHolder dslViewHolder = this.dslViewHolder;
        if (dslViewHolder != null) {
            return dslViewHolder;
        }
        IIX0o.XOxIOxOx("dslViewHolder");
        return null;
    }

    @OOXIXo
    public final HoverItemDecoration getHoverItemDecoration() {
        return this.hoverItemDecoration;
    }

    @OOXIXo
    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        IIX0o.XOxIOxOx("recyclerView");
        return null;
    }

    @OOXIXo
    public final SwipeRefreshLayout getRefreshLayout() {
        SwipeRefreshLayout swipeRefreshLayout = this.refreshLayout;
        if (swipeRefreshLayout != null) {
            return swipeRefreshLayout;
        }
        IIX0o.XOxIOxOx("refreshLayout");
        return null;
    }

    public void initBaseLayout(int i, int i2) {
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView = (RecyclerView) getDslViewHolder().v(i);
        if (recyclerView != null) {
            setRecyclerView(recyclerView);
            recyclerView.addItemDecoration(this.baseDslItemDecoration);
            HoverItemDecoration.attachToRecyclerView$default(this.hoverItemDecoration, recyclerView, null, 2, null);
            recyclerView.setHasFixedSize(true);
            final Context context = recyclerView.getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager(context) { // from class: com.bestmafen.androidbase.recycler.BaseDSLRecyclerActivity$initBaseLayout$1$1
                @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                public void onLayoutChildren(@oOoXoXO RecyclerView.Recycler recycler, @oOoXoXO RecyclerView.State state) {
                    try {
                        super.onLayoutChildren(recycler, state);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            recyclerView.setAdapter(this.dslAdapter);
        }
        if (i2 != 0 && (swipeRefreshLayout = (SwipeRefreshLayout) getDslViewHolder().v(i2)) != null) {
            setRefreshLayout(swipeRefreshLayout);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.bestmafen.androidbase.recycler.oIX0oI
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    BaseDSLRecyclerActivity.initBaseLayout$lambda$3$lambda$2(BaseDSLRecyclerActivity.this);
                }
            });
        }
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        View decorView = getWindow().getDecorView();
        IIX0o.oO(decorView, "getDecorView(...)");
        setDslViewHolder(new DslViewHolder(decorView, 0, 2, null));
        initBaseLayout(recyclerViewId(), refreshLayoutId());
        onInitBaseLayoutAfter();
    }

    public void onInitBaseLayoutAfter() {
    }

    public void onRefresh() {
    }

    @IdRes
    public abstract int recyclerViewId();

    @IdRes
    public abstract int refreshLayoutId();

    public void renderAdapter(@OOXIXo Oox.oOoXoXO<? super DslAdapter, oXIO0o0XI> render) {
        IIX0o.x0xO0oo(render, "render");
        DslAdapter.render$default(this.dslAdapter, false, null, render, 3, null);
    }

    public final void setAdapterStatus(@OOXIXo DslAdapterStatusItem dslAdapterStatusItem) {
        IIX0o.x0xO0oo(dslAdapterStatusItem, "<set-?>");
        this.adapterStatus = dslAdapterStatusItem;
    }

    public final void setBaseDslItemDecoration(@OOXIXo DslItemDecoration dslItemDecoration) {
        IIX0o.x0xO0oo(dslItemDecoration, "<set-?>");
        this.baseDslItemDecoration = dslItemDecoration;
    }

    public final void setDslAdapter(@OOXIXo DslAdapter dslAdapter) {
        IIX0o.x0xO0oo(dslAdapter, "<set-?>");
        this.dslAdapter = dslAdapter;
    }

    public final void setDslViewHolder(@OOXIXo DslViewHolder dslViewHolder) {
        IIX0o.x0xO0oo(dslViewHolder, "<set-?>");
        this.dslViewHolder = dslViewHolder;
    }

    public final void setHoverItemDecoration(@OOXIXo HoverItemDecoration hoverItemDecoration) {
        IIX0o.x0xO0oo(hoverItemDecoration, "<set-?>");
        this.hoverItemDecoration = hoverItemDecoration;
    }

    public final void setRecyclerView(@OOXIXo RecyclerView recyclerView) {
        IIX0o.x0xO0oo(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    public final void setRefreshLayout(@OOXIXo SwipeRefreshLayout swipeRefreshLayout) {
        IIX0o.x0xO0oo(swipeRefreshLayout, "<set-?>");
        this.refreshLayout = swipeRefreshLayout;
    }
}
