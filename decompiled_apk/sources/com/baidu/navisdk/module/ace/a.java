package com.baidu.navisdk.module.ace;

import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navisdk.j;
import com.baidu.navisdk.util.common.g;
import com.baidu.platform.comapi.bmsdk.BmGeoElement;
import com.baidu.platform.comapi.bmsdk.BmLayer;
import com.baidu.platform.comapi.bmsdk.BmMCPoint;
import com.baidu.platform.comapi.bmsdk.BmPolygon;
import com.baidu.platform.comapi.bmsdk.style.BmLineStyle;
import com.baidu.platform.comapi.bmsdk.style.BmSurfaceStyle;
import com.baidu.platform.comapi.map.BaiduMapSurfaceView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class a {
    private BmLayer b;

    /* renamed from: a, reason: collision with root package name */
    private final List<BmPolygon> f6965a = new ArrayList();
    private int c = 605585143;

    public a() {
        if (j.d()) {
            this.b = new BmLayer(true);
        }
    }

    private void b(List<b> list) {
        g gVar = g.ACE;
        if (gVar.d()) {
            gVar.e("ACEAoiDrawer", "drawAll(), modelList = " + list);
        }
        if (j.d() && list != null) {
            BmLayer bmLayer = new BmLayer(true);
            BaiduMapSurfaceView mapView = MapViewFactory.getInstance().getMapView();
            if (!mapView.getBmlayers().contains(bmLayer)) {
                mapView.addBmLayerBelow(MapViewFactory.getInstance().getMapView().getDefaultLocationLay(), bmLayer);
            }
            for (int i = 0; i < list.size(); i++) {
                BmPolygon a2 = a(list.get(i));
                this.f6965a.add(a2);
                bmLayer.addDrawItem(a2);
            }
            bmLayer.setClickable(false);
            bmLayer.commitUpdate();
            this.b = bmLayer;
        }
    }

    public void a(List<b> list) {
        g gVar = g.ACE;
        if (gVar.d()) {
            gVar.e("ACEAoiDrawer", "showAll(), modelList = " + list);
        }
        if (list == null) {
            return;
        }
        a();
        b(list);
    }

    private BmPolygon a(b bVar) {
        g gVar = g.ACE;
        if (gVar.d()) {
            gVar.e("ACEAoiDrawer", "createPolygone(), model = " + bVar);
        }
        BmLayer bmLayer = new BmLayer(true);
        BaiduMapSurfaceView mapView = MapViewFactory.getInstance().getMapView();
        if (!mapView.getBmlayers().contains(bmLayer)) {
            mapView.addBmLayerBelow(MapViewFactory.getInstance().getMapView().getDefaultLocationLay(), bmLayer);
        }
        BmPolygon bmPolygon = new BmPolygon();
        BmGeoElement bmGeoElement = new BmGeoElement(0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bVar.f6966a.size(); i++) {
            arrayList.add(new BmMCPoint(bVar.f6966a.get(i).a(), bVar.f6966a.get(i).b()));
        }
        bmGeoElement.setPoints(arrayList);
        BmLineStyle bmLineStyle = new BmLineStyle();
        bmLineStyle.setWidth(2);
        bmLineStyle.setColor(-16739841);
        bmLineStyle.setLineType(1);
        bmGeoElement.setStyle(bmLineStyle);
        BmSurfaceStyle bmSurfaceStyle = new BmSurfaceStyle();
        bmSurfaceStyle.setColor(this.c);
        bmPolygon.addGeoElement(bmGeoElement);
        bmPolygon.setSurfaceStyle(bmSurfaceStyle);
        return bmPolygon;
    }

    public void b() {
        g gVar = g.ACE;
        if (gVar.d()) {
            gVar.e("ACEAoiDrawer", "hide(), mPolygonList = " + this.f6965a);
        }
        Iterator<BmPolygon> it = this.f6965a.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(4);
        }
    }

    public void a() {
        g gVar = g.ACE;
        if (gVar.d()) {
            gVar.e("ACEAoiDrawer", "clear(), mPolygonList = " + this.f6965a + " mLayer = " + this.b);
        }
        b();
        BmLayer bmLayer = this.b;
        if (bmLayer != null) {
            bmLayer.clearDrawItems();
            this.b.commitUpdate();
            MapViewFactory.getInstance().getMapView().removeBmLayer(this.b);
            this.b = null;
        }
        this.f6965a.clear();
    }
}
