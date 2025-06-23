package com.kwad.components.ad.reward.l.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private b xG = new b();
    private final C0759a xH = new C0759a(d.CQ());

    /* renamed from: com.kwad.components.ad.reward.l.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0759a extends com.kwad.components.ad.reward.l.b {
        public C0759a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            this.xE = String.format("进阶奖励：浏览详情页 %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.xF = String.format("进阶奖励：浏览详情页 %ss", sb2.toString());
        }
    }

    /* loaded from: classes11.dex */
    public static class b extends com.kwad.components.ad.reward.l.b {
        public b() {
            this.xE = "基础奖励：观看视频";
            this.xF = "基础奖励：需再观看%ss视频";
        }
    }

    private void jD() {
        if (this.xH.isCompleted()) {
            jt();
        } else {
            ju();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.xH.isCompleted();
    }

    public final void jB() {
        c.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.xG.jt();
        jD();
    }

    public final boolean jC() {
        return this.xG.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<com.kwad.components.ad.reward.l.c> jr() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.xG);
        arrayList.add(this.xH);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int js() {
        Iterator<com.kwad.components.ad.reward.l.c> it = jr().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i++;
            }
        }
        return i;
    }

    public final void markOpenNsCompleted() {
        c.d("LandPageOpenTask", "markOpenNsCompleted");
        this.xH.jt();
        jD();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xG.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.xH.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "mWatchVideoTask", this.xG);
        t.a(jSONObject, "mOpenNsTask", this.xH);
        return jSONObject;
    }
}
