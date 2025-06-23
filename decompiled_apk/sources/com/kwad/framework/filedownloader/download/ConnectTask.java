package com.kwad.framework.filedownloader.download;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes11.dex */
public final class ConnectTask {
    private Map<String, List<String>> agA;
    private List<String> agB;
    final int agw;
    final com.kwad.framework.filedownloader.d.b agx;
    private com.kwad.framework.filedownloader.download.a agy;
    private String agz;
    final String url;

    /* loaded from: classes11.dex */
    public class Reconnect extends Throwable {
        private static final long serialVersionUID = 2940866805654257562L;

        public Reconnect() {
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        private Integer agC;
        private com.kwad.framework.filedownloader.download.a agD;
        private com.kwad.framework.filedownloader.d.b agx;
        private String agz;
        private String url;

        public final a a(com.kwad.framework.filedownloader.d.b bVar) {
            this.agx = bVar;
            return this;
        }

        public final a bi(String str) {
            this.url = str;
            return this;
        }

        public final a bj(String str) {
            this.agz = str;
            return this;
        }

        public final a bs(int i) {
            this.agC = Integer.valueOf(i);
            return this;
        }

        public final ConnectTask vR() {
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num = this.agC;
            if (num != null && (aVar = this.agD) != null && this.url != null) {
                return new ConnectTask(aVar, num.intValue(), this.url, this.agz, this.agx, (byte) 0);
            }
            throw new IllegalArgumentException();
        }

        public final a a(com.kwad.framework.filedownloader.download.a aVar) {
            this.agD = aVar;
            return this;
        }
    }

    public /* synthetic */ ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i, String str, String str2, com.kwad.framework.filedownloader.d.b bVar, byte b) {
        this(aVar, i, str, str2, bVar);
    }

    private void a(com.kwad.framework.filedownloader.a.b bVar) {
        HashMap<String, List<String>> wO;
        com.kwad.framework.filedownloader.d.b bVar2 = this.agx;
        if (bVar2 != null && (wO = bVar2.wO()) != null) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.agw), wO);
            }
            for (Map.Entry<String, List<String>> entry : wO.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                if (value != null) {
                    Iterator<String> it = value.iterator();
                    while (it.hasNext()) {
                        bVar.addHeader(key, it.next());
                    }
                }
            }
        }
    }

    private void b(com.kwad.framework.filedownloader.a.b bVar) {
        String b;
        if (!TextUtils.isEmpty(this.agz)) {
            bVar.addHeader("If-Match", this.agz);
        }
        com.kwad.framework.filedownloader.download.a aVar = this.agy;
        if (aVar.agG == 0) {
            b = com.kwad.framework.filedownloader.f.f.b("bytes=%d-", Long.valueOf(aVar.agF));
        } else {
            b = com.kwad.framework.filedownloader.f.f.b("bytes=%d-%d", Long.valueOf(aVar.agF), Long.valueOf(this.agy.agG));
        }
        bVar.addHeader("Range", b);
    }

    private void c(com.kwad.framework.filedownloader.a.b bVar) {
        com.kwad.framework.filedownloader.d.b bVar2 = this.agx;
        if (bVar2 == null || bVar2.wO().get("User-Agent") == null) {
            bVar.addHeader("User-Agent", com.kwad.framework.filedownloader.f.f.xx());
        }
    }

    public final Map<String, List<String>> getRequestHeader() {
        return this.agA;
    }

    public final com.kwad.framework.filedownloader.a.b vN() {
        com.kwad.framework.filedownloader.a.b bk = b.vS().bk(this.url);
        a(bk);
        b(bk);
        c(bk);
        this.agA = bk.vG();
        if (com.kwad.framework.filedownloader.f.d.ajb) {
            com.kwad.framework.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.agw), this.agA);
        }
        bk.execute();
        ArrayList arrayList = new ArrayList();
        this.agB = arrayList;
        return com.kwad.framework.filedownloader.a.d.a(this.agA, bk, arrayList);
    }

    public final boolean vO() {
        if (this.agy.agF > 0) {
            return true;
        }
        return false;
    }

    public final String vP() {
        List<String> list = this.agB;
        if (list != null && !list.isEmpty()) {
            return this.agB.get(r0.size() - 1);
        }
        return null;
    }

    public final com.kwad.framework.filedownloader.download.a vQ() {
        return this.agy;
    }

    private ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i, String str, String str2, com.kwad.framework.filedownloader.d.b bVar) {
        this.agw = i;
        this.url = str;
        this.agz = str2;
        this.agx = bVar;
        this.agy = aVar;
    }
}
