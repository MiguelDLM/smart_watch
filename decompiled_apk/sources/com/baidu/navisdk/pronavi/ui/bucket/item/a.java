package com.baidu.navisdk.pronavi.ui.bucket.item;

import OXOo.OOXIXo;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.k;
import com.baidu.navisdk.pronavi.ui.bucket.config.d;
import com.baidu.navisdk.pronavi.widget.RGImageTextBtn;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.widget.bucket.BNBucketItem;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import kotlin.Pair;

/* loaded from: classes7.dex */
public abstract class a extends BNBucketItem {

    /* renamed from: a, reason: collision with root package name */
    protected com.baidu.navisdk.pronavi.ui.base.b f7853a;
    private String[] b;
    protected int c;
    protected boolean d;
    protected com.baidu.navisdk.pronavi.style.i.a e;

    public a(com.baidu.navisdk.pronavi.ui.base.b bVar, d dVar) {
        super(dVar.f7852a, dVar.c, dVar.d);
        this.f7853a = bVar;
        this.c = dVar.f;
        this.d = dVar.g;
        setItemLocation(dVar.e);
        setType(dVar.b);
        setPriorityForGone(dVar.h);
        setSupportPriorityGone(dVar.i);
    }

    private boolean v() {
        if (this.b == null) {
            this.b = r();
        }
        if (this.b == null) {
            return false;
        }
        String m = this.f7853a.m();
        for (String str : this.b) {
            if (str.equals(m)) {
                return true;
            }
        }
        return false;
    }

    public abstract View a(@OOXIXo ViewGroup viewGroup, int i, @OOXIXo Context context);

    public void a(boolean z) {
    }

    public boolean b(int i) {
        return i != 2;
    }

    public abstract int c(int i);

    public com.baidu.navisdk.ui.routeguide.subview.a c() {
        return this.f7853a.w();
    }

    public String d() {
        return getClass().getName();
    }

    public boolean e() {
        return true;
    }

    public boolean f() {
        k u = this.f7853a.u();
        if (u != null && u.X()) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        k u = this.f7853a.u();
        if (u != null && u.p()) {
            return true;
        }
        return false;
    }

    public boolean k() {
        k u = this.f7853a.u();
        if (u != null && u.U()) {
            return true;
        }
        return false;
    }

