package com.jd.ad.sdk.jad_fs;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils;
import com.jd.ad.sdk.jad_vi.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_bo {
    public jad_an jad_an;

    public jad_bo() {
        this.jad_an = null;
        this.jad_an = new jad_an();
    }

    public String jad_an(@NonNull String str) {
        String str2;
        String replaceAll;
        long j;
        int i;
        jad_dq jad_dqVar;
        String str3;
        String sb;
        String sb2;
        jad_dq jad_dqVar2;
        jad_dq jad_dqVar3;
        jad_dq jad_dqVar4;
        jad_an jad_anVar = this.jad_an;
        if (jad_anVar == null) {
            return str;
        }
        try {
            int size = jad_anVar.jad_an.size();
            jad_dq jad_dqVar5 = jad_anVar.jad_bo;
            long j2 = 0;
            if (jad_dqVar5 != null && (jad_dqVar4 = jad_anVar.jad_cp) != null) {
                j = jad_dqVar4.jad_an - jad_dqVar5.jad_an;
            } else {
                j = 0;
            }
            if (jad_anVar.jad_an.size() > 0 && (jad_dqVar2 = jad_anVar.jad_an.get(0)) != null && (jad_dqVar3 = jad_anVar.jad_cp) != null) {
                j2 = jad_dqVar3.jad_an - jad_dqVar2.jad_an;
            }
            String str4 = "|" + size + "," + j + "," + j2 + "," + JADScreenInfoUtils.getScreenWidth(com.jd.ad.sdk.jad_do.jad_bo.jad_an()) + "," + JADScreenInfoUtils.getScreenHeight(com.jd.ad.sdk.jad_do.jad_bo.jad_an());
            ArrayList arrayList = new ArrayList();
            if (jad_anVar.jad_an.size() > 400) {
                int size2 = jad_anVar.jad_an.size();
                arrayList.add(jad_anVar.jad_an.get(0));
                arrayList.addAll(jad_anVar.jad_an.subList(size2 - 399, size2));
            } else {
                arrayList.addAll(jad_anVar.jad_an);
            }
            if (jad_anVar.jad_an.size() > 10) {
                i = (int) Math.floor(jad_anVar.jad_an.size() / 10);
            } else {
                i = 1;
            }
            String jad_an = jad_anVar.jad_an(arrayList, i);
            if (jad_anVar.jad_bo != null && jad_anVar.jad_an.isEmpty()) {
                List<jad_dq> list = jad_anVar.jad_an;
                jad_dq jad_dqVar6 = jad_anVar.jad_bo;
                list.add(new jad_dq(jad_dqVar6.jad_bo, jad_dqVar6.jad_cp, jad_dqVar6.jad_an));
            }
            List<jad_dq> list2 = jad_anVar.jad_an;
            if (list2 != null && list2.size() > 0) {
                List<jad_dq> list3 = jad_anVar.jad_an;
                jad_dqVar = list3.get(list3.size() - 1);
            } else {
                jad_dqVar = null;
            }
            if (jad_anVar.jad_cp == null || jad_dqVar == null) {
                str3 = "";
            } else {
                str3 = "|" + jad_anVar.jad_cp.jad_bo + "," + jad_anVar.jad_cp.jad_cp + "," + (jad_anVar.jad_cp.jad_an - jad_dqVar.jad_an);
            }
            String str5 = str4 + jad_an + str3 + ("|" + jad_anVar.jad_an());
            Logger.d("[cheat] path resultString: " + str5);
            StringBuilder sb3 = new StringBuilder();
            if (TextUtils.isEmpty(str)) {
                sb = "";
            } else {
                int floor = (int) Math.floor(str.length() / 12);
                StringBuilder sb4 = new StringBuilder();
                for (int i2 = 0; i2 < 12; i2++) {
                    sb4.append(Integer.toHexString(str.charAt(i2 * floor) % '\f'));
                }
                sb = sb4.toString();
            }
            sb3.append(sb);
            sb3.append(str5);
            sb2 = sb3.toString();
        } catch (Exception e) {
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("getPathList Exception: ");
            jad_an2.append(e.toString());
            Logger.d(jad_an2.toString());
        }
        if (!TextUtils.isEmpty(sb2)) {
            Logger.d("[cheat] Path all is: " + sb2);
            str2 = Base64.encodeToString(sb2.getBytes(Charset.defaultCharset()), 10);
            Logger.d("[cheat] Path all encode is: " + str2);
            if (TextUtils.isEmpty(str2) && str2.length() > 2048) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.URL_AC_LENGTH_EXCEEDS_2KB;
                jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(new String[0]));
                replaceAll = str;
            } else {
                replaceAll = str.replaceAll("__SDKAC__", str2);
            }
            if (!TextUtils.isEmpty(replaceAll) && replaceAll.length() > 4096) {
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar3 = com.jd.ad.sdk.jad_uh.jad_an.OPEN_JD_URL_LENGTH_EXCEEDS_4KB;
                jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(new String[0]));
            }
            return replaceAll;
        }
        str2 = "";
        if (TextUtils.isEmpty(str2)) {
        }
        replaceAll = str.replaceAll("__SDKAC__", str2);
        if (!TextUtils.isEmpty(replaceAll)) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar32 = com.jd.ad.sdk.jad_uh.jad_an.OPEN_JD_URL_LENGTH_EXCEEDS_4KB;
            jad_fs.jad_an("", jad_anVar32.jad_an, jad_anVar32.jad_an(new String[0]));
        }
        return replaceAll;
    }
}
