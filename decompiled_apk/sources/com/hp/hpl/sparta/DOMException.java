package com.hp.hpl.sparta;

/* loaded from: classes10.dex */
public class DOMException extends Exception {
    public static final short DOMSTRING_SIZE_ERR = 2;
    public static final short HIERARCHY_REQUEST_ERR = 3;
    public static final short NOT_FOUND_ERR = 8;
    public short code;

    public DOMException(short s, String str) {
        super(str);
        this.code = s;
    }
}
