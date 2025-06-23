package com.baidu.ar;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class ay {
    private static volatile ay iM;
    private List<ax> iN = new ArrayList();

    private ay() {
    }

    public static ay bl() {
        if (iM == null) {
            synchronized (ay.class) {
                try {
                    if (iM == null) {
                        iM = new ay();
                    }
                } finally {
                }
            }
        }
        return iM;
    }

    public ax b(int i, int i2, int i3) {
        List<ax> list = this.iN;
        if (list != null) {
            for (ax axVar : list) {
                if (axVar != null && axVar.mTextureId == i) {
                    axVar.h(i2, i3);
                    return axVar;
                }
            }
        }
        ax axVar2 = new ax();
        axVar2.a(i, i2, i3);
        List<ax> list2 = this.iN;
        if (list2 != null) {
            list2.add(axVar2);
        }
        return axVar2;
    }

    public ax m(int i) {
        List<ax> list = this.iN;
        if (list == null) {
            return null;
        }
        for (ax axVar : list) {
            if (axVar != null && axVar.mTextureId == i) {
                return axVar;
            }
        }
        return null;
    }

    public void release() {
        List<ax> list = this.iN;
        if (list != null) {
            for (ax axVar : list) {
                if (axVar != null) {
                    axVar.release();
                }
            }
            this.iN.clear();
        }
        if (iM != null) {
            iM = null;
        }
    }
}
