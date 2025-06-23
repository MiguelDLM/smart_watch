package com.baidu.navisdk.ui.routeguide.mapmode.presenter;

import android.os.Bundle;
import android.view.View;
import com.baidu.navisdk.ui.routeguide.subview.widget.CircleProgressImageView;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8696a = new C0451a();

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.presenter.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0451a implements a {
        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void a(int i) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void b(int i, int i2) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void c(boolean z) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void d(int i) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public boolean e() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IAssistGuidePresenter", "getMapSwitchVisibility()");
                return false;
            }
            return false;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void f(boolean z) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void g(boolean z) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public boolean j() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IAssistGuidePresenter", "isRoadConditionBarShown()");
                return false;
            }
            return false;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void k() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void m() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void o() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void q() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IAssistGuidePresenter", "updateCurCarSpeed()");
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void r() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IAssistGuidePresenter", "updateLeftTopLayoutMarginTop()");
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public View s() {
            return null;
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void u() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void a(int i, int i2) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void b(boolean z) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IAssistGuidePresenter", "showMapSwitchOrRoadBar(), show=" + z);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void d() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IAssistGuidePresenter", "updateRoadConditionBarMarginTop()");
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void g() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IAssistGuidePresenter", "initRoadConditionBarMarginLocation()");
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void a(CircleProgressImageView[] circleProgressImageViewArr) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void a() {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IAssistGuidePresenter", "updateFullViewBtn()");
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void b(Bundle bundle) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IAssistGuidePresenter", "updateAssistInfoView(), data=" + bundle);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void a(int i, boolean z) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IAssistGuidePresenter", "setIntervalAndCurCarSpeedVisibility(), visibility=" + i + ",withAnim=" + z);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void b(int i) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IAssistGuidePresenter", "setCurCarSpeedVisibility(), visibility=" + i);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.presenter.a
        public void a(Bundle bundle) {
            g gVar = g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("IAssistGuidePresenter", "updateIntervalCameraData(),data=" + bundle);
            }
        }
    }

    void a();

    void a(int i);

    void a(int i, int i2);

    void a(int i, boolean z);

    void a(Bundle bundle);

    void a(CircleProgressImageView[] circleProgressImageViewArr);

    void b(int i);

    void b(int i, int i2);

    void b(Bundle bundle);

    void b(boolean z);

    void c(boolean z);

    void d();

    void d(int i);

    boolean e();

    void f(boolean z);

    void g();

    void g(boolean z);

    boolean j();

    void k();

    void m();

    void o();

    void q();

    void r();

    View s();

    void u();
}
