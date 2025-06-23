package com.google.firebase.crashlytics.buildtools.ndk.internal.breakpad;

import com.google.firebase.crashlytics.buildtools.Buildtools;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes10.dex */
public class BreakpadRecords {
    private final String architecture;
    private final String codeId;
    private final String moduleId;
    private final String name;
    private final String os;

    public BreakpadRecords(String str, String str2, String str3, String str4, String str5) {
        this.os = str;
        this.architecture = str2;
        this.moduleId = str3;
        this.name = str4;
        this.codeId = str5;
    }

    public static BreakpadRecords createFromBreakpadFile(File file) throws IOException {
        String str;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String[] split = bufferedReader.readLine().split(" ");
        if (split.length >= 5 && split[0].equals("MODULE")) {
            String[] strArr = new String[0];
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.startsWith("INFO")) {
                    strArr = readLine.split(" ");
                    break;
                }
            }
            bufferedReader.close();
            if (strArr.length >= 3) {
                str = strArr[2];
            } else {
                Buildtools.logW("Invalid or missing INFO line, no CODE_ID found for " + file.getAbsolutePath());
                str = null;
            }
            return new BreakpadRecords(split[1], split[2], split[3].toLowerCase(), split[4], str.toLowerCase());
        }
        throw new IOException("Could not find valid module record for Breakpad file: " + file.getAbsolutePath() + " Clean your build directory and try again. Contact Firebase support if the problem persists.");
    }

    public String getArchitecture() {
        return this.architecture;
    }

    public String getCodeId() {
        return this.codeId;
    }

    public String getModuleId() {
        return this.moduleId;
    }

    public String getName() {
        return this.name;
    }

    public String getOs() {
        return this.os;
    }
}
