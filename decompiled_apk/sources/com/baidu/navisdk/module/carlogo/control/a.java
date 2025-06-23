package com.baidu.navisdk.module.carlogo.control;

import android.app.Activity;
import android.content.Context;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.framework.interfaces.e;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNBaseDialog;
import com.baidu.navisdk.ui.widget.BNMessageDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.z;
import com.baidu.navisdk.util.jar.JarUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public final class a implements com.baidu.navisdk.module.carlogo.listeners.a, com.baidu.navisdk.module.carlogo.listeners.c {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.module.carlogo.interfaces.b f7060a;
    private com.baidu.navisdk.module.carlogo.control.c b;
    private e c;
    private WeakReference<Activity> d;
    private Context e;
    private int f;

    /* renamed from: com.baidu.navisdk.module.carlogo.control.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0232a implements com.baidu.navisdk.module.carlogo.listeners.d {
        public C0232a() {
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.d
        public void a(String str) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoPanelControl", "download3DCarLogoList.onSuccess: ");
            }
            a.this.f();
            if (a.this.f7060a != null) {
                a.this.f7060a.a(a.this.b.a(), a.this.b.b());
            }
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.d
        public void onFailed() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoPanelControl", "download3DCarLogoList.onFailed: ");
            }
            if (a.this.f7060a != null) {
                a.this.f7060a.b();
            }
        }

        @Override // com.baidu.navisdk.module.carlogo.listeners.d
        public void onStart() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoPanelControl", "download3DCarLogoList.onStart: ");
            }
            if (a.this.f7060a != null) {
                a.this.f7060a.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements BNBaseDialog.OnNaviClickListener {
        public b(a aVar) {
        }

        @Override // com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener
        public void onClick() {
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BNBaseDialog.OnNaviClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.module.carlogo.datas.c f7062a;

        public c(com.baidu.navisdk.module.carlogo.datas.c cVar) {
            this.f7062a = cVar;
        }

        @Override // com.baidu.navisdk.ui.widget.BNBaseDialog.OnNaviClickListener
        public void onClick() {
            a.this.c(this.f7062a);
        }
    }

    public a(Activity activity, com.baidu.navisdk.module.carlogo.interfaces.b bVar, com.baidu.navisdk.module.carlogo.control.c cVar) {
        this.f7060a = bVar;
        this.b = cVar;
        this.e = activity.getApplicationContext();
        this.d = new WeakReference<>(activity);
        g();
    }

    private void d(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "download3DCarLogoList: " + i);
        }
        com.baidu.navisdk.module.carlogo.control.c cVar = this.b;
        if (cVar != null) {
            cVar.a(new C0232a(), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "addDownloadZipListenerIfNeed: ");
        }
        com.baidu.navisdk.module.carlogo.control.c cVar = this.b;
        if (cVar != null) {
            cVar.a((com.baidu.navisdk.module.carlogo.listeners.c) this, true);
        }
    }

    private void g() {
        this.f7060a.setPanelListener(this);
    }

    public void e() {
        com.baidu.navisdk.module.carlogo.interfaces.b bVar = this.f7060a;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.listeners.a
    public void b() {
        e eVar = this.c;
        if (eVar != null) {
            eVar.b();
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("b.f.1", "4", null, null);
    }

    public void c(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "startDownload3DCarLogoList lastVehicle:" + this.f + ", curVehicle:" + i);
        }
        this.f = i;
        d(i);
    }

    public void a(e eVar) {
        this.c = eVar;
    }

    @Override // com.baidu.navisdk.module.carlogo.listeners.a
    public void a(boolean z) {
        e eVar = this.c;
        if (eVar != null) {
            eVar.a(z);
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.listeners.a
    public void b(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "onClickConfirm: " + i);
        }
        if (this.b != null) {
            com.baidu.navisdk.module.carlogo.interfaces.b bVar = this.f7060a;
            if (bVar != null) {
                bVar.a();
            }
            com.baidu.navisdk.module.carlogo.datas.c a2 = this.b.a(i);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoPanelControl", "onClickConfirm: " + a2);
            }
            if (a2 != null) {
                int i2 = a2.p;
                if (i2 == 1) {
                    b(a2);
                    return;
                }
                if (i2 != 2) {
                    if (i2 == 3) {
                        a(a2);
                    }
                } else if (!z.b(this.e)) {
                    TipTool.onCreateToastDialog(this.e, R.string.nsdk_string_network_connect_failture);
                } else {
                    if (this.b.a(this.e)) {
                        if (LogUtil.LOGGABLE) {
                            LogUtil.e("BN3DCarLogoPanelControl", "onClickConfirm: isNeedShowDatamanDialog");
                        }
                        d(a2);
                        return;
                    }
                    c(a2);
                }
            }
        }
    }

    public void d() {
        this.e = null;
        this.d = null;
        this.c = null;
        com.baidu.navisdk.module.carlogo.interfaces.b bVar = this.f7060a;
        if (bVar != null) {
            bVar.onDestroy();
            this.f7060a = null;
        }
        com.baidu.navisdk.module.carlogo.control.c cVar = this.b;
        if (cVar != null) {
            cVar.a(false);
            this.b = null;
        }
    }

    private void a(com.baidu.navisdk.module.carlogo.datas.c cVar) {
        boolean z;
        com.baidu.navisdk.module.carlogo.interfaces.b bVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "onClickCancelDownload: " + cVar);
        }
        com.baidu.navisdk.module.carlogo.control.c cVar2 = this.b;
        if (cVar2 != null) {
            z = cVar2.a(cVar);
            if (z && (bVar = this.f7060a) != null) {
                bVar.a(cVar);
            }
        } else {
            z = false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "onClickCancelDownload result: " + z);
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.listeners.a
    public void c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "onClickRetry: ");
        }
        d(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.navisdk.module.carlogo.datas.c cVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "onClickDownload: " + cVar);
        }
        com.baidu.navisdk.module.carlogo.control.c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(cVar.f7077a, cVar.i, (com.baidu.navisdk.module.carlogo.listeners.c) this, true, 100);
            com.baidu.navisdk.module.carlogo.interfaces.b bVar = this.f7060a;
            if (bVar != null) {
                bVar.a(cVar.f7077a, cVar);
            }
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("b.f.3", null, cVar.f7077a + "", null);
    }

    private boolean d(com.baidu.navisdk.module.carlogo.datas.c cVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "showDatamanDialog: ");
        }
        WeakReference<Activity> weakReference = this.d;
        if (weakReference != null && weakReference.get() != null) {
            BNMessageDialog bNMessageDialog = new BNMessageDialog(this.d.get());
            bNMessageDialog.setTitleText(JarUtils.getResources().getString(R.string.nsdk_string_down_maidou_alert_title)).setMessage(JarUtils.getResources().getString(R.string.nsdk_string_not_wifi_notification)).setFirstBtnText(JarUtils.getResources().getString(R.string.nsdk_string_common_alert_cancel)).setSecondBtnText(JarUtils.getResources().getString(R.string.nsdk_string_common_alert_confirm)).setOnSecondBtnClickListener((BNBaseDialog.OnNaviClickListener) new c(cVar)).setOnFirstBtnClickListener((BNBaseDialog.OnNaviClickListener) new b(this));
            bNMessageDialog.show();
            return true;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "showDatamanDialog mActivity == null || mActivity.get() == null");
        }
        c(cVar);
        return false;
    }

    @Override // com.baidu.navisdk.module.carlogo.listeners.a
    public boolean a(com.baidu.navisdk.module.carlogo.datas.a aVar, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "onColorChange(), gifModel = " + aVar + " carLogoId = " + i);
        }
        com.baidu.navisdk.module.carlogo.control.c cVar = this.b;
        if (cVar != null) {
            return cVar.a(aVar, i);
        }
        if (!LogUtil.LOGGABLE) {
            return false;
        }
        LogUtil.e("BN3DCarLogoPanelControl", "onColorChange m3DDataManager == null");
        return false;
    }

    @Override // com.baidu.navisdk.module.carlogo.listeners.a
    public void a(int i, int i2) {
        com.baidu.navisdk.module.carlogo.datas.c cVar;
        com.baidu.navisdk.module.carlogo.interfaces.b bVar;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "onPageSelected(), position = " + i + " carLogoId = " + i2);
        }
        com.baidu.navisdk.module.carlogo.control.c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.b(i2);
            cVar = this.b.a(i2);
        } else {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DCarLogoPanelControl", "onPageSelected: m3DDataManager == null");
            }
            cVar = null;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "onPageSelected: " + cVar);
        }
        if (cVar == null || (bVar = this.f7060a) == null) {
            return;
        }
        bVar.b(cVar);
    }

    private void b(com.baidu.navisdk.module.carlogo.datas.c cVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "onClickChangeCarLogo: " + cVar);
        }
        e eVar = this.c;
        if (eVar == null || cVar == null) {
            return;
        }
        boolean a2 = eVar.a(cVar.o, cVar.e(), cVar.b);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "onClickChangeCarLogo: " + a2);
        }
        com.baidu.navisdk.module.carlogo.control.c cVar2 = this.b;
        if (cVar2 != null) {
            cVar2.a(cVar, this.e);
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("b.f.4", cVar.f7077a + "", cVar.f(), null);
        this.c.a(true);
    }

    @Override // com.baidu.navisdk.module.carlogo.listeners.a
    public com.baidu.navisdk.module.carlogo.datas.c a(int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "get3DModel: " + i);
        }
        com.baidu.navisdk.module.carlogo.control.c cVar = this.b;
        if (cVar != null) {
            return cVar.a(i);
        }
        return null;
    }

    @Override // com.baidu.navisdk.module.carlogo.listeners.a
    public boolean a() {
        e eVar = this.c;
        if (eVar != null) {
            return eVar.a();
        }
        return true;
    }

    public void b(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "updateStyle: " + z);
        }
        com.baidu.navisdk.module.carlogo.interfaces.b bVar = this.f7060a;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.listeners.c
    public void a(String str) {
        com.baidu.navisdk.module.carlogo.control.c cVar;
        if (this.f7060a == null || (cVar = this.b) == null) {
            return;
        }
        com.baidu.navisdk.module.carlogo.datas.c a2 = cVar.a(str);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "downloadZip.onFailed url: " + str + ", " + a2);
        }
        if (a2 != null) {
            this.f7060a.a(a2, a2.f7077a);
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.listeners.c
    public void a(String str, String str2) {
        com.baidu.navisdk.module.carlogo.control.c cVar;
        if (this.f7060a == null || (cVar = this.b) == null) {
            return;
        }
        com.baidu.navisdk.module.carlogo.datas.c a2 = cVar.a(str);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "downloadZip.onSuccess url: " + str + ", " + a2);
        }
        if (a2 != null) {
            this.f7060a.b(a2, a2.f7077a);
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.listeners.c
    public void a(int i, String str) {
        com.baidu.navisdk.module.carlogo.control.c cVar;
        if (this.f7060a == null || (cVar = this.b) == null) {
            return;
        }
        com.baidu.navisdk.module.carlogo.datas.c a2 = cVar.a(str);
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DCarLogoPanelControl", "downloadZip.onProgress url: " + str + ", progress: " + i + ", dModel:" + a2);
        }
        if (a2 != null) {
            a2.q = i;
            this.f7060a.a(i, a2.f7077a);
        }
    }
}
