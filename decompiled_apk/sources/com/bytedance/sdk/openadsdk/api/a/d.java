package com.bytedance.sdk.openadsdk.api.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.model.DownloadShortInfo;
import o0.xXxxox0I;

/* loaded from: classes8.dex */
public class d implements Bridge {

    /* renamed from: a, reason: collision with root package name */
    private DownloadShortInfo f10675a;

    public d(DownloadShortInfo downloadShortInfo) {
        this.f10675a = downloadShortInfo;
    }

    public long a() {
        DownloadShortInfo downloadShortInfo = this.f10675a;
        if (downloadShortInfo != null) {
            return downloadShortInfo.id;
        }
        return -1L;
    }

    public int b() {
        DownloadShortInfo downloadShortInfo = this.f10675a;
        if (downloadShortInfo != null) {
            return downloadShortInfo.status;
        }
        return -1;
    }

    public long c() {
        DownloadShortInfo downloadShortInfo = this.f10675a;
        if (downloadShortInfo != null) {
            return downloadShortInfo.totalBytes;
        }
        return -1L;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS /* 223700 */:
                return (T) Boolean.valueOf(equals(valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS_PARAMETER, Object.class)));
            case ValueSetConstants.VALUE_DOWNLOAD_SHORT_HASH_CODE /* 223701 */:
                hashCode();
                return null;
            default:
                return null;
        }
    }

    public long d() {
        DownloadShortInfo downloadShortInfo = this.f10675a;
        if (downloadShortInfo != null) {
            return downloadShortInfo.currentBytes;
        }
        return -1L;
    }

    public String e() {
        DownloadShortInfo downloadShortInfo = this.f10675a;
        if (downloadShortInfo != null) {
            return downloadShortInfo.fileName;
        }
        return "";
    }

    public boolean equals(Object obj) {
        DownloadShortInfo downloadShortInfo = this.f10675a;
        if (downloadShortInfo != null) {
            return downloadShortInfo.equals(obj);
        }
        return false;
    }

    public int f() {
        DownloadShortInfo downloadShortInfo = this.f10675a;
        if (downloadShortInfo != null) {
            return downloadShortInfo.failStatus;
        }
        return 0;
    }

    public boolean g() {
        DownloadShortInfo downloadShortInfo = this.f10675a;
        if (downloadShortInfo != null) {
            return downloadShortInfo.onlyWifi;
        }
        return false;
    }

    public int hashCode() {
        DownloadShortInfo downloadShortInfo = this.f10675a;
        if (downloadShortInfo != null) {
            return downloadShortInfo.hashCode();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return xXxxox0I.oIX0oI().XO(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_ID, a()).X0o0xo(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_STATUS, b()).XO(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES, c()).XO(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES, d()).II0XooXoX(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME, e()).X0o0xo(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FAIL_STATUS, f()).xxIXOIIO(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_ONLY_WIFI, g()).OOXIXo();
    }
}
