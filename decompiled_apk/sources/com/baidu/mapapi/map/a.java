package com.baidu.mapapi.map;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.platform.comapi.bmsdk.BmArc;
import com.baidu.platform.comapi.bmsdk.BmBaseLine;
import com.baidu.platform.comapi.bmsdk.BmCircle;
import com.baidu.platform.comapi.bmsdk.BmDrawItem;
import com.baidu.platform.comapi.bmsdk.BmPolygon;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class a implements com.baidu.platform.comapi.bmsdk.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaiduMap f5876a;

    public a(BaiduMap baiduMap) {
        this.f5876a = baiduMap;
    }

    @Override // com.baidu.platform.comapi.bmsdk.d
    public void a(BmDrawItem bmDrawItem, BmBaseUI bmBaseUI) {
    }

    @Override // com.baidu.platform.comapi.bmsdk.d
    public void a(BmDrawItem bmDrawItem) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        CopyOnWriteArrayList copyOnWriteArrayList3;
        CopyOnWriteArrayList copyOnWriteArrayList4;
        if (bmDrawItem instanceof BmArc) {
            BmArc bmArc = (BmArc) bmDrawItem;
            copyOnWriteArrayList4 = this.f5876a.H;
            Iterator it = copyOnWriteArrayList4.iterator();
            while (it.hasNext()) {
                ((BaiduMap.OnArcClickListener) it.next()).onArcClick(bmArc.a());
            }
            return;
        }
        if (bmDrawItem instanceof BmBaseLine) {
            BmBaseLine bmBaseLine = (BmBaseLine) bmDrawItem;
            copyOnWriteArrayList3 = this.f5876a.B;
            Iterator it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                ((BaiduMap.OnPolylineClickListener) it2.next()).onPolylineClick(bmBaseLine.a());
            }
            return;
        }
        if (bmDrawItem instanceof BmCircle) {
            BmCircle bmCircle = (BmCircle) bmDrawItem;
            bmCircle.a().k = (int) bmCircle.b();
            copyOnWriteArrayList2 = this.f5876a.D;
            Iterator it3 = copyOnWriteArrayList2.iterator();
            while (it3.hasNext()) {
                ((BaiduMap.OnCircleClickListener) it3.next()).onCircleClick(bmCircle.a());
            }
            return;
        }
        if (bmDrawItem instanceof BmPolygon) {
            BmPolygon bmPolygon = (BmPolygon) bmDrawItem;
            bmPolygon.a().p = (int) bmPolygon.b();
            copyOnWriteArrayList = this.f5876a.E;
            Iterator it4 = copyOnWriteArrayList.iterator();
            while (it4.hasNext()) {
                ((BaiduMap.OnPolygonClickListener) it4.next()).onPolygonClick(bmPolygon.a());
            }
        }
    }
}
