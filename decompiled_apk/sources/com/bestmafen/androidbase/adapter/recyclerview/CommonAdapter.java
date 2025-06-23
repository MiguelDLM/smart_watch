package com.bestmafen.androidbase.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import java.util.List;
import oo.xoXoI;

/* loaded from: classes8.dex */
public abstract class CommonAdapter<T> extends MultiItemTypeAdapter<T> {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    protected int mLayoutId;

    /* loaded from: classes8.dex */
    public class oIX0oI implements xoXoI<T> {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ int f10317oIX0oI;

        public oIX0oI(int i) {
            this.f10317oIX0oI = i;
        }

        @Override // oo.xoXoI
        public void I0Io(ViewHolder viewHolder, T t, int i) {
            CommonAdapter.this.convert(viewHolder, t, i);
        }

        @Override // oo.xoXoI
        public int II0xO0() {
            return this.f10317oIX0oI;
        }

        @Override // oo.xoXoI
        public boolean oIX0oI(T t, int i) {
            return true;
        }
    }

    public CommonAdapter(Context context, int i, List<T> list) {
        super(context, list);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mLayoutId = i;
        this.mDatas = list;
        addItemViewDelegate(new oIX0oI(i));
    }

    public abstract void convert(ViewHolder viewHolder, T t, int i);
}
