package xoIox;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cn;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MApiIMediationViewBinderReversal;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.Map;

/* loaded from: classes.dex */
public class x0XOIxOo {
    public static int I0Io(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static boolean II0XooXoX(MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (mediationAdSlotValueSet.getExtraObject() == null) {
            return false;
        }
        Object obj = mediationAdSlotValueSet.getExtraObject().get("dynamic_adapter_type");
        if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static int II0xO0(int i) {
        if (i != 1) {
            if (i != 2) {
                return -1;
            }
            return 3;
        }
        return 4;
    }

    public static String IXxxXO(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_ADN_NAME);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "other";
    }

    public static boolean OOXIXo(String str) {
        String XO2 = XO();
        if (TextUtils.isEmpty(XO2) || TextUtils.isEmpty(str) || XO2.compareTo(str) < 0) {
            return false;
        }
        return true;
    }

    public static int Oo(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adType");
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return 2;
    }

    public static boolean Oxx0IOOO(MediationAdLoaderImpl mediationAdLoaderImpl, MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean z;
        if (mediationAdLoaderImpl != null && mediationAdSlotValueSet != null) {
            boolean II0XooXoX2 = II0XooXoX(mediationAdSlotValueSet);
            boolean isClientBidding = mediationAdLoaderImpl.isClientBidding();
            boolean ooOOo0oXI2 = ooOOo0oXI(mediationAdSlotValueSet);
            if (mediationAdLoaderImpl.getBiddingType() == 0) {
                z = true;
                if ((!II0XooXoX2 && isClientBidding) || (ooOOo0oXI2 && z)) {
                    return true;
                }
            }
            z = false;
            if (!II0XooXoX2) {
            }
        }
        return false;
    }

    public static MediationViewBinder X0o0xo(Bridge bridge) {
        if (bridge == null) {
            return null;
        }
        MApiIMediationViewBinderReversal mApiIMediationViewBinderReversal = new MApiIMediationViewBinderReversal(bridge);
        return new MediationViewBinder.Builder(mApiIMediationViewBinderReversal.getLayoutId()).callToActionId(mApiIMediationViewBinderReversal.getCallToActionId()).addExtras(mApiIMediationViewBinderReversal.getExtras()).descriptionTextId(mApiIMediationViewBinderReversal.getDecriptionTextId()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage1Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage2Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage3Id()).iconImageId(mApiIMediationViewBinderReversal.getIconImageId()).mainImageId(mApiIMediationViewBinderReversal.getMainImageId()).mediaViewIdId(mApiIMediationViewBinderReversal.getMediaViewId()).logoLayoutId(mApiIMediationViewBinderReversal.getLogoLayoutId()).shakeViewContainerId(mApiIMediationViewBinderReversal.getShakeViewContainerId()).titleId(mApiIMediationViewBinderReversal.getTitleId()).sourceId(mApiIMediationViewBinderReversal.getSourceId()).build();
    }

    public static String XO() {
        try {
            return KsAdSDK.getSDKVersion();
        } catch (Throwable unused) {
            return cn.d;
        }
    }

    public static float oIX0oI(Context context, float f) {
        if (context == null) {
            return 0.0f;
        }
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int oO(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("failureCode");
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return 0;
    }

    public static long oOoXoXO(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("lossBidEcpm");
            if (obj instanceof Double) {
                return ((Double) obj).longValue();
            }
        }
        return 0L;
    }

    public static boolean ooOOo0oXI(MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (mediationAdSlotValueSet.getExtraObject() == null) {
            return false;
        }
        Object obj = mediationAdSlotValueSet.getExtraObject().get("wf_dynamic_adapter_type");
        if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static long oxoX(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("bidEcpm");
            if (obj instanceof Double) {
                return ((Double) obj).longValue();
            }
        }
        return 0L;
    }

    public static boolean x0XOIxOo(Object obj) {
        return xoIox(obj, "reportAdExposureFailed", Integer.TYPE, AdExposureFailedReason.class);
    }

    public static int x0xO0oo(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("bidEcpm");
            if (obj instanceof Double) {
                return ((Double) obj).intValue();
            }
        }
        return 0;
    }

    public static boolean xoIox(Object obj, String str, Class<?>... clsArr) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                obj.getClass().getMethod(str, clsArr);
                return true;
            } catch (NoSuchMethodException e) {
                MediationApiLog.i("-------ks_no_method --------- " + e.getMessage());
            }
        }
        return false;
    }

    public static boolean xxIXOIIO(Object obj) {
        Class cls = Long.TYPE;
        return xoIox(obj, "setBidEcpm", cls, cls);
    }
}
