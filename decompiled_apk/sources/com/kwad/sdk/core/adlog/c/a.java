package com.kwad.sdk.core.adlog.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

@KsJson
/* loaded from: classes11.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public long LJ;
    public String Lh;
    public a.C0845a Li;
    public int OP;

    @NonNull
    public AdTemplate adTemplate;
    public String adnName;
    public int adnType;
    public int apT;
    public JSONObject aqN;
    public int aqO;
    public int aqP;
    public int aqQ;
    public int aqR;
    public String aqS;
    public int aqX;
    public String aqY;
    public int aqZ;
    public int ara;
    public String arc;
    public int ard;
    public int are;
    public String arf;
    public String arg;
    public int arh;
    public int ari;
    public long arj;
    public long ark;
    public int arn;
    public int aro;
    public String arq;
    public int ars;
    public int art;
    public int aru;
    public String arw;
    public int downloadSource;
    public int kl;
    public ac.a kn;
    public double ko;
    public long vA;
    public long aqT = -1;
    public int aqU = -1;
    public long aqV = -1;
    public int aqW = -1;
    public int Lj = 0;
    public String arb = "";
    public int arl = -1;
    public int arm = -1;
    public int downloadStatus = 0;
    public int arp = -1;
    public int Lg = -1;
    public int arr = -1;
    public int adxResult = -1;
    public int Lk = -1;
    public int arv = 0;

    public static a BZ() {
        return new a();
    }

    public final void a(@Nullable h hVar) {
        if (hVar != null) {
            this.arw = hVar.Fv();
        }
    }

    public final a am(long j) {
        this.vA = j;
        return this;
    }

    public final a an(long j) {
        this.LJ = j;
        return this;
    }

    public final void cD(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    this.art = 3;
                    return;
                }
                return;
            }
            this.art = 2;
            return;
        }
        this.art = 1;
    }

    public final a cE(int i) {
        this.kl = i;
        return this;
    }

    public final a cF(int i) {
        this.Lj = i;
        return this;
    }

    public final a cG(int i) {
        this.Lk = i;
        return this;
    }

    public final a cH(int i) {
        this.Lg = i;
        return this;
    }

    public final a cI(int i) {
        this.OP = i;
        return this;
    }

    public final a cJ(int i) {
        this.ard = i;
        return this;
    }

    public final a dl(String str) {
        this.Lh = str;
        return this;
    }

    public final void e(AdTemplate adTemplate, String str, String str2) {
        a.C0845a c0845a = this.Li;
        if (c0845a == null) {
            a.C0845a c0845a2 = new a.C0845a();
            this.Li = c0845a2;
            c0845a2.a(adTemplate, null, null, null);
        } else if (c0845a.aqq == null) {
            c0845a.a(adTemplate, null, null, null);
        }
    }

    public final a a(a.C0845a c0845a) {
        this.Li = c0845a;
        return this;
    }

    public final a e(ac.a aVar) {
        this.kn = aVar;
        return this;
    }
}
