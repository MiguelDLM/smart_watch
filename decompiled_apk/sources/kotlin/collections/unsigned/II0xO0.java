package kotlin.collections.unsigned;

import OXOo.OOXIXo;
import XO0OX.xxIXOIIO;
import com.goodix.ble.gr.libdfu.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.O0X;
import kotlin.OO0x0xX;
import kotlin.OOXIxO0;
import kotlin.OX00O0xII;
import kotlin.X00IoxXI;
import kotlin.XI0oooXX;
import kotlin.XX;
import kotlin.XX0xXo;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.oOXoIIIo;
import kotlin.jvm.internal.IIX0o;
import kotlin.oI0IIXIo;
import kotlin.oOoXoXO;
import kotlin.oxxXoxO;
import kotlin.x0xO;
import kotlin.xX0IIXIx0;
import kotlin.xxIO;
import xx0o0O.XO;

/* loaded from: classes6.dex */
public class II0xO0 {

    /* loaded from: classes6.dex */
    public static final class I0Io extends kotlin.collections.II0xO0<x0xO> implements RandomAccess {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ byte[] f29169XO;

        public I0Io(byte[] bArr) {
            this.f29169XO = bArr;
        }

        public byte II0xO0(int i) {
            return OO0x0xX.OOXIXo(this.f29169XO, i);
        }

