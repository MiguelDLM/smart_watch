package com.baoyz.swipemenulistview;

import IIX0o.II0xO0;
import IIX0o.oxoX;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import androidx.core.internal.view.SupportMenu;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.baoyz.swipemenulistview.SwipeMenuView;

/* loaded from: classes8.dex */
public class oIX0oI implements WrapperListAdapter, SwipeMenuView.oIX0oI {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public SwipeMenuListView.II0xO0 f10286IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public Context f10287Oo;

    /* renamed from: XO, reason: collision with root package name */
    public ListAdapter f10288XO;

    public oIX0oI(Context context, ListAdapter listAdapter) {
        this.f10288XO = listAdapter;
        this.f10287Oo = context;
    }

    public void I0Io(SwipeMenuListView.II0xO0 iI0xO0) {
        this.f10286IXxxXO = iI0xO0;
    }

    public void II0xO0(II0xO0 iI0xO0) {
        oxoX oxox = new oxoX(this.f10287Oo);
        oxox.x0XOIxOo("Item 1");
        oxox.xxIXOIIO(new ColorDrawable(-7829368));
        oxox.Oo(300);
        iI0xO0.oIX0oI(oxox);
        oxoX oxox2 = new oxoX(this.f10287Oo);
        oxox2.x0XOIxOo("Item 2");
        oxox2.xxIXOIIO(new ColorDrawable(SupportMenu.CATEGORY_MASK));
        oxox2.Oo(300);
        iI0xO0.oIX0oI(oxox2);
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.f10288XO.areAllItemsEnabled();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10288XO.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f10288XO.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.f10288XO.getItemId(i);
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        return this.f10288XO.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            View view2 = this.f10288XO.getView(i, view, viewGroup);
            II0xO0 iI0xO0 = new II0xO0(this.f10287Oo);
            iI0xO0.Oxx0IOOO(this.f10288XO.getItemViewType(i));
            II0xO0(iI0xO0);
            SwipeMenuListView swipeMenuListView = (SwipeMenuListView) viewGroup;
            SwipeMenuView swipeMenuView = new SwipeMenuView(iI0xO0, swipeMenuListView);
            swipeMenuView.setOnSwipeItemClickListener(this);
            SwipeMenuLayout swipeMenuLayout = new SwipeMenuLayout(view2, swipeMenuView, swipeMenuListView.getCloseInterpolator(), swipeMenuListView.getOpenInterpolator());
            swipeMenuLayout.setPosition(i);
            return swipeMenuLayout;
        }
        SwipeMenuLayout swipeMenuLayout2 = (SwipeMenuLayout) view;
        swipeMenuLayout2.oxoX();
        swipeMenuLayout2.setPosition(i);
        this.f10288XO.getView(i, swipeMenuLayout2.getContentView(), viewGroup);
        return swipeMenuLayout2;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        return this.f10288XO.getViewTypeCount();
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.f10288XO;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        return this.f10288XO.hasStableIds();
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        return this.f10288XO.isEmpty();
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return this.f10288XO.isEnabled(i);
    }

    public void oIX0oI(SwipeMenuView swipeMenuView, II0xO0 iI0xO0, int i) {
        SwipeMenuListView.II0xO0 iI0xO02 = this.f10286IXxxXO;
        if (iI0xO02 != null) {
            iI0xO02.oIX0oI(swipeMenuView.getPosition(), iI0xO0, i);
        }
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f10288XO.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f10288XO.unregisterDataSetObserver(dataSetObserver);
    }
}
