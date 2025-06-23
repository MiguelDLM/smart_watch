package com.baidu.navisdk.skyeye.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.baidu.navisdk.ui.util.g;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;

/* loaded from: classes7.dex */
public class a {
    private static final String m = "a";

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f8011a;
    private WindowManager.LayoutParams b;
    private WindowManager c;
    private float e;
    private float f;
    private float g;
    private float h;
    private int i;
    private boolean d = false;
    private float j = 0.0f;
    private float k = 0.0f;
    private boolean l = false;

    /* renamed from: com.baidu.navisdk.skyeye.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ViewOnClickListenerC0366a implements View.OnClickListener {
        public ViewOnClickListenerC0366a(a aVar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.a()) {
                return;
            }
            com.baidu.navisdk.skyeye.a.n().i();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return a.this.a(motionEvent);
        }
    }

    public a() {
        e();
        d();
        this.i = ViewConfiguration.get(com.baidu.navisdk.framework.a.c().b()).getScaledTouchSlop();
    }

    private void d() {
        this.f8011a = new LinearLayout(com.baidu.navisdk.framework.a.c().a());
        TextView textView = new TextView(com.baidu.navisdk.framework.a.c().a());
        textView.setTextSize(1, 20.0f);
        textView.setText("报bug");
        this.f8011a.addView(textView);
        this.f8011a.setOrientation(0);
        this.f8011a.setGravity(17);
        this.f8011a.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        this.f8011a.setOnClickListener(new ViewOnClickListenerC0366a(this));
    }

    private void e() {
        this.b = new WindowManager.LayoutParams();
        this.c = (WindowManager) com.baidu.navisdk.framework.a.c().a().getSystemService("window");
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.b.type = 2038;
        } else if (i > 24) {
            this.b.type = 2003;
        } else {
            this.b.type = 2005;
        }
        WindowManager.LayoutParams layoutParams = this.b;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.width = ScreenUtil.getInstance().dip2px(69);
        this.b.height = ScreenUtil.getInstance().dip2px(30);
    }

    private void f() {
        WindowManager.LayoutParams layoutParams = this.b;
        layoutParams.x = (int) (this.g - this.e);
        layoutParams.y = (int) (this.h - this.f);
        try {
            this.c.updateViewLayout(this.f8011a, layoutParams);
        } catch (Exception unused) {
        }
    }

    public boolean b() {
        return this.d;
    }

    public boolean c() {
        LogUtil.e(m, "show :" + b());
        if (b()) {
            return true;
        }
        try {
            this.f8011a.setOnTouchListener(new b());
            this.c.addView(this.f8011a, this.b);
            this.d = true;
            return true;
        } catch (Exception e) {
            LogUtil.e(m, "float excetion e:" + e.getMessage());
            this.d = false;
            return false;
        }
    }

    public void a() {
        LogUtil.e(m, "hide");
        try {
            LinearLayout linearLayout = this.f8011a;
            if (linearLayout != null && linearLayout.getParent() != null) {
                this.c.removeView(this.f8011a);
            }
            this.d = false;
        } catch (Exception e) {
            LogUtil.e(m, "hide float excetion e:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.e = motionEvent.getX();
            this.f = motionEvent.getY();
            this.j = motionEvent.getRawX();
            this.k = motionEvent.getRawY();
            this.l = false;
            return false;
        }
        if (action == 1) {
            f();
            return this.l;
        }
        if (action != 2) {
            return false;
        }
        this.g = motionEvent.getRawX();
        this.h = motionEvent.getRawY() - ScreenUtil.getInstance().getStatusBarHeight(com.baidu.navisdk.framework.a.c().b());
        if (Math.abs(this.j - motionEvent.getRawX()) > this.i || Math.abs(this.k - motionEvent.getRawY()) > this.i) {
            this.l = true;
        }
        if (this.l) {
            f();
        }
        return false;
    }
}
