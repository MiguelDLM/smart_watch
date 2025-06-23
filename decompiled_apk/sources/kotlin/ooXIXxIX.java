package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* loaded from: classes6.dex */
public class ooXIXxIX extends IIX0o {
    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigInteger IIX0o(long j) {
        BigInteger valueOf = BigInteger.valueOf(j);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        return valueOf;
    }

    @xx0o0O.XO
    public static final BigInteger IIXOooo(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigInteger subtract = bigInteger.subtract(other);
        kotlin.jvm.internal.IIX0o.oO(subtract, "subtract(...)");
        return subtract;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigInteger IXxxXO(BigInteger bigInteger) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        BigInteger subtract = bigInteger.subtract(BigInteger.ONE);
        kotlin.jvm.internal.IIX0o.oO(subtract, "subtract(...)");
        return subtract;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigInteger O0xOxO(BigInteger bigInteger, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        BigInteger shiftLeft = bigInteger.shiftLeft(i);
        kotlin.jvm.internal.IIX0o.oO(shiftLeft, "shiftLeft(...)");
        return shiftLeft;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigInteger Oo(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigInteger and = bigInteger.and(other);
        kotlin.jvm.internal.IIX0o.oO(and, "and(...)");
        return and;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.1")
    public static final BigInteger OxI(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigInteger remainder = bigInteger.remainder(other);
        kotlin.jvm.internal.IIX0o.oO(remainder, "remainder(...)");
        return remainder;
    }

    @xx0o0O.XO
    public static final BigInteger Oxx0xo(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigInteger divide = bigInteger.divide(other);
        kotlin.jvm.internal.IIX0o.oO(divide, "divide(...)");
        return divide;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigInteger OxxIIOOXO(BigInteger bigInteger) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        BigInteger not = bigInteger.not();
        kotlin.jvm.internal.IIX0o.oO(not, "not(...)");
        return not;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigInteger X0IIOO(BigInteger bigInteger, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        BigInteger shiftRight = bigInteger.shiftRight(i);
        kotlin.jvm.internal.IIX0o.oO(shiftRight, "shiftRight(...)");
        return shiftRight;
    }

    @xx0o0O.XO
    public static final BigInteger XI0IXoo(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigInteger multiply = bigInteger.multiply(other);
        kotlin.jvm.internal.IIX0o.oO(multiply, "multiply(...)");
        return multiply;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal XIxXXX0x0(BigInteger bigInteger) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        return new BigDecimal(bigInteger);
    }

    public static /* synthetic */ BigDecimal XxX0x0xxx(BigInteger bigInteger, int i, MathContext mathContext, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            kotlin.jvm.internal.IIX0o.oO(mathContext, "UNLIMITED");
        }
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i, mathContext);
    }

    @xx0o0O.XO
    public static final BigInteger o00(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigInteger add = bigInteger.add(other);
        kotlin.jvm.internal.IIX0o.oO(add, "add(...)");
        return add;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigInteger oI0IIXIo(BigInteger bigInteger) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        BigInteger add = bigInteger.add(BigInteger.ONE);
        kotlin.jvm.internal.IIX0o.oO(add, "add(...)");
        return add;
    }

    @xx0o0O.XO
    public static final BigInteger ooXIXxIX(BigInteger bigInteger) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        BigInteger negate = bigInteger.negate();
        kotlin.jvm.internal.IIX0o.oO(negate, "negate(...)");
        return negate;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigInteger xI(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigInteger xor = bigInteger.xor(other);
        kotlin.jvm.internal.IIX0o.oO(xor, "xor(...)");
        return xor;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigInteger xXxxox0I(int i) {
        BigInteger valueOf = BigInteger.valueOf(i);
        kotlin.jvm.internal.IIX0o.oO(valueOf, "valueOf(...)");
        return valueOf;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigInteger xoXoI(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        BigInteger or = bigInteger.or(other);
        kotlin.jvm.internal.IIX0o.oO(or, "or(...)");
        return or;
    }

    @xx0o0O.XO
    @oxxXoxO(version = "1.2")
    public static final BigDecimal xxX(BigInteger bigInteger, int i, MathContext mathContext) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(bigInteger, "<this>");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i, mathContext);
    }
}
