package com.jd.ad.sdk.jad_xg;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity;
import com.jd.ad.sdk.jad_fs.jad_cp;
import com.jd.ad.sdk.jad_ly.jad_bo;
import com.jd.ad.sdk.jad_ly.jad_cp;
import com.jd.ad.sdk.jad_vi.jad_iv;
import com.jd.ad.sdk.mdt.service.JADTouchService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_iv implements JADTouchService {
    public final String[] jad_an(com.jd.ad.sdk.jad_fs.jad_bo jad_boVar, String str) {
        List<String> emptyList;
        com.jd.ad.sdk.jad_wj.jad_fs jad_cp = jad_bo.jad_an.jad_an.jad_cp(str);
        if (jad_cp != null) {
            emptyList = jad_cp.jad_kx;
        } else {
            emptyList = Collections.emptyList();
        }
        if (emptyList != null) {
            String[] strArr = (String[]) emptyList.toArray(new String[0]);
            if (strArr != null && strArr.length != 0) {
                String[] strArr2 = new String[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    strArr2[i] = jad_boVar.jad_an(strArr[i]);
                }
                return strArr2;
            }
            return strArr;
        }
        return new String[0];
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public int onViewClicked(@NonNull Context context, @NonNull View view, @NonNull String str) {
        String str2;
        String str3;
        com.jd.ad.sdk.jad_fs.jad_bo jad_boVar = jad_cp.jad_an.jad_an.jad_an.get(str);
        if (jad_boVar == null) {
            jad_boVar = null;
        }
        if (jad_boVar == null) {
            return -2;
        }
        String str4 = jad_cp.jad_an.jad_an.jad_an.get(str);
        String str5 = "";
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        if (TextUtils.isEmpty(str4)) {
            return -2;
        }
        com.jd.ad.sdk.jad_ly.jad_bo jad_boVar2 = jad_bo.jad_an.jad_an;
        com.jd.ad.sdk.jad_wj.jad_fs jad_cp = jad_boVar2.jad_cp(str4);
        if (jad_cp == null || TextUtils.isEmpty(jad_cp.jad_dq)) {
            str2 = "";
        } else {
            str2 = jad_cp.jad_dq;
        }
        com.jd.ad.sdk.jad_wj.jad_fs jad_cp2 = jad_boVar2.jad_cp(str4);
        if (jad_cp2 == null || TextUtils.isEmpty(jad_cp2.jad_cp)) {
            str3 = "";
        } else {
            str3 = jad_cp2.jad_cp;
        }
        com.jd.ad.sdk.jad_wj.jad_fs jad_cp3 = jad_boVar2.jad_cp(str4);
        if (jad_cp3 != null && !TextUtils.isEmpty(jad_cp3.jad_ly)) {
            str5 = jad_cp3.jad_ly;
        }
        if ("1".equals(str5) && !TextUtils.isEmpty(str2) && com.jd.ad.sdk.jad_er.jad_an.jad_an(context, jad_boVar.jad_an(str2))) {
            jad_iv.jad_cp.jad_an.jad_an(jad_an(jad_boVar, str4));
            return 1;
        }
        if (!"1".equals(str5) || TextUtils.isEmpty(str3)) {
            return 2;
        }
        String jad_an = jad_boVar.jad_an(str3);
        if (TextUtils.isEmpty(jad_an)) {
            return 2;
        }
        if (!TextUtils.isEmpty(jad_an) && context != null) {
            try {
                JADWebViewActivity.startActivity(context, jad_an);
                jad_iv.jad_cp.jad_an.jad_an(jad_an(jad_boVar, str4));
                return 0;
            } catch (Exception unused) {
                return 3;
            }
        }
        return 3;
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void onViewTouch(@NonNull View view, @NonNull MotionEvent motionEvent, @NonNull String str) {
        com.jd.ad.sdk.jad_fs.jad_an jad_anVar;
        com.jd.ad.sdk.jad_fs.jad_bo jad_boVar = jad_cp.jad_an.jad_an.jad_an.get(str);
        if (jad_boVar == null) {
            jad_boVar = null;
        }
        if (jad_boVar != null && (jad_anVar = jad_boVar.jad_an) != null && motionEvent != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return;
                        }
                    } else {
                        if (jad_anVar.jad_an.size() > 999) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(jad_anVar.jad_an.get(0));
                            arrayList.addAll(jad_anVar.jad_an.subList(r0.size() - 399, jad_anVar.jad_an.size()));
                            jad_anVar.jad_an.clear();
                            jad_anVar.jad_an.addAll(arrayList);
                            arrayList.clear();
                        }
                        jad_anVar.jad_an.add(new com.jd.ad.sdk.jad_fs.jad_dq(new Double(motionEvent.getX()).intValue(), new Double(motionEvent.getY()).intValue(), System.currentTimeMillis()));
                        return;
                    }
                }
                jad_anVar.jad_cp = new com.jd.ad.sdk.jad_fs.jad_dq(new Double(motionEvent.getX()).intValue(), new Double(motionEvent.getY()).intValue(), System.currentTimeMillis());
                return;
            }
            jad_anVar.jad_an.clear();
            jad_anVar.jad_bo = new com.jd.ad.sdk.jad_fs.jad_dq(Math.round(motionEvent.getX()), Math.round(motionEvent.getY()), System.currentTimeMillis());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void registerTouchView(@NonNull String str) {
        com.jd.ad.sdk.jad_fs.jad_cp jad_cpVar = jad_cp.jad_an.jad_an;
        if (jad_cpVar.jad_an.get(str) == null) {
            jad_cpVar.jad_an.put(str, new com.jd.ad.sdk.jad_fs.jad_bo());
        }
    }

    @Override // com.jd.ad.sdk.mdt.service.JADTouchService
    public void unregisterTouchView(@NonNull String str) {
        com.jd.ad.sdk.jad_fs.jad_cp jad_cpVar = jad_cp.jad_an.jad_an;
        if (jad_cpVar.jad_an.get(str) != null) {
            jad_cpVar.jad_an.remove(str);
        }
    }
}
