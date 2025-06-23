package androidx.work;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.TypeConverter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.reflect.oxoX;
import org.apache.commons.text.ooOOo0oXI;

@XX({"SMAP\nData_.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Data_.kt\nandroidx/work/Data\n*L\n1#1,841:1\n55#1,2:842\n63#1,4:844\n55#1,2:848\n63#1,4:850\n55#1,2:854\n63#1,4:856\n55#1,2:860\n63#1,4:862\n55#1,2:866\n63#1,4:868\n55#1,2:872\n63#1,4:874\n63#1,4:878\n*S KotlinDebug\n*F\n+ 1 Data_.kt\nandroidx/work/Data\n*L\n76#1:842,2\n84#1:844,4\n93#1:848,2\n101#1:850,4\n110#1:854,2\n118#1:856,4\n127#1:860,2\n135#1:862,4\n144#1:866,2\n152#1:868,4\n161#1:872,2\n169#1:874,4\n185#1:878,4\n*E\n"})
public final class Data {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @XO
    @OOXIXo
    public static final Data EMPTY = new Builder().build();
    @SuppressLint({"MinMaxConstant"})
    public static final int MAX_DATA_BYTES = 10240;
    @OOXIXo
    private static final String NULL_STRING_V1 = "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d";
    private static final short STREAM_MAGIC = -21521;
    private static final short STREAM_VERSION = 1;
    private static final byte TYPE_BOOLEAN = 1;
    private static final byte TYPE_BOOLEAN_ARRAY = 8;
    private static final byte TYPE_BYTE = 2;
    private static final byte TYPE_BYTE_ARRAY = 9;
    private static final byte TYPE_DOUBLE = 6;
    private static final byte TYPE_DOUBLE_ARRAY = 13;
    private static final byte TYPE_FLOAT = 5;
    private static final byte TYPE_FLOAT_ARRAY = 12;
    private static final byte TYPE_INTEGER = 3;
    private static final byte TYPE_INTEGER_ARRAY = 10;
    private static final byte TYPE_LONG = 4;
    private static final byte TYPE_LONG_ARRAY = 11;
    private static final byte TYPE_NULL = 0;
    private static final byte TYPE_STRING = 7;
    private static final byte TYPE_STRING_ARRAY = 14;
    /* access modifiers changed from: private */
    @OOXIXo
    public final Map<String, Object> values;

    @XX({"SMAP\nData_.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Data_.kt\nandroidx/work/Data$Builder\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,841:1\n215#2,2:842\n*S KotlinDebug\n*F\n+ 1 Data_.kt\nandroidx/work/Data$Builder\n*L\n469#1:842,2\n*E\n"})
    public static final class Builder {
        @OOXIXo
        private final Map<String, Object> values = new LinkedHashMap();

        private final Builder putDirect(String str, Object obj) {
            this.values.put(str, obj);
            return this;
        }

        @OOXIXo
        public final Data build() {
            Data data = new Data((Map<String, ?>) this.values);
            Data.Companion.toByteArrayInternalV1(data);
            return data;
        }

