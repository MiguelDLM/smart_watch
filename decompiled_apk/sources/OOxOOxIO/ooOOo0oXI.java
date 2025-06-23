package OOxOOxIO;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ar.base.MsgField;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class ooOOo0oXI implements Bridge {

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f1866Oo;

    /* renamed from: XO, reason: collision with root package name */
    public NativeUnifiedADData f1868XO;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public volatile boolean f1865IXxxXO = false;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public NativeADMediaListener f1867Oxx0xo = new oIX0oI();

    public ooOOo0oXI(NativeUnifiedADData nativeUnifiedADData) {
        this.f1868XO = nativeUnifiedADData;
    }

    private void II0xO0(int i) {
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.sendWinNotification(i);
        }
    }

    private String IIXOooo() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null && (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) != null) {
            return appMiitInfo.getPermissionsUrl();
        }
        return "";
    }

    private String IXxxXO() {
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null) {
            return nativeUnifiedADData.getCTAText();
        }
        return "";
    }

    private String O0xOxO() {
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null) {
            return nativeUnifiedADData.getTitle();
        }
        return "";
    }

    private Map<String, Object> OOXIXo() {
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null) {
            return nativeUnifiedADData.getExtraInfo();
        }
        return null;
    }

    private String Oo() {
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null) {
            return nativeUnifiedADData.getIconUrl();
        }
        return "";
    }

    private String OxI() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null && (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) != null) {
            return appMiitInfo.getAppName();
        }
        return "";
    }

    private String Oxx0xo() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null && (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) != null) {
            return appMiitInfo.getDescriptionUrl();
        }
        return "";
    }

    private String OxxIIOOXO() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null && (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) != null) {
            return appMiitInfo.getPrivacyAgreement();
        }
        return "";
    }

    private String X0IIOO() {
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null) {
            return nativeUnifiedADData.getDesc();
        }
        return "";
    }

    private void X0o0xo(Map<String, Object> map) {
        if (map != null && this.f1868XO != null) {
            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
            if (obj instanceof MediationConstant.BiddingLossReason) {
                this.f1868XO.sendLossNotification(0, xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj), null);
            }
        }
    }

    private String o00() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null && (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) != null) {
            return appMiitInfo.getAuthorName();
        }
        return "";
    }

    private String oI0IIXIo() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null && (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) != null) {
            return appMiitInfo.getVersionName();
        }
        return "";
    }

    private void oO() {
        this.f1868XO.setNativeAdEventListener(new II0xO0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oOoXoXO() {
        Bridge bridge = this.f1866Oo;
        if (bridge != null) {
            bridge.call(60020, null, Void.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ooOOo0oXI() {
        Bridge bridge = this.f1866Oo;
        if (bridge != null) {
            bridge.call(60019, null, Void.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0XOIxOo() {
        Bridge bridge = this.f1866Oo;
        if (bridge != null) {
            bridge.call(60018, null, Void.class);
        }
    }

    private String x0xO0oo() {
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null) {
            return nativeUnifiedADData.getImgUrl();
        }
        return "";
    }

    private void xoIox() {
        this.f1865IXxxXO = true;
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
            this.f1868XO = null;
        }
    }

    private long xoXoI() {
        NativeUnifiedADAppMiitInfo appMiitInfo;
        NativeUnifiedADData nativeUnifiedADData = this.f1868XO;
        if (nativeUnifiedADData != null && (appMiitInfo = nativeUnifiedADData.getAppMiitInfo()) != null) {
            return appMiitInfo.getPackageSizeBytes();
        }
        return 0L;
    }

    public void II0XooXoX() {
        Bridge bridge = this.f1866Oo;
        if (bridge != null) {
            bridge.call(60005, null, Void.class);
        }
    }

    public void XO() {
        Bridge bridge = this.f1866Oo;
        if (bridge != null) {
            bridge.call(60004, null, Void.class);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v107, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v108, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v109, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v110, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v111, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v112, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v113, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v114, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v115, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v118, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v119, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v152 */
    /* JADX WARN: Type inference failed for: r13v153 */
    /* JADX WARN: Type inference failed for: r13v80, types: [T, java.lang.String] */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        NativeUnifiedADData nativeUnifiedADData;
        if (i == 40038) {
            ?? r13 = (T) OxI();
            OxxIIOOXO.oIX0oI("getAppName appName = " + ((String) r13));
            return r13;
        }
        if (i == 40039) {
            ?? r132 = (T) o00();
            OxxIIOOXO.oIX0oI("getAuthorName authorName = " + ((String) r132));
            return r132;
        }
        if (i == 40040) {
            long xoXoI2 = xoXoI();
            OxxIIOOXO.oIX0oI("getPackageSizeBytes packageSize = " + xoXoI2);
            return (T) Long.valueOf(xoXoI2);
        }
        if (i == 40041) {
            ?? r133 = (T) IIXOooo();
            OxxIIOOXO.oIX0oI("getPermissionsUrl permissionsUrl = " + ((String) r133));
            return r133;
        }
        if (i == 40042) {
            ?? r134 = (T) OxxIIOOXO();
            OxxIIOOXO.oIX0oI("getPrivacyAgreement privacyAgreement = " + ((String) r134));
            return r134;
        }
        if (i == 40044) {
            ?? r135 = (T) Oxx0xo();
            OxxIIOOXO.oIX0oI("getDescriptionUrl descriptionUrl = " + ((String) r135));
            return r135;
        }
        if (i == 40043) {
            ?? r136 = (T) oI0IIXIo();
            OxxIIOOXO.oIX0oI("getVersionName versionName = " + ((String) r136));
            return r136;
        }
        if (i == 40032) {
            ?? r137 = (T) O0xOxO();
            OxxIIOOXO.oIX0oI("getTitle title = " + ((String) r137));
            return r137;
        }
        if (i == 40033) {
            ?? r138 = (T) X0IIOO();
            OxxIIOOXO.oIX0oI("desc title = " + ((String) r138));
            return r138;
        }
        if (i == 40045) {
            ?? r139 = (T) IXxxXO();
            OxxIIOOXO.oIX0oI("getCTAText ctaTest = " + ((String) r139));
            return r139;
        }
        if (i == 40046) {
            ?? r1310 = (T) Oo();
            OxxIIOOXO.oIX0oI("getIconUrl iconUrl = " + ((String) r1310));
            return r1310;
        }
        if (i == 40047) {
            ?? r1311 = (T) x0xO0oo();
            OxxIIOOXO.oIX0oI("getImgUrl imgUrl = " + ((String) r1311));
            return r1311;
        }
        if (i == 40048) {
            NativeUnifiedADData nativeUnifiedADData2 = this.f1868XO;
            int pictureWidth = nativeUnifiedADData2 != null ? nativeUnifiedADData2.getPictureWidth() : 0;
            OxxIIOOXO.oIX0oI("getPictureWidth width = " + pictureWidth);
            return (T) Integer.valueOf(pictureWidth);
        }
        if (i == 40049) {
            NativeUnifiedADData nativeUnifiedADData3 = this.f1868XO;
            int pictureHeight = nativeUnifiedADData3 != null ? nativeUnifiedADData3.getPictureHeight() : 0;
            OxxIIOOXO.oIX0oI("getPictureHeight height = " + pictureHeight);
            return (T) Integer.valueOf(pictureHeight);
        }
        if (i == 40050) {
            NativeUnifiedADData nativeUnifiedADData4 = this.f1868XO;
            T t = nativeUnifiedADData4 != null ? (T) nativeUnifiedADData4.getImgList() : (T) new ArrayList(0);
            StringBuilder sb = new StringBuilder();
            sb.append("getImgList list = ");
            sb.append(t);
            sb.append(" list.size = ");
            sb.append(t != null ? ((List) t).size() : 0);
            OxxIIOOXO.oIX0oI(sb.toString());
            return t;
        }
        if (i == 40051) {
            NativeUnifiedADData nativeUnifiedADData5 = this.f1868XO;
            int appScore = nativeUnifiedADData5 != null ? nativeUnifiedADData5.getAppScore() : 0;
            OxxIIOOXO.oIX0oI("getAppScore appScore = " + appScore);
            return (T) Integer.valueOf(appScore);
        }
        if (i == 40052) {
            NativeUnifiedADData nativeUnifiedADData6 = this.f1868XO;
            boolean isAppAd = nativeUnifiedADData6 != null ? nativeUnifiedADData6.isAppAd() : false;
            OxxIIOOXO.oIX0oI("isAppAd isAppAd = " + isAppAd);
            return (T) Boolean.valueOf(isAppAd);
        }
        if (i == 40003) {
            NativeUnifiedADData nativeUnifiedADData7 = this.f1868XO;
            int ecpm = nativeUnifiedADData7 != null ? nativeUnifiedADData7.getECPM() : -1;
            OxxIIOOXO.oIX0oI("getECPM ecpm = " + ecpm);
            return (T) Integer.valueOf(ecpm);
        }
        if (i == 40004) {
            NativeUnifiedADData nativeUnifiedADData8 = this.f1868XO;
            ?? r1312 = nativeUnifiedADData8 != null ? (T) nativeUnifiedADData8.getECPMLevel() : (T) "";
            OxxIIOOXO.oIX0oI("getECPMLevel level = " + ((String) r1312));
            return (T) r1312;
        }
        if (i == 40053) {
            NativeUnifiedADData nativeUnifiedADData9 = this.f1868XO;
            int appStatus = nativeUnifiedADData9 != null ? nativeUnifiedADData9.getAppStatus() : 1;
            OxxIIOOXO.oIX0oI("getAppStatus status = " + appStatus);
            return (T) Integer.valueOf(appStatus);
        }
        if (i == 40010) {
            NativeUnifiedADData nativeUnifiedADData10 = this.f1868XO;
            T t2 = (T) Boolean.valueOf(nativeUnifiedADData10 != null ? nativeUnifiedADData10.isValid() : false);
            OxxIIOOXO.oIX0oI("isValid  flag  = " + t2);
            return t2;
        }
        if (i == 40054) {
            T t3 = (T) Boolean.valueOf(((View) valueSet.objectValue(MsgField.MSG_MARKER_CREATE_SESSION_END, View.class)) instanceof NativeAdContainer);
            OxxIIOOXO.oIX0oI("isNativeAdContainer  flag  = " + t3);
            return t3;
        }
        if (i == 40055) {
            Context context = (Context) valueSet.objectValue(10000, Context.class);
            OxxIIOOXO.oIX0oI("createNativeContainer  context  = " + context);
            if (context != null) {
                return (T) new NativeAdContainer(context);
            }
            return null;
        }
        if (i == 40056) {
            Context context2 = (Context) valueSet.objectValue(10000, Context.class);
            ViewGroup viewGroup = (ViewGroup) valueSet.objectValue(MsgField.MSG_MARKER_CREATE_SESSION_END, ViewGroup.class);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) valueSet.objectValue(MsgField.MSG_MARKER_QUERY_FRAME_CODE, FrameLayout.LayoutParams.class);
            List<View> list = (List) valueSet.objectValue(MsgField.MSG_MARKER_ALGO_END, List.class);
            List<View> list2 = (List) valueSet.objectValue(MsgField.MSG_MARKER_QUERY_LOCATION_INFO, List.class);
            OxxIIOOXO.oIX0oI("bindToView context = " + context2 + " container = " + viewGroup + " logoParams = " + layoutParams + " clickViews = " + list + " createViews = " + list2);
            NativeUnifiedADData nativeUnifiedADData11 = this.f1868XO;
            if (nativeUnifiedADData11 == null || !(viewGroup instanceof NativeAdContainer)) {
                return null;
            }
            nativeUnifiedADData11.bindAdToView(context2, (NativeAdContainer) viewGroup, layoutParams, list, list2);
            return null;
        }
        if (i == 40057) {
            Context context3 = (Context) valueSet.objectValue(10000, Context.class);
            OxxIIOOXO.oIX0oI("getMediaView  context  = " + context3);
            if (context3 != null) {
                return (T) new MediaView(context3);
            }
            return null;
        }
        if (i == 40058) {
            ViewGroup viewGroup2 = (ViewGroup) valueSet.objectValue(MsgField.MSG_MARKER_CREATE_SESSION_END, ViewGroup.class);
            Object objectValue = valueSet.objectValue(MsgField.MSG_MARKER_LOCATION_COMMON, Object.class);
            OxxIIOOXO.oIX0oI("bindMediaView  mediaView  = " + viewGroup2 + " VideoOption = " + objectValue);
            VideoOption build = new VideoOption.Builder().build();
            if (objectValue instanceof VideoOption) {
                build = (VideoOption) objectValue;
            }
            if (!(viewGroup2 instanceof MediaView) || (nativeUnifiedADData = this.f1868XO) == null) {
                return null;
            }
            nativeUnifiedADData.bindMediaView((MediaView) viewGroup2, build, this.f1867Oxx0xo);
            return null;
        }
        if (i == 40059) {
            List<View> list3 = (List) valueSet.objectValue(50021, List.class);
            OxxIIOOXO.oIX0oI("bindCtaViews  ctaViews  = " + list3);
            NativeUnifiedADData nativeUnifiedADData12 = this.f1868XO;
            if (nativeUnifiedADData12 == null) {
                return null;
            }
            nativeUnifiedADData12.bindCTAViews(list3);
            return null;
        }
        if (i == 40060) {
            OxxIIOOXO.oIX0oI("setNativeAdEventListener");
            oO();
            return null;
        }
        if (i == 40009) {
            this.f1866Oo = (Bridge) valueSet.objectValue(MsgField.MSG_HIDE_UI_BTN, Bridge.class);
            return null;
        }
        if (i == 40021) {
            NativeUnifiedADData nativeUnifiedADData13 = this.f1868XO;
            int adPatternType = nativeUnifiedADData13 != null ? nativeUnifiedADData13.getAdPatternType() : 0;
            OxxIIOOXO.oIX0oI("getAdPatternType adPatternType = " + adPatternType);
            return (T) Integer.valueOf(adPatternType);
        }
        if (i == 40015) {
            T t4 = (T) OOXIXo();
            OxxIIOOXO.oIX0oI("getExtraInfo  map  = " + t4);
            return t4;
        }
        if (i == 40061) {
            OxxIIOOXO.oIX0oI("onResume");
            NativeUnifiedADData nativeUnifiedADData14 = this.f1868XO;
            if (nativeUnifiedADData14 == null) {
                return null;
            }
            nativeUnifiedADData14.resume();
            return null;
        }
        if (i == 40062) {
            OxxIIOOXO.oIX0oI("onPause");
            NativeUnifiedADData nativeUnifiedADData15 = this.f1868XO;
            if (nativeUnifiedADData15 == null) {
                return null;
            }
            nativeUnifiedADData15.pauseVideo();
            return null;
        }
        if (i == 40011) {
            OxxIIOOXO.oIX0oI("onDestroy");
            xoIox();
            return null;
        }
        if (i == 40012) {
            T t5 = (T) Boolean.valueOf(this.f1865IXxxXO);
            OxxIIOOXO.oIX0oI("hasDestroy  flag  = " + t5);
            return t5;
        }
        if (i == 40063) {
            OxxIIOOXO.oIX0oI("pauseAppDownload");
            NativeUnifiedADData nativeUnifiedADData16 = this.f1868XO;
            if (nativeUnifiedADData16 == null) {
                return null;
            }
            nativeUnifiedADData16.pauseAppDownload();
            return null;
        }
        if (i == 40064) {
            OxxIIOOXO.oIX0oI("resumeAppDownload");
            NativeUnifiedADData nativeUnifiedADData17 = this.f1868XO;
            if (nativeUnifiedADData17 == null) {
                return null;
            }
            nativeUnifiedADData17.resumeAppDownload();
            return null;
        }
        if (i == 40013) {
            int intValue = valueSet.intValue(40013);
            OxxIIOOXO.oIX0oI("sendWinNotification  ecpm  = " + intValue);
            II0xO0(intValue);
            return null;
        }
        if (i == 40014) {
            Map<String, Object> map = (Map) valueSet.objectValue(MsgField.MSG_SESSION_INVALID, Map.class);
            OxxIIOOXO.oIX0oI("sendLossNotification  map  = " + map);
            X0o0xo(map);
            return null;
        }
        if (i != 40065) {
            return null;
        }
        OxxIIOOXO.oIX0oI("negativeFeedback");
        NativeUnifiedADData nativeUnifiedADData18 = this.f1868XO;
        if (nativeUnifiedADData18 == null) {
            return null;
        }
        nativeUnifiedADData18.negativeFeedback();
        return null;
    }

    public void oIX0oI() {
        Bridge bridge = this.f1866Oo;
        if (bridge != null) {
            bridge.call(60009, null, Void.class);
        }
    }

    public void oxoX(AdError adError) {
        if (this.f1866Oo != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(50006, new II0XooXoX(adError));
            this.f1866Oo.call(60010, create.build(), Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    /* loaded from: classes6.dex */
    public class II0xO0 implements NativeADEventListener {
        public II0xO0() {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            OxxIIOOXO.oIX0oI("onADClicked");
            ooOOo0oXI.this.XO();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            OxxIIOOXO.oIX0oI("onADExposed");
            ooOOo0oXI.this.oIX0oI();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
        }
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements NativeADMediaListener {
        public oIX0oI() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoClicked() {
            OxxIIOOXO.oIX0oI("onVideoCompleted");
            ooOOo0oXI.this.XO();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoCompleted() {
            OxxIIOOXO.oIX0oI("onVideoCompleted");
            ooOOo0oXI.this.II0XooXoX();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoError(AdError adError) {
            OxxIIOOXO.oIX0oI("onVideoError adError = " + adError);
            ooOOo0oXI.this.oxoX(adError);
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoPause() {
            OxxIIOOXO.oIX0oI("onVideoPause");
            ooOOo0oXI.this.ooOOo0oXI();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoResume() {
            OxxIIOOXO.oIX0oI("onVideoResume");
            ooOOo0oXI.this.oOoXoXO();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStart() {
            OxxIIOOXO.oIX0oI("onVideoStart");
            ooOOo0oXI.this.x0XOIxOo();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i) {
        }
    }
}
