package com.baidu.mshield.rp;

import android.content.Context;

/* loaded from: classes7.dex */
public class Report {
    private static Report mReporter;
    private Context mContext;

    private Report(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized Report getInstance(Context context) {
        Report report;
        synchronized (Report.class) {
            try {
                if (mReporter == null) {
                    mReporter = new Report(context);
                }
                report = mReporter;
            } catch (Throwable th) {
                throw th;
            }
        }
        return report;
    }

    public void fr() {
        try {
            com.baidu.mshield.utility.b.a(this.mContext).e();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void i(String str, String str2, String str3, String str4, String str5) {
        try {
            com.baidu.mshield.utility.a.a(this.mContext, str, str2, str3, str4, str5);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void n() {
        try {
            com.baidu.mshield.utility.b.a(this.mContext).d();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void r(boolean z) {
        try {
            com.baidu.mshield.utility.b.a(this.mContext).a(z);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void s(String str) {
        try {
            com.baidu.mshield.b.c.a.b("send log : " + str);
            com.baidu.mshield.utility.a.a(this.mContext, str);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void sr(String str) {
        try {
            com.baidu.mshield.b.c.a.b("send log : " + str);
            com.baidu.mshield.utility.b.a(this.mContext).a(str);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public void w(String str) {
        try {
            com.baidu.mshield.utility.a.b(this.mContext, str);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }
}
