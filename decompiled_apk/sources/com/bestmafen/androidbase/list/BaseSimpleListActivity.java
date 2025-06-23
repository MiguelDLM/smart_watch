package com.bestmafen.androidbase.list;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public abstract class BaseSimpleListActivity<T> extends BaseListActivity<T> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BaseSimpleListActivity this$0, AdapterView adapterView, View view, int i, long j) {
        IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onItemClick(i, this$0.getMList().get(i));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.list.I0Io
    public void initItem(@OOXIXo XIOOI.I0Io holder, T t, int i) {
        IIX0o.x0xO0oo(holder, "holder");
        View II0xO02 = holder.II0xO0();
        IIX0o.x0XOIxOo(II0xO02, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) II0xO02).setText(String.valueOf(t));
    }

    @Override // com.bestmafen.androidbase.list.BaseListActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getMListView().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bestmafen.androidbase.list.oIX0oI
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                BaseSimpleListActivity.initView$lambda$0(BaseSimpleListActivity.this, adapterView, view, i, j);
            }
        });
    }

    @Override // com.bestmafen.androidbase.list.II0xO0
    public int itemLayoutId() {
        return R.layout.simple_list_item_1;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return com.bestmafen.androidbase.R.layout.activity_list;
    }

    public abstract void onItemClick(int i, T t);
}
