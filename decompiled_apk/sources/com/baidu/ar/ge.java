package com.baidu.ar;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public class ge {
    private static volatile ge uw;
    private int ux = -1;
    private Set<gd> uy = new HashSet();

    private ge() {
    }

    public static ge ew() {
        if (uw == null) {
            synchronized (ge.class) {
                try {
                    if (uw == null) {
                        uw = new ge();
                    }
                } finally {
                }
            }
        }
        return uw;
    }

    public void F(int i) {
        this.ux = i;
        kf.c("MultEngineManager", "setupEngine sdkType:" + i + " " + this.uy.size());
        Set<gd> set = this.uy;
        if (set == null || set.isEmpty()) {
            return;
        }
        for (gd gdVar : this.uy) {
            if (gdVar != null) {
                gdVar.onEngineCreate(i);
            }
        }
    }

    public void ex() {
        kf.c("MultEngineManager", "clearListeners");
        this.uy.clear();
    }

    public boolean ey() {
        return this.ux == 2;
    }

    public void release() {
        kf.c("MultEngineManager", "release");
        this.ux = -1;
        ex();
    }
}
