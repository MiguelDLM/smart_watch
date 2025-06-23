package com.baidu.platform.core.e;

import com.baidu.mapapi.search.recommendstop.OnGetRecommendStopResultListener;
import com.baidu.mapapi.search.recommendstop.RecommendStopSearchOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
public class b extends com.baidu.platform.base.a implements a {
    private OnGetRecommendStopResultListener b = null;

    @Override // com.baidu.platform.core.e.a
    public boolean a(RecommendStopSearchOption recommendStopSearchOption) {
        c cVar = new c();
        cVar.a(SearchType.RECOMMEND_STOP);
        return a(new d(recommendStopSearchOption), this.b, cVar);
    }

    @Override // com.baidu.platform.core.e.a
    public void a(OnGetRecommendStopResultListener onGetRecommendStopResultListener) {
        this.f9526a.lock();
        this.b = onGetRecommendStopResultListener;
        this.f9526a.unlock();
    }

    @Override // com.baidu.platform.core.e.a
    public void a() {
        this.f9526a.lock();
        this.b = null;
        this.f9526a.unlock();
    }
}
