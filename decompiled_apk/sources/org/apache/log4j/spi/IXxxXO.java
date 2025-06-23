package org.apache.log4j.spi;

import java.io.PrintWriter;
import java.util.Vector;

/* loaded from: classes6.dex */
public class IXxxXO extends PrintWriter {

    /* renamed from: XO, reason: collision with root package name */
    public Vector f33490XO;

    public IXxxXO() {
        super(new xoIox());
        this.f33490XO = new Vector();
    }

    public String[] oIX0oI() {
        int size = this.f33490XO.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = (String) this.f33490XO.elementAt(i);
        }
        return strArr;
    }

    @Override // java.io.PrintWriter
    public void print(Object obj) {
        this.f33490XO.addElement(obj.toString());
    }

    @Override // java.io.PrintWriter
    public void println(Object obj) {
        this.f33490XO.addElement(obj.toString());
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] cArr) {
        this.f33490XO.addElement(new String(cArr));
    }

    @Override // java.io.PrintWriter
    public void print(char[] cArr) {
        this.f33490XO.addElement(new String(cArr));
    }

    @Override // java.io.PrintWriter
    public void println(char[] cArr) {
        this.f33490XO.addElement(new String(cArr));
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        this.f33490XO.addElement(new String(cArr, i, i2));
    }

    @Override // java.io.PrintWriter
    public void print(String str) {
        this.f33490XO.addElement(str);
    }

    @Override // java.io.PrintWriter
    public void println(String str) {
        this.f33490XO.addElement(str);
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String str, int i, int i2) {
        this.f33490XO.addElement(str.substring(i, i2 + i));
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String str) {
        this.f33490XO.addElement(str);
    }
}
