package com.huawei.hms.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes10.dex */
public class ee {
    private static ee C = null;
    private static final String Code = "HiAd_def_tpt_sp";
    private static final String D = "show_times_";
    private static final String F = "last_time_";
    private static final byte[] I = new byte[0];
    private static final String L = "last_clean_time";
    private static final long V = 43200000;
    private static final String Z = "TptSpHandler";
    private final byte[] B = new byte[0];
    private Context S;

    private ee(Context context) {
        this.S = com.huawei.openalliance.ad.utils.n.L(context.getApplicationContext());
    }

    public long Code(String str) {
        long j;
        synchronized (this.B) {
            j = Code().getLong(F + str, 0L);
        }
        return j;
    }

    public int I(String str) {
        synchronized (this.B) {
            try {
                SharedPreferences Code2 = Code();
                if (!com.huawei.openalliance.ad.utils.be.Code(Code2.getLong(F + str, 0L))) {
                    return 0;
                }
                return Code2.getInt(D + str, 0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public long V(String str) {
        long j;
        synchronized (this.B) {
            j = Code().getInt(D + str, 0);
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences Code() {
        return this.S.getSharedPreferences(Code, 0);
    }

    public static ee Code(Context context) {
        return V(context);
    }

    private static ee V(Context context) {
        ee eeVar;
        synchronized (I) {
            try {
                if (C == null) {
                    C = new ee(context);
                }
                eeVar = C;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eeVar;
    }

    private void V() {
        com.huawei.openalliance.ad.utils.h.Code(new Runnable() { // from class: com.huawei.hms.ads.ee.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (ee.this.B) {
                    try {
                        SharedPreferences Code2 = ee.this.Code();
                        SharedPreferences.Editor edit = Code2.edit();
                        if (System.currentTimeMillis() - Code2.getLong(ee.L, 0L) <= ee.V) {
                            fb.V(ee.Z, "less than half day");
                            return;
                        }
                        fb.V(ee.Z, "begin clean");
                        for (Map.Entry<String, ?> entry : Code2.getAll().entrySet()) {
                            if (entry != null && entry.getKey() != null) {
                                String key = entry.getKey();
                                if (key.startsWith(ee.F) && (entry.getValue() instanceof Long) && (((Long) entry.getValue()) == null || !com.huawei.openalliance.ad.utils.be.Code(((Long) entry.getValue()).longValue()))) {
                                    edit.remove(key);
                                    String Code3 = ee.this.Code(key, ee.F);
                                    fb.Code(ee.Z, "slotId = %s", Code3);
                                    if (!TextUtils.isEmpty(Code3)) {
                                        edit.remove(ee.D + Code3);
                                    }
                                }
                            }
                        }
                        edit.putLong(ee.L, System.currentTimeMillis());
                        edit.commit();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Code(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            if (indexOf < 0 || indexOf >= str.length() - length) {
                return null;
            }
            return str.substring(indexOf + length);
        } catch (Throwable th) {
            fb.I(Z, "get slotId by prefix err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    public void Code(String str, long j) {
        synchronized (this.B) {
            try {
                SharedPreferences Code2 = Code();
                SharedPreferences.Editor edit = Code2.edit();
                long j2 = Code2.getLong(F + str, 0L);
                edit.putLong(F + str, j);
                if (com.huawei.openalliance.ad.utils.be.Code(j2)) {
                    edit.putInt(D + str, Code2.getInt(D + str, 0) + 1);
                } else {
                    edit.putInt(D + str, 1);
                }
                edit.commit();
                V();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
