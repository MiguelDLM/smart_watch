package kotlin.time;

import kotlin.IIX0;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;

@IIX0(markerClass = {xoIox.class})
@XX({"SMAP\nTimeSources.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TimeSources.kt\nkotlin/time/TestTimeSource\n+ 2 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,199:1\n80#2:200\n80#2:201\n*S KotlinDebug\n*F\n+ 1 TimeSources.kt\nkotlin/time/TestTimeSource\n*L\n173#1:200\n180#1:201\n*E\n"})
@oxxXoxO(version = "1.9")
/* loaded from: classes6.dex */
public final class oO extends AbstractLongTimeSource {

    /* renamed from: oxoX, reason: collision with root package name */
    public long f29645oxoX;

    public oO() {
        super(DurationUnit.NANOSECONDS);
        oIX0oI();
    }

    public final void II0XooXoX(long j) {
        long Ioxxx2 = oxoX.Ioxxx(j, oxoX());
        if (((Ioxxx2 - 1) | 1) == Long.MAX_VALUE) {
            long x0xO0oo2 = oxoX.x0xO0oo(j, 2);
            if ((1 | (oxoX.Ioxxx(x0xO0oo2, oxoX()) - 1)) == Long.MAX_VALUE) {
                Oxx0IOOO(j);
                return;
            }
            long j2 = this.f29645oxoX;
            try {
                II0XooXoX(x0xO0oo2);
                II0XooXoX(oxoX.Xo0(j, x0xO0oo2));
                return;
            } catch (IllegalStateException e) {
                this.f29645oxoX = j2;
                throw e;
            }
        }
        long j3 = this.f29645oxoX;
        long j4 = j3 + Ioxxx2;
        if ((Ioxxx2 ^ j3) >= 0 && (j3 ^ j4) < 0) {
            Oxx0IOOO(j);
        }
        this.f29645oxoX = j4;
    }

    public final void Oxx0IOOO(long j) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.f29645oxoX + xxIXOIIO.II0XooXoX(oxoX()) + " is advanced by " + ((Object) oxoX.o0xxxXXxX(j)) + '.');
    }

    @Override // kotlin.time.AbstractLongTimeSource
    public long XO() {
        return this.f29645oxoX;
    }
}
