package com.baidu.platform.core.g;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.share.OnGetShareUrlResultListener;
import com.baidu.mapapi.search.share.ShareUrlResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class d extends com.baidu.platform.base.d {
    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        ShareUrlResult shareUrlResult = new ShareUrlResult();
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        shareUrlResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return shareUrlResult;
                    }
                    if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        if (optString.equals("NETWORK_ERROR")) {
                            shareUrlResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        } else if (optString.equals("REQUEST_ERROR")) {
                            shareUrlResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        } else {
                            shareUrlResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        }
                        return shareUrlResult;
                    }
                }
                if (!a(str, shareUrlResult, false)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str);
                        if (jSONObject2.optInt("status_sdk") != 0) {
                            shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        } else {
                            shareUrlResult.setUrl(jSONObject2.optString("shorturl"));
                            shareUrlResult.setType(a().ordinal());
                            shareUrlResult.error = SearchResult.ERRORNO.NO_ERROR;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                }
                return shareUrlResult;
            } catch (Exception unused) {
                shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return shareUrlResult;
            }
        }
        shareUrlResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return shareUrlResult;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetShareUrlResultListener)) {
            return;
        }
        ((OnGetShareUrlResultListener) obj).onGetRouteShareUrlResult((ShareUrlResult) searchResult);
    }
}
