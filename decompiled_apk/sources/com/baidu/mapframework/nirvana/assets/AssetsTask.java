package com.baidu.mapframework.nirvana.assets;

import android.content.Context;
import com.baidu.mapframework.nirvana.NirvanaTask;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class AssetsTask extends NirvanaTask {
    private final String c;
    private final Context d;
    private int e = 2;
    private InputStream f;

    public AssetsTask(Context context, String str) {
        this.d = context;
        this.c = str;
    }

    public void a(InputStream inputStream) {
        this.f = inputStream;
    }

    public Context b() {
        return this.d;
    }

    public String c() {
        return this.c;
    }

    public InputStream getInputStream() {
        return this.f;
    }

    public void setAccessMode(int i) {
        this.e = i;
    }

    public int a() {
        return this.e;
    }
}
