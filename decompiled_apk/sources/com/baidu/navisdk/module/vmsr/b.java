package com.baidu.navisdk.module.vmsr;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.l;
import com.baidu.navisdk.ui.widget.BNBaseFloatView;
import com.baidu.navisdk.util.common.p;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class b extends BNBaseFloatView implements a.InterfaceC0201a {

    /* renamed from: a, reason: collision with root package name */
    private ListView f7617a;
    private ArrayAdapter b;
    private ArrayList c;

    /* loaded from: classes7.dex */
    public static class a extends ArrayAdapter {
        public a(Context context, int i, List<String> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = new TextView(getContext());
            }
            TextView textView = (TextView) view;
            textView.setText((String) getItem(i));
            textView.setTextColor(-256);
            return view;
        }
    }

    public b(Activity activity) {
        super(activity);
        new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseFloatView
    public void hide() {
        com.baidu.navisdk.framework.message.a.a().a((a.InterfaceC0201a) this);
        super.hide();
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseFloatView
    public View initViews() {
        View inflate = JarUtils.inflate(getContext(), R.layout.vmsr_debug_layout, null);
        this.f7617a = (ListView) inflate.findViewById(R.id.vmsr_debug_list);
        this.c = new ArrayList();
        a aVar = new a(getContext(), android.R.layout.simple_expandable_list_item_1, this.c);
        this.b = aVar;
        this.f7617a.setAdapter((ListAdapter) aVar);
        this.f7617a.setStackFromBottom(true);
        return inflate;
    }

    @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
    public void onEvent(Object obj) {
        if (obj instanceof l) {
            this.c.add("[" + p.a(p.b) + "]" + ((l) obj).f6831a);
            this.b.notifyDataSetInvalidated();
            getFloatView().requestLayout();
            getFloatView().invalidate();
        }
    }

    @Override // com.baidu.navisdk.ui.widget.BNBaseFloatView
    public boolean show() {
        com.baidu.navisdk.framework.message.a.a().a(this, l.class, new Class[0]);
        return super.show();
    }
}
