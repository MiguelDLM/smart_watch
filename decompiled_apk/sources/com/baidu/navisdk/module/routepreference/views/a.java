package com.baidu.navisdk.module.routepreference.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mapclient.liteapp.routeresult.PreferItemsAdapter;
import com.baidu.navisdk.module.routepreference.j;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public abstract class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static int g = 3;

    /* renamed from: a, reason: collision with root package name */
    protected com.baidu.navisdk.module.routepreference.interfaces.b f7491a;
    protected InterfaceC0282a b;
    protected Context c;
    protected List<j> d = new ArrayList();
    protected int e;
    protected int f;

    /* renamed from: com.baidu.navisdk.module.routepreference.views.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0282a {
        void b(int i);
    }

    public a(Context context, com.baidu.navisdk.module.routepreference.interfaces.b bVar, ArrayList<j> arrayList, int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(PreferItemsAdapter.TAG, "BNPreferItemsAdapter(), currentPrefer = " + i + " defaultPrefer = " + i2);
        }
        this.c = context;
        this.f7491a = bVar;
        this.e = i;
        this.f = i2;
    }

    public void a(List<j> list) {
        this.d.clear();
        this.d.addAll(list);
        notifyDataSetChanged();
    }

    public Drawable b(int i) {
        if (this.f7491a.c()) {
            return com.baidu.navisdk.ui.util.b.f(i);
        }
        return com.baidu.navisdk.ui.util.b.c(i, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<j> list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void a(InterfaceC0282a interfaceC0282a) {
        this.b = interfaceC0282a;
    }

    public void a(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e(PreferItemsAdapter.TAG, "updatePrefer(), currentPrefer = " + i + " defaultPrefer = " + i2);
        }
        this.e = i;
        this.f = i2;
    }

    public int a(int i) {
        if (this.f7491a.c()) {
            return com.baidu.navisdk.ui.util.b.b(i);
        }
        return com.baidu.navisdk.ui.util.b.a(i, true);
    }

    public void a() {
        this.b = null;
        this.f7491a = null;
        this.c = null;
    }
}
