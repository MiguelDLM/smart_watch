package XoOOx0IX;

import XO0OX.xxIXOIIO;
import java.time.Duration;
import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;
import kotlin.time.DurationUnit;
import kotlin.time.oxoX;
import kotlin.time.xoIox;
import xx0o0O.XO;

@xxIXOIIO(name = "DurationConversionsJDK8Kt")
@XX({"SMAP\nDurationConversions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n+ 2 Duration.kt\nkotlin/time/Duration\n*L\n1#1,33:1\n731#2,2:34\n*S KotlinDebug\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n*L\n33#1:34,2\n*E\n"})
/* loaded from: classes6.dex */
public final class I0Io {
    @IIX0(markerClass = {xoIox.class})
    @XO
    @oxxXoxO(version = "1.6")
    public static final long II0xO0(Duration duration) {
        long seconds;
        int nano;
        IIX0o.x0xO0oo(duration, "<this>");
        seconds = duration.getSeconds();
        long xoIxX2 = kotlin.time.XO.xoIxX(seconds, DurationUnit.SECONDS);
        nano = duration.getNano();
        return oxoX.XoI0Ixx0(xoIxX2, kotlin.time.XO.IoOoo(nano, DurationUnit.NANOSECONDS));
    }

    @IIX0(markerClass = {xoIox.class})
    @XO
    @oxxXoxO(version = "1.6")
    public static final Duration oIX0oI(long j) {
        Duration ofSeconds;
        ofSeconds = Duration.ofSeconds(oxoX.IO(j), oxoX.OI0(j));
        IIX0o.oO(ofSeconds, "toComponents-impl(...)");
        return ofSeconds;
    }
}
