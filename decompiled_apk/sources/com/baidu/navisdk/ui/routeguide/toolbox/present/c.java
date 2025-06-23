package com.baidu.navisdk.ui.routeguide.toolbox.present;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.navisdk.ui.routeguide.toolbox.view.RGToolboxSettingCellView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class c extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<com.baidu.navisdk.ui.routeguide.toolbox.bean.a> f9116a = new ArrayList();
    private Context b;

    public c(Context context) {
        this.b = context;
    }

    public void a(List<com.baidu.navisdk.ui.routeguide.toolbox.bean.a> list) {
        this.f9116a.clear();
        this.f9116a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9116a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return getItem(i).b();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.navisdk.ui.routeguide.toolbox.bean.a item = getItem(i);
        RGToolboxSettingCellView rGToolboxSettingCellView = new RGToolboxSettingCellView(this.b);
        rGToolboxSettingCellView.a(item);
        return rGToolboxSettingCellView;
    }

    @Override // android.widget.Adapter
    public com.baidu.navisdk.ui.routeguide.toolbox.bean.a getItem(int i) {
        return this.f9116a.get(i);
    }
}
