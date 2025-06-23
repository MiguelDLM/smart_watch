package com.jd.ad.sdk.jad_xk;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.util.StringTokenizer;
import java.util.TimeZone;

/* loaded from: classes10.dex */
public class jad_na implements Closeable {
    public String jad_an;
    public BufferedInputStream jad_bo;

    public jad_na(String str, BufferedInputStream bufferedInputStream) {
        this.jad_an = str;
        this.jad_bo = bufferedInputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_bo.close();
    }

    public String jad_bo() {
        String str;
        String str2 = this.jad_an;
        TimeZone timeZone = jad_fs.jad_bo;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty("charset")) {
            StringTokenizer stringTokenizer = new StringTokenizer(str2, x.aL);
            while (stringTokenizer.hasMoreElements()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf > 0 && "charset".equalsIgnoreCase(nextToken.substring(0, indexOf).trim())) {
                    str = nextToken.substring(indexOf + 1).trim();
                    break;
                }
            }
        }
        str = "UTF-8";
        if (TextUtils.isEmpty(str)) {
            return new String(com.jd.ad.sdk.jad_do.jad_fs.jad_an(this.jad_bo), Charset.forName("UTF-8"));
        }
        return new String(com.jd.ad.sdk.jad_do.jad_fs.jad_an(this.jad_bo), str);
    }
}
