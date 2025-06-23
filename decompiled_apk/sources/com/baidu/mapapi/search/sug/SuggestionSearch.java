package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.n;

/* loaded from: classes7.dex */
public class SuggestionSearch extends n {
    private boolean b = false;

    /* renamed from: a, reason: collision with root package name */
    com.baidu.platform.core.h.a f6000a = new com.baidu.platform.core.h.b();

    private SuggestionSearch() {
    }

    public static SuggestionSearch newInstance() {
        BMapManager.init();
        return new SuggestionSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f6000a.a();
        BMapManager.destroy();
    }

    public boolean requestSuggestion(SuggestionSearchOption suggestionSearchOption) {
        com.baidu.platform.core.h.a aVar = this.f6000a;
        if (aVar != null) {
            if (suggestionSearchOption != null && suggestionSearchOption.mKeyword != null && suggestionSearchOption.mCity != null) {
                return aVar.a(suggestionSearchOption);
            }
            throw new IllegalArgumentException("BDMapSDKException: option or keyword or city can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: suggestionsearch is null, please call newInstance() first.");
    }

    public void setOnGetSuggestionResultListener(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        com.baidu.platform.core.h.a aVar = this.f6000a;
        if (aVar != null) {
            if (onGetSuggestionResultListener != null) {
                aVar.a(onGetSuggestionResultListener);
                return;
            }
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: suggestionsearch is null, please call newInstance() first.");
    }
}
