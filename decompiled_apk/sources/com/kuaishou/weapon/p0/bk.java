package com.kuaishou.weapon.p0;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* loaded from: classes11.dex */
public class bk {

    /* renamed from: a, reason: collision with root package name */
    private static final String f18332a = "/proc/cpuinfo";

    public static String a() {
        try {
            String str = Build.CPU_ABI;
            String str2 = Build.CPU_ABI2;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (!TextUtils.isEmpty(str2)) {
                sb.append(com.huawei.openalliance.ad.constant.x.aL + str2);
            }
            String a2 = bh.a("ro.product.cpu.abilist");
            if (!TextUtils.isEmpty(a2)) {
                sb.append(com.huawei.openalliance.ad.constant.x.aL + a2);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static bj b() {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        String[] split;
        try {
            fileInputStream = new FileInputStream(new File(f18332a));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Throwable unused) {
                    bufferedReader = null;
                }
            } catch (Throwable unused2) {
                inputStreamReader = null;
                bufferedReader = null;
            }
        } catch (Throwable unused3) {
            inputStreamReader = null;
            fileInputStream = null;
            bufferedReader = null;
        }
        try {
            bj bjVar = new bj();
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (!TextUtils.isEmpty(readLine)) {
                        if (readLine.contains("Processor")) {
                            String[] split2 = readLine.split(":");
                            if (split2 != null) {
                                String trim = split2[1].trim();
                                if (!TextUtils.isEmpty(trim)) {
                                    bjVar.b(trim);
                                }
                            }
                        }
                        if (readLine.contains("processor")) {
                            String[] split3 = readLine.split(":");
                            if (split3 != null) {
                                String trim2 = split3[1].trim();
                                if (!TextUtils.isEmpty(trim2)) {
                                    i = Integer.parseInt(trim2) + 1;
                                }
                            }
                        }
                        if (readLine.contains("Hardware") && (split = readLine.split(":")) != null) {
                            String str = split[1];
                            if (!TextUtils.isEmpty(str)) {
                                bjVar.a(str);
                            }
                        }
                    }
                } else {
                    bjVar.a(i);
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    return bjVar;
                }
            }
        } catch (Throwable unused4) {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        }
    }
}
