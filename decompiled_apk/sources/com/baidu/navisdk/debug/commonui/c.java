package com.baidu.navisdk.debug.commonui;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.jar.JarUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private View f6775a = null;
    private Button b = null;
    private TextView c = null;
    private ListView d = null;
    private d e = null;
    private int f = 1;
    private String g = "";
    private com.baidu.navisdk.debug.commonui.a h;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.c();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnTouchListener {
        public b(c cVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public String f6779a;
        public String b;

        public e(String str, String str2) {
            this.f6779a = str;
            this.b = str2;
        }
    }

    public c(com.baidu.navisdk.debug.commonui.a aVar) {
        this.h = aVar;
        e();
    }

    private void e() {
        View inflate = JarUtils.inflate(com.baidu.navisdk.framework.a.c().a(), R.layout.debug_common_layout, null);
        this.f6775a = inflate;
        this.b = (Button) inflate.findViewById(R.id.debug_refresh_btn);
        this.c = (TextView) this.f6775a.findViewById(R.id.debug_info_tv);
        this.d = (ListView) this.f6775a.findViewById(R.id.debug_key_value_lv);
        Button button = this.b;
        if (button != null) {
            button.setOnClickListener(new a());
        }
        if (this.d != null) {
            d dVar = new d();
            this.e = dVar;
            this.d.setAdapter((ListAdapter) dVar);
            this.d.setOnTouchListener(new b(this));
        }
    }

    public View a() {
        return this.f6775a;
    }

    public void b() {
        this.f6775a.setVisibility(8);
    }

    public void c() {
        com.baidu.navisdk.debug.commonui.a aVar = this.h;
        if (aVar != null) {
            a(aVar.b());
            a(this.h.a(), false);
        }
    }

    public void d() {
        View view = this.f6775a;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private List<e> f6778a = new ArrayList();

        public void a(List<e> list) {
            this.f6778a.clear();
            if (list != null) {
                this.f6778a.addAll(list);
            }
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f6778a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0193c c0193c;
            if (view == null) {
                view = JarUtils.inflate(com.baidu.navisdk.framework.a.c().a(), R.layout.debug_common_listview_item, null);
                c0193c = new C0193c(null);
                c0193c.f6777a = (TextView) view.findViewById(R.id.debug_key_tv);
                c0193c.b = (TextView) view.findViewById(R.id.debug_value_tv);
                view.setTag(c0193c);
            } else {
                c0193c = (C0193c) view.getTag();
            }
            e a2 = a(i);
            if (a2 != null) {
                c0193c.f6777a.setText(a2.f6779a);
                c0193c.b.setText(a2.b);
            } else {
                c0193c.f6777a.setText("");
                c0193c.b.setText("");
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return false;
        }

        public e a(int i) {
            if (i < 0 || i >= this.f6778a.size()) {
                return null;
            }
            return this.f6778a.get(i);
        }
    }

    public void a(List<e> list) {
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(list);
            this.e.notifyDataSetChanged();
        }
    }

    /* renamed from: com.baidu.navisdk.debug.commonui.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0193c {

        /* renamed from: a, reason: collision with root package name */
        public TextView f6777a;
        public TextView b;

        private C0193c() {
            this.f6777a = null;
            this.b = null;
        }

        public /* synthetic */ C0193c(a aVar) {
            this();
        }
    }

    public void a(String str, boolean z) {
        if (this.c == null || str == null) {
            return;
        }
        if (z) {
            this.g = "";
        }
        StringBuilder sb = new StringBuilder();
        int i = this.f;
        this.f = i + 1;
        sb.append(String.valueOf(i));
        sb.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        sb.append(str);
        sb.append("\n");
        sb.append(this.g);
        String sb2 = sb.toString();
        this.g = sb2;
        this.c.setText(sb2);
        if (this.f > 9) {
            this.f = 1;
            this.g = "";
        }
    }
}
