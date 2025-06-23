package com.kwad.components.ad.widget.tailframe.appbar;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* loaded from: classes11.dex */
public class TailFrameBarAppLandscape extends a {
    public TailFrameBarAppLandscape(Context context) {
        this(context, null);
    }

    @Override // com.kwad.components.ad.widget.tailframe.appbar.a
    public int getLayoutId() {
        return R.layout.ksad_video_tf_bar_app_landscape;
    }

    public TailFrameBarAppLandscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
