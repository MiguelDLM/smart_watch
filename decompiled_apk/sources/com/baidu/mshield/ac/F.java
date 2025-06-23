package com.baidu.mshield.ac;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.Pair;
import com.baidu.mshield.b.f.a;
import com.baidu.mshield.utility.c;
import com.baidu.mshield.utility.d;
import java.util.Map;

/* loaded from: classes7.dex */
public class F implements FI {
    private static F instance;

    private F() {
    }

    public static synchronized F getInstance() {
        F f;
        synchronized (F.class) {
            try {
                if (instance == null) {
                    instance = new F();
                }
                f = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return f;
    }

    @Override // com.baidu.mshield.ac.FI
    public byte[] ad(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] b = a.b(bArr, bArr2);
                    if (b != null && b.length > 0) {
                        return b;
                    }
                    return new byte[0];
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        }
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public byte[] ae(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] a2 = a.a(bArr, bArr2);
                    if (a2 != null && a2.length > 0) {
                        return a2;
                    }
                    return new byte[0];
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        }
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public boolean chh(Context context, String str) {
        return false;
    }

    @Override // com.baidu.mshield.ac.FI
    public void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr) {
    }

    @Override // com.baidu.mshield.ac.FI
    public Pair<Integer, Object> cmsi(int i, String str, Class<?>[] clsArr, Object... objArr) {
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public SharedPreferences getCustomMutiProcessSharedPreferences(Context context, String str) {
        if (context == null) {
            return null;
        }
        return com.baidu.mshield.sharedpreferences.a.a(context).b(str);
    }

    @Override // com.baidu.mshield.ac.FI
    public SharedPreferences getPlatformPrivateSharedPreferences(Context context) {
        if (context == null) {
            return null;
        }
        return com.baidu.mshield.sharedpreferences.a.a(context).b();
    }

    @Override // com.baidu.mshield.ac.FI
    public SharedPreferences getPlatformSharedSharedPreferences(Context context) {
        if (context == null) {
            return null;
        }
        return com.baidu.mshield.sharedpreferences.a.a(context).c();
    }

    @Override // com.baidu.mshield.ac.FI
    public Map<Integer, String> gpd() {
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public String gs(String str) {
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public String gta(Context context) {
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public String gzd(Context context) {
        return c.a(context);
    }

    @Override // com.baidu.mshield.ac.FI
    public String p(String str) {
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public void r(String str, IntentFilter intentFilter, String str2, String str3) {
    }

    @Override // com.baidu.mshield.ac.FI
    public byte[] rd(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] a2 = d.a(bArr, bArr2);
                    if (a2 != null && a2.length > 0) {
                        return a2;
                    }
                    return new byte[0];
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        }
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public byte[] re(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] b = d.b(bArr, bArr2);
                    if (b != null && b.length > 0) {
                        return b;
                    }
                    return new byte[0];
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        }
        return null;
    }

    @Override // com.baidu.mshield.ac.FI
    public void rf(Context context) {
    }

    @Override // com.baidu.mshield.ac.FI
    public void s(int i, boolean z) {
    }

    @Override // com.baidu.mshield.ac.FI
    public void sp(String str, boolean z) {
    }

    @Override // com.baidu.mshield.ac.FI
    public void u(String str) {
    }

    @Override // com.baidu.mshield.ac.FI
    public void ur(String str, IntentFilter intentFilter, String str2, String str3) {
    }
}
