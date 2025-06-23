package com.baidu.tts;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.tools.CommonUtility;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class h4 extends i4 {
    public final File b;
    public final boolean c;
    public File d;
    public long e;
    public boolean f;

    public h4(File file) {
        boolean z;
        if (file != null) {
            z = true;
        } else {
            z = false;
        }
        CommonUtility.asserts(z, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
        if (!file.isDirectory() && !file.getParentFile().isDirectory()) {
            CommonUtility.asserts(file.getParentFile().mkdirs(), "Cannot create parent directories for requested File location");
        }
        if (file.isDirectory() && !file.mkdirs()) {
            LoggerProxy.d("FileAsyncHttpRH", "Cannot create directories for requested Directory location, might not be a problem");
        }
        this.b = file;
        this.c = false;
        this.e = 0L;
        this.f = false;
    }

    public abstract void a(int i, Map<String, List<String>> map, File file);

    public abstract void a(int i, Map<String, List<String>> map, Throwable th, File file);

    public void a(long j, long j2) {
    }

    public File b() {
        File a2;
        boolean z;
        String str;
        File file;
        if (this.d == null) {
            if (a().isDirectory()) {
                CommonUtility.asserts(a().isDirectory(), "Target file is not a directory, cannot proceed");
                if (this.f10110a != null) {
                    z = true;
                } else {
                    z = false;
                }
                CommonUtility.asserts(z, "RequestURI is null, cannot proceed");
                String uri = this.f10110a.toString();
                String substring = uri.substring(uri.lastIndexOf(47) + 1, uri.length());
                a2 = new File(a(), substring);
                if (a2.exists() && this.c) {
                    if (!substring.contains(FileUtils.FILE_EXTENSION_SEPARATOR)) {
                        str = substring + " (%d)";
                    } else {
                        str = substring.substring(0, substring.lastIndexOf(46)) + " (%d)" + substring.substring(substring.lastIndexOf(46), substring.length());
                    }
                    int i = 0;
                    while (true) {
                        file = new File(a(), String.format(str, Integer.valueOf(i)));
                        if (!file.exists()) {
                            break;
                        }
                        i++;
                    }
                    a2 = file;
                }
            } else {
                a2 = a();
            }
            this.d = a2;
        }
        return this.d;
    }

    @Override // com.baidu.tts.i4
    public void a(d4 d4Var) {
        InputStream inputStream;
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        int i = d4Var.d;
        Map<String, List<String>> map = d4Var.c;
        if (i == 416) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            a(i, map, (Throwable) null, (File) null);
            return;
        }
        if (i > 300) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            a(i, map, new Exception("response failed "), (File) null);
            return;
        }
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        List<String> list = map.get("Content-Range");
        if (list == null) {
            this.f = false;
            this.e = 0L;
        } else {
            LoggerProxy.v("RangeFileAsyncHttpRH", " HEADER_CONTENT_RANGE: " + ((Object) list.get(0)));
        }
        try {
            inputStream = d4Var.b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (inputStream != null) {
            long j = d4Var.f10072a;
            FileOutputStream fileOutputStream = new FileOutputStream(b(), this.f);
            try {
                byte[] bArr = new byte[4096];
                int i2 = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1 || Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    i2 += read;
                    fileOutputStream.write(bArr, 0, read);
                    a(i2, j);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                a(i, map, b());
                return;
            } catch (Throwable th) {
                fileOutputStream.flush();
                fileOutputStream.close();
                throw th;
            }
        }
        throw new IllegalStateException("response getInputstream is null");
    }

    public void a(HttpURLConnection httpURLConnection) {
        if (this.b.exists() && this.b.canWrite()) {
            this.e = this.b.length();
        }
        if (this.e > 0) {
            this.f = true;
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.e + HelpFormatter.DEFAULT_OPT_PREFIX);
        }
    }

    public File a() {
        CommonUtility.asserts(this.b != null, "Target file is null, fatal!");
        return this.b;
    }

    @Override // com.baidu.tts.i4
    public void a(int i, Map map, String str, byte[] bArr) {
        a(i, map, b());
    }

    @Override // com.baidu.tts.i4
    public void a(int i, Map map, String str, byte[] bArr, Throwable th) {
        a(i, (Map<String, List<String>>) map, th, b());
    }
}
