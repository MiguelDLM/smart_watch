package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nDurationJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationJvm.kt\nkotlin/time/DurationJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,33:1\n1#2:34\n*E\n"})
/* loaded from: classes6.dex */
public final class X0o0xo {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final ThreadLocal<DecimalFormat>[] f29635II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final boolean f29636oIX0oI = false;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i = 0; i < 4; i++) {
            threadLocalArr[i] = new ThreadLocal<>();
        }
        f29635II0xO0 = threadLocalArr;
    }

    @OXOo.OOXIXo
    public static final String I0Io(double d, int i) {
        DecimalFormat oIX0oI2 = oIX0oI(0);
        oIX0oI2.setMaximumFractionDigits(i);
        String format = oIX0oI2.format(d);
        IIX0o.oO(format, "format(...)");
        return format;
    }

    @OXOo.OOXIXo
    public static final String II0xO0(double d, int i) {
        DecimalFormat oIX0oI2;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f29635II0xO0;
        if (i < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i];
            DecimalFormat decimalFormat = threadLocal.get();
            if (decimalFormat == null) {
                decimalFormat = oIX0oI(i);
                threadLocal.set(decimalFormat);
            } else {
                IIX0o.ooOOo0oXI(decimalFormat);
            }
            oIX0oI2 = decimalFormat;
        } else {
            oIX0oI2 = oIX0oI(i);
        }
        String format = oIX0oI2.format(d);
        IIX0o.oO(format, "format(...)");
        return format;
    }

    public static final DecimalFormat oIX0oI(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        if (i > 0) {
            decimalFormat.setMinimumFractionDigits(i);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    public static final boolean oxoX() {
        return f29636oIX0oI;
    }
}
