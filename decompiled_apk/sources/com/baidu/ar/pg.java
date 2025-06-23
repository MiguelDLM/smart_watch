package com.baidu.ar;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes7.dex */
public class pg implements pc {
    private TreeMap<String, String> Jx = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private byte[] content;

    @Override // com.baidu.ar.pf
    public String cJ(String str) {
        String str2 = this.Jx.get(str);
        return str2 == null ? "" : str2;
    }

    @Override // com.baidu.ar.pf
    public boolean cK(String str) {
        return this.Jx.containsKey(str);
    }

    @Override // com.baidu.ar.pf
    public Iterator<String> jM() {
        return Collections.unmodifiableSet(this.Jx.keySet()).iterator();
    }

    @Override // com.baidu.ar.pf
    public byte[] jN() {
        return this.content;
    }

    @Override // com.baidu.ar.pc
    public void put(String str, String str2) {
        this.Jx.put(str, str2);
    }
}
