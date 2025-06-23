package com.google.firebase.crashlytics.buildtools;

import java.io.File;

/* loaded from: classes10.dex */
public class AppBuildInfo {
    private final File buildDir;
    private final String googleAppId;
    private final String packageName;

    public AppBuildInfo(String str, String str2, File file) {
        this.packageName = str;
        this.googleAppId = str2;
        this.buildDir = file;
    }

    public File getBuildDir() {
        return this.buildDir;
    }

    public String getGoogleAppId() {
        return this.googleAppId;
    }

    public String getPackageName() {
        return this.packageName;
    }
}
