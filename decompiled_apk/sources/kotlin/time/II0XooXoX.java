package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.IIX0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public class II0XooXoX {

    /* loaded from: classes6.dex */
    public /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f29626oIX0oI;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f29626oIX0oI = iArr;
        }
    }

    @oxxXoxO(version = "1.5")
    public static final long I0Io(long j, @OXOo.OOXIXo DurationUnit sourceUnit, @OXOo.OOXIXo DurationUnit targetUnit) {
        IIX0o.x0xO0oo(sourceUnit, "sourceUnit");
        IIX0o.x0xO0oo(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    @oxxXoxO(version = "1.5")
    public static final long II0xO0(long j, @OXOo.OOXIXo DurationUnit sourceUnit, @OXOo.OOXIXo DurationUnit targetUnit) {
        IIX0o.x0xO0oo(sourceUnit, "sourceUnit");
        IIX0o.x0xO0oo(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit$kotlin_stdlib().convert(j, sourceUnit.getTimeUnit$kotlin_stdlib());
    }

    @IIX0(markerClass = {xoIox.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.8")
    public static final TimeUnit X0o0xo(@OXOo.OOXIXo DurationUnit durationUnit) {
        IIX0o.x0xO0oo(durationUnit, "<this>");
        return durationUnit.getTimeUnit$kotlin_stdlib();
    }

    @oxxXoxO(version = "1.3")
    public static final double oIX0oI(double d, @OXOo.OOXIXo DurationUnit sourceUnit, @OXOo.OOXIXo DurationUnit targetUnit) {
        IIX0o.x0xO0oo(sourceUnit, "sourceUnit");
        IIX0o.x0xO0oo(targetUnit, "targetUnit");
        long convert = targetUnit.getTimeUnit$kotlin_stdlib().convert(1L, sourceUnit.getTimeUnit$kotlin_stdlib());
        if (convert > 0) {
            return d * convert;
        }
        return d / sourceUnit.getTimeUnit$kotlin_stdlib().convert(1L, targetUnit.getTimeUnit$kotlin_stdlib());
    }

    @IIX0(markerClass = {xoIox.class})
    @OXOo.OOXIXo
    @oxxXoxO(version = "1.8")
    public static final DurationUnit oxoX(@OXOo.OOXIXo TimeUnit timeUnit) {
        IIX0o.x0xO0oo(timeUnit, "<this>");
        switch (oIX0oI.f29626oIX0oI[timeUnit.ordinal()]) {
            case 1:
                return DurationUnit.NANOSECONDS;
            case 2:
                return DurationUnit.MICROSECONDS;
            case 3:
                return DurationUnit.MILLISECONDS;
            case 4:
                return DurationUnit.SECONDS;
            case 5:
                return DurationUnit.MINUTES;
            case 6:
                return DurationUnit.HOURS;
            case 7:
                return DurationUnit.DAYS;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
