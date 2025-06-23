package com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance;

import android.content.Context;
import com.baidu.baidunavis.maplayer.g;
import com.baidu.baidunavis.maplayer.i;
import com.baidu.navisdk.j;
import com.baidu.navisdk.model.datastruct.h;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class a {

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7526a = new a();
    }

    public static a c() {
        return b.f7526a;
    }

    public void a(Context context, ArrayList<h> arrayList, com.baidu.nplatform.comapi.basestruct.c cVar, com.baidu.navisdk.module.routeresultbase.logic.longdistance.d dVar, i iVar, boolean z) {
        float c;
        float d;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNMeteorLayerController", "showMeteorLayer --> point = " + cVar);
            LogUtil.printList("BNMeteorLayerController", "showMeteorLayer", "meteorList", arrayList);
        }
        int i = 0;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (cVar != null) {
                dVar.n = cVar.d() + "," + cVar.c();
            }
            ArrayList<g> arrayList2 = new ArrayList<>();
            boolean a2 = com.baidu.navisdk.comapi.commontool.a.getInstance().a();
            g gVar = null;
            h hVar = null;
            int i2 = 0;
            while (true) {
                boolean z2 = true;
                if (i2 >= arrayList.size()) {
                    break;
                }
                h hVar2 = arrayList.get(i2);
                if (e.b(hVar2)) {
                    if (hVar2.c.d.a(cVar)) {
                        g a3 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(1, cVar);
                        if (a3 != null) {
                            arrayList2.add(i, a3);
                        }
                    } else {
                        z2 = false;
                    }
                    MeteorBubbleView meteorBubbleView = new MeteorBubbleView(context, z);
                    meteorBubbleView.a(hVar2, z2, i2, a2);
                    if (i2 % 2 == 0) {
                        c = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(4, z2);
                        d = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.b(4, z2);
                    } else {
                        c = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.c(4, z2);
                        d = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.d(4, z2);
                    }
                    g a4 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(meteorBubbleView, hVar2.c.d, z2, c, d);
                    if (a4 != null) {
                        if (z2) {
                            gVar = a4;
                            hVar = hVar2;
                        } else {
                            a4.a(false);
                            a4.a(hVar2);
                            arrayList2.add(a4);
                        }
                    }
                }
                i2++;
                i = 0;
            }
            if (gVar != null) {
                gVar.a(true);
                gVar.a(hVar);
                arrayList2.add(gVar);
            }
            com.baidu.baidunavis.maplayer.e.k().a(arrayList2, iVar, false);
            return;
        }
        com.baidu.baidunavis.maplayer.e.k().a(new ArrayList<>(), iVar, false);
    }

    public boolean b() {
        if (j.d()) {
            return com.baidu.baidunavis.maplayer.e.k().i();
        }
        return false;
    }

    private a() {
    }

    public void a() {
        com.baidu.baidunavis.maplayer.e.k().f();
    }

    public com.baidu.baidunavis.maplayer.d a(int i) {
        return com.baidu.baidunavis.maplayer.e.k().a(i);
    }
}
