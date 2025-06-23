package com.baidu.navisdk.cmdrequest;

import android.os.Handler;
import com.baidu.navisdk.cmdrequest.b;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public String f6694a;
    public Class<? extends a> b;
    public int c;
    public HashMap<String, Object> d;
    public Handler e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public String k;
    public b.d l;
    public Object m;

    public i() {
        this.d = new HashMap<>();
        this.f = false;
        this.h = 500000;
        this.i = 1;
        this.j = 0;
    }

    public void a(Object obj) {
        this.m = obj;
    }

    public String toString() {
        String obj;
        StringBuilder sb = new StringBuilder("ReqData{");
        sb.append("mCmd='");
        sb.append(this.f6694a);
        sb.append('\'');
        sb.append(", mHandleClass=");
        sb.append(this.b);
        sb.append(", mSubSystem=");
        sb.append(this.c);
        sb.append(", mTag='");
        sb.append(this.k);
        sb.append(", mHandler='");
        sb.append(this.e);
        sb.append(", mHandlerMsgWhat=");
        sb.append(this.g);
        sb.append(", mTimeout=");
        sb.append(this.h);
        sb.append(", mRetryTimes=");
        sb.append(this.i);
        sb.append(", mRetryIntervals=");
        sb.append(this.j);
        sb.append(", mParams=");
        HashMap<String, Object> hashMap = this.d;
        if (hashMap == null) {
            obj = "null";
        } else {
            obj = hashMap.toString();
        }
        sb.append(obj);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public i(String str, int i, Handler handler, int i2, int i3) {
        this.d = new HashMap<>();
        this.f = false;
        this.i = 1;
        this.j = 0;
        this.f6694a = str;
        this.c = i;
        this.e = handler;
        this.g = i2;
        this.h = i3;
        if (handler != null) {
            this.k = handler.getClass().getName();
        }
    }

    public i(Class<? extends a> cls, int i, Handler handler, int i2, int i3) {
        this.d = new HashMap<>();
        this.f = false;
        this.i = 1;
        this.j = 0;
        this.b = cls;
        this.c = i;
        this.e = handler;
        this.g = i2;
        this.h = i3;
        if (handler != null) {
            this.k = handler.getClass().getName();
        }
    }
}
