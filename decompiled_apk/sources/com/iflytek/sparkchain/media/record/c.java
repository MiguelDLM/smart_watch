package com.iflytek.sparkchain.media.record;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes10.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private RandomAccessFile f17477a;
    private short b;
    private int c;
    private short d;

    public c(File file, int i) throws IOException {
        a(file, (short) 1, i, (short) 16);
    }

    public void a() throws IOException {
        RandomAccessFile randomAccessFile = this.f17477a;
        if (randomAccessFile != null) {
            randomAccessFile.close();
            this.f17477a = null;
        }
    }

    public int b() throws IOException {
        return (int) (this.f17477a.length() - 44);
    }

    public void c() throws IOException {
        this.f17477a.seek(0L);
        a("RIFF");
        a(b() + 36);
        a("WAVE");
        a("fmt ");
        a(16);
        a((short) 1);
        a(this.b);
        a(this.c);
        a(((this.b * this.c) * this.d) / 8);
        a((short) ((this.b * this.d) / 8));
        a(this.d);
        a("data");
        a(b());
    }

    public void a(int i) throws IOException {
        this.f17477a.write(i);
        this.f17477a.write(i >> 8);
        this.f17477a.write(i >> 16);
        this.f17477a.write(i >> 24);
    }

    public void a(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.f17477a.write(str.charAt(i));
        }
    }

    public void a(short s) throws IOException {
        this.f17477a.write(s);
        this.f17477a.write(s >> 8);
    }

    private boolean a(File file, short s, int i, short s2) throws IOException {
        if (file == null) {
            return false;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.f17477a = randomAccessFile;
        this.b = s;
        this.c = i;
        this.d = s2;
        randomAccessFile.write(new byte[44]);
        return true;
    }
}