    public boolean l() {
        k u = this.f7853a.u();
        if (u != null && u.v()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void loadBucketItem(@OOXIXo ViewGroup viewGroup, int i, @OOXIXo Context context) {
        super.loadBucketItem(viewGroup, i, context);
        View a2 = a(viewGroup, i, context);
        setView(a2);
        c(a2, a(i, this.d));
        a(i);
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        return false;
    }

    public boolean o() {
        return false;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onDestroy() {
        super.onDestroy();
        this.e = null;
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public void onRefreshViewStyle(int i) {
        super.onRefreshViewStyle(i);
        c(getView(), a(i, this.d));
        a(i);
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public int onVisibility(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(d(), "RGBucketBaseItem onVisibility: " + i + "," + toString());
        }
        if (isGoneByPriority()) {
            if (gVar.d()) {
                gVar.e(d(), "onVisibility: isGoneByPriority");
            }
            return 8;
        }
        int i2 = this.c;
        if (i2 != 0 && i != i2) {
            if (gVar.d()) {
                gVar.e(d(), "onVisibility mShowedOrientation: " + this.c + ", " + i);
            }
            return 8;
        }
        if (!o() && this.f7853a.C()) {
            if (gVar.d()) {
                gVar.e(d(), "onVisibility base: is mock navi ");
            }
            return 8;
        }
        if (v()) {
            if (gVar.d()) {
                gVar.e(d(), "onVisibility base: is isHideInState: " + b());
            }
            return 8;
        }
        String m = this.f7853a.m();
        if (!p() && (RGFSMTable.FsmState.IndoorPark.equals(m) || RGFSMTable.FsmState.IndoorParkBrowse.equals(m) || RGFSMTable.FsmState.IndoorParkChoose.equals(m))) {
            if (gVar.d()) {
                gVar.e(d(), "onVisibility base: is park ");
            }
            return 8;
        }
        if (!n() && this.f7853a.z()) {
            if (gVar.d()) {
                gVar.e(d(), "onVisibility: isARNavi");
            }
            return 8;
        }
        int p = this.f7853a.p();
        if (gVar.d()) {
            gVar.e(d(), "visibility hdNaviState: " + p);
        }
        if (h() && this.f7853a.a(p)) {
            if (gVar.d()) {
                gVar.e(d(), "onVisibility: isHDNavi");
            }
            return 8;
        }
        if (g() && p == 3) {
            if (gVar.d()) {
                gVar.e(d(), "onVisibility: isHideInHDFullScreenNavi");
            }
            return 8;
        }
        if (i() && this.f7853a.D()) {
            if (gVar.d()) {
                gVar.e(d(), "onVisibility: isHideInNormalHDShow");
            }
            return 8;
        }
        return c(i);
    }

    public boolean p() {
        return false;
    }

    public boolean q() {
        View view = getView();
        if (view != null && view.isShown()) {
            return true;
        }
        return false;
    }

    public String[] r() {
        return null;
    }

    public boolean s() {
        return a(new Integer[0]);
    }

    public boolean t() {
        return a(1);
    }

    @Override // com.baidu.navisdk.ui.widget.bucket.BNBucketItem
    public String toString() {
        return "RGBucketBaseItem{" + com.baidu.navisdk.ui.routeguide.utils.b.a(getId()) + ":" + super.toString() + ",isShowLeft:" + this.d + '}';
    }

    public void u() {
        removeFromParent();
        setView(null);
        refreshVisible();
    }

    public boolean a(Integer... numArr) {
        return false;
    }

    public String b() {
        return this.f7853a.m();
    }

    public void c(View view, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (view == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        if (this.d) {
            marginLayoutParams.leftMargin = i;
            marginLayoutParams.rightMargin = 0;
        } else {
            marginLayoutParams.rightMargin = i;
            marginLayoutParams.leftMargin = 0;
        }
    }

    public int a(int i, boolean z) {
        int dimensionPixelSize = JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_control_panel_margin_left);
        return i != 2 ? dimensionPixelSize + JarUtils.getResources().getDimensionPixelSize(R.dimen.nsdk_rg_guide_panel_shadow_left) : dimensionPixelSize;
    }

    public boolean b(String... strArr) {
        return this.f7853a.c(strArr);
    }

    public void b(View view, int i) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        Pair<Integer, Integer> a2 = RGImageTextBtn.b.a(i);
        if (layoutParams.width == a2.getFirst().intValue() && layoutParams.height == a2.getSecond().intValue()) {
            return;
        }
        layoutParams.width = a2.getFirst().intValue();
        layoutParams.height = a2.getSecond().intValue();
        view.requestLayout();
    }

    public void a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(d(), "changeItemSize: " + i);
        }
    }

    public boolean a(String... strArr) {
        if (strArr == null) {
            return false;
        }
        String n = this.f7853a.n();
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(d(), "isCurrentGlassState: " + n);
        }
        if (TextUtils.isEmpty(n)) {
            return false;
        }
        for (String str : strArr) {
            if (n.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public View a() {
        return getView();
    }

    public void a(View view, int i) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        Pair<Integer, Integer> b = RGImageTextBtn.b.b(i);
        if (layoutParams.width == b.getFirst().intValue() && layoutParams.height == b.getSecond().intValue()) {
            return;
        }
        layoutParams.width = b.getFirst().intValue();
        layoutParams.height = b.getSecond().intValue();
        view.requestLayout();
    }

    public void a(TextView textView, int i) {
        int d;
        if (textView == null) {
            return;
        }
        RGImageTextBtn.a aVar = RGImageTextBtn.b;
        textView.setTextSize(0, aVar.c(i));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        if (marginLayoutParams == null || marginLayoutParams.topMargin == (d = aVar.d(i))) {
            return;
        }
        marginLayoutParams.topMargin = d;
        textView.requestLayout();
    }

    public void a(String str, String str2) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(d(), "enterFSMState: " + str2 + "->" + str);
        }
    }
}
