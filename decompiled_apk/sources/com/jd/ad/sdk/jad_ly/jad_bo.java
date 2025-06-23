package com.jd.ad.sdk.jad_ly;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.jad_wj.jad_dq;
import com.jd.ad.sdk.jad_wj.jad_er;
import com.jd.ad.sdk.jad_wj.jad_fs;
import com.jd.ad.sdk.jad_wj.jad_hu;
import com.jd.ad.sdk.jad_wj.jad_jt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes10.dex */
public class jad_bo {

    /* loaded from: classes10.dex */
    public static class jad_an {
        public static final jad_bo jad_an = new jad_bo();
    }

    public com.jd.ad.sdk.jad_wj.jad_cp jad_an(String str) {
        jad_hu jad_huVar;
        List<jad_dq> list;
        jad_dq jad_dqVar;
        com.jd.ad.sdk.jad_wj.jad_cp jad_cpVar;
        jad_jt jad_er = jad_er(str);
        if (jad_er == null || (jad_huVar = jad_er.jad_cp) == null || (list = jad_huVar.jad_an) == null || list.isEmpty() || (jad_dqVar = list.get(0)) == null || (jad_cpVar = jad_dqVar.jad_bo) == null) {
            return null;
        }
        return jad_cpVar;
    }

    public String jad_bo(String str) {
        jad_er jad_erVar;
        List<jad_er> list;
        List<jad_fs> jad_dq = jad_dq(str);
        ArrayList arrayList = new ArrayList();
        if (jad_dq != null && !jad_dq.isEmpty()) {
            for (int i = 0; i < jad_dq.size(); i++) {
                jad_fs jad_fsVar = jad_dq.get(i);
                int size = arrayList.size();
                if (jad_fsVar != null) {
                    String str2 = jad_fsVar.jad_er;
                    if (!TextUtils.isEmpty(str2)) {
                        ArrayList arrayList2 = new ArrayList();
                        jad_er jad_erVar2 = new jad_er();
                        jad_erVar2.jad_an = str2;
                        String.valueOf(size);
                        arrayList2.add(jad_erVar2);
                        list = arrayList2;
                    } else {
                        list = jad_fsVar.jad_fs;
                    }
                } else {
                    list = null;
                }
                if (list != null && !list.isEmpty()) {
                    arrayList.addAll(list);
                }
            }
        }
        if (!arrayList.isEmpty() && (jad_erVar = (jad_er) arrayList.get(0)) != null && !TextUtils.isEmpty(jad_erVar.jad_an)) {
            return jad_erVar.jad_an;
        }
        return "";
    }

    public final jad_fs jad_cp(String str) {
        List<jad_fs> jad_dq;
        if (jad_er(str) == null || (jad_dq = jad_dq(str)) == null || jad_dq.isEmpty()) {
            return null;
        }
        return jad_dq.get(0);
    }

    @Nullable
    public List<jad_fs> jad_dq(String str) {
        List<jad_dq> list;
        jad_hu jad_huVar;
        jad_jt jad_er = jad_er(str);
        if (jad_er == null) {
            return null;
        }
        jad_jt jad_er2 = jad_er(str);
        if (jad_er2 != null && (jad_huVar = jad_er2.jad_cp) != null) {
            list = jad_huVar.jad_an;
        } else {
            list = null;
        }
        if (list == null || list.isEmpty() || jad_er.jad_cp.jad_an.get(0).jad_bo == null || jad_er.jad_cp.jad_an.get(0).jad_bo.jad_an == null || jad_er.jad_cp.jad_an.get(0).jad_bo.jad_an.isEmpty()) {
            return null;
        }
        return jad_er.jad_cp.jad_an.get(0).jad_bo.jad_an;
    }

    public jad_jt jad_er(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return jad_jt.jad_an(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
