package com.baidu.navisdk.comapi.routeplan;

import com.baidu.entity.pb.Cars;
import com.baidu.entity.pb.PoiResult;
import com.baidu.entity.pb.TrafficPois;
import com.baidu.navisdk.util.common.LogUtil;
import com.google.protobuf.micro.MessageMicro;
import java.util.List;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f6723a;

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.worker.f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6724a;
        final /* synthetic */ com.baidu.navisdk.comapi.routeplan.v2.d b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, int i, com.baidu.navisdk.comapi.routeplan.v2.d dVar) {
            super(str, str2);
            this.f6724a = i;
            this.b = dVar;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            int i;
            byte[] m;
            boolean unused = f.f6723a = false;
            long currentTimeMillis = System.currentTimeMillis();
            if (LogUtil.LOGGABLE) {
                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "parseCarsDataAfterSuccess --> start!!! resultType = " + this.f6724a);
            }
            com.baidu.navisdk.comapi.routeplan.v2.d dVar = this.b;
            if (dVar == null || dVar.e() == null) {
                i = 4;
            } else {
                i = this.b.e().f;
                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "parseCarsDataAfterSuccess --> entry=" + i + ", outH=" + this.b.e().q);
            }
            int i2 = this.f6724a;
            if (i2 == 2) {
                f.b();
                m = BNRoutePlaner.getInstance().m(f.b(i));
            } else if (i2 == 18) {
                m = BNRoutePlaner.getInstance().m(2);
            } else if (i2 != 49 && i2 != 65 && i2 != 67) {
                m = i2 != 177 ? null : BNRoutePlaner.getInstance().m(0);
            } else {
                m = BNRoutePlaner.getInstance().w();
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "parseCarsDataAfterSuccess --> get pb success!!! cost time is " + (System.currentTimeMillis() - currentTimeMillis));
            }
            ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).a(m);
            if (m != null && m.length != 0) {
                f.b(this.b, m, this.f6724a);
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "parseCarsDataAfterSuccess --> end!!! cost time is " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                }
                return null;
            }
            LogUtil.e(com.baidu.navisdk.util.worker.g.TAG, "parseCarsDataAfterSuccess --> pb is empty!!! resultType = " + this.f6724a);
            f.b(this.b, this.f6724a);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.navisdk.comapi.routeplan.v2.d dVar, byte[] bArr, int i) {
        LogUtil.e("BNRoutePlanResultResolver", "parsePbData --> start parse!!! resultType = " + i);
        List<MessageMicro> a2 = a(bArr);
        if (a2 != null && a2.size() > 1 && a2.get(1) != null) {
            LogUtil.e("BNRoutePlanResultResolver", "parsePbData --> parse success!!! resultType = " + i);
            a(dVar, a2, i);
            return;
        }
        if (a2 != null && a2.size() > 0 && a2.get(0) != null) {
            LogUtil.e("BNRoutePlanResultResolver", "parsePbData --> parse abnormal!!! resultType = " + i);
            a(dVar, a2, i);
            return;
        }
        LogUtil.e("BNRoutePlanResultResolver", "parsePbData --> parse error!!! resultType = " + i);
        b(dVar, i);
    }

    public static void c(com.baidu.navisdk.comapi.routeplan.v2.d dVar, int i) {
        LogUtil.e("BNRoutePlanResultResolver", i + "---");
        com.baidu.navisdk.util.worker.c.a().c(new a("BNRoutePlanResultResolver - parsePbDataAfterSuccess", null, i, dVar), new com.baidu.navisdk.util.worker.e(1, 0));
    }

    private static TrafficPois c(List<MessageMicro> list) {
        if (list != null && !list.isEmpty()) {
            for (MessageMicro messageMicro : list) {
                if (messageMicro instanceof TrafficPois) {
                    return (TrafficPois) messageMicro;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.google.protobuf.micro.MessageMicro> a(byte[] r7) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            boolean r2 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            java.lang.String r3 = "BNRoutePlanResultResolver"
            if (r2 == 0) goto Lf
            java.lang.String r2 = "getPbListData --> start parse pb to car!!!"
            com.baidu.navisdk.util.common.LogUtil.e(r3, r2)
        Lf:
            if (r7 == 0) goto L2f
            java.util.List r7 = com.baidu.navisdk.util.pbanaliysis.b.a(r7)     // Catch: java.io.IOException -> L16
            goto L30
        L16:
            r7 = move-exception
            boolean r2 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            if (r2 == 0) goto L2f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "getPbListData --> e = "
            r2.append(r4)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            com.baidu.navisdk.util.common.LogUtil.e(r3, r7)
        L2f:
            r7 = 0
        L30:
            boolean r2 = com.baidu.navisdk.util.common.LogUtil.LOGGABLE
            if (r2 == 0) goto L52
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "getPbListData --> end parse pb to car!!! cost time is "
            r2.append(r6)
            long r4 = r4 - r0
            r2.append(r4)
            java.lang.String r0 = "ms"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.baidu.navisdk.util.common.LogUtil.e(r3, r0)
        L52:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.comapi.routeplan.f.a(byte[]):java.util.List");
    }

    private static PoiResult b(List<MessageMicro> list) {
        if (list != null && !list.isEmpty()) {
            for (MessageMicro messageMicro : list) {
                if (messageMicro instanceof PoiResult) {
                    return (PoiResult) messageMicro;
                }
            }
        }
        return null;
    }

    private static void a(com.baidu.navisdk.comapi.routeplan.v2.d dVar, List<MessageMicro> list, int i) {
        List<MessageMicro> a2;
        PoiResult b = b(list);
        TrafficPois c = c(list);
        Cars a3 = a(list);
        if (a(a3, i) && (a2 = a(BNRoutePlaner.getInstance().m(2))) != null && !a2.isEmpty()) {
            a(a(a2), a3);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanResultResolver", "setResultData --> resultType = " + i + ", poiResult: " + b);
            LogUtil.e("BNRoutePlanResultResolver", "setResultData --> resultType = " + i + ", trafficPois: " + c);
            LogUtil.e("BNRoutePlanResultResolver", "setResultData --> resultType = " + i + ", cars: " + a3);
        }
        if (b != null) {
            a(dVar, b, i);
        }
        if (c != null) {
            a(dVar, c, i);
        }
        if (a3 != null) {
            a(dVar, a3, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.baidu.navisdk.comapi.routeplan.v2.d dVar, int i) {
        LogUtil.e("BNRoutePlanResultResolver", "notifyError --> parse pb error!!! resultType = " + i);
        if (f6723a) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNRoutePlanResultResolver", "notifyError --> force interrupt parse pb data!!!");
            }
        } else if (i == 2) {
            BNRoutePlaner.getInstance().a(dVar, 4098, 0);
        } else if (i == 49) {
            BNRoutePlaner.getInstance().a(dVar, 4108, 0);
        } else {
            if (i != 65) {
                return;
            }
            BNRoutePlaner.getInstance().a(dVar, 4102, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i) {
        int i2;
        if (i != 30 && i != 32 && i != 37 && i != 55 && i != 103) {
            if (i == 107) {
                i2 = 7;
            } else if (a() != 2) {
                i2 = 0;
            }
            LogUtil.e("BNRoutePlanResultResolver", "entryToCarsDataType() entry=" + i + ", type=" + i2);
            return i2;
        }
        i2 = 1;
        LogUtil.e("BNRoutePlanResultResolver", "entryToCarsDataType() entry=" + i + ", type=" + i2);
        return i2;
    }

    public static void b(boolean z) {
        f6723a = z;
    }

    public static void b() {
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null) {
            fVar.a((Cars) null);
            fVar.b((Cars) null);
            fVar.a((byte[]) null);
        }
        com.baidu.navisdk.framework.b.b(18, (Object) null);
        com.baidu.navisdk.framework.b.b(34, (Object) null);
    }

    private static boolean a(Cars cars, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanResultResolver", "isShouldAddLongDistanceData --> cars = " + cars + ", resultType = " + i);
        }
        if (cars == null) {
            return false;
        }
        return i == 65 || i == 67;
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

    private static void a(com.baidu.navisdk.comapi.routeplan.v2.d dVar, Cars cars, int i) {
        Cars d;
        if (cars == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        LogUtil.e("BNRoutePlanResultResolver", "setCarsResultData --> deal cars start!!! resultType = " + i);
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (i == 18) {
            d = fVar != null ? fVar.d() : null;
            if (d == null) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("BNRoutePlanResultResolver", "setCarsResultData --> deal second piece failed, old cars is null!!! resultType = " + i);
                    return;
                }
                return;
            }
            a(cars, d);
            fVar.a(d);
            com.baidu.navisdk.framework.b.b(34, d);
        } else if (i != 177) {
            d = fVar != null ? fVar.d() : null;
            if (cars.getContent() != null && cars.getContent().getRoutesCount() > 0 && cars.getContent().getStepsCount() > 0) {
                LogUtil.e("BNRoutePlanResultResolver", "setCarsResultData --> resultType = " + i + ", parseMCarObject parseMCarObject 11111 ");
                if (fVar != null) {
                    fVar.a(cars);
                }
                com.baidu.navisdk.framework.b.b(18, cars);
            } else {
                LogUtil.e("BNRoutePlanResultResolver", "setCarsResultData --> resultType = " + i + ", parseMCarObject enter2 ");
                if (cars.getContent() != null) {
                    int trafficsCount = cars.getContent().getTrafficsCount();
                    if (d != null && d.getContent() != null && cars.getContent().getSteptsCount() > 0 && cars.getContent().getSteptsCount() == d.getContent().getStepsCount() && trafficsCount > 0 && trafficsCount == d.getContent().getTrafficsCount()) {
                        d.getContent().clearStepts();
                        d.getContent().clearTraffics();
                        for (int i2 = 0; i2 < cars.getContent().getSteptsCount(); i2++) {
                            d.getContent().addStepts(cars.getContent().getStepts(i2));
                        }
                        for (int i3 = 0; i3 < trafficsCount; i3++) {
                            d.getContent().addTraffics(cars.getContent().getTraffics(i3));
                        }
                        fVar.a(d);
                        com.baidu.navisdk.framework.b.b(18, d);
                    }
                }
            }
        } else if (fVar != null) {
            fVar.b(cars);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNRoutePlanResultResolver", "setCarsResultData --> deal cars end!!! cost time is " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            LogUtil.e("BNRoutePlanResultResolver", "setCarsResultData --> resultType = " + i + ", set cars success!!! notify listener!!!");
        }
        if (f6723a) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNRoutePlanResultResolver", "setCarsResultData --> force interrupt parse pb data!!!");
                return;
            }
            return;
        }
        if (i == 2) {
            BNRoutePlaner.getInstance().a(dVar, 4097, 18);
            return;
        }
        if (i == 18) {
            BNRoutePlaner.getInstance().a(dVar, 4099, 34);
            return;
        }
        if (i == 49) {
            BNRoutePlaner.getInstance().a(dVar, 4107, 18);
            return;
        }
        if (i == 65) {
            BNRoutePlaner.getInstance().a(dVar, 4101, 18);
        } else if (i != 67) {
            if (i != 177) {
                return;
            }
            BNRoutePlaner.getInstance().a(dVar, 4109, 18);
        } else {
            BNRoutePlaner.getInstance().a(dVar, 4103, 18);
        }
    }

    private static void a(com.baidu.navisdk.comapi.routeplan.v2.d dVar, PoiResult poiResult, int i) {
        if (poiResult == null) {
            return;
        }
        LogUtil.e("BNRoutePlanResultResolver", "setPoiResult --> deal poi start!!! resultType = " + i);
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null) {
            fVar.a(poiResult);
        }
        com.baidu.navisdk.framework.b.b(1, poiResult);
        if (f6723a) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNRoutePlanResultResolver", "setPoiResult --> force interrupt parse pb data!!!");
                return;
            }
            return;
        }
        if (i == 2) {
            BNRoutePlaner.getInstance().a(dVar, 4097, 1);
            return;
        }
        if (i == 18) {
            BNRoutePlaner.getInstance().a(dVar, 4099, 1);
            return;
        }
        if (i == 49) {
            BNRoutePlaner.getInstance().a(dVar, 4107, 1);
        } else if (i == 65) {
            BNRoutePlaner.getInstance().a(dVar, 4101, 1);
        } else {
            if (i != 67) {
                return;
            }
            BNRoutePlaner.getInstance().a(dVar, 4103, 1);
        }
    }

    private static void a(com.baidu.navisdk.comapi.routeplan.v2.d dVar, TrafficPois trafficPois, int i) {
        if (trafficPois == null) {
            return;
        }
        LogUtil.e("BNRoutePlanResultResolver", "setTrafficResult --> deal traffic start!!! resultType = " + i);
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null) {
            fVar.a(trafficPois);
        }
        com.baidu.navisdk.framework.b.b(3, trafficPois);
        if (f6723a) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNRoutePlanResultResolver", "setTrafficResult --> force interrupt parse pb data!!!");
                return;
            }
            return;
        }
        if (i == 2) {
            BNRoutePlaner.getInstance().a(dVar, 4097, 3);
            return;
        }
        if (i == 18) {
            BNRoutePlaner.getInstance().a(dVar, 4099, 3);
            return;
        }
        if (i == 49) {
            BNRoutePlaner.getInstance().a(dVar, 4107, 3);
        } else if (i == 65) {
            BNRoutePlaner.getInstance().a(dVar, 4101, 3);
        } else {
            if (i != 67) {
                return;
            }
            BNRoutePlaner.getInstance().a(dVar, 4103, 3);
        }
    }

    private static int a() {
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        if (fVar != null) {
            return fVar.f();
        }
        return 0;
    }
}
