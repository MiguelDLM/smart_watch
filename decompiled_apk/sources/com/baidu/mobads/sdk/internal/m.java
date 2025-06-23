package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class m extends ae {
    private CpuChannelListManager.CpuChannelListListener q;
    private String r;
    private int s;

    public m(Context context) {
        super(context);
    }

    public void a(CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        this.q = cpuChannelListListener;
    }

    public void a(String str, int i) {
        this.r = str;
        this.s = i;
    }

    @Override // com.baidu.mobads.sdk.internal.ae, com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.k == null) {
            this.l = false;
            return;
        }
        this.l = true;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_CPU);
            this.k.createProdHandler(jSONObject2);
            n nVar = new n(this);
            this.k.addEventListener(x.aq, nVar);
            this.k.addEventListener(x.ar, nVar);
            jSONObject.put("appsid", this.r);
            jSONObject.put("subChannelId", this.s);
            jSONObject.put("event_type", "cpu_channelIds");
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(jSONObject);
    }
}
