package com.alimm.tanx.ui.image.glide.request.target;

import com.alimm.tanx.ui.image.glide.util.Util;
import oOxxXI.oIX0oI;

/* loaded from: classes.dex */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int height;
    private final int width;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public final void getSize(SizeReadyCallback sizeReadyCallback) {
        if (Util.isValidDimensions(this.width, this.height)) {
            sizeReadyCallback.onSizeReady(this.width, this.height);
            return;
        }
        StringBuilder oIX0oI2 = oIX0oI.oIX0oI("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        oIX0oI2.append(this.width);
        oIX0oI2.append(" and height: ");
        oIX0oI2.append(this.height);
        oIX0oI2.append(", either provide dimensions in the constructor");
        oIX0oI2.append(" or call override()");
        throw new IllegalArgumentException(oIX0oI2.toString());
    }

    public SimpleTarget(int i, int i2) {
        this.width = i;
        this.height = i2;
    }
}
