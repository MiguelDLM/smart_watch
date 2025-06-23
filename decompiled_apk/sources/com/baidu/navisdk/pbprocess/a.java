package com.baidu.navisdk.pbprocess;

import androidx.annotation.Nullable;
import com.baidu.entity.pb.Cars;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.model.modelfactory.c;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.platform.comjni.tools.ProtobufUtils;
import com.google.protobuf.micro.MessageMicro;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7632a = "a";

    @Nullable
    public static Cars a() {
        f fVar = (f) c.a().a("RoutePlanModel");
        if (fVar != null) {
            return fVar.d();
        }
        return null;
    }

    public static int b(Cars cars, int i) {
        int i2 = 0;
        if (i >= 0 && cars != null && cars.hasContent() && cars.getContent().getRoutesCount() > 0 && cars.getContent().getRoutesCount() > i && cars.getContent().getRoutes(i) != null) {
            int i3 = 0;
            for (Cars.Content.Routes.Legs legs : cars.getContent().getRoutes(i).getLegsList()) {
                i2 += legs.getDuration();
                LogUtil.e(f7632a, "getCarDuration --> legs[" + i3 + "].getDuration() = " + legs.getDuration());
                i3++;
            }
            LogUtil.e(f7632a, "getCarDuration --> duration = " + i2);
        }
        return i2;
    }

    public static int c() {
        return d(a());
    }

    public static int d(Cars cars) {
        if (cars == null || !cars.hasContent()) {
            return 0;
        }
        return cars.getContent().getRoutesCount();
    }

    public static String e(Cars cars, int i) {
        String routeLabelName;
        if (cars == null || cars.getContent() == null || cars.getContent().getRoutesList().isEmpty() || cars.getContent().getRoutes(i) == null || (routeLabelName = cars.getContent().getRoutes(i).getRouteLabelName()) == null) {
            return "";
        }
        return routeLabelName;
    }

    public static int f(Cars cars, int i) {
        int toll;
        if (cars == null || cars.getContent() == null || cars.getContent().getRoutesList().isEmpty() || cars.getContent().getRoutes(i) == null || (toll = cars.getContent().getRoutes(i).getToll()) <= 0) {
            return 0;
        }
        return toll;
    }

    public static boolean g(Cars cars, int i) {
        if (cars != null && cars.getContent() != null && i < cars.getContent().getRoutesCount()) {
            return false;
        }
        return true;
    }

    public static int c(Cars cars, int i) {
        int lightNum;
        if (cars == null || cars.getContent() == null || cars.getContent().getRoutesList().isEmpty() || cars.getContent().getRoutes(i) == null || (lightNum = cars.getContent().getRoutes(i).getLightNum()) <= 0) {
            return 0;
        }
        return lightNum;
    }

    public static int a(Cars cars, int i) {
        int i2 = 0;
        if (i >= 0 && cars != null && cars.hasContent() && cars.getContent().getRoutesCount() > 0 && cars.getContent().getRoutesCount() > i && cars.getContent().getRoutes(i) != null) {
            int i3 = 0;
            for (Cars.Content.Routes.Legs legs : cars.getContent().getRoutes(i).getLegsList()) {
                i2 += legs.getDistance();
                LogUtil.e(f7632a, "getCarDistance --> legs[" + i3 + "].getDistance() = " + legs.getDistance());
                i3++;
            }
            LogUtil.e(f7632a, "getCarDistance --> distance = " + i2);
        }
        return i2;
    }

    public static List<Cars.Content.Steps> d(Cars cars, int i) {
        ArrayList arrayList = new ArrayList();
        if (cars != null && cars.getContent() != null && i < cars.getContent().getRoutesCount()) {
            Iterator<Cars.Content.Routes.Legs> it = cars.getContent().getRoutes(i).getLegsList().iterator();
            while (it.hasNext()) {
                for (Cars.Content.Routes.Legs.Stepis stepis : it.next().getStepisList()) {
                    for (int s = stepis.getS(); s < stepis.getS() + stepis.getN(); s++) {
                        if (s < cars.getContent().getStepsList().size()) {
                            arrayList.add(cars.getContent().getStepsList().get(s));
                        }
                    }
                }
            }
            LogUtil.e("CarRouteUtils", "getListDataWithCarResultByNavi " + arrayList.size());
        }
        return arrayList;
    }

    public static String[] c(Cars cars) {
        Cars.Content.Routes routes;
        String[] strArr = new String[3];
        if (cars != null) {
            for (int i = 0; i < 3; i++) {
                if (cars.hasContent() && cars.getContent().getRoutesCount() > i && (routes = cars.getContent().getRoutes(i)) != null && routes.hasRouteMd5()) {
                    strArr[i] = routes.getRouteMd5();
                }
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e(f7632a, "getRouteMd5 --> routeMd5Array = " + Arrays.toString(strArr));
        }
        return strArr;
    }

    public static String b(Cars cars) {
        String startName = (cars != null && cars.hasOption() && cars.getOption().hasStartName()) ? cars.getOption().getStartName() : "";
        return startName == null ? "" : startName;
    }

    public static String a(Cars cars) {
        String endName = (cars != null && cars.hasOption() && cars.getOption().hasEndName()) ? cars.getOption().getEndName() : "";
        return endName == null ? "" : endName;
    }

    public static String[] b() {
        return c(a());
    }

    public static List<Cars.Content.Steps> a(int i) {
        LogUtil.e("CarRouteUtils", "tryToRepairData " + i);
        Cars a2 = a(BNRoutePlaner.getInstance().m(1));
        new ArrayList();
        return a(i, a2);
    }

    public static List<Cars.Content.Steps> a(int i, Cars cars) {
        ArrayList arrayList = new ArrayList();
        if (cars != null && cars.getContent() != null && i < cars.getContent().getRoutesCount()) {
            Iterator<Cars.Content.Routes.Legs> it = cars.getContent().getRoutes(i).getLegsList().iterator();
            while (it.hasNext()) {
                for (Cars.Content.Routes.Legs.Stepis stepis : it.next().getStepisList()) {
                    for (int s = stepis.getS(); s < stepis.getS() + stepis.getN(); s++) {
                        if (s < cars.getContent().getStepsList().size()) {
                            arrayList.add(cars.getContent().getStepsList().get(s));
                        }
                    }
                }
            }
            LogUtil.e("CarRouteUtils", "getListDataWithCarResultByNavi " + arrayList.size());
        }
        return arrayList;
    }

    public static Cars a(byte[] bArr) {
        try {
            List<MessageMicro> messageLiteList = ProtobufUtils.getMessageLiteList(bArr);
            if (messageLiteList == null) {
                return null;
            }
            for (MessageMicro messageMicro : messageLiteList) {
                if (messageMicro instanceof Cars) {
                    return (Cars) messageMicro;
                }
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }
}
