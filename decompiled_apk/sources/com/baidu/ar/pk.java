package com.baidu.ar;

import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class pk implements pj {
    private static final Pattern Jy = Pattern.compile(" ");
    private static final Pattern Jz = Pattern.compile(",");
    private final String JA;

    public pk(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.JA = str;
    }

    @Override // com.baidu.ar.pj
    public boolean cL(String str) {
        for (String str2 : Jz.split(Jy.matcher(str).replaceAll(""))) {
            if (this.JA.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.JA.equals(((pk) obj).JA);
    }

    public int hashCode() {
        return this.JA.hashCode();
    }

    @Override // com.baidu.ar.pj
    public String jO() {
        return this.JA;
    }

    @Override // com.baidu.ar.pj
    public pj jP() {
        return new pk(jO());
    }

    @Override // com.baidu.ar.pj
    public String toString() {
        return jO();
    }
}