        @OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final Builder put(@OOXIXo String str, @oOoXoXO Object obj) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            boolean z11;
            boolean z12;
            IIX0o.x0xO0oo(str, "key");
            Map<String, Object> map = this.values;
            if (obj == null) {
                obj = null;
            } else {
                oxoX oxoX2 = IO.oxoX(obj.getClass());
                boolean z13 = true;
                if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Boolean.TYPE))) {
                    z = true;
                } else {
                    z = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Byte.TYPE));
                }
                if (z) {
                    z2 = true;
                } else {
                    z2 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Integer.TYPE));
                }
                if (z2) {
                    z3 = true;
                } else {
                    z3 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Long.TYPE));
                }
                if (z3) {
                    z4 = true;
                } else {
                    z4 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Float.TYPE));
                }
                if (z4) {
                    z5 = true;
                } else {
                    z5 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Double.TYPE));
                }
                if (z5) {
                    z6 = true;
                } else {
                    z6 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(String.class));
                }
                if (z6) {
                    z7 = true;
                } else {
                    z7 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Boolean[].class));
                }
                if (z7) {
                    z8 = true;
                } else {
                    z8 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Byte[].class));
                }
                if (z8) {
                    z9 = true;
                } else {
                    z9 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Integer[].class));
                }
                if (z9) {
                    z10 = true;
                } else {
                    z10 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Long[].class));
                }
                if (z10) {
                    z11 = true;
                } else {
                    z11 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Float[].class));
                }
                if (z11) {
                    z12 = true;
                } else {
                    z12 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Double[].class));
                }
                if (!z12) {
                    z13 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(String[].class));
                }
                if (!z13) {
                    if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(boolean[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((boolean[]) obj);
                    } else if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(byte[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((byte[]) obj);
                    } else if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(int[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((int[]) obj);
                    } else if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(long[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((long[]) obj);
                    } else if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(float[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((float[]) obj);
                    } else if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(double[].class))) {
                        obj = Data_Kt.convertPrimitiveArray((double[]) obj);
                    } else {
                        throw new IllegalArgumentException("Key " + str + " has invalid type " + oxoX2);
                    }
                }
            }
            map.put(str, obj);
            return this;
        }

        @OOXIXo
        public final Builder putAll(@OOXIXo Data data) {
            IIX0o.x0xO0oo(data, "data");
            putAll((Map<String, ? extends Object>) data.values);
            return this;
        }

        @OOXIXo
        public final Builder putBoolean(@OOXIXo String str, boolean z) {
            IIX0o.x0xO0oo(str, "key");
            return putDirect(str, Boolean.valueOf(z));
        }

        @OOXIXo
        public final Builder putBooleanArray(@OOXIXo String str, @OOXIXo boolean[] zArr) {
            IIX0o.x0xO0oo(str, "key");
            IIX0o.x0xO0oo(zArr, "value");
            this.values.put(str, Data_Kt.convertPrimitiveArray(zArr));
            return this;
        }

        @OOXIXo
        public final Builder putByte(@OOXIXo String str, byte b) {
            IIX0o.x0xO0oo(str, "key");
            return putDirect(str, Byte.valueOf(b));
        }

        @OOXIXo
        public final Builder putByteArray(@OOXIXo String str, @OOXIXo byte[] bArr) {
            IIX0o.x0xO0oo(str, "key");
            IIX0o.x0xO0oo(bArr, "value");
            this.values.put(str, Data_Kt.convertPrimitiveArray(bArr));
            return this;
        }

        @OOXIXo
        public final Builder putDouble(@OOXIXo String str, double d) {
            IIX0o.x0xO0oo(str, "key");
            return putDirect(str, Double.valueOf(d));
        }

        @OOXIXo
        public final Builder putDoubleArray(@OOXIXo String str, @OOXIXo double[] dArr) {
            IIX0o.x0xO0oo(str, "key");
            IIX0o.x0xO0oo(dArr, "value");
            this.values.put(str, Data_Kt.convertPrimitiveArray(dArr));
            return this;
        }

        @OOXIXo
        public final Builder putFloat(@OOXIXo String str, float f) {
            IIX0o.x0xO0oo(str, "key");
            return putDirect(str, Float.valueOf(f));
        }

        @OOXIXo
        public final Builder putFloatArray(@OOXIXo String str, @OOXIXo float[] fArr) {
            IIX0o.x0xO0oo(str, "key");
            IIX0o.x0xO0oo(fArr, "value");
            this.values.put(str, Data_Kt.convertPrimitiveArray(fArr));
            return this;
        }

        @OOXIXo
        public final Builder putInt(@OOXIXo String str, int i) {
            IIX0o.x0xO0oo(str, "key");
            return putDirect(str, Integer.valueOf(i));
        }

        @OOXIXo
        public final Builder putIntArray(@OOXIXo String str, @OOXIXo int[] iArr) {
            IIX0o.x0xO0oo(str, "key");
            IIX0o.x0xO0oo(iArr, "value");
            this.values.put(str, Data_Kt.convertPrimitiveArray(iArr));
            return this;
        }

        @OOXIXo
        public final Builder putLong(@OOXIXo String str, long j) {
            IIX0o.x0xO0oo(str, "key");
            return putDirect(str, Long.valueOf(j));
        }

        @OOXIXo
        public final Builder putLongArray(@OOXIXo String str, @OOXIXo long[] jArr) {
            IIX0o.x0xO0oo(str, "key");
            IIX0o.x0xO0oo(jArr, "value");
            this.values.put(str, Data_Kt.convertPrimitiveArray(jArr));
            return this;
        }

        @OOXIXo
        public final Builder putString(@OOXIXo String str, @oOoXoXO String str2) {
            IIX0o.x0xO0oo(str, "key");
            return putDirect(str, str2);
        }

        @OOXIXo
        public final Builder putStringArray(@OOXIXo String str, @OOXIXo String[] strArr) {
            IIX0o.x0xO0oo(str, "key");
            IIX0o.x0xO0oo(strArr, "value");
            return putDirect(str, strArr);
        }

        @OOXIXo
        public final Builder putAll(@OOXIXo Map<String, ? extends Object> map) {
            IIX0o.x0xO0oo(map, "values");
            for (Map.Entry next : map.entrySet()) {
                put((String) next.getKey(), next.getValue());
            }
            return this;
        }
    }

    @XX({"SMAP\nData_.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Data_.kt\nandroidx/work/Data$Companion\n+ 2 LoggerExt.kt\nandroidx/work/LoggerExtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,841:1\n32#2:842\n32#2:843\n32#2:845\n32#2:846\n1#3:844\n*S KotlinDebug\n*F\n+ 1 Data_.kt\nandroidx/work/Data$Companion\n*L\n599#1:842\n710#1:843\n814#1:845\n816#1:846\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private static final boolean fromByteArray$isObjectStream(ByteArrayInputStream byteArrayInputStream) {
            byte[] bArr = new byte[2];
            byteArrayInputStream.read(bArr);
            byte b = (byte) -21267;
            boolean z = false;
            if (bArr[0] == ((byte) 16777132) && bArr[1] == b) {
                z = true;
            }
            byteArrayInputStream.reset();
            return z;
        }

        private static final void fromByteArray$readHeader(DataInputStream dataInputStream) {
            short readShort = dataInputStream.readShort();
            if (readShort == -21521) {
                short readShort2 = dataInputStream.readShort();
                if (readShort2 != 1) {
                    throw new IllegalStateException(("Unsupported version number: " + readShort2).toString());
                }
                return;
            }
            throw new IllegalStateException(("Magic number doesn't match: " + readShort).toString());
        }

        private static final Object fromByteArray$readValue(DataInputStream dataInputStream, byte b) {
            if (b == 0) {
                return null;
            }
            if (b == 1) {
                return Boolean.valueOf(dataInputStream.readBoolean());
            }
            if (b == 2) {
                return Byte.valueOf(dataInputStream.readByte());
            }
            if (b == 3) {
                return Integer.valueOf(dataInputStream.readInt());
            }
            if (b == 4) {
                return Long.valueOf(dataInputStream.readLong());
            }
            if (b == 5) {
                return Float.valueOf(dataInputStream.readFloat());
            }
            if (b == 6) {
                return Double.valueOf(dataInputStream.readDouble());
            }
            if (b == 7) {
                return dataInputStream.readUTF();
            }
            int i = 0;
            if (b == 8) {
                int readInt = dataInputStream.readInt();
                Boolean[] boolArr = new Boolean[readInt];
                while (i < readInt) {
                    boolArr[i] = Boolean.valueOf(dataInputStream.readBoolean());
                    i++;
                }
                return boolArr;
            } else if (b == 9) {
                int readInt2 = dataInputStream.readInt();
                Byte[] bArr = new Byte[readInt2];
                while (i < readInt2) {
                    bArr[i] = Byte.valueOf(dataInputStream.readByte());
                    i++;
                }
                return bArr;
            } else if (b == 10) {
                int readInt3 = dataInputStream.readInt();
                Integer[] numArr = new Integer[readInt3];
                while (i < readInt3) {
                    numArr[i] = Integer.valueOf(dataInputStream.readInt());
                    i++;
                }
                return numArr;
            } else if (b == 11) {
                int readInt4 = dataInputStream.readInt();
                Long[] lArr = new Long[readInt4];
                while (i < readInt4) {
                    lArr[i] = Long.valueOf(dataInputStream.readLong());
                    i++;
                }
                return lArr;
            } else if (b == 12) {
                int readInt5 = dataInputStream.readInt();
                Float[] fArr = new Float[readInt5];
                while (i < readInt5) {
                    fArr[i] = Float.valueOf(dataInputStream.readFloat());
                    i++;
                }
                return fArr;
            } else if (b == 13) {
                int readInt6 = dataInputStream.readInt();
                Double[] dArr = new Double[readInt6];
                while (i < readInt6) {
                    dArr[i] = Double.valueOf(dataInputStream.readDouble());
                    i++;
                }
                return dArr;
            } else if (b == 14) {
                int readInt7 = dataInputStream.readInt();
                String[] strArr = new String[readInt7];
                while (i < readInt7) {
                    String readUTF = dataInputStream.readUTF();
                    if (IIX0o.Oxx0IOOO(readUTF, Data.NULL_STRING_V1)) {
                        readUTF = null;
                    }
                    strArr[i] = readUTF;
                    i++;
                }
                return strArr;
            } else {
                throw new IllegalStateException("Unsupported type " + b);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.Double} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.lang.Double} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: java.lang.Float} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.Float} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.lang.Long} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v13, resolved type: java.lang.Long} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v16, resolved type: java.lang.Integer} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: java.lang.Byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: java.lang.Byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v22, resolved type: java.lang.Boolean} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v24, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r12v0 */
        /* JADX WARNING: type inference failed for: r12v25 */
        /* JADX WARNING: type inference failed for: r12v26 */
        /* JADX WARNING: type inference failed for: r12v27 */
        /* JADX WARNING: type inference failed for: r12v28 */
        /* JADX WARNING: type inference failed for: r12v29 */
        /* JADX WARNING: type inference failed for: r12v30 */
        /* JADX WARNING: type inference failed for: r12v31 */
        /* JADX WARNING: Failed to insert additional move for type inference */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static final void toByteArrayInternalV1$writeArray(java.io.DataOutputStream r14, java.lang.Object[] r15) {
            /*
                java.lang.Class r0 = r15.getClass()
                kotlin.reflect.oxoX r0 = kotlin.jvm.internal.IO.oxoX(r0)
                java.lang.Class<java.lang.Boolean[]> r1 = java.lang.Boolean[].class
                kotlin.reflect.oxoX r1 = kotlin.jvm.internal.IO.oxoX(r1)
                boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
                r2 = 14
                r3 = 13
                r4 = 12
                r5 = 11
                r6 = 10
                r7 = 9
                r8 = 8
                if (r1 == 0) goto L_0x0025
                r0 = 8
                goto L_0x007e
            L_0x0025:
                java.lang.Class<java.lang.Byte[]> r1 = java.lang.Byte[].class
                kotlin.reflect.oxoX r1 = kotlin.jvm.internal.IO.oxoX(r1)
                boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
                if (r1 == 0) goto L_0x0034
                r0 = 9
                goto L_0x007e
            L_0x0034:
                java.lang.Class<java.lang.Integer[]> r1 = java.lang.Integer[].class
                kotlin.reflect.oxoX r1 = kotlin.jvm.internal.IO.oxoX(r1)
                boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
                if (r1 == 0) goto L_0x0043
                r0 = 10
                goto L_0x007e
            L_0x0043:
                java.lang.Class<java.lang.Long[]> r1 = java.lang.Long[].class
                kotlin.reflect.oxoX r1 = kotlin.jvm.internal.IO.oxoX(r1)
                boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
                if (r1 == 0) goto L_0x0052
                r0 = 11
                goto L_0x007e
            L_0x0052:
                java.lang.Class<java.lang.Float[]> r1 = java.lang.Float[].class
                kotlin.reflect.oxoX r1 = kotlin.jvm.internal.IO.oxoX(r1)
                boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
                if (r1 == 0) goto L_0x0061
                r0 = 12
                goto L_0x007e
            L_0x0061:
                java.lang.Class<java.lang.Double[]> r1 = java.lang.Double[].class
                kotlin.reflect.oxoX r1 = kotlin.jvm.internal.IO.oxoX(r1)
                boolean r1 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
                if (r1 == 0) goto L_0x0070
                r0 = 13
                goto L_0x007e
            L_0x0070:
                java.lang.Class<java.lang.String[]> r1 = java.lang.String[].class
                kotlin.reflect.oxoX r1 = kotlin.jvm.internal.IO.oxoX(r1)
                boolean r0 = kotlin.jvm.internal.IIX0o.Oxx0IOOO(r0, r1)
                if (r0 == 0) goto L_0x0124
                r0 = 14
            L_0x007e:
                r14.writeByte(r0)
                int r1 = r15.length
                r14.writeInt(r1)
                int r1 = r15.length
                r9 = 0
                r10 = 0
            L_0x0088:
                if (r10 >= r1) goto L_0x0123
                r11 = r15[r10]
                r12 = 0
                if (r0 != r8) goto L_0x00a3
                boolean r13 = r11 instanceof java.lang.Boolean
                if (r13 == 0) goto L_0x0096
                r12 = r11
                java.lang.Boolean r12 = (java.lang.Boolean) r12
            L_0x0096:
                if (r12 == 0) goto L_0x009d
                boolean r11 = r12.booleanValue()
                goto L_0x009e
            L_0x009d:
                r11 = 0
            L_0x009e:
                r14.writeBoolean(r11)
                goto L_0x011f
            L_0x00a3:
                if (r0 != r7) goto L_0x00b9
                boolean r13 = r11 instanceof java.lang.Byte
                if (r13 == 0) goto L_0x00ac
                r12 = r11
                java.lang.Byte r12 = (java.lang.Byte) r12
            L_0x00ac:
                if (r12 == 0) goto L_0x00b3
                byte r11 = r12.byteValue()
                goto L_0x00b4
            L_0x00b3:
                r11 = 0
            L_0x00b4:
                r14.writeByte(r11)
                goto L_0x011f
            L_0x00b9:
                if (r0 != r6) goto L_0x00ce
                boolean r13 = r11 instanceof java.lang.Integer
                if (r13 == 0) goto L_0x00c2
                r12 = r11
                java.lang.Integer r12 = (java.lang.Integer) r12
            L_0x00c2:
                if (r12 == 0) goto L_0x00c9
                int r11 = r12.intValue()
                goto L_0x00ca
            L_0x00c9:
                r11 = 0
            L_0x00ca:
                r14.writeInt(r11)
                goto L_0x011f
            L_0x00ce:
                if (r0 != r5) goto L_0x00e4
                boolean r13 = r11 instanceof java.lang.Long
                if (r13 == 0) goto L_0x00d7
                r12 = r11
                java.lang.Long r12 = (java.lang.Long) r12
            L_0x00d7:
                if (r12 == 0) goto L_0x00de
                long r11 = r12.longValue()
                goto L_0x00e0
            L_0x00de:
                r11 = 0
            L_0x00e0:
                r14.writeLong(r11)
                goto L_0x011f
            L_0x00e4:
                if (r0 != r4) goto L_0x00f9
                boolean r13 = r11 instanceof java.lang.Float
                if (r13 == 0) goto L_0x00ed
                r12 = r11
                java.lang.Float r12 = (java.lang.Float) r12
            L_0x00ed:
                if (r12 == 0) goto L_0x00f4
                float r11 = r12.floatValue()
                goto L_0x00f5
            L_0x00f4:
                r11 = 0
            L_0x00f5:
                r14.writeFloat(r11)
                goto L_0x011f
            L_0x00f9:
                if (r0 != r3) goto L_0x010f
                boolean r13 = r11 instanceof java.lang.Double
                if (r13 == 0) goto L_0x0102
                r12 = r11
                java.lang.Double r12 = (java.lang.Double) r12
            L_0x0102:
                if (r12 == 0) goto L_0x0109
                double r11 = r12.doubleValue()
                goto L_0x010b
            L_0x0109:
                r11 = 0
            L_0x010b:
                r14.writeDouble(r11)
                goto L_0x011f
            L_0x010f:
                if (r0 != r2) goto L_0x011f
                boolean r13 = r11 instanceof java.lang.String
                if (r13 == 0) goto L_0x0118
                r12 = r11
                java.lang.String r12 = (java.lang.String) r12
            L_0x0118:
                if (r12 != 0) goto L_0x011c
                java.lang.String r12 = "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d"
            L_0x011c:
                r14.writeUTF(r12)
            L_0x011f:
                int r10 = r10 + 1
                goto L_0x0088
            L_0x0123:
                return
            L_0x0124:
                java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Unsupported value type "
                r0.append(r1)
                java.lang.Class r15 = r15.getClass()
                kotlin.reflect.oxoX r15 = kotlin.jvm.internal.IO.oxoX(r15)
                java.lang.String r15 = r15.II0XooXoX()
                r0.append(r15)
                java.lang.String r15 = r0.toString()
                r14.<init>(r15)
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.Companion.toByteArrayInternalV1$writeArray(java.io.DataOutputStream, java.lang.Object[]):void");
        }

        private static final void toByteArrayInternalV1$writeEntry(DataOutputStream dataOutputStream, String str, Object obj) {
            if (obj == null) {
                dataOutputStream.writeByte(0);
            } else if (obj instanceof Boolean) {
                dataOutputStream.writeByte(1);
                dataOutputStream.writeBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                dataOutputStream.writeByte(2);
                dataOutputStream.writeByte(((Number) obj).byteValue());
            } else if (obj instanceof Integer) {
                dataOutputStream.writeByte(3);
                dataOutputStream.writeInt(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                dataOutputStream.writeByte(4);
                dataOutputStream.writeLong(((Number) obj).longValue());
            } else if (obj instanceof Float) {
                dataOutputStream.writeByte(5);
                dataOutputStream.writeFloat(((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                dataOutputStream.writeByte(6);
                dataOutputStream.writeDouble(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                dataOutputStream.writeByte(7);
                dataOutputStream.writeUTF((String) obj);
            } else if (obj instanceof Object[]) {
                toByteArrayInternalV1$writeArray(dataOutputStream, (Object[]) obj);
            } else {
                throw new IllegalArgumentException("Unsupported value type " + IO.oxoX(obj.getClass()).xoXoI());
            }
            dataOutputStream.writeUTF(str);
        }

        private static final void toByteArrayInternalV1$writeHeader(DataOutputStream dataOutputStream) {
            dataOutputStream.writeShort(-21521);
            dataOutputStream.writeShort(1);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            kotlin.io.II0xO0.oIX0oI(r9, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0051, code lost:
            throw r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x007e, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
            kotlin.io.II0xO0.oIX0oI(r9, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0082, code lost:
            throw r3;
         */
        @androidx.room.TypeConverter
        @XO0OX.x0XOIxOo
        @OXOo.OOXIXo
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.work.Data fromByteArray(@OXOo.OOXIXo byte[] r9) {
            /*
                r8 = this;
                java.lang.String r0 = "Error in Data#fromByteArray: "
                java.lang.String r1 = "bytes"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r9, r1)
                int r1 = r9.length
                r2 = 10240(0x2800, float:1.4349E-41)
                if (r1 > r2) goto L_0x00a0
                int r1 = r9.length
                if (r1 != 0) goto L_0x0012
                androidx.work.Data r9 = androidx.work.Data.EMPTY
                return r9
            L_0x0012:
                java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
                r1.<init>()
                java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
                r2.<init>(r9)     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
                boolean r9 = fromByteArray$isObjectStream(r2)     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
                r3 = 0
                r4 = 0
                if (r9 == 0) goto L_0x0052
                java.io.ObjectInputStream r9 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
                r9.<init>(r2)     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
                int r2 = r9.readInt()     // Catch:{ all -> 0x0042 }
            L_0x002d:
                if (r3 >= r2) goto L_0x0044
                java.lang.String r5 = r9.readUTF()     // Catch:{ all -> 0x0042 }
                java.lang.String r6 = "readUTF()"
                kotlin.jvm.internal.IIX0o.oO(r5, r6)     // Catch:{ all -> 0x0042 }
                java.lang.Object r6 = r9.readObject()     // Catch:{ all -> 0x0042 }
                r1.put(r5, r6)     // Catch:{ all -> 0x0042 }
                int r3 = r3 + 1
                goto L_0x002d
            L_0x0042:
                r2 = move-exception
                goto L_0x004c
            L_0x0044:
                kotlin.io.II0xO0.oIX0oI(r9, r4)     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
                goto L_0x009a
            L_0x0048:
                r9 = move-exception
                goto L_0x0083
            L_0x004a:
                r9 = move-exception
                goto L_0x008f
            L_0x004c:
                throw r2     // Catch:{ all -> 0x004d }
            L_0x004d:
                r3 = move-exception
                kotlin.io.II0xO0.oIX0oI(r9, r2)     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
                throw r3     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
            L_0x0052:
                java.io.DataInputStream r9 = new java.io.DataInputStream     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
                r9.<init>(r2)     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
                fromByteArray$readHeader(r9)     // Catch:{ all -> 0x0077 }
                int r2 = r9.readInt()     // Catch:{ all -> 0x0077 }
            L_0x005e:
                if (r3 >= r2) goto L_0x0079
                byte r5 = r9.readByte()     // Catch:{ all -> 0x0077 }
                java.lang.Object r5 = fromByteArray$readValue(r9, r5)     // Catch:{ all -> 0x0077 }
                java.lang.String r6 = r9.readUTF()     // Catch:{ all -> 0x0077 }
                java.lang.String r7 = "key"
                kotlin.jvm.internal.IIX0o.oO(r6, r7)     // Catch:{ all -> 0x0077 }
                r1.put(r6, r5)     // Catch:{ all -> 0x0077 }
                int r3 = r3 + 1
                goto L_0x005e
            L_0x0077:
                r2 = move-exception
                goto L_0x007d
            L_0x0079:
                kotlin.io.II0xO0.oIX0oI(r9, r4)     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
                goto L_0x009a
            L_0x007d:
                throw r2     // Catch:{ all -> 0x007e }
            L_0x007e:
                r3 = move-exception
                kotlin.io.II0xO0.oIX0oI(r9, r2)     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
                throw r3     // Catch:{ IOException -> 0x004a, ClassNotFoundException -> 0x0048 }
            L_0x0083:
                java.lang.String r2 = androidx.work.Data_Kt.TAG
                androidx.work.Logger r3 = androidx.work.Logger.get()
                r3.error(r2, r0, r9)
                goto L_0x009a
            L_0x008f:
                java.lang.String r2 = androidx.work.Data_Kt.TAG
                androidx.work.Logger r3 = androidx.work.Logger.get()
                r3.error(r2, r0, r9)
            L_0x009a:
                androidx.work.Data r9 = new androidx.work.Data
                r9.<init>((java.util.Map<java.lang.String, ?>) r1)
                return r9
            L_0x00a0:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
                r9.<init>(r0)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.Companion.fromByteArray(byte[]):androidx.work.Data");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0070, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            kotlin.io.II0xO0.oIX0oI(r0, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0074, code lost:
            throw r1;
         */
        @XO0OX.x0XOIxOo
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        @kotlin.OOXIXo(message = "This is kept for testing migration", replaceWith = @kotlin.XX(expression = "toByteArrayInternalV1", imports = {}))
        @OXOo.OOXIXo
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final byte[] toByteArrayInternalV0(@OXOo.OOXIXo androidx.work.Data r5) {
            /*
                r4 = this;
                java.lang.String r0 = "data"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
                java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x005d }
                r0.<init>()     // Catch:{ IOException -> 0x005d }
                java.io.ObjectOutputStream r1 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0067 }
                r1.<init>(r0)     // Catch:{ all -> 0x0067 }
                int r2 = r5.size()     // Catch:{ all -> 0x003f }
                r1.writeInt(r2)     // Catch:{ all -> 0x003f }
                java.util.Map r5 = r5.values     // Catch:{ all -> 0x003f }
                java.util.Set r5 = r5.entrySet()     // Catch:{ all -> 0x003f }
                java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x003f }
            L_0x0022:
                boolean r2 = r5.hasNext()     // Catch:{ all -> 0x003f }
                if (r2 == 0) goto L_0x0041
                java.lang.Object r2 = r5.next()     // Catch:{ all -> 0x003f }
                java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x003f }
                java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x003f }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x003f }
                java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x003f }
                r1.writeUTF(r3)     // Catch:{ all -> 0x003f }
                r1.writeObject(r2)     // Catch:{ all -> 0x003f }
                goto L_0x0022
            L_0x003f:
                r5 = move-exception
                goto L_0x0069
            L_0x0041:
                kotlin.oXIO0o0XI r5 = kotlin.oXIO0o0XI.f19155oIX0oI     // Catch:{ all -> 0x003f }
                r5 = 0
                kotlin.io.II0xO0.oIX0oI(r1, r5)     // Catch:{ all -> 0x0067 }
                kotlin.io.II0xO0.oIX0oI(r0, r5)     // Catch:{ IOException -> 0x005d }
                int r5 = r0.size()     // Catch:{ IOException -> 0x005d }
                r1 = 10240(0x2800, float:1.4349E-41)
                if (r5 > r1) goto L_0x005f
                byte[] r5 = r0.toByteArray()     // Catch:{ IOException -> 0x005d }
                java.lang.String r0 = "{\n                val st…ByteArray()\n            }"
                kotlin.jvm.internal.IIX0o.oO(r5, r0)     // Catch:{ IOException -> 0x005d }
                goto L_0x0085
            L_0x005d:
                r5 = move-exception
                goto L_0x0075
            L_0x005f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x005d }
                java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
                r5.<init>(r0)     // Catch:{ IOException -> 0x005d }
                throw r5     // Catch:{ IOException -> 0x005d }
            L_0x0067:
                r5 = move-exception
                goto L_0x006f
            L_0x0069:
                throw r5     // Catch:{ all -> 0x006a }
            L_0x006a:
                r2 = move-exception
                kotlin.io.II0xO0.oIX0oI(r1, r5)     // Catch:{ all -> 0x0067 }
                throw r2     // Catch:{ all -> 0x0067 }
            L_0x006f:
                throw r5     // Catch:{ all -> 0x0070 }
            L_0x0070:
                r1 = move-exception
                kotlin.io.II0xO0.oIX0oI(r0, r5)     // Catch:{ IOException -> 0x005d }
                throw r1     // Catch:{ IOException -> 0x005d }
            L_0x0075:
                java.lang.String r0 = androidx.work.Data_Kt.TAG
                androidx.work.Logger r1 = androidx.work.Logger.get()
                java.lang.String r2 = "Error in Data#toByteArray: "
                r1.error(r0, r2, r5)
                r5 = 0
                byte[] r5 = new byte[r5]
            L_0x0085:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.Companion.toByteArrayInternalV0(androidx.work.Data):byte[]");
        }

        @TypeConverter
        @x0XOIxOo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @OOXIXo
        public final byte[] toByteArrayInternalV1(@OOXIXo Data data) {
            IIX0o.x0xO0oo(data, "data");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    toByteArrayInternalV1$writeHeader(dataOutputStream);
                    dataOutputStream.writeInt(data.size());
                    for (Map.Entry entry : data.values.entrySet()) {
                        toByteArrayInternalV1$writeEntry(dataOutputStream, (String) entry.getKey(), entry.getValue());
                    }
                    dataOutputStream.flush();
                    if (dataOutputStream.size() <= 10240) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        II0xO0.oIX0oI(dataOutputStream, (Throwable) null);
                        IIX0o.oO(byteArray, "{\n                ByteAr…          }\n            }");
                        return byteArray;
                    }
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                } catch (Throwable th) {
                    II0xO0.oIX0oI(dataOutputStream, th);
                    throw th;
                }
            } catch (IOException e) {
                Logger.get().error(Data_Kt.TAG, "Error in Data#toByteArray: ", e);
                return new byte[0];
            }
        }

        private Companion() {
        }
    }

    public Data(@OOXIXo Data data) {
        IIX0o.x0xO0oo(data, "other");
        this.values = new HashMap(data.values);
    }

    @TypeConverter
    @x0XOIxOo
    @OOXIXo
    public static final Data fromByteArray(@OOXIXo byte[] bArr) {
        return Companion.fromByteArray(bArr);
    }

    private final /* synthetic */ <T> T getOrDefault(String str, T t) {
        T t2 = this.values.get(str);
        IIX0o.OxI(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (t2 instanceof Object) {
            return t2;
        }
        return t;
    }

    private final /* synthetic */ <T, TArray> TArray getTypedArray(String str, x0xO0oo<? super Integer, ? super Oox.oOoXoXO<? super Integer, ? extends T>, ? extends TArray> x0xo0oo) {
        Object obj = this.values.get(str);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                Integer valueOf = Integer.valueOf(objArr.length);
                IIX0o.xoXoI();
                return x0xo0oo.invoke(valueOf, new Data$getTypedArray$1(obj));
            }
        }
        return null;
    }

    @x0XOIxOo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @kotlin.OOXIXo(message = "This is kept for testing migration", replaceWith = @kotlin.XX(expression = "toByteArrayInternalV1", imports = {}))
    @OOXIXo
    public static final byte[] toByteArrayInternalV0(@OOXIXo Data data) {
        return Companion.toByteArrayInternalV0(data);
    }

    @TypeConverter
    @x0XOIxOo
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @OOXIXo
    public static final byte[] toByteArrayInternalV1(@OOXIXo Data data) {
        return Companion.toByteArrayInternalV1(data);
    }

    public boolean equals(@oOoXoXO Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (IIX0o.Oxx0IOOO(Data.class, obj.getClass())) {
                Data data = (Data) obj;
                Set<String> keySet = this.values.keySet();
                if (!IIX0o.Oxx0IOOO(keySet, data.values.keySet())) {
                    return false;
                }
                for (String next : keySet) {
                    Object obj2 = this.values.get(next);
                    Object obj3 = data.values.get(next);
                    if (obj2 != null && obj3 != null) {
                        if (obj2 instanceof Object[]) {
                            Object[] objArr = (Object[]) obj2;
                            if (obj3 instanceof Object[]) {
                                z = kotlin.collections.oOoXoXO.Oxx0IOOO(objArr, (Object[]) obj3);
                                continue;
                            }
                        }
                        z = IIX0o.Oxx0IOOO(obj2, obj3);
                        continue;
                    } else if (obj2 == obj3) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean getBoolean(@OOXIXo String str, boolean z) {
        IIX0o.x0xO0oo(str, "key");
        Object valueOf = Boolean.valueOf(z);
        Object obj = this.values.get(str);
        if (obj instanceof Boolean) {
            valueOf = obj;
        }
        return ((Boolean) valueOf).booleanValue();
    }

    @oOoXoXO
    public final boolean[] getBooleanArray(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Data$getBooleanArray$$inlined$getTypedArray$1 data$getBooleanArray$$inlined$getTypedArray$1 = new Data$getBooleanArray$$inlined$getTypedArray$1(obj);
                boolean[] zArr = new boolean[length];
                for (int i = 0; i < length; i++) {
                    zArr[i] = ((Boolean) data$getBooleanArray$$inlined$getTypedArray$1.invoke(Integer.valueOf(i))).booleanValue();
                }
                return zArr;
            }
        }
        return null;
    }

    public final byte getByte(@OOXIXo String str, byte b) {
        IIX0o.x0xO0oo(str, "key");
        Object valueOf = Byte.valueOf(b);
        Object obj = this.values.get(str);
        if (obj instanceof Byte) {
            valueOf = obj;
        }
        return ((Number) valueOf).byteValue();
    }

    @oOoXoXO
    public final byte[] getByteArray(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Data$getByteArray$$inlined$getTypedArray$1 data$getByteArray$$inlined$getTypedArray$1 = new Data$getByteArray$$inlined$getTypedArray$1(obj);
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr[i] = ((Number) data$getByteArray$$inlined$getTypedArray$1.invoke(Integer.valueOf(i))).byteValue();
                }
                return bArr;
            }
        }
        return null;
    }

    public final double getDouble(@OOXIXo String str, double d) {
        IIX0o.x0xO0oo(str, "key");
        Object valueOf = Double.valueOf(d);
        Object obj = this.values.get(str);
        if (obj instanceof Double) {
            valueOf = obj;
        }
        return ((Number) valueOf).doubleValue();
    }

    @oOoXoXO
    public final double[] getDoubleArray(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Data$getDoubleArray$$inlined$getTypedArray$1 data$getDoubleArray$$inlined$getTypedArray$1 = new Data$getDoubleArray$$inlined$getTypedArray$1(obj);
                double[] dArr = new double[length];
                for (int i = 0; i < length; i++) {
                    dArr[i] = ((Number) data$getDoubleArray$$inlined$getTypedArray$1.invoke(Integer.valueOf(i))).doubleValue();
                }
                return dArr;
            }
        }
        return null;
    }

    public final float getFloat(@OOXIXo String str, float f) {
        IIX0o.x0xO0oo(str, "key");
        Object valueOf = Float.valueOf(f);
        Object obj = this.values.get(str);
        if (obj instanceof Float) {
            valueOf = obj;
        }
        return ((Number) valueOf).floatValue();
    }

    @oOoXoXO
    public final float[] getFloatArray(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Data$getFloatArray$$inlined$getTypedArray$1 data$getFloatArray$$inlined$getTypedArray$1 = new Data$getFloatArray$$inlined$getTypedArray$1(obj);
                float[] fArr = new float[length];
                for (int i = 0; i < length; i++) {
                    fArr[i] = ((Number) data$getFloatArray$$inlined$getTypedArray$1.invoke(Integer.valueOf(i))).floatValue();
                }
                return fArr;
            }
        }
        return null;
    }

    public final int getInt(@OOXIXo String str, int i) {
        IIX0o.x0xO0oo(str, "key");
        Object valueOf = Integer.valueOf(i);
        Object obj = this.values.get(str);
        if (obj instanceof Integer) {
            valueOf = obj;
        }
        return ((Number) valueOf).intValue();
    }

    @oOoXoXO
    public final int[] getIntArray(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Data$getIntArray$$inlined$getTypedArray$1 data$getIntArray$$inlined$getTypedArray$1 = new Data$getIntArray$$inlined$getTypedArray$1(obj);
                int[] iArr = new int[length];
                for (int i = 0; i < length; i++) {
                    iArr[i] = ((Number) data$getIntArray$$inlined$getTypedArray$1.invoke(Integer.valueOf(i))).intValue();
                }
                return iArr;
            }
        }
        return null;
    }

    @OOXIXo
    public final Map<String, Object> getKeyValueMap() {
        Map<String, Object> unmodifiableMap = Collections.unmodifiableMap(this.values);
        IIX0o.oO(unmodifiableMap, "unmodifiableMap(values)");
        return unmodifiableMap;
    }

    public final long getLong(@OOXIXo String str, long j) {
        IIX0o.x0xO0oo(str, "key");
        Object valueOf = Long.valueOf(j);
        Object obj = this.values.get(str);
        if (obj instanceof Long) {
            valueOf = obj;
        }
        return ((Number) valueOf).longValue();
    }

    @oOoXoXO
    public final long[] getLongArray(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Data$getLongArray$$inlined$getTypedArray$1 data$getLongArray$$inlined$getTypedArray$1 = new Data$getLongArray$$inlined$getTypedArray$1(obj);
                long[] jArr = new long[length];
                for (int i = 0; i < length; i++) {
                    jArr[i] = ((Number) data$getLongArray$$inlined$getTypedArray$1.invoke(Integer.valueOf(i))).longValue();
                }
                return jArr;
            }
        }
        return null;
    }

    @oOoXoXO
    public final String getString(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    @OXOo.oOoXoXO
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String[] getStringArray(@OXOo.OOXIXo java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.values
            java.lang.Object r5 = r0.get(r5)
            boolean r0 = r5 instanceof java.lang.Object[]
            if (r0 == 0) goto L_0x002e
            r0 = r5
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            boolean r1 = r0 instanceof java.lang.Object[]
            if (r1 == 0) goto L_0x002e
            int r0 = r0.length
            androidx.work.Data$getStringArray$$inlined$getTypedArray$1 r1 = new androidx.work.Data$getStringArray$$inlined$getTypedArray$1
            r1.<init>(r5)
            java.lang.String[] r5 = new java.lang.String[r0]
            r2 = 0
        L_0x001f:
            if (r2 >= r0) goto L_0x002f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.Object r3 = r1.invoke(r3)
            r5[r2] = r3
            int r2 = r2 + 1
            goto L_0x001f
        L_0x002e:
            r5 = 0
        L_0x002f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.getStringArray(java.lang.String):java.lang.String[]");
    }

    public final /* synthetic */ <T> boolean hasKey$work_runtime_release(String str) {
        IIX0o.x0xO0oo(str, "key");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return hasKeyWithValueOfType(str, Object.class);
    }

    public final <T> boolean hasKeyWithValueOfType(@OOXIXo String str, @OOXIXo Class<T> cls) {
        IIX0o.x0xO0oo(str, "key");
        IIX0o.x0xO0oo(cls, "klass");
        Object obj = this.values.get(str);
        if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        for (Map.Entry next : this.values.entrySet()) {
            Object value = next.getValue();
            if (value instanceof Object[]) {
                i = Objects.hashCode(next.getKey()) ^ kotlin.collections.OOXIXo.II0xO0((Object[]) value);
            } else {
                i = next.hashCode();
            }
            i2 += i;
        }
        return i2 * 31;
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int size() {
        return this.values.size();
    }

    @OOXIXo
    public final byte[] toByteArray() {
        return Companion.toByteArrayInternalV1(this);
    }

    @OOXIXo
    public String toString() {
        String str = "Data {" + CollectionsKt___CollectionsKt.OoIXo(this.values.entrySet(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, Data$toString$1$content$1.INSTANCE, 31, (Object) null) + ooOOo0oXI.f22054oOoXoXO;
        IIX0o.oO(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }

    public Data(@OOXIXo Map<String, ?> map) {
        IIX0o.x0xO0oo(map, "values");
        this.values = new HashMap(map);
    }
}
