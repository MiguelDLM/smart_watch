package com.jd.ad.sdk.jad_sb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: classes10.dex */
public class jad_an implements Closeable {

    @NonNull
    public final HttpURLConnection jad_an;

    public jad_an(@NonNull HttpURLConnection httpURLConnection) {
        this.jad_an = httpURLConnection;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.jad_an.disconnect();
    }

    @Nullable
    public String jad_bo() {
        try {
            if (jad_cp()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to fetch ");
            sb.append(this.jad_an.getURL());
            sb.append(". Failed with ");
            sb.append(this.jad_an.getResponseCode());
            sb.append("\n");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.jad_an.getErrorStream()));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb2.append(readLine);
                        sb2.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            }
            bufferedReader.close();
            sb.append(sb2.toString());
            return sb.toString();
        } catch (IOException e) {
            com.jd.ad.sdk.jad_ve.jad_dq.jad_an("get error failed ", e);
            return e.getMessage();
        }
    }

    public boolean jad_cp() {
        try {
            return this.jad_an.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }
}
