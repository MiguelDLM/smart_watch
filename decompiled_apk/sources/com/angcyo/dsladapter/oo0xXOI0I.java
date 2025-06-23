package com.angcyo.dsladapter;

import java.util.Arrays;
import java.util.Stack;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes7.dex */
public final class oo0xXOI0I {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oo0xXOI0I f5437oIX0oI = new oo0xXOI0I();

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final Stack<Long> f5436II0xO0 = new Stack<>();

    @OXOo.OOXIXo
    public final String I0Io(long j, long j2) {
        long j3 = j2 - j;
        long j4 = 1000;
        long j5 = j3 / j4;
        float f = (((float) (j3 % j4)) * 1.0f) / 1000;
        StringBuilder sb = new StringBuilder();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(((float) j5) + f)}, 1));
        kotlin.jvm.internal.IIX0o.oO(format, "format(format, *args)");
        sb.append(format);
        sb.append('s');
        return sb.toString();
    }

    @OXOo.OOXIXo
    public final String II0xO0() {
        Long startTime;
        if (!L.f5267oIX0oI.II0XooXoX()) {
            return "not debug!";
        }
        Stack<Long> stack = f5436II0xO0;
        if (stack.isEmpty()) {
            startTime = Long.valueOf(LibExKt.o0xxxXXxX());
        } else {
            startTime = stack.pop();
        }
        long o0xxxXXxX2 = LibExKt.o0xxxXXxX();
        kotlin.jvm.internal.IIX0o.oO(startTime, "startTime");
        return I0Io(startTime.longValue(), o0xxxXXxX2);
    }

    public final long oIX0oI() {
        long o0xxxXXxX2 = LibExKt.o0xxxXXxX();
        if (L.f5267oIX0oI.II0XooXoX()) {
            f5436II0xO0.push(Long.valueOf(o0xxxXXxX2));
        }
        return o0xxxXXxX2;
    }
}
