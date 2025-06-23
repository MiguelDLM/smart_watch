package com.baidu.navisdk.module.operationactivities;

import android.text.TextUtils;

/* loaded from: classes7.dex */
class c {
    public String b;
    public String d;
    public String e;

    /* renamed from: a, reason: collision with root package name */
    public int f7373a = -1;
    public int c = -1;
    public boolean f = false;

    public boolean a() {
        if (this.f7373a > -1 && !TextUtils.isEmpty(this.b) && this.c > -1) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "OperationData{taskId=" + this.f7373a + ", token='" + this.b + "', activityId=" + this.c + ", src='" + this.d + "', isPosting='" + this.f + "', source='" + this.e + "'}";
    }
}
