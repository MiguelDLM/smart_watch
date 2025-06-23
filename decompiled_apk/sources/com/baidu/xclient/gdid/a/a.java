package com.baidu.xclient.gdid.a;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.e;
import com.baidu.xclient.gdid.e.d;
import com.baidu.xclient.gdid.f;
import com.kuaishou.weapon.p0.g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.UUID;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f10222a;

    public static String a(Context context) {
        try {
        } catch (Throwable th) {
            d.a(th);
            f10222a = "";
        }
        if (!TextUtils.isEmpty(f10222a)) {
            return f10222a;
        }
        String b = b(context);
        f10222a = b;
        if (TextUtils.isEmpty(b)) {
            String c = c(context);
            f10222a = c;
            if (TextUtils.isEmpty(c)) {
                f10222a = f.a().m();
            }
        }
        if (TextUtils.isEmpty(f10222a)) {
            String a2 = e.a(UUID.randomUUID().toString());
            f10222a = a2;
            String str = new String(Base64.encode(com.baidu.xclient.gdid.a.a(a2.getBytes("UTF-8"), com.baidu.mshield.b.f.a.a(16)), 10), "UTF-8");
            f.a().c(str);
            a(context, str);
            b(context, str);
        } else {
            f10222a = new String(com.baidu.xclient.gdid.a.b(Base64.decode(f10222a, 10), com.baidu.mshield.b.f.a.a(16)), "UTF-8");
        }
        return f10222a;
    }

    public static String b(Context context) {
        try {
            return com.baidu.mshield.b.e.a.a(context, "setting_gdidv", false);
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static String c(Context context) {
        try {
            if (context.checkPermission(g.i, Process.myPid(), Process.myUid()) == -1) {
                return "";
            }
            File a2 = com.baidu.mshield.b.e.a.a(context, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/.gdidv");
            if (a2 == null) {
                return null;
            }
            FileReader fileReader = new FileReader(a2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    fileReader.close();
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
    }

    public static void a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context.checkPermission("android.permission.WRITE_SETTINGS", Process.myPid(), Process.myUid()) == 0) {
                com.baidu.mshield.b.e.a.a(context, "setting_gdidv", str);
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static void b(Context context, String str) {
        Throwable th;
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        try {
            if (TextUtils.isEmpty(str) || context.checkPermission(g.j, Process.myPid(), Process.myUid()) == -1) {
                return;
            }
            FileLock fileLock = null;
            try {
                File a2 = com.baidu.mshield.b.e.a.a(context, Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "backups/.gdidv");
                if (a2 != null) {
                    File parentFile = a2.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdir();
                    }
                    if (!a2.exists()) {
                        a2.createNewFile();
                    }
                    byte[] bytes = str.getBytes();
                    fileOutputStream = new FileOutputStream(a2);
                    try {
                        fileChannel = fileOutputStream.getChannel();
                        try {
                            fileLock = fileChannel.tryLock();
                            if (fileLock != null && fileLock.isValid()) {
                                fileOutputStream.write(bytes);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                d.a(th);
                                if (fileLock != null) {
                                    try {
                                        fileLock.release();
                                    } catch (Throwable th3) {
                                        th = th3;
                                        d.a(th);
                                        return;
                                    }
                                }
                                if (fileChannel != null) {
                                    fileChannel.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                    return;
                                }
                                return;
                            } finally {
                                if (fileLock != null) {
                                    try {
                                    } catch (Throwable th4) {
                                    }
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileChannel = null;
                    }
                } else {
                    fileChannel = null;
                    fileOutputStream = null;
                }
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Throwable th6) {
                        th = th6;
                        d.a(th);
                        return;
                    }
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th7) {
                th = th7;
                fileChannel = null;
                fileOutputStream = null;
            }
        } catch (Throwable th8) {
            d.a(th8);
        }
    }
}
