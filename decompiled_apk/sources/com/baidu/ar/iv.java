package com.baidu.ar;

import java.util.List;

/* loaded from: classes7.dex */
public final class iv extends ir {
    private long zp;

    public iv(im imVar, int i, in inVar, boolean z) {
        super(imVar, i, inVar, z);
        this.zp = 0L;
    }

    @Override // com.baidu.ar.ir
    public List<List<ij>> fZ() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.zp < 1000) {
            return null;
        }
        this.zp = currentTimeMillis;
        List<List<ij>> fZ = super.fZ();
        return fZ.size() > 1 ? fZ.subList(0, 1) : fZ;
    }
}
