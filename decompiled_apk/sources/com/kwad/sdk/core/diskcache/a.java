package com.kwad.sdk.core.diskcache;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import com.huawei.hms.ads.dynamicloader.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.d;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes11.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static PackageInfo a(Context context, File file) {
        if (file != null && file.exists()) {
            try {
                if (file.exists() & (!file.isDirectory())) {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getPath(), 65);
                    if (packageManager.getPackageInfo(packageArchiveInfo.packageName, 1) != null) {
                        return null;
                    }
                    return packageArchiveInfo;
                }
            } catch (Exception e) {
                c.printStackTrace(e);
            }
        }
        return null;
    }

    public static void bh(final Context context) {
        g.schedule(new az() { // from class: com.kwad.sdk.core.diskcache.a.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                File cZ;
                d ys;
                synchronized (a.class) {
                    try {
                        cZ = ax.cZ(context);
                    } catch (Throwable th) {
                        c.printStackTrace(th);
                    }
                    if (!cZ.exists()) {
                        return;
                    }
                    for (File file : a.n(cZ)) {
                        if (file.getName().endsWith(b.b) && com.kwad.sdk.core.a.BK().dc(file.getAbsolutePath()) != null && a.a(context, file) != null && (ys = com.kwad.sdk.c.yq().ys()) != null) {
                            ys.g(file);
                        }
                    }
                }
            }
        }, 10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<File> n(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        v(arrayList);
        return arrayList;
    }

    private static void v(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.a.2
            private static int c(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    if (file.lastModified() == file2.lastModified()) {
                        return 0;
                    }
                    return 1;
                }
                return -1;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return c(file, file2);
            }
        });
    }
}
