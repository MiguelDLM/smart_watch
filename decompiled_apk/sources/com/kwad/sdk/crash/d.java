package com.kwad.sdk.crash;

import java.util.regex.Pattern;

/* loaded from: classes11.dex */
public final class d {
    public static final double aGR = Runtime.getRuntime().maxMemory();
    public static final Pattern aGS = Pattern.compile("/data/user");
    public static final Pattern aGT = Pattern.compile("/data");
    public static final Pattern aGU = Pattern.compile("/data/data/(.*)/data/.*");
    public static final Pattern aGV = Pattern.compile("/data/user/.*/(.*)/data/.*");
    public static int aGW = 20;
    public static String aGX = "sessionId";
}
