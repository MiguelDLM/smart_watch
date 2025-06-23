package com.baidu.mapsdkplatform.comapi.b.a;

import com.baidu.mapsdkplatform.comapi.util.h;
import com.jieli.watchtesttool.tool.upgrade.OTAManager;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f6148a;

    public d(c cVar) {
        this.f6148a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        File[] listFiles;
        String str2;
        if (h.a().b() != null) {
            str = c.f6146a;
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                try {
                    Arrays.sort(listFiles, new e());
                } catch (Exception unused) {
                }
                int length = listFiles.length;
                if (length > 10) {
                    length = 10;
                }
                for (int i = 0; i < length; i++) {
                    File file2 = listFiles[i];
                    if (!file2.isDirectory() && file2.exists() && file2.isFile()) {
                        String name = file2.getName();
                        str2 = c.b;
                        if (name.contains(str2)) {
                            if (file2.getName().endsWith(".txt")) {
                                this.f6148a.a(file2);
                            } else if (file2.getName().endsWith(OTAManager.OTA_ZIP_SUFFIX) && file2.exists()) {
                                this.f6148a.a(file2);
                            }
                        }
                    }
                }
                if (listFiles.length > 10) {
                    this.f6148a.a(listFiles);
                }
            }
        }
    }
}
