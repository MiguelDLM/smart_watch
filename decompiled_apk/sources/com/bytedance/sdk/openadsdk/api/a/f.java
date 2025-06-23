package com.bytedance.sdk.openadsdk.api.a;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import o0.XxX0x0xxx;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class f extends com.bytedance.sdk.openadsdk.api.b implements IDownloadButtonClickListener {
    public f(EventListener eventListener) {
        this.f10688a = eventListener;
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleComplianceDialog(boolean z) {
        Result XO2;
        if (a()) {
            XO2 = null;
        } else {
            XO2 = XxX0x0xxx.oIX0oI().I0Io(xXxxox0I.oIX0oI().xxIXOIIO(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG_SHOULD_SHOW, z).OOXIXo()).XO();
        }
        a(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG, XO2);
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleMarketFailedComplianceDialog() {
        a(ValueSetConstants.VALUE_HANDLE_MARKET_FAILED_COMPLIANCE_DIALOG);
    }
}
