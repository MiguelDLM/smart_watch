package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Arrays;

/* loaded from: classes11.dex */
public class DownloadShortInfo {
    public String fileName;
    public boolean onlyWifi;
    public long id = -1;
    public int status = -1;
    public long totalBytes = -1;
    public long currentBytes = -1;
    public int failStatus = 0;

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if ((obj instanceof DownloadShortInfo) && obj != null) {
            DownloadShortInfo downloadShortInfo = (DownloadShortInfo) obj;
            if (this.id == downloadShortInfo.id) {
                z = true;
            } else {
                z = false;
            }
            if (this.status == downloadShortInfo.status) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.totalBytes == downloadShortInfo.totalBytes) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((TextUtils.isEmpty(this.fileName) && TextUtils.isEmpty(downloadShortInfo.fileName)) || (!TextUtils.isEmpty(this.fileName) && !TextUtils.isEmpty(downloadShortInfo.fileName) && this.fileName.equals(downloadShortInfo.fileName))) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z || !z2 || !z3 || !z4) {
                return false;
            }
            return true;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.id), Integer.valueOf(this.status), Long.valueOf(this.totalBytes), this.fileName});
    }

    public void updateFromNewDownloadInfo(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.id = downloadInfo.getId();
        this.status = downloadInfo.getStatus();
        this.currentBytes = downloadInfo.getCurBytes();
        this.totalBytes = downloadInfo.getTotalBytes();
        this.fileName = downloadInfo.getTargetFilePath();
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException != null) {
            this.failStatus = failedException.getErrorCode();
        } else {
            this.failStatus = 0;
        }
        this.onlyWifi = downloadInfo.isOnlyWifi();
    }
}
