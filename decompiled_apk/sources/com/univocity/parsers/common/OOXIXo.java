package com.univocity.parsers.common;

import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes13.dex */
public abstract class OOXIXo implements Cloneable {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final char[] f27044OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final String f27045oI0IIXIo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public char f27046IXxxXO = '\n';

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public char f27048Oxx0xo = '#';

    /* renamed from: Oo, reason: collision with root package name */
    public char[] f27047Oo = (char[]) f27044OxxIIOOXO.clone();

    /* renamed from: XO, reason: collision with root package name */
    public String f27049XO = f27045oI0IIXIo;

    static {
        String property = System.getProperty("line.separator");
        if (property == null) {
            f27045oI0IIXIo = "\n";
        } else {
            f27045oI0IIXIo = property;
        }
        f27044OxxIIOOXO = f27045oI0IIXIo.toCharArray();
    }

    public static char[] II0XooXoX() {
        return (char[]) f27044OxxIIOOXO.clone();
    }

    public static String oxoX(Object obj) {
        if (obj instanceof Character) {
            char charValue = ((Character) obj).charValue();
            if (charValue != 0) {
                if (charValue != '\r') {
                    if (charValue != '\t') {
                        if (charValue != '\n') {
                            return obj.toString();
                        }
                        return "\\n";
                    }
                    return "\\t";
                }
                return "\\r";
            }
            return "\\0";
        }
        if (obj instanceof String) {
            String str = (String) obj;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                sb.append(oxoX(Character.valueOf(str.charAt(i))));
            }
            obj = sb.toString();
        }
        if (String.valueOf(obj).trim().isEmpty()) {
            return "'" + obj + '\'';
        }
        return String.valueOf(obj);
    }

    public abstract TreeMap<String, Object> I0Io();

    public char II0xO0() {
        return this.f27048Oxx0xo;
    }

    public void OOXIXo(char c) {
        this.f27048Oxx0xo = c;
    }

    public char Oxx0IOOO() {
        return this.f27046IXxxXO;
    }

    public char[] X0o0xo() {
        return (char[]) this.f27047Oo.clone();
    }

    public String XO() {
        return this.f27049XO;
    }

    @Override // 
    /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
    public OOXIXo clone() {
        try {
            return (OOXIXo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Error cloning format object", e);
        }
    }

    public void oOoXoXO(String str) {
        if (str != null && !str.isEmpty()) {
            ooOOo0oXI(str.toCharArray());
            return;
        }
        throw new IllegalArgumentException("Line separator cannot be empty");
    }

    public void ooOOo0oXI(char[] cArr) {
        if (cArr != null && cArr.length != 0) {
            if (cArr.length <= 2) {
                this.f27047Oo = cArr;
                this.f27049XO = new String(cArr);
                return;
            } else {
                throw new IllegalArgumentException("Invalid line separator. Up to 2 characters are expected. Got " + cArr.length + " characters.");
            }
        }
        throw new IllegalArgumentException("Invalid line separator. Expected 1 to 2 characters");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(':');
        TreeMap<String, Object> I0Io2 = I0Io();
        I0Io2.put("Comment character", Character.valueOf(this.f27048Oxx0xo));
        I0Io2.put("Line separator sequence", this.f27049XO);
        I0Io2.put("Line separator (normalized)", Character.valueOf(this.f27046IXxxXO));
        for (Map.Entry<String, Object> entry : I0Io2.entrySet()) {
            sb.append("\n\t\t");
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(oxoX(entry.getValue()));
        }
        return sb.toString();
    }

    public void x0XOIxOo(char c) {
        this.f27046IXxxXO = c;
    }

    public boolean xoIox(char c) {
        if (this.f27046IXxxXO == c) {
            return true;
        }
        return false;
    }

    public boolean xxIXOIIO(char c) {
        if (this.f27048Oxx0xo == c) {
            return true;
        }
        return false;
    }
}
