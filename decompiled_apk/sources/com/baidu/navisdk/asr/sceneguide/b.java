package com.baidu.navisdk.asr.sceneguide;

import com.baidu.navisdk.asr.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class b implements com.baidu.navisdk.behavrules.action.b<a> {
    @Override // com.baidu.navisdk.behavrules.action.b
    public /* bridge */ /* synthetic */ boolean a(a aVar, List list) {
        return a2(aVar, (List<com.baidu.navisdk.behavrules.data.c>) list);
    }

    @Override // com.baidu.navisdk.behavrules.action.b
    public List<String> a() {
        HashMap<String, com.baidu.navisdk.asr.a> j = d.B().j();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(j.keySet());
        return arrayList;
    }

    @Override // com.baidu.navisdk.behavrules.action.b
    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        com.baidu.navisdk.asr.model.a a2 = aVar.a();
        c.a().a(aVar.b, aVar);
        d.B().a(a2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.navisdk.behavrules.action.b
    public a a(com.baidu.navisdk.behavrules.scene.c cVar) {
        return a.a(cVar.i().b(), cVar.i().a(), cVar.m(), cVar.h());
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(a aVar, List<com.baidu.navisdk.behavrules.data.c> list) {
        if (aVar == null) {
            return false;
        }
        return aVar.a(new com.baidu.navisdk.behavrules.data.a(list));
    }
}
