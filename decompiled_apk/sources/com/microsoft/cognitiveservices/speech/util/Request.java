package com.microsoft.cognitiveservices.speech.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* loaded from: classes11.dex */
class Request implements Runnable {
    private byte[] m_body;
    private HttpURLConnection m_connection;
    private final HttpClient m_parent;
    private String m_request_id;

    public Request(HttpClient httpClient, String str, String str2, byte[] bArr, String str3, int[] iArr, byte[] bArr2) throws IOException {
        this.m_parent = httpClient;
        HttpURLConnection httpURLConnection = (HttpURLConnection) httpClient.newUrl(str).openConnection();
        this.m_connection = httpURLConnection;
        httpURLConnection.setRequestMethod(str2);
        this.m_body = bArr;
        if (bArr.length > 0) {
            this.m_connection.setFixedLengthStreamingMode(bArr.length);
            this.m_connection.setDoOutput(true);
        }
        this.m_request_id = str3;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 >= iArr.length) {
                return;
            }
            int i4 = iArr[i];
            Charset charset = StandardCharsets.UTF_8;
            String str4 = new String(bArr2, i2, i4, charset);
            int i5 = i2 + iArr[i];
            String str5 = new String(bArr2, i5, iArr[i3], charset);
            i2 = i5 + iArr[i3];
            this.m_connection.setRequestProperty(str4, str5);
            i += 2;
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public void run() {
        int i;
        String[] strArr;
        int i2 = 0;
        String[] strArr2 = new String[0];
        byte[] bArr = new byte[0];
        try {
            try {
                if (this.m_body.length > 0) {
                    this.m_connection.getOutputStream().write(this.m_body);
                }
                i = this.m_connection.getResponseCode();
                try {
                    Map<String, List<String>> headerFields = this.m_connection.getHeaderFields();
                    Vector vector = new Vector();
                    for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                        if (entry.getKey() != null) {
                            for (String str : entry.getValue()) {
                                vector.add(entry.getKey());
                                vector.add(str);
                            }
                        }
                    }
                    strArr = (String[]) vector.toArray(strArr2);
                    try {
                        BufferedInputStream bufferedInputStream = i >= 300 ? new BufferedInputStream(this.m_connection.getErrorStream()) : new BufferedInputStream(this.m_connection.getInputStream());
                        byte[] bArr2 = new byte[1024];
                        Vector vector2 = new Vector();
                        int i3 = 0;
                        while (true) {
                            int read = bufferedInputStream.read(bArr2, 0, 1024);
                            if (read < 0) {
                                break;
                            } else if (read > 0) {
                                vector2.add(Arrays.copyOfRange(bArr2, 0, read));
                                i3 += read;
                            }
                        }
                        bArr = new byte[i3];
                        Iterator it = vector2.iterator();
                        int i4 = 0;
                        while (it.hasNext()) {
                            for (byte b : (byte[]) it.next()) {
                                bArr[i4] = b;
                                i4++;
                            }
                        }
                        this.m_connection.disconnect();
                    } catch (Exception unused) {
                        i2 = i;
                        strArr2 = strArr;
                        this.m_connection.disconnect();
                        i = i2;
                        strArr = strArr2;
                        this.m_parent.dispatchCallback(this.m_request_id, i, strArr, bArr);
                    }
                } catch (Exception unused2) {
                    i2 = i;
                }
            } catch (Throwable th) {
                this.m_connection.disconnect();
                throw th;
            }
        } catch (Exception unused3) {
        }
        this.m_parent.dispatchCallback(this.m_request_id, i, strArr, bArr);
    }
}
