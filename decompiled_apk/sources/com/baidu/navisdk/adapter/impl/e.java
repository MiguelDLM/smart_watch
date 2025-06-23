package com.baidu.navisdk.adapter.impl;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.entity.pb.Cars;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.navisdk.adapter.impl.base.BNaviAuthManager;
import com.baidu.navisdk.adapter.struct.BNPassCityInfo;
import com.baidu.navisdk.adapter.struct.BNRouteDetail;
import com.baidu.navisdk.adapter.struct.BNRoutePlanInfos;
import com.baidu.navisdk.adapter.struct.BNRoutePlanItem;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comjni.tools.JNITools;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes7.dex */
public class e {
    public static BNRoutePlanInfos a(BNRoutePlanInfos bNRoutePlanInfos) {
        byte[] m = BNRoutePlaner.getInstance().m(1);
        if (m == null || m.length == 0) {
            LogUtil.e("BNRoutePlanResolver", "parseCarsDataAfterSuccess --> pb is empty!!!");
        }
        return a(b(m), bNRoutePlanInfos);
    }

    private static Cars b(byte[] bArr) {
        LogUtil.out("BNRoutePlanResolver", "parsePbData --> start parse!!!");
        List<MessageMicro> a2 = a(bArr);
        if (a2 != null && a2.size() > 1 && a2.get(1) != null) {
            LogUtil.out("BNRoutePlanResolver", "parsePbData --> parse success!!!");
            return b(a2);
        }
        if (a2 != null && a2.size() > 0 && a2.get(0) != null) {
            LogUtil.out("BNRoutePlanResolver", "parsePbData --> parse abnormal!!!");
            return b(a2);
        }
        LogUtil.out("BNRoutePlanResolver", "parsePbData --> parse error!!!");
        return null;
    }

