package com.baidu.navisdk.ui.routeguide.toolbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.LayoutRes;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.module.diyspeak.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class b implements f {

    /* renamed from: a, reason: collision with root package name */
    private final int f9110a;
    protected e b;
    private View c;
    private Context d;
    private List<com.baidu.navisdk.ui.routeguide.toolbox.bean.a> e = new ArrayList();
    private d f;
    private GridView g;
    private int h;
    private com.baidu.navisdk.ui.routeguide.toolbox.present.c i;

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b.this.a(view, (int) j);
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.toolbox.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC0479b implements View.OnClickListener {
        public ViewOnClickListenerC0479b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a(view, 8);
        }
    }

    public b(Context context, int i, d dVar) {
        this.d = context;
        this.f9110a = i;
        this.f = dVar;
    }

    private float b(int i, int i2) {
        int i3;
        if (i % i2 == 0) {
            i3 = i / i2;
        } else {
            i3 = (i / i2) + 1;
        }
        return JarUtils.getResources().getDimension(R.dimen.nsdk_rg_toolbox_setting_cell_height) * i3;
    }

    private void c(int i, int i2) {
        GridView gridView = this.g;
        ViewGroup.LayoutParams layoutParams = gridView != null ? gridView.getLayoutParams() : null;
        if (layoutParams == null || this.g == null) {
            return;
        }
        layoutParams.height = (int) b(i, i2);
        this.g.setLayoutParams(layoutParams);
    }

    private com.baidu.navisdk.ui.routeguide.toolbox.bean.a d(int i) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar = this.e.get(i2);
            if (i == aVar.b()) {
                return aVar;
            }
        }
        return null;
    }

    private int e(int i) {
        if (i < 3) {
            return i;
        }
        int i2 = i % 3;
        if (i2 == 0) {
            return 3;
        }
        int i3 = i % 4;
        if (i3 == 0) {
            return 4;
        }
        if (i % 5 == 0) {
            return 5;
        }
        return i2 > i3 ? 3 : 4;
    }

    private List<com.baidu.navisdk.ui.routeguide.toolbox.bean.a> n() {
        int e;
        List<com.baidu.navisdk.ui.routeguide.toolbox.bean.a> j = j();
        if (k() != -1) {
            e = k();
        } else {
            e = e(j.size());
        }
        this.h = e;
        return a(j);
    }

    private void o() {
        if (this.c == null) {
            this.c = com.baidu.navisdk.ui.util.b.a(this.d, l());
            m();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public void a(boolean z) {
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public int f() {
        float f;
        List<com.baidu.navisdk.ui.routeguide.toolbox.bean.a> list = this.e;
        if (list == null || list.isEmpty()) {
            this.e = n();
        }
        float dimension = JarUtils.getResources().getDimension(R.dimen.nsdk_rg_toolbox_divider_height) * 2.0f;
        float b = b(this.e.size(), this.h);
        if (com.baidu.navisdk.function.b.FUNC_SETTING_MORE.a()) {
            f = JarUtils.getResources().getDimension(R.dimen.nsdk_rg_toolbox_more_setting_btn_height) + JarUtils.getResources().getDimension(R.dimen.nsdk_rg_toolbox_more_setting_btn_margintop) + JarUtils.getResources().getDimension(R.dimen.nsdk_rg_toolbox_more_setting_btn_marginbottom);
        } else {
            f = 0.0f;
        }
        return (int) (dimension + f + b);
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public e g() {
        return this.b;
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public void h() {
        com.baidu.navisdk.ui.routeguide.toolbox.bean.a d = d(5);
        if (d != null) {
            d.a(j.b());
            a(d);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public boolean i() {
        if (!com.baidu.navisdk.function.b.FUNC_SETTING_BOTTOM_BAR_SUPPORT_ANIM.a() && BNSettingManager.isBottomBarOpen()) {
            return false;
        }
        return true;
    }

    public abstract List<com.baidu.navisdk.ui.routeguide.toolbox.bean.a> j();

    public int k() {
        return -1;
    }

    @LayoutRes
    public abstract int l();

    public void m() {
        View view = this.c;
        if (view == null) {
            return;
        }
        this.g = (GridView) view.findViewById(R.id.bnav_rg_toolbox_settings_layout);
        this.e = n();
        this.g.setNumColumns(this.h);
        c(this.e.size(), this.h);
        com.baidu.navisdk.ui.routeguide.toolbox.present.c cVar = new com.baidu.navisdk.ui.routeguide.toolbox.present.c(a());
        this.i = cVar;
        this.g.setAdapter((ListAdapter) cVar);
        this.i.a(this.e);
        this.g.setOnItemClickListener(new a());
        View findViewById = this.c.findViewById(R.id.bnav_rg_menu_more_setting_tv);
        if (!com.baidu.navisdk.function.b.FUNC_SETTING_MORE.a() && findViewById != null) {
            findViewById.setVisibility(8);
        }
        findViewById.setOnClickListener(new ViewOnClickListenerC0479b());
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public void onDestroy() {
        View view = this.c;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int i) {
        e eVar = this.b;
        if (eVar != null) {
            eVar.a(view, i);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public void d() {
        d dVar = this.f;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public View e() {
        if (this.c == null) {
            o();
        }
        return this.c;
    }

    private List<com.baidu.navisdk.ui.routeguide.toolbox.bean.a> a(List<com.baidu.navisdk.ui.routeguide.toolbox.bean.a> list) {
        int i;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            int i2 = this.h;
            if (size % i2 == 0) {
                i = size / i2;
            } else {
                i = (size / i2) + 1;
            }
            for (int i3 = 0; i3 < size; i3++) {
                list.get(i3).a((i3 / this.h) + 1 < i);
            }
        }
        return list;
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public int b() {
        return this.f9110a;
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public void c(int i) {
        com.baidu.navisdk.ui.routeguide.toolbox.bean.a d = d(3);
        if (d != null) {
            d.b(i == 0);
            a(d);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public void b(int i) {
        com.baidu.navisdk.ui.routeguide.toolbox.bean.a d = d(2);
        if (d != null) {
            d.b(i == 0);
            a(d);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public void c() {
        d dVar = this.f;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public void a(int i, int i2) {
        int i3;
        int i4;
        String h;
        int i5;
        int i6;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("ARGToolboxOptionsView", "updateSettingStatus key=" + i + " value = " + i2);
        }
        if (i != 4) {
            if (i == 17) {
                i5 = R.color.nsdk_cl_text_g;
                if (i2 == 1) {
                    i6 = R.drawable.nsdk_drawable_toolbox_fullview_state;
                    h = "全览小窗";
                } else {
                    i6 = R.drawable.nsdk_drawable_toolbox_beam_chart;
                    h = "路况条";
                }
            } else if (i == 6) {
                i5 = R.color.nsdk_cl_text_g;
                if (i2 == 1) {
                    i6 = R.drawable.nsdk_drawable_toolbox_car3d_mode;
                    h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_menu_view_car3d);
                } else {
                    i6 = R.drawable.nsdk_drawable_toolbox_north2d_mode;
                    h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_menu_view_north2d);
                }
            } else {
                if (i != 7) {
                    return;
                }
                if (i2 == 1) {
                    i3 = R.color.nsdk_cl_text_g;
                    i4 = R.drawable.nsdk_drawable_toolbox_car_plate_open;
                    h = this.b.c();
                } else {
                    i3 = R.color.nsdk_cl_text_b_mm;
                    i4 = R.drawable.nsdk_drawable_toolbox_car_plate_closed;
                    h = "车牌限行";
                }
            }
            int i7 = i5;
            i4 = i6;
            i3 = i7;
        } else {
            i3 = R.color.nsdk_cl_text_b_mm;
            if (x.b().s2()) {
                i4 = R.drawable.nsdk_drawable_toolbox_orientation_changed_landscape;
                h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_menu_view_landscape);
            } else {
                i4 = R.drawable.nsdk_drawable_toolbox_orientation_changed_portrait;
                h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_menu_view_portrait);
            }
        }
        com.baidu.navisdk.ui.routeguide.toolbox.bean.a d = d(i);
        if (d != null) {
            d.b(h);
            d.b(i3);
            d.a(i4);
            a(d);
        }
    }

    private void a(com.baidu.navisdk.ui.routeguide.toolbox.bean.a aVar) {
        if (this.i == null) {
            return;
        }
        int b = aVar.b();
        for (int i = 0; i < this.e.size(); i++) {
            if (b == this.e.get(i).b()) {
                this.i.a(this.e);
                return;
            }
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public void a(int i) {
        com.baidu.navisdk.ui.routeguide.toolbox.bean.a d = d(4);
        if (d != null) {
            d.b(i == 0);
            a(d);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.toolbox.f
    public Context a() {
        return this.d;
    }
}
