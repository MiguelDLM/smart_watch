package com.baidu.navisdk.debug.commonui;

import android.os.Message;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes7.dex */
public class b {
    private static final SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static b f = null;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentMap<String, c> f6772a = new ConcurrentHashMap();
    private c b = null;
    private boolean c = false;
    private com.baidu.navisdk.util.worker.loop.a d = new HandlerC0192b("DCUC");

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6773a;
        final /* synthetic */ String b;

        public a(String str, String str2) {
            this.f6773a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((c) b.this.f6772a.get(this.f6773a)).a(b.e.format(new Date()) + " # " + this.b, false);
        }
    }

    /* renamed from: com.baidu.navisdk.debug.commonui.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class HandlerC0192b extends com.baidu.navisdk.util.worker.loop.a {
        public HandlerC0192b(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (message.what == 1) {
                if (b.this.b != null) {
                    b.this.b.c();
                }
                b.this.d.removeMessages(1);
                b.this.d.sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    private b() {
    }

    public static b b() {
        if (f == null) {
            synchronized (b.class) {
                try {
                    if (f == null) {
                        f = new b();
                    }
                } finally {
                }
            }
        }
        return f;
    }

    private void c() {
        if (this.c) {
            return;
        }
        synchronized (b.class) {
            try {
                if (!this.c) {
                    this.c = true;
                    this.d.removeMessages(1);
                    this.d.sendEmptyMessageDelayed(1, 1000L);
                }
            } finally {
            }
        }
    }

    public void a(String str, com.baidu.navisdk.debug.commonui.a aVar, ViewGroup viewGroup) {
        c cVar;
        if (str != null && str.length() != 0) {
            try {
                if (this.f6772a.containsKey(str)) {
                    cVar = this.f6772a.get(str);
                } else {
                    c cVar2 = new c(aVar);
                    this.f6772a.put(str, cVar2);
                    cVar = cVar2;
                }
                if (cVar != null) {
                    c cVar3 = this.b;
                    if (cVar3 != null) {
                        cVar3.b();
                        if (viewGroup != null) {
                            viewGroup.removeView(this.b.a());
                        }
                    }
                    this.b = cVar;
                    if (cVar.a().getParent() != null) {
                        ((ViewGroup) cVar.a().getParent()).removeView(cVar.a());
                    }
                    cVar.d();
                    if (viewGroup != null) {
                        viewGroup.addView(cVar.a(), new LinearLayout.LayoutParams(Math.min(ScreenUtil.getInstance().dip2px(400), ScreenUtil.getInstance().getWidthPixels()), ScreenUtil.getInstance().dip2px(700)));
                        viewGroup.setVisibility(0);
                    }
                }
                c();
            } catch (Exception unused) {
            }
        }
    }

    public void a(String str, String str2) {
        if (str == null || str.length() == 0 || !this.f6772a.containsKey(str)) {
            return;
        }
        this.d.post(new a(str, str2));
    }
}
