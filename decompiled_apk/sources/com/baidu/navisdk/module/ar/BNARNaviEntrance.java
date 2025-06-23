package com.baidu.navisdk.module.ar;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.oIX0oI;
import XO0OX.xoIox;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.module.ar.c;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.ui.widget.BNNaviDeclareDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.common.o0;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.ArrayList;
import kotlin.LazyThreadSafetyMode;
import kotlin.X0IIOO;
import kotlin.XIxXXX0x0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes7.dex */
public final class BNARNaviEntrance implements c.InterfaceC0214c {

    /* renamed from: a, reason: collision with root package name */
    private b f6969a;
    private Activity b;
    private BNCommonProgressDialog c;
    private com.baidu.navisdk.module.ar.a d;
    private final X0IIOO e = XIxXXX0x0.I0Io(LazyThreadSafetyMode.NONE, new c());
    private int f = 1;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void b();
    }

    /* loaded from: classes7.dex */
    public static final class c extends Lambda implements oIX0oI<a> {

        /* loaded from: classes7.dex */
        public static final class a implements BNNaviDeclareDialog.BNDeclareClickListener {
            public a() {
            }

            @Override // com.baidu.navisdk.ui.widget.BNNaviDeclareDialog.BNDeclareClickListener
            public void clickAgree() {
                g gVar = g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNARNaviEntrance", "clickAgree");
                }
                BNARNaviEntrance.this.a();
                com.baidu.navisdk.module.ar.b.c.a().a(true);
                BNCommSettingManager.getInstance().setPhoneStateDeclareShow(BNARNaviEntrance.this.f, false);
                BNARNaviEntrance.this.f();
            }

            @Override // com.baidu.navisdk.ui.widget.BNNaviDeclareDialog.BNDeclareClickListener
            public void clickDisAgree() {
                g gVar = g.PRO_NAV;
                if (gVar.d()) {
                    gVar.e("BNARNaviEntrance", "clickDisAgree");
                }
                BNARNaviEntrance.this.a();
            }
        }

        public c() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OOXIXo
        public final a invoke() {
            return new a();
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends com.baidu.navisdk.util.worker.lite.b {
        final /* synthetic */ int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i, String str) {
            super(str);
            this.b = i;
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            BNARNaviEntrance.this.b(this.b);
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements o0.b {
        public e() {
        }

        @Override // com.baidu.navisdk.util.common.o0.b
        public final void a(int i, boolean z, ArrayList<String> arrayList) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNARNaviEntrance", "onPermissionResult: " + i + ", " + z);
            }
            if (i == 3004) {
                if (z) {
                    BNARNaviEntrance.this.j();
                    return;
                }
                TipTool.onCreateToastDialog(com.baidu.navisdk.framework.a.c().a(), "没有照相机权限，请打开后重试");
                b bVar = BNARNaviEntrance.this.f6969a;
                if (bVar != null) {
                    bVar.a();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class f implements DialogInterface.OnCancelListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("BNARNaviEntrance", "mLoadDialog cancel ");
            }
            BNARNaviEntrance.this.e();
        }
    }

    static {
        new a(null);
    }

    private final BNNaviDeclareDialog.BNDeclareClickListener c() {
        return (BNNaviDeclareDialog.BNDeclareClickListener) this.e.getValue();
    }

    private final void g() {
        a();
        if (!com.baidu.navisdk.module.ar.b.c.a().c()) {
            if (this.b == null) {
                g gVar = g.PRO_NAV;
                if (gVar.c()) {
                    gVar.c("BNARNaviEntrance", "showDeclareDialogIfNeed: mActivity == null");
                    return;
                }
                return;
            }
            Activity activity = this.b;
            IIX0o.ooOOo0oXI(activity);
            com.baidu.navisdk.module.ar.a aVar = new com.baidu.navisdk.module.ar.a(activity);
            this.d = aVar;
            IIX0o.ooOOo0oXI(aVar);
            aVar.setBNDeclareClickListener(c());
            com.baidu.navisdk.module.ar.a aVar2 = this.d;
            IIX0o.ooOOo0oXI(aVar2);
            aVar2.show();
            return;
        }
        c().clickAgree();
    }

    private final void h() {
        b();
        try {
            if (this.c == null) {
                Activity activity = this.b;
                if (activity != null) {
                    if (!activity.isFinishing()) {
                    }
                }
                this.c = new BNCommonProgressDialog(this.b);
            }
            BNCommonProgressDialog bNCommonProgressDialog = this.c;
            if (bNCommonProgressDialog != null) {
                Activity activity2 = this.b;
                if (activity2 == null || !activity2.isFinishing()) {
                    bNCommonProgressDialog.setOnCancelListener(new f());
                    bNCommonProgressDialog.setMessage("AR导航准备中...");
                    bNCommonProgressDialog.show();
                }
            }
        } catch (Exception e2) {
            if (LogUtil.LOGGABLE) {
                LogUtil.printException("", e2);
            }
        }
    }

    private final void i() {
        Context context;
        b();
        Activity activity = this.b;
        if (activity != null) {
            context = activity.getApplicationContext();
        } else {
            context = null;
        }
        TipTool.onCreateToastDialog(context, "网络异常，请稍候重试");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNARNaviEntrance", ":startDownloadARRes ");
        }
        com.baidu.navisdk.module.ar.c.h.a().a(com.baidu.navisdk.framework.a.c().a(), this);
    }

    @xoIox
    public final void a(@oOoXoXO Activity activity, @oOoXoXO b bVar, @oOoXoXO LifecycleOwner lifecycleOwner) {
        a(this, activity, bVar, lifecycleOwner, 0, 8, null);
    }

    private final void b() {
        BNCommonProgressDialog bNCommonProgressDialog = this.c;
        if (bNCommonProgressDialog == null || !bNCommonProgressDialog.isShowing()) {
            return;
        }
        Activity activity = this.b;
        if (activity == null || !activity.isFinishing()) {
            BNCommonProgressDialog bNCommonProgressDialog2 = this.c;
            IIX0o.ooOOo0oXI(bNCommonProgressDialog2);
            bNCommonProgressDialog2.dismiss();
            this.c = null;
        }
    }

    private final boolean d() {
        return IIX0o.Oxx0IOOO(Thread.currentThread(), Looper.getMainLooper().getThread());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNARNaviEntrance", "onDestroy ");
        }
        this.f6969a = null;
        b();
        a();
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        com.baidu.navisdk.util.permission.a.f9352a.a(this.b, new e());
    }

    public static /* synthetic */ void a(BNARNaviEntrance bNARNaviEntrance, Activity activity, b bVar, LifecycleOwner lifecycleOwner, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bVar = null;
        }
        if ((i2 & 4) != 0) {
            lifecycleOwner = null;
        }
        if ((i2 & 8) != 0) {
            i = 1;
        }
        bNARNaviEntrance.a(activity, bVar, lifecycleOwner, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNARNaviEntrance", "handleDownloadStateChange:" + i + TokenParser.SP);
        }
        if (i == 0) {
            h();
            return;
        }
        if (i == 1) {
            h();
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            i();
        } else {
            b();
            b bVar = this.f6969a;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    @xoIox
    public final void a(@oOoXoXO Activity activity, @oOoXoXO b bVar, @oOoXoXO LifecycleOwner lifecycleOwner, int i) {
        Lifecycle lifecycle;
        if (activity == null) {
            return;
        }
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.baidu.navisdk.module.ar.BNARNaviEntrance$onClickEnterArNavi$1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@OOXIXo LifecycleOwner lifecycleOwner2, @OOXIXo Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_STOP) {
                        BNARNaviEntrance.this.e();
                    }
                }
            });
        }
        this.f = i;
        this.f6969a = bVar;
        this.b = activity;
        g();
    }

    @Override // com.baidu.navisdk.module.ar.c.InterfaceC0214c
    public void a(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNARNaviEntrance", "onDownloadStateChange:" + i + TokenParser.SP);
        }
        if (d()) {
            b(i);
        } else {
            com.baidu.navisdk.util.worker.lite.a.c(new d(i, "BNWorkerCenter:onDownloadStateChange"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        com.baidu.navisdk.module.ar.a aVar = this.d;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        com.baidu.navisdk.module.ar.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.dismiss();
        }
        this.d = null;
    }
}
