package com.baidu.mapsdkplatform.comapi.b.a;

import java.io.File;
import java.util.Comparator;

/* loaded from: classes7.dex */
public class e implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        try {
            return ((File) obj2).getName().split("_")[2].compareTo(((File) obj).getName().split("_")[2]);
        } catch (Exception unused) {
            return 0;
        }
    }
}
