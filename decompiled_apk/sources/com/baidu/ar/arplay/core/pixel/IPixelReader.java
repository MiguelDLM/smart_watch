package com.baidu.ar.arplay.core.pixel;

/* loaded from: classes7.dex */
public interface IPixelReader {
    void createPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener);

    void destroyPixelReader(PixelReadParams pixelReadParams, PixelReadListener pixelReadListener);

    void updatePixelReader(PixelReadParams pixelReadParams, PixelRotation pixelRotation);
}
