package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/* loaded from: classes6.dex */
public class IIX0o {
    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal I0Io(BigDecimal bigDecimal) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigDecimal, "<this>");
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        kotlin.jvm.internal.IIX0o.oO(add, "add(...)");
        return add;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal II0XooXoX(double d) {
        return new BigDecimal(String.valueOf(d));
    }

    @xx0o0O.XO
    public static final BigDecimal II0xO0(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigDecimal, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigDecimal divide = bigDecimal.divide(other, RoundingMode.HALF_EVEN);
        kotlin.jvm.internal.IIX0o.oO(divide, "divide(...)");
        return divide;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal OOXIXo(float f, MathContext mathContext) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(f), mathContext);
    }

    @xx0o0O.XO
    public static final BigDecimal Oxx0IOOO(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigDecimal, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigDecimal multiply = bigDecimal.multiply(other);
        kotlin.jvm.internal.IIX0o.oO(multiply, "multiply(...)");
        return multiply;
    }

    @xx0o0O.XO
    public static final BigDecimal X0o0xo(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigDecimal, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigDecimal add = bigDecimal.add(other);
        kotlin.jvm.internal.IIX0o.oO(add, "add(...)");
        return add;
    }

    @xx0o0O.XO
    public static final BigDecimal XO(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigDecimal, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigDecimal remainder = bigDecimal.remainder(other);
        kotlin.jvm.internal.IIX0o.oO(remainder, "remainder(...)");
        return remainder;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal oIX0oI(BigDecimal bigDecimal) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigDecimal, "<this>");
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        kotlin.jvm.internal.IIX0o.oO(subtract, "subtract(...)");
        return subtract;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal oO(long j, MathContext mathContext) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mathContext, "mathContext");
        return new BigDecimal(j, mathContext);
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal oOoXoXO(int i) {
        BigDecimal valueOf = BigDecimal.valueOf(i);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        return valueOf;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal ooOOo0oXI(int i, MathContext mathContext) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mathContext, "mathContext");
        return new BigDecimal(i, mathContext);
    }

    @xx0o0O.XO
    public static final BigDecimal oxoX(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigDecimal, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigDecimal subtract = bigDecimal.subtract(other);
        kotlin.jvm.internal.IIX0o.oO(subtract, "subtract(...)");
        return subtract;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal x0XOIxOo(long j) {
        BigDecimal valueOf = BigDecimal.valueOf(j);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        return valueOf;
    }

    @xx0o0O.XO
    public static final BigDecimal x0xO0oo(BigDecimal bigDecimal) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigDecimal, "<this>");
        BigDecimal negate = bigDecimal.negate();
        kotlin.jvm.internal.IIX0o.oO(negate, "negate(...)");
        return negate;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal xoIox(float f) {
        return new BigDecimal(String.valueOf(f));
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal xxIXOIIO(double d, MathContext mathContext) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(d), mathContext);
    }
}
