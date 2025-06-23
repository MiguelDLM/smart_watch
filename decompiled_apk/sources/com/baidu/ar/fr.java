package com.baidu.ar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes7.dex */
public class fr implements ft, h {
    private boolean tG = false;
    private boolean tH = false;

    @Override // com.baidu.ar.h
    public boolean Y() {
        return this.tG;
    }

    @Override // com.baidu.ar.ft
    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        if (i == 103) {
            this.tH = true;
        } else {
            if (i != 104) {
                return;
            }
            this.tG = true;
        }
    }

    public void af() {
        this.tG = false;
        this.tH = false;
    }

    public void b(fs fsVar) {
        fsVar.c(this);
    }

    @Override // com.baidu.ar.ft
    public List<Integer> q() {
        return Arrays.asList(103, 104);
    }

    public void release() {
        af();
    }
}
