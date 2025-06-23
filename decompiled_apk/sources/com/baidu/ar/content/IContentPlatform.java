package com.baidu.ar.content;

import com.baidu.ar.callback.ICancellable;
import com.baidu.ar.cv;
import com.baidu.ar.ihttp.IProgressCallback;
import java.util.List;

/* loaded from: classes7.dex */
public interface IContentPlatform {
    ICancellable checkCaseUpdate(String str, cv cvVar);

    ICancellable downloadCase(String str, IRequestCallback<IARCaseInfo> iRequestCallback, IProgressCallback iProgressCallback);

    ICancellable downloadCase(String str, String str2, IRequestCallback<IARCaseInfo> iRequestCallback, IProgressCallback iProgressCallback);

    ICancellable queryRecommendCases(String str, IRequestCallback<List<IARCaseInfo>> iRequestCallback);
}
