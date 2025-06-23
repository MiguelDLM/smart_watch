package xXo;

import com.univocity.parsers.conversions.EnumSelector;
import java.lang.Enum;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes13.dex */
public class OOXIXo<T extends Enum<T>> extends OxxIIOOXO<T> {

    /* renamed from: I0Io, reason: collision with root package name */
    public final Class<T> f34685I0Io;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final Map<String, T>[] f34686Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final Method f34687X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final EnumSelector[] f34688XO;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Field f34689oxoX;

    /* loaded from: classes13.dex */
    public static /* synthetic */ class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f34690oIX0oI;

        static {
            int[] iArr = new int[EnumSelector.values().length];
            f34690oIX0oI = iArr;
            try {
                iArr[EnumSelector.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34690oIX0oI[EnumSelector.ORDINAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34690oIX0oI[EnumSelector.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34690oIX0oI[EnumSelector.CUSTOM_FIELD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34690oIX0oI[EnumSelector.CUSTOM_METHOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public OOXIXo(Class<T> cls) {
        this(cls, EnumSelector.NAME, EnumSelector.ORDINAL, EnumSelector.STRING);
    }

    @Override // xXo.OxxIIOOXO
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public T X0o0xo(String str) {
        for (Map<String, T> map : this.f34686Oxx0IOOO) {
            T t = map.get(str);
            if (t != null) {
                return t;
            }
        }
        throw new IllegalArgumentException("Cannot convert '" + str + "' to enumeration of type " + this.f34685I0Io.getName());
    }

    public final String oOoXoXO(T t, EnumSelector enumSelector) {
        int i = oIX0oI.f34690oIX0oI[enumSelector.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i == 5) {
                            try {
                                return String.valueOf(this.f34687X0o0xo.invoke(t, null));
                            } catch (Throwable th) {
                                throw new IllegalStateException("Error reading custom method '" + this.f34687X0o0xo.getName() + "' from enumeration constant '" + t + "' of type " + this.f34685I0Io.getName(), th);
                            }
                        }
                        throw new IllegalStateException("Unsupported enumeration selector type " + enumSelector);
                    }
                    try {
                        return String.valueOf(this.f34689oxoX.get(t));
                    } catch (Throwable th2) {
                        throw new IllegalStateException("Error reading custom field '" + this.f34689oxoX.getName() + "' from enumeration constant '" + t + "' of type " + this.f34685I0Io.getName(), th2);
                    }
                }
                return t.toString();
            }
            return String.valueOf(t.ordinal());
        }
        return t.name();
    }

    public final void ooOOo0oXI(Set<EnumSelector> set) {
        T[] enumConstants = this.f34685I0Io.getEnumConstants();
        int i = 0;
        for (EnumSelector enumSelector : set) {
            Map<String, T> hashMap = new HashMap<>(enumConstants.length);
            int i2 = i + 1;
            this.f34686Oxx0IOOO[i] = hashMap;
            for (T t : enumConstants) {
                String oOoXoXO2 = oOoXoXO(t, enumSelector);
                if (!hashMap.containsKey(oOoXoXO2)) {
                    hashMap.put(oOoXoXO2, t);
                } else {
                    throw new IllegalArgumentException("Enumeration element type " + enumSelector + " does not uniquely identify elements of " + this.f34685I0Io.getName() + ". Got duplicate value '" + oOoXoXO2 + "' from constants '" + t + "' and '" + hashMap.get(oOoXoXO2) + "'.");
                }
            }
            i = i2;
        }
    }

    @Override // xXo.OxxIIOOXO, xXo.Oxx0IOOO
    /* renamed from: x0XOIxOo, reason: merged with bridge method [inline-methods] */
    public String oIX0oI(T t) {
        if (t == null) {
            return super.oIX0oI(null);
        }
        return oOoXoXO(t, this.f34688XO[0]);
    }

    public OOXIXo(Class<T> cls, EnumSelector... enumSelectorArr) {
        this(cls, null, null, null, enumSelectorArr);
    }

    public OOXIXo(Class<T> cls, String str, EnumSelector... enumSelectorArr) {
        this(cls, null, null, str, new EnumSelector[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ff A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public OOXIXo(java.lang.Class<T> r8, T r9, java.lang.String r10, java.lang.String r11, com.univocity.parsers.conversions.EnumSelector... r12) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xXo.OOXIXo.<init>(java.lang.Class, java.lang.Enum, java.lang.String, java.lang.String, com.univocity.parsers.conversions.EnumSelector[]):void");
    }
}
