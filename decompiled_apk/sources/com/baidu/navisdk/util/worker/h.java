package com.baidu.navisdk.util.worker;

import com.baidu.navisdk.util.common.LogUtil;
import java.util.concurrent.Future;

/* loaded from: classes8.dex */
public interface h {
    static {
        boolean z = LogUtil.LOGGABLE;
    }

    <K, T> Future<?> a(g<K, T> gVar);

    <K, T> Future<?> a(g<K, T> gVar, e eVar);

    <K, T> void a(b<K, T> bVar, e eVar);

    <K, T> void a(f<K, T> fVar, e eVar);

    <K, T> void a(f<K, T> fVar, e eVar, long j);

    <K, T> boolean a(g<K, T> gVar, boolean z);

    <K, T> void b(f<K, T> fVar, e eVar);

    <K, T> void b(f<K, T> fVar, e eVar, long j);

    <K, T> void c(f<K, T> fVar, e eVar);

    <K, T> void c(f<K, T> fVar, e eVar, long j);
}
