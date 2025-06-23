package com.bomdic.gomoreedgekit;

import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import com.bomdic.gomoreedgekit.data.GMCoachUserInfo;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class GMBase {

    @OOXIXo
    public static final GMBase INSTANCE = new GMBase();

    private GMBase() {
    }

    @x0XOIxOo
    private static final native int jniCoachUserInfoInit(GMCoachUserInfo gMCoachUserInfo, int i, String str, String str2);

    @x0XOIxOo
    private static final native String jniWellnessSdkBuildSubVersion();

    @x0XOIxOo
    private static final native String jniWellnessSdkVersion();

    @OOXIXo
    public final String coachVersion() {
        return jniWellnessSdkVersion() + " Build " + jniWellnessSdkBuildSubVersion();
    }

    @OOXIXo
    public final int[] releaseVersion() {
        return new int[]{1, 1, 0, 20240606};
    }

    public final int setupPlan$kit_release(@OOXIXo GMCoachUserInfo gmCoachUserInfo, int i, @OOXIXo String newTrainingChecksum, @OOXIXo String initTrainingChecksum) {
        IIX0o.x0xO0oo(gmCoachUserInfo, "gmCoachUserInfo");
        IIX0o.x0xO0oo(newTrainingChecksum, "newTrainingChecksum");
        IIX0o.x0xO0oo(initTrainingChecksum, "initTrainingChecksum");
        return jniCoachUserInfoInit(gmCoachUserInfo, i, newTrainingChecksum, initTrainingChecksum);
    }
}
