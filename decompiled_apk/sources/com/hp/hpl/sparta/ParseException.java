package com.hp.hpl.sparta;

import XXO0.oIX0oI;

/* loaded from: classes10.dex */
public class ParseException extends Exception {
    private Throwable cause_;
    private int lineNumber_;

    public ParseException(String str) {
        super(str);
        this.lineNumber_ = -1;
        this.cause_ = null;
    }

    public static String charRepr(int i) {
        if (i == -1) {
            return "EOF";
        }
        return "" + ((char) i);
    }

    private static String toMessage(String str, int i, int i2, String str2, String str3) {
        return str + oIX0oI.I0Io.f4096II0xO0 + i + "): \n" + str2 + "\nLast character read was '" + charRepr(i2) + "'\n" + str3;
    }

    private static String toString(char[] cArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cArr[0]);
        for (int i = 1; i < cArr.length; i++) {
            stringBuffer.append("or " + cArr[i]);
        }
        return stringBuffer.toString();
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause_;
    }

    public int getLineNumber() {
        return this.lineNumber_;
    }

    public ParseException(String str, Throwable th) {
        super(str + " " + th);
        this.lineNumber_ = -1;
        this.cause_ = th;
    }

    public ParseException(String str, int i, int i2, String str2, String str3) {
        super(toMessage(str, i, i2, str2, str3));
        this.cause_ = null;
        this.lineNumber_ = i;
    }

    public ParseException(x0XOIxOo x0xoixoo, String str, int i, int i2, String str2, String str3) {
        this(str, i, i2, str2, str3);
        x0xoixoo.I0Io(str3, str, i);
    }

    public ParseException(oOoXoXO oooxoxo, String str) {
        this(oooxoxo.II0XooXoX(), oooxoxo.oIX0oI(), oooxoxo.II0xO0(), oooxoxo.Oxx0IOOO(), oooxoxo.XO(), str);
    }

    public ParseException(oOoXoXO oooxoxo, char c, char c2) {
        this(oooxoxo, "got '" + c + "' instead of expected '" + c2 + "'");
    }

    public ParseException(oOoXoXO oooxoxo, char c, char[] cArr) {
        this(oooxoxo, "got '" + c + "' instead of " + toString(cArr));
    }

    public ParseException(oOoXoXO oooxoxo, char c, String str) {
        this(oooxoxo, "got '" + c + "' instead of " + str + " as expected");
    }

    public ParseException(oOoXoXO oooxoxo, String str, String str2) {
        this(oooxoxo, "got \"" + str + "\" instead of \"" + str2 + "\" as expected");
    }

    public ParseException(oOoXoXO oooxoxo, String str, char[] cArr) {
        this(oooxoxo, str, new String(cArr));
    }
}
