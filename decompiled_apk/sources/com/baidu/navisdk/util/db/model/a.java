package com.baidu.navisdk.util.db.model;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private List<com.baidu.navisdk.util.db.object.b> f9257a;
    private com.baidu.navisdk.util.db.table.b b;

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        static a f9258a = new a();
    }

    public static a d() {
        return b.f9258a;
    }

    public void a() {
        c();
        this.b.a("arg1=?", new String[]{"5"});
        this.f9257a.clear();
    }

    public ArrayList<RoutePlanNode> b() {
        return com.baidu.navisdk.util.db.object.b.a(this.f9257a);
    }

    public void c() {
        if (this.f9257a == null) {
            ArrayList<com.baidu.navisdk.util.db.object.b> a2 = this.b.a("arg1=?", new String[]{"5"}, "routeplan_id", "ASC");
            this.f9257a = a2;
            if (a2 == null) {
                this.f9257a = new ArrayList(0);
            }
        }
    }

    private a() {
        this.b = new com.baidu.navisdk.util.db.table.b();
    }

    public void a(RoutePlanNode routePlanNode) {
        if (routePlanNode == null) {
            return;
        }
        c();
        for (int i = 0; i < this.f9257a.size(); i++) {
            com.baidu.navisdk.util.db.object.b bVar = this.f9257a.get(i);
            if (com.baidu.navisdk.util.db.object.b.a(bVar, routePlanNode)) {
                this.b.a(bVar.getId());
                this.f9257a.remove(i);
                return;
            }
        }
    }

    public void a(ArrayList<RoutePlanNode> arrayList) {
        RoutePlanNode routePlanNode;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        c();
        a();
        this.b.a();
        for (int i = 1; i < arrayList.size(); i++) {
            try {
                routePlanNode = arrayList.get(i);
            } catch (Exception unused) {
                routePlanNode = null;
            }
            if (routePlanNode == null || routePlanNode.getLatitudeE6() == Integer.MIN_VALUE || routePlanNode.getLongitudeE6() == Integer.MIN_VALUE) {
                break;
            }
            com.baidu.navisdk.util.db.object.b bVar = new com.baidu.navisdk.util.db.object.b();
            bVar.copy(routePlanNode);
            bVar.a(5);
            this.b.b((com.baidu.navisdk.util.db.table.b) bVar);
            this.f9257a.add(bVar);
        }
        this.b.b();
    }
}
