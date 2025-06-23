package com.baidu.navisdk.ui.roadcondition.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.m;
import com.baidu.navisdk.ui.widget.BNStrokeTextView;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class BNSmartRoadConditionLayout extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    private BNStrokeTextView f8414a;
    private BNRoadConditionView b;
    private FrameLayout c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private View.OnClickListener j;
    private ArrayList<com.baidu.navisdk.ui.roadcondition.a> k;
    private com.baidu.navisdk.ui.roadcondition.i.a l;
    private List<com.baidu.navisdk.module.pronavi.model.c> m;
    private List<com.baidu.navisdk.ui.roadcondition.b> n;
    private View.OnLayoutChangeListener o;
    private com.baidu.navisdk.util.worker.lite.b p;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar = g.COMMON_UI;
            if (gVar.d()) {
                gVar.e("BNSmartRoadConditionLay", "mTypeDescText onClick: ");
            }
            BNSmartRoadConditionLayout.this.e(1);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BNSmartRoadConditionLayout.this.e(2);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BNSmartRoadConditionLayout.this.a(view);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnLayoutChangeListener {

        /* loaded from: classes8.dex */
        public class a extends com.baidu.navisdk.util.worker.lite.b {
            public a(String str) {
                super(str);
            }

            @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
            public void run() {
                if (BNSmartRoadConditionLayout.this.b != null) {
                    BNSmartRoadConditionLayout.this.b.a();
                }
                BNSmartRoadConditionLayout.this.f(4);
            }
        }

        public d() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (i4 - i2 != i8 - i6) {
                g gVar = g.COMMON_UI;
                if (gVar.d()) {
                    gVar.e("BNSmartRoadConditionLay", "jam-onLayoutChange: " + i4 + ", " + i2 + ":" + i8 + ", " + i6);
                }
                if (BNSmartRoadConditionLayout.this.p != null) {
                    com.baidu.navisdk.util.worker.lite.a.a(BNSmartRoadConditionLayout.this.p);
                }
                if (BNSmartRoadConditionLayout.this.p == null) {
                    BNSmartRoadConditionLayout.this.p = new a("JamIconLayout");
                }
                com.baidu.navisdk.util.worker.lite.a.c(BNSmartRoadConditionLayout.this.p);
            }
        }
    }

    public BNSmartRoadConditionLayout(Context context) {
        this(context, null);
    }

    private int a(int i, int i2) {
        return 5;
    }

    private boolean c(com.baidu.navisdk.module.pronavi.model.c cVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "isContainJamArray: " + cVar);
        }
        List<com.baidu.navisdk.module.pronavi.model.c> list = this.m;
        if (list != null && !list.isEmpty()) {
            for (com.baidu.navisdk.module.pronavi.model.c cVar2 : this.m) {
                if (cVar2 != null && cVar2.b(cVar)) {
                    cVar.a(cVar2);
                    return true;
                }
            }
        }
        return false;
    }

    private com.baidu.navisdk.ui.roadcondition.a d(int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "loadJamLabelView index:" + i);
        }
        if (this.k == null) {
            this.k = new ArrayList<>(3);
        }
        com.baidu.navisdk.ui.roadcondition.a aVar = i < this.k.size() ? this.k.get(i) : null;
        if (aVar != null) {
            return aVar;
        }
        com.baidu.navisdk.ui.roadcondition.a aVar2 = new com.baidu.navisdk.ui.roadcondition.a();
        View a2 = a(getContext(), R.layout.bn_layout_rg_road_condition_jam_label, (ViewGroup) this.c, false, false);
        aVar2.f8410a = a2;
        TextView textView = (TextView) a2.findViewById(R.id.bn_rg_road_jam_label_distance);
        aVar2.b = textView;
        aVar2.c = (ImageView) a2.findViewById(R.id.bn_rg_road_jam_label_type);
        textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_text_padding_end), textView.getPaddingBottom());
        this.k.add(aVar2);
        return aVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "handlerSwitchType: ");
        }
        if (com.baidu.navisdk.ui.util.g.a()) {
            return;
        }
        BNRoadConditionView bNRoadConditionView = this.b;
        if (bNRoadConditionView != null) {
            r3 = bNRoadConditionView.getType() == 0 ? 1 : 0;
            a(r3);
            com.baidu.navisdk.ui.roadcondition.i.a aVar = this.l;
            if (aVar != null) {
                aVar.a(i, r3);
            }
        }
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "handlerSwitchType currentType: " + r3);
        }
    }

    private void f() {
        this.d = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_road_condition_bar_width);
        int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_icon_big_width);
        int dimensionPixelSize2 = JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_big_height);
        this.e = dimensionPixelSize2;
        this.f = dimensionPixelSize2 / 2;
        this.g = (this.d - dimensionPixelSize) / 2;
        int dimensionPixelSize3 = JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_icon_normal_width);
        this.h = JarUtils.getResources().getDimensionPixelSize(R.dimen.bn_rg_road_condition_label_normal_height) / 2;
        this.i = (this.d - dimensionPixelSize3) / 2;
    }

    private void g() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "updateJamPriority: ");
        }
        List<com.baidu.navisdk.module.pronavi.model.c> list = this.m;
        if (list != null && !list.isEmpty() && this.m.size() >= 2) {
            com.baidu.navisdk.module.pronavi.model.c cVar = null;
            int i = -1;
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                if (cVar == null) {
                    cVar = this.m.get(i2);
                    i = i2;
                } else {
                    com.baidu.navisdk.module.pronavi.model.c cVar2 = this.m.get(i2);
                    if (cVar2 != null && cVar2.d < cVar.d) {
                        i = i2;
                        cVar = cVar2;
                    }
                }
            }
            if (i >= 0 && i < this.m.size()) {
                this.m.add(0, this.m.remove(i));
            }
        }
    }

    private int getShowedJamLabelCount() {
        List<com.baidu.navisdk.ui.roadcondition.b> list = this.n;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private void h() {
        String str;
        BNRoadConditionView bNRoadConditionView = this.b;
        if (bNRoadConditionView != null && this.f8414a != null) {
            if (bNRoadConditionView.getType() == 1) {
                str = "剩余";
            } else {
                str = "全程";
            }
            this.f8414a.setText(str);
        }
    }

    public int getRoadConditionHeight() {
        BNRoadConditionView bNRoadConditionView = this.b;
        if (bNRoadConditionView != null) {
            return bNRoadConditionView.getViewHeight();
        }
        return 0;
    }

    public View getRoadConditionView() {
        return this.b;
    }

    public int getRoadConditionWidth() {
        return this.d;
    }

    public void setClickListener(com.baidu.navisdk.ui.roadcondition.i.a aVar) {
        this.l = aVar;
    }

    public BNSmartRoadConditionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BNSmartRoadConditionLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
        f();
    }

    public void b(List<m> list) {
        if (this.b != null) {
            if (list != null && !list.isEmpty()) {
                this.b.a(list);
            } else {
                this.b.d();
            }
            this.b.invalidate();
        }
    }

    public void a(Context context) {
        a(context, R.layout.nsdk_layout_rg_road_condition_view, (ViewGroup) this, true, false);
        this.f8414a = (BNStrokeTextView) findViewById(R.id.bn_rg_roadcondition_type_desc);
        this.b = (BNRoadConditionView) findViewById(R.id.bnav_rg_cp_roadconditionbar);
        this.c = (FrameLayout) findViewById(R.id.bn_rg_roadcondition_icon_layout);
        this.f8414a.setOnClickListener(new a());
        this.b.setOnClickListener(new b());
        h();
        c();
        e();
        this.c.addOnLayoutChangeListener(this.o);
    }

    @Nullable
    private com.baidu.navisdk.ui.roadcondition.b c(int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "getClickJamModel: " + i);
        }
        List<com.baidu.navisdk.ui.roadcondition.b> list = this.n;
        if (list != null && !list.isEmpty()) {
            if (gVar.d()) {
                gVar.e("BNSmartRoadConditionLay", "getClickJamModel: " + Arrays.toString(this.n.toArray()));
            }
            for (com.baidu.navisdk.ui.roadcondition.b bVar : this.n) {
                if (bVar != null && bVar.a() && bVar.b.f == i) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private boolean b(int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "calculateOptimalJam: " + i);
        }
        List<com.baidu.navisdk.module.pronavi.model.c> list = this.m;
        if (list != null && !list.isEmpty()) {
            BNRoadConditionView bNRoadConditionView = this.b;
            if (bNRoadConditionView == null) {
                if (gVar.c()) {
                    gVar.c("BNSmartRoadConditionLay", "calculateOptimalJam: mRoadConditionView = null");
                }
                List<com.baidu.navisdk.ui.roadcondition.b> list2 = this.n;
                if (list2 != null) {
                    list2.clear();
                }
                return true;
            }
            int showJamIconHeight = bNRoadConditionView.getShowJamIconHeight();
            int min = Math.min(showJamIconHeight / this.e, 3);
            if (gVar.d()) {
                gVar.e("BNSmartRoadConditionLay", "calculateOptimalJam canShowLabelCount: " + min + ",showLabelTotalHeight: " + showJamIconHeight + ",roadViewHeight:" + this.b.getViewHeight());
            }
            if (gVar.c() && showJamIconHeight <= 0) {
                gVar.c("calculateOptimalJam canShowLabelCount1: " + min + ",showLabelTotalHeight: " + showJamIconHeight + ",roadViewHeight:" + this.b.getViewHeight());
            }
            if (min <= 0) {
                List<com.baidu.navisdk.ui.roadcondition.b> list3 = this.n;
                if (list3 != null) {
                    list3.clear();
                }
                g gVar2 = g.PRO_NAV;
                if (gVar2.c()) {
                    gVar2.c("BNSmartRoadConditionLay", "calculateOptimalJam: canShowLabelCount == 0");
                }
                return true;
            }
            int viewHeight = this.b.getViewHeight();
            int carCurrentAddDist = this.b.getCarCurrentAddDist();
            int a2 = a(showJamIconHeight, this.e);
            if (gVar.d()) {
                gVar.e("BNSmartRoadConditionLay", "calculateOptimalJam carAddDist: " + carCurrentAddDist + ", labelViewMinPadding:" + a2 + ",showLabelTotalHeight: " + showJamIconHeight);
            }
            int showedJamLabelCount = getShowedJamLabelCount();
            a(carCurrentAddDist, i, a2, viewHeight);
            if (i == 3 && showedJamLabelCount != getShowedJamLabelCount()) {
                if (gVar.d()) {
                    gVar.e("BNSmartRoadConditionLay", "calculateOptimalJam 由于驶过导致最近拥堵的优先级变高");
                }
                g();
            }
            if (this.n == null) {
                this.n = new ArrayList(3);
            }
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                if (this.n.size() >= min) {
                    g gVar3 = g.COMMON_UI;
                    if (!gVar3.d()) {
                        return true;
                    }
                    gVar3.e("BNSmartRoadConditionLay", "calculateOptimalJam: " + this.n.size() + ", index:" + i2);
                    return true;
                }
                com.baidu.navisdk.module.pronavi.model.c cVar = this.m.get(i2);
                if (cVar != null && cVar.c()) {
                    int b2 = b(cVar);
                    if (a(carCurrentAddDist, cVar, b2 - this.f, a2, viewHeight)) {
                        g gVar4 = g.COMMON_UI;
                        if (gVar4.d()) {
                            gVar4.e("BNSmartRoadConditionLay", "calculateOptimalJam: 碰撞掉： " + i2 + ", " + cVar + ",showMarginBottom: " + b2 + ",mBigLabelHalfHeight: " + this.f + ",roadConditionHeight: " + viewHeight + ",labelViewMinPadding: " + a2);
                        }
                    } else {
                        com.baidu.navisdk.ui.roadcondition.b bVar = new com.baidu.navisdk.ui.roadcondition.b();
                        bVar.a(cVar);
                        bVar.c = b2 - this.h;
                        bVar.d = this.i;
                        bVar.f = this.g;
                        bVar.e = b2 - this.f;
                        this.n.add(bVar);
                    }
                } else {
                    g gVar5 = g.COMMON_UI;
                    if (gVar5.d()) {
                        gVar5.e("BNSmartRoadConditionLay", "calculateOptimalJam: jamModel invalid");
                    }
                }
            }
            return true;
        }
        List<com.baidu.navisdk.ui.roadcondition.b> list4 = this.n;
        if (list4 != null) {
            list4.clear();
        }
        g gVar6 = g.PRO_NAV;
        if (!gVar6.c()) {
            return true;
        }
        gVar6.c("BNSmartRoadConditionLay", "calculateOptimalJam: mJamModelList is empty ");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "updateAllJamLabel updateSource: " + i);
        }
        if (this.c == null) {
            return;
        }
        List<com.baidu.navisdk.module.pronavi.model.c> list = this.m;
        if (list != null && !list.isEmpty()) {
            if (gVar.d()) {
                gVar.e("BNSmartRoadConditionLay", "updateJamLabel: " + Arrays.toString(this.m.toArray()));
            }
            boolean b2 = b(i);
            g gVar2 = g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("BNSmartRoadConditionLay", "updateAllJamLabel calculateOptimalJam result: " + b2);
            }
            if (!b2) {
                if (gVar2.c()) {
                    gVar2.c("BNSmartRoadConditionLay", "updateAllJamLabel: not need update");
                    return;
                }
                return;
            }
            List<com.baidu.navisdk.ui.roadcondition.b> list2 = this.n;
            if (list2 != null && !list2.isEmpty()) {
                if (gVar.d()) {
                    gVar.e("BNSmartRoadConditionLay", "updateAllJamLabel mShowedJamModelList size: " + this.n.size());
                }
                d();
                int i2 = 0;
                for (com.baidu.navisdk.ui.roadcondition.b bVar : this.n) {
                    g gVar3 = g.PRO_NAV;
                    if (gVar3.d()) {
                        gVar3.e("BNSmartRoadConditionLay", "updateJamLabel: " + bVar);
                    }
                    if (bVar != null && bVar.a()) {
                        com.baidu.navisdk.ui.roadcondition.a d2 = d(i2);
                        if (d2.a(bVar, this.c)) {
                            bVar.f8411a = d2;
                            d2.f8410a.setOnClickListener(this.j);
                            d2.f8410a.requestLayout();
                        }
                        i2++;
                    }
                }
                ArrayList<com.baidu.navisdk.ui.roadcondition.a> arrayList = this.k;
                if (arrayList != null) {
                    int size = arrayList.size();
                    while (i2 < size) {
                        com.baidu.navisdk.ui.roadcondition.a aVar = this.k.get(i2);
                        if (aVar != null) {
                            aVar.c();
                        }
                        i2++;
                    }
                    return;
                }
                return;
            }
            this.c.removeAllViews();
            if (gVar.c()) {
                gVar.c("BNSmartRoadConditionLay", "updateJamLabel: mShowJamModelList is empty");
                return;
            }
            return;
        }
        this.c.removeAllViews();
        List<com.baidu.navisdk.ui.roadcondition.b> list3 = this.n;
        if (list3 != null) {
            list3.clear();
        }
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "updateJamLabel: jamModelList is empty");
        }
    }

    private void e() {
        if (this.o == null) {
            this.o = new d();
        }
    }

    public void c() {
        BNStrokeTextView bNStrokeTextView = this.f8414a;
        if (bNStrokeTextView != null) {
            bNStrokeTextView.setStrokeColor(com.baidu.navisdk.ui.util.b.b(R.color.bn_road_condition_desc_stroke_color));
            this.f8414a.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.bn_road_condition_desc_color));
        }
    }

    public void a(List<m> list, List<com.baidu.navisdk.module.pronavi.model.c> list2, double d2) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "updateRoadCondition: ");
        }
        BNRoadConditionView bNRoadConditionView = this.b;
        if (bNRoadConditionView != null) {
            bNRoadConditionView.a(d2);
            b(list);
        }
        a(list2);
    }

    private void d() {
        if (this.j == null) {
            this.j = new c();
        }
    }

    public void a(List<com.baidu.navisdk.module.pronavi.model.c> list) {
        this.m = list;
        f(2);
    }

    public void a(double d2) {
        BNRoadConditionView bNRoadConditionView = this.b;
        if (bNRoadConditionView != null) {
            bNRoadConditionView.a(d2);
            f(3);
            this.b.invalidate();
        }
    }

    public void a(int i) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "updateRoadConditionType: " + i);
        }
        BNRoadConditionView bNRoadConditionView = this.b;
        if (bNRoadConditionView != null) {
            bNRoadConditionView.c(i);
            this.b.invalidate();
            h();
            f(1);
        }
    }

    public void a(Rect rect) {
        BNRoadConditionView bNRoadConditionView = this.b;
        if (bNRoadConditionView != null) {
            bNRoadConditionView.getGlobalVisibleRect(rect);
        }
    }

    public void a() {
        com.baidu.navisdk.util.worker.lite.b bVar = this.p;
        if (bVar != null) {
            com.baidu.navisdk.util.worker.lite.a.a(bVar);
            this.p = null;
        }
        FrameLayout frameLayout = this.c;
        if (frameLayout != null) {
            frameLayout.removeOnLayoutChangeListener(this.o);
            this.c.removeAllViews();
            this.c = null;
        }
        BNStrokeTextView bNStrokeTextView = this.f8414a;
        if (bNStrokeTextView != null) {
            bNStrokeTextView.setOnClickListener(null);
        }
        BNRoadConditionView bNRoadConditionView = this.b;
        if (bNRoadConditionView != null) {
            bNRoadConditionView.setOnClickListener(null);
            this.b.b();
            this.b = null;
        }
        ArrayList<com.baidu.navisdk.ui.roadcondition.a> arrayList = this.k;
        if (arrayList != null) {
            Iterator<com.baidu.navisdk.ui.roadcondition.a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.k.clear();
        }
        this.j = null;
        this.l = null;
    }

    private void a(int i, int i2, int i3, int i4) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "updateShowedJamModel: " + i + ",updateSource: " + i2 + ",labelMinPadding: " + i3 + ",roadViewHeight: " + i4);
        }
        List<com.baidu.navisdk.ui.roadcondition.b> list = this.n;
        if (list == null || list.isEmpty()) {
            return;
        }
        int i5 = 0;
        com.baidu.navisdk.ui.roadcondition.b bVar = null;
        if (i2 == 2) {
            while (true) {
                if (i5 < this.n.size()) {
                    com.baidu.navisdk.ui.roadcondition.b bVar2 = this.n.get(i5);
                    if (bVar2 != null && bVar2.a() && bVar2.g) {
                        bVar = bVar2;
                        break;
                    }
                    i5++;
                } else {
                    break;
                }
            }
            this.n.clear();
            if (bVar == null || !c(bVar.b)) {
                return;
            }
            this.n.add(bVar);
            return;
        }
        ArrayList arrayList = new ArrayList(this.n);
        this.n.clear();
        int i6 = 0;
        while (true) {
            if (i6 < arrayList.size()) {
                com.baidu.navisdk.ui.roadcondition.b bVar3 = (com.baidu.navisdk.ui.roadcondition.b) arrayList.get(i6);
                if (bVar3 != null && bVar3.a() && bVar3.g) {
                    arrayList.remove(i6);
                    bVar = bVar3;
                    break;
                }
                i6++;
            } else {
                break;
            }
        }
        if (bVar != null) {
            int b2 = b(bVar.b);
            bVar.c = b2 - this.h;
            int i7 = b2 - this.f;
            bVar.e = i7;
            if (!a(i, bVar.b, i7, i3, i4)) {
                this.n.add(bVar);
            } else {
                g gVar2 = g.PRO_NAV;
                if (gVar2.d()) {
                    gVar2.e("BNSmartRoadConditionLay", "updateShowedJamModel 碰撞掉2: " + bVar);
                }
            }
        }
        while (i5 < arrayList.size()) {
            com.baidu.navisdk.ui.roadcondition.b bVar4 = (com.baidu.navisdk.ui.roadcondition.b) arrayList.get(i5);
            if (bVar4 != null && bVar4.a()) {
                int b3 = b(bVar4.b);
                bVar4.c = b3 - this.h;
                int i8 = b3 - this.f;
                bVar4.e = i8;
                if (!a(i, bVar4.b, i8, i3, i4)) {
                    this.n.add(bVar4);
                } else {
                    g gVar3 = g.PRO_NAV;
                    if (gVar3.d()) {
                        gVar3.e("BNSmartRoadConditionLay", "updateShowedJamModel 碰撞掉1: " + bVar4 + ",roadViewHeight:" + i4);
                    }
                }
            }
            i5++;
        }
    }

    private int b(com.baidu.navisdk.module.pronavi.model.c cVar) {
        BNRoadConditionView bNRoadConditionView = this.b;
        if (bNRoadConditionView == null || cVar == null) {
            return -1;
        }
        return bNRoadConditionView.a(cVar.a());
    }

    private boolean b(int i, int i2) {
        List<com.baidu.navisdk.ui.roadcondition.b> list = this.n;
        if (list == null || list.isEmpty()) {
            return true;
        }
        int i3 = i2 + this.e;
        Iterator<com.baidu.navisdk.ui.roadcondition.b> it = this.n.iterator();
        while (it.hasNext()) {
            if (Math.abs(i - it.next().c) < i3) {
                return false;
            }
        }
        return true;
    }

    public void b() {
        com.baidu.navisdk.ui.roadcondition.a aVar;
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "resetBigLabel: ");
        }
        List<com.baidu.navisdk.ui.roadcondition.b> list = this.n;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (com.baidu.navisdk.ui.roadcondition.b bVar : this.n) {
            if (bVar != null && (aVar = bVar.f8411a) != null && bVar.g) {
                bVar.g = false;
                aVar.b(bVar);
            }
        }
    }

    private boolean a(int i, com.baidu.navisdk.module.pronavi.model.c cVar, int i2, int i3, int i4) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "isCollision: ");
        }
        if (i2 < 0) {
            if (gVar.d()) {
                gVar.e("BNSmartRoadConditionLay", "isCollision: marginBottom < 0");
            }
            return true;
        }
        if (this.e + i2 > i4) {
            if (gVar.d()) {
                gVar.e("BNSmartRoadConditionLay", "isCollision 超出路况条：" + i2 + ",mBigLabelHeight: " + this.e + ",roadConditionHeight: " + i4);
            }
            return true;
        }
        if (cVar.a(i)) {
            if (gVar.d()) {
                gVar.e("BNSmartRoadConditionLay", "isCollision: 车标驶到拥堵路段");
            }
            return true;
        }
        if (this.b.b(i2)) {
            if (gVar.d()) {
                gVar.e("BNSmartRoadConditionLay", "isCollision: 车标压盖");
            }
            return true;
        }
        if (b(i2, i3)) {
            return false;
        }
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "isCollision: padding 不对");
        }
        return true;
    }

    public View a(Context context, int i, ViewGroup viewGroup, boolean z, boolean z2) {
        if (z2) {
            return com.baidu.navisdk.ui.util.b.a(context, i, viewGroup, z);
        }
        return LayoutInflater.from(context).inflate(i, viewGroup, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        g gVar = g.COMMON_UI;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "handlerClickLabel: " + view);
        }
        if (this.l != null) {
            com.baidu.navisdk.ui.roadcondition.b c2 = c(((Integer) view.getTag()).intValue());
            if (gVar.d()) {
                gVar.e("BNSmartRoadConditionLay", "handlerClickLabel: " + c2);
            }
            if (c2 == null || !this.l.a(c2.b)) {
                return;
            }
            c2.g = true;
            com.baidu.navisdk.ui.roadcondition.a aVar = c2.f8411a;
            if (aVar != null) {
                aVar.a(c2);
            }
        }
    }

    public void a(com.baidu.navisdk.module.pronavi.model.c cVar) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNSmartRoadConditionLay", "showBigLabel: " + cVar);
        }
        List<com.baidu.navisdk.ui.roadcondition.b> list = this.n;
        if (list == null || list.isEmpty() || cVar == null) {
            return;
        }
        for (com.baidu.navisdk.ui.roadcondition.b bVar : this.n) {
            if (cVar.b(bVar.b)) {
                bVar.g = true;
                bVar.f8411a.a(bVar);
            }
        }
    }
}
