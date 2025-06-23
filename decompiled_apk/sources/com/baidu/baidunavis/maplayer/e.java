package com.baidu.baidunavis.maplayer;

import XIXIX.OOXIXo;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.OverlayItem;
import com.baidu.platform.comapi.map.PoiDynamicMapOverlay;
import com.baidu.platform.comapi.map.TruckDynamicOverlay;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.baidunavis.maplayer.a f5580a;
    private BMItemizedOverlay b;
    private BMItemizedOverlay c;
    private BMItemizedOverlay d;
    private BMItemizedOverlay e;
    private final c f;

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final e f5581a = new e();
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.util.worker.lite.b {

        /* renamed from: a, reason: collision with root package name */
        boolean f5582a;
        String b;

        public c(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.lite.b, java.lang.Runnable
        public void run() {
            e.this.a(this.f5582a, this.b);
        }
    }

    public static e k() {
        return b.f5581a;
    }

    private void l() {
        this.f5580a = com.baidu.baidunavis.maplayer.a.h();
        if (ScreenUtil.getInstance().getWidthPixels() > 10) {
            ScreenUtil.getInstance().getWidthPixels();
        }
        if (ScreenUtil.getInstance().getHeightPixels() > 10) {
            ScreenUtil.getInstance().getHeightPixels();
        }
    }

    public void a(ArrayList<g> arrayList, i iVar) {
        a(arrayList, iVar, true);
    }

    public void b(d dVar, i iVar) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapLayerUtils", "showRoutePanoramaOverlay=" + dVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        if (this.d == null) {
            this.d = new BMItemizedOverlay();
        }
        this.d.setOnTapListener(iVar);
        if (!this.f5580a.c().contains(this.d)) {
            this.f5580a.a(this.d);
        }
        this.d.removeAll();
        this.d.addItem(arrayList);
        this.f5580a.b(this.d);
    }

    public int c() {
        com.baidu.baidunavis.maplayer.a aVar = this.f5580a;
        if (aVar == null) {
            return 0;
        }
        return (int) aVar.f();
    }

    public double d() {
        if (this.f5580a != null) {
            return MapController.getScaleDis(c());
        }
        return OOXIXo.f3760XO;
    }

    public void e() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapLayerUtils", "hideDestPanoramaBubbleOverlay: ");
        }
        if (!h()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNMapLayerUtils", "hideDestPanoramaBubbleOverlay not showing");
                return;
            }
            return;
        }
        BMItemizedOverlay bMItemizedOverlay = this.e;
        if (bMItemizedOverlay != null) {
            bMItemizedOverlay.setOnTapListener(null);
            this.e.hide();
            this.e.removeAll();
            this.f5580a.c(this.e);
        }
    }

    public void f() {
        BMItemizedOverlay bMItemizedOverlay;
        boolean i = i();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapLayerUtils", "hideLongDistanceOverlay --> isLongDistanceOverlayShowing = " + i);
        }
        if (i && (bMItemizedOverlay = this.b) != null) {
            bMItemizedOverlay.setOnTapListener(null);
            this.b.hide();
            this.b.removeAll();
        }
    }

    public void g() {
        BMItemizedOverlay bMItemizedOverlay = this.c;
        if (bMItemizedOverlay != null) {
            bMItemizedOverlay.hide();
            this.c.removeAll();
        }
    }

    public boolean h() {
        BMItemizedOverlay bMItemizedOverlay = this.e;
        if (bMItemizedOverlay != null) {
            return bMItemizedOverlay.isShowing();
        }
        return false;
    }

    public boolean i() {
        BMItemizedOverlay bMItemizedOverlay = this.b;
        if (bMItemizedOverlay != null) {
            return bMItemizedOverlay.isShowing();
        }
        return false;
    }

    public void j() {
        PoiDynamicMapOverlay overlay = com.baidu.baidunavis.maplayer.a.h().b().getOverlay(PoiDynamicMapOverlay.class);
        if (overlay != null) {
            overlay.setFocus(0, true);
        }
    }

    private e() {
        this.f = new c("lpofr");
        l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b A[Catch: Exception -> 0x0044, TRY_LEAVE, TryCatch #0 {Exception -> 0x0044, blocks: (B:27:0x0035, B:12:0x0047, B:14:0x004b), top: B:26:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0062 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.ArrayList<com.baidu.baidunavis.maplayer.g> r4, com.baidu.baidunavis.maplayer.i r5, boolean r6) {
        /*
            r3 = this;
            boolean r0 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            java.lang.String r1 = "BNMapLayerUtils"
            if (r0 == 0) goto Le
            java.lang.String r0 = "showLongDistanceOverlay"
            java.lang.String r2 = "itemList"
            com.baidu.navisdk.util.common.LogUtil.printList(r1, r0, r2, r4)
        Le:
            com.baidu.baidunavis.maplayer.BMItemizedOverlay r0 = r3.b
            if (r0 != 0) goto L19
            com.baidu.baidunavis.maplayer.f r0 = new com.baidu.baidunavis.maplayer.f
            r0.<init>()
            r3.b = r0
        L19:
            com.baidu.baidunavis.maplayer.BMItemizedOverlay r0 = r3.b
            r0.setOnTapListener(r5)
            com.baidu.baidunavis.maplayer.a r5 = r3.f5580a
            java.util.List r5 = r5.c()
            com.baidu.baidunavis.maplayer.BMItemizedOverlay r0 = r3.b
            boolean r5 = r5.contains(r0)
            if (r5 != 0) goto L33
            com.baidu.baidunavis.maplayer.a r5 = r3.f5580a
            com.baidu.baidunavis.maplayer.BMItemizedOverlay r0 = r3.b
            r5.a(r0)
        L33:
            if (r6 != 0) goto L46
            com.baidu.baidunavis.maplayer.BMItemizedOverlay r5 = r3.b     // Catch: java.lang.Exception -> L44
            java.util.ArrayList r5 = r5.getAllItem()     // Catch: java.lang.Exception -> L44
            boolean r5 = r3.a(r5, r4)     // Catch: java.lang.Exception -> L44
            if (r5 == 0) goto L42
            goto L46
        L42:
            r5 = 0
            goto L47
        L44:
            r5 = move-exception
            goto L63
        L46:
            r5 = 1
        L47:
            boolean r6 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE     // Catch: java.lang.Exception -> L44
            if (r6 == 0) goto L60
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L44
            r6.<init>()     // Catch: java.lang.Exception -> L44
            java.lang.String r0 = "showLongDistanceOverlay --> isDataChanged = "
            r6.append(r0)     // Catch: java.lang.Exception -> L44
            r6.append(r5)     // Catch: java.lang.Exception -> L44
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L44
            com.baidu.navisdk.util.common.LogUtil.e(r1, r6)     // Catch: java.lang.Exception -> L44
        L60:
            if (r5 != 0) goto L7c
            return
        L63:
            boolean r6 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            if (r6 == 0) goto L7c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "showLongDistanceOverlay --> e = "
            r6.append(r0)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.baidu.navisdk.util.common.LogUtil.e(r1, r5)
        L7c:
            com.baidu.baidunavis.maplayer.BMItemizedOverlay r5 = r3.b
            r5.removeAll()
            com.baidu.baidunavis.maplayer.BMItemizedOverlay r5 = r3.b
            r5.addItem(r4)
            com.baidu.baidunavis.maplayer.a r4 = r3.f5580a
            com.baidu.baidunavis.maplayer.BMItemizedOverlay r5 = r3.b
            r4.b(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.baidunavis.maplayer.e.a(java.util.ArrayList, com.baidu.baidunavis.maplayer.i, boolean):void");
    }

    public String b() {
        com.baidu.baidunavis.maplayer.a aVar = this.f5580a;
        if (aVar != null && aVar.a() != null) {
            String buildingId = this.f5580a.a().getFocusedBaseIndoorMapInfo().getBuildingId();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNMapLayerUtils", "getIndoorId from Engine=" + buildingId);
            }
            return buildingId;
        }
        if (!LogUtil.LOGGABLE) {
            return null;
        }
        LogUtil.e("BNMapLayerUtils", "getIndoorId null" + this.f5580a + ", return!");
        return null;
    }

    private boolean a(ArrayList<g> arrayList, ArrayList<g> arrayList2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.printList("BNMapLayerUtils", "isDataChanged", "oldItemList", arrayList);
            LogUtil.printList("BNMapLayerUtils", "isDataChanged", "newItemList", arrayList2);
        }
        if (arrayList == null && arrayList2 == null) {
            return false;
        }
        if (arrayList == null || arrayList2 == null || arrayList.size() != arrayList2.size()) {
            return true;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            g gVar = arrayList.get(i);
            g gVar2 = arrayList2.get(i);
            if ((gVar != null && gVar2 == null) || (gVar == null && gVar2 != null)) {
                return true;
            }
            if (gVar != null) {
                if (gVar.d() != gVar2.d()) {
                    return true;
                }
                if (gVar.c() != null) {
                    if (!gVar.c().equals(gVar2.c())) {
                        return true;
                    }
                } else if (gVar2.c() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void b(boolean z) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapLayerUtils", "showOpgridLayer show = " + z);
        }
        com.baidu.baidunavis.maplayer.a aVar = this.f5580a;
        if (aVar != null && aVar.a() != null) {
            this.f5580a.a().getBaseMap().ShowLayers(this.f5580a.a().getBaseMap().getLayerIDByTag("opgrid"), z);
        } else if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMapLayerUtils", "showOpgridLayer null" + this.f5580a + ", return!");
        }
    }

    public d a(int i) {
        BMItemizedOverlay bMItemizedOverlay = this.b;
        if (bMItemizedOverlay == null) {
            return null;
        }
        return (d) bMItemizedOverlay.getItem(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f8 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0007, B:6:0x000b, B:9:0x0028, B:10:0x0020, B:11:0x0044, B:13:0x0048, B:14:0x0051, B:16:0x005f, B:17:0x0066, B:19:0x007b, B:21:0x0081, B:22:0x0085, B:24:0x008b, B:27:0x009b, B:30:0x00a7, B:33:0x00b4, B:35:0x00b8, B:36:0x00e1, B:38:0x00e8, B:40:0x00ee, B:41:0x00f2, B:43:0x00f8, B:46:0x0101, B:49:0x010e, B:57:0x0115, B:58:0x0119, B:60:0x011f, B:63:0x012f, B:66:0x013b, B:67:0x0164, B:69:0x016a, B:71:0x016e, B:72:0x0179, B:75:0x0182, B:76:0x023c, B:81:0x0196, B:84:0x01c2, B:86:0x020b, B:87:0x020f, B:89:0x0215, B:91:0x0222, B:92:0x0237, B:93:0x0245, B:95:0x024f, B:96:0x028a, B:98:0x02a7, B:99:0x02ab, B:101:0x02b1), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011f A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0007, B:6:0x000b, B:9:0x0028, B:10:0x0020, B:11:0x0044, B:13:0x0048, B:14:0x0051, B:16:0x005f, B:17:0x0066, B:19:0x007b, B:21:0x0081, B:22:0x0085, B:24:0x008b, B:27:0x009b, B:30:0x00a7, B:33:0x00b4, B:35:0x00b8, B:36:0x00e1, B:38:0x00e8, B:40:0x00ee, B:41:0x00f2, B:43:0x00f8, B:46:0x0101, B:49:0x010e, B:57:0x0115, B:58:0x0119, B:60:0x011f, B:63:0x012f, B:66:0x013b, B:67:0x0164, B:69:0x016a, B:71:0x016e, B:72:0x0179, B:75:0x0182, B:76:0x023c, B:81:0x0196, B:84:0x01c2, B:86:0x020b, B:87:0x020f, B:89:0x0215, B:91:0x0222, B:92:0x0237, B:93:0x0245, B:95:0x024f, B:96:0x028a, B:98:0x02a7, B:99:0x02ab, B:101:0x02b1), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x016a A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0007, B:6:0x000b, B:9:0x0028, B:10:0x0020, B:11:0x0044, B:13:0x0048, B:14:0x0051, B:16:0x005f, B:17:0x0066, B:19:0x007b, B:21:0x0081, B:22:0x0085, B:24:0x008b, B:27:0x009b, B:30:0x00a7, B:33:0x00b4, B:35:0x00b8, B:36:0x00e1, B:38:0x00e8, B:40:0x00ee, B:41:0x00f2, B:43:0x00f8, B:46:0x0101, B:49:0x010e, B:57:0x0115, B:58:0x0119, B:60:0x011f, B:63:0x012f, B:66:0x013b, B:67:0x0164, B:69:0x016a, B:71:0x016e, B:72:0x0179, B:75:0x0182, B:76:0x023c, B:81:0x0196, B:84:0x01c2, B:86:0x020b, B:87:0x020f, B:89:0x0215, B:91:0x0222, B:92:0x0237, B:93:0x0245, B:95:0x024f, B:96:0x028a, B:98:0x02a7, B:99:0x02ab, B:101:0x02b1), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0182 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:4:0x0007, B:6:0x000b, B:9:0x0028, B:10:0x0020, B:11:0x0044, B:13:0x0048, B:14:0x0051, B:16:0x005f, B:17:0x0066, B:19:0x007b, B:21:0x0081, B:22:0x0085, B:24:0x008b, B:27:0x009b, B:30:0x00a7, B:33:0x00b4, B:35:0x00b8, B:36:0x00e1, B:38:0x00e8, B:40:0x00ee, B:41:0x00f2, B:43:0x00f8, B:46:0x0101, B:49:0x010e, B:57:0x0115, B:58:0x0119, B:60:0x011f, B:63:0x012f, B:66:0x013b, B:67:0x0164, B:69:0x016a, B:71:0x016e, B:72:0x0179, B:75:0x0182, B:76:0x023c, B:81:0x0196, B:84:0x01c2, B:86:0x020b, B:87:0x020f, B:89:0x0215, B:91:0x0222, B:92:0x0237, B:93:0x0245, B:95:0x024f, B:96:0x028a, B:98:0x02a7, B:99:0x02ab, B:101:0x02b1), top: B:3:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0194  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(android.graphics.drawable.Drawable r19, java.util.ArrayList<com.baidu.baidunavis.maplayer.d> r20, com.baidu.baidunavis.maplayer.i r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 703
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.baidunavis.maplayer.e.a(android.graphics.drawable.Drawable, java.util.ArrayList, com.baidu.baidunavis.maplayer.i, boolean):void");
    }

    private void a(ArrayList<d> arrayList, int i) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        LogUtil.e("DrawRouteUtil", "setGrowthAnimForItem --> execute growth animate");
        Iterator<d> it = arrayList.iterator();
        while (it.hasNext()) {
            d next = it.next();
            next.setAnimateEffect(OverlayItem.AnimEffect.GROWTH_FADE_IN);
            next.setAnimateStartSize(0, 0);
            next.setAnimateDuration(i);
            next.setDelay(null);
        }
    }

    private void a(ArrayList<d> arrayList, int i, int i2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        LogUtil.e("DrawRouteUtil", "setShrinkAnimForItem --> execute shrink animate");
        Iterator<d> it = arrayList.iterator();
        while (it.hasNext()) {
            d next = it.next();
            next.setAnimateEffect(OverlayItem.AnimEffect.SHRINK_FADE_OUT);
            next.setAnimateEndSize(0, 0);
            next.setAnimateDuration(i);
            if (i2 > 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("delay_type", 2);
                bundle.putInt("delay_time", i2);
                next.setDelay(bundle);
            }
        }
    }

    public com.baidu.nplatform.comapi.basestruct.c a(int i, int i2) {
        AppBaseMap baseMap;
        String ScrPtToGeoPoint;
        com.baidu.baidunavis.maplayer.a aVar = this.f5580a;
        if (aVar != null && aVar.a() != null && (baseMap = this.f5580a.a().getBaseMap()) != null && (ScrPtToGeoPoint = baseMap.ScrPtToGeoPoint(i, i2)) != null) {
            try {
                JSONObject jSONObject = new JSONObject(ScrPtToGeoPoint);
                return new com.baidu.nplatform.comapi.basestruct.c(jSONObject.getDouble("geox"), jSONObject.getDouble("geoy"));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public com.baidu.nplatform.comapi.basestruct.c a(com.baidu.nplatform.comapi.basestruct.c cVar) {
        AppBaseMap baseMap;
        String GeoPtToScrPoint;
        com.baidu.nplatform.comapi.basestruct.c cVar2 = new com.baidu.nplatform.comapi.basestruct.c(OOXIXo.f3760XO, OOXIXo.f3760XO);
        com.baidu.baidunavis.maplayer.a aVar = this.f5580a;
        if (aVar != null && aVar.a() != null && (baseMap = this.f5580a.a().getBaseMap()) != null && (GeoPtToScrPoint = baseMap.GeoPtToScrPoint(cVar.c(), cVar.d())) != null) {
            try {
                JSONObject jSONObject = new JSONObject(GeoPtToScrPoint);
                cVar2.a(jSONObject.getInt("scrx"));
                cVar2.b(jSONObject.getInt("scry"));
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_RESULT;
                if (gVar.d()) {
                    gVar.e("BNMapLayerUtils", "toPixels,mcPoint:" + cVar + ",pixelPoint:" + cVar2);
                }
                return cVar2;
            } catch (JSONException e) {
                LogUtil.e("metersToEquatorPixels", "e = " + e);
            }
        }
        return cVar2;
    }

    public void a(boolean z, String str) {
        com.baidu.navisdk.util.worker.lite.a.a(this.f);
        TruckDynamicOverlay overlay = com.baidu.baidunavis.maplayer.a.h().b().getOverlay(TruckDynamicOverlay.class);
        if (overlay != null) {
            overlay.setFocus(0, z, str);
        }
    }

    public void a() {
        BMItemizedOverlay bMItemizedOverlay = this.d;
        if (bMItemizedOverlay == null || !bMItemizedOverlay.isShowing()) {
            return;
        }
        this.d.hide();
        this.d.removeAll();
    }

    public void a(@NonNull d dVar, i iVar) {
        ArrayList<OverlayItem> allItem;
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.MAP;
        if (gVar.d()) {
            gVar.e("BNMapLayerUtils", "showDestPanoramaBubbleOverlay --> item = " + dVar);
        }
        if (this.e == null) {
            this.e = new BMItemizedOverlay();
        }
        this.e.setOnTapListener(iVar);
        if (!this.f5580a.c().contains(this.e)) {
            this.f5580a.a(this.e);
        }
        if (h() && (allItem = this.e.getAllItem()) != null && allItem.size() == 1) {
            OverlayItem overlayItem = allItem.get(0);
            if (overlayItem instanceof d) {
                Object a2 = ((d) overlayItem).a("panorama_info");
                Object a3 = dVar.a("panorama_info");
                if (a2 != null && a2.equals(a3)) {
                    return;
                }
            }
        }
        this.e.removeAll();
        this.e.addItem(dVar);
        this.f5580a.b(this.e);
    }

    public void a(boolean z) {
        com.baidu.baidunavis.maplayer.a aVar = this.f5580a;
        if (aVar == null || aVar.a() == null) {
            return;
        }
        this.f5580a.a().showBaseIndoorMap(z);
    }

    public boolean a(String str, String str2) {
        com.baidu.baidunavis.maplayer.a aVar = this.f5580a;
        if (aVar != null && aVar.a() != null) {
            boolean switchBaseIndoorMapFloor = this.f5580a.a().switchBaseIndoorMapFloor(str, str2);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNMapLayerUtils", "switchIndoorMapFloor->result=" + switchBaseIndoorMapFloor);
            }
            return switchBaseIndoorMapFloor;
        }
        if (!LogUtil.LOGGABLE) {
            return false;
        }
        LogUtil.e("BNMapLayerUtils", "switchIndoorMapFloor->mMapView=" + this.f5580a + ", return!");
        return false;
    }
}
