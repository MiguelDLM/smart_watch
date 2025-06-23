package com.baidu.navisdk.behavrules;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class c {
    private static c b;

    /* renamed from: a, reason: collision with root package name */
    private List<com.baidu.navisdk.behavrules.scene.b> f6638a = new ArrayList();

    private c() {
    }

    public static c c() {
        if (b == null) {
            b = new c();
        }
        return b;
    }

    public void a(com.baidu.navisdk.behavrules.scene.b bVar) {
        this.f6638a.add(bVar);
    }

    public void b(com.baidu.navisdk.behavrules.scene.b bVar) {
        this.f6638a.remove(bVar);
    }

    public com.baidu.navisdk.behavrules.scene.b a(String str) {
        for (com.baidu.navisdk.behavrules.scene.b bVar : this.f6638a) {
            if (TextUtils.equals(bVar.f6654a, str)) {
                return bVar;
            }
        }
        return null;
    }

    public List<com.baidu.navisdk.behavrules.scene.c> b() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.baidu.navisdk.behavrules.scene.b> it = this.f6638a.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().e());
        }
        return arrayList;
    }

    public List<com.baidu.navisdk.behavrules.scene.b> a() {
        return this.f6638a;
    }

    public void a(int i) {
        com.baidu.navisdk.behavrules.util.b.b("BRuleManager", "enterPage = " + i);
        List<com.baidu.navisdk.behavrules.scene.b> list = this.f6638a;
        if (list != null) {
            Iterator<com.baidu.navisdk.behavrules.scene.b> it = list.iterator();
            while (it.hasNext()) {
                List<com.baidu.navisdk.behavrules.scene.c> e = it.next().e();
                if (e != null) {
                    Iterator<com.baidu.navisdk.behavrules.scene.c> it2 = e.iterator();
                    while (it2.hasNext()) {
                        it2.next().a(i);
                    }
                }
            }
        }
    }
}
