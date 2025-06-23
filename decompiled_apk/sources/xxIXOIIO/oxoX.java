package xxIXOIIO;

import android.os.Handler;
import android.os.Looper;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.GdtNativeLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class oxoX extends MediationNativeAd {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public xxIXOIIO f35483IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public volatile boolean f35484Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f35485Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public NativeExpressADView f35486XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public NativeExpressMediaListener f35487oI0IIXIo;

    /* loaded from: classes.dex */
    public class I0Io implements Runnable {
        public I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (oxoX.this.f35486XO != null) {
                oxoX.this.f35486XO.render();
            }
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements Callable<String> {
        public II0xO0() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String call() {
            return oxoX.this.XO();
        }
    }

    /* loaded from: classes.dex */
    public class X0o0xo implements Runnable {
        public X0o0xo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            oxoX.this.f35486XO.sendWinNotification((int) oxoX.this.getCpm());
        }
    }

    /* loaded from: classes.dex */
    public class XO implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f35492XO;

        public XO(int i) {
            this.f35492XO = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            oxoX.this.f35486XO.sendLossNotification(0, this.f35492XO, null);
        }
    }

    /* renamed from: xxIXOIIO.oxoX$oxoX, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC1188oxoX implements Runnable {
        public RunnableC1188oxoX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (oxoX.this.f35486XO != null) {
                oxoX.this.f35486XO.destroy();
            }
        }
    }

    public oxoX(xxIXOIIO xxixoiio, GdtNativeLoader gdtNativeLoader, Bridge bridge, NativeExpressADView nativeExpressADView, boolean z) {
        super(gdtNativeLoader, bridge);
        this.f35484Oo = false;
        this.f35487oI0IIXIo = new oIX0oI();
        this.f35486XO = nativeExpressADView;
        this.f35483IXxxXO = xxixoiio;
        this.f35485Oxx0xo = z;
        I0Io();
    }

    private void I0Io() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        AdData boundData = this.f35486XO.getBoundData();
        if (boundData.getAdPatternType() == 2) {
            this.f35486XO.setMediaListener(this.f35487oI0IIXIo);
            create.add(8060, 5);
        } else if (boundData.getAdPatternType() != 4 && boundData.getAdPatternType() != 1 && boundData.getAdPatternType() == 3) {
            create.add(8060, 4);
        } else {
            create.add(8060, 3);
        }
        create.add(8033, true);
        create.add(8045, boundData.getTitle());
        create.add(8046, boundData.getDesc());
        create.add(8059, 3);
        if (isClientBidding()) {
            create.add(8016, Math.max(boundData.getECPM(), XIXIX.OOXIXo.f3760XO));
        } else if (isMultiBidding()) {
            create.add(8058, boundData.getECPMLevel());
        }
        create.add(8033, true);
        notifyNativeValue(create.build());
    }

    private String X0o0xo() {
        try {
            return (String) oOoXoXO.oIX0oI(new II0xO0()).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String XO() {
        Object obj;
        try {
            NativeExpressADView nativeExpressADView = this.f35486XO;
            if (nativeExpressADView != null && (obj = nativeExpressADView.getExtraInfo().get("request_id")) != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String oxoX() {
        if (this.f35485Oxx0xo) {
            return X0o0xo();
        }
        return XO();
    }

    public void a() {
        notifyDislikeClick("gdt信息流模板dislike接口无关闭原因", new HashMap());
        notifyDislikeSelect(-1, "gdt信息流模板dislike接口无关闭原因");
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 6083) {
            if (this.f35485Oxx0xo) {
                oOoXoXO.X0o0xo(new I0Io());
            } else {
                NativeExpressADView nativeExpressADView = this.f35486XO;
                if (nativeExpressADView != null) {
                    nativeExpressADView.render();
                }
            }
        } else {
            if (i == 6081) {
                if (isServerBidding()) {
                    NativeExpressADView nativeExpressADView2 = this.f35486XO;
                    nativeExpressADView2.setBidECPM(nativeExpressADView2.getECPM());
                }
                return (T) this.f35486XO;
            }
            if (i == 8135) {
                return (T) Boolean.TRUE;
            }
            if (i == 8109) {
                this.f35484Oo = true;
                if (this.f35483IXxxXO.I0Io() != null) {
                    this.f35483IXxxXO.I0Io().remove(this.f35486XO);
                }
                new Handler(Looper.getMainLooper()).post(new RunnableC1188oxoX());
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(this.f35484Oo);
                }
                try {
                    if (i == 8142) {
                        NativeExpressADView nativeExpressADView3 = this.f35486XO;
                        if (nativeExpressADView3 != null) {
                            if (this.f35485Oxx0xo) {
                                oOoXoXO.I0Io(new X0o0xo());
                            } else {
                                nativeExpressADView3.sendWinNotification((int) getCpm());
                            }
                        }
                    } else if (i == 8144) {
                        Map map = (Map) valueSet.objectValue(8006, Map.class);
                        if (map != null && this.f35486XO != null) {
                            Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
                            if (obj instanceof MediationConstant.BiddingLossReason) {
                                int oIX0oI2 = xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj);
                                if (this.f35485Oxx0xo) {
                                    oOoXoXO.I0Io(new XO(oIX0oI2));
                                } else {
                                    this.f35486XO.sendLossNotification(0, oIX0oI2, null);
                                }
                            }
                        }
                    } else if (i == 8147) {
                        return (T) oxoX();
                    }
                } catch (Exception unused) {
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements NativeExpressMediaListener {
        public oIX0oI() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoComplete(NativeExpressADView nativeExpressADView) {
            oxoX.this.notifyOnVideoComplete();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
            oxoX oxox = oxoX.this;
            if (adError != null) {
                oxox.notifyOnVideoError(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                oxox.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "aderror is null");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoPause(NativeExpressADView nativeExpressADView) {
            oxoX.this.notifyOnVideoPause();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoStart(NativeExpressADView nativeExpressADView) {
            oxoX.this.notifyOnVideoStart();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoCached(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoInit(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoLoading(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
        public void onVideoReady(NativeExpressADView nativeExpressADView, long j) {
        }
    }
}
