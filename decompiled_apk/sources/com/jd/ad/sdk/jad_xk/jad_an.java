package com.jd.ad.sdk.jad_xk;

import android.text.TextUtils;
import com.jd.ad.sdk.jad_xk.jad_ly;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public abstract class jad_an {
    public URLConnection jad_an;

    public final jad_fs jad_an(Map<String, List<String>> map) {
        jad_fs jad_fsVar = new jad_fs();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !value.isEmpty()) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    jad_fsVar.jad_an(key, it.next());
                }
            }
        }
        return jad_fsVar;
    }

    public abstract URLConnection jad_an(jad_kx jad_kxVar);

    public abstract void jad_an();

    public jad_ly jad_bo(jad_kx jad_kxVar) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        long length;
        if (com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_kxVar.jad_an, 2)) {
            jad_fs jad_fsVar = jad_kxVar.jad_bo;
            jad_er jad_erVar = jad_kxVar.jad_fs;
            if (jad_erVar != null && jad_fsVar != null) {
                byte[] bArr = jad_erVar.jad_an;
                if (bArr == null) {
                    length = 0;
                } else {
                    length = bArr.length;
                }
                jad_fsVar.jad_bo("Content-Length", Long.toString(length));
                jad_fsVar.jad_bo("Content-Type", "application/stream");
            }
            URLConnection jad_an = jad_an(jad_kxVar);
            this.jad_an = jad_an;
            if (jad_erVar != null) {
                try {
                    OutputStream outputStream = jad_an.getOutputStream();
                    if (outputStream instanceof BufferedOutputStream) {
                        bufferedOutputStream = (BufferedOutputStream) outputStream;
                    } else {
                        bufferedOutputStream = new BufferedOutputStream(outputStream);
                    }
                    byte[] bArr2 = jad_erVar.jad_an;
                    if (bArr2 != null) {
                        bufferedOutputStream.write(bArr2);
                        bufferedOutputStream.flush();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Exception e) {
                    throw new com.jd.ad.sdk.jad_zm.jad_cp(e);
                }
            }
        } else {
            this.jad_an = jad_an(jad_kxVar);
        }
        try {
            int responseCode = ((jad_hu) this).jad_bo.getResponseCode();
            if (responseCode >= 400) {
                int i = jad_ly.jad_er;
                jad_ly.jad_an jad_anVar = new jad_ly.jad_an();
                jad_anVar.jad_an = responseCode;
                jad_anVar.jad_bo = null;
                jad_anVar.jad_cp = null;
                jad_anVar.jad_dq = this;
                return new jad_ly(jad_anVar);
            }
            InputStream inputStream = this.jad_an.getInputStream();
            if (inputStream instanceof BufferedInputStream) {
                bufferedInputStream = (BufferedInputStream) inputStream;
            } else {
                bufferedInputStream = new BufferedInputStream(inputStream);
            }
            if (jad_kxVar.jad_hu != null) {
                jad_fs jad_an2 = jad_an(this.jad_an.getHeaderFields());
                jad_na jad_naVar = new jad_na(jad_an2.jad_an("Content-Type"), bufferedInputStream);
                int i2 = jad_ly.jad_er;
                jad_ly.jad_an jad_anVar2 = new jad_ly.jad_an();
                jad_anVar2.jad_an = responseCode;
                jad_anVar2.jad_bo = jad_an2;
                jad_anVar2.jad_cp = jad_naVar;
                jad_anVar2.jad_dq = this;
                return new jad_ly(jad_anVar2);
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            bufferedInputStream.close();
            jad_an();
            return null;
        } catch (SocketTimeoutException e2) {
            throw new com.jd.ad.sdk.jad_zm.jad_bo(String.format("Read data time out: %1$s.", this.jad_an.getURL().toString()), e2);
        } catch (Exception e3) {
            if (e3 instanceof com.jd.ad.sdk.jad_zm.jad_bo) {
                throw new com.jd.ad.sdk.jad_zm.jad_bo(e3);
            }
            throw new com.jd.ad.sdk.jad_zm.jad_bo(new Exception(jad_kxVar.jad_er, e3));
        }
    }
}
