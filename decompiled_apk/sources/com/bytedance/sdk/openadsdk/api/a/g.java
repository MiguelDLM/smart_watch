package com.bytedance.sdk.openadsdk.api.a;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import o0.XxX0x0xxx;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class g extends com.bytedance.sdk.openadsdk.api.b implements OnItemClickListener {
    public g(EventListener eventListener) {
        this.f10688a = eventListener;
    }

    @Override // com.ss.android.download.api.config.OnItemClickListener
    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        Result XO2;
        if (a()) {
            XO2 = null;
        } else {
            XO2 = XxX0x0xxx.oIX0oI().I0Io(xXxxox0I.oIX0oI().Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_MODEL, new c(downloadModel)).Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG, new b(downloadEventConfig)).Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, new a(downloadController)).OOXIXo()).XO();
        }
        a(ValueSetConstants.VALUE_ON_ITEM_CLICK, XO2);
    }
}
