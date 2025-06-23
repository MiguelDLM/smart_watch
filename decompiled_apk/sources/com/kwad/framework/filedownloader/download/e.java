package com.kwad.framework.filedownloader.download;

import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes11.dex */
public final class e {
    private final String Wx;
    private final long agE;
    long agF;
    private final long agG;
    private final com.kwad.framework.filedownloader.b.a agL;
    private final boolean agT;
    private final int agw;
    private final c ahL;
    private final com.kwad.framework.filedownloader.a.b ahM;
    private com.kwad.framework.filedownloader.e.a ahN;
    private volatile long ahO;
    private volatile long ahP;
    private final f aht;
    private final int ahv;
    private final long contentLength;
    private volatile boolean kH;

    /* loaded from: classes11.dex */
    public static class a {
        String Wx;
        Integer agC;
        com.kwad.framework.filedownloader.download.a agD;
        com.kwad.framework.filedownloader.a.b ahM;
        c ahQ;
        Boolean ahq;
        f aht;
        Integer ahx;

        public final a a(c cVar) {
            this.ahQ = cVar;
            return this;
        }

        public final a b(f fVar) {
            this.aht = fVar;
            return this;
        }

        public final a bf(boolean z) {
            this.ahq = Boolean.valueOf(z);
            return this;
        }

        public final a bo(String str) {
            this.Wx = str;
            return this;
        }

        public final a bv(int i) {
            this.ahx = Integer.valueOf(i);
            return this;
        }

        public final a bw(int i) {
            this.agC = Integer.valueOf(i);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.download.a aVar) {
            this.agD = aVar;
            return this;
        }

        public final a d(com.kwad.framework.filedownloader.a.b bVar) {
            this.ahM = bVar;
            return this;
        }

        public final e ww() {
            com.kwad.framework.filedownloader.a.b bVar;
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num;
            if (this.ahq != null && (bVar = this.ahM) != null && (aVar = this.agD) != null && this.aht != null && this.Wx != null && (num = this.agC) != null && this.ahx != null) {
                return new e(bVar, aVar, this.ahQ, num.intValue(), this.ahx.intValue(), this.ahq.booleanValue(), this.aht, this.Wx, (byte) 0);
            }
            throw new IllegalArgumentException();
        }
    }

    public /* synthetic */ e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str, byte b) {
        this(bVar, aVar, cVar, i, i2, z, fVar, str);
    }

    private void sync() {
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.ahN.xm();
            if (this.ahL != null) {
                this.agL.a(this.agw, this.ahv, this.agF);
            } else {
                this.aht.we();
            }
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.agw), Integer.valueOf(this.ahv), Long.valueOf(this.agF), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        } catch (IOException e) {
            if (com.kwad.framework.filedownloader.f.d.ajb) {
                com.kwad.framework.filedownloader.f.d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e);
            }
        }
    }

    private void wv() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.kwad.framework.filedownloader.f.f.i(this.agF - this.ahO, elapsedRealtime - this.ahP)) {
            sync();
            this.ahO = this.agF;
            this.ahP = elapsedRealtime;
        }
    }

    public final void pause() {
        this.kH = true;
    }

    public final void run() {
        com.kwad.framework.filedownloader.e.a aVar;
        InputStream inputStream;
        String b;
        if (this.kH) {
            return;
        }
        long b2 = com.kwad.framework.filedownloader.f.f.b(this.ahv, this.ahM);
        if (b2 != 0) {
            long j = this.contentLength;
            if (j > 0 && b2 != j) {
                if (this.agG == 0) {
                    b = com.kwad.framework.filedownloader.f.f.b("range[%d-)", Long.valueOf(this.agF));
                } else {
                    b = com.kwad.framework.filedownloader.f.f.b("range[%d-%d)", Long.valueOf(this.agF), Long.valueOf(this.agG));
                }
                throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem.", b, Long.valueOf(this.contentLength), Long.valueOf(b2), Integer.valueOf(this.agw), Integer.valueOf(this.ahv)));
            }
            long j2 = this.agF;
            try {
                boolean vW = b.vS().vW();
                if (this.ahL != null && !vW) {
                    throw new IllegalAccessException("can't using multi-download when the output stream can't support seek");
                }
                com.kwad.framework.filedownloader.e.a bD = com.kwad.framework.filedownloader.f.f.bD(this.Wx);
                try {
                    this.ahN = bD;
                    if (vW) {
                        bD.seek(this.agF);
                    }
                    if (com.kwad.framework.filedownloader.f.d.ajb) {
                        aVar = bD;
                        try {
                            com.kwad.framework.filedownloader.f.d.c(this, "start fetch(%d): range [%d, %d), seek to[%d]", Integer.valueOf(this.ahv), Long.valueOf(this.agE), Long.valueOf(this.agG), Long.valueOf(this.agF));
                        } catch (Throwable th) {
                            th = th;
                            inputStream = null;
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                            throw th;
                        }
                    } else {
                        aVar = bD;
                    }
                    inputStream = this.ahM.getInputStream();
                } catch (Throwable th2) {
                    th = th2;
                    aVar = bD;
                }
                try {
                    byte[] bArr = new byte[4096];
                    if (this.kH) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                        return;
                    }
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        aVar.write(bArr, 0, read);
                        long j3 = read;
                        this.agF += j3;
                        this.aht.onProgress(j3);
                        wv();
                        if (this.kH) {
                            break;
                        } else if (this.agT && com.kwad.framework.filedownloader.f.f.xw()) {
                            throw new FileDownloadNetworkPolicyException();
                        }
                    }
                    if (aVar != null) {
                        sync();
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    long j4 = this.agF - j2;
                    if (b2 != -1 && b2 != j4) {
                        throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset", Long.valueOf(j4), Long.valueOf(b2), Long.valueOf(this.agE), Long.valueOf(this.agG), Long.valueOf(this.agF), Long.valueOf(j2)));
                    }
                    this.aht.a(this.ahL, this.agE, this.agG);
                } catch (Throwable th3) {
                    th = th3;
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                aVar = null;
            }
        } else {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.b("there isn't any content need to download on %d-%d with the content-length is 0", Integer.valueOf(this.agw), Integer.valueOf(this.ahv)));
        }
    }

    private e(com.kwad.framework.filedownloader.a.b bVar, com.kwad.framework.filedownloader.download.a aVar, c cVar, int i, int i2, boolean z, f fVar, String str) {
        this.ahO = 0L;
        this.ahP = 0L;
        this.aht = fVar;
        this.Wx = str;
        this.ahM = bVar;
        this.agT = z;
        this.ahL = cVar;
        this.ahv = i2;
        this.agw = i;
        this.agL = b.vS().vU();
        this.agE = aVar.agE;
        this.agG = aVar.agG;
        this.agF = aVar.agF;
        this.contentLength = aVar.contentLength;
    }
}
