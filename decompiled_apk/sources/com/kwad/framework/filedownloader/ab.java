package com.kwad.framework.filedownloader;

import android.os.Handler;
import android.util.SparseArray;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes11.dex */
final class ab implements w {
    private final SparseArray<Handler> afX = new SparseArray<>();

    private static void a(Handler handler) {
        handler.sendEmptyMessage(2);
    }

    private static void b(Handler handler) {
        handler.sendEmptyMessage(3);
    }

    @Override // com.kwad.framework.filedownloader.w
    public final boolean bh(int i) {
        if (this.afX.get(i) != null) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void p(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            b(this.afX.get(it.next().intValue()));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final void vE() {
        for (int i = 0; i < this.afX.size(); i++) {
            a(this.afX.get(this.afX.keyAt(i)));
        }
    }

    @Override // com.kwad.framework.filedownloader.w
    public final int vF() {
        return this.afX.size();
    }
}
