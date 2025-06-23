package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CPUAggregationManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeCPUAggregationData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class ak extends bj {

    /* renamed from: a, reason: collision with root package name */
    private CPUAggregationManager.CPUAggregationListener f6225a;
    private String q;
    private int r;
    private int s;
    private int t;
    private int[] u;
    private HashMap<String, Object> v;

    public ak(Context context, String str) {
        super(context);
        this.u = new int[]{1098};
        this.q = str;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.k == null) {
            this.l = false;
            return;
        }
        this.l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu_hot");
            this.k.createProdHandler(jSONObject3);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_hot");
            jSONObject.put("appsid", this.q);
            jSONObject.put("pageIndex", this.s);
            jSONObject.put("pageSize", this.r);
            jSONObject.put("channels", this.u);
            if (!TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            jSONObject2.put("timeout", this.t);
            jSONObject2 = k.a(this.v);
            jSONObject2.put("listScene", 503);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i) {
        super.b(str, i);
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f6225a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError(str, i);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void d() {
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f6225a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onExitLp();
        }
    }

    public void a(CPUAggregationManager.CPUAggregationListener cPUAggregationListener) {
        this.f6225a = cPUAggregationListener;
    }

    public void a(int i, int i2, HashMap<String, Object> hashMap) {
        this.s = i;
        this.r = i2;
        this.v = hashMap;
    }

    public void a(int i) {
        this.t = i;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        if (this.f6225a != null) {
            try {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) iOAdEvent.getData().get("cpuHotList")).iterator();
                while (it.hasNext()) {
                    arrayList.add(new NativeCPUAggregationData(this.h, it.next(), this.v));
                }
                this.f6225a.onHotContentLoaded(arrayList);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i, String str) {
        super.a(i, str);
        CPUAggregationManager.CPUAggregationListener cPUAggregationListener = this.f6225a;
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError(str, i);
        }
    }
}
