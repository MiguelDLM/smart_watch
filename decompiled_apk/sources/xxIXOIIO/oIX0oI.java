package xxIXOIIO;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MApiIMediationViewBinderReversal;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import java.util.Map;

/* loaded from: classes.dex */
public class oIX0oI {

    /* renamed from: xxIXOIIO.oIX0oI$oIX0oI, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1187oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f35479oIX0oI;

        static {
            int[] iArr = new int[MediationConstant.BiddingLossReason.values().length];
            f35479oIX0oI = iArr;
            try {
                iArr[MediationConstant.BiddingLossReason.LOW_PRICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35479oIX0oI[MediationConstant.BiddingLossReason.TIME_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35479oIX0oI[MediationConstant.BiddingLossReason.NO_AD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35479oIX0oI[MediationConstant.BiddingLossReason.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static MediationViewBinder II0xO0(Bridge bridge) {
        if (bridge == null) {
            return null;
        }
        MApiIMediationViewBinderReversal mApiIMediationViewBinderReversal = new MApiIMediationViewBinderReversal(bridge);
        return new MediationViewBinder.Builder(mApiIMediationViewBinderReversal.getLayoutId()).callToActionId(mApiIMediationViewBinderReversal.getCallToActionId()).addExtras(mApiIMediationViewBinderReversal.getExtras()).descriptionTextId(mApiIMediationViewBinderReversal.getDecriptionTextId()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage1Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage2Id()).groupImage1Id(mApiIMediationViewBinderReversal.getGroupImage3Id()).iconImageId(mApiIMediationViewBinderReversal.getIconImageId()).mainImageId(mApiIMediationViewBinderReversal.getMainImageId()).mediaViewIdId(mApiIMediationViewBinderReversal.getMediaViewId()).logoLayoutId(mApiIMediationViewBinderReversal.getLogoLayoutId()).shakeViewContainerId(mApiIMediationViewBinderReversal.getShakeViewContainerId()).titleId(mApiIMediationViewBinderReversal.getTitleId()).sourceId(mApiIMediationViewBinderReversal.getSourceId()).build();
    }

    public static boolean Oxx0IOOO(MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (mediationAdSlotValueSet.getExtraObject() == null) {
            return false;
        }
        Object obj = mediationAdSlotValueSet.getExtraObject().get("wf_dynamic_adapter_type");
        if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean X0o0xo(MediationAdSlotValueSet mediationAdSlotValueSet) {
        Map<String, Object> params = mediationAdSlotValueSet.getParams();
        if (params == null) {
            return false;
        }
        Object obj = params.get(MediationConstant.BANNER_AUTO_HEIGHT);
        try {
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean XO(MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (mediationAdSlotValueSet.getExtraObject() == null) {
            return false;
        }
        Object obj = mediationAdSlotValueSet.getExtraObject().get("dynamic_adapter_type");
        if (!(obj instanceof Integer) || ((Integer) obj).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static int oIX0oI(MediationConstant.BiddingLossReason biddingLossReason) {
        if (biddingLossReason == null) {
            return 10001;
        }
        try {
            int i = C1187oIX0oI.f35479oIX0oI[biddingLossReason.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 10001;
                    }
                    return 2;
                }
                return 101;
            }
            return 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return 10001;
        }
    }

    public static boolean oxoX(MediationAdLoaderImpl mediationAdLoaderImpl, MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean z;
        if (mediationAdLoaderImpl != null && mediationAdSlotValueSet != null) {
            boolean XO2 = XO(mediationAdSlotValueSet);
            boolean isClientBidding = mediationAdLoaderImpl.isClientBidding();
            boolean Oxx0IOOO2 = Oxx0IOOO(mediationAdSlotValueSet);
            if (mediationAdLoaderImpl.getBiddingType() == 0) {
                z = true;
                if ((!XO2 && isClientBidding) || (Oxx0IOOO2 && z)) {
                    return true;
                }
            }
            z = false;
            if (!XO2) {
            }
        }
        return false;
    }

    public static void I0Io(MediationInitConfig mediationInitConfig) {
    }
}
