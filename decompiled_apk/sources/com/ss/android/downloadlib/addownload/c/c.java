package com.ss.android.downloadlib.addownload.c;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bn;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;

/* loaded from: classes11.dex */
public class c {
    public static void a() {
        List<DownloadInfo> a2 = com.ss.android.socialbase.appdownloader.d.j().a(k.a());
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        for (int i = 0; i < a2.size(); i++) {
            DownloadInfo downloadInfo = a2.get(i);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long lastModified = file.lastModified();
            long a3 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_file_expire_hours", 0) * 3600000;
            if (a3 <= 0) {
                a3 = bn.d;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - lastModified >= a3) {
                a(file);
                Downloader.getInstance(k.a()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void b() {
        List successedDownloadInfosWithMimeType = Downloader.getInstance(k.a()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
        if (successedDownloadInfosWithMimeType != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            for (int i = 0; i < successedDownloadInfosWithMimeType.size(); i++) {
                DownloadInfo downloadInfo = (DownloadInfo) successedDownloadInfosWithMimeType.get(i);
                if (downloadInfo != null) {
                    String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                    File file = new File(str);
                    if (file.exists()) {
                        long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
                        long a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_complete_file_expire_hours", 0) * 3600000;
                        if (a2 <= 0) {
                            a2 = bn.d;
                        }
                        if (currentTimeMillis >= a2 || m.f(k.a(), str)) {
                            a(file);
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            a(externalCacheDir.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.File r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L1a
            java.lang.String r0 = "1"
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16
            r1.write(r0)     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16
            r1.close()     // Catch: java.lang.Throwable -> L13 java.lang.Exception -> L16
            goto L2b
        L13:
            r3 = move-exception
            r0 = r1
            goto L2f
        L16:
            r0 = move-exception
            goto L1e
        L18:
            r3 = move-exception
            goto L2f
        L1a:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L1e:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L2b
            r1.close()     // Catch: java.lang.Exception -> L27
            goto L2b
        L27:
            r0 = move-exception
            r0.printStackTrace()
        L2b:
            r3.delete()
            return
        L2f:
            if (r0 == 0) goto L39
            r0.close()     // Catch: java.lang.Exception -> L35
            goto L39
        L35:
            r0 = move-exception
            r0.printStackTrace()
        L39:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.c.c.a(java.io.File):void");
    }

    private static void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str2 : list) {
                if (str2 != null) {
                    String str3 = File.separator;
                    String str4 = str.endsWith(str3) ? str + str2 : str + str3 + str2;
                    File file2 = new File(str4);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        a(str4);
                    }
                }
            }
            file.delete();
        }
    }
}
