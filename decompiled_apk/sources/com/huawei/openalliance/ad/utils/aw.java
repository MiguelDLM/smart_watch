package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public abstract class aw {
    private static final List<String> Code = new ArrayList();

    public static void Code(Context context) {
        List<String> list = Code;
        list.clear();
        list.add(av.Z(context));
        list.add(av.V(context));
        list.add(av.B(context));
        list.add(av.I(context));
    }

    public static boolean Code(String str) {
        List<String> list = Code;
        if (list.isEmpty() || TextUtils.isEmpty(str)) {
            return false;
        }
        return list.contains(str);
    }
}
