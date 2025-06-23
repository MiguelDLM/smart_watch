package com.jd.ad.sdk.jad_wj;

import androidx.annotation.Nullable;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_hu {
    public List<jad_dq> jad_an;

    public List<jad_dq> jad_an() {
        return this.jad_an;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.jd.ad.sdk.jad_wj.jad_fs] */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.jd.ad.sdk.jad_wj.jad_cp] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static jad_hu jad_an(@Nullable JSONObject jSONObject) {
        jad_dq jad_dqVar;
        JSONArray jSONArray;
        jad_iv jad_ivVar;
        ?? jad_fsVar;
        JSONArray jSONArray2;
        String str;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        jad_er jad_erVar;
        String str2;
        ?? r9;
        jad_dq jad_dqVar2 = null;
        if (jSONObject == null) {
            return null;
        }
        jad_hu jad_huVar = new jad_hu();
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray5 = jSONObject.getJSONArray(MapBundleKey.MapObjKey.OBJ_BID);
        if (jSONArray5 != null && jSONArray5.length() > 0) {
            int i = 0;
            while (i < jSONArray5.length()) {
                JSONObject jSONObject2 = jSONArray5.getJSONObject(i);
                if (jSONObject2 == null) {
                    jSONArray = jSONArray5;
                    jad_dqVar = jad_dqVar2;
                } else {
                    jad_dqVar = new jad_dq();
                    String str3 = "id";
                    jSONObject2.optString("id");
                    jSONObject2.optString("impid");
                    jSONObject2.optString("adid");
                    jSONObject2.optString(AppEventsConstants.EVENT_PARAM_AD_TYPE);
                    jad_dqVar.jad_an = jSONObject2.optDouble("price");
                    JSONObject optJSONObject = jSONObject2.optJSONObject("adm");
                    if (optJSONObject == null) {
                        jSONArray = jSONArray5;
                        r9 = jad_dqVar2;
                    } else {
                        jad_cp jad_cpVar = new jad_cp();
                        JSONArray optJSONArray = optJSONObject.optJSONArray("items");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            int i2 = 0;
                            while (i2 < optJSONArray.length()) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                                if (optJSONObject2 == null) {
                                    jSONArray2 = jSONArray5;
                                    jad_fsVar = jad_dqVar2;
                                    str = str3;
                                    jSONArray3 = optJSONArray;
                                } else {
                                    jad_fsVar = new jad_fs();
                                    jad_fsVar.jad_an = optJSONObject2.optString("title");
                                    jad_fsVar.jad_bo = optJSONObject2.optString("desc");
                                    optJSONObject2.optString(str3);
                                    jad_fsVar.jad_cp = optJSONObject2.optString("click_url");
                                    jad_fsVar.jad_dq = optJSONObject2.optString("dpl_url");
                                    jad_fsVar.jad_ly = optJSONObject2.optString("media_style");
                                    jad_fsVar.jad_mz = optJSONObject2.optString("download_url");
                                    jad_fsVar.jad_er = optJSONObject2.optString("img");
                                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("imgs");
                                    ArrayList arrayList3 = new ArrayList();
                                    if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                                        jSONArray2 = jSONArray5;
                                    } else {
                                        jSONArray2 = jSONArray5;
                                        int i3 = 0;
                                        while (i3 < optJSONArray2.length()) {
                                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                                            if (optJSONObject3 == null) {
                                                str2 = str3;
                                                jSONArray4 = optJSONArray;
                                                jad_erVar = null;
                                            } else {
                                                jSONArray4 = optJSONArray;
                                                jad_erVar = new jad_er();
                                                optJSONObject3.optString(str3);
                                                str2 = str3;
                                                jad_erVar.jad_an = optJSONObject3.optString("url");
                                            }
                                            arrayList3.add(jad_erVar);
                                            i3++;
                                            optJSONArray = jSONArray4;
                                            str3 = str2;
                                        }
                                    }
                                    str = str3;
                                    jSONArray3 = optJSONArray;
                                    jad_fsVar.jad_fs = arrayList3;
                                    jad_fsVar.jad_na = optJSONObject2.optString("video");
                                    jad_fsVar.jad_iv = optJSONObject2.optString("ad_resource");
                                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("exposal_urls");
                                    ArrayList arrayList4 = new ArrayList();
                                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                                        for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                            arrayList4.add(optJSONArray3.optString(i4));
                                        }
                                    }
                                    jad_fsVar.jad_jw = arrayList4;
                                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("click_monitor_urls");
                                    ArrayList arrayList5 = new ArrayList();
                                    if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                                        for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                                            arrayList5.add(optJSONArray4.optString(i5));
                                        }
                                    }
                                    jad_fsVar.jad_kx = arrayList5;
                                    optJSONObject2.optString("video_start_url");
                                    optJSONObject2.optString("video_valid_url");
                                    optJSONObject2.optString("video_finish_url");
                                    jad_fsVar.jad_ob = optJSONObject2.optInt("video_voice");
                                    jad_fsVar.jad_pc = optJSONObject2.optInt("video_auto_play");
                                    jad_fsVar.jad_qd = optJSONObject2.optInt("video_duration");
                                    jad_fsVar.jad_re = optJSONObject2.optInt("video_width");
                                    jad_fsVar.jad_sf = optJSONObject2.optInt("video_height");
                                    jad_fsVar.jad_jt = optJSONObject2.optInt("img_width");
                                    jad_fsVar.jad_hu = optJSONObject2.optInt("img_height");
                                }
                                arrayList2.add(jad_fsVar);
                                i2++;
                                jSONArray5 = jSONArray2;
                                optJSONArray = jSONArray3;
                                str3 = str;
                                jad_dqVar2 = null;
                            }
                        }
                        jSONArray = jSONArray5;
                        jad_cpVar.jad_an = arrayList2;
                        JSONObject optJSONObject4 = optJSONObject.optJSONObject(SDKConstants.PARAM_UPDATE_TEMPLATE);
                        if (optJSONObject4 == null || optJSONObject4.length() == 0) {
                            jad_ivVar = null;
                        } else {
                            jad_ivVar = new jad_iv();
                            jad_ivVar.jad_an = optJSONObject4.optInt(ExposeManager.UtArgsNames.templateId);
                            jad_ivVar.jad_bo = optJSONObject4.optString("template_update_timestamp");
                            jad_ivVar.jad_cp = optJSONObject4.optString("template_json");
                        }
                        jad_cpVar.jad_bo = jad_ivVar;
                        jad_cpVar.jad_cp = optJSONObject.optInt("spec_set_id");
                        jad_cpVar.jad_dq = optJSONObject.optInt("template_style_id");
                        jad_cpVar.jad_er = optJSONObject.optInt("creative_interactive_type");
                        jad_cpVar.jad_fs = optJSONObject.optInt("area_click_type");
                        r9 = jad_cpVar;
                    }
                    jad_dqVar.jad_bo = r9;
                }
                arrayList.add(jad_dqVar);
                i++;
                jSONArray5 = jSONArray;
                jad_dqVar2 = null;
            }
        }
        jad_huVar.jad_an = arrayList;
        return jad_huVar;
    }
}
