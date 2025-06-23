package com.bytedance.pangle.g;

import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
final class h implements k {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f10565a;

    public h(ByteBuffer byteBuffer) {
        this.f10565a = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f10565a.capacity();
    }

    @Override // com.bytedance.pangle.g.k
    public final void a(j jVar, long j, int i) {
        ByteBuffer slice;
        synchronized (this.f10565a) {
            this.f10565a.position(0);
            int i2 = (int) j;
            this.f10565a.limit(i + i2);
            this.f10565a.position(i2);
            slice = this.f10565a.slice();
        }
        jVar.a(slice);
    }
}
