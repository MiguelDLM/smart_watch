package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class e extends k {
    private final p aDe;
    private final com.kwad.sdk.core.videocache.a.b aDf;
    private b aDg;

    public e(p pVar, com.kwad.sdk.core.videocache.a.b bVar) {
        super(pVar, bVar);
        this.aDf = bVar;
        this.aDe = pVar;
    }

    private String b(d dVar) {
        String str;
        String Hi = this.aDe.Hi();
        boolean isEmpty = TextUtils.isEmpty(Hi);
        long GY = this.aDf.isCompleted() ? this.aDf.GY() : this.aDe.length();
        boolean z = GY >= 0;
        boolean z2 = dVar.aDd;
        long j = z2 ? GY - dVar.aDc : GY;
        boolean z3 = z && z2;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.aDd ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        String str2 = "";
        sb.append(z ? format("Content-Length: %d\n", Long.valueOf(j)) : "");
        if (!z3) {
            str = "";
        } else {
            str = format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.aDc), Long.valueOf(GY - 1), Long.valueOf(GY));
        }
        sb.append(str);
        if (!isEmpty) {
            str2 = format("Content-Type: %s\n", Hi);
        }
        sb.append(str2);
        sb.append("\n");
        return sb.toString();
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public final void a(b bVar) {
        this.aDg = bVar;
    }

    @Override // com.kwad.sdk.core.videocache.k
    public final void dr(int i) {
        b bVar = this.aDg;
        if (bVar != null) {
            bVar.a(this.aDf.file, i);
        }
    }

    public final void a(d dVar, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j = dVar.aDc;
        if (a(dVar)) {
            a(bufferedOutputStream, j);
        } else {
            b(bufferedOutputStream, j);
        }
    }

    private boolean a(d dVar) {
        long length = this.aDe.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && dVar.aDd && ((float) dVar.aDc) > ((float) this.aDf.GY()) + (((float) length) * 0.2f)) ? false : true;
    }

    private void a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[1024];
        while (true) {
            int a2 = a(bArr, j, 1024);
            if (a2 == -1) {
                break;
            }
            try {
                outputStream.write(bArr, 0, a2);
                j += a2;
            } catch (Exception unused) {
            }
        }
        outputStream.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[Catch: all -> 0x0030, LOOP:0: B:8:0x0024->B:10:0x002b, LOOP_END, TryCatch #0 {all -> 0x0030, blocks: (B:7:0x001d, B:8:0x0024, B:10:0x002b, B:12:0x0032), top: B:6:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(java.io.OutputStream r3, long r4) {
        /*
            r2 = this;
            com.kwad.sdk.core.videocache.p r0 = r2.aDe
            boolean r1 = r0 instanceof com.kwad.sdk.core.videocache.h
            if (r1 == 0) goto Lf
            com.kwad.sdk.core.videocache.h r1 = new com.kwad.sdk.core.videocache.h
            com.kwad.sdk.core.videocache.h r0 = (com.kwad.sdk.core.videocache.h) r0
            r1.<init>(r0)
        Ld:
            r0 = r1
            goto L1b
        Lf:
            boolean r1 = r0 instanceof com.kwad.sdk.core.videocache.j
            if (r1 == 0) goto L1b
            com.kwad.sdk.core.videocache.j r1 = new com.kwad.sdk.core.videocache.j
            com.kwad.sdk.core.videocache.j r0 = (com.kwad.sdk.core.videocache.j) r0
            r1.<init>(r0)
            goto Ld
        L1b:
            int r5 = (int) r4
            long r4 = (long) r5
            r0.aA(r4)     // Catch: java.lang.Throwable -> L30
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L30
        L24:
            int r5 = r0.read(r4)     // Catch: java.lang.Throwable -> L30
            r1 = -1
            if (r5 == r1) goto L32
            r1 = 0
            r3.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L30
            goto L24
        L30:
            r3 = move-exception
            goto L39
        L32:
            r3.flush()     // Catch: java.lang.Throwable -> L30
            r0.close()
            return
        L39:
            r0.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.e.b(java.io.OutputStream, long):void");
    }
}
