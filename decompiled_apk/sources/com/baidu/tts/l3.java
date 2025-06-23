package com.baidu.tts;

import com.baidu.tts.j3;
import com.baidu.tts.k3;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;

/* loaded from: classes8.dex */
public class l3<A extends k3<A, R>, R extends j3> {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<A, Future<R>> f10130a = new ConcurrentHashMap();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.concurrent.Future, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.concurrent.FutureTask, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public R a(A r8) throws java.lang.Exception {
        /*
            r7 = this;
            java.util.concurrent.ConcurrentMap<A extends com.baidu.tts.k3<A, R>, java.util.concurrent.Future<R extends com.baidu.tts.j3>> r0 = r7.f10130a
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        La:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()
            com.baidu.tts.k3 r1 = (com.baidu.tts.k3) r1
            int r3 = r8.compareTo(r1)
            if (r3 != 0) goto La
            goto L1f
        L1e:
            r1 = r2
        L1f:
            if (r1 == 0) goto L2a
            java.util.concurrent.ConcurrentMap<A extends com.baidu.tts.k3<A, R>, java.util.concurrent.Future<R extends com.baidu.tts.j3>> r0 = r7.f10130a
            java.lang.Object r0 = r0.get(r1)
            java.util.concurrent.Future r0 = (java.util.concurrent.Future) r0
            goto L2b
        L2a:
            r0 = r2
        L2b:
            java.lang.String r3 = "Memorizer"
            if (r0 == 0) goto L7d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "+ get f="
            r4.append(r5)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r3, r4)
            java.lang.Object r4 = r0.get()
            com.baidu.tts.j3 r4 = (com.baidu.tts.j3) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "- get f="
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r3, r5)
            boolean r5 = r4.a()
            if (r5 != 0) goto L7d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arg invalid r="
            r0.append(r5)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r3, r0)
            java.util.concurrent.ConcurrentMap<A extends com.baidu.tts.k3<A, R>, java.util.concurrent.Future<R extends com.baidu.tts.j3>> r0 = r7.f10130a
            r0.remove(r1)
            goto L7e
        L7d:
            r2 = r0
        L7e:
            if (r2 != 0) goto Lbc
            java.util.concurrent.FutureTask r2 = new java.util.concurrent.FutureTask
            r2.<init>(r8)
            java.util.concurrent.ConcurrentMap<A extends com.baidu.tts.k3<A, R>, java.util.concurrent.Future<R extends com.baidu.tts.j3>> r0 = r7.f10130a
            java.lang.Object r0 = r0.putIfAbsent(r8, r2)
            java.util.concurrent.Future r0 = (java.util.concurrent.Future) r0
            if (r0 != 0) goto Lbb
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "+ run f="
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r3, r0)
            r2.run()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "- run f="
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.baidu.tts.chainofresponsibility.logger.LoggerProxy.d(r3, r0)
            goto Lbc
        Lbb:
            r2 = r0
        Lbc:
            java.lang.Object r0 = r2.get()     // Catch: java.lang.Exception -> Lc3 java.util.concurrent.ExecutionException -> Lc5
            com.baidu.tts.j3 r0 = (com.baidu.tts.j3) r0     // Catch: java.lang.Exception -> Lc3 java.util.concurrent.ExecutionException -> Lc5
            return r0
        Lc3:
            r0 = move-exception
            goto Lc7
        Lc5:
            r0 = move-exception
            goto Lcd
        Lc7:
            java.util.concurrent.ConcurrentMap<A extends com.baidu.tts.k3<A, R>, java.util.concurrent.Future<R extends com.baidu.tts.j3>> r1 = r7.f10130a
            r1.remove(r8, r2)
            throw r0
        Lcd:
            java.util.concurrent.ConcurrentMap<A extends com.baidu.tts.k3<A, R>, java.util.concurrent.Future<R extends com.baidu.tts.j3>> r1 = r7.f10130a
            r1.remove(r8, r2)
            java.lang.Throwable r8 = r0.getCause()
            java.lang.Exception r8 = (java.lang.Exception) r8
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.l3.a(com.baidu.tts.k3):com.baidu.tts.j3");
    }
}
