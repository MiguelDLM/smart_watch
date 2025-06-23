package com.baidu.ar;

import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.content.ARResourceInfo;
import com.baidu.ar.content.ARResourceManager;
import com.baidu.ar.content.IARCaseInfo;
import com.baidu.ar.ihttp.Downloader;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.statistic.StatisticApi;
import com.baidu.ar.statistic.StatisticConstants;
import java.io.IOException;

/* loaded from: classes7.dex */
public class cw extends gr<ARResourceInfo, IARCaseInfo> {
    ARResourceManager oa;
    private cv ob;

    public cw(ARResourceManager aRResourceManager, cv cvVar) {
        this.oa = aRResourceManager;
        this.ob = cvVar;
    }

    @Override // com.baidu.ar.gr
    public void a(ARResourceInfo aRResourceInfo, ICallbackWith<IARCaseInfo> iCallbackWith, IError iError) {
        if (this.ob == null) {
            return;
        }
        String[] strArr = aRResourceInfo.multiResourceUrl;
        if (strArr == null || strArr.length == 0) {
            iError.onError(104, "resource url is not exists", null);
            return;
        }
        try {
            int fileSize = new Downloader(strArr[0]).getFileSize();
            if (a(aRResourceInfo, fileSize, iCallbackWith)) {
                this.ob.a(aRResourceInfo.arKey, false, 0.0f);
            } else {
                this.ob.a(aRResourceInfo.arKey, true, fileSize);
            }
        } catch (HttpException e) {
            iError.onError(104, e.getMessage(), e);
        }
    }

    @Override // com.baidu.ar.gr
    public void cK() {
    }

    public boolean a(ARResourceInfo aRResourceInfo, int i, ICallbackWith<IARCaseInfo> iCallbackWith) {
        return a(aRResourceInfo, i, true, iCallbackWith);
    }

    public boolean a(ARResourceInfo aRResourceInfo, int i, boolean z, ICallbackWith<IARCaseInfo> iCallbackWith) {
        if (!this.oa.hasValidResource(aRResourceInfo, i)) {
            return false;
        }
        if (z) {
            try {
                this.oa.unzipResource(aRResourceInfo);
            } catch (IOException unused) {
                StatisticApi.onEvent(StatisticConstants.FIRST_LOAD_FILE_MANAGE_FAILURE);
                return false;
            }
        }
        ARCaseBundleInfo aRCaseBundleInfo = new ARCaseBundleInfo();
        aRCaseBundleInfo.arKey = aRResourceInfo.arKey;
        aRCaseBundleInfo.arType = ARType.valueOf(aRResourceInfo.arType);
        aRCaseBundleInfo.caseDir = this.oa.getCaseResourceDirPath(aRResourceInfo);
        aRResourceInfo.caseBundleInfo = aRCaseBundleInfo;
        StatisticApi.onEvent(StatisticConstants.FIRST_LOAD_FILE_MANAGE_SUCCESS);
        iCallbackWith.run(aRResourceInfo);
        return true;
    }
}
