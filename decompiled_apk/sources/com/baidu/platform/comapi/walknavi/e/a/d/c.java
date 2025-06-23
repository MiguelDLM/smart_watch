package com.baidu.platform.comapi.walknavi.e.a.d;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9726a;

    public c(b bVar) {
        this.f9726a = bVar;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.getName().endsWith(".so");
    }
}
