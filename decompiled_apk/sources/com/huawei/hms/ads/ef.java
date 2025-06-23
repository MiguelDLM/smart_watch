package com.huawei.hms.ads;

import XIXIX.OOXIXo;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes10.dex */
public class ef {
    private static final String Code = "SafeBundle";
    private static final String V = "";
    private final Bundle I;

    public ef() {
        this(new Bundle());
    }

    public ArrayList<String> A(String str) {
        try {
            return this.I.getStringArrayList(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getStringArrayList exception ex.");
            return new ArrayList<>();
        }
    }

    public Set<String> B() {
        try {
            return this.I.keySet();
        } catch (Throwable unused) {
            fb.Z(Code, "keySet exception.");
            return null;
        }
    }

    public byte[] C(String str) {
        try {
            byte[] byteArray = this.I.getByteArray(str);
            return byteArray == null ? new byte[0] : byteArray;
        } catch (Throwable unused) {
            fb.Z(Code, "getByteArray exception ex.");
            return new byte[0];
        }
    }

    public byte Code(String str, byte b) {
        try {
            return this.I.getByte(str, b).byteValue();
        } catch (Throwable unused) {
            fb.Z(Code, "getByte exception ex.");
            return b;
        }
    }

    public char[] D(String str) {
        try {
            char[] charArray = this.I.getCharArray(str);
            return charArray == null ? new char[0] : charArray;
        } catch (Throwable unused) {
            fb.Z(Code, "getCharArray exception ex.");
            return new char[0];
        }
    }

    public ArrayList<String> E(String str) {
        try {
            ArrayList<String> stringArrayList = this.I.getStringArrayList(str);
            return stringArrayList == null ? new ArrayList<>() : stringArrayList;
        } catch (Throwable unused) {
            fb.Z(Code, "getStringArrayList exception ex.");
            return new ArrayList<>();
        }
    }

    public char[] F(String str) {
        try {
            return this.I.getCharArray(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getCharArray exception ex.");
            return new char[0];
        }
    }

    public Size G(String str) {
        try {
            return this.I.getSize(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getSize exception ex.");
            return null;
        }
    }

    public SizeF H(String str) {
        try {
            return this.I.getSizeF(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getSizeF exception ex.");
            return null;
        }
    }

    public ef I(String str, CharSequence charSequence) {
        try {
            this.I.putCharSequence(str, charSequence);
        } catch (Throwable unused) {
            fb.Z(Code, "putCharSequence exception ex.");
        }
        return this;
    }

    public <T extends Parcelable> T J(String str) {
        try {
            return (T) this.I.getParcelable(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getParcelable exception ex.");
            return null;
        }
    }

    public Parcelable[] K(String str) {
        try {
            return this.I.getParcelableArray(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getParcelableArray exception ex.");
            return new Parcelable[0];
        }
    }

    public short L(String str) {
        try {
            return this.I.getShort(str);
        } catch (Throwable unused) {
            return (short) 0;
        }
    }

    public Parcelable[] M(String str) {
        try {
            Parcelable[] parcelableArray = this.I.getParcelableArray(str);
            return parcelableArray == null ? new Parcelable[0] : parcelableArray;
        } catch (Throwable unused) {
            fb.Z(Code, "getParcelableArray exception ex.");
            return new Parcelable[0];
        }
    }

    public <T extends Parcelable> ArrayList<T> N(String str) {
        try {
            return this.I.getParcelableArrayList(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getParcelableArrayList exception ex.");
            return null;
        }
    }

    public <T extends Parcelable> SparseArray<T> O(String str) {
        try {
            return this.I.getSparseParcelableArray(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getSparseParcelableArray exception ex.");
            return null;
        }
    }

    public Serializable P(String str) {
        try {
            return this.I.getSerializable(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getSerializable exception ex.");
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public IBinder Q(String str) {
        try {
            return this.I.getBinder(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getBinder exception ex.");
            return null;
        }
    }

    public Bundle R(String str) {
        try {
            return this.I.getBundle(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getBundle exception ex.");
            return null;
        }
    }

    public char S(String str) {
        try {
            return this.I.getChar(str);
        } catch (Throwable unused) {
            return (char) 0;
        }
    }

    public Bundle T(String str) {
        try {
            Bundle bundle = this.I.getBundle(str);
            return bundle == null ? new Bundle() : bundle;
        } catch (Throwable unused) {
            fb.Z(Code, "getBundle exception ex.");
            return new Bundle();
        }
    }

    public Object U(String str) {
        try {
            return this.I.get(str);
        } catch (Throwable unused) {
            fb.Z(Code, "get exception ex.");
            return null;
        }
    }

    public int V() {
        try {
            return this.I.size();
        } catch (Throwable unused) {
            fb.Z(Code, "size exception");
            return 0;
        }
    }

    public Object W(String str) {
        try {
            Object obj = this.I.get(str);
            return obj == null ? new Object() : obj;
        } catch (Throwable unused) {
            fb.Z(Code, "get exception ex.");
            return new Object();
        }
    }

    public boolean X(String str) {
        try {
            return this.I.containsKey(str);
        } catch (Throwable unused) {
            fb.Z(Code, "containsKey exception. key:");
            return false;
        }
    }

    public void Y(String str) {
        try {
            this.I.remove(str);
        } catch (Throwable unused) {
            fb.Z(Code, "remove exception. key:");
        }
    }

    public byte Z(String str) {
        try {
            return this.I.getByte(str);
        } catch (Throwable unused) {
            return (byte) 0;
        }
    }

    public short[] a(String str) {
        try {
            return this.I.getShortArray(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getShortArray exception ex.");
            return new short[0];
        }
    }

    public short[] b(String str) {
        try {
            short[] shortArray = this.I.getShortArray(str);
            return shortArray == null ? new short[0] : shortArray;
        } catch (Throwable unused) {
            fb.Z(Code, "getShortArray exception ex.");
            return new short[0];
        }
    }

    public CharSequence c(String str) {
        try {
            return this.I.getCharSequence(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public CharSequence d(String str) {
        CharSequence charSequence;
        try {
            charSequence = this.I.getCharSequence(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getCharSequenceReturnNotNull exception ex.");
            charSequence = "";
        }
        return TextUtils.isEmpty(charSequence) ? "" : charSequence;
    }

    public CharSequence[] e(String str) {
        try {
            return this.I.getCharSequenceArray(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getCharSequenceArray exception ex.");
            return new CharSequence[0];
        }
    }

    public CharSequence[] f(String str) {
        try {
            CharSequence[] charSequenceArray = this.I.getCharSequenceArray(str);
            return charSequenceArray == null ? new CharSequence[0] : charSequenceArray;
        } catch (Throwable unused) {
            fb.Z(Code, "getCharSequenceArrayReturnNotNull exception ex.");
            return new CharSequence[0];
        }
    }

    public ArrayList<CharSequence> g(String str) {
        try {
            return this.I.getCharSequenceArrayList(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getCharSequenceArrayList exception ex.");
            return new ArrayList<>();
        }
    }

    public ArrayList<CharSequence> h(String str) {
        try {
            ArrayList<CharSequence> charSequenceArrayList = this.I.getCharSequenceArrayList(str);
            return charSequenceArrayList == null ? new ArrayList<>() : charSequenceArrayList;
        } catch (Throwable unused) {
            fb.Z(Code, "getCharSequenceArrayList exception ex.");
            return new ArrayList<>();
        }
    }

    public int i(String str) {
        return Code(str, 0);
    }

    public int[] j(String str) {
        try {
            return this.I.getIntArray(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getIntArray exception ex.");
            return new int[0];
        }
    }

    public int[] k(String str) {
        try {
            int[] intArray = this.I.getIntArray(str);
            return intArray == null ? new int[0] : intArray;
        } catch (Throwable unused) {
            fb.Z(Code, "getIntArray exception ex.");
            return new int[0];
        }
    }

    public ArrayList<Integer> l(String str) {
        try {
            return this.I.getIntegerArrayList(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getIntegerArrayList exception ex.");
            return new ArrayList<>();
        }
    }

    public ArrayList<Integer> m(String str) {
        try {
            ArrayList<Integer> integerArrayList = this.I.getIntegerArrayList(str);
            return integerArrayList == null ? new ArrayList<>() : integerArrayList;
        } catch (Throwable unused) {
            fb.Z(Code, "getIntegerArrayList exception ex.");
            return new ArrayList<>();
        }
    }

    public float n(String str) {
        return Code(str, 0.0f);
    }

    public float[] o(String str) {
        try {
            return this.I.getFloatArray(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getFloatArray exception ex.");
            return new float[0];
        }
    }

    public float[] p(String str) {
        try {
            float[] floatArray = this.I.getFloatArray(str);
            return floatArray == null ? new float[0] : floatArray;
        } catch (Throwable unused) {
            fb.Z(Code, "getFloatArray exception ex.");
            return new float[0];
        }
    }

    public long q(String str) {
        return Code(str, 0L);
    }

    public long[] r(String str) {
        try {
            return this.I.getLongArray(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getLongArray exception ex.");
            return new long[0];
        }
    }

    public long[] s(String str) {
        try {
            long[] longArray = this.I.getLongArray(str);
            return longArray == null ? new long[0] : longArray;
        } catch (Throwable unused) {
            fb.Z(Code, "getLongArray exception ex.");
            return new long[0];
        }
    }

    public double t(String str) {
        return Code(str, OOXIXo.f3760XO);
    }

    public String toString() {
        try {
            return this.I.toString();
        } catch (Throwable unused) {
            fb.Z(Code, "toString exception.");
            return null;
        }
    }

    public double[] u(String str) {
        try {
            return this.I.getDoubleArray(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getDoubleArray exception ex.");
            return new double[0];
        }
    }

    public double[] v(String str) {
        try {
            double[] doubleArray = this.I.getDoubleArray(str);
            return doubleArray == null ? new double[0] : doubleArray;
        } catch (Throwable unused) {
            fb.Z(Code, "getDoubleArray exception ex.");
            return new double[0];
        }
    }

    public String w(String str) {
        try {
            return this.I.getString(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getString exception ex.");
            return "";
        }
    }

    public String x(String str) {
        String str2;
        try {
            str2 = this.I.getString(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getString exception ex.");
            str2 = "";
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }

    public String[] y(String str) {
        try {
            return this.I.getStringArray(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getStringArray exception ex.");
            return new String[0];
        }
    }

    public String[] z(String str) {
        try {
            String[] stringArray = this.I.getStringArray(str);
            return stringArray == null ? new String[0] : stringArray;
        } catch (Throwable unused) {
            fb.Z(Code, "getStringArray exception ex.");
            return new String[0];
        }
    }

    public ef(Bundle bundle) {
        this.I = bundle == null ? new Bundle() : bundle;
    }

    public byte[] B(String str) {
        try {
            return this.I.getByteArray(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getByteArray exception ex.");
            return new byte[0];
        }
    }

    public char Code(String str, char c) {
        try {
            return this.I.getChar(str, c);
        } catch (Throwable unused) {
            fb.Z(Code, "getChar exception ex.");
            return c;
        }
    }

    public ef I(String str, String str2) {
        try {
            this.I.putString(str, str2);
        } catch (Throwable unused) {
            fb.Z(Code, "putString exception ex.");
        }
        return this;
    }

    public ef V(String str, byte b) {
        try {
            this.I.putByte(str, b);
        } catch (Throwable unused) {
            fb.Z(Code, "putByte exception ex.");
        }
        return this;
    }

    public ef Z(String str, ArrayList<CharSequence> arrayList) {
        try {
            this.I.putCharSequenceArrayList(str, arrayList);
        } catch (Throwable unused) {
            fb.Z(Code, "putCharSequenceArrayList exception ex.");
        }
        return this;
    }

    public double Code(String str, double d) {
        try {
            return this.I.getDouble(str, d);
        } catch (Throwable unused) {
            fb.Z(Code, "getDouble exception ex.");
            return d;
        }
    }

    public ef I(String str, ArrayList<String> arrayList) {
        try {
            this.I.putStringArrayList(str, arrayList);
        } catch (Throwable unused) {
            fb.Z(Code, "putStringArrayList exception ex.");
        }
        return this;
    }

    public ef V(String str, char c) {
        try {
            this.I.putChar(str, c);
        } catch (Throwable unused) {
            fb.Z(Code, "putChar exception ex.");
        }
        return this;
    }

    public void Z() {
        try {
            this.I.clear();
        } catch (Throwable unused) {
            fb.Z(Code, "clear exception.");
        }
    }

    public float Code(String str, float f) {
        try {
            return this.I.getFloat(str, f);
        } catch (Throwable unused) {
            fb.Z(Code, "getFloat exception ex.");
            return f;
        }
    }

    public boolean I() {
        try {
            return this.I.isEmpty();
        } catch (Throwable unused) {
            fb.Z(Code, "isEmpty exception");
            return true;
        }
    }

    public ef V(String str, double d) {
        try {
            this.I.putDouble(str, d);
        } catch (Throwable unused) {
            fb.Z(Code, "putDouble exception ex.");
        }
        return this;
    }

    public int Code(String str, int i) {
        try {
            return this.I.getInt(str, i);
        } catch (Throwable unused) {
            fb.Z(Code, "getInt exception ex.");
            return i;
        }
    }

    public boolean[] I(String str) {
        try {
            boolean[] booleanArray = this.I.getBooleanArray(str);
            return booleanArray == null ? new boolean[0] : booleanArray;
        } catch (Throwable unused) {
            fb.Z(Code, "getBooleanArray exception ex.");
            return new boolean[0];
        }
    }

    public ef V(String str, float f) {
        try {
            this.I.putFloat(str, f);
        } catch (Throwable unused) {
            fb.Z(Code, "putFloat exception ex.");
        }
        return this;
    }

    public long Code(String str, long j) {
        try {
            return this.I.getLong(str, j);
        } catch (Throwable unused) {
            fb.Z(Code, "getLong exception ex.");
            return j;
        }
    }

    public ef V(String str, int i) {
        try {
            this.I.putInt(str, i);
        } catch (Throwable unused) {
            fb.Z(Code, "putInt exception ex.");
        }
        return this;
    }

    public Bundle Code() {
        return this.I;
    }

    public ef V(String str, long j) {
        try {
            this.I.putLong(str, j);
        } catch (Throwable unused) {
            fb.Z(Code, "putLong exception ex.");
        }
        return this;
    }

    public <T extends Parcelable> T Code(String str, Class<T> cls) {
        try {
            Parcelable parcelable = this.I.getParcelable(str);
            if (cls.isInstance(parcelable)) {
                return cls.cast(parcelable);
            }
            return null;
        } catch (Throwable unused) {
            fb.Z(Code, "getParcelable exception ex.");
            return null;
        }
    }

    public ef V(String str, ArrayList<Integer> arrayList) {
        try {
            this.I.putIntegerArrayList(str, arrayList);
        } catch (Throwable unused) {
            fb.Z(Code, "putIntegerArrayList exception ex.");
        }
        return this;
    }

    public ef Code(Bundle bundle) {
        if (bundle != null) {
            try {
                this.I.putAll(bundle);
            } catch (Throwable unused) {
                fb.Z(Code, "putAll exception");
            }
        }
        return this;
    }

    public ef V(String str, short s) {
        try {
            this.I.putShort(str, s);
        } catch (Throwable unused) {
            fb.Z(Code, "putShort exception ex.");
        }
        return this;
    }

    public ef Code(String str, Bundle bundle) {
        try {
            this.I.putBundle(str, bundle);
        } catch (Throwable unused) {
            fb.Z(Code, "putBundle exception ex.");
        }
        return this;
    }

    public ef V(String str, boolean z) {
        try {
            this.I.putBoolean(str, z);
        } catch (Throwable unused) {
            fb.Z(Code, "putBoolean exception ex.");
        }
        return this;
    }

    @SuppressLint({"NewApi"})
    public ef Code(String str, IBinder iBinder) {
        try {
            this.I.putBinder(str, iBinder);
        } catch (Throwable unused) {
            fb.Z(Code, "putBundle exception ex.");
        }
        return this;
    }

    public <T extends Serializable> T V(String str, Class<T> cls) {
        try {
            Serializable serializable = this.I.getSerializable(str);
            if (cls.isInstance(serializable)) {
                return cls.cast(serializable);
            }
            return null;
        } catch (Throwable unused) {
            fb.Z(Code, "getSerializable exception ex.");
            return null;
        }
    }

    public ef Code(String str, Parcelable parcelable) {
        try {
            this.I.putParcelable(str, parcelable);
        } catch (Throwable unused) {
            fb.Z(Code, "putParcelable exception ex.");
        }
        return this;
    }

    @SuppressLint({"NewApi"})
    public CharSequence V(String str, CharSequence charSequence) {
        try {
            CharSequence charSequence2 = this.I.getCharSequence(str, charSequence);
            return charSequence2 == null ? "" : charSequence2;
        } catch (Throwable unused) {
            fb.Z(Code, "getCharSequence exception ex.");
            return charSequence;
        }
    }

    @TargetApi(21)
    public ef Code(String str, Size size) {
        try {
            this.I.putSize(str, size);
        } catch (Throwable unused) {
            fb.Z(Code, "putSize exception ex.");
        }
        return this;
    }

    @SuppressLint({"NewApi"})
    public String V(String str, String str2) {
        try {
            String string = this.I.getString(str, str2);
            return string == null ? str2 : string;
        } catch (Throwable unused) {
            fb.Z(Code, "getString exception ex.");
            return str2;
        }
    }

    @TargetApi(21)
    public ef Code(String str, SizeF sizeF) {
        try {
            this.I.putSizeF(str, sizeF);
        } catch (Throwable unused) {
            fb.Z(Code, "putSizeF exception ex.");
        }
        return this;
    }

    public boolean[] V(String str) {
        try {
            return this.I.getBooleanArray(str);
        } catch (Throwable unused) {
            fb.Z(Code, "getBooleanArray exception ex.");
            return new boolean[0];
        }
    }

    public ef Code(String str, SparseArray<? extends Parcelable> sparseArray) {
        try {
            this.I.putSparseParcelableArray(str, sparseArray);
        } catch (Throwable unused) {
            fb.Z(Code, "putSparseParcelableArray exception ex.");
        }
        return this;
    }

    public ef Code(String str, Serializable serializable) {
        try {
            this.I.putSerializable(str, serializable);
        } catch (Throwable unused) {
            fb.Z(Code, "putSerializable exception ex.");
        }
        return this;
    }

    public ef Code(String str, ArrayList<? extends Parcelable> arrayList) {
        try {
            this.I.putParcelableArrayList(str, arrayList);
        } catch (Throwable unused) {
            fb.Z(Code, "putParcelableArrayList exception ex.");
        }
        return this;
    }

    public ef Code(String str, byte[] bArr) {
        try {
            this.I.putByteArray(str, bArr);
        } catch (Throwable unused) {
            fb.Z(Code, "putByteArray exception ex.");
        }
        return this;
    }

    public ef Code(String str, char[] cArr) {
        try {
            this.I.putCharArray(str, cArr);
        } catch (Throwable unused) {
            fb.Z(Code, "putCharArray exception ex.");
        }
        return this;
    }

    public ef Code(String str, double[] dArr) {
        try {
            this.I.putDoubleArray(str, dArr);
        } catch (Throwable unused) {
            fb.Z(Code, "putDoubleArray exception ex.");
        }
        return this;
    }

    public ef Code(String str, float[] fArr) {
        try {
            this.I.putFloatArray(str, fArr);
        } catch (Throwable unused) {
            fb.Z(Code, "putFloatArray exception ex.");
        }
        return this;
    }

    public ef Code(String str, int[] iArr) {
        try {
            this.I.putIntArray(str, iArr);
        } catch (Throwable unused) {
            fb.Z(Code, "putIntArray exception ex.");
        }
        return this;
    }

    public ef Code(String str, long[] jArr) {
        try {
            this.I.putLongArray(str, jArr);
        } catch (Throwable unused) {
            fb.Z(Code, "putLongArray exception ex.");
        }
        return this;
    }

    public ef Code(String str, Parcelable[] parcelableArr) {
        try {
            this.I.putParcelableArray(str, parcelableArr);
        } catch (Throwable unused) {
            fb.Z(Code, "putParcelableArray exception ex.");
        }
        return this;
    }

    public ef Code(String str, CharSequence[] charSequenceArr) {
        try {
            this.I.putCharSequenceArray(str, charSequenceArr);
        } catch (Throwable unused) {
            fb.Z(Code, "putCharSequenceArray exception ex.");
        }
        return this;
    }

    public ef Code(String str, String[] strArr) {
        try {
            this.I.putStringArray(str, strArr);
        } catch (Throwable unused) {
            fb.Z(Code, "putStringArray exception ex.");
        }
        return this;
    }

    public ef Code(String str, short[] sArr) {
        try {
            this.I.putShortArray(str, sArr);
        } catch (Throwable unused) {
            fb.Z(Code, "putShortArray exception ex.");
        }
        return this;
    }

    public ef Code(String str, boolean[] zArr) {
        try {
            this.I.putBooleanArray(str, zArr);
        } catch (Throwable unused) {
            fb.Z(Code, "putBooleanArray exception ex.");
        }
        return this;
    }

    @SuppressLint({"NewApi"})
    public CharSequence Code(String str, CharSequence charSequence) {
        try {
            return this.I.getCharSequence(str, charSequence);
        } catch (Throwable unused) {
            fb.Z(Code, "getCharSequence exception ex.");
            return charSequence;
        }
    }

    @SuppressLint({"NewApi"})
    public String Code(String str, String str2) {
        try {
            return this.I.getString(str, str2);
        } catch (Throwable unused) {
            fb.Z(Code, "getString exception ex.");
            return str2;
        }
    }

    public short Code(String str, short s) {
        try {
            return this.I.getShort(str, s);
        } catch (Throwable unused) {
            fb.Z(Code, "getShort exception ex.");
            return s;
        }
    }

    public boolean Code(String str) {
        return Code(str, false);
    }

    public boolean Code(String str, boolean z) {
        try {
            return this.I.getBoolean(str, z);
        } catch (Throwable unused) {
            fb.Z(Code, "getBoolean exception  ex.");
            return z;
        }
    }
}
