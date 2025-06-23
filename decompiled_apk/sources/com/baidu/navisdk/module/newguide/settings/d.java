package com.baidu.navisdk.module.newguide.settings;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.newguide.settings.customguideui.a;
import com.baidu.navisdk.module.newguide.settings.customguideui.b;
import com.baidu.navisdk.ui.widget.BNCommonTitleBar;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class d implements com.baidu.navisdk.framework.interfaces.pronavi.d, com.baidu.navisdk.framework.interfaces.h, View.OnClickListener {
    private com.baidu.navisdk.module.newguide.settings.customguideui.a A;
    private View B;
    private View C;
    private RadioGroup D;
    private RadioButton E;
    private RadioButton F;
    private RadioGroup G;
    private RadioButton H;
    private RadioButton I;
    private RadioButton J;
    private LinearLayoutManager K;
    private Context L;
    private com.baidu.navisdk.comapi.commontool.b M;

    /* renamed from: a, reason: collision with root package name */
    private View f7240a;
    private BNCommonTitleBar b;
    private ConstraintLayout c;
    private ScrollView d;
    private View e;
    private View f;
    private View g;
    private View h;
    private View i;
    private ImageView j;
    private LinearLayout k;
    private View l;
    private View m;
    private View n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private View r;
    private TextView s;
    private TextView t;
    private TextView u;
    private ViewPager v;
    private PagerAdapter w;
    private ArrayList<View> x = new ArrayList<>();
    private ArrayList<com.baidu.navisdk.module.newguide.settings.customguideui.b> y = new ArrayList<>();
    private RecyclerView z;

    /* loaded from: classes7.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // com.baidu.navisdk.module.newguide.settings.customguideui.b.a
        public void a(int i, boolean z) {
            d.this.d.fullScroll(33);
            if (z) {
                d.this.k.setVisibility(0);
            } else {
                d.this.k.setVisibility(4);
            }
            ((com.baidu.navisdk.module.newguide.settings.customguideui.b) d.this.y.get(i)).a(z);
            BNCommSettingManager.getInstance().putIsShowLaneLine(z);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements b.a {
        public b() {
        }

        @Override // com.baidu.navisdk.module.newguide.settings.customguideui.b.a
        public void a(int i, boolean z) {
            d.this.d.fullScroll(33);
            if (z) {
                d.this.l.setVisibility(0);
            } else {
                d.this.l.setVisibility(4);
            }
            ((com.baidu.navisdk.module.newguide.settings.customguideui.b) d.this.y.get(i)).a(z);
            BNCommSettingManager.getInstance().putIsShowSpeedClock(z);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements b.a {
        public c() {
        }

        @Override // com.baidu.navisdk.module.newguide.settings.customguideui.b.a
        public void a(int i, boolean z) {
            d.this.d.fullScroll(33);
            if (z) {
                d.this.n.setVisibility(0);
            } else {
                d.this.n.setVisibility(4);
            }
            ((com.baidu.navisdk.module.newguide.settings.customguideui.b) d.this.y.get(i)).a(z);
            BNCommSettingManager.getInstance().putIsShowHighSpeedPanel(z);
        }
    }

    /* renamed from: com.baidu.navisdk.module.newguide.settings.d$d, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0252d implements b.a {
        public C0252d() {
        }

        @Override // com.baidu.navisdk.module.newguide.settings.customguideui.b.a
        public void a(int i, boolean z) {
            d.this.d.smoothScrollTo((int) d.this.o.getX(), (int) d.this.o.getY());
            if (z) {
                d.this.o.setVisibility(0);
            } else {
                d.this.o.setVisibility(4);
            }
            ((com.baidu.navisdk.module.newguide.settings.customguideui.b) d.this.y.get(i)).a(z);
            BNCommSettingManager.getInstance().putIsShowCurrentRoad(z);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements b.a {
        public e() {
        }

        @Override // com.baidu.navisdk.module.newguide.settings.customguideui.b.a
        public void a(int i, boolean z) {
            d.this.d.smoothScrollTo((int) d.this.p.getX(), (int) d.this.p.getY());
            if (z) {
                d.this.p.setVisibility(0);
            } else {
                d.this.p.setVisibility(4);
            }
            ((com.baidu.navisdk.module.newguide.settings.customguideui.b) d.this.y.get(i)).a(z);
            BNCommSettingManager.getInstance().putIsShowCarDirCompass(z);
        }
    }

    /* loaded from: classes7.dex */
    public class f implements b.a {
        public f() {
        }

        @Override // com.baidu.navisdk.module.newguide.settings.customguideui.b.a
        public void a(int i, boolean z) {
            d.this.d.smoothScrollTo((int) d.this.m.getX(), (int) d.this.m.getY());
            if (z) {
                d.this.m.setVisibility(0);
            } else {
                d.this.m.setVisibility(4);
            }
            ((com.baidu.navisdk.module.newguide.settings.customguideui.b) d.this.y.get(i)).a(z);
            BNCommSettingManager.getInstance().setShowCarLogoToEnd(z);
        }
    }

    /* loaded from: classes7.dex */
    public class g implements b.a {
        public g() {
        }

        @Override // com.baidu.navisdk.module.newguide.settings.customguideui.b.a
        public void a(int i, boolean z) {
            d.this.d.fullScroll(33);
            if (z) {
                d.this.q.setVisibility(0);
            } else {
                d.this.q.setVisibility(4);
            }
            ((com.baidu.navisdk.module.newguide.settings.customguideui.b) d.this.y.get(i)).a(z);
            BNCommSettingManager.getInstance().putIsShowXiaoDu(z);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements com.baidu.navisdk.comapi.commontool.b {
        public h() {
        }

        @Override // com.baidu.navisdk.comapi.base.b
        public void update(com.baidu.navisdk.comapi.base.c cVar, int i, int i2, Object obj) {
            if (i == 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return;
                            }
                        }
                    }
                    d.this.q(false);
                    return;
                }
                d.this.q(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7249a;

        public i(Context context) {
            this.f7249a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = this.f7249a;
            if (context instanceof Activity) {
                ((Activity) context).onBackPressed();
            } else {
                d.this.onBackPressed();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.m.setPivotX(d.this.m.getWidth());
            d.this.m.setPivotY(0.0f);
            d.this.m.setRotation(38.0f);
        }
    }

    /* loaded from: classes7.dex */
    public class k implements RadioGroup.OnCheckedChangeListener {
        public k() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int i2 = 0;
            if (i == R.id.nav_default_mode_rb) {
                d.this.d.fullScroll(33);
                d.this.f.setVisibility(4);
                d.this.e.setVisibility(0);
                d.this.y0();
                BNCommSettingManager.getInstance().setSimpleGuideMode(0);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.k", "1", null, null);
            } else if (i == R.id.nav_simple_mode_rb) {
                d.this.d.fullScroll(33);
                d.this.f.setVisibility(0);
                d.this.e.setVisibility(4);
                d.this.z0();
                i2 = 1;
                BNCommSettingManager.getInstance().setSimpleGuideMode(1);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.k", "0", null, null);
            }
            com.baidu.navisdk.logicframe.b h = com.baidu.navisdk.ui.routeguide.b.V().h();
            if (h != null) {
                h.j().e("RGGuidePanelModelService").a(30001).a(Integer.valueOf(i2)).a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements a.b {
        public l() {
        }

        @Override // com.baidu.navisdk.module.newguide.settings.customguideui.a.b
        public void a(int i, boolean z) {
            if (d.this.y != null && !d.this.y.isEmpty()) {
                ((com.baidu.navisdk.module.newguide.settings.customguideui.b) d.this.y.get(i)).d().a(i, z);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.t", String.valueOf(i + 1), String.valueOf(z ? 1 : 0), null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends PagerAdapter {
        public m() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            viewGroup.removeView(d.this.b0().get(i));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return d.this.b0().size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            viewGroup.removeView(d.this.b0().get(i));
            viewGroup.addView(d.this.b0().get(i));
            return d.this.b0().get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }
    }

    /* loaded from: classes7.dex */
    public class n implements ViewPager.OnPageChangeListener {
        public n() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        d.this.v0();
                        return;
                    }
                    return;
                }
                d.this.x0();
                return;
            }
            d.this.C();
        }
    }

    /* loaded from: classes7.dex */
    public class o implements RadioGroup.OnCheckedChangeListener {
        public o() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.nav_overview_thumbnail_rb) {
                d.this.d.smoothScrollTo((int) d.this.j.getX(), (int) d.this.j.getY());
                d.this.j.setVisibility(0);
                d.this.g.setVisibility(4);
                d.this.h.setVisibility(4);
                d.this.i.setBackgroundResource(R.drawable.bnav_rg_custom_setting_bottom_bg);
                BNCommSettingManager.getInstance().setIsShowMapSwitch(0);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.p.1", null, null, "1");
                return;
            }
            if (i == R.id.nav_overview_road_condition_rb) {
                d.this.d.smoothScrollTo((int) d.this.g.getX(), (int) d.this.g.getY());
                d.this.j.setVisibility(4);
                d.this.g.setVisibility(0);
                d.this.h.setVisibility(0);
                d.this.i.setBackgroundResource(R.drawable.bnav_rg_custom_setting_bottom_bg);
                BNCommSettingManager.getInstance().setIsShowMapSwitch(1);
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.p.2", null, null, "1");
                return;
            }
            if (i == R.id.nav_overview_arc_condition_rb) {
                d.this.d.smoothScrollTo((int) d.this.g.getX(), (int) d.this.g.getY());
                d.this.j.setVisibility(4);
                d.this.g.setVisibility(4);
                d.this.h.setVisibility(4);
                d.this.i.setBackgroundResource(R.drawable.bnav_rg_custom_setting_bottom_road_bg);
                BNCommSettingManager.getInstance().setIsShowMapSwitch(3);
                com.baidu.navisdk.util.statistic.userop.b.r().a("35.0.1.1427", "2", null, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements b.a {
        public p() {
        }

        @Override // com.baidu.navisdk.module.newguide.settings.customguideui.b.a
        public void a(int i, boolean z) {
            ((com.baidu.navisdk.module.newguide.settings.customguideui.b) d.this.y.get(i)).a(z);
            BNCommSettingManager.getInstance().setPrefRealEnlargementNavi(z);
            if (z) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.r", "1", null, "1");
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.5.r", "2", null, "1");
            }
        }
    }

    private void A0() {
        if (this.M == null) {
            this.M = new h();
        }
    }

    private void B0() {
        RadioGroup radioGroup = this.G;
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new o());
        }
    }

    private void C0() {
        if (!b0().isEmpty()) {
            b0().clear();
        }
        b0().add(this.B);
        b0().add(this.C);
        b0().add(this.z);
    }

    private void D0() {
        int simpleGuideMode = BNCommSettingManager.getInstance().getSimpleGuideMode();
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("CustomGuideUIView", "获取的面板模式为：" + simpleGuideMode + "（0：经典模式 1：简约模式）");
        }
        if (simpleGuideMode == 0) {
            this.F.setChecked(true);
        } else if (simpleGuideMode == 1) {
            this.E.setChecked(true);
        }
        int isShowMapSwitch = BNCommSettingManager.getInstance().getIsShowMapSwitch();
        if (gVar.d()) {
            gVar.e("CustomGuideUIView", "获取的缩略图模式为：" + simpleGuideMode + "（0x0：缩略图 0x1：路况条）");
        }
        if (isShowMapSwitch == 0) {
            this.H.setChecked(true);
        } else if (isShowMapSwitch == 1) {
            this.I.setChecked(true);
        } else if (isShowMapSwitch == 3) {
            this.J.setChecked(true);
        }
        if (BNCommSettingManager.getInstance().isShowXiaoDu()) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(4);
        }
        if (BNCommSettingManager.getInstance().isShowSpeedClock()) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(4);
        }
        if (BNCommSettingManager.getInstance().isShowLaneLine()) {
            this.k.setVisibility(0);
        } else {
            this.k.setVisibility(4);
        }
        if (BNCommSettingManager.getInstance().isShowHighSpeedPanel()) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(4);
        }
        if (BNCommSettingManager.getInstance().isShowCarDirCompass()) {
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(4);
        }
        if (BNCommSettingManager.getInstance().getShowCarLogoToEnd()) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(4);
        }
        if (BNCommSettingManager.getInstance().isShowCurrentRoad()) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(4);
        }
    }

    private void E0() {
        if (!this.y.isEmpty()) {
            this.y.clear();
        }
        this.y.add(new com.baidu.navisdk.module.newguide.settings.customguideui.b(R.drawable.nsdk_custom_guide_road_enlarge, "路口放大图", new p(), BNCommSettingManager.getInstance().getPrefRealEnlargementNavi()));
        this.y.add(new com.baidu.navisdk.module.newguide.settings.customguideui.b(R.drawable.nsdk_custom_guide_lane_line, "路口车道线", new a(), BNCommSettingManager.getInstance().isShowLaneLine()));
        this.y.add(new com.baidu.navisdk.module.newguide.settings.customguideui.b(R.drawable.nsdk_custom_guide_speed_clock, "速度码表", new b(), BNCommSettingManager.getInstance().isShowSpeedClock()));
        this.y.add(new com.baidu.navisdk.module.newguide.settings.customguideui.b(R.drawable.nsdk_custom_guide_highway_info, "高速信息", new c(), BNCommSettingManager.getInstance().isShowHighSpeedPanel()));
        this.y.add(new com.baidu.navisdk.module.newguide.settings.customguideui.b(R.drawable.nsdk_custom_guide_road_name, "当前路名", new C0252d(), BNCommSettingManager.getInstance().isShowCurrentRoad()));
        this.y.add(new com.baidu.navisdk.module.newguide.settings.customguideui.b(R.drawable.nsdk_custom_guide_compass, "方向罗盘", new e(), BNCommSettingManager.getInstance().isShowCarDirCompass()));
        this.y.add(new com.baidu.navisdk.module.newguide.settings.customguideui.b(R.drawable.nsdk_custom_guide_red_line, "终点连线", new f(), BNCommSettingManager.getInstance().getShowCarLogoToEnd()));
        if (com.baidu.navisdk.j.d()) {
            this.y.add(new com.baidu.navisdk.module.newguide.settings.customguideui.b(R.drawable.nsdk_custom_guide_xiaodu, "小度语音", new g(), BNCommSettingManager.getInstance().isShowXiaoDu()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        if (this.k != null) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.c);
            constraintSet.connect(this.k.getId(), 3, this.e.getId(), 4);
            constraintSet.applyTo(this.c);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.setMargins(0, 15, 0, 0);
            this.k.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        if (this.k != null) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.c);
            constraintSet.connect(this.k.getId(), 3, this.f.getId(), 3);
            constraintSet.applyTo(this.c);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.setMarginStart(0);
            layoutParams.setMargins(0, 0, 0, 0);
            this.k.setLayoutParams(layoutParams);
        }
    }

    public void C() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("CustomGuideUIView", "curline移动前的translationX为：" + this.r.getTranslationX());
        }
        View view = this.r;
        ObjectAnimator.ofFloat(view, "translationX", view.getTranslationX(), this.s.getX()).setDuration(250L).start();
        this.s.setTypeface(Typeface.defaultFromStyle(1));
        this.u.setTypeface(Typeface.defaultFromStyle(0));
        this.t.setTypeface(Typeface.defaultFromStyle(0));
        if (gVar.d()) {
            gVar.e("CustomGuideUIView", "curline移动后的translationX为：" + this.r.getTranslationX());
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.pronavi.d
    public void a(com.baidu.navisdk.framework.interfaces.l lVar) {
    }

    public ArrayList<View> b0() {
        return this.x;
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public boolean onBackPressed() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.con_board) {
            this.v.setCurrentItem(0);
            if (this.r.getTranslationX() != this.s.getX()) {
                C();
            }
        }
        if (view.getId() == R.id.con_road) {
            this.v.setCurrentItem(1);
            if (this.r.getTranslationX() != this.u.getX()) {
                x0();
            }
        }
        if (view.getId() == R.id.con_image) {
            this.v.setCurrentItem(2);
            if (this.r.getTranslationX() != this.t.getX()) {
                v0();
            }
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onDestroy() {
        if (com.baidu.navisdk.j.d()) {
            com.baidu.navisdk.module.asr.a.b().a(true);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onPause() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onResume() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onStart() {
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void onStop() {
    }

    public void v0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("CustomGuideUIView", "curline移动前的translationX为：" + this.r.getTranslationX());
        }
        View view = this.r;
        ObjectAnimator.ofFloat(view, "translationX", view.getTranslationX(), this.t.getX()).setDuration(250L).start();
        this.s.setTypeface(Typeface.defaultFromStyle(0));
        this.u.setTypeface(Typeface.defaultFromStyle(0));
        this.t.setTypeface(Typeface.defaultFromStyle(1));
        if (gVar.d()) {
            gVar.e("CustomGuideUIView", "curline移动后的translationX为：" + this.r.getTranslationX());
        }
    }

    public void x0() {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("CustomGuideUIView", "curline移动前的translationX为：" + this.r.getTranslationX());
        }
        View view = this.r;
        ObjectAnimator.ofFloat(view, "translationX", view.getTranslationX(), this.u.getX()).setDuration(250L).start();
        this.s.setTypeface(Typeface.defaultFromStyle(0));
        this.u.setTypeface(Typeface.defaultFromStyle(1));
        this.t.setTypeface(Typeface.defaultFromStyle(0));
        if (gVar.d()) {
            gVar.e("CustomGuideUIView", "curline移动后的translationX为：" + this.r.getTranslationX());
        }
    }

    private View b(Context context, View view) {
        this.L = context;
        View a2 = a(context, view);
        if (a2 == null) {
            return null;
        }
        E0();
        D0();
        B0();
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("CustomGuideUIView", "onDayNightChanged: " + z);
        }
        BNCommonTitleBar bNCommonTitleBar = this.b;
        if (bNCommonTitleBar != null) {
            if (z) {
                bNCommonTitleBar.setLeftImageViewSrc(com.baidu.navisdk.ui.util.b.f(R.drawable.bnav_common_titlebar_ic_back_new));
            } else {
                bNCommonTitleBar.setLeftImageViewSrc(com.baidu.navisdk.ui.util.b.c(R.drawable.bnav_titlebar_ic_back_normal, false));
            }
            this.b.setTitleBarBackgroundColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_rg_custom_default_white, z));
            this.b.setMiddleTextColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_rg_custom_title_color, z));
            this.b.setTitleBarDivideLineBackgroudColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_rg_custom_divide_line_color, z));
        }
        View view = this.f7240a;
        if (view != null) {
            view.setBackgroundColor(com.baidu.navisdk.ui.util.b.a(R.color.nsdk_rg_custom_default_white, z));
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public void a(Context context, Bundle bundle) {
        A0();
        if (com.baidu.navisdk.j.d()) {
            com.baidu.navisdk.module.asr.a.b().a(false);
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.i
    public View a(Activity activity, Bundle bundle, View view) {
        if (this.v != null) {
            com.baidu.navisdk.util.common.g.PRO_NAV.e("CustomGuideUIView", "onCreateView(),mPager.getCurrentItem():" + this.v.getCurrentItem());
        }
        return b(activity, view);
    }

    private View a(Context context, View view) {
        View a2 = com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_custom_guide, (ViewGroup) view, false);
        if (a2 == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.c()) {
                gVar.c("CustomGuideUIView", "onCreateView view == null");
            }
            if (!gVar.b()) {
                return null;
            }
            gVar.a("CustomGuideUIView", new Exception("view == null"));
            return null;
        }
        a2.setOnClickListener(this);
        this.f7240a = a2.findViewById(R.id.ugc_map_report_statusbar_view);
        BNCommonTitleBar bNCommonTitleBar = (BNCommonTitleBar) a2.findViewById(R.id.custom_navi_title_bar);
        this.b = bNCommonTitleBar;
        bNCommonTitleBar.setLeftOnClickedListener(new i(context));
        this.c = (ConstraintLayout) a2.findViewById(R.id.custom_navi_base_page);
        this.d = (ScrollView) a2.findViewById(R.id.panel);
        this.e = a2.findViewById(R.id.top_panel);
        this.f = a2.findViewById(R.id.simple_top_panel);
        this.g = a2.findViewById(R.id.road_condition);
        this.h = a2.findViewById(R.id.road_condition_logo);
        this.j = (ImageView) a2.findViewById(R.id.custom_navi_thumbnail);
        this.i = a2.findViewById(R.id.road_new_prediction_info);
        this.l = a2.findViewById(R.id.speed_clock);
        this.q = (ImageView) a2.findViewById(R.id.xd_voice_btn);
        this.k = (LinearLayout) a2.findViewById(R.id.custom_lane_line);
        this.o = (TextView) a2.findViewById(R.id.road_name);
        this.p = (ImageView) a2.findViewById(R.id.compass);
        this.n = a2.findViewById(R.id.highway_info);
        View findViewById = a2.findViewById(R.id.red_line);
        this.m = findViewById;
        findViewById.post(new j());
        this.s = (TextView) a2.findViewById(R.id.con_board);
        this.t = (TextView) a2.findViewById(R.id.con_image);
        this.u = (TextView) a2.findViewById(R.id.con_road);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.r = a2.findViewById(R.id.cur_line);
        this.v = (ViewPager) a2.findViewById(R.id.custom_pager);
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
        if (gVar2.d()) {
            gVar2.e("CustomGuideUIView", "initView(),mPager.getCurrentItem():" + this.v.getCurrentItem());
        }
        View a3 = com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_custom_board, this.v, false);
        this.B = a3;
        RadioGroup radioGroup = (RadioGroup) a3.findViewById(R.id.nav_simple_guide_mode_selector_rg);
        this.D = radioGroup;
        radioGroup.setOnCheckedChangeListener(new k());
        this.F = (RadioButton) this.B.findViewById(R.id.nav_default_mode_rb);
        this.E = (RadioButton) this.B.findViewById(R.id.nav_simple_mode_rb);
        View a4 = com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_custom_road, this.v, false);
        this.C = a4;
        this.G = (RadioGroup) a4.findViewById(R.id.nav_view_overview_selector_rg);
        this.H = (RadioButton) this.C.findViewById(R.id.nav_overview_thumbnail_rb);
        this.I = (RadioButton) this.C.findViewById(R.id.nav_overview_road_condition_rb);
        this.J = (RadioButton) this.C.findViewById(R.id.nav_overview_arc_condition_rb);
        this.z = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, false);
        this.K = linearLayoutManager;
        this.z.setLayoutManager(linearLayoutManager);
        com.baidu.navisdk.module.newguide.settings.customguideui.a aVar = new com.baidu.navisdk.module.newguide.settings.customguideui.a(this.y, context);
        this.A = aVar;
        aVar.a(new l());
        this.z.setAdapter(this.A);
        C0();
        this.w = new m();
        this.v.addOnPageChangeListener(new n());
        this.v.setAdapter(this.w);
        q(com.baidu.navisdk.ui.util.b.b());
        return a2;
    }
}
