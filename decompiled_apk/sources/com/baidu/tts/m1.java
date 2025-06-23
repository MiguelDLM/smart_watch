package com.baidu.tts;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes8.dex */
public class m1 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f10134a = false;
    public Map<String, Integer> b = new HashMap();

    public boolean a() {
        Iterator<Integer> it = this.b.values().iterator();
        while (it.hasNext()) {
            if (it.next().intValue() != 7) {
                return false;
            }
        }
        return true;
    }
}
