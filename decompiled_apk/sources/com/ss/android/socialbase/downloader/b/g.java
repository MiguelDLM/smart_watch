package com.ss.android.socialbase.downloader.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.i.i;

/* loaded from: classes13.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f26234a;
    private final String b;
    private final String[] c;
    private final String[] d;
    private SQLiteStatement e;
    private SQLiteStatement f;
    private SQLiteStatement g;
    private SQLiteStatement h;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f26234a = sQLiteDatabase;
        this.b = str;
        this.c = strArr;
        this.d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.e == null) {
            SQLiteStatement compileStatement = this.f26234a.compileStatement(i.a("INSERT INTO ", this.b, this.c));
            synchronized (this) {
                try {
                    if (this.e == null) {
                        this.e = compileStatement;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.e;
    }

    public SQLiteStatement b() {
        if (this.g == null) {
            SQLiteStatement compileStatement = this.f26234a.compileStatement(i.a(this.b, this.d));
            synchronized (this) {
                try {
                    if (this.g == null) {
                        this.g = compileStatement;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.g;
    }

    public SQLiteStatement c() {
        if (this.f == null) {
            SQLiteStatement compileStatement = this.f26234a.compileStatement(i.a(this.b, this.c, this.d));
            synchronized (this) {
                try {
                    if (this.f == null) {
                        this.f = compileStatement;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f;
    }

    public SQLiteStatement d() {
        if (this.h == null) {
            SQLiteStatement compileStatement = this.f26234a.compileStatement(i.b(this.b, this.c, this.d));
            synchronized (this) {
                try {
                    if (this.h == null) {
                        this.h = compileStatement;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.h;
    }
}
