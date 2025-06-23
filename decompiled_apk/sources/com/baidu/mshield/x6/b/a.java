package com.baidu.mshield.x6.b;

import OoOoXO0.xoXoI;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.x6.e.f;
import com.garmin.fit.O0Xx;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.an;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.spi.LocationInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class a {
    @SuppressLint({"MissingPermission"})
    public static String a(Context context) {
        return "";
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String b(Context context) {
        return "";
    }

    public static void c(int i, String str, String str2, String str3, List<String> list) {
        try {
            if (i == 1) {
                if (!c(str) || list.contains(str2)) {
                    return;
                }
                list.add(str2);
                return;
            }
            if (i == 2) {
                if (c(str) || list.contains(str2)) {
                    return;
                }
                list.add(str2);
                return;
            }
            if (i != 6 || TextUtils.isEmpty(str3)) {
                return;
            }
            if (!str.contains(LocationInfo.NA)) {
                File[] listFiles = new File(str).listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                for (File file : listFiles) {
                    String name = file.getName();
                    if (name != null && name.contains(str3)) {
                        if (list.contains(str2)) {
                            return;
                        }
                        list.add(str2);
                        return;
                    }
                }
                return;
            }
            if (!a(str, str3, 2) || list.contains(str2)) {
                return;
            }
            list.add(str2);
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static void d(int i, String str, String str2, String str3, List<String> list) {
        try {
            if (i == 1) {
                if (!TextUtils.isEmpty(b(str)) && !list.contains(str2)) {
                    list.add(str2);
                }
            } else if (i == 2) {
                if (TextUtils.isEmpty(b(str)) && !list.contains(str2)) {
                    list.add(str2);
                }
            } else if (i == 3) {
                String b = b(str);
                if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(str3) && b.contains(str3) && !list.contains(str2)) {
                    list.add(str2);
                }
            } else {
                if (i != 4) {
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    String b2 = b(str);
                    if (!TextUtils.isEmpty(b2) && !TextUtils.isEmpty(str3) && b2.startsWith(str3) && !list.contains(str2)) {
                        list.add(str2);
                    }
                }
            }
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static void e(int i, String str, String str2, String str3, List<String> list) {
        try {
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData13===" + i + x.aL + str + x.aL + str2 + x.aL + str3);
            if (i == 0) {
                String[] split = str3.split("\\|");
                if (1 == a(str, split[0], split.length == 2 ? split[1].replace("$", xoXoI.f2670oxoX) : null)) {
                    list.add(str2);
                }
            }
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static void f(int i, String str, String str2, String str3, List<String> list) {
        try {
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData14===" + i + x.aL + str + x.aL + str2 + x.aL + str3);
            if (i == 0) {
                String[] split = str3.split("\\|");
                if (split.length != 2) {
                    return;
                }
                String str4 = (String) com.baidu.xclient.gdid.a.a(16, str, split[0], new long[]{Long.valueOf(split[1]).longValue(), d(str)});
                com.baidu.mshield.b.c.a.b("GH jniCtl ===" + str4);
                if ("1".equals(str4)) {
                    list.add(str2);
                }
            }
        } catch (Throwable th) {
            f.a(th);
        }
    }

    /* JADX WARN: Finally extract failed */
    public static List<String> a(String str) {
        String str2;
        int i;
        String str3;
        String str4;
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                try {
                    str2 = String.valueOf(jSONObject.getInt("eid"));
                } catch (Throwable th) {
                    f.a(th);
                    str2 = null;
                }
                int i3 = -1;
                try {
                    i = jSONObject.getInt("pattern");
                } catch (Throwable th2) {
                    f.a(th2);
                    i = -1;
                }
                try {
                    str3 = jSONObject.getString("item");
                } catch (Throwable th3) {
                    f.a(th3);
                    str3 = null;
                }
                try {
                    i3 = jSONObject.getInt("type");
                } catch (Throwable th4) {
                    f.a(th4);
                }
                try {
                    str4 = jSONObject.getString("value");
                } catch (Throwable th5) {
                    f.a(th5);
                    str4 = null;
                }
                if (i3 == 0 && !TextUtils.isEmpty(str3)) {
                    a(i, str3, str2, str4, arrayList);
                } else if (i3 == 1 && !TextUtils.isEmpty(str3)) {
                    b(i, str3, str2, str4, arrayList);
                } else if (i3 == 2 && !TextUtils.isEmpty(str3)) {
                    c(i, str3, str2, str4, arrayList);
                } else if (i3 == 3 && !TextUtils.isEmpty(str3)) {
                    d(i, str3, str2, str4, arrayList);
                } else if (i3 == 4 && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                    try {
                        fileReader = new FileReader(new File("/proc/cpuinfo"));
                        try {
                            bufferedReader = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    if (readLine.contains(str3)) {
                                        String a2 = a(readLine, str3);
                                        if (!TextUtils.isEmpty(a2) && a2.startsWith(str4)) {
                                            if (!arrayList.contains(str2)) {
                                                arrayList.add(str2);
                                            }
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    try {
                                        f.a(th);
                                        if (fileReader != null) {
                                            fileReader.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                    } catch (Throwable th7) {
                                        if (fileReader != null) {
                                            fileReader.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        throw th7;
                                    }
                                }
                            }
                            fileReader.close();
                            bufferedReader.close();
                        } catch (Throwable th8) {
                            th = th8;
                            bufferedReader = null;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        fileReader = null;
                        bufferedReader = null;
                    }
                } else if (i3 == 13 && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                    e(i, str3, str2, str4, arrayList);
                } else if (i3 == 14 && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                    f(i, str3, str2, str4, arrayList);
                }
            }
            return arrayList;
        } catch (Throwable th10) {
            f.a(th10);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0054, code lost:
    
        if (r7.contains(r5) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0056, code lost:
    
        r7.add(r5);
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(int r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.util.List<java.lang.String> r7) {
        /*
            r0 = 1
            if (r3 != r0) goto L17
            boolean r3 = c(r4)     // Catch: java.lang.Throwable -> L14
            if (r3 == 0) goto L89
            boolean r3 = r7.contains(r5)     // Catch: java.lang.Throwable -> L14
            if (r3 != 0) goto L89
            r7.add(r5)     // Catch: java.lang.Throwable -> L14
            goto L89
        L14:
            r3 = move-exception
            goto L86
        L17:
            r0 = 2
            if (r3 != r0) goto L2b
            boolean r3 = c(r4)     // Catch: java.lang.Throwable -> L14
            if (r3 != 0) goto L89
            boolean r3 = r7.contains(r5)     // Catch: java.lang.Throwable -> L14
            if (r3 != 0) goto L89
            r7.add(r5)     // Catch: java.lang.Throwable -> L14
            goto L89
        L2b:
            r0 = 3
            if (r3 != r0) goto L89
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L14
            if (r3 != 0) goto L89
            r3 = 0
            java.io.FileReader r0 = new java.io.FileReader     // Catch: java.lang.Throwable -> L68
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L68
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L68
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L68
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L63
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L63
        L44:
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L5a
            if (r3 == 0) goto L5c
            boolean r3 = r3.contains(r6)     // Catch: java.lang.Throwable -> L5a
            if (r3 == 0) goto L44
            boolean r3 = r7.contains(r5)     // Catch: java.lang.Throwable -> L5a
            if (r3 != 0) goto L5c
            r7.add(r5)     // Catch: java.lang.Throwable -> L5a
            goto L5c
        L5a:
            r3 = move-exception
            goto L6c
        L5c:
            r0.close()     // Catch: java.lang.Throwable -> L14
            r4.close()     // Catch: java.lang.Throwable -> L14
            goto L89
        L63:
            r4 = move-exception
            r2 = r4
            r4 = r3
            r3 = r2
            goto L6c
        L68:
            r4 = move-exception
            r0 = r3
            r3 = r4
            r4 = r0
        L6c:
            com.baidu.mshield.x6.e.f.a(r3)     // Catch: java.lang.Throwable -> L7a
            if (r0 == 0) goto L74
            r0.close()     // Catch: java.lang.Throwable -> L14
        L74:
            if (r4 == 0) goto L89
            r4.close()     // Catch: java.lang.Throwable -> L14
            goto L89
        L7a:
            r3 = move-exception
            if (r0 == 0) goto L80
            r0.close()     // Catch: java.lang.Throwable -> L14
        L80:
            if (r4 == 0) goto L85
            r4.close()     // Catch: java.lang.Throwable -> L14
        L85:
            throw r3     // Catch: java.lang.Throwable -> L14
        L86:
            com.baidu.mshield.x6.e.f.a(r3)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mshield.x6.b.a.b(int, java.lang.String, java.lang.String, java.lang.String, java.util.List):void");
    }

    public static long e(String str) {
        try {
            return Long.valueOf(str, 16).longValue();
        } catch (NumberFormatException e) {
            f.a(e);
            return O0Xx.f12378xXxxox0I;
        }
    }

    public static JSONObject f(String str) {
        String str2;
        int i;
        String str3;
        String str4;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 0) {
                return null;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                try {
                    str2 = String.valueOf(jSONObject2.getInt("eid"));
                } catch (Throwable th) {
                    f.a(th);
                    str2 = null;
                }
                int i3 = -1;
                try {
                    i = jSONObject2.getInt("pattern");
                } catch (Throwable th2) {
                    f.a(th2);
                    i = -1;
                }
                try {
                    str3 = jSONObject2.getString("item");
                } catch (Throwable th3) {
                    f.a(th3);
                    str3 = null;
                }
                try {
                    i3 = jSONObject2.getInt("type");
                } catch (Throwable th4) {
                    f.a(th4);
                }
                try {
                    str4 = jSONObject2.getString("value");
                } catch (Throwable th5) {
                    f.a(th5);
                    str4 = null;
                }
                if (i3 == 9 && !TextUtils.isEmpty(str3)) {
                    a(i, str3, str2, str4, jSONObject);
                } else if (i3 == 11 && !TextUtils.isEmpty(str3)) {
                    b(i, str3, str2, str4, jSONObject);
                } else if (i3 == 12 && !TextUtils.isEmpty(str3)) {
                    c(i, str3, str2, str4, jSONObject);
                } else if (i3 == 20 && !TextUtils.isEmpty(str3)) {
                    d(i, str3, str2, str4, jSONObject);
                }
            }
            return jSONObject;
        } catch (Throwable th6) {
            f.a(th6);
            return null;
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String a2 = com.baidu.xclient.gdid.a.a(str);
            com.baidu.mshield.b.c.a.b("GH getFileInode===" + a2);
            return !"-1".equals(new JSONObject(a2).optString("0"));
        } catch (Throwable th) {
            f.a(th);
            return false;
        }
    }

    public static long d(String str) {
        String readLine;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("proc/self/maps", "r");
            do {
                readLine = randomAccessFile.readLine();
                if (readLine == null) {
                    break;
                }
                readLine = readLine.trim();
            } while (!readLine.endsWith(str));
            long e = !TextUtils.isEmpty(readLine) ? e(readLine.split(HelpFormatter.DEFAULT_OPT_PREFIX)[0]) : 0L;
            randomAccessFile.close();
            return e;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static String b(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Throwable th) {
            f.a(th);
            return null;
        }
    }

    public static void b(int i, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData11 item=" + str);
            if (i == 0) {
                String str4 = (String) com.baidu.xclient.gdid.a.a(21, str, str3, (Object) null);
                jSONObject.put(str2, str4);
                com.baidu.mshield.b.c.a.b("hanldeEmulatorData11 pat=0, jniRet=" + str4);
            } else if (i == 1) {
                String str5 = (String) com.baidu.xclient.gdid.a.a(22, str, str3, (Object) null);
                jSONObject.put(str2, str5);
                com.baidu.mshield.b.c.a.b("hanldeEmulatorData11 pat=1, jniRet=" + str5);
            }
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static void c(int i, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData12 item=" + str);
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData12 value=" + str3);
            if (i == 0) {
                String str4 = (String) com.baidu.xclient.gdid.a.a(23, str, Integer.valueOf(Integer.parseInt(str3)), (Object) null);
                jSONObject.put(str2, str4);
                com.baidu.mshield.b.c.a.b("hanldeEmulatorData12 pat=0, jniRet=" + str4);
            }
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static void d(int i, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData20 item=" + str);
            if (i == 0) {
                String str4 = (String) com.baidu.xclient.gdid.a.a(24, str, str3, (Object) null);
                jSONObject.put(str2, str4);
                com.baidu.mshield.b.c.a.b("hanldeEmulatorData20 pat=0, jniRet=" + str4);
            } else if (i == 2) {
                String str5 = (String) com.baidu.xclient.gdid.a.a(25, str, str3, (Object) null);
                jSONObject.put(str2, str5);
                com.baidu.mshield.b.c.a.b("hanldeEmulatorData20 pat=2, jniRet=" + str5);
            } else if (i == 3) {
                String str6 = (String) com.baidu.xclient.gdid.a.a(26, str, str3, (Object) null);
                jSONObject.put(str2, str6);
                com.baidu.mshield.b.c.a.b("hanldeEmulatorData20 pat=3, jniRet=" + str6);
            }
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static void a(int i, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData9 item=" + str);
            String str4 = (String) com.baidu.xclient.gdid.a.a(10, str, str3, (Object) null);
            com.baidu.mshield.b.c.a.b("hanldeEmulatorData9 prop=" + str4);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put(str2, str4);
            } else {
                jSONObject.put(str2, "");
            }
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static void a(int i, String str, String str2, String str3, List<String> list) {
        try {
            if (i == 1) {
                if (str.contains("/")) {
                    try {
                        Class.forName(str.replace("/", FileUtils.FILE_EXTENSION_SEPARATOR), false, ClassLoader.getSystemClassLoader());
                        list.add(str2);
                    } catch (ClassNotFoundException e) {
                        f.a(e);
                    }
                }
                return;
            }
            if (i == 2) {
                try {
                    Class.forName(str.replace("/", FileUtils.FILE_EXTENSION_SEPARATOR), false, ClassLoader.getSystemClassLoader());
                } catch (ClassNotFoundException e2) {
                    f.a(e2);
                    list.add(str2);
                }
                return;
            }
            return;
        } catch (Throwable th) {
            f.a(th);
        }
        f.a(th);
    }

    public static boolean a(String str, String str2, int i) {
        int i2 = i - 1;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String replaceAll = str.replaceAll("\\?", "");
                File[] listFiles = new File(replaceAll).listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file : listFiles) {
                        String name = file.getName();
                        if (name != null && name.contains(str2)) {
                            return true;
                        }
                        if ((name == null || !name.equals(FileUtils.FILE_EXTENSION_SEPARATOR)) && ((name == null || !name.equals("..")) && i > 0)) {
                            File file2 = new File(replaceAll, file.getName());
                            if (file2.isDirectory()) {
                                return a(file2.getAbsolutePath(), str2, i2);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                f.a(th);
            }
        }
        return false;
    }

    public static String a(String str, String str2) {
        try {
            Matcher matcher = Pattern.compile("(?i)" + str2 + "\t*: (.*)").matcher(str);
            if (matcher.matches()) {
                return matcher.group(1);
            }
            return null;
        } catch (Throwable th) {
            f.a(th);
            return null;
        }
    }

    public static int a(String str, String str2, String str3) {
        Method declaredMethod;
        com.baidu.mshield.b.c.a.b("getAPH===" + str + x.aL + str2 + x.aL + str3);
        try {
            Class<?> cls = Class.forName(str);
            if (!TextUtils.isEmpty(str3)) {
                String[] split = str3.split(xoXoI.f2670oxoX);
                if (split != null && split.length > 0) {
                    Class<?>[] clsArr = new Class[split.length];
                    for (int i = 0; i < split.length; i++) {
                        clsArr[i] = Class.forName(split[i]);
                    }
                    declaredMethod = cls.getDeclaredMethod(str2, clsArr);
                } else {
                    declaredMethod = cls.getDeclaredMethod(str2, null);
                }
            } else {
                declaredMethod = cls.getDeclaredMethod(str2, null);
            }
            if (declaredMethod != null) {
                if (Modifier.isNative(declaredMethod.getModifiers())) {
                    return 1;
                }
            }
        } catch (Throwable th) {
            f.a(th);
        }
        try {
            Field declaredField = Class.forName(an.f18308a, true, ClassLoader.getSystemClassLoader()).getDeclaredField("methodCache");
            declaredField.setAccessible(true);
            HashMap hashMap = (HashMap) declaredField.get(null);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(xoXoI.f2670oxoX);
            stringBuffer.append(str2);
            Iterator it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                if (((String) it.next()).contains(stringBuffer.toString())) {
                    return 1;
                }
            }
        } catch (Throwable th2) {
            f.a(th2);
            com.baidu.mshield.b.c.a.b("getAPH exe===" + th2);
        }
        return 0;
    }
}
