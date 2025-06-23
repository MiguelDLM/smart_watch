package com.huawei.hms.ads;

import android.os.Process;
import android.util.Log;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.text.SimpleDateFormat;

/* loaded from: classes10.dex */
public class fi {
    private static final String Code = "HA";
    private String C;
    private String I;
    private int S;
    private String V;
    private int Z;
    private long B = 0;
    private final StringBuilder F = new StringBuilder();

    public fi(String str, int i, String str2) {
        this.V = null;
        this.I = Code;
        this.Z = 0;
        this.V = str;
        this.Z = i;
        if (str2 != null) {
            this.I = str2;
        }
        I();
    }

    private fi I() {
        this.B = System.currentTimeMillis();
        this.C = Thread.currentThread().getName();
        this.S = Process.myPid();
        return this;
    }

    public <T> fi Code(T t) {
        this.F.append(t);
        return this;
    }

    public String V() {
        StringBuilder sb = new StringBuilder();
        V(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Code(sb);
        V(sb);
        return sb.toString();
    }

    private StringBuilder V(StringBuilder sb) {
        sb.append(TokenParser.SP);
        sb.append((CharSequence) this.F);
        return sb;
    }

    public fi Code(Throwable th) {
        if (th != null) {
            Code((fi) '\n').Code((fi) Log.getStackTraceString(th));
        }
        return this;
    }

    public String Code() {
        StringBuilder sb = new StringBuilder();
        Code(sb);
        return sb.toString();
    }

    private StringBuilder Code(StringBuilder sb) {
        SimpleDateFormat Code2 = com.huawei.openalliance.ad.utils.w.Code(DateFormatUtils.YYYY_MM_DD_HH_MM_SS_SSS);
        sb.append('[');
        sb.append(Code2.format(Long.valueOf(this.B)));
        String Code3 = ff.Code(this.Z);
        sb.append(TokenParser.SP);
        sb.append(Code3);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(this.V);
        sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb.append(this.I);
        sb.append(TokenParser.SP);
        sb.append(this.S);
        sb.append(':');
        sb.append(this.C);
        sb.append(']');
        return sb;
    }
}
