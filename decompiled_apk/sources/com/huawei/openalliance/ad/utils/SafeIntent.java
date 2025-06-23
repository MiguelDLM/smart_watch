package com.huawei.openalliance.ad.utils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.ads.fb;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class SafeIntent extends Intent {
    private static final String Code = "SafeIntent";

    public SafeIntent(Intent intent) {
        super(intent == null ? new Intent() : intent);
    }

    public ArrayList<String> B(String str) {
        try {
            ArrayList<String> stringArrayListExtra = super.getStringArrayListExtra(str);
            return stringArrayListExtra == null ? new ArrayList<>() : stringArrayListExtra;
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    public boolean[] C(String str) {
        try {
            boolean[] booleanArrayExtra = super.getBooleanArrayExtra(str);
            return booleanArrayExtra == null ? new boolean[0] : booleanArrayExtra;
        } catch (Throwable unused) {
            return new boolean[0];
        }
    }

    public String Code() {
        try {
            String action = super.getAction();
            return action == null ? "" : action;
        } catch (Throwable unused) {
            return "";
        }
    }

    public char[] D(String str) {
        try {
            char[] charArrayExtra = super.getCharArrayExtra(str);
            return charArrayExtra == null ? new char[0] : charArrayExtra;
        } catch (Throwable unused) {
            return new char[0];
        }
    }

    public byte[] F(String str) {
        try {
            byte[] byteArrayExtra = super.getByteArrayExtra(str);
            return byteArrayExtra == null ? new byte[0] : byteArrayExtra;
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    @Deprecated
    public String I() {
        String str;
        try {
            str = super.toURI();
        } catch (Throwable th) {
            fb.I(Code, "toURI: exception " + th.getClass().getSimpleName());
            str = "";
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public CharSequence[] L(String str) {
        try {
            CharSequence[] charSequenceArrayExtra = super.getCharSequenceArrayExtra(str);
            return charSequenceArrayExtra == null ? new CharSequence[0] : charSequenceArrayExtra;
        } catch (Throwable unused) {
            return new CharSequence[0];
        }
    }

    public Bundle S(String str) {
        try {
            Bundle bundleExtra = super.getBundleExtra(str);
            return bundleExtra == null ? new Bundle() : bundleExtra;
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    public Bundle V() {
        try {
            Bundle extras = super.getExtras();
            return extras == null ? new Bundle() : extras;
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    public ArrayList<Integer> Z(String str) {
        try {
            ArrayList<Integer> integerArrayListExtra = super.getIntegerArrayListExtra(str);
            return integerArrayListExtra == null ? new ArrayList<>() : integerArrayListExtra;
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    public double[] a(String str) {
        try {
            double[] doubleArrayExtra = super.getDoubleArrayExtra(str);
            return doubleArrayExtra == null ? new double[0] : doubleArrayExtra;
        } catch (Throwable unused) {
            return new double[0];
        }
    }

    public float[] b(String str) {
        try {
            float[] floatArrayExtra = super.getFloatArrayExtra(str);
            return floatArrayExtra == null ? new float[0] : floatArrayExtra;
        } catch (Throwable unused) {
            return new float[0];
        }
    }

    public int[] c(String str) {
        try {
            int[] intArrayExtra = super.getIntArrayExtra(str);
            return intArrayExtra == null ? new int[0] : intArrayExtra;
        } catch (Throwable unused) {
            return new int[0];
        }
    }

    public long[] d(String str) {
        try {
            long[] longArrayExtra = super.getLongArrayExtra(str);
            return longArrayExtra == null ? new long[0] : longArrayExtra;
        } catch (Throwable unused) {
            return new long[0];
        }
    }

    public Parcelable[] e(String str) {
        try {
            Parcelable[] parcelableArrayExtra = super.getParcelableArrayExtra(str);
            return parcelableArrayExtra == null ? new Parcelable[0] : parcelableArrayExtra;
        } catch (Throwable unused) {
            return new Parcelable[0];
        }
    }

    public String[] f(String str) {
        try {
            String[] stringArrayExtra = super.getStringArrayExtra(str);
            return stringArrayExtra == null ? new String[0] : stringArrayExtra;
        } catch (Throwable unused) {
            return new String[0];
        }
    }

    public short[] g(String str) {
        try {
            short[] shortArrayExtra = super.getShortArrayExtra(str);
            return shortArrayExtra == null ? new short[0] : shortArrayExtra;
        } catch (Throwable unused) {
            return new short[0];
        }
    }

    @Override // android.content.Intent
    public String getAction() {
        try {
            return super.getAction();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean[] getBooleanArrayExtra(String str) {
        try {
            return super.getBooleanArrayExtra(str);
        } catch (Throwable unused) {
            return new boolean[0];
        }
    }

    @Override // android.content.Intent
    public boolean getBooleanExtra(String str, boolean z) {
        try {
            return super.getBooleanExtra(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    @Override // android.content.Intent
    public Bundle getBundleExtra(String str) {
        try {
            return super.getBundleExtra(str);
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    @Override // android.content.Intent
    public byte[] getByteArrayExtra(String str) {
        try {
            return super.getByteArrayExtra(str);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    @Override // android.content.Intent
    public byte getByteExtra(String str, byte b) {
        try {
            return super.getByteExtra(str, b);
        } catch (Throwable unused) {
            return b;
        }
    }

    @Override // android.content.Intent
    public char[] getCharArrayExtra(String str) {
        try {
            return super.getCharArrayExtra(str);
        } catch (Throwable unused) {
            return new char[0];
        }
    }

    @Override // android.content.Intent
    public char getCharExtra(String str, char c) {
        try {
            return super.getCharExtra(str, c);
        } catch (Throwable unused) {
            return c;
        }
    }

    @Override // android.content.Intent
    public CharSequence[] getCharSequenceArrayExtra(String str) {
        try {
            return super.getCharSequenceArrayExtra(str);
        } catch (Throwable unused) {
            return new CharSequence[0];
        }
    }

    @Override // android.content.Intent
    public ArrayList<CharSequence> getCharSequenceArrayListExtra(String str) {
        try {
            return super.getCharSequenceArrayListExtra(str);
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public CharSequence getCharSequenceExtra(String str) {
        try {
            return super.getCharSequenceExtra(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public String getDataString() {
        try {
            return super.getDataString();
        } catch (Throwable th) {
            fb.I(Code, "getDataStr err: %s", th.getClass().getSimpleName());
            return "";
        }
    }

    @Override // android.content.Intent
    public double[] getDoubleArrayExtra(String str) {
        try {
            return super.getDoubleArrayExtra(str);
        } catch (Throwable unused) {
            return new double[0];
        }
    }

    @Override // android.content.Intent
    public double getDoubleExtra(String str, double d) {
        try {
            return super.getDoubleExtra(str, d);
        } catch (Throwable unused) {
            return d;
        }
    }

    @Override // android.content.Intent
    public Bundle getExtras() {
        try {
            return super.getExtras();
        } catch (Throwable unused) {
            return new Bundle();
        }
    }

    @Override // android.content.Intent
    public float[] getFloatArrayExtra(String str) {
        try {
            return super.getFloatArrayExtra(str);
        } catch (Throwable unused) {
            return new float[0];
        }
    }

    @Override // android.content.Intent
    public float getFloatExtra(String str, float f) {
        try {
            return super.getFloatExtra(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    @Override // android.content.Intent
    public int[] getIntArrayExtra(String str) {
        try {
            return super.getIntArrayExtra(str);
        } catch (Throwable unused) {
            return new int[0];
        }
    }

    @Override // android.content.Intent
    public int getIntExtra(String str, int i) {
        try {
            return super.getIntExtra(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    @Override // android.content.Intent
    public ArrayList<Integer> getIntegerArrayListExtra(String str) {
        try {
            return super.getIntegerArrayListExtra(str);
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public long[] getLongArrayExtra(String str) {
        try {
            return super.getLongArrayExtra(str);
        } catch (Throwable unused) {
            return new long[0];
        }
    }

    @Override // android.content.Intent
    public long getLongExtra(String str, long j) {
        try {
            return super.getLongExtra(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    @Override // android.content.Intent
    public Parcelable[] getParcelableArrayExtra(String str) {
        try {
            return super.getParcelableArrayExtra(str);
        } catch (Throwable unused) {
            return new Parcelable[0];
        }
    }

    @Override // android.content.Intent
    public <T extends Parcelable> ArrayList<T> getParcelableArrayListExtra(String str) {
        try {
            return super.getParcelableArrayListExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public <T extends Parcelable> T getParcelableExtra(String str) {
        try {
            return (T) super.getParcelableExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public String getScheme() {
        try {
            return super.getScheme();
        } catch (Throwable th) {
            fb.I(Code, "getScheme err: %s", th.getClass().getSimpleName());
            return "";
        }
    }

    @Override // android.content.Intent
    public Serializable getSerializableExtra(String str) {
        try {
            return super.getSerializableExtra(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.content.Intent
    public short[] getShortArrayExtra(String str) {
        try {
            return super.getShortArrayExtra(str);
        } catch (Throwable unused) {
            return new short[0];
        }
    }

    @Override // android.content.Intent
    public short getShortExtra(String str, short s) {
        try {
            return super.getShortExtra(str, s);
        } catch (Throwable unused) {
            return s;
        }
    }

    @Override // android.content.Intent
    public String[] getStringArrayExtra(String str) {
        try {
            return super.getStringArrayExtra(str);
        } catch (Throwable unused) {
            return new String[0];
        }
    }

    @Override // android.content.Intent
    public ArrayList<String> getStringArrayListExtra(String str) {
        try {
            return super.getStringArrayListExtra(str);
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    @Override // android.content.Intent
    public String getStringExtra(String str) {
        try {
            return super.getStringExtra(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public boolean hasExtra(String str) {
        try {
            return super.hasExtra(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Bundle bundle) {
        try {
            return super.putExtra(str, bundle);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtras(Intent intent) {
        try {
            return super.putExtras(intent);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putParcelableArrayListExtra(String str, ArrayList<? extends Parcelable> arrayList) {
        try {
            return super.putParcelableArrayListExtra(str, arrayList);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent setAction(String str) {
        try {
            return super.setAction(str);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent setPackage(String str) {
        try {
            return super.setPackage(str);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public void setSelector(Intent intent) {
        try {
            super.setSelector(intent);
        } catch (Throwable unused) {
            fb.I(Code, "setSelector ex.");
        }
    }

    @Override // android.content.Intent
    @Deprecated
    public String toURI() {
        try {
            return super.toURI();
        } catch (Throwable th) {
            fb.I(Code, "toURI: exception " + th.getClass().getSimpleName());
            return "";
        }
    }

    @Override // android.content.Intent
    public String toUri(int i) {
        try {
            return super.toUri(i);
        } catch (Throwable unused) {
            fb.I(Code, "toUri ex.");
            return "";
        }
    }

    public String Code(int i) {
        String str;
        try {
            str = super.toUri(i);
        } catch (Throwable unused) {
            fb.I(Code, "toUri ex.");
            str = "";
        }
        return str == null ? "" : str;
    }

    public ArrayList<CharSequence> I(String str) {
        try {
            ArrayList<CharSequence> charSequenceArrayListExtra = super.getCharSequenceArrayListExtra(str);
            return charSequenceArrayListExtra == null ? new ArrayList<>() : charSequenceArrayListExtra;
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    public CharSequence V(String str) {
        try {
            CharSequence charSequenceExtra = super.getCharSequenceExtra(str);
            return charSequenceExtra == null ? "" : charSequenceExtra;
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Parcelable parcelable) {
        try {
            return super.putExtra(str, parcelable);
        } catch (Throwable unused) {
            return this;
        }
    }

    public String Code(String str) {
        try {
            String stringExtra = super.getStringExtra(str);
            return stringExtra == null ? "" : stringExtra;
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Serializable serializable) {
        try {
            return super.putExtra(str, serializable);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, CharSequence charSequence) {
        try {
            return super.putExtra(str, charSequence);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, String str2) {
        try {
            return super.putExtra(str, str2);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, Parcelable[] parcelableArr) {
        try {
            return super.putExtra(str, parcelableArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, CharSequence[] charSequenceArr) {
        try {
            return super.putExtra(str, charSequenceArr);
        } catch (Throwable unused) {
            return this;
        }
    }

    @Override // android.content.Intent
    public Intent putExtra(String str, String[] strArr) {
        try {
            return super.putExtra(str, strArr);
        } catch (Throwable unused) {
            return this;
        }
    }
}
