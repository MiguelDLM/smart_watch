package com.baidu.navisdk.framework.interfaces;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.model.RGLineItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public interface k extends h {

    /* loaded from: classes7.dex */
    public interface a {
        void a(ArrayList<com.baidu.navisdk.model.datastruct.s> arrayList);

        void onSearchExit();

        void onSearchFailed();
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i, RoutePlanNode routePlanNode, int i2);

        void b(int i, RoutePlanNode routePlanNode, int i2);

        void onStart();
    }

    void A();

    void B();

    void D();

    int E();

    boolean F();

    void G();

    void H();

    boolean J();

    void L();

    long N();

    boolean P();

    String R();

    boolean S();

    boolean T();

    boolean U();

    void V();

    void W();

    boolean X();

    void a();

    void a(double d);

    void a(long j, float f, float f2, double d, double d2, double d3, double d4, float f3);

    void a(Activity activity, String str, Bundle bundle);

    void a(a aVar);

    void a(b bVar);

    void a(com.baidu.navisdk.model.datastruct.g gVar);

    void a(String str);

    void a(String str, int i);

    void a(String str, int i, String str2);

    void a(String str, int i, String str2, int i2);

    void a(List<RGLineItem> list);

    void a0();

    void b(int i);

    void b(Activity activity, String str, Bundle bundle);

    void b(String str);

    long[] b(boolean z);

    void c(int i);

    void c(Activity activity, String str, Bundle bundle);

    void c(String str);

    Rect c0();

    void d(int i);

    void d(boolean z);

    void e(boolean z);

    void f(int i);

    void f(boolean z);

    boolean f0();

    void g();

    void h(int i);

    void h(boolean z);

    boolean h0();

    void i(int i);

    void i(boolean z);

    void i0();

    boolean isNodeClick();

    void j();

    void j(boolean z);

    boolean j0();

    void k(int i);

    boolean k();

    void k0();

    void l();

    void l(int i);

    b l0();

    void m(int i);

    boolean m();

    a m0();

    void n(int i);

    boolean o0();

    boolean onBackPressed();

    void onLocationChange(com.baidu.navisdk.model.datastruct.g gVar);

    void onNoNewRoute();

    void onRemainInfoUpdate(int i, int i2);

    void onRoadNameUpdate(String str);

    boolean p();

    boolean p0();

    void q();

    void q0();

    void r();

    void r0();

    void s();

    boolean s0();

    void t();

    void u();

    void u0();

    boolean v();

    void w();

    void w0();

    void y();

    void y(Message message);

    boolean z();
}
