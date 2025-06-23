package o0;

import XIXIX.OOXIXo;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes8.dex */
public class xXxxox0I {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final ValueSet f31020I0Io = II0xO0(0).OOXIXo();

    /* renamed from: oxoX, reason: collision with root package name */
    public static final Bridge f31021oxoX = new II0xO0();

    /* renamed from: II0xO0, reason: collision with root package name */
    public ValueSet f31022II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final SparseArray<Object> f31023oIX0oI;

    /* loaded from: classes8.dex */
    public static final class I0Io implements ValueSet {

        /* renamed from: I0Io, reason: collision with root package name */
        public int f31024I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public ValueSet f31025II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final SparseArray<Object> f31026oIX0oI;

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.f31026oIX0oI.get(i);
            if (obj == null) {
                ValueSet valueSet = this.f31025II0xO0;
                if (valueSet == null) {
                    return null;
                }
                return (T[]) valueSet.arrayValue(i, cls);
            }
            Class<?> cls2 = obj.getClass();
            if (!cls2.isArray() || !cls.isAssignableFrom(cls2.getComponentType())) {
                return null;
            }
            return (T[]) ((Object[]) obj);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i) {
            ValueSet valueSet;
            int indexOfKey = this.f31026oIX0oI.indexOfKey(i);
            if (indexOfKey < 0 && (valueSet = this.f31025II0xO0) != null) {
                return valueSet.containsKey(i);
            }
            if (indexOfKey >= 0) {
                return true;
            }
            return false;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            ValueSet valueSet;
            Object obj = this.f31026oIX0oI.get(i);
            if (obj == null && (valueSet = this.f31025II0xO0) != null) {
                return valueSet.doubleValue(i);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return OOXIXo.f3760XO;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            if (size() <= 0) {
                return true;
            }
            return false;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.f31026oIX0oI.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.f31026oIX0oI.keyAt(i)));
            }
            ValueSet valueSet = this.f31025II0xO0;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.f31024I0Io = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Object obj = this.f31026oIX0oI.get(i);
            if (obj == null) {
                ValueSet valueSet = this.f31025II0xO0;
                if (valueSet == null) {
                    return null;
                }
                return (T) valueSet.objectValue(i, cls);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (!cls.isInstance(obj)) {
                return null;
            }
            return (T) obj;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.f31024I0Io < 0) {
                keys();
            }
            return this.f31024I0Io;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        public I0Io(SparseArray<Object> sparseArray, ValueSet valueSet) {
            this.f31024I0Io = -1;
            this.f31026oIX0oI = sparseArray;
            this.f31025II0xO0 = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            ValueSet valueSet;
            Object obj = this.f31026oIX0oI.get(i);
            if (obj == null && (valueSet = this.f31025II0xO0) != null) {
                return valueSet.booleanValue(i, z);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            ValueSet valueSet;
            Object obj = this.f31026oIX0oI.get(i);
            if (obj == null && (valueSet = this.f31025II0xO0) != null) {
                return valueSet.floatValue(i, f);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            ValueSet valueSet;
            Object obj = this.f31026oIX0oI.get(i);
            if (obj == null && (valueSet = this.f31025II0xO0) != null) {
                return valueSet.intValue(i, i2);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            ValueSet valueSet;
            Object obj = this.f31026oIX0oI.get(i);
            if (obj == null && (valueSet = this.f31025II0xO0) != null) {
                return valueSet.longValue(i, j);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            ValueSet valueSet;
            Object obj = this.f31026oIX0oI.get(i);
            if (obj != null || (valueSet = this.f31025II0xO0) == null) {
                return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
            }
            return valueSet.stringValue(i, str);
        }
    }

    /* loaded from: classes8.dex */
    public static final class II0xO0 implements Bridge {
        public II0xO0() {
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (cls == Boolean.class) {
                return (T) Boolean.FALSE;
            }
            if (cls != Integer.TYPE && cls != Integer.class) {
                if (cls != Long.TYPE && cls != Long.class) {
                    if (cls != Double.TYPE && cls != Double.class) {
                        if (cls != Float.TYPE && cls != Float.class) {
                            return null;
                        }
                        return (T) new Float(0.0f);
                    }
                    return (T) new Double(OOXIXo.f3760XO);
                }
                return (T) new Long(0L);
            }
            return (T) new Integer(0);
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return xXxxox0I.f31020I0Io;
        }
    }

    public xXxxox0I(SparseArray<Object> sparseArray, ValueSet valueSet) {
        this.f31023oIX0oI = sparseArray;
        this.f31022II0xO0 = valueSet;
    }

    public static final xXxxox0I II0xO0(int i) {
        return new xXxxox0I(new SparseArray(i));
    }

    public static final xXxxox0I oIX0oI() {
        return new xXxxox0I(new SparseArray());
    }

    public static final xXxxox0I xoIox(ValueSet valueSet) {
        return new xXxxox0I(new SparseArray(), valueSet);
    }

    public xXxxox0I I0Io(int i, double d) {
        this.f31023oIX0oI.put(i, Double.valueOf(d));
        return this;
    }

    public xXxxox0I II0XooXoX(int i, String str) {
        this.f31023oIX0oI.put(i, str);
        return this;
    }

    public ValueSet OOXIXo() {
        return new I0Io(this.f31023oIX0oI, this.f31022II0xO0);
    }

    public xXxxox0I Oxx0IOOO(int i, Object obj) {
        this.f31023oIX0oI.put(i, obj);
        return this;
    }

    public xXxxox0I X0o0xo(int i, int i2) {
        this.f31023oIX0oI.put(i, Integer.valueOf(i2));
        return this;
    }

    public xXxxox0I XO(int i, long j) {
        this.f31023oIX0oI.put(i, Long.valueOf(j));
        return this;
    }

    public xXxxox0I oxoX(int i, float f) {
        this.f31023oIX0oI.put(i, Float.valueOf(f));
        return this;
    }

    public xXxxox0I xxIXOIIO(int i, boolean z) {
        this.f31023oIX0oI.put(i, Boolean.valueOf(z));
        return this;
    }

    public xXxxox0I(SparseArray<Object> sparseArray) {
        this.f31023oIX0oI = sparseArray;
    }
}
