package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class x0xO0oo extends AbstractCircuitBreaker<Long> {

    /* renamed from: XO, reason: collision with root package name */
    public static final long f32730XO = 0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final AtomicLong f32731X0o0xo = new AtomicLong(0);

    /* renamed from: oxoX, reason: collision with root package name */
    public final long f32732oxoX;

    public x0xO0oo(long j) {
        this.f32732oxoX = j;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.XO
    /* renamed from: II0XooXoX, reason: merged with bridge method [inline-methods] */
    public boolean II0xO0(Long l) {
        if (this.f32732oxoX == 0) {
            open();
        }
        if (this.f32731X0o0xo.addAndGet(l.longValue()) > this.f32732oxoX) {
            open();
        }
        return oIX0oI();
    }

    public long Oxx0IOOO() {
        return this.f32732oxoX;
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.XO
    public void close() {
        super.close();
        this.f32731X0o0xo.set(0L);
    }

    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.XO
    public boolean oIX0oI() {
        return isOpen();
    }
}
