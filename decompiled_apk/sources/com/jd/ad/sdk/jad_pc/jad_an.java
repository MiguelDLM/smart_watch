package com.jd.ad.sdk.jad_pc;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.jad_do.jad_er;
import com.jd.ad.sdk.jad_na.jad_cp;
import com.jd.ad.sdk.jad_na.jad_dq;
import com.jd.ad.sdk.jad_na.jad_fs;
import com.jd.ad.sdk.jad_sf.jad_an;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_an {
    public static jad_cp jad_an;

    @Nullable
    public static com.jd.ad.sdk.jad_na.jad_an jad_an() {
        jad_cp jad_cp = jad_cp();
        if (jad_cp == null) {
            return null;
        }
        return jad_cp.jad_iv;
    }

    public static boolean jad_bo() {
        com.jd.ad.sdk.jad_sf.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        jad_anVar.getClass();
        String str = "";
        if (!TextUtils.isEmpty("Config")) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Config");
            jad_an2.append(JADYunSdk.getAppId());
            String jad_an3 = jad_anVar.jad_an(jad_an2.toString());
            if (!TextUtils.isEmpty(jad_an3)) {
                str = jad_an3;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jad_an = jad_cp.jad_an(new JSONObject(str));
        } catch (Exception e) {
            StringBuilder jad_an4 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while read config cache: ");
            jad_an4.append(e.getMessage());
            Logger.d(jad_an4.toString());
        }
        if (jad_an == null) {
            return false;
        }
        return true;
    }

    @Nullable
    public static jad_cp jad_cp() {
        if (jad_bo()) {
            return jad_an;
        }
        jad_cp jad_cpVar = new jad_cp();
        com.jd.ad.sdk.jad_na.jad_bo jad_boVar = new com.jd.ad.sdk.jad_na.jad_bo();
        jad_boVar.jad_an = jad_er.jad_an("aHR0cHM6Ly9kc3AteC5qZC5jb20vYWR4L3Nkaw==");
        jad_boVar.jad_bo = jad_er.jad_an("aHR0cHM6Ly9kc3AtdGVzdC14LmpkLmNvbS9hZHgvc2Rr");
        jad_cpVar.jad_an = jad_boVar;
        jad_dq jad_dqVar = new jad_dq();
        jad_dqVar.jad_cp = 0;
        jad_dqVar.jad_bo = 1;
        jad_dqVar.jad_an = jad_er.jad_an("aHR0cHM6Ly94bG9nLmpkLmNvbS92MS9hbg==");
        jad_cpVar.jad_bo = jad_dqVar;
        jad_cpVar.jad_dq = 5000L;
        ArrayList arrayList = new ArrayList(1);
        jad_fs jad_fsVar = new jad_fs();
        jad_fsVar.jad_an = 1;
        jad_fsVar.jad_bo = "Audience";
        jad_fsVar.jad_cp = JADYunSdk.getAppId();
        arrayList.add(jad_fsVar);
        jad_cpVar.jad_cp = arrayList;
        return jad_cpVar;
    }
}
