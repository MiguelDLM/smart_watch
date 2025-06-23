package com.baidu.platform.comapi.wnplatform.p;

import android.text.TextUtils;
import com.baidu.entity.pb.IndoorNavi;
import com.baidu.entity.pb.WalkPlan;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f9953a = {"m", "km", "米", "公里"};
    public static final String[] b = {"m", IAdInterListener.AdReqParam.HEIGHT, "分钟", "小时"};
    public static final String[] c = {"m", IAdInterListener.AdReqParam.HEIGHT, "d", "分钟", "小时", "天"};

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static int f9954a = 1;
        public static int b = 2;
    }

    /* loaded from: classes8.dex */
    public enum b {
        EN(0),
        ZH(1);

        private int c;

        b(int i) {
            this.c = i;
        }

        public int a() {
            return this.c;
        }
    }

    public static void a(int i, b bVar, StringBuffer stringBuffer) {
        String str;
        int a2 = bVar.a();
        if (a2 != 0) {
            a2++;
        }
        if (i < 1000) {
            if (stringBuffer != null) {
                stringBuffer.append(String.format("%d%s", Integer.valueOf(i), f9953a[a2]));
                return;
            }
            return;
        }
        if (i % 1000 == 0) {
            str = "%.0f%s";
        } else {
            str = "%.1f%s";
        }
        if (stringBuffer != null) {
            int i2 = i / 1000;
            if (i2 >= 100) {
                stringBuffer.append(String.format("%d%s", Integer.valueOf(i2), f9953a[a2 + 1]));
            } else {
                stringBuffer.append(String.format(str, Double.valueOf(i / 1000.0d), f9953a[a2 + 1]));
            }
        }
    }

    public static int b() {
        if (!a()) {
            return 0;
        }
        WalkPlan V = com.baidu.platform.comapi.walknavi.b.a().V();
        int a2 = a(V, com.baidu.platform.comapi.walknavi.b.a().b());
        if (V != null && V.hasOption() && V.getOption().hasStart()) {
            String floor = V.getOption().getStart().getFloor();
            String building = V.getOption().getStart().getBuilding();
            if (!TextUtils.isEmpty(floor) && !TextUtils.isEmpty(building) && (a2 == 2 || a2 == 3)) {
                return 1;
            }
        }
        return 2;
    }

    public static List<WalkPlan.Routes.Legs.ConnectedPois> c(WalkPlan walkPlan) {
        int b2 = com.baidu.platform.comapi.walknavi.b.a().b();
        ArrayList arrayList = new ArrayList();
        if (walkPlan.getRoutesCount() > 0 && b2 < walkPlan.getRoutesCount()) {
            Iterator<WalkPlan.Routes.Legs> it = walkPlan.getRoutes(b2).getLegsList().iterator();
            while (it.hasNext()) {
                List<WalkPlan.Routes.Legs.ConnectedPois> connectedPoisList = it.next().getConnectedPoisList();
                if (connectedPoisList != null) {
                    Iterator<WalkPlan.Routes.Legs.ConnectedPois> it2 = connectedPoisList.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next());
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean d() {
        WalkPlan V = com.baidu.platform.comapi.walknavi.b.a().V();
        if (V != null && V.getRoutesCount() == 0 && V.getIndoorNavisCount() != 0) {
            return true;
        }
        return false;
    }

    public static ArrayList<LatLng> b(WalkPlan walkPlan, int i) {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        LatLng T = com.baidu.platform.comapi.walknavi.b.a().T();
        if (T != null) {
            arrayList.add(T);
        }
        if (walkPlan.getRoutes(i) != null) {
            int legsCount = walkPlan.getRoutes(i).getLegsCount();
            for (int i2 = 0; i2 < legsCount; i2++) {
                if (walkPlan.getRoutes(i).getLegsCount() > i2 && walkPlan.getRoutes(i).getLegs(i2) != null) {
                    int stepsCount = walkPlan.getRoutes(i).getLegs(i2).getStepsCount();
                    for (int i3 = 0; i3 < stepsCount; i3++) {
                        if (walkPlan.getRoutes(i).getLegs(i2).getSteps(i3) != null && walkPlan.getRoutes(i).getLegs(i2).getSteps(i3).getSstartLocationList() != null) {
                            double doubleValue = walkPlan.getRoutes(i).getLegs(i2).getSteps(i3).getSstartLocationList().get(0).doubleValue();
                            arrayList.add(CoordTrans.gcjToBaidu(new LatLng(walkPlan.getRoutes(i).getLegs(i2).getSteps(i3).getSstartLocationList().get(1).doubleValue() / 100000.0d, doubleValue / 100000.0d)));
                        }
                    }
                }
            }
        }
        LatLng U = com.baidu.platform.comapi.walknavi.b.a().U();
        if (U != null) {
            arrayList.add(U);
        }
        return arrayList;
    }

    public static boolean c() {
        WalkPlan V = com.baidu.platform.comapi.walknavi.b.a().V();
        if (V == null || V.getIndoorNavisCount() == 0) {
            return false;
        }
        List<IndoorNavi> indoorNavisList = V.getIndoorNavisList();
        int i = 0;
        for (int i2 = 0; i2 < indoorNavisList.size(); i2++) {
            IndoorNavi indoorNavi = indoorNavisList.get(i2);
            if (indoorNavi.getRoutesCount() != 0 && indoorNavi.getRoutes(0).getLocLevel() == 1) {
                i++;
            }
        }
        return i == indoorNavisList.size();
    }

    public static void a(int i, int i2, StringBuffer stringBuffer) {
        if (stringBuffer != null) {
            if (i < 60) {
                stringBuffer.append("少于1分钟");
                return;
            }
            int i3 = (i / 3600) % 24;
            int i4 = (i / 60) % 60;
            if (i < 3600) {
                stringBuffer.append(i4);
                stringBuffer.append(c[i2 + 1]);
                return;
            }
            if (i < 86400) {
                stringBuffer.append(i3);
                stringBuffer.append(c[i2 + 2]);
                if (i4 > 0) {
                    stringBuffer.append(i4);
                    stringBuffer.append("分");
                    return;
                }
                return;
            }
            stringBuffer.append(i / 86400);
            String[] strArr = c;
            stringBuffer.append(strArr[i2 + 3]);
            if (i3 > 0) {
                stringBuffer.append(i3);
                stringBuffer.append(strArr[i2 + 2]);
            }
        }
    }

    public static String a(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        a(i, i2, stringBuffer);
        return stringBuffer.toString();
    }

    public static boolean a() {
        WalkPlan V = com.baidu.platform.comapi.walknavi.b.a().V();
        return (V == null || V.getIndoorNavisCount() == 0) ? false : true;
    }

    public static int a(WalkPlan walkPlan, int i) {
        boolean z;
        boolean z2;
        if (d()) {
            if (walkPlan.getIndoorNavisCount() != 0) {
                return 3;
            }
        } else if (walkPlan != null && walkPlan.getRoutesCount() > 0 && i < walkPlan.getRoutesCount()) {
            z = false;
            z2 = false;
            for (int i2 = 0; i2 < walkPlan.getRoutes(i).getLegsCount(); i2++) {
                WalkPlan.Routes.Legs.LegLinked legLinked = walkPlan.getRoutes(i).getLegs(i2).getLegLinked();
                if (legLinked != null && legLinked.hasPrev()) {
                    z = true;
                }
                if (legLinked != null && legLinked.hasNext()) {
                    z2 = true;
                }
            }
            if (z || z2) {
                return (z && z2) ? 1 : 0;
            }
            return 2;
        }
        z = false;
        z2 = false;
        if (z) {
        }
        if (z) {
        }
    }

    public static int b(WalkPlan walkPlan) {
        List<WalkPlan.Routes.Legs.ConnectedPois> c2;
        if (walkPlan == null || (c2 = c(walkPlan)) == null || c2.size() == 0) {
            return 0;
        }
        return c2.get(0).getType();
    }

    public static String a(WalkPlan walkPlan) {
        String str = new String("");
        return (walkPlan == null || !walkPlan.hasOption() || walkPlan.getOption().getEndCount() <= 0 || walkPlan.getOption().getEnd(walkPlan.getOption().getEndCount() + (-1)) == null || !walkPlan.getOption().getEnd(walkPlan.getOption().getEndCount() + (-1)).hasFloor()) ? str : walkPlan.getOption().getEnd(walkPlan.getOption().getEndCount() - 1).getFloor();
    }

    public static int a(boolean z) {
        WalkPlan b2 = com.baidu.platform.comapi.walknavi.b.a().Z().a().b();
        if (b2 == null) {
            return 0;
        }
        if (z) {
            if (d()) {
                return 3;
            }
            if (b(b2) == a.f9954a) {
                return 2;
            }
        } else if (b(b2) == a.b) {
            return 1;
        }
        return 0;
    }
}
