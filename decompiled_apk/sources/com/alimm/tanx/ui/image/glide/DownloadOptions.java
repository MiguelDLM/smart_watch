package com.alimm.tanx.ui.image.glide;

import com.alimm.tanx.ui.image.glide.request.FutureTarget;
import com.alimm.tanx.ui.image.glide.request.target.Target;
import java.io.File;

/* loaded from: classes.dex */
interface DownloadOptions {
    FutureTarget<File> downloadOnly(int i, int i2);

    <Y extends Target<File>> Y downloadOnly(Y y);
}
