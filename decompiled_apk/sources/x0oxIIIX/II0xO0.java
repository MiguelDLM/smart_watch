package x0oxIIIX;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tanx.exposer.achieve.AdMonitorType;
import java.util.Map;

/* loaded from: classes13.dex */
public class II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static int f34048oIX0oI = 9004;

    public static void I0Io(com.tanx.exposer.achieve.II0xO0 iI0xO0, int i, String str, boolean z, String str2) {
        String str3;
        if (iI0xO0 != null && iI0xO0.oOoXoXO() != null) {
            if (iI0xO0.oOoXoXO() == AdMonitorType.CLICK) {
                str3 = "tanx_click_request_fail";
            } else if (iI0xO0.oOoXoXO() == AdMonitorType.EXPOSE) {
                str3 = "tanx_expose_request_fail";
            } else {
                str3 = "tanx_interact_request_fail";
            }
            if (iI0xO0.xoIox() == null) {
                XOxoX.oIX0oI.oIX0oI(str3, "AdMonitorExtraParams is null");
                return;
            }
            Map<String, Object> XO2 = XOxoX.I0Io.XO(iI0xO0.xoIox());
            XO2.put("host", iI0xO0.oO());
            XO2.put("url_hash", iI0xO0.x0XOIxOo());
            XO2.put("isRetry", String.valueOf(z));
            XO2.put("retryType", str2);
            XO2.put("url", iI0xO0.OOXIXo());
            XO2.put("errorCode", String.valueOf(i));
            XO2.put(MediationConstant.KEY_ERROR_MSG, str);
            I0Io.oIX0oI(str3, XO2, false);
            return;
        }
        XOxoX.oIX0oI.oIX0oI("exposeRequestFail", "wrapper is null");
    }

    public static void II0XooXoX(xIx.oxoX oxox, AdMonitorType adMonitorType) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("tanx_request_duplicated_");
        if (adMonitorType != null) {
            str = adMonitorType.name();
        } else {
            str = "";
        }
        sb.append(str);
        String sb2 = sb.toString();
        if (oxox == null) {
            XOxoX.oIX0oI.oIX0oI(sb2, "AdMonitorExtraParams is null");
        } else {
            I0Io.oIX0oI(sb2, XOxoX.I0Io.XO(oxox), true);
        }
    }

    public static void II0xO0(int i) {
        f34048oIX0oI = i;
    }

    public static void Oxx0IOOO(xIx.oxoX oxox, AdMonitorType adMonitorType, String str, String str2) {
        String str3;
        if (adMonitorType == AdMonitorType.CLICK) {
            str3 = "tanx_click_request";
        } else if (adMonitorType == AdMonitorType.EXPOSE) {
            str3 = "tanx_expose_request";
        } else if (adMonitorType == AdMonitorType.INTERACT_DEDUPLICATION) {
            str3 = "tanx_interact_deduplication_request";
        } else {
            str3 = "tanx_interact_request";
        }
        if (oxox == null) {
            XOxoX.oIX0oI.oIX0oI(str3, "AdMonitorExtraParams is null");
            return;
        }
        Map<String, Object> XO2 = XOxoX.I0Io.XO(oxox);
        XO2.put("host", str);
        XO2.put("url_hash", str2);
        I0Io.oIX0oI(str3, XO2, true);
    }

    public static void X0o0xo(xIx.oxoX oxox, AdMonitorType adMonitorType) {
        String str;
        if (adMonitorType == AdMonitorType.CLICK) {
            str = "tanx_click_invoke_success";
        } else if (adMonitorType == AdMonitorType.EXPOSE) {
            str = "tanx_expose_invoke_success";
        } else {
            str = "tanx_interact_invoke_success";
        }
        if (oxox == null) {
            XOxoX.oIX0oI.oIX0oI(str, "AdMonitorExtraParams is null");
        } else {
            I0Io.oIX0oI(str, XOxoX.I0Io.XO(oxox), true);
        }
    }

    public static void XO(xIx.oxoX oxox, AdMonitorType adMonitorType, String str) {
        String str2;
        if (adMonitorType == AdMonitorType.CLICK) {
            str2 = "tanx_click_invoke_error";
        } else if (adMonitorType == AdMonitorType.EXPOSE) {
            str2 = "tanx_expose_invoke_error";
        } else {
            str2 = "tanx_interact_invoke_error";
        }
        if (oxox == null) {
            XOxoX.oIX0oI.oIX0oI(str2, "AdMonitorExtraParams is null");
            return;
        }
        Map<String, Object> XO2 = XOxoX.I0Io.XO(oxox);
        XO2.put(MediationConstant.KEY_ERROR_MSG, str);
        I0Io.oIX0oI(str2, XO2, true);
    }

    public static int oIX0oI() {
        return f34048oIX0oI;
    }

    public static void oxoX(com.tanx.exposer.achieve.II0xO0 iI0xO0, boolean z, String str) {
        String str2;
        if (iI0xO0 != null && iI0xO0.oOoXoXO() != null) {
            if (iI0xO0.oOoXoXO() == AdMonitorType.CLICK) {
                str2 = "tanx_click_request_success";
            } else if (iI0xO0.oOoXoXO() == AdMonitorType.EXPOSE) {
                str2 = "tanx_expose_request_success";
            } else {
                str2 = "tanx_interact_request_success";
            }
            if (iI0xO0.xoIox() == null) {
                XOxoX.oIX0oI.oIX0oI(str2, "AdMonitorExtraParams is null");
                return;
            }
            Map<String, Object> XO2 = XOxoX.I0Io.XO(iI0xO0.xoIox());
            XO2.put("host", iI0xO0.oO());
            XO2.put("url_hash", iI0xO0.x0XOIxOo());
            XO2.put("isRetry", String.valueOf(z));
            XO2.put("retryType", str);
            I0Io.oIX0oI(str2, XO2, false);
            return;
        }
        XOxoX.oIX0oI.oIX0oI("exposeRequestSuccess", "wrapper is null");
    }

    public static void xxIXOIIO(xIx.oxoX oxox, AdMonitorType adMonitorType, String str) {
        String str2;
        if (adMonitorType == AdMonitorType.CLICK) {
            str2 = "tanx_click_invalid_url";
        } else if (adMonitorType == AdMonitorType.EXPOSE) {
            str2 = "tanx_expose_invalid_url";
        } else if (adMonitorType == AdMonitorType.INTERACT_DEDUPLICATION) {
            str2 = "tanx_interact_deduplication_invalid_url";
        } else {
            str2 = "tanx_interact_invalid_url";
        }
        if (oxox == null) {
            XOxoX.oIX0oI.oIX0oI(str2, "AdMonitorExtraParams is null");
            return;
        }
        Map<String, Object> XO2 = XOxoX.I0Io.XO(oxox);
        XO2.put(MediationConstant.KEY_ERROR_MSG, str);
        I0Io.oIX0oI(str2, XO2, true);
    }
}
