package com.baidu.navisdk.ui.routeguide.asr.instruction;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes8.dex */
public class a {
    public static void a() {
        a(null);
    }

    public static void a(HashSet<String> hashSet) {
        c.d();
        e.a();
        com.baidu.navisdk.module.asr.instructions.c.a();
        HashMap<String, com.baidu.navisdk.asr.a> j = com.baidu.navisdk.asr.d.B().j();
        if (hashSet != null) {
            Iterator<Map.Entry<String, com.baidu.navisdk.asr.a>> it = j.entrySet().iterator();
            while (it.hasNext()) {
                if (hashSet.contains(it.next().getKey())) {
                    it.remove();
                }
            }
        }
    }
}
