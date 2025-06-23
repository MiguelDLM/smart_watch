package androidx.work;

import Oox.x0xO0oo;
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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.IO;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import org.apache.commons.text.ooOOo0oXI;

@XX({"SMAP\nData_.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Data_.kt\nandroidx/work/Data\n*L\n1#1,841:1\n55#1,2:842\n63#1,4:844\n55#1,2:848\n63#1,4:850\n55#1,2:854\n63#1,4:856\n55#1,2:860\n63#1,4:862\n55#1,2:866\n63#1,4:868\n55#1,2:872\n63#1,4:874\n63#1,4:878\n*S KotlinDebug\n*F\n+ 1 Data_.kt\nandroidx/work/Data\n*L\n76#1:842,2\n84#1:844,4\n93#1:848,2\n101#1:850,4\n110#1:854,2\n118#1:856,4\n127#1:860,2\n135#1:862,4\n144#1:866,2\n152#1:868,4\n161#1:872,2\n169#1:874,4\n185#1:878,4\n*E\n"})
/* loaded from: classes.dex */
public final class Data {

    @OXOo.OOXIXo
    public static final Companion Companion = new Companion(null);

    @OXOo.OOXIXo
    @XO0OX.XO
    public static final Data EMPTY = new Builder().build();

    @SuppressLint({"MinMaxConstant"})
    public static final int MAX_DATA_BYTES = 10240;

    @OXOo.OOXIXo
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

    @OXOo.OOXIXo
    private final Map<String, Object> values;

