package com.alimm.tanx.ui.image.glide;

import android.view.animation.Animation;

interface DrawableOptions {
    GenericRequestBuilder<?, ?, ?, ?> crossFade();

    GenericRequestBuilder<?, ?, ?, ?> crossFade(int i);

    GenericRequestBuilder<?, ?, ?, ?> crossFade(int i, int i2);

    @Deprecated
    GenericRequestBuilder<?, ?, ?, ?> crossFade(Animation animation, int i);
}
