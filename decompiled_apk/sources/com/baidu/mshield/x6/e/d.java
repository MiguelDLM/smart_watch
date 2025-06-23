package com.baidu.mshield.x6.e;

import android.text.TextUtils;
import org.json.JSONArray;

/* loaded from: classes7.dex */
public class d {
    public static int a(int i, String str) {
        int a2;
        try {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return -1;
            }
            if (jSONArray.length() == 1) {
                return jSONArray.optInt(0);
            }
            if (i == 1) {
                a2 = a(jSONArray);
            } else if (i == 2) {
                a2 = b(jSONArray);
            } else if (i == 3) {
                a2 = c(jSONArray);
            } else if (i == 4) {
                a2 = d(jSONArray);
            } else {
                if (i != 5) {
                    return -1;
                }
                a2 = e(jSONArray);
            }
            return a2;
        } catch (Throwable th) {
            f.a(th);
            return -1;
        }
    }

    public static int b(JSONArray jSONArray) {
        int i = 0;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (jSONArray.length() == 1) {
                        return jSONArray.optInt(0);
                    }
                    i = jSONArray.optInt(0);
                    for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                        i |= jSONArray.optInt(i2);
                    }
                }
            } catch (Throwable th) {
                f.a(th);
            }
        }
        return i;
    }

    public static int c(JSONArray jSONArray) {
        int i = 0;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (jSONArray.length() == 1) {
                        return jSONArray.optInt(0);
                    }
                    i = jSONArray.optInt(0);
                    for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                        i ^= jSONArray.optInt(i2);
                    }
                }
            } catch (Throwable th) {
                f.a(th);
            }
        }
        return i;
    }

    public static int d(JSONArray jSONArray) {
        int i = 0;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (jSONArray.length() == 1) {
                        return jSONArray.optInt(0);
                    }
                    i = jSONArray.optInt(0);
                    for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                        i <<= jSONArray.optInt(i2);
                    }
                }
            } catch (Throwable th) {
                f.a(th);
            }
        }
        return i;
    }

    public static int e(JSONArray jSONArray) {
        int i = 0;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (jSONArray.length() == 1) {
                        return jSONArray.optInt(0);
                    }
                    i = jSONArray.optInt(0);
                    for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                        i >>= jSONArray.optInt(i2);
                    }
                }
            } catch (Throwable th) {
                f.a(th);
            }
        }
        return i;
    }

    public static int a(JSONArray jSONArray) {
        int i = 0;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    if (jSONArray.length() == 1) {
                        return jSONArray.optInt(0);
                    }
                    i = jSONArray.optInt(0);
                    for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                        i &= jSONArray.optInt(i2);
                    }
                }
            } catch (Throwable th) {
                f.a(th);
            }
        }
        return i;
    }
}
