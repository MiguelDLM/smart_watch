package com.baidu.platform.comapi.wnplatform.j;

import com.baidu.ar.marker.model.Existance;
import com.baidu.ar.marker.model.Segments;
import com.baidu.entity.pb.WalkPlan;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.location.CoordinateUtil;
import com.baidu.platform.comapi.wnplatform.p.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9931a = "n";
    private static n b;
    private List<Segments> c;
    private Point d;

    private n() {
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            try {
                if (b == null) {
                    b = new n();
                }
                nVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    public Point b() {
        Point point = new Point(0, 0);
        List<Segments> list = this.c;
        if (list != null && list.size() > 0 && this.c.get(0).getPoints().size() > 0) {
            double[] dArr = (double[]) ((ArrayList) this.c.get(0).getPoints()).get(0);
            point.setDoubleX(dArr[0]);
            point.setDoubleY(dArr[1]);
        }
        return point;
    }

    public Point c() {
        return this.d;
    }

    private ArrayList<double[]> a(ArrayList<Point> arrayList) {
        ArrayList<double[]> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            Point point = arrayList.get(i);
            Point bd09mcTogcj02ll = CoordinateUtil.bd09mcTogcj02ll(point.getIntX(), point.getIntY());
            arrayList2.add(new double[]{bd09mcTogcj02ll.getDoubleX(), bd09mcTogcj02ll.getDoubleY()});
        }
        return arrayList2;
    }

    private void b(ArrayList<i.b> arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            i.b bVar = arrayList.get(i);
            if (bVar.d.size() > 0) {
                ArrayList<double[]> a2 = a(bVar.d);
                if (a2.size() > 0) {
                    Segments segments = new Segments();
                    Existance existance = new Existance();
                    existance.setType(bVar.b);
                    existance.setLatlng(a2.get(a2.size() - 1));
                    existance.setStreetName(bVar.f9959a);
                    existance.setDirectionType(bVar.c);
                    segments.setExistance(existance);
                    segments.setPoints(a2);
                    segments.setPointsCount(a2.size());
                    this.c.add(segments);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("x", a2.get(a2.size() - 1)[0]);
                        jSONObject.put("y", a2.get(a2.size() - 1)[1]);
                        jSONObject.put("type", bVar.b);
                        jSONArray.put(jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void a(WalkPlan walkPlan, int i) {
        if (walkPlan == null) {
            return;
        }
        this.c = new ArrayList();
        this.d = null;
        int b2 = i == 0 ? com.baidu.platform.comapi.walknavi.b.a().b() : 0;
        b(com.baidu.platform.comapi.wnplatform.p.i.a(walkPlan, b2));
        b(walkPlan, b2);
        try {
            List<Segments> list = this.c;
            if (list == null || list.size() == 0) {
                return;
            }
            com.baidu.platform.comapi.wnplatform.a.a().a(this.c, PrerollVideoResponse.NORMAL);
        } catch (Exception unused) {
        }
    }

    private void b(WalkPlan walkPlan, int i) {
        if (i < walkPlan.getRoutesCount()) {
            WalkPlan.Routes.Legs legs = walkPlan.getRoutes(i).getLegs(0);
            for (int i2 = 0; i2 < legs.getStepsCount(); i2++) {
                WalkPlan.Routes.Legs.Steps steps = legs.getSteps(i2);
                if (steps.getWalkType() == 2) {
                    List<Integer> strafficmarkLocList = steps.getStrafficmarkLocList();
                    this.d = new Point(strafficmarkLocList.get(0).intValue(), strafficmarkLocList.get(1).intValue());
                    return;
                }
            }
        }
    }
}
