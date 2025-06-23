package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class BaiduNativeLoader extends BaiduBaseLoader {

    /* renamed from: Oo, reason: collision with root package name */
    public Map<NativeResponse, BaiduNativeAd> f10446Oo = new HashMap();

    /* renamed from: XO, reason: collision with root package name */
    public BaiduNativeManager f10447XO;

    public final void I0Io(final Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (this.f10447XO == null) {
            this.f10447XO = new BaiduNativeManager(context, mediationAdSlotValueSet.getADNId());
        }
        this.f10447XO.setAppSid(mediationAdSlotValueSet.getBaiduAppSid());
        this.f10447XO.setCacheVideoOnlyWifi(mediationAdSlotValueSet.getBaiduCacheVideoOnlyWifi());
        BaiduNativeManager.FeedAdListener feedAdListener = new BaiduNativeManager.FeedAdListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeLoader.2
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            @JProtect
            public void onNativeFail(int i, String str) {
                BaiduNativeLoader.this.notifyAdFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            @JProtect
            public void onNativeLoad(List<NativeResponse> list) {
                if (list == null || list.size() <= 0) {
                    BaiduNativeLoader.this.notifyAdFailed(80001, "返回广告位列表空");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (NativeResponse nativeResponse : list) {
                    if (nativeResponse != null) {
                        Bridge gMBridge = BaiduNativeLoader.this.getGMBridge();
                        BaiduNativeLoader baiduNativeLoader = BaiduNativeLoader.this;
                        BaiduNativeLoader.this.f10446Oo.put(nativeResponse, new BaiduNativeAd(context, (XAdNativeResponse) nativeResponse, baiduNativeLoader, gMBridge, baiduNativeLoader.mSlotValueSet));
                        arrayList.add(gMBridge);
                    }
                }
                BaiduNativeLoader.this.notifyAdSuccess(arrayList);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            @JProtect
            public void onNoAd(int i, String str) {
                BaiduNativeLoader.this.notifyAdFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
            }
        };
        if (isServerBidding()) {
            this.f10447XO.loadBidAdForFeed(getAdm(), feedAdListener);
            return;
        }
        RequestParameters requestParameters = BaiduAdapterUtil.getRequestParameters(mediationAdSlotValueSet);
        setBiddingResult(getAdnId(), isClientBidding(), requestParameters);
        this.f10447XO.loadFeedAd(requestParameters, feedAdListener);
    }

    public final void II0xO0(final Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (this.f10447XO == null) {
            this.f10447XO = new BaiduNativeManager(context, mediationAdSlotValueSet.getADNId());
        }
        this.f10447XO.setAppSid(mediationAdSlotValueSet.getBaiduAppSid());
        this.f10447XO.setCacheVideoOnlyWifi(mediationAdSlotValueSet.getBaiduCacheVideoOnlyWifi());
        BaiduNativeManager.ExpressAdListener expressAdListener = new BaiduNativeManager.ExpressAdListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeLoader.1
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            @JProtect
            public void onNativeFail(int i, String str) {
                BaiduNativeLoader.this.notifyAdFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            @JProtect
            public void onNativeLoad(List<ExpressResponse> list) {
                if (list == null || list.size() <= 0) {
                    BaiduNativeLoader.this.notifyAdFailed(80001, "请求成功，但无广告可用");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (ExpressResponse expressResponse : list) {
                    if (expressResponse != null) {
                        Bridge gMBridge = BaiduNativeLoader.this.getGMBridge();
                        new BaiduNativeExpressAd(context, expressResponse, BaiduNativeLoader.this, gMBridge);
                        arrayList.add(gMBridge);
                    }
                }
                BaiduNativeLoader.this.notifyAdSuccess(arrayList);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            @JProtect
            public void onNoAd(int i, String str) {
                BaiduNativeLoader.this.notifyAdFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
            public void onVideoDownloadSuccess() {
            }
        };
        if (isServerBidding()) {
            this.f10447XO.loadBidAdForExpress(getAdm(), expressAdListener);
            return;
        }
        RequestParameters requestParameters = BaiduAdapterUtil.getRequestParameters(mediationAdSlotValueSet);
        setBiddingResult(getAdnId(), isClientBidding(), requestParameters);
        this.f10447XO.loadExpressAd(requestParameters, expressAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public <T> T callFunction(int i, ValueSet valueSet, Class<T> cls) {
        return i == 8139 ? (T) String.valueOf(getBiddingToken((Context) valueSet.objectValue(8009, Context.class), valueSet.stringValue(8007), valueSet.objectValue(8044, Object.class))) : (T) MediationValueUtil.checkClassType(cls);
    }

    public String getBiddingToken(Context context, String str, Object obj) {
        if (this.f10447XO == null) {
            this.f10447XO = new BaiduNativeManager(context, str);
        }
        if (obj instanceof RequestParameters) {
            return this.f10447XO.getFeedBiddingToken((RequestParameters) obj);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            if (mediationAdSlotValueSet.getOriginType() == 1 || mediationAdSlotValueSet.getOriginType() == 2) {
                I0Io(context.getApplicationContext(), mediationAdSlotValueSet);
            } else if (mediationAdSlotValueSet.getOriginType() == 3) {
                II0xO0(context.getApplicationContext(), mediationAdSlotValueSet);
            } else {
                notifyAdFailed(80001, "originType 类型不正确");
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
