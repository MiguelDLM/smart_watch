package com.baidu.navisdk.module.pronavi.message;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import com.baidu.navisdk.adapter.struct.BNHighwayInfo;
import com.baidu.navisdk.adapter.struct.BNRoadCondition;
import com.baidu.navisdk.adapter.struct.BNavLineItem;
import com.baidu.navisdk.adapter.struct.BNaviLocation;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.model.datastruct.g;
import com.baidu.navisdk.ui.routeguide.model.RGLineItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class b extends a {
    @Override // com.baidu.navisdk.framework.interfaces.k
    public void G() {
        BNRouteGuider.getInstance().messageCallback(20, 0, 0, e.BROWSE);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void H() {
        BNRouteGuider.getInstance().messageCallback(17, 0, 0, null);
    }

    public void a(c cVar, BNHighwayInfo bNHighwayInfo) {
        BNRouteGuider.getInstance().messageCallback(9, 0, 0, cVar, bNHighwayInfo);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public long[] b(boolean z) {
        try {
            return (long[]) BNRouteGuider.getInstance().getNaviListenerMessage(4, 0, 0, Boolean.valueOf(z));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void c(String str) {
        BNRouteGuider.getInstance().messageCallback(21, 0, 0, str);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public Rect c0() {
        try {
            return (Rect) BNRouteGuider.getInstance().getNaviListenerMessage(3, 0, 0, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void f(int i) {
        BNRouteGuider.getInstance().messageCallback(18, i, 0, null);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void l(int i) {
        BNRouteGuider.getInstance().messageCallback(23, i, 0, null);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void n(int i) {
        BNRouteGuider.getInstance().messageCallback(14, i, 0, null);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void onLocationChange(g gVar) {
        BNaviLocation bNaviLocation = new BNaviLocation();
        bNaviLocation.accuracy = gVar.f;
        bNaviLocation.altitude = gVar.h;
        bNaviLocation.direction = gVar.e;
        bNaviLocation.latitude = gVar.f6926a;
        bNaviLocation.speed = gVar.c;
        bNaviLocation.time = gVar.j;
        bNaviLocation.longitude = gVar.b;
        BNRouteGuider.getInstance().messageCallback(19, 0, 0, bNaviLocation);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void onRemainInfoUpdate(int i, int i2) {
        BNRouteGuider.getInstance().messageCallback(6, i, i2, null);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void onRoadNameUpdate(String str) {
        BNRouteGuider.getInstance().messageCallback(5, 0, 0, str);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void q() {
        BNRouteGuider.getInstance().messageCallback(25, 0, 0, null);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void r0() {
        BNRouteGuider.getInstance().messageCallback(20, 0, 0, e.NAVING);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void w() {
        BNRouteGuider.getInstance().messageCallback(22, 0, 0, null);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void y(Message message) {
        BNRouteGuider.getInstance().messageCallback(7, 0, 0, message);
    }

    public void a(c cVar, View view, String str, int i, String str2, Bitmap bitmap) {
        Bundle bundle = new Bundle();
        bundle.putInt("infoAction", cVar.ordinal());
        bundle.putString("remainDistance", str);
        bundle.putInt("progress", i);
        bundle.putString("roadName", str2);
        bundle.putParcelable("turnIcon", bitmap);
        BNRouteGuider.getInstance().messageCallback(11, 0, 0, view, bundle);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void y() {
        BNRouteGuider.getInstance().messageCallback(15, 0, 0, c.HIDE, null);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void b(String str) {
        BNRouteGuider.getInstance().messageCallback(24, 0, 0, str);
    }

    public void a(double d, List<BNRoadCondition> list) {
        BNRouteGuider.getInstance().messageCallback(13, 0, 0, Double.valueOf(d), list);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(List<RGLineItem> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new BNavLineItem(list.get(i)));
        }
        BNRouteGuider.getInstance().messageCallback(15, 0, 0, c.SHOW, arrayList);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a(String str, int i) {
        int i2;
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i2 = -1;
        }
        BNRouteGuider.getInstance().messageCallback(16, i2, i, null);
    }

    @Override // com.baidu.navisdk.framework.interfaces.k
    public void a() {
        BNRouteGuider.getInstance().messageCallback(26, 0, 0, null);
    }
}
