package com.baidu.navisdk.ui.widget;

import android.content.Context;
import android.database.Observable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.navisdk.ui.widget.BNFixedItemLayout.ViewHolder;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class BNFixedItemLayout<VH extends ViewHolder> extends FrameLayout {
    private static final String TAG = "BNFixedItemLayout";
    private boolean isNeedUpdate;
    private Adapter<VH> mAdapter;
    private int mItemHeight;
    private ArrayList<VH> mItemViewList;
    private int mItemWidth;
    private LayoutManager mLayoutManager;
    private OnItemClickListener mOnItemClickListener;
    private int mRemainderPadding;
    private final AdapterDataObserver observer;

    /* loaded from: classes8.dex */
    public static abstract class Adapter<VH extends ViewHolder> {
        private AdapterDataObservable observable = new AdapterDataObservable();

        public abstract int getItemCount();

        public abstract void onBindViewHolder(@NonNull VH vh, int i);

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup);

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.observable.registerObserver(adapterDataObserver);
        }

        public void updateAllView() {
            this.observable.updateAllView();
        }

        public void updateLayout() {
            this.observable.updateLayout();
        }

        public void updateView(int i) {
            this.observable.updateView(i);
        }
    }

    /* loaded from: classes8.dex */
    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public void updateAllView() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).updateAllView();
            }
        }

        public void updateLayout() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).updateLayout();
            }
        }

        public void updateView(int i) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).updateView(i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface AdapterDataObserver {
        void updateAllView();

        void updateLayout();

        void updateView(int i);
    }

    /* loaded from: classes8.dex */
    public static abstract class LayoutManager {
        public abstract int getColMargin();

        public abstract int getColTotal();

        public abstract int getItemHeight();

        public abstract int getItemWidth();

        public abstract int getRowMargin();
    }

    /* loaded from: classes8.dex */
    public interface OnItemClickListener {
        void onClickItem(int i, View view);
    }

    /* loaded from: classes8.dex */
    public static abstract class ViewHolder {
        public final View itemView;

        public ViewHolder(View view) {
            this.itemView = view;
        }
    }

    public BNFixedItemLayout(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOrientationChange() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "onOrientationChange: ");
        }
        LayoutManager layoutManager = this.mLayoutManager;
        if (layoutManager == null) {
            if (gVar.c()) {
                gVar.c(TAG, "onOrientationChange mLayoutManager == null ");
                return;
            }
            return;
        }
        this.mItemHeight = layoutManager.getItemHeight();
        this.mItemWidth = this.mLayoutManager.getItemWidth();
        int width = getWidth();
        if (this.mItemWidth <= 0 && width <= 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.navisdk.ui.widget.BNFixedItemLayout.4
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    g gVar2 = g.PRO_NAV;
                    if (gVar2.d()) {
                        gVar2.e(BNFixedItemLayout.TAG, "onOrientationChange onGlobalLayout: ");
                    }
                    BNFixedItemLayout.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    BNFixedItemLayout.this.updateWidthHeight();
                    BNFixedItemLayout.this.updateLayout();
                }
            });
        } else {
            updateWidthHeight();
            updateLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAllView() {
        View view;
        VH onCreateViewHolder;
        if (this.mItemHeight > 0 && this.mItemWidth > 0) {
            int i = 0;
            this.isNeedUpdate = false;
            Adapter<VH> adapter = this.mAdapter;
            if (adapter != null && adapter.getItemCount() > 0) {
                if (this.mItemViewList == null) {
                    this.mItemViewList = new ArrayList<>(this.mAdapter.getItemCount());
                }
                int itemCount = this.mAdapter.getItemCount();
                while (i < itemCount) {
                    if (i < this.mItemViewList.size()) {
                        onCreateViewHolder = this.mItemViewList.get(i);
                    } else {
                        onCreateViewHolder = this.mAdapter.onCreateViewHolder(this);
                        addView(onCreateViewHolder.itemView);
                        this.mItemViewList.add(onCreateViewHolder);
                    }
                    int colTotal = i / this.mLayoutManager.getColTotal();
                    int colTotal2 = i % this.mLayoutManager.getColTotal();
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) onCreateViewHolder.itemView.getLayoutParams();
                    layoutParams.width = this.mItemWidth;
                    layoutParams.height = this.mItemHeight;
                    layoutParams.topMargin = (this.mLayoutManager.getRowMargin() + this.mItemHeight) * colTotal;
                    if (colTotal2 == this.mLayoutManager.getColTotal() - 1) {
                        layoutParams.setMarginStart(((this.mLayoutManager.getColMargin() + this.mItemWidth) * colTotal2) + this.mRemainderPadding);
                    } else {
                        layoutParams.setMarginStart((this.mLayoutManager.getColMargin() + this.mItemWidth) * colTotal2);
                    }
                    onCreateViewHolder.itemView.requestLayout();
                    this.mAdapter.onBindViewHolder(onCreateViewHolder, i);
                    onCreateViewHolder.itemView.setTag(Integer.valueOf(i));
                    onCreateViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.BNFixedItemLayout.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (BNFixedItemLayout.this.mOnItemClickListener != null) {
                                BNFixedItemLayout.this.mOnItemClickListener.onClickItem(((Integer) view2.getTag()).intValue(), view2);
                            }
                        }
                    });
                    i++;
                }
                while (i < this.mItemViewList.size()) {
                    VH remove = this.mItemViewList.remove(i);
                    if (remove != null && (view = remove.itemView) != null) {
                        removeView(view);
                    }
                    i++;
                }
                return;
            }
            g gVar = g.COMMON;
            if (gVar.d()) {
                gVar.e(TAG, "updateAllView mAdapter == null || 0");
                return;
            }
            return;
        }
        this.isNeedUpdate = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        for (int i = 0; i < this.mItemViewList.size(); i++) {
            VH vh = this.mItemViewList.get(i);
            int colTotal = i / this.mLayoutManager.getColTotal();
            int colTotal2 = i % this.mLayoutManager.getColTotal();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) vh.itemView.getLayoutParams();
            layoutParams.width = this.mItemWidth;
            layoutParams.height = this.mItemHeight;
            layoutParams.topMargin = (this.mLayoutManager.getRowMargin() + this.mItemHeight) * colTotal;
            if (colTotal2 == this.mLayoutManager.getColTotal() - 1) {
                layoutParams.setMarginStart(((this.mLayoutManager.getColMargin() + this.mItemWidth) * colTotal2) + this.mRemainderPadding);
            } else {
                layoutParams.setMarginStart((this.mLayoutManager.getColMargin() + this.mItemWidth) * colTotal2);
            }
            vh.itemView.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWidthHeight() {
        int colTotal = this.mLayoutManager.getColTotal();
        if (this.mItemWidth == -1) {
            int width = ((getWidth() - getPaddingEnd()) - getPaddingStart()) - ((colTotal - 1) * this.mLayoutManager.getColMargin());
            int i = width / colTotal;
            this.mItemWidth = i;
            int i2 = width - (i * colTotal);
            this.mRemainderPadding = i2;
            if (i2 > 0) {
                g gVar = g.COMMON;
                if (gVar.d()) {
                    gVar.e(TAG, "mRemainderPadding:" + this.mRemainderPadding);
                }
            }
        }
        if (this.mItemHeight == -1) {
            this.mItemHeight = this.mItemWidth;
        }
        g gVar2 = g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e(TAG, "setLayoutManager: " + this.mItemWidth + ", " + this.mItemHeight);
        }
        if (this.isNeedUpdate) {
            updateAllView();
        }
    }

    @Nullable
    public VH getViewHolder(int i) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e(TAG, "getViewHolder: " + i);
        }
        ArrayList<VH> arrayList = this.mItemViewList;
        if (arrayList != null && arrayList.size() != 0 && i < this.mItemViewList.size()) {
            return this.mItemViewList.get(i);
        }
        return null;
    }

    public void setAdapter(Adapter<VH> adapter) {
        this.mAdapter = adapter;
        adapter.registerAdapterDataObserver(this.observer);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
        this.mItemHeight = layoutManager.getItemHeight();
        this.mItemWidth = this.mLayoutManager.getItemWidth();
        int width = getWidth();
        if (this.mItemWidth <= 0 && width <= 0) {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.navisdk.ui.widget.BNFixedItemLayout.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    g gVar = g.PRO_NAV;
                    if (gVar.d()) {
                        gVar.e(BNFixedItemLayout.TAG, "setLayoutManager onGlobalLayout: ");
                    }
                    BNFixedItemLayout.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    BNFixedItemLayout.this.updateWidthHeight();
                }
            });
        } else {
            updateWidthHeight();
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void updateView(int i) {
        g gVar = g.COMMON;
        if (gVar.d()) {
            gVar.e(TAG, "updateView: " + i);
        }
        ArrayList<VH> arrayList = this.mItemViewList;
        if (arrayList != null && arrayList.size() != 0 && i < this.mItemViewList.size()) {
            VH vh = this.mItemViewList.get(i);
            Adapter<VH> adapter = this.mAdapter;
            if (adapter != null) {
                adapter.onBindViewHolder(vh, i);
                return;
            }
            return;
        }
        if (gVar.d()) {
            gVar.e(TAG, "updateView mItemViewList == null ");
        }
    }

    public BNFixedItemLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNFixedItemLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isNeedUpdate = false;
        this.observer = new AdapterDataObserver() { // from class: com.baidu.navisdk.ui.widget.BNFixedItemLayout.1
            @Override // com.baidu.navisdk.ui.widget.BNFixedItemLayout.AdapterDataObserver
            public void updateAllView() {
                BNFixedItemLayout.this.updateAllView();
            }

            @Override // com.baidu.navisdk.ui.widget.BNFixedItemLayout.AdapterDataObserver
            public void updateLayout() {
                BNFixedItemLayout.this.onOrientationChange();
            }

            @Override // com.baidu.navisdk.ui.widget.BNFixedItemLayout.AdapterDataObserver
            public void updateView(int i2) {
                BNFixedItemLayout.this.updateView(i2);
            }
        };
        this.mRemainderPadding = 0;
    }

    @RequiresApi(api = 21)
    public BNFixedItemLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.isNeedUpdate = false;
        this.observer = new AdapterDataObserver() { // from class: com.baidu.navisdk.ui.widget.BNFixedItemLayout.1
            @Override // com.baidu.navisdk.ui.widget.BNFixedItemLayout.AdapterDataObserver
            public void updateAllView() {
                BNFixedItemLayout.this.updateAllView();
            }

            @Override // com.baidu.navisdk.ui.widget.BNFixedItemLayout.AdapterDataObserver
            public void updateLayout() {
                BNFixedItemLayout.this.onOrientationChange();
            }

            @Override // com.baidu.navisdk.ui.widget.BNFixedItemLayout.AdapterDataObserver
            public void updateView(int i22) {
                BNFixedItemLayout.this.updateView(i22);
            }
        };
        this.mRemainderPadding = 0;
    }
}
