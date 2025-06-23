package com.baidu.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.s1;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes8.dex */
public class r1 extends x1 {
    public final /* synthetic */ String h;
    public final /* synthetic */ s1.a i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r1(s1.a aVar, File file, t1 t1Var, String str) {
        super(file, t1Var);
        this.i = aVar;
        this.h = str;
    }

    @Override // com.baidu.tts.h4
    public void a(int i, Map<String, List<String>> map, Throwable th, File file) {
        String str;
        LoggerProxy.d("DownloadEngine", "1isInterrupted=" + Thread.currentThread().isInterrupted());
        if (s1.this.b()) {
            if (th != null) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    str = th.getMessage();
                } else {
                    str = cause.getMessage();
                }
            } else {
                str = null;
            }
            LoggerProxy.d("ModelFileResponseHandler", "onFailure statuscode=" + i + "--msg=" + str);
            TtsError a2 = c3.a().a(x2.f10190I0);
            a2.setCode(i);
            a2.setMessage("download failure");
            a2.setThrowable(th);
            this.g.a(a2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0095, code lost:
    
        if (r5 == 7) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x009c, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009a, code lost:
    
        if (r4 == 7) goto L18;
     */
    @Override // com.baidu.tts.h4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r8, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r9, java.io.File r10) {
        /*
            r7 = this;
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "2isInterrupted="
            r8.append(r9)
            java.lang.Thread r9 = java.lang.Thread.currentThread()
            boolean r9 = r9.isInterrupted()
            r8.append(r9)
            java.lang.String r9 = "--fileId="
            r8.append(r9)
            java.lang.String r9 = r7.h
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "DownloadEngine"
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r9, r8)
            com.baidu.tts.s1$a r8 = r7.i
            com.baidu.tts.s1 r8 = com.baidu.tts.s1.this
            boolean r8 = r8.b()
            if (r8 == 0) goto Ld9
            java.lang.String r8 = "ModelFileResponseHandler"
            java.lang.String r9 = "onSuccess"
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r8, r9)
            com.baidu.tts.t1 r8 = r7.g
            com.baidu.tts.b2 r8 = r8.f10169a
            r8.getClass()
            java.lang.String r9 = "FsFileInfoFlyweight"
            java.lang.String r10 = "onDownloadSuccess"
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r9, r10)
            r9 = 7
            r8.d = r9
            r8.e = r9
            com.baidu.tts.a2 r10 = com.baidu.tts.a2.a()
            com.baidu.tts.e1 r0 = r10.b
            java.lang.String r1 = r8.f10041a
            int r2 = r8.e
            r0.a(r1, r2)
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r0 = r8.h
            if (r0 == 0) goto Ld9
            java.util.Iterator r0 = r0.iterator()
        L61:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Ld9
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            com.baidu.tts.d2 r2 = r10.c(r1)
            com.baidu.tts.a2 r3 = r2.f
            java.lang.String r4 = r2.b
            int r3 = r3.b(r4)
            com.baidu.tts.a2 r4 = r2.f
            java.lang.String r5 = r2.c
            int r4 = r4.b(r5)
            java.lang.String r5 = r2.d
            boolean r5 = com.baidu.tts.tools.StringTool.isEmpty(r5)
            if (r5 != 0) goto L98
            com.baidu.tts.a2 r5 = r2.f
            java.lang.String r6 = r2.d
            int r5 = r5.b(r6)
            if (r3 != r9) goto L9e
            if (r4 != r9) goto L9e
            if (r5 != r9) goto L9e
            goto L9c
        L98:
            if (r3 != r9) goto L9e
            if (r4 != r9) goto L9e
        L9c:
            r3 = 1
            goto L9f
        L9e:
            r3 = 0
        L9f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "onFileDownloadSuccess isAllFileDownloadSuccess="
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "ModelFlyweight"
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r5, r4)
            if (r3 == 0) goto Ld3
            java.util.concurrent.CopyOnWriteArraySet<com.baidu.tts.client.model.DownloadHandler> r3 = r2.g
            if (r3 == 0) goto Ld3
            java.util.Iterator r3 = r3.iterator()
        Lbf:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto Ld3
            java.lang.Object r4 = r3.next()
            com.baidu.tts.client.model.DownloadHandler r4 = (com.baidu.tts.client.model.DownloadHandler) r4
            r5 = 0
            r4.updateFinish(r2, r5)
            r2.a(r4)
            goto Lbf
        Ld3:
            java.util.concurrent.CopyOnWriteArraySet<java.lang.String> r2 = r8.h
            r2.remove(r1)
            goto L61
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.r1.a(int, java.util.Map, java.io.File):void");
    }

    @Override // com.baidu.tts.h4
    public void a(long j, long j2) {
        LoggerProxy.d("DownloadEngine", "onProgress fileId=" + this.h + "--written=" + j);
        if (s1.this.b()) {
            b2 b2Var = this.g.f10169a;
            b2Var.getClass();
            a2 a2 = a2.a();
            b2Var.b = j;
            CopyOnWriteArraySet<String> copyOnWriteArraySet = b2Var.h;
            if (copyOnWriteArraySet != null) {
                Iterator<String> it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    d2 c = a2.c(it.next());
                    CopyOnWriteArraySet<DownloadHandler> copyOnWriteArraySet2 = c.g;
                    if (copyOnWriteArraySet2 != null) {
                        Iterator<DownloadHandler> it2 = copyOnWriteArraySet2.iterator();
                        while (it2.hasNext()) {
                            it2.next().updateProgress(c);
                        }
                    }
                }
            }
        }
    }
}
