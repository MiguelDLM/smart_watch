package com.baidu.mshield.ac;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.Pair;
import java.util.Map;

/* loaded from: classes7.dex */
public interface FI {
    byte[] ad(byte[] bArr, byte[] bArr2);

    byte[] ae(byte[] bArr, byte[] bArr2);

    boolean chh(Context context, String str);

    void cm(String str, String str2, String str3, Callback callback, Class<?>[] clsArr, Object... objArr);

    Pair<Integer, Object> cmsi(int i, String str, Class<?>[] clsArr, Object... objArr);

    SharedPreferences getCustomMutiProcessSharedPreferences(Context context, String str);

    SharedPreferences getPlatformPrivateSharedPreferences(Context context);

    SharedPreferences getPlatformSharedSharedPreferences(Context context);

    Map<Integer, String> gpd();

    String gs(String str);

    String gta(Context context);

    String gzd(Context context);

    String p(String str);

    void r(String str, IntentFilter intentFilter, String str2, String str3);

    byte[] rd(byte[] bArr, byte[] bArr2);

    byte[] re(byte[] bArr, byte[] bArr2);

    void rf(Context context);

    void s(int i, boolean z);

    void sp(String str, boolean z);

    void u(String str);

    void ur(String str, IntentFilter intentFilter, String str2, String str3);
}
