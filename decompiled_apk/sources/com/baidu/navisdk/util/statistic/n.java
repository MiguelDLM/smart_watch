package com.baidu.navisdk.util.statistic;

import com.baidu.navisdk.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.util.common.h0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class n extends com.baidu.navisdk.comapi.statistics.f {
    private static n l;
    private long j;
    private StringBuilder k;

    private n(com.baidu.navisdk.comapi.statistics.d dVar) {
        super(dVar);
        this.j = 0L;
    }

    public static n o() {
        if (l == null) {
            l = new n(com.baidu.navisdk.comapi.statistics.b.f());
        }
        return l;
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public void b(int i) {
        String encode;
        n();
        b("down_m", Long.toString(this.j / 1048576));
        b("left_m", Long.toString(h0.b() / 1048576));
        StringBuilder sb = this.k;
        if (sb != null) {
            try {
                encode = URLEncoder.encode(sb.toString(), "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
            b("down_city", encode);
            super.b(i);
        }
        encode = "";
        b("down_city", encode);
        super.b(i);
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String d() {
        return "50007";
    }

    @Override // com.baidu.navisdk.comapi.statistics.f
    public String h() {
        return "Statistics-OfflineDataStatItem";
    }

    public void n() {
        this.k = new StringBuilder();
        ArrayList<com.baidu.navisdk.model.datastruct.k> downloadedList = BNOfflineDataManager.getInstance().getDownloadedList();
        if (downloadedList != null) {
            for (com.baidu.navisdk.model.datastruct.k kVar : downloadedList) {
                if (kVar != null) {
                    this.j += kVar.e;
                    StringBuilder sb = this.k;
                    sb.append(kVar.f6934a);
                    sb.append(",");
                }
            }
        }
        if (this.k.length() > 0) {
            this.k.deleteCharAt(r0.length() - 1);
        }
    }
}
