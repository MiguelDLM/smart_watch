package com.baidu.navisdk.skyeye.log;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f8005a = -1;
    public boolean b = false;
    public int c = 0;
    public long d = 0;
    public int e = -1;
    public long f = -1;
    public int g = 0;
    public int h = 0;
    public b i;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f8005a = jSONObject.optInt("id", 0);
        boolean z = true;
        if (jSONObject.optInt("open", 0) != 1) {
            z = false;
        }
        this.b = z;
        this.e = jSONObject.optInt("dur", -1);
        this.c = jSONObject.optInt("level", 0);
        this.d = jSONObject.optLong("tag", 0L);
        this.g = jSONObject.optInt("rcsize", 200);
        this.h = jSONObject.optInt("rptype", 0);
        this.f = jSONObject.optLong("deadline", -1L);
        JSONObject optJSONObject = jSONObject.optJSONObject("rpconfig");
        if (optJSONObject != null) {
            b bVar = new b();
            this.i = bVar;
            bVar.a(optJSONObject);
        }
    }

    @NonNull
    public String toString() {
        String bVar;
        StringBuilder sb = new StringBuilder();
        sb.append("mId");
        sb.append(this.f8005a);
        sb.append("isOpen");
        sb.append(this.b);
        sb.append("mLevelSwitcher");
        sb.append(this.c);
        sb.append("mTagSwitcher");
        sb.append(this.d);
        sb.append("mMaxRecordSize");
        sb.append(this.g);
        sb.append("mReportType");
        sb.append(this.h);
        sb.append("mDeadlineTime");
        sb.append(this.f);
        sb.append("mReportConfig");
        b bVar2 = this.i;
        if (bVar2 == null) {
            bVar = "null";
        } else {
            bVar = bVar2.toString();
        }
        sb.append(bVar);
        return sb.toString();
    }
}
