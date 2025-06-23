package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes11.dex */
public class d {
    public static b a(Map<String, List<String>> map, b bVar, List<String> list) {
        int responseCode = bVar.getResponseCode();
        String bg = bVar.bg("Location");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (bi(responseCode)) {
            if (bg != null) {
                if (com.kwad.framework.filedownloader.f.d.ajb) {
                    com.kwad.framework.filedownloader.f.d.c(d.class, "redirect to %s with %d, %s", bg, Integer.valueOf(responseCode), arrayList);
                }
                bVar.vI();
                bVar = a(map, bg);
                arrayList.add(bg);
                bVar.execute();
                responseCode = bVar.getResponseCode();
                bg = bVar.bg("Location");
                i++;
                if (i >= 10) {
                    throw new IllegalAccessException(f.b("redirect too many times! %s", arrayList));
                }
            } else {
                throw new IllegalAccessException(f.b("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(responseCode), bVar.vH()));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    private static boolean bi(int i) {
        return i == 301 || i == 302 || i == 303 || i == 300 || i == 307 || i == 308;
    }

    private static b a(Map<String, List<String>> map, String str) {
        b bk = com.kwad.framework.filedownloader.download.b.vS().bk(str);
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bk.addHeader(key, it.next());
                }
            }
        }
        return bk;
    }
}
