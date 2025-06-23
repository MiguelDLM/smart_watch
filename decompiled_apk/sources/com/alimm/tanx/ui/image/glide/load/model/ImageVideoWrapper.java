package com.alimm.tanx.ui.image.glide.load.model;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ImageVideoWrapper {
    private final ParcelFileDescriptor fileDescriptor;
    private final InputStream streamData;

    public ImageVideoWrapper(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.streamData = inputStream;
        this.fileDescriptor = parcelFileDescriptor;
    }

    public ParcelFileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    public InputStream getStream() {
        return this.streamData;
    }
}
