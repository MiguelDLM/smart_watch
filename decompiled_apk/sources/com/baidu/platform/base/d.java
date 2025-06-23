package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    protected SearchType f9529a;

    public abstract SearchResult a(String str);

    public abstract void a(SearchResult searchResult, Object obj);

    public void a(SearchType searchType) {
        this.f9529a = searchType;
    }

    public SearchType a() {
        return this.f9529a;
    }

    public boolean a(String str, SearchResult searchResult, boolean z) {
        int optInt;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (z) {
                        optInt = jSONObject.optInt("status");
                    } else {
                        optInt = jSONObject.optInt("status_sp");
                    }
                    if (optInt == 0) {
                        return false;
                    }
                    if (optInt != 2) {
                        if (optInt == 200 || optInt == 230) {
                            searchResult.error = SearchResult.ERRORNO.KEY_ERROR;
                        } else if (optInt == 10 || optInt == 11) {
                            searchResult.error = SearchResult.ERRORNO.PARAMER_ERROR;
                        } else if (optInt == 40) {
                            searchResult.error = SearchResult.ERRORNO.INVALID_DISTRICT_ID;
                        } else if (optInt != 41 && optInt != 44) {
                            if (optInt != 45) {
                                switch (optInt) {
                                    case 104:
                                    case 105:
                                    case 106:
                                    case 107:
                                    case 108:
                                        searchResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                                        break;
                                    default:
                                        searchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                                        break;
                                }
                            }
                        } else {
                            searchResult.error = SearchResult.ERRORNO.NO_DATA_FOR_LATLNG;
                        }
                        return true;
                    }
                    searchResult.error = SearchResult.ERRORNO.NO_ADVANCED_PERMISSION;
                    return true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                searchResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return true;
            }
        }
        searchResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
        return true;
    }
}
