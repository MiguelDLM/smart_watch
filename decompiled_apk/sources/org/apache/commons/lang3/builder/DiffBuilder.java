package org.apache.commons.lang3.builder;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.xoIxX;

/* loaded from: classes6.dex */
public class DiffBuilder<T> implements oIX0oI<I0Io<T>> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final T f32636IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final boolean f32637Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public final T f32638Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final List<Diff<?>> f32639XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public final ToStringStyle f32640oI0IIXIo;

    public DiffBuilder(T t, T t2, ToStringStyle toStringStyle, boolean z) {
        boolean z2 = false;
        xoIxX.xo0x(t, "lhs cannot be null", new Object[0]);
        xoIxX.xo0x(t2, "rhs cannot be null", new Object[0]);
        this.f32639XO = new ArrayList();
        this.f32636IXxxXO = t;
        this.f32638Oxx0xo = t2;
        this.f32640oI0IIXIo = toStringStyle;
        if (z && (t == t2 || t.equals(t2))) {
            z2 = true;
        }
        this.f32637Oo = z2;
    }

    public DiffBuilder<T> I0Io(String str, final double d, final double d2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (Double.doubleToLongBits(d) != Double.doubleToLongBits(d2)) {
            this.f32639XO.add(new Diff<Double>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.7
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Double getLeft() {
                    return Double.valueOf(d);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Double getRight() {
                    return Double.valueOf(d2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> II0XooXoX(String str, I0Io<T> i0Io) {
        OxxIIOOXO(str);
        xoIxX.xo0x(i0Io, "Diff result cannot be null", new Object[0]);
        if (this.f32637Oo) {
            return this;
        }
        for (Diff<?> diff : i0Io.oIX0oI()) {
            Oxx0IOOO(str + FileUtils.FILE_EXTENSION_SEPARATOR + diff.getFieldName(), diff.getLeft(), diff.getRight());
        }
        return this;
    }

    public DiffBuilder<T> II0xO0(String str, final char c, final char c2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (c != c2) {
            this.f32639XO.add(new Diff<Character>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.5
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Character getLeft() {
                    return Character.valueOf(c);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Character getRight() {
                    return Character.valueOf(c2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> IXxxXO(String str, final short[] sArr, final short[] sArr2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (!Arrays.equals(sArr, sArr2)) {
            this.f32639XO.add(new Diff<Short[]>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.16
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Short[] getLeft() {
                    return org.apache.commons.lang3.oxoX.XoIoOXOIx(sArr);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Short[] getRight() {
                    return org.apache.commons.lang3.oxoX.XoIoOXOIx(sArr2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> OOXIXo(String str, final byte[] bArr, final byte[] bArr2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (!Arrays.equals(bArr, bArr2)) {
            this.f32639XO.add(new Diff<Byte[]>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.4
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Byte[] getLeft() {
                    return org.apache.commons.lang3.oxoX.xxx(bArr);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Byte[] getRight() {
                    return org.apache.commons.lang3.oxoX.xxx(bArr2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> Oo(String str, final Object[] objArr, final Object[] objArr2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (!Arrays.equals(objArr, objArr2)) {
            this.f32639XO.add(new Diff<Object[]>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.18
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Object[] getLeft() {
                    return objArr;
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Object[] getRight() {
                    return objArr2;
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> Oxx0IOOO(String str, final Object obj, final Object obj2) {
        Object obj3;
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (obj == obj2) {
            return this;
        }
        if (obj != null) {
            obj3 = obj;
        } else {
            obj3 = obj2;
        }
        if (obj3.getClass().isArray()) {
            if (obj3 instanceof boolean[]) {
                return Oxx0xo(str, (boolean[]) obj, (boolean[]) obj2);
            }
            if (obj3 instanceof byte[]) {
                return OOXIXo(str, (byte[]) obj, (byte[]) obj2);
            }
            if (obj3 instanceof char[]) {
                return oOoXoXO(str, (char[]) obj, (char[]) obj2);
            }
            if (obj3 instanceof double[]) {
                return ooOOo0oXI(str, (double[]) obj, (double[]) obj2);
            }
            if (obj3 instanceof float[]) {
                return x0XOIxOo(str, (float[]) obj, (float[]) obj2);
            }
            if (obj3 instanceof int[]) {
                return oO(str, (int[]) obj, (int[]) obj2);
            }
            if (obj3 instanceof long[]) {
                return x0xO0oo(str, (long[]) obj, (long[]) obj2);
            }
            if (obj3 instanceof short[]) {
                return IXxxXO(str, (short[]) obj, (short[]) obj2);
            }
            return Oo(str, (Object[]) obj, (Object[]) obj2);
        }
        if (obj != null && obj.equals(obj2)) {
            return this;
        }
        this.f32639XO.add(new Diff<Object>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.17
            private static final long serialVersionUID = 1;

            @Override // org.apache.commons.lang3.tuple.Pair
            public Object getLeft() {
                return obj;
            }

            @Override // org.apache.commons.lang3.tuple.Pair
            public Object getRight() {
                return obj2;
            }
        });
        return this;
    }

    public DiffBuilder<T> Oxx0xo(String str, final boolean[] zArr, final boolean[] zArr2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (!Arrays.equals(zArr, zArr2)) {
            this.f32639XO.add(new Diff<Boolean[]>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.2
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Boolean[] getLeft() {
                    return org.apache.commons.lang3.oxoX.IxOIO(zArr);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Boolean[] getRight() {
                    return org.apache.commons.lang3.oxoX.IxOIO(zArr2);
                }
            });
        }
        return this;
    }

    public final void OxxIIOOXO(String str) {
        xoIxX.xo0x(str, "Field name cannot be null", new Object[0]);
    }

    public DiffBuilder<T> X0o0xo(String str, final int i, final int i2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (i != i2) {
            this.f32639XO.add(new Diff<Integer>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.11
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Integer getLeft() {
                    return Integer.valueOf(i);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Integer getRight() {
                    return Integer.valueOf(i2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> XO(String str, final long j, final long j2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (j != j2) {
            this.f32639XO.add(new Diff<Long>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.13
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Long getLeft() {
                    return Long.valueOf(j);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Long getRight() {
                    return Long.valueOf(j2);
                }
            });
        }
        return this;
    }

    @Override // org.apache.commons.lang3.builder.oIX0oI
    /* renamed from: oI0IIXIo, reason: merged with bridge method [inline-methods] */
    public I0Io<T> build() {
        return new I0Io<>(this.f32636IXxxXO, this.f32638Oxx0xo, this.f32639XO, this.f32640oI0IIXIo);
    }

    public DiffBuilder<T> oIX0oI(String str, final byte b, final byte b2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (b != b2) {
            this.f32639XO.add(new Diff<Byte>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.3
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Byte getLeft() {
                    return Byte.valueOf(b);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Byte getRight() {
                    return Byte.valueOf(b2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> oO(String str, final int[] iArr, final int[] iArr2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (!Arrays.equals(iArr, iArr2)) {
            this.f32639XO.add(new Diff<Integer[]>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.12
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Integer[] getLeft() {
                    return org.apache.commons.lang3.oxoX.xxoXO(iArr);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Integer[] getRight() {
                    return org.apache.commons.lang3.oxoX.xxoXO(iArr2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> oOoXoXO(String str, final char[] cArr, final char[] cArr2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (!Arrays.equals(cArr, cArr2)) {
            this.f32639XO.add(new Diff<Character[]>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.6
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Character[] getLeft() {
                    return org.apache.commons.lang3.oxoX.OoxxX(cArr);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Character[] getRight() {
                    return org.apache.commons.lang3.oxoX.OoxxX(cArr2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> ooOOo0oXI(String str, final double[] dArr, final double[] dArr2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (!Arrays.equals(dArr, dArr2)) {
            this.f32639XO.add(new Diff<Double[]>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.8
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Double[] getLeft() {
                    return org.apache.commons.lang3.oxoX.oX0O(dArr);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Double[] getRight() {
                    return org.apache.commons.lang3.oxoX.oX0O(dArr2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> oxoX(String str, final float f, final float f2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (Float.floatToIntBits(f) != Float.floatToIntBits(f2)) {
            this.f32639XO.add(new Diff<Float>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.9
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Float getLeft() {
                    return Float.valueOf(f);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Float getRight() {
                    return Float.valueOf(f2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> x0XOIxOo(String str, final float[] fArr, final float[] fArr2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (!Arrays.equals(fArr, fArr2)) {
            this.f32639XO.add(new Diff<Float[]>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.10
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Float[] getLeft() {
                    return org.apache.commons.lang3.oxoX.Oo0xX(fArr);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Float[] getRight() {
                    return org.apache.commons.lang3.oxoX.Oo0xX(fArr2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> x0xO0oo(String str, final long[] jArr, final long[] jArr2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (!Arrays.equals(jArr, jArr2)) {
            this.f32639XO.add(new Diff<Long[]>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.14
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Long[] getLeft() {
                    return org.apache.commons.lang3.oxoX.oOxxXI(jArr);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Long[] getRight() {
                    return org.apache.commons.lang3.oxoX.oOxxXI(jArr2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> xoIox(String str, final boolean z, final boolean z2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (z != z2) {
            this.f32639XO.add(new Diff<Boolean>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.1
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Boolean getLeft() {
                    return Boolean.valueOf(z);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Boolean getRight() {
                    return Boolean.valueOf(z2);
                }
            });
        }
        return this;
    }

    public DiffBuilder<T> xxIXOIIO(String str, final short s, final short s2) {
        OxxIIOOXO(str);
        if (this.f32637Oo) {
            return this;
        }
        if (s != s2) {
            this.f32639XO.add(new Diff<Short>(str) { // from class: org.apache.commons.lang3.builder.DiffBuilder.15
                private static final long serialVersionUID = 1;

                @Override // org.apache.commons.lang3.tuple.Pair
                public Short getLeft() {
                    return Short.valueOf(s);
                }

                @Override // org.apache.commons.lang3.tuple.Pair
                public Short getRight() {
                    return Short.valueOf(s2);
                }
            });
        }
        return this;
    }

    public DiffBuilder(T t, T t2, ToStringStyle toStringStyle) {
        this(t, t2, toStringStyle, true);
    }
}
