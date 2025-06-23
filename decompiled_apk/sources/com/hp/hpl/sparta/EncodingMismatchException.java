package com.hp.hpl.sparta;

/* loaded from: classes10.dex */
public class EncodingMismatchException extends ParseException {
    private String declaredEncoding_;

    public EncodingMismatchException(String str, String str2, String str3) {
        super(str, 0, str2.charAt(str2.length() - 1), str2, "encoding '" + str2 + "' declared instead of of " + str3 + " as expected");
        this.declaredEncoding_ = str2;
    }

    public String getDeclaredEncoding() {
        return this.declaredEncoding_;
    }
}
