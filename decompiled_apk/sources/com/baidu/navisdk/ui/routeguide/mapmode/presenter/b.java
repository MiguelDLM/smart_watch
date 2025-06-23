package com.baidu.navisdk.ui.routeguide.mapmode.presenter;

import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f8697a = new a();

    void a(boolean z);

    void a(boolean z, boolean z2);

    void b(boolean z);

    void e(boolean z);

    void f();

    void h(boolean z);

    void n();

    void p();

    /* loaded from: classes8.dex */
    public class a implements b {
        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
        public void a(boolean z, boolean z2) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IControlPanelPresenter", "showUGCBtnLayout(), visible=" + z + ",immediately=" + z2);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
        public void b(boolean z) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IControlPanelPresenter", "setAllowShowingUgcBtn(), allowShowingUgcBtn=" + z);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
        public void e(boolean z) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IControlPanelPresenter", "showToCommuteNaviBtn(), visible=" + z);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
        public void f() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IControlPanelPresenter", "onBluetoothConnected()");
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
        public void h(boolean z) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
        public void n() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IControlPanelPresenter", "onBluetoothDisconnected()");
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
        public void p() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IControlPanelPresenter", "onFlingMap()");
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.b
        public void a(boolean z) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IControlPanelPresenter", "setIsAllowShowToCommuteGuideBtn(),isAllowShowToCommuteGuideBtn:" + z);
            }
        }
    }
}
