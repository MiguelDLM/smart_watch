package com.kuaishou.weapon.p0;

import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class di {
    public static String a() {
        try {
            return b(String.format(" lsof -p %1$s ", Integer.valueOf(Process.myPid())));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String b(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            ArrayList arrayList = new ArrayList();
            do {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.contains("TCP") && !readLine.contains(":443")) {
                    arrayList.add(readLine);
                }
            } while (arrayList.size() <= 5);
            bufferedReader.close();
            if (arrayList.size() > 0) {
                return arrayList.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005f, code lost:
    
        if (r3 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Set c() {
        /*
            r0 = 0
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            r1.<init>()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            java.lang.String r2 = " netstat -nap "
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            java.lang.Process r2 = r3.exec(r2)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
        L1e:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r2 == 0) goto L44
            java.lang.String r4 = "tcp"
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r4 == 0) goto L1e
            java.lang.String r4 = "ESTABLISHED"
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r4 == 0) goto L1e
            java.lang.String r4 = ":5555 "
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r4 == 0) goto L1e
            r1.add(r2)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            goto L1e
        L40:
            r0 = move-exception
            goto L58
        L42:
            goto L5f
        L44:
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r2 <= 0) goto L4e
            r3.close()     // Catch: java.lang.Exception -> L4d
        L4d:
            return r1
        L4e:
            r3.close()     // Catch: java.lang.Exception -> L62
            goto L62
        L52:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto L58
        L56:
            goto L5e
        L58:
            if (r3 == 0) goto L5d
            r3.close()     // Catch: java.lang.Exception -> L5d
        L5d:
            throw r0
        L5e:
            r3 = r0
        L5f:
            if (r3 == 0) goto L62
            goto L4e
        L62:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.di.c():java.util.Set");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d() {
        /*
            r0 = 0
            r1 = 0
            java.lang.String r2 = " netstat -apn | grep scrcpy "
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            java.lang.Process r2 = r3.exec(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
        L1a:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
            if (r1 == 0) goto L32
            java.lang.String r2 = "scrcpy"
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L30
            if (r1 == 0) goto L1a
            r3.close()     // Catch: java.lang.Exception -> L2b
        L2b:
            r0 = 1
            return r0
        L2d:
            r0 = move-exception
            r1 = r3
            goto L3c
        L30:
            goto L36
        L32:
            r3.close()     // Catch: java.lang.Exception -> L35
        L35:
            return r0
        L36:
            r1 = r3
            goto L42
        L38:
            r0 = move-exception
            goto L3c
        L3a:
            goto L42
        L3c:
            if (r1 == 0) goto L41
            r1.close()     // Catch: java.lang.Exception -> L41
        L41:
            throw r0
        L42:
            if (r1 == 0) goto L47
            r1.close()     // Catch: java.lang.Exception -> L47
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.di.d():int");
    }

    public static JSONObject e() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -an ").getInputStream()));
            try {
                JSONObject jSONObject = new JSONObject();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!readLine.contains("/") && !readLine.contains("@")) {
                    }
                    if (readLine.contains("/")) {
                        readLine = readLine.substring(readLine.indexOf("/"));
                    } else if (readLine.contains("@")) {
                        readLine = readLine.substring(readLine.indexOf("@"));
                    }
                    if (readLine.contains("/ddy")) {
                        jSONObject.put("0", readLine);
                    } else if (readLine.contains("scrcpy")) {
                        jSONObject.put("1", readLine);
                    } else if (readLine.contains("supersu")) {
                        jSONObject.put("2", readLine);
                    } else if (readLine.contains("/adbd")) {
                        jSONObject.put("3", readLine);
                    }
                }
                if (jSONObject.length() > 0) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused) {
                    }
                    return jSONObject;
                }
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                return null;
            } catch (Exception unused3) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused4) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        } catch (Exception unused6) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        String str2 = "";
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = "" + readLine;
            }
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return str2;
        } catch (Exception unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused4) {
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static String b() {
        try {
            String a2 = a(" pidof adbd ");
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            return a2.length() > 10 ? a2.substring(0, 10) : a2;
        } catch (Exception unused) {
            return null;
        }
    }
}
