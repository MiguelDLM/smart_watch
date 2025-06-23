package com.bytedance.sdk.openadsdk.api.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import o0.XxX0x0xxx;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class e extends com.bytedance.sdk.openadsdk.api.b implements DownloadStatusChangeListener {
    public e(EventListener eventListener) {
        this.f10688a = eventListener;
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i) {
        Result XO2;
        if (a()) {
            XO2 = null;
        } else {
            XO2 = XxX0x0xxx.oIX0oI().I0Io(xXxxox0I.oIX0oI().Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).X0o0xo(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, i).OOXIXo()).XO();
        }
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE, XO2);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
        Result XO2;
        if (a()) {
            XO2 = null;
        } else {
            XO2 = XxX0x0xxx.oIX0oI().I0Io(xXxxox0I.oIX0oI().Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).OOXIXo()).XO();
        }
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_FAILED, XO2);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
        Result XO2;
        if (a()) {
            XO2 = null;
        } else {
            XO2 = XxX0x0xxx.oIX0oI().I0Io(xXxxox0I.oIX0oI().Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).OOXIXo()).XO();
        }
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_FINISHED, XO2);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i) {
        Result XO2;
        if (a()) {
            XO2 = null;
        } else {
            XO2 = XxX0x0xxx.oIX0oI().I0Io(xXxxox0I.oIX0oI().Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).X0o0xo(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, i).OOXIXo()).XO();
        }
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_PAUSED, XO2);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadStart(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController) {
        Result XO2;
        if (a()) {
            XO2 = null;
        } else {
            XO2 = XxX0x0xxx.oIX0oI().I0Io(xXxxox0I.oIX0oI().Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_MODEL, new c(downloadModel)).Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, new a(downloadController)).OOXIXo()).XO();
        }
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_START, XO2);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onIdle() {
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_IDLE);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
        Result XO2;
        if (a()) {
            XO2 = null;
        } else {
            XO2 = XxX0x0xxx.oIX0oI().I0Io(xXxxox0I.oIX0oI().Oxx0IOOO(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).OOXIXo()).XO();
        }
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_INSTALLED, XO2);
    }
}
