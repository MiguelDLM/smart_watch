package com.baidu.navisdk.ui.bubble;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.bubble.a;
import com.baidu.navisdk.ui.bubble.b;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f8353a;
    private final FrameLayout b;
    private ArrayList<com.baidu.navisdk.ui.bubble.b> d;
    private ViewTreeObserver f;
    private ViewTreeObserver.OnGlobalLayoutListener g;
    private com.baidu.navisdk.ui.bubble.b h;
    private final ArrayList<com.baidu.navisdk.ui.bubble.b> c = new ArrayList<>();
    private com.baidu.navisdk.ui.bubble.d e = new a.b();
    private final f<String, String> i = new a("BNRRBubbleController-autoHideTask", null);

    /* loaded from: classes8.dex */
    public class a extends f<String, String> {
        public a(String str, String str2) {
            super(str, str2);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            c.this.d();
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8355a;
        final /* synthetic */ com.baidu.navisdk.ui.bubble.b b;
        final /* synthetic */ TextView c;

        public b(View view, com.baidu.navisdk.ui.bubble.b bVar, TextView textView) {
            this.f8355a = view;
            this.b = bVar;
            this.c = textView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f8355a.getVisibility() == 0 && c.this.b != null && this.f8355a.getWidth() != 0 && this.f8355a.isShown()) {
                int[] iArr = new int[2];
                this.f8355a.getLocationInWindow(iArr);
                FrameLayout.LayoutParams a2 = c.this.a(this.b, this.c);
                if (a2 == null) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("BubbleController", "onGlobalLayout: layoutParams == null");
                        return;
                    }
                    return;
                }
                boolean z = false;
                c.this.b.setVisibility(0);
                int[] a3 = this.b.e().a();
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BubbleController", "onGlobalLayout --> location = " + Arrays.toString(iArr) + ", lastLocation = " + Arrays.toString(a3));
                }
                if (a3 != null && a3.length == 2) {
                    if (a3[0] == iArr[0] && a3[1] == iArr[1]) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("BubbleController", "onGlobalLayout --> lastLocation is same with curLocation!!!");
                            return;
                        }
                        return;
                    }
                    z = true;
                }
                this.b.e().a(iArr);
                ViewParent parent = this.c.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.c);
                }
                c.this.b.addView(this.c, a2);
                c.this.h = this.b;
                if (z) {
                    return;
                }
                if (this.b.f() != null) {
                    this.b.f().b(this.b);
                }
                c.this.b(this.b.b());
                if (c.this.c != null) {
                    c.this.c.clear();
                    return;
                }
                return;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BubbleController", "onGlobalLayout: anchorView.getVisibility() != View.VISIBLE || mRootView == null || anchorView.getWidth() == 0 || !anchorView.isShown()");
            }
            if (c.this.b != null) {
                c.this.b.setVisibility(8);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.bubble.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnClickListenerC0404c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.ui.bubble.b f8356a;

        public ViewOnClickListenerC0404c(com.baidu.navisdk.ui.bubble.b bVar) {
            this.f8356a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.d();
            if (this.f8356a.f() != null) {
                this.f8356a.f().a(this.f8356a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private com.baidu.navisdk.ui.bubble.d f8357a = new a.b();
        private final ArrayList<com.baidu.navisdk.ui.bubble.b> b = new ArrayList<>();

        public d(Context context) {
        }

        public void a(com.baidu.navisdk.ui.bubble.b bVar) {
            this.b.add(bVar);
        }

        public void a(c cVar) {
            if (cVar == null) {
                return;
            }
            cVar.a();
            cVar.a(this.b);
            cVar.a(this.f8357a);
            cVar.c();
            cVar.b();
        }
    }

    public c(Context context, FrameLayout frameLayout) {
        this.f8353a = context;
        this.b = frameLayout;
    }

    private void f() {
        com.baidu.navisdk.util.worker.c.a().a((g) this.i, false);
    }

    private void g() {
        ViewTreeObserver viewTreeObserver;
        try {
            com.baidu.navisdk.ui.bubble.b bVar = this.h;
            if (bVar != null && bVar.a() != null && (viewTreeObserver = this.f) != null && viewTreeObserver.isAlive()) {
                this.f.removeOnGlobalLayoutListener(this.g);
            }
        } catch (Exception e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("removeGlobalLayoutListener", e);
            }
        }
    }

    public void c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.printList("BubbleController", "filterBubble", "mTotalBubbles", this.c);
        }
        ArrayList<com.baidu.navisdk.ui.bubble.b> a2 = this.e.a(this.c);
        this.d = a2;
        if (LogUtil.LOGGABLE) {
            LogUtil.printList("BubbleController", "filterBubble", "mFilterBubbles", a2);
        }
    }

    public void d() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BubbleController", "hide()");
        }
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            this.b.removeAllViews();
        }
        g();
        f();
        this.h = null;
        this.f = null;
    }

    public void e() {
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        com.baidu.navisdk.util.worker.c.a().a((g) this.i, false);
        com.baidu.navisdk.util.worker.c.a().a(this.i, new com.baidu.navisdk.util.worker.e(2, 0), i);
    }

    public void b() {
        ArrayList<com.baidu.navisdk.ui.bubble.b> arrayList = this.d;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.bubble.b> it = this.d.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public void a(Collection<com.baidu.navisdk.ui.bubble.b> collection) {
        if (LogUtil.LOGGABLE) {
            LogUtil.printList("BubbleController", "addAll", "bubbles", collection);
        }
        if (collection == null || collection.isEmpty()) {
            return;
        }
        for (com.baidu.navisdk.ui.bubble.b bVar : collection) {
            if (bVar != null && bVar.j()) {
                this.c.add(bVar);
            }
        }
    }

    private TextView b(@NonNull com.baidu.navisdk.ui.bubble.b bVar) {
        int d2 = bVar.d();
        if (d2 == 0) {
            return a(R.layout.nsdk_layout_route_result_bottom_bubble, bVar);
        }
        if (d2 == 1) {
            return a(R.layout.nsdk_layout_route_result_right_bubble, bVar);
        }
        if (d2 == 3) {
            return a(R.layout.nsdk_layout_route_result_left_bubble, bVar);
        }
        if (d2 != 5) {
            return null;
        }
        return a(R.layout.nsdk_layout_route_result_right_top_bubble, bVar);
    }

    public void a() {
        this.c.clear();
    }

    private int b(TextView textView, com.baidu.navisdk.ui.bubble.b bVar) {
        int i = 0;
        for (String str : bVar.c().toString().split("\n")) {
            int a2 = j.a(textView, str);
            if (a2 > i) {
                i = a2;
            }
        }
        return i + textView.getPaddingLeft() + textView.getPaddingRight();
    }

    public void a(com.baidu.navisdk.ui.bubble.d dVar) {
        this.e = dVar;
    }

    private void a(com.baidu.navisdk.ui.bubble.b bVar) {
        FrameLayout frameLayout;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BubbleController", "showBubble(), bubble = " + bVar);
        }
        if (bVar == null || this.f8353a == null || (frameLayout = this.b) == null) {
            return;
        }
        frameLayout.removeAllViews();
        this.h = null;
        TextView b2 = b(bVar);
        View a2 = bVar.a();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BubbleController", "showBubble(), bubbleView = " + b2 + " anchorView = " + a2);
        }
        if (a2 == null || b2 == null) {
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BubbleController", "showBubble(), bubbleView = " + b2 + " anchorView = " + a2);
        }
        this.g = new b(a2, bVar, b2);
        g();
        ViewTreeObserver viewTreeObserver = a2.getViewTreeObserver();
        this.f = viewTreeObserver;
        viewTreeObserver.addOnGlobalLayoutListener(this.g);
    }

    @Nullable
    private TextView a(int i, @NonNull com.baidu.navisdk.ui.bubble.b bVar) {
        TextView textView;
        if (this.f8353a == null || TextUtils.isEmpty(bVar.c()) || (textView = (TextView) JarUtils.inflate(this.f8353a, i, null)) == null) {
            return null;
        }
        textView.setOnClickListener(new ViewOnClickListenerC0404c(bVar));
        textView.setMaxLines(bVar.g());
        textView.setVisibility(0);
        textView.setText(bVar.c());
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams a(@NonNull com.baidu.navisdk.ui.bubble.b bVar, TextView textView) {
        int e;
        boolean z;
        int b2;
        int i;
        int c;
        int d2;
        int i2;
        View a2 = bVar.a();
        int[] iArr = new int[2];
        a2.getLocationInWindow(iArr);
        b.a e2 = bVar.e();
        int i3 = 0;
        if (e2.e() == 0) {
            int a3 = a(textView, bVar);
            int dip2px = ScreenUtil.getInstance().dip2px(300);
            z = a3 > dip2px;
            e = Math.min(a3, dip2px);
        } else {
            e = e2.e();
            z = true;
        }
        if (e2.b() == 0) {
            if (bVar.d() != 1 && bVar.d() != 3) {
                b2 = ScreenUtil.getInstance().dip2px(38) + 14;
            } else {
                b2 = ScreenUtil.getInstance().dip2px(38);
            }
        } else {
            b2 = e2.b();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(z ? e : -2, b2);
        boolean z2 = e2.c() == Integer.MIN_VALUE;
        boolean z3 = e2.d() == Integer.MIN_VALUE;
        int d3 = bVar.d();
        if (d3 != 0) {
            if (d3 == 1) {
                i2 = -ScreenUtil.getInstance().dip2px(5);
                c = z2 ? i2 : e2.c();
                d2 = z3 ? 0 : e2.d();
                layoutParams.leftMargin = (iArr[0] - e) + c;
                layoutParams.topMargin = iArr[1] + ((a2.getHeight() - b2) / 2) + d2;
            } else if (d3 == 3) {
                i2 = ScreenUtil.getInstance().dip2px(5);
                c = z2 ? i2 : e2.c();
                d2 = z3 ? 0 : e2.d();
                layoutParams.leftMargin = iArr[0] + a2.getWidth() + c;
                layoutParams.topMargin = iArr[1] + ((a2.getHeight() - b2) / 2) + d2;
            } else if (d3 != 5) {
                layoutParams = null;
                i = 0;
                d2 = 0;
                c = 0;
            } else {
                i = -ScreenUtil.getInstance().dip2px(5);
                c = z2 ? 0 : e2.c();
                d2 = z3 ? i : e2.d();
                layoutParams.leftMargin = iArr[0] + ((a2.getWidth() / 2) - 54) + c;
                layoutParams.topMargin = (iArr[1] - b2) + d2;
            }
            i3 = i2;
            i = 0;
        } else {
            i = -ScreenUtil.getInstance().dip2px(5);
            c = z2 ? 0 : e2.c();
            d2 = z3 ? i : e2.d();
            layoutParams.leftMargin = iArr[0] + ((a2.getWidth() - e) / 2) + c;
            layoutParams.topMargin = (iArr[1] - b2) + d2;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BubbleController", "getLayoutParams(), location = " + Arrays.toString(iArr) + " bubbleWidth = " + e + " bubbleHeight = " + b2 + " defaultHorizontalOffset = " + i3 + " defaultVerticalOffset = " + i + " horizontalOffset = " + c + " verticalOffset = " + d2);
            StringBuilder sb = new StringBuilder();
            sb.append("getLayoutParams(), anchorView.getWidth() = ");
            sb.append(a2.getWidth());
            sb.append(", anchorView.getHeight = ");
            sb.append(a2.getHeight());
            LogUtil.e("BubbleController", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getLayoutParams(), layoutParams.leftMargin = ");
            sb2.append(layoutParams == null ? "null" : Integer.valueOf(layoutParams.leftMargin));
            sb2.append(", layoutParams.topMargin = ");
            sb2.append(layoutParams != null ? Integer.valueOf(layoutParams.topMargin) : "null");
            LogUtil.e("BubbleController", sb2.toString());
        }
        return layoutParams;
    }

    private int a(TextView textView, com.baidu.navisdk.ui.bubble.b bVar) {
        if (textView == null) {
            return 0;
        }
        if (bVar.g() > 1) {
            return b(textView, bVar);
        }
        return j.a(textView, textView.getText().toString()) + textView.getPaddingLeft() + textView.getPaddingRight();
    }

    public boolean a(int i) {
        com.baidu.navisdk.ui.bubble.b bVar = this.h;
        return bVar != null && bVar.i() == i;
    }
}
