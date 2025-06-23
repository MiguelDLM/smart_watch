package com.baidu.mobads.sdk.internal.a;

/* loaded from: classes7.dex */
public class b {
    public int a(Object[] objArr, int i, int i2) {
        if (objArr != null && objArr.length > i) {
            Object obj = objArr[i];
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return i2;
    }

    public Object a(Object[] objArr, int i, Object obj) {
        Object obj2;
        return (objArr == null || objArr.length <= i || (obj2 = objArr[i]) == null) ? obj : obj2;
    }
}
