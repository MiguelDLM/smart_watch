package com.bestmafen.androidbase.adapter.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import java.util.List;
import oo.o00;
import oo.xoXoI;

/* loaded from: classes8.dex */
public class MultiItemTypeAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected List<T> mDatas;
    protected o00 mItemViewDelegateManager = new o00();
    protected I0Io mOnItemClickListener;

    /* loaded from: classes8.dex */
    public interface I0Io {
        boolean II0xO0(View view, RecyclerView.ViewHolder viewHolder, int i);

        void oIX0oI(View view, RecyclerView.ViewHolder viewHolder, int i);
    }

    /* loaded from: classes8.dex */
    public class II0xO0 implements View.OnLongClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ ViewHolder f10319XO;

        public II0xO0(ViewHolder viewHolder) {
            this.f10319XO = viewHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (MultiItemTypeAdapter.this.mOnItemClickListener != null) {
                return MultiItemTypeAdapter.this.mOnItemClickListener.II0xO0(view, this.f10319XO, this.f10319XO.getAdapterPosition());
            }
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public class oIX0oI implements View.OnClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ ViewHolder f10321XO;

        public oIX0oI(ViewHolder viewHolder) {
            this.f10321XO = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MultiItemTypeAdapter.this.mOnItemClickListener != null) {
                MultiItemTypeAdapter.this.mOnItemClickListener.oIX0oI(view, this.f10321XO, this.f10321XO.getAdapterPosition());
            }
        }
    }

    public MultiItemTypeAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mDatas = list;
    }

    public MultiItemTypeAdapter addItemViewDelegate(xoXoI<T> xoxoi) {
        this.mItemViewDelegateManager.II0xO0(xoxoi);
        return this;
    }

    public void convert(ViewHolder viewHolder, T t) {
        this.mItemViewDelegateManager.I0Io(viewHolder, t, viewHolder.getAdapterPosition());
    }

    public List<T> getDatas() {
        return this.mDatas;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDatas.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (!useItemViewDelegateManager()) {
            return super.getItemViewType(i);
        }
        return this.mItemViewDelegateManager.Oxx0IOOO(this.mDatas.get(i), i);
    }

    public boolean isEnabled(int i) {
        return true;
    }

    public void onViewHolderCreated(ViewHolder viewHolder, View view) {
    }

    public void setListener(ViewGroup viewGroup, ViewHolder viewHolder, int i) {
        if (!isEnabled(i)) {
            return;
        }
        viewHolder.getConvertView().setOnClickListener(new oIX0oI(viewHolder));
        viewHolder.getConvertView().setOnLongClickListener(new II0xO0(viewHolder));
    }

    public void setOnItemClickListener(I0Io i0Io) {
        this.mOnItemClickListener = i0Io;
    }

    public boolean useItemViewDelegateManager() {
        if (this.mItemViewDelegateManager.X0o0xo() > 0) {
            return true;
        }
        return false;
    }

    public MultiItemTypeAdapter addItemViewDelegate(int i, xoXoI<T> xoxoi) {
        this.mItemViewDelegateManager.oIX0oI(i, xoxoi);
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        convert(viewHolder, this.mDatas.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder createViewHolder = ViewHolder.createViewHolder(this.mContext, viewGroup, this.mItemViewDelegateManager.oxoX(i).II0xO0());
        onViewHolderCreated(createViewHolder, createViewHolder.getConvertView());
        setListener(viewGroup, createViewHolder, i);
        return createViewHolder;
    }
}
