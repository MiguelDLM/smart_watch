package com.baidu.ar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
class ci {
    private static final Map<Class<?>, List<ch>> mr = new ConcurrentHashMap();
    private static final a[] ms = new a[4];

    /* loaded from: classes7.dex */
    public static class a {
        final List<ch> mt = new ArrayList();
        final Map<Class, Object> mu = new HashMap();
        final Map<String, Class> mv = new HashMap();
        final StringBuilder mw = new StringBuilder(128);
    }
}
