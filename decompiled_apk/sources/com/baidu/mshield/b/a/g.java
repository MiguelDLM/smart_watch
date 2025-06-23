package com.baidu.mshield.b.a;

import OI0.oxoX;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.sec.privacy.d.h;
import java.util.HashMap;
import oOoIIO0.oIX0oI;

/* loaded from: classes7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f6366a = new HashMap<>();

    public static String a(Context context) {
        return com.baidu.sec.privacy.c.a.a(context).g();
    }

    public static String b() {
        return a("arv");
    }

    public static String c(Context context) {
        try {
            String a2 = a(context);
            String a3 = h.a("ro.build.display.id", "");
            if (TextUtils.isEmpty(a2)) {
                return a3;
            }
            if (a2.equalsIgnoreCase("HUAWEI")) {
                return h.a(oxoX.f1509II0XooXoX, a3);
            }
            if (a2.equalsIgnoreCase(oIX0oI.f32057oO)) {
                return h.a(oxoX.f1519xoIox, a3);
            }
            if (a2.equalsIgnoreCase("OPPO")) {
                return h.a(oxoX.f1511OOXIXo, a3);
            }
            if (a2.equalsIgnoreCase(oIX0oI.f32059ooOOo0oXI)) {
                return h.a("ro.vivo.rom.version", a3);
            }
            if (a2.equalsIgnoreCase("BBK")) {
                return h.a("ro.build.version.bbk", a3);
            }
            if (a2.equalsIgnoreCase("MEIZU")) {
                return h.a(oxoX.f1519xoIox, a3);
            }
            if (a2.equalsIgnoreCase("SAMSUNG")) {
                return a3;
            }
            if (a2.equalsIgnoreCase("GiONEE")) {
                return a3;
            }
            if (a2.equalsIgnoreCase("ZTE")) {
                String a4 = h.a("ro.build.rom.id", a3);
                if (a3.equals(a4)) {
                    String a5 = h.a("apps.setting.product.release", a3);
                    if (a3.equals(a5)) {
                        return h.a("ro.bliss.display.version", a3);
                    }
                    return a5;
                }
                return a4;
            }
            if (!a2.equalsIgnoreCase("LeMobile") && !a2.equalsIgnoreCase("Letv")) {
                if (a2.equalsIgnoreCase("LENOVO")) {
                    String a6 = a();
                    if (!TextUtils.isEmpty(a6)) {
                        if (a6.equalsIgnoreCase("Lenovo A5800-D")) {
                            return h.a("ro.build.cmccdisplay.id", a3);
                        }
                        if (a6.equalsIgnoreCase("Lenovo K900")) {
                            return h.a(oxoX.f1519xoIox, a3);
                        }
                    }
                } else {
                    if (a2.equalsIgnoreCase("YuLong")) {
                        return a3;
                    }
                    if (a2.equalsIgnoreCase("OnePlus")) {
                        return h.a("ro.rom.version", a3);
                    }
                    if (a2.equalsIgnoreCase("QiKU")) {
                        return h.a("ro.build.uiversion", a3);
                    }
                    if (a2.equalsIgnoreCase("nubia")) {
                        return h.a("ro.build.rom.id", a3);
                    }
                    if (a2.equalsIgnoreCase("motorola")) {
                        return a3;
                    }
                    if (a2.equalsIgnoreCase("HTC")) {
                        return h.a("ro.build.sense.version", a3);
                    }
                    if (a2.equalsIgnoreCase("ZUK")) {
                        return h.a(oxoX.f1519xoIox, a3);
                    }
                    if (a2.equalsIgnoreCase("K-Touch")) {
                        return h.a("ro.yunos.version", a3);
                    }
                    if (a2.equalsIgnoreCase("MeiTu")) {
                        return h.a("ro.build.version.meios", a3);
                    }
                    if (a2.equalsIgnoreCase("DOOV")) {
                        return h.a("ro.fota.version", a3);
                    }
                    if (a2.equalsIgnoreCase("hisense")) {
                        String a7 = a();
                        if (!TextUtils.isEmpty(a7)) {
                            if (a7.equalsIgnoreCase("hisense e76")) {
                                return h.a("ro.hs.ui.style", a3);
                            }
                            if (a7.equalsIgnoreCase("hisense e51-m")) {
                                return h.a("hw.cabl.version", a3);
                            }
                        }
                    } else {
                        if (a2.equalsIgnoreCase("Changhong")) {
                            return h.a("ro.fota.version", a3);
                        }
                        if (a2.equalsIgnoreCase("smartisan")) {
                            return h.a("ro.smartisan.version", a3);
                        }
                        if (a2.equalsIgnoreCase("NM")) {
                            return h.a("ro.xh.display.version", a3);
                        }
                        if (a2.equalsIgnoreCase("HONOR")) {
                            return h.a(oxoX.f1509II0XooXoX, a3);
                        }
                        if (a2.equalsIgnoreCase("REALME")) {
                            return h.a(oxoX.f1511OOXIXo, a3);
                        }
                    }
                }
                return a3;
            }
            return h.a("ro.letv.release.version", a3);
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return "";
        }
    }

    public static String a() {
        return a("mod");
    }

    public static String b(Context context) {
        String a2;
        try {
            a2 = a(context);
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
        }
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        if (a2.equalsIgnoreCase("HUAWEI")) {
            return "EmotionUI";
        }
        if (a2.equalsIgnoreCase("HONOR")) {
            return "MagicUI";
        }
        if (a2.equalsIgnoreCase(oIX0oI.f32057oO)) {
            return h.a("ro.miui.ui.version.name", "MIUI");
        }
        if (a2.equalsIgnoreCase("OPPO")) {
            return "ColorOS";
        }
        if (a2.equalsIgnoreCase(oIX0oI.f32059ooOOo0oXI)) {
            return h.a("ro.vivo.os.name", "Funtouch");
        }
        if (a2.equalsIgnoreCase("BBK")) {
            return "BBK";
        }
        if (a2.equalsIgnoreCase("MEIZU")) {
            return h.a("ro.build.user", "Flyme");
        }
        if (a2.equalsIgnoreCase("samsung")) {
            return "SAMSUNG";
        }
        if (a2.equalsIgnoreCase("GiONEE")) {
            return h.a("ro.build.display.id", "Amigo");
        }
        if (a2.equalsIgnoreCase("ZTE")) {
            String a3 = a();
            return (TextUtils.isEmpty(a3) || !a3.equalsIgnoreCase("X9180")) ? h.a("ro.build.nubia.rom.name", "ZTE") : "Bliss";
        }
        if (a2.equalsIgnoreCase("LeMobile") || a2.equalsIgnoreCase("Letv")) {
            return "EUI";
        }
        if (a2.equalsIgnoreCase("LENOVO")) {
            return "LENOVO";
        }
        if (a2.equalsIgnoreCase("YuLong")) {
            return "COOLUI";
        }
        if (a2.equalsIgnoreCase("OnePlus")) {
            return "H2OS";
        }
        if (a2.equalsIgnoreCase("QiKU")) {
            return "QIKU";
        }
        if (a2.equalsIgnoreCase("nubia")) {
            return h.a("ro.build.nubia.rom.name", "NUBIAUI");
        }
        if (a2.equalsIgnoreCase("motorola")) {
            return "MOTOROLA";
        }
        if (a2.equalsIgnoreCase("HTC")) {
            return "HTC Sense";
        }
        if (a2.equalsIgnoreCase("ZUK")) {
            return "ZUI";
        }
        if (a2.equalsIgnoreCase("coolpad")) {
            return "COOLPAD";
        }
        if (a2.equalsIgnoreCase("360")) {
            return h.a("ro.build.uiversion", "360");
        }
        if (a2.equalsIgnoreCase("K-Touch")) {
            return "KTOUCH";
        }
        if (a2.equalsIgnoreCase("MeiTu")) {
            return h.a("ro.build.user", "MEITU");
        }
        if (a2.equalsIgnoreCase("DOOV")) {
            return h.a("ro.fota.oem", "DOOV");
        }
        if (a2.equalsIgnoreCase("TCL")) {
            return "TCL";
        }
        if (a2.equalsIgnoreCase("Yota Devices Limited")) {
            return "Yota";
        }
        if (a2.equalsIgnoreCase("lge")) {
            return h.a("ro.build.product", "LGE");
        }
        return a2.equalsIgnoreCase("hisense") ? "VISION" : a2.equalsIgnoreCase("Changhong") ? "CHANGHONG" : a2.equalsIgnoreCase("Sony") ? "Sony" : a2.equalsIgnoreCase("smartisan") ? "smartisan" : a2.equalsIgnoreCase("NM") ? "newman" : a2.equalsIgnoreCase("REALME") ? "realmeUI" : "";
    }

    public static String a(String str) {
        try {
            HashMap<String, String> hashMap = f6366a;
            if (hashMap.size() <= 0) {
                return "";
            }
            synchronized (hashMap) {
                try {
                    if (!hashMap.containsKey(str)) {
                        return "";
                    }
                    return hashMap.get(str);
                } finally {
                }
            }
        } catch (Throwable th) {
            com.baidu.sec.privacy.d.c.a(th);
            return "";
        }
    }

    public static void a(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            HashMap<String, String> hashMap2 = f6366a;
            synchronized (hashMap2) {
                hashMap2.putAll(hashMap);
            }
        }
    }

    public static void b(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            try {
                if (hashMap.size() == 0) {
                    return;
                }
                synchronized (f6366a) {
                    try {
                        for (String str : hashMap.keySet()) {
                            f6366a.put(str, hashMap.get(str));
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                com.baidu.sec.privacy.d.c.a(th);
            }
        }
    }
}
