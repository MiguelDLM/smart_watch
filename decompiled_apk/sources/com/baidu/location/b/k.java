package com.baidu.location.b;

import com.baidu.location.b.j;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class k implements Comparator<j.c> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f5647a;

    public k(j jVar) {
        this.f5647a = jVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(j.c cVar, j.c cVar2) {
        int i = cVar.b;
        int i2 = cVar2.b;
        if (i > i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }
}
