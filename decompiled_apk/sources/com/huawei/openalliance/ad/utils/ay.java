package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.fb;
import com.huawei.openalliance.ad.constant.ca;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public abstract class ay {
    private static final String Code = "StrUtil";
    private static final String I = "^[0-9]+,[0-9]+$";
    private static final String V = "^[0-9\\*\\+\\-\\.]*$";
    private static final int Z = 100;

    public static boolean B(String str) {
        return str != null && (str.startsWith(ca.HTTP.toString()) || str.startsWith(ca.HTTPS.toString()));
    }

    public static String C(String str) {
        return TextUtils.isEmpty(str) ? "" : str.contains("://") ? a(str) : b(str);
    }

    public static int Code(String str, int i) {
        try {
            return Code(str) ? i : Integer.parseInt(str);
        } catch (NumberFormatException e) {
            fb.I(Code, "parseIntOrDefault exception: " + e.getClass().getSimpleName());
            return i;
        }
    }

    public static boolean D(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches(I, str) && str.length() < 100;
    }

    public static Integer F(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e) {
            fb.Z(Code, "toInteger NumberFormatException:" + e.getClass().getSimpleName());
            return null;
        }
    }

    public static Long I(String str) {
        if (Code(str)) {
            return null;
        }
        try {
            return Long.valueOf(str);
        } catch (NumberFormatException e) {
            fb.Z(Code, "toLong NumberFormatException:" + e.getClass().getSimpleName());
            return null;
        }
    }

    public static boolean L(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches(V, str) && str.length() < 100;
    }

    public static String S(String str) {
        if (Code(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            fb.Z(Code, "unsupport encoding");
            return null;
        }
    }

    public static String V(Object obj) {
        return obj == null ? "null" : "not null";
    }

    public static String Z(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\"", "\\\"");
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder();
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme != null) {
            sb.append(scheme);
            sb.append("://");
        }
        String lastPathSegment = parse.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = parse.getHost();
        } else {
            sb.append("******");
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
        }
        if (lastPathSegment != null) {
            int length = lastPathSegment.length();
            if (length > 3) {
                sb.append((CharSequence) lastPathSegment, 0, 3);
            } else if (length > 1) {
                sb.append((CharSequence) lastPathSegment, 0, length - 1);
            }
        }
        sb.append("******");
        return sb.toString();
    }

    private static String b(String str) {
        int i;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf >= 0 && (i = lastIndexOf + 1) < str.length()) {
            str = str.substring(i);
        }
        int length = str.length();
        if (length > 3) {
            return str.substring(0, 3) + "******";
        }
        if (length <= 1) {
            return "******";
        }
        return str.substring(0, length - 1) + "******";
    }

    public static long Code(String str, long j) {
        try {
            return Code(str) ? j : Long.parseLong(str);
        } catch (NumberFormatException e) {
            fb.I(Code, "parseLongOrDefault exception: " + e.getClass().getSimpleName());
            return j;
        }
    }

    private static Object I(Object obj) {
        if (obj instanceof Bundle) {
            return V((Bundle) obj);
        }
        try {
            return JSONObject.wrap(obj);
        } catch (Throwable th) {
            fb.I(Code, "wrap Exception:" + th.getClass().getSimpleName());
            return JSONObject.NULL;
        }
    }

    public static String V(String str) {
        String str2;
        if (Code(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "unsupport encoding";
            fb.Z(Code, str2);
            return null;
        } catch (Exception unused2) {
            str2 = "decode error";
            fb.Z(Code, str2);
            return null;
        }
    }

    public static Float Code(String str, Float f) {
        if (Code(str)) {
            return f;
        }
        try {
            return Float.valueOf(str);
        } catch (NumberFormatException e) {
            fb.Z(Code, "parseFloatOrDefault NumberFormatException:" + e.getClass().getSimpleName());
            return f;
        }
    }

    public static List<String> V(String str, String str2) {
        return TextUtils.isEmpty(str) ? Collections.emptyList() : new ArrayList(Arrays.asList(str.split(str2)));
    }

    private static String Code(long j) {
        float f = (((float) j) * 1.0f) / 1048576.0f;
        if (f < 0.1f) {
            f = 0.1f;
        }
        return String.format(Locale.getDefault(), "%.1f", Float.valueOf(f));
    }

    public static JSONObject V(Bundle bundle) {
        if (bundle == null) {
            return new JSONObject();
        }
        Set<String> keySet = bundle.keySet();
        JSONObject jSONObject = new JSONObject();
        for (String str : keySet) {
            try {
                jSONObject.put(str, I(bundle.get(str)));
            } catch (Throwable th) {
                fb.I(Code, "converBundleToJson Exception:" + th.getClass().getSimpleName());
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String Code(android.content.Context r5, int r6, java.lang.String r7, java.lang.Object... r8) {
        /*
            java.lang.String r0 = "getChinaString "
            java.lang.String r1 = "StrUtil"
            android.content.res.Resources r2 = r5.getResources()
            r3 = 0
            com.huawei.hms.ads.cv r4 = com.huawei.hms.ads.ck.Code(r5)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            boolean r4 = r4.Code()     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            if (r4 == 0) goto L5f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            r4.<init>()     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            r4.append(r7)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            java.lang.String r7 = "_zh"
            r4.append(r7)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            java.lang.String r4 = "string"
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            int r5 = r2.getIdentifier(r7, r4, r5)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            if (r8 == 0) goto L39
            java.lang.String r3 = r2.getString(r5, r8)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            goto L5f
        L35:
            r5 = move-exception
            goto L3e
        L37:
            r5 = move-exception
            goto L59
        L39:
            java.lang.String r3 = r2.getString(r5)     // Catch: java.lang.Exception -> L35 java.lang.RuntimeException -> L37
            goto L5f
        L3e:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
        L43:
            r7.append(r0)
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            com.huawei.hms.ads.fb.Z(r1, r5)
            goto L5f
        L59:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            goto L43
        L5f:
            if (r3 != 0) goto L6f
            if (r8 == 0) goto L6b
            int r5 = r8.length
            if (r5 <= 0) goto L6b
            java.lang.String r3 = r2.getString(r6, r8)
            goto L6f
        L6b:
            java.lang.String r3 = r2.getString(r6)
        L6f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.ay.Code(android.content.Context, int, java.lang.String, java.lang.Object[]):java.lang.String");
    }

    public static String Code(Context context, long j) {
        if (context == null) {
            return "";
        }
        return context.getString(R.string.hiad_data_size_prompt, Code(j));
    }

    public static String Code(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return V(bundle).toString();
    }

    public static String Code(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public static String Code(String str, Context context) {
        BufferedReader bufferedReader;
        Object th;
        InputStream inputStream;
        AssetManager assets = context.getAssets();
        StringBuilder sb = new StringBuilder();
        try {
            inputStream = assets.open(str);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            fb.I(Code, "getStringFromAsset " + th.getClass().getSimpleName());
                            return sb.toString();
                        } finally {
                            ax.Code(bufferedReader);
                            ax.Code((Closeable) inputStream);
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            inputStream = null;
        }
        return sb.toString();
    }

    public static String Code(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            boolean z = true;
            for (String str2 : list) {
                if (!z) {
                    sb.append(str);
                }
                sb.append(str2);
                z = false;
            }
        }
        return sb.toString();
    }

    public static List<String> Code(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (ad.Code(list)) {
            return arrayList;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String V2 = V(it.next());
            if (V2 != null) {
                arrayList.add(V2);
            }
        }
        return arrayList;
    }

    public static boolean Code(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean Code(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return TextUtils.equals(str, str2);
    }

    public static boolean Code(Set<String> set, String str) {
        if (!ad.Code(set) && !TextUtils.isEmpty(str)) {
            return set.contains(str);
        }
        fb.Code(Code, "ModelList or ModelName is empty");
        return true;
    }
}
