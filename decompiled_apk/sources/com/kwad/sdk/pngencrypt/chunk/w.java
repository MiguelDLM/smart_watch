package com.kwad.sdk.pngencrypt.chunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
public final class w {
    private final e aNW;
    private final boolean aNX;

    public w(e eVar) {
        this.aNW = eVar;
        if (eVar instanceof f) {
            this.aNX = false;
        } else {
            this.aNX = true;
        }
    }

    private List<? extends t> gv(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.aNW.al("tEXt", str));
        arrayList.addAll(this.aNW.al("zTXt", str));
        arrayList.addAll(this.aNW.al("iTXt", str));
        return arrayList;
    }

    public final String gw(String str) {
        List<? extends t> gv = gv(str);
        if (gv.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<? extends t> it = gv.iterator();
        while (it.hasNext()) {
            sb.append(it.next().Lf());
            sb.append("\n");
        }
        return sb.toString().trim();
    }
}
