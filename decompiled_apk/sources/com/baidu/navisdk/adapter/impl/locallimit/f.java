package com.baidu.navisdk.adapter.impl.locallimit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public List<String> f6528a = null;
    public List<String> b = null;
    public com.baidu.navisdk.adapter.impl.locallimit.bean.c c = null;
    public List<com.baidu.navisdk.adapter.impl.locallimit.bean.e> d = new ArrayList();
    public Map<String, com.baidu.navisdk.adapter.impl.locallimit.bean.c> e = new ConcurrentHashMap();

    public boolean a() {
        List<String> list = this.b;
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }
}
