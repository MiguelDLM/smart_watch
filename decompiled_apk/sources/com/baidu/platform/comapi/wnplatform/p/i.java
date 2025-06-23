package com.baidu.platform.comapi.wnplatform.p;

import android.text.TextUtils;
import com.baidu.ar.marker.model.SegmentTypeCons;
import com.baidu.entity.pb.WalkPlan;
import com.baidu.platform.comapi.basestruct.Point;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9957a = "i";
    private static ArrayList<a> b = null;
    private static boolean c = false;

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Point f9958a;
        public String b;
        public int c;
        public String d;
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f9959a;
        public String b;
        public String c;
        public ArrayList<Point> d;
    }

    public static String a(WalkPlan walkPlan) {
        if (walkPlan != null && walkPlan.hasOption() && walkPlan.getOption().getEndCount() > 0 && walkPlan.getOption().getEnd(walkPlan.getOption().getEndCount() - 1) != null) {
            return walkPlan.getOption().getEnd(walkPlan.getOption().getEndCount() - 1).getFloor();
        }
        return "";
    }

    private static void b(WalkPlan walkPlan, int i) {
        if (walkPlan != null && i < walkPlan.getRoutesCount()) {
            WalkPlan.Routes routes = walkPlan.getRoutes(i);
            b = new ArrayList<>();
            for (int i2 = 0; i2 < routes.getLegsCount(); i2++) {
                WalkPlan.Routes.Legs legs = routes.getLegs(i2);
                for (int i3 = 0; i3 < legs.getStepsCount(); i3++) {
                    WalkPlan.Routes.Legs.Steps steps = legs.getSteps(i3);
                    ArrayList<Point> arrayList = com.baidu.platform.comapi.basestruct.a.a(steps.getSpathList()).d.get(0);
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        a aVar = new a();
                        aVar.f9958a = arrayList.get(i4);
                        aVar.b = a(i2, i3, i4);
                        aVar.d = steps.getName();
                        b.add(aVar);
                    }
                }
            }
            int size = b.size();
            if (size > 0) {
                if (TextUtils.isEmpty(a(walkPlan))) {
                    b.get(size - 1).c = 101;
                } else {
                    b.get(size - 1).c = 102;
                }
            }
        }
    }

    public static String a(int i, int i2, int i3) {
        return i + HelpFormatter.DEFAULT_OPT_PREFIX + i2 + HelpFormatter.DEFAULT_OPT_PREFIX + i3;
    }

    public static ArrayList<b> a(WalkPlan walkPlan, int i) {
        String str;
        WalkPlan.Routes routes;
        ArrayList<b> arrayList = new ArrayList<>();
        b(walkPlan, i);
        c = false;
        if (walkPlan != null && i < walkPlan.getRoutesCount()) {
            List<WalkPlan.ARGuide> arGuideList = walkPlan.getArGuideList();
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < arGuideList.size(); i3++) {
                WalkPlan.ARGuide aRGuide = arGuideList.get(i3);
                int legIdx = aRGuide.getLegIdx();
                if (i == aRGuide.getRouteIdx()) {
                    List<WalkPlan.ARGuide.GuideV1.BaseInfo> baseInfoList = aRGuide.getGuideV1().getBaseInfoList();
                    for (int i4 = 0; i4 < baseInfoList.size(); i4++) {
                        WalkPlan.ARGuide.GuideV1.BaseInfo baseInfo = baseInfoList.get(i4);
                        int stepIdx = baseInfo.getStepIdx();
                        int spIdx = baseInfo.getSpIdx();
                        int modelType = baseInfo.getModelType();
                        if (modelType == 14) {
                            if (i < walkPlan.getRoutesCount() && (routes = walkPlan.getRoutes(i)) != null && legIdx < routes.getLegsCount()) {
                                WalkPlan.Routes.Legs legs = routes.getLegs(legIdx);
                                for (int i5 = i2; i5 <= stepIdx; i5++) {
                                    if (i5 < legs.getStepsCount() && legs.getSteps(i5).getDistance() > 100) {
                                        c = true;
                                    }
                                }
                            }
                            z = false;
                        }
                        if (z) {
                            modelType = 0;
                        }
                        if (modelType == 4) {
                            i2 = stepIdx;
                            z = true;
                        }
                        if (modelType > 0 && modelType <= 14 && stepIdx >= 0 && spIdx >= 0) {
                            a(a(legIdx, stepIdx, spIdx), modelType);
                        }
                    }
                }
            }
            int i6 = 0;
            for (int i7 = 0; i7 < b.size(); i7++) {
                a aVar = b.get(i7);
                if (aVar.c > 0) {
                    b bVar = new b();
                    a(bVar, aVar.c);
                    if (SegmentTypeCons.SEGMENT_KAKE_TURN.equals(bVar.b)) {
                        int i8 = i7 + 1;
                        if (i8 < b.size()) {
                            str = b.get(i8).d;
                        } else {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            bVar.f9959a = str;
                        } else {
                            bVar.f9959a = "无名路";
                        }
                    }
                    bVar.d = a(b.subList(i6, i7 + 1));
                    arrayList.add(bVar);
                    i6 = i7;
                }
            }
        }
        return arrayList;
    }

    private static ArrayList<Point> a(List<a> list) {
        ArrayList<Point> arrayList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i).f9958a);
        }
        return arrayList;
    }

    private static void a(b bVar, int i) {
        if (i == 1 || i == 2 || i == 7) {
            bVar.b = SegmentTypeCons.SEGMENT_KAKE_TURN;
            return;
        }
        if (i == 3) {
            bVar.b = SegmentTypeCons.SEGMENT_ENTER_FOOT_BRIDGE;
            return;
        }
        if (i == 4) {
            bVar.b = SegmentTypeCons.SEGMENT_ENTER_TUNNEL;
            return;
        }
        if (i == 14) {
            bVar.b = SegmentTypeCons.SEGMENT_OUT_TUNNEL;
            return;
        }
        if (i != 5 && i != 6 && i != 8 && i != 9 && i != 10 && i != 11 && i != 12 && i != 13) {
            if (i == 101) {
                bVar.b = SegmentTypeCons.SEGMENT_TERMINAL;
                return;
            } else {
                if (i == 102) {
                    bVar.b = SegmentTypeCons.SEGMENT_TERMINAL_GUIDE;
                    return;
                }
                return;
            }
        }
        bVar.b = SegmentTypeCons.SEGMENT_GO_CROSS;
        if (i == 8) {
            bVar.c = SegmentTypeCons.SEGMENT_DIRECTIONTYPE_TURN_LEFT;
            return;
        }
        if (i == 9) {
            bVar.c = SegmentTypeCons.SEGMENT_DIRECTIONTYPE_TURN_RIGHT;
            return;
        }
        if (i == 10) {
            bVar.c = SegmentTypeCons.SEGMENT_DIRECTIONTYPE_TURN_LEFT_FRONT;
            return;
        }
        if (i == 11) {
            bVar.c = SegmentTypeCons.SEGMENT_DIRECTIONTYPE_TURN_LEFT_BACK;
            return;
        }
        if (i == 12) {
            bVar.c = SegmentTypeCons.SEGMENT_DIRECTIONTYPE_TURN_RIGHT_FRONT;
        } else if (i == 13) {
            bVar.c = SegmentTypeCons.SEGMENT_DIRECTIONTYPE_TURN_RIGHT_BACK;
        } else {
            bVar.c = "";
        }
    }

    private static void a(String str, int i) {
        for (int i2 = 0; i2 < b.size(); i2++) {
            if (str.equals(b.get(i2).b)) {
                b.get(i2).c = i;
                return;
            }
        }
    }
}
