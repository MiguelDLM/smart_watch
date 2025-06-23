package com.baidu.platform.comapi.walknavi.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.R;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class c extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private boolean f9698a;
    public ArrayList<String> c;
    public LayoutInflater d;
    public boolean e;
    public String f;
    protected Activity g;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public View f9699a;
        public ImageView b;
        public TextView c;
        public String d;
        public String e;
    }

    public c(ArrayList<String> arrayList) {
        Activity activity = (Activity) com.baidu.platform.comapi.walknavi.b.a().g();
        this.g = activity;
        if (activity != null) {
            this.d = (LayoutInflater) activity.getSystemService("layout_inflater");
        }
        this.c = arrayList;
    }

    public void a(boolean z) {
        this.f9698a = z;
    }

    public void b(boolean z) {
        this.e = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<String> arrayList = this.c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        ArrayList<String> arrayList = this.c;
        if (arrayList == null || arrayList.size() <= i || i < 0) {
            return null;
        }
        return this.c.get(i);
    }

    public void b(String str) {
        this.f = str;
    }

    @TargetApi(16)
    public void a(int i, View view, a aVar) {
        if (getCount() == 1) {
            aVar.f9699a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.drawable.wsdk_bar_item_all_bac));
            return;
        }
        if (i == 0) {
            if (this.e && this.f9698a) {
                aVar.f9699a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.drawable.wsdk_bar_item_middle_bac));
                return;
            } else {
                aVar.f9699a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.drawable.wsdk_bar_item_up_bac));
                return;
            }
        }
        if (i == getCount() - 1) {
            if (this.e && this.f9698a) {
                aVar.f9699a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.drawable.wsdk_bar_item_middle_bac));
                return;
            } else {
                aVar.f9699a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.drawable.wsdk_bar_item_down_bac));
                return;
            }
        }
        aVar.f9699a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.drawable.wsdk_bar_item_middle_bac));
    }
}
