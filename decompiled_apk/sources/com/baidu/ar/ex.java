package com.baidu.ar;

import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
class ex implements ev {
    private Charset rA;
    private int se = 0;
    private String sb = eo.MULTIPART_BOUNDARY;
    private StringBuilder rB = new StringBuilder();
    private Map<String, byte[]> sd = new HashMap();
    private Map<String, String> sc = new HashMap();

    private InputStream a(String str, String str2, String str3, String str4, boolean z) {
        StringBuilder sb = new StringBuilder();
        String format = String.format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"", eu.a(str2, this.rA), eu.a(str3, this.rA));
        sb.append(str);
        sb.append(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        sb.append(this.sb);
        sb.append("\r\n");
        sb.append(format);
        sb.append("\r\n");
        sb.append("Content-Type:");
        sb.append(str4);
        sb.append(com.huawei.openalliance.ad.constant.x.aL);
        if (z) {
            sb.append("charset=");
            sb.append(this.rA.name());
        }
        sb.append("\r\n");
        sb.append("\r\n");
        return new ByteArrayInputStream(sb.toString().getBytes(this.rA));
    }

    public void aF(String str) {
        this.sb = str;
    }

    @Override // com.baidu.ar.ev
    public InputStream[] dI() {
        ArrayList arrayList = new ArrayList();
        if (this.rB.length() > 0) {
            arrayList.add(new ByteArrayInputStream(this.rB.toString().getBytes(this.rA)));
        }
        String str = "";
        if (!this.sc.isEmpty()) {
            String str2 = "";
            for (Map.Entry<String, String> entry : this.sc.entrySet()) {
                arrayList.add(a(str2, entry.getKey(), new File(entry.getValue()).getName(), eu.aD(entry.getValue()), false));
                arrayList.add(new FileInputStream(entry.getValue()));
                str2 = "\r\n";
            }
            str = str2;
        }
        if (!this.sd.isEmpty()) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            int i = 1;
            String str3 = str;
            for (Map.Entry<String, byte[]> entry2 : this.sd.entrySet()) {
                arrayList.add(a(str3, entry2.getKey(), valueOf + i + ".jpg", "application/octet-stream", true));
                arrayList.add(new ByteArrayInputStream(entry2.getValue()));
                str3 = "\r\n";
                i++;
            }
            str = str3;
        }
        if (!this.sc.isEmpty() || !this.sd.isEmpty()) {
            arrayList.add(new ByteArrayInputStream((str + HelpFormatter.DEFAULT_LONG_OPT_PREFIX + this.sb + HelpFormatter.DEFAULT_LONG_OPT_PREFIX + "\r\n").getBytes(this.rA)));
        }
        return (InputStream[]) arrayList.toArray(new InputStream[arrayList.size()]);
    }

    public String getBoundary() {
        return this.sb;
    }

    @Override // com.baidu.ar.ev
    public String getContentType() {
        return "multipart/form-data;boundary=" + getBoundary();
    }

    @Override // com.baidu.ar.ev
    public int getSize() {
        return this.se;
    }

    public boolean isEmpty() {
        return this.rB.length() == 0 && this.sd.isEmpty() && this.sc.isEmpty();
    }

    public void k(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        StringBuilder sb = this.rB;
        sb.append(HelpFormatter.DEFAULT_LONG_OPT_PREFIX);
        sb.append(this.sb);
        sb.append("\r\n");
        StringBuilder sb2 = this.rB;
        sb2.append("Content-Disposition: form-data; name=\"");
        sb2.append(eu.a(str, this.rA));
        sb2.append("\"\r\n");
        this.rB.append("\r\n");
        this.rB.append(eu.a(str2, this.rA));
        this.rB.append("\r\n");
    }

    public void l(String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            this.se = (int) (this.se + file.length());
        }
        this.sc.put(str, str2);
    }

    public void a(String str, byte[] bArr) {
        if (bArr != null) {
            this.se += bArr.length;
        }
        this.sd.put(str, bArr);
    }

    @Override // com.baidu.ar.ev
    public void a(Charset charset) {
        this.rA = charset;
    }
}
