package com.baidu.ar;

import java.util.HashMap;

/* renamed from: com.baidu.ar.do, reason: invalid class name */
/* loaded from: classes7.dex */
public class Cdo {
    private HashMap<String, Double> pA;
    private boolean px;
    private byte[] py;
    private String pz;

    public Cdo() {
    }

    public void ac(String str) {
        this.pz = str;
    }

    public byte[] cV() {
        return this.py;
    }

    public String cW() {
        return this.pz;
    }

    public HashMap<String, Double> cX() {
        return this.pA;
    }

    public boolean isLast() {
        return this.px;
    }

    public Cdo(byte[] bArr, HashMap<String, Double> hashMap, boolean z) {
        this.py = bArr;
        this.pA = hashMap;
        this.px = z;
    }
}
