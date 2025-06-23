package com.bytedance.sdk.openadsdk.mediation.bridge.native_ad;

import XIXIX.OOXIXo;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.mapapi.UIMsg;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import java.util.Map;

/* loaded from: classes8.dex */
public class MediationNativeAd implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private MediationAdLoaderImpl f10863a;
    public Bridge mGMAd;

    public MediationNativeAd(MediationAdLoaderImpl mediationAdLoaderImpl, Bridge bridge) {
        this.f10863a = mediationAdLoaderImpl;
        this.mGMAd = bridge;
        a();
    }

    private void a() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8035, this);
        this.mGMAd.call(8128, create.build(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public String getAdm() {
        MediationAdLoaderImpl mediationAdLoaderImpl = this.f10863a;
        if (mediationAdLoaderImpl != null) {
            return mediationAdLoaderImpl.getAdm();
        }
        return "";
    }

    public double getCpm() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            return ((Double) bridge.call(8143, null, Double.class)).doubleValue();
        }
        return OOXIXo.f3760XO;
    }

    public int getImageMode() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            return ((Integer) bridge.call(6069, null, Integer.class)).intValue();
        }
        return 0;
    }

    public boolean isClientBidding() {
        return this.f10863a.isClientBidding();
    }

    public boolean isExpress() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            return ((Boolean) bridge.call(8196, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public boolean isMultiBidding() {
        return this.f10863a.isMultiBidding();
    }

    public boolean isServerBidding() {
        return this.f10863a.isServerBidding();
    }

    public boolean isUseCustomVideo() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            return ((Boolean) bridge.call(8160, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    public void notifyDislikeClick(String str, Map map) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8036, str);
            create.add(8037, map);
            this.mGMAd.call(8131, create.build(), Void.class);
        }
    }

    public void notifyDislikeOnCancel() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8184, null, Void.class);
        }
    }

    public void notifyDislikeOnShow() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8185, null, Void.class);
        }
    }

    public void notifyDislikeSelect(int i, String str) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8038, i);
            create.add(8039, str);
            this.mGMAd.call(8132, create.build(), Void.class);
        }
    }

    public void notifyNativeValue(ValueSet valueSet) {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8140, valueSet, Void.class);
        }
    }

    public void notifyOnClickAd() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8130, null, Void.class);
        }
    }

    public void notifyOnDownloadFailed(long j, long j2, String str, String str2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j);
            create.add(8063, j2);
            create.add(8066, str);
            create.add(8056, str2);
            this.mGMAd.call(8157, create.build(), Void.class);
        }
    }

    public void notifyOnDownloadFinished(long j, String str, String str2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j);
            create.add(8066, str);
            create.add(8056, str2);
            this.mGMAd.call(8155, create.build(), Void.class);
        }
    }

    public void notifyOnDownloadPause(long j, long j2, String str, String str2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j);
            create.add(8063, j2);
            create.add(8066, str);
            create.add(8056, str2);
            this.mGMAd.call(8158, create.build(), Void.class);
        }
    }

    public void notifyOnDownloadStarted() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8153, null, Void.class);
        }
    }

    public void notifyOnIdel() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8152, null, Void.class);
        }
    }

    public void notifyOnInstalled(String str, String str2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8066, str);
            create.add(8056, str2);
            this.mGMAd.call(8156, create.build(), Void.class);
        }
    }

    public void notifyOnProgressUpdate(long j, long j2, int i, int i2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j);
            create.add(8063, j2);
            create.add(8064, i);
            create.add(8065, i2);
            this.mGMAd.call(8187, create.build(), Void.class);
        }
    }

    public void notifyOnShowAd() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8113, null, Void.class);
        }
    }

    public void notifyOnVideoComplete() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8118, null, Void.class);
        }
    }

    public void notifyOnVideoError(int i, String str) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYS, i);
            create.add(8015, str);
            this.mGMAd.call(8117, create.build(), Void.class);
        }
    }

    public void notifyOnVideoPause() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8146, null, Void.class);
        }
    }

    public void notifyOnVideoResume() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8150, null, Void.class);
        }
    }

    public void notifyOnVideoStart() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(8145, null, Void.class);
        }
    }

    public void notifyRenderFail(View view, int i, String str) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8042, view);
            create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYS, i);
            create.add(8015, str);
            this.mGMAd.call(8134, create.build(), Void.class);
        }
    }

    public void notifyRenderSuccess(float f, float f2) {
        if (this.mGMAd != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8040, f);
            create.add(8041, f2);
            this.mGMAd.call(8133, create.build(), Void.class);
        }
    }

    public void removeSelfFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(view);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void shakeViewDismissed() {
        Bridge bridge = this.mGMAd;
        if (bridge != null) {
            bridge.call(FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE, null, Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
