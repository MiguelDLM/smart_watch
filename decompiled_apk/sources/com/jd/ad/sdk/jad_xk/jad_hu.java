package com.jd.ad.sdk.jad_xk;

import android.text.TextUtils;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes10.dex */
public final class jad_hu extends jad_an {
    public static String[] jad_cp = new String[0];
    public HttpsURLConnection jad_bo;

    @Override // com.jd.ad.sdk.jad_xk.jad_an
    public void jad_an() {
        HttpsURLConnection httpsURLConnection = this.jad_bo;
        if (httpsURLConnection != null) {
            InputStream inputStream = httpsURLConnection.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
            this.jad_bo.disconnect();
        }
    }

    @Override // com.jd.ad.sdk.jad_xk.jad_an
    public URLConnection jad_an(jad_kx jad_kxVar) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(jad_kxVar.jad_er).openConnection();
        this.jad_bo = httpsURLConnection;
        httpsURLConnection.setConnectTimeout(jad_kxVar.jad_cp);
        this.jad_bo.setReadTimeout(jad_kxVar.jad_dq);
        this.jad_bo.setInstanceFollowRedirects(jad_kxVar.jad_jt);
        int i = jad_kxVar.jad_an;
        this.jad_bo.setRequestMethod(jad_jw.jad_an(i));
        this.jad_bo.setDoInput(true);
        this.jad_bo.setDoOutput(com.jd.ad.sdk.jad_jt.jad_fs.jad_an(i, 2));
        this.jad_bo.setUseCaches(false);
        jad_fs jad_fsVar = jad_kxVar.jad_bo;
        if (jad_fsVar != null) {
            List<String> list = jad_fsVar.jad_an.get("Connection");
            if (list != null && !list.isEmpty()) {
                jad_fsVar.jad_bo("Connection", list.get(0));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, List<String>> entry : jad_fsVar.jad_an.entrySet()) {
                linkedHashMap.put(entry.getKey(), TextUtils.join("; ", entry.getValue()));
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                this.jad_bo.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
            }
        }
        this.jad_bo.setSSLSocketFactory(new jad_mz(com.jd.ad.sdk.jad_do.jad_bo.jad_an()));
        this.jad_bo.setHostnameVerifier(new jad_jt());
        this.jad_bo.connect();
        return this.jad_bo;
    }
}
