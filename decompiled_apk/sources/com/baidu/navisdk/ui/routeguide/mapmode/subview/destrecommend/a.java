package com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.imageloader.ImageLoader;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.c;
import java.util.List;

/* loaded from: classes8.dex */
public class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<c.b> f8739a;
    private Context b;
    private boolean c = true;
    private int d;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.destrecommend.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0454a {

        /* renamed from: a, reason: collision with root package name */
        final View f8740a;
        final ImageView b;
        final TextView c;

        public C0454a(View view) {
            this.f8740a = view;
            this.b = (ImageView) view.findViewById(R.id.item_icon);
            this.c = (TextView) view.findViewById(R.id.item_text);
        }
    }

    public a(Context context, List<c.b> list) {
        this.b = context;
        this.f8739a = list;
    }

    public void a(int i) {
        this.d = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<c.b> list = this.f8739a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<c.b> list = this.f8739a;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0454a c0454a;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.nsdk_layout_dest_recommend_grid_item, viewGroup, false);
            c0454a = new C0454a(view);
            c0454a.c.getPaint().setFakeBoldText(true);
            view.setTag(c0454a);
        } else {
            c0454a = (C0454a) view.getTag();
        }
        c.b bVar = (c.b) getItem(i);
        c0454a.c.setText(bVar.f8748a);
        if (TextUtils.isEmpty(bVar.b)) {
            c0454a.b.setVisibility(8);
        } else {
            ImageLoader.with(this.b).load(bVar.b).asBitmap().into(c0454a.b);
            c0454a.b.setVisibility(0);
        }
        if (this.d == i) {
            c0454a.f8740a.setBackgroundResource(R.drawable.nsdk_dest_recommend_grid_item_bg_selected);
            c0454a.c.setTextColor(Color.parseColor("#3385FF"));
            c0454a.b.setColorFilter(Color.parseColor("#3385FF"));
        } else {
            c0454a.f8740a.setBackgroundResource(R.drawable.nsdk_dest_recommend_grid_item_bg_normal);
            if (this.c) {
                c0454a.c.setTextColor(Color.parseColor("#222222"));
                c0454a.b.clearColorFilter();
            } else {
                c0454a.c.setTextColor(Color.parseColor("#FFFFFF"));
                c0454a.b.setColorFilter(Color.parseColor("#AAAFC3"));
            }
        }
        return view;
    }

    public void a(boolean z) {
        this.c = z;
    }
}
