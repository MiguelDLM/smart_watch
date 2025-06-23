package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: classes11.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f25962a;
    private Handler b = null;

    public static b a() {
        if (f25962a == null) {
            synchronized (b.class) {
                try {
                    if (f25962a == null) {
                        f25962a = new b();
                    }
                } finally {
                }
            }
        }
        return f25962a;
    }

    public boolean b() {
        if (k.j().optInt("forbid_invalidte_download_file_install", 0) != 1) {
            return false;
        }
        return true;
    }

    public void a(Context context, DownloadInfo downloadInfo) {
        if (b() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.b == null) {
                this.b = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.b.1
                @Override // java.lang.Runnable
                public void run() {
                    k.d().a(3, k.a(), null, "下载失败，请重试！", null, 0);
                    e a2 = com.ss.android.downloadlib.g.a().a(url);
                    if (a2 != null) {
                        a2.g();
                    }
                }
            });
        }
    }
}
