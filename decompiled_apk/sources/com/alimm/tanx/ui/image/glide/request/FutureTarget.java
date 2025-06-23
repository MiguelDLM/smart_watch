package com.alimm.tanx.ui.image.glide.request;

import com.alimm.tanx.ui.image.glide.request.target.Target;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public interface FutureTarget<R> extends Future<R>, Target<R> {
    void clear();
}
