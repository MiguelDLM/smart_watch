package com.baidu.sec.privacy.d;

import com.baidu.sec.privacy.d.d;
import java.util.Comparator;

/* loaded from: classes8.dex */
public class e implements Comparator<d.b> {
    public e(d dVar) {
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(d.b bVar, d.b bVar2) {
        int i = bVar2.c - bVar.c;
        if (i != 0) {
            return i;
        }
        boolean z = bVar.b;
        if (z && bVar2.b) {
            return 0;
        }
        if (z) {
            return -1;
        }
        if (bVar2.b) {
            return 1;
        }
        return i;
    }
}
