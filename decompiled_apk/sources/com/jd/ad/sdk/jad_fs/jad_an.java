package com.jd.ad.sdk.jad_fs;

import android.app.Application;
import com.facebook.appevents.UserDataStore;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_an {
    public final List<jad_dq> jad_an = new ArrayList();
    public jad_dq jad_bo;
    public jad_dq jad_cp;

    public final String jad_an(List<jad_dq> list, int i) {
        if (i >= 1 && list.size() >= i) {
            int floor = (int) Math.floor(list.size() / i);
            if (floor > 9) {
                floor = 9;
            }
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < floor) {
                i2++;
                arrayList.add(list.get((i * i2) - 1));
            }
            long j = ((jad_dq) arrayList.get(0)).jad_an;
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jad_dq jad_dqVar = (jad_dq) it.next();
                sb.append("|");
                sb.append(jad_dqVar.jad_bo);
                sb.append(",");
                sb.append(jad_dqVar.jad_cp);
                sb.append(",");
                sb.append(jad_dqVar.jad_an - j);
                j = jad_dqVar.jad_an;
            }
            return sb.toString();
        }
        return "";
    }

    public final String jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            Application jad_an = com.jd.ad.sdk.jad_do.jad_bo.jad_an();
            jSONObject.putOpt("jbr", Integer.valueOf(com.jd.ad.sdk.jad_ob.jad_an.jad_qd()));
            jSONObject.putOpt("sof", Integer.valueOf(com.jd.ad.sdk.jad_ob.jad_an.jad_bo(jad_an)));
            jSONObject.putOpt("sl", Integer.valueOf(com.jd.ad.sdk.jad_ob.jad_an.jad_an(jad_an)));
            jSONObject.putOpt(UserDataStore.EMAIL, -1);
            jSONObject.putOpt("af", Integer.valueOf(com.jd.ad.sdk.jad_ob.jad_an.jad_ob()));
            jSONObject.putOpt("hoo", com.jd.ad.sdk.jad_ob.jad_an.jad_re());
            jSONObject.putOpt("open", com.jd.ad.sdk.jad_ob.jad_an.jad_sf());
            jSONObject.putOpt("dbg", com.jd.ad.sdk.jad_ob.jad_an.jad_pc());
            jSONObject.putOpt("clo", "NA");
            jSONObject.putOpt("pac", com.jd.ad.sdk.jad_ob.jad_an.jad_an());
            jSONObject.putOpt("soa", com.jd.ad.sdk.jad_ob.jad_an.jad_kx());
            Logger.d("Cheat AC Params: " + jSONObject.toString());
        } catch (JSONException e) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("getCheatParams Exception: ");
            jad_an2.append(e.toString());
            Logger.d(jad_an2.toString());
        }
        return jSONObject.toString();
    }
}
