package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.y;

/* loaded from: classes11.dex */
public class ImageLoaderPerfUtil {
    private static final String TAG = "ImageLoaderPerfUtil";

    public static ImageLoaderInfo getInfo() {
        ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
        imageLoaderInfo.totalCount = y.MA();
        imageLoaderInfo.successCount = y.MB();
        imageLoaderInfo.failedCount = y.MC();
        imageLoaderInfo.duration = y.Mz();
        return imageLoaderInfo;
    }

    public static void report() {
        g.execute(new az() { // from class: com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil.1
            @Override // com.kwad.sdk.utils.az
            public void doTask() {
                ImageLoaderInfo info = ImageLoaderPerfUtil.getInfo();
                if (info.totalCount != 0) {
                    c.d(ImageLoaderPerfUtil.TAG, "ImageLoaderInfo:" + info.toJson().toString());
                    b.p(info);
                    return;
                }
                c.w(ImageLoaderPerfUtil.TAG, "info.totalCount == 0");
            }
        });
    }
}
