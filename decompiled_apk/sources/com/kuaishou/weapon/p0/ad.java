package com.kuaishou.weapon.p0;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes11.dex */
public class ad {
    private String a(String str) {
        int read;
        try {
            File file = new File(str);
            if (!file.exists() || !file.canRead()) {
                return null;
            }
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream = new FileInputStream(file);
            String str2 = null;
            do {
                read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                str2 = new String(bArr, 0, read);
            } while (read <= 0);
            fileInputStream.close();
            return str2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b() {
        if ("nokia".equalsIgnoreCase(Build.MANUFACTURER) && ("Nokia_N1".equalsIgnoreCase(Build.DEVICE) || "N1".equalsIgnoreCase(Build.MODEL))) {
            return false;
        }
        try {
            Process start = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream(), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            bufferedReader.close();
            String lowerCase = stringBuffer.toString().toLowerCase();
            if (!lowerCase.contains("intel") && !lowerCase.contains("x86")) {
                if (!lowerCase.contains("amd")) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean a() {
        try {
            String a2 = a("/proc/tty/drivers");
            boolean z = !TextUtils.isEmpty(a2) && a2.contains("goldfish");
            if (!z) {
                String a3 = a("/proc/cpuinfo");
                if (!TextUtils.isEmpty(a3)) {
                    if (a3.contains("goldfish")) {
                        return true;
                    }
                }
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }
}
