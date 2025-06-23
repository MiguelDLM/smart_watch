package com.bytedance.sdk.openadsdk.c.a.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class e implements DownloadStatusController {

    /* renamed from: a, reason: collision with root package name */
    private final Bridge f10718a;

    public e(Bridge bridge) {
        this.f10718a = bridge == null ? xXxxox0I.f31021oxoX : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        this.f10718a.call(222102, xXxxox0I.II0xO0(0).OOXIXo(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        this.f10718a.call(222101, xXxxox0I.II0xO0(0).OOXIXo(), Void.class);
    }
}
