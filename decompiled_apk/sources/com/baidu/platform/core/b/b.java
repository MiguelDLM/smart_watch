package com.baidu.platform.core.b;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class b extends com.baidu.platform.base.d {
    boolean b = false;
    String c = null;

    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean b(java.lang.String r6, com.baidu.mapapi.search.district.DistrictResult r7) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L92
            java.lang.String r1 = ""
            boolean r1 = r6.equals(r1)
            if (r1 != 0) goto L92
            if (r7 != 0) goto Lf
            goto L92
        Lf:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L8e
            r1.<init>(r6)     // Catch: org.json.JSONException -> L8e
            java.lang.String r6 = "result"
            org.json.JSONObject r6 = r1.optJSONObject(r6)
            java.lang.String r2 = "content"
            org.json.JSONObject r1 = r1.optJSONObject(r2)
            if (r6 == 0) goto L8d
            if (r1 != 0) goto L25
            goto L8d
        L25:
            java.lang.String r2 = "error"
            int r6 = r6.optInt(r2)
            if (r6 == 0) goto L2e
            return r0
        L2e:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.lang.String r0 = r5.c
            r2 = 0
            if (r0 == 0) goto L47
            java.lang.String r0 = "geo"
            java.lang.String r0 = r1.optString(r0)     // Catch: java.lang.Exception -> L43
            java.util.List r0 = com.baidu.mapapi.model.CoordUtil.decodeLocationList2D(r0)     // Catch: java.lang.Exception -> L43
            goto L48
        L43:
            r0 = move-exception
            r0.printStackTrace()
        L47:
            r0 = r2
        L48:
            if (r0 == 0) goto L77
            java.util.Iterator r0 = r0.iterator()
        L4e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L77
            java.lang.Object r1 = r0.next()
            java.util.List r1 = (java.util.List) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r1 = r1.iterator()
        L63:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L73
            java.lang.Object r4 = r1.next()
            com.baidu.mapapi.model.LatLng r4 = (com.baidu.mapapi.model.LatLng) r4
            r3.add(r4)
            goto L63
        L73:
            r6.add(r3)
            goto L4e
        L77:
            int r0 = r6.size()
            if (r0 <= 0) goto L80
            r7.setPolylines(r6)
        L80:
            java.lang.String r6 = r5.c
            r7.setCityName(r6)
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r6 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.NO_ERROR
            r7.error = r6
            r5.c = r2
            r6 = 1
            return r6
        L8d:
            return r0
        L8e:
            r6 = move-exception
            r6.printStackTrace()
        L92:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.core.b.b.b(java.lang.String, com.baidu.mapapi.search.district.DistrictResult):boolean");
    }

    @Override // com.baidu.platform.base.d
    public SearchResult a(String str) {
        DistrictResult districtResult = new DistrictResult();
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("SDK_InnerError")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("SDK_InnerError");
                    if (optJSONObject.has("PermissionCheckError")) {
                        districtResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                        return districtResult;
                    }
                    if (optJSONObject.has("httpStateError")) {
                        String optString = optJSONObject.optString("httpStateError");
                        if (optString.equals("NETWORK_ERROR")) {
                            districtResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                        } else if (optString.equals("REQUEST_ERROR")) {
                            districtResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                        } else {
                            districtResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                        }
                        return districtResult;
                    }
                }
                if (!a(str, districtResult, false)) {
                    if (!this.b) {
                        if (!a(str, districtResult)) {
                            districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                        }
                    } else {
                        b(str, districtResult);
                    }
                }
                return districtResult;
            } catch (Exception unused) {
                districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
                return districtResult;
            }
        }
        districtResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
        return districtResult;
    }

    public void a(boolean z) {
        this.b = z;
    }

    private boolean a(String str, DistrictResult districtResult) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        int length;
        if (str != null && !"".equals(str) && districtResult != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("result");
                JSONObject optJSONObject3 = jSONObject.optJSONObject("city_result");
                if (optJSONObject2 != null && optJSONObject3 != null) {
                    if (optJSONObject2.optInt("error") != 0 || (optJSONObject = optJSONObject3.optJSONObject("content")) == null) {
                        return false;
                    }
                    JSONObject optJSONObject4 = optJSONObject.optJSONObject("sgeo");
                    if (optJSONObject4 != null && (optJSONArray = optJSONObject4.optJSONArray("geo_elements")) != null && optJSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                            if (optJSONObject5 != null && (optJSONArray2 = optJSONObject5.optJSONArray("point")) != null && (length = optJSONArray2.length()) > 0) {
                                ArrayList arrayList2 = new ArrayList();
                                int i2 = 0;
                                int i3 = 0;
                                for (int i4 = 0; i4 < length; i4++) {
                                    int optInt = optJSONArray2.optInt(i4);
                                    if (i4 % 2 == 0) {
                                        i3 += optInt;
                                    } else {
                                        i2 += optInt;
                                        arrayList2.add(CoordUtil.mc2ll(new GeoPoint(i2, i3)));
                                    }
                                }
                                arrayList.add(arrayList2);
                            }
                        }
                        if (arrayList.size() > 0) {
                            districtResult.setPolylines(arrayList);
                            districtResult.setCenterPt(CoordUtil.decodeLocation(optJSONObject.optString("geo")));
                            districtResult.setCityCode(optJSONObject.optInt("code"));
                            districtResult.setCityName(optJSONObject.optString("cname"));
                            districtResult.error = SearchResult.ERRORNO.NO_ERROR;
                            return true;
                        }
                    }
                    districtResult.setCityName(optJSONObject.optString("uid"));
                    this.c = optJSONObject.optString("cname");
                    districtResult.setCenterPt(CoordUtil.decodeLocation(optJSONObject.optString("geo")));
                    districtResult.setCityCode(optJSONObject.optInt("code"));
                }
                return false;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.baidu.platform.base.d
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetDistricSearchResultListener)) {
            return;
        }
        ((OnGetDistricSearchResultListener) obj).onGetDistrictResult((DistrictResult) searchResult);
    }
}
