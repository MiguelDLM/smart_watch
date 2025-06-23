package com.baidu.ar;

import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.content.ARResourceInfo;
import com.baidu.ar.content.ARResourceManager;
import com.baidu.ar.content.IARCaseInfo;
import com.baidu.ar.ihttp.Downloader;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;

/* loaded from: classes7.dex */
public class cy extends cw {
    private IProgressCallback oe;

    public cy(ARResourceManager aRResourceManager, IProgressCallback iProgressCallback) {
        super(aRResourceManager, null);
        this.oe = iProgressCallback;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.ar.cw, com.baidu.ar.gr
    public void a(ARResourceInfo aRResourceInfo, ICallbackWith<IARCaseInfo> iCallbackWith, IError iError) {
        String[] strArr = aRResourceInfo.multiResourceUrl;
        if (strArr == null || strArr.length == 0) {
            iError.onError(102, "resource url is not exists", null);
            return;
        }
        Downloader downloader = new Downloader(strArr[0]);
        try {
            int fileSize = downloader.getFileSize();
            kf.u("DownloadARResourceHandler", "check new version case begin");
            boolean a2 = a(aRResourceInfo, fileSize, false, iCallbackWith);
            kf.u("DownloadARResourceHandler", "check new version case: hasValid:" + a2);
            if (a2) {
                return;
            }
            String caseMainZipFile = this.oa.getCaseMainZipFile(aRResourceInfo);
            kf.u("DownloadARResourceHandler", "start downloading new version case: versionCode=" + aRResourceInfo.versionCode);
            try {
                downloader.download(caseMainZipFile, this.oe);
                StatisticApi.onEvent(StatisticConstants.LOAD_DOWNLOAD_SUCCESS);
                if (a(aRResourceInfo, fileSize, iCallbackWith)) {
                    return;
                }
                iError.onError(102, "unzip fail", null);
            } catch (Exception e) {
                StatisticApi.onEvent(StatisticConstants.LOAD_DOWNLOAD_FAILURE);
                iError.onError(102, e.getMessage(), e);
            }
        } catch (HttpException e2) {
            iError.onError(102, e2.getMessage(), e2);
        }
    }

    @Override // com.baidu.ar.cw, com.baidu.ar.gr
    public void cK() {
    }
}
