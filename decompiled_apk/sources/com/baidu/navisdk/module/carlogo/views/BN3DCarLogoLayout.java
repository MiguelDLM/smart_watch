package com.baidu.navisdk.module.carlogo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.module.carlogo.views.ThreeDColorLayout;
import com.baidu.navisdk.module.carlogo.views.a;
import com.baidu.navisdk.ui.util.g;
import com.baidu.navisdk.ui.widget.BNLoadingView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class BN3DCarLogoLayout extends RelativeLayout implements com.baidu.navisdk.module.carlogo.interfaces.b, View.OnClickListener, ViewPager.OnPageChangeListener, ThreeDColorLayout.a {

    /* renamed from: a, reason: collision with root package name */
    private TextView f7078a;
    private ViewPager b;
    private TextView c;
    private ThreeDColorLayout d;
    private View e;
    private Button f;
    private BNLoadingView g;
    private com.baidu.navisdk.module.carlogo.views.a h;
    private com.baidu.navisdk.module.carlogo.listeners.a i;
    private ArrayList<View> j;
    private BN3DCarLogoPageItem k;
    private int l;
    private d m;
    private int n;
    private ArrayList<com.baidu.navisdk.module.carlogo.datas.c> o;

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7080a;

        public b(int i) {
            this.f7080a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BN3DCarLogoLayout.this.a(this.f7080a);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoLayout", "onClick 加载失败 重试");
            }
            if (BN3DCarLogoLayout.this.i != null) {
                BN3DCarLogoLayout.this.i.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a();
    }

    public BN3DCarLogoLayout(Context context) {
        this(context, null);
    }

    private void e() {
        BNLoadingView bNLoadingView = this.g;
        if (bNLoadingView == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoLayout", "removeLoadingView loadingView == null");
            }
        } else {
            if (bNLoadingView.getParent() == null) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BN3DCarLogoLayout", "removeLoadingView parent view is null");
                    return;
                }
                return;
            }
            removeView(this.g);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.m != null && motionEvent.getAction() == 0) {
            this.m.a();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.navisdk.module.carlogo.listeners.a aVar;
        int id = view.getId();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "onClick: " + view);
        }
        if (g.a()) {
            return;
        }
        if (id == R.id.three_d_car_logo_more) {
            com.baidu.navisdk.module.carlogo.listeners.a aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.b();
                return;
            }
            return;
        }
        if (id == R.id.three_d_car_logo_cancel) {
            com.baidu.navisdk.module.carlogo.listeners.a aVar3 = this.i;
            if (aVar3 != null) {
                aVar3.a(true);
                return;
            }
            return;
        }
        if (id == R.id.three_d_car_logo_confirm && (aVar = this.i) != null) {
            aVar.b(this.l);
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void onDestroy() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "onDestroy: ");
        }
        this.i = null;
        ArrayList<View> arrayList = this.j;
        if (arrayList != null) {
            arrayList.clear();
            this.j = null;
        }
        ThreeDColorLayout threeDColorLayout = this.d;
        if (threeDColorLayout != null) {
            threeDColorLayout.a();
            this.d = null;
        }
        ViewPager viewPager = this.b;
        if (viewPager != null) {
            viewPager.setAdapter(null);
            this.b = null;
        }
        this.k = null;
        com.baidu.navisdk.module.carlogo.views.a aVar = this.h;
        if (aVar != null) {
            aVar.a();
            this.h = null;
        }
        this.o = null;
        this.m = null;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        BN3DCarLogoPageItem bN3DCarLogoPageItem;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "onPageScrollStateChanged: " + i);
        }
        if (i == 1 && (bN3DCarLogoPageItem = this.k) != null) {
            bN3DCarLogoPageItem.d();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "onPageSelected mCurrentPosition: " + this.n + ", position:" + i);
        }
        this.n = i;
        com.baidu.navisdk.module.carlogo.views.a aVar = this.h;
        if (aVar != null) {
            BN3DCarLogoPageItem a2 = aVar.a(i);
            this.k = a2;
            if (a2 != null) {
                a(i);
                return;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoLayout", "onPageSelected mCurrentPageItem == null,  position:" + i);
            }
            post(new b(i));
        }
    }

    public void setOnTouchDownListener(d dVar) {
        this.m = dVar;
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void setPanelListener(com.baidu.navisdk.module.carlogo.listeners.a aVar) {
        this.i = aVar;
    }

    /* loaded from: classes7.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // com.baidu.navisdk.module.carlogo.views.a.b
        public boolean a() {
            if (BN3DCarLogoLayout.this.i != null) {
                return BN3DCarLogoLayout.this.i.a();
            }
            return true;
        }

        @Override // com.baidu.navisdk.module.carlogo.views.a.b
        public void b(int i) {
            if (i == BN3DCarLogoLayout.this.n) {
                if (BN3DCarLogoLayout.this.k != null) {
                    BN3DCarLogoLayout.this.k.c();
                }
            } else {
                if (BN3DCarLogoLayout.this.k != null) {
                    BN3DCarLogoLayout.this.k.d();
                }
                if (BN3DCarLogoLayout.this.b != null) {
                    BN3DCarLogoLayout.this.b.setCurrentItem(i, true);
                }
            }
        }

        @Override // com.baidu.navisdk.module.carlogo.views.a.b
        public boolean a(int i) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoLayout", "isCurrentPosition: " + i);
            }
            return i == BN3DCarLogoLayout.this.n;
        }
    }

    public BN3DCarLogoLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "initPanel: " + Arrays.toString(arrayList.toArray()) + ", currentPosition:" + i);
        }
        this.n = i;
        int width = (getWidth() / 4) + (this.b.getPageMargin() * 2);
        if (width > 0) {
            this.b.setPadding(width, 0, width, 0);
        }
        this.o = arrayList;
        com.baidu.navisdk.module.carlogo.views.a aVar = this.h;
        if (aVar == null) {
            this.h = new com.baidu.navisdk.module.carlogo.views.a(getContext(), arrayList, new a());
        } else {
            aVar.a(arrayList);
        }
        this.b.setAdapter(this.h);
    }

    private void d(com.baidu.navisdk.module.carlogo.datas.c cVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "changeDescAndColorIndicatorState: " + cVar);
        }
        if (!cVar.g()) {
            View view = this.e;
            if (view != null) {
                view.setVisibility(8);
            }
            TextView textView = this.c;
            if (textView != null) {
                textView.setText(JarUtils.getResources().getString(R.string.nsdk_3d_car_logo_space_usage_desc, cVar.j));
                this.c.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        if (this.e != null) {
            if (cVar.c()) {
                this.e.setVisibility(0);
                ThreeDColorLayout threeDColorLayout = this.d;
                if (threeDColorLayout != null) {
                    threeDColorLayout.a(cVar.m, cVar.n, cVar.f7077a);
                    return;
                }
                return;
            }
            this.e.setVisibility(8);
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void c() {
        int id;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "startLoading: ");
        }
        int childCount = getChildCount();
        if (this.j == null) {
            this.j = new ArrayList<>(childCount);
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (id = childAt.getId()) != R.id.three_d_car_logo_title && id != R.id.three_d_car_logo_more) {
                this.j.add(childAt);
                childAt.setVisibility(4);
            }
        }
        d();
        BNLoadingView bNLoadingView = this.g;
        if (bNLoadingView != null) {
            bNLoadingView.resetBottomLoadtab(1);
        }
    }

    public BN3DCarLogoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = 0;
        a(context);
    }

    private void a(Context context) {
        setClipChildren(false);
        com.baidu.navisdk.ui.util.b.a(context, R.layout.nsdk_layout_3d_car_logo_panel_layout, this);
        this.f7078a = (TextView) findViewById(R.id.three_d_car_logo_title);
        this.b = (ViewPager) findViewById(R.id.three_d_car_logo_viewpage);
        this.c = (TextView) findViewById(R.id.three_d_car_logo_desc);
        this.d = (ThreeDColorLayout) findViewById(R.id.three_d_car_logo_color_layout);
        this.f = (Button) findViewById(R.id.three_d_car_logo_confirm);
        this.e = findViewById(R.id.car_logo_color_horizontal_scroll_view);
        this.d.setOnColorChangeListener(this);
        this.f.setOnClickListener(this);
        findViewById(R.id.three_d_car_logo_more).setOnClickListener(this);
        findViewById(R.id.three_d_car_logo_cancel).setOnClickListener(this);
        this.b.setClipChildren(false);
        this.b.setPageMargin(JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_10dp));
        this.b.addOnPageChangeListener(this);
        ViewPager viewPager = this.b;
        viewPager.setPageTransformer(true, new com.baidu.navisdk.module.carlogo.views.b(viewPager));
    }

    @RequiresApi(api = 21)
    public BN3DCarLogoLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.n = 0;
        a(context);
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void b() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "loadFailed: ");
        }
        BNLoadingView bNLoadingView = this.g;
        if (bNLoadingView != null) {
            bNLoadingView.resetBottomLoadtab(3);
            this.g.setErrorViewText("加载失败", true);
            this.g.setErrorRepeatBtnListener(new c());
        }
    }

    private void c(com.baidu.navisdk.module.carlogo.datas.c cVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "changeConfirmBtnState: " + cVar);
        }
        Button button = this.f;
        if (button == null) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoLayout", "changeConfirmBtnState mConfirmBtn == null");
                return;
            }
            return;
        }
        int i = cVar.p;
        if (i == 1) {
            if (cVar.i()) {
                this.f.setText(R.string.nsdk_in_use);
                this.f.setEnabled(false);
                return;
            } else {
                this.f.setText(R.string.nsdk_confirm_change);
                this.f.setEnabled(true);
                return;
            }
        }
        if (i == 2) {
            button.setText(R.string.nsdk_start_download);
            this.f.setEnabled(true);
        } else {
            button.setText(R.string.nsdk_cancel_download);
            this.f.setEnabled(true);
        }
    }

    private void d() {
        if (this.g == null) {
            this.g = new BNLoadingView(getContext());
        }
        if (this.g.getParent() != null) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "addLoadingView: ");
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, JarUtils.getResources().getDimensionPixelSize(R.dimen.navi_dimens_214dp));
        layoutParams.addRule(3, R.id.three_d_car_logo_title);
        addView(this.g, layoutParams);
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void b(com.baidu.navisdk.module.carlogo.datas.c cVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "selectedCarLogoChange: " + cVar);
        }
        if (cVar == null) {
            return;
        }
        if (cVar.f7077a != this.l) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoLayout", "selectedCarLogoChange: " + cVar.f7077a + ",mCurrentCarLogoId: " + this.l);
            }
            LogUtil.printCallStack();
        }
        TextView textView = this.f7078a;
        if (textView != null) {
            textView.setText(cVar.b);
        }
        d(cVar);
        c(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "changeCurrentSelected3DCarLogo: " + i);
        }
        com.baidu.navisdk.module.carlogo.views.a aVar = this.h;
        if (aVar != null) {
            BN3DCarLogoPageItem a2 = aVar.a(i);
            this.k = a2;
            if (a2 != null) {
                this.l = ((Integer) a2.getTag()).intValue();
                this.k.c();
                com.baidu.navisdk.module.carlogo.listeners.a aVar2 = this.i;
                if (aVar2 != null) {
                    aVar2.a(i, this.l);
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BN3DCarLogoLayout", "changeCurrentSelected3DCarLogo position: " + i + ", mCurrentPageItem:" + this.k + ", mCurrentCarLogoId:" + this.l);
                    return;
                }
                return;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoLayout", "changeCurrentSelected3DCarLogo mCurrentPageItem == null");
            }
            com.baidu.navisdk.module.carlogo.listeners.a aVar3 = this.i;
            if (aVar3 != null) {
                aVar3.a(false);
            }
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void b(com.baidu.navisdk.module.carlogo.datas.c cVar, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "downloadZipSuccess: " + i + ", model:" + cVar + ",mCurrentCarLogoId: " + this.l);
        }
        if (i == this.l) {
            BN3DCarLogoPageItem bN3DCarLogoPageItem = this.k;
            if (bN3DCarLogoPageItem != null) {
                bN3DCarLogoPageItem.a();
                com.baidu.navisdk.module.carlogo.listeners.a aVar = this.i;
                if (aVar != null) {
                    this.k.a(cVar.a(aVar.a()));
                }
            }
            b(cVar);
            return;
        }
        com.baidu.navisdk.module.carlogo.views.a aVar2 = this.h;
        BN3DCarLogoPageItem b2 = aVar2 != null ? aVar2.b(i) : null;
        if (b2 != null) {
            b2.a();
            com.baidu.navisdk.module.carlogo.listeners.a aVar3 = this.i;
            if (aVar3 != null) {
                b2.a(cVar.a(aVar3.a()));
            }
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void a(ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "loadSuccess currentPosition: " + i + ", " + Arrays.toString(arrayList.toArray()));
        }
        e();
        ArrayList<View> arrayList2 = this.j;
        if (arrayList2 != null) {
            Iterator<View> it = arrayList2.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next != null) {
                    next.setVisibility(0);
                }
            }
            this.j.clear();
        }
        b(arrayList, i);
        if (i == 0) {
            onPageSelected(0);
        } else {
            this.b.setCurrentItem(i, false);
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void a(com.baidu.navisdk.module.carlogo.datas.c cVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "handlerCancelDownload: " + cVar + ",mCurrentCarLogoId:" + this.l);
        }
        if (cVar != null && cVar.f7077a == this.l) {
            BN3DCarLogoPageItem bN3DCarLogoPageItem = this.k;
            if (bN3DCarLogoPageItem != null) {
                bN3DCarLogoPageItem.a();
            }
            c(cVar);
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void a() {
        BN3DCarLogoPageItem bN3DCarLogoPageItem = this.k;
        if (bN3DCarLogoPageItem != null) {
            bN3DCarLogoPageItem.d();
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void a(int i, com.baidu.navisdk.module.carlogo.datas.c cVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "startDownloadZip: " + i);
        }
        BN3DCarLogoPageItem bN3DCarLogoPageItem = this.k;
        if (bN3DCarLogoPageItem != null && i == this.l) {
            bN3DCarLogoPageItem.a(0);
        }
        c(cVar);
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void a(com.baidu.navisdk.module.carlogo.datas.c cVar, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "downloadZipFailed: " + i + ", mCurrentCarLogoId:" + this.l);
        }
        if (i == this.l) {
            BN3DCarLogoPageItem bN3DCarLogoPageItem = this.k;
            if (bN3DCarLogoPageItem != null) {
                bN3DCarLogoPageItem.a();
            }
            Button button = this.f;
            if (button != null) {
                button.setEnabled(true);
            }
            if (cVar != null) {
                c(cVar);
                return;
            }
            return;
        }
        com.baidu.navisdk.module.carlogo.views.a aVar = this.h;
        BN3DCarLogoPageItem b2 = aVar != null ? aVar.b(i) : null;
        if (b2 != null) {
            b2.a();
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void a(int i, int i2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "onDownloadZipProgress: " + i + ",carLogoId: " + i2 + ", mCurrentCarLogoId:" + this.l);
        }
        BN3DCarLogoPageItem bN3DCarLogoPageItem = this.k;
        if (bN3DCarLogoPageItem != null && i2 == this.l) {
            bN3DCarLogoPageItem.a(i);
            return;
        }
        com.baidu.navisdk.module.carlogo.views.a aVar = this.h;
        BN3DCarLogoPageItem b2 = aVar != null ? aVar.b(i2) : null;
        if (b2 != null) {
            b2.a(i);
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.views.ThreeDColorLayout.a
    public void a(com.baidu.navisdk.module.carlogo.datas.a aVar, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "onColorChange: " + aVar + ", carLogoId:" + i);
        }
        com.baidu.navisdk.module.carlogo.listeners.a aVar2 = this.i;
        if (aVar2 != null) {
            boolean a2 = aVar2.a(aVar, i);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoLayout", "onColorChange result: " + a2);
            }
            if (a2) {
                com.baidu.navisdk.module.carlogo.datas.c a3 = this.i.a(i);
                BN3DCarLogoPageItem bN3DCarLogoPageItem = this.k;
                if (bN3DCarLogoPageItem != null) {
                    bN3DCarLogoPageItem.a(a3.a(this.i.a()));
                }
                c(a3);
            }
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.b
    public void a(boolean z) {
        ArrayList<com.baidu.navisdk.module.carlogo.datas.c> arrayList;
        if (this.h != null && (arrayList = this.o) != null && !arrayList.isEmpty()) {
            int size = this.o.size();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoLayout", "updateStyle childCount: " + size);
            }
            for (int i = 0; i < size; i++) {
                BN3DCarLogoPageItem a2 = this.h.a(i);
                if (a2 == null) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("BN3DCarLogoLayout", "updateStyle pageItem == null index:" + i);
                    }
                } else {
                    com.baidu.navisdk.module.carlogo.datas.c cVar = this.o.get(i);
                    if (cVar != null) {
                        a2.a(cVar.a(z));
                    }
                }
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoLayout", "updateStyle mLogoAdapter == null or m3DModelList == null ");
        }
    }
}
