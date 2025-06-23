package com.kwad.sdk.utils;

import android.location.Location;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes11.dex */
public final class av {
    private static boolean MS() {
        if (!com.kwad.framework.a.a.md.booleanValue()) {
            return false;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    public static boolean MT() {
        KsCustomController ksCustomController;
        if (MS()) {
            return true;
        }
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                if (!ksCustomController.canReadLocation()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static Location MU() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                return ksCustomController.getLocation();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String MV() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                return ksCustomController.getImei();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] MW() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable unused) {
        }
        return new String[]{"", ""};
    }

    public static String MX() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                return ksCustomController.getAndroidId();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean MY() {
        KsCustomController ksCustomController;
        if (MS()) {
            return true;
        }
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                if (!ksCustomController.canUseMacAddress()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String MZ() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                return ksCustomController.getMacAddress();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean Na() {
        KsCustomController ksCustomController;
        if (MS()) {
            return true;
        }
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                if (!ksCustomController.canUseOaid()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String Nb() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                return ksCustomController.getOaid();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean Nc() {
        KsCustomController ksCustomController;
        if (MS()) {
            return true;
        }
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                if (!ksCustomController.canUseNetworkState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean Nd() {
        KsCustomController ksCustomController;
        if (MS()) {
            return true;
        }
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                if (!ksCustomController.canUseStoragePermission()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean Ne() {
        KsCustomController ksCustomController;
        if (MS()) {
            return true;
        }
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                if (!ksCustomController.canReadInstalledPackages()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static List<String> Nf() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    public static boolean usePhoneStateDisable() {
        KsCustomController ksCustomController;
        if (MS()) {
            return true;
        }
        try {
            SdkConfig Lx = ServiceProvider.Lx();
            if (Lx != null && (ksCustomController = Lx.ksCustomController) != null) {
                if (!ksCustomController.canUsePhoneState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
