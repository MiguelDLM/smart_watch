package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;

/* loaded from: classes8.dex */
final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f10568a = new o(null, 0, null, null, null);

    @Nullable
    public final Signature[] b;
    public final int c;

    @Nullable
    public final ArraySet<PublicKey> d;

    @Nullable
    public final Signature[] e;

    @Nullable
    public final int[] f;

    public o(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.b = signatureArr;
        this.c = i;
        this.d = arraySet;
        this.e = signatureArr2;
        this.f = iArr;
    }

    private static ArraySet<PublicKey> a(Signature[] signatureArr) {
        Method method;
        X0o0xo.oIX0oI();
        ArraySet<PublicKey> oIX0oI2 = oxoX.oIX0oI(signatureArr.length);
        for (Signature signature : signatureArr) {
            try {
                method = Signature.class.getMethod("getPublicKey", null);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                method = null;
            }
            if (method != null && method.isAccessible()) {
                try {
                    oIX0oI2.add((PublicKey) method.invoke(signature, null));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return oIX0oI2;
    }

    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.c != oVar.c || !a(this.b, oVar.b)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.d;
        if (arraySet != null) {
            equals = arraySet.equals(oVar.d);
            if (!equals) {
                return false;
            }
        } else if (oVar.d != null) {
            return false;
        }
        if (Arrays.equals(this.e, oVar.e) && Arrays.equals(this.f, oVar.f)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = ((Arrays.hashCode(this.b) * 31) + this.c) * 31;
        ArraySet<PublicKey> arraySet = this.d;
        if (arraySet != null) {
            i = arraySet.hashCode();
        } else {
            i = 0;
        }
        return ((((hashCode + i) * 31) + Arrays.hashCode(this.e)) * 31) + Arrays.hashCode(this.f);
    }

    public o(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i, a(signatureArr), signatureArr2, iArr);
    }

    public o(Signature[] signatureArr) {
        this(signatureArr, 2, null, null);
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.d.a((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.d.a((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
