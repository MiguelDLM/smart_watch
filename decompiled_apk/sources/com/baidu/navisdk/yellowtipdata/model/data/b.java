package com.baidu.navisdk.yellowtipdata.model.data;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.baidu.entity.pb.end_button_info;
import com.baidu.entity.pb.yellow_tip_point;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.o;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class b {

    @OOXIXo
    public static final a f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    private final String f9462a;

    @OOXIXo
    private final com.baidu.nplatform.comapi.basestruct.c b;

    @OOXIXo
    private final String c;

    @OOXIXo
    private final String d;
    private final int e;

    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        @oOoXoXO
        public final b a(@oOoXoXO end_button_info end_button_infoVar) {
            if (end_button_infoVar != null) {
                try {
                    String byteStringMicro = end_button_infoVar.getBtnTitle().toString("GBK");
                    IIX0o.oO(byteStringMicro, "endButton.btnTitle.toString(\"GBK\")");
                    String byteStringMicro2 = end_button_infoVar.getEndInput().toString("GBK");
                    IIX0o.oO(byteStringMicro2, "endButton.endInput.toString(\"GBK\")");
                    yellow_tip_point showPoint = end_button_infoVar.getShowPoint();
                    IIX0o.oO(showPoint, "endButton.showPoint");
                    double x = showPoint.getX();
                    IIX0o.oO(end_button_infoVar.getShowPoint(), "endButton.showPoint");
                    com.baidu.nplatform.comapi.basestruct.c cVar = new com.baidu.nplatform.comapi.basestruct.c(x, r2.getY());
                    String byteStringMicro3 = end_button_infoVar.getUid().toString("GBK");
                    IIX0o.oO(byteStringMicro3, "endButton.uid.toString(\"GBK\")");
                    String byteStringMicro4 = end_button_infoVar.getCname().toString("GBK");
                    IIX0o.oO(byteStringMicro4, "endButton.cname.toString(\"GBK\")");
                    return new b(byteStringMicro, byteStringMicro2, cVar, byteStringMicro3, byteStringMicro4, end_button_infoVar.getCityid(), end_button_infoVar.getBorderColor(), end_button_infoVar.getBackgroundColor(), null);
                } catch (Exception e) {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ROUTE_RESULT;
                    if (gVar.d()) {
                        gVar.a("parse end button info error!", e);
                    }
                }
            }
            return null;
        }

        public /* synthetic */ a(IIXOooo iIXOooo) {
            this();
        }

        @oOoXoXO
        public final RoutePlanNode a(@oOoXoXO b bVar) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("EndBtnInfo", "convertEndInfoToNode --> endButtonInfo = " + bVar);
            }
            if (bVar != null) {
                try {
                    RoutePlanNode routePlanNode = new RoutePlanNode();
                    routePlanNode.setDistrictID(bVar.a());
                    routePlanNode.setCityName(bVar.b());
                    routePlanNode.setUID(bVar.e());
                    routePlanNode.setName(bVar.c());
                    if (!bVar.d().e()) {
                        GeoPoint a2 = o.a(bVar.d());
                        IIX0o.oO(a2, "CoordinateTransformUtil.…(endButtonInfo.showPoint)");
                        routePlanNode.setGeoPoint(a2);
                        routePlanNode.setFrom(1);
                        routePlanNode.setNodeType(1);
                    } else {
                        routePlanNode.setFrom(2);
                        routePlanNode.setNodeType(2);
                    }
                    if (!LogUtil.LOGGABLE) {
                        return routePlanNode;
                    }
                    LogUtil.e("EndBtnInfo", "convertEndInfoToNode --> routePlanNode = " + routePlanNode);
                    return routePlanNode;
                } catch (Exception e) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("EndBtnInfo", "convertEndInfoToNode --> e = " + e);
                    }
                }
            }
            return null;
        }
    }

    private b(String str, String str2, com.baidu.nplatform.comapi.basestruct.c cVar, String str3, String str4, int i, int i2, int i3) {
        this.f9462a = str2;
        this.b = cVar;
        this.c = str3;
        this.d = str4;
        this.e = i;
    }

    public final int a() {
        return this.e;
    }

    @OOXIXo
    public final String b() {
        return this.d;
    }

    @OOXIXo
    public final String c() {
        return this.f9462a;
    }

    @OOXIXo
    public final com.baidu.nplatform.comapi.basestruct.c d() {
        return this.b;
    }

    @OOXIXo
    public final String e() {
        return this.c;
    }

    public /* synthetic */ b(String str, String str2, com.baidu.nplatform.comapi.basestruct.c cVar, String str3, String str4, int i, int i2, int i3, IIXOooo iIXOooo) {
        this(str, str2, cVar, str3, str4, i, i2, i3);
    }
}
