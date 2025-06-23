package com.kwad.sdk.core.diskcache;

import androidx.annotation.NonNull;
import com.huawei.hms.ads.dynamicloader.b;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ax;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes11.dex */
public class ApkCacheManager {
    private Future ajZ;
    private File auL;
    private final ExecutorService auM;
    private final Callable<Void> auN;

    /* loaded from: classes11.dex */
    public enum Holder {
        INSTANCE;

        private ApkCacheManager mInstance = new ApkCacheManager(0);

        Holder() {
        }

        public final ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    public /* synthetic */ ApkCacheManager(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean DA() {
        File file = this.auL;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.auL.listFiles();
        if (listFiles.length > 5) {
            if (listFiles.length > 10 || l(this.auL) > 400) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static ApkCacheManager getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(File file) {
        if (file != null && file.exists()) {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        h(file2);
                    }
                    file.delete();
                    return;
                }
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
    }

    private int l(File file) {
        return (int) ((((float) m(file)) / 1000.0f) / 1000.0f);
    }

    private long m(File file) {
        long length;
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            int length2 = listFiles.length;
            for (int i = 0; i < length2; i++) {
                if (listFiles[i].isDirectory()) {
                    length = m(listFiles[i]);
                } else {
                    length = listFiles[i].length();
                }
                j += length;
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> n(@NonNull File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        v(arrayList);
        return arrayList;
    }

    private void v(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
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

    public final void DB() {
        File file = this.auL;
        if (file != null && file.exists()) {
            Future future = this.ajZ;
            if (future == null || future.isDone()) {
                this.ajZ = this.auM.submit(this.auN);
            }
        }
    }

    private ApkCacheManager() {
        this.auM = GlobalThreadPools.Gu();
        this.auN = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: DC, reason: merged with bridge method [inline-methods] */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    try {
                        try {
                        } finally {
                        }
                    } catch (Throwable unused) {
                    }
                    if (ApkCacheManager.this.auL != null && ApkCacheManager.this.auL.exists() && !ApkCacheManager.this.DA()) {
                        ApkCacheManager apkCacheManager = ApkCacheManager.this;
                        for (File file : apkCacheManager.n(apkCacheManager.auL)) {
                            if (file.getName().endsWith(b.b)) {
                                ApkCacheManager.this.h(file);
                                if (ApkCacheManager.this.DA()) {
                                    return null;
                                }
                            }
                        }
                        return null;
                    }
                    return null;
                }
            }
        };
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        try {
            this.auL = ax.cZ(((f) ServiceProvider.get(f.class)).getContext());
        } catch (Throwable unused) {
        }
    }
}
