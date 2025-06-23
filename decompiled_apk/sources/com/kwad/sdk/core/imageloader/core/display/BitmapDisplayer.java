package com.kwad.sdk.core.imageloader.core.display;

import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;

/* loaded from: classes11.dex */
public interface BitmapDisplayer {
    void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom);
}
