package com.baidu.ar.ihttp;

import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.fa;
import com.baidu.ar.km;
import com.baidu.ar.ko;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpHead;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* loaded from: classes7.dex */
public final class Downloader {
    private String nS;
    private int sh = 0;

    public Downloader(String str) {
        this.nS = str;
    }

    public static int getNetFileSize(String str) {
        return HttpFactory.newRequest().setUrl(str).setMethod(HttpHead.METHOD_NAME).execute().getContentLength();
    }

    public int download(String str, IProgressCallback iProgressCallback) {
        int fileSize = getFileSize();
        IHttpResponse execute = HttpFactory.newRequest().setUrl(this.nS).setMethod("GET").execute();
        if (!execute.isSuccess()) {
            throw new HttpException(4, "下载失败");
        }
        a(execute.getStream(), str, fileSize, iProgressCallback);
        return fileSize;
    }

    public IHttpRequest downloadAsync(String str, ICallbackWith<Integer> iCallbackWith, ICallbackWith<Exception> iCallbackWith2) {
        return downloadAsync(str, iCallbackWith, iCallbackWith2, null);
    }

    public int getFileSize() {
        if (this.sh == 0) {
            this.sh = getNetFileSize(this.nS);
        }
        return this.sh;
    }

    public IHttpRequest downloadAsync(final String str, final ICallbackWith<Integer> iCallbackWith, final ICallbackWith<Exception> iCallbackWith2, final IProgressCallback iProgressCallback) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        newRequest.setUrl(this.nS).setMethod(HttpHead.METHOD_NAME).enqueue(new fa() { // from class: com.baidu.ar.ihttp.Downloader.1
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                iCallbackWith2.run(httpException);
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                Downloader.this.sh = iHttpResponse.getContentLength();
                try {
                    Downloader.this.download(str, iProgressCallback);
                    iCallbackWith.run(Integer.valueOf(Downloader.this.sh));
                } catch (Exception e) {
                    e.printStackTrace();
                    iCallbackWith2.run(e);
                }
            }
        });
        return newRequest;
    }

    private static void a(InputStream inputStream, String str, int i, IProgressCallback iProgressCallback) {
        RandomAccessFile randomAccessFile;
        km.e(new File(str));
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
            try {
                randomAccessFile.seek(0L);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream, 8192);
                int i2 = 0;
                while (true) {
                    try {
                        int read = bufferedInputStream2.read(bArr, 0, 8192);
                        if (read == -1) {
                            ko.closeQuietly(bufferedInputStream2);
                            ko.closeQuietly(randomAccessFile);
                            return;
                        } else {
                            randomAccessFile.write(bArr, 0, read);
                            i2 += read;
                            if (iProgressCallback != null) {
                                iProgressCallback.onProgress(i2, i);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        ko.closeQuietly(bufferedInputStream);
                        ko.closeQuietly(randomAccessFile);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }
}
