package com.bytedance.sdk.openadsdk.c.a;

import android.util.Pair;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.g.a.a.a.f;
import com.bytedance.sdk.openadsdk.mediation.a.a.c;
import com.bytedance.sdk.openadsdk.mediation.a.a.d;
import com.bytedance.sdk.openadsdk.mediation.a.a.e;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: com.bytedance.sdk.openadsdk.c.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0568a implements TTAdNative {

        /* renamed from: a, reason: collision with root package name */
        private final a f10713a;

        public C0568a(a aVar) {
            this.f10713a = aVar;
        }

        private ValueSet a(AdSlot adSlot) {
            xXxxox0I xoIox2 = xXxxox0I.xoIox(com.bytedance.sdk.openadsdk.c.a.c.b.b(adSlot));
            xoIox2.Oxx0IOOO(8302, MediationAdClassLoader.getInstance());
            if (adSlot.getMediationAdSlot() != null) {
                xoIox2.Oxx0IOOO(8260028, new e(adSlot.getMediationAdSlot()));
                xoIox2.Oxx0IOOO(260027, adSlot.getMediationAdSlot());
            }
            return xoIox2.OOXIXo();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f10713a.i(a(adSlot), new com.bytedance.sdk.openadsdk.g.a.a.a.e(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> a2 = this.f10713a.a(e);
                    nativeExpressAdListener.onError(((Integer) a2.first).intValue(), (String) a2.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.f10713a.c(a(adSlot), new com.bytedance.sdk.openadsdk.mediation.a.a.b(drawFeedAdListener));
            } catch (Exception e) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> a2 = this.f10713a.a(e);
                    drawFeedAdListener.onError(((Integer) a2.first).intValue(), (String) a2.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f10713a.h(a(adSlot), new com.bytedance.sdk.openadsdk.g.a.a.a.e(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> a2 = this.f10713a.a(e);
                    nativeExpressAdListener.onError(((Integer) a2.first).intValue(), (String) a2.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f10713a.a(a(adSlot), new c(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> a2 = this.f10713a.a(e);
                    feedAdListener.onError(((Integer) a2.first).intValue(), (String) a2.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.f10713a.f(a(adSlot), new d(fullScreenVideoAdListener));
            } catch (Exception e) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> a2 = this.f10713a.a(e);
                    fullScreenVideoAdListener.onError(((Integer) a2.first).intValue(), (String) a2.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadInteractionExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.f10713a.d(a(adSlot), new com.bytedance.sdk.openadsdk.g.a.a.a.d(nativeAdListener));
            } catch (Exception e) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> a2 = this.f10713a.a(e);
                    nativeAdListener.onError(((Integer) a2.first).intValue(), (String) a2.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.f10713a.g(a(adSlot), new com.bytedance.sdk.openadsdk.g.a.a.a.e(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> a2 = this.f10713a.a(e);
                    nativeExpressAdListener.onError(((Integer) a2.first).intValue(), (String) a2.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.f10713a.e(a(adSlot), new f(rewardVideoAdListener));
            } catch (Exception e) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> a2 = this.f10713a.a(e);
                    rewardVideoAdListener.onError(((Integer) a2.first).intValue(), (String) a2.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i) {
            try {
                this.f10713a.a(a(adSlot), new b(cSJSplashAdListener), i);
            } catch (Exception e) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> a2 = this.f10713a.a(e);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.bytedance.sdk.openadsdk.c.a.a.a.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) a2.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) a2.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.f10713a.b(a(adSlot), new c(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> a2 = this.f10713a.a(e);
                    feedAdListener.onError(((Integer) a2.first).intValue(), (String) a2.second);
                }
            }
        }
    }

    public abstract Pair<Integer, String> a(Exception exc);

    public TTAdNative a() {
        return new C0568a(this);
    }

    public abstract void a(ValueSet valueSet, Bridge bridge);

    public abstract void a(ValueSet valueSet, Bridge bridge, int i);

    public abstract void b(ValueSet valueSet, Bridge bridge);

    public abstract void c(ValueSet valueSet, Bridge bridge);

    public abstract void d(ValueSet valueSet, Bridge bridge);

    public abstract void e(ValueSet valueSet, Bridge bridge);

    public abstract void f(ValueSet valueSet, Bridge bridge);

    public abstract void g(ValueSet valueSet, Bridge bridge);

    public abstract void h(ValueSet valueSet, Bridge bridge);

    public abstract void i(ValueSet valueSet, Bridge bridge);
}
