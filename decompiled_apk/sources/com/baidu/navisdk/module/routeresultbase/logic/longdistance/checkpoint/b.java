package com.baidu.navisdk.module.routeresultbase.logic.longdistance.checkpoint;

import XIXIX.OOXIXo;
import android.content.Context;
import android.util.SparseArray;
import com.baidu.baidunavis.maplayer.e;
import com.baidu.baidunavis.maplayer.g;
import com.baidu.navisdk.module.routeresultbase.logic.longdistance.d;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.c;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class b extends com.baidu.navisdk.module.routeresultbase.logic.longdistance.b {
    public SparseArray<ArrayList<a>> b;
    public SparseArray<ArrayList<a>> c;

    public b(d dVar) {
        super(dVar);
        this.b = new SparseArray<>();
        this.c = new SparseArray<>();
    }

    public a a(c cVar) {
        SparseArray<ArrayList<a>> sparseArray;
        ArrayList<a> arrayList;
        if (cVar != null && (sparseArray = this.c) != null && this.f7511a.q < sparseArray.size() && (arrayList = this.c.get(this.f7511a.q)) != null && arrayList.size() > 0) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && cVar.equals(next.d)) {
                    return next;
                }
            }
        }
        return null;
    }

    public boolean b() {
        ArrayList<a> arrayList;
        SparseArray<ArrayList<a>> sparseArray = this.b;
        if (sparseArray != null) {
            int size = sparseArray.size();
            int i = this.f7511a.q;
            if (size > i && (arrayList = this.b.get(i)) != null && arrayList.size() > 0) {
                return true;
            }
        }
        return false;
    }

    public void a(int i) {
        String str;
        ArrayList<a> arrayList;
        int i2;
        double d = 1.3d;
        int rint = (int) Math.rint(this.f7511a.o / 1.3d);
        ArrayList<a> arrayList2 = new ArrayList<>();
        ArrayList<a> arrayList3 = this.b.get(i);
        String str2 = "updatePassCheckpointByLevel --> routeIndex = ";
        int i3 = 0;
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "updatePassCheckpointByLevel --> routeIndex = " + i + ", totalList = " + arrayList3);
            StringBuilder sb = new StringBuilder();
            sb.append("updatePassCheckpointByLevel count is ");
            sb.append(rint);
            sb.append(",");
            sb.append(arrayList3 == null ? 0 : arrayList3.size());
            LogUtil.e("LongDistanceNaviModel", sb.toString());
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            double d2 = e.k().d() * 1.3d;
            int i4 = -1;
            int i5 = 0;
            while (true) {
                if (i3 >= arrayList3.size()) {
                    str = str2;
                    break;
                }
                a aVar = arrayList3.get(i3);
                if (aVar == null) {
                    arrayList = arrayList3;
                    str = str2;
                    i2 = i3;
                } else {
                    arrayList = arrayList3;
                    str = str2;
                    i2 = i3;
                    int a2 = a(aVar.b, d);
                    LogUtil.e("LongDistanceNaviModel", "updatePassCheckpointByLevel tempSegment is " + a2 + "," + i4);
                    if (a2 != i4) {
                        double d3 = e.k().d() * d;
                        if (d3 == OOXIXo.f3760XO) {
                            i4 = a2;
                        } else {
                            if (aVar.b - (d3 * ((int) (r4 / d3))) < d2) {
                                i5++;
                                a aVar2 = new a();
                                aVar2.a(aVar);
                                arrayList2.add(aVar2);
                            }
                            if (i5 >= rint) {
                                break;
                            } else {
                                i4 = a2;
                            }
                        }
                    } else {
                        continue;
                    }
                }
                i3 = i2 + 1;
                arrayList3 = arrayList;
                str2 = str;
                d = 1.3d;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("LongDistanceNaviModel", str + i + ", showList = " + arrayList2);
            }
            this.c.append(i, arrayList2);
            return;
        }
        this.c.append(i, arrayList2);
    }

    public ArrayList<a> a() {
        if (this.f7511a.q < this.c.size()) {
            return this.c.get(this.f7511a.q);
        }
        return null;
    }

    public void a(Context context, c cVar) {
        g a2;
        ArrayList<a> a3 = a();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("LongDistanceNaviModel", "handlePassServiceShow --> weatherList = " + a3 + ", point = " + cVar);
        }
        if (a3 != null && a3.size() > 0) {
            ArrayList<g> arrayList = new ArrayList<>();
            for (int i = 0; i < a3.size(); i++) {
                a aVar = a3.get(i);
                if (aVar != null && (a2 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(5, aVar.d)) != null) {
                    arrayList.add(a2);
                }
            }
            a a4 = a(cVar);
            com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.a aVar2 = new com.baidu.navisdk.module.routeresultbase.view.support.module.longdistance.view.a(context);
            if (a4 != null) {
                aVar2.a(a4);
                this.f7511a.a(a4.d);
                g a5 = com.baidu.navisdk.module.routeresultbase.logic.longdistance.c.a(aVar2, a4.d, false, 0.52f, 1.6f);
                if (a5 != null) {
                    arrayList.add(a5);
                }
            }
            a(arrayList);
            return;
        }
        e.k().f();
    }
}
