package com.baidu.platform.core.a;

import android.util.Log;
import com.baidu.mapapi.search.building.BuildingResult;
import com.baidu.mapapi.search.building.OnGetBuildingSearchResultListener;
import com.baidu.mapapi.search.core.BuildingInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.platform.base.d;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a extends d {
    private static final String b = "a";

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        BuildingResult buildingResult = new BuildingResult();
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() == 0) {
                    buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return buildingResult;
                }
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject != null && optJSONObject.has("PermissionCheckError")) {
                        buildingResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return buildingResult;
                    }
                    if (optJSONObject != null && optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        optString.hashCode();
                        if (optString.equals("NETWORK_ERROR")) {
                            buildingResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        } else if (!optString.equals("REQUEST_ERROR")) {
                            buildingResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        } else {
                            buildingResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        }
                        return buildingResult;
                    }
                }
                if (!a(str, buildingResult, true)) {
                    a(str, buildingResult);
                }
                return buildingResult;
            } catch (JSONException e) {
                Log.e(b, "ParseBuidingResult: ", e);
                buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return buildingResult;
            }
        }
        buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return buildingResult;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj instanceof OnGetBuildingSearchResultListener) {
            ((OnGetBuildingSearchResultListener) obj).onGetBuildingResult((BuildingResult) searchResult);
        }
    }

    private boolean a(String str, BuildingResult buildingResult) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0) {
                buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return false;
            }
            int optInt = jSONObject.optInt("status");
            if (optInt == 0) {
                buildingResult.setRelation("in".equals(jSONObject.optString("relation")) ? 1 : 0);
                return a(jSONObject, buildingResult);
            }
            if (optInt == 1) {
                buildingResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
            } else if (optInt != 2) {
                buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            } else {
                buildingResult.error = SearchResult.ERRORNO.SEARCH_OPTION_ERROR;
            }
            return false;
        } catch (JSONException e) {
            Log.e(b, "ParseBuidingResult error: ", e);
            buildingResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return false;
        }
    }

    private boolean a(JSONObject jSONObject, BuildingResult buildingResult) {
        JSONArray optJSONArray = jSONObject.optJSONArray("buildinginfo");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
            if (jSONObject2 != null) {
                BuildingInfo buildingInfo = new BuildingInfo();
                float optLong = (float) jSONObject2.optLong("height");
                buildingInfo.a(jSONObject2.optString(TTDownloadField.TT_LABEL).equals("main") ? 1 : 0);
                buildingInfo.a(jSONObject2.optString("struct_id"));
                buildingInfo.setHeight(optLong);
                buildingInfo.b(jSONObject2.optInt("accuracy"));
                buildingInfo.b(jSONObject2.optString("geom"));
                buildingInfo.c(jSONObject2.optString(TtmlNode.CENTER));
                arrayList.add(buildingInfo);
            }
        }
        buildingResult.setBuildingList(arrayList);
        return true;
    }
}
