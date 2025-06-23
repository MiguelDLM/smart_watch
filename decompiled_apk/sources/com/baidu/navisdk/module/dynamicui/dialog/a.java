package com.baidu.navisdk.module.dynamicui.dialog;

import android.text.TextUtils;
import com.baidu.navisdk.module.dynamicui.e;
import com.baidu.navisdk.util.common.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class a implements com.baidu.navisdk.behavrules.action.b<b> {
    @Override // com.baidu.navisdk.behavrules.action.b
    public /* bridge */ /* synthetic */ boolean a(b bVar, List list) {
        return a2(bVar, (List<com.baidu.navisdk.behavrules.data.c>) list);
    }

    @Override // com.baidu.navisdk.behavrules.action.b
    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("showDialog");
        return arrayList;
    }

    @Override // com.baidu.navisdk.behavrules.action.b
    public void a(b bVar) {
        com.baidu.navisdk.module.dynamicui.a.f.a().a(com.baidu.navisdk.framework.a.c().b(), bVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.navisdk.behavrules.action.b
    public b a(com.baidu.navisdk.behavrules.scene.c cVar) {
        return b.c(cVar.i().b());
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(b bVar, List<com.baidu.navisdk.behavrules.data.c> list) {
        if (TextUtils.isEmpty(com.baidu.navisdk.module.dynamicui.d.b().a(bVar.b(), bVar.c()))) {
            return false;
        }
        if (e.a().a(bVar.b()) && e.a().a(bVar.c())) {
            return true;
        }
        g gVar = g.BRULE;
        if (gVar.d()) {
            gVar.e("BRuleDynaUIDialogAction", "fixData(), 预加载还没完成 model = " + bVar);
        }
        return false;
    }
}
