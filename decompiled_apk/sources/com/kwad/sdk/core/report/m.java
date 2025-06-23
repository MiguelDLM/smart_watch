package com.kwad.sdk.core.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes11.dex */
public final class m<T extends e> implements l<T> {
    private final Map<String, T> ayU = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized void j(@NonNull T t) {
        this.ayU.put(t.actionId, t);
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<T> Fs() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.ayU.size());
        Iterator<Map.Entry<String, T>> it = this.ayU.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        int size;
        size = this.ayU.size();
        com.kwad.sdk.core.e.c.d("MemReportCache", "size() = " + size);
        return size;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void x(List<T> list) {
        for (T t : list) {
            if (t != null) {
                this.ayU.remove(t.actionId);
            }
        }
    }
}
