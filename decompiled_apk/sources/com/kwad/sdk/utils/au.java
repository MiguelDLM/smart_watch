package com.kwad.sdk.utils;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes11.dex */
public final class au {
    private static String aQL;
    private static String aQM;

    public static boolean MP() {
        return gS("EMUI");
    }

    public static boolean MQ() {
        return gS("MIUI");
    }

    public static boolean MR() {
        return gS("FLYME");
    }

    private static boolean gS(String str) {
        String str2 = aQL;
        if (str2 != null) {
            return str2.contains(str);
        }
        String str3 = bi.get(OI0.oxoX.f1511OOXIXo);
        aQM = str3;
        if (!TextUtils.isEmpty(str3)) {
            aQL = "OPPO";
        } else {
            String str4 = bi.get("ro.vivo.os.version");
            aQM = str4;
            if (!TextUtils.isEmpty(str4)) {
                aQL = oOoIIO0.oIX0oI.f32059ooOOo0oXI;
            } else {
                String str5 = bi.get(OI0.oxoX.f1509II0XooXoX);
                aQM = str5;
                if (!TextUtils.isEmpty(str5)) {
                    aQL = "EMUI";
                } else {
                    String str6 = bi.get("ro.miui.ui.version.name");
                    aQM = str6;
                    if (!TextUtils.isEmpty(str6)) {
                        aQL = "MIUI";
                    } else {
                        String str7 = bi.get("ro.product.system.manufacturer");
                        aQM = str7;
                        if (!TextUtils.isEmpty(str7)) {
                            aQL = "OnePlus";
                        } else {
                            String str8 = bi.get("ro.smartisan.version");
                            aQM = str8;
                            if (!TextUtils.isEmpty(str8)) {
                                aQL = "SMARTISAN";
                            } else if (bi.get("ro.product.manufacturer").toUpperCase().contains("SAMSUNG")) {
                                aQL = "SAMSUNG";
                            } else {
                                String str9 = Build.DISPLAY;
                                aQM = str9;
                                if (str9.toUpperCase().contains("FLYME")) {
                                    aQL = "FLYME";
                                } else {
                                    aQM = "unknown";
                                    aQL = Build.MANUFACTURER.toUpperCase();
                                }
                            }
                        }
                    }
                }
            }
        }
        return aQL.contains(str);
    }

    public static String getName() {
        if (aQL == null) {
            gS("");
        }
        return aQL;
    }

    public static String getVersion() {
        if (aQM == null) {
            gS("");
        }
        return aQM;
    }
}
