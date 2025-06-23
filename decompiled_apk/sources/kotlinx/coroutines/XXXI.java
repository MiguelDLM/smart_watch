package kotlinx.coroutines;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes6.dex */
public final class XXXI<U, T extends U> extends kotlinx.coroutines.internal.Xx000oIo<T> implements Runnable {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @XO0OX.XO
    public final long f29779oI0IIXIo;

    public XXXI(long j, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super U> i0Io) {
        super(i0Io.getContext(), i0Io);
        this.f29779oI0IIXIo = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        XoI0Ixx0(TimeoutKt.oIX0oI(this.f29779oI0IIXIo, DelayKt.oxoX(getContext()), this));
    }

    @Override // kotlinx.coroutines.oIX0oI, kotlinx.coroutines.JobSupport
    @OXOo.OOXIXo
    public String x0OIX00oO() {
        return super.x0OIX00oO() + "(timeMillis=" + this.f29779oI0IIXIo + HexStringBuilder.COMMENT_END_CHAR;
    }
}
