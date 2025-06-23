package com.jd.ad.sdk.jad_ob;

import android.text.TextUtils;
import android.util.Base64;
import com.jd.ad.sdk.bl.initsdk.JADPrivateController;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;
import com.jd.ad.sdk.jad_sf.jad_an;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes10.dex */
public class jad_dq {
    public JADPrivateController jad_jw;
    public String jad_an = "";
    public String jad_bo = "";
    public String jad_cp = "0.0.0.0";
    public JADLocation jad_dq = new JADLocation();
    public boolean jad_er = true;
    public boolean jad_fs = true;
    public boolean jad_jt = true;
    public final CopyOnWriteArrayList<String> jad_hu = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<String> jad_iv = new CopyOnWriteArrayList<>();

    /* loaded from: classes10.dex */
    public static class jad_an {
        public static final jad_dq jad_an = new jad_dq();
    }

    public String jad_an() {
        if (!TextUtils.isEmpty(this.jad_cp) && !"0.0.0.0".equals(this.jad_cp)) {
            return this.jad_cp;
        }
        String str = (String) jad_an.jad_bo.jad_an.jad_an("ipCustom", String.class);
        if (!TextUtils.isEmpty(str)) {
            String str2 = new String(Base64.decode(str.getBytes(), 10));
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return "0.0.0.0";
    }

    public String jad_bo() {
        if (!TextUtils.isEmpty(this.jad_an)) {
            return this.jad_an;
        }
        JADPrivateController jADPrivateController = this.jad_jw;
        if (jADPrivateController != null) {
            String oaid = jADPrivateController.getOaid();
            this.jad_an = oaid;
            if (!TextUtils.isEmpty(oaid)) {
                jad_an.jad_bo.jad_an.jad_an("oidCustom", this.jad_an);
                return this.jad_an;
            }
        }
        String jad_an2 = jad_an.jad_bo.jad_an.jad_an("oidCustom");
        this.jad_an = jad_an2;
        return jad_an2;
    }

    public boolean jad_an(String str) {
        return this.jad_hu.contains(str) && !this.jad_iv.contains(str);
    }
}
