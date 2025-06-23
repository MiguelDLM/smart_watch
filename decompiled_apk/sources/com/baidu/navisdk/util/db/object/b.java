package com.baidu.navisdk.util.db.object;

import android.text.TextUtils;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class b extends RoutePlanNode implements a {

    /* renamed from: a, reason: collision with root package name */
    private int f9259a;
    private int b;
    private int c;

    public b() {
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    @Override // com.baidu.navisdk.model.datastruct.RoutePlanNode
    public int getId() {
        return this.f9259a;
    }

    @Override // com.baidu.navisdk.model.datastruct.RoutePlanNode, com.baidu.navisdk.util.db.object.a
    public void setId(int i) {
        this.f9259a = i;
    }

    public b(int i, int i2, int i3, String str, String str2, String str3) {
        super(i, i2, i3, str, str2, str3);
    }

    public void a(int i) {
        this.b = i;
    }

    public void b(int i) {
        this.c = i;
    }

    public static ArrayList<RoutePlanNode> a(List<b> list) {
        ArrayList<RoutePlanNode> arrayList;
        if (list != null) {
            arrayList = new ArrayList<>(list.size());
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i));
            }
        } else {
            arrayList = null;
        }
        return arrayList == null ? new ArrayList<>(0) : arrayList;
    }

    public static boolean a(RoutePlanNode routePlanNode, RoutePlanNode routePlanNode2) {
        if (routePlanNode == null || routePlanNode2 == null) {
            return false;
        }
        String name = routePlanNode.getName();
        String name2 = routePlanNode2.getName();
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(name2)) {
            if (!name.equals(name2)) {
                return false;
            }
            if (!TextUtils.isEmpty(routePlanNode.getDescription()) && !TextUtils.isEmpty(routePlanNode2.getDescription())) {
                if (!routePlanNode.getDescription().equals(routePlanNode2.getDescription())) {
                    return false;
                }
            } else if (Math.abs(routePlanNode.getLatitudeE6() - routePlanNode2.getLatitudeE6()) > 3 || Math.abs(routePlanNode.getLongitudeE6() - routePlanNode2.getLongitudeE6()) > 3) {
                return false;
            }
        } else if (Math.abs(routePlanNode.getLatitudeE6() - routePlanNode2.getLatitudeE6()) > 3 || Math.abs(routePlanNode.getLongitudeE6() - routePlanNode2.getLongitudeE6()) > 3) {
            return false;
        }
        return true;
    }
}
