package com.baidu.navisdk.behavrules;

import android.os.Environment;
import java.io.File;

/* loaded from: classes7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private File f6648a;

    public f() {
        File file = new File(a() + "/sceneguide");
        this.f6648a = file;
        if (!file.exists()) {
            this.f6648a.mkdirs();
        }
    }

    private String a() {
        if (Environment.getExternalStorageState().equalsIgnoreCase("mounted")) {
            return Environment.getExternalStorageDirectory().toString();
        }
        return null;
    }

    public com.baidu.navisdk.behavrules.scene.d a(String str, a aVar) {
        return new b().a(str, aVar);
    }
}
