package com.google.android.cameraview;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.params.StreamConfigurationMap;
import com.google.android.cameraview.CameraViewImpl;

@TargetApi(23)
/* loaded from: classes9.dex */
class Camera2Api23 extends Camera2 {
    public Camera2Api23(CameraViewImpl.Callback callback, PreviewImpl previewImpl, Context context) {
        super(callback, previewImpl, context);
    }

    @Override // com.google.android.cameraview.Camera2
    public void collectPictureSizes(SizeMap sizeMap, StreamConfigurationMap streamConfigurationMap) {
        android.util.Size[] highResolutionOutputSizes;
        android.util.Size[] highResolutionOutputSizes2;
        highResolutionOutputSizes = streamConfigurationMap.getHighResolutionOutputSizes(256);
        if (highResolutionOutputSizes != null) {
            highResolutionOutputSizes2 = streamConfigurationMap.getHighResolutionOutputSizes(256);
            for (android.util.Size size : highResolutionOutputSizes2) {
                sizeMap.add(new Size(size.getWidth(), size.getHeight()));
            }
        }
        if (sizeMap.isEmpty()) {
            super.collectPictureSizes(sizeMap, streamConfigurationMap);
        }
    }
}
