package com.bytedance.sdk.openadsdk.mediation.bridge;

import XIXIX.OOXIXo;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes8.dex */
public class MediationValueSetBuilder {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<Object> f10855a;

    /* loaded from: classes8.dex */
    public interface BooleanGetter extends ValueSet.ValueGetter<Boolean> {
    }

    /* loaded from: classes8.dex */
    public interface DoubleGetter extends ValueSet.ValueGetter<Double> {
    }

    /* loaded from: classes8.dex */
    public interface FloatGetter extends ValueSet.ValueGetter<Float> {
    }

    /* loaded from: classes8.dex */
    public interface IntGetter extends ValueSet.ValueGetter<Integer> {
    }

    /* loaded from: classes8.dex */
    public interface LongGetter extends ValueSet.ValueGetter<Long> {
    }

    /* loaded from: classes8.dex */
    public interface ObjectGetter extends ValueSet.ValueGetter<Object> {
    }

    /* loaded from: classes8.dex */
    public interface StringGetter extends ValueSet.ValueGetter<String> {
    }

    /* loaded from: classes8.dex */
    public static final class ValueSetImpl implements ValueSet {

        /* renamed from: a, reason: collision with root package name */
        private final SparseArray<Object> f10856a;

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.f10856a.get(i);
            if (obj == null) {
                return null;
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
            if (this.f10856a.indexOfKey(i) >= 0) {
                return true;
            }
            return false;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            Object obj = this.f10856a.get(i);
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
            int size = this.f10856a.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(i));
            }
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Object obj = this.f10856a.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (cls.isInstance(obj)) {
                return (T) this.f10856a.get(i);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            SparseArray<Object> sparseArray = this.f10856a;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.size();
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        private ValueSetImpl(SparseArray<Object> sparseArray) {
            this.f10856a = sparseArray;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            Object obj = this.f10856a.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            Object obj = this.f10856a.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            Object obj = this.f10856a.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            Object obj = this.f10856a.get(i);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            Object obj = this.f10856a.get(i);
            return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
        }
    }

    private MediationValueSetBuilder(SparseArray<Object> sparseArray) {
        this.f10855a = sparseArray;
    }

    public static final MediationValueSetBuilder create() {
        return new MediationValueSetBuilder(new SparseArray());
    }

    public MediationValueSetBuilder add(int i, Object obj) {
        this.f10855a.put(i, obj);
        return this;
    }

    public <T> MediationValueSetBuilder addArray(int i, T[] tArr) {
        this.f10855a.put(i, tArr);
        return this;
    }

    public ValueSet build() {
        return new ValueSetImpl(this.f10855a);
    }

    public static final MediationValueSetBuilder create(ValueSet valueSet) {
        if (valueSet != null && !valueSet.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            for (Integer num : valueSet.keys()) {
                sparseArray.put(num.intValue(), valueSet.objectValue(num.intValue(), Object.class));
            }
            return new MediationValueSetBuilder(sparseArray);
        }
        return new MediationValueSetBuilder(new SparseArray());
    }

    public MediationValueSetBuilder add(int i, String str) {
        this.f10855a.put(i, str);
        return this;
    }

    public MediationValueSetBuilder add(int i, int i2) {
        this.f10855a.put(i, Integer.valueOf(i2));
        return this;
    }

    public MediationValueSetBuilder add(int i, double d) {
        this.f10855a.put(i, Double.valueOf(d));
        return this;
    }

    public MediationValueSetBuilder add(int i, boolean z) {
        this.f10855a.put(i, Boolean.valueOf(z));
        return this;
    }

    public MediationValueSetBuilder add(int i, long j) {
        this.f10855a.put(i, Long.valueOf(j));
        return this;
    }

    public MediationValueSetBuilder add(int i, float f) {
        this.f10855a.put(i, Float.valueOf(f));
        return this;
    }

    public MediationValueSetBuilder add(int i, ObjectGetter objectGetter) {
        this.f10855a.put(i, objectGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, StringGetter stringGetter) {
        this.f10855a.put(i, stringGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, DoubleGetter doubleGetter) {
        this.f10855a.put(i, doubleGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, IntGetter intGetter) {
        this.f10855a.put(i, intGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, BooleanGetter booleanGetter) {
        this.f10855a.put(i, booleanGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, LongGetter longGetter) {
        this.f10855a.put(i, longGetter);
        return this;
    }

    public MediationValueSetBuilder add(int i, FloatGetter floatGetter) {
        this.f10855a.put(i, floatGetter);
        return this;
    }
}
