package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class BaiduDrawLoader extends BaiduBaseLoader {

    /* renamed from: Oo, reason: collision with root package name */
    public MediationAdSlotValueSet f10421Oo;

    /* renamed from: XO, reason: collision with root package name */
    public BaiduDrawExpressAd f10422XO;

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(final Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        this.f10421Oo = mediationAdSlotValueSet;
        if (context != null) {
            BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context.getApplicationContext(), mediationAdSlotValueSet.getADNId());
            RequestParameters requestParameters = BaiduAdapterUtil.getRequestParameters(mediationAdSlotValueSet);
            setBiddingResult(getAdnId(), isClientBidding(), requestParameters);
            baiduNativeManager.loadPortraitVideoAd(requestParameters, new BaiduNativeManager.PortraitVideoAdListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawLoader.1
                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener
                public void onAdClick() {
                    if (BaiduDrawLoader.this.f10422XO != null) {
                        BaiduDrawLoader.this.f10422XO.notifyOnClickAd();
                    }
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onLpClosed() {
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onNativeFail(int i, String str) {
                    BaiduDrawLoader.this.notifyAdFailed(i, str);
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onNativeLoad(List<NativeResponse> list) {
                    if (list == null || list.size() <= 0) {
                        BaiduDrawLoader.this.notifyAdFailed(80001, "加载成功无数据");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    Bridge gMBridge = BaiduDrawLoader.this.getGMBridge();
                    BaiduDrawLoader baiduDrawLoader = BaiduDrawLoader.this;
                    Context applicationContext = context.getApplicationContext();
                    XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) list.get(0);
                    BaiduDrawLoader baiduDrawLoader2 = BaiduDrawLoader.this;
                    baiduDrawLoader.f10422XO = new BaiduDrawExpressAd(applicationContext, xAdNativeResponse, baiduDrawLoader2, gMBridge, baiduDrawLoader2.f10421Oo);
                    arrayList.add(gMBridge);
                    BaiduDrawLoader.this.notifyAdSuccess(arrayList);
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onNoAd(int i, String str) {
                    BaiduDrawLoader.this.notifyAdFailed(i, str);
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onVideoDownloadFailed() {
                }

                @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
                public void onVideoDownloadSuccess() {
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
