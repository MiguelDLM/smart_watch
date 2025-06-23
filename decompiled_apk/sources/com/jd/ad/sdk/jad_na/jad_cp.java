package com.jd.ad.sdk.jad_na;

import XIXIX.OOXIXo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.appevents.UserDataStore;
import com.jd.ad.sdk.logger.Logger;
import com.sma.smartv3.network.BaiDu;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_cp {
    public jad_bo jad_an;
    public jad_dq jad_bo;
    public List<jad_fs> jad_cp;
    public long jad_dq;
    public long jad_er;
    public List<jad_hu> jad_hu;
    public jad_an jad_iv;
    public List<jad_er> jad_jt;
    public jad_jt jad_kx;
    public int jad_fs = 2;
    public int jad_jw = 0;

    public static jad_cp jad_an(@Nullable JSONObject jSONObject) {
        jad_bo jad_boVar;
        jad_dq jad_dqVar;
        jad_an jad_anVar;
        jad_hu jad_huVar;
        jad_er jad_erVar;
        jad_fs jad_fsVar;
        jad_jt jad_jtVar = null;
        if (jSONObject == null) {
            return null;
        }
        jad_cp jad_cpVar = new jad_cp();
        JSONObject optJSONObject = jSONObject.optJSONObject("api");
        if (optJSONObject == null) {
            jad_boVar = null;
        } else {
            jad_boVar = new jad_bo();
            jad_boVar.jad_cp = optJSONObject.optString("eu");
            jad_boVar.jad_an = optJSONObject.optString("ou");
            jad_boVar.jad_bo = optJSONObject.optString("tu");
        }
        jad_cpVar.jad_an = jad_boVar;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("events");
        if (optJSONObject2 == null) {
            jad_dqVar = null;
        } else {
            jad_dqVar = new jad_dq();
            jad_dqVar.jad_cp = optJSONObject2.optInt("ci");
            jad_dqVar.jad_bo = optJSONObject2.optInt("mn");
            jad_dqVar.jad_an = optJSONObject2.optString("url");
        }
        jad_cpVar.jad_bo = jad_dqVar;
        JSONArray optJSONArray = jSONObject.optJSONArray("ms");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                if (optJSONObject3 == null) {
                    jad_fsVar = null;
                } else {
                    jad_fsVar = new jad_fs();
                    jad_fsVar.jad_an = optJSONObject3.optInt("id");
                    jad_fsVar.jad_cp = optJSONObject3.optString("sa");
                    jad_fsVar.jad_bo = optJSONObject3.optString("sn");
                }
                arrayList.add(jad_fsVar);
            }
        }
        jad_cpVar.jad_cp = arrayList;
        jad_cpVar.jad_dq = jSONObject.optLong("timeout");
        jad_cpVar.jad_er = jSONObject.optLong("lrf");
        jad_cpVar.jad_fs = jSONObject.optInt("ssp", 2);
        JSONArray optJSONArray2 = jSONObject.optJSONArray("pls");
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i2);
                if (optJSONObject4 == null) {
                    jad_erVar = null;
                } else {
                    jad_erVar = new jad_er();
                    jad_erVar.jad_an = optJSONObject4.optString(BaiDu.AK_SERVICE_KEY);
                    jad_erVar.jad_bo = optJSONObject4.optInt("t");
                    jad_erVar.jad_cp = optJSONObject4.optInt("m");
                    jad_erVar.jad_dq = optJSONObject4.optInt("bs");
                    jad_erVar.jad_er = optJSONObject4.optInt(UserDataStore.STATE);
                    JSONArray optJSONArray3 = optJSONObject4.optJSONArray("tmp");
                    ArrayList arrayList3 = new ArrayList();
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            arrayList3.add(Integer.valueOf(optJSONArray3.optInt(i3)));
                        }
                    }
                    jad_erVar.jad_fs = arrayList3;
                    jad_erVar.jad_jt = optJSONObject4.optInt("ds");
                    jad_erVar.jad_hu = optJSONObject4.optInt("r");
                }
                arrayList2.add(jad_erVar);
            }
        }
        jad_cpVar.jad_jt = arrayList2;
        JSONArray optJSONArray4 = jSONObject.optJSONArray("fcfg");
        ArrayList arrayList4 = new ArrayList();
        if (optJSONArray4 != null && optJSONArray4.length() > 0) {
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                JSONObject optJSONObject5 = optJSONArray4.optJSONObject(i4);
                if (optJSONObject5 == null) {
                    jad_huVar = null;
                } else {
                    jad_huVar = new jad_hu();
                    jad_huVar.jad_an = optJSONObject5.optInt("mId");
                    jad_huVar.jad_bo = optJSONObject5.optString("tagId");
                }
                arrayList4.add(jad_huVar);
            }
        }
        jad_cpVar.jad_hu = arrayList4;
        JSONObject optJSONObject6 = jSONObject.optJSONObject("abcfg");
        if (optJSONObject6 == null) {
            jad_anVar = null;
        } else {
            jad_anVar = new jad_an();
            jad_anVar.jad_an = optJSONObject6.optString("crt");
            jad_anVar.jad_mz = optJSONObject6.optString("fbdr");
            jad_anVar.jad_bo = optJSONObject6.optString("enpe");
            jad_anVar.jad_cp = (float) optJSONObject6.optDouble("ssvl", OOXIXo.f3760XO);
            jad_anVar.jad_dq = (float) optJSONObject6.optDouble("slng", OOXIXo.f3760XO);
            jad_anVar.jad_er = (float) optJSONObject6.optDouble("savl", OOXIXo.f3760XO);
            jad_anVar.jad_fs = (float) optJSONObject6.optDouble("stvl", OOXIXo.f3760XO);
            jad_anVar.jad_jt = (float) optJSONObject6.optDouble("fsvl", OOXIXo.f3760XO);
            jad_anVar.jad_hu = (float) optJSONObject6.optDouble("favl", OOXIXo.f3760XO);
            jad_anVar.jad_iv = (float) optJSONObject6.optDouble("ftvl", OOXIXo.f3760XO);
            jad_anVar.jad_jw = optJSONObject6.optInt("pcit", 3600);
            jad_anVar.jad_kx = optJSONObject6.optInt("pcdc", 2);
            jad_anVar.jad_ly = optJSONObject6.optInt("pdut", 3);
            jad_anVar.jad_na = optJSONObject6.optInt("fpif");
            jad_anVar.jad_ob = optJSONObject6.optString("fikc");
        }
        jad_cpVar.jad_iv = jad_anVar;
        jad_cpVar.jad_jw = jSONObject.optInt("collectedEnable", 0);
        JSONObject optJSONObject7 = jSONObject.optJSONObject("collectInfoConfig");
        if (optJSONObject7 != null) {
            jad_jtVar = new jad_jt();
            jad_jtVar.jad_an = optJSONObject7.optString("deviceInfoList");
            jad_jtVar.jad_bo = optJSONObject7.optString("screenInfoList");
            jad_jtVar.jad_cp = optJSONObject7.optString("osInfoList");
            jad_jtVar.jad_dq = optJSONObject7.optString("userInfoList");
            jad_jtVar.jad_er = optJSONObject7.optString("realTimeInfoList");
        }
        jad_cpVar.jad_kx = jad_jtVar;
        return jad_cpVar;
    }

    @NonNull
    public String toString() {
        StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANConfigurations{api=");
        jad_an.append(this.jad_an);
        jad_an.append(", events=");
        jad_an.append(this.jad_bo);
        jad_an.append(", ms=");
        jad_an.append(this.jad_cp);
        jad_an.append(", timeout=");
        jad_an.append(this.jad_dq);
        jad_an.append(", lrf=");
        jad_an.append(this.jad_er);
        jad_an.append(", pls=");
        jad_an.append(this.jad_jt);
        jad_an.append(", ssp=");
        jad_an.append(this.jad_fs);
        jad_an.append(", fcfg=");
        jad_an.append(this.jad_hu);
        jad_an.append(", abcfg=");
        jad_an.append(this.jad_iv);
        jad_an.append(", collectedEnable=");
        jad_an.append(this.jad_jw);
        jad_an.append(", collectInfoConfig=");
        jad_an.append(this.jad_kx);
        jad_an.append('}');
        return jad_an.toString();
    }

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jad_bo jad_boVar = this.jad_an;
            if (jad_boVar != null) {
                jSONObject.putOpt("api", jad_boVar.jad_an());
            }
            jad_dq jad_dqVar = this.jad_bo;
            if (jad_dqVar != null) {
                jSONObject.putOpt("events", jad_dqVar.jad_an());
            }
            JSONArray jSONArray = new JSONArray();
            List<jad_fs> list = this.jad_cp;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.jad_cp.size(); i++) {
                    jad_fs jad_fsVar = this.jad_cp.get(i);
                    if (jad_fsVar != null) {
                        jSONArray.put(jad_fsVar.jad_an());
                    }
                }
            }
            jSONObject.putOpt("ms", jSONArray);
            jSONObject.putOpt("timeout", Long.valueOf(this.jad_dq));
            jSONObject.putOpt("lrf", Long.valueOf(this.jad_er));
            jSONObject.putOpt("ssp", Integer.valueOf(this.jad_fs));
            JSONArray jSONArray2 = new JSONArray();
            List<jad_er> list2 = this.jad_jt;
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < this.jad_jt.size(); i2++) {
                    jad_er jad_erVar = this.jad_jt.get(i2);
                    if (jad_erVar != null) {
                        jSONArray2.put(jad_erVar.jad_an());
                    }
                }
            }
            jSONObject.putOpt("pls", jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            List<jad_hu> list3 = this.jad_hu;
            if (list3 != null && list3.size() > 0) {
                for (int i3 = 0; i3 < this.jad_hu.size(); i3++) {
                    jad_hu jad_huVar = this.jad_hu.get(i3);
                    if (jad_huVar != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.putOpt("mId", Integer.valueOf(jad_huVar.jad_an));
                            jSONObject2.putOpt("tagId", jad_huVar.jad_bo);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        jSONArray3.put(jSONObject2);
                    }
                }
            }
            jSONObject.putOpt("fcfg", jSONArray3);
            jad_an jad_anVar = this.jad_iv;
            if (jad_anVar != null) {
                jSONObject.putOpt("abcfg", jad_anVar.jad_an());
            }
            jSONObject.putOpt("collectedEnable", Integer.valueOf(this.jad_jw));
            jad_jt jad_jtVar = this.jad_kx;
            if (jad_jtVar != null) {
                jSONObject.putOpt("collectInfoConfig", jad_jtVar.jad_an());
            }
        } catch (Exception e2) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an configuration ");
            jad_an.append(e2.getMessage());
            Logger.d(jad_an.toString());
        }
        return jSONObject;
    }
}
