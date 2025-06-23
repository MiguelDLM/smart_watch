package com.jd.ad.sdk.mdt.service;

import androidx.annotation.NonNull;

/* loaded from: classes10.dex */
public interface JADEventService {
    void reportClickEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    void reportCloseEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10);

    void reportExceptionEvent(@NonNull String str, int i, @NonNull String str2);

    void reportExposureEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, int i6, int i7, int i8, int i9, String str3, int i10, int i11);

    void reportPreloadClickEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10, int i11, int i12);

    void reportPreloadCloseEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, long j3, int i6, int i7, int i8, int i9, int i10);

    void reportPreloadExposureEvent(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, long j2, int i6, int i7, int i8, int i9, String str3, int i10, int i11);

    void reportPreloadRenderSuccessEvent(@NonNull String str, @NonNull String str2, int i, int i2, int i3, int i4, long j, long j2, int i5, int i6, int i7, int i8, int i9);

    void reportPreloadResponseEvent(@NonNull String str, @NonNull String str2, int i, int i2, int i3, int i4, long j, int i5, int i6, int i7, int i8, int i9);

    void reportRenderFailedEvent(@NonNull String str, int i, @NonNull String str2, int i2);

    void reportRenderSuccessEvent(@NonNull String str, @NonNull String str2, int i, int i2, int i3, int i4, long j, long j2, int i5, int i6, int i7, int i8, int i9);

    void reportRequestErrorEvent(@NonNull String str, int i, @NonNull String str2);

    void reportResponseEvent(@NonNull String str, @NonNull String str2, int i, int i2, int i3, int i4, long j, int i5, int i6, int i7, int i8, int i9);

    void reportVideoEvent(String str, String str2, int i, int i2, int i3, int i4, long j, long j2, long j3, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f);

    void reportVideoExceptionEvent(@NonNull String str, int i, @NonNull String str2);
}
