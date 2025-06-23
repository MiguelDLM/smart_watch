package com.baidu.navisdk.asr.query.sp;

import android.content.Context;
import android.text.TextUtils;
import java.util.Calendar;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private a f6561a;
    private a b;
    private a c;

    public b(Context context) {
        this.f6561a = new a(context, "asr_sp_week");
        this.b = new a(context, "asr_sp_day");
        this.c = new a(context, "asr_sp_navi");
    }

    public void a(String str) {
        this.c.b(str, c(str) + 1);
        this.b.b(str, b(str) + 1);
        this.f6561a.b(str, d(str) + 1);
    }

    public int b(String str) {
        long a2 = this.b.a("day_record_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis / 86400000 != a2 / 86400000) {
            this.b.a();
        }
        this.b.b("day_record_time", currentTimeMillis);
        return this.b.a(str, 0);
    }

    public int c(String str) {
        return this.c.a(str, 0);
    }

    public int d(String str) {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(3);
        if (TextUtils.equals(calendar.get(1) + "_" + i, this.f6561a.a("week_record_time", ""))) {
            this.f6561a.a();
        }
        return this.f6561a.a(str, 0);
    }

    public void a() {
        this.c.a();
    }
}
