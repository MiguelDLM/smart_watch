package com.alimm.tanx.core.image;

import com.alimm.tanx.core.image.util.GifConfig;
import com.alimm.tanx.core.image.util.ImageConfig;

public interface ILoader {
    void load(ImageConfig imageConfig, ImageConfig.ImageBitmapCallback imageBitmapCallback);

    void loadGif(GifConfig gifConfig, ImageConfig.GifCallback gifCallback);
}
