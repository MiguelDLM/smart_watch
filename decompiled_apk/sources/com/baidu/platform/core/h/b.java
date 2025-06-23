package com.baidu.platform.core.h;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.baidu.platform.base.SearchType;

/* loaded from: classes8.dex */
public class b extends com.baidu.platform.base.a implements a {
    private OnGetSuggestionResultListener b = null;

    @Override // com.baidu.platform.core.h.a
    public boolean a(SuggestionSearchOption suggestionSearchOption) {
        c cVar = new c();
        cVar.a(SearchType.SUGGESTION_SEARCH_TYPE);
        return a(new d(suggestionSearchOption), this.b, cVar);
    }

    @Override // com.baidu.platform.core.h.a
    public void a(OnGetSuggestionResultListener onGetSuggestionResultListener) {
        this.f9526a.lock();
        this.b = onGetSuggestionResultListener;
        this.f9526a.unlock();
    }

    @Override // com.baidu.platform.core.h.a
    public void a() {
        this.f9526a.lock();
        this.b = null;
        this.f9526a.unlock();
    }
}