    private static void c(Cars cars, int i, BNRoutePlanInfos bNRoutePlanInfos) {
        List<Cars.Content.Steps> d;
        com.baidu.nplatform.comapi.basestruct.a a2;
        Bundle bundle = new Bundle();
        ArrayList<ArrayList<ArrayList<LatLng>>> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < i; i2++) {
            if (com.baidu.navisdk.pbprocess.a.g(cars, i2)) {
                LogUtil.out("BNRoutePlanResolver", "isDetailDataEmpty empty");
                d = com.baidu.navisdk.pbprocess.a.a(i2);
            } else {
                LogUtil.out("BNRoutePlanResolver", "isDetailData useful");
                d = com.baidu.navisdk.pbprocess.a.d(cars, i2);
            }
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            ArrayList<ArrayList<LatLng>> arrayList3 = new ArrayList<>();
            int size = d.size();
            for (int i3 = 0; i3 < size; i3++) {
                Cars.Content.Steps steps = d.get(i3);
                if (steps != null && steps.getSpathList() != null && (a2 = com.baidu.nplatform.comapi.basestruct.a.a(steps.getSpathList())) != null) {
                    ArrayList<LatLng> a3 = a(a2.a());
                    arrayList2.addAll(a3);
                    arrayList3.add(a3);
                }
            }
            bundle.putParcelableArrayList(String.valueOf(i2), arrayList2);
            arrayList.add(arrayList3);
        }
        if (bNRoutePlanInfos != null) {
            bNRoutePlanInfos.setRouteInfoLatLngLists(arrayList);
        }
    }

    private static void d(Cars cars, int i, BNRoutePlanInfos bNRoutePlanInfos) {
        ArrayList<BNRoutePlanItem> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < i; i2++) {
            BNRoutePlanItem bNRoutePlanItem = new BNRoutePlanItem();
            String e = com.baidu.navisdk.pbprocess.a.e(cars, i2);
            if (TextUtils.isEmpty(e)) {
                if (i2 == 0) {
                    e = "方案一";
                } else if (i2 == 1) {
                    e = "方案二";
                } else if (i2 == 2) {
                    e = "方案三";
                }
            }
            bNRoutePlanItem.setPusLabelName(e);
            if (BNRoutePlaner.getInstance().m() == 3 && !BNaviAuthManager.getInstance().hasEtcPermission()) {
                bNRoutePlanItem.setToll(0);
            } else {
                bNRoutePlanItem.setToll(com.baidu.navisdk.pbprocess.a.f(cars, i2));
            }
            bNRoutePlanItem.setLights(com.baidu.navisdk.pbprocess.a.c(cars, i2));
            bNRoutePlanItem.setPassTime(com.baidu.navisdk.pbprocess.a.b(cars, i2));
            bNRoutePlanItem.setLength(com.baidu.navisdk.pbprocess.a.a(cars, i2));
            arrayList.add(bNRoutePlanItem);
        }
        if (bNRoutePlanInfos != null) {
            bNRoutePlanInfos.setRouteTabInfos(arrayList);
        }
    }

    private static List<MessageMicro> a(byte[] bArr) {
        if (LogUtil.LOGGABLE) {
            LogUtil.out("BNRoutePlanResolver", "getPbListData --> start parse pb to car!!!");
        }
        if (bArr != null) {
            try {
                return com.baidu.navisdk.util.pbanaliysis.b.a(bArr);
            } catch (IOException e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.out("BNRoutePlanResolver", "getPbListData --> e = " + e.toString());
                }
            }
        }
        return null;
    }

    private static boolean a(Cars cars) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanResolver", "isShouldAddLongDistanceData --> cars = " + cars);
        }
        return cars != null;
    }

    private static Cars b(List<MessageMicro> list) {
        List<MessageMicro> a2;
        Cars a3 = a(list);
        if (a(a3) && (a2 = a(BNRoutePlaner.getInstance().m(2))) != null && !a2.isEmpty()) {
            a(a(a2), a3);
        }
        LogUtil.out("BNRoutePlanResolver", "setResultData --> cars: " + a3);
        return a3;
    }

    private static void a(Cars cars, Cars cars2) {
        int longDistanceInfoCount;
        if (cars == null || cars2 == null || cars.getContent() == null || cars2.getContent() == null || (longDistanceInfoCount = cars.getContent().getLongDistanceInfoCount()) <= 0) {
            return;
        }
        cars2.getContent().clearLongDistanceInfo();
        for (int i = 0; i < longDistanceInfoCount; i++) {
            Cars.Content.LongDistanceInfo longDistanceInfo = cars.getContent().getLongDistanceInfo(i);
            if (longDistanceInfo != null) {
                cars2.getContent().addLongDistanceInfo(longDistanceInfo);
            }
        }
    }

    @NonNull
    private static BNPassCityInfo a(@NonNull Cars.Content.LongDistanceInfo.ViaCityInfo viaCityInfo) {
        BNPassCityInfo bNPassCityInfo = new BNPassCityInfo();
        bNPassCityInfo.setCityName(viaCityInfo.hasCityName() ? viaCityInfo.getCityName() : "");
        bNPassCityInfo.setCityCode(viaCityInfo.hasCityId() ? viaCityInfo.getCityId() : -1);
        return bNPassCityInfo;
    }

    private static void b(Cars cars, int i, BNRoutePlanInfos bNRoutePlanInfos) {
        List<Cars.Content.Steps> d;
        Bundle bundle = new Bundle();
        ArrayList<ArrayList<BNRouteDetail>> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < i; i2++) {
            if (com.baidu.navisdk.pbprocess.a.g(cars, i2)) {
                LogUtil.out("BNRoutePlanResolver", "isDetailDataEmpty empty");
                d = com.baidu.navisdk.pbprocess.a.a(i2);
            } else {
                LogUtil.out("BNRoutePlanResolver", "isDetailData useful");
                d = com.baidu.navisdk.pbprocess.a.d(cars, i2);
            }
            int size = d.size();
            ArrayList<BNRouteDetail> arrayList2 = new ArrayList<>();
            for (int i3 = 0; i3 < size; i3++) {
                Cars.Content.Steps steps = d.get(i3);
                if (steps != null) {
                    BNRouteDetail bNRouteDetail = new BNRouteDetail();
                    bNRouteDetail.setIndex(i3 + 1);
                    a(steps, bNRouteDetail);
                    int turn = steps.getTurn();
                    int[] iArr = com.baidu.navisdk.module.routeresultbase.framework.utils.b.f7507a;
                    if (turn < iArr.length && steps.getTurn() > 0) {
                        bNRouteDetail.setIconId(iArr[steps.getTurn()]);
                    } else {
                        bNRouteDetail.setIconId(iArr[0]);
                    }
                    bNRouteDetail.setDescription(steps.getInstructions().replace("<b>", "").replace("</b>", ""));
                    arrayList2.add(bNRouteDetail);
                }
            }
            if (cars != null) {
                BNRouteDetail bNRouteDetail2 = new BNRouteDetail();
                bNRouteDetail2.setIndex(0);
                bNRouteDetail2.setIconId(R.drawable.nsdk_icon_route_result_start_point);
                bNRouteDetail2.setDescription(com.baidu.navisdk.pbprocess.a.b(cars));
                arrayList2.add(0, bNRouteDetail2);
                BNRouteDetail bNRouteDetail3 = new BNRouteDetail();
                bNRouteDetail3.setIndex(d.size() + 1);
                bNRouteDetail3.setIconId(R.drawable.nsdk_icon_route_result_end_point);
                bNRouteDetail3.setDescription(com.baidu.navisdk.pbprocess.a.a(cars));
                arrayList2.add(bNRouteDetail3);
            }
            bundle.putParcelableArrayList(String.valueOf(i2), arrayList2);
            arrayList.add(arrayList2);
        }
        if (bNRoutePlanInfos != null) {
            bNRoutePlanInfos.setRouteDetailLists(arrayList);
        }
    }

    private static Cars a(List<MessageMicro> list) {
        if (list != null && !list.isEmpty()) {
            for (MessageMicro messageMicro : list) {
                if (messageMicro instanceof Cars) {
                    return (Cars) messageMicro;
                }
            }
        }
        return null;
    }

    private static BNRoutePlanInfos a(Cars cars, BNRoutePlanInfos bNRoutePlanInfos) {
        int d = com.baidu.navisdk.pbprocess.a.d(cars);
        if (d <= 0 || bNRoutePlanInfos == null) {
            return null;
        }
        d(cars, d, bNRoutePlanInfos);
        a(cars, d, bNRoutePlanInfos);
        b(cars, d, bNRoutePlanInfos);
        c(cars, d, bNRoutePlanInfos);
        b(cars, bNRoutePlanInfos);
        return bNRoutePlanInfos;
    }

    private static void a(Cars cars, int i, BNRoutePlanInfos bNRoutePlanInfos) {
        if (cars == null || cars.getContent() == null || cars.getContent().getLongDistanceInfoCount() == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        ArrayList<ArrayList<BNPassCityInfo>> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList<BNPassCityInfo> arrayList2 = new ArrayList<>();
            List<Cars.Content.LongDistanceInfo.ViaCityInfo> arrayList3 = new ArrayList<>();
            if (i2 < cars.getContent().getLongDistanceInfoCount()) {
                arrayList3 = cars.getContent().getLongDistanceInfo(i2).getViaCityInfoList();
            }
            if (arrayList3 != null && arrayList3.size() > 0) {
                if (arrayList3.size() <= 2) {
                    for (Cars.Content.LongDistanceInfo.ViaCityInfo viaCityInfo : arrayList3) {
                        if (viaCityInfo != null) {
                            arrayList2.add(a(viaCityInfo));
                        }
                    }
                } else {
                    HashSet hashSet = new HashSet();
                    Cars.Content.LongDistanceInfo.ViaCityInfo viaCityInfo2 = arrayList3.get(0);
                    Cars.Content.LongDistanceInfo.ViaCityInfo viaCityInfo3 = arrayList3.get(arrayList3.size() - 1);
                    if (viaCityInfo2 != null) {
                        arrayList2.add(a(viaCityInfo2));
                        hashSet.add(viaCityInfo2.hasCityName() ? viaCityInfo2.getCityName() : "");
                    }
                    if (viaCityInfo3 != null) {
                        hashSet.add(viaCityInfo3.hasCityName() ? viaCityInfo3.getCityName() : "");
                    }
                    for (int i3 = 1; i3 < arrayList3.size() - 1; i3++) {
                        Cars.Content.LongDistanceInfo.ViaCityInfo viaCityInfo4 = arrayList3.get(i3);
                        if (viaCityInfo4 != null) {
                            String cityName = viaCityInfo4.hasCityName() ? viaCityInfo4.getCityName() : "";
                            if (!hashSet.contains(cityName)) {
                                hashSet.add(cityName);
                                arrayList2.add(a(viaCityInfo4));
                            }
                        }
                    }
                    if (viaCityInfo3 != null) {
                        arrayList2.add(a(viaCityInfo3));
                    }
                }
            }
            bundle.putParcelableArrayList(String.valueOf(i2), arrayList2);
            arrayList.add(arrayList2);
        }
        if (bNRoutePlanInfos != null) {
            bNRoutePlanInfos.setCityLists(arrayList);
        }
    }

    private static void b(Cars cars, BNRoutePlanInfos bNRoutePlanInfos) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanResolver", "parseRouteYBannerDataFromCars --> cars = " + cars);
        }
        if (cars == null || cars.getContent() == null || cars.getContent().getYellowTipsListCount() <= 0) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < cars.getContent().getYellowTipsListCount(); i++) {
            Cars.Content.YellowTipsList yellowTipsList = cars.getContent().getYellowTipsList(i);
            if (yellowTipsList != null && yellowTipsList.hasMrsl() && yellowTipsList.getMrsl() != null && yellowTipsList.getMrsl().length() > 0 && yellowTipsList.getYellowTipsInfoCount() > 0) {
                for (int i2 = 0; i2 < yellowTipsList.getYellowTipsInfoCount(); i2++) {
                    Cars.Content.YellowTipsList.YellowTipsInfo yellowTipsInfo = yellowTipsList.getYellowTipsInfo(i2);
                    if (yellowTipsInfo.getTipId() == 4) {
                        String title = yellowTipsInfo.getTitle();
                        if (yellowTipsInfo.getTitle() != null && title.contains(">")) {
                            int indexOf = title.indexOf(">");
                            arrayList.add(i + "," + title.substring(indexOf + 1, title.indexOf("<", indexOf)));
                        }
                    }
                }
            }
        }
        if (bNRoutePlanInfos != null) {
            bNRoutePlanInfos.setLimitInfo(arrayList);
        }
    }

    private static void a(Cars.Content.Steps steps, BNRouteDetail bNRouteDetail) {
        int steprcsCount = steps.getSteprcsCount();
        StringBuilder sb = new StringBuilder();
        sb.append("sPath=[");
        for (int i = 0; i < steps.getSpathCount(); i++) {
            sb.append(steps.getSpath(i) + ",");
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        if (steprcsCount > 0) {
            ArrayList arrayList = new ArrayList();
            int spath = steps.getSpath(5);
            int spath2 = steps.getSpath(6);
            int i2 = 7;
            for (int i3 = 0; i3 < steprcsCount; i3++) {
                Cars.Content.Steps.Steprcs steprcs = steps.getSteprcs(i3);
                int end = steprcs.getEnd();
                int status = steprcs.getStatus();
                ArrayList arrayList2 = new ArrayList();
                if (end == 0) {
                    arrayList2.add(a(spath, spath2));
                } else if (end > 0) {
                    while (i2 < (end * 2) + 7) {
                        arrayList2.add(a(steps.getSpath(i2) + spath, steps.getSpath(i2 + 1) + spath2));
                        i2 += 2;
                    }
                }
                arrayList.add(new BNRouteDetail.RoadCondition(arrayList2, status));
            }
            bNRouteDetail.setRoadConditions(arrayList);
        }
    }

    private static ArrayList<LatLng> a(ArrayList<com.baidu.nplatform.comapi.basestruct.c> arrayList) {
        ArrayList<LatLng> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            LatLng a2 = com.baidu.navisdk.a.a((float) arrayList.get(i).a(), (float) arrayList.get(i).b());
            if (SDKInitializer.getCoordType().equals(CoordType.BD09LL)) {
                arrayList2.add(a2);
            } else {
                Bundle Bd09llToGcj02 = JNITools.Bd09llToGcj02(a2.longitude, a2.latitude);
                arrayList2.add(new LatLng(Bd09llToGcj02.getDouble("LLy"), Bd09llToGcj02.getDouble("LLx")));
            }
        }
        return arrayList2;
    }

    private static LatLng a(int i, int i2) {
        LatLng a2 = com.baidu.navisdk.a.a(i, i2);
        if (!SDKInitializer.getCoordType().equals(CoordType.GCJ02)) {
            return a2;
        }
        Bundle Bd09llToGcj02 = JNITools.Bd09llToGcj02(a2.longitude, a2.latitude);
        return new LatLng(Bd09llToGcj02.getDouble("LLy"), Bd09llToGcj02.getDouble("LLx"));
    }
}
