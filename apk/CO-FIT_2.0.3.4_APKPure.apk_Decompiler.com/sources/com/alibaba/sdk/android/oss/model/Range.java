package com.alibaba.sdk.android.oss.model;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;

public class Range {
    public static final long INFINITE = -1;
    private long begin;
    private long end;

    public Range(long j, long j2) {
        setBegin(j);
        setEnd(j2);
    }

    public boolean checkIsValid() {
        long j = this.begin;
        if (j >= -1) {
            long j2 = this.end;
            if (j2 >= -1) {
                if (j < 0 || j2 < 0 || j <= j2) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public long getBegin() {
        return this.begin;
    }

    public long getEnd() {
        return this.end;
    }

    public void setBegin(long j) {
        this.begin = j;
    }

    public void setEnd(long j) {
        this.end = j;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        long j = this.begin;
        String str2 = "";
        if (j == -1) {
            str = str2;
        } else {
            str = String.valueOf(j);
        }
        sb.append(str);
        sb.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        long j2 = this.end;
        if (j2 != -1) {
            str2 = String.valueOf(j2);
        }
        sb.append(str2);
        return sb.toString();
    }
}
