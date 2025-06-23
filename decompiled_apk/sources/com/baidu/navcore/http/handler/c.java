package com.baidu.navcore.http.handler;

import java.io.File;

/* loaded from: classes7.dex */
public abstract class c extends a {
    private File e;

    public c(File file) {
        this.e = file;
    }

    public abstract void a(int i, File file);

    public abstract void a(int i, Throwable th, File file);

    @Override // com.baidu.navcore.http.handler.a
    public void a(int i, byte[] bArr) {
        a(i, this.e);
    }

    @Override // com.baidu.navcore.http.handler.a
    public void a(int i, byte[] bArr, Throwable th) {
        a(i, th, this.e);
    }
}
