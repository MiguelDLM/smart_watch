package com.baidu.tts.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes8.dex */
public final class PropUtil {
    public static String a(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            String readLine = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return readLine;
        } catch (IOException e3) {
            e = e3;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                    return "";
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return "";
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean needOfflineTag() {
        return "true".equalsIgnoreCase(a("log.tag.TTSLOG_OFFLINE"));
    }

    public static boolean needSaveAudio() {
        return "true".equalsIgnoreCase(a("log.tag.TTSLOG_SAVEAUDIO"));
    }

    public static boolean needSaveLog() {
        return "true".equalsIgnoreCase(a("log.tag.TTSLOG_SAVELOG"));
    }
}
