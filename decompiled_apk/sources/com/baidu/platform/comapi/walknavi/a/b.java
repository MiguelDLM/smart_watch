package com.baidu.platform.comapi.walknavi.a;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.R;
import com.baidu.platform.comapi.walknavi.a.c;
import com.baidu.platform.comapi.wnplatform.p.e;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public int f9696a;
    public String b;
    private String h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private int b;

        public a(int i) {
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            String str;
            if (view != null && (tag = view.getTag()) != null && (tag instanceof c.a)) {
                if (b.this.getItem(this.b) == null) {
                    str = "";
                } else {
                    str = b.this.getItem(this.b);
                }
                b bVar = b.this;
                bVar.b = str;
                bVar.h = "";
                b bVar2 = b.this;
                bVar2.f9696a = this.b;
                e.a(str, bVar2.f, true);
                b.this.notifyDataSetChanged();
            }
        }
    }

    public b(ArrayList<String> arrayList) {
        super(arrayList);
        this.f9696a = -1;
    }

    @TargetApi(16)
    private void b(String str, c.a aVar, int i) {
        if (this.f9696a == i) {
            if (getCount() == 1) {
                aVar.f9699a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.drawable.wsdk_bmbar_all_bac_press));
            } else if (i == 0) {
                if (this.e) {
                    aVar.f9699a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.drawable.wsdk_bmbar_middle_bac_press));
                } else {
                    aVar.f9699a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.drawable.wsdk_bmbar_up_bac_press));
                }
            } else if (i == getCount() - 1) {
                if (this.e) {
                    aVar.f9699a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.drawable.wsdk_bmbar_middle_bac_press));
                } else {
                    aVar.f9699a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.drawable.wsdk_bmbar_down_bac_press));
                }
            } else {
                aVar.f9699a.setBackground(com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.drawable.wsdk_bmbar_middle_bac_press));
            }
            aVar.c.setTextColor(-1);
            this.b = getItem(this.f9696a);
            return;
        }
        aVar.c.setTextColor(-13488081);
    }

    @Override // com.baidu.platform.comapi.walknavi.a.c, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c.a aVar;
        String item = getItem(i);
        if (item == null) {
            return null;
        }
        if (view == null) {
            view = com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.layout.wsdk_bm_bar_item_indoor_a, null);
            view.setClickable(false);
            aVar = new c.a();
            aVar.c = (TextView) view.findViewById(R.id.name);
            aVar.f9699a = view.findViewById(R.id.bar_item);
            aVar.b = (ImageView) view.findViewById(R.id.indoor_loc_sanjiao);
            view.setTag(aVar);
        } else {
            aVar = (c.a) view.getTag();
        }
        a(i, view, aVar);
        aVar.d = null;
        aVar.e = null;
        aVar.f9699a.setTag(aVar);
        aVar.f9699a.setOnClickListener(new a(i));
        aVar.c.setText(item);
        a(item, aVar, i);
        return view;
    }

    private void a(String str, c.a aVar, int i) {
        a(aVar);
        b(str, aVar, i);
    }

    public void a(c.a aVar) {
        if (this.e) {
            return;
        }
        aVar.c.setTextSize(1, 9.0f);
    }

    public void a(String str) {
        this.h = str;
    }

    public int a() {
        String str = this.h;
        for (int i = 0; i < getCount(); i++) {
            if (TextUtils.equals(str, getItem(i))) {
                this.f9696a = i;
            }
        }
        return this.f9696a;
    }
}
