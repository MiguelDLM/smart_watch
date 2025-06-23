package com.baidu.mapapi.search.recommendstop;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;
import com.baidu.platform.core.e.b;

/* loaded from: classes7.dex */
public class RecommendStopSearch extends n {
    private boolean b = false;

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.platform.core.e.a f5973a = new b();

    private RecommendStopSearch() {
    }

    public static RecommendStopSearch newInstance() {
        BMapManager.init();
        return new RecommendStopSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        com.baidu.platform.core.e.a aVar = this.f5973a;
        if (aVar != null) {
            aVar.a();
        }
        BMapManager.destroy();
    }

    public boolean requestRecommendStop(RecommendStopSearchOption recommendStopSearchOption) {
        if (this.f5973a != null) {
            if (recommendStopSearchOption != null && recommendStopSearchOption.getLocation() != null) {
                return this.f5973a.a(recommendStopSearchOption);
            }
            throw new IllegalStateException("BDMapSDKException: option or location can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: RecommendStopSearch is null, please call newInstance() first.");
    }

    public void setOnGetRecommendStopResultListener(OnGetRecommendStopResultListener onGetRecommendStopResultListener) {
        com.baidu.platform.core.e.a aVar = this.f5973a;
        if (aVar != null) {
            if (onGetRecommendStopResultListener != null) {
                aVar.a(onGetRecommendStopResultListener);
                return;
            }
            throw new IllegalStateException("BDMapSDKException: OnGetRecommendStopResultListener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: RecommendStopSearch is null, please call newInstance() first.");
    }
}
