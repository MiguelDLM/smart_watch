package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements Overlay.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaiduMap f5897a;

    public e(BaiduMap baiduMap) {
        this.f5897a = baiduMap;
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public LatLngBounds a(Overlay overlay) {
        com.baidu.mapsdkplatform.comapi.map.c cVar;
        com.baidu.mapsdkplatform.comapi.map.c cVar2;
        cVar = this.f5897a.j;
        if (cVar != null && overlay != null) {
            Bundle bundle = new Bundle();
            overlay.a(bundle);
            cVar2 = this.f5897a.j;
            return cVar2.c(bundle);
        }
        return null;
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public void b(Overlay overlay) {
        boolean z;
        List list;
        List list2;
        List list3;
        com.baidu.mapsdkplatform.comapi.map.c cVar;
        com.baidu.mapsdkplatform.comapi.map.c cVar2;
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        List list4;
        List list5;
        List list6;
        com.baidu.mapsdkplatform.comapi.map.c cVar3;
        com.baidu.mapsdkplatform.comapi.map.c cVar4;
        List list7;
        com.baidu.mapsdkplatform.comapi.map.c cVar5;
        com.baidu.mapsdkplatform.comapi.map.c cVar6;
        z = this.f5897a.ah;
        if (z) {
            return;
        }
        if (overlay != null) {
            list6 = this.f5897a.l;
            if (list6.contains(overlay)) {
                if (OverlayUtil.isOverlayUpgrade()) {
                    if ((overlay instanceof Arc) || (overlay instanceof Circle) || (overlay instanceof Polygon) || (overlay instanceof Polyline)) {
                        this.f5897a.b(overlay);
                    } else {
                        Bundle a2 = overlay.a();
                        cVar5 = this.f5897a.j;
                        if (cVar5 != null) {
                            cVar6 = this.f5897a.j;
                            cVar6.g(a2);
                        }
                    }
                } else {
                    Bundle a3 = overlay.a();
                    cVar3 = this.f5897a.j;
                    if (cVar3 != null) {
                        cVar4 = this.f5897a.j;
                        cVar4.g(a3);
                    }
                }
                list7 = this.f5897a.l;
                list7.remove(overlay);
            }
        }
        if (overlay != null) {
            list4 = this.f5897a.n;
            if (list4.contains(overlay)) {
                list5 = this.f5897a.n;
                list5.remove(overlay);
            }
        }
        if (overlay != null) {
            copyOnWriteArrayList = this.f5897a.M;
            if (copyOnWriteArrayList.contains(overlay)) {
                copyOnWriteArrayList2 = this.f5897a.M;
                copyOnWriteArrayList2.remove(overlay);
            }
        }
        if (overlay != null) {
            list = this.f5897a.m;
            if (list.contains(overlay)) {
                Marker marker = (Marker) overlay;
                if (marker.v != null) {
                    list2 = this.f5897a.m;
                    list2.remove(marker);
                    list3 = this.f5897a.m;
                    if (list3.size() == 0) {
                        cVar = this.f5897a.j;
                        if (cVar != null) {
                            cVar2 = this.f5897a.j;
                            cVar2.d(false);
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public void c(Overlay overlay) {
        boolean z;
        List list;
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        List list2;
        CopyOnWriteArrayList copyOnWriteArrayList3;
        List list3;
        List list4;
        com.baidu.mapsdkplatform.comapi.map.c cVar;
        boolean z2;
        com.baidu.mapsdkplatform.comapi.map.c cVar2;
        com.baidu.mapsdkplatform.comapi.map.c cVar3;
        List list5;
        List list6;
        com.baidu.mapsdkplatform.comapi.map.c cVar4;
        com.baidu.mapsdkplatform.comapi.map.c cVar5;
        List list7;
        com.baidu.mapsdkplatform.comapi.map.c cVar6;
        boolean z3;
        com.baidu.mapsdkplatform.comapi.map.c cVar7;
        List list8;
        z = this.f5897a.ah;
        if (z) {
            return;
        }
        if (overlay != null) {
            list4 = this.f5897a.l;
            if (list4.contains(overlay)) {
                boolean z4 = false;
                if (overlay instanceof Marker) {
                    Marker marker = (Marker) overlay;
                    if (marker.b != null) {
                        ArrayList<BitmapDescriptor> arrayList = marker.v;
                        if (arrayList != null && arrayList.size() > 1) {
                            Bundle bundle = new Bundle();
                            cVar6 = this.f5897a.j;
                            if (cVar6 != null) {
                                z3 = this.f5897a.ah;
                                if (!z3) {
                                    marker.remove();
                                    marker.v.clear();
                                    cVar7 = this.f5897a.j;
                                    cVar7.d(overlay.a(bundle));
                                    list8 = this.f5897a.l;
                                    list8.add(overlay);
                                    z4 = true;
                                }
                            }
                        }
                    } else {
                        ArrayList<BitmapDescriptor> arrayList2 = marker.v;
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            list5 = this.f5897a.m;
                            if (list5.contains(marker)) {
                                list7 = this.f5897a.m;
                                list7.remove(marker);
                            }
                            list6 = this.f5897a.m;
                            list6.add(marker);
                            cVar4 = this.f5897a.j;
                            if (cVar4 != null) {
                                cVar5 = this.f5897a.j;
                                cVar5.d(true);
                            }
                        }
                    }
                }
                cVar = this.f5897a.j;
                if (cVar != null && !z4) {
                    z2 = this.f5897a.ah;
                    if (!z2) {
                        if (OverlayUtil.isOverlayUpgrade()) {
                            if ((overlay instanceof Arc) || (overlay instanceof Circle) || (overlay instanceof Polygon) || (overlay instanceof Polyline)) {
                                this.f5897a.c(overlay);
                            } else {
                                Bundle bundle2 = new Bundle();
                                cVar3 = this.f5897a.j;
                                cVar3.f(overlay.a(bundle2));
                            }
                        } else {
                            Bundle bundle3 = new Bundle();
                            cVar2 = this.f5897a.j;
                            cVar2.f(overlay.a(bundle3));
                        }
                    }
                }
            }
        }
        list = this.f5897a.n;
        if (list.contains(overlay)) {
            list3 = this.f5897a.n;
            list3.remove(overlay);
        }
        copyOnWriteArrayList = this.f5897a.M;
        if (copyOnWriteArrayList.contains(overlay)) {
            copyOnWriteArrayList3 = this.f5897a.M;
            copyOnWriteArrayList3.remove(overlay);
        }
        if (overlay instanceof Marker) {
            list2 = this.f5897a.n;
            list2.add((Marker) overlay);
        }
        if (overlay instanceof Building) {
            copyOnWriteArrayList2 = this.f5897a.M;
            copyOnWriteArrayList2.add((Building) overlay);
        }
    }

    @Override // com.baidu.mapapi.map.Overlay.a
    public boolean d(Overlay overlay) {
        List list;
        List list2;
        list = this.f5897a.l;
        if (list != null) {
            list2 = this.f5897a.l;
            if (!list2.contains(overlay)) {
                return true;
            }
        }
        return false;
    }
}
