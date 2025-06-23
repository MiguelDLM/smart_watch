package com.alimm.tanx.ui.image.glide;

interface BitmapOptions {
    GenericRequestBuilder<?, ?, ?, ?> centerCrop();

    GenericRequestBuilder<?, ?, ?, ?> fitCenter();
}