    @XX({"SMAP\nData_.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Data_.kt\nandroidx/work/Data$Builder\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,841:1\n215#2,2:842\n*S KotlinDebug\n*F\n+ 1 Data_.kt\nandroidx/work/Data$Builder\n*L\n469#1:842,2\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Builder {

        @OXOo.OOXIXo
        private final Map<String, Object> values = new LinkedHashMap();

        private final Builder putDirect(String str, Object obj) {
            this.values.put(str, obj);
            return this;
        }

        @OXOo.OOXIXo
        public final Data build() {
            Data data = new Data((Map<String, ?>) this.values);
            Data.Companion.toByteArrayInternalV1(data);
            return data;
        }

        @OXOo.OOXIXo
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final Builder put(@OXOo.OOXIXo String key, @OXOo.oOoXoXO Object obj) {
            boolean Oxx0IOOO2;
            boolean Oxx0IOOO3;
            boolean Oxx0IOOO4;
            boolean Oxx0IOOO5;
            boolean Oxx0IOOO6;
            boolean Oxx0IOOO7;
            boolean Oxx0IOOO8;
            boolean Oxx0IOOO9;
            boolean Oxx0IOOO10;
            boolean Oxx0IOOO11;
            boolean Oxx0IOOO12;
            boolean Oxx0IOOO13;
            IIX0o.x0xO0oo(key, "key");
            Map<String, Object> map = this.values;
            if (obj == null) {
                obj = null;
            } else {
                kotlin.reflect.oxoX oxoX2 = IO.oxoX(obj.getClass());
                boolean z = true;
                if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Boolean.TYPE))) {
                    Oxx0IOOO2 = true;
                } else {
                    Oxx0IOOO2 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Byte.TYPE));
                }
                if (Oxx0IOOO2) {
                    Oxx0IOOO3 = true;
                } else {
                    Oxx0IOOO3 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Integer.TYPE));
                }
                if (Oxx0IOOO3) {
                    Oxx0IOOO4 = true;
                } else {
                    Oxx0IOOO4 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Long.TYPE));
                }
                if (Oxx0IOOO4) {
                    Oxx0IOOO5 = true;
                } else {
                    Oxx0IOOO5 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Float.TYPE));
                }
                if (Oxx0IOOO5) {
                    Oxx0IOOO6 = true;
                } else {
                    Oxx0IOOO6 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Double.TYPE));
                }
                if (Oxx0IOOO6) {
                    Oxx0IOOO7 = true;
                } else {
                    Oxx0IOOO7 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(String.class));
                }
                if (Oxx0IOOO7) {
                    Oxx0IOOO8 = true;
                } else {
                    Oxx0IOOO8 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Boolean[].class));
                }
                if (Oxx0IOOO8) {
                    Oxx0IOOO9 = true;
                } else {
                    Oxx0IOOO9 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Byte[].class));
                }
                if (Oxx0IOOO9) {
                    Oxx0IOOO10 = true;
                } else {
                    Oxx0IOOO10 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Integer[].class));
                }
                if (Oxx0IOOO10) {
                    Oxx0IOOO11 = true;
                } else {
                    Oxx0IOOO11 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Long[].class));
                }
                if (Oxx0IOOO11) {
                    Oxx0IOOO12 = true;
                } else {
                    Oxx0IOOO12 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Float[].class));
                }
                if (Oxx0IOOO12) {
                    Oxx0IOOO13 = true;
                } else {
                    Oxx0IOOO13 = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Double[].class));
                }
                if (!Oxx0IOOO13) {
                    z = IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(String[].class));
                }
                if (!z) {
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
                        throw new IllegalArgumentException("Key " + key + " has invalid type " + oxoX2);
                    }
                }
            }
            map.put(key, obj);
            return this;
        }

        @OXOo.OOXIXo
        public final Builder putAll(@OXOo.OOXIXo Data data) {
            IIX0o.x0xO0oo(data, "data");
            putAll(data.values);
            return this;
        }

        @OXOo.OOXIXo
        public final Builder putBoolean(@OXOo.OOXIXo String key, boolean z) {
            IIX0o.x0xO0oo(key, "key");
            return putDirect(key, Boolean.valueOf(z));
        }

        @OXOo.OOXIXo
        public final Builder putBooleanArray(@OXOo.OOXIXo String key, @OXOo.OOXIXo boolean[] value) {
            Boolean[] convertPrimitiveArray;
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(value, "value");
            Map<String, Object> map = this.values;
            convertPrimitiveArray = Data_Kt.convertPrimitiveArray(value);
            map.put(key, convertPrimitiveArray);
            return this;
        }

        @OXOo.OOXIXo
        public final Builder putByte(@OXOo.OOXIXo String key, byte b) {
            IIX0o.x0xO0oo(key, "key");
            return putDirect(key, Byte.valueOf(b));
        }

        @OXOo.OOXIXo
        public final Builder putByteArray(@OXOo.OOXIXo String key, @OXOo.OOXIXo byte[] value) {
            Byte[] convertPrimitiveArray;
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(value, "value");
            Map<String, Object> map = this.values;
            convertPrimitiveArray = Data_Kt.convertPrimitiveArray(value);
            map.put(key, convertPrimitiveArray);
            return this;
        }

        @OXOo.OOXIXo
        public final Builder putDouble(@OXOo.OOXIXo String key, double d) {
            IIX0o.x0xO0oo(key, "key");
            return putDirect(key, Double.valueOf(d));
        }

        @OXOo.OOXIXo
        public final Builder putDoubleArray(@OXOo.OOXIXo String key, @OXOo.OOXIXo double[] value) {
            Double[] convertPrimitiveArray;
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(value, "value");
            Map<String, Object> map = this.values;
            convertPrimitiveArray = Data_Kt.convertPrimitiveArray(value);
            map.put(key, convertPrimitiveArray);
            return this;
        }

        @OXOo.OOXIXo
        public final Builder putFloat(@OXOo.OOXIXo String key, float f) {
            IIX0o.x0xO0oo(key, "key");
            return putDirect(key, Float.valueOf(f));
        }

        @OXOo.OOXIXo
        public final Builder putFloatArray(@OXOo.OOXIXo String key, @OXOo.OOXIXo float[] value) {
            Float[] convertPrimitiveArray;
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(value, "value");
            Map<String, Object> map = this.values;
            convertPrimitiveArray = Data_Kt.convertPrimitiveArray(value);
            map.put(key, convertPrimitiveArray);
            return this;
        }

        @OXOo.OOXIXo
        public final Builder putInt(@OXOo.OOXIXo String key, int i) {
            IIX0o.x0xO0oo(key, "key");
            return putDirect(key, Integer.valueOf(i));
        }

        @OXOo.OOXIXo
        public final Builder putIntArray(@OXOo.OOXIXo String key, @OXOo.OOXIXo int[] value) {
            Integer[] convertPrimitiveArray;
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(value, "value");
            Map<String, Object> map = this.values;
            convertPrimitiveArray = Data_Kt.convertPrimitiveArray(value);
            map.put(key, convertPrimitiveArray);
            return this;
        }

        @OXOo.OOXIXo
        public final Builder putLong(@OXOo.OOXIXo String key, long j) {
            IIX0o.x0xO0oo(key, "key");
            return putDirect(key, Long.valueOf(j));
        }

        @OXOo.OOXIXo
        public final Builder putLongArray(@OXOo.OOXIXo String key, @OXOo.OOXIXo long[] value) {
            Long[] convertPrimitiveArray;
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(value, "value");
            Map<String, Object> map = this.values;
            convertPrimitiveArray = Data_Kt.convertPrimitiveArray(value);
            map.put(key, convertPrimitiveArray);
            return this;
        }

        @OXOo.OOXIXo
        public final Builder putString(@OXOo.OOXIXo String key, @OXOo.oOoXoXO String str) {
            IIX0o.x0xO0oo(key, "key");
            return putDirect(key, str);
        }

        @OXOo.OOXIXo
        public final Builder putStringArray(@OXOo.OOXIXo String key, @OXOo.OOXIXo String[] value) {
            IIX0o.x0xO0oo(key, "key");
            IIX0o.x0xO0oo(value, "value");
            return putDirect(key, value);
        }

        @OXOo.OOXIXo
        public final Builder putAll(@OXOo.OOXIXo Map<String, ? extends Object> values) {
            IIX0o.x0xO0oo(values, "values");
            for (Map.Entry<String, ? extends Object> entry : values.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    @XX({"SMAP\nData_.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Data_.kt\nandroidx/work/Data$Companion\n+ 2 LoggerExt.kt\nandroidx/work/LoggerExtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,841:1\n32#2:842\n32#2:843\n32#2:845\n32#2:846\n1#3:844\n*S KotlinDebug\n*F\n+ 1 Data_.kt\nandroidx/work/Data$Companion\n*L\n599#1:842\n710#1:843\n814#1:845\n816#1:846\n*E\n"})
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private static final boolean fromByteArray$isObjectStream(ByteArrayInputStream byteArrayInputStream) {
            byte[] bArr = new byte[2];
            byteArrayInputStream.read(bArr);
            byte b = (byte) (-21267);
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
                if (readShort2 == 1) {
                    return;
                }
                throw new IllegalStateException(("Unsupported version number: " + ((int) readShort2)).toString());
            }
            throw new IllegalStateException(("Magic number doesn't match: " + ((int) readShort)).toString());
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
            }
            if (b == 9) {
                int readInt2 = dataInputStream.readInt();
                Byte[] bArr = new Byte[readInt2];
                while (i < readInt2) {
                    bArr[i] = Byte.valueOf(dataInputStream.readByte());
                    i++;
                }
                return bArr;
            }
            if (b == 10) {
                int readInt3 = dataInputStream.readInt();
                Integer[] numArr = new Integer[readInt3];
                while (i < readInt3) {
                    numArr[i] = Integer.valueOf(dataInputStream.readInt());
                    i++;
                }
                return numArr;
            }
            if (b == 11) {
                int readInt4 = dataInputStream.readInt();
                Long[] lArr = new Long[readInt4];
                while (i < readInt4) {
                    lArr[i] = Long.valueOf(dataInputStream.readLong());
                    i++;
                }
                return lArr;
            }
            if (b == 12) {
                int readInt5 = dataInputStream.readInt();
                Float[] fArr = new Float[readInt5];
                while (i < readInt5) {
                    fArr[i] = Float.valueOf(dataInputStream.readFloat());
                    i++;
                }
                return fArr;
            }
            if (b == 13) {
                int readInt6 = dataInputStream.readInt();
                Double[] dArr = new Double[readInt6];
                while (i < readInt6) {
                    dArr[i] = Double.valueOf(dataInputStream.readDouble());
                    i++;
                }
                return dArr;
            }
            if (b == 14) {
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
            }
            throw new IllegalStateException("Unsupported type " + ((int) b));
        }

        private static final void toByteArrayInternalV1$writeArray(DataOutputStream dataOutputStream, Object[] objArr) {
            int i;
            double d;
            float f;
            long j;
            int i2;
            byte b;
            boolean z;
            kotlin.reflect.oxoX oxoX2 = IO.oxoX(objArr.getClass());
            if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Boolean[].class))) {
                i = 8;
            } else if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Byte[].class))) {
                i = 9;
            } else if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Integer[].class))) {
                i = 10;
            } else if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Long[].class))) {
                i = 11;
            } else if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Float[].class))) {
                i = 12;
            } else if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(Double[].class))) {
                i = 13;
            } else if (IIX0o.Oxx0IOOO(oxoX2, IO.oxoX(String[].class))) {
                i = 14;
            } else {
                throw new IllegalArgumentException("Unsupported value type " + IO.oxoX(objArr.getClass()).II0XooXoX());
            }
            dataOutputStream.writeByte(i);
            dataOutputStream.writeInt(objArr.length);
            for (Object obj : objArr) {
                String str = null;
                Boolean bool = null;
                Byte b2 = null;
                Integer num = null;
                Long l = null;
                Float f2 = null;
                Double d2 = null;
                if (i == 8) {
                    if (obj instanceof Boolean) {
                        bool = (Boolean) obj;
                    }
                    if (bool != null) {
                        z = bool.booleanValue();
                    } else {
                        z = false;
                    }
                    dataOutputStream.writeBoolean(z);
                } else if (i == 9) {
                    if (obj instanceof Byte) {
                        b2 = (Byte) obj;
                    }
                    if (b2 != null) {
                        b = b2.byteValue();
                    } else {
                        b = 0;
                    }
                    dataOutputStream.writeByte(b);
                } else if (i == 10) {
                    if (obj instanceof Integer) {
                        num = (Integer) obj;
                    }
                    if (num != null) {
                        i2 = num.intValue();
                    } else {
                        i2 = 0;
                    }
                    dataOutputStream.writeInt(i2);
                } else if (i == 11) {
                    if (obj instanceof Long) {
                        l = (Long) obj;
                    }
                    if (l != null) {
                        j = l.longValue();
                    } else {
                        j = 0;
                    }
                    dataOutputStream.writeLong(j);
                } else if (i == 12) {
                    if (obj instanceof Float) {
                        f2 = (Float) obj;
                    }
                    if (f2 != null) {
                        f = f2.floatValue();
                    } else {
                        f = 0.0f;
                    }
                    dataOutputStream.writeFloat(f);
                } else if (i == 13) {
                    if (obj instanceof Double) {
                        d2 = (Double) obj;
                    }
                    if (d2 != null) {
                        d = d2.doubleValue();
                    } else {
                        d = XIXIX.OOXIXo.f3760XO;
                    }
                    dataOutputStream.writeDouble(d);
                } else if (i == 14) {
                    if (obj instanceof String) {
                        str = (String) obj;
                    }
                    if (str == null) {
                        str = Data.NULL_STRING_V1;
                    }
                    dataOutputStream.writeUTF(str);
                }
            }
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

        @x0XOIxOo
        @OXOo.OOXIXo
        @TypeConverter
        public final Data fromByteArray(@OXOo.OOXIXo byte[] bytes) {
            String str;
            String str2;
            IIX0o.x0xO0oo(bytes, "bytes");
            if (bytes.length <= 10240) {
                if (bytes.length == 0) {
                    return Data.EMPTY;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
                    int i = 0;
                    if (fromByteArray$isObjectStream(byteArrayInputStream)) {
                        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                        try {
                            int readInt = objectInputStream.readInt();
                            while (i < readInt) {
                                String readUTF = objectInputStream.readUTF();
                                IIX0o.oO(readUTF, "readUTF()");
                                linkedHashMap.put(readUTF, objectInputStream.readObject());
                                i++;
                            }
                            kotlin.io.II0xO0.oIX0oI(objectInputStream, null);
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                kotlin.io.II0xO0.oIX0oI(objectInputStream, th);
                                throw th2;
                            }
                        }
                    } else {
                        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                        try {
                            fromByteArray$readHeader(dataInputStream);
                            int readInt2 = dataInputStream.readInt();
                            while (i < readInt2) {
                                Object fromByteArray$readValue = fromByteArray$readValue(dataInputStream, dataInputStream.readByte());
                                String key = dataInputStream.readUTF();
                                IIX0o.oO(key, "key");
                                linkedHashMap.put(key, fromByteArray$readValue);
                                i++;
                            }
                            kotlin.io.II0xO0.oIX0oI(dataInputStream, null);
                        } catch (Throwable th3) {
                            try {
                                throw th3;
                            } catch (Throwable th4) {
                                kotlin.io.II0xO0.oIX0oI(dataInputStream, th3);
                                throw th4;
                            }
                        }
                    }
                } catch (IOException e) {
                    str2 = Data_Kt.TAG;
                    Logger.get().error(str2, "Error in Data#fromByteArray: ", e);
                } catch (ClassNotFoundException e2) {
                    str = Data_Kt.TAG;
                    Logger.get().error(str, "Error in Data#fromByteArray: ", e2);
                }
                return new Data(linkedHashMap);
            }
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @kotlin.OOXIXo(message = "This is kept for testing migration", replaceWith = @kotlin.XX(expression = "toByteArrayInternalV1", imports = {}))
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final byte[] toByteArrayInternalV0(@OXOo.OOXIXo Data data) {
            String str;
            IIX0o.x0xO0oo(data, "data");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream.writeInt(data.size());
                        for (Map.Entry entry : data.values.entrySet()) {
                            String str2 = (String) entry.getKey();
                            Object value = entry.getValue();
                            objectOutputStream.writeUTF(str2);
                            objectOutputStream.writeObject(value);
                        }
                        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
                        kotlin.io.II0xO0.oIX0oI(objectOutputStream, null);
                        kotlin.io.II0xO0.oIX0oI(byteArrayOutputStream, null);
                        if (byteArrayOutputStream.size() <= 10240) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            IIX0o.oO(byteArray, "{\n                val st…ByteArray()\n            }");
                            return byteArray;
                        }
                        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        kotlin.io.II0xO0.oIX0oI(byteArrayOutputStream, th);
                        throw th2;
                    }
                }
            } catch (IOException e) {
                str = Data_Kt.TAG;
                Logger.get().error(str, "Error in Data#toByteArray: ", e);
                return new byte[0];
            }
        }

        @x0XOIxOo
        @OXOo.OOXIXo
        @TypeConverter
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final byte[] toByteArrayInternalV1(@OXOo.OOXIXo Data data) {
            String str;
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
                        kotlin.io.II0xO0.oIX0oI(dataOutputStream, null);
                        IIX0o.oO(byteArray, "{\n                ByteAr…          }\n            }");
                        return byteArray;
                    }
                    throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                } finally {
                }
            } catch (IOException e) {
                str = Data_Kt.TAG;
                Logger.get().error(str, "Error in Data#toByteArray: ", e);
                return new byte[0];
            }
        }

        private Companion() {
        }
    }

    public Data(@OXOo.OOXIXo Data other) {
        IIX0o.x0xO0oo(other, "other");
        this.values = new HashMap(other.values);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @TypeConverter
    public static final Data fromByteArray(@OXOo.OOXIXo byte[] bArr) {
        return Companion.fromByteArray(bArr);
    }

    private final /* synthetic */ <T> T getOrDefault(String str, T t) {
        T t2 = (T) this.values.get(str);
        IIX0o.OxI(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (t2 instanceof Object) {
            return t2;
        }
        return t;
    }

    private final /* synthetic */ <T, TArray> TArray getTypedArray(String str, x0xO0oo<? super Integer, ? super Oox.oOoXoXO<? super Integer, ? extends T>, ? extends TArray> x0xo0oo) {
        final Object obj = this.values.get(str);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                Integer valueOf = Integer.valueOf(objArr.length);
                IIX0o.xoXoI();
                return x0xo0oo.invoke(valueOf, new Oox.oOoXoXO<Integer, T>() { // from class: androidx.work.Data$getTypedArray$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final T invoke(int i) {
                        T t = (T) ((Object[]) obj)[i];
                        IIX0o.OxI(1, ExifInterface.GPS_DIRECTION_TRUE);
                        return t;
                    }

                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                });
            }
        }
        return null;
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @kotlin.OOXIXo(message = "This is kept for testing migration", replaceWith = @kotlin.XX(expression = "toByteArrayInternalV1", imports = {}))
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final byte[] toByteArrayInternalV0(@OXOo.OOXIXo Data data) {
        return Companion.toByteArrayInternalV0(data);
    }

    @x0XOIxOo
    @OXOo.OOXIXo
    @TypeConverter
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final byte[] toByteArrayInternalV1(@OXOo.OOXIXo Data data) {
        return Companion.toByteArrayInternalV1(data);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || !IIX0o.Oxx0IOOO(Data.class, obj.getClass())) {
            return false;
        }
        Data data = (Data) obj;
        Set<String> keySet = this.values.keySet();
        if (!IIX0o.Oxx0IOOO(keySet, data.values.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj2 = this.values.get(str);
            Object obj3 = data.values.get(str);
            if (obj2 != null && obj3 != null) {
                if (obj2 instanceof Object[]) {
                    Object[] objArr = (Object[]) obj2;
                    if (obj3 instanceof Object[]) {
                        z = kotlin.collections.oOoXoXO.Oxx0IOOO(objArr, (Object[]) obj3);
                    }
                }
                z = IIX0o.Oxx0IOOO(obj2, obj3);
            } else if (obj2 == obj3) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final boolean getBoolean(@OXOo.OOXIXo String key, boolean z) {
        IIX0o.x0xO0oo(key, "key");
        Object valueOf = Boolean.valueOf(z);
        Object obj = this.values.get(key);
        if (obj instanceof Boolean) {
            valueOf = obj;
        }
        return ((Boolean) valueOf).booleanValue();
    }

    @OXOo.oOoXoXO
    public final boolean[] getBooleanArray(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        final Object obj = this.values.get(key);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Oox.oOoXoXO<Integer, Boolean> oooxoxo = new Oox.oOoXoXO<Integer, Boolean>() { // from class: androidx.work.Data$getBooleanArray$$inlined$getTypedArray$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Boolean invoke(int i) {
                        Object obj2 = ((Object[]) obj)[i];
                        if (obj2 != null) {
                            return (Boolean) obj2;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Boolean, java.lang.Object] */
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
                boolean[] zArr = new boolean[length];
                for (int i = 0; i < length; i++) {
                    zArr[i] = oooxoxo.invoke(Integer.valueOf(i)).booleanValue();
                }
                return zArr;
            }
        }
        return null;
    }

    public final byte getByte(@OXOo.OOXIXo String key, byte b) {
        IIX0o.x0xO0oo(key, "key");
        Object valueOf = Byte.valueOf(b);
        Object obj = this.values.get(key);
        if (obj instanceof Byte) {
            valueOf = obj;
        }
        return ((Number) valueOf).byteValue();
    }

    @OXOo.oOoXoXO
    public final byte[] getByteArray(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        final Object obj = this.values.get(key);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Oox.oOoXoXO<Integer, Byte> oooxoxo = new Oox.oOoXoXO<Integer, Byte>() { // from class: androidx.work.Data$getByteArray$$inlined$getTypedArray$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Byte invoke(int i) {
                        Object obj2 = ((Object[]) obj)[i];
                        if (obj2 != null) {
                            return (Byte) obj2;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Byte");
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.lang.Byte] */
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Byte invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr[i] = oooxoxo.invoke(Integer.valueOf(i)).byteValue();
                }
                return bArr;
            }
        }
        return null;
    }

    public final double getDouble(@OXOo.OOXIXo String key, double d) {
        IIX0o.x0xO0oo(key, "key");
        Object valueOf = Double.valueOf(d);
        Object obj = this.values.get(key);
        if (obj instanceof Double) {
            valueOf = obj;
        }
        return ((Number) valueOf).doubleValue();
    }

    @OXOo.oOoXoXO
    public final double[] getDoubleArray(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        final Object obj = this.values.get(key);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Oox.oOoXoXO<Integer, Double> oooxoxo = new Oox.oOoXoXO<Integer, Double>() { // from class: androidx.work.Data$getDoubleArray$$inlined$getTypedArray$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Double invoke(int i) {
                        Object obj2 = ((Object[]) obj)[i];
                        if (obj2 != null) {
                            return (Double) obj2;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Double, java.lang.Object] */
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Double invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
                double[] dArr = new double[length];
                for (int i = 0; i < length; i++) {
                    dArr[i] = oooxoxo.invoke(Integer.valueOf(i)).doubleValue();
                }
                return dArr;
            }
        }
        return null;
    }

    public final float getFloat(@OXOo.OOXIXo String key, float f) {
        IIX0o.x0xO0oo(key, "key");
        Object valueOf = Float.valueOf(f);
        Object obj = this.values.get(key);
        if (obj instanceof Float) {
            valueOf = obj;
        }
        return ((Number) valueOf).floatValue();
    }

    @OXOo.oOoXoXO
    public final float[] getFloatArray(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        final Object obj = this.values.get(key);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Oox.oOoXoXO<Integer, Float> oooxoxo = new Oox.oOoXoXO<Integer, Float>() { // from class: androidx.work.Data$getFloatArray$$inlined$getTypedArray$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Float invoke(int i) {
                        Object obj2 = ((Object[]) obj)[i];
                        if (obj2 != null) {
                            return (Float) obj2;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Float, java.lang.Object] */
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
                float[] fArr = new float[length];
                for (int i = 0; i < length; i++) {
                    fArr[i] = oooxoxo.invoke(Integer.valueOf(i)).floatValue();
                }
                return fArr;
            }
        }
        return null;
    }

    public final int getInt(@OXOo.OOXIXo String key, int i) {
        IIX0o.x0xO0oo(key, "key");
        Object valueOf = Integer.valueOf(i);
        Object obj = this.values.get(key);
        if (obj instanceof Integer) {
            valueOf = obj;
        }
        return ((Number) valueOf).intValue();
    }

    @OXOo.oOoXoXO
    public final int[] getIntArray(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        final Object obj = this.values.get(key);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Oox.oOoXoXO<Integer, Integer> oooxoxo = new Oox.oOoXoXO<Integer, Integer>() { // from class: androidx.work.Data$getIntArray$$inlined$getTypedArray$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Integer invoke(int i) {
                        Object obj2 = ((Object[]) obj)[i];
                        if (obj2 != null) {
                            return (Integer) obj2;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.lang.Integer] */
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
                int[] iArr = new int[length];
                for (int i = 0; i < length; i++) {
                    iArr[i] = oooxoxo.invoke(Integer.valueOf(i)).intValue();
                }
                return iArr;
            }
        }
        return null;
    }

    @OXOo.OOXIXo
    public final Map<String, Object> getKeyValueMap() {
        Map<String, Object> unmodifiableMap = Collections.unmodifiableMap(this.values);
        IIX0o.oO(unmodifiableMap, "unmodifiableMap(values)");
        return unmodifiableMap;
    }

    public final long getLong(@OXOo.OOXIXo String key, long j) {
        IIX0o.x0xO0oo(key, "key");
        Object valueOf = Long.valueOf(j);
        Object obj = this.values.get(key);
        if (obj instanceof Long) {
            valueOf = obj;
        }
        return ((Number) valueOf).longValue();
    }

    @OXOo.oOoXoXO
    public final long[] getLongArray(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        final Object obj = this.values.get(key);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Oox.oOoXoXO<Integer, Long> oooxoxo = new Oox.oOoXoXO<Integer, Long>() { // from class: androidx.work.Data$getLongArray$$inlined$getTypedArray$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Long invoke(int i) {
                        Object obj2 = ((Object[]) obj)[i];
                        if (obj2 != null) {
                            return (Long) obj2;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Long, java.lang.Object] */
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ Long invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
                long[] jArr = new long[length];
                for (int i = 0; i < length; i++) {
                    jArr[i] = oooxoxo.invoke(Integer.valueOf(i)).longValue();
                }
                return jArr;
            }
        }
        return null;
    }

    @OXOo.oOoXoXO
    public final String getString(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        Object obj = this.values.get(key);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    @OXOo.oOoXoXO
    public final String[] getStringArray(@OXOo.OOXIXo String key) {
        IIX0o.x0xO0oo(key, "key");
        final Object obj = this.values.get(key);
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Object[]) {
                int length = objArr.length;
                Oox.oOoXoXO<Integer, String> oooxoxo = new Oox.oOoXoXO<Integer, String>() { // from class: androidx.work.Data$getStringArray$$inlined$getTypedArray$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final String invoke(int i) {
                        Object obj2 = ((Object[]) obj)[i];
                        if (obj2 != null) {
                            return (String) obj2;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }

                    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.lang.String] */
                    @Override // Oox.oOoXoXO
                    public /* bridge */ /* synthetic */ String invoke(Integer num) {
                        return invoke(num.intValue());
                    }
                };
                String[] strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = oooxoxo.invoke(Integer.valueOf(i));
                }
                return strArr;
            }
        }
        return null;
    }

    public final /* synthetic */ <T> boolean hasKey$work_runtime_release(String key) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return hasKeyWithValueOfType(key, Object.class);
    }

    public final <T> boolean hasKeyWithValueOfType(@OXOo.OOXIXo String key, @OXOo.OOXIXo Class<T> klass) {
        IIX0o.x0xO0oo(key, "key");
        IIX0o.x0xO0oo(klass, "klass");
        Object obj = this.values.get(key);
        if (obj != null && klass.isAssignableFrom(obj.getClass())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        for (Map.Entry<String, Object> entry : this.values.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Object[]) {
                hashCode = Objects.hashCode(entry.getKey()) ^ kotlin.collections.OOXIXo.II0xO0((Object[]) value);
            } else {
                hashCode = entry.hashCode();
            }
            i += hashCode;
        }
        return i * 31;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public final int size() {
        return this.values.size();
    }

    @OXOo.OOXIXo
    public final byte[] toByteArray() {
        return Companion.toByteArrayInternalV1(this);
    }

    @OXOo.OOXIXo
    public String toString() {
        String str = "Data {" + CollectionsKt___CollectionsKt.OoIXo(this.values.entrySet(), null, null, null, 0, null, new Oox.oOoXoXO<Map.Entry<? extends String, ? extends Object>, CharSequence>() { // from class: androidx.work.Data$toString$1$content$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Map.Entry<String, ? extends Object> entry) {
                IIX0o.x0xO0oo(entry, "<name for destructuring parameter 0>");
                String key = entry.getKey();
                Object value = entry.getValue();
                StringBuilder sb = new StringBuilder();
                sb.append(key);
                sb.append(" : ");
                if (value instanceof Object[]) {
                    value = Arrays.toString((Object[]) value);
                    IIX0o.oO(value, "toString(this)");
                }
                sb.append(value);
                return sb.toString();
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
                return invoke2((Map.Entry<String, ? extends Object>) entry);
            }
        }, 31, null) + ooOOo0oXI.f33074oOoXoXO;
        IIX0o.oO(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }

    public Data(@OXOo.OOXIXo Map<String, ?> values) {
        IIX0o.x0xO0oo(values, "values");
        this.values = new HashMap(values);
    }
}
