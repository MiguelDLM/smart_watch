package com.baidu.platform.comapi.walknavi.h.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.R;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.platform.comapi.walknavi.a.b;
import com.baidu.platform.comapi.wnplatform.f;
import com.baidu.platform.comapi.wnplatform.p.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f9764a;
    private LinearLayout b;
    private View c;
    private ListView d;
    private View e;
    private View f;
    private Activity g;

    public a(ViewGroup viewGroup, Activity activity) {
        this.f9764a = viewGroup;
        this.g = activity;
    }

    public void a() {
        this.b = (LinearLayout) this.f9764a.findViewById(R.id.indoor_bar_container);
        if (this.c == null) {
            this.c = com.baidu.platform.comapi.wnplatform.p.a.a.a(this.g, R.layout.wsdk_layout_indoor_bar, null);
        }
        this.e = this.c.findViewById(R.id.up_scroll);
        this.f = this.c.findViewById(R.id.down_scroll);
        this.b.addView(this.c);
        this.d = (ListView) this.c.findViewById(R.id.bar_a_list);
    }

    public void b() {
        if (this.b != null && f.a().c()) {
            this.b.setVisibility(8);
        }
    }

    public void c() {
        this.b.setVisibility(8);
    }

    public void a(MapBaseIndoorMapInfo mapBaseIndoorMapInfo) {
        if (mapBaseIndoorMapInfo == null) {
            return;
        }
        String id = mapBaseIndoorMapInfo.getID();
        String curFloor = mapBaseIndoorMapInfo.getCurFloor();
        int i = 0;
        this.b.setVisibility(0);
        ArrayList<String> floors = mapBaseIndoorMapInfo.getFloors();
        if (floors == null || floors.size() == 0) {
            return;
        }
        this.d.setLayoutParams(a(floors, this.d, this.d.getLayoutParams()));
        b bVar = new b(floors);
        if (floors.size() > 3) {
            bVar.a(true);
            View view = this.e;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.f;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        } else {
            bVar.a(false);
            View view3 = this.e;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            View view4 = this.f;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        }
        bVar.b(true);
        bVar.b(id);
        bVar.a(curFloor);
        this.d.setAdapter((ListAdapter) bVar);
        int a2 = bVar.a();
        if (a2 >= this.d.getLastVisiblePosition()) {
            i = a2 + 2;
            if (i >= bVar.getCount() - 1) {
                i = bVar.getCount() - 1;
            }
        } else if (a2 > this.d.getFirstVisiblePosition() || a2 - 2 > 0) {
            i = a2;
        }
        bVar.notifyDataSetChanged();
        this.d.setSelection(i);
    }

    public void a(String str) {
        int i = 0;
        this.b.setVisibility(0);
        b bVar = (b) this.d.getAdapter();
        if (bVar == null) {
            return;
        }
        bVar.a(str);
        int a2 = bVar.a();
        if (a2 >= this.d.getLastVisiblePosition()) {
            i = a2 + 2;
            if (i >= bVar.getCount() - 1) {
                i = bVar.getCount() - 1;
            }
        } else if (a2 > this.d.getFirstVisiblePosition() || a2 - 2 > 0) {
            i = a2;
        }
        bVar.notifyDataSetChanged();
        this.d.setSelection(i);
    }

    private ViewGroup.LayoutParams a(List<String> list, View view, ViewGroup.LayoutParams layoutParams) {
        if (list != null) {
            if (list.size() > 5) {
                layoutParams.height = h.a(this.g, 185);
            } else {
                layoutParams.height = h.a(this.g, (list.size() * 37) - 2);
            }
        }
        return layoutParams;
    }
}
