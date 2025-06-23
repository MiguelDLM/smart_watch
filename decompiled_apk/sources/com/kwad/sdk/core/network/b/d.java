package com.kwad.sdk.core.network.b;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;
import org.apache.log4j.spi.LocationInfo;

/* loaded from: classes11.dex */
public final class d implements b {
    private static boolean aya = true;
    public static double ayb = 1.0d;
    private static volatile boolean ayf = false;
    private static String ayg = "";
    private long ayc = -1;
    private long ayd = -1;
    private long aye = -1;
    private j ayh = new j();

    public d() {
        ayb = new Random().nextDouble();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: EU, reason: merged with bridge method [inline-methods] */
    public d EM() {
        this.ayh.axl = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: EV, reason: merged with bridge method [inline-methods] */
    public d EN() {
        this.ayd = SystemClock.elapsedRealtime();
        em("this.responseReceiveTime:" + this.ayd);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: EW, reason: merged with bridge method [inline-methods] */
    public d EO() {
        if (as(this.ayc) && as(this.ayd)) {
            this.ayh.axs = this.ayd - this.ayc;
            em("info.waiting_response_cost:" + this.ayh.axs);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: EX, reason: merged with bridge method [inline-methods] */
    public d EP() {
        if (as(this.ayh.axl)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.ayc = elapsedRealtime;
            j jVar = this.ayh;
            jVar.axf = elapsedRealtime - jVar.axl;
            if (as(jVar.axd)) {
                j jVar2 = this.ayh;
                jVar2.axe = jVar2.axf - jVar2.axd;
            }
            em("info.request_create_cost:" + this.ayh.axf);
            em("info.requestAddParamsCost:" + this.ayh.axe);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: EY, reason: merged with bridge method [inline-methods] */
    public d ER() {
        if (as(this.ayd)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.aye = elapsedRealtime;
            this.ayh.axq = elapsedRealtime - this.ayd;
            em("info.response_parse_cost:" + this.ayh.axq);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: EZ, reason: merged with bridge method [inline-methods] */
    public d ES() {
        if (as(this.aye)) {
            this.ayh.axx = SystemClock.elapsedRealtime() - this.aye;
            Fa();
            em("info.response_done_cost:" + this.ayh.axx);
        }
        return this;
    }

    private void Fa() {
        j jVar = this.ayh;
        if (jVar != null && jVar.axw == 1 && !av(jVar.axx)) {
            this.ayh.axx = -1L;
        }
    }

    private d Fb() {
        this.ayh.axA = (int) com.kwad.sdk.ip.direct.a.Ji();
        this.ayh.axB = (int) com.kwad.sdk.ip.direct.a.Jj();
        this.ayh.axC = (int) com.kwad.sdk.ip.direct.a.Jk();
        return this;
    }

    private void Fc() {
        i c = c(this.ayh);
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(c);
        }
        com.kwad.sdk.core.e.c.d("NetworkMonitorRecorder", "reportError" + c.toJson().toString());
    }

    private static boolean as(long j) {
        return j != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: at, reason: merged with bridge method [inline-methods] */
    public d ar(long j) {
        this.ayh.axr = j;
        em("responseSize:" + j);
        return this;
    }

    private d au(long j) {
        this.ayh.axt = j;
        em("totalCost:" + j);
        return this;
    }

    private static boolean av(long j) {
        return j >= 50;
    }

    private static boolean c(@NonNull i iVar) {
        if (TextUtils.isEmpty(iVar.url)) {
            return true;
        }
        String lowerCase = iVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dj, reason: merged with bridge method [inline-methods] */
    public d df(int i) {
        this.ayh.httpCode = i;
        em("http_code:" + i);
        return this;
    }

    private d dk(int i) {
        this.ayh.axw = i;
        em("hasData:" + i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: dl, reason: merged with bridge method [inline-methods] */
    public d dh(int i) {
        this.ayh.result = i;
        em("result:" + i);
        return this;
    }

    private static void em(String str) {
        if (aya) {
            com.kwad.sdk.core.e.c.d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: en, reason: merged with bridge method [inline-methods] */
    public d eh(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.ayh.url = str;
        if (str.contains(LocationInfo.NA)) {
            String[] split = str.split("\\?");
            if (split.length > 0) {
                str = split[0];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            em("url:" + str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eo, reason: merged with bridge method [inline-methods] */
    public d ei(String str) {
        try {
            this.ayh.host = Uri.parse(str).getHost();
            em("host:" + this.ayh.host);
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.e("NetworkMonitorRecorder", Log.getStackTraceString(e));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: ep, reason: merged with bridge method [inline-methods] */
    public d ej(String str) {
        this.ayh.errorMsg = str;
        em(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: eq, reason: merged with bridge method [inline-methods] */
    public d ek(String str) {
        this.ayh.axb = str;
        em("reqType:" + str);
        es(com.kwad.sdk.ip.direct.a.Jh());
        Fb();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* renamed from: er, reason: merged with bridge method [inline-methods] */
    public d el(String str) {
        this.ayh.axv = str;
        em("requestId:" + str);
        return this;
    }

    private d es(String str) {
        this.ayh.axy = str;
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b EQ() {
        if (as(this.ayh.axl)) {
            this.ayh.axd = SystemClock.elapsedRealtime() - this.ayh.axl;
            em("info.request_prepare_cost:" + this.ayh.axd);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final /* synthetic */ b dg(int i) {
        return dk(1);
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b di(int i) {
        j jVar = this.ayh;
        jVar.axz = i;
        if (i != 0) {
            jVar.axc = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final void report() {
        long j;
        if (c((i) this.ayh)) {
            return;
        }
        if (this.ayh.httpCode != 200) {
            Fc();
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (as(this.ayh.axl)) {
            j = elapsedRealtime - this.ayh.axl;
        } else {
            j = -1;
        }
        au(j);
        if (j <= 30000 && j > -1) {
            k kVar = (k) ServiceProvider.get(k.class);
            if (kVar != null) {
                kVar.a(this.ayh);
            }
            em("report normal" + this.ayh.toString());
        }
    }

    private static i c(j jVar) {
        i iVar = new i();
        iVar.errorMsg = jVar.errorMsg;
        iVar.host = jVar.host;
        iVar.httpCode = jVar.httpCode;
        iVar.axb = jVar.axb;
        iVar.url = jVar.url;
        iVar.axc = jVar.axc;
        return iVar;
    }
}
