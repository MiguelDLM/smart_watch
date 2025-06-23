package com.baidu.ar;

import android.text.TextUtils;
import com.baidu.ar.bean.ARCaseBundleInfo;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.callback.IError;
import com.baidu.ar.ihttp.Downloader;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.IProgressCallback;
import java.io.File;

/* loaded from: classes7.dex */
class je extends gr<String, Void> {
    private IProgressCallback oe;
    private ARCaseBundleInfo zW;
    private String zX;
    private jc zY;

    public je(ARCaseBundleInfo aRCaseBundleInfo, String str, jc jcVar, IProgressCallback iProgressCallback) {
        this.zW = aRCaseBundleInfo;
        this.zX = str;
        this.zY = jcVar;
        this.oe = iProgressCallback;
    }

    private String a(jh jhVar) {
        StringBuilder sb;
        String str;
        String parent = new File(this.zW.caseDir).getParent();
        if ("gzip".equalsIgnoreCase(jhVar.Aj)) {
            str = String.format("/temp/%s.zip", jhVar.Ai);
            sb = new StringBuilder();
            sb.append(parent);
        } else {
            if (!"identity".equalsIgnoreCase(jhVar.Aj)) {
                return null;
            }
            sb = new StringBuilder();
            sb.append(parent);
            sb.append(File.separator);
            str = jhVar.Ah;
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // com.baidu.ar.gr
    public void cK() {
    }

    @Override // com.baidu.ar.gr
    public void a(String str, ICallbackWith<Void> iCallbackWith, IError iError) {
        if (TextUtils.isEmpty(str)) {
            iError.onError(2, "res url is not exists", null);
            return;
        }
        if ("local".equals(str)) {
            iCallbackWith.run(null);
            return;
        }
        jh bN = this.zY.bN(this.zX);
        if (bN == null) {
            iError.onError(2, "res is not exists", null);
            return;
        }
        String a2 = a(bN);
        if (a2 == null) {
            iError.onError(2, "未知的资源encoding", null);
            return;
        }
        Downloader downloader = new Downloader(str);
        try {
            int fileSize = downloader.getFileSize();
            if (!a(a2, bN, fileSize)) {
                try {
                    downloader.download(a2, this.oe);
                    if (!a(a2, bN, fileSize)) {
                        iError.onError(2, "download fail", null);
                        return;
                    }
                } catch (Exception e) {
                    iError.onError(2, e.getMessage(), e);
                    return;
                }
            }
            iCallbackWith.run(null);
        } catch (HttpException e2) {
            iError.onError(2, e2.getMessage(), e2);
        }
    }

    private boolean a(String str, jh jhVar, int i) {
        File file = new File(str);
        if (!file.exists() || file.length() != i) {
            return false;
        }
        if ("gzip".equalsIgnoreCase(jhVar.Aj)) {
            return kx.b(new File(str), new File(this.zW.caseDir).getParentFile());
        }
        return true;
    }
}
