package com.baidu.navisdk.module.business;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.pronavi.i;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.util.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.x;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class b {
    private static final String n = "b";
    private static b o;
    private static Object p = new Object();

    /* renamed from: a, reason: collision with root package name */
    private boolean f7053a = true;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private View e = null;
    private View f = null;
    private ImageView g = null;
    private TextView h = null;
    private View i = null;
    private ImageView j = null;
    private TextView k = null;
    private TextView l = null;
    private com.baidu.navisdk.util.worker.loop.a m = new e("BAVM");

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f7054a;
        final /* synthetic */ boolean b;

        public a(Context context, boolean z) {
            this.f7054a = context;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.b(this.f7054a, this.b);
        }
    }

    /* renamed from: com.baidu.navisdk.module.business.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class ViewOnClickListenerC0231b implements View.OnClickListener {
        public ViewOnClickListenerC0231b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a(false);
            com.baidu.navisdk.module.a.h().a().D = true;
            com.baidu.navisdk.module.a.h().a().C++;
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.n", null, null, "" + com.baidu.navisdk.module.a.h().a().k);
            LogUtil.e(b.n, "pop.onClick() receive prize.");
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.a();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.i();
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.util.worker.loop.a {
        public e(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                b.this.h();
                com.baidu.navisdk.module.a.h().a().f();
                com.baidu.navisdk.module.a.h().a().e();
                b.this.b = false;
                return;
            }
            if (i == 2) {
                b.this.g();
                com.baidu.navisdk.module.a.h().a().f();
                com.baidu.navisdk.module.a.h().a().e();
                b.this.b = false;
            }
        }
    }

    private b() {
    }

    public static b d() {
        if (o == null) {
            synchronized (p) {
                try {
                    if (o == null) {
                        o = new b();
                    }
                } finally {
                }
            }
        }
        return o;
    }

    private int e() {
        String str;
        int widthPixels;
        double widthPixels2;
        double d2;
        int i;
        i i2 = x.i();
        if (i2 != null) {
            str = i2.q();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = RGFSMTable.FsmState.Car3D;
        }
        if (x.u()) {
            if (RGFSMTable.FsmState.Car3D.equals(str)) {
                widthPixels = ScreenUtil.getInstance().getHeightPixels() / 2;
                widthPixels2 = ScreenUtil.getInstance().getHeightPixels();
                d2 = 0.23d;
            } else {
                widthPixels = ScreenUtil.getInstance().getHeightPixels() / 2;
                i = ScreenUtil.getInstance().dip2px(64);
                return (widthPixels - i) + 80;
            }
        } else if (RGFSMTable.FsmState.Car3D.equals(str)) {
            widthPixels = ScreenUtil.getInstance().getWidthPixels() / 2;
            widthPixels2 = ScreenUtil.getInstance().getWidthPixels();
            d2 = 0.25d;
        } else {
            widthPixels = ScreenUtil.getInstance().getWidthPixels() / 2;
            widthPixels2 = ScreenUtil.getInstance().getWidthPixels();
            d2 = 0.1d;
        }
        i = (int) (widthPixels2 * d2);
        return (widthPixels - i) + 80;
    }

    private int f() {
        if (x.u()) {
            return 0;
        }
        return ScreenUtil.getInstance().getHeightPixels() / 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.d = false;
        this.b = false;
        if (this.m.hasMessages(2)) {
            this.m.removeMessages(2);
        }
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
        LogUtil.e("BusinessActivityManager", "view.hideBanner() ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.c = false;
        if (this.m.hasMessages(1)) {
            this.m.removeMessages(1);
        }
        View view = this.f;
        if (view != null) {
            view.setVisibility(8);
        }
        LogUtil.e("BusinessActivityManager", "view.hidePop() ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.m.hasMessages(1)) {
            this.m.removeMessages(1);
        }
        if (this.m.hasMessages(2)) {
            this.m.removeMessages(2);
        }
        ViewGroup f = x.f();
        if (f != null) {
            f.removeAllViews();
            f.setVisibility(8);
        }
        View view = this.e;
        if (view != null) {
            view.setVisibility(0);
        }
        ImageView imageView = this.g;
        if (imageView != null) {
            j.a(imageView);
            this.g = null;
        }
        ImageView imageView2 = this.j;
        if (imageView2 != null) {
            j.a(imageView2);
            this.j = null;
        }
        this.e = null;
        this.b = false;
        this.c = false;
        this.d = false;
        LogUtil.e("BusinessActivityManager", "view.hideViews() ");
    }

    private void j() {
        View view = this.e;
        if (view != null) {
            view.setVisibility(0);
        }
        ImageView imageView = this.g;
        if (imageView != null) {
            j.a(imageView);
            this.g = null;
        }
        ImageView imageView2 = this.j;
        if (imageView2 != null) {
            j.a(imageView2);
            this.j = null;
        }
        this.e = null;
    }

    public boolean b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, boolean z) {
        j();
        if (a(context)) {
            if (z && !this.c) {
                if (this.d) {
                    a(z);
                    return;
                }
                return;
            }
            b(z);
        }
    }

    public void a(Context context, boolean z) {
        if ((!this.b || z) && context != null) {
            if (com.baidu.navisdk.module.a.h().a() != null && com.baidu.navisdk.module.a.h().a().j) {
                if (!z && (com.baidu.navisdk.module.a.h().a().B >= com.baidu.navisdk.module.a.h().a().z || com.baidu.navisdk.module.a.h().a().C >= com.baidu.navisdk.module.a.h().a().A)) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e(n, "showViews() no show for max. hasShowCount=" + com.baidu.navisdk.module.a.h().a().B);
                        return;
                    }
                    return;
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(n, "showViews() reShowForOrientaionChanged=" + z + ", mIsPopShowing=" + this.c + ", mIsBannerShowing=" + this.d);
                }
                this.m.post(new a(context, z));
                return;
            }
            LogUtil.e(n, "showViews() no show for activity is not open.");
        }
    }

    private void b(boolean z) {
        View view = this.i;
        if (view != null) {
            view.setVisibility(8);
        }
        if (com.baidu.navisdk.module.a.h().a().n == null) {
            return;
        }
        this.g.setImageBitmap(com.baidu.navisdk.module.a.h().a().n);
        this.f.setVisibility(0);
        ViewGroup f = x.f();
        if (f == null) {
            return;
        }
        f.setVisibility(0);
        if (!z) {
            com.baidu.navisdk.module.a.h().a().B++;
            com.baidu.navisdk.module.business.a.e().b();
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.m", null, null, "" + com.baidu.navisdk.module.a.h().a().k);
            this.m.sendEmptyMessageDelayed(1, (long) (com.baidu.navisdk.module.a.h().a().r * 1000));
        }
        this.b = true;
        this.c = true;
        this.d = false;
    }

    private boolean a(Context context) {
        View inflate;
        if (context == null) {
            return false;
        }
        try {
            inflate = JarUtils.inflate(context, R.layout.nsdk_layout_rg_mapmode_business, null);
            this.e = inflate;
        } catch (Exception unused) {
        }
        if (inflate == null) {
            return false;
        }
        this.f = inflate.findViewById(R.id.nsdk_layout_rg_busi_logo_area);
        this.g = (ImageView) this.e.findViewById(R.id.nsdk_layout_rg_busi_logo_image);
        this.h = (TextView) this.e.findViewById(R.id.nsdk_layout_rg_busi_logo_text);
        this.i = this.e.findViewById(R.id.nsdk_layout_rg_busi_banner_area);
        this.k = (TextView) this.e.findViewById(R.id.nsdk_layout_rg_busi_banner_content);
        this.j = (ImageView) this.e.findViewById(R.id.nsdk_layout_rg_busi_banner_image);
        TextView textView = (TextView) this.e.findViewById(R.id.nsdk_layout_rg_busi_banner_tips);
        this.l = textView;
        View view = this.f;
        if (view != null && this.g != null && this.i != null && this.k != null && this.j != null && textView != null) {
            view.setOnClickListener(new ViewOnClickListenerC0231b());
            this.i.setOnClickListener(new c());
            ViewGroup f = x.f();
            if (f == null) {
                return false;
            }
            f.removeAllViews();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            f.setPadding(f(), 0, 0, e());
            f.addView(this.e, layoutParams);
            boolean z = this.f7053a;
            if (!z) {
                a(z, true);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.d = true;
        this.c = false;
        View view = this.f;
        if (view != null) {
            view.setVisibility(8);
        }
        if (this.i != null) {
            this.k.setText(com.baidu.navisdk.module.a.h().a().l);
            this.j.setImageBitmap(com.baidu.navisdk.module.a.h().a().p);
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            ViewGroup f = x.f();
            if (f == null) {
                return;
            }
            f.setVisibility(0);
            if (z) {
                return;
            }
            this.m.sendEmptyMessageDelayed(2, com.baidu.navisdk.module.a.h().a().y * 1000);
        }
    }

    public void a(boolean z, boolean z2) {
        if (z2 || this.f7053a != z) {
            this.f7053a = z;
            View view = this.f;
            if (view == null || this.g == null || this.h == null || this.i == null || this.k == null || this.j == null) {
                return;
            }
            int i = R.drawable.nsdk_rg_other_gift_popup_big;
            view.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i));
            this.h.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_a));
            this.i.setBackgroundDrawable(com.baidu.navisdk.ui.util.b.f(i));
            this.l.setTextColor(com.baidu.navisdk.ui.util.b.b(R.color.nsdk_cl_text_c));
        }
    }

    public void a() {
        this.m.post(new d());
    }
}