        public int X0o0xo(byte b) {
            return ArraysKt___ArraysKt.OIX0oXO0o(this.f29169XO, b);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof x0xO)) {
                return false;
            }
            return oIX0oI(((x0xO) obj).I0oOIX());
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i) {
            return x0xO.oxoX(II0xO0(i));
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return OO0x0xX.ooOOo0oXI(this.f29169XO);
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof x0xO)) {
                return -1;
            }
            return oxoX(((x0xO) obj).I0oOIX());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return OO0x0xX.x0xO0oo(this.f29169XO);
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof x0xO)) {
                return -1;
            }
            return X0o0xo(((x0xO) obj).I0oOIX());
        }

        public boolean oIX0oI(byte b) {
            return OO0x0xX.Oxx0IOOO(this.f29169XO, b);
        }

        public int oxoX(byte b) {
            return ArraysKt___ArraysKt.O00Ix(this.f29169XO, b);
        }
    }

    /* renamed from: kotlin.collections.unsigned.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1105II0xO0 extends kotlin.collections.II0xO0<XI0oooXX> implements RandomAccess {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ long[] f29170XO;

        public C1105II0xO0(long[] jArr) {
            this.f29170XO = jArr;
        }

        public long II0xO0(int i) {
            return OOXIxO0.OOXIXo(this.f29170XO, i);
        }

        public int X0o0xo(long j) {
            return ArraysKt___ArraysKt.I0Xo(this.f29170XO, j);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof XI0oooXX)) {
                return false;
            }
            return oIX0oI(((XI0oooXX) obj).OO());
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i) {
            return XI0oooXX.oxoX(II0xO0(i));
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return OOXIxO0.ooOOo0oXI(this.f29170XO);
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof XI0oooXX)) {
                return -1;
            }
            return oxoX(((XI0oooXX) obj).OO());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return OOXIxO0.x0xO0oo(this.f29170XO);
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof XI0oooXX)) {
                return -1;
            }
            return X0o0xo(((XI0oooXX) obj).OO());
        }

        public boolean oIX0oI(long j) {
            return OOXIxO0.Oxx0IOOO(this.f29170XO, j);
        }

        public int oxoX(long j) {
            return ArraysKt___ArraysKt.XxxoIooX(this.f29170XO, j);
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI extends kotlin.collections.II0xO0<xxIO> implements RandomAccess {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int[] f29171XO;

        public oIX0oI(int[] iArr) {
            this.f29171XO = iArr;
        }

        public int II0xO0(int i) {
            return XX0xXo.OOXIXo(this.f29171XO, i);
        }

        public int X0o0xo(int i) {
            return ArraysKt___ArraysKt.I0IoX00I(this.f29171XO, i);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof xxIO)) {
                return false;
            }
            return oIX0oI(((xxIO) obj).OO());
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i) {
            return xxIO.oxoX(II0xO0(i));
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return XX0xXo.ooOOo0oXI(this.f29171XO);
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof xxIO)) {
                return -1;
            }
            return oxoX(((xxIO) obj).OO());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return XX0xXo.x0xO0oo(this.f29171XO);
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof xxIO)) {
                return -1;
            }
            return X0o0xo(((xxIO) obj).OO());
        }

        public boolean oIX0oI(int i) {
            return XX0xXo.Oxx0IOOO(this.f29171XO, i);
        }

        public int oxoX(int i) {
            return ArraysKt___ArraysKt.XoOoxI0X(this.f29171XO, i);
        }
    }

    /* loaded from: classes6.dex */
    public static final class oxoX extends kotlin.collections.II0xO0<OX00O0xII> implements RandomAccess {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ short[] f29172XO;

        public oxoX(short[] sArr) {
            this.f29172XO = sArr;
        }

        public short II0xO0(int i) {
            return xX0IIXIx0.OOXIXo(this.f29172XO, i);
        }

        public int X0o0xo(short s) {
            return ArraysKt___ArraysKt.xoOxO0(this.f29172XO, s);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (!(obj instanceof OX00O0xII)) {
                return false;
            }
            return oIX0oI(((OX00O0xII) obj).I0oOIX());
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i) {
            return OX00O0xII.oxoX(II0xO0(i));
        }

        @Override // kotlin.collections.II0xO0, kotlin.collections.AbstractCollection
        public int getSize() {
            return xX0IIXIx0.ooOOo0oXI(this.f29172XO);
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (!(obj instanceof OX00O0xII)) {
                return -1;
            }
            return oxoX(((OX00O0xII) obj).I0oOIX());
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return xX0IIXIx0.x0xO0oo(this.f29172XO);
        }

        @Override // kotlin.collections.II0xO0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (!(obj instanceof OX00O0xII)) {
                return -1;
            }
            return X0o0xo(((OX00O0xII) obj).I0oOIX());
        }

        public boolean oIX0oI(short s) {
            return xX0IIXIx0.Oxx0IOOO(this.f29172XO, s);
        }

        public int oxoX(short s) {
            return ArraysKt___ArraysKt.Oo0OxoOx(this.f29172XO, s);
        }
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<XI0oooXX> I0Io(@OOXIXo long[] asList) {
        IIX0o.x0xO0oo(asList, "$this$asList");
        return new C1105II0xO0(asList);
    }

    public static /* synthetic */ int II0XooXoX(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = xX0IIXIx0.ooOOo0oXI(sArr);
        }
        return Oxx0IOOO(sArr, s, i, i2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<x0xO> II0xO0(@OOXIXo byte[] asList) {
        IIX0o.x0xO0oo(asList, "$this$asList");
        return new I0Io(asList);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @XX(expression = "this.minByOrNull(selector)", imports = {}))
    @XO
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> x0xO IIX0o(byte[] minBy, Oox.oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(minBy, "$this$minBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (OO0x0xX.x0xO0oo(minBy)) {
            return null;
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(minBy, 0);
        int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(minBy);
        if (xxXIIXIxx != 0) {
            R invoke = selector.invoke(x0xO.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx).iterator();
            while (it.hasNext()) {
                byte OOXIXo3 = OO0x0xX.OOXIXo(minBy, it.nextInt());
                R invoke2 = selector.invoke(x0xO.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) > 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
        }
        return x0xO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @XO
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> XI0oooXX IIXOooo(long[] maxBy, Oox.oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(maxBy, "$this$maxBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (OOXIxO0.x0xO0oo(maxBy)) {
            return null;
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(maxBy, 0);
        int IOXI = ArraysKt___ArraysKt.IOXI(maxBy);
        if (IOXI != 0) {
            R invoke = selector.invoke(XI0oooXX.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI).iterator();
            while (it.hasNext()) {
                long OOXIXo3 = OOXIxO0.OOXIXo(maxBy, it.nextInt());
                R invoke2 = selector.invoke(XI0oooXX.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) < 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
        }
        return XI0oooXX.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfBigDecimal")
    @X00IoxXI
    @XO
    public static final BigDecimal IO(int[] sumOf, Oox.oOoXoXO<? super xxIO, ? extends BigDecimal> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        IIX0o.oO(valueOf, "valueOf(...)");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            valueOf = valueOf.add(selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(sumOf, i))));
            IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @XX(expression = "this.maxOrNull()", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ x0xO IXxxXO(byte[] max) {
        IIX0o.x0xO0oo(max, "$this$max");
        return UArraysKt___UArraysKt.X0OXI(max);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfBigInteger")
    @X00IoxXI
    @XO
    public static final BigInteger Io(long[] sumOf, Oox.oOoXoXO<? super XI0oooXX, ? extends BigInteger> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        IIX0o.oO(valueOf, "valueOf(...)");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            valueOf = valueOf.add(selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(sumOf, i))));
            IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ xxIO IoOoX(int[] minWith, Comparator comparator) {
        IIX0o.x0xO0oo(minWith, "$this$minWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        return UArraysKt___UArraysKt.X0xO(minWith, comparator);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ xxIO O0xOxO(int[] maxWith, Comparator comparator) {
        IIX0o.x0xO0oo(maxWith, "$this$maxWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        return UArraysKt___UArraysKt.xXx0x0(maxWith, comparator);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfBigInteger")
    @X00IoxXI
    @XO
    public static final BigInteger OI0(int[] sumOf, Oox.oOoXoXO<? super xxIO, ? extends BigInteger> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        IIX0o.oO(valueOf, "valueOf(...)");
        int ooOOo0oXI2 = XX0xXo.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            valueOf = valueOf.add(selector.invoke(xxIO.oxoX(XX0xXo.OOXIXo(sumOf, i))));
            IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final int OOXIXo(@OOXIXo byte[] binarySearch, byte b, int i, int i2) {
        IIX0o.x0xO0oo(binarySearch, "$this$binarySearch");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, OO0x0xX.ooOOo0oXI(binarySearch));
        int i3 = b & 255;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int I0Io2 = O0X.I0Io(binarySearch[i5], i3);
            if (I0Io2 < 0) {
                i = i5 + 1;
            } else if (I0Io2 > 0) {
                i4 = i5 - 1;
            } else {
                return i5;
            }
        }
        return -(i + 1);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @XX(expression = "this.maxOrNull()", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ xxIO Oo(int[] max) {
        IIX0o.x0xO0oo(max, "$this$max");
        return UArraysKt___UArraysKt.OxXXx0OX(max);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ x0xO OxI(byte[] maxWith, Comparator comparator) {
        IIX0o.x0xO0oo(maxWith, "$this$maxWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        return UArraysKt___UArraysKt.x0Ix0O(maxWith, comparator);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final int Oxx0IOOO(@OOXIXo short[] binarySearch, short s, int i, int i2) {
        IIX0o.x0xO0oo(binarySearch, "$this$binarySearch");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, xX0IIXIx0.ooOOo0oXI(binarySearch));
        int i3 = s & OX00O0xII.f29066Oxx0xo;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int I0Io2 = O0X.I0Io(binarySearch[i5], i3);
            if (I0Io2 < 0) {
                i = i5 + 1;
            } else if (I0Io2 > 0) {
                i4 = i5 - 1;
            } else {
                return i5;
            }
        }
        return -(i + 1);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @XX(expression = "this.maxOrNull()", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ XI0oooXX Oxx0xo(long[] max) {
        IIX0o.x0xO0oo(max, "$this$max");
        return UArraysKt___UArraysKt.oIoIxo(max);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @XO
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> x0xO OxxIIOOXO(byte[] maxBy, Oox.oOoXoXO<? super x0xO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxBy, "$this$maxBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (OO0x0xX.x0xO0oo(maxBy)) {
            return null;
        }
        byte OOXIXo2 = OO0x0xX.OOXIXo(maxBy, 0);
        int xxXIIXIxx = ArraysKt___ArraysKt.xxXIIXIxx(maxBy);
        if (xxXIIXIxx != 0) {
            R invoke = selector.invoke(x0xO.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, xxXIIXIxx).iterator();
            while (it.hasNext()) {
                byte OOXIXo3 = OO0x0xX.OOXIXo(maxBy, it.nextInt());
                R invoke2 = selector.invoke(x0xO.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) < 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
        }
        return x0xO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfBigDecimal")
    @X00IoxXI
    @XO
    public static final BigDecimal X00IoxXI(byte[] sumOf, Oox.oOoXoXO<? super x0xO, ? extends BigDecimal> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        IIX0o.oO(valueOf, "valueOf(...)");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            valueOf = valueOf.add(selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(sumOf, i))));
            IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ OX00O0xII X0IIOO(short[] maxWith, Comparator comparator) {
        IIX0o.x0xO0oo(maxWith, "$this$maxWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        return UArraysKt___UArraysKt.OOOxXxoO(maxWith, comparator);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final int X0o0xo(@OOXIXo int[] binarySearch, int i, int i2, int i3) {
        IIX0o.x0xO0oo(binarySearch, "$this$binarySearch");
        kotlin.collections.II0xO0.Companion.oxoX(i2, i3, XX0xXo.ooOOo0oXI(binarySearch));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int I0Io2 = O0X.I0Io(binarySearch[i5], i);
            if (I0Io2 < 0) {
                i2 = i5 + 1;
            } else if (I0Io2 > 0) {
                i4 = i5 - 1;
            } else {
                return i5;
            }
        }
        return -(i2 + 1);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use maxWithOrNull instead.", replaceWith = @XX(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ XI0oooXX XI0IXoo(long[] maxWith, Comparator comparator) {
        IIX0o.x0xO0oo(maxWith, "$this$maxWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        return UArraysKt___UArraysKt.XxIO0(maxWith, comparator);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @XX(expression = "this.minOrNull()", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ xxIO XIxXXX0x0(int[] min) {
        IIX0o.x0xO0oo(min, "$this$min");
        return UArraysKt___UArraysKt.XX00xxo(min);
    }

    public static /* synthetic */ int XO(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = XX0xXo.ooOOo0oXI(iArr);
        }
        return X0o0xo(iArr, i, i2, i3);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfBigInteger")
    @X00IoxXI
    @XO
    public static final BigInteger XOxIOxOx(byte[] sumOf, Oox.oOoXoXO<? super x0xO, ? extends BigInteger> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        IIX0o.oO(valueOf, "valueOf(...)");
        int ooOOo0oXI2 = OO0x0xX.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            valueOf = valueOf.add(selector.invoke(x0xO.oxoX(OO0x0xX.OOXIXo(sumOf, i))));
            IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ XI0oooXX Xx000oIo(long[] minWith, Comparator comparator) {
        IIX0o.x0xO0oo(minWith, "$this$minWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        return UArraysKt___UArraysKt.XIOoI(minWith, comparator);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @XX(expression = "this.minOrNull()", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ XI0oooXX XxX0x0xxx(long[] min) {
        IIX0o.x0xO0oo(min, "$this$min");
        return UArraysKt___UArraysKt.x0I0(min);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfBigInteger")
    @X00IoxXI
    @XO
    public static final BigInteger o0(short[] sumOf, Oox.oOoXoXO<? super OX00O0xII, ? extends BigInteger> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        IIX0o.oO(valueOf, "valueOf(...)");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            valueOf = valueOf.add(selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(sumOf, i))));
            IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @XO
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> OX00O0xII o00(short[] maxBy, Oox.oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(maxBy, "$this$maxBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (xX0IIXIx0.x0xO0oo(maxBy)) {
            return null;
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(maxBy, 0);
        int xX0Ox = ArraysKt___ArraysKt.xX0Ox(maxBy);
        if (xX0Ox != 0) {
            R invoke = selector.invoke(OX00O0xII.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox).iterator();
            while (it.hasNext()) {
                short OOXIXo3 = xX0IIXIx0.OOXIXo(maxBy, it.nextInt());
                R invoke2 = selector.invoke(OX00O0xII.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) < 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
        }
        return OX00O0xII.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use maxOrNull instead.", replaceWith = @XX(expression = "this.maxOrNull()", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ OX00O0xII oI0IIXIo(short[] max) {
        IIX0o.x0xO0oo(max, "$this$max");
        return UArraysKt___UArraysKt.xoIIIOI(max);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<xxIO> oIX0oI(@OOXIXo int[] asList) {
        IIX0o.x0xO0oo(asList, "$this$asList");
        return new oIX0oI(asList);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final int oO(int[] elementAt, int i) {
        IIX0o.x0xO0oo(elementAt, "$this$elementAt");
        return XX0xXo.OOXIXo(elementAt, i);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ OX00O0xII oOXoIIIo(short[] minWith, Comparator comparator) {
        IIX0o.x0xO0oo(minWith, "$this$minWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        return UArraysKt___UArraysKt.OOxOXI0(minWith, comparator);
    }

    public static /* synthetic */ int oOoXoXO(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = OO0x0xX.ooOOo0oXI(bArr);
        }
        return OOXIXo(bArr, b, i, i2);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use minWithOrNull instead.", replaceWith = @XX(expression = "this.minWithOrNull(comparator)", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ x0xO oo(byte[] minWith, Comparator comparator) {
        IIX0o.x0xO0oo(minWith, "$this$minWith");
        IIX0o.x0xO0oo(comparator, "comparator");
        return UArraysKt___UArraysKt.Io0OXxX(minWith, comparator);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @XX(expression = "this.minByOrNull(selector)", imports = {}))
    @XO
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> OX00O0xII oo0xXOI0I(short[] minBy, Oox.oOoXoXO<? super OX00O0xII, ? extends R> selector) {
        IIX0o.x0xO0oo(minBy, "$this$minBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (xX0IIXIx0.x0xO0oo(minBy)) {
            return null;
        }
        short OOXIXo2 = xX0IIXIx0.OOXIXo(minBy, 0);
        int xX0Ox = ArraysKt___ArraysKt.xX0Ox(minBy);
        if (xX0Ox != 0) {
            R invoke = selector.invoke(OX00O0xII.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, xX0Ox).iterator();
            while (it.hasNext()) {
                short OOXIXo3 = xX0IIXIx0.OOXIXo(minBy, it.nextInt());
                R invoke2 = selector.invoke(OX00O0xII.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) > 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
        }
        return OX00O0xII.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final byte ooOOo0oXI(byte[] elementAt, int i) {
        IIX0o.x0xO0oo(elementAt, "$this$elementAt");
        return OO0x0xX.OOXIXo(elementAt, i);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @XX(expression = "this.minByOrNull(selector)", imports = {}))
    @XO
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> XI0oooXX ooXIXxIX(long[] minBy, Oox.oOoXoXO<? super XI0oooXX, ? extends R> selector) {
        IIX0o.x0xO0oo(minBy, "$this$minBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (OOXIxO0.x0xO0oo(minBy)) {
            return null;
        }
        long OOXIXo2 = OOXIxO0.OOXIXo(minBy, 0);
        int IOXI = ArraysKt___ArraysKt.IOXI(minBy);
        if (IOXI != 0) {
            R invoke = selector.invoke(XI0oooXX.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, IOXI).iterator();
            while (it.hasNext()) {
                long OOXIXo3 = OOXIxO0.OOXIXo(minBy, it.nextInt());
                R invoke2 = selector.invoke(XI0oooXX.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) > 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
        }
        return XI0oooXX.oxoX(OOXIXo2);
    }

    @OOXIXo
    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final List<OX00O0xII> oxoX(@OOXIXo short[] asList) {
        IIX0o.x0xO0oo(asList, "$this$asList");
        return new oxoX(asList);
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final short x0XOIxOo(short[] elementAt, int i) {
        IIX0o.x0xO0oo(elementAt, "$this$elementAt");
        return xX0IIXIx0.OOXIXo(elementAt, i);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfBigDecimal")
    @X00IoxXI
    @XO
    public static final BigDecimal x0o(short[] sumOf, Oox.oOoXoXO<? super OX00O0xII, ? extends BigDecimal> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        IIX0o.oO(valueOf, "valueOf(...)");
        int ooOOo0oXI2 = xX0IIXIx0.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            valueOf = valueOf.add(selector.invoke(OX00O0xII.oxoX(xX0IIXIx0.OOXIXo(sumOf, i))));
            IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @oI0IIXIo
    @XO
    @oxxXoxO(version = "1.3")
    public static final long x0xO0oo(long[] elementAt, int i) {
        IIX0o.x0xO0oo(elementAt, "$this$elementAt");
        return OOXIxO0.OOXIXo(elementAt, i);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use minByOrNull instead.", replaceWith = @XX(expression = "this.minByOrNull(selector)", imports = {}))
    @XO
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> xxIO xI(int[] minBy, Oox.oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(minBy, "$this$minBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (XX0xXo.x0xO0oo(minBy)) {
            return null;
        }
        int OOXIXo2 = XX0xXo.OOXIXo(minBy, 0);
        int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(minBy);
        if (oOIoXOoI != 0) {
            R invoke = selector.invoke(xxIO.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI).iterator();
            while (it.hasNext()) {
                int OOXIXo3 = XX0xXo.OOXIXo(minBy, it.nextInt());
                R invoke2 = selector.invoke(xxIO.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) > 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
        }
        return xxIO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = BuildConfig.VERSION_NAME)
    @xxIXOIIO(name = "sumOfBigDecimal")
    @X00IoxXI
    @XO
    public static final BigDecimal xII(long[] sumOf, Oox.oOoXoXO<? super XI0oooXX, ? extends BigDecimal> selector) {
        IIX0o.x0xO0oo(sumOf, "$this$sumOf");
        IIX0o.x0xO0oo(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        IIX0o.oO(valueOf, "valueOf(...)");
        int ooOOo0oXI2 = OOXIxO0.ooOOo0oXI(sumOf);
        for (int i = 0; i < ooOOo0oXI2; i++) {
            valueOf = valueOf.add(selector.invoke(XI0oooXX.oxoX(OOXIxO0.OOXIXo(sumOf, i))));
            IIX0o.oO(valueOf, "add(...)");
        }
        return valueOf;
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @XX(expression = "this.minOrNull()", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ OX00O0xII xXxxox0I(short[] min) {
        IIX0o.x0xO0oo(min, "$this$min");
        return UArraysKt___UArraysKt.OOI(min);
    }

    public static /* synthetic */ int xoIox(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = OOXIxO0.ooOOo0oXI(jArr);
        }
        return xxIXOIIO(jArr, j, i, i2);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use maxByOrNull instead.", replaceWith = @XX(expression = "this.maxByOrNull(selector)", imports = {}))
    @XO
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ <R extends Comparable<? super R>> xxIO xoXoI(int[] maxBy, Oox.oOoXoXO<? super xxIO, ? extends R> selector) {
        IIX0o.x0xO0oo(maxBy, "$this$maxBy");
        IIX0o.x0xO0oo(selector, "selector");
        if (XX0xXo.x0xO0oo(maxBy)) {
            return null;
        }
        int OOXIXo2 = XX0xXo.OOXIXo(maxBy, 0);
        int oOIoXOoI = ArraysKt___ArraysKt.oOIoXOoI(maxBy);
        if (oOIoXOoI != 0) {
            R invoke = selector.invoke(xxIO.oxoX(OOXIXo2));
            oOXoIIIo it = new X0.oOoXoXO(1, oOIoXOoI).iterator();
            while (it.hasNext()) {
                int OOXIXo3 = XX0xXo.OOXIXo(maxBy, it.nextInt());
                R invoke2 = selector.invoke(xxIO.oxoX(OOXIXo3));
                if (invoke.compareTo(invoke2) < 0) {
                    OOXIXo2 = OOXIXo3;
                    invoke = invoke2;
                }
            }
        }
        return xxIO.oxoX(OOXIXo2);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    public static final int xxIXOIIO(@OOXIXo long[] binarySearch, long j, int i, int i2) {
        IIX0o.x0xO0oo(binarySearch, "$this$binarySearch");
        kotlin.collections.II0xO0.Companion.oxoX(i, i2, OOXIxO0.ooOOo0oXI(binarySearch));
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int Oxx0IOOO2 = O0X.Oxx0IOOO(binarySearch[i4], j);
            if (Oxx0IOOO2 < 0) {
                i = i4 + 1;
            } else if (Oxx0IOOO2 > 0) {
                i3 = i4 - 1;
            } else {
                return i4;
            }
        }
        return -(i + 1);
    }

    @oI0IIXIo
    @oxxXoxO(version = "1.3")
    @kotlin.OOXIXo(message = "Use minOrNull instead.", replaceWith = @XX(expression = "this.minOrNull()", imports = {}))
    @oOoXoXO(errorSince = "1.5", hiddenSince = "1.6", warningSince = BuildConfig.VERSION_NAME)
    public static final /* synthetic */ x0xO xxX(byte[] min) {
        IIX0o.x0xO0oo(min, "$this$min");
        return UArraysKt___UArraysKt.xXXXox(min);
    }
}
