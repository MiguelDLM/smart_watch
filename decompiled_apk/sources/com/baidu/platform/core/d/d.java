package com.baidu.platform.core.d;

import XIXIX.OOXIXo;
import android.util.Log;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiDetailInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.garmin.fit.xOxOoo;
import com.huawei.openalliance.ad.constant.aw;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class d extends com.baidu.platform.base.d {
    private static final String b = "d";
    private boolean c = false;

    public void a(boolean z) {
        this.c = z;
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        SearchResult poiDetailResult;
        if (this.c) {
            poiDetailResult = new PoiDetailSearchResult();
        } else {
            poiDetailResult = new PoiDetailResult();
        }
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() == 0) {
                    poiDetailResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    return poiDetailResult;
                }
                if (!jSONObject.has("SDK_InnerError")) {
                    if (!a(str, poiDetailResult)) {
                        poiDetailResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                    }
                    return poiDetailResult;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    if (optJSONObject.has("PermissionCheckError")) {
                        poiDetailResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return poiDetailResult;
                    }
                    if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        optString.hashCode();
                        if (optString.equals("NETWORK_ERROR")) {
                            poiDetailResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        } else if (!optString.equals("REQUEST_ERROR")) {
                            poiDetailResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        } else {
                            poiDetailResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        }
                    }
                    return poiDetailResult;
                }
                poiDetailResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return poiDetailResult;
            } catch (JSONException e) {
                Log.e(b, "Parse detail search result failed", e);
                poiDetailResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return poiDetailResult;
            }
        }
        poiDetailResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return poiDetailResult;
    }

    private boolean a(String str, SearchResult searchResult) {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() == 0 || jSONObject.optInt("status") != 0 || (optJSONArray = jSONObject.optJSONArray("result")) == null || optJSONArray.length() == 0) {
                return false;
            }
            if (this.c) {
                return a(optJSONArray, (PoiDetailSearchResult) searchResult);
            }
            return a(optJSONArray, (PoiDetailResult) searchResult);
        } catch (JSONException e) {
            Log.e(b, "Parse detail search result error", e);
            return false;
        }
    }

    private boolean a(JSONArray jSONArray, PoiDetailSearchResult poiDetailSearchResult) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null && jSONObject.length() != 0) {
                PoiDetailInfo poiDetailInfo = new PoiDetailInfo();
                poiDetailInfo.setName(jSONObject.optString("name"));
                poiDetailInfo.setLocation(a(jSONObject.optJSONObject("location")));
                poiDetailInfo.setAddress(jSONObject.optString("address"));
                poiDetailInfo.setAdCode(jSONObject.optInt("adcode"));
                poiDetailInfo.setProvince(jSONObject.optString("province"));
                poiDetailInfo.setCity(jSONObject.optString("city"));
                poiDetailInfo.setArea(jSONObject.optString("area"));
                poiDetailInfo.setTelephone(jSONObject.optString("telephone"));
                poiDetailInfo.setUid(jSONObject.optString("uid"));
                poiDetailInfo.setStreetId(jSONObject.optString("setStreetId"));
                poiDetailInfo.setDetail(jSONObject.optString(aw.as));
                JSONObject optJSONObject = jSONObject.optJSONObject("detail_info");
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    poiDetailInfo.setDistance(optJSONObject.optInt(xOxOoo.f15470o00, 0));
                    poiDetailInfo.setType(optJSONObject.optString("type"));
                    poiDetailInfo.setTag(optJSONObject.optString("tag"));
                    poiDetailInfo.setDetailUrl(optJSONObject.optString("detail_url"));
                    poiDetailInfo.setPrice(optJSONObject.optDouble("price", OOXIXo.f3760XO));
                    poiDetailInfo.setShopHours(optJSONObject.optString("shop_hours"));
                    poiDetailInfo.setOverallRating(optJSONObject.optDouble("overall_rating", OOXIXo.f3760XO));
                    poiDetailInfo.setTasteRating(optJSONObject.optDouble("taste_rating", OOXIXo.f3760XO));
                    poiDetailInfo.setServiceRating(optJSONObject.optDouble("service_rating", OOXIXo.f3760XO));
                    poiDetailInfo.setEnvironmentRating(optJSONObject.optDouble("environment_rating", OOXIXo.f3760XO));
                    poiDetailInfo.setFacilityRating(optJSONObject.optDouble("facility_rating", OOXIXo.f3760XO));
                    poiDetailInfo.setHygieneRating(optJSONObject.optDouble("hygiene_rating", OOXIXo.f3760XO));
                    poiDetailInfo.setTechnologyRating(optJSONObject.optDouble("technology_rating", OOXIXo.f3760XO));
                    poiDetailInfo.setImageNum(optJSONObject.optInt("image_num"));
                    poiDetailInfo.setGrouponNum(optJSONObject.optInt("groupon_num", 0));
                    poiDetailInfo.setCommentNum(optJSONObject.optInt("comment_num", 0));
                    poiDetailInfo.setDiscountNum(optJSONObject.optInt("discount_num", 0));
                    poiDetailInfo.setFavoriteNum(optJSONObject.optInt("favorite_num", 0));
                    poiDetailInfo.setCheckinNum(optJSONObject.optInt("checkin_num", 0));
                }
                arrayList.add(poiDetailInfo);
            }
        }
        poiDetailSearchResult.setPoiDetailInfoList(arrayList);
        poiDetailSearchResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    private boolean a(JSONArray jSONArray, PoiDetailResult poiDetailResult) {
        JSONObject jSONObject = (JSONObject) jSONArray.opt(0);
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        poiDetailResult.setName(jSONObject.optString("name"));
        poiDetailResult.setLocation(a(jSONObject.optJSONObject("location")));
        poiDetailResult.setAddress(jSONObject.optString("address"));
        poiDetailResult.setTelephone(jSONObject.optString("telephone"));
        poiDetailResult.setUid(jSONObject.optString("uid"));
        JSONObject optJSONObject = jSONObject.optJSONObject("detail_info");
        if (optJSONObject != null && optJSONObject.length() != 0) {
            poiDetailResult.setTag(optJSONObject.optString("tag"));
            poiDetailResult.setDetailUrl(optJSONObject.optString("detail_url"));
            poiDetailResult.setType(optJSONObject.optString("type"));
            poiDetailResult.setPrice(optJSONObject.optDouble("price", OOXIXo.f3760XO));
            poiDetailResult.setOverallRating(optJSONObject.optDouble("overall_rating", OOXIXo.f3760XO));
            poiDetailResult.setTasteRating(optJSONObject.optDouble("taste_rating", OOXIXo.f3760XO));
            poiDetailResult.setServiceRating(optJSONObject.optDouble("service_rating", OOXIXo.f3760XO));
            poiDetailResult.setEnvironmentRating(optJSONObject.optDouble("environment_rating", OOXIXo.f3760XO));
            poiDetailResult.setFacilityRating(optJSONObject.optDouble("facility_rating", OOXIXo.f3760XO));
            poiDetailResult.setHygieneRating(optJSONObject.optDouble("hygiene_rating", OOXIXo.f3760XO));
            poiDetailResult.setTechnologyRating(optJSONObject.optDouble("technology_rating", OOXIXo.f3760XO));
            poiDetailResult.setImageNum(optJSONObject.optInt("image_num"));
            poiDetailResult.setGrouponNum(optJSONObject.optInt("groupon_num", 0));
            poiDetailResult.setCommentNum(optJSONObject.optInt("comment_num", 0));
            poiDetailResult.setDiscountNum(optJSONObject.optInt("discount_num", 0));
            poiDetailResult.setFavoriteNum(optJSONObject.optInt("favorite_num", 0));
            poiDetailResult.setCheckinNum(optJSONObject.optInt("checkin_num", 0));
            poiDetailResult.setShopHours(optJSONObject.optString("shop_hours"));
        }
        poiDetailResult.error = SearchResult.ERRORNO.NO_ERROR;
        return true;
    }

    private LatLng a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double optDouble = jSONObject.optDouble("lat");
        double optDouble2 = jSONObject.optDouble("lng");
        if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
            return CoordTrans.baiduToGcj(new LatLng(optDouble, optDouble2));
        }
        return new LatLng(optDouble, optDouble2);
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetPoiSearchResultListener)) {
            return;
        }
        if (this.c) {
            ((OnGetPoiSearchResultListener) obj).onGetPoiDetailResult((PoiDetailSearchResult) searchResult);
        } else {
            ((OnGetPoiSearchResultListener) obj).onGetPoiDetailResult((PoiDetailResult) searchResult);
        }
    }
}
