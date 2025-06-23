package com.baidu.ar.content;

import android.content.Context;
import com.baidu.ar.callback.ICancellable;
import com.baidu.ar.cu;
import com.baidu.ar.cv;
import com.baidu.ar.cw;
import com.baidu.ar.cx;
import com.baidu.ar.cy;
import com.baidu.ar.cz;
import com.baidu.ar.da;
import com.baidu.ar.gu;
import com.baidu.ar.ihttp.IProgressCallback;
import java.util.List;

/* loaded from: classes7.dex */
public class ContentCloud implements IContentPlatform {
    private Context mContext;
    private ARResourceManager oa;
    private cx od;

    public ContentCloud(Context context) {
        this(context, null);
    }

    @Override // com.baidu.ar.content.IContentPlatform
    public ICancellable checkCaseUpdate(String str, cv cvVar) {
        return gu.b(new cz(this.mContext, this.od), new String[]{str, null}).d(new cw(this.oa, cvVar));
    }

    @Override // com.baidu.ar.content.IContentPlatform
    public ICancellable downloadCase(String str, IRequestCallback<IARCaseInfo> iRequestCallback, IProgressCallback iProgressCallback) {
        return gu.b(new cz(this.mContext, this.od), new String[]{str, null}).d(new cy(this.oa, iProgressCallback)).d(new cu(iRequestCallback));
    }

    public String getCasePath(String str) {
        return this.oa.getCaseDirPath(str);
    }

    public ARResourceManager getResManager() {
        return this.oa;
    }

    @Override // com.baidu.ar.content.IContentPlatform
    public ICancellable queryRecommendCases(String str, IRequestCallback<List<IARCaseInfo>> iRequestCallback) {
        return gu.b(new da(this.mContext), str).d(new cu(iRequestCallback));
    }

    public void release() {
        this.mContext = null;
        this.oa = null;
        this.od = null;
    }

    public ContentCloud(Context context, ARResourceManager aRResourceManager) {
        this.mContext = context.getApplicationContext();
        if (aRResourceManager == null) {
            this.oa = new ARResourceManager(this.mContext);
        } else {
            this.oa = aRResourceManager;
        }
    }

    @Override // com.baidu.ar.content.IContentPlatform
    public ICancellable downloadCase(String str, String str2, IRequestCallback<IARCaseInfo> iRequestCallback, IProgressCallback iProgressCallback) {
        return gu.b(new cz(this.mContext, this.od), new String[]{str, str2}).d(new cy(this.oa, iProgressCallback)).d(new cu(iRequestCallback));
    }

    public ContentCloud(Context context, String str, String str2) {
        this.mContext = context.getApplicationContext();
        cx cxVar = new cx();
        this.od = cxVar;
        cxVar.appId = str;
        cxVar.oc = str2;
        this.oa = new ARResourceManager(this.mContext);
    }
}
